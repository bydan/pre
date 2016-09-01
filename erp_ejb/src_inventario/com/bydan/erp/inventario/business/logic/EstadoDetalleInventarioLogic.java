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
import com.bydan.erp.inventario.util.EstadoDetalleInventarioConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoDetalleInventarioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoDetalleInventarioParameterGeneral;
import com.bydan.erp.inventario.business.entity.EstadoDetalleInventario;
import com.bydan.erp.inventario.business.logic.EstadoDetalleInventarioLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class EstadoDetalleInventarioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoDetalleInventarioLogic.class);
	
	protected EstadoDetalleInventarioDataAccess estadodetalleinventarioDataAccess; 	
	protected EstadoDetalleInventario estadodetalleinventario;
	protected List<EstadoDetalleInventario> estadodetalleinventarios;
	protected Object estadodetalleinventarioObject;	
	protected List<Object> estadodetalleinventariosObject;
	
	public static ClassValidator<EstadoDetalleInventario> estadodetalleinventarioValidator = new ClassValidator<EstadoDetalleInventario>(EstadoDetalleInventario.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoDetalleInventarioLogicAdditional estadodetalleinventarioLogicAdditional=null;
	
	public EstadoDetalleInventarioLogicAdditional getEstadoDetalleInventarioLogicAdditional() {
		return this.estadodetalleinventarioLogicAdditional;
	}
	
	public void setEstadoDetalleInventarioLogicAdditional(EstadoDetalleInventarioLogicAdditional estadodetalleinventarioLogicAdditional) {
		try {
			this.estadodetalleinventarioLogicAdditional=estadodetalleinventarioLogicAdditional;
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
	
	
	
	
	public  EstadoDetalleInventarioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadodetalleinventarioDataAccess = new EstadoDetalleInventarioDataAccess();
			
			this.estadodetalleinventarios= new ArrayList<EstadoDetalleInventario>();
			this.estadodetalleinventario= new EstadoDetalleInventario();
			
			this.estadodetalleinventarioObject=new Object();
			this.estadodetalleinventariosObject=new ArrayList<Object>();
				
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
			
			this.estadodetalleinventarioDataAccess.setConnexionType(this.connexionType);
			this.estadodetalleinventarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoDetalleInventarioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadodetalleinventarioDataAccess = new EstadoDetalleInventarioDataAccess();
			this.estadodetalleinventarios= new ArrayList<EstadoDetalleInventario>();
			this.estadodetalleinventario= new EstadoDetalleInventario();
			this.estadodetalleinventarioObject=new Object();
			this.estadodetalleinventariosObject=new ArrayList<Object>();
			
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
			
			this.estadodetalleinventarioDataAccess.setConnexionType(this.connexionType);
			this.estadodetalleinventarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoDetalleInventario getEstadoDetalleInventario() throws Exception {	
		EstadoDetalleInventarioLogicAdditional.checkEstadoDetalleInventarioToGet(estadodetalleinventario,this.datosCliente,this.arrDatoGeneral);
		EstadoDetalleInventarioLogicAdditional.updateEstadoDetalleInventarioToGet(estadodetalleinventario,this.arrDatoGeneral);
		
		return estadodetalleinventario;
	}
		
	public void setEstadoDetalleInventario(EstadoDetalleInventario newEstadoDetalleInventario) {
		this.estadodetalleinventario = newEstadoDetalleInventario;
	}
	
	public EstadoDetalleInventarioDataAccess getEstadoDetalleInventarioDataAccess() {
		return estadodetalleinventarioDataAccess;
	}
	
	public void setEstadoDetalleInventarioDataAccess(EstadoDetalleInventarioDataAccess newestadodetalleinventarioDataAccess) {
		this.estadodetalleinventarioDataAccess = newestadodetalleinventarioDataAccess;
	}
	
	public List<EstadoDetalleInventario> getEstadoDetalleInventarios() throws Exception {		
		this.quitarEstadoDetalleInventariosNulos();
		
		EstadoDetalleInventarioLogicAdditional.checkEstadoDetalleInventarioToGets(estadodetalleinventarios,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoDetalleInventario estadodetalleinventarioLocal: estadodetalleinventarios ) {
			EstadoDetalleInventarioLogicAdditional.updateEstadoDetalleInventarioToGet(estadodetalleinventarioLocal,this.arrDatoGeneral);
		}
		
		return estadodetalleinventarios;
	}
	
	public void setEstadoDetalleInventarios(List<EstadoDetalleInventario> newEstadoDetalleInventarios) {
		this.estadodetalleinventarios = newEstadoDetalleInventarios;
	}
	
	public Object getEstadoDetalleInventarioObject() {	
		this.estadodetalleinventarioObject=this.estadodetalleinventarioDataAccess.getEntityObject();
		return this.estadodetalleinventarioObject;
	}
		
	public void setEstadoDetalleInventarioObject(Object newEstadoDetalleInventarioObject) {
		this.estadodetalleinventarioObject = newEstadoDetalleInventarioObject;
	}
	
	public List<Object> getEstadoDetalleInventariosObject() {		
		this.estadodetalleinventariosObject=this.estadodetalleinventarioDataAccess.getEntitiesObject();
		return this.estadodetalleinventariosObject;
	}
		
	public void setEstadoDetalleInventariosObject(List<Object> newEstadoDetalleInventariosObject) {
		this.estadodetalleinventariosObject = newEstadoDetalleInventariosObject;
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
		
		if(this.estadodetalleinventarioDataAccess!=null) {
			this.estadodetalleinventarioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleInventario.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadodetalleinventarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadodetalleinventarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadodetalleinventario = new  EstadoDetalleInventario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleInventario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadodetalleinventario=estadodetalleinventarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetalleinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleInventario(this.estadodetalleinventario);
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
		estadodetalleinventario = new  EstadoDetalleInventario();
		  		  
        try {
			
			estadodetalleinventario=estadodetalleinventarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetalleinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleInventario(this.estadodetalleinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadodetalleinventario = new  EstadoDetalleInventario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleInventario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadodetalleinventario=estadodetalleinventarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetalleinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleInventario(this.estadodetalleinventario);
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
		estadodetalleinventario = new  EstadoDetalleInventario();
		  		  
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
		estadodetalleinventario = new  EstadoDetalleInventario();
		  		  
        try {
			
			estadodetalleinventario=estadodetalleinventarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetalleinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleInventario(this.estadodetalleinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadodetalleinventario = new  EstadoDetalleInventario();
		  		  
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
		estadodetalleinventario = new  EstadoDetalleInventario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleInventario.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadodetalleinventarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodetalleinventario = new  EstadoDetalleInventario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadodetalleinventarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadodetalleinventario = new  EstadoDetalleInventario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleInventario.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadodetalleinventarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodetalleinventario = new  EstadoDetalleInventario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadodetalleinventarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadodetalleinventario = new  EstadoDetalleInventario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleInventario.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadodetalleinventarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodetalleinventario = new  EstadoDetalleInventario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadodetalleinventarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadodetalleinventarios = new  ArrayList<EstadoDetalleInventario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleInventario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoDetalleInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleinventarios=estadodetalleinventarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleInventario(estadodetalleinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleInventario(this.estadodetalleinventarios);
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
		estadodetalleinventarios = new  ArrayList<EstadoDetalleInventario>();
		  		  
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
		estadodetalleinventarios = new  ArrayList<EstadoDetalleInventario>();
		  		  
        try {			
			EstadoDetalleInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleinventarios=estadodetalleinventarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoDetalleInventario(estadodetalleinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleInventario(this.estadodetalleinventarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadodetalleinventarios = new  ArrayList<EstadoDetalleInventario>();
		  		  
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
		estadodetalleinventarios = new  ArrayList<EstadoDetalleInventario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleInventario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoDetalleInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleinventarios=estadodetalleinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleInventario(estadodetalleinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleInventario(this.estadodetalleinventarios);
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
		estadodetalleinventarios = new  ArrayList<EstadoDetalleInventario>();
		  		  
        try {
			EstadoDetalleInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleinventarios=estadodetalleinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleInventario(estadodetalleinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleInventario(this.estadodetalleinventarios);
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
		estadodetalleinventarios = new  ArrayList<EstadoDetalleInventario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleInventario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleinventarios=estadodetalleinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleInventario(estadodetalleinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleInventario(this.estadodetalleinventarios);
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
		estadodetalleinventarios = new  ArrayList<EstadoDetalleInventario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleinventarios=estadodetalleinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleInventario(estadodetalleinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleInventario(this.estadodetalleinventarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadodetalleinventario = new  EstadoDetalleInventario();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleInventario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleinventario=estadodetalleinventarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleInventario(estadodetalleinventario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleInventario(this.estadodetalleinventario);
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
		estadodetalleinventario = new  EstadoDetalleInventario();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleinventario=estadodetalleinventarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleInventario(estadodetalleinventario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleInventario(this.estadodetalleinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadodetalleinventarios = new  ArrayList<EstadoDetalleInventario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleInventario.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoDetalleInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleinventarios=estadodetalleinventarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleInventario(estadodetalleinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleInventario(this.estadodetalleinventarios);
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
		estadodetalleinventarios = new  ArrayList<EstadoDetalleInventario>();
		  		  
        try {
			EstadoDetalleInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleinventarios=estadodetalleinventarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleInventario(estadodetalleinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleInventario(this.estadodetalleinventarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoDetalleInventariosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadodetalleinventarios = new  ArrayList<EstadoDetalleInventario>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleInventario.class.getSimpleName()+"-getTodosEstadoDetalleInventariosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleinventarios=estadodetalleinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoDetalleInventario(estadodetalleinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleInventario(this.estadodetalleinventarios);
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
	
	public  void  getTodosEstadoDetalleInventarios(String sFinalQuery,Pagination pagination)throws Exception {
		estadodetalleinventarios = new  ArrayList<EstadoDetalleInventario>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleinventarios=estadodetalleinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoDetalleInventario(estadodetalleinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleInventario(this.estadodetalleinventarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoDetalleInventario(EstadoDetalleInventario estadodetalleinventario) throws Exception {
		Boolean estaValidado=false;
		
		if(estadodetalleinventario.getIsNew() || estadodetalleinventario.getIsChanged()) { 
			this.invalidValues = estadodetalleinventarioValidator.getInvalidValues(estadodetalleinventario);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadodetalleinventario);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoDetalleInventario(List<EstadoDetalleInventario> EstadoDetalleInventarios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoDetalleInventario estadodetalleinventarioLocal:estadodetalleinventarios) {				
			estaValidadoObjeto=this.validarGuardarEstadoDetalleInventario(estadodetalleinventarioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoDetalleInventario(List<EstadoDetalleInventario> EstadoDetalleInventarios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoDetalleInventario(estadodetalleinventarios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoDetalleInventario(EstadoDetalleInventario EstadoDetalleInventario) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoDetalleInventario(estadodetalleinventario)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoDetalleInventario estadodetalleinventario) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadodetalleinventario.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoDetalleInventarioConstantesFunciones.getEstadoDetalleInventarioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadodetalleinventario","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoDetalleInventarioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoDetalleInventarioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoDetalleInventarioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleInventario.class.getSimpleName()+"-saveEstadoDetalleInventarioWithConnection");connexion.begin();			
			
			EstadoDetalleInventarioLogicAdditional.checkEstadoDetalleInventarioToSave(this.estadodetalleinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoDetalleInventarioLogicAdditional.updateEstadoDetalleInventarioToSave(this.estadodetalleinventario,this.arrDatoGeneral);
			
			EstadoDetalleInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadodetalleinventario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoDetalleInventario();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoDetalleInventario(this.estadodetalleinventario)) {
				EstadoDetalleInventarioDataAccess.save(this.estadodetalleinventario, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadodetalleinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoDetalleInventarioLogicAdditional.checkEstadoDetalleInventarioToSaveAfter(this.estadodetalleinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoDetalleInventario();
			
			connexion.commit();			
			
			if(this.estadodetalleinventario.getIsDeleted()) {
				this.estadodetalleinventario=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoDetalleInventario()throws Exception {	
		try {	
			
			EstadoDetalleInventarioLogicAdditional.checkEstadoDetalleInventarioToSave(this.estadodetalleinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoDetalleInventarioLogicAdditional.updateEstadoDetalleInventarioToSave(this.estadodetalleinventario,this.arrDatoGeneral);
			
			EstadoDetalleInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadodetalleinventario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoDetalleInventario(this.estadodetalleinventario)) {			
				EstadoDetalleInventarioDataAccess.save(this.estadodetalleinventario, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadodetalleinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoDetalleInventarioLogicAdditional.checkEstadoDetalleInventarioToSaveAfter(this.estadodetalleinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadodetalleinventario.getIsDeleted()) {
				this.estadodetalleinventario=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoDetalleInventariosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleInventario.class.getSimpleName()+"-saveEstadoDetalleInventariosWithConnection");connexion.begin();			
			
			EstadoDetalleInventarioLogicAdditional.checkEstadoDetalleInventarioToSaves(estadodetalleinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoDetalleInventarios();
			
			Boolean validadoTodosEstadoDetalleInventario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoDetalleInventario estadodetalleinventarioLocal:estadodetalleinventarios) {		
				if(estadodetalleinventarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoDetalleInventarioLogicAdditional.updateEstadoDetalleInventarioToSave(estadodetalleinventarioLocal,this.arrDatoGeneral);
	        	
				EstadoDetalleInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadodetalleinventarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoDetalleInventario(estadodetalleinventarioLocal)) {
					EstadoDetalleInventarioDataAccess.save(estadodetalleinventarioLocal, connexion);				
				} else {
					validadoTodosEstadoDetalleInventario=false;
				}
			}
			
			if(!validadoTodosEstadoDetalleInventario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoDetalleInventarioLogicAdditional.checkEstadoDetalleInventarioToSavesAfter(estadodetalleinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoDetalleInventarios();
			
			connexion.commit();		
			
			this.quitarEstadoDetalleInventariosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoDetalleInventarios()throws Exception {				
		 try {	
			EstadoDetalleInventarioLogicAdditional.checkEstadoDetalleInventarioToSaves(estadodetalleinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoDetalleInventario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoDetalleInventario estadodetalleinventarioLocal:estadodetalleinventarios) {				
				if(estadodetalleinventarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoDetalleInventarioLogicAdditional.updateEstadoDetalleInventarioToSave(estadodetalleinventarioLocal,this.arrDatoGeneral);
	        	
				EstadoDetalleInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadodetalleinventarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoDetalleInventario(estadodetalleinventarioLocal)) {				
					EstadoDetalleInventarioDataAccess.save(estadodetalleinventarioLocal, connexion);				
				} else {
					validadoTodosEstadoDetalleInventario=false;
				}
			}
			
			if(!validadoTodosEstadoDetalleInventario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoDetalleInventarioLogicAdditional.checkEstadoDetalleInventarioToSavesAfter(estadodetalleinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoDetalleInventariosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoDetalleInventarioParameterReturnGeneral procesarAccionEstadoDetalleInventarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoDetalleInventario> estadodetalleinventarios,EstadoDetalleInventarioParameterReturnGeneral estadodetalleinventarioParameterGeneral)throws Exception {
		 try {	
			EstadoDetalleInventarioParameterReturnGeneral estadodetalleinventarioReturnGeneral=new EstadoDetalleInventarioParameterReturnGeneral();
	
			EstadoDetalleInventarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadodetalleinventarios,estadodetalleinventarioParameterGeneral,estadodetalleinventarioReturnGeneral);
			
			return estadodetalleinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoDetalleInventarioParameterReturnGeneral procesarAccionEstadoDetalleInventariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoDetalleInventario> estadodetalleinventarios,EstadoDetalleInventarioParameterReturnGeneral estadodetalleinventarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleInventario.class.getSimpleName()+"-procesarAccionEstadoDetalleInventariosWithConnection");connexion.begin();			
			
			EstadoDetalleInventarioParameterReturnGeneral estadodetalleinventarioReturnGeneral=new EstadoDetalleInventarioParameterReturnGeneral();
	
			EstadoDetalleInventarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadodetalleinventarios,estadodetalleinventarioParameterGeneral,estadodetalleinventarioReturnGeneral);
			
			this.connexion.commit();
			
			return estadodetalleinventarioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoDetalleInventarioParameterReturnGeneral procesarEventosEstadoDetalleInventarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoDetalleInventario> estadodetalleinventarios,EstadoDetalleInventario estadodetalleinventario,EstadoDetalleInventarioParameterReturnGeneral estadodetalleinventarioParameterGeneral,Boolean isEsNuevoEstadoDetalleInventario,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoDetalleInventarioParameterReturnGeneral estadodetalleinventarioReturnGeneral=new EstadoDetalleInventarioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadodetalleinventarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoDetalleInventarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadodetalleinventarios,estadodetalleinventario,estadodetalleinventarioParameterGeneral,estadodetalleinventarioReturnGeneral,isEsNuevoEstadoDetalleInventario,clases);
			
			return estadodetalleinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoDetalleInventarioParameterReturnGeneral procesarEventosEstadoDetalleInventariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoDetalleInventario> estadodetalleinventarios,EstadoDetalleInventario estadodetalleinventario,EstadoDetalleInventarioParameterReturnGeneral estadodetalleinventarioParameterGeneral,Boolean isEsNuevoEstadoDetalleInventario,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleInventario.class.getSimpleName()+"-procesarEventosEstadoDetalleInventariosWithConnection");connexion.begin();			
			
			EstadoDetalleInventarioParameterReturnGeneral estadodetalleinventarioReturnGeneral=new EstadoDetalleInventarioParameterReturnGeneral();
	
			estadodetalleinventarioReturnGeneral.setEstadoDetalleInventario(estadodetalleinventario);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadodetalleinventarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoDetalleInventarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadodetalleinventarios,estadodetalleinventario,estadodetalleinventarioParameterGeneral,estadodetalleinventarioReturnGeneral,isEsNuevoEstadoDetalleInventario,clases);
			
			this.connexion.commit();
			
			return estadodetalleinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoDetalleInventarioParameterReturnGeneral procesarImportacionEstadoDetalleInventariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoDetalleInventarioParameterReturnGeneral estadodetalleinventarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleInventario.class.getSimpleName()+"-procesarImportacionEstadoDetalleInventariosWithConnection");connexion.begin();			
			
			EstadoDetalleInventarioParameterReturnGeneral estadodetalleinventarioReturnGeneral=new EstadoDetalleInventarioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadodetalleinventarios=new ArrayList<EstadoDetalleInventario>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadodetalleinventario=new EstadoDetalleInventario();
				
				
				if(conColumnasBase) {this.estadodetalleinventario.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadodetalleinventario.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadodetalleinventario.setcodigo(arrColumnas[iColumn++]);
				this.estadodetalleinventario.setnombre(arrColumnas[iColumn++]);
				
				this.estadodetalleinventarios.add(this.estadodetalleinventario);
			}
			
			this.saveEstadoDetalleInventarios();
			
			this.connexion.commit();
			
			estadodetalleinventarioReturnGeneral.setConRetornoEstaProcesado(true);
			estadodetalleinventarioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadodetalleinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoDetalleInventariosEliminados() throws Exception {				
		
		List<EstadoDetalleInventario> estadodetalleinventariosAux= new ArrayList<EstadoDetalleInventario>();
		
		for(EstadoDetalleInventario estadodetalleinventario:estadodetalleinventarios) {
			if(!estadodetalleinventario.getIsDeleted()) {
				estadodetalleinventariosAux.add(estadodetalleinventario);
			}
		}
		
		estadodetalleinventarios=estadodetalleinventariosAux;
	}
	
	public void quitarEstadoDetalleInventariosNulos() throws Exception {				
		
		List<EstadoDetalleInventario> estadodetalleinventariosAux= new ArrayList<EstadoDetalleInventario>();
		
		for(EstadoDetalleInventario estadodetalleinventario : this.estadodetalleinventarios) {
			if(estadodetalleinventario==null) {
				estadodetalleinventariosAux.add(estadodetalleinventario);
			}
		}
		
		//this.estadodetalleinventarios=estadodetalleinventariosAux;
		
		this.estadodetalleinventarios.removeAll(estadodetalleinventariosAux);
	}
	
	public void getSetVersionRowEstadoDetalleInventarioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadodetalleinventario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadodetalleinventario.getIsDeleted() || (estadodetalleinventario.getIsChanged()&&!estadodetalleinventario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadodetalleinventarioDataAccess.getSetVersionRowEstadoDetalleInventario(connexion,estadodetalleinventario.getId());
				
				if(!estadodetalleinventario.getVersionRow().equals(timestamp)) {	
					estadodetalleinventario.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadodetalleinventario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoDetalleInventario()throws Exception {	
		
		if(estadodetalleinventario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadodetalleinventario.getIsDeleted() || (estadodetalleinventario.getIsChanged()&&!estadodetalleinventario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadodetalleinventarioDataAccess.getSetVersionRowEstadoDetalleInventario(connexion,estadodetalleinventario.getId());
			
			try {							
				if(!estadodetalleinventario.getVersionRow().equals(timestamp)) {	
					estadodetalleinventario.setVersionRow(timestamp);
				}
				
				estadodetalleinventario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoDetalleInventariosWithConnection()throws Exception {	
		if(estadodetalleinventarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoDetalleInventario estadodetalleinventarioAux:estadodetalleinventarios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadodetalleinventarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadodetalleinventarioAux.getIsDeleted() || (estadodetalleinventarioAux.getIsChanged()&&!estadodetalleinventarioAux.getIsNew())) {
						
						timestamp=estadodetalleinventarioDataAccess.getSetVersionRowEstadoDetalleInventario(connexion,estadodetalleinventarioAux.getId());
						
						if(!estadodetalleinventario.getVersionRow().equals(timestamp)) {	
							estadodetalleinventarioAux.setVersionRow(timestamp);
						}
								
						estadodetalleinventarioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoDetalleInventarios()throws Exception {	
		if(estadodetalleinventarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoDetalleInventario estadodetalleinventarioAux:estadodetalleinventarios) {
					if(estadodetalleinventarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadodetalleinventarioAux.getIsDeleted() || (estadodetalleinventarioAux.getIsChanged()&&!estadodetalleinventarioAux.getIsNew())) {
						
						timestamp=estadodetalleinventarioDataAccess.getSetVersionRowEstadoDetalleInventario(connexion,estadodetalleinventarioAux.getId());
						
						if(!estadodetalleinventarioAux.getVersionRow().equals(timestamp)) {	
							estadodetalleinventarioAux.setVersionRow(timestamp);
						}
						
													
						estadodetalleinventarioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoDetalleInventarioWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleCompraLogic detallecompraLogic=new DetalleCompraLogic();
			DetalleTransferenciaLogic detalletransferenciaLogic=new DetalleTransferenciaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleInventario.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoDetalleInventarioWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleCompra.class));
			classes.add(new Classe(DetalleTransferencia.class));
											
			

			detallecompraLogic.setConnexion(this.getConnexion());
			detallecompraLogic.setDatosCliente(this.datosCliente);
			detallecompraLogic.setIsConRefrescarForeignKeys(true);

			detalletransferenciaLogic.setConnexion(this.getConnexion());
			detalletransferenciaLogic.setDatosCliente(this.datosCliente);
			detalletransferenciaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoDetalleInventario estadodetalleinventario:this.estadodetalleinventarios) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleCompraConstantesFunciones.getClassesForeignKeysOfDetalleCompra(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallecompraLogic.setDetalleCompras(estadodetalleinventario.detallecompras);
				detallecompraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetalleTransferenciaConstantesFunciones.getClassesForeignKeysOfDetalleTransferencia(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalletransferenciaLogic.setDetalleTransferencias(estadodetalleinventario.detalletransferencias);
				detalletransferenciaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoDetalleInventario estadodetalleinventario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoDetalleInventarioLogicAdditional.updateEstadoDetalleInventarioToGet(estadodetalleinventario,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadodetalleinventario.setDetalleCompras(estadodetalleinventarioDataAccess.getDetalleCompras(connexion,estadodetalleinventario));
		estadodetalleinventario.setDetalleTransferencias(estadodetalleinventarioDataAccess.getDetalleTransferencias(connexion,estadodetalleinventario));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodetalleinventario.setDetalleCompras(estadodetalleinventarioDataAccess.getDetalleCompras(connexion,estadodetalleinventario));

				if(this.isConDeep) {
					DetalleCompraLogic detallecompraLogic= new DetalleCompraLogic(this.connexion);
					detallecompraLogic.setDetalleCompras(estadodetalleinventario.getDetalleCompras());
					ArrayList<Classe> classesLocal=DetalleCompraConstantesFunciones.getClassesForeignKeysOfDetalleCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallecompraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(detallecompraLogic.getDetalleCompras());
					estadodetalleinventario.setDetalleCompras(detallecompraLogic.getDetalleCompras());
				}

				continue;
			}

			if(clas.clas.equals(DetalleTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodetalleinventario.setDetalleTransferencias(estadodetalleinventarioDataAccess.getDetalleTransferencias(connexion,estadodetalleinventario));

				if(this.isConDeep) {
					DetalleTransferenciaLogic detalletransferenciaLogic= new DetalleTransferenciaLogic(this.connexion);
					detalletransferenciaLogic.setDetalleTransferencias(estadodetalleinventario.getDetalleTransferencias());
					ArrayList<Classe> classesLocal=DetalleTransferenciaConstantesFunciones.getClassesForeignKeysOfDetalleTransferencia(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalletransferenciaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(detalletransferenciaLogic.getDetalleTransferencias());
					estadodetalleinventario.setDetalleTransferencias(detalletransferenciaLogic.getDetalleTransferencias());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleCompra.class));
			estadodetalleinventario.setDetalleCompras(estadodetalleinventarioDataAccess.getDetalleCompras(connexion,estadodetalleinventario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleTransferencia.class));
			estadodetalleinventario.setDetalleTransferencias(estadodetalleinventarioDataAccess.getDetalleTransferencias(connexion,estadodetalleinventario));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadodetalleinventario.setDetalleCompras(estadodetalleinventarioDataAccess.getDetalleCompras(connexion,estadodetalleinventario));

		for(DetalleCompra detallecompra:estadodetalleinventario.getDetalleCompras()) {
			DetalleCompraLogic detallecompraLogic= new DetalleCompraLogic(connexion);
			detallecompraLogic.deepLoad(detallecompra,isDeep,deepLoadType,clases);
		}

		estadodetalleinventario.setDetalleTransferencias(estadodetalleinventarioDataAccess.getDetalleTransferencias(connexion,estadodetalleinventario));

		for(DetalleTransferencia detalletransferencia:estadodetalleinventario.getDetalleTransferencias()) {
			DetalleTransferenciaLogic detalletransferenciaLogic= new DetalleTransferenciaLogic(connexion);
			detalletransferenciaLogic.deepLoad(detalletransferencia,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodetalleinventario.setDetalleCompras(estadodetalleinventarioDataAccess.getDetalleCompras(connexion,estadodetalleinventario));

				for(DetalleCompra detallecompra:estadodetalleinventario.getDetalleCompras()) {
					DetalleCompraLogic detallecompraLogic= new DetalleCompraLogic(connexion);
					detallecompraLogic.deepLoad(detallecompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodetalleinventario.setDetalleTransferencias(estadodetalleinventarioDataAccess.getDetalleTransferencias(connexion,estadodetalleinventario));

				for(DetalleTransferencia detalletransferencia:estadodetalleinventario.getDetalleTransferencias()) {
					DetalleTransferenciaLogic detalletransferenciaLogic= new DetalleTransferenciaLogic(connexion);
					detalletransferenciaLogic.deepLoad(detalletransferencia,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleCompra.class));
			estadodetalleinventario.setDetalleCompras(estadodetalleinventarioDataAccess.getDetalleCompras(connexion,estadodetalleinventario));

			for(DetalleCompra detallecompra:estadodetalleinventario.getDetalleCompras()) {
				DetalleCompraLogic detallecompraLogic= new DetalleCompraLogic(connexion);
				detallecompraLogic.deepLoad(detallecompra,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleTransferencia.class));
			estadodetalleinventario.setDetalleTransferencias(estadodetalleinventarioDataAccess.getDetalleTransferencias(connexion,estadodetalleinventario));

			for(DetalleTransferencia detalletransferencia:estadodetalleinventario.getDetalleTransferencias()) {
				DetalleTransferenciaLogic detalletransferenciaLogic= new DetalleTransferenciaLogic(connexion);
				detalletransferenciaLogic.deepLoad(detalletransferencia,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoDetalleInventario estadodetalleinventario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoDetalleInventarioLogicAdditional.updateEstadoDetalleInventarioToSave(estadodetalleinventario,this.arrDatoGeneral);
			
EstadoDetalleInventarioDataAccess.save(estadodetalleinventario, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(DetalleCompra detallecompra:estadodetalleinventario.getDetalleCompras()) {
			detallecompra.setid_estado_detalle_inventario(estadodetalleinventario.getId());
			DetalleCompraDataAccess.save(detallecompra,connexion);
		}

		for(DetalleTransferencia detalletransferencia:estadodetalleinventario.getDetalleTransferencias()) {
			detalletransferencia.setid_estado_detalle_inventario(estadodetalleinventario.getId());
			DetalleTransferenciaDataAccess.save(detalletransferencia,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(DetalleCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleCompra detallecompra:estadodetalleinventario.getDetalleCompras()) {
					detallecompra.setid_estado_detalle_inventario(estadodetalleinventario.getId());
					DetalleCompraDataAccess.save(detallecompra,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetalleTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleTransferencia detalletransferencia:estadodetalleinventario.getDetalleTransferencias()) {
					detalletransferencia.setid_estado_detalle_inventario(estadodetalleinventario.getId());
					DetalleTransferenciaDataAccess.save(detalletransferencia,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(DetalleCompra detallecompra:estadodetalleinventario.getDetalleCompras()) {
			DetalleCompraLogic detallecompraLogic= new DetalleCompraLogic(connexion);
			detallecompra.setid_estado_detalle_inventario(estadodetalleinventario.getId());
			DetalleCompraDataAccess.save(detallecompra,connexion);
			detallecompraLogic.deepSave(detallecompra,isDeep,deepLoadType,clases);
		}

		for(DetalleTransferencia detalletransferencia:estadodetalleinventario.getDetalleTransferencias()) {
			DetalleTransferenciaLogic detalletransferenciaLogic= new DetalleTransferenciaLogic(connexion);
			detalletransferencia.setid_estado_detalle_inventario(estadodetalleinventario.getId());
			DetalleTransferenciaDataAccess.save(detalletransferencia,connexion);
			detalletransferenciaLogic.deepSave(detalletransferencia,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(DetalleCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleCompra detallecompra:estadodetalleinventario.getDetalleCompras()) {
					DetalleCompraLogic detallecompraLogic= new DetalleCompraLogic(connexion);
					detallecompra.setid_estado_detalle_inventario(estadodetalleinventario.getId());
					DetalleCompraDataAccess.save(detallecompra,connexion);
					detallecompraLogic.deepSave(detallecompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleTransferencia detalletransferencia:estadodetalleinventario.getDetalleTransferencias()) {
					DetalleTransferenciaLogic detalletransferenciaLogic= new DetalleTransferenciaLogic(connexion);
					detalletransferencia.setid_estado_detalle_inventario(estadodetalleinventario.getId());
					DetalleTransferenciaDataAccess.save(detalletransferencia,connexion);
					detalletransferenciaLogic.deepSave(detalletransferencia,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EstadoDetalleInventario.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadodetalleinventario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoDetalleInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleInventario(estadodetalleinventario);
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
			this.deepLoad(this.estadodetalleinventario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoDetalleInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleInventario(this.estadodetalleinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoDetalleInventario.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadodetalleinventarios!=null) {
				for(EstadoDetalleInventario estadodetalleinventario:estadodetalleinventarios) {
					this.deepLoad(estadodetalleinventario,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoDetalleInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleInventario(estadodetalleinventarios);
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
			if(estadodetalleinventarios!=null) {
				for(EstadoDetalleInventario estadodetalleinventario:estadodetalleinventarios) {
					this.deepLoad(estadodetalleinventario,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoDetalleInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleInventario(estadodetalleinventarios);
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
			this.getNewConnexionToDeep(EstadoDetalleInventario.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadodetalleinventario,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoDetalleInventario.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadodetalleinventarios!=null) {
				for(EstadoDetalleInventario estadodetalleinventario:estadodetalleinventarios) {
					this.deepSave(estadodetalleinventario,isDeep,deepLoadType,clases);
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
			if(estadodetalleinventarios!=null) {
				for(EstadoDetalleInventario estadodetalleinventario:estadodetalleinventarios) {
					this.deepSave(estadodetalleinventario,isDeep,deepLoadType,clases);
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
			if(EstadoDetalleInventarioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleInventarioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoDetalleInventario estadodetalleinventario,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoDetalleInventarioConstantesFunciones.ISCONAUDITORIA) {
				if(estadodetalleinventario.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleInventarioDataAccess.TABLENAME, estadodetalleinventario.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoDetalleInventarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoDetalleInventarioLogic.registrarAuditoriaDetallesEstadoDetalleInventario(connexion,estadodetalleinventario,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadodetalleinventario.getIsDeleted()) {
					/*if(!estadodetalleinventario.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoDetalleInventarioDataAccess.TABLENAME, estadodetalleinventario.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoDetalleInventarioLogic.registrarAuditoriaDetallesEstadoDetalleInventario(connexion,estadodetalleinventario,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleInventarioDataAccess.TABLENAME, estadodetalleinventario.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadodetalleinventario.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleInventarioDataAccess.TABLENAME, estadodetalleinventario.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoDetalleInventarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoDetalleInventarioLogic.registrarAuditoriaDetallesEstadoDetalleInventario(connexion,estadodetalleinventario,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoDetalleInventario(Connexion connexion,EstadoDetalleInventario estadodetalleinventario)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadodetalleinventario.getIsNew()||!estadodetalleinventario.getcodigo().equals(estadodetalleinventario.getEstadoDetalleInventarioOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadodetalleinventario.getEstadoDetalleInventarioOriginal().getcodigo()!=null)
				{
					strValorActual=estadodetalleinventario.getEstadoDetalleInventarioOriginal().getcodigo();
				}
				if(estadodetalleinventario.getcodigo()!=null)
				{
					strValorNuevo=estadodetalleinventario.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoDetalleInventarioConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadodetalleinventario.getIsNew()||!estadodetalleinventario.getnombre().equals(estadodetalleinventario.getEstadoDetalleInventarioOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadodetalleinventario.getEstadoDetalleInventarioOriginal().getnombre()!=null)
				{
					strValorActual=estadodetalleinventario.getEstadoDetalleInventarioOriginal().getnombre();
				}
				if(estadodetalleinventario.getnombre()!=null)
				{
					strValorNuevo=estadodetalleinventario.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoDetalleInventarioConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoDetalleInventarioRelacionesWithConnection(EstadoDetalleInventario estadodetalleinventario,List<DetalleCompra> detallecompras,List<DetalleTransferencia> detalletransferencias) throws Exception {

		if(!estadodetalleinventario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoDetalleInventarioRelacionesBase(estadodetalleinventario,detallecompras,detalletransferencias,true);
		}
	}

	public void saveEstadoDetalleInventarioRelaciones(EstadoDetalleInventario estadodetalleinventario,List<DetalleCompra> detallecompras,List<DetalleTransferencia> detalletransferencias)throws Exception {

		if(!estadodetalleinventario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoDetalleInventarioRelacionesBase(estadodetalleinventario,detallecompras,detalletransferencias,false);
		}
	}

	public void saveEstadoDetalleInventarioRelacionesBase(EstadoDetalleInventario estadodetalleinventario,List<DetalleCompra> detallecompras,List<DetalleTransferencia> detalletransferencias,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoDetalleInventario-saveRelacionesWithConnection");}
	
			estadodetalleinventario.setDetalleCompras(detallecompras);
			estadodetalleinventario.setDetalleTransferencias(detalletransferencias);

			this.setEstadoDetalleInventario(estadodetalleinventario);

				if((estadodetalleinventario.getIsNew()||estadodetalleinventario.getIsChanged())&&!estadodetalleinventario.getIsDeleted()) {
					this.saveEstadoDetalleInventario();
					this.saveEstadoDetalleInventarioRelacionesDetalles(detallecompras,detalletransferencias);

				} else if(estadodetalleinventario.getIsDeleted()) {
					this.saveEstadoDetalleInventarioRelacionesDetalles(detallecompras,detalletransferencias);
					this.saveEstadoDetalleInventario();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleCompraConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleCompras(detallecompras,true,true);
			DetalleTransferenciaConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleTransferencias(detalletransferencias,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoDetalleInventarioRelacionesDetalles(List<DetalleCompra> detallecompras,List<DetalleTransferencia> detalletransferencias)throws Exception {
		try {
	

			Long idEstadoDetalleInventarioActual=this.getEstadoDetalleInventario().getId();

			DetalleCompraLogic detallecompraLogic_Desde_EstadoDetalleInventario=new DetalleCompraLogic();
			detallecompraLogic_Desde_EstadoDetalleInventario.setDetalleCompras(detallecompras);

			detallecompraLogic_Desde_EstadoDetalleInventario.setConnexion(this.getConnexion());
			detallecompraLogic_Desde_EstadoDetalleInventario.setDatosCliente(this.datosCliente);

			for(DetalleCompra detallecompra_Desde_EstadoDetalleInventario:detallecompraLogic_Desde_EstadoDetalleInventario.getDetalleCompras()) {
				detallecompra_Desde_EstadoDetalleInventario.setid_estado_detalle_inventario(idEstadoDetalleInventarioActual);
			}

			detallecompraLogic_Desde_EstadoDetalleInventario.saveDetalleCompras();

			DetalleTransferenciaLogic detalletransferenciaLogic_Desde_EstadoDetalleInventario=new DetalleTransferenciaLogic();
			detalletransferenciaLogic_Desde_EstadoDetalleInventario.setDetalleTransferencias(detalletransferencias);

			detalletransferenciaLogic_Desde_EstadoDetalleInventario.setConnexion(this.getConnexion());
			detalletransferenciaLogic_Desde_EstadoDetalleInventario.setDatosCliente(this.datosCliente);

			for(DetalleTransferencia detalletransferencia_Desde_EstadoDetalleInventario:detalletransferenciaLogic_Desde_EstadoDetalleInventario.getDetalleTransferencias()) {
				detalletransferencia_Desde_EstadoDetalleInventario.setid_estado_detalle_inventario(idEstadoDetalleInventarioActual);
			}

			detalletransferenciaLogic_Desde_EstadoDetalleInventario.saveDetalleTransferencias();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoDetalleInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoDetalleInventarioConstantesFunciones.getClassesForeignKeysOfEstadoDetalleInventario(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDetalleInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoDetalleInventarioConstantesFunciones.getClassesRelationshipsOfEstadoDetalleInventario(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

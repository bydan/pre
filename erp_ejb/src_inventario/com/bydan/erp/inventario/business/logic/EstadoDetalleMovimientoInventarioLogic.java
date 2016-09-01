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
import com.bydan.erp.inventario.util.EstadoDetalleMovimientoInventarioConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoDetalleMovimientoInventarioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoDetalleMovimientoInventarioParameterGeneral;
import com.bydan.erp.inventario.business.entity.EstadoDetalleMovimientoInventario;
import com.bydan.erp.inventario.business.logic.EstadoDetalleMovimientoInventarioLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

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
public class EstadoDetalleMovimientoInventarioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoDetalleMovimientoInventarioLogic.class);
	
	protected EstadoDetalleMovimientoInventarioDataAccess estadodetallemovimientoinventarioDataAccess; 	
	protected EstadoDetalleMovimientoInventario estadodetallemovimientoinventario;
	protected List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventarios;
	protected Object estadodetallemovimientoinventarioObject;	
	protected List<Object> estadodetallemovimientoinventariosObject;
	
	public static ClassValidator<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventarioValidator = new ClassValidator<EstadoDetalleMovimientoInventario>(EstadoDetalleMovimientoInventario.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoDetalleMovimientoInventarioLogicAdditional estadodetallemovimientoinventarioLogicAdditional=null;
	
	public EstadoDetalleMovimientoInventarioLogicAdditional getEstadoDetalleMovimientoInventarioLogicAdditional() {
		return this.estadodetallemovimientoinventarioLogicAdditional;
	}
	
	public void setEstadoDetalleMovimientoInventarioLogicAdditional(EstadoDetalleMovimientoInventarioLogicAdditional estadodetallemovimientoinventarioLogicAdditional) {
		try {
			this.estadodetallemovimientoinventarioLogicAdditional=estadodetallemovimientoinventarioLogicAdditional;
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
	
	
	
	
	public  EstadoDetalleMovimientoInventarioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadodetallemovimientoinventarioDataAccess = new EstadoDetalleMovimientoInventarioDataAccess();
			
			this.estadodetallemovimientoinventarios= new ArrayList<EstadoDetalleMovimientoInventario>();
			this.estadodetallemovimientoinventario= new EstadoDetalleMovimientoInventario();
			
			this.estadodetallemovimientoinventarioObject=new Object();
			this.estadodetallemovimientoinventariosObject=new ArrayList<Object>();
				
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
			
			this.estadodetallemovimientoinventarioDataAccess.setConnexionType(this.connexionType);
			this.estadodetallemovimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoDetalleMovimientoInventarioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadodetallemovimientoinventarioDataAccess = new EstadoDetalleMovimientoInventarioDataAccess();
			this.estadodetallemovimientoinventarios= new ArrayList<EstadoDetalleMovimientoInventario>();
			this.estadodetallemovimientoinventario= new EstadoDetalleMovimientoInventario();
			this.estadodetallemovimientoinventarioObject=new Object();
			this.estadodetallemovimientoinventariosObject=new ArrayList<Object>();
			
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
			
			this.estadodetallemovimientoinventarioDataAccess.setConnexionType(this.connexionType);
			this.estadodetallemovimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoDetalleMovimientoInventario getEstadoDetalleMovimientoInventario() throws Exception {	
		EstadoDetalleMovimientoInventarioLogicAdditional.checkEstadoDetalleMovimientoInventarioToGet(estadodetallemovimientoinventario,this.datosCliente,this.arrDatoGeneral);
		EstadoDetalleMovimientoInventarioLogicAdditional.updateEstadoDetalleMovimientoInventarioToGet(estadodetallemovimientoinventario,this.arrDatoGeneral);
		
		return estadodetallemovimientoinventario;
	}
		
	public void setEstadoDetalleMovimientoInventario(EstadoDetalleMovimientoInventario newEstadoDetalleMovimientoInventario) {
		this.estadodetallemovimientoinventario = newEstadoDetalleMovimientoInventario;
	}
	
	public EstadoDetalleMovimientoInventarioDataAccess getEstadoDetalleMovimientoInventarioDataAccess() {
		return estadodetallemovimientoinventarioDataAccess;
	}
	
	public void setEstadoDetalleMovimientoInventarioDataAccess(EstadoDetalleMovimientoInventarioDataAccess newestadodetallemovimientoinventarioDataAccess) {
		this.estadodetallemovimientoinventarioDataAccess = newestadodetallemovimientoinventarioDataAccess;
	}
	
	public List<EstadoDetalleMovimientoInventario> getEstadoDetalleMovimientoInventarios() throws Exception {		
		this.quitarEstadoDetalleMovimientoInventariosNulos();
		
		EstadoDetalleMovimientoInventarioLogicAdditional.checkEstadoDetalleMovimientoInventarioToGets(estadodetallemovimientoinventarios,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoDetalleMovimientoInventario estadodetallemovimientoinventarioLocal: estadodetallemovimientoinventarios ) {
			EstadoDetalleMovimientoInventarioLogicAdditional.updateEstadoDetalleMovimientoInventarioToGet(estadodetallemovimientoinventarioLocal,this.arrDatoGeneral);
		}
		
		return estadodetallemovimientoinventarios;
	}
	
	public void setEstadoDetalleMovimientoInventarios(List<EstadoDetalleMovimientoInventario> newEstadoDetalleMovimientoInventarios) {
		this.estadodetallemovimientoinventarios = newEstadoDetalleMovimientoInventarios;
	}
	
	public Object getEstadoDetalleMovimientoInventarioObject() {	
		this.estadodetallemovimientoinventarioObject=this.estadodetallemovimientoinventarioDataAccess.getEntityObject();
		return this.estadodetallemovimientoinventarioObject;
	}
		
	public void setEstadoDetalleMovimientoInventarioObject(Object newEstadoDetalleMovimientoInventarioObject) {
		this.estadodetallemovimientoinventarioObject = newEstadoDetalleMovimientoInventarioObject;
	}
	
	public List<Object> getEstadoDetalleMovimientoInventariosObject() {		
		this.estadodetallemovimientoinventariosObject=this.estadodetallemovimientoinventarioDataAccess.getEntitiesObject();
		return this.estadodetallemovimientoinventariosObject;
	}
		
	public void setEstadoDetalleMovimientoInventariosObject(List<Object> newEstadoDetalleMovimientoInventariosObject) {
		this.estadodetallemovimientoinventariosObject = newEstadoDetalleMovimientoInventariosObject;
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
		
		if(this.estadodetallemovimientoinventarioDataAccess!=null) {
			this.estadodetallemovimientoinventarioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleMovimientoInventario.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadodetallemovimientoinventarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadodetallemovimientoinventarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadodetallemovimientoinventario = new  EstadoDetalleMovimientoInventario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleMovimientoInventario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadodetallemovimientoinventario=estadodetallemovimientoinventarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetallemovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(this.estadodetallemovimientoinventario);
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
		estadodetallemovimientoinventario = new  EstadoDetalleMovimientoInventario();
		  		  
        try {
			
			estadodetallemovimientoinventario=estadodetallemovimientoinventarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetallemovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(this.estadodetallemovimientoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadodetallemovimientoinventario = new  EstadoDetalleMovimientoInventario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleMovimientoInventario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadodetallemovimientoinventario=estadodetallemovimientoinventarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetallemovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(this.estadodetallemovimientoinventario);
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
		estadodetallemovimientoinventario = new  EstadoDetalleMovimientoInventario();
		  		  
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
		estadodetallemovimientoinventario = new  EstadoDetalleMovimientoInventario();
		  		  
        try {
			
			estadodetallemovimientoinventario=estadodetallemovimientoinventarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetallemovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(this.estadodetallemovimientoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadodetallemovimientoinventario = new  EstadoDetalleMovimientoInventario();
		  		  
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
		estadodetallemovimientoinventario = new  EstadoDetalleMovimientoInventario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleMovimientoInventario.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadodetallemovimientoinventarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodetallemovimientoinventario = new  EstadoDetalleMovimientoInventario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadodetallemovimientoinventarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadodetallemovimientoinventario = new  EstadoDetalleMovimientoInventario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleMovimientoInventario.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadodetallemovimientoinventarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodetallemovimientoinventario = new  EstadoDetalleMovimientoInventario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadodetallemovimientoinventarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadodetallemovimientoinventario = new  EstadoDetalleMovimientoInventario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleMovimientoInventario.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadodetallemovimientoinventarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodetallemovimientoinventario = new  EstadoDetalleMovimientoInventario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadodetallemovimientoinventarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadodetallemovimientoinventarios = new  ArrayList<EstadoDetalleMovimientoInventario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleMovimientoInventario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallemovimientoinventarios=estadodetallemovimientoinventarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleMovimientoInventario(estadodetallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(this.estadodetallemovimientoinventarios);
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
		estadodetallemovimientoinventarios = new  ArrayList<EstadoDetalleMovimientoInventario>();
		  		  
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
		estadodetallemovimientoinventarios = new  ArrayList<EstadoDetalleMovimientoInventario>();
		  		  
        try {			
			EstadoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallemovimientoinventarios=estadodetallemovimientoinventarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoDetalleMovimientoInventario(estadodetallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(this.estadodetallemovimientoinventarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadodetallemovimientoinventarios = new  ArrayList<EstadoDetalleMovimientoInventario>();
		  		  
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
		estadodetallemovimientoinventarios = new  ArrayList<EstadoDetalleMovimientoInventario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleMovimientoInventario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallemovimientoinventarios=estadodetallemovimientoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleMovimientoInventario(estadodetallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(this.estadodetallemovimientoinventarios);
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
		estadodetallemovimientoinventarios = new  ArrayList<EstadoDetalleMovimientoInventario>();
		  		  
        try {
			EstadoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallemovimientoinventarios=estadodetallemovimientoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleMovimientoInventario(estadodetallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(this.estadodetallemovimientoinventarios);
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
		estadodetallemovimientoinventarios = new  ArrayList<EstadoDetalleMovimientoInventario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleMovimientoInventario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallemovimientoinventarios=estadodetallemovimientoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleMovimientoInventario(estadodetallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(this.estadodetallemovimientoinventarios);
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
		estadodetallemovimientoinventarios = new  ArrayList<EstadoDetalleMovimientoInventario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallemovimientoinventarios=estadodetallemovimientoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleMovimientoInventario(estadodetallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(this.estadodetallemovimientoinventarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadodetallemovimientoinventario = new  EstadoDetalleMovimientoInventario();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleMovimientoInventario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallemovimientoinventario=estadodetallemovimientoinventarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleMovimientoInventario(estadodetallemovimientoinventario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(this.estadodetallemovimientoinventario);
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
		estadodetallemovimientoinventario = new  EstadoDetalleMovimientoInventario();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallemovimientoinventario=estadodetallemovimientoinventarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleMovimientoInventario(estadodetallemovimientoinventario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(this.estadodetallemovimientoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadodetallemovimientoinventarios = new  ArrayList<EstadoDetalleMovimientoInventario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleMovimientoInventario.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallemovimientoinventarios=estadodetallemovimientoinventarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleMovimientoInventario(estadodetallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(this.estadodetallemovimientoinventarios);
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
		estadodetallemovimientoinventarios = new  ArrayList<EstadoDetalleMovimientoInventario>();
		  		  
        try {
			EstadoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallemovimientoinventarios=estadodetallemovimientoinventarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleMovimientoInventario(estadodetallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(this.estadodetallemovimientoinventarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoDetalleMovimientoInventariosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadodetallemovimientoinventarios = new  ArrayList<EstadoDetalleMovimientoInventario>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleMovimientoInventario.class.getSimpleName()+"-getTodosEstadoDetalleMovimientoInventariosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallemovimientoinventarios=estadodetallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoDetalleMovimientoInventario(estadodetallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(this.estadodetallemovimientoinventarios);
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
	
	public  void  getTodosEstadoDetalleMovimientoInventarios(String sFinalQuery,Pagination pagination)throws Exception {
		estadodetallemovimientoinventarios = new  ArrayList<EstadoDetalleMovimientoInventario>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallemovimientoinventarios=estadodetallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoDetalleMovimientoInventario(estadodetallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(this.estadodetallemovimientoinventarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoDetalleMovimientoInventario(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario) throws Exception {
		Boolean estaValidado=false;
		
		if(estadodetallemovimientoinventario.getIsNew() || estadodetallemovimientoinventario.getIsChanged()) { 
			this.invalidValues = estadodetallemovimientoinventarioValidator.getInvalidValues(estadodetallemovimientoinventario);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadodetallemovimientoinventario);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoDetalleMovimientoInventario(List<EstadoDetalleMovimientoInventario> EstadoDetalleMovimientoInventarios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventarioLocal:estadodetallemovimientoinventarios) {				
			estaValidadoObjeto=this.validarGuardarEstadoDetalleMovimientoInventario(estadodetallemovimientoinventarioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoDetalleMovimientoInventario(List<EstadoDetalleMovimientoInventario> EstadoDetalleMovimientoInventarios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoDetalleMovimientoInventario(estadodetallemovimientoinventarios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoDetalleMovimientoInventario(EstadoDetalleMovimientoInventario EstadoDetalleMovimientoInventario) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoDetalleMovimientoInventario(estadodetallemovimientoinventario)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadodetallemovimientoinventario.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoDetalleMovimientoInventarioConstantesFunciones.getEstadoDetalleMovimientoInventarioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadodetallemovimientoinventario","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoDetalleMovimientoInventarioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoDetalleMovimientoInventarioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoDetalleMovimientoInventarioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleMovimientoInventario.class.getSimpleName()+"-saveEstadoDetalleMovimientoInventarioWithConnection");connexion.begin();			
			
			EstadoDetalleMovimientoInventarioLogicAdditional.checkEstadoDetalleMovimientoInventarioToSave(this.estadodetallemovimientoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoDetalleMovimientoInventarioLogicAdditional.updateEstadoDetalleMovimientoInventarioToSave(this.estadodetallemovimientoinventario,this.arrDatoGeneral);
			
			EstadoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadodetallemovimientoinventario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoDetalleMovimientoInventario();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoDetalleMovimientoInventario(this.estadodetallemovimientoinventario)) {
				EstadoDetalleMovimientoInventarioDataAccess.save(this.estadodetallemovimientoinventario, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadodetallemovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoDetalleMovimientoInventarioLogicAdditional.checkEstadoDetalleMovimientoInventarioToSaveAfter(this.estadodetallemovimientoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoDetalleMovimientoInventario();
			
			connexion.commit();			
			
			if(this.estadodetallemovimientoinventario.getIsDeleted()) {
				this.estadodetallemovimientoinventario=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoDetalleMovimientoInventario()throws Exception {	
		try {	
			
			EstadoDetalleMovimientoInventarioLogicAdditional.checkEstadoDetalleMovimientoInventarioToSave(this.estadodetallemovimientoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoDetalleMovimientoInventarioLogicAdditional.updateEstadoDetalleMovimientoInventarioToSave(this.estadodetallemovimientoinventario,this.arrDatoGeneral);
			
			EstadoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadodetallemovimientoinventario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoDetalleMovimientoInventario(this.estadodetallemovimientoinventario)) {			
				EstadoDetalleMovimientoInventarioDataAccess.save(this.estadodetallemovimientoinventario, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadodetallemovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoDetalleMovimientoInventarioLogicAdditional.checkEstadoDetalleMovimientoInventarioToSaveAfter(this.estadodetallemovimientoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadodetallemovimientoinventario.getIsDeleted()) {
				this.estadodetallemovimientoinventario=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoDetalleMovimientoInventariosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleMovimientoInventario.class.getSimpleName()+"-saveEstadoDetalleMovimientoInventariosWithConnection");connexion.begin();			
			
			EstadoDetalleMovimientoInventarioLogicAdditional.checkEstadoDetalleMovimientoInventarioToSaves(estadodetallemovimientoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoDetalleMovimientoInventarios();
			
			Boolean validadoTodosEstadoDetalleMovimientoInventario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventarioLocal:estadodetallemovimientoinventarios) {		
				if(estadodetallemovimientoinventarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoDetalleMovimientoInventarioLogicAdditional.updateEstadoDetalleMovimientoInventarioToSave(estadodetallemovimientoinventarioLocal,this.arrDatoGeneral);
	        	
				EstadoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadodetallemovimientoinventarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoDetalleMovimientoInventario(estadodetallemovimientoinventarioLocal)) {
					EstadoDetalleMovimientoInventarioDataAccess.save(estadodetallemovimientoinventarioLocal, connexion);				
				} else {
					validadoTodosEstadoDetalleMovimientoInventario=false;
				}
			}
			
			if(!validadoTodosEstadoDetalleMovimientoInventario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoDetalleMovimientoInventarioLogicAdditional.checkEstadoDetalleMovimientoInventarioToSavesAfter(estadodetallemovimientoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoDetalleMovimientoInventarios();
			
			connexion.commit();		
			
			this.quitarEstadoDetalleMovimientoInventariosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoDetalleMovimientoInventarios()throws Exception {				
		 try {	
			EstadoDetalleMovimientoInventarioLogicAdditional.checkEstadoDetalleMovimientoInventarioToSaves(estadodetallemovimientoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoDetalleMovimientoInventario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventarioLocal:estadodetallemovimientoinventarios) {				
				if(estadodetallemovimientoinventarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoDetalleMovimientoInventarioLogicAdditional.updateEstadoDetalleMovimientoInventarioToSave(estadodetallemovimientoinventarioLocal,this.arrDatoGeneral);
	        	
				EstadoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadodetallemovimientoinventarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoDetalleMovimientoInventario(estadodetallemovimientoinventarioLocal)) {				
					EstadoDetalleMovimientoInventarioDataAccess.save(estadodetallemovimientoinventarioLocal, connexion);				
				} else {
					validadoTodosEstadoDetalleMovimientoInventario=false;
				}
			}
			
			if(!validadoTodosEstadoDetalleMovimientoInventario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoDetalleMovimientoInventarioLogicAdditional.checkEstadoDetalleMovimientoInventarioToSavesAfter(estadodetallemovimientoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoDetalleMovimientoInventariosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoDetalleMovimientoInventarioParameterReturnGeneral procesarAccionEstadoDetalleMovimientoInventarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventarios,EstadoDetalleMovimientoInventarioParameterReturnGeneral estadodetallemovimientoinventarioParameterGeneral)throws Exception {
		 try {	
			EstadoDetalleMovimientoInventarioParameterReturnGeneral estadodetallemovimientoinventarioReturnGeneral=new EstadoDetalleMovimientoInventarioParameterReturnGeneral();
	
			EstadoDetalleMovimientoInventarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadodetallemovimientoinventarios,estadodetallemovimientoinventarioParameterGeneral,estadodetallemovimientoinventarioReturnGeneral);
			
			return estadodetallemovimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoDetalleMovimientoInventarioParameterReturnGeneral procesarAccionEstadoDetalleMovimientoInventariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventarios,EstadoDetalleMovimientoInventarioParameterReturnGeneral estadodetallemovimientoinventarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleMovimientoInventario.class.getSimpleName()+"-procesarAccionEstadoDetalleMovimientoInventariosWithConnection");connexion.begin();			
			
			EstadoDetalleMovimientoInventarioParameterReturnGeneral estadodetallemovimientoinventarioReturnGeneral=new EstadoDetalleMovimientoInventarioParameterReturnGeneral();
	
			EstadoDetalleMovimientoInventarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadodetallemovimientoinventarios,estadodetallemovimientoinventarioParameterGeneral,estadodetallemovimientoinventarioReturnGeneral);
			
			this.connexion.commit();
			
			return estadodetallemovimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoDetalleMovimientoInventarioParameterReturnGeneral procesarEventosEstadoDetalleMovimientoInventarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventarios,EstadoDetalleMovimientoInventario estadodetallemovimientoinventario,EstadoDetalleMovimientoInventarioParameterReturnGeneral estadodetallemovimientoinventarioParameterGeneral,Boolean isEsNuevoEstadoDetalleMovimientoInventario,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoDetalleMovimientoInventarioParameterReturnGeneral estadodetallemovimientoinventarioReturnGeneral=new EstadoDetalleMovimientoInventarioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadodetallemovimientoinventarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoDetalleMovimientoInventarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadodetallemovimientoinventarios,estadodetallemovimientoinventario,estadodetallemovimientoinventarioParameterGeneral,estadodetallemovimientoinventarioReturnGeneral,isEsNuevoEstadoDetalleMovimientoInventario,clases);
			
			return estadodetallemovimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoDetalleMovimientoInventarioParameterReturnGeneral procesarEventosEstadoDetalleMovimientoInventariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventarios,EstadoDetalleMovimientoInventario estadodetallemovimientoinventario,EstadoDetalleMovimientoInventarioParameterReturnGeneral estadodetallemovimientoinventarioParameterGeneral,Boolean isEsNuevoEstadoDetalleMovimientoInventario,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleMovimientoInventario.class.getSimpleName()+"-procesarEventosEstadoDetalleMovimientoInventariosWithConnection");connexion.begin();			
			
			EstadoDetalleMovimientoInventarioParameterReturnGeneral estadodetallemovimientoinventarioReturnGeneral=new EstadoDetalleMovimientoInventarioParameterReturnGeneral();
	
			estadodetallemovimientoinventarioReturnGeneral.setEstadoDetalleMovimientoInventario(estadodetallemovimientoinventario);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadodetallemovimientoinventarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoDetalleMovimientoInventarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadodetallemovimientoinventarios,estadodetallemovimientoinventario,estadodetallemovimientoinventarioParameterGeneral,estadodetallemovimientoinventarioReturnGeneral,isEsNuevoEstadoDetalleMovimientoInventario,clases);
			
			this.connexion.commit();
			
			return estadodetallemovimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoDetalleMovimientoInventarioParameterReturnGeneral procesarImportacionEstadoDetalleMovimientoInventariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoDetalleMovimientoInventarioParameterReturnGeneral estadodetallemovimientoinventarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleMovimientoInventario.class.getSimpleName()+"-procesarImportacionEstadoDetalleMovimientoInventariosWithConnection");connexion.begin();			
			
			EstadoDetalleMovimientoInventarioParameterReturnGeneral estadodetallemovimientoinventarioReturnGeneral=new EstadoDetalleMovimientoInventarioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadodetallemovimientoinventarios=new ArrayList<EstadoDetalleMovimientoInventario>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadodetallemovimientoinventario=new EstadoDetalleMovimientoInventario();
				
				
				if(conColumnasBase) {this.estadodetallemovimientoinventario.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadodetallemovimientoinventario.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadodetallemovimientoinventario.setcodigo(arrColumnas[iColumn++]);
				this.estadodetallemovimientoinventario.setnombre(arrColumnas[iColumn++]);
				
				this.estadodetallemovimientoinventarios.add(this.estadodetallemovimientoinventario);
			}
			
			this.saveEstadoDetalleMovimientoInventarios();
			
			this.connexion.commit();
			
			estadodetallemovimientoinventarioReturnGeneral.setConRetornoEstaProcesado(true);
			estadodetallemovimientoinventarioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadodetallemovimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoDetalleMovimientoInventariosEliminados() throws Exception {				
		
		List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventariosAux= new ArrayList<EstadoDetalleMovimientoInventario>();
		
		for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario:estadodetallemovimientoinventarios) {
			if(!estadodetallemovimientoinventario.getIsDeleted()) {
				estadodetallemovimientoinventariosAux.add(estadodetallemovimientoinventario);
			}
		}
		
		estadodetallemovimientoinventarios=estadodetallemovimientoinventariosAux;
	}
	
	public void quitarEstadoDetalleMovimientoInventariosNulos() throws Exception {				
		
		List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventariosAux= new ArrayList<EstadoDetalleMovimientoInventario>();
		
		for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario : this.estadodetallemovimientoinventarios) {
			if(estadodetallemovimientoinventario==null) {
				estadodetallemovimientoinventariosAux.add(estadodetallemovimientoinventario);
			}
		}
		
		//this.estadodetallemovimientoinventarios=estadodetallemovimientoinventariosAux;
		
		this.estadodetallemovimientoinventarios.removeAll(estadodetallemovimientoinventariosAux);
	}
	
	public void getSetVersionRowEstadoDetalleMovimientoInventarioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadodetallemovimientoinventario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadodetallemovimientoinventario.getIsDeleted() || (estadodetallemovimientoinventario.getIsChanged()&&!estadodetallemovimientoinventario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadodetallemovimientoinventarioDataAccess.getSetVersionRowEstadoDetalleMovimientoInventario(connexion,estadodetallemovimientoinventario.getId());
				
				if(!estadodetallemovimientoinventario.getVersionRow().equals(timestamp)) {	
					estadodetallemovimientoinventario.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadodetallemovimientoinventario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoDetalleMovimientoInventario()throws Exception {	
		
		if(estadodetallemovimientoinventario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadodetallemovimientoinventario.getIsDeleted() || (estadodetallemovimientoinventario.getIsChanged()&&!estadodetallemovimientoinventario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadodetallemovimientoinventarioDataAccess.getSetVersionRowEstadoDetalleMovimientoInventario(connexion,estadodetallemovimientoinventario.getId());
			
			try {							
				if(!estadodetallemovimientoinventario.getVersionRow().equals(timestamp)) {	
					estadodetallemovimientoinventario.setVersionRow(timestamp);
				}
				
				estadodetallemovimientoinventario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoDetalleMovimientoInventariosWithConnection()throws Exception {	
		if(estadodetallemovimientoinventarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventarioAux:estadodetallemovimientoinventarios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadodetallemovimientoinventarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadodetallemovimientoinventarioAux.getIsDeleted() || (estadodetallemovimientoinventarioAux.getIsChanged()&&!estadodetallemovimientoinventarioAux.getIsNew())) {
						
						timestamp=estadodetallemovimientoinventarioDataAccess.getSetVersionRowEstadoDetalleMovimientoInventario(connexion,estadodetallemovimientoinventarioAux.getId());
						
						if(!estadodetallemovimientoinventario.getVersionRow().equals(timestamp)) {	
							estadodetallemovimientoinventarioAux.setVersionRow(timestamp);
						}
								
						estadodetallemovimientoinventarioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoDetalleMovimientoInventarios()throws Exception {	
		if(estadodetallemovimientoinventarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventarioAux:estadodetallemovimientoinventarios) {
					if(estadodetallemovimientoinventarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadodetallemovimientoinventarioAux.getIsDeleted() || (estadodetallemovimientoinventarioAux.getIsChanged()&&!estadodetallemovimientoinventarioAux.getIsNew())) {
						
						timestamp=estadodetallemovimientoinventarioDataAccess.getSetVersionRowEstadoDetalleMovimientoInventario(connexion,estadodetallemovimientoinventarioAux.getId());
						
						if(!estadodetallemovimientoinventarioAux.getVersionRow().equals(timestamp)) {	
							estadodetallemovimientoinventarioAux.setVersionRow(timestamp);
						}
						
													
						estadodetallemovimientoinventarioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoDetalleMovimientoInventarioWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic=new DetalleMovimientoInventarioLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleMovimientoInventario.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoDetalleMovimientoInventarioWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleMovimientoInventario.class));
											
			

			detallemovimientoinventarioLogic.setConnexion(this.getConnexion());
			detallemovimientoinventarioLogic.setDatosCliente(this.datosCliente);
			detallemovimientoinventarioLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario:this.estadodetallemovimientoinventarios) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleMovimientoInventarioConstantesFunciones.getClassesForeignKeysOfDetalleMovimientoInventario(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallemovimientoinventarioLogic.setDetalleMovimientoInventarios(estadodetallemovimientoinventario.detallemovimientoinventarios);
				detallemovimientoinventarioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoDetalleMovimientoInventarioLogicAdditional.updateEstadoDetalleMovimientoInventarioToGet(estadodetallemovimientoinventario,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadodetallemovimientoinventario.setDetalleMovimientoInventarios(estadodetallemovimientoinventarioDataAccess.getDetalleMovimientoInventarios(connexion,estadodetallemovimientoinventario));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodetallemovimientoinventario.setDetalleMovimientoInventarios(estadodetallemovimientoinventarioDataAccess.getDetalleMovimientoInventarios(connexion,estadodetallemovimientoinventario));

				if(this.isConDeep) {
					DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(this.connexion);
					detallemovimientoinventarioLogic.setDetalleMovimientoInventarios(estadodetallemovimientoinventario.getDetalleMovimientoInventarios());
					ArrayList<Classe> classesLocal=DetalleMovimientoInventarioConstantesFunciones.getClassesForeignKeysOfDetalleMovimientoInventario(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallemovimientoinventarioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(detallemovimientoinventarioLogic.getDetalleMovimientoInventarios());
					estadodetallemovimientoinventario.setDetalleMovimientoInventarios(detallemovimientoinventarioLogic.getDetalleMovimientoInventarios());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleMovimientoInventario.class));
			estadodetallemovimientoinventario.setDetalleMovimientoInventarios(estadodetallemovimientoinventarioDataAccess.getDetalleMovimientoInventarios(connexion,estadodetallemovimientoinventario));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadodetallemovimientoinventario.setDetalleMovimientoInventarios(estadodetallemovimientoinventarioDataAccess.getDetalleMovimientoInventarios(connexion,estadodetallemovimientoinventario));

		for(DetalleMovimientoInventario detallemovimientoinventario:estadodetallemovimientoinventario.getDetalleMovimientoInventarios()) {
			DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
			detallemovimientoinventarioLogic.deepLoad(detallemovimientoinventario,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodetallemovimientoinventario.setDetalleMovimientoInventarios(estadodetallemovimientoinventarioDataAccess.getDetalleMovimientoInventarios(connexion,estadodetallemovimientoinventario));

				for(DetalleMovimientoInventario detallemovimientoinventario:estadodetallemovimientoinventario.getDetalleMovimientoInventarios()) {
					DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
					detallemovimientoinventarioLogic.deepLoad(detallemovimientoinventario,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleMovimientoInventario.class));
			estadodetallemovimientoinventario.setDetalleMovimientoInventarios(estadodetallemovimientoinventarioDataAccess.getDetalleMovimientoInventarios(connexion,estadodetallemovimientoinventario));

			for(DetalleMovimientoInventario detallemovimientoinventario:estadodetallemovimientoinventario.getDetalleMovimientoInventarios()) {
				DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
				detallemovimientoinventarioLogic.deepLoad(detallemovimientoinventario,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoDetalleMovimientoInventarioLogicAdditional.updateEstadoDetalleMovimientoInventarioToSave(estadodetallemovimientoinventario,this.arrDatoGeneral);
			
EstadoDetalleMovimientoInventarioDataAccess.save(estadodetallemovimientoinventario, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(DetalleMovimientoInventario detallemovimientoinventario:estadodetallemovimientoinventario.getDetalleMovimientoInventarios()) {
			detallemovimientoinventario.setid_estado_detalle_movimiento_inventario(estadodetallemovimientoinventario.getId());
			DetalleMovimientoInventarioDataAccess.save(detallemovimientoinventario,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleMovimientoInventario detallemovimientoinventario:estadodetallemovimientoinventario.getDetalleMovimientoInventarios()) {
					detallemovimientoinventario.setid_estado_detalle_movimiento_inventario(estadodetallemovimientoinventario.getId());
					DetalleMovimientoInventarioDataAccess.save(detallemovimientoinventario,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(DetalleMovimientoInventario detallemovimientoinventario:estadodetallemovimientoinventario.getDetalleMovimientoInventarios()) {
			DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
			detallemovimientoinventario.setid_estado_detalle_movimiento_inventario(estadodetallemovimientoinventario.getId());
			DetalleMovimientoInventarioDataAccess.save(detallemovimientoinventario,connexion);
			detallemovimientoinventarioLogic.deepSave(detallemovimientoinventario,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleMovimientoInventario detallemovimientoinventario:estadodetallemovimientoinventario.getDetalleMovimientoInventarios()) {
					DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
					detallemovimientoinventario.setid_estado_detalle_movimiento_inventario(estadodetallemovimientoinventario.getId());
					DetalleMovimientoInventarioDataAccess.save(detallemovimientoinventario,connexion);
					detallemovimientoinventarioLogic.deepSave(detallemovimientoinventario,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EstadoDetalleMovimientoInventario.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadodetallemovimientoinventario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(estadodetallemovimientoinventario);
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
			this.deepLoad(this.estadodetallemovimientoinventario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(this.estadodetallemovimientoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoDetalleMovimientoInventario.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadodetallemovimientoinventarios!=null) {
				for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario:estadodetallemovimientoinventarios) {
					this.deepLoad(estadodetallemovimientoinventario,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(estadodetallemovimientoinventarios);
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
			if(estadodetallemovimientoinventarios!=null) {
				for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario:estadodetallemovimientoinventarios) {
					this.deepLoad(estadodetallemovimientoinventario,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleMovimientoInventario(estadodetallemovimientoinventarios);
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
			this.getNewConnexionToDeep(EstadoDetalleMovimientoInventario.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadodetallemovimientoinventario,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoDetalleMovimientoInventario.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadodetallemovimientoinventarios!=null) {
				for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario:estadodetallemovimientoinventarios) {
					this.deepSave(estadodetallemovimientoinventario,isDeep,deepLoadType,clases);
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
			if(estadodetallemovimientoinventarios!=null) {
				for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario:estadodetallemovimientoinventarios) {
					this.deepSave(estadodetallemovimientoinventario,isDeep,deepLoadType,clases);
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
			if(EstadoDetalleMovimientoInventarioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleMovimientoInventarioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoDetalleMovimientoInventario estadodetallemovimientoinventario,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoDetalleMovimientoInventarioConstantesFunciones.ISCONAUDITORIA) {
				if(estadodetallemovimientoinventario.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleMovimientoInventarioDataAccess.TABLENAME, estadodetallemovimientoinventario.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoDetalleMovimientoInventarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoDetalleMovimientoInventarioLogic.registrarAuditoriaDetallesEstadoDetalleMovimientoInventario(connexion,estadodetallemovimientoinventario,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadodetallemovimientoinventario.getIsDeleted()) {
					/*if(!estadodetallemovimientoinventario.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoDetalleMovimientoInventarioDataAccess.TABLENAME, estadodetallemovimientoinventario.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoDetalleMovimientoInventarioLogic.registrarAuditoriaDetallesEstadoDetalleMovimientoInventario(connexion,estadodetallemovimientoinventario,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleMovimientoInventarioDataAccess.TABLENAME, estadodetallemovimientoinventario.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadodetallemovimientoinventario.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleMovimientoInventarioDataAccess.TABLENAME, estadodetallemovimientoinventario.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoDetalleMovimientoInventarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoDetalleMovimientoInventarioLogic.registrarAuditoriaDetallesEstadoDetalleMovimientoInventario(connexion,estadodetallemovimientoinventario,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoDetalleMovimientoInventario(Connexion connexion,EstadoDetalleMovimientoInventario estadodetallemovimientoinventario)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadodetallemovimientoinventario.getIsNew()||!estadodetallemovimientoinventario.getcodigo().equals(estadodetallemovimientoinventario.getEstadoDetalleMovimientoInventarioOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadodetallemovimientoinventario.getEstadoDetalleMovimientoInventarioOriginal().getcodigo()!=null)
				{
					strValorActual=estadodetallemovimientoinventario.getEstadoDetalleMovimientoInventarioOriginal().getcodigo();
				}
				if(estadodetallemovimientoinventario.getcodigo()!=null)
				{
					strValorNuevo=estadodetallemovimientoinventario.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoDetalleMovimientoInventarioConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadodetallemovimientoinventario.getIsNew()||!estadodetallemovimientoinventario.getnombre().equals(estadodetallemovimientoinventario.getEstadoDetalleMovimientoInventarioOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadodetallemovimientoinventario.getEstadoDetalleMovimientoInventarioOriginal().getnombre()!=null)
				{
					strValorActual=estadodetallemovimientoinventario.getEstadoDetalleMovimientoInventarioOriginal().getnombre();
				}
				if(estadodetallemovimientoinventario.getnombre()!=null)
				{
					strValorNuevo=estadodetallemovimientoinventario.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoDetalleMovimientoInventarioConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoDetalleMovimientoInventarioRelacionesWithConnection(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario,List<DetalleMovimientoInventario> detallemovimientoinventarios) throws Exception {

		if(!estadodetallemovimientoinventario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoDetalleMovimientoInventarioRelacionesBase(estadodetallemovimientoinventario,detallemovimientoinventarios,true);
		}
	}

	public void saveEstadoDetalleMovimientoInventarioRelaciones(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario,List<DetalleMovimientoInventario> detallemovimientoinventarios)throws Exception {

		if(!estadodetallemovimientoinventario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoDetalleMovimientoInventarioRelacionesBase(estadodetallemovimientoinventario,detallemovimientoinventarios,false);
		}
	}

	public void saveEstadoDetalleMovimientoInventarioRelacionesBase(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario,List<DetalleMovimientoInventario> detallemovimientoinventarios,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoDetalleMovimientoInventario-saveRelacionesWithConnection");}
	
			estadodetallemovimientoinventario.setDetalleMovimientoInventarios(detallemovimientoinventarios);

			this.setEstadoDetalleMovimientoInventario(estadodetallemovimientoinventario);

				if((estadodetallemovimientoinventario.getIsNew()||estadodetallemovimientoinventario.getIsChanged())&&!estadodetallemovimientoinventario.getIsDeleted()) {
					this.saveEstadoDetalleMovimientoInventario();
					this.saveEstadoDetalleMovimientoInventarioRelacionesDetalles(detallemovimientoinventarios);

				} else if(estadodetallemovimientoinventario.getIsDeleted()) {
					this.saveEstadoDetalleMovimientoInventarioRelacionesDetalles(detallemovimientoinventarios);
					this.saveEstadoDetalleMovimientoInventario();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleMovimientoInventarioConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleMovimientoInventarios(detallemovimientoinventarios,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoDetalleMovimientoInventarioRelacionesDetalles(List<DetalleMovimientoInventario> detallemovimientoinventarios)throws Exception {
		try {
	

			Long idEstadoDetalleMovimientoInventarioActual=this.getEstadoDetalleMovimientoInventario().getId();

			DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic_Desde_EstadoDetalleMovimientoInventario=new DetalleMovimientoInventarioLogic();
			detallemovimientoinventarioLogic_Desde_EstadoDetalleMovimientoInventario.setDetalleMovimientoInventarios(detallemovimientoinventarios);

			detallemovimientoinventarioLogic_Desde_EstadoDetalleMovimientoInventario.setConnexion(this.getConnexion());
			detallemovimientoinventarioLogic_Desde_EstadoDetalleMovimientoInventario.setDatosCliente(this.datosCliente);

			for(DetalleMovimientoInventario detallemovimientoinventario_Desde_EstadoDetalleMovimientoInventario:detallemovimientoinventarioLogic_Desde_EstadoDetalleMovimientoInventario.getDetalleMovimientoInventarios()) {
				detallemovimientoinventario_Desde_EstadoDetalleMovimientoInventario.setid_estado_detalle_movimiento_inventario(idEstadoDetalleMovimientoInventarioActual);

				detallemovimientoinventarioLogic_Desde_EstadoDetalleMovimientoInventario.setDetalleMovimientoInventario(detallemovimientoinventario_Desde_EstadoDetalleMovimientoInventario);
				detallemovimientoinventarioLogic_Desde_EstadoDetalleMovimientoInventario.saveDetalleMovimientoInventario();

				Long idDetalleMovimientoInventarioActual=detallemovimientoinventario_Desde_EstadoDetalleMovimientoInventario.getId();

				NovedadSeguimientoLogic novedadseguimientoLogic_Desde_DetalleMovimientoInventario=new NovedadSeguimientoLogic();

				if(detallemovimientoinventario_Desde_EstadoDetalleMovimientoInventario.getNovedadSeguimientos()==null){
					detallemovimientoinventario_Desde_EstadoDetalleMovimientoInventario.setNovedadSeguimientos(new ArrayList<NovedadSeguimiento>());
				}

				novedadseguimientoLogic_Desde_DetalleMovimientoInventario.setNovedadSeguimientos(detallemovimientoinventario_Desde_EstadoDetalleMovimientoInventario.getNovedadSeguimientos());

				novedadseguimientoLogic_Desde_DetalleMovimientoInventario.setConnexion(this.getConnexion());
				novedadseguimientoLogic_Desde_DetalleMovimientoInventario.setDatosCliente(this.datosCliente);

				for(NovedadSeguimiento novedadseguimiento_Desde_DetalleMovimientoInventario:novedadseguimientoLogic_Desde_DetalleMovimientoInventario.getNovedadSeguimientos()) {
					novedadseguimiento_Desde_DetalleMovimientoInventario.setid_detalle_movimiento_inventario(idDetalleMovimientoInventarioActual);
				}

				novedadseguimientoLogic_Desde_DetalleMovimientoInventario.saveNovedadSeguimientos();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoDetalleMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoDetalleMovimientoInventarioConstantesFunciones.getClassesForeignKeysOfEstadoDetalleMovimientoInventario(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDetalleMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoDetalleMovimientoInventarioConstantesFunciones.getClassesRelationshipsOfEstadoDetalleMovimientoInventario(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

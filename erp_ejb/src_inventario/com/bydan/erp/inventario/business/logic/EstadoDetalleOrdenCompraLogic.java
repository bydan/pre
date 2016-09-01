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
import com.bydan.erp.inventario.util.EstadoDetalleOrdenCompraConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoDetalleOrdenCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoDetalleOrdenCompraParameterGeneral;
import com.bydan.erp.inventario.business.entity.EstadoDetalleOrdenCompra;
import com.bydan.erp.inventario.business.logic.EstadoDetalleOrdenCompraLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class EstadoDetalleOrdenCompraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoDetalleOrdenCompraLogic.class);
	
	protected EstadoDetalleOrdenCompraDataAccess estadodetalleordencompraDataAccess; 	
	protected EstadoDetalleOrdenCompra estadodetalleordencompra;
	protected List<EstadoDetalleOrdenCompra> estadodetalleordencompras;
	protected Object estadodetalleordencompraObject;	
	protected List<Object> estadodetalleordencomprasObject;
	
	public static ClassValidator<EstadoDetalleOrdenCompra> estadodetalleordencompraValidator = new ClassValidator<EstadoDetalleOrdenCompra>(EstadoDetalleOrdenCompra.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoDetalleOrdenCompraLogicAdditional estadodetalleordencompraLogicAdditional=null;
	
	public EstadoDetalleOrdenCompraLogicAdditional getEstadoDetalleOrdenCompraLogicAdditional() {
		return this.estadodetalleordencompraLogicAdditional;
	}
	
	public void setEstadoDetalleOrdenCompraLogicAdditional(EstadoDetalleOrdenCompraLogicAdditional estadodetalleordencompraLogicAdditional) {
		try {
			this.estadodetalleordencompraLogicAdditional=estadodetalleordencompraLogicAdditional;
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
	
	
	
	
	public  EstadoDetalleOrdenCompraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadodetalleordencompraDataAccess = new EstadoDetalleOrdenCompraDataAccess();
			
			this.estadodetalleordencompras= new ArrayList<EstadoDetalleOrdenCompra>();
			this.estadodetalleordencompra= new EstadoDetalleOrdenCompra();
			
			this.estadodetalleordencompraObject=new Object();
			this.estadodetalleordencomprasObject=new ArrayList<Object>();
				
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
			
			this.estadodetalleordencompraDataAccess.setConnexionType(this.connexionType);
			this.estadodetalleordencompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoDetalleOrdenCompraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadodetalleordencompraDataAccess = new EstadoDetalleOrdenCompraDataAccess();
			this.estadodetalleordencompras= new ArrayList<EstadoDetalleOrdenCompra>();
			this.estadodetalleordencompra= new EstadoDetalleOrdenCompra();
			this.estadodetalleordencompraObject=new Object();
			this.estadodetalleordencomprasObject=new ArrayList<Object>();
			
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
			
			this.estadodetalleordencompraDataAccess.setConnexionType(this.connexionType);
			this.estadodetalleordencompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoDetalleOrdenCompra getEstadoDetalleOrdenCompra() throws Exception {	
		EstadoDetalleOrdenCompraLogicAdditional.checkEstadoDetalleOrdenCompraToGet(estadodetalleordencompra,this.datosCliente,this.arrDatoGeneral);
		EstadoDetalleOrdenCompraLogicAdditional.updateEstadoDetalleOrdenCompraToGet(estadodetalleordencompra,this.arrDatoGeneral);
		
		return estadodetalleordencompra;
	}
		
	public void setEstadoDetalleOrdenCompra(EstadoDetalleOrdenCompra newEstadoDetalleOrdenCompra) {
		this.estadodetalleordencompra = newEstadoDetalleOrdenCompra;
	}
	
	public EstadoDetalleOrdenCompraDataAccess getEstadoDetalleOrdenCompraDataAccess() {
		return estadodetalleordencompraDataAccess;
	}
	
	public void setEstadoDetalleOrdenCompraDataAccess(EstadoDetalleOrdenCompraDataAccess newestadodetalleordencompraDataAccess) {
		this.estadodetalleordencompraDataAccess = newestadodetalleordencompraDataAccess;
	}
	
	public List<EstadoDetalleOrdenCompra> getEstadoDetalleOrdenCompras() throws Exception {		
		this.quitarEstadoDetalleOrdenComprasNulos();
		
		EstadoDetalleOrdenCompraLogicAdditional.checkEstadoDetalleOrdenCompraToGets(estadodetalleordencompras,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoDetalleOrdenCompra estadodetalleordencompraLocal: estadodetalleordencompras ) {
			EstadoDetalleOrdenCompraLogicAdditional.updateEstadoDetalleOrdenCompraToGet(estadodetalleordencompraLocal,this.arrDatoGeneral);
		}
		
		return estadodetalleordencompras;
	}
	
	public void setEstadoDetalleOrdenCompras(List<EstadoDetalleOrdenCompra> newEstadoDetalleOrdenCompras) {
		this.estadodetalleordencompras = newEstadoDetalleOrdenCompras;
	}
	
	public Object getEstadoDetalleOrdenCompraObject() {	
		this.estadodetalleordencompraObject=this.estadodetalleordencompraDataAccess.getEntityObject();
		return this.estadodetalleordencompraObject;
	}
		
	public void setEstadoDetalleOrdenCompraObject(Object newEstadoDetalleOrdenCompraObject) {
		this.estadodetalleordencompraObject = newEstadoDetalleOrdenCompraObject;
	}
	
	public List<Object> getEstadoDetalleOrdenComprasObject() {		
		this.estadodetalleordencomprasObject=this.estadodetalleordencompraDataAccess.getEntitiesObject();
		return this.estadodetalleordencomprasObject;
	}
		
	public void setEstadoDetalleOrdenComprasObject(List<Object> newEstadoDetalleOrdenComprasObject) {
		this.estadodetalleordencomprasObject = newEstadoDetalleOrdenComprasObject;
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
		
		if(this.estadodetalleordencompraDataAccess!=null) {
			this.estadodetalleordencompraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleOrdenCompra.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadodetalleordencompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadodetalleordencompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadodetalleordencompra = new  EstadoDetalleOrdenCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleOrdenCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadodetalleordencompra=estadodetalleordencompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetalleordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(this.estadodetalleordencompra);
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
		estadodetalleordencompra = new  EstadoDetalleOrdenCompra();
		  		  
        try {
			
			estadodetalleordencompra=estadodetalleordencompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetalleordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(this.estadodetalleordencompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadodetalleordencompra = new  EstadoDetalleOrdenCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleOrdenCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadodetalleordencompra=estadodetalleordencompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetalleordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(this.estadodetalleordencompra);
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
		estadodetalleordencompra = new  EstadoDetalleOrdenCompra();
		  		  
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
		estadodetalleordencompra = new  EstadoDetalleOrdenCompra();
		  		  
        try {
			
			estadodetalleordencompra=estadodetalleordencompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetalleordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(this.estadodetalleordencompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadodetalleordencompra = new  EstadoDetalleOrdenCompra();
		  		  
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
		estadodetalleordencompra = new  EstadoDetalleOrdenCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleOrdenCompra.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadodetalleordencompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodetalleordencompra = new  EstadoDetalleOrdenCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadodetalleordencompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadodetalleordencompra = new  EstadoDetalleOrdenCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleOrdenCompra.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadodetalleordencompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodetalleordencompra = new  EstadoDetalleOrdenCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadodetalleordencompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadodetalleordencompra = new  EstadoDetalleOrdenCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleOrdenCompra.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadodetalleordencompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodetalleordencompra = new  EstadoDetalleOrdenCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadodetalleordencompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadodetalleordencompras = new  ArrayList<EstadoDetalleOrdenCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleOrdenCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoDetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleordencompras=estadodetalleordencompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleOrdenCompra(estadodetalleordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(this.estadodetalleordencompras);
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
		estadodetalleordencompras = new  ArrayList<EstadoDetalleOrdenCompra>();
		  		  
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
		estadodetalleordencompras = new  ArrayList<EstadoDetalleOrdenCompra>();
		  		  
        try {			
			EstadoDetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleordencompras=estadodetalleordencompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoDetalleOrdenCompra(estadodetalleordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(this.estadodetalleordencompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadodetalleordencompras = new  ArrayList<EstadoDetalleOrdenCompra>();
		  		  
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
		estadodetalleordencompras = new  ArrayList<EstadoDetalleOrdenCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleOrdenCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoDetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleordencompras=estadodetalleordencompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleOrdenCompra(estadodetalleordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(this.estadodetalleordencompras);
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
		estadodetalleordencompras = new  ArrayList<EstadoDetalleOrdenCompra>();
		  		  
        try {
			EstadoDetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleordencompras=estadodetalleordencompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleOrdenCompra(estadodetalleordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(this.estadodetalleordencompras);
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
		estadodetalleordencompras = new  ArrayList<EstadoDetalleOrdenCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleOrdenCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleordencompras=estadodetalleordencompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleOrdenCompra(estadodetalleordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(this.estadodetalleordencompras);
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
		estadodetalleordencompras = new  ArrayList<EstadoDetalleOrdenCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleordencompras=estadodetalleordencompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleOrdenCompra(estadodetalleordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(this.estadodetalleordencompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadodetalleordencompra = new  EstadoDetalleOrdenCompra();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleOrdenCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleordencompra=estadodetalleordencompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleOrdenCompra(estadodetalleordencompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(this.estadodetalleordencompra);
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
		estadodetalleordencompra = new  EstadoDetalleOrdenCompra();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleordencompra=estadodetalleordencompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleOrdenCompra(estadodetalleordencompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(this.estadodetalleordencompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadodetalleordencompras = new  ArrayList<EstadoDetalleOrdenCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleOrdenCompra.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoDetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleordencompras=estadodetalleordencompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleOrdenCompra(estadodetalleordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(this.estadodetalleordencompras);
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
		estadodetalleordencompras = new  ArrayList<EstadoDetalleOrdenCompra>();
		  		  
        try {
			EstadoDetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleordencompras=estadodetalleordencompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleOrdenCompra(estadodetalleordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(this.estadodetalleordencompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoDetalleOrdenComprasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadodetalleordencompras = new  ArrayList<EstadoDetalleOrdenCompra>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleOrdenCompra.class.getSimpleName()+"-getTodosEstadoDetalleOrdenComprasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleordencompras=estadodetalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoDetalleOrdenCompra(estadodetalleordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(this.estadodetalleordencompras);
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
	
	public  void  getTodosEstadoDetalleOrdenCompras(String sFinalQuery,Pagination pagination)throws Exception {
		estadodetalleordencompras = new  ArrayList<EstadoDetalleOrdenCompra>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleordencompras=estadodetalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoDetalleOrdenCompra(estadodetalleordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(this.estadodetalleordencompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoDetalleOrdenCompra(EstadoDetalleOrdenCompra estadodetalleordencompra) throws Exception {
		Boolean estaValidado=false;
		
		if(estadodetalleordencompra.getIsNew() || estadodetalleordencompra.getIsChanged()) { 
			this.invalidValues = estadodetalleordencompraValidator.getInvalidValues(estadodetalleordencompra);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadodetalleordencompra);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoDetalleOrdenCompra(List<EstadoDetalleOrdenCompra> EstadoDetalleOrdenCompras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoDetalleOrdenCompra estadodetalleordencompraLocal:estadodetalleordencompras) {				
			estaValidadoObjeto=this.validarGuardarEstadoDetalleOrdenCompra(estadodetalleordencompraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoDetalleOrdenCompra(List<EstadoDetalleOrdenCompra> EstadoDetalleOrdenCompras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoDetalleOrdenCompra(estadodetalleordencompras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoDetalleOrdenCompra(EstadoDetalleOrdenCompra EstadoDetalleOrdenCompra) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoDetalleOrdenCompra(estadodetalleordencompra)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoDetalleOrdenCompra estadodetalleordencompra) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadodetalleordencompra.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoDetalleOrdenCompraConstantesFunciones.getEstadoDetalleOrdenCompraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadodetalleordencompra","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoDetalleOrdenCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoDetalleOrdenCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoDetalleOrdenCompraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleOrdenCompra.class.getSimpleName()+"-saveEstadoDetalleOrdenCompraWithConnection");connexion.begin();			
			
			EstadoDetalleOrdenCompraLogicAdditional.checkEstadoDetalleOrdenCompraToSave(this.estadodetalleordencompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoDetalleOrdenCompraLogicAdditional.updateEstadoDetalleOrdenCompraToSave(this.estadodetalleordencompra,this.arrDatoGeneral);
			
			EstadoDetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadodetalleordencompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoDetalleOrdenCompra();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoDetalleOrdenCompra(this.estadodetalleordencompra)) {
				EstadoDetalleOrdenCompraDataAccess.save(this.estadodetalleordencompra, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadodetalleordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoDetalleOrdenCompraLogicAdditional.checkEstadoDetalleOrdenCompraToSaveAfter(this.estadodetalleordencompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoDetalleOrdenCompra();
			
			connexion.commit();			
			
			if(this.estadodetalleordencompra.getIsDeleted()) {
				this.estadodetalleordencompra=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoDetalleOrdenCompra()throws Exception {	
		try {	
			
			EstadoDetalleOrdenCompraLogicAdditional.checkEstadoDetalleOrdenCompraToSave(this.estadodetalleordencompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoDetalleOrdenCompraLogicAdditional.updateEstadoDetalleOrdenCompraToSave(this.estadodetalleordencompra,this.arrDatoGeneral);
			
			EstadoDetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadodetalleordencompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoDetalleOrdenCompra(this.estadodetalleordencompra)) {			
				EstadoDetalleOrdenCompraDataAccess.save(this.estadodetalleordencompra, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadodetalleordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoDetalleOrdenCompraLogicAdditional.checkEstadoDetalleOrdenCompraToSaveAfter(this.estadodetalleordencompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadodetalleordencompra.getIsDeleted()) {
				this.estadodetalleordencompra=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoDetalleOrdenComprasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleOrdenCompra.class.getSimpleName()+"-saveEstadoDetalleOrdenComprasWithConnection");connexion.begin();			
			
			EstadoDetalleOrdenCompraLogicAdditional.checkEstadoDetalleOrdenCompraToSaves(estadodetalleordencompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoDetalleOrdenCompras();
			
			Boolean validadoTodosEstadoDetalleOrdenCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoDetalleOrdenCompra estadodetalleordencompraLocal:estadodetalleordencompras) {		
				if(estadodetalleordencompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoDetalleOrdenCompraLogicAdditional.updateEstadoDetalleOrdenCompraToSave(estadodetalleordencompraLocal,this.arrDatoGeneral);
	        	
				EstadoDetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadodetalleordencompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoDetalleOrdenCompra(estadodetalleordencompraLocal)) {
					EstadoDetalleOrdenCompraDataAccess.save(estadodetalleordencompraLocal, connexion);				
				} else {
					validadoTodosEstadoDetalleOrdenCompra=false;
				}
			}
			
			if(!validadoTodosEstadoDetalleOrdenCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoDetalleOrdenCompraLogicAdditional.checkEstadoDetalleOrdenCompraToSavesAfter(estadodetalleordencompras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoDetalleOrdenCompras();
			
			connexion.commit();		
			
			this.quitarEstadoDetalleOrdenComprasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoDetalleOrdenCompras()throws Exception {				
		 try {	
			EstadoDetalleOrdenCompraLogicAdditional.checkEstadoDetalleOrdenCompraToSaves(estadodetalleordencompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoDetalleOrdenCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoDetalleOrdenCompra estadodetalleordencompraLocal:estadodetalleordencompras) {				
				if(estadodetalleordencompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoDetalleOrdenCompraLogicAdditional.updateEstadoDetalleOrdenCompraToSave(estadodetalleordencompraLocal,this.arrDatoGeneral);
	        	
				EstadoDetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadodetalleordencompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoDetalleOrdenCompra(estadodetalleordencompraLocal)) {				
					EstadoDetalleOrdenCompraDataAccess.save(estadodetalleordencompraLocal, connexion);				
				} else {
					validadoTodosEstadoDetalleOrdenCompra=false;
				}
			}
			
			if(!validadoTodosEstadoDetalleOrdenCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoDetalleOrdenCompraLogicAdditional.checkEstadoDetalleOrdenCompraToSavesAfter(estadodetalleordencompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoDetalleOrdenComprasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoDetalleOrdenCompraParameterReturnGeneral procesarAccionEstadoDetalleOrdenCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoDetalleOrdenCompra> estadodetalleordencompras,EstadoDetalleOrdenCompraParameterReturnGeneral estadodetalleordencompraParameterGeneral)throws Exception {
		 try {	
			EstadoDetalleOrdenCompraParameterReturnGeneral estadodetalleordencompraReturnGeneral=new EstadoDetalleOrdenCompraParameterReturnGeneral();
	
			EstadoDetalleOrdenCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadodetalleordencompras,estadodetalleordencompraParameterGeneral,estadodetalleordencompraReturnGeneral);
			
			return estadodetalleordencompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoDetalleOrdenCompraParameterReturnGeneral procesarAccionEstadoDetalleOrdenComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoDetalleOrdenCompra> estadodetalleordencompras,EstadoDetalleOrdenCompraParameterReturnGeneral estadodetalleordencompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleOrdenCompra.class.getSimpleName()+"-procesarAccionEstadoDetalleOrdenComprasWithConnection");connexion.begin();			
			
			EstadoDetalleOrdenCompraParameterReturnGeneral estadodetalleordencompraReturnGeneral=new EstadoDetalleOrdenCompraParameterReturnGeneral();
	
			EstadoDetalleOrdenCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadodetalleordencompras,estadodetalleordencompraParameterGeneral,estadodetalleordencompraReturnGeneral);
			
			this.connexion.commit();
			
			return estadodetalleordencompraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoDetalleOrdenCompraParameterReturnGeneral procesarEventosEstadoDetalleOrdenCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoDetalleOrdenCompra> estadodetalleordencompras,EstadoDetalleOrdenCompra estadodetalleordencompra,EstadoDetalleOrdenCompraParameterReturnGeneral estadodetalleordencompraParameterGeneral,Boolean isEsNuevoEstadoDetalleOrdenCompra,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoDetalleOrdenCompraParameterReturnGeneral estadodetalleordencompraReturnGeneral=new EstadoDetalleOrdenCompraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadodetalleordencompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoDetalleOrdenCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadodetalleordencompras,estadodetalleordencompra,estadodetalleordencompraParameterGeneral,estadodetalleordencompraReturnGeneral,isEsNuevoEstadoDetalleOrdenCompra,clases);
			
			return estadodetalleordencompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoDetalleOrdenCompraParameterReturnGeneral procesarEventosEstadoDetalleOrdenComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoDetalleOrdenCompra> estadodetalleordencompras,EstadoDetalleOrdenCompra estadodetalleordencompra,EstadoDetalleOrdenCompraParameterReturnGeneral estadodetalleordencompraParameterGeneral,Boolean isEsNuevoEstadoDetalleOrdenCompra,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleOrdenCompra.class.getSimpleName()+"-procesarEventosEstadoDetalleOrdenComprasWithConnection");connexion.begin();			
			
			EstadoDetalleOrdenCompraParameterReturnGeneral estadodetalleordencompraReturnGeneral=new EstadoDetalleOrdenCompraParameterReturnGeneral();
	
			estadodetalleordencompraReturnGeneral.setEstadoDetalleOrdenCompra(estadodetalleordencompra);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadodetalleordencompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoDetalleOrdenCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadodetalleordencompras,estadodetalleordencompra,estadodetalleordencompraParameterGeneral,estadodetalleordencompraReturnGeneral,isEsNuevoEstadoDetalleOrdenCompra,clases);
			
			this.connexion.commit();
			
			return estadodetalleordencompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoDetalleOrdenCompraParameterReturnGeneral procesarImportacionEstadoDetalleOrdenComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoDetalleOrdenCompraParameterReturnGeneral estadodetalleordencompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleOrdenCompra.class.getSimpleName()+"-procesarImportacionEstadoDetalleOrdenComprasWithConnection");connexion.begin();			
			
			EstadoDetalleOrdenCompraParameterReturnGeneral estadodetalleordencompraReturnGeneral=new EstadoDetalleOrdenCompraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadodetalleordencompras=new ArrayList<EstadoDetalleOrdenCompra>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadodetalleordencompra=new EstadoDetalleOrdenCompra();
				
				
				if(conColumnasBase) {this.estadodetalleordencompra.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadodetalleordencompra.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadodetalleordencompra.setcodigo(arrColumnas[iColumn++]);
				this.estadodetalleordencompra.setnombre(arrColumnas[iColumn++]);
				
				this.estadodetalleordencompras.add(this.estadodetalleordencompra);
			}
			
			this.saveEstadoDetalleOrdenCompras();
			
			this.connexion.commit();
			
			estadodetalleordencompraReturnGeneral.setConRetornoEstaProcesado(true);
			estadodetalleordencompraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadodetalleordencompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoDetalleOrdenComprasEliminados() throws Exception {				
		
		List<EstadoDetalleOrdenCompra> estadodetalleordencomprasAux= new ArrayList<EstadoDetalleOrdenCompra>();
		
		for(EstadoDetalleOrdenCompra estadodetalleordencompra:estadodetalleordencompras) {
			if(!estadodetalleordencompra.getIsDeleted()) {
				estadodetalleordencomprasAux.add(estadodetalleordencompra);
			}
		}
		
		estadodetalleordencompras=estadodetalleordencomprasAux;
	}
	
	public void quitarEstadoDetalleOrdenComprasNulos() throws Exception {				
		
		List<EstadoDetalleOrdenCompra> estadodetalleordencomprasAux= new ArrayList<EstadoDetalleOrdenCompra>();
		
		for(EstadoDetalleOrdenCompra estadodetalleordencompra : this.estadodetalleordencompras) {
			if(estadodetalleordencompra==null) {
				estadodetalleordencomprasAux.add(estadodetalleordencompra);
			}
		}
		
		//this.estadodetalleordencompras=estadodetalleordencomprasAux;
		
		this.estadodetalleordencompras.removeAll(estadodetalleordencomprasAux);
	}
	
	public void getSetVersionRowEstadoDetalleOrdenCompraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadodetalleordencompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadodetalleordencompra.getIsDeleted() || (estadodetalleordencompra.getIsChanged()&&!estadodetalleordencompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadodetalleordencompraDataAccess.getSetVersionRowEstadoDetalleOrdenCompra(connexion,estadodetalleordencompra.getId());
				
				if(!estadodetalleordencompra.getVersionRow().equals(timestamp)) {	
					estadodetalleordencompra.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadodetalleordencompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoDetalleOrdenCompra()throws Exception {	
		
		if(estadodetalleordencompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadodetalleordencompra.getIsDeleted() || (estadodetalleordencompra.getIsChanged()&&!estadodetalleordencompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadodetalleordencompraDataAccess.getSetVersionRowEstadoDetalleOrdenCompra(connexion,estadodetalleordencompra.getId());
			
			try {							
				if(!estadodetalleordencompra.getVersionRow().equals(timestamp)) {	
					estadodetalleordencompra.setVersionRow(timestamp);
				}
				
				estadodetalleordencompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoDetalleOrdenComprasWithConnection()throws Exception {	
		if(estadodetalleordencompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoDetalleOrdenCompra estadodetalleordencompraAux:estadodetalleordencompras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadodetalleordencompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadodetalleordencompraAux.getIsDeleted() || (estadodetalleordencompraAux.getIsChanged()&&!estadodetalleordencompraAux.getIsNew())) {
						
						timestamp=estadodetalleordencompraDataAccess.getSetVersionRowEstadoDetalleOrdenCompra(connexion,estadodetalleordencompraAux.getId());
						
						if(!estadodetalleordencompra.getVersionRow().equals(timestamp)) {	
							estadodetalleordencompraAux.setVersionRow(timestamp);
						}
								
						estadodetalleordencompraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoDetalleOrdenCompras()throws Exception {	
		if(estadodetalleordencompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoDetalleOrdenCompra estadodetalleordencompraAux:estadodetalleordencompras) {
					if(estadodetalleordencompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadodetalleordencompraAux.getIsDeleted() || (estadodetalleordencompraAux.getIsChanged()&&!estadodetalleordencompraAux.getIsNew())) {
						
						timestamp=estadodetalleordencompraDataAccess.getSetVersionRowEstadoDetalleOrdenCompra(connexion,estadodetalleordencompraAux.getId());
						
						if(!estadodetalleordencompraAux.getVersionRow().equals(timestamp)) {	
							estadodetalleordencompraAux.setVersionRow(timestamp);
						}
						
													
						estadodetalleordencompraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoDetalleOrdenCompraWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleOrdenCompraLogic detalleordencompraLogic=new DetalleOrdenCompraLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleOrdenCompra.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoDetalleOrdenCompraWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleOrdenCompra.class));
											
			

			detalleordencompraLogic.setConnexion(this.getConnexion());
			detalleordencompraLogic.setDatosCliente(this.datosCliente);
			detalleordencompraLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoDetalleOrdenCompra estadodetalleordencompra:this.estadodetalleordencompras) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleOrdenCompraConstantesFunciones.getClassesForeignKeysOfDetalleOrdenCompra(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleordencompraLogic.setDetalleOrdenCompras(estadodetalleordencompra.detalleordencompras);
				detalleordencompraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoDetalleOrdenCompra estadodetalleordencompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoDetalleOrdenCompraLogicAdditional.updateEstadoDetalleOrdenCompraToGet(estadodetalleordencompra,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadodetalleordencompra.setDetalleOrdenCompras(estadodetalleordencompraDataAccess.getDetalleOrdenCompras(connexion,estadodetalleordencompra));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodetalleordencompra.setDetalleOrdenCompras(estadodetalleordencompraDataAccess.getDetalleOrdenCompras(connexion,estadodetalleordencompra));

				if(this.isConDeep) {
					DetalleOrdenCompraLogic detalleordencompraLogic= new DetalleOrdenCompraLogic(this.connexion);
					detalleordencompraLogic.setDetalleOrdenCompras(estadodetalleordencompra.getDetalleOrdenCompras());
					ArrayList<Classe> classesLocal=DetalleOrdenCompraConstantesFunciones.getClassesForeignKeysOfDetalleOrdenCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleordencompraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(detalleordencompraLogic.getDetalleOrdenCompras());
					estadodetalleordencompra.setDetalleOrdenCompras(detalleordencompraLogic.getDetalleOrdenCompras());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleOrdenCompra.class));
			estadodetalleordencompra.setDetalleOrdenCompras(estadodetalleordencompraDataAccess.getDetalleOrdenCompras(connexion,estadodetalleordencompra));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadodetalleordencompra.setDetalleOrdenCompras(estadodetalleordencompraDataAccess.getDetalleOrdenCompras(connexion,estadodetalleordencompra));

		for(DetalleOrdenCompra detalleordencompra:estadodetalleordencompra.getDetalleOrdenCompras()) {
			DetalleOrdenCompraLogic detalleordencompraLogic= new DetalleOrdenCompraLogic(connexion);
			detalleordencompraLogic.deepLoad(detalleordencompra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodetalleordencompra.setDetalleOrdenCompras(estadodetalleordencompraDataAccess.getDetalleOrdenCompras(connexion,estadodetalleordencompra));

				for(DetalleOrdenCompra detalleordencompra:estadodetalleordencompra.getDetalleOrdenCompras()) {
					DetalleOrdenCompraLogic detalleordencompraLogic= new DetalleOrdenCompraLogic(connexion);
					detalleordencompraLogic.deepLoad(detalleordencompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleOrdenCompra.class));
			estadodetalleordencompra.setDetalleOrdenCompras(estadodetalleordencompraDataAccess.getDetalleOrdenCompras(connexion,estadodetalleordencompra));

			for(DetalleOrdenCompra detalleordencompra:estadodetalleordencompra.getDetalleOrdenCompras()) {
				DetalleOrdenCompraLogic detalleordencompraLogic= new DetalleOrdenCompraLogic(connexion);
				detalleordencompraLogic.deepLoad(detalleordencompra,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoDetalleOrdenCompra estadodetalleordencompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoDetalleOrdenCompraLogicAdditional.updateEstadoDetalleOrdenCompraToSave(estadodetalleordencompra,this.arrDatoGeneral);
			
EstadoDetalleOrdenCompraDataAccess.save(estadodetalleordencompra, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(DetalleOrdenCompra detalleordencompra:estadodetalleordencompra.getDetalleOrdenCompras()) {
			detalleordencompra.setid_estado_detalle_orden_compra(estadodetalleordencompra.getId());
			DetalleOrdenCompraDataAccess.save(detalleordencompra,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(DetalleOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleOrdenCompra detalleordencompra:estadodetalleordencompra.getDetalleOrdenCompras()) {
					detalleordencompra.setid_estado_detalle_orden_compra(estadodetalleordencompra.getId());
					DetalleOrdenCompraDataAccess.save(detalleordencompra,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(DetalleOrdenCompra detalleordencompra:estadodetalleordencompra.getDetalleOrdenCompras()) {
			DetalleOrdenCompraLogic detalleordencompraLogic= new DetalleOrdenCompraLogic(connexion);
			detalleordencompra.setid_estado_detalle_orden_compra(estadodetalleordencompra.getId());
			DetalleOrdenCompraDataAccess.save(detalleordencompra,connexion);
			detalleordencompraLogic.deepSave(detalleordencompra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(DetalleOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleOrdenCompra detalleordencompra:estadodetalleordencompra.getDetalleOrdenCompras()) {
					DetalleOrdenCompraLogic detalleordencompraLogic= new DetalleOrdenCompraLogic(connexion);
					detalleordencompra.setid_estado_detalle_orden_compra(estadodetalleordencompra.getId());
					DetalleOrdenCompraDataAccess.save(detalleordencompra,connexion);
					detalleordencompraLogic.deepSave(detalleordencompra,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EstadoDetalleOrdenCompra.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadodetalleordencompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoDetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(estadodetalleordencompra);
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
			this.deepLoad(this.estadodetalleordencompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoDetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(this.estadodetalleordencompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoDetalleOrdenCompra.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadodetalleordencompras!=null) {
				for(EstadoDetalleOrdenCompra estadodetalleordencompra:estadodetalleordencompras) {
					this.deepLoad(estadodetalleordencompra,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoDetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(estadodetalleordencompras);
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
			if(estadodetalleordencompras!=null) {
				for(EstadoDetalleOrdenCompra estadodetalleordencompra:estadodetalleordencompras) {
					this.deepLoad(estadodetalleordencompra,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoDetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleOrdenCompra(estadodetalleordencompras);
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
			this.getNewConnexionToDeep(EstadoDetalleOrdenCompra.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadodetalleordencompra,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoDetalleOrdenCompra.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadodetalleordencompras!=null) {
				for(EstadoDetalleOrdenCompra estadodetalleordencompra:estadodetalleordencompras) {
					this.deepSave(estadodetalleordencompra,isDeep,deepLoadType,clases);
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
			if(estadodetalleordencompras!=null) {
				for(EstadoDetalleOrdenCompra estadodetalleordencompra:estadodetalleordencompras) {
					this.deepSave(estadodetalleordencompra,isDeep,deepLoadType,clases);
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
			if(EstadoDetalleOrdenCompraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleOrdenCompraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoDetalleOrdenCompra estadodetalleordencompra,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoDetalleOrdenCompraConstantesFunciones.ISCONAUDITORIA) {
				if(estadodetalleordencompra.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleOrdenCompraDataAccess.TABLENAME, estadodetalleordencompra.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoDetalleOrdenCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoDetalleOrdenCompraLogic.registrarAuditoriaDetallesEstadoDetalleOrdenCompra(connexion,estadodetalleordencompra,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadodetalleordencompra.getIsDeleted()) {
					/*if(!estadodetalleordencompra.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoDetalleOrdenCompraDataAccess.TABLENAME, estadodetalleordencompra.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoDetalleOrdenCompraLogic.registrarAuditoriaDetallesEstadoDetalleOrdenCompra(connexion,estadodetalleordencompra,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleOrdenCompraDataAccess.TABLENAME, estadodetalleordencompra.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadodetalleordencompra.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleOrdenCompraDataAccess.TABLENAME, estadodetalleordencompra.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoDetalleOrdenCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoDetalleOrdenCompraLogic.registrarAuditoriaDetallesEstadoDetalleOrdenCompra(connexion,estadodetalleordencompra,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoDetalleOrdenCompra(Connexion connexion,EstadoDetalleOrdenCompra estadodetalleordencompra)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadodetalleordencompra.getIsNew()||!estadodetalleordencompra.getcodigo().equals(estadodetalleordencompra.getEstadoDetalleOrdenCompraOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadodetalleordencompra.getEstadoDetalleOrdenCompraOriginal().getcodigo()!=null)
				{
					strValorActual=estadodetalleordencompra.getEstadoDetalleOrdenCompraOriginal().getcodigo();
				}
				if(estadodetalleordencompra.getcodigo()!=null)
				{
					strValorNuevo=estadodetalleordencompra.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoDetalleOrdenCompraConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadodetalleordencompra.getIsNew()||!estadodetalleordencompra.getnombre().equals(estadodetalleordencompra.getEstadoDetalleOrdenCompraOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadodetalleordencompra.getEstadoDetalleOrdenCompraOriginal().getnombre()!=null)
				{
					strValorActual=estadodetalleordencompra.getEstadoDetalleOrdenCompraOriginal().getnombre();
				}
				if(estadodetalleordencompra.getnombre()!=null)
				{
					strValorNuevo=estadodetalleordencompra.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoDetalleOrdenCompraConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoDetalleOrdenCompraRelacionesWithConnection(EstadoDetalleOrdenCompra estadodetalleordencompra,List<DetalleOrdenCompra> detalleordencompras) throws Exception {

		if(!estadodetalleordencompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoDetalleOrdenCompraRelacionesBase(estadodetalleordencompra,detalleordencompras,true);
		}
	}

	public void saveEstadoDetalleOrdenCompraRelaciones(EstadoDetalleOrdenCompra estadodetalleordencompra,List<DetalleOrdenCompra> detalleordencompras)throws Exception {

		if(!estadodetalleordencompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoDetalleOrdenCompraRelacionesBase(estadodetalleordencompra,detalleordencompras,false);
		}
	}

	public void saveEstadoDetalleOrdenCompraRelacionesBase(EstadoDetalleOrdenCompra estadodetalleordencompra,List<DetalleOrdenCompra> detalleordencompras,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoDetalleOrdenCompra-saveRelacionesWithConnection");}
	
			estadodetalleordencompra.setDetalleOrdenCompras(detalleordencompras);

			this.setEstadoDetalleOrdenCompra(estadodetalleordencompra);

				if((estadodetalleordencompra.getIsNew()||estadodetalleordencompra.getIsChanged())&&!estadodetalleordencompra.getIsDeleted()) {
					this.saveEstadoDetalleOrdenCompra();
					this.saveEstadoDetalleOrdenCompraRelacionesDetalles(detalleordencompras);

				} else if(estadodetalleordencompra.getIsDeleted()) {
					this.saveEstadoDetalleOrdenCompraRelacionesDetalles(detalleordencompras);
					this.saveEstadoDetalleOrdenCompra();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleOrdenCompraConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleOrdenCompras(detalleordencompras,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoDetalleOrdenCompraRelacionesDetalles(List<DetalleOrdenCompra> detalleordencompras)throws Exception {
		try {
	

			Long idEstadoDetalleOrdenCompraActual=this.getEstadoDetalleOrdenCompra().getId();

			DetalleOrdenCompraLogic detalleordencompraLogic_Desde_EstadoDetalleOrdenCompra=new DetalleOrdenCompraLogic();
			detalleordencompraLogic_Desde_EstadoDetalleOrdenCompra.setDetalleOrdenCompras(detalleordencompras);

			detalleordencompraLogic_Desde_EstadoDetalleOrdenCompra.setConnexion(this.getConnexion());
			detalleordencompraLogic_Desde_EstadoDetalleOrdenCompra.setDatosCliente(this.datosCliente);

			for(DetalleOrdenCompra detalleordencompra_Desde_EstadoDetalleOrdenCompra:detalleordencompraLogic_Desde_EstadoDetalleOrdenCompra.getDetalleOrdenCompras()) {
				detalleordencompra_Desde_EstadoDetalleOrdenCompra.setid_estado_detalle_orden_compra(idEstadoDetalleOrdenCompraActual);
			}

			detalleordencompraLogic_Desde_EstadoDetalleOrdenCompra.saveDetalleOrdenCompras();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoDetalleOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoDetalleOrdenCompraConstantesFunciones.getClassesForeignKeysOfEstadoDetalleOrdenCompra(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDetalleOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoDetalleOrdenCompraConstantesFunciones.getClassesRelationshipsOfEstadoDetalleOrdenCompra(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.util.EstadoDetallePedidoConstantesFunciones;
import com.bydan.erp.facturacion.util.EstadoDetallePedidoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.EstadoDetallePedidoParameterGeneral;
import com.bydan.erp.facturacion.business.entity.EstadoDetallePedido;
//import com.bydan.erp.facturacion.business.logic.EstadoDetallePedidoLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.inventario.util.*;


import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class EstadoDetallePedidoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoDetallePedidoLogic.class);
	
	protected EstadoDetallePedidoDataAccess estadodetallepedidoDataAccess; 	
	protected EstadoDetallePedido estadodetallepedido;
	protected List<EstadoDetallePedido> estadodetallepedidos;
	protected Object estadodetallepedidoObject;	
	protected List<Object> estadodetallepedidosObject;
	
	public static ClassValidator<EstadoDetallePedido> estadodetallepedidoValidator = new ClassValidator<EstadoDetallePedido>(EstadoDetallePedido.class);	
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
	
	
	
	
	public  EstadoDetallePedidoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadodetallepedidoDataAccess = new EstadoDetallePedidoDataAccess();
			
			this.estadodetallepedidos= new ArrayList<EstadoDetallePedido>();
			this.estadodetallepedido= new EstadoDetallePedido();
			
			this.estadodetallepedidoObject=new Object();
			this.estadodetallepedidosObject=new ArrayList<Object>();
				
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
			
			this.estadodetallepedidoDataAccess.setConnexionType(this.connexionType);
			this.estadodetallepedidoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoDetallePedidoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadodetallepedidoDataAccess = new EstadoDetallePedidoDataAccess();
			this.estadodetallepedidos= new ArrayList<EstadoDetallePedido>();
			this.estadodetallepedido= new EstadoDetallePedido();
			this.estadodetallepedidoObject=new Object();
			this.estadodetallepedidosObject=new ArrayList<Object>();
			
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
			
			this.estadodetallepedidoDataAccess.setConnexionType(this.connexionType);
			this.estadodetallepedidoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoDetallePedido getEstadoDetallePedido() throws Exception {	
		//EstadoDetallePedidoLogicAdditional.checkEstadoDetallePedidoToGet(estadodetallepedido,this.datosCliente,this.arrDatoGeneral);
		//EstadoDetallePedidoLogicAdditional.updateEstadoDetallePedidoToGet(estadodetallepedido,this.arrDatoGeneral);
		
		return estadodetallepedido;
	}
		
	public void setEstadoDetallePedido(EstadoDetallePedido newEstadoDetallePedido) {
		this.estadodetallepedido = newEstadoDetallePedido;
	}
	
	public EstadoDetallePedidoDataAccess getEstadoDetallePedidoDataAccess() {
		return estadodetallepedidoDataAccess;
	}
	
	public void setEstadoDetallePedidoDataAccess(EstadoDetallePedidoDataAccess newestadodetallepedidoDataAccess) {
		this.estadodetallepedidoDataAccess = newestadodetallepedidoDataAccess;
	}
	
	public List<EstadoDetallePedido> getEstadoDetallePedidos() throws Exception {		
		this.quitarEstadoDetallePedidosNulos();
		
		//EstadoDetallePedidoLogicAdditional.checkEstadoDetallePedidoToGets(estadodetallepedidos,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoDetallePedido estadodetallepedidoLocal: estadodetallepedidos ) {
			//EstadoDetallePedidoLogicAdditional.updateEstadoDetallePedidoToGet(estadodetallepedidoLocal,this.arrDatoGeneral);
		}
		
		return estadodetallepedidos;
	}
	
	public void setEstadoDetallePedidos(List<EstadoDetallePedido> newEstadoDetallePedidos) {
		this.estadodetallepedidos = newEstadoDetallePedidos;
	}
	
	public Object getEstadoDetallePedidoObject() {	
		this.estadodetallepedidoObject=this.estadodetallepedidoDataAccess.getEntityObject();
		return this.estadodetallepedidoObject;
	}
		
	public void setEstadoDetallePedidoObject(Object newEstadoDetallePedidoObject) {
		this.estadodetallepedidoObject = newEstadoDetallePedidoObject;
	}
	
	public List<Object> getEstadoDetallePedidosObject() {		
		this.estadodetallepedidosObject=this.estadodetallepedidoDataAccess.getEntitiesObject();
		return this.estadodetallepedidosObject;
	}
		
	public void setEstadoDetallePedidosObject(List<Object> newEstadoDetallePedidosObject) {
		this.estadodetallepedidosObject = newEstadoDetallePedidosObject;
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
		
		if(this.estadodetallepedidoDataAccess!=null) {
			this.estadodetallepedidoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetallePedido.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadodetallepedidoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadodetallepedidoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadodetallepedido = new  EstadoDetallePedido();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetallePedido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadodetallepedido=estadodetallepedidoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetallepedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetallePedido(this.estadodetallepedido);
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
		estadodetallepedido = new  EstadoDetallePedido();
		  		  
        try {
			
			estadodetallepedido=estadodetallepedidoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetallepedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetallePedido(this.estadodetallepedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadodetallepedido = new  EstadoDetallePedido();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetallePedido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadodetallepedido=estadodetallepedidoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetallepedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetallePedido(this.estadodetallepedido);
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
		estadodetallepedido = new  EstadoDetallePedido();
		  		  
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
		estadodetallepedido = new  EstadoDetallePedido();
		  		  
        try {
			
			estadodetallepedido=estadodetallepedidoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetallepedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetallePedido(this.estadodetallepedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadodetallepedido = new  EstadoDetallePedido();
		  		  
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
		estadodetallepedido = new  EstadoDetallePedido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetallePedido.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadodetallepedidoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodetallepedido = new  EstadoDetallePedido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadodetallepedidoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadodetallepedido = new  EstadoDetallePedido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetallePedido.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadodetallepedidoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodetallepedido = new  EstadoDetallePedido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadodetallepedidoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadodetallepedido = new  EstadoDetallePedido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetallePedido.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadodetallepedidoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodetallepedido = new  EstadoDetallePedido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadodetallepedidoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadodetallepedidos = new  ArrayList<EstadoDetallePedido>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetallePedido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoDetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallepedidos=estadodetallepedidoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetallePedido(estadodetallepedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetallePedido(this.estadodetallepedidos);
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
		estadodetallepedidos = new  ArrayList<EstadoDetallePedido>();
		  		  
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
		estadodetallepedidos = new  ArrayList<EstadoDetallePedido>();
		  		  
        try {			
			EstadoDetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallepedidos=estadodetallepedidoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoDetallePedido(estadodetallepedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetallePedido(this.estadodetallepedidos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadodetallepedidos = new  ArrayList<EstadoDetallePedido>();
		  		  
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
		estadodetallepedidos = new  ArrayList<EstadoDetallePedido>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetallePedido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoDetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallepedidos=estadodetallepedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetallePedido(estadodetallepedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetallePedido(this.estadodetallepedidos);
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
		estadodetallepedidos = new  ArrayList<EstadoDetallePedido>();
		  		  
        try {
			EstadoDetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallepedidos=estadodetallepedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetallePedido(estadodetallepedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetallePedido(this.estadodetallepedidos);
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
		estadodetallepedidos = new  ArrayList<EstadoDetallePedido>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetallePedido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallepedidos=estadodetallepedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetallePedido(estadodetallepedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetallePedido(this.estadodetallepedidos);
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
		estadodetallepedidos = new  ArrayList<EstadoDetallePedido>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallepedidos=estadodetallepedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetallePedido(estadodetallepedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetallePedido(this.estadodetallepedidos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadodetallepedido = new  EstadoDetallePedido();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetallePedido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallepedido=estadodetallepedidoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetallePedido(estadodetallepedido);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetallePedido(this.estadodetallepedido);
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
		estadodetallepedido = new  EstadoDetallePedido();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallepedido=estadodetallepedidoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetallePedido(estadodetallepedido);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetallePedido(this.estadodetallepedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosEstadoDetallePedidosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadodetallepedidos = new  ArrayList<EstadoDetallePedido>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetallePedido.class.getSimpleName()+"-getTodosEstadoDetallePedidosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallepedidos=estadodetallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoDetallePedido(estadodetallepedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetallePedido(this.estadodetallepedidos);
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
	
	public  void  getTodosEstadoDetallePedidos(String sFinalQuery,Pagination pagination)throws Exception {
		estadodetallepedidos = new  ArrayList<EstadoDetallePedido>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallepedidos=estadodetallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoDetallePedido(estadodetallepedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetallePedido(this.estadodetallepedidos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoDetallePedido(EstadoDetallePedido estadodetallepedido) throws Exception {
		Boolean estaValidado=false;
		
		if(estadodetallepedido.getIsNew() || estadodetallepedido.getIsChanged()) { 
			this.invalidValues = estadodetallepedidoValidator.getInvalidValues(estadodetallepedido);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadodetallepedido);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoDetallePedido(List<EstadoDetallePedido> EstadoDetallePedidos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoDetallePedido estadodetallepedidoLocal:estadodetallepedidos) {				
			estaValidadoObjeto=this.validarGuardarEstadoDetallePedido(estadodetallepedidoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoDetallePedido(List<EstadoDetallePedido> EstadoDetallePedidos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoDetallePedido(estadodetallepedidos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoDetallePedido(EstadoDetallePedido EstadoDetallePedido) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoDetallePedido(estadodetallepedido)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoDetallePedido estadodetallepedido) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadodetallepedido.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoDetallePedidoConstantesFunciones.getEstadoDetallePedidoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadodetallepedido","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoDetallePedidoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoDetallePedidoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoDetallePedidoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetallePedido.class.getSimpleName()+"-saveEstadoDetallePedidoWithConnection");connexion.begin();			
			
			//EstadoDetallePedidoLogicAdditional.checkEstadoDetallePedidoToSave(this.estadodetallepedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoDetallePedidoLogicAdditional.updateEstadoDetallePedidoToSave(this.estadodetallepedido,this.arrDatoGeneral);
			
			EstadoDetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadodetallepedido,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoDetallePedido();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoDetallePedido(this.estadodetallepedido)) {
				EstadoDetallePedidoDataAccess.save(this.estadodetallepedido, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadodetallepedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoDetallePedidoLogicAdditional.checkEstadoDetallePedidoToSaveAfter(this.estadodetallepedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoDetallePedido();
			
			connexion.commit();			
			
			if(this.estadodetallepedido.getIsDeleted()) {
				this.estadodetallepedido=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoDetallePedido()throws Exception {	
		try {	
			
			//EstadoDetallePedidoLogicAdditional.checkEstadoDetallePedidoToSave(this.estadodetallepedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoDetallePedidoLogicAdditional.updateEstadoDetallePedidoToSave(this.estadodetallepedido,this.arrDatoGeneral);
			
			EstadoDetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadodetallepedido,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoDetallePedido(this.estadodetallepedido)) {			
				EstadoDetallePedidoDataAccess.save(this.estadodetallepedido, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadodetallepedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoDetallePedidoLogicAdditional.checkEstadoDetallePedidoToSaveAfter(this.estadodetallepedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadodetallepedido.getIsDeleted()) {
				this.estadodetallepedido=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoDetallePedidosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetallePedido.class.getSimpleName()+"-saveEstadoDetallePedidosWithConnection");connexion.begin();			
			
			//EstadoDetallePedidoLogicAdditional.checkEstadoDetallePedidoToSaves(estadodetallepedidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoDetallePedidos();
			
			Boolean validadoTodosEstadoDetallePedido=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoDetallePedido estadodetallepedidoLocal:estadodetallepedidos) {		
				if(estadodetallepedidoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoDetallePedidoLogicAdditional.updateEstadoDetallePedidoToSave(estadodetallepedidoLocal,this.arrDatoGeneral);
	        	
				EstadoDetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadodetallepedidoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoDetallePedido(estadodetallepedidoLocal)) {
					EstadoDetallePedidoDataAccess.save(estadodetallepedidoLocal, connexion);				
				} else {
					validadoTodosEstadoDetallePedido=false;
				}
			}
			
			if(!validadoTodosEstadoDetallePedido) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoDetallePedidoLogicAdditional.checkEstadoDetallePedidoToSavesAfter(estadodetallepedidos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoDetallePedidos();
			
			connexion.commit();		
			
			this.quitarEstadoDetallePedidosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoDetallePedidos()throws Exception {				
		 try {	
			//EstadoDetallePedidoLogicAdditional.checkEstadoDetallePedidoToSaves(estadodetallepedidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoDetallePedido=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoDetallePedido estadodetallepedidoLocal:estadodetallepedidos) {				
				if(estadodetallepedidoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoDetallePedidoLogicAdditional.updateEstadoDetallePedidoToSave(estadodetallepedidoLocal,this.arrDatoGeneral);
	        	
				EstadoDetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadodetallepedidoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoDetallePedido(estadodetallepedidoLocal)) {				
					EstadoDetallePedidoDataAccess.save(estadodetallepedidoLocal, connexion);				
				} else {
					validadoTodosEstadoDetallePedido=false;
				}
			}
			
			if(!validadoTodosEstadoDetallePedido) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoDetallePedidoLogicAdditional.checkEstadoDetallePedidoToSavesAfter(estadodetallepedidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoDetallePedidosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoDetallePedidoParameterReturnGeneral procesarAccionEstadoDetallePedidos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoDetallePedido> estadodetallepedidos,EstadoDetallePedidoParameterReturnGeneral estadodetallepedidoParameterGeneral)throws Exception {
		 try {	
			EstadoDetallePedidoParameterReturnGeneral estadodetallepedidoReturnGeneral=new EstadoDetallePedidoParameterReturnGeneral();
	
			
			return estadodetallepedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoDetallePedidoParameterReturnGeneral procesarAccionEstadoDetallePedidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoDetallePedido> estadodetallepedidos,EstadoDetallePedidoParameterReturnGeneral estadodetallepedidoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetallePedido.class.getSimpleName()+"-procesarAccionEstadoDetallePedidosWithConnection");connexion.begin();			
			
			EstadoDetallePedidoParameterReturnGeneral estadodetallepedidoReturnGeneral=new EstadoDetallePedidoParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return estadodetallepedidoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoDetallePedidoParameterReturnGeneral procesarEventosEstadoDetallePedidos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoDetallePedido> estadodetallepedidos,EstadoDetallePedido estadodetallepedido,EstadoDetallePedidoParameterReturnGeneral estadodetallepedidoParameterGeneral,Boolean isEsNuevoEstadoDetallePedido,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoDetallePedidoParameterReturnGeneral estadodetallepedidoReturnGeneral=new EstadoDetallePedidoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadodetallepedidoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return estadodetallepedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoDetallePedidoParameterReturnGeneral procesarEventosEstadoDetallePedidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoDetallePedido> estadodetallepedidos,EstadoDetallePedido estadodetallepedido,EstadoDetallePedidoParameterReturnGeneral estadodetallepedidoParameterGeneral,Boolean isEsNuevoEstadoDetallePedido,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetallePedido.class.getSimpleName()+"-procesarEventosEstadoDetallePedidosWithConnection");connexion.begin();			
			
			EstadoDetallePedidoParameterReturnGeneral estadodetallepedidoReturnGeneral=new EstadoDetallePedidoParameterReturnGeneral();
	
			estadodetallepedidoReturnGeneral.setEstadoDetallePedido(estadodetallepedido);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadodetallepedidoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return estadodetallepedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoDetallePedidoParameterReturnGeneral procesarImportacionEstadoDetallePedidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoDetallePedidoParameterReturnGeneral estadodetallepedidoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetallePedido.class.getSimpleName()+"-procesarImportacionEstadoDetallePedidosWithConnection");connexion.begin();			
			
			EstadoDetallePedidoParameterReturnGeneral estadodetallepedidoReturnGeneral=new EstadoDetallePedidoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadodetallepedidos=new ArrayList<EstadoDetallePedido>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadodetallepedido=new EstadoDetallePedido();
				
				
				if(conColumnasBase) {this.estadodetallepedido.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadodetallepedido.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadodetallepedido.setcodigo(arrColumnas[iColumn++]);
				this.estadodetallepedido.setnombre(arrColumnas[iColumn++]);
				
				this.estadodetallepedidos.add(this.estadodetallepedido);
			}
			
			this.saveEstadoDetallePedidos();
			
			this.connexion.commit();
			
			estadodetallepedidoReturnGeneral.setConRetornoEstaProcesado(true);
			estadodetallepedidoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadodetallepedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoDetallePedidosEliminados() throws Exception {				
		
		List<EstadoDetallePedido> estadodetallepedidosAux= new ArrayList<EstadoDetallePedido>();
		
		for(EstadoDetallePedido estadodetallepedido:estadodetallepedidos) {
			if(!estadodetallepedido.getIsDeleted()) {
				estadodetallepedidosAux.add(estadodetallepedido);
			}
		}
		
		estadodetallepedidos=estadodetallepedidosAux;
	}
	
	public void quitarEstadoDetallePedidosNulos() throws Exception {				
		
		List<EstadoDetallePedido> estadodetallepedidosAux= new ArrayList<EstadoDetallePedido>();
		
		for(EstadoDetallePedido estadodetallepedido : this.estadodetallepedidos) {
			if(estadodetallepedido==null) {
				estadodetallepedidosAux.add(estadodetallepedido);
			}
		}
		
		//this.estadodetallepedidos=estadodetallepedidosAux;
		
		this.estadodetallepedidos.removeAll(estadodetallepedidosAux);
	}
	
	public void getSetVersionRowEstadoDetallePedidoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadodetallepedido.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadodetallepedido.getIsDeleted() || (estadodetallepedido.getIsChanged()&&!estadodetallepedido.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadodetallepedidoDataAccess.getSetVersionRowEstadoDetallePedido(connexion,estadodetallepedido.getId());
				
				if(!estadodetallepedido.getVersionRow().equals(timestamp)) {	
					estadodetallepedido.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadodetallepedido.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoDetallePedido()throws Exception {	
		
		if(estadodetallepedido.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadodetallepedido.getIsDeleted() || (estadodetallepedido.getIsChanged()&&!estadodetallepedido.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadodetallepedidoDataAccess.getSetVersionRowEstadoDetallePedido(connexion,estadodetallepedido.getId());
			
			try {							
				if(!estadodetallepedido.getVersionRow().equals(timestamp)) {	
					estadodetallepedido.setVersionRow(timestamp);
				}
				
				estadodetallepedido.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoDetallePedidosWithConnection()throws Exception {	
		if(estadodetallepedidos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoDetallePedido estadodetallepedidoAux:estadodetallepedidos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadodetallepedidoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadodetallepedidoAux.getIsDeleted() || (estadodetallepedidoAux.getIsChanged()&&!estadodetallepedidoAux.getIsNew())) {
						
						timestamp=estadodetallepedidoDataAccess.getSetVersionRowEstadoDetallePedido(connexion,estadodetallepedidoAux.getId());
						
						if(!estadodetallepedido.getVersionRow().equals(timestamp)) {	
							estadodetallepedidoAux.setVersionRow(timestamp);
						}
								
						estadodetallepedidoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoDetallePedidos()throws Exception {	
		if(estadodetallepedidos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoDetallePedido estadodetallepedidoAux:estadodetallepedidos) {
					if(estadodetallepedidoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadodetallepedidoAux.getIsDeleted() || (estadodetallepedidoAux.getIsChanged()&&!estadodetallepedidoAux.getIsNew())) {
						
						timestamp=estadodetallepedidoDataAccess.getSetVersionRowEstadoDetallePedido(connexion,estadodetallepedidoAux.getId());
						
						if(!estadodetallepedidoAux.getVersionRow().equals(timestamp)) {	
							estadodetallepedidoAux.setVersionRow(timestamp);
						}
						
													
						estadodetallepedidoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoDetallePedidoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleConsignacionLogic detalleconsignacionLogic=new DetalleConsignacionLogic();
			DetallePedidoExporLogic detallepedidoexporLogic=new DetallePedidoExporLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetallePedido.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoDetallePedidoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleConsignacion.class));
			classes.add(new Classe(DetallePedidoExpor.class));
											
			

			detalleconsignacionLogic.setConnexion(this.getConnexion());
			detalleconsignacionLogic.setDatosCliente(this.datosCliente);
			detalleconsignacionLogic.setIsConRefrescarForeignKeys(true);

			detallepedidoexporLogic.setConnexion(this.getConnexion());
			detallepedidoexporLogic.setDatosCliente(this.datosCliente);
			detallepedidoexporLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoDetallePedido estadodetallepedido:this.estadodetallepedidos) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleConsignacionConstantesFunciones.getClassesForeignKeysOfDetalleConsignacion(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleconsignacionLogic.setDetalleConsignacions(estadodetallepedido.detalleconsignacions);
				detalleconsignacionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetallePedidoExporConstantesFunciones.getClassesForeignKeysOfDetallePedidoExpor(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallepedidoexporLogic.setDetallePedidoExpors(estadodetallepedido.detallepedidoexporExpors);
				detallepedidoexporLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoDetallePedido estadodetallepedido,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//EstadoDetallePedidoLogicAdditional.updateEstadoDetallePedidoToGet(estadodetallepedido,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadodetallepedido.setDetalleConsignacions(estadodetallepedidoDataAccess.getDetalleConsignacions(connexion,estadodetallepedido));
		estadodetallepedido.setDetallePedidoExporExpors(estadodetallepedidoDataAccess.getDetallePedidoExporExpors(connexion,estadodetallepedido));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleConsignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodetallepedido.setDetalleConsignacions(estadodetallepedidoDataAccess.getDetalleConsignacions(connexion,estadodetallepedido));

				if(this.isConDeep) {
					DetalleConsignacionLogic detalleconsignacionLogic= new DetalleConsignacionLogic(this.connexion);
					detalleconsignacionLogic.setDetalleConsignacions(estadodetallepedido.getDetalleConsignacions());
					ArrayList<Classe> classesLocal=DetalleConsignacionConstantesFunciones.getClassesForeignKeysOfDetalleConsignacion(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleconsignacionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(detalleconsignacionLogic.getDetalleConsignacions());
					estadodetallepedido.setDetalleConsignacions(detalleconsignacionLogic.getDetalleConsignacions());
				}

				continue;
			}

			if(clas.clas.equals(DetallePedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodetallepedido.setDetallePedidoExporExpors(estadodetallepedidoDataAccess.getDetallePedidoExporExpors(connexion,estadodetallepedido));

				if(this.isConDeep) {
					DetallePedidoExporLogic detallepedidoexporLogic= new DetallePedidoExporLogic(this.connexion);
					detallepedidoexporLogic.setDetallePedidoExpors(estadodetallepedido.getDetallePedidoExporExpors());
					ArrayList<Classe> classesLocal=DetallePedidoExporConstantesFunciones.getClassesForeignKeysOfDetallePedidoExpor(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallepedidoexporLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(detallepedidoexporLogic.getDetallePedidoExpors());
					estadodetallepedido.setDetallePedidoExporExpors(detallepedidoexporLogic.getDetallePedidoExpors());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleConsignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleConsignacion.class));
			estadodetallepedido.setDetalleConsignacions(estadodetallepedidoDataAccess.getDetalleConsignacions(connexion,estadodetallepedido));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetallePedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetallePedidoExpor.class));
			estadodetallepedido.setDetallePedidoExporExpors(estadodetallepedidoDataAccess.getDetallePedidoExporExpors(connexion,estadodetallepedido));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadodetallepedido.setDetalleConsignacions(estadodetallepedidoDataAccess.getDetalleConsignacions(connexion,estadodetallepedido));

		for(DetalleConsignacion detalleconsignacion:estadodetallepedido.getDetalleConsignacions()) {
			DetalleConsignacionLogic detalleconsignacionLogic= new DetalleConsignacionLogic(connexion);
			detalleconsignacionLogic.deepLoad(detalleconsignacion,isDeep,deepLoadType,clases);
		}

		estadodetallepedido.setDetallePedidoExporExpors(estadodetallepedidoDataAccess.getDetallePedidoExporExpors(connexion,estadodetallepedido));

		for(DetallePedidoExpor detallepedidoexpor:estadodetallepedido.getDetallePedidoExporExpors()) {
			DetallePedidoExporLogic detallepedidoexporLogic= new DetallePedidoExporLogic(connexion);
			detallepedidoexporLogic.deepLoad(detallepedidoexpor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleConsignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodetallepedido.setDetalleConsignacions(estadodetallepedidoDataAccess.getDetalleConsignacions(connexion,estadodetallepedido));

				for(DetalleConsignacion detalleconsignacion:estadodetallepedido.getDetalleConsignacions()) {
					DetalleConsignacionLogic detalleconsignacionLogic= new DetalleConsignacionLogic(connexion);
					detalleconsignacionLogic.deepLoad(detalleconsignacion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetallePedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodetallepedido.setDetallePedidoExporExpors(estadodetallepedidoDataAccess.getDetallePedidoExporExpors(connexion,estadodetallepedido));

				for(DetallePedidoExpor detallepedidoexpor:estadodetallepedido.getDetallePedidoExporExpors()) {
					DetallePedidoExporLogic detallepedidoexporLogic= new DetallePedidoExporLogic(connexion);
					detallepedidoexporLogic.deepLoad(detallepedidoexpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleConsignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleConsignacion.class));
			estadodetallepedido.setDetalleConsignacions(estadodetallepedidoDataAccess.getDetalleConsignacions(connexion,estadodetallepedido));

			for(DetalleConsignacion detalleconsignacion:estadodetallepedido.getDetalleConsignacions()) {
				DetalleConsignacionLogic detalleconsignacionLogic= new DetalleConsignacionLogic(connexion);
				detalleconsignacionLogic.deepLoad(detalleconsignacion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetallePedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetallePedidoExpor.class));
			estadodetallepedido.setDetallePedidoExporExpors(estadodetallepedidoDataAccess.getDetallePedidoExporExpors(connexion,estadodetallepedido));

			for(DetallePedidoExpor detallepedidoexpor:estadodetallepedido.getDetallePedidoExporExpors()) {
				DetallePedidoExporLogic detallepedidoexporLogic= new DetallePedidoExporLogic(connexion);
				detallepedidoexporLogic.deepLoad(detallepedidoexpor,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoDetallePedido estadodetallepedido,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoDetallePedido.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadodetallepedido,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoDetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetallePedido(estadodetallepedido);
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
			this.deepLoad(this.estadodetallepedido,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoDetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetallePedido(this.estadodetallepedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoDetallePedido.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadodetallepedidos!=null) {
				for(EstadoDetallePedido estadodetallepedido:estadodetallepedidos) {
					this.deepLoad(estadodetallepedido,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoDetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetallePedido(estadodetallepedidos);
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
			if(estadodetallepedidos!=null) {
				for(EstadoDetallePedido estadodetallepedido:estadodetallepedidos) {
					this.deepLoad(estadodetallepedido,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoDetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetallePedido(estadodetallepedidos);
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
	
	
	public void getEstadoDetallePedidoPorCodigoWithConnection(String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetallePedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoDetallePedidoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadodetallepedido=estadodetallepedidoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadodetallepedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoDetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetallePedido(this.estadodetallepedido);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoDetallePedidoPorCodigo(String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoDetallePedidoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadodetallepedido=estadodetallepedidoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadodetallepedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoDetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetallePedido(this.estadodetallepedido);
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
			if(EstadoDetallePedidoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetallePedidoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoDetallePedido estadodetallepedido,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoDetallePedidoConstantesFunciones.ISCONAUDITORIA) {
				if(estadodetallepedido.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetallePedidoDataAccess.TABLENAME, estadodetallepedido.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoDetallePedidoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoDetallePedidoLogic.registrarAuditoriaDetallesEstadoDetallePedido(connexion,estadodetallepedido,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadodetallepedido.getIsDeleted()) {
					/*if(!estadodetallepedido.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoDetallePedidoDataAccess.TABLENAME, estadodetallepedido.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoDetallePedidoLogic.registrarAuditoriaDetallesEstadoDetallePedido(connexion,estadodetallepedido,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetallePedidoDataAccess.TABLENAME, estadodetallepedido.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadodetallepedido.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetallePedidoDataAccess.TABLENAME, estadodetallepedido.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoDetallePedidoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoDetallePedidoLogic.registrarAuditoriaDetallesEstadoDetallePedido(connexion,estadodetallepedido,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoDetallePedido(Connexion connexion,EstadoDetallePedido estadodetallepedido)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadodetallepedido.getIsNew()||!estadodetallepedido.getcodigo().equals(estadodetallepedido.getEstadoDetallePedidoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadodetallepedido.getEstadoDetallePedidoOriginal().getcodigo()!=null)
				{
					strValorActual=estadodetallepedido.getEstadoDetallePedidoOriginal().getcodigo();
				}
				if(estadodetallepedido.getcodigo()!=null)
				{
					strValorNuevo=estadodetallepedido.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoDetallePedidoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadodetallepedido.getIsNew()||!estadodetallepedido.getnombre().equals(estadodetallepedido.getEstadoDetallePedidoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadodetallepedido.getEstadoDetallePedidoOriginal().getnombre()!=null)
				{
					strValorActual=estadodetallepedido.getEstadoDetallePedidoOriginal().getnombre();
				}
				if(estadodetallepedido.getnombre()!=null)
				{
					strValorNuevo=estadodetallepedido.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoDetallePedidoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoDetallePedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoDetallePedidoConstantesFunciones.getClassesForeignKeysOfEstadoDetallePedido(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDetallePedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoDetallePedidoConstantesFunciones.getClassesRelationshipsOfEstadoDetallePedido(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

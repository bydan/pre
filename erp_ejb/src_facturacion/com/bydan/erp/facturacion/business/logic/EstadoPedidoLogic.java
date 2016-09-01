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
import com.bydan.erp.facturacion.util.EstadoPedidoConstantesFunciones;
import com.bydan.erp.facturacion.util.EstadoPedidoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.EstadoPedidoParameterGeneral;
import com.bydan.erp.facturacion.business.entity.EstadoPedido;
//import com.bydan.erp.facturacion.business.logic.EstadoPedidoLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class EstadoPedidoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoPedidoLogic.class);
	
	protected EstadoPedidoDataAccess estadopedidoDataAccess; 	
	protected EstadoPedido estadopedido;
	protected List<EstadoPedido> estadopedidos;
	protected Object estadopedidoObject;	
	protected List<Object> estadopedidosObject;
	
	public static ClassValidator<EstadoPedido> estadopedidoValidator = new ClassValidator<EstadoPedido>(EstadoPedido.class);	
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
	
	
	
	
	public  EstadoPedidoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadopedidoDataAccess = new EstadoPedidoDataAccess();
			
			this.estadopedidos= new ArrayList<EstadoPedido>();
			this.estadopedido= new EstadoPedido();
			
			this.estadopedidoObject=new Object();
			this.estadopedidosObject=new ArrayList<Object>();
				
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
			
			this.estadopedidoDataAccess.setConnexionType(this.connexionType);
			this.estadopedidoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoPedidoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadopedidoDataAccess = new EstadoPedidoDataAccess();
			this.estadopedidos= new ArrayList<EstadoPedido>();
			this.estadopedido= new EstadoPedido();
			this.estadopedidoObject=new Object();
			this.estadopedidosObject=new ArrayList<Object>();
			
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
			
			this.estadopedidoDataAccess.setConnexionType(this.connexionType);
			this.estadopedidoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoPedido getEstadoPedido() throws Exception {	
		//EstadoPedidoLogicAdditional.checkEstadoPedidoToGet(estadopedido,this.datosCliente,this.arrDatoGeneral);
		//EstadoPedidoLogicAdditional.updateEstadoPedidoToGet(estadopedido,this.arrDatoGeneral);
		
		return estadopedido;
	}
		
	public void setEstadoPedido(EstadoPedido newEstadoPedido) {
		this.estadopedido = newEstadoPedido;
	}
	
	public EstadoPedidoDataAccess getEstadoPedidoDataAccess() {
		return estadopedidoDataAccess;
	}
	
	public void setEstadoPedidoDataAccess(EstadoPedidoDataAccess newestadopedidoDataAccess) {
		this.estadopedidoDataAccess = newestadopedidoDataAccess;
	}
	
	public List<EstadoPedido> getEstadoPedidos() throws Exception {		
		this.quitarEstadoPedidosNulos();
		
		//EstadoPedidoLogicAdditional.checkEstadoPedidoToGets(estadopedidos,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoPedido estadopedidoLocal: estadopedidos ) {
			//EstadoPedidoLogicAdditional.updateEstadoPedidoToGet(estadopedidoLocal,this.arrDatoGeneral);
		}
		
		return estadopedidos;
	}
	
	public void setEstadoPedidos(List<EstadoPedido> newEstadoPedidos) {
		this.estadopedidos = newEstadoPedidos;
	}
	
	public Object getEstadoPedidoObject() {	
		this.estadopedidoObject=this.estadopedidoDataAccess.getEntityObject();
		return this.estadopedidoObject;
	}
		
	public void setEstadoPedidoObject(Object newEstadoPedidoObject) {
		this.estadopedidoObject = newEstadoPedidoObject;
	}
	
	public List<Object> getEstadoPedidosObject() {		
		this.estadopedidosObject=this.estadopedidoDataAccess.getEntitiesObject();
		return this.estadopedidosObject;
	}
		
	public void setEstadoPedidosObject(List<Object> newEstadoPedidosObject) {
		this.estadopedidosObject = newEstadoPedidosObject;
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
		
		if(this.estadopedidoDataAccess!=null) {
			this.estadopedidoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedido.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadopedidoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadopedidoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadopedido = new  EstadoPedido();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadopedido=estadopedidoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadopedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedido(this.estadopedido);
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
		estadopedido = new  EstadoPedido();
		  		  
        try {
			
			estadopedido=estadopedidoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadopedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedido(this.estadopedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadopedido = new  EstadoPedido();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadopedido=estadopedidoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadopedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedido(this.estadopedido);
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
		estadopedido = new  EstadoPedido();
		  		  
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
		estadopedido = new  EstadoPedido();
		  		  
        try {
			
			estadopedido=estadopedidoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadopedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedido(this.estadopedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadopedido = new  EstadoPedido();
		  		  
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
		estadopedido = new  EstadoPedido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedido.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadopedidoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadopedido = new  EstadoPedido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadopedidoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadopedido = new  EstadoPedido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedido.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadopedidoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadopedido = new  EstadoPedido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadopedidoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadopedido = new  EstadoPedido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedido.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadopedidoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadopedido = new  EstadoPedido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadopedidoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadopedidos = new  ArrayList<EstadoPedido>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopedidos=estadopedidoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoPedido(estadopedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedido(this.estadopedidos);
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
		estadopedidos = new  ArrayList<EstadoPedido>();
		  		  
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
		estadopedidos = new  ArrayList<EstadoPedido>();
		  		  
        try {			
			EstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopedidos=estadopedidoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoPedido(estadopedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedido(this.estadopedidos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadopedidos = new  ArrayList<EstadoPedido>();
		  		  
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
		estadopedidos = new  ArrayList<EstadoPedido>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopedidos=estadopedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoPedido(estadopedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedido(this.estadopedidos);
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
		estadopedidos = new  ArrayList<EstadoPedido>();
		  		  
        try {
			EstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopedidos=estadopedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoPedido(estadopedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedido(this.estadopedidos);
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
		estadopedidos = new  ArrayList<EstadoPedido>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopedidos=estadopedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoPedido(estadopedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedido(this.estadopedidos);
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
		estadopedidos = new  ArrayList<EstadoPedido>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopedidos=estadopedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoPedido(estadopedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedido(this.estadopedidos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadopedido = new  EstadoPedido();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopedido=estadopedidoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoPedido(estadopedido);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedido(this.estadopedido);
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
		estadopedido = new  EstadoPedido();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopedido=estadopedidoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoPedido(estadopedido);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedido(this.estadopedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosEstadoPedidosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadopedidos = new  ArrayList<EstadoPedido>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedido.class.getSimpleName()+"-getTodosEstadoPedidosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopedidos=estadopedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoPedido(estadopedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedido(this.estadopedidos);
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
	
	public  void  getTodosEstadoPedidos(String sFinalQuery,Pagination pagination)throws Exception {
		estadopedidos = new  ArrayList<EstadoPedido>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopedidos=estadopedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoPedido(estadopedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedido(this.estadopedidos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoPedido(EstadoPedido estadopedido) throws Exception {
		Boolean estaValidado=false;
		
		if(estadopedido.getIsNew() || estadopedido.getIsChanged()) { 
			this.invalidValues = estadopedidoValidator.getInvalidValues(estadopedido);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadopedido);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoPedido(List<EstadoPedido> EstadoPedidos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoPedido estadopedidoLocal:estadopedidos) {				
			estaValidadoObjeto=this.validarGuardarEstadoPedido(estadopedidoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoPedido(List<EstadoPedido> EstadoPedidos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoPedido(estadopedidos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoPedido(EstadoPedido EstadoPedido) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoPedido(estadopedido)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoPedido estadopedido) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadopedido.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoPedidoConstantesFunciones.getEstadoPedidoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadopedido","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoPedidoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoPedidoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoPedidoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedido.class.getSimpleName()+"-saveEstadoPedidoWithConnection");connexion.begin();			
			
			//EstadoPedidoLogicAdditional.checkEstadoPedidoToSave(this.estadopedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoPedidoLogicAdditional.updateEstadoPedidoToSave(this.estadopedido,this.arrDatoGeneral);
			
			EstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadopedido,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoPedido();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoPedido(this.estadopedido)) {
				EstadoPedidoDataAccess.save(this.estadopedido, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadopedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoPedidoLogicAdditional.checkEstadoPedidoToSaveAfter(this.estadopedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoPedido();
			
			connexion.commit();			
			
			if(this.estadopedido.getIsDeleted()) {
				this.estadopedido=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoPedido()throws Exception {	
		try {	
			
			//EstadoPedidoLogicAdditional.checkEstadoPedidoToSave(this.estadopedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoPedidoLogicAdditional.updateEstadoPedidoToSave(this.estadopedido,this.arrDatoGeneral);
			
			EstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadopedido,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoPedido(this.estadopedido)) {			
				EstadoPedidoDataAccess.save(this.estadopedido, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadopedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoPedidoLogicAdditional.checkEstadoPedidoToSaveAfter(this.estadopedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadopedido.getIsDeleted()) {
				this.estadopedido=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoPedidosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedido.class.getSimpleName()+"-saveEstadoPedidosWithConnection");connexion.begin();			
			
			//EstadoPedidoLogicAdditional.checkEstadoPedidoToSaves(estadopedidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoPedidos();
			
			Boolean validadoTodosEstadoPedido=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoPedido estadopedidoLocal:estadopedidos) {		
				if(estadopedidoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoPedidoLogicAdditional.updateEstadoPedidoToSave(estadopedidoLocal,this.arrDatoGeneral);
	        	
				EstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadopedidoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoPedido(estadopedidoLocal)) {
					EstadoPedidoDataAccess.save(estadopedidoLocal, connexion);				
				} else {
					validadoTodosEstadoPedido=false;
				}
			}
			
			if(!validadoTodosEstadoPedido) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoPedidoLogicAdditional.checkEstadoPedidoToSavesAfter(estadopedidos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoPedidos();
			
			connexion.commit();		
			
			this.quitarEstadoPedidosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoPedidos()throws Exception {				
		 try {	
			//EstadoPedidoLogicAdditional.checkEstadoPedidoToSaves(estadopedidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoPedido=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoPedido estadopedidoLocal:estadopedidos) {				
				if(estadopedidoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoPedidoLogicAdditional.updateEstadoPedidoToSave(estadopedidoLocal,this.arrDatoGeneral);
	        	
				EstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadopedidoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoPedido(estadopedidoLocal)) {				
					EstadoPedidoDataAccess.save(estadopedidoLocal, connexion);				
				} else {
					validadoTodosEstadoPedido=false;
				}
			}
			
			if(!validadoTodosEstadoPedido) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoPedidoLogicAdditional.checkEstadoPedidoToSavesAfter(estadopedidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoPedidosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoPedidoParameterReturnGeneral procesarAccionEstadoPedidos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoPedido> estadopedidos,EstadoPedidoParameterReturnGeneral estadopedidoParameterGeneral)throws Exception {
		 try {	
			EstadoPedidoParameterReturnGeneral estadopedidoReturnGeneral=new EstadoPedidoParameterReturnGeneral();
	
			
			return estadopedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoPedidoParameterReturnGeneral procesarAccionEstadoPedidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoPedido> estadopedidos,EstadoPedidoParameterReturnGeneral estadopedidoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedido.class.getSimpleName()+"-procesarAccionEstadoPedidosWithConnection");connexion.begin();			
			
			EstadoPedidoParameterReturnGeneral estadopedidoReturnGeneral=new EstadoPedidoParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return estadopedidoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoPedidoParameterReturnGeneral procesarEventosEstadoPedidos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoPedido> estadopedidos,EstadoPedido estadopedido,EstadoPedidoParameterReturnGeneral estadopedidoParameterGeneral,Boolean isEsNuevoEstadoPedido,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoPedidoParameterReturnGeneral estadopedidoReturnGeneral=new EstadoPedidoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadopedidoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return estadopedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoPedidoParameterReturnGeneral procesarEventosEstadoPedidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoPedido> estadopedidos,EstadoPedido estadopedido,EstadoPedidoParameterReturnGeneral estadopedidoParameterGeneral,Boolean isEsNuevoEstadoPedido,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedido.class.getSimpleName()+"-procesarEventosEstadoPedidosWithConnection");connexion.begin();			
			
			EstadoPedidoParameterReturnGeneral estadopedidoReturnGeneral=new EstadoPedidoParameterReturnGeneral();
	
			estadopedidoReturnGeneral.setEstadoPedido(estadopedido);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadopedidoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return estadopedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoPedidoParameterReturnGeneral procesarImportacionEstadoPedidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoPedidoParameterReturnGeneral estadopedidoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedido.class.getSimpleName()+"-procesarImportacionEstadoPedidosWithConnection");connexion.begin();			
			
			EstadoPedidoParameterReturnGeneral estadopedidoReturnGeneral=new EstadoPedidoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadopedidos=new ArrayList<EstadoPedido>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadopedido=new EstadoPedido();
				
				
				if(conColumnasBase) {this.estadopedido.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadopedido.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadopedido.setcodigo(arrColumnas[iColumn++]);
				this.estadopedido.setnombre(arrColumnas[iColumn++]);
				
				this.estadopedidos.add(this.estadopedido);
			}
			
			this.saveEstadoPedidos();
			
			this.connexion.commit();
			
			estadopedidoReturnGeneral.setConRetornoEstaProcesado(true);
			estadopedidoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadopedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoPedidosEliminados() throws Exception {				
		
		List<EstadoPedido> estadopedidosAux= new ArrayList<EstadoPedido>();
		
		for(EstadoPedido estadopedido:estadopedidos) {
			if(!estadopedido.getIsDeleted()) {
				estadopedidosAux.add(estadopedido);
			}
		}
		
		estadopedidos=estadopedidosAux;
	}
	
	public void quitarEstadoPedidosNulos() throws Exception {				
		
		List<EstadoPedido> estadopedidosAux= new ArrayList<EstadoPedido>();
		
		for(EstadoPedido estadopedido : this.estadopedidos) {
			if(estadopedido==null) {
				estadopedidosAux.add(estadopedido);
			}
		}
		
		//this.estadopedidos=estadopedidosAux;
		
		this.estadopedidos.removeAll(estadopedidosAux);
	}
	
	public void getSetVersionRowEstadoPedidoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadopedido.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadopedido.getIsDeleted() || (estadopedido.getIsChanged()&&!estadopedido.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadopedidoDataAccess.getSetVersionRowEstadoPedido(connexion,estadopedido.getId());
				
				if(!estadopedido.getVersionRow().equals(timestamp)) {	
					estadopedido.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadopedido.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoPedido()throws Exception {	
		
		if(estadopedido.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadopedido.getIsDeleted() || (estadopedido.getIsChanged()&&!estadopedido.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadopedidoDataAccess.getSetVersionRowEstadoPedido(connexion,estadopedido.getId());
			
			try {							
				if(!estadopedido.getVersionRow().equals(timestamp)) {	
					estadopedido.setVersionRow(timestamp);
				}
				
				estadopedido.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoPedidosWithConnection()throws Exception {	
		if(estadopedidos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoPedido estadopedidoAux:estadopedidos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadopedidoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadopedidoAux.getIsDeleted() || (estadopedidoAux.getIsChanged()&&!estadopedidoAux.getIsNew())) {
						
						timestamp=estadopedidoDataAccess.getSetVersionRowEstadoPedido(connexion,estadopedidoAux.getId());
						
						if(!estadopedido.getVersionRow().equals(timestamp)) {	
							estadopedidoAux.setVersionRow(timestamp);
						}
								
						estadopedidoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoPedidos()throws Exception {	
		if(estadopedidos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoPedido estadopedidoAux:estadopedidos) {
					if(estadopedidoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadopedidoAux.getIsDeleted() || (estadopedidoAux.getIsChanged()&&!estadopedidoAux.getIsNew())) {
						
						timestamp=estadopedidoDataAccess.getSetVersionRowEstadoPedido(connexion,estadopedidoAux.getId());
						
						if(!estadopedidoAux.getVersionRow().equals(timestamp)) {	
							estadopedidoAux.setVersionRow(timestamp);
						}
						
													
						estadopedidoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EstadoPedidoParameterReturnGeneral cargarCombosLoteForeignKeyEstadoPedidoWithConnection(String finalQueryGlobalColorGeneral) throws Exception {
		EstadoPedidoParameterReturnGeneral  estadopedidoReturnGeneral =new EstadoPedidoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedido.class.getSimpleName()+"-cargarCombosLoteForeignKeyEstadoPedidoWithConnection");connexion.begin();
			
			estadopedidoReturnGeneral =new EstadoPedidoParameterReturnGeneral();
			
			

			List<ColorGeneral> colorgeneralsForeignKey=new ArrayList<ColorGeneral>();
			ColorGeneralLogic colorgeneralLogic=new ColorGeneralLogic();
			colorgeneralLogic.setConnexion(this.connexion);
			colorgeneralLogic.getColorGeneralDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalColorGeneral.equals("NONE")) {
				colorgeneralLogic.getTodosColorGenerals(finalQueryGlobalColorGeneral,new Pagination());
				colorgeneralsForeignKey=colorgeneralLogic.getColorGenerals();
			}

			estadopedidoReturnGeneral.setcolorgeneralsForeignKey(colorgeneralsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return estadopedidoReturnGeneral;
	}
	
	public EstadoPedidoParameterReturnGeneral cargarCombosLoteForeignKeyEstadoPedido(String finalQueryGlobalColorGeneral) throws Exception {
		EstadoPedidoParameterReturnGeneral  estadopedidoReturnGeneral =new EstadoPedidoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			estadopedidoReturnGeneral =new EstadoPedidoParameterReturnGeneral();
			
			

			List<ColorGeneral> colorgeneralsForeignKey=new ArrayList<ColorGeneral>();
			ColorGeneralLogic colorgeneralLogic=new ColorGeneralLogic();
			colorgeneralLogic.setConnexion(this.connexion);
			colorgeneralLogic.getColorGeneralDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalColorGeneral.equals("NONE")) {
				colorgeneralLogic.getTodosColorGenerals(finalQueryGlobalColorGeneral,new Pagination());
				colorgeneralsForeignKey=colorgeneralLogic.getColorGenerals();
			}

			estadopedidoReturnGeneral.setcolorgeneralsForeignKey(colorgeneralsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return estadopedidoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyEstadoPedidoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ConsignacionLogic consignacionLogic=new ConsignacionLogic();
			PedidoExporLogic pedidoexporLogic=new PedidoExporLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedido.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoPedidoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Consignacion.class));
			classes.add(new Classe(PedidoExpor.class));
											
			

			consignacionLogic.setConnexion(this.getConnexion());
			consignacionLogic.setDatosCliente(this.datosCliente);
			consignacionLogic.setIsConRefrescarForeignKeys(true);

			pedidoexporLogic.setConnexion(this.getConnexion());
			pedidoexporLogic.setDatosCliente(this.datosCliente);
			pedidoexporLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoPedido estadopedido:this.estadopedidos) {
				

				classes=new ArrayList<Classe>();
				classes=ConsignacionConstantesFunciones.getClassesForeignKeysOfConsignacion(new ArrayList<Classe>(),DeepLoadType.NONE);

				consignacionLogic.setConsignacions(estadopedido.consignacions);
				consignacionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PedidoExporConstantesFunciones.getClassesForeignKeysOfPedidoExpor(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidoexporLogic.setPedidoExpors(estadopedido.pedidoexporExpors);
				pedidoexporLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoPedido estadopedido,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//EstadoPedidoLogicAdditional.updateEstadoPedidoToGet(estadopedido,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadopedido.setColorGeneral(estadopedidoDataAccess.getColorGeneral(connexion,estadopedido));
		estadopedido.setConsignacions(estadopedidoDataAccess.getConsignacions(connexion,estadopedido));
		estadopedido.setPedidoExporExpors(estadopedidoDataAccess.getPedidoExporExpors(connexion,estadopedido));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ColorGeneral.class)) {
				estadopedido.setColorGeneral(estadopedidoDataAccess.getColorGeneral(connexion,estadopedido));
				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadopedido.setConsignacions(estadopedidoDataAccess.getConsignacions(connexion,estadopedido));

				if(this.isConDeep) {
					ConsignacionLogic consignacionLogic= new ConsignacionLogic(this.connexion);
					consignacionLogic.setConsignacions(estadopedido.getConsignacions());
					ArrayList<Classe> classesLocal=ConsignacionConstantesFunciones.getClassesForeignKeysOfConsignacion(new ArrayList<Classe>(),DeepLoadType.NONE);
					consignacionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(consignacionLogic.getConsignacions());
					estadopedido.setConsignacions(consignacionLogic.getConsignacions());
				}

				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadopedido.setPedidoExporExpors(estadopedidoDataAccess.getPedidoExporExpors(connexion,estadopedido));

				if(this.isConDeep) {
					PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(this.connexion);
					pedidoexporLogic.setPedidoExpors(estadopedido.getPedidoExporExpors());
					ArrayList<Classe> classesLocal=PedidoExporConstantesFunciones.getClassesForeignKeysOfPedidoExpor(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidoexporLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(pedidoexporLogic.getPedidoExpors());
					estadopedido.setPedidoExporExpors(pedidoexporLogic.getPedidoExpors());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ColorGeneral.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estadopedido.setColorGeneral(estadopedidoDataAccess.getColorGeneral(connexion,estadopedido));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Consignacion.class));
			estadopedido.setConsignacions(estadopedidoDataAccess.getConsignacions(connexion,estadopedido));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoExpor.class));
			estadopedido.setPedidoExporExpors(estadopedidoDataAccess.getPedidoExporExpors(connexion,estadopedido));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadopedido.setColorGeneral(estadopedidoDataAccess.getColorGeneral(connexion,estadopedido));
		ColorGeneralLogic colorgeneralLogic= new ColorGeneralLogic(connexion);
		colorgeneralLogic.deepLoad(estadopedido.getColorGeneral(),isDeep,deepLoadType,clases);
				

		estadopedido.setConsignacions(estadopedidoDataAccess.getConsignacions(connexion,estadopedido));

		for(Consignacion consignacion:estadopedido.getConsignacions()) {
			ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
			consignacionLogic.deepLoad(consignacion,isDeep,deepLoadType,clases);
		}

		estadopedido.setPedidoExporExpors(estadopedidoDataAccess.getPedidoExporExpors(connexion,estadopedido));

		for(PedidoExpor pedidoexpor:estadopedido.getPedidoExporExpors()) {
			PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
			pedidoexporLogic.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ColorGeneral.class)) {
				estadopedido.setColorGeneral(estadopedidoDataAccess.getColorGeneral(connexion,estadopedido));
				ColorGeneralLogic colorgeneralLogic= new ColorGeneralLogic(connexion);
				colorgeneralLogic.deepLoad(estadopedido.getColorGeneral(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadopedido.setConsignacions(estadopedidoDataAccess.getConsignacions(connexion,estadopedido));

				for(Consignacion consignacion:estadopedido.getConsignacions()) {
					ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
					consignacionLogic.deepLoad(consignacion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadopedido.setPedidoExporExpors(estadopedidoDataAccess.getPedidoExporExpors(connexion,estadopedido));

				for(PedidoExpor pedidoexpor:estadopedido.getPedidoExporExpors()) {
					PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
					pedidoexporLogic.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ColorGeneral.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estadopedido.setColorGeneral(estadopedidoDataAccess.getColorGeneral(connexion,estadopedido));
			ColorGeneralLogic colorgeneralLogic= new ColorGeneralLogic(connexion);
			colorgeneralLogic.deepLoad(estadopedido.getColorGeneral(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Consignacion.class));
			estadopedido.setConsignacions(estadopedidoDataAccess.getConsignacions(connexion,estadopedido));

			for(Consignacion consignacion:estadopedido.getConsignacions()) {
				ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
				consignacionLogic.deepLoad(consignacion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoExpor.class));
			estadopedido.setPedidoExporExpors(estadopedidoDataAccess.getPedidoExporExpors(connexion,estadopedido));

			for(PedidoExpor pedidoexpor:estadopedido.getPedidoExporExpors()) {
				PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
				pedidoexporLogic.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoPedido estadopedido,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoPedido.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadopedido,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedido(estadopedido);
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
			this.deepLoad(this.estadopedido,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedido(this.estadopedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoPedido.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadopedidos!=null) {
				for(EstadoPedido estadopedido:estadopedidos) {
					this.deepLoad(estadopedido,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedido(estadopedidos);
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
			if(estadopedidos!=null) {
				for(EstadoPedido estadopedido:estadopedidos) {
					this.deepLoad(estadopedido,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedido(estadopedidos);
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
	
	
	public void getEstadoPedidosFK_IdColorGeneralWithConnection(String sFinalQuery,Pagination pagination,Long id_color_general)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidColorGeneral= new ParameterSelectionGeneral();
			parameterSelectionGeneralidColorGeneral.setParameterSelectionGeneralEqual(ParameterType.LONG,id_color_general,EstadoPedidoConstantesFunciones.IDCOLORGENERAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidColorGeneral);

			EstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdColorGeneral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estadopedidos=estadopedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedido(this.estadopedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoPedidosFK_IdColorGeneral(String sFinalQuery,Pagination pagination,Long id_color_general)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidColorGeneral= new ParameterSelectionGeneral();
			parameterSelectionGeneralidColorGeneral.setParameterSelectionGeneralEqual(ParameterType.LONG,id_color_general,EstadoPedidoConstantesFunciones.IDCOLORGENERAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidColorGeneral);

			EstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdColorGeneral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estadopedidos=estadopedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedido(this.estadopedidos);
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
			if(EstadoPedidoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoPedidoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoPedido estadopedido,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoPedidoConstantesFunciones.ISCONAUDITORIA) {
				if(estadopedido.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoPedidoDataAccess.TABLENAME, estadopedido.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoPedidoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoPedidoLogic.registrarAuditoriaDetallesEstadoPedido(connexion,estadopedido,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadopedido.getIsDeleted()) {
					/*if(!estadopedido.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoPedidoDataAccess.TABLENAME, estadopedido.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoPedidoLogic.registrarAuditoriaDetallesEstadoPedido(connexion,estadopedido,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoPedidoDataAccess.TABLENAME, estadopedido.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadopedido.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoPedidoDataAccess.TABLENAME, estadopedido.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoPedidoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoPedidoLogic.registrarAuditoriaDetallesEstadoPedido(connexion,estadopedido,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoPedido(Connexion connexion,EstadoPedido estadopedido)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadopedido.getIsNew()||!estadopedido.getcodigo().equals(estadopedido.getEstadoPedidoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadopedido.getEstadoPedidoOriginal().getcodigo()!=null)
				{
					strValorActual=estadopedido.getEstadoPedidoOriginal().getcodigo();
				}
				if(estadopedido.getcodigo()!=null)
				{
					strValorNuevo=estadopedido.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoPedidoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadopedido.getIsNew()||!estadopedido.getnombre().equals(estadopedido.getEstadoPedidoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadopedido.getEstadoPedidoOriginal().getnombre()!=null)
				{
					strValorActual=estadopedido.getEstadoPedidoOriginal().getnombre();
				}
				if(estadopedido.getnombre()!=null)
				{
					strValorNuevo=estadopedido.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoPedidoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(estadopedido.getIsNew()||!estadopedido.getid_color_general().equals(estadopedido.getEstadoPedidoOriginal().getid_color_general()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadopedido.getEstadoPedidoOriginal().getid_color_general()!=null)
				{
					strValorActual=estadopedido.getEstadoPedidoOriginal().getid_color_general().toString();
				}
				if(estadopedido.getid_color_general()!=null)
				{
					strValorNuevo=estadopedido.getid_color_general().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoPedidoConstantesFunciones.IDCOLORGENERAL,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoPedidoConstantesFunciones.getClassesForeignKeysOfEstadoPedido(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoPedidoConstantesFunciones.getClassesRelationshipsOfEstadoPedido(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

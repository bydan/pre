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
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.puntoventa.util.EstadoPedidoPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.EstadoPedidoPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.EstadoPedidoPuntoVentaParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.EstadoPedidoPuntoVenta;
//import com.bydan.erp.puntoventa.business.logic.EstadoPedidoPuntoVentaLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class EstadoPedidoPuntoVentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoPedidoPuntoVentaLogic.class);
	
	protected EstadoPedidoPuntoVentaDataAccess estadopedidopuntoventaDataAccess; 	
	protected EstadoPedidoPuntoVenta estadopedidopuntoventa;
	protected List<EstadoPedidoPuntoVenta> estadopedidopuntoventas;
	protected Object estadopedidopuntoventaObject;	
	protected List<Object> estadopedidopuntoventasObject;
	
	public static ClassValidator<EstadoPedidoPuntoVenta> estadopedidopuntoventaValidator = new ClassValidator<EstadoPedidoPuntoVenta>(EstadoPedidoPuntoVenta.class);	
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
	
	
	
	
	public  EstadoPedidoPuntoVentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadopedidopuntoventaDataAccess = new EstadoPedidoPuntoVentaDataAccess();
			
			this.estadopedidopuntoventas= new ArrayList<EstadoPedidoPuntoVenta>();
			this.estadopedidopuntoventa= new EstadoPedidoPuntoVenta();
			
			this.estadopedidopuntoventaObject=new Object();
			this.estadopedidopuntoventasObject=new ArrayList<Object>();
				
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
			
			this.estadopedidopuntoventaDataAccess.setConnexionType(this.connexionType);
			this.estadopedidopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoPedidoPuntoVentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadopedidopuntoventaDataAccess = new EstadoPedidoPuntoVentaDataAccess();
			this.estadopedidopuntoventas= new ArrayList<EstadoPedidoPuntoVenta>();
			this.estadopedidopuntoventa= new EstadoPedidoPuntoVenta();
			this.estadopedidopuntoventaObject=new Object();
			this.estadopedidopuntoventasObject=new ArrayList<Object>();
			
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
			
			this.estadopedidopuntoventaDataAccess.setConnexionType(this.connexionType);
			this.estadopedidopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoPedidoPuntoVenta getEstadoPedidoPuntoVenta() throws Exception {	
		//EstadoPedidoPuntoVentaLogicAdditional.checkEstadoPedidoPuntoVentaToGet(estadopedidopuntoventa,this.datosCliente,this.arrDatoGeneral);
		//EstadoPedidoPuntoVentaLogicAdditional.updateEstadoPedidoPuntoVentaToGet(estadopedidopuntoventa,this.arrDatoGeneral);
		
		return estadopedidopuntoventa;
	}
		
	public void setEstadoPedidoPuntoVenta(EstadoPedidoPuntoVenta newEstadoPedidoPuntoVenta) {
		this.estadopedidopuntoventa = newEstadoPedidoPuntoVenta;
	}
	
	public EstadoPedidoPuntoVentaDataAccess getEstadoPedidoPuntoVentaDataAccess() {
		return estadopedidopuntoventaDataAccess;
	}
	
	public void setEstadoPedidoPuntoVentaDataAccess(EstadoPedidoPuntoVentaDataAccess newestadopedidopuntoventaDataAccess) {
		this.estadopedidopuntoventaDataAccess = newestadopedidopuntoventaDataAccess;
	}
	
	public List<EstadoPedidoPuntoVenta> getEstadoPedidoPuntoVentas() throws Exception {		
		this.quitarEstadoPedidoPuntoVentasNulos();
		
		//EstadoPedidoPuntoVentaLogicAdditional.checkEstadoPedidoPuntoVentaToGets(estadopedidopuntoventas,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoPedidoPuntoVenta estadopedidopuntoventaLocal: estadopedidopuntoventas ) {
			//EstadoPedidoPuntoVentaLogicAdditional.updateEstadoPedidoPuntoVentaToGet(estadopedidopuntoventaLocal,this.arrDatoGeneral);
		}
		
		return estadopedidopuntoventas;
	}
	
	public void setEstadoPedidoPuntoVentas(List<EstadoPedidoPuntoVenta> newEstadoPedidoPuntoVentas) {
		this.estadopedidopuntoventas = newEstadoPedidoPuntoVentas;
	}
	
	public Object getEstadoPedidoPuntoVentaObject() {	
		this.estadopedidopuntoventaObject=this.estadopedidopuntoventaDataAccess.getEntityObject();
		return this.estadopedidopuntoventaObject;
	}
		
	public void setEstadoPedidoPuntoVentaObject(Object newEstadoPedidoPuntoVentaObject) {
		this.estadopedidopuntoventaObject = newEstadoPedidoPuntoVentaObject;
	}
	
	public List<Object> getEstadoPedidoPuntoVentasObject() {		
		this.estadopedidopuntoventasObject=this.estadopedidopuntoventaDataAccess.getEntitiesObject();
		return this.estadopedidopuntoventasObject;
	}
		
	public void setEstadoPedidoPuntoVentasObject(List<Object> newEstadoPedidoPuntoVentasObject) {
		this.estadopedidopuntoventasObject = newEstadoPedidoPuntoVentasObject;
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
		
		if(this.estadopedidopuntoventaDataAccess!=null) {
			this.estadopedidopuntoventaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedidoPuntoVenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadopedidopuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadopedidopuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadopedidopuntoventa = new  EstadoPedidoPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedidoPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadopedidopuntoventa=estadopedidopuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadopedidopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoPedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedidoPuntoVenta(this.estadopedidopuntoventa);
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
		estadopedidopuntoventa = new  EstadoPedidoPuntoVenta();
		  		  
        try {
			
			estadopedidopuntoventa=estadopedidopuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadopedidopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoPedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedidoPuntoVenta(this.estadopedidopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadopedidopuntoventa = new  EstadoPedidoPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedidoPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadopedidopuntoventa=estadopedidopuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadopedidopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoPedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedidoPuntoVenta(this.estadopedidopuntoventa);
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
		estadopedidopuntoventa = new  EstadoPedidoPuntoVenta();
		  		  
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
		estadopedidopuntoventa = new  EstadoPedidoPuntoVenta();
		  		  
        try {
			
			estadopedidopuntoventa=estadopedidopuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadopedidopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoPedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedidoPuntoVenta(this.estadopedidopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadopedidopuntoventa = new  EstadoPedidoPuntoVenta();
		  		  
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
		estadopedidopuntoventa = new  EstadoPedidoPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedidoPuntoVenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadopedidopuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadopedidopuntoventa = new  EstadoPedidoPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadopedidopuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadopedidopuntoventa = new  EstadoPedidoPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedidoPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadopedidopuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadopedidopuntoventa = new  EstadoPedidoPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadopedidopuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadopedidopuntoventa = new  EstadoPedidoPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedidoPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadopedidopuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadopedidopuntoventa = new  EstadoPedidoPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadopedidopuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadopedidopuntoventas = new  ArrayList<EstadoPedidoPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedidoPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoPedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopedidopuntoventas=estadopedidopuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoPedidoPuntoVenta(estadopedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedidoPuntoVenta(this.estadopedidopuntoventas);
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
		estadopedidopuntoventas = new  ArrayList<EstadoPedidoPuntoVenta>();
		  		  
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
		estadopedidopuntoventas = new  ArrayList<EstadoPedidoPuntoVenta>();
		  		  
        try {			
			EstadoPedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopedidopuntoventas=estadopedidopuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoPedidoPuntoVenta(estadopedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedidoPuntoVenta(this.estadopedidopuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadopedidopuntoventas = new  ArrayList<EstadoPedidoPuntoVenta>();
		  		  
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
		estadopedidopuntoventas = new  ArrayList<EstadoPedidoPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedidoPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoPedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopedidopuntoventas=estadopedidopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoPedidoPuntoVenta(estadopedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedidoPuntoVenta(this.estadopedidopuntoventas);
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
		estadopedidopuntoventas = new  ArrayList<EstadoPedidoPuntoVenta>();
		  		  
        try {
			EstadoPedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopedidopuntoventas=estadopedidopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoPedidoPuntoVenta(estadopedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedidoPuntoVenta(this.estadopedidopuntoventas);
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
		estadopedidopuntoventas = new  ArrayList<EstadoPedidoPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedidoPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopedidopuntoventas=estadopedidopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoPedidoPuntoVenta(estadopedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedidoPuntoVenta(this.estadopedidopuntoventas);
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
		estadopedidopuntoventas = new  ArrayList<EstadoPedidoPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopedidopuntoventas=estadopedidopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoPedidoPuntoVenta(estadopedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedidoPuntoVenta(this.estadopedidopuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadopedidopuntoventa = new  EstadoPedidoPuntoVenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedidoPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopedidopuntoventa=estadopedidopuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoPedidoPuntoVenta(estadopedidopuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedidoPuntoVenta(this.estadopedidopuntoventa);
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
		estadopedidopuntoventa = new  EstadoPedidoPuntoVenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopedidopuntoventa=estadopedidopuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoPedidoPuntoVenta(estadopedidopuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedidoPuntoVenta(this.estadopedidopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosEstadoPedidoPuntoVentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadopedidopuntoventas = new  ArrayList<EstadoPedidoPuntoVenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedidoPuntoVenta.class.getSimpleName()+"-getTodosEstadoPedidoPuntoVentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopedidopuntoventas=estadopedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoPedidoPuntoVenta(estadopedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedidoPuntoVenta(this.estadopedidopuntoventas);
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
	
	public  void  getTodosEstadoPedidoPuntoVentas(String sFinalQuery,Pagination pagination)throws Exception {
		estadopedidopuntoventas = new  ArrayList<EstadoPedidoPuntoVenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopedidopuntoventas=estadopedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoPedidoPuntoVenta(estadopedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedidoPuntoVenta(this.estadopedidopuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoPedidoPuntoVenta(EstadoPedidoPuntoVenta estadopedidopuntoventa) throws Exception {
		Boolean estaValidado=false;
		
		if(estadopedidopuntoventa.getIsNew() || estadopedidopuntoventa.getIsChanged()) { 
			this.invalidValues = estadopedidopuntoventaValidator.getInvalidValues(estadopedidopuntoventa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadopedidopuntoventa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoPedidoPuntoVenta(List<EstadoPedidoPuntoVenta> EstadoPedidoPuntoVentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoPedidoPuntoVenta estadopedidopuntoventaLocal:estadopedidopuntoventas) {				
			estaValidadoObjeto=this.validarGuardarEstadoPedidoPuntoVenta(estadopedidopuntoventaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoPedidoPuntoVenta(List<EstadoPedidoPuntoVenta> EstadoPedidoPuntoVentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoPedidoPuntoVenta(estadopedidopuntoventas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoPedidoPuntoVenta(EstadoPedidoPuntoVenta EstadoPedidoPuntoVenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoPedidoPuntoVenta(estadopedidopuntoventa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoPedidoPuntoVenta estadopedidopuntoventa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadopedidopuntoventa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoPedidoPuntoVentaConstantesFunciones.getEstadoPedidoPuntoVentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadopedidopuntoventa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoPedidoPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoPedidoPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoPedidoPuntoVentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedidoPuntoVenta.class.getSimpleName()+"-saveEstadoPedidoPuntoVentaWithConnection");connexion.begin();			
			
			//EstadoPedidoPuntoVentaLogicAdditional.checkEstadoPedidoPuntoVentaToSave(this.estadopedidopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoPedidoPuntoVentaLogicAdditional.updateEstadoPedidoPuntoVentaToSave(this.estadopedidopuntoventa,this.arrDatoGeneral);
			
			EstadoPedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadopedidopuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoPedidoPuntoVenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoPedidoPuntoVenta(this.estadopedidopuntoventa)) {
				EstadoPedidoPuntoVentaDataAccess.save(this.estadopedidopuntoventa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadopedidopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoPedidoPuntoVentaLogicAdditional.checkEstadoPedidoPuntoVentaToSaveAfter(this.estadopedidopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoPedidoPuntoVenta();
			
			connexion.commit();			
			
			if(this.estadopedidopuntoventa.getIsDeleted()) {
				this.estadopedidopuntoventa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoPedidoPuntoVenta()throws Exception {	
		try {	
			
			//EstadoPedidoPuntoVentaLogicAdditional.checkEstadoPedidoPuntoVentaToSave(this.estadopedidopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoPedidoPuntoVentaLogicAdditional.updateEstadoPedidoPuntoVentaToSave(this.estadopedidopuntoventa,this.arrDatoGeneral);
			
			EstadoPedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadopedidopuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoPedidoPuntoVenta(this.estadopedidopuntoventa)) {			
				EstadoPedidoPuntoVentaDataAccess.save(this.estadopedidopuntoventa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadopedidopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoPedidoPuntoVentaLogicAdditional.checkEstadoPedidoPuntoVentaToSaveAfter(this.estadopedidopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadopedidopuntoventa.getIsDeleted()) {
				this.estadopedidopuntoventa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoPedidoPuntoVentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedidoPuntoVenta.class.getSimpleName()+"-saveEstadoPedidoPuntoVentasWithConnection");connexion.begin();			
			
			//EstadoPedidoPuntoVentaLogicAdditional.checkEstadoPedidoPuntoVentaToSaves(estadopedidopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoPedidoPuntoVentas();
			
			Boolean validadoTodosEstadoPedidoPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoPedidoPuntoVenta estadopedidopuntoventaLocal:estadopedidopuntoventas) {		
				if(estadopedidopuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoPedidoPuntoVentaLogicAdditional.updateEstadoPedidoPuntoVentaToSave(estadopedidopuntoventaLocal,this.arrDatoGeneral);
	        	
				EstadoPedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadopedidopuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoPedidoPuntoVenta(estadopedidopuntoventaLocal)) {
					EstadoPedidoPuntoVentaDataAccess.save(estadopedidopuntoventaLocal, connexion);				
				} else {
					validadoTodosEstadoPedidoPuntoVenta=false;
				}
			}
			
			if(!validadoTodosEstadoPedidoPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoPedidoPuntoVentaLogicAdditional.checkEstadoPedidoPuntoVentaToSavesAfter(estadopedidopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoPedidoPuntoVentas();
			
			connexion.commit();		
			
			this.quitarEstadoPedidoPuntoVentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoPedidoPuntoVentas()throws Exception {				
		 try {	
			//EstadoPedidoPuntoVentaLogicAdditional.checkEstadoPedidoPuntoVentaToSaves(estadopedidopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoPedidoPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoPedidoPuntoVenta estadopedidopuntoventaLocal:estadopedidopuntoventas) {				
				if(estadopedidopuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoPedidoPuntoVentaLogicAdditional.updateEstadoPedidoPuntoVentaToSave(estadopedidopuntoventaLocal,this.arrDatoGeneral);
	        	
				EstadoPedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadopedidopuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoPedidoPuntoVenta(estadopedidopuntoventaLocal)) {				
					EstadoPedidoPuntoVentaDataAccess.save(estadopedidopuntoventaLocal, connexion);				
				} else {
					validadoTodosEstadoPedidoPuntoVenta=false;
				}
			}
			
			if(!validadoTodosEstadoPedidoPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoPedidoPuntoVentaLogicAdditional.checkEstadoPedidoPuntoVentaToSavesAfter(estadopedidopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoPedidoPuntoVentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoPedidoPuntoVentaParameterReturnGeneral procesarAccionEstadoPedidoPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoPedidoPuntoVenta> estadopedidopuntoventas,EstadoPedidoPuntoVentaParameterReturnGeneral estadopedidopuntoventaParameterGeneral)throws Exception {
		 try {	
			EstadoPedidoPuntoVentaParameterReturnGeneral estadopedidopuntoventaReturnGeneral=new EstadoPedidoPuntoVentaParameterReturnGeneral();
	
			
			return estadopedidopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoPedidoPuntoVentaParameterReturnGeneral procesarAccionEstadoPedidoPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoPedidoPuntoVenta> estadopedidopuntoventas,EstadoPedidoPuntoVentaParameterReturnGeneral estadopedidopuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedidoPuntoVenta.class.getSimpleName()+"-procesarAccionEstadoPedidoPuntoVentasWithConnection");connexion.begin();			
			
			EstadoPedidoPuntoVentaParameterReturnGeneral estadopedidopuntoventaReturnGeneral=new EstadoPedidoPuntoVentaParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return estadopedidopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoPedidoPuntoVentaParameterReturnGeneral procesarEventosEstadoPedidoPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoPedidoPuntoVenta> estadopedidopuntoventas,EstadoPedidoPuntoVenta estadopedidopuntoventa,EstadoPedidoPuntoVentaParameterReturnGeneral estadopedidopuntoventaParameterGeneral,Boolean isEsNuevoEstadoPedidoPuntoVenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoPedidoPuntoVentaParameterReturnGeneral estadopedidopuntoventaReturnGeneral=new EstadoPedidoPuntoVentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadopedidopuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return estadopedidopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoPedidoPuntoVentaParameterReturnGeneral procesarEventosEstadoPedidoPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoPedidoPuntoVenta> estadopedidopuntoventas,EstadoPedidoPuntoVenta estadopedidopuntoventa,EstadoPedidoPuntoVentaParameterReturnGeneral estadopedidopuntoventaParameterGeneral,Boolean isEsNuevoEstadoPedidoPuntoVenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedidoPuntoVenta.class.getSimpleName()+"-procesarEventosEstadoPedidoPuntoVentasWithConnection");connexion.begin();			
			
			EstadoPedidoPuntoVentaParameterReturnGeneral estadopedidopuntoventaReturnGeneral=new EstadoPedidoPuntoVentaParameterReturnGeneral();
	
			estadopedidopuntoventaReturnGeneral.setEstadoPedidoPuntoVenta(estadopedidopuntoventa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadopedidopuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return estadopedidopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoPedidoPuntoVentaParameterReturnGeneral procesarImportacionEstadoPedidoPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoPedidoPuntoVentaParameterReturnGeneral estadopedidopuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedidoPuntoVenta.class.getSimpleName()+"-procesarImportacionEstadoPedidoPuntoVentasWithConnection");connexion.begin();			
			
			EstadoPedidoPuntoVentaParameterReturnGeneral estadopedidopuntoventaReturnGeneral=new EstadoPedidoPuntoVentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadopedidopuntoventas=new ArrayList<EstadoPedidoPuntoVenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadopedidopuntoventa=new EstadoPedidoPuntoVenta();
				
				
				if(conColumnasBase) {this.estadopedidopuntoventa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadopedidopuntoventa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadopedidopuntoventa.setnombre(arrColumnas[iColumn++]);
				
				this.estadopedidopuntoventas.add(this.estadopedidopuntoventa);
			}
			
			this.saveEstadoPedidoPuntoVentas();
			
			this.connexion.commit();
			
			estadopedidopuntoventaReturnGeneral.setConRetornoEstaProcesado(true);
			estadopedidopuntoventaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadopedidopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoPedidoPuntoVentasEliminados() throws Exception {				
		
		List<EstadoPedidoPuntoVenta> estadopedidopuntoventasAux= new ArrayList<EstadoPedidoPuntoVenta>();
		
		for(EstadoPedidoPuntoVenta estadopedidopuntoventa:estadopedidopuntoventas) {
			if(!estadopedidopuntoventa.getIsDeleted()) {
				estadopedidopuntoventasAux.add(estadopedidopuntoventa);
			}
		}
		
		estadopedidopuntoventas=estadopedidopuntoventasAux;
	}
	
	public void quitarEstadoPedidoPuntoVentasNulos() throws Exception {				
		
		List<EstadoPedidoPuntoVenta> estadopedidopuntoventasAux= new ArrayList<EstadoPedidoPuntoVenta>();
		
		for(EstadoPedidoPuntoVenta estadopedidopuntoventa : this.estadopedidopuntoventas) {
			if(estadopedidopuntoventa==null) {
				estadopedidopuntoventasAux.add(estadopedidopuntoventa);
			}
		}
		
		//this.estadopedidopuntoventas=estadopedidopuntoventasAux;
		
		this.estadopedidopuntoventas.removeAll(estadopedidopuntoventasAux);
	}
	
	public void getSetVersionRowEstadoPedidoPuntoVentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadopedidopuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadopedidopuntoventa.getIsDeleted() || (estadopedidopuntoventa.getIsChanged()&&!estadopedidopuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadopedidopuntoventaDataAccess.getSetVersionRowEstadoPedidoPuntoVenta(connexion,estadopedidopuntoventa.getId());
				
				if(!estadopedidopuntoventa.getVersionRow().equals(timestamp)) {	
					estadopedidopuntoventa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadopedidopuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoPedidoPuntoVenta()throws Exception {	
		
		if(estadopedidopuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadopedidopuntoventa.getIsDeleted() || (estadopedidopuntoventa.getIsChanged()&&!estadopedidopuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadopedidopuntoventaDataAccess.getSetVersionRowEstadoPedidoPuntoVenta(connexion,estadopedidopuntoventa.getId());
			
			try {							
				if(!estadopedidopuntoventa.getVersionRow().equals(timestamp)) {	
					estadopedidopuntoventa.setVersionRow(timestamp);
				}
				
				estadopedidopuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoPedidoPuntoVentasWithConnection()throws Exception {	
		if(estadopedidopuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoPedidoPuntoVenta estadopedidopuntoventaAux:estadopedidopuntoventas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadopedidopuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadopedidopuntoventaAux.getIsDeleted() || (estadopedidopuntoventaAux.getIsChanged()&&!estadopedidopuntoventaAux.getIsNew())) {
						
						timestamp=estadopedidopuntoventaDataAccess.getSetVersionRowEstadoPedidoPuntoVenta(connexion,estadopedidopuntoventaAux.getId());
						
						if(!estadopedidopuntoventa.getVersionRow().equals(timestamp)) {	
							estadopedidopuntoventaAux.setVersionRow(timestamp);
						}
								
						estadopedidopuntoventaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoPedidoPuntoVentas()throws Exception {	
		if(estadopedidopuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoPedidoPuntoVenta estadopedidopuntoventaAux:estadopedidopuntoventas) {
					if(estadopedidopuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadopedidopuntoventaAux.getIsDeleted() || (estadopedidopuntoventaAux.getIsChanged()&&!estadopedidopuntoventaAux.getIsNew())) {
						
						timestamp=estadopedidopuntoventaDataAccess.getSetVersionRowEstadoPedidoPuntoVenta(connexion,estadopedidopuntoventaAux.getId());
						
						if(!estadopedidopuntoventaAux.getVersionRow().equals(timestamp)) {	
							estadopedidopuntoventaAux.setVersionRow(timestamp);
						}
						
													
						estadopedidopuntoventaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoPedidoPuntoVentaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PedidoPuntoVentaLogic pedidopuntoventaLogic=new PedidoPuntoVentaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPedidoPuntoVenta.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoPedidoPuntoVentaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(PedidoPuntoVenta.class));
											
			

			pedidopuntoventaLogic.setConnexion(this.getConnexion());
			pedidopuntoventaLogic.setDatosCliente(this.datosCliente);
			pedidopuntoventaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoPedidoPuntoVenta estadopedidopuntoventa:this.estadopedidopuntoventas) {
				

				classes=new ArrayList<Classe>();
				classes=PedidoPuntoVentaConstantesFunciones.getClassesForeignKeysOfPedidoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidopuntoventaLogic.setPedidoPuntoVentas(estadopedidopuntoventa.pedidopuntoventas);
				pedidopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoPedidoPuntoVenta estadopedidopuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//EstadoPedidoPuntoVentaLogicAdditional.updateEstadoPedidoPuntoVentaToGet(estadopedidopuntoventa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadopedidopuntoventa.setPedidoPuntoVentas(estadopedidopuntoventaDataAccess.getPedidoPuntoVentas(connexion,estadopedidopuntoventa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadopedidopuntoventa.setPedidoPuntoVentas(estadopedidopuntoventaDataAccess.getPedidoPuntoVentas(connexion,estadopedidopuntoventa));

				if(this.isConDeep) {
					PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(this.connexion);
					pedidopuntoventaLogic.setPedidoPuntoVentas(estadopedidopuntoventa.getPedidoPuntoVentas());
					ArrayList<Classe> classesLocal=PedidoPuntoVentaConstantesFunciones.getClassesForeignKeysOfPedidoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(pedidopuntoventaLogic.getPedidoPuntoVentas());
					estadopedidopuntoventa.setPedidoPuntoVentas(pedidopuntoventaLogic.getPedidoPuntoVentas());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoPuntoVenta.class));
			estadopedidopuntoventa.setPedidoPuntoVentas(estadopedidopuntoventaDataAccess.getPedidoPuntoVentas(connexion,estadopedidopuntoventa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadopedidopuntoventa.setPedidoPuntoVentas(estadopedidopuntoventaDataAccess.getPedidoPuntoVentas(connexion,estadopedidopuntoventa));

		for(PedidoPuntoVenta pedidopuntoventa:estadopedidopuntoventa.getPedidoPuntoVentas()) {
			PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
			pedidopuntoventaLogic.deepLoad(pedidopuntoventa,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadopedidopuntoventa.setPedidoPuntoVentas(estadopedidopuntoventaDataAccess.getPedidoPuntoVentas(connexion,estadopedidopuntoventa));

				for(PedidoPuntoVenta pedidopuntoventa:estadopedidopuntoventa.getPedidoPuntoVentas()) {
					PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
					pedidopuntoventaLogic.deepLoad(pedidopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoPuntoVenta.class));
			estadopedidopuntoventa.setPedidoPuntoVentas(estadopedidopuntoventaDataAccess.getPedidoPuntoVentas(connexion,estadopedidopuntoventa));

			for(PedidoPuntoVenta pedidopuntoventa:estadopedidopuntoventa.getPedidoPuntoVentas()) {
				PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
				pedidopuntoventaLogic.deepLoad(pedidopuntoventa,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoPedidoPuntoVenta estadopedidopuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoPedidoPuntoVenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadopedidopuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoPedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedidoPuntoVenta(estadopedidopuntoventa);
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
			this.deepLoad(this.estadopedidopuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoPedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedidoPuntoVenta(this.estadopedidopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoPedidoPuntoVenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadopedidopuntoventas!=null) {
				for(EstadoPedidoPuntoVenta estadopedidopuntoventa:estadopedidopuntoventas) {
					this.deepLoad(estadopedidopuntoventa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoPedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedidoPuntoVenta(estadopedidopuntoventas);
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
			if(estadopedidopuntoventas!=null) {
				for(EstadoPedidoPuntoVenta estadopedidopuntoventa:estadopedidopuntoventas) {
					this.deepLoad(estadopedidopuntoventa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoPedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPedidoPuntoVenta(estadopedidopuntoventas);
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
			if(EstadoPedidoPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoPedidoPuntoVentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoPedidoPuntoVenta estadopedidopuntoventa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoPedidoPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				if(estadopedidopuntoventa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoPedidoPuntoVentaDataAccess.TABLENAME, estadopedidopuntoventa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoPedidoPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoPedidoPuntoVentaLogic.registrarAuditoriaDetallesEstadoPedidoPuntoVenta(connexion,estadopedidopuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadopedidopuntoventa.getIsDeleted()) {
					/*if(!estadopedidopuntoventa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoPedidoPuntoVentaDataAccess.TABLENAME, estadopedidopuntoventa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoPedidoPuntoVentaLogic.registrarAuditoriaDetallesEstadoPedidoPuntoVenta(connexion,estadopedidopuntoventa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoPedidoPuntoVentaDataAccess.TABLENAME, estadopedidopuntoventa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadopedidopuntoventa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoPedidoPuntoVentaDataAccess.TABLENAME, estadopedidopuntoventa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoPedidoPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoPedidoPuntoVentaLogic.registrarAuditoriaDetallesEstadoPedidoPuntoVenta(connexion,estadopedidopuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoPedidoPuntoVenta(Connexion connexion,EstadoPedidoPuntoVenta estadopedidopuntoventa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadopedidopuntoventa.getIsNew()||!estadopedidopuntoventa.getnombre().equals(estadopedidopuntoventa.getEstadoPedidoPuntoVentaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadopedidopuntoventa.getEstadoPedidoPuntoVentaOriginal().getnombre()!=null)
				{
					strValorActual=estadopedidopuntoventa.getEstadoPedidoPuntoVentaOriginal().getnombre();
				}
				if(estadopedidopuntoventa.getnombre()!=null)
				{
					strValorNuevo=estadopedidopuntoventa.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoPedidoPuntoVentaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoPedidoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoPedidoPuntoVentaConstantesFunciones.getClassesForeignKeysOfEstadoPedidoPuntoVenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoPedidoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoPedidoPuntoVentaConstantesFunciones.getClassesRelationshipsOfEstadoPedidoPuntoVenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

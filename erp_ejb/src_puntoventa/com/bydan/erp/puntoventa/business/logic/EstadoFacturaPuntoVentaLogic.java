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
import com.bydan.erp.puntoventa.util.EstadoFacturaPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.EstadoFacturaPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.EstadoFacturaPuntoVentaParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.EstadoFacturaPuntoVenta;
//import com.bydan.erp.puntoventa.business.logic.EstadoFacturaPuntoVentaLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class EstadoFacturaPuntoVentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoFacturaPuntoVentaLogic.class);
	
	protected EstadoFacturaPuntoVentaDataAccess estadofacturapuntoventaDataAccess; 	
	protected EstadoFacturaPuntoVenta estadofacturapuntoventa;
	protected List<EstadoFacturaPuntoVenta> estadofacturapuntoventas;
	protected Object estadofacturapuntoventaObject;	
	protected List<Object> estadofacturapuntoventasObject;
	
	public static ClassValidator<EstadoFacturaPuntoVenta> estadofacturapuntoventaValidator = new ClassValidator<EstadoFacturaPuntoVenta>(EstadoFacturaPuntoVenta.class);	
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
	
	
	
	
	public  EstadoFacturaPuntoVentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadofacturapuntoventaDataAccess = new EstadoFacturaPuntoVentaDataAccess();
			
			this.estadofacturapuntoventas= new ArrayList<EstadoFacturaPuntoVenta>();
			this.estadofacturapuntoventa= new EstadoFacturaPuntoVenta();
			
			this.estadofacturapuntoventaObject=new Object();
			this.estadofacturapuntoventasObject=new ArrayList<Object>();
				
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
			
			this.estadofacturapuntoventaDataAccess.setConnexionType(this.connexionType);
			this.estadofacturapuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoFacturaPuntoVentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadofacturapuntoventaDataAccess = new EstadoFacturaPuntoVentaDataAccess();
			this.estadofacturapuntoventas= new ArrayList<EstadoFacturaPuntoVenta>();
			this.estadofacturapuntoventa= new EstadoFacturaPuntoVenta();
			this.estadofacturapuntoventaObject=new Object();
			this.estadofacturapuntoventasObject=new ArrayList<Object>();
			
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
			
			this.estadofacturapuntoventaDataAccess.setConnexionType(this.connexionType);
			this.estadofacturapuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoFacturaPuntoVenta getEstadoFacturaPuntoVenta() throws Exception {	
		//EstadoFacturaPuntoVentaLogicAdditional.checkEstadoFacturaPuntoVentaToGet(estadofacturapuntoventa,this.datosCliente,this.arrDatoGeneral);
		//EstadoFacturaPuntoVentaLogicAdditional.updateEstadoFacturaPuntoVentaToGet(estadofacturapuntoventa,this.arrDatoGeneral);
		
		return estadofacturapuntoventa;
	}
		
	public void setEstadoFacturaPuntoVenta(EstadoFacturaPuntoVenta newEstadoFacturaPuntoVenta) {
		this.estadofacturapuntoventa = newEstadoFacturaPuntoVenta;
	}
	
	public EstadoFacturaPuntoVentaDataAccess getEstadoFacturaPuntoVentaDataAccess() {
		return estadofacturapuntoventaDataAccess;
	}
	
	public void setEstadoFacturaPuntoVentaDataAccess(EstadoFacturaPuntoVentaDataAccess newestadofacturapuntoventaDataAccess) {
		this.estadofacturapuntoventaDataAccess = newestadofacturapuntoventaDataAccess;
	}
	
	public List<EstadoFacturaPuntoVenta> getEstadoFacturaPuntoVentas() throws Exception {		
		this.quitarEstadoFacturaPuntoVentasNulos();
		
		//EstadoFacturaPuntoVentaLogicAdditional.checkEstadoFacturaPuntoVentaToGets(estadofacturapuntoventas,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoFacturaPuntoVenta estadofacturapuntoventaLocal: estadofacturapuntoventas ) {
			//EstadoFacturaPuntoVentaLogicAdditional.updateEstadoFacturaPuntoVentaToGet(estadofacturapuntoventaLocal,this.arrDatoGeneral);
		}
		
		return estadofacturapuntoventas;
	}
	
	public void setEstadoFacturaPuntoVentas(List<EstadoFacturaPuntoVenta> newEstadoFacturaPuntoVentas) {
		this.estadofacturapuntoventas = newEstadoFacturaPuntoVentas;
	}
	
	public Object getEstadoFacturaPuntoVentaObject() {	
		this.estadofacturapuntoventaObject=this.estadofacturapuntoventaDataAccess.getEntityObject();
		return this.estadofacturapuntoventaObject;
	}
		
	public void setEstadoFacturaPuntoVentaObject(Object newEstadoFacturaPuntoVentaObject) {
		this.estadofacturapuntoventaObject = newEstadoFacturaPuntoVentaObject;
	}
	
	public List<Object> getEstadoFacturaPuntoVentasObject() {		
		this.estadofacturapuntoventasObject=this.estadofacturapuntoventaDataAccess.getEntitiesObject();
		return this.estadofacturapuntoventasObject;
	}
		
	public void setEstadoFacturaPuntoVentasObject(List<Object> newEstadoFacturaPuntoVentasObject) {
		this.estadofacturapuntoventasObject = newEstadoFacturaPuntoVentasObject;
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
		
		if(this.estadofacturapuntoventaDataAccess!=null) {
			this.estadofacturapuntoventaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFacturaPuntoVenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadofacturapuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadofacturapuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadofacturapuntoventa = new  EstadoFacturaPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFacturaPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadofacturapuntoventa=estadofacturapuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadofacturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFacturaPuntoVenta(this.estadofacturapuntoventa);
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
		estadofacturapuntoventa = new  EstadoFacturaPuntoVenta();
		  		  
        try {
			
			estadofacturapuntoventa=estadofacturapuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadofacturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFacturaPuntoVenta(this.estadofacturapuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadofacturapuntoventa = new  EstadoFacturaPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFacturaPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadofacturapuntoventa=estadofacturapuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadofacturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFacturaPuntoVenta(this.estadofacturapuntoventa);
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
		estadofacturapuntoventa = new  EstadoFacturaPuntoVenta();
		  		  
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
		estadofacturapuntoventa = new  EstadoFacturaPuntoVenta();
		  		  
        try {
			
			estadofacturapuntoventa=estadofacturapuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadofacturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFacturaPuntoVenta(this.estadofacturapuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadofacturapuntoventa = new  EstadoFacturaPuntoVenta();
		  		  
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
		estadofacturapuntoventa = new  EstadoFacturaPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFacturaPuntoVenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadofacturapuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadofacturapuntoventa = new  EstadoFacturaPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadofacturapuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadofacturapuntoventa = new  EstadoFacturaPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFacturaPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadofacturapuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadofacturapuntoventa = new  EstadoFacturaPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadofacturapuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadofacturapuntoventa = new  EstadoFacturaPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFacturaPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadofacturapuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadofacturapuntoventa = new  EstadoFacturaPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadofacturapuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadofacturapuntoventas = new  ArrayList<EstadoFacturaPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFacturaPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofacturapuntoventas=estadofacturapuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoFacturaPuntoVenta(estadofacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFacturaPuntoVenta(this.estadofacturapuntoventas);
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
		estadofacturapuntoventas = new  ArrayList<EstadoFacturaPuntoVenta>();
		  		  
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
		estadofacturapuntoventas = new  ArrayList<EstadoFacturaPuntoVenta>();
		  		  
        try {			
			EstadoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofacturapuntoventas=estadofacturapuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoFacturaPuntoVenta(estadofacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFacturaPuntoVenta(this.estadofacturapuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadofacturapuntoventas = new  ArrayList<EstadoFacturaPuntoVenta>();
		  		  
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
		estadofacturapuntoventas = new  ArrayList<EstadoFacturaPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFacturaPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofacturapuntoventas=estadofacturapuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoFacturaPuntoVenta(estadofacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFacturaPuntoVenta(this.estadofacturapuntoventas);
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
		estadofacturapuntoventas = new  ArrayList<EstadoFacturaPuntoVenta>();
		  		  
        try {
			EstadoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofacturapuntoventas=estadofacturapuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoFacturaPuntoVenta(estadofacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFacturaPuntoVenta(this.estadofacturapuntoventas);
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
		estadofacturapuntoventas = new  ArrayList<EstadoFacturaPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFacturaPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofacturapuntoventas=estadofacturapuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoFacturaPuntoVenta(estadofacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFacturaPuntoVenta(this.estadofacturapuntoventas);
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
		estadofacturapuntoventas = new  ArrayList<EstadoFacturaPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofacturapuntoventas=estadofacturapuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoFacturaPuntoVenta(estadofacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFacturaPuntoVenta(this.estadofacturapuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadofacturapuntoventa = new  EstadoFacturaPuntoVenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFacturaPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofacturapuntoventa=estadofacturapuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoFacturaPuntoVenta(estadofacturapuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFacturaPuntoVenta(this.estadofacturapuntoventa);
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
		estadofacturapuntoventa = new  EstadoFacturaPuntoVenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofacturapuntoventa=estadofacturapuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoFacturaPuntoVenta(estadofacturapuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFacturaPuntoVenta(this.estadofacturapuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosEstadoFacturaPuntoVentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadofacturapuntoventas = new  ArrayList<EstadoFacturaPuntoVenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFacturaPuntoVenta.class.getSimpleName()+"-getTodosEstadoFacturaPuntoVentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofacturapuntoventas=estadofacturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoFacturaPuntoVenta(estadofacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFacturaPuntoVenta(this.estadofacturapuntoventas);
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
	
	public  void  getTodosEstadoFacturaPuntoVentas(String sFinalQuery,Pagination pagination)throws Exception {
		estadofacturapuntoventas = new  ArrayList<EstadoFacturaPuntoVenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofacturapuntoventas=estadofacturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoFacturaPuntoVenta(estadofacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFacturaPuntoVenta(this.estadofacturapuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoFacturaPuntoVenta(EstadoFacturaPuntoVenta estadofacturapuntoventa) throws Exception {
		Boolean estaValidado=false;
		
		if(estadofacturapuntoventa.getIsNew() || estadofacturapuntoventa.getIsChanged()) { 
			this.invalidValues = estadofacturapuntoventaValidator.getInvalidValues(estadofacturapuntoventa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadofacturapuntoventa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoFacturaPuntoVenta(List<EstadoFacturaPuntoVenta> EstadoFacturaPuntoVentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoFacturaPuntoVenta estadofacturapuntoventaLocal:estadofacturapuntoventas) {				
			estaValidadoObjeto=this.validarGuardarEstadoFacturaPuntoVenta(estadofacturapuntoventaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoFacturaPuntoVenta(List<EstadoFacturaPuntoVenta> EstadoFacturaPuntoVentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoFacturaPuntoVenta(estadofacturapuntoventas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoFacturaPuntoVenta(EstadoFacturaPuntoVenta EstadoFacturaPuntoVenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoFacturaPuntoVenta(estadofacturapuntoventa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoFacturaPuntoVenta estadofacturapuntoventa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadofacturapuntoventa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoFacturaPuntoVentaConstantesFunciones.getEstadoFacturaPuntoVentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadofacturapuntoventa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoFacturaPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoFacturaPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoFacturaPuntoVentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFacturaPuntoVenta.class.getSimpleName()+"-saveEstadoFacturaPuntoVentaWithConnection");connexion.begin();			
			
			//EstadoFacturaPuntoVentaLogicAdditional.checkEstadoFacturaPuntoVentaToSave(this.estadofacturapuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoFacturaPuntoVentaLogicAdditional.updateEstadoFacturaPuntoVentaToSave(this.estadofacturapuntoventa,this.arrDatoGeneral);
			
			EstadoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadofacturapuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoFacturaPuntoVenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoFacturaPuntoVenta(this.estadofacturapuntoventa)) {
				EstadoFacturaPuntoVentaDataAccess.save(this.estadofacturapuntoventa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadofacturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoFacturaPuntoVentaLogicAdditional.checkEstadoFacturaPuntoVentaToSaveAfter(this.estadofacturapuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoFacturaPuntoVenta();
			
			connexion.commit();			
			
			if(this.estadofacturapuntoventa.getIsDeleted()) {
				this.estadofacturapuntoventa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoFacturaPuntoVenta()throws Exception {	
		try {	
			
			//EstadoFacturaPuntoVentaLogicAdditional.checkEstadoFacturaPuntoVentaToSave(this.estadofacturapuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoFacturaPuntoVentaLogicAdditional.updateEstadoFacturaPuntoVentaToSave(this.estadofacturapuntoventa,this.arrDatoGeneral);
			
			EstadoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadofacturapuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoFacturaPuntoVenta(this.estadofacturapuntoventa)) {			
				EstadoFacturaPuntoVentaDataAccess.save(this.estadofacturapuntoventa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadofacturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoFacturaPuntoVentaLogicAdditional.checkEstadoFacturaPuntoVentaToSaveAfter(this.estadofacturapuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadofacturapuntoventa.getIsDeleted()) {
				this.estadofacturapuntoventa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoFacturaPuntoVentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFacturaPuntoVenta.class.getSimpleName()+"-saveEstadoFacturaPuntoVentasWithConnection");connexion.begin();			
			
			//EstadoFacturaPuntoVentaLogicAdditional.checkEstadoFacturaPuntoVentaToSaves(estadofacturapuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoFacturaPuntoVentas();
			
			Boolean validadoTodosEstadoFacturaPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoFacturaPuntoVenta estadofacturapuntoventaLocal:estadofacturapuntoventas) {		
				if(estadofacturapuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoFacturaPuntoVentaLogicAdditional.updateEstadoFacturaPuntoVentaToSave(estadofacturapuntoventaLocal,this.arrDatoGeneral);
	        	
				EstadoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadofacturapuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoFacturaPuntoVenta(estadofacturapuntoventaLocal)) {
					EstadoFacturaPuntoVentaDataAccess.save(estadofacturapuntoventaLocal, connexion);				
				} else {
					validadoTodosEstadoFacturaPuntoVenta=false;
				}
			}
			
			if(!validadoTodosEstadoFacturaPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoFacturaPuntoVentaLogicAdditional.checkEstadoFacturaPuntoVentaToSavesAfter(estadofacturapuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoFacturaPuntoVentas();
			
			connexion.commit();		
			
			this.quitarEstadoFacturaPuntoVentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoFacturaPuntoVentas()throws Exception {				
		 try {	
			//EstadoFacturaPuntoVentaLogicAdditional.checkEstadoFacturaPuntoVentaToSaves(estadofacturapuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoFacturaPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoFacturaPuntoVenta estadofacturapuntoventaLocal:estadofacturapuntoventas) {				
				if(estadofacturapuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoFacturaPuntoVentaLogicAdditional.updateEstadoFacturaPuntoVentaToSave(estadofacturapuntoventaLocal,this.arrDatoGeneral);
	        	
				EstadoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadofacturapuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoFacturaPuntoVenta(estadofacturapuntoventaLocal)) {				
					EstadoFacturaPuntoVentaDataAccess.save(estadofacturapuntoventaLocal, connexion);				
				} else {
					validadoTodosEstadoFacturaPuntoVenta=false;
				}
			}
			
			if(!validadoTodosEstadoFacturaPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoFacturaPuntoVentaLogicAdditional.checkEstadoFacturaPuntoVentaToSavesAfter(estadofacturapuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoFacturaPuntoVentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoFacturaPuntoVentaParameterReturnGeneral procesarAccionEstadoFacturaPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoFacturaPuntoVenta> estadofacturapuntoventas,EstadoFacturaPuntoVentaParameterReturnGeneral estadofacturapuntoventaParameterGeneral)throws Exception {
		 try {	
			EstadoFacturaPuntoVentaParameterReturnGeneral estadofacturapuntoventaReturnGeneral=new EstadoFacturaPuntoVentaParameterReturnGeneral();
	
			
			return estadofacturapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoFacturaPuntoVentaParameterReturnGeneral procesarAccionEstadoFacturaPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoFacturaPuntoVenta> estadofacturapuntoventas,EstadoFacturaPuntoVentaParameterReturnGeneral estadofacturapuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFacturaPuntoVenta.class.getSimpleName()+"-procesarAccionEstadoFacturaPuntoVentasWithConnection");connexion.begin();			
			
			EstadoFacturaPuntoVentaParameterReturnGeneral estadofacturapuntoventaReturnGeneral=new EstadoFacturaPuntoVentaParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return estadofacturapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoFacturaPuntoVentaParameterReturnGeneral procesarEventosEstadoFacturaPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoFacturaPuntoVenta> estadofacturapuntoventas,EstadoFacturaPuntoVenta estadofacturapuntoventa,EstadoFacturaPuntoVentaParameterReturnGeneral estadofacturapuntoventaParameterGeneral,Boolean isEsNuevoEstadoFacturaPuntoVenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoFacturaPuntoVentaParameterReturnGeneral estadofacturapuntoventaReturnGeneral=new EstadoFacturaPuntoVentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadofacturapuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return estadofacturapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoFacturaPuntoVentaParameterReturnGeneral procesarEventosEstadoFacturaPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoFacturaPuntoVenta> estadofacturapuntoventas,EstadoFacturaPuntoVenta estadofacturapuntoventa,EstadoFacturaPuntoVentaParameterReturnGeneral estadofacturapuntoventaParameterGeneral,Boolean isEsNuevoEstadoFacturaPuntoVenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFacturaPuntoVenta.class.getSimpleName()+"-procesarEventosEstadoFacturaPuntoVentasWithConnection");connexion.begin();			
			
			EstadoFacturaPuntoVentaParameterReturnGeneral estadofacturapuntoventaReturnGeneral=new EstadoFacturaPuntoVentaParameterReturnGeneral();
	
			estadofacturapuntoventaReturnGeneral.setEstadoFacturaPuntoVenta(estadofacturapuntoventa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadofacturapuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return estadofacturapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoFacturaPuntoVentaParameterReturnGeneral procesarImportacionEstadoFacturaPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoFacturaPuntoVentaParameterReturnGeneral estadofacturapuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFacturaPuntoVenta.class.getSimpleName()+"-procesarImportacionEstadoFacturaPuntoVentasWithConnection");connexion.begin();			
			
			EstadoFacturaPuntoVentaParameterReturnGeneral estadofacturapuntoventaReturnGeneral=new EstadoFacturaPuntoVentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadofacturapuntoventas=new ArrayList<EstadoFacturaPuntoVenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadofacturapuntoventa=new EstadoFacturaPuntoVenta();
				
				
				if(conColumnasBase) {this.estadofacturapuntoventa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadofacturapuntoventa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadofacturapuntoventa.setnombre(arrColumnas[iColumn++]);
				
				this.estadofacturapuntoventas.add(this.estadofacturapuntoventa);
			}
			
			this.saveEstadoFacturaPuntoVentas();
			
			this.connexion.commit();
			
			estadofacturapuntoventaReturnGeneral.setConRetornoEstaProcesado(true);
			estadofacturapuntoventaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadofacturapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoFacturaPuntoVentasEliminados() throws Exception {				
		
		List<EstadoFacturaPuntoVenta> estadofacturapuntoventasAux= new ArrayList<EstadoFacturaPuntoVenta>();
		
		for(EstadoFacturaPuntoVenta estadofacturapuntoventa:estadofacturapuntoventas) {
			if(!estadofacturapuntoventa.getIsDeleted()) {
				estadofacturapuntoventasAux.add(estadofacturapuntoventa);
			}
		}
		
		estadofacturapuntoventas=estadofacturapuntoventasAux;
	}
	
	public void quitarEstadoFacturaPuntoVentasNulos() throws Exception {				
		
		List<EstadoFacturaPuntoVenta> estadofacturapuntoventasAux= new ArrayList<EstadoFacturaPuntoVenta>();
		
		for(EstadoFacturaPuntoVenta estadofacturapuntoventa : this.estadofacturapuntoventas) {
			if(estadofacturapuntoventa==null) {
				estadofacturapuntoventasAux.add(estadofacturapuntoventa);
			}
		}
		
		//this.estadofacturapuntoventas=estadofacturapuntoventasAux;
		
		this.estadofacturapuntoventas.removeAll(estadofacturapuntoventasAux);
	}
	
	public void getSetVersionRowEstadoFacturaPuntoVentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadofacturapuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadofacturapuntoventa.getIsDeleted() || (estadofacturapuntoventa.getIsChanged()&&!estadofacturapuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadofacturapuntoventaDataAccess.getSetVersionRowEstadoFacturaPuntoVenta(connexion,estadofacturapuntoventa.getId());
				
				if(!estadofacturapuntoventa.getVersionRow().equals(timestamp)) {	
					estadofacturapuntoventa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadofacturapuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoFacturaPuntoVenta()throws Exception {	
		
		if(estadofacturapuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadofacturapuntoventa.getIsDeleted() || (estadofacturapuntoventa.getIsChanged()&&!estadofacturapuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadofacturapuntoventaDataAccess.getSetVersionRowEstadoFacturaPuntoVenta(connexion,estadofacturapuntoventa.getId());
			
			try {							
				if(!estadofacturapuntoventa.getVersionRow().equals(timestamp)) {	
					estadofacturapuntoventa.setVersionRow(timestamp);
				}
				
				estadofacturapuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoFacturaPuntoVentasWithConnection()throws Exception {	
		if(estadofacturapuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoFacturaPuntoVenta estadofacturapuntoventaAux:estadofacturapuntoventas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadofacturapuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadofacturapuntoventaAux.getIsDeleted() || (estadofacturapuntoventaAux.getIsChanged()&&!estadofacturapuntoventaAux.getIsNew())) {
						
						timestamp=estadofacturapuntoventaDataAccess.getSetVersionRowEstadoFacturaPuntoVenta(connexion,estadofacturapuntoventaAux.getId());
						
						if(!estadofacturapuntoventa.getVersionRow().equals(timestamp)) {	
							estadofacturapuntoventaAux.setVersionRow(timestamp);
						}
								
						estadofacturapuntoventaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoFacturaPuntoVentas()throws Exception {	
		if(estadofacturapuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoFacturaPuntoVenta estadofacturapuntoventaAux:estadofacturapuntoventas) {
					if(estadofacturapuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadofacturapuntoventaAux.getIsDeleted() || (estadofacturapuntoventaAux.getIsChanged()&&!estadofacturapuntoventaAux.getIsNew())) {
						
						timestamp=estadofacturapuntoventaDataAccess.getSetVersionRowEstadoFacturaPuntoVenta(connexion,estadofacturapuntoventaAux.getId());
						
						if(!estadofacturapuntoventaAux.getVersionRow().equals(timestamp)) {	
							estadofacturapuntoventaAux.setVersionRow(timestamp);
						}
						
													
						estadofacturapuntoventaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoFacturaPuntoVentaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			FacturaPuntoVentaLogic facturapuntoventaLogic=new FacturaPuntoVentaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFacturaPuntoVenta.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoFacturaPuntoVentaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(FacturaPuntoVenta.class));
											
			

			facturapuntoventaLogic.setConnexion(this.getConnexion());
			facturapuntoventaLogic.setDatosCliente(this.datosCliente);
			facturapuntoventaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoFacturaPuntoVenta estadofacturapuntoventa:this.estadofacturapuntoventas) {
				

				classes=new ArrayList<Classe>();
				classes=FacturaPuntoVentaConstantesFunciones.getClassesForeignKeysOfFacturaPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				facturapuntoventaLogic.setFacturaPuntoVentas(estadofacturapuntoventa.facturapuntoventas);
				facturapuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoFacturaPuntoVenta estadofacturapuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//EstadoFacturaPuntoVentaLogicAdditional.updateEstadoFacturaPuntoVentaToGet(estadofacturapuntoventa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadofacturapuntoventa.setFacturaPuntoVentas(estadofacturapuntoventaDataAccess.getFacturaPuntoVentas(connexion,estadofacturapuntoventa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadofacturapuntoventa.setFacturaPuntoVentas(estadofacturapuntoventaDataAccess.getFacturaPuntoVentas(connexion,estadofacturapuntoventa));

				if(this.isConDeep) {
					FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(this.connexion);
					facturapuntoventaLogic.setFacturaPuntoVentas(estadofacturapuntoventa.getFacturaPuntoVentas());
					ArrayList<Classe> classesLocal=FacturaPuntoVentaConstantesFunciones.getClassesForeignKeysOfFacturaPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					facturapuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(facturapuntoventaLogic.getFacturaPuntoVentas());
					estadofacturapuntoventa.setFacturaPuntoVentas(facturapuntoventaLogic.getFacturaPuntoVentas());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FacturaPuntoVenta.class));
			estadofacturapuntoventa.setFacturaPuntoVentas(estadofacturapuntoventaDataAccess.getFacturaPuntoVentas(connexion,estadofacturapuntoventa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadofacturapuntoventa.setFacturaPuntoVentas(estadofacturapuntoventaDataAccess.getFacturaPuntoVentas(connexion,estadofacturapuntoventa));

		for(FacturaPuntoVenta facturapuntoventa:estadofacturapuntoventa.getFacturaPuntoVentas()) {
			FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
			facturapuntoventaLogic.deepLoad(facturapuntoventa,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadofacturapuntoventa.setFacturaPuntoVentas(estadofacturapuntoventaDataAccess.getFacturaPuntoVentas(connexion,estadofacturapuntoventa));

				for(FacturaPuntoVenta facturapuntoventa:estadofacturapuntoventa.getFacturaPuntoVentas()) {
					FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
					facturapuntoventaLogic.deepLoad(facturapuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FacturaPuntoVenta.class));
			estadofacturapuntoventa.setFacturaPuntoVentas(estadofacturapuntoventaDataAccess.getFacturaPuntoVentas(connexion,estadofacturapuntoventa));

			for(FacturaPuntoVenta facturapuntoventa:estadofacturapuntoventa.getFacturaPuntoVentas()) {
				FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
				facturapuntoventaLogic.deepLoad(facturapuntoventa,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoFacturaPuntoVenta estadofacturapuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoFacturaPuntoVenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadofacturapuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFacturaPuntoVenta(estadofacturapuntoventa);
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
			this.deepLoad(this.estadofacturapuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFacturaPuntoVenta(this.estadofacturapuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoFacturaPuntoVenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadofacturapuntoventas!=null) {
				for(EstadoFacturaPuntoVenta estadofacturapuntoventa:estadofacturapuntoventas) {
					this.deepLoad(estadofacturapuntoventa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFacturaPuntoVenta(estadofacturapuntoventas);
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
			if(estadofacturapuntoventas!=null) {
				for(EstadoFacturaPuntoVenta estadofacturapuntoventa:estadofacturapuntoventas) {
					this.deepLoad(estadofacturapuntoventa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFacturaPuntoVenta(estadofacturapuntoventas);
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
			if(EstadoFacturaPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoFacturaPuntoVentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoFacturaPuntoVenta estadofacturapuntoventa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoFacturaPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				if(estadofacturapuntoventa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoFacturaPuntoVentaDataAccess.TABLENAME, estadofacturapuntoventa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoFacturaPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoFacturaPuntoVentaLogic.registrarAuditoriaDetallesEstadoFacturaPuntoVenta(connexion,estadofacturapuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadofacturapuntoventa.getIsDeleted()) {
					/*if(!estadofacturapuntoventa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoFacturaPuntoVentaDataAccess.TABLENAME, estadofacturapuntoventa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoFacturaPuntoVentaLogic.registrarAuditoriaDetallesEstadoFacturaPuntoVenta(connexion,estadofacturapuntoventa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoFacturaPuntoVentaDataAccess.TABLENAME, estadofacturapuntoventa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadofacturapuntoventa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoFacturaPuntoVentaDataAccess.TABLENAME, estadofacturapuntoventa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoFacturaPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoFacturaPuntoVentaLogic.registrarAuditoriaDetallesEstadoFacturaPuntoVenta(connexion,estadofacturapuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoFacturaPuntoVenta(Connexion connexion,EstadoFacturaPuntoVenta estadofacturapuntoventa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadofacturapuntoventa.getIsNew()||!estadofacturapuntoventa.getnombre().equals(estadofacturapuntoventa.getEstadoFacturaPuntoVentaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadofacturapuntoventa.getEstadoFacturaPuntoVentaOriginal().getnombre()!=null)
				{
					strValorActual=estadofacturapuntoventa.getEstadoFacturaPuntoVentaOriginal().getnombre();
				}
				if(estadofacturapuntoventa.getnombre()!=null)
				{
					strValorNuevo=estadofacturapuntoventa.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoFacturaPuntoVentaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoFacturaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoFacturaPuntoVentaConstantesFunciones.getClassesForeignKeysOfEstadoFacturaPuntoVenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoFacturaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoFacturaPuntoVentaConstantesFunciones.getClassesRelationshipsOfEstadoFacturaPuntoVenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

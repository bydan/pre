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
import com.bydan.erp.puntoventa.util.DetallePedidoPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.DetallePedidoPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.DetallePedidoPuntoVentaParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.DetallePedidoPuntoVenta;
import com.bydan.erp.puntoventa.business.logic.DetallePedidoPuntoVentaLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetallePedidoPuntoVentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetallePedidoPuntoVentaLogic.class);
	
	protected DetallePedidoPuntoVentaDataAccess detallepedidopuntoventaDataAccess; 	
	protected DetallePedidoPuntoVenta detallepedidopuntoventa;
	protected List<DetallePedidoPuntoVenta> detallepedidopuntoventas;
	protected Object detallepedidopuntoventaObject;	
	protected List<Object> detallepedidopuntoventasObject;
	
	public static ClassValidator<DetallePedidoPuntoVenta> detallepedidopuntoventaValidator = new ClassValidator<DetallePedidoPuntoVenta>(DetallePedidoPuntoVenta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetallePedidoPuntoVentaLogicAdditional detallepedidopuntoventaLogicAdditional=null;
	
	public DetallePedidoPuntoVentaLogicAdditional getDetallePedidoPuntoVentaLogicAdditional() {
		return this.detallepedidopuntoventaLogicAdditional;
	}
	
	public void setDetallePedidoPuntoVentaLogicAdditional(DetallePedidoPuntoVentaLogicAdditional detallepedidopuntoventaLogicAdditional) {
		try {
			this.detallepedidopuntoventaLogicAdditional=detallepedidopuntoventaLogicAdditional;
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
	
	
	
	
	public  DetallePedidoPuntoVentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detallepedidopuntoventaDataAccess = new DetallePedidoPuntoVentaDataAccess();
			
			this.detallepedidopuntoventas= new ArrayList<DetallePedidoPuntoVenta>();
			this.detallepedidopuntoventa= new DetallePedidoPuntoVenta();
			
			this.detallepedidopuntoventaObject=new Object();
			this.detallepedidopuntoventasObject=new ArrayList<Object>();
				
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
			
			this.detallepedidopuntoventaDataAccess.setConnexionType(this.connexionType);
			this.detallepedidopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetallePedidoPuntoVentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detallepedidopuntoventaDataAccess = new DetallePedidoPuntoVentaDataAccess();
			this.detallepedidopuntoventas= new ArrayList<DetallePedidoPuntoVenta>();
			this.detallepedidopuntoventa= new DetallePedidoPuntoVenta();
			this.detallepedidopuntoventaObject=new Object();
			this.detallepedidopuntoventasObject=new ArrayList<Object>();
			
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
			
			this.detallepedidopuntoventaDataAccess.setConnexionType(this.connexionType);
			this.detallepedidopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetallePedidoPuntoVenta getDetallePedidoPuntoVenta() throws Exception {	
		DetallePedidoPuntoVentaLogicAdditional.checkDetallePedidoPuntoVentaToGet(detallepedidopuntoventa,this.datosCliente,this.arrDatoGeneral);
		DetallePedidoPuntoVentaLogicAdditional.updateDetallePedidoPuntoVentaToGet(detallepedidopuntoventa,this.arrDatoGeneral);
		
		return detallepedidopuntoventa;
	}
		
	public void setDetallePedidoPuntoVenta(DetallePedidoPuntoVenta newDetallePedidoPuntoVenta) {
		this.detallepedidopuntoventa = newDetallePedidoPuntoVenta;
	}
	
	public DetallePedidoPuntoVentaDataAccess getDetallePedidoPuntoVentaDataAccess() {
		return detallepedidopuntoventaDataAccess;
	}
	
	public void setDetallePedidoPuntoVentaDataAccess(DetallePedidoPuntoVentaDataAccess newdetallepedidopuntoventaDataAccess) {
		this.detallepedidopuntoventaDataAccess = newdetallepedidopuntoventaDataAccess;
	}
	
	public List<DetallePedidoPuntoVenta> getDetallePedidoPuntoVentas() throws Exception {		
		this.quitarDetallePedidoPuntoVentasNulos();
		
		DetallePedidoPuntoVentaLogicAdditional.checkDetallePedidoPuntoVentaToGets(detallepedidopuntoventas,this.datosCliente,this.arrDatoGeneral);
		
		for (DetallePedidoPuntoVenta detallepedidopuntoventaLocal: detallepedidopuntoventas ) {
			DetallePedidoPuntoVentaLogicAdditional.updateDetallePedidoPuntoVentaToGet(detallepedidopuntoventaLocal,this.arrDatoGeneral);
		}
		
		return detallepedidopuntoventas;
	}
	
	public void setDetallePedidoPuntoVentas(List<DetallePedidoPuntoVenta> newDetallePedidoPuntoVentas) {
		this.detallepedidopuntoventas = newDetallePedidoPuntoVentas;
	}
	
	public Object getDetallePedidoPuntoVentaObject() {	
		this.detallepedidopuntoventaObject=this.detallepedidopuntoventaDataAccess.getEntityObject();
		return this.detallepedidopuntoventaObject;
	}
		
	public void setDetallePedidoPuntoVentaObject(Object newDetallePedidoPuntoVentaObject) {
		this.detallepedidopuntoventaObject = newDetallePedidoPuntoVentaObject;
	}
	
	public List<Object> getDetallePedidoPuntoVentasObject() {		
		this.detallepedidopuntoventasObject=this.detallepedidopuntoventaDataAccess.getEntitiesObject();
		return this.detallepedidopuntoventasObject;
	}
		
	public void setDetallePedidoPuntoVentasObject(List<Object> newDetallePedidoPuntoVentasObject) {
		this.detallepedidopuntoventasObject = newDetallePedidoPuntoVentasObject;
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
		
		if(this.detallepedidopuntoventaDataAccess!=null) {
			this.detallepedidopuntoventaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detallepedidopuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detallepedidopuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detallepedidopuntoventa = new  DetallePedidoPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallepedidopuntoventa=detallepedidopuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallepedidopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventa);
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
		detallepedidopuntoventa = new  DetallePedidoPuntoVenta();
		  		  
        try {
			
			detallepedidopuntoventa=detallepedidopuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallepedidopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detallepedidopuntoventa = new  DetallePedidoPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallepedidopuntoventa=detallepedidopuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallepedidopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventa);
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
		detallepedidopuntoventa = new  DetallePedidoPuntoVenta();
		  		  
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
		detallepedidopuntoventa = new  DetallePedidoPuntoVenta();
		  		  
        try {
			
			detallepedidopuntoventa=detallepedidopuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallepedidopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detallepedidopuntoventa = new  DetallePedidoPuntoVenta();
		  		  
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
		detallepedidopuntoventa = new  DetallePedidoPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detallepedidopuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallepedidopuntoventa = new  DetallePedidoPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detallepedidopuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallepedidopuntoventa = new  DetallePedidoPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detallepedidopuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallepedidopuntoventa = new  DetallePedidoPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detallepedidopuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallepedidopuntoventa = new  DetallePedidoPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detallepedidopuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallepedidopuntoventa = new  DetallePedidoPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detallepedidopuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallepedidopuntoventas = new  ArrayList<DetallePedidoPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedidoPuntoVenta(detallepedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
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
		detallepedidopuntoventas = new  ArrayList<DetallePedidoPuntoVenta>();
		  		  
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
		detallepedidopuntoventas = new  ArrayList<DetallePedidoPuntoVenta>();
		  		  
        try {			
			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetallePedidoPuntoVenta(detallepedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detallepedidopuntoventas = new  ArrayList<DetallePedidoPuntoVenta>();
		  		  
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
		detallepedidopuntoventas = new  ArrayList<DetallePedidoPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedidoPuntoVenta(detallepedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
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
		detallepedidopuntoventas = new  ArrayList<DetallePedidoPuntoVenta>();
		  		  
        try {
			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedidoPuntoVenta(detallepedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
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
		detallepedidopuntoventas = new  ArrayList<DetallePedidoPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePedidoPuntoVenta(detallepedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
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
		detallepedidopuntoventas = new  ArrayList<DetallePedidoPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePedidoPuntoVenta(detallepedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detallepedidopuntoventa = new  DetallePedidoPuntoVenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidopuntoventa=detallepedidopuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePedidoPuntoVenta(detallepedidopuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventa);
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
		detallepedidopuntoventa = new  DetallePedidoPuntoVenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidopuntoventa=detallepedidopuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePedidoPuntoVenta(detallepedidopuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallepedidopuntoventas = new  ArrayList<DetallePedidoPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedidoPuntoVenta(detallepedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
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
		detallepedidopuntoventas = new  ArrayList<DetallePedidoPuntoVenta>();
		  		  
        try {
			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedidoPuntoVenta(detallepedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetallePedidoPuntoVentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detallepedidopuntoventas = new  ArrayList<DetallePedidoPuntoVenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-getTodosDetallePedidoPuntoVentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetallePedidoPuntoVenta(detallepedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
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
	
	public  void  getTodosDetallePedidoPuntoVentas(String sFinalQuery,Pagination pagination)throws Exception {
		detallepedidopuntoventas = new  ArrayList<DetallePedidoPuntoVenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetallePedidoPuntoVenta(detallepedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetallePedidoPuntoVenta(DetallePedidoPuntoVenta detallepedidopuntoventa) throws Exception {
		Boolean estaValidado=false;
		
		if(detallepedidopuntoventa.getIsNew() || detallepedidopuntoventa.getIsChanged()) { 
			this.invalidValues = detallepedidopuntoventaValidator.getInvalidValues(detallepedidopuntoventa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detallepedidopuntoventa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetallePedidoPuntoVenta(List<DetallePedidoPuntoVenta> DetallePedidoPuntoVentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetallePedidoPuntoVenta detallepedidopuntoventaLocal:detallepedidopuntoventas) {				
			estaValidadoObjeto=this.validarGuardarDetallePedidoPuntoVenta(detallepedidopuntoventaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetallePedidoPuntoVenta(List<DetallePedidoPuntoVenta> DetallePedidoPuntoVentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetallePedidoPuntoVenta(detallepedidopuntoventas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetallePedidoPuntoVenta(DetallePedidoPuntoVenta DetallePedidoPuntoVenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetallePedidoPuntoVenta(detallepedidopuntoventa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetallePedidoPuntoVenta detallepedidopuntoventa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detallepedidopuntoventa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetallePedidoPuntoVentaConstantesFunciones.getDetallePedidoPuntoVentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detallepedidopuntoventa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetallePedidoPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetallePedidoPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetallePedidoPuntoVentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-saveDetallePedidoPuntoVentaWithConnection");connexion.begin();			
			
			DetallePedidoPuntoVentaLogicAdditional.checkDetallePedidoPuntoVentaToSave(this.detallepedidopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetallePedidoPuntoVentaLogicAdditional.updateDetallePedidoPuntoVentaToSave(this.detallepedidopuntoventa,this.arrDatoGeneral);
			
			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallepedidopuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetallePedidoPuntoVenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetallePedidoPuntoVenta(this.detallepedidopuntoventa)) {
				DetallePedidoPuntoVentaDataAccess.save(this.detallepedidopuntoventa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detallepedidopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetallePedidoPuntoVentaLogicAdditional.checkDetallePedidoPuntoVentaToSaveAfter(this.detallepedidopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetallePedidoPuntoVenta();
			
			connexion.commit();			
			
			if(this.detallepedidopuntoventa.getIsDeleted()) {
				this.detallepedidopuntoventa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetallePedidoPuntoVenta()throws Exception {	
		try {	
			
			DetallePedidoPuntoVentaLogicAdditional.checkDetallePedidoPuntoVentaToSave(this.detallepedidopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetallePedidoPuntoVentaLogicAdditional.updateDetallePedidoPuntoVentaToSave(this.detallepedidopuntoventa,this.arrDatoGeneral);
			
			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallepedidopuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetallePedidoPuntoVenta(this.detallepedidopuntoventa)) {			
				DetallePedidoPuntoVentaDataAccess.save(this.detallepedidopuntoventa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detallepedidopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetallePedidoPuntoVentaLogicAdditional.checkDetallePedidoPuntoVentaToSaveAfter(this.detallepedidopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detallepedidopuntoventa.getIsDeleted()) {
				this.detallepedidopuntoventa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetallePedidoPuntoVentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-saveDetallePedidoPuntoVentasWithConnection");connexion.begin();			
			
			DetallePedidoPuntoVentaLogicAdditional.checkDetallePedidoPuntoVentaToSaves(detallepedidopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetallePedidoPuntoVentas();
			
			Boolean validadoTodosDetallePedidoPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetallePedidoPuntoVenta detallepedidopuntoventaLocal:detallepedidopuntoventas) {		
				if(detallepedidopuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetallePedidoPuntoVentaLogicAdditional.updateDetallePedidoPuntoVentaToSave(detallepedidopuntoventaLocal,this.arrDatoGeneral);
	        	
				DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallepedidopuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetallePedidoPuntoVenta(detallepedidopuntoventaLocal)) {
					DetallePedidoPuntoVentaDataAccess.save(detallepedidopuntoventaLocal, connexion);				
				} else {
					validadoTodosDetallePedidoPuntoVenta=false;
				}
			}
			
			if(!validadoTodosDetallePedidoPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetallePedidoPuntoVentaLogicAdditional.checkDetallePedidoPuntoVentaToSavesAfter(detallepedidopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetallePedidoPuntoVentas();
			
			connexion.commit();		
			
			this.quitarDetallePedidoPuntoVentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetallePedidoPuntoVentas()throws Exception {				
		 try {	
			DetallePedidoPuntoVentaLogicAdditional.checkDetallePedidoPuntoVentaToSaves(detallepedidopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetallePedidoPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetallePedidoPuntoVenta detallepedidopuntoventaLocal:detallepedidopuntoventas) {				
				if(detallepedidopuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetallePedidoPuntoVentaLogicAdditional.updateDetallePedidoPuntoVentaToSave(detallepedidopuntoventaLocal,this.arrDatoGeneral);
	        	
				DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallepedidopuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetallePedidoPuntoVenta(detallepedidopuntoventaLocal)) {				
					DetallePedidoPuntoVentaDataAccess.save(detallepedidopuntoventaLocal, connexion);				
				} else {
					validadoTodosDetallePedidoPuntoVenta=false;
				}
			}
			
			if(!validadoTodosDetallePedidoPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetallePedidoPuntoVentaLogicAdditional.checkDetallePedidoPuntoVentaToSavesAfter(detallepedidopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetallePedidoPuntoVentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetallePedidoPuntoVentaParameterReturnGeneral procesarAccionDetallePedidoPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetallePedidoPuntoVenta> detallepedidopuntoventas,DetallePedidoPuntoVentaParameterReturnGeneral detallepedidopuntoventaParameterGeneral)throws Exception {
		 try {	
			DetallePedidoPuntoVentaParameterReturnGeneral detallepedidopuntoventaReturnGeneral=new DetallePedidoPuntoVentaParameterReturnGeneral();
	
			DetallePedidoPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallepedidopuntoventas,detallepedidopuntoventaParameterGeneral,detallepedidopuntoventaReturnGeneral);
			
			return detallepedidopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetallePedidoPuntoVentaParameterReturnGeneral procesarAccionDetallePedidoPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetallePedidoPuntoVenta> detallepedidopuntoventas,DetallePedidoPuntoVentaParameterReturnGeneral detallepedidopuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-procesarAccionDetallePedidoPuntoVentasWithConnection");connexion.begin();			
			
			DetallePedidoPuntoVentaParameterReturnGeneral detallepedidopuntoventaReturnGeneral=new DetallePedidoPuntoVentaParameterReturnGeneral();
	
			DetallePedidoPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallepedidopuntoventas,detallepedidopuntoventaParameterGeneral,detallepedidopuntoventaReturnGeneral);
			
			this.connexion.commit();
			
			return detallepedidopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetallePedidoPuntoVentaParameterReturnGeneral procesarEventosDetallePedidoPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetallePedidoPuntoVenta> detallepedidopuntoventas,DetallePedidoPuntoVenta detallepedidopuntoventa,DetallePedidoPuntoVentaParameterReturnGeneral detallepedidopuntoventaParameterGeneral,Boolean isEsNuevoDetallePedidoPuntoVenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetallePedidoPuntoVentaParameterReturnGeneral detallepedidopuntoventaReturnGeneral=new DetallePedidoPuntoVentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallepedidopuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetallePedidoPuntoVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallepedidopuntoventas,detallepedidopuntoventa,detallepedidopuntoventaParameterGeneral,detallepedidopuntoventaReturnGeneral,isEsNuevoDetallePedidoPuntoVenta,clases);
			
			return detallepedidopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetallePedidoPuntoVentaParameterReturnGeneral procesarEventosDetallePedidoPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetallePedidoPuntoVenta> detallepedidopuntoventas,DetallePedidoPuntoVenta detallepedidopuntoventa,DetallePedidoPuntoVentaParameterReturnGeneral detallepedidopuntoventaParameterGeneral,Boolean isEsNuevoDetallePedidoPuntoVenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-procesarEventosDetallePedidoPuntoVentasWithConnection");connexion.begin();			
			
			DetallePedidoPuntoVentaParameterReturnGeneral detallepedidopuntoventaReturnGeneral=new DetallePedidoPuntoVentaParameterReturnGeneral();
	
			detallepedidopuntoventaReturnGeneral.setDetallePedidoPuntoVenta(detallepedidopuntoventa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallepedidopuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetallePedidoPuntoVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallepedidopuntoventas,detallepedidopuntoventa,detallepedidopuntoventaParameterGeneral,detallepedidopuntoventaReturnGeneral,isEsNuevoDetallePedidoPuntoVenta,clases);
			
			this.connexion.commit();
			
			return detallepedidopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetallePedidoPuntoVentaParameterReturnGeneral procesarImportacionDetallePedidoPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetallePedidoPuntoVentaParameterReturnGeneral detallepedidopuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-procesarImportacionDetallePedidoPuntoVentasWithConnection");connexion.begin();			
			
			DetallePedidoPuntoVentaParameterReturnGeneral detallepedidopuntoventaReturnGeneral=new DetallePedidoPuntoVentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detallepedidopuntoventas=new ArrayList<DetallePedidoPuntoVenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detallepedidopuntoventa=new DetallePedidoPuntoVenta();
				
				
				if(conColumnasBase) {this.detallepedidopuntoventa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detallepedidopuntoventa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detallepedidopuntoventa.setserie(arrColumnas[iColumn++]);
				this.detallepedidopuntoventa.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.detallepedidopuntoventa.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidopuntoventa.setdescuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidopuntoventa.setdescuento_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidopuntoventa.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidopuntoventa.setiva_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidopuntoventa.setice(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidopuntoventa.setice_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidopuntoventa.setsub_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidopuntoventa.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.detallepedidopuntoventas.add(this.detallepedidopuntoventa);
			}
			
			this.saveDetallePedidoPuntoVentas();
			
			this.connexion.commit();
			
			detallepedidopuntoventaReturnGeneral.setConRetornoEstaProcesado(true);
			detallepedidopuntoventaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detallepedidopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetallePedidoPuntoVentasEliminados() throws Exception {				
		
		List<DetallePedidoPuntoVenta> detallepedidopuntoventasAux= new ArrayList<DetallePedidoPuntoVenta>();
		
		for(DetallePedidoPuntoVenta detallepedidopuntoventa:detallepedidopuntoventas) {
			if(!detallepedidopuntoventa.getIsDeleted()) {
				detallepedidopuntoventasAux.add(detallepedidopuntoventa);
			}
		}
		
		detallepedidopuntoventas=detallepedidopuntoventasAux;
	}
	
	public void quitarDetallePedidoPuntoVentasNulos() throws Exception {				
		
		List<DetallePedidoPuntoVenta> detallepedidopuntoventasAux= new ArrayList<DetallePedidoPuntoVenta>();
		
		for(DetallePedidoPuntoVenta detallepedidopuntoventa : this.detallepedidopuntoventas) {
			if(detallepedidopuntoventa==null) {
				detallepedidopuntoventasAux.add(detallepedidopuntoventa);
			}
		}
		
		//this.detallepedidopuntoventas=detallepedidopuntoventasAux;
		
		this.detallepedidopuntoventas.removeAll(detallepedidopuntoventasAux);
	}
	
	public void getSetVersionRowDetallePedidoPuntoVentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detallepedidopuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detallepedidopuntoventa.getIsDeleted() || (detallepedidopuntoventa.getIsChanged()&&!detallepedidopuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detallepedidopuntoventaDataAccess.getSetVersionRowDetallePedidoPuntoVenta(connexion,detallepedidopuntoventa.getId());
				
				if(!detallepedidopuntoventa.getVersionRow().equals(timestamp)) {	
					detallepedidopuntoventa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detallepedidopuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetallePedidoPuntoVenta()throws Exception {	
		
		if(detallepedidopuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detallepedidopuntoventa.getIsDeleted() || (detallepedidopuntoventa.getIsChanged()&&!detallepedidopuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detallepedidopuntoventaDataAccess.getSetVersionRowDetallePedidoPuntoVenta(connexion,detallepedidopuntoventa.getId());
			
			try {							
				if(!detallepedidopuntoventa.getVersionRow().equals(timestamp)) {	
					detallepedidopuntoventa.setVersionRow(timestamp);
				}
				
				detallepedidopuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetallePedidoPuntoVentasWithConnection()throws Exception {	
		if(detallepedidopuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetallePedidoPuntoVenta detallepedidopuntoventaAux:detallepedidopuntoventas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detallepedidopuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallepedidopuntoventaAux.getIsDeleted() || (detallepedidopuntoventaAux.getIsChanged()&&!detallepedidopuntoventaAux.getIsNew())) {
						
						timestamp=detallepedidopuntoventaDataAccess.getSetVersionRowDetallePedidoPuntoVenta(connexion,detallepedidopuntoventaAux.getId());
						
						if(!detallepedidopuntoventa.getVersionRow().equals(timestamp)) {	
							detallepedidopuntoventaAux.setVersionRow(timestamp);
						}
								
						detallepedidopuntoventaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetallePedidoPuntoVentas()throws Exception {	
		if(detallepedidopuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetallePedidoPuntoVenta detallepedidopuntoventaAux:detallepedidopuntoventas) {
					if(detallepedidopuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallepedidopuntoventaAux.getIsDeleted() || (detallepedidopuntoventaAux.getIsChanged()&&!detallepedidopuntoventaAux.getIsNew())) {
						
						timestamp=detallepedidopuntoventaDataAccess.getSetVersionRowDetallePedidoPuntoVenta(connexion,detallepedidopuntoventaAux.getId());
						
						if(!detallepedidopuntoventaAux.getVersionRow().equals(timestamp)) {	
							detallepedidopuntoventaAux.setVersionRow(timestamp);
						}
						
													
						detallepedidopuntoventaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetallePedidoPuntoVentaParameterReturnGeneral cargarCombosLoteForeignKeyDetallePedidoPuntoVentaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalPedidoPuntoVenta,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad) throws Exception {
		DetallePedidoPuntoVentaParameterReturnGeneral  detallepedidopuntoventaReturnGeneral =new DetallePedidoPuntoVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetallePedidoPuntoVentaWithConnection");connexion.begin();
			
			detallepedidopuntoventaReturnGeneral =new DetallePedidoPuntoVentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallepedidopuntoventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallepedidopuntoventaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<PedidoPuntoVenta> pedidopuntoventasForeignKey=new ArrayList<PedidoPuntoVenta>();
			PedidoPuntoVentaLogic pedidopuntoventaLogic=new PedidoPuntoVentaLogic();
			pedidopuntoventaLogic.setConnexion(this.connexion);
			pedidopuntoventaLogic.getPedidoPuntoVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPedidoPuntoVenta.equals("NONE")) {
				pedidopuntoventaLogic.getTodosPedidoPuntoVentas(finalQueryGlobalPedidoPuntoVenta,new Pagination());
				pedidopuntoventasForeignKey=pedidopuntoventaLogic.getPedidoPuntoVentas();
			}

			detallepedidopuntoventaReturnGeneral.setpedidopuntoventasForeignKey(pedidopuntoventasForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallepedidopuntoventaReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallepedidopuntoventaReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallepedidopuntoventaReturnGeneral.setunidadsForeignKey(unidadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detallepedidopuntoventaReturnGeneral;
	}
	
	public DetallePedidoPuntoVentaParameterReturnGeneral cargarCombosLoteForeignKeyDetallePedidoPuntoVenta(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalPedidoPuntoVenta,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad) throws Exception {
		DetallePedidoPuntoVentaParameterReturnGeneral  detallepedidopuntoventaReturnGeneral =new DetallePedidoPuntoVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detallepedidopuntoventaReturnGeneral =new DetallePedidoPuntoVentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallepedidopuntoventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallepedidopuntoventaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<PedidoPuntoVenta> pedidopuntoventasForeignKey=new ArrayList<PedidoPuntoVenta>();
			PedidoPuntoVentaLogic pedidopuntoventaLogic=new PedidoPuntoVentaLogic();
			pedidopuntoventaLogic.setConnexion(this.connexion);
			pedidopuntoventaLogic.getPedidoPuntoVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPedidoPuntoVenta.equals("NONE")) {
				pedidopuntoventaLogic.getTodosPedidoPuntoVentas(finalQueryGlobalPedidoPuntoVenta,new Pagination());
				pedidopuntoventasForeignKey=pedidopuntoventaLogic.getPedidoPuntoVentas();
			}

			detallepedidopuntoventaReturnGeneral.setpedidopuntoventasForeignKey(pedidopuntoventasForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallepedidopuntoventaReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallepedidopuntoventaReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallepedidopuntoventaReturnGeneral.setunidadsForeignKey(unidadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detallepedidopuntoventaReturnGeneral;
	}
	
	
	public void deepLoad(DetallePedidoPuntoVenta detallepedidopuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetallePedidoPuntoVentaLogicAdditional.updateDetallePedidoPuntoVentaToGet(detallepedidopuntoventa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallepedidopuntoventa.setEmpresa(detallepedidopuntoventaDataAccess.getEmpresa(connexion,detallepedidopuntoventa));
		detallepedidopuntoventa.setSucursal(detallepedidopuntoventaDataAccess.getSucursal(connexion,detallepedidopuntoventa));
		detallepedidopuntoventa.setPedidoPuntoVenta(detallepedidopuntoventaDataAccess.getPedidoPuntoVenta(connexion,detallepedidopuntoventa));
		detallepedidopuntoventa.setBodega(detallepedidopuntoventaDataAccess.getBodega(connexion,detallepedidopuntoventa));
		detallepedidopuntoventa.setProducto(detallepedidopuntoventaDataAccess.getProducto(connexion,detallepedidopuntoventa));
		detallepedidopuntoventa.setUnidad(detallepedidopuntoventaDataAccess.getUnidad(connexion,detallepedidopuntoventa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detallepedidopuntoventa.setEmpresa(detallepedidopuntoventaDataAccess.getEmpresa(connexion,detallepedidopuntoventa));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallepedidopuntoventa.setSucursal(detallepedidopuntoventaDataAccess.getSucursal(connexion,detallepedidopuntoventa));
				continue;
			}

			if(clas.clas.equals(PedidoPuntoVenta.class)) {
				detallepedidopuntoventa.setPedidoPuntoVenta(detallepedidopuntoventaDataAccess.getPedidoPuntoVenta(connexion,detallepedidopuntoventa));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallepedidopuntoventa.setBodega(detallepedidopuntoventaDataAccess.getBodega(connexion,detallepedidopuntoventa));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallepedidopuntoventa.setProducto(detallepedidopuntoventaDataAccess.getProducto(connexion,detallepedidopuntoventa));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallepedidopuntoventa.setUnidad(detallepedidopuntoventaDataAccess.getUnidad(connexion,detallepedidopuntoventa));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidopuntoventa.setEmpresa(detallepedidopuntoventaDataAccess.getEmpresa(connexion,detallepedidopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidopuntoventa.setSucursal(detallepedidopuntoventaDataAccess.getSucursal(connexion,detallepedidopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoPuntoVenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidopuntoventa.setPedidoPuntoVenta(detallepedidopuntoventaDataAccess.getPedidoPuntoVenta(connexion,detallepedidopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidopuntoventa.setBodega(detallepedidopuntoventaDataAccess.getBodega(connexion,detallepedidopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidopuntoventa.setProducto(detallepedidopuntoventaDataAccess.getProducto(connexion,detallepedidopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidopuntoventa.setUnidad(detallepedidopuntoventaDataAccess.getUnidad(connexion,detallepedidopuntoventa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallepedidopuntoventa.setEmpresa(detallepedidopuntoventaDataAccess.getEmpresa(connexion,detallepedidopuntoventa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallepedidopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		detallepedidopuntoventa.setSucursal(detallepedidopuntoventaDataAccess.getSucursal(connexion,detallepedidopuntoventa));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallepedidopuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				
		detallepedidopuntoventa.setPedidoPuntoVenta(detallepedidopuntoventaDataAccess.getPedidoPuntoVenta(connexion,detallepedidopuntoventa));
		PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
		pedidopuntoventaLogic.deepLoad(detallepedidopuntoventa.getPedidoPuntoVenta(),isDeep,deepLoadType,clases);
				
		detallepedidopuntoventa.setBodega(detallepedidopuntoventaDataAccess.getBodega(connexion,detallepedidopuntoventa));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallepedidopuntoventa.getBodega(),isDeep,deepLoadType,clases);
				
		detallepedidopuntoventa.setProducto(detallepedidopuntoventaDataAccess.getProducto(connexion,detallepedidopuntoventa));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallepedidopuntoventa.getProducto(),isDeep,deepLoadType,clases);
				
		detallepedidopuntoventa.setUnidad(detallepedidopuntoventaDataAccess.getUnidad(connexion,detallepedidopuntoventa));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallepedidopuntoventa.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detallepedidopuntoventa.setEmpresa(detallepedidopuntoventaDataAccess.getEmpresa(connexion,detallepedidopuntoventa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detallepedidopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallepedidopuntoventa.setSucursal(detallepedidopuntoventaDataAccess.getSucursal(connexion,detallepedidopuntoventa));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detallepedidopuntoventa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PedidoPuntoVenta.class)) {
				detallepedidopuntoventa.setPedidoPuntoVenta(detallepedidopuntoventaDataAccess.getPedidoPuntoVenta(connexion,detallepedidopuntoventa));
				PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
				pedidopuntoventaLogic.deepLoad(detallepedidopuntoventa.getPedidoPuntoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallepedidopuntoventa.setBodega(detallepedidopuntoventaDataAccess.getBodega(connexion,detallepedidopuntoventa));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detallepedidopuntoventa.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallepedidopuntoventa.setProducto(detallepedidopuntoventaDataAccess.getProducto(connexion,detallepedidopuntoventa));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detallepedidopuntoventa.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallepedidopuntoventa.setUnidad(detallepedidopuntoventaDataAccess.getUnidad(connexion,detallepedidopuntoventa));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detallepedidopuntoventa.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidopuntoventa.setEmpresa(detallepedidopuntoventaDataAccess.getEmpresa(connexion,detallepedidopuntoventa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detallepedidopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidopuntoventa.setSucursal(detallepedidopuntoventaDataAccess.getSucursal(connexion,detallepedidopuntoventa));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detallepedidopuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoPuntoVenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidopuntoventa.setPedidoPuntoVenta(detallepedidopuntoventaDataAccess.getPedidoPuntoVenta(connexion,detallepedidopuntoventa));
			PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
			pedidopuntoventaLogic.deepLoad(detallepedidopuntoventa.getPedidoPuntoVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidopuntoventa.setBodega(detallepedidopuntoventaDataAccess.getBodega(connexion,detallepedidopuntoventa));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detallepedidopuntoventa.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidopuntoventa.setProducto(detallepedidopuntoventaDataAccess.getProducto(connexion,detallepedidopuntoventa));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detallepedidopuntoventa.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidopuntoventa.setUnidad(detallepedidopuntoventaDataAccess.getUnidad(connexion,detallepedidopuntoventa));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detallepedidopuntoventa.getUnidad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetallePedidoPuntoVenta detallepedidopuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetallePedidoPuntoVentaLogicAdditional.updateDetallePedidoPuntoVentaToSave(detallepedidopuntoventa,this.arrDatoGeneral);
			
DetallePedidoPuntoVentaDataAccess.save(detallepedidopuntoventa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detallepedidopuntoventa.getEmpresa(),connexion);

		SucursalDataAccess.save(detallepedidopuntoventa.getSucursal(),connexion);

		PedidoPuntoVentaDataAccess.save(detallepedidopuntoventa.getPedidoPuntoVenta(),connexion);

		BodegaDataAccess.save(detallepedidopuntoventa.getBodega(),connexion);

		ProductoDataAccess.save(detallepedidopuntoventa.getProducto(),connexion);

		UnidadDataAccess.save(detallepedidopuntoventa.getUnidad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallepedidopuntoventa.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallepedidopuntoventa.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(PedidoPuntoVenta.class)) {
				PedidoPuntoVentaDataAccess.save(detallepedidopuntoventa.getPedidoPuntoVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallepedidopuntoventa.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallepedidopuntoventa.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallepedidopuntoventa.getUnidad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detallepedidopuntoventa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallepedidopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detallepedidopuntoventa.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallepedidopuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				

		PedidoPuntoVentaDataAccess.save(detallepedidopuntoventa.getPedidoPuntoVenta(),connexion);
		PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
		pedidopuntoventaLogic.deepLoad(detallepedidopuntoventa.getPedidoPuntoVenta(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detallepedidopuntoventa.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallepedidopuntoventa.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detallepedidopuntoventa.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallepedidopuntoventa.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detallepedidopuntoventa.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallepedidopuntoventa.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallepedidopuntoventa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detallepedidopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallepedidopuntoventa.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detallepedidopuntoventa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PedidoPuntoVenta.class)) {
				PedidoPuntoVentaDataAccess.save(detallepedidopuntoventa.getPedidoPuntoVenta(),connexion);
				PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
				pedidopuntoventaLogic.deepSave(detallepedidopuntoventa.getPedidoPuntoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallepedidopuntoventa.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detallepedidopuntoventa.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallepedidopuntoventa.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detallepedidopuntoventa.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallepedidopuntoventa.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detallepedidopuntoventa.getUnidad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetallePedidoPuntoVenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detallepedidopuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(detallepedidopuntoventa);
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
			this.deepLoad(this.detallepedidopuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetallePedidoPuntoVenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detallepedidopuntoventas!=null) {
				for(DetallePedidoPuntoVenta detallepedidopuntoventa:detallepedidopuntoventas) {
					this.deepLoad(detallepedidopuntoventa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(detallepedidopuntoventas);
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
			if(detallepedidopuntoventas!=null) {
				for(DetallePedidoPuntoVenta detallepedidopuntoventa:detallepedidopuntoventas) {
					this.deepLoad(detallepedidopuntoventa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(detallepedidopuntoventas);
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
			this.getNewConnexionToDeep(DetallePedidoPuntoVenta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detallepedidopuntoventa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetallePedidoPuntoVenta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detallepedidopuntoventas!=null) {
				for(DetallePedidoPuntoVenta detallepedidopuntoventa:detallepedidopuntoventas) {
					this.deepSave(detallepedidopuntoventa,isDeep,deepLoadType,clases);
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
			if(detallepedidopuntoventas!=null) {
				for(DetallePedidoPuntoVenta detallepedidopuntoventa:detallepedidopuntoventas) {
					this.deepSave(detallepedidopuntoventa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetallePedidoPuntoVentasFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetallePedidoPuntoVentaConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoPuntoVentasFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetallePedidoPuntoVentaConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoPuntoVentasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetallePedidoPuntoVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoPuntoVentasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetallePedidoPuntoVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoPuntoVentasFK_IdPedidoPuntoVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_pedido_punto_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPedidoPuntoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPedidoPuntoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pedido_punto_venta,DetallePedidoPuntoVentaConstantesFunciones.IDPEDIDOPUNTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPedidoPuntoVenta);

			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPedidoPuntoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoPuntoVentasFK_IdPedidoPuntoVenta(String sFinalQuery,Pagination pagination,Long id_pedido_punto_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPedidoPuntoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPedidoPuntoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pedido_punto_venta,DetallePedidoPuntoVentaConstantesFunciones.IDPEDIDOPUNTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPedidoPuntoVenta);

			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPedidoPuntoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoPuntoVentasFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetallePedidoPuntoVentaConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoPuntoVentasFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetallePedidoPuntoVentaConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoPuntoVentasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetallePedidoPuntoVentaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoPuntoVentasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetallePedidoPuntoVentaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoPuntoVentasFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetallePedidoPuntoVentaConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoPuntoVentasFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetallePedidoPuntoVentaConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetallePedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(this.detallepedidopuntoventas);
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
			if(DetallePedidoPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePedidoPuntoVentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetallePedidoPuntoVenta detallepedidopuntoventa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetallePedidoPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				if(detallepedidopuntoventa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePedidoPuntoVentaDataAccess.TABLENAME, detallepedidopuntoventa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetallePedidoPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetallePedidoPuntoVentaLogic.registrarAuditoriaDetallesDetallePedidoPuntoVenta(connexion,detallepedidopuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detallepedidopuntoventa.getIsDeleted()) {
					/*if(!detallepedidopuntoventa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetallePedidoPuntoVentaDataAccess.TABLENAME, detallepedidopuntoventa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetallePedidoPuntoVentaLogic.registrarAuditoriaDetallesDetallePedidoPuntoVenta(connexion,detallepedidopuntoventa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePedidoPuntoVentaDataAccess.TABLENAME, detallepedidopuntoventa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detallepedidopuntoventa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePedidoPuntoVentaDataAccess.TABLENAME, detallepedidopuntoventa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetallePedidoPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetallePedidoPuntoVentaLogic.registrarAuditoriaDetallesDetallePedidoPuntoVenta(connexion,detallepedidopuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetallePedidoPuntoVenta(Connexion connexion,DetallePedidoPuntoVenta detallepedidopuntoventa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detallepedidopuntoventa.getIsNew()||!detallepedidopuntoventa.getid_empresa().equals(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getid_empresa()!=null)
				{
					strValorActual=detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getid_empresa().toString();
				}
				if(detallepedidopuntoventa.getid_empresa()!=null)
				{
					strValorNuevo=detallepedidopuntoventa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoPuntoVentaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidopuntoventa.getIsNew()||!detallepedidopuntoventa.getid_sucursal().equals(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getid_sucursal()!=null)
				{
					strValorActual=detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getid_sucursal().toString();
				}
				if(detallepedidopuntoventa.getid_sucursal()!=null)
				{
					strValorNuevo=detallepedidopuntoventa.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoPuntoVentaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidopuntoventa.getIsNew()||!detallepedidopuntoventa.getid_pedido_punto_venta().equals(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getid_pedido_punto_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getid_pedido_punto_venta()!=null)
				{
					strValorActual=detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getid_pedido_punto_venta().toString();
				}
				if(detallepedidopuntoventa.getid_pedido_punto_venta()!=null)
				{
					strValorNuevo=detallepedidopuntoventa.getid_pedido_punto_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoPuntoVentaConstantesFunciones.IDPEDIDOPUNTOVENTA,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidopuntoventa.getIsNew()||!detallepedidopuntoventa.getid_bodega().equals(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getid_bodega()!=null)
				{
					strValorActual=detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getid_bodega().toString();
				}
				if(detallepedidopuntoventa.getid_bodega()!=null)
				{
					strValorNuevo=detallepedidopuntoventa.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoPuntoVentaConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidopuntoventa.getIsNew()||!detallepedidopuntoventa.getid_producto().equals(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getid_producto()!=null)
				{
					strValorActual=detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getid_producto().toString();
				}
				if(detallepedidopuntoventa.getid_producto()!=null)
				{
					strValorNuevo=detallepedidopuntoventa.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoPuntoVentaConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidopuntoventa.getIsNew()||!detallepedidopuntoventa.getid_unidad().equals(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getid_unidad()!=null)
				{
					strValorActual=detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getid_unidad().toString();
				}
				if(detallepedidopuntoventa.getid_unidad()!=null)
				{
					strValorNuevo=detallepedidopuntoventa.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoPuntoVentaConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidopuntoventa.getIsNew()||!detallepedidopuntoventa.getserie().equals(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getserie()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getserie()!=null)
				{
					strValorActual=detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getserie();
				}
				if(detallepedidopuntoventa.getserie()!=null)
				{
					strValorNuevo=detallepedidopuntoventa.getserie() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoPuntoVentaConstantesFunciones.SERIE,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidopuntoventa.getIsNew()||!detallepedidopuntoventa.getcantidad().equals(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getcantidad()!=null)
				{
					strValorActual=detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getcantidad().toString();
				}
				if(detallepedidopuntoventa.getcantidad()!=null)
				{
					strValorNuevo=detallepedidopuntoventa.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoPuntoVentaConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidopuntoventa.getIsNew()||!detallepedidopuntoventa.getprecio().equals(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getprecio()!=null)
				{
					strValorActual=detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getprecio().toString();
				}
				if(detallepedidopuntoventa.getprecio()!=null)
				{
					strValorNuevo=detallepedidopuntoventa.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoPuntoVentaConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidopuntoventa.getIsNew()||!detallepedidopuntoventa.getdescuento().equals(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getdescuento()!=null)
				{
					strValorActual=detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getdescuento().toString();
				}
				if(detallepedidopuntoventa.getdescuento()!=null)
				{
					strValorNuevo=detallepedidopuntoventa.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoPuntoVentaConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidopuntoventa.getIsNew()||!detallepedidopuntoventa.getdescuento_valor().equals(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getdescuento_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getdescuento_valor()!=null)
				{
					strValorActual=detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getdescuento_valor().toString();
				}
				if(detallepedidopuntoventa.getdescuento_valor()!=null)
				{
					strValorNuevo=detallepedidopuntoventa.getdescuento_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoPuntoVentaConstantesFunciones.DESCUENTOVALOR,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidopuntoventa.getIsNew()||!detallepedidopuntoventa.getiva().equals(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getiva()!=null)
				{
					strValorActual=detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getiva().toString();
				}
				if(detallepedidopuntoventa.getiva()!=null)
				{
					strValorNuevo=detallepedidopuntoventa.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoPuntoVentaConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidopuntoventa.getIsNew()||!detallepedidopuntoventa.getiva_valor().equals(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getiva_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getiva_valor()!=null)
				{
					strValorActual=detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getiva_valor().toString();
				}
				if(detallepedidopuntoventa.getiva_valor()!=null)
				{
					strValorNuevo=detallepedidopuntoventa.getiva_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoPuntoVentaConstantesFunciones.IVAVALOR,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidopuntoventa.getIsNew()||!detallepedidopuntoventa.getice().equals(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getice()!=null)
				{
					strValorActual=detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getice().toString();
				}
				if(detallepedidopuntoventa.getice()!=null)
				{
					strValorNuevo=detallepedidopuntoventa.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoPuntoVentaConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidopuntoventa.getIsNew()||!detallepedidopuntoventa.getice_valor().equals(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getice_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getice_valor()!=null)
				{
					strValorActual=detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getice_valor().toString();
				}
				if(detallepedidopuntoventa.getice_valor()!=null)
				{
					strValorNuevo=detallepedidopuntoventa.getice_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoPuntoVentaConstantesFunciones.ICEVALOR,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidopuntoventa.getIsNew()||!detallepedidopuntoventa.getsub_total().equals(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getsub_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getsub_total()!=null)
				{
					strValorActual=detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().getsub_total().toString();
				}
				if(detallepedidopuntoventa.getsub_total()!=null)
				{
					strValorNuevo=detallepedidopuntoventa.getsub_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoPuntoVentaConstantesFunciones.SUBTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidopuntoventa.getIsNew()||!detallepedidopuntoventa.gettotal().equals(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().gettotal()!=null)
				{
					strValorActual=detallepedidopuntoventa.getDetallePedidoPuntoVentaOriginal().gettotal().toString();
				}
				if(detallepedidopuntoventa.gettotal()!=null)
				{
					strValorNuevo=detallepedidopuntoventa.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoPuntoVentaConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetallePedidoPuntoVentaRelacionesWithConnection(DetallePedidoPuntoVenta detallepedidopuntoventa) throws Exception {

		if(!detallepedidopuntoventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetallePedidoPuntoVentaRelacionesBase(detallepedidopuntoventa,true);
		}
	}

	public void saveDetallePedidoPuntoVentaRelaciones(DetallePedidoPuntoVenta detallepedidopuntoventa)throws Exception {

		if(!detallepedidopuntoventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetallePedidoPuntoVentaRelacionesBase(detallepedidopuntoventa,false);
		}
	}

	public void saveDetallePedidoPuntoVentaRelacionesBase(DetallePedidoPuntoVenta detallepedidopuntoventa,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetallePedidoPuntoVenta-saveRelacionesWithConnection");}
	

			this.setDetallePedidoPuntoVenta(detallepedidopuntoventa);

			if(DetallePedidoPuntoVentaLogicAdditional.validarSaveRelaciones(detallepedidopuntoventa,this)) {

				DetallePedidoPuntoVentaLogicAdditional.updateRelacionesToSave(detallepedidopuntoventa,this);

				if((detallepedidopuntoventa.getIsNew()||detallepedidopuntoventa.getIsChanged())&&!detallepedidopuntoventa.getIsDeleted()) {
					this.saveDetallePedidoPuntoVenta();
					this.saveDetallePedidoPuntoVentaRelacionesDetalles();

				} else if(detallepedidopuntoventa.getIsDeleted()) {
					this.saveDetallePedidoPuntoVentaRelacionesDetalles();
					this.saveDetallePedidoPuntoVenta();
				}

				DetallePedidoPuntoVentaLogicAdditional.updateRelacionesToSaveAfter(detallepedidopuntoventa,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveDetallePedidoPuntoVentaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetallePedidoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetallePedidoPuntoVentaConstantesFunciones.getClassesForeignKeysOfDetallePedidoPuntoVenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePedidoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetallePedidoPuntoVentaConstantesFunciones.getClassesRelationshipsOfDetallePedidoPuntoVenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.puntoventa.util.NotaCreditoPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.NotaCreditoPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.NotaCreditoPuntoVentaParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.NotaCreditoPuntoVenta;
import com.bydan.erp.puntoventa.business.logic.NotaCreditoPuntoVentaLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class NotaCreditoPuntoVentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(NotaCreditoPuntoVentaLogic.class);
	
	protected NotaCreditoPuntoVentaDataAccess notacreditopuntoventaDataAccess; 	
	protected NotaCreditoPuntoVenta notacreditopuntoventa;
	protected List<NotaCreditoPuntoVenta> notacreditopuntoventas;
	protected Object notacreditopuntoventaObject;	
	protected List<Object> notacreditopuntoventasObject;
	
	public static ClassValidator<NotaCreditoPuntoVenta> notacreditopuntoventaValidator = new ClassValidator<NotaCreditoPuntoVenta>(NotaCreditoPuntoVenta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected NotaCreditoPuntoVentaLogicAdditional notacreditopuntoventaLogicAdditional=null;
	
	public NotaCreditoPuntoVentaLogicAdditional getNotaCreditoPuntoVentaLogicAdditional() {
		return this.notacreditopuntoventaLogicAdditional;
	}
	
	public void setNotaCreditoPuntoVentaLogicAdditional(NotaCreditoPuntoVentaLogicAdditional notacreditopuntoventaLogicAdditional) {
		try {
			this.notacreditopuntoventaLogicAdditional=notacreditopuntoventaLogicAdditional;
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
	
	
	
	
	public  NotaCreditoPuntoVentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.notacreditopuntoventaDataAccess = new NotaCreditoPuntoVentaDataAccess();
			
			this.notacreditopuntoventas= new ArrayList<NotaCreditoPuntoVenta>();
			this.notacreditopuntoventa= new NotaCreditoPuntoVenta();
			
			this.notacreditopuntoventaObject=new Object();
			this.notacreditopuntoventasObject=new ArrayList<Object>();
				
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
			
			this.notacreditopuntoventaDataAccess.setConnexionType(this.connexionType);
			this.notacreditopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  NotaCreditoPuntoVentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.notacreditopuntoventaDataAccess = new NotaCreditoPuntoVentaDataAccess();
			this.notacreditopuntoventas= new ArrayList<NotaCreditoPuntoVenta>();
			this.notacreditopuntoventa= new NotaCreditoPuntoVenta();
			this.notacreditopuntoventaObject=new Object();
			this.notacreditopuntoventasObject=new ArrayList<Object>();
			
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
			
			this.notacreditopuntoventaDataAccess.setConnexionType(this.connexionType);
			this.notacreditopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public NotaCreditoPuntoVenta getNotaCreditoPuntoVenta() throws Exception {	
		NotaCreditoPuntoVentaLogicAdditional.checkNotaCreditoPuntoVentaToGet(notacreditopuntoventa,this.datosCliente,this.arrDatoGeneral);
		NotaCreditoPuntoVentaLogicAdditional.updateNotaCreditoPuntoVentaToGet(notacreditopuntoventa,this.arrDatoGeneral);
		
		return notacreditopuntoventa;
	}
		
	public void setNotaCreditoPuntoVenta(NotaCreditoPuntoVenta newNotaCreditoPuntoVenta) {
		this.notacreditopuntoventa = newNotaCreditoPuntoVenta;
	}
	
	public NotaCreditoPuntoVentaDataAccess getNotaCreditoPuntoVentaDataAccess() {
		return notacreditopuntoventaDataAccess;
	}
	
	public void setNotaCreditoPuntoVentaDataAccess(NotaCreditoPuntoVentaDataAccess newnotacreditopuntoventaDataAccess) {
		this.notacreditopuntoventaDataAccess = newnotacreditopuntoventaDataAccess;
	}
	
	public List<NotaCreditoPuntoVenta> getNotaCreditoPuntoVentas() throws Exception {		
		this.quitarNotaCreditoPuntoVentasNulos();
		
		NotaCreditoPuntoVentaLogicAdditional.checkNotaCreditoPuntoVentaToGets(notacreditopuntoventas,this.datosCliente,this.arrDatoGeneral);
		
		for (NotaCreditoPuntoVenta notacreditopuntoventaLocal: notacreditopuntoventas ) {
			NotaCreditoPuntoVentaLogicAdditional.updateNotaCreditoPuntoVentaToGet(notacreditopuntoventaLocal,this.arrDatoGeneral);
		}
		
		return notacreditopuntoventas;
	}
	
	public void setNotaCreditoPuntoVentas(List<NotaCreditoPuntoVenta> newNotaCreditoPuntoVentas) {
		this.notacreditopuntoventas = newNotaCreditoPuntoVentas;
	}
	
	public Object getNotaCreditoPuntoVentaObject() {	
		this.notacreditopuntoventaObject=this.notacreditopuntoventaDataAccess.getEntityObject();
		return this.notacreditopuntoventaObject;
	}
		
	public void setNotaCreditoPuntoVentaObject(Object newNotaCreditoPuntoVentaObject) {
		this.notacreditopuntoventaObject = newNotaCreditoPuntoVentaObject;
	}
	
	public List<Object> getNotaCreditoPuntoVentasObject() {		
		this.notacreditopuntoventasObject=this.notacreditopuntoventaDataAccess.getEntitiesObject();
		return this.notacreditopuntoventasObject;
	}
		
	public void setNotaCreditoPuntoVentasObject(List<Object> newNotaCreditoPuntoVentasObject) {
		this.notacreditopuntoventasObject = newNotaCreditoPuntoVentasObject;
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
		
		if(this.notacreditopuntoventaDataAccess!=null) {
			this.notacreditopuntoventaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			notacreditopuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			notacreditopuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		notacreditopuntoventa = new  NotaCreditoPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			notacreditopuntoventa=notacreditopuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.notacreditopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventa);
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
		notacreditopuntoventa = new  NotaCreditoPuntoVenta();
		  		  
        try {
			
			notacreditopuntoventa=notacreditopuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.notacreditopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		notacreditopuntoventa = new  NotaCreditoPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			notacreditopuntoventa=notacreditopuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.notacreditopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventa);
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
		notacreditopuntoventa = new  NotaCreditoPuntoVenta();
		  		  
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
		notacreditopuntoventa = new  NotaCreditoPuntoVenta();
		  		  
        try {
			
			notacreditopuntoventa=notacreditopuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.notacreditopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		notacreditopuntoventa = new  NotaCreditoPuntoVenta();
		  		  
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
		notacreditopuntoventa = new  NotaCreditoPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =notacreditopuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		notacreditopuntoventa = new  NotaCreditoPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=notacreditopuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		notacreditopuntoventa = new  NotaCreditoPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =notacreditopuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		notacreditopuntoventa = new  NotaCreditoPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=notacreditopuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		notacreditopuntoventa = new  NotaCreditoPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =notacreditopuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		notacreditopuntoventa = new  NotaCreditoPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=notacreditopuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		notacreditopuntoventas = new  ArrayList<NotaCreditoPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNotaCreditoPuntoVenta(notacreditopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
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
		notacreditopuntoventas = new  ArrayList<NotaCreditoPuntoVenta>();
		  		  
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
		notacreditopuntoventas = new  ArrayList<NotaCreditoPuntoVenta>();
		  		  
        try {			
			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarNotaCreditoPuntoVenta(notacreditopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		notacreditopuntoventas = new  ArrayList<NotaCreditoPuntoVenta>();
		  		  
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
		notacreditopuntoventas = new  ArrayList<NotaCreditoPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNotaCreditoPuntoVenta(notacreditopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
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
		notacreditopuntoventas = new  ArrayList<NotaCreditoPuntoVenta>();
		  		  
        try {
			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNotaCreditoPuntoVenta(notacreditopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
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
		notacreditopuntoventas = new  ArrayList<NotaCreditoPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNotaCreditoPuntoVenta(notacreditopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
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
		notacreditopuntoventas = new  ArrayList<NotaCreditoPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNotaCreditoPuntoVenta(notacreditopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		notacreditopuntoventa = new  NotaCreditoPuntoVenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditopuntoventa=notacreditopuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNotaCreditoPuntoVenta(notacreditopuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventa);
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
		notacreditopuntoventa = new  NotaCreditoPuntoVenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditopuntoventa=notacreditopuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNotaCreditoPuntoVenta(notacreditopuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		notacreditopuntoventas = new  ArrayList<NotaCreditoPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNotaCreditoPuntoVenta(notacreditopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
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
		notacreditopuntoventas = new  ArrayList<NotaCreditoPuntoVenta>();
		  		  
        try {
			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNotaCreditoPuntoVenta(notacreditopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosNotaCreditoPuntoVentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		notacreditopuntoventas = new  ArrayList<NotaCreditoPuntoVenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getTodosNotaCreditoPuntoVentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNotaCreditoPuntoVenta(notacreditopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
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
	
	public  void  getTodosNotaCreditoPuntoVentas(String sFinalQuery,Pagination pagination)throws Exception {
		notacreditopuntoventas = new  ArrayList<NotaCreditoPuntoVenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNotaCreditoPuntoVenta(notacreditopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarNotaCreditoPuntoVenta(NotaCreditoPuntoVenta notacreditopuntoventa) throws Exception {
		Boolean estaValidado=false;
		
		if(notacreditopuntoventa.getIsNew() || notacreditopuntoventa.getIsChanged()) { 
			this.invalidValues = notacreditopuntoventaValidator.getInvalidValues(notacreditopuntoventa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(notacreditopuntoventa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarNotaCreditoPuntoVenta(List<NotaCreditoPuntoVenta> NotaCreditoPuntoVentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(NotaCreditoPuntoVenta notacreditopuntoventaLocal:notacreditopuntoventas) {				
			estaValidadoObjeto=this.validarGuardarNotaCreditoPuntoVenta(notacreditopuntoventaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarNotaCreditoPuntoVenta(List<NotaCreditoPuntoVenta> NotaCreditoPuntoVentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNotaCreditoPuntoVenta(notacreditopuntoventas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarNotaCreditoPuntoVenta(NotaCreditoPuntoVenta NotaCreditoPuntoVenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNotaCreditoPuntoVenta(notacreditopuntoventa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(NotaCreditoPuntoVenta notacreditopuntoventa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+notacreditopuntoventa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=NotaCreditoPuntoVentaConstantesFunciones.getNotaCreditoPuntoVentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"notacreditopuntoventa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(NotaCreditoPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(NotaCreditoPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveNotaCreditoPuntoVentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-saveNotaCreditoPuntoVentaWithConnection");connexion.begin();			
			
			NotaCreditoPuntoVentaLogicAdditional.checkNotaCreditoPuntoVentaToSave(this.notacreditopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NotaCreditoPuntoVentaLogicAdditional.updateNotaCreditoPuntoVentaToSave(this.notacreditopuntoventa,this.arrDatoGeneral);
			
			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.notacreditopuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowNotaCreditoPuntoVenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNotaCreditoPuntoVenta(this.notacreditopuntoventa)) {
				NotaCreditoPuntoVentaDataAccess.save(this.notacreditopuntoventa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.notacreditopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NotaCreditoPuntoVentaLogicAdditional.checkNotaCreditoPuntoVentaToSaveAfter(this.notacreditopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNotaCreditoPuntoVenta();
			
			connexion.commit();			
			
			if(this.notacreditopuntoventa.getIsDeleted()) {
				this.notacreditopuntoventa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveNotaCreditoPuntoVenta()throws Exception {	
		try {	
			
			NotaCreditoPuntoVentaLogicAdditional.checkNotaCreditoPuntoVentaToSave(this.notacreditopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NotaCreditoPuntoVentaLogicAdditional.updateNotaCreditoPuntoVentaToSave(this.notacreditopuntoventa,this.arrDatoGeneral);
			
			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.notacreditopuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNotaCreditoPuntoVenta(this.notacreditopuntoventa)) {			
				NotaCreditoPuntoVentaDataAccess.save(this.notacreditopuntoventa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.notacreditopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NotaCreditoPuntoVentaLogicAdditional.checkNotaCreditoPuntoVentaToSaveAfter(this.notacreditopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.notacreditopuntoventa.getIsDeleted()) {
				this.notacreditopuntoventa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveNotaCreditoPuntoVentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-saveNotaCreditoPuntoVentasWithConnection");connexion.begin();			
			
			NotaCreditoPuntoVentaLogicAdditional.checkNotaCreditoPuntoVentaToSaves(notacreditopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowNotaCreditoPuntoVentas();
			
			Boolean validadoTodosNotaCreditoPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NotaCreditoPuntoVenta notacreditopuntoventaLocal:notacreditopuntoventas) {		
				if(notacreditopuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NotaCreditoPuntoVentaLogicAdditional.updateNotaCreditoPuntoVentaToSave(notacreditopuntoventaLocal,this.arrDatoGeneral);
	        	
				NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),notacreditopuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNotaCreditoPuntoVenta(notacreditopuntoventaLocal)) {
					NotaCreditoPuntoVentaDataAccess.save(notacreditopuntoventaLocal, connexion);				
				} else {
					validadoTodosNotaCreditoPuntoVenta=false;
				}
			}
			
			if(!validadoTodosNotaCreditoPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NotaCreditoPuntoVentaLogicAdditional.checkNotaCreditoPuntoVentaToSavesAfter(notacreditopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNotaCreditoPuntoVentas();
			
			connexion.commit();		
			
			this.quitarNotaCreditoPuntoVentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveNotaCreditoPuntoVentas()throws Exception {				
		 try {	
			NotaCreditoPuntoVentaLogicAdditional.checkNotaCreditoPuntoVentaToSaves(notacreditopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosNotaCreditoPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NotaCreditoPuntoVenta notacreditopuntoventaLocal:notacreditopuntoventas) {				
				if(notacreditopuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NotaCreditoPuntoVentaLogicAdditional.updateNotaCreditoPuntoVentaToSave(notacreditopuntoventaLocal,this.arrDatoGeneral);
	        	
				NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),notacreditopuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNotaCreditoPuntoVenta(notacreditopuntoventaLocal)) {				
					NotaCreditoPuntoVentaDataAccess.save(notacreditopuntoventaLocal, connexion);				
				} else {
					validadoTodosNotaCreditoPuntoVenta=false;
				}
			}
			
			if(!validadoTodosNotaCreditoPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NotaCreditoPuntoVentaLogicAdditional.checkNotaCreditoPuntoVentaToSavesAfter(notacreditopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarNotaCreditoPuntoVentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NotaCreditoPuntoVentaParameterReturnGeneral procesarAccionNotaCreditoPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NotaCreditoPuntoVenta> notacreditopuntoventas,NotaCreditoPuntoVentaParameterReturnGeneral notacreditopuntoventaParameterGeneral)throws Exception {
		 try {	
			NotaCreditoPuntoVentaParameterReturnGeneral notacreditopuntoventaReturnGeneral=new NotaCreditoPuntoVentaParameterReturnGeneral();
	
			NotaCreditoPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,notacreditopuntoventas,notacreditopuntoventaParameterGeneral,notacreditopuntoventaReturnGeneral);
			
			return notacreditopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NotaCreditoPuntoVentaParameterReturnGeneral procesarAccionNotaCreditoPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NotaCreditoPuntoVenta> notacreditopuntoventas,NotaCreditoPuntoVentaParameterReturnGeneral notacreditopuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-procesarAccionNotaCreditoPuntoVentasWithConnection");connexion.begin();			
			
			NotaCreditoPuntoVentaParameterReturnGeneral notacreditopuntoventaReturnGeneral=new NotaCreditoPuntoVentaParameterReturnGeneral();
	
			NotaCreditoPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,notacreditopuntoventas,notacreditopuntoventaParameterGeneral,notacreditopuntoventaReturnGeneral);
			
			this.connexion.commit();
			
			return notacreditopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NotaCreditoPuntoVentaParameterReturnGeneral procesarEventosNotaCreditoPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NotaCreditoPuntoVenta> notacreditopuntoventas,NotaCreditoPuntoVenta notacreditopuntoventa,NotaCreditoPuntoVentaParameterReturnGeneral notacreditopuntoventaParameterGeneral,Boolean isEsNuevoNotaCreditoPuntoVenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			NotaCreditoPuntoVentaParameterReturnGeneral notacreditopuntoventaReturnGeneral=new NotaCreditoPuntoVentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				notacreditopuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NotaCreditoPuntoVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,notacreditopuntoventas,notacreditopuntoventa,notacreditopuntoventaParameterGeneral,notacreditopuntoventaReturnGeneral,isEsNuevoNotaCreditoPuntoVenta,clases);
			
			return notacreditopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public NotaCreditoPuntoVentaParameterReturnGeneral procesarEventosNotaCreditoPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NotaCreditoPuntoVenta> notacreditopuntoventas,NotaCreditoPuntoVenta notacreditopuntoventa,NotaCreditoPuntoVentaParameterReturnGeneral notacreditopuntoventaParameterGeneral,Boolean isEsNuevoNotaCreditoPuntoVenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-procesarEventosNotaCreditoPuntoVentasWithConnection");connexion.begin();			
			
			NotaCreditoPuntoVentaParameterReturnGeneral notacreditopuntoventaReturnGeneral=new NotaCreditoPuntoVentaParameterReturnGeneral();
	
			notacreditopuntoventaReturnGeneral.setNotaCreditoPuntoVenta(notacreditopuntoventa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				notacreditopuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NotaCreditoPuntoVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,notacreditopuntoventas,notacreditopuntoventa,notacreditopuntoventaParameterGeneral,notacreditopuntoventaReturnGeneral,isEsNuevoNotaCreditoPuntoVenta,clases);
			
			this.connexion.commit();
			
			return notacreditopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NotaCreditoPuntoVentaParameterReturnGeneral procesarImportacionNotaCreditoPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,NotaCreditoPuntoVentaParameterReturnGeneral notacreditopuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-procesarImportacionNotaCreditoPuntoVentasWithConnection");connexion.begin();			
			
			NotaCreditoPuntoVentaParameterReturnGeneral notacreditopuntoventaReturnGeneral=new NotaCreditoPuntoVentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.notacreditopuntoventas=new ArrayList<NotaCreditoPuntoVenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.notacreditopuntoventa=new NotaCreditoPuntoVenta();
				
				
				if(conColumnasBase) {this.notacreditopuntoventa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.notacreditopuntoventa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.notacreditopuntoventa.setnumero_secuencial(arrColumnas[iColumn++]);
				this.notacreditopuntoventa.setcodigo_cliente(arrColumnas[iColumn++]);
				this.notacreditopuntoventa.setnombre_cliente(arrColumnas[iColumn++]);
				this.notacreditopuntoventa.settarjeta_cliente(arrColumnas[iColumn++]);
				this.notacreditopuntoventa.setdireccion_cliente(arrColumnas[iColumn++]);
				this.notacreditopuntoventa.settelefono_cliente(arrColumnas[iColumn++]);
				this.notacreditopuntoventa.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				//this.notacreditopuntoventa.sethora(arrColumnas[iColumn++]);
				this.notacreditopuntoventa.settotal_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditopuntoventa.settotal_sin_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditopuntoventa.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditopuntoventa.setdescuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditopuntoventa.setfinanciamiento(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditopuntoventa.setflete(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditopuntoventa.setice(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditopuntoventa.setotros(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditopuntoventa.setsub_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditopuntoventa.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.notacreditopuntoventas.add(this.notacreditopuntoventa);
			}
			
			this.saveNotaCreditoPuntoVentas();
			
			this.connexion.commit();
			
			notacreditopuntoventaReturnGeneral.setConRetornoEstaProcesado(true);
			notacreditopuntoventaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return notacreditopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarNotaCreditoPuntoVentasEliminados() throws Exception {				
		
		List<NotaCreditoPuntoVenta> notacreditopuntoventasAux= new ArrayList<NotaCreditoPuntoVenta>();
		
		for(NotaCreditoPuntoVenta notacreditopuntoventa:notacreditopuntoventas) {
			if(!notacreditopuntoventa.getIsDeleted()) {
				notacreditopuntoventasAux.add(notacreditopuntoventa);
			}
		}
		
		notacreditopuntoventas=notacreditopuntoventasAux;
	}
	
	public void quitarNotaCreditoPuntoVentasNulos() throws Exception {				
		
		List<NotaCreditoPuntoVenta> notacreditopuntoventasAux= new ArrayList<NotaCreditoPuntoVenta>();
		
		for(NotaCreditoPuntoVenta notacreditopuntoventa : this.notacreditopuntoventas) {
			if(notacreditopuntoventa==null) {
				notacreditopuntoventasAux.add(notacreditopuntoventa);
			}
		}
		
		//this.notacreditopuntoventas=notacreditopuntoventasAux;
		
		this.notacreditopuntoventas.removeAll(notacreditopuntoventasAux);
	}
	
	public void getSetVersionRowNotaCreditoPuntoVentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(notacreditopuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((notacreditopuntoventa.getIsDeleted() || (notacreditopuntoventa.getIsChanged()&&!notacreditopuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=notacreditopuntoventaDataAccess.getSetVersionRowNotaCreditoPuntoVenta(connexion,notacreditopuntoventa.getId());
				
				if(!notacreditopuntoventa.getVersionRow().equals(timestamp)) {	
					notacreditopuntoventa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				notacreditopuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowNotaCreditoPuntoVenta()throws Exception {	
		
		if(notacreditopuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((notacreditopuntoventa.getIsDeleted() || (notacreditopuntoventa.getIsChanged()&&!notacreditopuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=notacreditopuntoventaDataAccess.getSetVersionRowNotaCreditoPuntoVenta(connexion,notacreditopuntoventa.getId());
			
			try {							
				if(!notacreditopuntoventa.getVersionRow().equals(timestamp)) {	
					notacreditopuntoventa.setVersionRow(timestamp);
				}
				
				notacreditopuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowNotaCreditoPuntoVentasWithConnection()throws Exception {	
		if(notacreditopuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(NotaCreditoPuntoVenta notacreditopuntoventaAux:notacreditopuntoventas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(notacreditopuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(notacreditopuntoventaAux.getIsDeleted() || (notacreditopuntoventaAux.getIsChanged()&&!notacreditopuntoventaAux.getIsNew())) {
						
						timestamp=notacreditopuntoventaDataAccess.getSetVersionRowNotaCreditoPuntoVenta(connexion,notacreditopuntoventaAux.getId());
						
						if(!notacreditopuntoventa.getVersionRow().equals(timestamp)) {	
							notacreditopuntoventaAux.setVersionRow(timestamp);
						}
								
						notacreditopuntoventaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowNotaCreditoPuntoVentas()throws Exception {	
		if(notacreditopuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(NotaCreditoPuntoVenta notacreditopuntoventaAux:notacreditopuntoventas) {
					if(notacreditopuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(notacreditopuntoventaAux.getIsDeleted() || (notacreditopuntoventaAux.getIsChanged()&&!notacreditopuntoventaAux.getIsNew())) {
						
						timestamp=notacreditopuntoventaDataAccess.getSetVersionRowNotaCreditoPuntoVenta(connexion,notacreditopuntoventaAux.getId());
						
						if(!notacreditopuntoventaAux.getVersionRow().equals(timestamp)) {	
							notacreditopuntoventaAux.setVersionRow(timestamp);
						}
						
													
						notacreditopuntoventaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public NotaCreditoPuntoVentaParameterReturnGeneral cargarCombosLoteForeignKeyNotaCreditoPuntoVentaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalVendedor,String finalQueryGlobalCliente,String finalQueryGlobalCaja,String finalQueryGlobalAsientoContable,String finalQueryGlobalTipoPrecio,String finalQueryGlobalMesa,String finalQueryGlobalFormato,String finalQueryGlobalTipoFacturaPuntoVenta,String finalQueryGlobalEstadoNotaCreditoPuntoVenta) throws Exception {
		NotaCreditoPuntoVentaParameterReturnGeneral  notacreditopuntoventaReturnGeneral =new NotaCreditoPuntoVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-cargarCombosLoteForeignKeyNotaCreditoPuntoVentaWithConnection");connexion.begin();
			
			notacreditopuntoventaReturnGeneral =new NotaCreditoPuntoVentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			notacreditopuntoventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			notacreditopuntoventaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			notacreditopuntoventaReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			notacreditopuntoventaReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			//clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			notacreditopuntoventaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Caja> cajasForeignKey=new ArrayList<Caja>();
			CajaLogic cajaLogic=new CajaLogic();
			cajaLogic.setConnexion(this.connexion);
			cajaLogic.getCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCaja.equals("NONE")) {
				cajaLogic.getTodosCajas(finalQueryGlobalCaja,new Pagination());
				cajasForeignKey=cajaLogic.getCajas();
			}

			notacreditopuntoventaReturnGeneral.setcajasForeignKey(cajasForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			notacreditopuntoventaReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			notacreditopuntoventaReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Mesa> mesasForeignKey=new ArrayList<Mesa>();
			MesaLogic mesaLogic=new MesaLogic();
			mesaLogic.setConnexion(this.connexion);
			mesaLogic.getMesaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMesa.equals("NONE")) {
				mesaLogic.getTodosMesas(finalQueryGlobalMesa,new Pagination());
				mesasForeignKey=mesaLogic.getMesas();
			}

			notacreditopuntoventaReturnGeneral.setmesasForeignKey(mesasForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			notacreditopuntoventaReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<TipoFacturaPuntoVenta> tipofacturapuntoventasForeignKey=new ArrayList<TipoFacturaPuntoVenta>();
			TipoFacturaPuntoVentaLogic tipofacturapuntoventaLogic=new TipoFacturaPuntoVentaLogic();
			tipofacturapuntoventaLogic.setConnexion(this.connexion);
			tipofacturapuntoventaLogic.getTipoFacturaPuntoVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFacturaPuntoVenta.equals("NONE")) {
				tipofacturapuntoventaLogic.getTodosTipoFacturaPuntoVentas(finalQueryGlobalTipoFacturaPuntoVenta,new Pagination());
				tipofacturapuntoventasForeignKey=tipofacturapuntoventaLogic.getTipoFacturaPuntoVentas();
			}

			notacreditopuntoventaReturnGeneral.settipofacturapuntoventasForeignKey(tipofacturapuntoventasForeignKey);


			List<EstadoNotaCredito> estadonotacreditopuntoventasForeignKey=new ArrayList<EstadoNotaCredito>();
			EstadoNotaCreditoLogic estadonotacreditopuntoventaLogic=new EstadoNotaCreditoLogic();
			estadonotacreditopuntoventaLogic.setConnexion(this.connexion);
			estadonotacreditopuntoventaLogic.getEstadoNotaCreditoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoNotaCreditoPuntoVenta.equals("NONE")) {
				estadonotacreditopuntoventaLogic.getTodosEstadoNotaCreditos(finalQueryGlobalEstadoNotaCreditoPuntoVenta,new Pagination());
				estadonotacreditopuntoventasForeignKey=estadonotacreditopuntoventaLogic.getEstadoNotaCreditos();
			}

			notacreditopuntoventaReturnGeneral.setestadonotacreditopuntoventasForeignKey(estadonotacreditopuntoventasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return notacreditopuntoventaReturnGeneral;
	}
	
	public NotaCreditoPuntoVentaParameterReturnGeneral cargarCombosLoteForeignKeyNotaCreditoPuntoVenta(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalVendedor,String finalQueryGlobalCliente,String finalQueryGlobalCaja,String finalQueryGlobalAsientoContable,String finalQueryGlobalTipoPrecio,String finalQueryGlobalMesa,String finalQueryGlobalFormato,String finalQueryGlobalTipoFacturaPuntoVenta,String finalQueryGlobalEstadoNotaCreditoPuntoVenta) throws Exception {
		NotaCreditoPuntoVentaParameterReturnGeneral  notacreditopuntoventaReturnGeneral =new NotaCreditoPuntoVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			notacreditopuntoventaReturnGeneral =new NotaCreditoPuntoVentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			notacreditopuntoventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			notacreditopuntoventaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			notacreditopuntoventaReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			notacreditopuntoventaReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			//clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			notacreditopuntoventaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Caja> cajasForeignKey=new ArrayList<Caja>();
			CajaLogic cajaLogic=new CajaLogic();
			cajaLogic.setConnexion(this.connexion);
			cajaLogic.getCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCaja.equals("NONE")) {
				cajaLogic.getTodosCajas(finalQueryGlobalCaja,new Pagination());
				cajasForeignKey=cajaLogic.getCajas();
			}

			notacreditopuntoventaReturnGeneral.setcajasForeignKey(cajasForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			notacreditopuntoventaReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			notacreditopuntoventaReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Mesa> mesasForeignKey=new ArrayList<Mesa>();
			MesaLogic mesaLogic=new MesaLogic();
			mesaLogic.setConnexion(this.connexion);
			mesaLogic.getMesaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMesa.equals("NONE")) {
				mesaLogic.getTodosMesas(finalQueryGlobalMesa,new Pagination());
				mesasForeignKey=mesaLogic.getMesas();
			}

			notacreditopuntoventaReturnGeneral.setmesasForeignKey(mesasForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			notacreditopuntoventaReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<TipoFacturaPuntoVenta> tipofacturapuntoventasForeignKey=new ArrayList<TipoFacturaPuntoVenta>();
			TipoFacturaPuntoVentaLogic tipofacturapuntoventaLogic=new TipoFacturaPuntoVentaLogic();
			tipofacturapuntoventaLogic.setConnexion(this.connexion);
			tipofacturapuntoventaLogic.getTipoFacturaPuntoVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFacturaPuntoVenta.equals("NONE")) {
				tipofacturapuntoventaLogic.getTodosTipoFacturaPuntoVentas(finalQueryGlobalTipoFacturaPuntoVenta,new Pagination());
				tipofacturapuntoventasForeignKey=tipofacturapuntoventaLogic.getTipoFacturaPuntoVentas();
			}

			notacreditopuntoventaReturnGeneral.settipofacturapuntoventasForeignKey(tipofacturapuntoventasForeignKey);


			List<EstadoNotaCredito> estadonotacreditopuntoventasForeignKey=new ArrayList<EstadoNotaCredito>();
			EstadoNotaCreditoLogic estadonotacreditopuntoventaLogic=new EstadoNotaCreditoLogic();
			estadonotacreditopuntoventaLogic.setConnexion(this.connexion);
			estadonotacreditopuntoventaLogic.getEstadoNotaCreditoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoNotaCreditoPuntoVenta.equals("NONE")) {
				estadonotacreditopuntoventaLogic.getTodosEstadoNotaCreditos(finalQueryGlobalEstadoNotaCreditoPuntoVenta,new Pagination());
				estadonotacreditopuntoventasForeignKey=estadonotacreditopuntoventaLogic.getEstadoNotaCreditos();
			}

			notacreditopuntoventaReturnGeneral.setestadonotacreditopuntoventasForeignKey(estadonotacreditopuntoventasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return notacreditopuntoventaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyNotaCreditoPuntoVentaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleNotaCreditoPuntoVentaLogic detallenotacreditopuntoventaLogic=new DetalleNotaCreditoPuntoVentaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyNotaCreditoPuntoVentaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleNotaCreditoPuntoVenta.class));
											
			

			detallenotacreditopuntoventaLogic.setConnexion(this.getConnexion());
			detallenotacreditopuntoventaLogic.setDatosCliente(this.datosCliente);
			detallenotacreditopuntoventaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(NotaCreditoPuntoVenta notacreditopuntoventa:this.notacreditopuntoventas) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleNotaCreditoPuntoVentaConstantesFunciones.getClassesForeignKeysOfDetalleNotaCreditoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallenotacreditopuntoventaLogic.setDetalleNotaCreditoPuntoVentas(notacreditopuntoventa.detallenotacreditopuntoventas);
				detallenotacreditopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(NotaCreditoPuntoVenta notacreditopuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			NotaCreditoPuntoVentaLogicAdditional.updateNotaCreditoPuntoVentaToGet(notacreditopuntoventa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		notacreditopuntoventa.setEmpresa(notacreditopuntoventaDataAccess.getEmpresa(connexion,notacreditopuntoventa));
		notacreditopuntoventa.setSucursal(notacreditopuntoventaDataAccess.getSucursal(connexion,notacreditopuntoventa));
		notacreditopuntoventa.setUsuario(notacreditopuntoventaDataAccess.getUsuario(connexion,notacreditopuntoventa));
		notacreditopuntoventa.setVendedor(notacreditopuntoventaDataAccess.getVendedor(connexion,notacreditopuntoventa));
		notacreditopuntoventa.setCliente(notacreditopuntoventaDataAccess.getCliente(connexion,notacreditopuntoventa));
		notacreditopuntoventa.setCaja(notacreditopuntoventaDataAccess.getCaja(connexion,notacreditopuntoventa));
		notacreditopuntoventa.setAsientoContable(notacreditopuntoventaDataAccess.getAsientoContable(connexion,notacreditopuntoventa));
		notacreditopuntoventa.setTipoPrecio(notacreditopuntoventaDataAccess.getTipoPrecio(connexion,notacreditopuntoventa));
		notacreditopuntoventa.setMesa(notacreditopuntoventaDataAccess.getMesa(connexion,notacreditopuntoventa));
		notacreditopuntoventa.setFormato(notacreditopuntoventaDataAccess.getFormato(connexion,notacreditopuntoventa));
		notacreditopuntoventa.setTipoFacturaPuntoVenta(notacreditopuntoventaDataAccess.getTipoFacturaPuntoVenta(connexion,notacreditopuntoventa));
		notacreditopuntoventa.setEstadoNotaCreditoPuntoVenta(notacreditopuntoventaDataAccess.getEstadoNotaCreditoPuntoVenta(connexion,notacreditopuntoventa));
		notacreditopuntoventa.setDetalleNotaCreditoPuntoVentas(notacreditopuntoventaDataAccess.getDetalleNotaCreditoPuntoVentas(connexion,notacreditopuntoventa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				notacreditopuntoventa.setEmpresa(notacreditopuntoventaDataAccess.getEmpresa(connexion,notacreditopuntoventa));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				notacreditopuntoventa.setSucursal(notacreditopuntoventaDataAccess.getSucursal(connexion,notacreditopuntoventa));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				notacreditopuntoventa.setUsuario(notacreditopuntoventaDataAccess.getUsuario(connexion,notacreditopuntoventa));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				notacreditopuntoventa.setVendedor(notacreditopuntoventaDataAccess.getVendedor(connexion,notacreditopuntoventa));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				notacreditopuntoventa.setCliente(notacreditopuntoventaDataAccess.getCliente(connexion,notacreditopuntoventa));
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				notacreditopuntoventa.setCaja(notacreditopuntoventaDataAccess.getCaja(connexion,notacreditopuntoventa));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				notacreditopuntoventa.setAsientoContable(notacreditopuntoventaDataAccess.getAsientoContable(connexion,notacreditopuntoventa));
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				notacreditopuntoventa.setTipoPrecio(notacreditopuntoventaDataAccess.getTipoPrecio(connexion,notacreditopuntoventa));
				continue;
			}

			if(clas.clas.equals(Mesa.class)) {
				notacreditopuntoventa.setMesa(notacreditopuntoventaDataAccess.getMesa(connexion,notacreditopuntoventa));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				notacreditopuntoventa.setFormato(notacreditopuntoventaDataAccess.getFormato(connexion,notacreditopuntoventa));
				continue;
			}

			if(clas.clas.equals(TipoFacturaPuntoVenta.class)) {
				notacreditopuntoventa.setTipoFacturaPuntoVenta(notacreditopuntoventaDataAccess.getTipoFacturaPuntoVenta(connexion,notacreditopuntoventa));
				continue;
			}

			if(clas.clas.equals(EstadoNotaCredito.class)) {
				notacreditopuntoventa.setEstadoNotaCreditoPuntoVenta(notacreditopuntoventaDataAccess.getEstadoNotaCreditoPuntoVenta(connexion,notacreditopuntoventa));
				continue;
			}

			if(clas.clas.equals(DetalleNotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				notacreditopuntoventa.setDetalleNotaCreditoPuntoVentas(notacreditopuntoventaDataAccess.getDetalleNotaCreditoPuntoVentas(connexion,notacreditopuntoventa));

				if(this.isConDeep) {
					DetalleNotaCreditoPuntoVentaLogic detallenotacreditopuntoventaLogic= new DetalleNotaCreditoPuntoVentaLogic(this.connexion);
					detallenotacreditopuntoventaLogic.setDetalleNotaCreditoPuntoVentas(notacreditopuntoventa.getDetalleNotaCreditoPuntoVentas());
					ArrayList<Classe> classesLocal=DetalleNotaCreditoPuntoVentaConstantesFunciones.getClassesForeignKeysOfDetalleNotaCreditoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallenotacreditopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventaLogic.getDetalleNotaCreditoPuntoVentas());
					notacreditopuntoventa.setDetalleNotaCreditoPuntoVentas(detallenotacreditopuntoventaLogic.getDetalleNotaCreditoPuntoVentas());
				}

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
			notacreditopuntoventa.setEmpresa(notacreditopuntoventaDataAccess.getEmpresa(connexion,notacreditopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setSucursal(notacreditopuntoventaDataAccess.getSucursal(connexion,notacreditopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setUsuario(notacreditopuntoventaDataAccess.getUsuario(connexion,notacreditopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setVendedor(notacreditopuntoventaDataAccess.getVendedor(connexion,notacreditopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setCliente(notacreditopuntoventaDataAccess.getCliente(connexion,notacreditopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setCaja(notacreditopuntoventaDataAccess.getCaja(connexion,notacreditopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setAsientoContable(notacreditopuntoventaDataAccess.getAsientoContable(connexion,notacreditopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setTipoPrecio(notacreditopuntoventaDataAccess.getTipoPrecio(connexion,notacreditopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mesa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setMesa(notacreditopuntoventaDataAccess.getMesa(connexion,notacreditopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setFormato(notacreditopuntoventaDataAccess.getFormato(connexion,notacreditopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFacturaPuntoVenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setTipoFacturaPuntoVenta(notacreditopuntoventaDataAccess.getTipoFacturaPuntoVenta(connexion,notacreditopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoNotaCredito.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setEstadoNotaCreditoPuntoVenta(notacreditopuntoventaDataAccess.getEstadoNotaCreditoPuntoVenta(connexion,notacreditopuntoventa));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleNotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleNotaCreditoPuntoVenta.class));
			notacreditopuntoventa.setDetalleNotaCreditoPuntoVentas(notacreditopuntoventaDataAccess.getDetalleNotaCreditoPuntoVentas(connexion,notacreditopuntoventa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		notacreditopuntoventa.setEmpresa(notacreditopuntoventaDataAccess.getEmpresa(connexion,notacreditopuntoventa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(notacreditopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		notacreditopuntoventa.setSucursal(notacreditopuntoventaDataAccess.getSucursal(connexion,notacreditopuntoventa));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(notacreditopuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				
		notacreditopuntoventa.setUsuario(notacreditopuntoventaDataAccess.getUsuario(connexion,notacreditopuntoventa));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(notacreditopuntoventa.getUsuario(),isDeep,deepLoadType,clases);
				
		notacreditopuntoventa.setVendedor(notacreditopuntoventaDataAccess.getVendedor(connexion,notacreditopuntoventa));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(notacreditopuntoventa.getVendedor(),isDeep,deepLoadType,clases);
				
		notacreditopuntoventa.setCliente(notacreditopuntoventaDataAccess.getCliente(connexion,notacreditopuntoventa));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(notacreditopuntoventa.getCliente(),isDeep,deepLoadType,clases);
				
		notacreditopuntoventa.setCaja(notacreditopuntoventaDataAccess.getCaja(connexion,notacreditopuntoventa));
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(notacreditopuntoventa.getCaja(),isDeep,deepLoadType,clases);
				
		notacreditopuntoventa.setAsientoContable(notacreditopuntoventaDataAccess.getAsientoContable(connexion,notacreditopuntoventa));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(notacreditopuntoventa.getAsientoContable(),isDeep,deepLoadType,clases);
				
		notacreditopuntoventa.setTipoPrecio(notacreditopuntoventaDataAccess.getTipoPrecio(connexion,notacreditopuntoventa));
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(notacreditopuntoventa.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		notacreditopuntoventa.setMesa(notacreditopuntoventaDataAccess.getMesa(connexion,notacreditopuntoventa));
		MesaLogic mesaLogic= new MesaLogic(connexion);
		mesaLogic.deepLoad(notacreditopuntoventa.getMesa(),isDeep,deepLoadType,clases);
				
		notacreditopuntoventa.setFormato(notacreditopuntoventaDataAccess.getFormato(connexion,notacreditopuntoventa));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(notacreditopuntoventa.getFormato(),isDeep,deepLoadType,clases);
				
		notacreditopuntoventa.setTipoFacturaPuntoVenta(notacreditopuntoventaDataAccess.getTipoFacturaPuntoVenta(connexion,notacreditopuntoventa));
		TipoFacturaPuntoVentaLogic tipofacturapuntoventaLogic= new TipoFacturaPuntoVentaLogic(connexion);
		tipofacturapuntoventaLogic.deepLoad(notacreditopuntoventa.getTipoFacturaPuntoVenta(),isDeep,deepLoadType,clases);
				
		notacreditopuntoventa.setEstadoNotaCreditoPuntoVenta(notacreditopuntoventaDataAccess.getEstadoNotaCreditoPuntoVenta(connexion,notacreditopuntoventa));
		EstadoNotaCreditoLogic estadonotacreditopuntoventaLogic= new EstadoNotaCreditoLogic(connexion);
		estadonotacreditopuntoventaLogic.deepLoad(notacreditopuntoventa.getEstadoNotaCreditoPuntoVenta(),isDeep,deepLoadType,clases);
				

		notacreditopuntoventa.setDetalleNotaCreditoPuntoVentas(notacreditopuntoventaDataAccess.getDetalleNotaCreditoPuntoVentas(connexion,notacreditopuntoventa));

		for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa:notacreditopuntoventa.getDetalleNotaCreditoPuntoVentas()) {
			DetalleNotaCreditoPuntoVentaLogic detallenotacreditopuntoventaLogic= new DetalleNotaCreditoPuntoVentaLogic(connexion);
			detallenotacreditopuntoventaLogic.deepLoad(detallenotacreditopuntoventa,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				notacreditopuntoventa.setEmpresa(notacreditopuntoventaDataAccess.getEmpresa(connexion,notacreditopuntoventa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(notacreditopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				notacreditopuntoventa.setSucursal(notacreditopuntoventaDataAccess.getSucursal(connexion,notacreditopuntoventa));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(notacreditopuntoventa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				notacreditopuntoventa.setUsuario(notacreditopuntoventaDataAccess.getUsuario(connexion,notacreditopuntoventa));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(notacreditopuntoventa.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				notacreditopuntoventa.setVendedor(notacreditopuntoventaDataAccess.getVendedor(connexion,notacreditopuntoventa));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(notacreditopuntoventa.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				notacreditopuntoventa.setCliente(notacreditopuntoventaDataAccess.getCliente(connexion,notacreditopuntoventa));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(notacreditopuntoventa.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				notacreditopuntoventa.setCaja(notacreditopuntoventaDataAccess.getCaja(connexion,notacreditopuntoventa));
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepLoad(notacreditopuntoventa.getCaja(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				notacreditopuntoventa.setAsientoContable(notacreditopuntoventaDataAccess.getAsientoContable(connexion,notacreditopuntoventa));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(notacreditopuntoventa.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				notacreditopuntoventa.setTipoPrecio(notacreditopuntoventaDataAccess.getTipoPrecio(connexion,notacreditopuntoventa));
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepLoad(notacreditopuntoventa.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mesa.class)) {
				notacreditopuntoventa.setMesa(notacreditopuntoventaDataAccess.getMesa(connexion,notacreditopuntoventa));
				MesaLogic mesaLogic= new MesaLogic(connexion);
				mesaLogic.deepLoad(notacreditopuntoventa.getMesa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				notacreditopuntoventa.setFormato(notacreditopuntoventaDataAccess.getFormato(connexion,notacreditopuntoventa));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(notacreditopuntoventa.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFacturaPuntoVenta.class)) {
				notacreditopuntoventa.setTipoFacturaPuntoVenta(notacreditopuntoventaDataAccess.getTipoFacturaPuntoVenta(connexion,notacreditopuntoventa));
				TipoFacturaPuntoVentaLogic tipofacturapuntoventaLogic= new TipoFacturaPuntoVentaLogic(connexion);
				tipofacturapuntoventaLogic.deepLoad(notacreditopuntoventa.getTipoFacturaPuntoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoNotaCredito.class)) {
				notacreditopuntoventa.setEstadoNotaCreditoPuntoVenta(notacreditopuntoventaDataAccess.getEstadoNotaCreditoPuntoVenta(connexion,notacreditopuntoventa));
				EstadoNotaCreditoLogic estadonotacreditoLogic= new EstadoNotaCreditoLogic(connexion);
				estadonotacreditoLogic.deepLoad(notacreditopuntoventa.getEstadoNotaCreditoPuntoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleNotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				notacreditopuntoventa.setDetalleNotaCreditoPuntoVentas(notacreditopuntoventaDataAccess.getDetalleNotaCreditoPuntoVentas(connexion,notacreditopuntoventa));

				for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa:notacreditopuntoventa.getDetalleNotaCreditoPuntoVentas()) {
					DetalleNotaCreditoPuntoVentaLogic detallenotacreditopuntoventaLogic= new DetalleNotaCreditoPuntoVentaLogic(connexion);
					detallenotacreditopuntoventaLogic.deepLoad(detallenotacreditopuntoventa,isDeep,deepLoadType,clases);
				}
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
			notacreditopuntoventa.setEmpresa(notacreditopuntoventaDataAccess.getEmpresa(connexion,notacreditopuntoventa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(notacreditopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setSucursal(notacreditopuntoventaDataAccess.getSucursal(connexion,notacreditopuntoventa));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(notacreditopuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setUsuario(notacreditopuntoventaDataAccess.getUsuario(connexion,notacreditopuntoventa));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(notacreditopuntoventa.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setVendedor(notacreditopuntoventaDataAccess.getVendedor(connexion,notacreditopuntoventa));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(notacreditopuntoventa.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setCliente(notacreditopuntoventaDataAccess.getCliente(connexion,notacreditopuntoventa));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(notacreditopuntoventa.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setCaja(notacreditopuntoventaDataAccess.getCaja(connexion,notacreditopuntoventa));
			CajaLogic cajaLogic= new CajaLogic(connexion);
			cajaLogic.deepLoad(notacreditopuntoventa.getCaja(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setAsientoContable(notacreditopuntoventaDataAccess.getAsientoContable(connexion,notacreditopuntoventa));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(notacreditopuntoventa.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setTipoPrecio(notacreditopuntoventaDataAccess.getTipoPrecio(connexion,notacreditopuntoventa));
			TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
			tipoprecioLogic.deepLoad(notacreditopuntoventa.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mesa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setMesa(notacreditopuntoventaDataAccess.getMesa(connexion,notacreditopuntoventa));
			MesaLogic mesaLogic= new MesaLogic(connexion);
			mesaLogic.deepLoad(notacreditopuntoventa.getMesa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setFormato(notacreditopuntoventaDataAccess.getFormato(connexion,notacreditopuntoventa));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(notacreditopuntoventa.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFacturaPuntoVenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setTipoFacturaPuntoVenta(notacreditopuntoventaDataAccess.getTipoFacturaPuntoVenta(connexion,notacreditopuntoventa));
			TipoFacturaPuntoVentaLogic tipofacturapuntoventaLogic= new TipoFacturaPuntoVentaLogic(connexion);
			tipofacturapuntoventaLogic.deepLoad(notacreditopuntoventa.getTipoFacturaPuntoVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoNotaCredito.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditopuntoventa.setEstadoNotaCreditoPuntoVenta(notacreditopuntoventaDataAccess.getEstadoNotaCreditoPuntoVenta(connexion,notacreditopuntoventa));
			EstadoNotaCreditoLogic estadonotacreditoLogic= new EstadoNotaCreditoLogic(connexion);
			estadonotacreditoLogic.deepLoad(notacreditopuntoventa.getEstadoNotaCreditoPuntoVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleNotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleNotaCreditoPuntoVenta.class));
			notacreditopuntoventa.setDetalleNotaCreditoPuntoVentas(notacreditopuntoventaDataAccess.getDetalleNotaCreditoPuntoVentas(connexion,notacreditopuntoventa));

			for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa:notacreditopuntoventa.getDetalleNotaCreditoPuntoVentas()) {
				DetalleNotaCreditoPuntoVentaLogic detallenotacreditopuntoventaLogic= new DetalleNotaCreditoPuntoVentaLogic(connexion);
				detallenotacreditopuntoventaLogic.deepLoad(detallenotacreditopuntoventa,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(NotaCreditoPuntoVenta notacreditopuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			NotaCreditoPuntoVentaLogicAdditional.updateNotaCreditoPuntoVentaToSave(notacreditopuntoventa,this.arrDatoGeneral);
			
NotaCreditoPuntoVentaDataAccess.save(notacreditopuntoventa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(notacreditopuntoventa.getEmpresa(),connexion);

		SucursalDataAccess.save(notacreditopuntoventa.getSucursal(),connexion);

		UsuarioDataAccess.save(notacreditopuntoventa.getUsuario(),connexion);

		VendedorDataAccess.save(notacreditopuntoventa.getVendedor(),connexion);

		ClienteDataAccess.save(notacreditopuntoventa.getCliente(),connexion);

		CajaDataAccess.save(notacreditopuntoventa.getCaja(),connexion);

		AsientoContableDataAccess.save(notacreditopuntoventa.getAsientoContable(),connexion);

		TipoPrecioDataAccess.save(notacreditopuntoventa.getTipoPrecio(),connexion);

		MesaDataAccess.save(notacreditopuntoventa.getMesa(),connexion);

		FormatoDataAccess.save(notacreditopuntoventa.getFormato(),connexion);

		TipoFacturaPuntoVentaDataAccess.save(notacreditopuntoventa.getTipoFacturaPuntoVenta(),connexion);

		EstadoNotaCreditoDataAccess.save(notacreditopuntoventa.getEstadoNotaCreditoPuntoVenta(),connexion);

		for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa:notacreditopuntoventa.getDetalleNotaCreditoPuntoVentas()) {
			detallenotacreditopuntoventa.setid_factura_punto_venta(notacreditopuntoventa.getId());
			DetalleNotaCreditoPuntoVentaDataAccess.save(detallenotacreditopuntoventa,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(notacreditopuntoventa.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(notacreditopuntoventa.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(notacreditopuntoventa.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(notacreditopuntoventa.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(notacreditopuntoventa.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				CajaDataAccess.save(notacreditopuntoventa.getCaja(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(notacreditopuntoventa.getAsientoContable(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(notacreditopuntoventa.getTipoPrecio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mesa.class)) {
				MesaDataAccess.save(notacreditopuntoventa.getMesa(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(notacreditopuntoventa.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoFacturaPuntoVenta.class)) {
				TipoFacturaPuntoVentaDataAccess.save(notacreditopuntoventa.getTipoFacturaPuntoVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoNotaCredito.class)) {
				EstadoNotaCreditoDataAccess.save(notacreditopuntoventa.getEstadoNotaCreditoPuntoVenta(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleNotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa:notacreditopuntoventa.getDetalleNotaCreditoPuntoVentas()) {
					detallenotacreditopuntoventa.setid_factura_punto_venta(notacreditopuntoventa.getId());
					DetalleNotaCreditoPuntoVentaDataAccess.save(detallenotacreditopuntoventa,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(notacreditopuntoventa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(notacreditopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(notacreditopuntoventa.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(notacreditopuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(notacreditopuntoventa.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(notacreditopuntoventa.getUsuario(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(notacreditopuntoventa.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(notacreditopuntoventa.getVendedor(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(notacreditopuntoventa.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(notacreditopuntoventa.getCliente(),isDeep,deepLoadType,clases);
				

		CajaDataAccess.save(notacreditopuntoventa.getCaja(),connexion);
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(notacreditopuntoventa.getCaja(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(notacreditopuntoventa.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(notacreditopuntoventa.getAsientoContable(),isDeep,deepLoadType,clases);
				

		TipoPrecioDataAccess.save(notacreditopuntoventa.getTipoPrecio(),connexion);
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(notacreditopuntoventa.getTipoPrecio(),isDeep,deepLoadType,clases);
				

		MesaDataAccess.save(notacreditopuntoventa.getMesa(),connexion);
		MesaLogic mesaLogic= new MesaLogic(connexion);
		mesaLogic.deepLoad(notacreditopuntoventa.getMesa(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(notacreditopuntoventa.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(notacreditopuntoventa.getFormato(),isDeep,deepLoadType,clases);
				

		TipoFacturaPuntoVentaDataAccess.save(notacreditopuntoventa.getTipoFacturaPuntoVenta(),connexion);
		TipoFacturaPuntoVentaLogic tipofacturapuntoventaLogic= new TipoFacturaPuntoVentaLogic(connexion);
		tipofacturapuntoventaLogic.deepLoad(notacreditopuntoventa.getTipoFacturaPuntoVenta(),isDeep,deepLoadType,clases);
				

		EstadoNotaCreditoDataAccess.save(notacreditopuntoventa.getEstadoNotaCreditoPuntoVenta(),connexion);
		EstadoNotaCreditoLogic estadonotacreditopuntoventaLogic= new EstadoNotaCreditoLogic(connexion);
		estadonotacreditopuntoventaLogic.deepLoad(notacreditopuntoventa.getEstadoNotaCreditoPuntoVenta(),isDeep,deepLoadType,clases);
				

		for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa:notacreditopuntoventa.getDetalleNotaCreditoPuntoVentas()) {
			DetalleNotaCreditoPuntoVentaLogic detallenotacreditopuntoventaLogic= new DetalleNotaCreditoPuntoVentaLogic(connexion);
			detallenotacreditopuntoventa.setid_factura_punto_venta(notacreditopuntoventa.getId());
			DetalleNotaCreditoPuntoVentaDataAccess.save(detallenotacreditopuntoventa,connexion);
			detallenotacreditopuntoventaLogic.deepSave(detallenotacreditopuntoventa,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(notacreditopuntoventa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(notacreditopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(notacreditopuntoventa.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(notacreditopuntoventa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(notacreditopuntoventa.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(notacreditopuntoventa.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(notacreditopuntoventa.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(notacreditopuntoventa.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(notacreditopuntoventa.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(notacreditopuntoventa.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				CajaDataAccess.save(notacreditopuntoventa.getCaja(),connexion);
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepSave(notacreditopuntoventa.getCaja(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(notacreditopuntoventa.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(notacreditopuntoventa.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(notacreditopuntoventa.getTipoPrecio(),connexion);
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepSave(notacreditopuntoventa.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mesa.class)) {
				MesaDataAccess.save(notacreditopuntoventa.getMesa(),connexion);
				MesaLogic mesaLogic= new MesaLogic(connexion);
				mesaLogic.deepSave(notacreditopuntoventa.getMesa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(notacreditopuntoventa.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(notacreditopuntoventa.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFacturaPuntoVenta.class)) {
				TipoFacturaPuntoVentaDataAccess.save(notacreditopuntoventa.getTipoFacturaPuntoVenta(),connexion);
				TipoFacturaPuntoVentaLogic tipofacturapuntoventaLogic= new TipoFacturaPuntoVentaLogic(connexion);
				tipofacturapuntoventaLogic.deepSave(notacreditopuntoventa.getTipoFacturaPuntoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoNotaCredito.class)) {
				EstadoNotaCreditoDataAccess.save(notacreditopuntoventa.getEstadoNotaCreditoPuntoVenta(),connexion);
				EstadoNotaCreditoLogic estadonotacreditoLogic= new EstadoNotaCreditoLogic(connexion);
				estadonotacreditoLogic.deepSave(notacreditopuntoventa.getEstadoNotaCreditoPuntoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleNotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa:notacreditopuntoventa.getDetalleNotaCreditoPuntoVentas()) {
					DetalleNotaCreditoPuntoVentaLogic detallenotacreditopuntoventaLogic= new DetalleNotaCreditoPuntoVentaLogic(connexion);
					detallenotacreditopuntoventa.setid_factura_punto_venta(notacreditopuntoventa.getId());
					DetalleNotaCreditoPuntoVentaDataAccess.save(detallenotacreditopuntoventa,connexion);
					detallenotacreditopuntoventaLogic.deepSave(detallenotacreditopuntoventa,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(NotaCreditoPuntoVenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(notacreditopuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(notacreditopuntoventa);
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
			this.deepLoad(this.notacreditopuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(NotaCreditoPuntoVenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(notacreditopuntoventas!=null) {
				for(NotaCreditoPuntoVenta notacreditopuntoventa:notacreditopuntoventas) {
					this.deepLoad(notacreditopuntoventa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(notacreditopuntoventas);
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
			if(notacreditopuntoventas!=null) {
				for(NotaCreditoPuntoVenta notacreditopuntoventa:notacreditopuntoventas) {
					this.deepLoad(notacreditopuntoventa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(notacreditopuntoventas);
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
			this.getNewConnexionToDeep(NotaCreditoPuntoVenta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(notacreditopuntoventa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(NotaCreditoPuntoVenta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(notacreditopuntoventas!=null) {
				for(NotaCreditoPuntoVenta notacreditopuntoventa:notacreditopuntoventas) {
					this.deepSave(notacreditopuntoventa,isDeep,deepLoadType,clases);
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
			if(notacreditopuntoventas!=null) {
				for(NotaCreditoPuntoVenta notacreditopuntoventa:notacreditopuntoventas) {
					this.deepSave(notacreditopuntoventa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getNotaCreditoPuntoVentasFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,NotaCreditoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,NotaCreditoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdCajaWithConnection(String sFinalQuery,Pagination pagination,Long id_caja)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_caja,NotaCreditoPuntoVentaConstantesFunciones.IDCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCaja);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdCaja(String sFinalQuery,Pagination pagination,Long id_caja)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_caja,NotaCreditoPuntoVentaConstantesFunciones.IDCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCaja);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,NotaCreditoPuntoVentaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,NotaCreditoPuntoVentaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdEstadoNotaCreditoPuntoVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_nota_credito_punto_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoNotaCreditoPuntoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoNotaCreditoPuntoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_nota_credito_punto_venta,NotaCreditoPuntoVentaConstantesFunciones.IDESTADONOTACREDITOPUNTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoNotaCreditoPuntoVenta);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoNotaCreditoPuntoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdEstadoNotaCreditoPuntoVenta(String sFinalQuery,Pagination pagination,Long id_estado_nota_credito_punto_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoNotaCreditoPuntoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoNotaCreditoPuntoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_nota_credito_punto_venta,NotaCreditoPuntoVentaConstantesFunciones.IDESTADONOTACREDITOPUNTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoNotaCreditoPuntoVenta);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoNotaCreditoPuntoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,NotaCreditoPuntoVentaConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,NotaCreditoPuntoVentaConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdMesaWithConnection(String sFinalQuery,Pagination pagination,Long id_mesa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMesa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMesa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mesa,NotaCreditoPuntoVentaConstantesFunciones.IDMESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMesa);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMesa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdMesa(String sFinalQuery,Pagination pagination,Long id_mesa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMesa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMesa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mesa,NotaCreditoPuntoVentaConstantesFunciones.IDMESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMesa);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMesa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,NotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,NotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdTipoFacturaPuntoVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_factura_punto_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFacturaPuntoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFacturaPuntoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_factura_punto_venta,NotaCreditoPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFacturaPuntoVenta);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFacturaPuntoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdTipoFacturaPuntoVenta(String sFinalQuery,Pagination pagination,Long id_tipo_factura_punto_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFacturaPuntoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFacturaPuntoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_factura_punto_venta,NotaCreditoPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFacturaPuntoVenta);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFacturaPuntoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdTipoPrecioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,NotaCreditoPuntoVentaConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdTipoPrecio(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,NotaCreditoPuntoVentaConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,NotaCreditoPuntoVentaConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,NotaCreditoPuntoVentaConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,NotaCreditoPuntoVentaConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoPuntoVentasFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,NotaCreditoPuntoVentaConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			NotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(this.notacreditopuntoventas);
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
			if(NotaCreditoPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,NotaCreditoPuntoVentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,NotaCreditoPuntoVenta notacreditopuntoventa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(NotaCreditoPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				if(notacreditopuntoventa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NotaCreditoPuntoVentaDataAccess.TABLENAME, notacreditopuntoventa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NotaCreditoPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NotaCreditoPuntoVentaLogic.registrarAuditoriaDetallesNotaCreditoPuntoVenta(connexion,notacreditopuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(notacreditopuntoventa.getIsDeleted()) {
					/*if(!notacreditopuntoventa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,NotaCreditoPuntoVentaDataAccess.TABLENAME, notacreditopuntoventa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////NotaCreditoPuntoVentaLogic.registrarAuditoriaDetallesNotaCreditoPuntoVenta(connexion,notacreditopuntoventa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NotaCreditoPuntoVentaDataAccess.TABLENAME, notacreditopuntoventa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(notacreditopuntoventa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NotaCreditoPuntoVentaDataAccess.TABLENAME, notacreditopuntoventa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NotaCreditoPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NotaCreditoPuntoVentaLogic.registrarAuditoriaDetallesNotaCreditoPuntoVenta(connexion,notacreditopuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesNotaCreditoPuntoVenta(Connexion connexion,NotaCreditoPuntoVenta notacreditopuntoventa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getid_empresa().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_empresa()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_empresa().toString();
				}
				if(notacreditopuntoventa.getid_empresa()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getid_sucursal().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_sucursal()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_sucursal().toString();
				}
				if(notacreditopuntoventa.getid_sucursal()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getid_usuario().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_usuario()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_usuario().toString();
				}
				if(notacreditopuntoventa.getid_usuario()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getid_vendedor().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_vendedor()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_vendedor().toString();
				}
				if(notacreditopuntoventa.getid_vendedor()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getid_cliente().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_cliente()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_cliente().toString();
				}
				if(notacreditopuntoventa.getid_cliente()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getid_caja().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_caja()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_caja()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_caja().toString();
				}
				if(notacreditopuntoventa.getid_caja()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getid_caja().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.IDCAJA,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getid_asiento_contable().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_asiento_contable().toString();
				}
				if(notacreditopuntoventa.getid_asiento_contable()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getid_tipo_precio().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_tipo_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_tipo_precio()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_tipo_precio().toString();
				}
				if(notacreditopuntoventa.getid_tipo_precio()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getid_tipo_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.IDTIPOPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getid_mesa().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_mesa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_mesa()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_mesa().toString();
				}
				if(notacreditopuntoventa.getid_mesa()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getid_mesa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.IDMESA,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getid_formato().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_formato()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_formato().toString();
				}
				if(notacreditopuntoventa.getid_formato()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getid_tipo_factura_punto_venta().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_tipo_factura_punto_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_tipo_factura_punto_venta()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_tipo_factura_punto_venta().toString();
				}
				if(notacreditopuntoventa.getid_tipo_factura_punto_venta()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getid_tipo_factura_punto_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getid_estado_nota_credito_punto_venta().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_estado_nota_credito_punto_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_estado_nota_credito_punto_venta()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getid_estado_nota_credito_punto_venta().toString();
				}
				if(notacreditopuntoventa.getid_estado_nota_credito_punto_venta()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getid_estado_nota_credito_punto_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.IDESTADONOTACREDITOPUNTOVENTA,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getnumero_secuencial().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getnumero_secuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getnumero_secuencial()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getnumero_secuencial();
				}
				if(notacreditopuntoventa.getnumero_secuencial()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getnumero_secuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.NUMEROSECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getcodigo_cliente().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getcodigo_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getcodigo_cliente()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getcodigo_cliente();
				}
				if(notacreditopuntoventa.getcodigo_cliente()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getcodigo_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.CODIGOCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getnombre_cliente().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getnombre_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getnombre_cliente()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getnombre_cliente();
				}
				if(notacreditopuntoventa.getnombre_cliente()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getnombre_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.NOMBRECLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.gettarjeta_cliente().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().gettarjeta_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().gettarjeta_cliente()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().gettarjeta_cliente();
				}
				if(notacreditopuntoventa.gettarjeta_cliente()!=null)
				{
					strValorNuevo=notacreditopuntoventa.gettarjeta_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.TARJETACLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getdireccion_cliente().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getdireccion_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getdireccion_cliente()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getdireccion_cliente();
				}
				if(notacreditopuntoventa.getdireccion_cliente()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getdireccion_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.DIRECCIONCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.gettelefono_cliente().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().gettelefono_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().gettelefono_cliente()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().gettelefono_cliente();
				}
				if(notacreditopuntoventa.gettelefono_cliente()!=null)
				{
					strValorNuevo=notacreditopuntoventa.gettelefono_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.TELEFONOCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getfecha().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getfecha()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getfecha().toString();
				}
				if(notacreditopuntoventa.getfecha()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.gethora().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().gethora()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().gethora()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().gethora().toString();
				}
				if(notacreditopuntoventa.gethora()!=null)
				{
					strValorNuevo=notacreditopuntoventa.gethora().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.HORA,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.gettotal_iva().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().gettotal_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().gettotal_iva()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().gettotal_iva().toString();
				}
				if(notacreditopuntoventa.gettotal_iva()!=null)
				{
					strValorNuevo=notacreditopuntoventa.gettotal_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.TOTALIVA,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.gettotal_sin_iva().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().gettotal_sin_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().gettotal_sin_iva()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().gettotal_sin_iva().toString();
				}
				if(notacreditopuntoventa.gettotal_sin_iva()!=null)
				{
					strValorNuevo=notacreditopuntoventa.gettotal_sin_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.TOTALSINIVA,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getiva().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getiva()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getiva().toString();
				}
				if(notacreditopuntoventa.getiva()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getdescuento().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getdescuento()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getdescuento().toString();
				}
				if(notacreditopuntoventa.getdescuento()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getfinanciamiento().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getfinanciamiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getfinanciamiento()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getfinanciamiento().toString();
				}
				if(notacreditopuntoventa.getfinanciamiento()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getfinanciamiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.FINANCIAMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getflete().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getflete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getflete()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getflete().toString();
				}
				if(notacreditopuntoventa.getflete()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getflete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.FLETE,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getice().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getice()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getice().toString();
				}
				if(notacreditopuntoventa.getice()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getotros().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getotros()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getotros()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getotros().toString();
				}
				if(notacreditopuntoventa.getotros()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getotros().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.OTROS,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.getsub_total().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getsub_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getsub_total()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().getsub_total().toString();
				}
				if(notacreditopuntoventa.getsub_total()!=null)
				{
					strValorNuevo=notacreditopuntoventa.getsub_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(notacreditopuntoventa.getIsNew()||!notacreditopuntoventa.gettotal().equals(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().gettotal()!=null)
				{
					strValorActual=notacreditopuntoventa.getNotaCreditoPuntoVentaOriginal().gettotal().toString();
				}
				if(notacreditopuntoventa.gettotal()!=null)
				{
					strValorNuevo=notacreditopuntoventa.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoPuntoVentaConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveNotaCreditoPuntoVentaRelacionesWithConnection(NotaCreditoPuntoVenta notacreditopuntoventa,List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas) throws Exception {

		if(!notacreditopuntoventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNotaCreditoPuntoVentaRelacionesBase(notacreditopuntoventa,detallenotacreditopuntoventas,true);
		}
	}

	public void saveNotaCreditoPuntoVentaRelaciones(NotaCreditoPuntoVenta notacreditopuntoventa,List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas)throws Exception {

		if(!notacreditopuntoventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNotaCreditoPuntoVentaRelacionesBase(notacreditopuntoventa,detallenotacreditopuntoventas,false);
		}
	}

	public void saveNotaCreditoPuntoVentaRelacionesBase(NotaCreditoPuntoVenta notacreditopuntoventa,List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("NotaCreditoPuntoVenta-saveRelacionesWithConnection");}
	
			notacreditopuntoventa.setDetalleNotaCreditoPuntoVentas(detallenotacreditopuntoventas);

			this.setNotaCreditoPuntoVenta(notacreditopuntoventa);

			if(NotaCreditoPuntoVentaLogicAdditional.validarSaveRelaciones(notacreditopuntoventa,this)) {

				NotaCreditoPuntoVentaLogicAdditional.updateRelacionesToSave(notacreditopuntoventa,this);

				if((notacreditopuntoventa.getIsNew()||notacreditopuntoventa.getIsChanged())&&!notacreditopuntoventa.getIsDeleted()) {
					this.saveNotaCreditoPuntoVenta();
					this.saveNotaCreditoPuntoVentaRelacionesDetalles(detallenotacreditopuntoventas);

				} else if(notacreditopuntoventa.getIsDeleted()) {
					this.saveNotaCreditoPuntoVentaRelacionesDetalles(detallenotacreditopuntoventas);
					this.saveNotaCreditoPuntoVenta();
				}

				NotaCreditoPuntoVentaLogicAdditional.updateRelacionesToSaveAfter(notacreditopuntoventa,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleNotaCreditoPuntoVentaConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleNotaCreditoPuntoVentas(detallenotacreditopuntoventas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveNotaCreditoPuntoVentaRelacionesDetalles(List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas)throws Exception {
		try {
	

			Long idNotaCreditoPuntoVentaActual=this.getNotaCreditoPuntoVenta().getId();

			DetalleNotaCreditoPuntoVentaLogic detallenotacreditopuntoventaLogic_Desde_NotaCreditoPuntoVenta=new DetalleNotaCreditoPuntoVentaLogic();
			detallenotacreditopuntoventaLogic_Desde_NotaCreditoPuntoVenta.setDetalleNotaCreditoPuntoVentas(detallenotacreditopuntoventas);

			detallenotacreditopuntoventaLogic_Desde_NotaCreditoPuntoVenta.setConnexion(this.getConnexion());
			detallenotacreditopuntoventaLogic_Desde_NotaCreditoPuntoVenta.setDatosCliente(this.datosCliente);

			for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa_Desde_NotaCreditoPuntoVenta:detallenotacreditopuntoventaLogic_Desde_NotaCreditoPuntoVenta.getDetalleNotaCreditoPuntoVentas()) {
				detallenotacreditopuntoventa_Desde_NotaCreditoPuntoVenta.setid_factura_punto_venta(idNotaCreditoPuntoVentaActual);
			}

			detallenotacreditopuntoventaLogic_Desde_NotaCreditoPuntoVenta.saveDetalleNotaCreditoPuntoVentas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfNotaCreditoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NotaCreditoPuntoVentaConstantesFunciones.getClassesForeignKeysOfNotaCreditoPuntoVenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNotaCreditoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NotaCreditoPuntoVentaConstantesFunciones.getClassesRelationshipsOfNotaCreditoPuntoVenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

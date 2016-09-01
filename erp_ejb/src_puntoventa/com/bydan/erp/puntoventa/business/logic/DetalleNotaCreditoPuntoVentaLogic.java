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
import com.bydan.erp.puntoventa.util.DetalleNotaCreditoPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.DetalleNotaCreditoPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.DetalleNotaCreditoPuntoVentaParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.DetalleNotaCreditoPuntoVenta;
import com.bydan.erp.puntoventa.business.logic.DetalleNotaCreditoPuntoVentaLogicAdditional;
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
public class DetalleNotaCreditoPuntoVentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleNotaCreditoPuntoVentaLogic.class);
	
	protected DetalleNotaCreditoPuntoVentaDataAccess detallenotacreditopuntoventaDataAccess; 	
	protected DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa;
	protected List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas;
	protected Object detallenotacreditopuntoventaObject;	
	protected List<Object> detallenotacreditopuntoventasObject;
	
	public static ClassValidator<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventaValidator = new ClassValidator<DetalleNotaCreditoPuntoVenta>(DetalleNotaCreditoPuntoVenta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleNotaCreditoPuntoVentaLogicAdditional detallenotacreditopuntoventaLogicAdditional=null;
	
	public DetalleNotaCreditoPuntoVentaLogicAdditional getDetalleNotaCreditoPuntoVentaLogicAdditional() {
		return this.detallenotacreditopuntoventaLogicAdditional;
	}
	
	public void setDetalleNotaCreditoPuntoVentaLogicAdditional(DetalleNotaCreditoPuntoVentaLogicAdditional detallenotacreditopuntoventaLogicAdditional) {
		try {
			this.detallenotacreditopuntoventaLogicAdditional=detallenotacreditopuntoventaLogicAdditional;
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
	
	
	
	
	public  DetalleNotaCreditoPuntoVentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detallenotacreditopuntoventaDataAccess = new DetalleNotaCreditoPuntoVentaDataAccess();
			
			this.detallenotacreditopuntoventas= new ArrayList<DetalleNotaCreditoPuntoVenta>();
			this.detallenotacreditopuntoventa= new DetalleNotaCreditoPuntoVenta();
			
			this.detallenotacreditopuntoventaObject=new Object();
			this.detallenotacreditopuntoventasObject=new ArrayList<Object>();
				
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
			
			this.detallenotacreditopuntoventaDataAccess.setConnexionType(this.connexionType);
			this.detallenotacreditopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleNotaCreditoPuntoVentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detallenotacreditopuntoventaDataAccess = new DetalleNotaCreditoPuntoVentaDataAccess();
			this.detallenotacreditopuntoventas= new ArrayList<DetalleNotaCreditoPuntoVenta>();
			this.detallenotacreditopuntoventa= new DetalleNotaCreditoPuntoVenta();
			this.detallenotacreditopuntoventaObject=new Object();
			this.detallenotacreditopuntoventasObject=new ArrayList<Object>();
			
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
			
			this.detallenotacreditopuntoventaDataAccess.setConnexionType(this.connexionType);
			this.detallenotacreditopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleNotaCreditoPuntoVenta getDetalleNotaCreditoPuntoVenta() throws Exception {	
		DetalleNotaCreditoPuntoVentaLogicAdditional.checkDetalleNotaCreditoPuntoVentaToGet(detallenotacreditopuntoventa,this.datosCliente,this.arrDatoGeneral);
		DetalleNotaCreditoPuntoVentaLogicAdditional.updateDetalleNotaCreditoPuntoVentaToGet(detallenotacreditopuntoventa,this.arrDatoGeneral);
		
		return detallenotacreditopuntoventa;
	}
		
	public void setDetalleNotaCreditoPuntoVenta(DetalleNotaCreditoPuntoVenta newDetalleNotaCreditoPuntoVenta) {
		this.detallenotacreditopuntoventa = newDetalleNotaCreditoPuntoVenta;
	}
	
	public DetalleNotaCreditoPuntoVentaDataAccess getDetalleNotaCreditoPuntoVentaDataAccess() {
		return detallenotacreditopuntoventaDataAccess;
	}
	
	public void setDetalleNotaCreditoPuntoVentaDataAccess(DetalleNotaCreditoPuntoVentaDataAccess newdetallenotacreditopuntoventaDataAccess) {
		this.detallenotacreditopuntoventaDataAccess = newdetallenotacreditopuntoventaDataAccess;
	}
	
	public List<DetalleNotaCreditoPuntoVenta> getDetalleNotaCreditoPuntoVentas() throws Exception {		
		this.quitarDetalleNotaCreditoPuntoVentasNulos();
		
		DetalleNotaCreditoPuntoVentaLogicAdditional.checkDetalleNotaCreditoPuntoVentaToGets(detallenotacreditopuntoventas,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventaLocal: detallenotacreditopuntoventas ) {
			DetalleNotaCreditoPuntoVentaLogicAdditional.updateDetalleNotaCreditoPuntoVentaToGet(detallenotacreditopuntoventaLocal,this.arrDatoGeneral);
		}
		
		return detallenotacreditopuntoventas;
	}
	
	public void setDetalleNotaCreditoPuntoVentas(List<DetalleNotaCreditoPuntoVenta> newDetalleNotaCreditoPuntoVentas) {
		this.detallenotacreditopuntoventas = newDetalleNotaCreditoPuntoVentas;
	}
	
	public Object getDetalleNotaCreditoPuntoVentaObject() {	
		this.detallenotacreditopuntoventaObject=this.detallenotacreditopuntoventaDataAccess.getEntityObject();
		return this.detallenotacreditopuntoventaObject;
	}
		
	public void setDetalleNotaCreditoPuntoVentaObject(Object newDetalleNotaCreditoPuntoVentaObject) {
		this.detallenotacreditopuntoventaObject = newDetalleNotaCreditoPuntoVentaObject;
	}
	
	public List<Object> getDetalleNotaCreditoPuntoVentasObject() {		
		this.detallenotacreditopuntoventasObject=this.detallenotacreditopuntoventaDataAccess.getEntitiesObject();
		return this.detallenotacreditopuntoventasObject;
	}
		
	public void setDetalleNotaCreditoPuntoVentasObject(List<Object> newDetalleNotaCreditoPuntoVentasObject) {
		this.detallenotacreditopuntoventasObject = newDetalleNotaCreditoPuntoVentasObject;
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
		
		if(this.detallenotacreditopuntoventaDataAccess!=null) {
			this.detallenotacreditopuntoventaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detallenotacreditopuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detallenotacreditopuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detallenotacreditopuntoventa = new  DetalleNotaCreditoPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallenotacreditopuntoventa=detallenotacreditopuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallenotacreditopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventa);
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
		detallenotacreditopuntoventa = new  DetalleNotaCreditoPuntoVenta();
		  		  
        try {
			
			detallenotacreditopuntoventa=detallenotacreditopuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallenotacreditopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detallenotacreditopuntoventa = new  DetalleNotaCreditoPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallenotacreditopuntoventa=detallenotacreditopuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallenotacreditopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventa);
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
		detallenotacreditopuntoventa = new  DetalleNotaCreditoPuntoVenta();
		  		  
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
		detallenotacreditopuntoventa = new  DetalleNotaCreditoPuntoVenta();
		  		  
        try {
			
			detallenotacreditopuntoventa=detallenotacreditopuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallenotacreditopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detallenotacreditopuntoventa = new  DetalleNotaCreditoPuntoVenta();
		  		  
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
		detallenotacreditopuntoventa = new  DetalleNotaCreditoPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detallenotacreditopuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallenotacreditopuntoventa = new  DetalleNotaCreditoPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detallenotacreditopuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallenotacreditopuntoventa = new  DetalleNotaCreditoPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detallenotacreditopuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallenotacreditopuntoventa = new  DetalleNotaCreditoPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detallenotacreditopuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallenotacreditopuntoventa = new  DetalleNotaCreditoPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detallenotacreditopuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallenotacreditopuntoventa = new  DetalleNotaCreditoPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detallenotacreditopuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallenotacreditopuntoventas = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
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
		detallenotacreditopuntoventas = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		  		  
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
		detallenotacreditopuntoventas = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		  		  
        try {			
			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detallenotacreditopuntoventas = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		  		  
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
		detallenotacreditopuntoventas = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
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
		detallenotacreditopuntoventas = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		  		  
        try {
			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
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
		detallenotacreditopuntoventas = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
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
		detallenotacreditopuntoventas = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detallenotacreditopuntoventa = new  DetalleNotaCreditoPuntoVenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallenotacreditopuntoventa=detallenotacreditopuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventa);
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
		detallenotacreditopuntoventa = new  DetalleNotaCreditoPuntoVenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallenotacreditopuntoventa=detallenotacreditopuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallenotacreditopuntoventas = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
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
		detallenotacreditopuntoventas = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		  		  
        try {
			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleNotaCreditoPuntoVentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detallenotacreditopuntoventas = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-getTodosDetalleNotaCreditoPuntoVentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
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
	
	public  void  getTodosDetalleNotaCreditoPuntoVentas(String sFinalQuery,Pagination pagination)throws Exception {
		detallenotacreditopuntoventas = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleNotaCreditoPuntoVenta(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa) throws Exception {
		Boolean estaValidado=false;
		
		if(detallenotacreditopuntoventa.getIsNew() || detallenotacreditopuntoventa.getIsChanged()) { 
			this.invalidValues = detallenotacreditopuntoventaValidator.getInvalidValues(detallenotacreditopuntoventa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detallenotacreditopuntoventa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleNotaCreditoPuntoVenta(List<DetalleNotaCreditoPuntoVenta> DetalleNotaCreditoPuntoVentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventaLocal:detallenotacreditopuntoventas) {				
			estaValidadoObjeto=this.validarGuardarDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleNotaCreditoPuntoVenta(List<DetalleNotaCreditoPuntoVenta> DetalleNotaCreditoPuntoVentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleNotaCreditoPuntoVenta(DetalleNotaCreditoPuntoVenta DetalleNotaCreditoPuntoVenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detallenotacreditopuntoventa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleNotaCreditoPuntoVentaConstantesFunciones.getDetalleNotaCreditoPuntoVentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detallenotacreditopuntoventa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleNotaCreditoPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleNotaCreditoPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleNotaCreditoPuntoVentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-saveDetalleNotaCreditoPuntoVentaWithConnection");connexion.begin();			
			
			DetalleNotaCreditoPuntoVentaLogicAdditional.checkDetalleNotaCreditoPuntoVentaToSave(this.detallenotacreditopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleNotaCreditoPuntoVentaLogicAdditional.updateDetalleNotaCreditoPuntoVentaToSave(this.detallenotacreditopuntoventa,this.arrDatoGeneral);
			
			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallenotacreditopuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleNotaCreditoPuntoVenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventa)) {
				DetalleNotaCreditoPuntoVentaDataAccess.save(this.detallenotacreditopuntoventa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detallenotacreditopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleNotaCreditoPuntoVentaLogicAdditional.checkDetalleNotaCreditoPuntoVentaToSaveAfter(this.detallenotacreditopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleNotaCreditoPuntoVenta();
			
			connexion.commit();			
			
			if(this.detallenotacreditopuntoventa.getIsDeleted()) {
				this.detallenotacreditopuntoventa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleNotaCreditoPuntoVenta()throws Exception {	
		try {	
			
			DetalleNotaCreditoPuntoVentaLogicAdditional.checkDetalleNotaCreditoPuntoVentaToSave(this.detallenotacreditopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleNotaCreditoPuntoVentaLogicAdditional.updateDetalleNotaCreditoPuntoVentaToSave(this.detallenotacreditopuntoventa,this.arrDatoGeneral);
			
			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallenotacreditopuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventa)) {			
				DetalleNotaCreditoPuntoVentaDataAccess.save(this.detallenotacreditopuntoventa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detallenotacreditopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleNotaCreditoPuntoVentaLogicAdditional.checkDetalleNotaCreditoPuntoVentaToSaveAfter(this.detallenotacreditopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detallenotacreditopuntoventa.getIsDeleted()) {
				this.detallenotacreditopuntoventa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleNotaCreditoPuntoVentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-saveDetalleNotaCreditoPuntoVentasWithConnection");connexion.begin();			
			
			DetalleNotaCreditoPuntoVentaLogicAdditional.checkDetalleNotaCreditoPuntoVentaToSaves(detallenotacreditopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleNotaCreditoPuntoVentas();
			
			Boolean validadoTodosDetalleNotaCreditoPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventaLocal:detallenotacreditopuntoventas) {		
				if(detallenotacreditopuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleNotaCreditoPuntoVentaLogicAdditional.updateDetalleNotaCreditoPuntoVentaToSave(detallenotacreditopuntoventaLocal,this.arrDatoGeneral);
	        	
				DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallenotacreditopuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventaLocal)) {
					DetalleNotaCreditoPuntoVentaDataAccess.save(detallenotacreditopuntoventaLocal, connexion);				
				} else {
					validadoTodosDetalleNotaCreditoPuntoVenta=false;
				}
			}
			
			if(!validadoTodosDetalleNotaCreditoPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleNotaCreditoPuntoVentaLogicAdditional.checkDetalleNotaCreditoPuntoVentaToSavesAfter(detallenotacreditopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleNotaCreditoPuntoVentas();
			
			connexion.commit();		
			
			this.quitarDetalleNotaCreditoPuntoVentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleNotaCreditoPuntoVentas()throws Exception {				
		 try {	
			DetalleNotaCreditoPuntoVentaLogicAdditional.checkDetalleNotaCreditoPuntoVentaToSaves(detallenotacreditopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleNotaCreditoPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventaLocal:detallenotacreditopuntoventas) {				
				if(detallenotacreditopuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleNotaCreditoPuntoVentaLogicAdditional.updateDetalleNotaCreditoPuntoVentaToSave(detallenotacreditopuntoventaLocal,this.arrDatoGeneral);
	        	
				DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallenotacreditopuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventaLocal)) {				
					DetalleNotaCreditoPuntoVentaDataAccess.save(detallenotacreditopuntoventaLocal, connexion);				
				} else {
					validadoTodosDetalleNotaCreditoPuntoVenta=false;
				}
			}
			
			if(!validadoTodosDetalleNotaCreditoPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleNotaCreditoPuntoVentaLogicAdditional.checkDetalleNotaCreditoPuntoVentaToSavesAfter(detallenotacreditopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleNotaCreditoPuntoVentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleNotaCreditoPuntoVentaParameterReturnGeneral procesarAccionDetalleNotaCreditoPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas,DetalleNotaCreditoPuntoVentaParameterReturnGeneral detallenotacreditopuntoventaParameterGeneral)throws Exception {
		 try {	
			DetalleNotaCreditoPuntoVentaParameterReturnGeneral detallenotacreditopuntoventaReturnGeneral=new DetalleNotaCreditoPuntoVentaParameterReturnGeneral();
	
			DetalleNotaCreditoPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallenotacreditopuntoventas,detallenotacreditopuntoventaParameterGeneral,detallenotacreditopuntoventaReturnGeneral);
			
			return detallenotacreditopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleNotaCreditoPuntoVentaParameterReturnGeneral procesarAccionDetalleNotaCreditoPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas,DetalleNotaCreditoPuntoVentaParameterReturnGeneral detallenotacreditopuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-procesarAccionDetalleNotaCreditoPuntoVentasWithConnection");connexion.begin();			
			
			DetalleNotaCreditoPuntoVentaParameterReturnGeneral detallenotacreditopuntoventaReturnGeneral=new DetalleNotaCreditoPuntoVentaParameterReturnGeneral();
	
			DetalleNotaCreditoPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallenotacreditopuntoventas,detallenotacreditopuntoventaParameterGeneral,detallenotacreditopuntoventaReturnGeneral);
			
			this.connexion.commit();
			
			return detallenotacreditopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleNotaCreditoPuntoVentaParameterReturnGeneral procesarEventosDetalleNotaCreditoPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas,DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa,DetalleNotaCreditoPuntoVentaParameterReturnGeneral detallenotacreditopuntoventaParameterGeneral,Boolean isEsNuevoDetalleNotaCreditoPuntoVenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleNotaCreditoPuntoVentaParameterReturnGeneral detallenotacreditopuntoventaReturnGeneral=new DetalleNotaCreditoPuntoVentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallenotacreditopuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleNotaCreditoPuntoVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallenotacreditopuntoventas,detallenotacreditopuntoventa,detallenotacreditopuntoventaParameterGeneral,detallenotacreditopuntoventaReturnGeneral,isEsNuevoDetalleNotaCreditoPuntoVenta,clases);
			
			return detallenotacreditopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleNotaCreditoPuntoVentaParameterReturnGeneral procesarEventosDetalleNotaCreditoPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas,DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa,DetalleNotaCreditoPuntoVentaParameterReturnGeneral detallenotacreditopuntoventaParameterGeneral,Boolean isEsNuevoDetalleNotaCreditoPuntoVenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-procesarEventosDetalleNotaCreditoPuntoVentasWithConnection");connexion.begin();			
			
			DetalleNotaCreditoPuntoVentaParameterReturnGeneral detallenotacreditopuntoventaReturnGeneral=new DetalleNotaCreditoPuntoVentaParameterReturnGeneral();
	
			detallenotacreditopuntoventaReturnGeneral.setDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallenotacreditopuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleNotaCreditoPuntoVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallenotacreditopuntoventas,detallenotacreditopuntoventa,detallenotacreditopuntoventaParameterGeneral,detallenotacreditopuntoventaReturnGeneral,isEsNuevoDetalleNotaCreditoPuntoVenta,clases);
			
			this.connexion.commit();
			
			return detallenotacreditopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleNotaCreditoPuntoVentaParameterReturnGeneral procesarImportacionDetalleNotaCreditoPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleNotaCreditoPuntoVentaParameterReturnGeneral detallenotacreditopuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-procesarImportacionDetalleNotaCreditoPuntoVentasWithConnection");connexion.begin();			
			
			DetalleNotaCreditoPuntoVentaParameterReturnGeneral detallenotacreditopuntoventaReturnGeneral=new DetalleNotaCreditoPuntoVentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detallenotacreditopuntoventas=new ArrayList<DetalleNotaCreditoPuntoVenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detallenotacreditopuntoventa=new DetalleNotaCreditoPuntoVenta();
				
				
				if(conColumnasBase) {this.detallenotacreditopuntoventa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detallenotacreditopuntoventa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detallenotacreditopuntoventa.setserie(arrColumnas[iColumn++]);
				this.detallenotacreditopuntoventa.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.detallenotacreditopuntoventa.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallenotacreditopuntoventa.setdescuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallenotacreditopuntoventa.setdescuento_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallenotacreditopuntoventa.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallenotacreditopuntoventa.setiva_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallenotacreditopuntoventa.setice(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallenotacreditopuntoventa.setice_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallenotacreditopuntoventa.setsub_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallenotacreditopuntoventa.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallenotacreditopuntoventa.setdescripcion(arrColumnas[iColumn++]);
				
				this.detallenotacreditopuntoventas.add(this.detallenotacreditopuntoventa);
			}
			
			this.saveDetalleNotaCreditoPuntoVentas();
			
			this.connexion.commit();
			
			detallenotacreditopuntoventaReturnGeneral.setConRetornoEstaProcesado(true);
			detallenotacreditopuntoventaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detallenotacreditopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleNotaCreditoPuntoVentasEliminados() throws Exception {				
		
		List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventasAux= new ArrayList<DetalleNotaCreditoPuntoVenta>();
		
		for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa:detallenotacreditopuntoventas) {
			if(!detallenotacreditopuntoventa.getIsDeleted()) {
				detallenotacreditopuntoventasAux.add(detallenotacreditopuntoventa);
			}
		}
		
		detallenotacreditopuntoventas=detallenotacreditopuntoventasAux;
	}
	
	public void quitarDetalleNotaCreditoPuntoVentasNulos() throws Exception {				
		
		List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventasAux= new ArrayList<DetalleNotaCreditoPuntoVenta>();
		
		for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa : this.detallenotacreditopuntoventas) {
			if(detallenotacreditopuntoventa==null) {
				detallenotacreditopuntoventasAux.add(detallenotacreditopuntoventa);
			}
		}
		
		//this.detallenotacreditopuntoventas=detallenotacreditopuntoventasAux;
		
		this.detallenotacreditopuntoventas.removeAll(detallenotacreditopuntoventasAux);
	}
	
	public void getSetVersionRowDetalleNotaCreditoPuntoVentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detallenotacreditopuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detallenotacreditopuntoventa.getIsDeleted() || (detallenotacreditopuntoventa.getIsChanged()&&!detallenotacreditopuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detallenotacreditopuntoventaDataAccess.getSetVersionRowDetalleNotaCreditoPuntoVenta(connexion,detallenotacreditopuntoventa.getId());
				
				if(!detallenotacreditopuntoventa.getVersionRow().equals(timestamp)) {	
					detallenotacreditopuntoventa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detallenotacreditopuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleNotaCreditoPuntoVenta()throws Exception {	
		
		if(detallenotacreditopuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detallenotacreditopuntoventa.getIsDeleted() || (detallenotacreditopuntoventa.getIsChanged()&&!detallenotacreditopuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detallenotacreditopuntoventaDataAccess.getSetVersionRowDetalleNotaCreditoPuntoVenta(connexion,detallenotacreditopuntoventa.getId());
			
			try {							
				if(!detallenotacreditopuntoventa.getVersionRow().equals(timestamp)) {	
					detallenotacreditopuntoventa.setVersionRow(timestamp);
				}
				
				detallenotacreditopuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleNotaCreditoPuntoVentasWithConnection()throws Exception {	
		if(detallenotacreditopuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventaAux:detallenotacreditopuntoventas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detallenotacreditopuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallenotacreditopuntoventaAux.getIsDeleted() || (detallenotacreditopuntoventaAux.getIsChanged()&&!detallenotacreditopuntoventaAux.getIsNew())) {
						
						timestamp=detallenotacreditopuntoventaDataAccess.getSetVersionRowDetalleNotaCreditoPuntoVenta(connexion,detallenotacreditopuntoventaAux.getId());
						
						if(!detallenotacreditopuntoventa.getVersionRow().equals(timestamp)) {	
							detallenotacreditopuntoventaAux.setVersionRow(timestamp);
						}
								
						detallenotacreditopuntoventaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleNotaCreditoPuntoVentas()throws Exception {	
		if(detallenotacreditopuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventaAux:detallenotacreditopuntoventas) {
					if(detallenotacreditopuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallenotacreditopuntoventaAux.getIsDeleted() || (detallenotacreditopuntoventaAux.getIsChanged()&&!detallenotacreditopuntoventaAux.getIsNew())) {
						
						timestamp=detallenotacreditopuntoventaDataAccess.getSetVersionRowDetalleNotaCreditoPuntoVenta(connexion,detallenotacreditopuntoventaAux.getId());
						
						if(!detallenotacreditopuntoventaAux.getVersionRow().equals(timestamp)) {	
							detallenotacreditopuntoventaAux.setVersionRow(timestamp);
						}
						
													
						detallenotacreditopuntoventaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleNotaCreditoPuntoVentaParameterReturnGeneral cargarCombosLoteForeignKeyDetalleNotaCreditoPuntoVentaWithConnection(String finalQueryGlobalNotaCreditoPuntoVenta,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad) throws Exception {
		DetalleNotaCreditoPuntoVentaParameterReturnGeneral  detallenotacreditopuntoventaReturnGeneral =new DetalleNotaCreditoPuntoVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleNotaCreditoPuntoVentaWithConnection");connexion.begin();
			
			detallenotacreditopuntoventaReturnGeneral =new DetalleNotaCreditoPuntoVentaParameterReturnGeneral();
			
			

			List<NotaCreditoPuntoVenta> notacreditopuntoventasForeignKey=new ArrayList<NotaCreditoPuntoVenta>();
			NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic=new NotaCreditoPuntoVentaLogic();
			notacreditopuntoventaLogic.setConnexion(this.connexion);
			notacreditopuntoventaLogic.getNotaCreditoPuntoVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNotaCreditoPuntoVenta.equals("NONE")) {
				notacreditopuntoventaLogic.getTodosNotaCreditoPuntoVentas(finalQueryGlobalNotaCreditoPuntoVenta,new Pagination());
				notacreditopuntoventasForeignKey=notacreditopuntoventaLogic.getNotaCreditoPuntoVentas();
			}

			detallenotacreditopuntoventaReturnGeneral.setnotacreditopuntoventasForeignKey(notacreditopuntoventasForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallenotacreditopuntoventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallenotacreditopuntoventaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallenotacreditopuntoventaReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallenotacreditopuntoventaReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallenotacreditopuntoventaReturnGeneral.setunidadsForeignKey(unidadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detallenotacreditopuntoventaReturnGeneral;
	}
	
	public DetalleNotaCreditoPuntoVentaParameterReturnGeneral cargarCombosLoteForeignKeyDetalleNotaCreditoPuntoVenta(String finalQueryGlobalNotaCreditoPuntoVenta,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad) throws Exception {
		DetalleNotaCreditoPuntoVentaParameterReturnGeneral  detallenotacreditopuntoventaReturnGeneral =new DetalleNotaCreditoPuntoVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detallenotacreditopuntoventaReturnGeneral =new DetalleNotaCreditoPuntoVentaParameterReturnGeneral();
			
			

			List<NotaCreditoPuntoVenta> notacreditopuntoventasForeignKey=new ArrayList<NotaCreditoPuntoVenta>();
			NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic=new NotaCreditoPuntoVentaLogic();
			notacreditopuntoventaLogic.setConnexion(this.connexion);
			notacreditopuntoventaLogic.getNotaCreditoPuntoVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNotaCreditoPuntoVenta.equals("NONE")) {
				notacreditopuntoventaLogic.getTodosNotaCreditoPuntoVentas(finalQueryGlobalNotaCreditoPuntoVenta,new Pagination());
				notacreditopuntoventasForeignKey=notacreditopuntoventaLogic.getNotaCreditoPuntoVentas();
			}

			detallenotacreditopuntoventaReturnGeneral.setnotacreditopuntoventasForeignKey(notacreditopuntoventasForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallenotacreditopuntoventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallenotacreditopuntoventaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallenotacreditopuntoventaReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallenotacreditopuntoventaReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallenotacreditopuntoventaReturnGeneral.setunidadsForeignKey(unidadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detallenotacreditopuntoventaReturnGeneral;
	}
	
	
	public void deepLoad(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleNotaCreditoPuntoVentaLogicAdditional.updateDetalleNotaCreditoPuntoVentaToGet(detallenotacreditopuntoventa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallenotacreditopuntoventa.setNotaCreditoPuntoVenta(detallenotacreditopuntoventaDataAccess.getNotaCreditoPuntoVenta(connexion,detallenotacreditopuntoventa));
		detallenotacreditopuntoventa.setEmpresa(detallenotacreditopuntoventaDataAccess.getEmpresa(connexion,detallenotacreditopuntoventa));
		detallenotacreditopuntoventa.setSucursal(detallenotacreditopuntoventaDataAccess.getSucursal(connexion,detallenotacreditopuntoventa));
		detallenotacreditopuntoventa.setBodega(detallenotacreditopuntoventaDataAccess.getBodega(connexion,detallenotacreditopuntoventa));
		detallenotacreditopuntoventa.setProducto(detallenotacreditopuntoventaDataAccess.getProducto(connexion,detallenotacreditopuntoventa));
		detallenotacreditopuntoventa.setUnidad(detallenotacreditopuntoventaDataAccess.getUnidad(connexion,detallenotacreditopuntoventa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoPuntoVenta.class)) {
				detallenotacreditopuntoventa.setNotaCreditoPuntoVenta(detallenotacreditopuntoventaDataAccess.getNotaCreditoPuntoVenta(connexion,detallenotacreditopuntoventa));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallenotacreditopuntoventa.setEmpresa(detallenotacreditopuntoventaDataAccess.getEmpresa(connexion,detallenotacreditopuntoventa));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallenotacreditopuntoventa.setSucursal(detallenotacreditopuntoventaDataAccess.getSucursal(connexion,detallenotacreditopuntoventa));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallenotacreditopuntoventa.setBodega(detallenotacreditopuntoventaDataAccess.getBodega(connexion,detallenotacreditopuntoventa));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallenotacreditopuntoventa.setProducto(detallenotacreditopuntoventaDataAccess.getProducto(connexion,detallenotacreditopuntoventa));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallenotacreditopuntoventa.setUnidad(detallenotacreditopuntoventaDataAccess.getUnidad(connexion,detallenotacreditopuntoventa));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoPuntoVenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallenotacreditopuntoventa.setNotaCreditoPuntoVenta(detallenotacreditopuntoventaDataAccess.getNotaCreditoPuntoVenta(connexion,detallenotacreditopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallenotacreditopuntoventa.setEmpresa(detallenotacreditopuntoventaDataAccess.getEmpresa(connexion,detallenotacreditopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallenotacreditopuntoventa.setSucursal(detallenotacreditopuntoventaDataAccess.getSucursal(connexion,detallenotacreditopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallenotacreditopuntoventa.setBodega(detallenotacreditopuntoventaDataAccess.getBodega(connexion,detallenotacreditopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallenotacreditopuntoventa.setProducto(detallenotacreditopuntoventaDataAccess.getProducto(connexion,detallenotacreditopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallenotacreditopuntoventa.setUnidad(detallenotacreditopuntoventaDataAccess.getUnidad(connexion,detallenotacreditopuntoventa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallenotacreditopuntoventa.setNotaCreditoPuntoVenta(detallenotacreditopuntoventaDataAccess.getNotaCreditoPuntoVenta(connexion,detallenotacreditopuntoventa));
		NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
		notacreditopuntoventaLogic.deepLoad(detallenotacreditopuntoventa.getNotaCreditoPuntoVenta(),isDeep,deepLoadType,clases);
				
		detallenotacreditopuntoventa.setEmpresa(detallenotacreditopuntoventaDataAccess.getEmpresa(connexion,detallenotacreditopuntoventa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallenotacreditopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		detallenotacreditopuntoventa.setSucursal(detallenotacreditopuntoventaDataAccess.getSucursal(connexion,detallenotacreditopuntoventa));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallenotacreditopuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				
		detallenotacreditopuntoventa.setBodega(detallenotacreditopuntoventaDataAccess.getBodega(connexion,detallenotacreditopuntoventa));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallenotacreditopuntoventa.getBodega(),isDeep,deepLoadType,clases);
				
		detallenotacreditopuntoventa.setProducto(detallenotacreditopuntoventaDataAccess.getProducto(connexion,detallenotacreditopuntoventa));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallenotacreditopuntoventa.getProducto(),isDeep,deepLoadType,clases);
				
		detallenotacreditopuntoventa.setUnidad(detallenotacreditopuntoventaDataAccess.getUnidad(connexion,detallenotacreditopuntoventa));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallenotacreditopuntoventa.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoPuntoVenta.class)) {
				detallenotacreditopuntoventa.setNotaCreditoPuntoVenta(detallenotacreditopuntoventaDataAccess.getNotaCreditoPuntoVenta(connexion,detallenotacreditopuntoventa));
				NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
				notacreditopuntoventaLogic.deepLoad(detallenotacreditopuntoventa.getNotaCreditoPuntoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallenotacreditopuntoventa.setEmpresa(detallenotacreditopuntoventaDataAccess.getEmpresa(connexion,detallenotacreditopuntoventa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detallenotacreditopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallenotacreditopuntoventa.setSucursal(detallenotacreditopuntoventaDataAccess.getSucursal(connexion,detallenotacreditopuntoventa));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detallenotacreditopuntoventa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallenotacreditopuntoventa.setBodega(detallenotacreditopuntoventaDataAccess.getBodega(connexion,detallenotacreditopuntoventa));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detallenotacreditopuntoventa.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallenotacreditopuntoventa.setProducto(detallenotacreditopuntoventaDataAccess.getProducto(connexion,detallenotacreditopuntoventa));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detallenotacreditopuntoventa.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallenotacreditopuntoventa.setUnidad(detallenotacreditopuntoventaDataAccess.getUnidad(connexion,detallenotacreditopuntoventa));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detallenotacreditopuntoventa.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoPuntoVenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallenotacreditopuntoventa.setNotaCreditoPuntoVenta(detallenotacreditopuntoventaDataAccess.getNotaCreditoPuntoVenta(connexion,detallenotacreditopuntoventa));
			NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
			notacreditopuntoventaLogic.deepLoad(detallenotacreditopuntoventa.getNotaCreditoPuntoVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallenotacreditopuntoventa.setEmpresa(detallenotacreditopuntoventaDataAccess.getEmpresa(connexion,detallenotacreditopuntoventa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detallenotacreditopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallenotacreditopuntoventa.setSucursal(detallenotacreditopuntoventaDataAccess.getSucursal(connexion,detallenotacreditopuntoventa));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detallenotacreditopuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallenotacreditopuntoventa.setBodega(detallenotacreditopuntoventaDataAccess.getBodega(connexion,detallenotacreditopuntoventa));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detallenotacreditopuntoventa.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallenotacreditopuntoventa.setProducto(detallenotacreditopuntoventaDataAccess.getProducto(connexion,detallenotacreditopuntoventa));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detallenotacreditopuntoventa.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallenotacreditopuntoventa.setUnidad(detallenotacreditopuntoventaDataAccess.getUnidad(connexion,detallenotacreditopuntoventa));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detallenotacreditopuntoventa.getUnidad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleNotaCreditoPuntoVentaLogicAdditional.updateDetalleNotaCreditoPuntoVentaToSave(detallenotacreditopuntoventa,this.arrDatoGeneral);
			
DetalleNotaCreditoPuntoVentaDataAccess.save(detallenotacreditopuntoventa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		NotaCreditoPuntoVentaDataAccess.save(detallenotacreditopuntoventa.getNotaCreditoPuntoVenta(),connexion);

		EmpresaDataAccess.save(detallenotacreditopuntoventa.getEmpresa(),connexion);

		SucursalDataAccess.save(detallenotacreditopuntoventa.getSucursal(),connexion);

		BodegaDataAccess.save(detallenotacreditopuntoventa.getBodega(),connexion);

		ProductoDataAccess.save(detallenotacreditopuntoventa.getProducto(),connexion);

		UnidadDataAccess.save(detallenotacreditopuntoventa.getUnidad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoPuntoVenta.class)) {
				NotaCreditoPuntoVentaDataAccess.save(detallenotacreditopuntoventa.getNotaCreditoPuntoVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallenotacreditopuntoventa.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallenotacreditopuntoventa.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallenotacreditopuntoventa.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallenotacreditopuntoventa.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallenotacreditopuntoventa.getUnidad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		NotaCreditoPuntoVentaDataAccess.save(detallenotacreditopuntoventa.getNotaCreditoPuntoVenta(),connexion);
		NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
		notacreditopuntoventaLogic.deepLoad(detallenotacreditopuntoventa.getNotaCreditoPuntoVenta(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(detallenotacreditopuntoventa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallenotacreditopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detallenotacreditopuntoventa.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallenotacreditopuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detallenotacreditopuntoventa.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallenotacreditopuntoventa.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detallenotacreditopuntoventa.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallenotacreditopuntoventa.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detallenotacreditopuntoventa.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallenotacreditopuntoventa.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoPuntoVenta.class)) {
				NotaCreditoPuntoVentaDataAccess.save(detallenotacreditopuntoventa.getNotaCreditoPuntoVenta(),connexion);
				NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
				notacreditopuntoventaLogic.deepSave(detallenotacreditopuntoventa.getNotaCreditoPuntoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallenotacreditopuntoventa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detallenotacreditopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallenotacreditopuntoventa.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detallenotacreditopuntoventa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallenotacreditopuntoventa.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detallenotacreditopuntoventa.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallenotacreditopuntoventa.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detallenotacreditopuntoventa.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallenotacreditopuntoventa.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detallenotacreditopuntoventa.getUnidad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detallenotacreditopuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventa);
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
			this.deepLoad(this.detallenotacreditopuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detallenotacreditopuntoventas!=null) {
				for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa:detallenotacreditopuntoventas) {
					this.deepLoad(detallenotacreditopuntoventa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventas);
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
			if(detallenotacreditopuntoventas!=null) {
				for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa:detallenotacreditopuntoventas) {
					this.deepLoad(detallenotacreditopuntoventa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventas);
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
			this.getNewConnexionToDeep(DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detallenotacreditopuntoventa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detallenotacreditopuntoventas!=null) {
				for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa:detallenotacreditopuntoventas) {
					this.deepSave(detallenotacreditopuntoventa,isDeep,deepLoadType,clases);
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
			if(detallenotacreditopuntoventas!=null) {
				for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa:detallenotacreditopuntoventas) {
					this.deepSave(detallenotacreditopuntoventa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleNotaCreditoPuntoVentasFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleNotaCreditoPuntoVentaConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleNotaCreditoPuntoVentasFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleNotaCreditoPuntoVentaConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleNotaCreditoPuntoVentasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleNotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleNotaCreditoPuntoVentasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleNotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleNotaCreditoPuntoVentasFK_IdNotaCreditoPuntoVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura_punto_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNotaCreditoPuntoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNotaCreditoPuntoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura_punto_venta,DetalleNotaCreditoPuntoVentaConstantesFunciones.IDNOTACREDITOPUNTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNotaCreditoPuntoVenta);

			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNotaCreditoPuntoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleNotaCreditoPuntoVentasFK_IdNotaCreditoPuntoVenta(String sFinalQuery,Pagination pagination,Long id_factura_punto_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNotaCreditoPuntoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNotaCreditoPuntoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura_punto_venta,DetalleNotaCreditoPuntoVentaConstantesFunciones.IDNOTACREDITOPUNTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNotaCreditoPuntoVenta);

			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNotaCreditoPuntoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleNotaCreditoPuntoVentasFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleNotaCreditoPuntoVentaConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleNotaCreditoPuntoVentasFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleNotaCreditoPuntoVentaConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleNotaCreditoPuntoVentasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleNotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleNotaCreditoPuntoVentasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleNotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleNotaCreditoPuntoVentasFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleNotaCreditoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleNotaCreditoPuntoVentaConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleNotaCreditoPuntoVentasFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleNotaCreditoPuntoVentaConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleNotaCreditoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleNotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(this.detallenotacreditopuntoventas);
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
			if(DetalleNotaCreditoPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleNotaCreditoPuntoVentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleNotaCreditoPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				if(detallenotacreditopuntoventa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleNotaCreditoPuntoVentaDataAccess.TABLENAME, detallenotacreditopuntoventa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleNotaCreditoPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleNotaCreditoPuntoVentaLogic.registrarAuditoriaDetallesDetalleNotaCreditoPuntoVenta(connexion,detallenotacreditopuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detallenotacreditopuntoventa.getIsDeleted()) {
					/*if(!detallenotacreditopuntoventa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleNotaCreditoPuntoVentaDataAccess.TABLENAME, detallenotacreditopuntoventa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleNotaCreditoPuntoVentaLogic.registrarAuditoriaDetallesDetalleNotaCreditoPuntoVenta(connexion,detallenotacreditopuntoventa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleNotaCreditoPuntoVentaDataAccess.TABLENAME, detallenotacreditopuntoventa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detallenotacreditopuntoventa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleNotaCreditoPuntoVentaDataAccess.TABLENAME, detallenotacreditopuntoventa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleNotaCreditoPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleNotaCreditoPuntoVentaLogic.registrarAuditoriaDetallesDetalleNotaCreditoPuntoVenta(connexion,detallenotacreditopuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleNotaCreditoPuntoVenta(Connexion connexion,DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detallenotacreditopuntoventa.getIsNew()||!detallenotacreditopuntoventa.getid_factura_punto_venta().equals(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getid_factura_punto_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getid_factura_punto_venta()!=null)
				{
					strValorActual=detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getid_factura_punto_venta().toString();
				}
				if(detallenotacreditopuntoventa.getid_factura_punto_venta()!=null)
				{
					strValorNuevo=detallenotacreditopuntoventa.getid_factura_punto_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleNotaCreditoPuntoVentaConstantesFunciones.IDNOTACREDITOPUNTOVENTA,strValorActual,strValorNuevo);
			}	
			
			if(detallenotacreditopuntoventa.getIsNew()||!detallenotacreditopuntoventa.getid_empresa().equals(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getid_empresa()!=null)
				{
					strValorActual=detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getid_empresa().toString();
				}
				if(detallenotacreditopuntoventa.getid_empresa()!=null)
				{
					strValorNuevo=detallenotacreditopuntoventa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleNotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detallenotacreditopuntoventa.getIsNew()||!detallenotacreditopuntoventa.getid_sucursal().equals(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getid_sucursal()!=null)
				{
					strValorActual=detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getid_sucursal().toString();
				}
				if(detallenotacreditopuntoventa.getid_sucursal()!=null)
				{
					strValorNuevo=detallenotacreditopuntoventa.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleNotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detallenotacreditopuntoventa.getIsNew()||!detallenotacreditopuntoventa.getid_bodega().equals(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getid_bodega()!=null)
				{
					strValorActual=detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getid_bodega().toString();
				}
				if(detallenotacreditopuntoventa.getid_bodega()!=null)
				{
					strValorNuevo=detallenotacreditopuntoventa.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleNotaCreditoPuntoVentaConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detallenotacreditopuntoventa.getIsNew()||!detallenotacreditopuntoventa.getid_producto().equals(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getid_producto()!=null)
				{
					strValorActual=detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getid_producto().toString();
				}
				if(detallenotacreditopuntoventa.getid_producto()!=null)
				{
					strValorNuevo=detallenotacreditopuntoventa.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleNotaCreditoPuntoVentaConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detallenotacreditopuntoventa.getIsNew()||!detallenotacreditopuntoventa.getid_unidad().equals(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getid_unidad()!=null)
				{
					strValorActual=detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getid_unidad().toString();
				}
				if(detallenotacreditopuntoventa.getid_unidad()!=null)
				{
					strValorNuevo=detallenotacreditopuntoventa.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleNotaCreditoPuntoVentaConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallenotacreditopuntoventa.getIsNew()||!detallenotacreditopuntoventa.getserie().equals(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getserie()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getserie()!=null)
				{
					strValorActual=detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getserie();
				}
				if(detallenotacreditopuntoventa.getserie()!=null)
				{
					strValorNuevo=detallenotacreditopuntoventa.getserie() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleNotaCreditoPuntoVentaConstantesFunciones.SERIE,strValorActual,strValorNuevo);
			}	
			
			if(detallenotacreditopuntoventa.getIsNew()||!detallenotacreditopuntoventa.getcantidad().equals(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getcantidad()!=null)
				{
					strValorActual=detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getcantidad().toString();
				}
				if(detallenotacreditopuntoventa.getcantidad()!=null)
				{
					strValorNuevo=detallenotacreditopuntoventa.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleNotaCreditoPuntoVentaConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallenotacreditopuntoventa.getIsNew()||!detallenotacreditopuntoventa.getprecio().equals(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getprecio()!=null)
				{
					strValorActual=detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getprecio().toString();
				}
				if(detallenotacreditopuntoventa.getprecio()!=null)
				{
					strValorNuevo=detallenotacreditopuntoventa.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleNotaCreditoPuntoVentaConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
			
			if(detallenotacreditopuntoventa.getIsNew()||!detallenotacreditopuntoventa.getdescuento().equals(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getdescuento()!=null)
				{
					strValorActual=detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getdescuento().toString();
				}
				if(detallenotacreditopuntoventa.getdescuento()!=null)
				{
					strValorNuevo=detallenotacreditopuntoventa.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(detallenotacreditopuntoventa.getIsNew()||!detallenotacreditopuntoventa.getdescuento_valor().equals(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getdescuento_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getdescuento_valor()!=null)
				{
					strValorActual=detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getdescuento_valor().toString();
				}
				if(detallenotacreditopuntoventa.getdescuento_valor()!=null)
				{
					strValorNuevo=detallenotacreditopuntoventa.getdescuento_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTOVALOR,strValorActual,strValorNuevo);
			}	
			
			if(detallenotacreditopuntoventa.getIsNew()||!detallenotacreditopuntoventa.getiva().equals(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getiva()!=null)
				{
					strValorActual=detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getiva().toString();
				}
				if(detallenotacreditopuntoventa.getiva()!=null)
				{
					strValorNuevo=detallenotacreditopuntoventa.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleNotaCreditoPuntoVentaConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(detallenotacreditopuntoventa.getIsNew()||!detallenotacreditopuntoventa.getiva_valor().equals(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getiva_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getiva_valor()!=null)
				{
					strValorActual=detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getiva_valor().toString();
				}
				if(detallenotacreditopuntoventa.getiva_valor()!=null)
				{
					strValorNuevo=detallenotacreditopuntoventa.getiva_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleNotaCreditoPuntoVentaConstantesFunciones.IVAVALOR,strValorActual,strValorNuevo);
			}	
			
			if(detallenotacreditopuntoventa.getIsNew()||!detallenotacreditopuntoventa.getice().equals(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getice()!=null)
				{
					strValorActual=detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getice().toString();
				}
				if(detallenotacreditopuntoventa.getice()!=null)
				{
					strValorNuevo=detallenotacreditopuntoventa.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleNotaCreditoPuntoVentaConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(detallenotacreditopuntoventa.getIsNew()||!detallenotacreditopuntoventa.getice_valor().equals(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getice_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getice_valor()!=null)
				{
					strValorActual=detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getice_valor().toString();
				}
				if(detallenotacreditopuntoventa.getice_valor()!=null)
				{
					strValorNuevo=detallenotacreditopuntoventa.getice_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleNotaCreditoPuntoVentaConstantesFunciones.ICEVALOR,strValorActual,strValorNuevo);
			}	
			
			if(detallenotacreditopuntoventa.getIsNew()||!detallenotacreditopuntoventa.getsub_total().equals(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getsub_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getsub_total()!=null)
				{
					strValorActual=detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getsub_total().toString();
				}
				if(detallenotacreditopuntoventa.getsub_total()!=null)
				{
					strValorNuevo=detallenotacreditopuntoventa.getsub_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleNotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detallenotacreditopuntoventa.getIsNew()||!detallenotacreditopuntoventa.gettotal().equals(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().gettotal()!=null)
				{
					strValorActual=detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().gettotal().toString();
				}
				if(detallenotacreditopuntoventa.gettotal()!=null)
				{
					strValorNuevo=detallenotacreditopuntoventa.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleNotaCreditoPuntoVentaConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detallenotacreditopuntoventa.getIsNew()||!detallenotacreditopuntoventa.getdescripcion().equals(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getdescripcion()!=null)
				{
					strValorActual=detallenotacreditopuntoventa.getDetalleNotaCreditoPuntoVentaOriginal().getdescripcion();
				}
				if(detallenotacreditopuntoventa.getdescripcion()!=null)
				{
					strValorNuevo=detallenotacreditopuntoventa.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleNotaCreditoPuntoVentaRelacionesWithConnection(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa) throws Exception {

		if(!detallenotacreditopuntoventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleNotaCreditoPuntoVentaRelacionesBase(detallenotacreditopuntoventa,true);
		}
	}

	public void saveDetalleNotaCreditoPuntoVentaRelaciones(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa)throws Exception {

		if(!detallenotacreditopuntoventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleNotaCreditoPuntoVentaRelacionesBase(detallenotacreditopuntoventa,false);
		}
	}

	public void saveDetalleNotaCreditoPuntoVentaRelacionesBase(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleNotaCreditoPuntoVenta-saveRelacionesWithConnection");}
	

			this.setDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventa);

			if(DetalleNotaCreditoPuntoVentaLogicAdditional.validarSaveRelaciones(detallenotacreditopuntoventa,this)) {

				DetalleNotaCreditoPuntoVentaLogicAdditional.updateRelacionesToSave(detallenotacreditopuntoventa,this);

				if((detallenotacreditopuntoventa.getIsNew()||detallenotacreditopuntoventa.getIsChanged())&&!detallenotacreditopuntoventa.getIsDeleted()) {
					this.saveDetalleNotaCreditoPuntoVenta();
					this.saveDetalleNotaCreditoPuntoVentaRelacionesDetalles();

				} else if(detallenotacreditopuntoventa.getIsDeleted()) {
					this.saveDetalleNotaCreditoPuntoVentaRelacionesDetalles();
					this.saveDetalleNotaCreditoPuntoVenta();
				}

				DetalleNotaCreditoPuntoVentaLogicAdditional.updateRelacionesToSaveAfter(detallenotacreditopuntoventa,this);

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
	
	
	private void saveDetalleNotaCreditoPuntoVentaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleNotaCreditoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleNotaCreditoPuntoVentaConstantesFunciones.getClassesForeignKeysOfDetalleNotaCreditoPuntoVenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleNotaCreditoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleNotaCreditoPuntoVentaConstantesFunciones.getClassesRelationshipsOfDetalleNotaCreditoPuntoVenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

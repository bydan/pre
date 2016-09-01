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
import com.bydan.erp.facturacion.util.DetalleDescuenPoliVentaConstantesFunciones;
import com.bydan.erp.facturacion.util.DetalleDescuenPoliVentaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetalleDescuenPoliVentaParameterGeneral;
import com.bydan.erp.facturacion.business.entity.DetalleDescuenPoliVenta;
import com.bydan.erp.facturacion.business.logic.DetalleDescuenPoliVentaLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetalleDescuenPoliVentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleDescuenPoliVentaLogic.class);
	
	protected DetalleDescuenPoliVentaDataAccess detalledescuenpoliventaDataAccess; 	
	protected DetalleDescuenPoliVenta detalledescuenpoliventa;
	protected List<DetalleDescuenPoliVenta> detalledescuenpoliventas;
	protected Object detalledescuenpoliventaObject;	
	protected List<Object> detalledescuenpoliventasObject;
	
	public static ClassValidator<DetalleDescuenPoliVenta> detalledescuenpoliventaValidator = new ClassValidator<DetalleDescuenPoliVenta>(DetalleDescuenPoliVenta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleDescuenPoliVentaLogicAdditional detalledescuenpoliventaLogicAdditional=null;
	
	public DetalleDescuenPoliVentaLogicAdditional getDetalleDescuenPoliVentaLogicAdditional() {
		return this.detalledescuenpoliventaLogicAdditional;
	}
	
	public void setDetalleDescuenPoliVentaLogicAdditional(DetalleDescuenPoliVentaLogicAdditional detalledescuenpoliventaLogicAdditional) {
		try {
			this.detalledescuenpoliventaLogicAdditional=detalledescuenpoliventaLogicAdditional;
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
	
	
	
	
	public  DetalleDescuenPoliVentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalledescuenpoliventaDataAccess = new DetalleDescuenPoliVentaDataAccess();
			
			this.detalledescuenpoliventas= new ArrayList<DetalleDescuenPoliVenta>();
			this.detalledescuenpoliventa= new DetalleDescuenPoliVenta();
			
			this.detalledescuenpoliventaObject=new Object();
			this.detalledescuenpoliventasObject=new ArrayList<Object>();
				
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
			
			this.detalledescuenpoliventaDataAccess.setConnexionType(this.connexionType);
			this.detalledescuenpoliventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleDescuenPoliVentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalledescuenpoliventaDataAccess = new DetalleDescuenPoliVentaDataAccess();
			this.detalledescuenpoliventas= new ArrayList<DetalleDescuenPoliVenta>();
			this.detalledescuenpoliventa= new DetalleDescuenPoliVenta();
			this.detalledescuenpoliventaObject=new Object();
			this.detalledescuenpoliventasObject=new ArrayList<Object>();
			
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
			
			this.detalledescuenpoliventaDataAccess.setConnexionType(this.connexionType);
			this.detalledescuenpoliventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleDescuenPoliVenta getDetalleDescuenPoliVenta() throws Exception {	
		DetalleDescuenPoliVentaLogicAdditional.checkDetalleDescuenPoliVentaToGet(detalledescuenpoliventa,this.datosCliente,this.arrDatoGeneral);
		DetalleDescuenPoliVentaLogicAdditional.updateDetalleDescuenPoliVentaToGet(detalledescuenpoliventa,this.arrDatoGeneral);
		
		return detalledescuenpoliventa;
	}
		
	public void setDetalleDescuenPoliVenta(DetalleDescuenPoliVenta newDetalleDescuenPoliVenta) {
		this.detalledescuenpoliventa = newDetalleDescuenPoliVenta;
	}
	
	public DetalleDescuenPoliVentaDataAccess getDetalleDescuenPoliVentaDataAccess() {
		return detalledescuenpoliventaDataAccess;
	}
	
	public void setDetalleDescuenPoliVentaDataAccess(DetalleDescuenPoliVentaDataAccess newdetalledescuenpoliventaDataAccess) {
		this.detalledescuenpoliventaDataAccess = newdetalledescuenpoliventaDataAccess;
	}
	
	public List<DetalleDescuenPoliVenta> getDetalleDescuenPoliVentas() throws Exception {		
		this.quitarDetalleDescuenPoliVentasNulos();
		
		DetalleDescuenPoliVentaLogicAdditional.checkDetalleDescuenPoliVentaToGets(detalledescuenpoliventas,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleDescuenPoliVenta detalledescuenpoliventaLocal: detalledescuenpoliventas ) {
			DetalleDescuenPoliVentaLogicAdditional.updateDetalleDescuenPoliVentaToGet(detalledescuenpoliventaLocal,this.arrDatoGeneral);
		}
		
		return detalledescuenpoliventas;
	}
	
	public void setDetalleDescuenPoliVentas(List<DetalleDescuenPoliVenta> newDetalleDescuenPoliVentas) {
		this.detalledescuenpoliventas = newDetalleDescuenPoliVentas;
	}
	
	public Object getDetalleDescuenPoliVentaObject() {	
		this.detalledescuenpoliventaObject=this.detalledescuenpoliventaDataAccess.getEntityObject();
		return this.detalledescuenpoliventaObject;
	}
		
	public void setDetalleDescuenPoliVentaObject(Object newDetalleDescuenPoliVentaObject) {
		this.detalledescuenpoliventaObject = newDetalleDescuenPoliVentaObject;
	}
	
	public List<Object> getDetalleDescuenPoliVentasObject() {		
		this.detalledescuenpoliventasObject=this.detalledescuenpoliventaDataAccess.getEntitiesObject();
		return this.detalledescuenpoliventasObject;
	}
		
	public void setDetalleDescuenPoliVentasObject(List<Object> newDetalleDescuenPoliVentasObject) {
		this.detalledescuenpoliventasObject = newDetalleDescuenPoliVentasObject;
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
		
		if(this.detalledescuenpoliventaDataAccess!=null) {
			this.detalledescuenpoliventaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDescuenPoliVenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalledescuenpoliventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalledescuenpoliventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalledescuenpoliventa = new  DetalleDescuenPoliVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDescuenPoliVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalledescuenpoliventa=detalledescuenpoliventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalledescuenpoliventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventa);
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
		detalledescuenpoliventa = new  DetalleDescuenPoliVenta();
		  		  
        try {
			
			detalledescuenpoliventa=detalledescuenpoliventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalledescuenpoliventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalledescuenpoliventa = new  DetalleDescuenPoliVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDescuenPoliVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalledescuenpoliventa=detalledescuenpoliventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalledescuenpoliventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventa);
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
		detalledescuenpoliventa = new  DetalleDescuenPoliVenta();
		  		  
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
		detalledescuenpoliventa = new  DetalleDescuenPoliVenta();
		  		  
        try {
			
			detalledescuenpoliventa=detalledescuenpoliventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalledescuenpoliventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalledescuenpoliventa = new  DetalleDescuenPoliVenta();
		  		  
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
		detalledescuenpoliventa = new  DetalleDescuenPoliVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDescuenPoliVenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalledescuenpoliventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalledescuenpoliventa = new  DetalleDescuenPoliVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalledescuenpoliventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalledescuenpoliventa = new  DetalleDescuenPoliVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDescuenPoliVenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalledescuenpoliventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalledescuenpoliventa = new  DetalleDescuenPoliVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalledescuenpoliventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalledescuenpoliventa = new  DetalleDescuenPoliVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDescuenPoliVenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalledescuenpoliventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalledescuenpoliventa = new  DetalleDescuenPoliVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalledescuenpoliventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalledescuenpoliventas = new  ArrayList<DetalleDescuenPoliVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDescuenPoliVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledescuenpoliventas=detalledescuenpoliventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleDescuenPoliVenta(detalledescuenpoliventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventas);
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
		detalledescuenpoliventas = new  ArrayList<DetalleDescuenPoliVenta>();
		  		  
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
		detalledescuenpoliventas = new  ArrayList<DetalleDescuenPoliVenta>();
		  		  
        try {			
			DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledescuenpoliventas=detalledescuenpoliventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleDescuenPoliVenta(detalledescuenpoliventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalledescuenpoliventas = new  ArrayList<DetalleDescuenPoliVenta>();
		  		  
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
		detalledescuenpoliventas = new  ArrayList<DetalleDescuenPoliVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDescuenPoliVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledescuenpoliventas=detalledescuenpoliventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleDescuenPoliVenta(detalledescuenpoliventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventas);
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
		detalledescuenpoliventas = new  ArrayList<DetalleDescuenPoliVenta>();
		  		  
        try {
			DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledescuenpoliventas=detalledescuenpoliventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleDescuenPoliVenta(detalledescuenpoliventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventas);
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
		detalledescuenpoliventas = new  ArrayList<DetalleDescuenPoliVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDescuenPoliVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledescuenpoliventas=detalledescuenpoliventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleDescuenPoliVenta(detalledescuenpoliventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventas);
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
		detalledescuenpoliventas = new  ArrayList<DetalleDescuenPoliVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledescuenpoliventas=detalledescuenpoliventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleDescuenPoliVenta(detalledescuenpoliventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalledescuenpoliventa = new  DetalleDescuenPoliVenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDescuenPoliVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledescuenpoliventa=detalledescuenpoliventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleDescuenPoliVenta(detalledescuenpoliventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventa);
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
		detalledescuenpoliventa = new  DetalleDescuenPoliVenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledescuenpoliventa=detalledescuenpoliventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleDescuenPoliVenta(detalledescuenpoliventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalledescuenpoliventas = new  ArrayList<DetalleDescuenPoliVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDescuenPoliVenta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledescuenpoliventas=detalledescuenpoliventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleDescuenPoliVenta(detalledescuenpoliventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventas);
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
		detalledescuenpoliventas = new  ArrayList<DetalleDescuenPoliVenta>();
		  		  
        try {
			DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledescuenpoliventas=detalledescuenpoliventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleDescuenPoliVenta(detalledescuenpoliventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleDescuenPoliVentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalledescuenpoliventas = new  ArrayList<DetalleDescuenPoliVenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDescuenPoliVenta.class.getSimpleName()+"-getTodosDetalleDescuenPoliVentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledescuenpoliventas=detalledescuenpoliventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleDescuenPoliVenta(detalledescuenpoliventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventas);
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
	
	public  void  getTodosDetalleDescuenPoliVentas(String sFinalQuery,Pagination pagination)throws Exception {
		detalledescuenpoliventas = new  ArrayList<DetalleDescuenPoliVenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledescuenpoliventas=detalledescuenpoliventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleDescuenPoliVenta(detalledescuenpoliventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleDescuenPoliVenta(DetalleDescuenPoliVenta detalledescuenpoliventa) throws Exception {
		Boolean estaValidado=false;
		
		if(detalledescuenpoliventa.getIsNew() || detalledescuenpoliventa.getIsChanged()) { 
			this.invalidValues = detalledescuenpoliventaValidator.getInvalidValues(detalledescuenpoliventa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalledescuenpoliventa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleDescuenPoliVenta(List<DetalleDescuenPoliVenta> DetalleDescuenPoliVentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleDescuenPoliVenta detalledescuenpoliventaLocal:detalledescuenpoliventas) {				
			estaValidadoObjeto=this.validarGuardarDetalleDescuenPoliVenta(detalledescuenpoliventaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleDescuenPoliVenta(List<DetalleDescuenPoliVenta> DetalleDescuenPoliVentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleDescuenPoliVenta(detalledescuenpoliventas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleDescuenPoliVenta(DetalleDescuenPoliVenta DetalleDescuenPoliVenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleDescuenPoliVenta(detalledescuenpoliventa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleDescuenPoliVenta detalledescuenpoliventa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalledescuenpoliventa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleDescuenPoliVentaConstantesFunciones.getDetalleDescuenPoliVentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalledescuenpoliventa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleDescuenPoliVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleDescuenPoliVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleDescuenPoliVentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDescuenPoliVenta.class.getSimpleName()+"-saveDetalleDescuenPoliVentaWithConnection");connexion.begin();			
			
			DetalleDescuenPoliVentaLogicAdditional.checkDetalleDescuenPoliVentaToSave(this.detalledescuenpoliventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleDescuenPoliVentaLogicAdditional.updateDetalleDescuenPoliVentaToSave(this.detalledescuenpoliventa,this.arrDatoGeneral);
			
			DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalledescuenpoliventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleDescuenPoliVenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleDescuenPoliVenta(this.detalledescuenpoliventa)) {
				DetalleDescuenPoliVentaDataAccess.save(this.detalledescuenpoliventa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalledescuenpoliventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleDescuenPoliVentaLogicAdditional.checkDetalleDescuenPoliVentaToSaveAfter(this.detalledescuenpoliventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleDescuenPoliVenta();
			
			connexion.commit();			
			
			if(this.detalledescuenpoliventa.getIsDeleted()) {
				this.detalledescuenpoliventa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleDescuenPoliVenta()throws Exception {	
		try {	
			
			DetalleDescuenPoliVentaLogicAdditional.checkDetalleDescuenPoliVentaToSave(this.detalledescuenpoliventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleDescuenPoliVentaLogicAdditional.updateDetalleDescuenPoliVentaToSave(this.detalledescuenpoliventa,this.arrDatoGeneral);
			
			DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalledescuenpoliventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleDescuenPoliVenta(this.detalledescuenpoliventa)) {			
				DetalleDescuenPoliVentaDataAccess.save(this.detalledescuenpoliventa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalledescuenpoliventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleDescuenPoliVentaLogicAdditional.checkDetalleDescuenPoliVentaToSaveAfter(this.detalledescuenpoliventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalledescuenpoliventa.getIsDeleted()) {
				this.detalledescuenpoliventa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleDescuenPoliVentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDescuenPoliVenta.class.getSimpleName()+"-saveDetalleDescuenPoliVentasWithConnection");connexion.begin();			
			
			DetalleDescuenPoliVentaLogicAdditional.checkDetalleDescuenPoliVentaToSaves(detalledescuenpoliventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleDescuenPoliVentas();
			
			Boolean validadoTodosDetalleDescuenPoliVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleDescuenPoliVenta detalledescuenpoliventaLocal:detalledescuenpoliventas) {		
				if(detalledescuenpoliventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleDescuenPoliVentaLogicAdditional.updateDetalleDescuenPoliVentaToSave(detalledescuenpoliventaLocal,this.arrDatoGeneral);
	        	
				DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalledescuenpoliventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleDescuenPoliVenta(detalledescuenpoliventaLocal)) {
					DetalleDescuenPoliVentaDataAccess.save(detalledescuenpoliventaLocal, connexion);				
				} else {
					validadoTodosDetalleDescuenPoliVenta=false;
				}
			}
			
			if(!validadoTodosDetalleDescuenPoliVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleDescuenPoliVentaLogicAdditional.checkDetalleDescuenPoliVentaToSavesAfter(detalledescuenpoliventas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleDescuenPoliVentas();
			
			connexion.commit();		
			
			this.quitarDetalleDescuenPoliVentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleDescuenPoliVentas()throws Exception {				
		 try {	
			DetalleDescuenPoliVentaLogicAdditional.checkDetalleDescuenPoliVentaToSaves(detalledescuenpoliventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleDescuenPoliVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleDescuenPoliVenta detalledescuenpoliventaLocal:detalledescuenpoliventas) {				
				if(detalledescuenpoliventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleDescuenPoliVentaLogicAdditional.updateDetalleDescuenPoliVentaToSave(detalledescuenpoliventaLocal,this.arrDatoGeneral);
	        	
				DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalledescuenpoliventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleDescuenPoliVenta(detalledescuenpoliventaLocal)) {				
					DetalleDescuenPoliVentaDataAccess.save(detalledescuenpoliventaLocal, connexion);				
				} else {
					validadoTodosDetalleDescuenPoliVenta=false;
				}
			}
			
			if(!validadoTodosDetalleDescuenPoliVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleDescuenPoliVentaLogicAdditional.checkDetalleDescuenPoliVentaToSavesAfter(detalledescuenpoliventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleDescuenPoliVentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleDescuenPoliVentaParameterReturnGeneral procesarAccionDetalleDescuenPoliVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleDescuenPoliVenta> detalledescuenpoliventas,DetalleDescuenPoliVentaParameterReturnGeneral detalledescuenpoliventaParameterGeneral)throws Exception {
		 try {	
			DetalleDescuenPoliVentaParameterReturnGeneral detalledescuenpoliventaReturnGeneral=new DetalleDescuenPoliVentaParameterReturnGeneral();
	
			DetalleDescuenPoliVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalledescuenpoliventas,detalledescuenpoliventaParameterGeneral,detalledescuenpoliventaReturnGeneral);
			
			return detalledescuenpoliventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleDescuenPoliVentaParameterReturnGeneral procesarAccionDetalleDescuenPoliVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleDescuenPoliVenta> detalledescuenpoliventas,DetalleDescuenPoliVentaParameterReturnGeneral detalledescuenpoliventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDescuenPoliVenta.class.getSimpleName()+"-procesarAccionDetalleDescuenPoliVentasWithConnection");connexion.begin();			
			
			DetalleDescuenPoliVentaParameterReturnGeneral detalledescuenpoliventaReturnGeneral=new DetalleDescuenPoliVentaParameterReturnGeneral();
	
			DetalleDescuenPoliVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalledescuenpoliventas,detalledescuenpoliventaParameterGeneral,detalledescuenpoliventaReturnGeneral);
			
			this.connexion.commit();
			
			return detalledescuenpoliventaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleDescuenPoliVentaParameterReturnGeneral procesarEventosDetalleDescuenPoliVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleDescuenPoliVenta> detalledescuenpoliventas,DetalleDescuenPoliVenta detalledescuenpoliventa,DetalleDescuenPoliVentaParameterReturnGeneral detalledescuenpoliventaParameterGeneral,Boolean isEsNuevoDetalleDescuenPoliVenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleDescuenPoliVentaParameterReturnGeneral detalledescuenpoliventaReturnGeneral=new DetalleDescuenPoliVentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalledescuenpoliventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleDescuenPoliVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalledescuenpoliventas,detalledescuenpoliventa,detalledescuenpoliventaParameterGeneral,detalledescuenpoliventaReturnGeneral,isEsNuevoDetalleDescuenPoliVenta,clases);
			
			return detalledescuenpoliventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleDescuenPoliVentaParameterReturnGeneral procesarEventosDetalleDescuenPoliVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleDescuenPoliVenta> detalledescuenpoliventas,DetalleDescuenPoliVenta detalledescuenpoliventa,DetalleDescuenPoliVentaParameterReturnGeneral detalledescuenpoliventaParameterGeneral,Boolean isEsNuevoDetalleDescuenPoliVenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDescuenPoliVenta.class.getSimpleName()+"-procesarEventosDetalleDescuenPoliVentasWithConnection");connexion.begin();			
			
			DetalleDescuenPoliVentaParameterReturnGeneral detalledescuenpoliventaReturnGeneral=new DetalleDescuenPoliVentaParameterReturnGeneral();
	
			detalledescuenpoliventaReturnGeneral.setDetalleDescuenPoliVenta(detalledescuenpoliventa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalledescuenpoliventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleDescuenPoliVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalledescuenpoliventas,detalledescuenpoliventa,detalledescuenpoliventaParameterGeneral,detalledescuenpoliventaReturnGeneral,isEsNuevoDetalleDescuenPoliVenta,clases);
			
			this.connexion.commit();
			
			return detalledescuenpoliventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleDescuenPoliVentaParameterReturnGeneral procesarImportacionDetalleDescuenPoliVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleDescuenPoliVentaParameterReturnGeneral detalledescuenpoliventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDescuenPoliVenta.class.getSimpleName()+"-procesarImportacionDetalleDescuenPoliVentasWithConnection");connexion.begin();			
			
			DetalleDescuenPoliVentaParameterReturnGeneral detalledescuenpoliventaReturnGeneral=new DetalleDescuenPoliVentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalledescuenpoliventas=new ArrayList<DetalleDescuenPoliVenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalledescuenpoliventa=new DetalleDescuenPoliVenta();
				
				
				if(conColumnasBase) {this.detalledescuenpoliventa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalledescuenpoliventa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalledescuenpoliventa.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalledescuenpoliventa.setdescripcion(arrColumnas[iColumn++]);
				
				this.detalledescuenpoliventas.add(this.detalledescuenpoliventa);
			}
			
			this.saveDetalleDescuenPoliVentas();
			
			this.connexion.commit();
			
			detalledescuenpoliventaReturnGeneral.setConRetornoEstaProcesado(true);
			detalledescuenpoliventaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalledescuenpoliventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleDescuenPoliVentasEliminados() throws Exception {				
		
		List<DetalleDescuenPoliVenta> detalledescuenpoliventasAux= new ArrayList<DetalleDescuenPoliVenta>();
		
		for(DetalleDescuenPoliVenta detalledescuenpoliventa:detalledescuenpoliventas) {
			if(!detalledescuenpoliventa.getIsDeleted()) {
				detalledescuenpoliventasAux.add(detalledescuenpoliventa);
			}
		}
		
		detalledescuenpoliventas=detalledescuenpoliventasAux;
	}
	
	public void quitarDetalleDescuenPoliVentasNulos() throws Exception {				
		
		List<DetalleDescuenPoliVenta> detalledescuenpoliventasAux= new ArrayList<DetalleDescuenPoliVenta>();
		
		for(DetalleDescuenPoliVenta detalledescuenpoliventa : this.detalledescuenpoliventas) {
			if(detalledescuenpoliventa==null) {
				detalledescuenpoliventasAux.add(detalledescuenpoliventa);
			}
		}
		
		//this.detalledescuenpoliventas=detalledescuenpoliventasAux;
		
		this.detalledescuenpoliventas.removeAll(detalledescuenpoliventasAux);
	}
	
	public void getSetVersionRowDetalleDescuenPoliVentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalledescuenpoliventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalledescuenpoliventa.getIsDeleted() || (detalledescuenpoliventa.getIsChanged()&&!detalledescuenpoliventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalledescuenpoliventaDataAccess.getSetVersionRowDetalleDescuenPoliVenta(connexion,detalledescuenpoliventa.getId());
				
				if(!detalledescuenpoliventa.getVersionRow().equals(timestamp)) {	
					detalledescuenpoliventa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalledescuenpoliventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleDescuenPoliVenta()throws Exception {	
		
		if(detalledescuenpoliventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalledescuenpoliventa.getIsDeleted() || (detalledescuenpoliventa.getIsChanged()&&!detalledescuenpoliventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalledescuenpoliventaDataAccess.getSetVersionRowDetalleDescuenPoliVenta(connexion,detalledescuenpoliventa.getId());
			
			try {							
				if(!detalledescuenpoliventa.getVersionRow().equals(timestamp)) {	
					detalledescuenpoliventa.setVersionRow(timestamp);
				}
				
				detalledescuenpoliventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleDescuenPoliVentasWithConnection()throws Exception {	
		if(detalledescuenpoliventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleDescuenPoliVenta detalledescuenpoliventaAux:detalledescuenpoliventas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalledescuenpoliventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalledescuenpoliventaAux.getIsDeleted() || (detalledescuenpoliventaAux.getIsChanged()&&!detalledescuenpoliventaAux.getIsNew())) {
						
						timestamp=detalledescuenpoliventaDataAccess.getSetVersionRowDetalleDescuenPoliVenta(connexion,detalledescuenpoliventaAux.getId());
						
						if(!detalledescuenpoliventa.getVersionRow().equals(timestamp)) {	
							detalledescuenpoliventaAux.setVersionRow(timestamp);
						}
								
						detalledescuenpoliventaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleDescuenPoliVentas()throws Exception {	
		if(detalledescuenpoliventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleDescuenPoliVenta detalledescuenpoliventaAux:detalledescuenpoliventas) {
					if(detalledescuenpoliventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalledescuenpoliventaAux.getIsDeleted() || (detalledescuenpoliventaAux.getIsChanged()&&!detalledescuenpoliventaAux.getIsNew())) {
						
						timestamp=detalledescuenpoliventaDataAccess.getSetVersionRowDetalleDescuenPoliVenta(connexion,detalledescuenpoliventaAux.getId());
						
						if(!detalledescuenpoliventaAux.getVersionRow().equals(timestamp)) {	
							detalledescuenpoliventaAux.setVersionRow(timestamp);
						}
						
													
						detalledescuenpoliventaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleDescuenPoliVentaParameterReturnGeneral cargarCombosLoteForeignKeyDetalleDescuenPoliVentaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCliente) throws Exception {
		DetalleDescuenPoliVentaParameterReturnGeneral  detalledescuenpoliventaReturnGeneral =new DetalleDescuenPoliVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDescuenPoliVenta.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleDescuenPoliVentaWithConnection");connexion.begin();
			
			detalledescuenpoliventaReturnGeneral =new DetalleDescuenPoliVentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalledescuenpoliventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalledescuenpoliventaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			detalledescuenpoliventaReturnGeneral.setclientesForeignKey(clientesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalledescuenpoliventaReturnGeneral;
	}
	
	public DetalleDescuenPoliVentaParameterReturnGeneral cargarCombosLoteForeignKeyDetalleDescuenPoliVenta(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCliente) throws Exception {
		DetalleDescuenPoliVentaParameterReturnGeneral  detalledescuenpoliventaReturnGeneral =new DetalleDescuenPoliVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalledescuenpoliventaReturnGeneral =new DetalleDescuenPoliVentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalledescuenpoliventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalledescuenpoliventaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			detalledescuenpoliventaReturnGeneral.setclientesForeignKey(clientesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalledescuenpoliventaReturnGeneral;
	}
	
	
	public void deepLoad(DetalleDescuenPoliVenta detalledescuenpoliventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleDescuenPoliVentaLogicAdditional.updateDetalleDescuenPoliVentaToGet(detalledescuenpoliventa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalledescuenpoliventa.setEmpresa(detalledescuenpoliventaDataAccess.getEmpresa(connexion,detalledescuenpoliventa));
		detalledescuenpoliventa.setSucursal(detalledescuenpoliventaDataAccess.getSucursal(connexion,detalledescuenpoliventa));
		detalledescuenpoliventa.setCliente(detalledescuenpoliventaDataAccess.getCliente(connexion,detalledescuenpoliventa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalledescuenpoliventa.setEmpresa(detalledescuenpoliventaDataAccess.getEmpresa(connexion,detalledescuenpoliventa));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalledescuenpoliventa.setSucursal(detalledescuenpoliventaDataAccess.getSucursal(connexion,detalledescuenpoliventa));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				detalledescuenpoliventa.setCliente(detalledescuenpoliventaDataAccess.getCliente(connexion,detalledescuenpoliventa));
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
			detalledescuenpoliventa.setEmpresa(detalledescuenpoliventaDataAccess.getEmpresa(connexion,detalledescuenpoliventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalledescuenpoliventa.setSucursal(detalledescuenpoliventaDataAccess.getSucursal(connexion,detalledescuenpoliventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalledescuenpoliventa.setCliente(detalledescuenpoliventaDataAccess.getCliente(connexion,detalledescuenpoliventa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalledescuenpoliventa.setEmpresa(detalledescuenpoliventaDataAccess.getEmpresa(connexion,detalledescuenpoliventa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalledescuenpoliventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalledescuenpoliventa.setSucursal(detalledescuenpoliventaDataAccess.getSucursal(connexion,detalledescuenpoliventa));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalledescuenpoliventa.getSucursal(),isDeep,deepLoadType,clases);
				
		detalledescuenpoliventa.setCliente(detalledescuenpoliventaDataAccess.getCliente(connexion,detalledescuenpoliventa));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(detalledescuenpoliventa.getCliente(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalledescuenpoliventa.setEmpresa(detalledescuenpoliventaDataAccess.getEmpresa(connexion,detalledescuenpoliventa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalledescuenpoliventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalledescuenpoliventa.setSucursal(detalledescuenpoliventaDataAccess.getSucursal(connexion,detalledescuenpoliventa));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detalledescuenpoliventa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				detalledescuenpoliventa.setCliente(detalledescuenpoliventaDataAccess.getCliente(connexion,detalledescuenpoliventa));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(detalledescuenpoliventa.getCliente(),isDeep,deepLoadType,clases);				
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
			detalledescuenpoliventa.setEmpresa(detalledescuenpoliventaDataAccess.getEmpresa(connexion,detalledescuenpoliventa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalledescuenpoliventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalledescuenpoliventa.setSucursal(detalledescuenpoliventaDataAccess.getSucursal(connexion,detalledescuenpoliventa));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detalledescuenpoliventa.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalledescuenpoliventa.setCliente(detalledescuenpoliventaDataAccess.getCliente(connexion,detalledescuenpoliventa));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(detalledescuenpoliventa.getCliente(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleDescuenPoliVenta detalledescuenpoliventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleDescuenPoliVentaLogicAdditional.updateDetalleDescuenPoliVentaToSave(detalledescuenpoliventa,this.arrDatoGeneral);
			
DetalleDescuenPoliVentaDataAccess.save(detalledescuenpoliventa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalledescuenpoliventa.getEmpresa(),connexion);

		SucursalDataAccess.save(detalledescuenpoliventa.getSucursal(),connexion);

		ClienteDataAccess.save(detalledescuenpoliventa.getCliente(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalledescuenpoliventa.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalledescuenpoliventa.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(detalledescuenpoliventa.getCliente(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalledescuenpoliventa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalledescuenpoliventa.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detalledescuenpoliventa.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalledescuenpoliventa.getSucursal(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(detalledescuenpoliventa.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(detalledescuenpoliventa.getCliente(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalledescuenpoliventa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalledescuenpoliventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalledescuenpoliventa.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detalledescuenpoliventa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(detalledescuenpoliventa.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(detalledescuenpoliventa.getCliente(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleDescuenPoliVenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalledescuenpoliventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(detalledescuenpoliventa);
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
			this.deepLoad(this.detalledescuenpoliventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleDescuenPoliVenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalledescuenpoliventas!=null) {
				for(DetalleDescuenPoliVenta detalledescuenpoliventa:detalledescuenpoliventas) {
					this.deepLoad(detalledescuenpoliventa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(detalledescuenpoliventas);
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
			if(detalledescuenpoliventas!=null) {
				for(DetalleDescuenPoliVenta detalledescuenpoliventa:detalledescuenpoliventas) {
					this.deepLoad(detalledescuenpoliventa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(detalledescuenpoliventas);
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
			this.getNewConnexionToDeep(DetalleDescuenPoliVenta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalledescuenpoliventa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleDescuenPoliVenta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalledescuenpoliventas!=null) {
				for(DetalleDescuenPoliVenta detalledescuenpoliventa:detalledescuenpoliventas) {
					this.deepSave(detalledescuenpoliventa,isDeep,deepLoadType,clases);
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
			if(detalledescuenpoliventas!=null) {
				for(DetalleDescuenPoliVenta detalledescuenpoliventa:detalledescuenpoliventas) {
					this.deepSave(detalledescuenpoliventa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleDescuenPoliVentasFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDescuenPoliVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,DetalleDescuenPoliVentaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalledescuenpoliventas=detalledescuenpoliventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleDescuenPoliVentasFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,DetalleDescuenPoliVentaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalledescuenpoliventas=detalledescuenpoliventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleDescuenPoliVentasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDescuenPoliVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleDescuenPoliVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalledescuenpoliventas=detalledescuenpoliventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleDescuenPoliVentasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleDescuenPoliVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalledescuenpoliventas=detalledescuenpoliventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleDescuenPoliVentasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDescuenPoliVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleDescuenPoliVentaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalledescuenpoliventas=detalledescuenpoliventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleDescuenPoliVentasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleDescuenPoliVentaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleDescuenPoliVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalledescuenpoliventas=detalledescuenpoliventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleDescuenPoliVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(this.detalledescuenpoliventas);
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
			if(DetalleDescuenPoliVentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleDescuenPoliVentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleDescuenPoliVenta detalledescuenpoliventa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleDescuenPoliVentaConstantesFunciones.ISCONAUDITORIA) {
				if(detalledescuenpoliventa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleDescuenPoliVentaDataAccess.TABLENAME, detalledescuenpoliventa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleDescuenPoliVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleDescuenPoliVentaLogic.registrarAuditoriaDetallesDetalleDescuenPoliVenta(connexion,detalledescuenpoliventa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalledescuenpoliventa.getIsDeleted()) {
					/*if(!detalledescuenpoliventa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleDescuenPoliVentaDataAccess.TABLENAME, detalledescuenpoliventa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleDescuenPoliVentaLogic.registrarAuditoriaDetallesDetalleDescuenPoliVenta(connexion,detalledescuenpoliventa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleDescuenPoliVentaDataAccess.TABLENAME, detalledescuenpoliventa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalledescuenpoliventa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleDescuenPoliVentaDataAccess.TABLENAME, detalledescuenpoliventa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleDescuenPoliVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleDescuenPoliVentaLogic.registrarAuditoriaDetallesDetalleDescuenPoliVenta(connexion,detalledescuenpoliventa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleDescuenPoliVenta(Connexion connexion,DetalleDescuenPoliVenta detalledescuenpoliventa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalledescuenpoliventa.getIsNew()||!detalledescuenpoliventa.getid_empresa().equals(detalledescuenpoliventa.getDetalleDescuenPoliVentaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalledescuenpoliventa.getDetalleDescuenPoliVentaOriginal().getid_empresa()!=null)
				{
					strValorActual=detalledescuenpoliventa.getDetalleDescuenPoliVentaOriginal().getid_empresa().toString();
				}
				if(detalledescuenpoliventa.getid_empresa()!=null)
				{
					strValorNuevo=detalledescuenpoliventa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleDescuenPoliVentaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalledescuenpoliventa.getIsNew()||!detalledescuenpoliventa.getid_sucursal().equals(detalledescuenpoliventa.getDetalleDescuenPoliVentaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalledescuenpoliventa.getDetalleDescuenPoliVentaOriginal().getid_sucursal()!=null)
				{
					strValorActual=detalledescuenpoliventa.getDetalleDescuenPoliVentaOriginal().getid_sucursal().toString();
				}
				if(detalledescuenpoliventa.getid_sucursal()!=null)
				{
					strValorNuevo=detalledescuenpoliventa.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleDescuenPoliVentaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detalledescuenpoliventa.getIsNew()||!detalledescuenpoliventa.getid_cliente().equals(detalledescuenpoliventa.getDetalleDescuenPoliVentaOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalledescuenpoliventa.getDetalleDescuenPoliVentaOriginal().getid_cliente()!=null)
				{
					strValorActual=detalledescuenpoliventa.getDetalleDescuenPoliVentaOriginal().getid_cliente().toString();
				}
				if(detalledescuenpoliventa.getid_cliente()!=null)
				{
					strValorNuevo=detalledescuenpoliventa.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleDescuenPoliVentaConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(detalledescuenpoliventa.getIsNew()||!detalledescuenpoliventa.getvalor().equals(detalledescuenpoliventa.getDetalleDescuenPoliVentaOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalledescuenpoliventa.getDetalleDescuenPoliVentaOriginal().getvalor()!=null)
				{
					strValorActual=detalledescuenpoliventa.getDetalleDescuenPoliVentaOriginal().getvalor().toString();
				}
				if(detalledescuenpoliventa.getvalor()!=null)
				{
					strValorNuevo=detalledescuenpoliventa.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleDescuenPoliVentaConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(detalledescuenpoliventa.getIsNew()||!detalledescuenpoliventa.getdescripcion().equals(detalledescuenpoliventa.getDetalleDescuenPoliVentaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalledescuenpoliventa.getDetalleDescuenPoliVentaOriginal().getdescripcion()!=null)
				{
					strValorActual=detalledescuenpoliventa.getDetalleDescuenPoliVentaOriginal().getdescripcion();
				}
				if(detalledescuenpoliventa.getdescripcion()!=null)
				{
					strValorNuevo=detalledescuenpoliventa.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleDescuenPoliVentaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleDescuenPoliVentaRelacionesWithConnection(DetalleDescuenPoliVenta detalledescuenpoliventa) throws Exception {

		if(!detalledescuenpoliventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleDescuenPoliVentaRelacionesBase(detalledescuenpoliventa,true);
		}
	}

	public void saveDetalleDescuenPoliVentaRelaciones(DetalleDescuenPoliVenta detalledescuenpoliventa)throws Exception {

		if(!detalledescuenpoliventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleDescuenPoliVentaRelacionesBase(detalledescuenpoliventa,false);
		}
	}

	public void saveDetalleDescuenPoliVentaRelacionesBase(DetalleDescuenPoliVenta detalledescuenpoliventa,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleDescuenPoliVenta-saveRelacionesWithConnection");}
	

			this.setDetalleDescuenPoliVenta(detalledescuenpoliventa);

			if(DetalleDescuenPoliVentaLogicAdditional.validarSaveRelaciones(detalledescuenpoliventa,this)) {

				DetalleDescuenPoliVentaLogicAdditional.updateRelacionesToSave(detalledescuenpoliventa,this);

				if((detalledescuenpoliventa.getIsNew()||detalledescuenpoliventa.getIsChanged())&&!detalledescuenpoliventa.getIsDeleted()) {
					this.saveDetalleDescuenPoliVenta();
					this.saveDetalleDescuenPoliVentaRelacionesDetalles();

				} else if(detalledescuenpoliventa.getIsDeleted()) {
					this.saveDetalleDescuenPoliVentaRelacionesDetalles();
					this.saveDetalleDescuenPoliVenta();
				}

				DetalleDescuenPoliVentaLogicAdditional.updateRelacionesToSaveAfter(detalledescuenpoliventa,this);

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
	
	
	private void saveDetalleDescuenPoliVentaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleDescuenPoliVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleDescuenPoliVentaConstantesFunciones.getClassesForeignKeysOfDetalleDescuenPoliVenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleDescuenPoliVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleDescuenPoliVentaConstantesFunciones.getClassesRelationshipsOfDetalleDescuenPoliVenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

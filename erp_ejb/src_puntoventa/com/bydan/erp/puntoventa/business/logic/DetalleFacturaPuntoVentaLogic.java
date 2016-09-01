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
import com.bydan.erp.puntoventa.util.DetalleFacturaPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.DetalleFacturaPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.DetalleFacturaPuntoVentaParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.DetalleFacturaPuntoVenta;
import com.bydan.erp.puntoventa.business.logic.DetalleFacturaPuntoVentaLogicAdditional;
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
public class DetalleFacturaPuntoVentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleFacturaPuntoVentaLogic.class);
	
	protected DetalleFacturaPuntoVentaDataAccess detallefacturapuntoventaDataAccess; 	
	protected DetalleFacturaPuntoVenta detallefacturapuntoventa;
	protected List<DetalleFacturaPuntoVenta> detallefacturapuntoventas;
	protected Object detallefacturapuntoventaObject;	
	protected List<Object> detallefacturapuntoventasObject;
	
	public static ClassValidator<DetalleFacturaPuntoVenta> detallefacturapuntoventaValidator = new ClassValidator<DetalleFacturaPuntoVenta>(DetalleFacturaPuntoVenta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleFacturaPuntoVentaLogicAdditional detallefacturapuntoventaLogicAdditional=null;
	
	public DetalleFacturaPuntoVentaLogicAdditional getDetalleFacturaPuntoVentaLogicAdditional() {
		return this.detallefacturapuntoventaLogicAdditional;
	}
	
	public void setDetalleFacturaPuntoVentaLogicAdditional(DetalleFacturaPuntoVentaLogicAdditional detallefacturapuntoventaLogicAdditional) {
		try {
			this.detallefacturapuntoventaLogicAdditional=detallefacturapuntoventaLogicAdditional;
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
	
	
	
	
	public  DetalleFacturaPuntoVentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detallefacturapuntoventaDataAccess = new DetalleFacturaPuntoVentaDataAccess();
			
			this.detallefacturapuntoventas= new ArrayList<DetalleFacturaPuntoVenta>();
			this.detallefacturapuntoventa= new DetalleFacturaPuntoVenta();
			
			this.detallefacturapuntoventaObject=new Object();
			this.detallefacturapuntoventasObject=new ArrayList<Object>();
				
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
			
			this.detallefacturapuntoventaDataAccess.setConnexionType(this.connexionType);
			this.detallefacturapuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleFacturaPuntoVentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detallefacturapuntoventaDataAccess = new DetalleFacturaPuntoVentaDataAccess();
			this.detallefacturapuntoventas= new ArrayList<DetalleFacturaPuntoVenta>();
			this.detallefacturapuntoventa= new DetalleFacturaPuntoVenta();
			this.detallefacturapuntoventaObject=new Object();
			this.detallefacturapuntoventasObject=new ArrayList<Object>();
			
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
			
			this.detallefacturapuntoventaDataAccess.setConnexionType(this.connexionType);
			this.detallefacturapuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleFacturaPuntoVenta getDetalleFacturaPuntoVenta() throws Exception {	
		DetalleFacturaPuntoVentaLogicAdditional.checkDetalleFacturaPuntoVentaToGet(detallefacturapuntoventa,this.datosCliente,this.arrDatoGeneral);
		DetalleFacturaPuntoVentaLogicAdditional.updateDetalleFacturaPuntoVentaToGet(detallefacturapuntoventa,this.arrDatoGeneral);
		
		return detallefacturapuntoventa;
	}
		
	public void setDetalleFacturaPuntoVenta(DetalleFacturaPuntoVenta newDetalleFacturaPuntoVenta) {
		this.detallefacturapuntoventa = newDetalleFacturaPuntoVenta;
	}
	
	public DetalleFacturaPuntoVentaDataAccess getDetalleFacturaPuntoVentaDataAccess() {
		return detallefacturapuntoventaDataAccess;
	}
	
	public void setDetalleFacturaPuntoVentaDataAccess(DetalleFacturaPuntoVentaDataAccess newdetallefacturapuntoventaDataAccess) {
		this.detallefacturapuntoventaDataAccess = newdetallefacturapuntoventaDataAccess;
	}
	
	public List<DetalleFacturaPuntoVenta> getDetalleFacturaPuntoVentas() throws Exception {		
		this.quitarDetalleFacturaPuntoVentasNulos();
		
		DetalleFacturaPuntoVentaLogicAdditional.checkDetalleFacturaPuntoVentaToGets(detallefacturapuntoventas,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleFacturaPuntoVenta detallefacturapuntoventaLocal: detallefacturapuntoventas ) {
			DetalleFacturaPuntoVentaLogicAdditional.updateDetalleFacturaPuntoVentaToGet(detallefacturapuntoventaLocal,this.arrDatoGeneral);
		}
		
		return detallefacturapuntoventas;
	}
	
	public void setDetalleFacturaPuntoVentas(List<DetalleFacturaPuntoVenta> newDetalleFacturaPuntoVentas) {
		this.detallefacturapuntoventas = newDetalleFacturaPuntoVentas;
	}
	
	public Object getDetalleFacturaPuntoVentaObject() {	
		this.detallefacturapuntoventaObject=this.detallefacturapuntoventaDataAccess.getEntityObject();
		return this.detallefacturapuntoventaObject;
	}
		
	public void setDetalleFacturaPuntoVentaObject(Object newDetalleFacturaPuntoVentaObject) {
		this.detallefacturapuntoventaObject = newDetalleFacturaPuntoVentaObject;
	}
	
	public List<Object> getDetalleFacturaPuntoVentasObject() {		
		this.detallefacturapuntoventasObject=this.detallefacturapuntoventaDataAccess.getEntitiesObject();
		return this.detallefacturapuntoventasObject;
	}
		
	public void setDetalleFacturaPuntoVentasObject(List<Object> newDetalleFacturaPuntoVentasObject) {
		this.detallefacturapuntoventasObject = newDetalleFacturaPuntoVentasObject;
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
		
		if(this.detallefacturapuntoventaDataAccess!=null) {
			this.detallefacturapuntoventaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detallefacturapuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detallefacturapuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detallefacturapuntoventa = new  DetalleFacturaPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallefacturapuntoventa=detallefacturapuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallefacturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventa);
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
		detallefacturapuntoventa = new  DetalleFacturaPuntoVenta();
		  		  
        try {
			
			detallefacturapuntoventa=detallefacturapuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallefacturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detallefacturapuntoventa = new  DetalleFacturaPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallefacturapuntoventa=detallefacturapuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallefacturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventa);
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
		detallefacturapuntoventa = new  DetalleFacturaPuntoVenta();
		  		  
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
		detallefacturapuntoventa = new  DetalleFacturaPuntoVenta();
		  		  
        try {
			
			detallefacturapuntoventa=detallefacturapuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallefacturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detallefacturapuntoventa = new  DetalleFacturaPuntoVenta();
		  		  
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
		detallefacturapuntoventa = new  DetalleFacturaPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detallefacturapuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallefacturapuntoventa = new  DetalleFacturaPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detallefacturapuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallefacturapuntoventa = new  DetalleFacturaPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detallefacturapuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallefacturapuntoventa = new  DetalleFacturaPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detallefacturapuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallefacturapuntoventa = new  DetalleFacturaPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detallefacturapuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallefacturapuntoventa = new  DetalleFacturaPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detallefacturapuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallefacturapuntoventas = new  ArrayList<DetalleFacturaPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleFacturaPuntoVenta(detallefacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
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
		detallefacturapuntoventas = new  ArrayList<DetalleFacturaPuntoVenta>();
		  		  
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
		detallefacturapuntoventas = new  ArrayList<DetalleFacturaPuntoVenta>();
		  		  
        try {			
			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleFacturaPuntoVenta(detallefacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detallefacturapuntoventas = new  ArrayList<DetalleFacturaPuntoVenta>();
		  		  
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
		detallefacturapuntoventas = new  ArrayList<DetalleFacturaPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleFacturaPuntoVenta(detallefacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
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
		detallefacturapuntoventas = new  ArrayList<DetalleFacturaPuntoVenta>();
		  		  
        try {
			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleFacturaPuntoVenta(detallefacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
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
		detallefacturapuntoventas = new  ArrayList<DetalleFacturaPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleFacturaPuntoVenta(detallefacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
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
		detallefacturapuntoventas = new  ArrayList<DetalleFacturaPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleFacturaPuntoVenta(detallefacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detallefacturapuntoventa = new  DetalleFacturaPuntoVenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturapuntoventa=detallefacturapuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleFacturaPuntoVenta(detallefacturapuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventa);
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
		detallefacturapuntoventa = new  DetalleFacturaPuntoVenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturapuntoventa=detallefacturapuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleFacturaPuntoVenta(detallefacturapuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallefacturapuntoventas = new  ArrayList<DetalleFacturaPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleFacturaPuntoVenta(detallefacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
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
		detallefacturapuntoventas = new  ArrayList<DetalleFacturaPuntoVenta>();
		  		  
        try {
			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleFacturaPuntoVenta(detallefacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleFacturaPuntoVentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detallefacturapuntoventas = new  ArrayList<DetalleFacturaPuntoVenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-getTodosDetalleFacturaPuntoVentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleFacturaPuntoVenta(detallefacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
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
	
	public  void  getTodosDetalleFacturaPuntoVentas(String sFinalQuery,Pagination pagination)throws Exception {
		detallefacturapuntoventas = new  ArrayList<DetalleFacturaPuntoVenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleFacturaPuntoVenta(detallefacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleFacturaPuntoVenta(DetalleFacturaPuntoVenta detallefacturapuntoventa) throws Exception {
		Boolean estaValidado=false;
		
		if(detallefacturapuntoventa.getIsNew() || detallefacturapuntoventa.getIsChanged()) { 
			this.invalidValues = detallefacturapuntoventaValidator.getInvalidValues(detallefacturapuntoventa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detallefacturapuntoventa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleFacturaPuntoVenta(List<DetalleFacturaPuntoVenta> DetalleFacturaPuntoVentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleFacturaPuntoVenta detallefacturapuntoventaLocal:detallefacturapuntoventas) {				
			estaValidadoObjeto=this.validarGuardarDetalleFacturaPuntoVenta(detallefacturapuntoventaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleFacturaPuntoVenta(List<DetalleFacturaPuntoVenta> DetalleFacturaPuntoVentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleFacturaPuntoVenta(detallefacturapuntoventas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleFacturaPuntoVenta(DetalleFacturaPuntoVenta DetalleFacturaPuntoVenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleFacturaPuntoVenta(detallefacturapuntoventa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleFacturaPuntoVenta detallefacturapuntoventa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detallefacturapuntoventa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleFacturaPuntoVentaConstantesFunciones.getDetalleFacturaPuntoVentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detallefacturapuntoventa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleFacturaPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleFacturaPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleFacturaPuntoVentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-saveDetalleFacturaPuntoVentaWithConnection");connexion.begin();			
			
			DetalleFacturaPuntoVentaLogicAdditional.checkDetalleFacturaPuntoVentaToSave(this.detallefacturapuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleFacturaPuntoVentaLogicAdditional.updateDetalleFacturaPuntoVentaToSave(this.detallefacturapuntoventa,this.arrDatoGeneral);
			
			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallefacturapuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleFacturaPuntoVenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleFacturaPuntoVenta(this.detallefacturapuntoventa)) {
				DetalleFacturaPuntoVentaDataAccess.save(this.detallefacturapuntoventa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detallefacturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleFacturaPuntoVentaLogicAdditional.checkDetalleFacturaPuntoVentaToSaveAfter(this.detallefacturapuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleFacturaPuntoVenta();
			
			connexion.commit();			
			
			if(this.detallefacturapuntoventa.getIsDeleted()) {
				this.detallefacturapuntoventa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleFacturaPuntoVenta()throws Exception {	
		try {	
			
			DetalleFacturaPuntoVentaLogicAdditional.checkDetalleFacturaPuntoVentaToSave(this.detallefacturapuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleFacturaPuntoVentaLogicAdditional.updateDetalleFacturaPuntoVentaToSave(this.detallefacturapuntoventa,this.arrDatoGeneral);
			
			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallefacturapuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleFacturaPuntoVenta(this.detallefacturapuntoventa)) {			
				DetalleFacturaPuntoVentaDataAccess.save(this.detallefacturapuntoventa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detallefacturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleFacturaPuntoVentaLogicAdditional.checkDetalleFacturaPuntoVentaToSaveAfter(this.detallefacturapuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detallefacturapuntoventa.getIsDeleted()) {
				this.detallefacturapuntoventa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleFacturaPuntoVentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-saveDetalleFacturaPuntoVentasWithConnection");connexion.begin();			
			
			DetalleFacturaPuntoVentaLogicAdditional.checkDetalleFacturaPuntoVentaToSaves(detallefacturapuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleFacturaPuntoVentas();
			
			Boolean validadoTodosDetalleFacturaPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleFacturaPuntoVenta detallefacturapuntoventaLocal:detallefacturapuntoventas) {		
				if(detallefacturapuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleFacturaPuntoVentaLogicAdditional.updateDetalleFacturaPuntoVentaToSave(detallefacturapuntoventaLocal,this.arrDatoGeneral);
	        	
				DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallefacturapuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleFacturaPuntoVenta(detallefacturapuntoventaLocal)) {
					DetalleFacturaPuntoVentaDataAccess.save(detallefacturapuntoventaLocal, connexion);				
				} else {
					validadoTodosDetalleFacturaPuntoVenta=false;
				}
			}
			
			if(!validadoTodosDetalleFacturaPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleFacturaPuntoVentaLogicAdditional.checkDetalleFacturaPuntoVentaToSavesAfter(detallefacturapuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleFacturaPuntoVentas();
			
			connexion.commit();		
			
			this.quitarDetalleFacturaPuntoVentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleFacturaPuntoVentas()throws Exception {				
		 try {	
			DetalleFacturaPuntoVentaLogicAdditional.checkDetalleFacturaPuntoVentaToSaves(detallefacturapuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleFacturaPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleFacturaPuntoVenta detallefacturapuntoventaLocal:detallefacturapuntoventas) {				
				if(detallefacturapuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleFacturaPuntoVentaLogicAdditional.updateDetalleFacturaPuntoVentaToSave(detallefacturapuntoventaLocal,this.arrDatoGeneral);
	        	
				DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallefacturapuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleFacturaPuntoVenta(detallefacturapuntoventaLocal)) {				
					DetalleFacturaPuntoVentaDataAccess.save(detallefacturapuntoventaLocal, connexion);				
				} else {
					validadoTodosDetalleFacturaPuntoVenta=false;
				}
			}
			
			if(!validadoTodosDetalleFacturaPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleFacturaPuntoVentaLogicAdditional.checkDetalleFacturaPuntoVentaToSavesAfter(detallefacturapuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleFacturaPuntoVentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleFacturaPuntoVentaParameterReturnGeneral procesarAccionDetalleFacturaPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleFacturaPuntoVenta> detallefacturapuntoventas,DetalleFacturaPuntoVentaParameterReturnGeneral detallefacturapuntoventaParameterGeneral)throws Exception {
		 try {	
			DetalleFacturaPuntoVentaParameterReturnGeneral detallefacturapuntoventaReturnGeneral=new DetalleFacturaPuntoVentaParameterReturnGeneral();
	
			DetalleFacturaPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallefacturapuntoventas,detallefacturapuntoventaParameterGeneral,detallefacturapuntoventaReturnGeneral);
			
			return detallefacturapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleFacturaPuntoVentaParameterReturnGeneral procesarAccionDetalleFacturaPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleFacturaPuntoVenta> detallefacturapuntoventas,DetalleFacturaPuntoVentaParameterReturnGeneral detallefacturapuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-procesarAccionDetalleFacturaPuntoVentasWithConnection");connexion.begin();			
			
			DetalleFacturaPuntoVentaParameterReturnGeneral detallefacturapuntoventaReturnGeneral=new DetalleFacturaPuntoVentaParameterReturnGeneral();
	
			DetalleFacturaPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallefacturapuntoventas,detallefacturapuntoventaParameterGeneral,detallefacturapuntoventaReturnGeneral);
			
			this.connexion.commit();
			
			return detallefacturapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleFacturaPuntoVentaParameterReturnGeneral procesarEventosDetalleFacturaPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleFacturaPuntoVenta> detallefacturapuntoventas,DetalleFacturaPuntoVenta detallefacturapuntoventa,DetalleFacturaPuntoVentaParameterReturnGeneral detallefacturapuntoventaParameterGeneral,Boolean isEsNuevoDetalleFacturaPuntoVenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleFacturaPuntoVentaParameterReturnGeneral detallefacturapuntoventaReturnGeneral=new DetalleFacturaPuntoVentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallefacturapuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleFacturaPuntoVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallefacturapuntoventas,detallefacturapuntoventa,detallefacturapuntoventaParameterGeneral,detallefacturapuntoventaReturnGeneral,isEsNuevoDetalleFacturaPuntoVenta,clases);
			
			return detallefacturapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleFacturaPuntoVentaParameterReturnGeneral procesarEventosDetalleFacturaPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleFacturaPuntoVenta> detallefacturapuntoventas,DetalleFacturaPuntoVenta detallefacturapuntoventa,DetalleFacturaPuntoVentaParameterReturnGeneral detallefacturapuntoventaParameterGeneral,Boolean isEsNuevoDetalleFacturaPuntoVenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-procesarEventosDetalleFacturaPuntoVentasWithConnection");connexion.begin();			
			
			DetalleFacturaPuntoVentaParameterReturnGeneral detallefacturapuntoventaReturnGeneral=new DetalleFacturaPuntoVentaParameterReturnGeneral();
	
			detallefacturapuntoventaReturnGeneral.setDetalleFacturaPuntoVenta(detallefacturapuntoventa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallefacturapuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleFacturaPuntoVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallefacturapuntoventas,detallefacturapuntoventa,detallefacturapuntoventaParameterGeneral,detallefacturapuntoventaReturnGeneral,isEsNuevoDetalleFacturaPuntoVenta,clases);
			
			this.connexion.commit();
			
			return detallefacturapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleFacturaPuntoVentaParameterReturnGeneral procesarImportacionDetalleFacturaPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleFacturaPuntoVentaParameterReturnGeneral detallefacturapuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-procesarImportacionDetalleFacturaPuntoVentasWithConnection");connexion.begin();			
			
			DetalleFacturaPuntoVentaParameterReturnGeneral detallefacturapuntoventaReturnGeneral=new DetalleFacturaPuntoVentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detallefacturapuntoventas=new ArrayList<DetalleFacturaPuntoVenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detallefacturapuntoventa=new DetalleFacturaPuntoVenta();
				
				
				if(conColumnasBase) {this.detallefacturapuntoventa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detallefacturapuntoventa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detallefacturapuntoventa.setserie(arrColumnas[iColumn++]);
				this.detallefacturapuntoventa.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.detallefacturapuntoventa.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallefacturapuntoventa.setdescuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallefacturapuntoventa.setdescuento_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallefacturapuntoventa.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallefacturapuntoventa.setiva_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallefacturapuntoventa.setice(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallefacturapuntoventa.setice_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallefacturapuntoventa.setsub_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallefacturapuntoventa.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallefacturapuntoventa.setdescripcion(arrColumnas[iColumn++]);
				
				this.detallefacturapuntoventas.add(this.detallefacturapuntoventa);
			}
			
			this.saveDetalleFacturaPuntoVentas();
			
			this.connexion.commit();
			
			detallefacturapuntoventaReturnGeneral.setConRetornoEstaProcesado(true);
			detallefacturapuntoventaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detallefacturapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleFacturaPuntoVentasEliminados() throws Exception {				
		
		List<DetalleFacturaPuntoVenta> detallefacturapuntoventasAux= new ArrayList<DetalleFacturaPuntoVenta>();
		
		for(DetalleFacturaPuntoVenta detallefacturapuntoventa:detallefacturapuntoventas) {
			if(!detallefacturapuntoventa.getIsDeleted()) {
				detallefacturapuntoventasAux.add(detallefacturapuntoventa);
			}
		}
		
		detallefacturapuntoventas=detallefacturapuntoventasAux;
	}
	
	public void quitarDetalleFacturaPuntoVentasNulos() throws Exception {				
		
		List<DetalleFacturaPuntoVenta> detallefacturapuntoventasAux= new ArrayList<DetalleFacturaPuntoVenta>();
		
		for(DetalleFacturaPuntoVenta detallefacturapuntoventa : this.detallefacturapuntoventas) {
			if(detallefacturapuntoventa==null) {
				detallefacturapuntoventasAux.add(detallefacturapuntoventa);
			}
		}
		
		//this.detallefacturapuntoventas=detallefacturapuntoventasAux;
		
		this.detallefacturapuntoventas.removeAll(detallefacturapuntoventasAux);
	}
	
	public void getSetVersionRowDetalleFacturaPuntoVentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detallefacturapuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detallefacturapuntoventa.getIsDeleted() || (detallefacturapuntoventa.getIsChanged()&&!detallefacturapuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detallefacturapuntoventaDataAccess.getSetVersionRowDetalleFacturaPuntoVenta(connexion,detallefacturapuntoventa.getId());
				
				if(!detallefacturapuntoventa.getVersionRow().equals(timestamp)) {	
					detallefacturapuntoventa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detallefacturapuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleFacturaPuntoVenta()throws Exception {	
		
		if(detallefacturapuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detallefacturapuntoventa.getIsDeleted() || (detallefacturapuntoventa.getIsChanged()&&!detallefacturapuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detallefacturapuntoventaDataAccess.getSetVersionRowDetalleFacturaPuntoVenta(connexion,detallefacturapuntoventa.getId());
			
			try {							
				if(!detallefacturapuntoventa.getVersionRow().equals(timestamp)) {	
					detallefacturapuntoventa.setVersionRow(timestamp);
				}
				
				detallefacturapuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleFacturaPuntoVentasWithConnection()throws Exception {	
		if(detallefacturapuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleFacturaPuntoVenta detallefacturapuntoventaAux:detallefacturapuntoventas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detallefacturapuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallefacturapuntoventaAux.getIsDeleted() || (detallefacturapuntoventaAux.getIsChanged()&&!detallefacturapuntoventaAux.getIsNew())) {
						
						timestamp=detallefacturapuntoventaDataAccess.getSetVersionRowDetalleFacturaPuntoVenta(connexion,detallefacturapuntoventaAux.getId());
						
						if(!detallefacturapuntoventa.getVersionRow().equals(timestamp)) {	
							detallefacturapuntoventaAux.setVersionRow(timestamp);
						}
								
						detallefacturapuntoventaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleFacturaPuntoVentas()throws Exception {	
		if(detallefacturapuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleFacturaPuntoVenta detallefacturapuntoventaAux:detallefacturapuntoventas) {
					if(detallefacturapuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallefacturapuntoventaAux.getIsDeleted() || (detallefacturapuntoventaAux.getIsChanged()&&!detallefacturapuntoventaAux.getIsNew())) {
						
						timestamp=detallefacturapuntoventaDataAccess.getSetVersionRowDetalleFacturaPuntoVenta(connexion,detallefacturapuntoventaAux.getId());
						
						if(!detallefacturapuntoventaAux.getVersionRow().equals(timestamp)) {	
							detallefacturapuntoventaAux.setVersionRow(timestamp);
						}
						
													
						detallefacturapuntoventaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleFacturaPuntoVentaParameterReturnGeneral cargarCombosLoteForeignKeyDetalleFacturaPuntoVentaWithConnection(String finalQueryGlobalFacturaPuntoVenta,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad) throws Exception {
		DetalleFacturaPuntoVentaParameterReturnGeneral  detallefacturapuntoventaReturnGeneral =new DetalleFacturaPuntoVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleFacturaPuntoVentaWithConnection");connexion.begin();
			
			detallefacturapuntoventaReturnGeneral =new DetalleFacturaPuntoVentaParameterReturnGeneral();
			
			

			List<FacturaPuntoVenta> facturapuntoventasForeignKey=new ArrayList<FacturaPuntoVenta>();
			FacturaPuntoVentaLogic facturapuntoventaLogic=new FacturaPuntoVentaLogic();
			facturapuntoventaLogic.setConnexion(this.connexion);
			facturapuntoventaLogic.getFacturaPuntoVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFacturaPuntoVenta.equals("NONE")) {
				facturapuntoventaLogic.getTodosFacturaPuntoVentas(finalQueryGlobalFacturaPuntoVenta,new Pagination());
				facturapuntoventasForeignKey=facturapuntoventaLogic.getFacturaPuntoVentas();
			}

			detallefacturapuntoventaReturnGeneral.setfacturapuntoventasForeignKey(facturapuntoventasForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallefacturapuntoventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallefacturapuntoventaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallefacturapuntoventaReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallefacturapuntoventaReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallefacturapuntoventaReturnGeneral.setunidadsForeignKey(unidadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detallefacturapuntoventaReturnGeneral;
	}
	
	public DetalleFacturaPuntoVentaParameterReturnGeneral cargarCombosLoteForeignKeyDetalleFacturaPuntoVenta(String finalQueryGlobalFacturaPuntoVenta,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad) throws Exception {
		DetalleFacturaPuntoVentaParameterReturnGeneral  detallefacturapuntoventaReturnGeneral =new DetalleFacturaPuntoVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detallefacturapuntoventaReturnGeneral =new DetalleFacturaPuntoVentaParameterReturnGeneral();
			
			

			List<FacturaPuntoVenta> facturapuntoventasForeignKey=new ArrayList<FacturaPuntoVenta>();
			FacturaPuntoVentaLogic facturapuntoventaLogic=new FacturaPuntoVentaLogic();
			facturapuntoventaLogic.setConnexion(this.connexion);
			facturapuntoventaLogic.getFacturaPuntoVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFacturaPuntoVenta.equals("NONE")) {
				facturapuntoventaLogic.getTodosFacturaPuntoVentas(finalQueryGlobalFacturaPuntoVenta,new Pagination());
				facturapuntoventasForeignKey=facturapuntoventaLogic.getFacturaPuntoVentas();
			}

			detallefacturapuntoventaReturnGeneral.setfacturapuntoventasForeignKey(facturapuntoventasForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallefacturapuntoventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallefacturapuntoventaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallefacturapuntoventaReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallefacturapuntoventaReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallefacturapuntoventaReturnGeneral.setunidadsForeignKey(unidadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detallefacturapuntoventaReturnGeneral;
	}
	
	
	public void deepLoad(DetalleFacturaPuntoVenta detallefacturapuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleFacturaPuntoVentaLogicAdditional.updateDetalleFacturaPuntoVentaToGet(detallefacturapuntoventa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallefacturapuntoventa.setFacturaPuntoVenta(detallefacturapuntoventaDataAccess.getFacturaPuntoVenta(connexion,detallefacturapuntoventa));
		detallefacturapuntoventa.setEmpresa(detallefacturapuntoventaDataAccess.getEmpresa(connexion,detallefacturapuntoventa));
		detallefacturapuntoventa.setSucursal(detallefacturapuntoventaDataAccess.getSucursal(connexion,detallefacturapuntoventa));
		detallefacturapuntoventa.setBodega(detallefacturapuntoventaDataAccess.getBodega(connexion,detallefacturapuntoventa));
		detallefacturapuntoventa.setProducto(detallefacturapuntoventaDataAccess.getProducto(connexion,detallefacturapuntoventa));
		detallefacturapuntoventa.setUnidad(detallefacturapuntoventaDataAccess.getUnidad(connexion,detallefacturapuntoventa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)) {
				detallefacturapuntoventa.setFacturaPuntoVenta(detallefacturapuntoventaDataAccess.getFacturaPuntoVenta(connexion,detallefacturapuntoventa));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallefacturapuntoventa.setEmpresa(detallefacturapuntoventaDataAccess.getEmpresa(connexion,detallefacturapuntoventa));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallefacturapuntoventa.setSucursal(detallefacturapuntoventaDataAccess.getSucursal(connexion,detallefacturapuntoventa));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallefacturapuntoventa.setBodega(detallefacturapuntoventaDataAccess.getBodega(connexion,detallefacturapuntoventa));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallefacturapuntoventa.setProducto(detallefacturapuntoventaDataAccess.getProducto(connexion,detallefacturapuntoventa));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallefacturapuntoventa.setUnidad(detallefacturapuntoventaDataAccess.getUnidad(connexion,detallefacturapuntoventa));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturapuntoventa.setFacturaPuntoVenta(detallefacturapuntoventaDataAccess.getFacturaPuntoVenta(connexion,detallefacturapuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturapuntoventa.setEmpresa(detallefacturapuntoventaDataAccess.getEmpresa(connexion,detallefacturapuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturapuntoventa.setSucursal(detallefacturapuntoventaDataAccess.getSucursal(connexion,detallefacturapuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturapuntoventa.setBodega(detallefacturapuntoventaDataAccess.getBodega(connexion,detallefacturapuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturapuntoventa.setProducto(detallefacturapuntoventaDataAccess.getProducto(connexion,detallefacturapuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturapuntoventa.setUnidad(detallefacturapuntoventaDataAccess.getUnidad(connexion,detallefacturapuntoventa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallefacturapuntoventa.setFacturaPuntoVenta(detallefacturapuntoventaDataAccess.getFacturaPuntoVenta(connexion,detallefacturapuntoventa));
		FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
		facturapuntoventaLogic.deepLoad(detallefacturapuntoventa.getFacturaPuntoVenta(),isDeep,deepLoadType,clases);
				
		detallefacturapuntoventa.setEmpresa(detallefacturapuntoventaDataAccess.getEmpresa(connexion,detallefacturapuntoventa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallefacturapuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		detallefacturapuntoventa.setSucursal(detallefacturapuntoventaDataAccess.getSucursal(connexion,detallefacturapuntoventa));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallefacturapuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				
		detallefacturapuntoventa.setBodega(detallefacturapuntoventaDataAccess.getBodega(connexion,detallefacturapuntoventa));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallefacturapuntoventa.getBodega(),isDeep,deepLoadType,clases);
				
		detallefacturapuntoventa.setProducto(detallefacturapuntoventaDataAccess.getProducto(connexion,detallefacturapuntoventa));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallefacturapuntoventa.getProducto(),isDeep,deepLoadType,clases);
				
		detallefacturapuntoventa.setUnidad(detallefacturapuntoventaDataAccess.getUnidad(connexion,detallefacturapuntoventa));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallefacturapuntoventa.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)) {
				detallefacturapuntoventa.setFacturaPuntoVenta(detallefacturapuntoventaDataAccess.getFacturaPuntoVenta(connexion,detallefacturapuntoventa));
				FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
				facturapuntoventaLogic.deepLoad(detallefacturapuntoventa.getFacturaPuntoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallefacturapuntoventa.setEmpresa(detallefacturapuntoventaDataAccess.getEmpresa(connexion,detallefacturapuntoventa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detallefacturapuntoventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallefacturapuntoventa.setSucursal(detallefacturapuntoventaDataAccess.getSucursal(connexion,detallefacturapuntoventa));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detallefacturapuntoventa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallefacturapuntoventa.setBodega(detallefacturapuntoventaDataAccess.getBodega(connexion,detallefacturapuntoventa));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detallefacturapuntoventa.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallefacturapuntoventa.setProducto(detallefacturapuntoventaDataAccess.getProducto(connexion,detallefacturapuntoventa));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detallefacturapuntoventa.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallefacturapuntoventa.setUnidad(detallefacturapuntoventaDataAccess.getUnidad(connexion,detallefacturapuntoventa));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detallefacturapuntoventa.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturapuntoventa.setFacturaPuntoVenta(detallefacturapuntoventaDataAccess.getFacturaPuntoVenta(connexion,detallefacturapuntoventa));
			FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
			facturapuntoventaLogic.deepLoad(detallefacturapuntoventa.getFacturaPuntoVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturapuntoventa.setEmpresa(detallefacturapuntoventaDataAccess.getEmpresa(connexion,detallefacturapuntoventa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detallefacturapuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturapuntoventa.setSucursal(detallefacturapuntoventaDataAccess.getSucursal(connexion,detallefacturapuntoventa));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detallefacturapuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturapuntoventa.setBodega(detallefacturapuntoventaDataAccess.getBodega(connexion,detallefacturapuntoventa));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detallefacturapuntoventa.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturapuntoventa.setProducto(detallefacturapuntoventaDataAccess.getProducto(connexion,detallefacturapuntoventa));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detallefacturapuntoventa.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturapuntoventa.setUnidad(detallefacturapuntoventaDataAccess.getUnidad(connexion,detallefacturapuntoventa));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detallefacturapuntoventa.getUnidad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleFacturaPuntoVenta detallefacturapuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleFacturaPuntoVentaLogicAdditional.updateDetalleFacturaPuntoVentaToSave(detallefacturapuntoventa,this.arrDatoGeneral);
			
DetalleFacturaPuntoVentaDataAccess.save(detallefacturapuntoventa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		FacturaPuntoVentaDataAccess.save(detallefacturapuntoventa.getFacturaPuntoVenta(),connexion);

		EmpresaDataAccess.save(detallefacturapuntoventa.getEmpresa(),connexion);

		SucursalDataAccess.save(detallefacturapuntoventa.getSucursal(),connexion);

		BodegaDataAccess.save(detallefacturapuntoventa.getBodega(),connexion);

		ProductoDataAccess.save(detallefacturapuntoventa.getProducto(),connexion);

		UnidadDataAccess.save(detallefacturapuntoventa.getUnidad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)) {
				FacturaPuntoVentaDataAccess.save(detallefacturapuntoventa.getFacturaPuntoVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallefacturapuntoventa.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallefacturapuntoventa.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallefacturapuntoventa.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallefacturapuntoventa.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallefacturapuntoventa.getUnidad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		FacturaPuntoVentaDataAccess.save(detallefacturapuntoventa.getFacturaPuntoVenta(),connexion);
		FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
		facturapuntoventaLogic.deepLoad(detallefacturapuntoventa.getFacturaPuntoVenta(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(detallefacturapuntoventa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallefacturapuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detallefacturapuntoventa.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallefacturapuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detallefacturapuntoventa.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallefacturapuntoventa.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detallefacturapuntoventa.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallefacturapuntoventa.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detallefacturapuntoventa.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallefacturapuntoventa.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)) {
				FacturaPuntoVentaDataAccess.save(detallefacturapuntoventa.getFacturaPuntoVenta(),connexion);
				FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
				facturapuntoventaLogic.deepSave(detallefacturapuntoventa.getFacturaPuntoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallefacturapuntoventa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detallefacturapuntoventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallefacturapuntoventa.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detallefacturapuntoventa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallefacturapuntoventa.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detallefacturapuntoventa.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallefacturapuntoventa.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detallefacturapuntoventa.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallefacturapuntoventa.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detallefacturapuntoventa.getUnidad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleFacturaPuntoVenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detallefacturapuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(detallefacturapuntoventa);
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
			this.deepLoad(this.detallefacturapuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleFacturaPuntoVenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detallefacturapuntoventas!=null) {
				for(DetalleFacturaPuntoVenta detallefacturapuntoventa:detallefacturapuntoventas) {
					this.deepLoad(detallefacturapuntoventa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(detallefacturapuntoventas);
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
			if(detallefacturapuntoventas!=null) {
				for(DetalleFacturaPuntoVenta detallefacturapuntoventa:detallefacturapuntoventas) {
					this.deepLoad(detallefacturapuntoventa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(detallefacturapuntoventas);
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
			this.getNewConnexionToDeep(DetalleFacturaPuntoVenta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detallefacturapuntoventa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleFacturaPuntoVenta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detallefacturapuntoventas!=null) {
				for(DetalleFacturaPuntoVenta detallefacturapuntoventa:detallefacturapuntoventas) {
					this.deepSave(detallefacturapuntoventa,isDeep,deepLoadType,clases);
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
			if(detallefacturapuntoventas!=null) {
				for(DetalleFacturaPuntoVenta detallefacturapuntoventa:detallefacturapuntoventas) {
					this.deepSave(detallefacturapuntoventa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleFacturaPuntoVentasFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleFacturaPuntoVentaConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFacturaPuntoVentasFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleFacturaPuntoVentaConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleFacturaPuntoVentasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleFacturaPuntoVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFacturaPuntoVentasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleFacturaPuntoVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleFacturaPuntoVentasFK_IdFacturaPuntoVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura_punto_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFacturaPuntoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFacturaPuntoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura_punto_venta,DetalleFacturaPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFacturaPuntoVenta);

			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFacturaPuntoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFacturaPuntoVentasFK_IdFacturaPuntoVenta(String sFinalQuery,Pagination pagination,Long id_factura_punto_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFacturaPuntoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFacturaPuntoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura_punto_venta,DetalleFacturaPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFacturaPuntoVenta);

			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFacturaPuntoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleFacturaPuntoVentasFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleFacturaPuntoVentaConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFacturaPuntoVentasFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleFacturaPuntoVentaConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleFacturaPuntoVentasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleFacturaPuntoVentaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFacturaPuntoVentasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleFacturaPuntoVentaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleFacturaPuntoVentasFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleFacturaPuntoVentaConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFacturaPuntoVentasFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleFacturaPuntoVentaConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturapuntoventas=detallefacturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(this.detallefacturapuntoventas);
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
			if(DetalleFacturaPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleFacturaPuntoVentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleFacturaPuntoVenta detallefacturapuntoventa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleFacturaPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				if(detallefacturapuntoventa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleFacturaPuntoVentaDataAccess.TABLENAME, detallefacturapuntoventa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleFacturaPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleFacturaPuntoVentaLogic.registrarAuditoriaDetallesDetalleFacturaPuntoVenta(connexion,detallefacturapuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detallefacturapuntoventa.getIsDeleted()) {
					/*if(!detallefacturapuntoventa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleFacturaPuntoVentaDataAccess.TABLENAME, detallefacturapuntoventa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleFacturaPuntoVentaLogic.registrarAuditoriaDetallesDetalleFacturaPuntoVenta(connexion,detallefacturapuntoventa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleFacturaPuntoVentaDataAccess.TABLENAME, detallefacturapuntoventa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detallefacturapuntoventa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleFacturaPuntoVentaDataAccess.TABLENAME, detallefacturapuntoventa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleFacturaPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleFacturaPuntoVentaLogic.registrarAuditoriaDetallesDetalleFacturaPuntoVenta(connexion,detallefacturapuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleFacturaPuntoVenta(Connexion connexion,DetalleFacturaPuntoVenta detallefacturapuntoventa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detallefacturapuntoventa.getIsNew()||!detallefacturapuntoventa.getid_factura_punto_venta().equals(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getid_factura_punto_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getid_factura_punto_venta()!=null)
				{
					strValorActual=detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getid_factura_punto_venta().toString();
				}
				if(detallefacturapuntoventa.getid_factura_punto_venta()!=null)
				{
					strValorNuevo=detallefacturapuntoventa.getid_factura_punto_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturapuntoventa.getIsNew()||!detallefacturapuntoventa.getid_empresa().equals(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getid_empresa()!=null)
				{
					strValorActual=detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getid_empresa().toString();
				}
				if(detallefacturapuntoventa.getid_empresa()!=null)
				{
					strValorNuevo=detallefacturapuntoventa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaPuntoVentaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturapuntoventa.getIsNew()||!detallefacturapuntoventa.getid_sucursal().equals(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getid_sucursal()!=null)
				{
					strValorActual=detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getid_sucursal().toString();
				}
				if(detallefacturapuntoventa.getid_sucursal()!=null)
				{
					strValorNuevo=detallefacturapuntoventa.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaPuntoVentaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturapuntoventa.getIsNew()||!detallefacturapuntoventa.getid_bodega().equals(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getid_bodega()!=null)
				{
					strValorActual=detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getid_bodega().toString();
				}
				if(detallefacturapuntoventa.getid_bodega()!=null)
				{
					strValorNuevo=detallefacturapuntoventa.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaPuntoVentaConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturapuntoventa.getIsNew()||!detallefacturapuntoventa.getid_producto().equals(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getid_producto()!=null)
				{
					strValorActual=detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getid_producto().toString();
				}
				if(detallefacturapuntoventa.getid_producto()!=null)
				{
					strValorNuevo=detallefacturapuntoventa.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaPuntoVentaConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturapuntoventa.getIsNew()||!detallefacturapuntoventa.getid_unidad().equals(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getid_unidad()!=null)
				{
					strValorActual=detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getid_unidad().toString();
				}
				if(detallefacturapuntoventa.getid_unidad()!=null)
				{
					strValorNuevo=detallefacturapuntoventa.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaPuntoVentaConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturapuntoventa.getIsNew()||!detallefacturapuntoventa.getserie().equals(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getserie()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getserie()!=null)
				{
					strValorActual=detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getserie();
				}
				if(detallefacturapuntoventa.getserie()!=null)
				{
					strValorNuevo=detallefacturapuntoventa.getserie() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaPuntoVentaConstantesFunciones.SERIE,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturapuntoventa.getIsNew()||!detallefacturapuntoventa.getcantidad().equals(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getcantidad()!=null)
				{
					strValorActual=detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getcantidad().toString();
				}
				if(detallefacturapuntoventa.getcantidad()!=null)
				{
					strValorNuevo=detallefacturapuntoventa.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaPuntoVentaConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturapuntoventa.getIsNew()||!detallefacturapuntoventa.getprecio().equals(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getprecio()!=null)
				{
					strValorActual=detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getprecio().toString();
				}
				if(detallefacturapuntoventa.getprecio()!=null)
				{
					strValorNuevo=detallefacturapuntoventa.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaPuntoVentaConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturapuntoventa.getIsNew()||!detallefacturapuntoventa.getdescuento().equals(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getdescuento()!=null)
				{
					strValorActual=detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getdescuento().toString();
				}
				if(detallefacturapuntoventa.getdescuento()!=null)
				{
					strValorNuevo=detallefacturapuntoventa.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturapuntoventa.getIsNew()||!detallefacturapuntoventa.getdescuento_valor().equals(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getdescuento_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getdescuento_valor()!=null)
				{
					strValorActual=detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getdescuento_valor().toString();
				}
				if(detallefacturapuntoventa.getdescuento_valor()!=null)
				{
					strValorNuevo=detallefacturapuntoventa.getdescuento_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTOVALOR,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturapuntoventa.getIsNew()||!detallefacturapuntoventa.getiva().equals(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getiva()!=null)
				{
					strValorActual=detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getiva().toString();
				}
				if(detallefacturapuntoventa.getiva()!=null)
				{
					strValorNuevo=detallefacturapuntoventa.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaPuntoVentaConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturapuntoventa.getIsNew()||!detallefacturapuntoventa.getiva_valor().equals(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getiva_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getiva_valor()!=null)
				{
					strValorActual=detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getiva_valor().toString();
				}
				if(detallefacturapuntoventa.getiva_valor()!=null)
				{
					strValorNuevo=detallefacturapuntoventa.getiva_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaPuntoVentaConstantesFunciones.IVAVALOR,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturapuntoventa.getIsNew()||!detallefacturapuntoventa.getice().equals(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getice()!=null)
				{
					strValorActual=detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getice().toString();
				}
				if(detallefacturapuntoventa.getice()!=null)
				{
					strValorNuevo=detallefacturapuntoventa.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaPuntoVentaConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturapuntoventa.getIsNew()||!detallefacturapuntoventa.getice_valor().equals(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getice_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getice_valor()!=null)
				{
					strValorActual=detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getice_valor().toString();
				}
				if(detallefacturapuntoventa.getice_valor()!=null)
				{
					strValorNuevo=detallefacturapuntoventa.getice_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaPuntoVentaConstantesFunciones.ICEVALOR,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturapuntoventa.getIsNew()||!detallefacturapuntoventa.getsub_total().equals(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getsub_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getsub_total()!=null)
				{
					strValorActual=detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getsub_total().toString();
				}
				if(detallefacturapuntoventa.getsub_total()!=null)
				{
					strValorNuevo=detallefacturapuntoventa.getsub_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaPuntoVentaConstantesFunciones.SUBTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturapuntoventa.getIsNew()||!detallefacturapuntoventa.gettotal().equals(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().gettotal()!=null)
				{
					strValorActual=detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().gettotal().toString();
				}
				if(detallefacturapuntoventa.gettotal()!=null)
				{
					strValorNuevo=detallefacturapuntoventa.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaPuntoVentaConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturapuntoventa.getIsNew()||!detallefacturapuntoventa.getdescripcion().equals(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getdescripcion()!=null)
				{
					strValorActual=detallefacturapuntoventa.getDetalleFacturaPuntoVentaOriginal().getdescripcion();
				}
				if(detallefacturapuntoventa.getdescripcion()!=null)
				{
					strValorNuevo=detallefacturapuntoventa.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaPuntoVentaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleFacturaPuntoVentaRelacionesWithConnection(DetalleFacturaPuntoVenta detallefacturapuntoventa) throws Exception {

		if(!detallefacturapuntoventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleFacturaPuntoVentaRelacionesBase(detallefacturapuntoventa,true);
		}
	}

	public void saveDetalleFacturaPuntoVentaRelaciones(DetalleFacturaPuntoVenta detallefacturapuntoventa)throws Exception {

		if(!detallefacturapuntoventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleFacturaPuntoVentaRelacionesBase(detallefacturapuntoventa,false);
		}
	}

	public void saveDetalleFacturaPuntoVentaRelacionesBase(DetalleFacturaPuntoVenta detallefacturapuntoventa,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleFacturaPuntoVenta-saveRelacionesWithConnection");}
	

			this.setDetalleFacturaPuntoVenta(detallefacturapuntoventa);

			if(DetalleFacturaPuntoVentaLogicAdditional.validarSaveRelaciones(detallefacturapuntoventa,this)) {

				DetalleFacturaPuntoVentaLogicAdditional.updateRelacionesToSave(detallefacturapuntoventa,this);

				if((detallefacturapuntoventa.getIsNew()||detallefacturapuntoventa.getIsChanged())&&!detallefacturapuntoventa.getIsDeleted()) {
					this.saveDetalleFacturaPuntoVenta();
					this.saveDetalleFacturaPuntoVentaRelacionesDetalles();

				} else if(detallefacturapuntoventa.getIsDeleted()) {
					this.saveDetalleFacturaPuntoVentaRelacionesDetalles();
					this.saveDetalleFacturaPuntoVenta();
				}

				DetalleFacturaPuntoVentaLogicAdditional.updateRelacionesToSaveAfter(detallefacturapuntoventa,this);

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
	
	
	private void saveDetalleFacturaPuntoVentaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleFacturaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleFacturaPuntoVentaConstantesFunciones.getClassesForeignKeysOfDetalleFacturaPuntoVenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleFacturaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleFacturaPuntoVentaConstantesFunciones.getClassesRelationshipsOfDetalleFacturaPuntoVenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

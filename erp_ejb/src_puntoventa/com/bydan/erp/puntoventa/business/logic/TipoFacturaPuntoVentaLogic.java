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
import com.bydan.erp.puntoventa.util.TipoFacturaPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.TipoFacturaPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.TipoFacturaPuntoVentaParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.TipoFacturaPuntoVenta;
//import com.bydan.erp.puntoventa.business.logic.TipoFacturaPuntoVentaLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoFacturaPuntoVentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoFacturaPuntoVentaLogic.class);
	
	protected TipoFacturaPuntoVentaDataAccess tipofacturapuntoventaDataAccess; 	
	protected TipoFacturaPuntoVenta tipofacturapuntoventa;
	protected List<TipoFacturaPuntoVenta> tipofacturapuntoventas;
	protected Object tipofacturapuntoventaObject;	
	protected List<Object> tipofacturapuntoventasObject;
	
	public static ClassValidator<TipoFacturaPuntoVenta> tipofacturapuntoventaValidator = new ClassValidator<TipoFacturaPuntoVenta>(TipoFacturaPuntoVenta.class);	
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
	
	
	
	
	public  TipoFacturaPuntoVentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipofacturapuntoventaDataAccess = new TipoFacturaPuntoVentaDataAccess();
			
			this.tipofacturapuntoventas= new ArrayList<TipoFacturaPuntoVenta>();
			this.tipofacturapuntoventa= new TipoFacturaPuntoVenta();
			
			this.tipofacturapuntoventaObject=new Object();
			this.tipofacturapuntoventasObject=new ArrayList<Object>();
				
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
			
			this.tipofacturapuntoventaDataAccess.setConnexionType(this.connexionType);
			this.tipofacturapuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoFacturaPuntoVentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipofacturapuntoventaDataAccess = new TipoFacturaPuntoVentaDataAccess();
			this.tipofacturapuntoventas= new ArrayList<TipoFacturaPuntoVenta>();
			this.tipofacturapuntoventa= new TipoFacturaPuntoVenta();
			this.tipofacturapuntoventaObject=new Object();
			this.tipofacturapuntoventasObject=new ArrayList<Object>();
			
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
			
			this.tipofacturapuntoventaDataAccess.setConnexionType(this.connexionType);
			this.tipofacturapuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoFacturaPuntoVenta getTipoFacturaPuntoVenta() throws Exception {	
		//TipoFacturaPuntoVentaLogicAdditional.checkTipoFacturaPuntoVentaToGet(tipofacturapuntoventa,this.datosCliente,this.arrDatoGeneral);
		//TipoFacturaPuntoVentaLogicAdditional.updateTipoFacturaPuntoVentaToGet(tipofacturapuntoventa,this.arrDatoGeneral);
		
		return tipofacturapuntoventa;
	}
		
	public void setTipoFacturaPuntoVenta(TipoFacturaPuntoVenta newTipoFacturaPuntoVenta) {
		this.tipofacturapuntoventa = newTipoFacturaPuntoVenta;
	}
	
	public TipoFacturaPuntoVentaDataAccess getTipoFacturaPuntoVentaDataAccess() {
		return tipofacturapuntoventaDataAccess;
	}
	
	public void setTipoFacturaPuntoVentaDataAccess(TipoFacturaPuntoVentaDataAccess newtipofacturapuntoventaDataAccess) {
		this.tipofacturapuntoventaDataAccess = newtipofacturapuntoventaDataAccess;
	}
	
	public List<TipoFacturaPuntoVenta> getTipoFacturaPuntoVentas() throws Exception {		
		this.quitarTipoFacturaPuntoVentasNulos();
		
		//TipoFacturaPuntoVentaLogicAdditional.checkTipoFacturaPuntoVentaToGets(tipofacturapuntoventas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoFacturaPuntoVenta tipofacturapuntoventaLocal: tipofacturapuntoventas ) {
			//TipoFacturaPuntoVentaLogicAdditional.updateTipoFacturaPuntoVentaToGet(tipofacturapuntoventaLocal,this.arrDatoGeneral);
		}
		
		return tipofacturapuntoventas;
	}
	
	public void setTipoFacturaPuntoVentas(List<TipoFacturaPuntoVenta> newTipoFacturaPuntoVentas) {
		this.tipofacturapuntoventas = newTipoFacturaPuntoVentas;
	}
	
	public Object getTipoFacturaPuntoVentaObject() {	
		this.tipofacturapuntoventaObject=this.tipofacturapuntoventaDataAccess.getEntityObject();
		return this.tipofacturapuntoventaObject;
	}
		
	public void setTipoFacturaPuntoVentaObject(Object newTipoFacturaPuntoVentaObject) {
		this.tipofacturapuntoventaObject = newTipoFacturaPuntoVentaObject;
	}
	
	public List<Object> getTipoFacturaPuntoVentasObject() {		
		this.tipofacturapuntoventasObject=this.tipofacturapuntoventaDataAccess.getEntitiesObject();
		return this.tipofacturapuntoventasObject;
	}
		
	public void setTipoFacturaPuntoVentasObject(List<Object> newTipoFacturaPuntoVentasObject) {
		this.tipofacturapuntoventasObject = newTipoFacturaPuntoVentasObject;
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
		
		if(this.tipofacturapuntoventaDataAccess!=null) {
			this.tipofacturapuntoventaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFacturaPuntoVenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipofacturapuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipofacturapuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipofacturapuntoventa = new  TipoFacturaPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFacturaPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipofacturapuntoventa=tipofacturapuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipofacturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesTipoFacturaPuntoVenta(this.tipofacturapuntoventa);
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
		tipofacturapuntoventa = new  TipoFacturaPuntoVenta();
		  		  
        try {
			
			tipofacturapuntoventa=tipofacturapuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipofacturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesTipoFacturaPuntoVenta(this.tipofacturapuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipofacturapuntoventa = new  TipoFacturaPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFacturaPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipofacturapuntoventa=tipofacturapuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipofacturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesTipoFacturaPuntoVenta(this.tipofacturapuntoventa);
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
		tipofacturapuntoventa = new  TipoFacturaPuntoVenta();
		  		  
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
		tipofacturapuntoventa = new  TipoFacturaPuntoVenta();
		  		  
        try {
			
			tipofacturapuntoventa=tipofacturapuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipofacturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesTipoFacturaPuntoVenta(this.tipofacturapuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipofacturapuntoventa = new  TipoFacturaPuntoVenta();
		  		  
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
		tipofacturapuntoventa = new  TipoFacturaPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFacturaPuntoVenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipofacturapuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipofacturapuntoventa = new  TipoFacturaPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipofacturapuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipofacturapuntoventa = new  TipoFacturaPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFacturaPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipofacturapuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipofacturapuntoventa = new  TipoFacturaPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipofacturapuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipofacturapuntoventa = new  TipoFacturaPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFacturaPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipofacturapuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipofacturapuntoventa = new  TipoFacturaPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipofacturapuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipofacturapuntoventas = new  ArrayList<TipoFacturaPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFacturaPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipofacturapuntoventas=tipofacturapuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoFacturaPuntoVenta(tipofacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesTipoFacturaPuntoVenta(this.tipofacturapuntoventas);
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
		tipofacturapuntoventas = new  ArrayList<TipoFacturaPuntoVenta>();
		  		  
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
		tipofacturapuntoventas = new  ArrayList<TipoFacturaPuntoVenta>();
		  		  
        try {			
			TipoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipofacturapuntoventas=tipofacturapuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoFacturaPuntoVenta(tipofacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesTipoFacturaPuntoVenta(this.tipofacturapuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipofacturapuntoventas = new  ArrayList<TipoFacturaPuntoVenta>();
		  		  
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
		tipofacturapuntoventas = new  ArrayList<TipoFacturaPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFacturaPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipofacturapuntoventas=tipofacturapuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoFacturaPuntoVenta(tipofacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesTipoFacturaPuntoVenta(this.tipofacturapuntoventas);
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
		tipofacturapuntoventas = new  ArrayList<TipoFacturaPuntoVenta>();
		  		  
        try {
			TipoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipofacturapuntoventas=tipofacturapuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoFacturaPuntoVenta(tipofacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesTipoFacturaPuntoVenta(this.tipofacturapuntoventas);
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
		tipofacturapuntoventas = new  ArrayList<TipoFacturaPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFacturaPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipofacturapuntoventas=tipofacturapuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoFacturaPuntoVenta(tipofacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesTipoFacturaPuntoVenta(this.tipofacturapuntoventas);
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
		tipofacturapuntoventas = new  ArrayList<TipoFacturaPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipofacturapuntoventas=tipofacturapuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoFacturaPuntoVenta(tipofacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesTipoFacturaPuntoVenta(this.tipofacturapuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipofacturapuntoventa = new  TipoFacturaPuntoVenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFacturaPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipofacturapuntoventa=tipofacturapuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoFacturaPuntoVenta(tipofacturapuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesTipoFacturaPuntoVenta(this.tipofacturapuntoventa);
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
		tipofacturapuntoventa = new  TipoFacturaPuntoVenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipofacturapuntoventa=tipofacturapuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoFacturaPuntoVenta(tipofacturapuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesTipoFacturaPuntoVenta(this.tipofacturapuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoFacturaPuntoVentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipofacturapuntoventas = new  ArrayList<TipoFacturaPuntoVenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFacturaPuntoVenta.class.getSimpleName()+"-getTodosTipoFacturaPuntoVentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipofacturapuntoventas=tipofacturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoFacturaPuntoVenta(tipofacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesTipoFacturaPuntoVenta(this.tipofacturapuntoventas);
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
	
	public  void  getTodosTipoFacturaPuntoVentas(String sFinalQuery,Pagination pagination)throws Exception {
		tipofacturapuntoventas = new  ArrayList<TipoFacturaPuntoVenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipofacturapuntoventas=tipofacturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoFacturaPuntoVenta(tipofacturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesTipoFacturaPuntoVenta(this.tipofacturapuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoFacturaPuntoVenta(TipoFacturaPuntoVenta tipofacturapuntoventa) throws Exception {
		Boolean estaValidado=false;
		
		if(tipofacturapuntoventa.getIsNew() || tipofacturapuntoventa.getIsChanged()) { 
			this.invalidValues = tipofacturapuntoventaValidator.getInvalidValues(tipofacturapuntoventa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipofacturapuntoventa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoFacturaPuntoVenta(List<TipoFacturaPuntoVenta> TipoFacturaPuntoVentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoFacturaPuntoVenta tipofacturapuntoventaLocal:tipofacturapuntoventas) {				
			estaValidadoObjeto=this.validarGuardarTipoFacturaPuntoVenta(tipofacturapuntoventaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoFacturaPuntoVenta(List<TipoFacturaPuntoVenta> TipoFacturaPuntoVentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoFacturaPuntoVenta(tipofacturapuntoventas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoFacturaPuntoVenta(TipoFacturaPuntoVenta TipoFacturaPuntoVenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoFacturaPuntoVenta(tipofacturapuntoventa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoFacturaPuntoVenta tipofacturapuntoventa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipofacturapuntoventa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoFacturaPuntoVentaConstantesFunciones.getTipoFacturaPuntoVentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipofacturapuntoventa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoFacturaPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoFacturaPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoFacturaPuntoVentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFacturaPuntoVenta.class.getSimpleName()+"-saveTipoFacturaPuntoVentaWithConnection");connexion.begin();			
			
			//TipoFacturaPuntoVentaLogicAdditional.checkTipoFacturaPuntoVentaToSave(this.tipofacturapuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoFacturaPuntoVentaLogicAdditional.updateTipoFacturaPuntoVentaToSave(this.tipofacturapuntoventa,this.arrDatoGeneral);
			
			TipoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipofacturapuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoFacturaPuntoVenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoFacturaPuntoVenta(this.tipofacturapuntoventa)) {
				TipoFacturaPuntoVentaDataAccess.save(this.tipofacturapuntoventa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipofacturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoFacturaPuntoVentaLogicAdditional.checkTipoFacturaPuntoVentaToSaveAfter(this.tipofacturapuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoFacturaPuntoVenta();
			
			connexion.commit();			
			
			if(this.tipofacturapuntoventa.getIsDeleted()) {
				this.tipofacturapuntoventa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoFacturaPuntoVenta()throws Exception {	
		try {	
			
			//TipoFacturaPuntoVentaLogicAdditional.checkTipoFacturaPuntoVentaToSave(this.tipofacturapuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoFacturaPuntoVentaLogicAdditional.updateTipoFacturaPuntoVentaToSave(this.tipofacturapuntoventa,this.arrDatoGeneral);
			
			TipoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipofacturapuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoFacturaPuntoVenta(this.tipofacturapuntoventa)) {			
				TipoFacturaPuntoVentaDataAccess.save(this.tipofacturapuntoventa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipofacturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoFacturaPuntoVentaLogicAdditional.checkTipoFacturaPuntoVentaToSaveAfter(this.tipofacturapuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipofacturapuntoventa.getIsDeleted()) {
				this.tipofacturapuntoventa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoFacturaPuntoVentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFacturaPuntoVenta.class.getSimpleName()+"-saveTipoFacturaPuntoVentasWithConnection");connexion.begin();			
			
			//TipoFacturaPuntoVentaLogicAdditional.checkTipoFacturaPuntoVentaToSaves(tipofacturapuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoFacturaPuntoVentas();
			
			Boolean validadoTodosTipoFacturaPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoFacturaPuntoVenta tipofacturapuntoventaLocal:tipofacturapuntoventas) {		
				if(tipofacturapuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoFacturaPuntoVentaLogicAdditional.updateTipoFacturaPuntoVentaToSave(tipofacturapuntoventaLocal,this.arrDatoGeneral);
	        	
				TipoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipofacturapuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoFacturaPuntoVenta(tipofacturapuntoventaLocal)) {
					TipoFacturaPuntoVentaDataAccess.save(tipofacturapuntoventaLocal, connexion);				
				} else {
					validadoTodosTipoFacturaPuntoVenta=false;
				}
			}
			
			if(!validadoTodosTipoFacturaPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoFacturaPuntoVentaLogicAdditional.checkTipoFacturaPuntoVentaToSavesAfter(tipofacturapuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoFacturaPuntoVentas();
			
			connexion.commit();		
			
			this.quitarTipoFacturaPuntoVentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoFacturaPuntoVentas()throws Exception {				
		 try {	
			//TipoFacturaPuntoVentaLogicAdditional.checkTipoFacturaPuntoVentaToSaves(tipofacturapuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoFacturaPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoFacturaPuntoVenta tipofacturapuntoventaLocal:tipofacturapuntoventas) {				
				if(tipofacturapuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoFacturaPuntoVentaLogicAdditional.updateTipoFacturaPuntoVentaToSave(tipofacturapuntoventaLocal,this.arrDatoGeneral);
	        	
				TipoFacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipofacturapuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoFacturaPuntoVenta(tipofacturapuntoventaLocal)) {				
					TipoFacturaPuntoVentaDataAccess.save(tipofacturapuntoventaLocal, connexion);				
				} else {
					validadoTodosTipoFacturaPuntoVenta=false;
				}
			}
			
			if(!validadoTodosTipoFacturaPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoFacturaPuntoVentaLogicAdditional.checkTipoFacturaPuntoVentaToSavesAfter(tipofacturapuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoFacturaPuntoVentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoFacturaPuntoVentaParameterReturnGeneral procesarAccionTipoFacturaPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoFacturaPuntoVenta> tipofacturapuntoventas,TipoFacturaPuntoVentaParameterReturnGeneral tipofacturapuntoventaParameterGeneral)throws Exception {
		 try {	
			TipoFacturaPuntoVentaParameterReturnGeneral tipofacturapuntoventaReturnGeneral=new TipoFacturaPuntoVentaParameterReturnGeneral();
	
			
			return tipofacturapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoFacturaPuntoVentaParameterReturnGeneral procesarAccionTipoFacturaPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoFacturaPuntoVenta> tipofacturapuntoventas,TipoFacturaPuntoVentaParameterReturnGeneral tipofacturapuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFacturaPuntoVenta.class.getSimpleName()+"-procesarAccionTipoFacturaPuntoVentasWithConnection");connexion.begin();			
			
			TipoFacturaPuntoVentaParameterReturnGeneral tipofacturapuntoventaReturnGeneral=new TipoFacturaPuntoVentaParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipofacturapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoFacturaPuntoVentaParameterReturnGeneral procesarEventosTipoFacturaPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoFacturaPuntoVenta> tipofacturapuntoventas,TipoFacturaPuntoVenta tipofacturapuntoventa,TipoFacturaPuntoVentaParameterReturnGeneral tipofacturapuntoventaParameterGeneral,Boolean isEsNuevoTipoFacturaPuntoVenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoFacturaPuntoVentaParameterReturnGeneral tipofacturapuntoventaReturnGeneral=new TipoFacturaPuntoVentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipofacturapuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipofacturapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoFacturaPuntoVentaParameterReturnGeneral procesarEventosTipoFacturaPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoFacturaPuntoVenta> tipofacturapuntoventas,TipoFacturaPuntoVenta tipofacturapuntoventa,TipoFacturaPuntoVentaParameterReturnGeneral tipofacturapuntoventaParameterGeneral,Boolean isEsNuevoTipoFacturaPuntoVenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFacturaPuntoVenta.class.getSimpleName()+"-procesarEventosTipoFacturaPuntoVentasWithConnection");connexion.begin();			
			
			TipoFacturaPuntoVentaParameterReturnGeneral tipofacturapuntoventaReturnGeneral=new TipoFacturaPuntoVentaParameterReturnGeneral();
	
			tipofacturapuntoventaReturnGeneral.setTipoFacturaPuntoVenta(tipofacturapuntoventa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipofacturapuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipofacturapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoFacturaPuntoVentaParameterReturnGeneral procesarImportacionTipoFacturaPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoFacturaPuntoVentaParameterReturnGeneral tipofacturapuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFacturaPuntoVenta.class.getSimpleName()+"-procesarImportacionTipoFacturaPuntoVentasWithConnection");connexion.begin();			
			
			TipoFacturaPuntoVentaParameterReturnGeneral tipofacturapuntoventaReturnGeneral=new TipoFacturaPuntoVentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipofacturapuntoventas=new ArrayList<TipoFacturaPuntoVenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipofacturapuntoventa=new TipoFacturaPuntoVenta();
				
				
				if(conColumnasBase) {this.tipofacturapuntoventa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipofacturapuntoventa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipofacturapuntoventa.setnombre(arrColumnas[iColumn++]);
				this.tipofacturapuntoventa.setdescripcion(arrColumnas[iColumn++]);
				
				this.tipofacturapuntoventas.add(this.tipofacturapuntoventa);
			}
			
			this.saveTipoFacturaPuntoVentas();
			
			this.connexion.commit();
			
			tipofacturapuntoventaReturnGeneral.setConRetornoEstaProcesado(true);
			tipofacturapuntoventaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipofacturapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoFacturaPuntoVentasEliminados() throws Exception {				
		
		List<TipoFacturaPuntoVenta> tipofacturapuntoventasAux= new ArrayList<TipoFacturaPuntoVenta>();
		
		for(TipoFacturaPuntoVenta tipofacturapuntoventa:tipofacturapuntoventas) {
			if(!tipofacturapuntoventa.getIsDeleted()) {
				tipofacturapuntoventasAux.add(tipofacturapuntoventa);
			}
		}
		
		tipofacturapuntoventas=tipofacturapuntoventasAux;
	}
	
	public void quitarTipoFacturaPuntoVentasNulos() throws Exception {				
		
		List<TipoFacturaPuntoVenta> tipofacturapuntoventasAux= new ArrayList<TipoFacturaPuntoVenta>();
		
		for(TipoFacturaPuntoVenta tipofacturapuntoventa : this.tipofacturapuntoventas) {
			if(tipofacturapuntoventa==null) {
				tipofacturapuntoventasAux.add(tipofacturapuntoventa);
			}
		}
		
		//this.tipofacturapuntoventas=tipofacturapuntoventasAux;
		
		this.tipofacturapuntoventas.removeAll(tipofacturapuntoventasAux);
	}
	
	public void getSetVersionRowTipoFacturaPuntoVentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipofacturapuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipofacturapuntoventa.getIsDeleted() || (tipofacturapuntoventa.getIsChanged()&&!tipofacturapuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipofacturapuntoventaDataAccess.getSetVersionRowTipoFacturaPuntoVenta(connexion,tipofacturapuntoventa.getId());
				
				if(!tipofacturapuntoventa.getVersionRow().equals(timestamp)) {	
					tipofacturapuntoventa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipofacturapuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoFacturaPuntoVenta()throws Exception {	
		
		if(tipofacturapuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipofacturapuntoventa.getIsDeleted() || (tipofacturapuntoventa.getIsChanged()&&!tipofacturapuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipofacturapuntoventaDataAccess.getSetVersionRowTipoFacturaPuntoVenta(connexion,tipofacturapuntoventa.getId());
			
			try {							
				if(!tipofacturapuntoventa.getVersionRow().equals(timestamp)) {	
					tipofacturapuntoventa.setVersionRow(timestamp);
				}
				
				tipofacturapuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoFacturaPuntoVentasWithConnection()throws Exception {	
		if(tipofacturapuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoFacturaPuntoVenta tipofacturapuntoventaAux:tipofacturapuntoventas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipofacturapuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipofacturapuntoventaAux.getIsDeleted() || (tipofacturapuntoventaAux.getIsChanged()&&!tipofacturapuntoventaAux.getIsNew())) {
						
						timestamp=tipofacturapuntoventaDataAccess.getSetVersionRowTipoFacturaPuntoVenta(connexion,tipofacturapuntoventaAux.getId());
						
						if(!tipofacturapuntoventa.getVersionRow().equals(timestamp)) {	
							tipofacturapuntoventaAux.setVersionRow(timestamp);
						}
								
						tipofacturapuntoventaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoFacturaPuntoVentas()throws Exception {	
		if(tipofacturapuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoFacturaPuntoVenta tipofacturapuntoventaAux:tipofacturapuntoventas) {
					if(tipofacturapuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipofacturapuntoventaAux.getIsDeleted() || (tipofacturapuntoventaAux.getIsChanged()&&!tipofacturapuntoventaAux.getIsNew())) {
						
						timestamp=tipofacturapuntoventaDataAccess.getSetVersionRowTipoFacturaPuntoVenta(connexion,tipofacturapuntoventaAux.getId());
						
						if(!tipofacturapuntoventaAux.getVersionRow().equals(timestamp)) {	
							tipofacturapuntoventaAux.setVersionRow(timestamp);
						}
						
													
						tipofacturapuntoventaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoFacturaPuntoVentaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			FacturaPuntoVentaLogic facturapuntoventaLogic=new FacturaPuntoVentaLogic();
			NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic=new NotaCreditoPuntoVentaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFacturaPuntoVenta.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoFacturaPuntoVentaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(FacturaPuntoVenta.class));
			classes.add(new Classe(NotaCreditoPuntoVenta.class));
											
			

			facturapuntoventaLogic.setConnexion(this.getConnexion());
			facturapuntoventaLogic.setDatosCliente(this.datosCliente);
			facturapuntoventaLogic.setIsConRefrescarForeignKeys(true);

			notacreditopuntoventaLogic.setConnexion(this.getConnexion());
			notacreditopuntoventaLogic.setDatosCliente(this.datosCliente);
			notacreditopuntoventaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoFacturaPuntoVenta tipofacturapuntoventa:this.tipofacturapuntoventas) {
				

				classes=new ArrayList<Classe>();
				classes=FacturaPuntoVentaConstantesFunciones.getClassesForeignKeysOfFacturaPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				facturapuntoventaLogic.setFacturaPuntoVentas(tipofacturapuntoventa.facturapuntoventas);
				facturapuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=NotaCreditoPuntoVentaConstantesFunciones.getClassesForeignKeysOfNotaCreditoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				notacreditopuntoventaLogic.setNotaCreditoPuntoVentas(tipofacturapuntoventa.notacreditopuntoventas);
				notacreditopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoFacturaPuntoVenta tipofacturapuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoFacturaPuntoVentaLogicAdditional.updateTipoFacturaPuntoVentaToGet(tipofacturapuntoventa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipofacturapuntoventa.setFacturaPuntoVentas(tipofacturapuntoventaDataAccess.getFacturaPuntoVentas(connexion,tipofacturapuntoventa));
		tipofacturapuntoventa.setNotaCreditoPuntoVentas(tipofacturapuntoventaDataAccess.getNotaCreditoPuntoVentas(connexion,tipofacturapuntoventa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipofacturapuntoventa.setFacturaPuntoVentas(tipofacturapuntoventaDataAccess.getFacturaPuntoVentas(connexion,tipofacturapuntoventa));

				if(this.isConDeep) {
					FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(this.connexion);
					facturapuntoventaLogic.setFacturaPuntoVentas(tipofacturapuntoventa.getFacturaPuntoVentas());
					ArrayList<Classe> classesLocal=FacturaPuntoVentaConstantesFunciones.getClassesForeignKeysOfFacturaPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					facturapuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(facturapuntoventaLogic.getFacturaPuntoVentas());
					tipofacturapuntoventa.setFacturaPuntoVentas(facturapuntoventaLogic.getFacturaPuntoVentas());
				}

				continue;
			}

			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipofacturapuntoventa.setNotaCreditoPuntoVentas(tipofacturapuntoventaDataAccess.getNotaCreditoPuntoVentas(connexion,tipofacturapuntoventa));

				if(this.isConDeep) {
					NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(this.connexion);
					notacreditopuntoventaLogic.setNotaCreditoPuntoVentas(tipofacturapuntoventa.getNotaCreditoPuntoVentas());
					ArrayList<Classe> classesLocal=NotaCreditoPuntoVentaConstantesFunciones.getClassesForeignKeysOfNotaCreditoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					notacreditopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(notacreditopuntoventaLogic.getNotaCreditoPuntoVentas());
					tipofacturapuntoventa.setNotaCreditoPuntoVentas(notacreditopuntoventaLogic.getNotaCreditoPuntoVentas());
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
			tipofacturapuntoventa.setFacturaPuntoVentas(tipofacturapuntoventaDataAccess.getFacturaPuntoVentas(connexion,tipofacturapuntoventa));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoPuntoVenta.class));
			tipofacturapuntoventa.setNotaCreditoPuntoVentas(tipofacturapuntoventaDataAccess.getNotaCreditoPuntoVentas(connexion,tipofacturapuntoventa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipofacturapuntoventa.setFacturaPuntoVentas(tipofacturapuntoventaDataAccess.getFacturaPuntoVentas(connexion,tipofacturapuntoventa));

		for(FacturaPuntoVenta facturapuntoventa:tipofacturapuntoventa.getFacturaPuntoVentas()) {
			FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
			facturapuntoventaLogic.deepLoad(facturapuntoventa,isDeep,deepLoadType,clases);
		}

		tipofacturapuntoventa.setNotaCreditoPuntoVentas(tipofacturapuntoventaDataAccess.getNotaCreditoPuntoVentas(connexion,tipofacturapuntoventa));

		for(NotaCreditoPuntoVenta notacreditopuntoventa:tipofacturapuntoventa.getNotaCreditoPuntoVentas()) {
			NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
			notacreditopuntoventaLogic.deepLoad(notacreditopuntoventa,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipofacturapuntoventa.setFacturaPuntoVentas(tipofacturapuntoventaDataAccess.getFacturaPuntoVentas(connexion,tipofacturapuntoventa));

				for(FacturaPuntoVenta facturapuntoventa:tipofacturapuntoventa.getFacturaPuntoVentas()) {
					FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
					facturapuntoventaLogic.deepLoad(facturapuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipofacturapuntoventa.setNotaCreditoPuntoVentas(tipofacturapuntoventaDataAccess.getNotaCreditoPuntoVentas(connexion,tipofacturapuntoventa));

				for(NotaCreditoPuntoVenta notacreditopuntoventa:tipofacturapuntoventa.getNotaCreditoPuntoVentas()) {
					NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
					notacreditopuntoventaLogic.deepLoad(notacreditopuntoventa,isDeep,deepLoadType,clases);
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
			tipofacturapuntoventa.setFacturaPuntoVentas(tipofacturapuntoventaDataAccess.getFacturaPuntoVentas(connexion,tipofacturapuntoventa));

			for(FacturaPuntoVenta facturapuntoventa:tipofacturapuntoventa.getFacturaPuntoVentas()) {
				FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
				facturapuntoventaLogic.deepLoad(facturapuntoventa,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoPuntoVenta.class));
			tipofacturapuntoventa.setNotaCreditoPuntoVentas(tipofacturapuntoventaDataAccess.getNotaCreditoPuntoVentas(connexion,tipofacturapuntoventa));

			for(NotaCreditoPuntoVenta notacreditopuntoventa:tipofacturapuntoventa.getNotaCreditoPuntoVentas()) {
				NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
				notacreditopuntoventaLogic.deepLoad(notacreditopuntoventa,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoFacturaPuntoVenta tipofacturapuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoFacturaPuntoVenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipofacturapuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesTipoFacturaPuntoVenta(tipofacturapuntoventa);
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
			this.deepLoad(this.tipofacturapuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesTipoFacturaPuntoVenta(this.tipofacturapuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoFacturaPuntoVenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipofacturapuntoventas!=null) {
				for(TipoFacturaPuntoVenta tipofacturapuntoventa:tipofacturapuntoventas) {
					this.deepLoad(tipofacturapuntoventa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesTipoFacturaPuntoVenta(tipofacturapuntoventas);
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
			if(tipofacturapuntoventas!=null) {
				for(TipoFacturaPuntoVenta tipofacturapuntoventa:tipofacturapuntoventas) {
					this.deepLoad(tipofacturapuntoventa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesTipoFacturaPuntoVenta(tipofacturapuntoventas);
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
			if(TipoFacturaPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoFacturaPuntoVentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoFacturaPuntoVenta tipofacturapuntoventa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoFacturaPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				if(tipofacturapuntoventa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoFacturaPuntoVentaDataAccess.TABLENAME, tipofacturapuntoventa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoFacturaPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoFacturaPuntoVentaLogic.registrarAuditoriaDetallesTipoFacturaPuntoVenta(connexion,tipofacturapuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipofacturapuntoventa.getIsDeleted()) {
					/*if(!tipofacturapuntoventa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoFacturaPuntoVentaDataAccess.TABLENAME, tipofacturapuntoventa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoFacturaPuntoVentaLogic.registrarAuditoriaDetallesTipoFacturaPuntoVenta(connexion,tipofacturapuntoventa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoFacturaPuntoVentaDataAccess.TABLENAME, tipofacturapuntoventa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipofacturapuntoventa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoFacturaPuntoVentaDataAccess.TABLENAME, tipofacturapuntoventa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoFacturaPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoFacturaPuntoVentaLogic.registrarAuditoriaDetallesTipoFacturaPuntoVenta(connexion,tipofacturapuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoFacturaPuntoVenta(Connexion connexion,TipoFacturaPuntoVenta tipofacturapuntoventa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipofacturapuntoventa.getIsNew()||!tipofacturapuntoventa.getnombre().equals(tipofacturapuntoventa.getTipoFacturaPuntoVentaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipofacturapuntoventa.getTipoFacturaPuntoVentaOriginal().getnombre()!=null)
				{
					strValorActual=tipofacturapuntoventa.getTipoFacturaPuntoVentaOriginal().getnombre();
				}
				if(tipofacturapuntoventa.getnombre()!=null)
				{
					strValorNuevo=tipofacturapuntoventa.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoFacturaPuntoVentaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipofacturapuntoventa.getIsNew()||!tipofacturapuntoventa.getdescripcion().equals(tipofacturapuntoventa.getTipoFacturaPuntoVentaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipofacturapuntoventa.getTipoFacturaPuntoVentaOriginal().getdescripcion()!=null)
				{
					strValorActual=tipofacturapuntoventa.getTipoFacturaPuntoVentaOriginal().getdescripcion();
				}
				if(tipofacturapuntoventa.getdescripcion()!=null)
				{
					strValorNuevo=tipofacturapuntoventa.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoFacturaPuntoVentaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoFacturaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoFacturaPuntoVentaConstantesFunciones.getClassesForeignKeysOfTipoFacturaPuntoVenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFacturaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoFacturaPuntoVentaConstantesFunciones.getClassesRelationshipsOfTipoFacturaPuntoVenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

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
import com.bydan.erp.puntoventa.util.HistorialFormaPagoPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.HistorialFormaPagoPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.HistorialFormaPagoPuntoVentaParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.HistorialFormaPagoPuntoVenta;
import com.bydan.erp.puntoventa.business.logic.HistorialFormaPagoPuntoVentaLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class HistorialFormaPagoPuntoVentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(HistorialFormaPagoPuntoVentaLogic.class);
	
	protected HistorialFormaPagoPuntoVentaDataAccess historialformapagopuntoventaDataAccess; 	
	protected HistorialFormaPagoPuntoVenta historialformapagopuntoventa;
	protected List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventas;
	protected Object historialformapagopuntoventaObject;	
	protected List<Object> historialformapagopuntoventasObject;
	
	public static ClassValidator<HistorialFormaPagoPuntoVenta> historialformapagopuntoventaValidator = new ClassValidator<HistorialFormaPagoPuntoVenta>(HistorialFormaPagoPuntoVenta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected HistorialFormaPagoPuntoVentaLogicAdditional historialformapagopuntoventaLogicAdditional=null;
	
	public HistorialFormaPagoPuntoVentaLogicAdditional getHistorialFormaPagoPuntoVentaLogicAdditional() {
		return this.historialformapagopuntoventaLogicAdditional;
	}
	
	public void setHistorialFormaPagoPuntoVentaLogicAdditional(HistorialFormaPagoPuntoVentaLogicAdditional historialformapagopuntoventaLogicAdditional) {
		try {
			this.historialformapagopuntoventaLogicAdditional=historialformapagopuntoventaLogicAdditional;
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
	
	
	
	
	public  HistorialFormaPagoPuntoVentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.historialformapagopuntoventaDataAccess = new HistorialFormaPagoPuntoVentaDataAccess();
			
			this.historialformapagopuntoventas= new ArrayList<HistorialFormaPagoPuntoVenta>();
			this.historialformapagopuntoventa= new HistorialFormaPagoPuntoVenta();
			
			this.historialformapagopuntoventaObject=new Object();
			this.historialformapagopuntoventasObject=new ArrayList<Object>();
				
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
			
			this.historialformapagopuntoventaDataAccess.setConnexionType(this.connexionType);
			this.historialformapagopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  HistorialFormaPagoPuntoVentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.historialformapagopuntoventaDataAccess = new HistorialFormaPagoPuntoVentaDataAccess();
			this.historialformapagopuntoventas= new ArrayList<HistorialFormaPagoPuntoVenta>();
			this.historialformapagopuntoventa= new HistorialFormaPagoPuntoVenta();
			this.historialformapagopuntoventaObject=new Object();
			this.historialformapagopuntoventasObject=new ArrayList<Object>();
			
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
			
			this.historialformapagopuntoventaDataAccess.setConnexionType(this.connexionType);
			this.historialformapagopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public HistorialFormaPagoPuntoVenta getHistorialFormaPagoPuntoVenta() throws Exception {	
		HistorialFormaPagoPuntoVentaLogicAdditional.checkHistorialFormaPagoPuntoVentaToGet(historialformapagopuntoventa,this.datosCliente,this.arrDatoGeneral);
		HistorialFormaPagoPuntoVentaLogicAdditional.updateHistorialFormaPagoPuntoVentaToGet(historialformapagopuntoventa,this.arrDatoGeneral);
		
		return historialformapagopuntoventa;
	}
		
	public void setHistorialFormaPagoPuntoVenta(HistorialFormaPagoPuntoVenta newHistorialFormaPagoPuntoVenta) {
		this.historialformapagopuntoventa = newHistorialFormaPagoPuntoVenta;
	}
	
	public HistorialFormaPagoPuntoVentaDataAccess getHistorialFormaPagoPuntoVentaDataAccess() {
		return historialformapagopuntoventaDataAccess;
	}
	
	public void setHistorialFormaPagoPuntoVentaDataAccess(HistorialFormaPagoPuntoVentaDataAccess newhistorialformapagopuntoventaDataAccess) {
		this.historialformapagopuntoventaDataAccess = newhistorialformapagopuntoventaDataAccess;
	}
	
	public List<HistorialFormaPagoPuntoVenta> getHistorialFormaPagoPuntoVentas() throws Exception {		
		this.quitarHistorialFormaPagoPuntoVentasNulos();
		
		HistorialFormaPagoPuntoVentaLogicAdditional.checkHistorialFormaPagoPuntoVentaToGets(historialformapagopuntoventas,this.datosCliente,this.arrDatoGeneral);
		
		for (HistorialFormaPagoPuntoVenta historialformapagopuntoventaLocal: historialformapagopuntoventas ) {
			HistorialFormaPagoPuntoVentaLogicAdditional.updateHistorialFormaPagoPuntoVentaToGet(historialformapagopuntoventaLocal,this.arrDatoGeneral);
		}
		
		return historialformapagopuntoventas;
	}
	
	public void setHistorialFormaPagoPuntoVentas(List<HistorialFormaPagoPuntoVenta> newHistorialFormaPagoPuntoVentas) {
		this.historialformapagopuntoventas = newHistorialFormaPagoPuntoVentas;
	}
	
	public Object getHistorialFormaPagoPuntoVentaObject() {	
		this.historialformapagopuntoventaObject=this.historialformapagopuntoventaDataAccess.getEntityObject();
		return this.historialformapagopuntoventaObject;
	}
		
	public void setHistorialFormaPagoPuntoVentaObject(Object newHistorialFormaPagoPuntoVentaObject) {
		this.historialformapagopuntoventaObject = newHistorialFormaPagoPuntoVentaObject;
	}
	
	public List<Object> getHistorialFormaPagoPuntoVentasObject() {		
		this.historialformapagopuntoventasObject=this.historialformapagopuntoventaDataAccess.getEntitiesObject();
		return this.historialformapagopuntoventasObject;
	}
		
	public void setHistorialFormaPagoPuntoVentasObject(List<Object> newHistorialFormaPagoPuntoVentasObject) {
		this.historialformapagopuntoventasObject = newHistorialFormaPagoPuntoVentasObject;
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
		
		if(this.historialformapagopuntoventaDataAccess!=null) {
			this.historialformapagopuntoventaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			historialformapagopuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			historialformapagopuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		historialformapagopuntoventa = new  HistorialFormaPagoPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			historialformapagopuntoventa=historialformapagopuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.historialformapagopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventa);
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
		historialformapagopuntoventa = new  HistorialFormaPagoPuntoVenta();
		  		  
        try {
			
			historialformapagopuntoventa=historialformapagopuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.historialformapagopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		historialformapagopuntoventa = new  HistorialFormaPagoPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			historialformapagopuntoventa=historialformapagopuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.historialformapagopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventa);
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
		historialformapagopuntoventa = new  HistorialFormaPagoPuntoVenta();
		  		  
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
		historialformapagopuntoventa = new  HistorialFormaPagoPuntoVenta();
		  		  
        try {
			
			historialformapagopuntoventa=historialformapagopuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.historialformapagopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		historialformapagopuntoventa = new  HistorialFormaPagoPuntoVenta();
		  		  
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
		historialformapagopuntoventa = new  HistorialFormaPagoPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =historialformapagopuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		historialformapagopuntoventa = new  HistorialFormaPagoPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=historialformapagopuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		historialformapagopuntoventa = new  HistorialFormaPagoPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =historialformapagopuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		historialformapagopuntoventa = new  HistorialFormaPagoPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=historialformapagopuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		historialformapagopuntoventa = new  HistorialFormaPagoPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =historialformapagopuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		historialformapagopuntoventa = new  HistorialFormaPagoPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=historialformapagopuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		historialformapagopuntoventas = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagopuntoventas=historialformapagopuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialFormaPagoPuntoVenta(historialformapagopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventas);
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
		historialformapagopuntoventas = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		  		  
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
		historialformapagopuntoventas = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		  		  
        try {			
			HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagopuntoventas=historialformapagopuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarHistorialFormaPagoPuntoVenta(historialformapagopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		historialformapagopuntoventas = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		  		  
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
		historialformapagopuntoventas = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagopuntoventas=historialformapagopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialFormaPagoPuntoVenta(historialformapagopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventas);
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
		historialformapagopuntoventas = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		  		  
        try {
			HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagopuntoventas=historialformapagopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialFormaPagoPuntoVenta(historialformapagopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventas);
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
		historialformapagopuntoventas = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagopuntoventas=historialformapagopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHistorialFormaPagoPuntoVenta(historialformapagopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventas);
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
		historialformapagopuntoventas = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagopuntoventas=historialformapagopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHistorialFormaPagoPuntoVenta(historialformapagopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		historialformapagopuntoventa = new  HistorialFormaPagoPuntoVenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagopuntoventa=historialformapagopuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHistorialFormaPagoPuntoVenta(historialformapagopuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventa);
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
		historialformapagopuntoventa = new  HistorialFormaPagoPuntoVenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagopuntoventa=historialformapagopuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHistorialFormaPagoPuntoVenta(historialformapagopuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		historialformapagopuntoventas = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagopuntoventas=historialformapagopuntoventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialFormaPagoPuntoVenta(historialformapagopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventas);
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
		historialformapagopuntoventas = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		  		  
        try {
			HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagopuntoventas=historialformapagopuntoventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialFormaPagoPuntoVenta(historialformapagopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosHistorialFormaPagoPuntoVentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		historialformapagopuntoventas = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-getTodosHistorialFormaPagoPuntoVentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagopuntoventas=historialformapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarHistorialFormaPagoPuntoVenta(historialformapagopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventas);
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
	
	public  void  getTodosHistorialFormaPagoPuntoVentas(String sFinalQuery,Pagination pagination)throws Exception {
		historialformapagopuntoventas = new  ArrayList<HistorialFormaPagoPuntoVenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagopuntoventas=historialformapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarHistorialFormaPagoPuntoVenta(historialformapagopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarHistorialFormaPagoPuntoVenta(HistorialFormaPagoPuntoVenta historialformapagopuntoventa) throws Exception {
		Boolean estaValidado=false;
		
		if(historialformapagopuntoventa.getIsNew() || historialformapagopuntoventa.getIsChanged()) { 
			this.invalidValues = historialformapagopuntoventaValidator.getInvalidValues(historialformapagopuntoventa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(historialformapagopuntoventa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarHistorialFormaPagoPuntoVenta(List<HistorialFormaPagoPuntoVenta> HistorialFormaPagoPuntoVentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(HistorialFormaPagoPuntoVenta historialformapagopuntoventaLocal:historialformapagopuntoventas) {				
			estaValidadoObjeto=this.validarGuardarHistorialFormaPagoPuntoVenta(historialformapagopuntoventaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarHistorialFormaPagoPuntoVenta(List<HistorialFormaPagoPuntoVenta> HistorialFormaPagoPuntoVentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarHistorialFormaPagoPuntoVenta(historialformapagopuntoventas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarHistorialFormaPagoPuntoVenta(HistorialFormaPagoPuntoVenta HistorialFormaPagoPuntoVenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarHistorialFormaPagoPuntoVenta(historialformapagopuntoventa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(HistorialFormaPagoPuntoVenta historialformapagopuntoventa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+historialformapagopuntoventa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=HistorialFormaPagoPuntoVentaConstantesFunciones.getHistorialFormaPagoPuntoVentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"historialformapagopuntoventa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(HistorialFormaPagoPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(HistorialFormaPagoPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveHistorialFormaPagoPuntoVentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-saveHistorialFormaPagoPuntoVentaWithConnection");connexion.begin();			
			
			HistorialFormaPagoPuntoVentaLogicAdditional.checkHistorialFormaPagoPuntoVentaToSave(this.historialformapagopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			HistorialFormaPagoPuntoVentaLogicAdditional.updateHistorialFormaPagoPuntoVentaToSave(this.historialformapagopuntoventa,this.arrDatoGeneral);
			
			HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.historialformapagopuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowHistorialFormaPagoPuntoVenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventa)) {
				HistorialFormaPagoPuntoVentaDataAccess.save(this.historialformapagopuntoventa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.historialformapagopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			HistorialFormaPagoPuntoVentaLogicAdditional.checkHistorialFormaPagoPuntoVentaToSaveAfter(this.historialformapagopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowHistorialFormaPagoPuntoVenta();
			
			connexion.commit();			
			
			if(this.historialformapagopuntoventa.getIsDeleted()) {
				this.historialformapagopuntoventa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveHistorialFormaPagoPuntoVenta()throws Exception {	
		try {	
			
			HistorialFormaPagoPuntoVentaLogicAdditional.checkHistorialFormaPagoPuntoVentaToSave(this.historialformapagopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			HistorialFormaPagoPuntoVentaLogicAdditional.updateHistorialFormaPagoPuntoVentaToSave(this.historialformapagopuntoventa,this.arrDatoGeneral);
			
			HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.historialformapagopuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventa)) {			
				HistorialFormaPagoPuntoVentaDataAccess.save(this.historialformapagopuntoventa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.historialformapagopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			HistorialFormaPagoPuntoVentaLogicAdditional.checkHistorialFormaPagoPuntoVentaToSaveAfter(this.historialformapagopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.historialformapagopuntoventa.getIsDeleted()) {
				this.historialformapagopuntoventa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveHistorialFormaPagoPuntoVentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-saveHistorialFormaPagoPuntoVentasWithConnection");connexion.begin();			
			
			HistorialFormaPagoPuntoVentaLogicAdditional.checkHistorialFormaPagoPuntoVentaToSaves(historialformapagopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowHistorialFormaPagoPuntoVentas();
			
			Boolean validadoTodosHistorialFormaPagoPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(HistorialFormaPagoPuntoVenta historialformapagopuntoventaLocal:historialformapagopuntoventas) {		
				if(historialformapagopuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				HistorialFormaPagoPuntoVentaLogicAdditional.updateHistorialFormaPagoPuntoVentaToSave(historialformapagopuntoventaLocal,this.arrDatoGeneral);
	        	
				HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),historialformapagopuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarHistorialFormaPagoPuntoVenta(historialformapagopuntoventaLocal)) {
					HistorialFormaPagoPuntoVentaDataAccess.save(historialformapagopuntoventaLocal, connexion);				
				} else {
					validadoTodosHistorialFormaPagoPuntoVenta=false;
				}
			}
			
			if(!validadoTodosHistorialFormaPagoPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			HistorialFormaPagoPuntoVentaLogicAdditional.checkHistorialFormaPagoPuntoVentaToSavesAfter(historialformapagopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowHistorialFormaPagoPuntoVentas();
			
			connexion.commit();		
			
			this.quitarHistorialFormaPagoPuntoVentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveHistorialFormaPagoPuntoVentas()throws Exception {				
		 try {	
			HistorialFormaPagoPuntoVentaLogicAdditional.checkHistorialFormaPagoPuntoVentaToSaves(historialformapagopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosHistorialFormaPagoPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(HistorialFormaPagoPuntoVenta historialformapagopuntoventaLocal:historialformapagopuntoventas) {				
				if(historialformapagopuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				HistorialFormaPagoPuntoVentaLogicAdditional.updateHistorialFormaPagoPuntoVentaToSave(historialformapagopuntoventaLocal,this.arrDatoGeneral);
	        	
				HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),historialformapagopuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarHistorialFormaPagoPuntoVenta(historialformapagopuntoventaLocal)) {				
					HistorialFormaPagoPuntoVentaDataAccess.save(historialformapagopuntoventaLocal, connexion);				
				} else {
					validadoTodosHistorialFormaPagoPuntoVenta=false;
				}
			}
			
			if(!validadoTodosHistorialFormaPagoPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			HistorialFormaPagoPuntoVentaLogicAdditional.checkHistorialFormaPagoPuntoVentaToSavesAfter(historialformapagopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarHistorialFormaPagoPuntoVentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public HistorialFormaPagoPuntoVentaParameterReturnGeneral procesarAccionHistorialFormaPagoPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventas,HistorialFormaPagoPuntoVentaParameterReturnGeneral historialformapagopuntoventaParameterGeneral)throws Exception {
		 try {	
			HistorialFormaPagoPuntoVentaParameterReturnGeneral historialformapagopuntoventaReturnGeneral=new HistorialFormaPagoPuntoVentaParameterReturnGeneral();
	
			HistorialFormaPagoPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,historialformapagopuntoventas,historialformapagopuntoventaParameterGeneral,historialformapagopuntoventaReturnGeneral);
			
			return historialformapagopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public HistorialFormaPagoPuntoVentaParameterReturnGeneral procesarAccionHistorialFormaPagoPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventas,HistorialFormaPagoPuntoVentaParameterReturnGeneral historialformapagopuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-procesarAccionHistorialFormaPagoPuntoVentasWithConnection");connexion.begin();			
			
			HistorialFormaPagoPuntoVentaParameterReturnGeneral historialformapagopuntoventaReturnGeneral=new HistorialFormaPagoPuntoVentaParameterReturnGeneral();
	
			HistorialFormaPagoPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,historialformapagopuntoventas,historialformapagopuntoventaParameterGeneral,historialformapagopuntoventaReturnGeneral);
			
			this.connexion.commit();
			
			return historialformapagopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public HistorialFormaPagoPuntoVentaParameterReturnGeneral procesarEventosHistorialFormaPagoPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventas,HistorialFormaPagoPuntoVenta historialformapagopuntoventa,HistorialFormaPagoPuntoVentaParameterReturnGeneral historialformapagopuntoventaParameterGeneral,Boolean isEsNuevoHistorialFormaPagoPuntoVenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			HistorialFormaPagoPuntoVentaParameterReturnGeneral historialformapagopuntoventaReturnGeneral=new HistorialFormaPagoPuntoVentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				historialformapagopuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			HistorialFormaPagoPuntoVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,historialformapagopuntoventas,historialformapagopuntoventa,historialformapagopuntoventaParameterGeneral,historialformapagopuntoventaReturnGeneral,isEsNuevoHistorialFormaPagoPuntoVenta,clases);
			
			return historialformapagopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public HistorialFormaPagoPuntoVentaParameterReturnGeneral procesarEventosHistorialFormaPagoPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventas,HistorialFormaPagoPuntoVenta historialformapagopuntoventa,HistorialFormaPagoPuntoVentaParameterReturnGeneral historialformapagopuntoventaParameterGeneral,Boolean isEsNuevoHistorialFormaPagoPuntoVenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-procesarEventosHistorialFormaPagoPuntoVentasWithConnection");connexion.begin();			
			
			HistorialFormaPagoPuntoVentaParameterReturnGeneral historialformapagopuntoventaReturnGeneral=new HistorialFormaPagoPuntoVentaParameterReturnGeneral();
	
			historialformapagopuntoventaReturnGeneral.setHistorialFormaPagoPuntoVenta(historialformapagopuntoventa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				historialformapagopuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			HistorialFormaPagoPuntoVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,historialformapagopuntoventas,historialformapagopuntoventa,historialformapagopuntoventaParameterGeneral,historialformapagopuntoventaReturnGeneral,isEsNuevoHistorialFormaPagoPuntoVenta,clases);
			
			this.connexion.commit();
			
			return historialformapagopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public HistorialFormaPagoPuntoVentaParameterReturnGeneral procesarImportacionHistorialFormaPagoPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,HistorialFormaPagoPuntoVentaParameterReturnGeneral historialformapagopuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-procesarImportacionHistorialFormaPagoPuntoVentasWithConnection");connexion.begin();			
			
			HistorialFormaPagoPuntoVentaParameterReturnGeneral historialformapagopuntoventaReturnGeneral=new HistorialFormaPagoPuntoVentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.historialformapagopuntoventas=new ArrayList<HistorialFormaPagoPuntoVenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.historialformapagopuntoventa=new HistorialFormaPagoPuntoVenta();
				
				
				if(conColumnasBase) {this.historialformapagopuntoventa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.historialformapagopuntoventa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.historialformapagopuntoventas.add(this.historialformapagopuntoventa);
			}
			
			this.saveHistorialFormaPagoPuntoVentas();
			
			this.connexion.commit();
			
			historialformapagopuntoventaReturnGeneral.setConRetornoEstaProcesado(true);
			historialformapagopuntoventaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return historialformapagopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarHistorialFormaPagoPuntoVentasEliminados() throws Exception {				
		
		List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventasAux= new ArrayList<HistorialFormaPagoPuntoVenta>();
		
		for(HistorialFormaPagoPuntoVenta historialformapagopuntoventa:historialformapagopuntoventas) {
			if(!historialformapagopuntoventa.getIsDeleted()) {
				historialformapagopuntoventasAux.add(historialformapagopuntoventa);
			}
		}
		
		historialformapagopuntoventas=historialformapagopuntoventasAux;
	}
	
	public void quitarHistorialFormaPagoPuntoVentasNulos() throws Exception {				
		
		List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventasAux= new ArrayList<HistorialFormaPagoPuntoVenta>();
		
		for(HistorialFormaPagoPuntoVenta historialformapagopuntoventa : this.historialformapagopuntoventas) {
			if(historialformapagopuntoventa==null) {
				historialformapagopuntoventasAux.add(historialformapagopuntoventa);
			}
		}
		
		//this.historialformapagopuntoventas=historialformapagopuntoventasAux;
		
		this.historialformapagopuntoventas.removeAll(historialformapagopuntoventasAux);
	}
	
	public void getSetVersionRowHistorialFormaPagoPuntoVentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(historialformapagopuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((historialformapagopuntoventa.getIsDeleted() || (historialformapagopuntoventa.getIsChanged()&&!historialformapagopuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=historialformapagopuntoventaDataAccess.getSetVersionRowHistorialFormaPagoPuntoVenta(connexion,historialformapagopuntoventa.getId());
				
				if(!historialformapagopuntoventa.getVersionRow().equals(timestamp)) {	
					historialformapagopuntoventa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				historialformapagopuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowHistorialFormaPagoPuntoVenta()throws Exception {	
		
		if(historialformapagopuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((historialformapagopuntoventa.getIsDeleted() || (historialformapagopuntoventa.getIsChanged()&&!historialformapagopuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=historialformapagopuntoventaDataAccess.getSetVersionRowHistorialFormaPagoPuntoVenta(connexion,historialformapagopuntoventa.getId());
			
			try {							
				if(!historialformapagopuntoventa.getVersionRow().equals(timestamp)) {	
					historialformapagopuntoventa.setVersionRow(timestamp);
				}
				
				historialformapagopuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowHistorialFormaPagoPuntoVentasWithConnection()throws Exception {	
		if(historialformapagopuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(HistorialFormaPagoPuntoVenta historialformapagopuntoventaAux:historialformapagopuntoventas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(historialformapagopuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(historialformapagopuntoventaAux.getIsDeleted() || (historialformapagopuntoventaAux.getIsChanged()&&!historialformapagopuntoventaAux.getIsNew())) {
						
						timestamp=historialformapagopuntoventaDataAccess.getSetVersionRowHistorialFormaPagoPuntoVenta(connexion,historialformapagopuntoventaAux.getId());
						
						if(!historialformapagopuntoventa.getVersionRow().equals(timestamp)) {	
							historialformapagopuntoventaAux.setVersionRow(timestamp);
						}
								
						historialformapagopuntoventaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowHistorialFormaPagoPuntoVentas()throws Exception {	
		if(historialformapagopuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(HistorialFormaPagoPuntoVenta historialformapagopuntoventaAux:historialformapagopuntoventas) {
					if(historialformapagopuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(historialformapagopuntoventaAux.getIsDeleted() || (historialformapagopuntoventaAux.getIsChanged()&&!historialformapagopuntoventaAux.getIsNew())) {
						
						timestamp=historialformapagopuntoventaDataAccess.getSetVersionRowHistorialFormaPagoPuntoVenta(connexion,historialformapagopuntoventaAux.getId());
						
						if(!historialformapagopuntoventaAux.getVersionRow().equals(timestamp)) {	
							historialformapagopuntoventaAux.setVersionRow(timestamp);
						}
						
													
						historialformapagopuntoventaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public HistorialFormaPagoPuntoVentaParameterReturnGeneral cargarCombosLoteForeignKeyHistorialFormaPagoPuntoVentaWithConnection(String finalQueryGlobalFacturaPuntoVenta,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal) throws Exception {
		HistorialFormaPagoPuntoVentaParameterReturnGeneral  historialformapagopuntoventaReturnGeneral =new HistorialFormaPagoPuntoVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-cargarCombosLoteForeignKeyHistorialFormaPagoPuntoVentaWithConnection");connexion.begin();
			
			historialformapagopuntoventaReturnGeneral =new HistorialFormaPagoPuntoVentaParameterReturnGeneral();
			
			

			List<FacturaPuntoVenta> facturapuntoventasForeignKey=new ArrayList<FacturaPuntoVenta>();
			FacturaPuntoVentaLogic facturapuntoventaLogic=new FacturaPuntoVentaLogic();
			facturapuntoventaLogic.setConnexion(this.connexion);
			facturapuntoventaLogic.getFacturaPuntoVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFacturaPuntoVenta.equals("NONE")) {
				facturapuntoventaLogic.getTodosFacturaPuntoVentas(finalQueryGlobalFacturaPuntoVenta,new Pagination());
				facturapuntoventasForeignKey=facturapuntoventaLogic.getFacturaPuntoVentas();
			}

			historialformapagopuntoventaReturnGeneral.setfacturapuntoventasForeignKey(facturapuntoventasForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			historialformapagopuntoventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			historialformapagopuntoventaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return historialformapagopuntoventaReturnGeneral;
	}
	
	public HistorialFormaPagoPuntoVentaParameterReturnGeneral cargarCombosLoteForeignKeyHistorialFormaPagoPuntoVenta(String finalQueryGlobalFacturaPuntoVenta,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal) throws Exception {
		HistorialFormaPagoPuntoVentaParameterReturnGeneral  historialformapagopuntoventaReturnGeneral =new HistorialFormaPagoPuntoVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			historialformapagopuntoventaReturnGeneral =new HistorialFormaPagoPuntoVentaParameterReturnGeneral();
			
			

			List<FacturaPuntoVenta> facturapuntoventasForeignKey=new ArrayList<FacturaPuntoVenta>();
			FacturaPuntoVentaLogic facturapuntoventaLogic=new FacturaPuntoVentaLogic();
			facturapuntoventaLogic.setConnexion(this.connexion);
			facturapuntoventaLogic.getFacturaPuntoVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFacturaPuntoVenta.equals("NONE")) {
				facturapuntoventaLogic.getTodosFacturaPuntoVentas(finalQueryGlobalFacturaPuntoVenta,new Pagination());
				facturapuntoventasForeignKey=facturapuntoventaLogic.getFacturaPuntoVentas();
			}

			historialformapagopuntoventaReturnGeneral.setfacturapuntoventasForeignKey(facturapuntoventasForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			historialformapagopuntoventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			historialformapagopuntoventaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return historialformapagopuntoventaReturnGeneral;
	}
	
	
	public void deepLoad(HistorialFormaPagoPuntoVenta historialformapagopuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			HistorialFormaPagoPuntoVentaLogicAdditional.updateHistorialFormaPagoPuntoVentaToGet(historialformapagopuntoventa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		historialformapagopuntoventa.setFacturaPuntoVenta(historialformapagopuntoventaDataAccess.getFacturaPuntoVenta(connexion,historialformapagopuntoventa));
		historialformapagopuntoventa.setEmpresa(historialformapagopuntoventaDataAccess.getEmpresa(connexion,historialformapagopuntoventa));
		historialformapagopuntoventa.setSucursal(historialformapagopuntoventaDataAccess.getSucursal(connexion,historialformapagopuntoventa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)) {
				historialformapagopuntoventa.setFacturaPuntoVenta(historialformapagopuntoventaDataAccess.getFacturaPuntoVenta(connexion,historialformapagopuntoventa));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				historialformapagopuntoventa.setEmpresa(historialformapagopuntoventaDataAccess.getEmpresa(connexion,historialformapagopuntoventa));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				historialformapagopuntoventa.setSucursal(historialformapagopuntoventaDataAccess.getSucursal(connexion,historialformapagopuntoventa));
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
			historialformapagopuntoventa.setFacturaPuntoVenta(historialformapagopuntoventaDataAccess.getFacturaPuntoVenta(connexion,historialformapagopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialformapagopuntoventa.setEmpresa(historialformapagopuntoventaDataAccess.getEmpresa(connexion,historialformapagopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialformapagopuntoventa.setSucursal(historialformapagopuntoventaDataAccess.getSucursal(connexion,historialformapagopuntoventa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		historialformapagopuntoventa.setFacturaPuntoVenta(historialformapagopuntoventaDataAccess.getFacturaPuntoVenta(connexion,historialformapagopuntoventa));
		FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
		facturapuntoventaLogic.deepLoad(historialformapagopuntoventa.getFacturaPuntoVenta(),isDeep,deepLoadType,clases);
				
		historialformapagopuntoventa.setEmpresa(historialformapagopuntoventaDataAccess.getEmpresa(connexion,historialformapagopuntoventa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(historialformapagopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		historialformapagopuntoventa.setSucursal(historialformapagopuntoventaDataAccess.getSucursal(connexion,historialformapagopuntoventa));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(historialformapagopuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)) {
				historialformapagopuntoventa.setFacturaPuntoVenta(historialformapagopuntoventaDataAccess.getFacturaPuntoVenta(connexion,historialformapagopuntoventa));
				FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
				facturapuntoventaLogic.deepLoad(historialformapagopuntoventa.getFacturaPuntoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				historialformapagopuntoventa.setEmpresa(historialformapagopuntoventaDataAccess.getEmpresa(connexion,historialformapagopuntoventa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(historialformapagopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				historialformapagopuntoventa.setSucursal(historialformapagopuntoventaDataAccess.getSucursal(connexion,historialformapagopuntoventa));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(historialformapagopuntoventa.getSucursal(),isDeep,deepLoadType,clases);				
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
			historialformapagopuntoventa.setFacturaPuntoVenta(historialformapagopuntoventaDataAccess.getFacturaPuntoVenta(connexion,historialformapagopuntoventa));
			FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
			facturapuntoventaLogic.deepLoad(historialformapagopuntoventa.getFacturaPuntoVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialformapagopuntoventa.setEmpresa(historialformapagopuntoventaDataAccess.getEmpresa(connexion,historialformapagopuntoventa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(historialformapagopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialformapagopuntoventa.setSucursal(historialformapagopuntoventaDataAccess.getSucursal(connexion,historialformapagopuntoventa));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(historialformapagopuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(HistorialFormaPagoPuntoVenta historialformapagopuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			HistorialFormaPagoPuntoVentaLogicAdditional.updateHistorialFormaPagoPuntoVentaToSave(historialformapagopuntoventa,this.arrDatoGeneral);
			
HistorialFormaPagoPuntoVentaDataAccess.save(historialformapagopuntoventa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		FacturaPuntoVentaDataAccess.save(historialformapagopuntoventa.getFacturaPuntoVenta(),connexion);

		EmpresaDataAccess.save(historialformapagopuntoventa.getEmpresa(),connexion);

		SucursalDataAccess.save(historialformapagopuntoventa.getSucursal(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)) {
				FacturaPuntoVentaDataAccess.save(historialformapagopuntoventa.getFacturaPuntoVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(historialformapagopuntoventa.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(historialformapagopuntoventa.getSucursal(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		FacturaPuntoVentaDataAccess.save(historialformapagopuntoventa.getFacturaPuntoVenta(),connexion);
		FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
		facturapuntoventaLogic.deepLoad(historialformapagopuntoventa.getFacturaPuntoVenta(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(historialformapagopuntoventa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(historialformapagopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(historialformapagopuntoventa.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(historialformapagopuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)) {
				FacturaPuntoVentaDataAccess.save(historialformapagopuntoventa.getFacturaPuntoVenta(),connexion);
				FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
				facturapuntoventaLogic.deepSave(historialformapagopuntoventa.getFacturaPuntoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(historialformapagopuntoventa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(historialformapagopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(historialformapagopuntoventa.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(historialformapagopuntoventa.getSucursal(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(historialformapagopuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(historialformapagopuntoventa);
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
			this.deepLoad(this.historialformapagopuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(historialformapagopuntoventas!=null) {
				for(HistorialFormaPagoPuntoVenta historialformapagopuntoventa:historialformapagopuntoventas) {
					this.deepLoad(historialformapagopuntoventa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(historialformapagopuntoventas);
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
			if(historialformapagopuntoventas!=null) {
				for(HistorialFormaPagoPuntoVenta historialformapagopuntoventa:historialformapagopuntoventas) {
					this.deepLoad(historialformapagopuntoventa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(historialformapagopuntoventas);
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
			this.getNewConnexionToDeep(HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(historialformapagopuntoventa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(historialformapagopuntoventas!=null) {
				for(HistorialFormaPagoPuntoVenta historialformapagopuntoventa:historialformapagopuntoventas) {
					this.deepSave(historialformapagopuntoventa,isDeep,deepLoadType,clases);
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
			if(historialformapagopuntoventas!=null) {
				for(HistorialFormaPagoPuntoVenta historialformapagopuntoventa:historialformapagopuntoventas) {
					this.deepSave(historialformapagopuntoventa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getHistorialFormaPagoPuntoVentasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,HistorialFormaPagoPuntoVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagopuntoventas=historialformapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialFormaPagoPuntoVentasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,HistorialFormaPagoPuntoVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagopuntoventas=historialformapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHistorialFormaPagoPuntoVentasFK_IdFacturaPuntoVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura_punto_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFacturaPuntoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFacturaPuntoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura_punto_venta,HistorialFormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFacturaPuntoVenta);

			HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFacturaPuntoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagopuntoventas=historialformapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialFormaPagoPuntoVentasFK_IdFacturaPuntoVenta(String sFinalQuery,Pagination pagination,Long id_factura_punto_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFacturaPuntoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFacturaPuntoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura_punto_venta,HistorialFormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFacturaPuntoVenta);

			HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFacturaPuntoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagopuntoventas=historialformapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHistorialFormaPagoPuntoVentasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPagoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,HistorialFormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagopuntoventas=historialformapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialFormaPagoPuntoVentasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,HistorialFormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			HistorialFormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagopuntoventas=historialformapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(this.historialformapagopuntoventas);
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
			if(HistorialFormaPagoPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,HistorialFormaPagoPuntoVentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,HistorialFormaPagoPuntoVenta historialformapagopuntoventa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(HistorialFormaPagoPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				if(historialformapagopuntoventa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HistorialFormaPagoPuntoVentaDataAccess.TABLENAME, historialformapagopuntoventa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(HistorialFormaPagoPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////HistorialFormaPagoPuntoVentaLogic.registrarAuditoriaDetallesHistorialFormaPagoPuntoVenta(connexion,historialformapagopuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(historialformapagopuntoventa.getIsDeleted()) {
					/*if(!historialformapagopuntoventa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,HistorialFormaPagoPuntoVentaDataAccess.TABLENAME, historialformapagopuntoventa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////HistorialFormaPagoPuntoVentaLogic.registrarAuditoriaDetallesHistorialFormaPagoPuntoVenta(connexion,historialformapagopuntoventa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HistorialFormaPagoPuntoVentaDataAccess.TABLENAME, historialformapagopuntoventa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(historialformapagopuntoventa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HistorialFormaPagoPuntoVentaDataAccess.TABLENAME, historialformapagopuntoventa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(HistorialFormaPagoPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////HistorialFormaPagoPuntoVentaLogic.registrarAuditoriaDetallesHistorialFormaPagoPuntoVenta(connexion,historialformapagopuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesHistorialFormaPagoPuntoVenta(Connexion connexion,HistorialFormaPagoPuntoVenta historialformapagopuntoventa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(historialformapagopuntoventa.getIsNew()||!historialformapagopuntoventa.getid_factura_punto_venta().equals(historialformapagopuntoventa.getHistorialFormaPagoPuntoVentaOriginal().getid_factura_punto_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialformapagopuntoventa.getHistorialFormaPagoPuntoVentaOriginal().getid_factura_punto_venta()!=null)
				{
					strValorActual=historialformapagopuntoventa.getHistorialFormaPagoPuntoVentaOriginal().getid_factura_punto_venta().toString();
				}
				if(historialformapagopuntoventa.getid_factura_punto_venta()!=null)
				{
					strValorNuevo=historialformapagopuntoventa.getid_factura_punto_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialFormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA,strValorActual,strValorNuevo);
			}	
			
			if(historialformapagopuntoventa.getIsNew()||!historialformapagopuntoventa.getid_empresa().equals(historialformapagopuntoventa.getHistorialFormaPagoPuntoVentaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialformapagopuntoventa.getHistorialFormaPagoPuntoVentaOriginal().getid_empresa()!=null)
				{
					strValorActual=historialformapagopuntoventa.getHistorialFormaPagoPuntoVentaOriginal().getid_empresa().toString();
				}
				if(historialformapagopuntoventa.getid_empresa()!=null)
				{
					strValorNuevo=historialformapagopuntoventa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialFormaPagoPuntoVentaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(historialformapagopuntoventa.getIsNew()||!historialformapagopuntoventa.getid_sucursal().equals(historialformapagopuntoventa.getHistorialFormaPagoPuntoVentaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialformapagopuntoventa.getHistorialFormaPagoPuntoVentaOriginal().getid_sucursal()!=null)
				{
					strValorActual=historialformapagopuntoventa.getHistorialFormaPagoPuntoVentaOriginal().getid_sucursal().toString();
				}
				if(historialformapagopuntoventa.getid_sucursal()!=null)
				{
					strValorNuevo=historialformapagopuntoventa.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialFormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveHistorialFormaPagoPuntoVentaRelacionesWithConnection(HistorialFormaPagoPuntoVenta historialformapagopuntoventa) throws Exception {

		if(!historialformapagopuntoventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveHistorialFormaPagoPuntoVentaRelacionesBase(historialformapagopuntoventa,true);
		}
	}

	public void saveHistorialFormaPagoPuntoVentaRelaciones(HistorialFormaPagoPuntoVenta historialformapagopuntoventa)throws Exception {

		if(!historialformapagopuntoventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveHistorialFormaPagoPuntoVentaRelacionesBase(historialformapagopuntoventa,false);
		}
	}

	public void saveHistorialFormaPagoPuntoVentaRelacionesBase(HistorialFormaPagoPuntoVenta historialformapagopuntoventa,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("HistorialFormaPagoPuntoVenta-saveRelacionesWithConnection");}
	

			this.setHistorialFormaPagoPuntoVenta(historialformapagopuntoventa);

			if(HistorialFormaPagoPuntoVentaLogicAdditional.validarSaveRelaciones(historialformapagopuntoventa,this)) {

				HistorialFormaPagoPuntoVentaLogicAdditional.updateRelacionesToSave(historialformapagopuntoventa,this);

				if((historialformapagopuntoventa.getIsNew()||historialformapagopuntoventa.getIsChanged())&&!historialformapagopuntoventa.getIsDeleted()) {
					this.saveHistorialFormaPagoPuntoVenta();
					this.saveHistorialFormaPagoPuntoVentaRelacionesDetalles();

				} else if(historialformapagopuntoventa.getIsDeleted()) {
					this.saveHistorialFormaPagoPuntoVentaRelacionesDetalles();
					this.saveHistorialFormaPagoPuntoVenta();
				}

				HistorialFormaPagoPuntoVentaLogicAdditional.updateRelacionesToSaveAfter(historialformapagopuntoventa,this);

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
	
	
	private void saveHistorialFormaPagoPuntoVentaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfHistorialFormaPagoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=HistorialFormaPagoPuntoVentaConstantesFunciones.getClassesForeignKeysOfHistorialFormaPagoPuntoVenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfHistorialFormaPagoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=HistorialFormaPagoPuntoVentaConstantesFunciones.getClassesRelationshipsOfHistorialFormaPagoPuntoVenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

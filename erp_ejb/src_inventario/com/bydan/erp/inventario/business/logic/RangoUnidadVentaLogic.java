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
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.RangoUnidadVentaConstantesFunciones;
import com.bydan.erp.inventario.util.RangoUnidadVentaParameterReturnGeneral;
//import com.bydan.erp.inventario.util.RangoUnidadVentaParameterGeneral;
import com.bydan.erp.inventario.business.entity.RangoUnidadVenta;
import com.bydan.erp.inventario.business.logic.RangoUnidadVentaLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class RangoUnidadVentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(RangoUnidadVentaLogic.class);
	
	protected RangoUnidadVentaDataAccess rangounidadventaDataAccess; 	
	protected RangoUnidadVenta rangounidadventa;
	protected List<RangoUnidadVenta> rangounidadventas;
	protected Object rangounidadventaObject;	
	protected List<Object> rangounidadventasObject;
	
	public static ClassValidator<RangoUnidadVenta> rangounidadventaValidator = new ClassValidator<RangoUnidadVenta>(RangoUnidadVenta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected RangoUnidadVentaLogicAdditional rangounidadventaLogicAdditional=null;
	
	public RangoUnidadVentaLogicAdditional getRangoUnidadVentaLogicAdditional() {
		return this.rangounidadventaLogicAdditional;
	}
	
	public void setRangoUnidadVentaLogicAdditional(RangoUnidadVentaLogicAdditional rangounidadventaLogicAdditional) {
		try {
			this.rangounidadventaLogicAdditional=rangounidadventaLogicAdditional;
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
	
	
	
	
	public  RangoUnidadVentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.rangounidadventaDataAccess = new RangoUnidadVentaDataAccess();
			
			this.rangounidadventas= new ArrayList<RangoUnidadVenta>();
			this.rangounidadventa= new RangoUnidadVenta();
			
			this.rangounidadventaObject=new Object();
			this.rangounidadventasObject=new ArrayList<Object>();
				
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
			
			this.rangounidadventaDataAccess.setConnexionType(this.connexionType);
			this.rangounidadventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RangoUnidadVentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.rangounidadventaDataAccess = new RangoUnidadVentaDataAccess();
			this.rangounidadventas= new ArrayList<RangoUnidadVenta>();
			this.rangounidadventa= new RangoUnidadVenta();
			this.rangounidadventaObject=new Object();
			this.rangounidadventasObject=new ArrayList<Object>();
			
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
			
			this.rangounidadventaDataAccess.setConnexionType(this.connexionType);
			this.rangounidadventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public RangoUnidadVenta getRangoUnidadVenta() throws Exception {	
		RangoUnidadVentaLogicAdditional.checkRangoUnidadVentaToGet(rangounidadventa,this.datosCliente,this.arrDatoGeneral);
		RangoUnidadVentaLogicAdditional.updateRangoUnidadVentaToGet(rangounidadventa,this.arrDatoGeneral);
		
		return rangounidadventa;
	}
		
	public void setRangoUnidadVenta(RangoUnidadVenta newRangoUnidadVenta) {
		this.rangounidadventa = newRangoUnidadVenta;
	}
	
	public RangoUnidadVentaDataAccess getRangoUnidadVentaDataAccess() {
		return rangounidadventaDataAccess;
	}
	
	public void setRangoUnidadVentaDataAccess(RangoUnidadVentaDataAccess newrangounidadventaDataAccess) {
		this.rangounidadventaDataAccess = newrangounidadventaDataAccess;
	}
	
	public List<RangoUnidadVenta> getRangoUnidadVentas() throws Exception {		
		this.quitarRangoUnidadVentasNulos();
		
		RangoUnidadVentaLogicAdditional.checkRangoUnidadVentaToGets(rangounidadventas,this.datosCliente,this.arrDatoGeneral);
		
		for (RangoUnidadVenta rangounidadventaLocal: rangounidadventas ) {
			RangoUnidadVentaLogicAdditional.updateRangoUnidadVentaToGet(rangounidadventaLocal,this.arrDatoGeneral);
		}
		
		return rangounidadventas;
	}
	
	public void setRangoUnidadVentas(List<RangoUnidadVenta> newRangoUnidadVentas) {
		this.rangounidadventas = newRangoUnidadVentas;
	}
	
	public Object getRangoUnidadVentaObject() {	
		this.rangounidadventaObject=this.rangounidadventaDataAccess.getEntityObject();
		return this.rangounidadventaObject;
	}
		
	public void setRangoUnidadVentaObject(Object newRangoUnidadVentaObject) {
		this.rangounidadventaObject = newRangoUnidadVentaObject;
	}
	
	public List<Object> getRangoUnidadVentasObject() {		
		this.rangounidadventasObject=this.rangounidadventaDataAccess.getEntitiesObject();
		return this.rangounidadventasObject;
	}
		
	public void setRangoUnidadVentasObject(List<Object> newRangoUnidadVentasObject) {
		this.rangounidadventasObject = newRangoUnidadVentasObject;
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
		
		if(this.rangounidadventaDataAccess!=null) {
			this.rangounidadventaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoUnidadVenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			rangounidadventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			rangounidadventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		rangounidadventa = new  RangoUnidadVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoUnidadVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			rangounidadventa=rangounidadventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rangounidadventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(this.rangounidadventa);
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
		rangounidadventa = new  RangoUnidadVenta();
		  		  
        try {
			
			rangounidadventa=rangounidadventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rangounidadventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(this.rangounidadventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		rangounidadventa = new  RangoUnidadVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoUnidadVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			rangounidadventa=rangounidadventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rangounidadventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(this.rangounidadventa);
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
		rangounidadventa = new  RangoUnidadVenta();
		  		  
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
		rangounidadventa = new  RangoUnidadVenta();
		  		  
        try {
			
			rangounidadventa=rangounidadventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rangounidadventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(this.rangounidadventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		rangounidadventa = new  RangoUnidadVenta();
		  		  
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
		rangounidadventa = new  RangoUnidadVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoUnidadVenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =rangounidadventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rangounidadventa = new  RangoUnidadVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=rangounidadventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		rangounidadventa = new  RangoUnidadVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoUnidadVenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =rangounidadventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rangounidadventa = new  RangoUnidadVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=rangounidadventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		rangounidadventa = new  RangoUnidadVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoUnidadVenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =rangounidadventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rangounidadventa = new  RangoUnidadVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=rangounidadventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		rangounidadventas = new  ArrayList<RangoUnidadVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoUnidadVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			RangoUnidadVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangounidadventas=rangounidadventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRangoUnidadVenta(rangounidadventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(this.rangounidadventas);
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
		rangounidadventas = new  ArrayList<RangoUnidadVenta>();
		  		  
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
		rangounidadventas = new  ArrayList<RangoUnidadVenta>();
		  		  
        try {			
			RangoUnidadVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangounidadventas=rangounidadventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarRangoUnidadVenta(rangounidadventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(this.rangounidadventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		rangounidadventas = new  ArrayList<RangoUnidadVenta>();
		  		  
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
		rangounidadventas = new  ArrayList<RangoUnidadVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoUnidadVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			RangoUnidadVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangounidadventas=rangounidadventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRangoUnidadVenta(rangounidadventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(this.rangounidadventas);
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
		rangounidadventas = new  ArrayList<RangoUnidadVenta>();
		  		  
        try {
			RangoUnidadVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangounidadventas=rangounidadventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRangoUnidadVenta(rangounidadventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(this.rangounidadventas);
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
		rangounidadventas = new  ArrayList<RangoUnidadVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoUnidadVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RangoUnidadVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangounidadventas=rangounidadventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRangoUnidadVenta(rangounidadventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(this.rangounidadventas);
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
		rangounidadventas = new  ArrayList<RangoUnidadVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RangoUnidadVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangounidadventas=rangounidadventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRangoUnidadVenta(rangounidadventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(this.rangounidadventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		rangounidadventa = new  RangoUnidadVenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoUnidadVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RangoUnidadVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangounidadventa=rangounidadventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRangoUnidadVenta(rangounidadventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(this.rangounidadventa);
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
		rangounidadventa = new  RangoUnidadVenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RangoUnidadVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangounidadventa=rangounidadventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRangoUnidadVenta(rangounidadventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(this.rangounidadventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		rangounidadventas = new  ArrayList<RangoUnidadVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoUnidadVenta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			RangoUnidadVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangounidadventas=rangounidadventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRangoUnidadVenta(rangounidadventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(this.rangounidadventas);
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
		rangounidadventas = new  ArrayList<RangoUnidadVenta>();
		  		  
        try {
			RangoUnidadVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangounidadventas=rangounidadventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRangoUnidadVenta(rangounidadventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(this.rangounidadventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosRangoUnidadVentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		rangounidadventas = new  ArrayList<RangoUnidadVenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoUnidadVenta.class.getSimpleName()+"-getTodosRangoUnidadVentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RangoUnidadVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangounidadventas=rangounidadventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRangoUnidadVenta(rangounidadventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(this.rangounidadventas);
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
	
	public  void  getTodosRangoUnidadVentas(String sFinalQuery,Pagination pagination)throws Exception {
		rangounidadventas = new  ArrayList<RangoUnidadVenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RangoUnidadVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangounidadventas=rangounidadventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRangoUnidadVenta(rangounidadventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(this.rangounidadventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarRangoUnidadVenta(RangoUnidadVenta rangounidadventa) throws Exception {
		Boolean estaValidado=false;
		
		if(rangounidadventa.getIsNew() || rangounidadventa.getIsChanged()) { 
			this.invalidValues = rangounidadventaValidator.getInvalidValues(rangounidadventa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(rangounidadventa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarRangoUnidadVenta(List<RangoUnidadVenta> RangoUnidadVentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(RangoUnidadVenta rangounidadventaLocal:rangounidadventas) {				
			estaValidadoObjeto=this.validarGuardarRangoUnidadVenta(rangounidadventaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarRangoUnidadVenta(List<RangoUnidadVenta> RangoUnidadVentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRangoUnidadVenta(rangounidadventas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarRangoUnidadVenta(RangoUnidadVenta RangoUnidadVenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRangoUnidadVenta(rangounidadventa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(RangoUnidadVenta rangounidadventa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+rangounidadventa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=RangoUnidadVentaConstantesFunciones.getRangoUnidadVentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"rangounidadventa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(RangoUnidadVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(RangoUnidadVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveRangoUnidadVentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoUnidadVenta.class.getSimpleName()+"-saveRangoUnidadVentaWithConnection");connexion.begin();			
			
			RangoUnidadVentaLogicAdditional.checkRangoUnidadVentaToSave(this.rangounidadventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RangoUnidadVentaLogicAdditional.updateRangoUnidadVentaToSave(this.rangounidadventa,this.arrDatoGeneral);
			
			RangoUnidadVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.rangounidadventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowRangoUnidadVenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRangoUnidadVenta(this.rangounidadventa)) {
				RangoUnidadVentaDataAccess.save(this.rangounidadventa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.rangounidadventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RangoUnidadVentaLogicAdditional.checkRangoUnidadVentaToSaveAfter(this.rangounidadventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRangoUnidadVenta();
			
			connexion.commit();			
			
			if(this.rangounidadventa.getIsDeleted()) {
				this.rangounidadventa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveRangoUnidadVenta()throws Exception {	
		try {	
			
			RangoUnidadVentaLogicAdditional.checkRangoUnidadVentaToSave(this.rangounidadventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RangoUnidadVentaLogicAdditional.updateRangoUnidadVentaToSave(this.rangounidadventa,this.arrDatoGeneral);
			
			RangoUnidadVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.rangounidadventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRangoUnidadVenta(this.rangounidadventa)) {			
				RangoUnidadVentaDataAccess.save(this.rangounidadventa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.rangounidadventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RangoUnidadVentaLogicAdditional.checkRangoUnidadVentaToSaveAfter(this.rangounidadventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.rangounidadventa.getIsDeleted()) {
				this.rangounidadventa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveRangoUnidadVentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoUnidadVenta.class.getSimpleName()+"-saveRangoUnidadVentasWithConnection");connexion.begin();			
			
			RangoUnidadVentaLogicAdditional.checkRangoUnidadVentaToSaves(rangounidadventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowRangoUnidadVentas();
			
			Boolean validadoTodosRangoUnidadVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RangoUnidadVenta rangounidadventaLocal:rangounidadventas) {		
				if(rangounidadventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RangoUnidadVentaLogicAdditional.updateRangoUnidadVentaToSave(rangounidadventaLocal,this.arrDatoGeneral);
	        	
				RangoUnidadVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),rangounidadventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRangoUnidadVenta(rangounidadventaLocal)) {
					RangoUnidadVentaDataAccess.save(rangounidadventaLocal, connexion);				
				} else {
					validadoTodosRangoUnidadVenta=false;
				}
			}
			
			if(!validadoTodosRangoUnidadVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RangoUnidadVentaLogicAdditional.checkRangoUnidadVentaToSavesAfter(rangounidadventas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRangoUnidadVentas();
			
			connexion.commit();		
			
			this.quitarRangoUnidadVentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveRangoUnidadVentas()throws Exception {				
		 try {	
			RangoUnidadVentaLogicAdditional.checkRangoUnidadVentaToSaves(rangounidadventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosRangoUnidadVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RangoUnidadVenta rangounidadventaLocal:rangounidadventas) {				
				if(rangounidadventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RangoUnidadVentaLogicAdditional.updateRangoUnidadVentaToSave(rangounidadventaLocal,this.arrDatoGeneral);
	        	
				RangoUnidadVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),rangounidadventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRangoUnidadVenta(rangounidadventaLocal)) {				
					RangoUnidadVentaDataAccess.save(rangounidadventaLocal, connexion);				
				} else {
					validadoTodosRangoUnidadVenta=false;
				}
			}
			
			if(!validadoTodosRangoUnidadVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RangoUnidadVentaLogicAdditional.checkRangoUnidadVentaToSavesAfter(rangounidadventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarRangoUnidadVentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RangoUnidadVentaParameterReturnGeneral procesarAccionRangoUnidadVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RangoUnidadVenta> rangounidadventas,RangoUnidadVentaParameterReturnGeneral rangounidadventaParameterGeneral)throws Exception {
		 try {	
			RangoUnidadVentaParameterReturnGeneral rangounidadventaReturnGeneral=new RangoUnidadVentaParameterReturnGeneral();
	
			RangoUnidadVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,rangounidadventas,rangounidadventaParameterGeneral,rangounidadventaReturnGeneral);
			
			return rangounidadventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RangoUnidadVentaParameterReturnGeneral procesarAccionRangoUnidadVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RangoUnidadVenta> rangounidadventas,RangoUnidadVentaParameterReturnGeneral rangounidadventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoUnidadVenta.class.getSimpleName()+"-procesarAccionRangoUnidadVentasWithConnection");connexion.begin();			
			
			RangoUnidadVentaParameterReturnGeneral rangounidadventaReturnGeneral=new RangoUnidadVentaParameterReturnGeneral();
	
			RangoUnidadVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,rangounidadventas,rangounidadventaParameterGeneral,rangounidadventaReturnGeneral);
			
			this.connexion.commit();
			
			return rangounidadventaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RangoUnidadVentaParameterReturnGeneral procesarEventosRangoUnidadVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RangoUnidadVenta> rangounidadventas,RangoUnidadVenta rangounidadventa,RangoUnidadVentaParameterReturnGeneral rangounidadventaParameterGeneral,Boolean isEsNuevoRangoUnidadVenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			RangoUnidadVentaParameterReturnGeneral rangounidadventaReturnGeneral=new RangoUnidadVentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				rangounidadventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RangoUnidadVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,rangounidadventas,rangounidadventa,rangounidadventaParameterGeneral,rangounidadventaReturnGeneral,isEsNuevoRangoUnidadVenta,clases);
			
			return rangounidadventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public RangoUnidadVentaParameterReturnGeneral procesarEventosRangoUnidadVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RangoUnidadVenta> rangounidadventas,RangoUnidadVenta rangounidadventa,RangoUnidadVentaParameterReturnGeneral rangounidadventaParameterGeneral,Boolean isEsNuevoRangoUnidadVenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoUnidadVenta.class.getSimpleName()+"-procesarEventosRangoUnidadVentasWithConnection");connexion.begin();			
			
			RangoUnidadVentaParameterReturnGeneral rangounidadventaReturnGeneral=new RangoUnidadVentaParameterReturnGeneral();
	
			rangounidadventaReturnGeneral.setRangoUnidadVenta(rangounidadventa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				rangounidadventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RangoUnidadVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,rangounidadventas,rangounidadventa,rangounidadventaParameterGeneral,rangounidadventaReturnGeneral,isEsNuevoRangoUnidadVenta,clases);
			
			this.connexion.commit();
			
			return rangounidadventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RangoUnidadVentaParameterReturnGeneral procesarImportacionRangoUnidadVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,RangoUnidadVentaParameterReturnGeneral rangounidadventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoUnidadVenta.class.getSimpleName()+"-procesarImportacionRangoUnidadVentasWithConnection");connexion.begin();			
			
			RangoUnidadVentaParameterReturnGeneral rangounidadventaReturnGeneral=new RangoUnidadVentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.rangounidadventas=new ArrayList<RangoUnidadVenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.rangounidadventa=new RangoUnidadVenta();
				
				
				if(conColumnasBase) {this.rangounidadventa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.rangounidadventa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.rangounidadventa.setrango_inicial(Double.parseDouble(arrColumnas[iColumn++]));
				this.rangounidadventa.setrango_final(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.rangounidadventas.add(this.rangounidadventa);
			}
			
			this.saveRangoUnidadVentas();
			
			this.connexion.commit();
			
			rangounidadventaReturnGeneral.setConRetornoEstaProcesado(true);
			rangounidadventaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return rangounidadventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarRangoUnidadVentasEliminados() throws Exception {				
		
		List<RangoUnidadVenta> rangounidadventasAux= new ArrayList<RangoUnidadVenta>();
		
		for(RangoUnidadVenta rangounidadventa:rangounidadventas) {
			if(!rangounidadventa.getIsDeleted()) {
				rangounidadventasAux.add(rangounidadventa);
			}
		}
		
		rangounidadventas=rangounidadventasAux;
	}
	
	public void quitarRangoUnidadVentasNulos() throws Exception {				
		
		List<RangoUnidadVenta> rangounidadventasAux= new ArrayList<RangoUnidadVenta>();
		
		for(RangoUnidadVenta rangounidadventa : this.rangounidadventas) {
			if(rangounidadventa==null) {
				rangounidadventasAux.add(rangounidadventa);
			}
		}
		
		//this.rangounidadventas=rangounidadventasAux;
		
		this.rangounidadventas.removeAll(rangounidadventasAux);
	}
	
	public void getSetVersionRowRangoUnidadVentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(rangounidadventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((rangounidadventa.getIsDeleted() || (rangounidadventa.getIsChanged()&&!rangounidadventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=rangounidadventaDataAccess.getSetVersionRowRangoUnidadVenta(connexion,rangounidadventa.getId());
				
				if(!rangounidadventa.getVersionRow().equals(timestamp)) {	
					rangounidadventa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				rangounidadventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowRangoUnidadVenta()throws Exception {	
		
		if(rangounidadventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((rangounidadventa.getIsDeleted() || (rangounidadventa.getIsChanged()&&!rangounidadventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=rangounidadventaDataAccess.getSetVersionRowRangoUnidadVenta(connexion,rangounidadventa.getId());
			
			try {							
				if(!rangounidadventa.getVersionRow().equals(timestamp)) {	
					rangounidadventa.setVersionRow(timestamp);
				}
				
				rangounidadventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowRangoUnidadVentasWithConnection()throws Exception {	
		if(rangounidadventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(RangoUnidadVenta rangounidadventaAux:rangounidadventas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(rangounidadventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(rangounidadventaAux.getIsDeleted() || (rangounidadventaAux.getIsChanged()&&!rangounidadventaAux.getIsNew())) {
						
						timestamp=rangounidadventaDataAccess.getSetVersionRowRangoUnidadVenta(connexion,rangounidadventaAux.getId());
						
						if(!rangounidadventa.getVersionRow().equals(timestamp)) {	
							rangounidadventaAux.setVersionRow(timestamp);
						}
								
						rangounidadventaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowRangoUnidadVentas()throws Exception {	
		if(rangounidadventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(RangoUnidadVenta rangounidadventaAux:rangounidadventas) {
					if(rangounidadventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(rangounidadventaAux.getIsDeleted() || (rangounidadventaAux.getIsChanged()&&!rangounidadventaAux.getIsNew())) {
						
						timestamp=rangounidadventaDataAccess.getSetVersionRowRangoUnidadVenta(connexion,rangounidadventaAux.getId());
						
						if(!rangounidadventaAux.getVersionRow().equals(timestamp)) {	
							rangounidadventaAux.setVersionRow(timestamp);
						}
						
													
						rangounidadventaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public RangoUnidadVentaParameterReturnGeneral cargarCombosLoteForeignKeyRangoUnidadVentaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalUnidad) throws Exception {
		RangoUnidadVentaParameterReturnGeneral  rangounidadventaReturnGeneral =new RangoUnidadVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoUnidadVenta.class.getSimpleName()+"-cargarCombosLoteForeignKeyRangoUnidadVentaWithConnection");connexion.begin();
			
			rangounidadventaReturnGeneral =new RangoUnidadVentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			rangounidadventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			rangounidadventaReturnGeneral.setunidadsForeignKey(unidadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return rangounidadventaReturnGeneral;
	}
	
	public RangoUnidadVentaParameterReturnGeneral cargarCombosLoteForeignKeyRangoUnidadVenta(String finalQueryGlobalEmpresa,String finalQueryGlobalUnidad) throws Exception {
		RangoUnidadVentaParameterReturnGeneral  rangounidadventaReturnGeneral =new RangoUnidadVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			rangounidadventaReturnGeneral =new RangoUnidadVentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			rangounidadventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			rangounidadventaReturnGeneral.setunidadsForeignKey(unidadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return rangounidadventaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyRangoUnidadVentaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PrecioLogic precioLogic=new PrecioLogic();
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic=new ParametroInventarioDefectoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoUnidadVenta.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyRangoUnidadVentaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Precio.class));
			classes.add(new Classe(ParametroInventarioDefecto.class));
											
			

			precioLogic.setConnexion(this.getConnexion());
			precioLogic.setDatosCliente(this.datosCliente);
			precioLogic.setIsConRefrescarForeignKeys(true);

			parametroinventariodefectoLogic.setConnexion(this.getConnexion());
			parametroinventariodefectoLogic.setDatosCliente(this.datosCliente);
			parametroinventariodefectoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(RangoUnidadVenta rangounidadventa:this.rangounidadventas) {
				

				classes=new ArrayList<Classe>();
				classes=PrecioConstantesFunciones.getClassesForeignKeysOfPrecio(new ArrayList<Classe>(),DeepLoadType.NONE);

				precioLogic.setPrecios(rangounidadventa.precios);
				precioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroInventarioDefectoConstantesFunciones.getClassesForeignKeysOfParametroInventarioDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametroinventariodefectoLogic.setParametroInventarioDefectos(rangounidadventa.parametroinventariodefectos);
				parametroinventariodefectoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(RangoUnidadVenta rangounidadventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RangoUnidadVentaLogicAdditional.updateRangoUnidadVentaToGet(rangounidadventa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		rangounidadventa.setEmpresa(rangounidadventaDataAccess.getEmpresa(connexion,rangounidadventa));
		rangounidadventa.setUnidad(rangounidadventaDataAccess.getUnidad(connexion,rangounidadventa));
		rangounidadventa.setPrecios(rangounidadventaDataAccess.getPrecios(connexion,rangounidadventa));
		rangounidadventa.setParametroInventarioDefectos(rangounidadventaDataAccess.getParametroInventarioDefectos(connexion,rangounidadventa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				rangounidadventa.setEmpresa(rangounidadventaDataAccess.getEmpresa(connexion,rangounidadventa));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				rangounidadventa.setUnidad(rangounidadventaDataAccess.getUnidad(connexion,rangounidadventa));
				continue;
			}

			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rangounidadventa.setPrecios(rangounidadventaDataAccess.getPrecios(connexion,rangounidadventa));

				if(this.isConDeep) {
					PrecioLogic precioLogic= new PrecioLogic(this.connexion);
					precioLogic.setPrecios(rangounidadventa.getPrecios());
					ArrayList<Classe> classesLocal=PrecioConstantesFunciones.getClassesForeignKeysOfPrecio(new ArrayList<Classe>(),DeepLoadType.NONE);
					precioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(precioLogic.getPrecios());
					rangounidadventa.setPrecios(precioLogic.getPrecios());
				}

				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rangounidadventa.setParametroInventarioDefectos(rangounidadventaDataAccess.getParametroInventarioDefectos(connexion,rangounidadventa));

				if(this.isConDeep) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(this.connexion);
					parametroinventariodefectoLogic.setParametroInventarioDefectos(rangounidadventa.getParametroInventarioDefectos());
					ArrayList<Classe> classesLocal=ParametroInventarioDefectoConstantesFunciones.getClassesForeignKeysOfParametroInventarioDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametroinventariodefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(parametroinventariodefectoLogic.getParametroInventarioDefectos());
					rangounidadventa.setParametroInventarioDefectos(parametroinventariodefectoLogic.getParametroInventarioDefectos());
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
			rangounidadventa.setEmpresa(rangounidadventaDataAccess.getEmpresa(connexion,rangounidadventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rangounidadventa.setUnidad(rangounidadventaDataAccess.getUnidad(connexion,rangounidadventa));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Precio.class));
			rangounidadventa.setPrecios(rangounidadventaDataAccess.getPrecios(connexion,rangounidadventa));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroInventarioDefecto.class));
			rangounidadventa.setParametroInventarioDefectos(rangounidadventaDataAccess.getParametroInventarioDefectos(connexion,rangounidadventa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		rangounidadventa.setEmpresa(rangounidadventaDataAccess.getEmpresa(connexion,rangounidadventa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(rangounidadventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		rangounidadventa.setUnidad(rangounidadventaDataAccess.getUnidad(connexion,rangounidadventa));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(rangounidadventa.getUnidad(),isDeep,deepLoadType,clases);
				

		rangounidadventa.setPrecios(rangounidadventaDataAccess.getPrecios(connexion,rangounidadventa));

		for(Precio precio:rangounidadventa.getPrecios()) {
			PrecioLogic precioLogic= new PrecioLogic(connexion);
			precioLogic.deepLoad(precio,isDeep,deepLoadType,clases);
		}

		rangounidadventa.setParametroInventarioDefectos(rangounidadventaDataAccess.getParametroInventarioDefectos(connexion,rangounidadventa));

		for(ParametroInventarioDefecto parametroinventariodefecto:rangounidadventa.getParametroInventarioDefectos()) {
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
			parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				rangounidadventa.setEmpresa(rangounidadventaDataAccess.getEmpresa(connexion,rangounidadventa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(rangounidadventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				rangounidadventa.setUnidad(rangounidadventaDataAccess.getUnidad(connexion,rangounidadventa));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(rangounidadventa.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rangounidadventa.setPrecios(rangounidadventaDataAccess.getPrecios(connexion,rangounidadventa));

				for(Precio precio:rangounidadventa.getPrecios()) {
					PrecioLogic precioLogic= new PrecioLogic(connexion);
					precioLogic.deepLoad(precio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rangounidadventa.setParametroInventarioDefectos(rangounidadventaDataAccess.getParametroInventarioDefectos(connexion,rangounidadventa));

				for(ParametroInventarioDefecto parametroinventariodefecto:rangounidadventa.getParametroInventarioDefectos()) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
					parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
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
			rangounidadventa.setEmpresa(rangounidadventaDataAccess.getEmpresa(connexion,rangounidadventa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(rangounidadventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rangounidadventa.setUnidad(rangounidadventaDataAccess.getUnidad(connexion,rangounidadventa));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(rangounidadventa.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Precio.class));
			rangounidadventa.setPrecios(rangounidadventaDataAccess.getPrecios(connexion,rangounidadventa));

			for(Precio precio:rangounidadventa.getPrecios()) {
				PrecioLogic precioLogic= new PrecioLogic(connexion);
				precioLogic.deepLoad(precio,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroInventarioDefecto.class));
			rangounidadventa.setParametroInventarioDefectos(rangounidadventaDataAccess.getParametroInventarioDefectos(connexion,rangounidadventa));

			for(ParametroInventarioDefecto parametroinventariodefecto:rangounidadventa.getParametroInventarioDefectos()) {
				ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
				parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(RangoUnidadVenta rangounidadventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			RangoUnidadVentaLogicAdditional.updateRangoUnidadVentaToSave(rangounidadventa,this.arrDatoGeneral);
			
RangoUnidadVentaDataAccess.save(rangounidadventa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(rangounidadventa.getEmpresa(),connexion);

		UnidadDataAccess.save(rangounidadventa.getUnidad(),connexion);

		for(Precio precio:rangounidadventa.getPrecios()) {
			precio.setid_rango_unidad_venta(rangounidadventa.getId());
			PrecioDataAccess.save(precio,connexion);
		}

		for(ParametroInventarioDefecto parametroinventariodefecto:rangounidadventa.getParametroInventarioDefectos()) {
			parametroinventariodefecto.setid_rango_unidad_venta(rangounidadventa.getId());
			ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(rangounidadventa.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(rangounidadventa.getUnidad(),connexion);
				continue;
			}


			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Precio precio:rangounidadventa.getPrecios()) {
					precio.setid_rango_unidad_venta(rangounidadventa.getId());
					PrecioDataAccess.save(precio,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroInventarioDefecto parametroinventariodefecto:rangounidadventa.getParametroInventarioDefectos()) {
					parametroinventariodefecto.setid_rango_unidad_venta(rangounidadventa.getId());
					ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(rangounidadventa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(rangounidadventa.getEmpresa(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(rangounidadventa.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(rangounidadventa.getUnidad(),isDeep,deepLoadType,clases);
				

		for(Precio precio:rangounidadventa.getPrecios()) {
			PrecioLogic precioLogic= new PrecioLogic(connexion);
			precio.setid_rango_unidad_venta(rangounidadventa.getId());
			PrecioDataAccess.save(precio,connexion);
			precioLogic.deepSave(precio,isDeep,deepLoadType,clases);
		}

		for(ParametroInventarioDefecto parametroinventariodefecto:rangounidadventa.getParametroInventarioDefectos()) {
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
			parametroinventariodefecto.setid_rango_unidad_venta(rangounidadventa.getId());
			ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
			parametroinventariodefectoLogic.deepSave(parametroinventariodefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(rangounidadventa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(rangounidadventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(rangounidadventa.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(rangounidadventa.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Precio precio:rangounidadventa.getPrecios()) {
					PrecioLogic precioLogic= new PrecioLogic(connexion);
					precio.setid_rango_unidad_venta(rangounidadventa.getId());
					PrecioDataAccess.save(precio,connexion);
					precioLogic.deepSave(precio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroInventarioDefecto parametroinventariodefecto:rangounidadventa.getParametroInventarioDefectos()) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
					parametroinventariodefecto.setid_rango_unidad_venta(rangounidadventa.getId());
					ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
					parametroinventariodefectoLogic.deepSave(parametroinventariodefecto,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(RangoUnidadVenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(rangounidadventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(rangounidadventa);
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
			this.deepLoad(this.rangounidadventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(this.rangounidadventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(RangoUnidadVenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(rangounidadventas!=null) {
				for(RangoUnidadVenta rangounidadventa:rangounidadventas) {
					this.deepLoad(rangounidadventa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(rangounidadventas);
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
			if(rangounidadventas!=null) {
				for(RangoUnidadVenta rangounidadventa:rangounidadventas) {
					this.deepLoad(rangounidadventa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(rangounidadventas);
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
			this.getNewConnexionToDeep(RangoUnidadVenta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(rangounidadventa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(RangoUnidadVenta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(rangounidadventas!=null) {
				for(RangoUnidadVenta rangounidadventa:rangounidadventas) {
					this.deepSave(rangounidadventa,isDeep,deepLoadType,clases);
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
			if(rangounidadventas!=null) {
				for(RangoUnidadVenta rangounidadventa:rangounidadventas) {
					this.deepSave(rangounidadventa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getRangoUnidadVentasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoUnidadVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RangoUnidadVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RangoUnidadVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rangounidadventas=rangounidadventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(this.rangounidadventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRangoUnidadVentasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RangoUnidadVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RangoUnidadVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rangounidadventas=rangounidadventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(this.rangounidadventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRangoUnidadVentasFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoUnidadVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,RangoUnidadVentaConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			RangoUnidadVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rangounidadventas=rangounidadventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(this.rangounidadventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRangoUnidadVentasFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,RangoUnidadVentaConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			RangoUnidadVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rangounidadventas=rangounidadventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(this.rangounidadventas);
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
			if(RangoUnidadVentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,RangoUnidadVentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,RangoUnidadVenta rangounidadventa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(RangoUnidadVentaConstantesFunciones.ISCONAUDITORIA) {
				if(rangounidadventa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RangoUnidadVentaDataAccess.TABLENAME, rangounidadventa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RangoUnidadVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RangoUnidadVentaLogic.registrarAuditoriaDetallesRangoUnidadVenta(connexion,rangounidadventa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(rangounidadventa.getIsDeleted()) {
					/*if(!rangounidadventa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,RangoUnidadVentaDataAccess.TABLENAME, rangounidadventa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////RangoUnidadVentaLogic.registrarAuditoriaDetallesRangoUnidadVenta(connexion,rangounidadventa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RangoUnidadVentaDataAccess.TABLENAME, rangounidadventa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(rangounidadventa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RangoUnidadVentaDataAccess.TABLENAME, rangounidadventa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RangoUnidadVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RangoUnidadVentaLogic.registrarAuditoriaDetallesRangoUnidadVenta(connexion,rangounidadventa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesRangoUnidadVenta(Connexion connexion,RangoUnidadVenta rangounidadventa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(rangounidadventa.getIsNew()||!rangounidadventa.getid_empresa().equals(rangounidadventa.getRangoUnidadVentaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rangounidadventa.getRangoUnidadVentaOriginal().getid_empresa()!=null)
				{
					strValorActual=rangounidadventa.getRangoUnidadVentaOriginal().getid_empresa().toString();
				}
				if(rangounidadventa.getid_empresa()!=null)
				{
					strValorNuevo=rangounidadventa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RangoUnidadVentaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(rangounidadventa.getIsNew()||!rangounidadventa.getid_unidad().equals(rangounidadventa.getRangoUnidadVentaOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rangounidadventa.getRangoUnidadVentaOriginal().getid_unidad()!=null)
				{
					strValorActual=rangounidadventa.getRangoUnidadVentaOriginal().getid_unidad().toString();
				}
				if(rangounidadventa.getid_unidad()!=null)
				{
					strValorNuevo=rangounidadventa.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RangoUnidadVentaConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(rangounidadventa.getIsNew()||!rangounidadventa.getrango_inicial().equals(rangounidadventa.getRangoUnidadVentaOriginal().getrango_inicial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rangounidadventa.getRangoUnidadVentaOriginal().getrango_inicial()!=null)
				{
					strValorActual=rangounidadventa.getRangoUnidadVentaOriginal().getrango_inicial().toString();
				}
				if(rangounidadventa.getrango_inicial()!=null)
				{
					strValorNuevo=rangounidadventa.getrango_inicial().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RangoUnidadVentaConstantesFunciones.RANGOINICIAL,strValorActual,strValorNuevo);
			}	
			
			if(rangounidadventa.getIsNew()||!rangounidadventa.getrango_final().equals(rangounidadventa.getRangoUnidadVentaOriginal().getrango_final()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rangounidadventa.getRangoUnidadVentaOriginal().getrango_final()!=null)
				{
					strValorActual=rangounidadventa.getRangoUnidadVentaOriginal().getrango_final().toString();
				}
				if(rangounidadventa.getrango_final()!=null)
				{
					strValorNuevo=rangounidadventa.getrango_final().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RangoUnidadVentaConstantesFunciones.RANGOFINAL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveRangoUnidadVentaRelacionesWithConnection(RangoUnidadVenta rangounidadventa,List<Precio> precios,List<ParametroInventarioDefecto> parametroinventariodefectos) throws Exception {

		if(!rangounidadventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRangoUnidadVentaRelacionesBase(rangounidadventa,precios,parametroinventariodefectos,true);
		}
	}

	public void saveRangoUnidadVentaRelaciones(RangoUnidadVenta rangounidadventa,List<Precio> precios,List<ParametroInventarioDefecto> parametroinventariodefectos)throws Exception {

		if(!rangounidadventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRangoUnidadVentaRelacionesBase(rangounidadventa,precios,parametroinventariodefectos,false);
		}
	}

	public void saveRangoUnidadVentaRelacionesBase(RangoUnidadVenta rangounidadventa,List<Precio> precios,List<ParametroInventarioDefecto> parametroinventariodefectos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("RangoUnidadVenta-saveRelacionesWithConnection");}
	
			rangounidadventa.setPrecios(precios);
			rangounidadventa.setParametroInventarioDefectos(parametroinventariodefectos);

			this.setRangoUnidadVenta(rangounidadventa);

			if(RangoUnidadVentaLogicAdditional.validarSaveRelaciones(rangounidadventa,this)) {

				RangoUnidadVentaLogicAdditional.updateRelacionesToSave(rangounidadventa,this);

				if((rangounidadventa.getIsNew()||rangounidadventa.getIsChanged())&&!rangounidadventa.getIsDeleted()) {
					this.saveRangoUnidadVenta();
					this.saveRangoUnidadVentaRelacionesDetalles(precios,parametroinventariodefectos);

				} else if(rangounidadventa.getIsDeleted()) {
					this.saveRangoUnidadVentaRelacionesDetalles(precios,parametroinventariodefectos);
					this.saveRangoUnidadVenta();
				}

				RangoUnidadVentaLogicAdditional.updateRelacionesToSaveAfter(rangounidadventa,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			PrecioConstantesFunciones.InicializarGeneralEntityAuxiliaresPrecios(precios,true,true);
			ParametroInventarioDefectoConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroInventarioDefectos(parametroinventariodefectos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveRangoUnidadVentaRelacionesDetalles(List<Precio> precios,List<ParametroInventarioDefecto> parametroinventariodefectos)throws Exception {
		try {
	

			Long idRangoUnidadVentaActual=this.getRangoUnidadVenta().getId();

			PrecioLogic precioLogic_Desde_RangoUnidadVenta=new PrecioLogic();
			precioLogic_Desde_RangoUnidadVenta.setPrecios(precios);

			precioLogic_Desde_RangoUnidadVenta.setConnexion(this.getConnexion());
			precioLogic_Desde_RangoUnidadVenta.setDatosCliente(this.datosCliente);

			for(Precio precio_Desde_RangoUnidadVenta:precioLogic_Desde_RangoUnidadVenta.getPrecios()) {
				precio_Desde_RangoUnidadVenta.setid_rango_unidad_venta(idRangoUnidadVentaActual);
			}

			precioLogic_Desde_RangoUnidadVenta.savePrecios();

			ParametroInventarioDefectoLogic parametroinventariodefectoLogic_Desde_RangoUnidadVenta=new ParametroInventarioDefectoLogic();
			parametroinventariodefectoLogic_Desde_RangoUnidadVenta.setParametroInventarioDefectos(parametroinventariodefectos);

			parametroinventariodefectoLogic_Desde_RangoUnidadVenta.setConnexion(this.getConnexion());
			parametroinventariodefectoLogic_Desde_RangoUnidadVenta.setDatosCliente(this.datosCliente);

			for(ParametroInventarioDefecto parametroinventariodefecto_Desde_RangoUnidadVenta:parametroinventariodefectoLogic_Desde_RangoUnidadVenta.getParametroInventarioDefectos()) {
				parametroinventariodefecto_Desde_RangoUnidadVenta.setid_rango_unidad_venta(idRangoUnidadVentaActual);
			}

			parametroinventariodefectoLogic_Desde_RangoUnidadVenta.saveParametroInventarioDefectos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfRangoUnidadVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RangoUnidadVentaConstantesFunciones.getClassesForeignKeysOfRangoUnidadVenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRangoUnidadVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RangoUnidadVentaConstantesFunciones.getClassesRelationshipsOfRangoUnidadVenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

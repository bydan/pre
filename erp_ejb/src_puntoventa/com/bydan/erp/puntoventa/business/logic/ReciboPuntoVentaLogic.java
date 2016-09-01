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
import com.bydan.erp.puntoventa.util.ReciboPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.ReciboPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.ReciboPuntoVentaParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.ReciboPuntoVenta;
import com.bydan.erp.puntoventa.business.logic.ReciboPuntoVentaLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class ReciboPuntoVentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ReciboPuntoVentaLogic.class);
	
	protected ReciboPuntoVentaDataAccess recibopuntoventaDataAccess; 	
	protected ReciboPuntoVenta recibopuntoventa;
	protected List<ReciboPuntoVenta> recibopuntoventas;
	protected Object recibopuntoventaObject;	
	protected List<Object> recibopuntoventasObject;
	
	public static ClassValidator<ReciboPuntoVenta> recibopuntoventaValidator = new ClassValidator<ReciboPuntoVenta>(ReciboPuntoVenta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ReciboPuntoVentaLogicAdditional recibopuntoventaLogicAdditional=null;
	
	public ReciboPuntoVentaLogicAdditional getReciboPuntoVentaLogicAdditional() {
		return this.recibopuntoventaLogicAdditional;
	}
	
	public void setReciboPuntoVentaLogicAdditional(ReciboPuntoVentaLogicAdditional recibopuntoventaLogicAdditional) {
		try {
			this.recibopuntoventaLogicAdditional=recibopuntoventaLogicAdditional;
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
	
	
	
	
	public  ReciboPuntoVentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.recibopuntoventaDataAccess = new ReciboPuntoVentaDataAccess();
			
			this.recibopuntoventas= new ArrayList<ReciboPuntoVenta>();
			this.recibopuntoventa= new ReciboPuntoVenta();
			
			this.recibopuntoventaObject=new Object();
			this.recibopuntoventasObject=new ArrayList<Object>();
				
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
			
			this.recibopuntoventaDataAccess.setConnexionType(this.connexionType);
			this.recibopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ReciboPuntoVentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.recibopuntoventaDataAccess = new ReciboPuntoVentaDataAccess();
			this.recibopuntoventas= new ArrayList<ReciboPuntoVenta>();
			this.recibopuntoventa= new ReciboPuntoVenta();
			this.recibopuntoventaObject=new Object();
			this.recibopuntoventasObject=new ArrayList<Object>();
			
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
			
			this.recibopuntoventaDataAccess.setConnexionType(this.connexionType);
			this.recibopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ReciboPuntoVenta getReciboPuntoVenta() throws Exception {	
		ReciboPuntoVentaLogicAdditional.checkReciboPuntoVentaToGet(recibopuntoventa,this.datosCliente,this.arrDatoGeneral);
		ReciboPuntoVentaLogicAdditional.updateReciboPuntoVentaToGet(recibopuntoventa,this.arrDatoGeneral);
		
		return recibopuntoventa;
	}
		
	public void setReciboPuntoVenta(ReciboPuntoVenta newReciboPuntoVenta) {
		this.recibopuntoventa = newReciboPuntoVenta;
	}
	
	public ReciboPuntoVentaDataAccess getReciboPuntoVentaDataAccess() {
		return recibopuntoventaDataAccess;
	}
	
	public void setReciboPuntoVentaDataAccess(ReciboPuntoVentaDataAccess newrecibopuntoventaDataAccess) {
		this.recibopuntoventaDataAccess = newrecibopuntoventaDataAccess;
	}
	
	public List<ReciboPuntoVenta> getReciboPuntoVentas() throws Exception {		
		this.quitarReciboPuntoVentasNulos();
		
		ReciboPuntoVentaLogicAdditional.checkReciboPuntoVentaToGets(recibopuntoventas,this.datosCliente,this.arrDatoGeneral);
		
		for (ReciboPuntoVenta recibopuntoventaLocal: recibopuntoventas ) {
			ReciboPuntoVentaLogicAdditional.updateReciboPuntoVentaToGet(recibopuntoventaLocal,this.arrDatoGeneral);
		}
		
		return recibopuntoventas;
	}
	
	public void setReciboPuntoVentas(List<ReciboPuntoVenta> newReciboPuntoVentas) {
		this.recibopuntoventas = newReciboPuntoVentas;
	}
	
	public Object getReciboPuntoVentaObject() {	
		this.recibopuntoventaObject=this.recibopuntoventaDataAccess.getEntityObject();
		return this.recibopuntoventaObject;
	}
		
	public void setReciboPuntoVentaObject(Object newReciboPuntoVentaObject) {
		this.recibopuntoventaObject = newReciboPuntoVentaObject;
	}
	
	public List<Object> getReciboPuntoVentasObject() {		
		this.recibopuntoventasObject=this.recibopuntoventaDataAccess.getEntitiesObject();
		return this.recibopuntoventasObject;
	}
		
	public void setReciboPuntoVentasObject(List<Object> newReciboPuntoVentasObject) {
		this.recibopuntoventasObject = newReciboPuntoVentasObject;
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
		
		if(this.recibopuntoventaDataAccess!=null) {
			this.recibopuntoventaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReciboPuntoVenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			recibopuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			recibopuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		recibopuntoventa = new  ReciboPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReciboPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			recibopuntoventa=recibopuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.recibopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(this.recibopuntoventa);
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
		recibopuntoventa = new  ReciboPuntoVenta();
		  		  
        try {
			
			recibopuntoventa=recibopuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.recibopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(this.recibopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		recibopuntoventa = new  ReciboPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReciboPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			recibopuntoventa=recibopuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.recibopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(this.recibopuntoventa);
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
		recibopuntoventa = new  ReciboPuntoVenta();
		  		  
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
		recibopuntoventa = new  ReciboPuntoVenta();
		  		  
        try {
			
			recibopuntoventa=recibopuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.recibopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(this.recibopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		recibopuntoventa = new  ReciboPuntoVenta();
		  		  
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
		recibopuntoventa = new  ReciboPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReciboPuntoVenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =recibopuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		recibopuntoventa = new  ReciboPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=recibopuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		recibopuntoventa = new  ReciboPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReciboPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =recibopuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		recibopuntoventa = new  ReciboPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=recibopuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		recibopuntoventa = new  ReciboPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReciboPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =recibopuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		recibopuntoventa = new  ReciboPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=recibopuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		recibopuntoventas = new  ArrayList<ReciboPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReciboPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ReciboPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recibopuntoventas=recibopuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReciboPuntoVenta(recibopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(this.recibopuntoventas);
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
		recibopuntoventas = new  ArrayList<ReciboPuntoVenta>();
		  		  
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
		recibopuntoventas = new  ArrayList<ReciboPuntoVenta>();
		  		  
        try {			
			ReciboPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recibopuntoventas=recibopuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarReciboPuntoVenta(recibopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(this.recibopuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		recibopuntoventas = new  ArrayList<ReciboPuntoVenta>();
		  		  
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
		recibopuntoventas = new  ArrayList<ReciboPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReciboPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ReciboPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recibopuntoventas=recibopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReciboPuntoVenta(recibopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(this.recibopuntoventas);
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
		recibopuntoventas = new  ArrayList<ReciboPuntoVenta>();
		  		  
        try {
			ReciboPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recibopuntoventas=recibopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReciboPuntoVenta(recibopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(this.recibopuntoventas);
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
		recibopuntoventas = new  ArrayList<ReciboPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReciboPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReciboPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recibopuntoventas=recibopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarReciboPuntoVenta(recibopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(this.recibopuntoventas);
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
		recibopuntoventas = new  ArrayList<ReciboPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReciboPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recibopuntoventas=recibopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarReciboPuntoVenta(recibopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(this.recibopuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		recibopuntoventa = new  ReciboPuntoVenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReciboPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReciboPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recibopuntoventa=recibopuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarReciboPuntoVenta(recibopuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(this.recibopuntoventa);
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
		recibopuntoventa = new  ReciboPuntoVenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReciboPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recibopuntoventa=recibopuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarReciboPuntoVenta(recibopuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(this.recibopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		recibopuntoventas = new  ArrayList<ReciboPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReciboPuntoVenta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ReciboPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recibopuntoventas=recibopuntoventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReciboPuntoVenta(recibopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(this.recibopuntoventas);
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
		recibopuntoventas = new  ArrayList<ReciboPuntoVenta>();
		  		  
        try {
			ReciboPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recibopuntoventas=recibopuntoventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReciboPuntoVenta(recibopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(this.recibopuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosReciboPuntoVentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		recibopuntoventas = new  ArrayList<ReciboPuntoVenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReciboPuntoVenta.class.getSimpleName()+"-getTodosReciboPuntoVentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReciboPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recibopuntoventas=recibopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarReciboPuntoVenta(recibopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(this.recibopuntoventas);
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
	
	public  void  getTodosReciboPuntoVentas(String sFinalQuery,Pagination pagination)throws Exception {
		recibopuntoventas = new  ArrayList<ReciboPuntoVenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReciboPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recibopuntoventas=recibopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarReciboPuntoVenta(recibopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(this.recibopuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarReciboPuntoVenta(ReciboPuntoVenta recibopuntoventa) throws Exception {
		Boolean estaValidado=false;
		
		if(recibopuntoventa.getIsNew() || recibopuntoventa.getIsChanged()) { 
			this.invalidValues = recibopuntoventaValidator.getInvalidValues(recibopuntoventa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(recibopuntoventa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarReciboPuntoVenta(List<ReciboPuntoVenta> ReciboPuntoVentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ReciboPuntoVenta recibopuntoventaLocal:recibopuntoventas) {				
			estaValidadoObjeto=this.validarGuardarReciboPuntoVenta(recibopuntoventaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarReciboPuntoVenta(List<ReciboPuntoVenta> ReciboPuntoVentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarReciboPuntoVenta(recibopuntoventas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarReciboPuntoVenta(ReciboPuntoVenta ReciboPuntoVenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarReciboPuntoVenta(recibopuntoventa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ReciboPuntoVenta recibopuntoventa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+recibopuntoventa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ReciboPuntoVentaConstantesFunciones.getReciboPuntoVentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"recibopuntoventa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ReciboPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ReciboPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveReciboPuntoVentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReciboPuntoVenta.class.getSimpleName()+"-saveReciboPuntoVentaWithConnection");connexion.begin();			
			
			ReciboPuntoVentaLogicAdditional.checkReciboPuntoVentaToSave(this.recibopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ReciboPuntoVentaLogicAdditional.updateReciboPuntoVentaToSave(this.recibopuntoventa,this.arrDatoGeneral);
			
			ReciboPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.recibopuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowReciboPuntoVenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarReciboPuntoVenta(this.recibopuntoventa)) {
				ReciboPuntoVentaDataAccess.save(this.recibopuntoventa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.recibopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ReciboPuntoVentaLogicAdditional.checkReciboPuntoVentaToSaveAfter(this.recibopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowReciboPuntoVenta();
			
			connexion.commit();			
			
			if(this.recibopuntoventa.getIsDeleted()) {
				this.recibopuntoventa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveReciboPuntoVenta()throws Exception {	
		try {	
			
			ReciboPuntoVentaLogicAdditional.checkReciboPuntoVentaToSave(this.recibopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ReciboPuntoVentaLogicAdditional.updateReciboPuntoVentaToSave(this.recibopuntoventa,this.arrDatoGeneral);
			
			ReciboPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.recibopuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarReciboPuntoVenta(this.recibopuntoventa)) {			
				ReciboPuntoVentaDataAccess.save(this.recibopuntoventa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.recibopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ReciboPuntoVentaLogicAdditional.checkReciboPuntoVentaToSaveAfter(this.recibopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.recibopuntoventa.getIsDeleted()) {
				this.recibopuntoventa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveReciboPuntoVentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReciboPuntoVenta.class.getSimpleName()+"-saveReciboPuntoVentasWithConnection");connexion.begin();			
			
			ReciboPuntoVentaLogicAdditional.checkReciboPuntoVentaToSaves(recibopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowReciboPuntoVentas();
			
			Boolean validadoTodosReciboPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ReciboPuntoVenta recibopuntoventaLocal:recibopuntoventas) {		
				if(recibopuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ReciboPuntoVentaLogicAdditional.updateReciboPuntoVentaToSave(recibopuntoventaLocal,this.arrDatoGeneral);
	        	
				ReciboPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),recibopuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarReciboPuntoVenta(recibopuntoventaLocal)) {
					ReciboPuntoVentaDataAccess.save(recibopuntoventaLocal, connexion);				
				} else {
					validadoTodosReciboPuntoVenta=false;
				}
			}
			
			if(!validadoTodosReciboPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ReciboPuntoVentaLogicAdditional.checkReciboPuntoVentaToSavesAfter(recibopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowReciboPuntoVentas();
			
			connexion.commit();		
			
			this.quitarReciboPuntoVentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveReciboPuntoVentas()throws Exception {				
		 try {	
			ReciboPuntoVentaLogicAdditional.checkReciboPuntoVentaToSaves(recibopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosReciboPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ReciboPuntoVenta recibopuntoventaLocal:recibopuntoventas) {				
				if(recibopuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ReciboPuntoVentaLogicAdditional.updateReciboPuntoVentaToSave(recibopuntoventaLocal,this.arrDatoGeneral);
	        	
				ReciboPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),recibopuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarReciboPuntoVenta(recibopuntoventaLocal)) {				
					ReciboPuntoVentaDataAccess.save(recibopuntoventaLocal, connexion);				
				} else {
					validadoTodosReciboPuntoVenta=false;
				}
			}
			
			if(!validadoTodosReciboPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ReciboPuntoVentaLogicAdditional.checkReciboPuntoVentaToSavesAfter(recibopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarReciboPuntoVentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ReciboPuntoVentaParameterReturnGeneral procesarAccionReciboPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ReciboPuntoVenta> recibopuntoventas,ReciboPuntoVentaParameterReturnGeneral recibopuntoventaParameterGeneral)throws Exception {
		 try {	
			ReciboPuntoVentaParameterReturnGeneral recibopuntoventaReturnGeneral=new ReciboPuntoVentaParameterReturnGeneral();
	
			ReciboPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,recibopuntoventas,recibopuntoventaParameterGeneral,recibopuntoventaReturnGeneral);
			
			return recibopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ReciboPuntoVentaParameterReturnGeneral procesarAccionReciboPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ReciboPuntoVenta> recibopuntoventas,ReciboPuntoVentaParameterReturnGeneral recibopuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReciboPuntoVenta.class.getSimpleName()+"-procesarAccionReciboPuntoVentasWithConnection");connexion.begin();			
			
			ReciboPuntoVentaParameterReturnGeneral recibopuntoventaReturnGeneral=new ReciboPuntoVentaParameterReturnGeneral();
	
			ReciboPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,recibopuntoventas,recibopuntoventaParameterGeneral,recibopuntoventaReturnGeneral);
			
			this.connexion.commit();
			
			return recibopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ReciboPuntoVentaParameterReturnGeneral procesarEventosReciboPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ReciboPuntoVenta> recibopuntoventas,ReciboPuntoVenta recibopuntoventa,ReciboPuntoVentaParameterReturnGeneral recibopuntoventaParameterGeneral,Boolean isEsNuevoReciboPuntoVenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			ReciboPuntoVentaParameterReturnGeneral recibopuntoventaReturnGeneral=new ReciboPuntoVentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				recibopuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ReciboPuntoVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,recibopuntoventas,recibopuntoventa,recibopuntoventaParameterGeneral,recibopuntoventaReturnGeneral,isEsNuevoReciboPuntoVenta,clases);
			
			return recibopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ReciboPuntoVentaParameterReturnGeneral procesarEventosReciboPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ReciboPuntoVenta> recibopuntoventas,ReciboPuntoVenta recibopuntoventa,ReciboPuntoVentaParameterReturnGeneral recibopuntoventaParameterGeneral,Boolean isEsNuevoReciboPuntoVenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReciboPuntoVenta.class.getSimpleName()+"-procesarEventosReciboPuntoVentasWithConnection");connexion.begin();			
			
			ReciboPuntoVentaParameterReturnGeneral recibopuntoventaReturnGeneral=new ReciboPuntoVentaParameterReturnGeneral();
	
			recibopuntoventaReturnGeneral.setReciboPuntoVenta(recibopuntoventa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				recibopuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ReciboPuntoVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,recibopuntoventas,recibopuntoventa,recibopuntoventaParameterGeneral,recibopuntoventaReturnGeneral,isEsNuevoReciboPuntoVenta,clases);
			
			this.connexion.commit();
			
			return recibopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ReciboPuntoVentaParameterReturnGeneral procesarImportacionReciboPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ReciboPuntoVentaParameterReturnGeneral recibopuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReciboPuntoVenta.class.getSimpleName()+"-procesarImportacionReciboPuntoVentasWithConnection");connexion.begin();			
			
			ReciboPuntoVentaParameterReturnGeneral recibopuntoventaReturnGeneral=new ReciboPuntoVentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.recibopuntoventas=new ArrayList<ReciboPuntoVenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.recibopuntoventa=new ReciboPuntoVenta();
				
				
				if(conColumnasBase) {this.recibopuntoventa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.recibopuntoventa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.recibopuntoventa.setvalor_efectivo(Double.parseDouble(arrColumnas[iColumn++]));
				this.recibopuntoventa.setvalor_cheque(Double.parseDouble(arrColumnas[iColumn++]));
				this.recibopuntoventa.setnumero_cheque(arrColumnas[iColumn++]);
				this.recibopuntoventa.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				
				this.recibopuntoventas.add(this.recibopuntoventa);
			}
			
			this.saveReciboPuntoVentas();
			
			this.connexion.commit();
			
			recibopuntoventaReturnGeneral.setConRetornoEstaProcesado(true);
			recibopuntoventaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return recibopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarReciboPuntoVentasEliminados() throws Exception {				
		
		List<ReciboPuntoVenta> recibopuntoventasAux= new ArrayList<ReciboPuntoVenta>();
		
		for(ReciboPuntoVenta recibopuntoventa:recibopuntoventas) {
			if(!recibopuntoventa.getIsDeleted()) {
				recibopuntoventasAux.add(recibopuntoventa);
			}
		}
		
		recibopuntoventas=recibopuntoventasAux;
	}
	
	public void quitarReciboPuntoVentasNulos() throws Exception {				
		
		List<ReciboPuntoVenta> recibopuntoventasAux= new ArrayList<ReciboPuntoVenta>();
		
		for(ReciboPuntoVenta recibopuntoventa : this.recibopuntoventas) {
			if(recibopuntoventa==null) {
				recibopuntoventasAux.add(recibopuntoventa);
			}
		}
		
		//this.recibopuntoventas=recibopuntoventasAux;
		
		this.recibopuntoventas.removeAll(recibopuntoventasAux);
	}
	
	public void getSetVersionRowReciboPuntoVentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(recibopuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((recibopuntoventa.getIsDeleted() || (recibopuntoventa.getIsChanged()&&!recibopuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=recibopuntoventaDataAccess.getSetVersionRowReciboPuntoVenta(connexion,recibopuntoventa.getId());
				
				if(!recibopuntoventa.getVersionRow().equals(timestamp)) {	
					recibopuntoventa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				recibopuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowReciboPuntoVenta()throws Exception {	
		
		if(recibopuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((recibopuntoventa.getIsDeleted() || (recibopuntoventa.getIsChanged()&&!recibopuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=recibopuntoventaDataAccess.getSetVersionRowReciboPuntoVenta(connexion,recibopuntoventa.getId());
			
			try {							
				if(!recibopuntoventa.getVersionRow().equals(timestamp)) {	
					recibopuntoventa.setVersionRow(timestamp);
				}
				
				recibopuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowReciboPuntoVentasWithConnection()throws Exception {	
		if(recibopuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ReciboPuntoVenta recibopuntoventaAux:recibopuntoventas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(recibopuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(recibopuntoventaAux.getIsDeleted() || (recibopuntoventaAux.getIsChanged()&&!recibopuntoventaAux.getIsNew())) {
						
						timestamp=recibopuntoventaDataAccess.getSetVersionRowReciboPuntoVenta(connexion,recibopuntoventaAux.getId());
						
						if(!recibopuntoventa.getVersionRow().equals(timestamp)) {	
							recibopuntoventaAux.setVersionRow(timestamp);
						}
								
						recibopuntoventaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowReciboPuntoVentas()throws Exception {	
		if(recibopuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ReciboPuntoVenta recibopuntoventaAux:recibopuntoventas) {
					if(recibopuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(recibopuntoventaAux.getIsDeleted() || (recibopuntoventaAux.getIsChanged()&&!recibopuntoventaAux.getIsNew())) {
						
						timestamp=recibopuntoventaDataAccess.getSetVersionRowReciboPuntoVenta(connexion,recibopuntoventaAux.getId());
						
						if(!recibopuntoventaAux.getVersionRow().equals(timestamp)) {	
							recibopuntoventaAux.setVersionRow(timestamp);
						}
						
													
						recibopuntoventaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ReciboPuntoVentaParameterReturnGeneral cargarCombosLoteForeignKeyReciboPuntoVentaWithConnection(String finalQueryGlobalCliente,String finalQueryGlobalBanco) throws Exception {
		ReciboPuntoVentaParameterReturnGeneral  recibopuntoventaReturnGeneral =new ReciboPuntoVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReciboPuntoVenta.class.getSimpleName()+"-cargarCombosLoteForeignKeyReciboPuntoVentaWithConnection");connexion.begin();
			
			recibopuntoventaReturnGeneral =new ReciboPuntoVentaParameterReturnGeneral();
			
			

			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			recibopuntoventaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			recibopuntoventaReturnGeneral.setbancosForeignKey(bancosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return recibopuntoventaReturnGeneral;
	}
	
	public ReciboPuntoVentaParameterReturnGeneral cargarCombosLoteForeignKeyReciboPuntoVenta(String finalQueryGlobalCliente,String finalQueryGlobalBanco) throws Exception {
		ReciboPuntoVentaParameterReturnGeneral  recibopuntoventaReturnGeneral =new ReciboPuntoVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			recibopuntoventaReturnGeneral =new ReciboPuntoVentaParameterReturnGeneral();
			
			

			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			recibopuntoventaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			recibopuntoventaReturnGeneral.setbancosForeignKey(bancosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return recibopuntoventaReturnGeneral;
	}
	
	
	public void deepLoad(ReciboPuntoVenta recibopuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ReciboPuntoVentaLogicAdditional.updateReciboPuntoVentaToGet(recibopuntoventa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		recibopuntoventa.setCliente(recibopuntoventaDataAccess.getCliente(connexion,recibopuntoventa));
		recibopuntoventa.setBanco(recibopuntoventaDataAccess.getBanco(connexion,recibopuntoventa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				recibopuntoventa.setCliente(recibopuntoventaDataAccess.getCliente(connexion,recibopuntoventa));
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				recibopuntoventa.setBanco(recibopuntoventaDataAccess.getBanco(connexion,recibopuntoventa));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			recibopuntoventa.setCliente(recibopuntoventaDataAccess.getCliente(connexion,recibopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			recibopuntoventa.setBanco(recibopuntoventaDataAccess.getBanco(connexion,recibopuntoventa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		recibopuntoventa.setCliente(recibopuntoventaDataAccess.getCliente(connexion,recibopuntoventa));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(recibopuntoventa.getCliente(),isDeep,deepLoadType,clases);
				
		recibopuntoventa.setBanco(recibopuntoventaDataAccess.getBanco(connexion,recibopuntoventa));
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(recibopuntoventa.getBanco(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				recibopuntoventa.setCliente(recibopuntoventaDataAccess.getCliente(connexion,recibopuntoventa));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(recibopuntoventa.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				recibopuntoventa.setBanco(recibopuntoventaDataAccess.getBanco(connexion,recibopuntoventa));
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepLoad(recibopuntoventa.getBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			recibopuntoventa.setCliente(recibopuntoventaDataAccess.getCliente(connexion,recibopuntoventa));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(recibopuntoventa.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			recibopuntoventa.setBanco(recibopuntoventaDataAccess.getBanco(connexion,recibopuntoventa));
			BancoLogic bancoLogic= new BancoLogic(connexion);
			bancoLogic.deepLoad(recibopuntoventa.getBanco(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ReciboPuntoVenta recibopuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ReciboPuntoVentaLogicAdditional.updateReciboPuntoVentaToSave(recibopuntoventa,this.arrDatoGeneral);
			
ReciboPuntoVentaDataAccess.save(recibopuntoventa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ClienteDataAccess.save(recibopuntoventa.getCliente(),connexion);

		BancoDataAccess.save(recibopuntoventa.getBanco(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(recibopuntoventa.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(recibopuntoventa.getBanco(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ClienteDataAccess.save(recibopuntoventa.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(recibopuntoventa.getCliente(),isDeep,deepLoadType,clases);
				

		BancoDataAccess.save(recibopuntoventa.getBanco(),connexion);
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(recibopuntoventa.getBanco(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(recibopuntoventa.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(recibopuntoventa.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(recibopuntoventa.getBanco(),connexion);
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepSave(recibopuntoventa.getBanco(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ReciboPuntoVenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(recibopuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(recibopuntoventa);
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
			this.deepLoad(this.recibopuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(this.recibopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ReciboPuntoVenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(recibopuntoventas!=null) {
				for(ReciboPuntoVenta recibopuntoventa:recibopuntoventas) {
					this.deepLoad(recibopuntoventa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(recibopuntoventas);
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
			if(recibopuntoventas!=null) {
				for(ReciboPuntoVenta recibopuntoventa:recibopuntoventas) {
					this.deepLoad(recibopuntoventa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(recibopuntoventas);
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
			this.getNewConnexionToDeep(ReciboPuntoVenta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(recibopuntoventa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ReciboPuntoVenta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(recibopuntoventas!=null) {
				for(ReciboPuntoVenta recibopuntoventa:recibopuntoventas) {
					this.deepSave(recibopuntoventa,isDeep,deepLoadType,clases);
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
			if(recibopuntoventas!=null) {
				for(ReciboPuntoVenta recibopuntoventa:recibopuntoventas) {
					this.deepSave(recibopuntoventa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getReciboPuntoVentasFK_IdBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReciboPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,ReciboPuntoVentaConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			ReciboPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			recibopuntoventas=recibopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(this.recibopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReciboPuntoVentasFK_IdBanco(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,ReciboPuntoVentaConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			ReciboPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			recibopuntoventas=recibopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(this.recibopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getReciboPuntoVentasFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReciboPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ReciboPuntoVentaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ReciboPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			recibopuntoventas=recibopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(this.recibopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReciboPuntoVentasFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ReciboPuntoVentaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ReciboPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			recibopuntoventas=recibopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReciboPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesReciboPuntoVenta(this.recibopuntoventas);
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
			if(ReciboPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ReciboPuntoVentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ReciboPuntoVenta recibopuntoventa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ReciboPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				if(recibopuntoventa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ReciboPuntoVentaDataAccess.TABLENAME, recibopuntoventa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ReciboPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ReciboPuntoVentaLogic.registrarAuditoriaDetallesReciboPuntoVenta(connexion,recibopuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(recibopuntoventa.getIsDeleted()) {
					/*if(!recibopuntoventa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ReciboPuntoVentaDataAccess.TABLENAME, recibopuntoventa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ReciboPuntoVentaLogic.registrarAuditoriaDetallesReciboPuntoVenta(connexion,recibopuntoventa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ReciboPuntoVentaDataAccess.TABLENAME, recibopuntoventa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(recibopuntoventa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ReciboPuntoVentaDataAccess.TABLENAME, recibopuntoventa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ReciboPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ReciboPuntoVentaLogic.registrarAuditoriaDetallesReciboPuntoVenta(connexion,recibopuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesReciboPuntoVenta(Connexion connexion,ReciboPuntoVenta recibopuntoventa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(recibopuntoventa.getIsNew()||!recibopuntoventa.getid_cliente().equals(recibopuntoventa.getReciboPuntoVentaOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recibopuntoventa.getReciboPuntoVentaOriginal().getid_cliente()!=null)
				{
					strValorActual=recibopuntoventa.getReciboPuntoVentaOriginal().getid_cliente().toString();
				}
				if(recibopuntoventa.getid_cliente()!=null)
				{
					strValorNuevo=recibopuntoventa.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReciboPuntoVentaConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(recibopuntoventa.getIsNew()||!recibopuntoventa.getid_banco().equals(recibopuntoventa.getReciboPuntoVentaOriginal().getid_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recibopuntoventa.getReciboPuntoVentaOriginal().getid_banco()!=null)
				{
					strValorActual=recibopuntoventa.getReciboPuntoVentaOriginal().getid_banco().toString();
				}
				if(recibopuntoventa.getid_banco()!=null)
				{
					strValorNuevo=recibopuntoventa.getid_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReciboPuntoVentaConstantesFunciones.IDBANCO,strValorActual,strValorNuevo);
			}	
			
			if(recibopuntoventa.getIsNew()||!recibopuntoventa.getvalor_efectivo().equals(recibopuntoventa.getReciboPuntoVentaOriginal().getvalor_efectivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recibopuntoventa.getReciboPuntoVentaOriginal().getvalor_efectivo()!=null)
				{
					strValorActual=recibopuntoventa.getReciboPuntoVentaOriginal().getvalor_efectivo().toString();
				}
				if(recibopuntoventa.getvalor_efectivo()!=null)
				{
					strValorNuevo=recibopuntoventa.getvalor_efectivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReciboPuntoVentaConstantesFunciones.VALOREFECTIVO,strValorActual,strValorNuevo);
			}	
			
			if(recibopuntoventa.getIsNew()||!recibopuntoventa.getvalor_cheque().equals(recibopuntoventa.getReciboPuntoVentaOriginal().getvalor_cheque()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recibopuntoventa.getReciboPuntoVentaOriginal().getvalor_cheque()!=null)
				{
					strValorActual=recibopuntoventa.getReciboPuntoVentaOriginal().getvalor_cheque().toString();
				}
				if(recibopuntoventa.getvalor_cheque()!=null)
				{
					strValorNuevo=recibopuntoventa.getvalor_cheque().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReciboPuntoVentaConstantesFunciones.VALORCHEQUE,strValorActual,strValorNuevo);
			}	
			
			if(recibopuntoventa.getIsNew()||!recibopuntoventa.getnumero_cheque().equals(recibopuntoventa.getReciboPuntoVentaOriginal().getnumero_cheque()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recibopuntoventa.getReciboPuntoVentaOriginal().getnumero_cheque()!=null)
				{
					strValorActual=recibopuntoventa.getReciboPuntoVentaOriginal().getnumero_cheque();
				}
				if(recibopuntoventa.getnumero_cheque()!=null)
				{
					strValorNuevo=recibopuntoventa.getnumero_cheque() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReciboPuntoVentaConstantesFunciones.NUMEROCHEQUE,strValorActual,strValorNuevo);
			}	
			
			if(recibopuntoventa.getIsNew()||!recibopuntoventa.getfecha().equals(recibopuntoventa.getReciboPuntoVentaOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recibopuntoventa.getReciboPuntoVentaOriginal().getfecha()!=null)
				{
					strValorActual=recibopuntoventa.getReciboPuntoVentaOriginal().getfecha().toString();
				}
				if(recibopuntoventa.getfecha()!=null)
				{
					strValorNuevo=recibopuntoventa.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReciboPuntoVentaConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveReciboPuntoVentaRelacionesWithConnection(ReciboPuntoVenta recibopuntoventa) throws Exception {

		if(!recibopuntoventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveReciboPuntoVentaRelacionesBase(recibopuntoventa,true);
		}
	}

	public void saveReciboPuntoVentaRelaciones(ReciboPuntoVenta recibopuntoventa)throws Exception {

		if(!recibopuntoventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveReciboPuntoVentaRelacionesBase(recibopuntoventa,false);
		}
	}

	public void saveReciboPuntoVentaRelacionesBase(ReciboPuntoVenta recibopuntoventa,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ReciboPuntoVenta-saveRelacionesWithConnection");}
	

			this.setReciboPuntoVenta(recibopuntoventa);

			if(ReciboPuntoVentaLogicAdditional.validarSaveRelaciones(recibopuntoventa,this)) {

				ReciboPuntoVentaLogicAdditional.updateRelacionesToSave(recibopuntoventa,this);

				if((recibopuntoventa.getIsNew()||recibopuntoventa.getIsChanged())&&!recibopuntoventa.getIsDeleted()) {
					this.saveReciboPuntoVenta();
					this.saveReciboPuntoVentaRelacionesDetalles();

				} else if(recibopuntoventa.getIsDeleted()) {
					this.saveReciboPuntoVentaRelacionesDetalles();
					this.saveReciboPuntoVenta();
				}

				ReciboPuntoVentaLogicAdditional.updateRelacionesToSaveAfter(recibopuntoventa,this);

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
	
	
	private void saveReciboPuntoVentaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfReciboPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ReciboPuntoVentaConstantesFunciones.getClassesForeignKeysOfReciboPuntoVenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfReciboPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ReciboPuntoVentaConstantesFunciones.getClassesRelationshipsOfReciboPuntoVenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

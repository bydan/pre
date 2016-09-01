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
package com.bydan.erp.sris.business.logic;

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
import com.bydan.erp.sris.util.*;
import com.bydan.erp.sris.util.RetencionVentaConstantesFunciones;
import com.bydan.erp.sris.util.RetencionVentaParameterReturnGeneral;
//import com.bydan.erp.sris.util.RetencionVentaParameterGeneral;
import com.bydan.erp.sris.business.entity.RetencionVenta;
import com.bydan.erp.sris.business.logic.RetencionVentaLogicAdditional;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.sris.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class RetencionVentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(RetencionVentaLogic.class);
	
	protected RetencionVentaDataAccess retencionventaDataAccess; 	
	protected RetencionVenta retencionventa;
	protected List<RetencionVenta> retencionventas;
	protected Object retencionventaObject;	
	protected List<Object> retencionventasObject;
	
	public static ClassValidator<RetencionVenta> retencionventaValidator = new ClassValidator<RetencionVenta>(RetencionVenta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected RetencionVentaLogicAdditional retencionventaLogicAdditional=null;
	
	public RetencionVentaLogicAdditional getRetencionVentaLogicAdditional() {
		return this.retencionventaLogicAdditional;
	}
	
	public void setRetencionVentaLogicAdditional(RetencionVentaLogicAdditional retencionventaLogicAdditional) {
		try {
			this.retencionventaLogicAdditional=retencionventaLogicAdditional;
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
	
	
	
	
	public  RetencionVentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.retencionventaDataAccess = new RetencionVentaDataAccess();
			
			this.retencionventas= new ArrayList<RetencionVenta>();
			this.retencionventa= new RetencionVenta();
			
			this.retencionventaObject=new Object();
			this.retencionventasObject=new ArrayList<Object>();
				
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
			
			this.retencionventaDataAccess.setConnexionType(this.connexionType);
			this.retencionventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RetencionVentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.retencionventaDataAccess = new RetencionVentaDataAccess();
			this.retencionventas= new ArrayList<RetencionVenta>();
			this.retencionventa= new RetencionVenta();
			this.retencionventaObject=new Object();
			this.retencionventasObject=new ArrayList<Object>();
			
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
			
			this.retencionventaDataAccess.setConnexionType(this.connexionType);
			this.retencionventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public RetencionVenta getRetencionVenta() throws Exception {	
		RetencionVentaLogicAdditional.checkRetencionVentaToGet(retencionventa,this.datosCliente,this.arrDatoGeneral);
		RetencionVentaLogicAdditional.updateRetencionVentaToGet(retencionventa,this.arrDatoGeneral);
		
		return retencionventa;
	}
		
	public void setRetencionVenta(RetencionVenta newRetencionVenta) {
		this.retencionventa = newRetencionVenta;
	}
	
	public RetencionVentaDataAccess getRetencionVentaDataAccess() {
		return retencionventaDataAccess;
	}
	
	public void setRetencionVentaDataAccess(RetencionVentaDataAccess newretencionventaDataAccess) {
		this.retencionventaDataAccess = newretencionventaDataAccess;
	}
	
	public List<RetencionVenta> getRetencionVentas() throws Exception {		
		this.quitarRetencionVentasNulos();
		
		RetencionVentaLogicAdditional.checkRetencionVentaToGets(retencionventas,this.datosCliente,this.arrDatoGeneral);
		
		for (RetencionVenta retencionventaLocal: retencionventas ) {
			RetencionVentaLogicAdditional.updateRetencionVentaToGet(retencionventaLocal,this.arrDatoGeneral);
		}
		
		return retencionventas;
	}
	
	public void setRetencionVentas(List<RetencionVenta> newRetencionVentas) {
		this.retencionventas = newRetencionVentas;
	}
	
	public Object getRetencionVentaObject() {	
		this.retencionventaObject=this.retencionventaDataAccess.getEntityObject();
		return this.retencionventaObject;
	}
		
	public void setRetencionVentaObject(Object newRetencionVentaObject) {
		this.retencionventaObject = newRetencionVentaObject;
	}
	
	public List<Object> getRetencionVentasObject() {		
		this.retencionventasObject=this.retencionventaDataAccess.getEntitiesObject();
		return this.retencionventasObject;
	}
		
	public void setRetencionVentasObject(List<Object> newRetencionVentasObject) {
		this.retencionventasObject = newRetencionVentasObject;
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
		
		if(this.retencionventaDataAccess!=null) {
			this.retencionventaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionVenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			retencionventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			retencionventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		retencionventa = new  RetencionVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			retencionventa=retencionventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.retencionventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventa);
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
		retencionventa = new  RetencionVenta();
		  		  
        try {
			
			retencionventa=retencionventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.retencionventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		retencionventa = new  RetencionVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			retencionventa=retencionventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.retencionventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventa);
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
		retencionventa = new  RetencionVenta();
		  		  
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
		retencionventa = new  RetencionVenta();
		  		  
        try {
			
			retencionventa=retencionventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.retencionventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		retencionventa = new  RetencionVenta();
		  		  
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
		retencionventa = new  RetencionVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionVenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =retencionventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		retencionventa = new  RetencionVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=retencionventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		retencionventa = new  RetencionVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionVenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =retencionventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		retencionventa = new  RetencionVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=retencionventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		retencionventa = new  RetencionVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionVenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =retencionventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		retencionventa = new  RetencionVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=retencionventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		retencionventas = new  ArrayList<RetencionVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionventas=retencionventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRetencionVenta(retencionventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventas);
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
		retencionventas = new  ArrayList<RetencionVenta>();
		  		  
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
		retencionventas = new  ArrayList<RetencionVenta>();
		  		  
        try {			
			RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionventas=retencionventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarRetencionVenta(retencionventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		retencionventas = new  ArrayList<RetencionVenta>();
		  		  
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
		retencionventas = new  ArrayList<RetencionVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionventas=retencionventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRetencionVenta(retencionventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventas);
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
		retencionventas = new  ArrayList<RetencionVenta>();
		  		  
        try {
			RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionventas=retencionventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRetencionVenta(retencionventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventas);
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
		retencionventas = new  ArrayList<RetencionVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionventas=retencionventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRetencionVenta(retencionventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventas);
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
		retencionventas = new  ArrayList<RetencionVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionventas=retencionventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRetencionVenta(retencionventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		retencionventa = new  RetencionVenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionventa=retencionventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRetencionVenta(retencionventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventa);
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
		retencionventa = new  RetencionVenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionventa=retencionventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRetencionVenta(retencionventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		retencionventas = new  ArrayList<RetencionVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionVenta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionventas=retencionventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRetencionVenta(retencionventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventas);
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
		retencionventas = new  ArrayList<RetencionVenta>();
		  		  
        try {
			RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionventas=retencionventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRetencionVenta(retencionventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosRetencionVentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		retencionventas = new  ArrayList<RetencionVenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionVenta.class.getSimpleName()+"-getTodosRetencionVentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionventas=retencionventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRetencionVenta(retencionventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventas);
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
	
	public  void  getTodosRetencionVentas(String sFinalQuery,Pagination pagination)throws Exception {
		retencionventas = new  ArrayList<RetencionVenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			retencionventas=retencionventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRetencionVenta(retencionventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarRetencionVenta(RetencionVenta retencionventa) throws Exception {
		Boolean estaValidado=false;
		
		if(retencionventa.getIsNew() || retencionventa.getIsChanged()) { 
			this.invalidValues = retencionventaValidator.getInvalidValues(retencionventa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(retencionventa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarRetencionVenta(List<RetencionVenta> RetencionVentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(RetencionVenta retencionventaLocal:retencionventas) {				
			estaValidadoObjeto=this.validarGuardarRetencionVenta(retencionventaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarRetencionVenta(List<RetencionVenta> RetencionVentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRetencionVenta(retencionventas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarRetencionVenta(RetencionVenta RetencionVenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRetencionVenta(retencionventa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(RetencionVenta retencionventa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+retencionventa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=RetencionVentaConstantesFunciones.getRetencionVentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"retencionventa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(RetencionVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(RetencionVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveRetencionVentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionVenta.class.getSimpleName()+"-saveRetencionVentaWithConnection");connexion.begin();			
			
			RetencionVentaLogicAdditional.checkRetencionVentaToSave(this.retencionventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RetencionVentaLogicAdditional.updateRetencionVentaToSave(this.retencionventa,this.arrDatoGeneral);
			
			RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.retencionventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowRetencionVenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRetencionVenta(this.retencionventa)) {
				RetencionVentaDataAccess.save(this.retencionventa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.retencionventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RetencionVentaLogicAdditional.checkRetencionVentaToSaveAfter(this.retencionventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRetencionVenta();
			
			connexion.commit();			
			
			if(this.retencionventa.getIsDeleted()) {
				this.retencionventa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveRetencionVenta()throws Exception {	
		try {	
			
			RetencionVentaLogicAdditional.checkRetencionVentaToSave(this.retencionventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RetencionVentaLogicAdditional.updateRetencionVentaToSave(this.retencionventa,this.arrDatoGeneral);
			
			RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.retencionventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRetencionVenta(this.retencionventa)) {			
				RetencionVentaDataAccess.save(this.retencionventa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.retencionventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RetencionVentaLogicAdditional.checkRetencionVentaToSaveAfter(this.retencionventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.retencionventa.getIsDeleted()) {
				this.retencionventa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveRetencionVentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionVenta.class.getSimpleName()+"-saveRetencionVentasWithConnection");connexion.begin();			
			
			RetencionVentaLogicAdditional.checkRetencionVentaToSaves(retencionventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowRetencionVentas();
			
			Boolean validadoTodosRetencionVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RetencionVenta retencionventaLocal:retencionventas) {		
				if(retencionventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RetencionVentaLogicAdditional.updateRetencionVentaToSave(retencionventaLocal,this.arrDatoGeneral);
	        	
				RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),retencionventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRetencionVenta(retencionventaLocal)) {
					RetencionVentaDataAccess.save(retencionventaLocal, connexion);				
				} else {
					validadoTodosRetencionVenta=false;
				}
			}
			
			if(!validadoTodosRetencionVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RetencionVentaLogicAdditional.checkRetencionVentaToSavesAfter(retencionventas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRetencionVentas();
			
			connexion.commit();		
			
			this.quitarRetencionVentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveRetencionVentas()throws Exception {				
		 try {	
			RetencionVentaLogicAdditional.checkRetencionVentaToSaves(retencionventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosRetencionVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RetencionVenta retencionventaLocal:retencionventas) {				
				if(retencionventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RetencionVentaLogicAdditional.updateRetencionVentaToSave(retencionventaLocal,this.arrDatoGeneral);
	        	
				RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),retencionventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRetencionVenta(retencionventaLocal)) {				
					RetencionVentaDataAccess.save(retencionventaLocal, connexion);				
				} else {
					validadoTodosRetencionVenta=false;
				}
			}
			
			if(!validadoTodosRetencionVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RetencionVentaLogicAdditional.checkRetencionVentaToSavesAfter(retencionventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarRetencionVentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RetencionVentaParameterReturnGeneral procesarAccionRetencionVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RetencionVenta> retencionventas,RetencionVentaParameterReturnGeneral retencionventaParameterGeneral)throws Exception {
		 try {	
			RetencionVentaParameterReturnGeneral retencionventaReturnGeneral=new RetencionVentaParameterReturnGeneral();
	
			RetencionVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,retencionventas,retencionventaParameterGeneral,retencionventaReturnGeneral);
			
			return retencionventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RetencionVentaParameterReturnGeneral procesarAccionRetencionVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RetencionVenta> retencionventas,RetencionVentaParameterReturnGeneral retencionventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionVenta.class.getSimpleName()+"-procesarAccionRetencionVentasWithConnection");connexion.begin();			
			
			RetencionVentaParameterReturnGeneral retencionventaReturnGeneral=new RetencionVentaParameterReturnGeneral();
	
			RetencionVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,retencionventas,retencionventaParameterGeneral,retencionventaReturnGeneral);
			
			this.connexion.commit();
			
			return retencionventaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RetencionVentaParameterReturnGeneral procesarEventosRetencionVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RetencionVenta> retencionventas,RetencionVenta retencionventa,RetencionVentaParameterReturnGeneral retencionventaParameterGeneral,Boolean isEsNuevoRetencionVenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			RetencionVentaParameterReturnGeneral retencionventaReturnGeneral=new RetencionVentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				retencionventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RetencionVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,retencionventas,retencionventa,retencionventaParameterGeneral,retencionventaReturnGeneral,isEsNuevoRetencionVenta,clases);
			
			return retencionventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public RetencionVentaParameterReturnGeneral procesarEventosRetencionVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RetencionVenta> retencionventas,RetencionVenta retencionventa,RetencionVentaParameterReturnGeneral retencionventaParameterGeneral,Boolean isEsNuevoRetencionVenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionVenta.class.getSimpleName()+"-procesarEventosRetencionVentasWithConnection");connexion.begin();			
			
			RetencionVentaParameterReturnGeneral retencionventaReturnGeneral=new RetencionVentaParameterReturnGeneral();
	
			retencionventaReturnGeneral.setRetencionVenta(retencionventa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				retencionventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RetencionVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,retencionventas,retencionventa,retencionventaParameterGeneral,retencionventaReturnGeneral,isEsNuevoRetencionVenta,clases);
			
			this.connexion.commit();
			
			return retencionventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RetencionVentaParameterReturnGeneral procesarImportacionRetencionVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,RetencionVentaParameterReturnGeneral retencionventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionVenta.class.getSimpleName()+"-procesarImportacionRetencionVentasWithConnection");connexion.begin();			
			
			RetencionVentaParameterReturnGeneral retencionventaReturnGeneral=new RetencionVentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.retencionventas=new ArrayList<RetencionVenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.retencionventa=new RetencionVenta();
				
				
				if(conColumnasBase) {this.retencionventa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.retencionventa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.retencionventa.setruc(arrColumnas[iColumn++]);
				this.retencionventa.setnumero_retencion(arrColumnas[iColumn++]);
				this.retencionventa.setbase_imponible(Double.parseDouble(arrColumnas[iColumn++]));
				this.retencionventa.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.retencionventa.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.retencionventa.setes_debito(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.retencionventas.add(this.retencionventa);
			}
			
			this.saveRetencionVentas();
			
			this.connexion.commit();
			
			retencionventaReturnGeneral.setConRetornoEstaProcesado(true);
			retencionventaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return retencionventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarRetencionVentasEliminados() throws Exception {				
		
		List<RetencionVenta> retencionventasAux= new ArrayList<RetencionVenta>();
		
		for(RetencionVenta retencionventa:retencionventas) {
			if(!retencionventa.getIsDeleted()) {
				retencionventasAux.add(retencionventa);
			}
		}
		
		retencionventas=retencionventasAux;
	}
	
	public void quitarRetencionVentasNulos() throws Exception {				
		
		List<RetencionVenta> retencionventasAux= new ArrayList<RetencionVenta>();
		
		for(RetencionVenta retencionventa : this.retencionventas) {
			if(retencionventa==null) {
				retencionventasAux.add(retencionventa);
			}
		}
		
		//this.retencionventas=retencionventasAux;
		
		this.retencionventas.removeAll(retencionventasAux);
	}
	
	public void getSetVersionRowRetencionVentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(retencionventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((retencionventa.getIsDeleted() || (retencionventa.getIsChanged()&&!retencionventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=retencionventaDataAccess.getSetVersionRowRetencionVenta(connexion,retencionventa.getId());
				
				if(!retencionventa.getVersionRow().equals(timestamp)) {	
					retencionventa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				retencionventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowRetencionVenta()throws Exception {	
		
		if(retencionventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((retencionventa.getIsDeleted() || (retencionventa.getIsChanged()&&!retencionventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=retencionventaDataAccess.getSetVersionRowRetencionVenta(connexion,retencionventa.getId());
			
			try {							
				if(!retencionventa.getVersionRow().equals(timestamp)) {	
					retencionventa.setVersionRow(timestamp);
				}
				
				retencionventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowRetencionVentasWithConnection()throws Exception {	
		if(retencionventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(RetencionVenta retencionventaAux:retencionventas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(retencionventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(retencionventaAux.getIsDeleted() || (retencionventaAux.getIsChanged()&&!retencionventaAux.getIsNew())) {
						
						timestamp=retencionventaDataAccess.getSetVersionRowRetencionVenta(connexion,retencionventaAux.getId());
						
						if(!retencionventa.getVersionRow().equals(timestamp)) {	
							retencionventaAux.setVersionRow(timestamp);
						}
								
						retencionventaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowRetencionVentas()throws Exception {	
		if(retencionventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(RetencionVenta retencionventaAux:retencionventas) {
					if(retencionventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(retencionventaAux.getIsDeleted() || (retencionventaAux.getIsChanged()&&!retencionventaAux.getIsNew())) {
						
						timestamp=retencionventaDataAccess.getSetVersionRowRetencionVenta(connexion,retencionventaAux.getId());
						
						if(!retencionventaAux.getVersionRow().equals(timestamp)) {	
							retencionventaAux.setVersionRow(timestamp);
						}
						
													
						retencionventaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public RetencionVentaParameterReturnGeneral cargarCombosLoteForeignKeyRetencionVentaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalPeriodoDeclara,String finalQueryGlobalTipoRetencion) throws Exception {
		RetencionVentaParameterReturnGeneral  retencionventaReturnGeneral =new RetencionVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionVenta.class.getSimpleName()+"-cargarCombosLoteForeignKeyRetencionVentaWithConnection");connexion.begin();
			
			retencionventaReturnGeneral =new RetencionVentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			retencionventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<PeriodoDeclara> periododeclarasForeignKey=new ArrayList<PeriodoDeclara>();
			PeriodoDeclaraLogic periododeclaraLogic=new PeriodoDeclaraLogic();
			periododeclaraLogic.setConnexion(this.connexion);
			periododeclaraLogic.getPeriodoDeclaraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodoDeclara.equals("NONE")) {
				periododeclaraLogic.getTodosPeriodoDeclaras(finalQueryGlobalPeriodoDeclara,new Pagination());
				periododeclarasForeignKey=periododeclaraLogic.getPeriodoDeclaras();
			}

			retencionventaReturnGeneral.setperiododeclarasForeignKey(periododeclarasForeignKey);


			List<TipoRetencion> tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionLogic=new TipoRetencionLogic();
			tiporetencionLogic.setConnexion(this.connexion);
			tiporetencionLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencion.equals("NONE")) {
				tiporetencionLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencion,new Pagination());
				tiporetencionsForeignKey=tiporetencionLogic.getTipoRetencions();
			}

			retencionventaReturnGeneral.settiporetencionsForeignKey(tiporetencionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return retencionventaReturnGeneral;
	}
	
	public RetencionVentaParameterReturnGeneral cargarCombosLoteForeignKeyRetencionVenta(String finalQueryGlobalEmpresa,String finalQueryGlobalPeriodoDeclara,String finalQueryGlobalTipoRetencion) throws Exception {
		RetencionVentaParameterReturnGeneral  retencionventaReturnGeneral =new RetencionVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			retencionventaReturnGeneral =new RetencionVentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			retencionventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<PeriodoDeclara> periododeclarasForeignKey=new ArrayList<PeriodoDeclara>();
			PeriodoDeclaraLogic periododeclaraLogic=new PeriodoDeclaraLogic();
			periododeclaraLogic.setConnexion(this.connexion);
			periododeclaraLogic.getPeriodoDeclaraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodoDeclara.equals("NONE")) {
				periododeclaraLogic.getTodosPeriodoDeclaras(finalQueryGlobalPeriodoDeclara,new Pagination());
				periododeclarasForeignKey=periododeclaraLogic.getPeriodoDeclaras();
			}

			retencionventaReturnGeneral.setperiododeclarasForeignKey(periododeclarasForeignKey);


			List<TipoRetencion> tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionLogic=new TipoRetencionLogic();
			tiporetencionLogic.setConnexion(this.connexion);
			tiporetencionLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencion.equals("NONE")) {
				tiporetencionLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencion,new Pagination());
				tiporetencionsForeignKey=tiporetencionLogic.getTipoRetencions();
			}

			retencionventaReturnGeneral.settiporetencionsForeignKey(tiporetencionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return retencionventaReturnGeneral;
	}
	
	
	public void deepLoad(RetencionVenta retencionventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RetencionVentaLogicAdditional.updateRetencionVentaToGet(retencionventa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		retencionventa.setEmpresa(retencionventaDataAccess.getEmpresa(connexion,retencionventa));
		retencionventa.setPeriodoDeclara(retencionventaDataAccess.getPeriodoDeclara(connexion,retencionventa));
		retencionventa.setTipoRetencion(retencionventaDataAccess.getTipoRetencion(connexion,retencionventa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				retencionventa.setEmpresa(retencionventaDataAccess.getEmpresa(connexion,retencionventa));
				continue;
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				retencionventa.setPeriodoDeclara(retencionventaDataAccess.getPeriodoDeclara(connexion,retencionventa));
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				retencionventa.setTipoRetencion(retencionventaDataAccess.getTipoRetencion(connexion,retencionventa));
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
			retencionventa.setEmpresa(retencionventaDataAccess.getEmpresa(connexion,retencionventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PeriodoDeclara.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencionventa.setPeriodoDeclara(retencionventaDataAccess.getPeriodoDeclara(connexion,retencionventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencionventa.setTipoRetencion(retencionventaDataAccess.getTipoRetencion(connexion,retencionventa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		retencionventa.setEmpresa(retencionventaDataAccess.getEmpresa(connexion,retencionventa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(retencionventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		retencionventa.setPeriodoDeclara(retencionventaDataAccess.getPeriodoDeclara(connexion,retencionventa));
		PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
		periododeclaraLogic.deepLoad(retencionventa.getPeriodoDeclara(),isDeep,deepLoadType,clases);
				
		retencionventa.setTipoRetencion(retencionventaDataAccess.getTipoRetencion(connexion,retencionventa));
		TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
		tiporetencionLogic.deepLoad(retencionventa.getTipoRetencion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				retencionventa.setEmpresa(retencionventaDataAccess.getEmpresa(connexion,retencionventa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(retencionventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				retencionventa.setPeriodoDeclara(retencionventaDataAccess.getPeriodoDeclara(connexion,retencionventa));
				PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
				periododeclaraLogic.deepLoad(retencionventa.getPeriodoDeclara(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				retencionventa.setTipoRetencion(retencionventaDataAccess.getTipoRetencion(connexion,retencionventa));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(retencionventa.getTipoRetencion(),isDeep,deepLoadType,clases);				
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
			retencionventa.setEmpresa(retencionventaDataAccess.getEmpresa(connexion,retencionventa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(retencionventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PeriodoDeclara.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencionventa.setPeriodoDeclara(retencionventaDataAccess.getPeriodoDeclara(connexion,retencionventa));
			PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
			periododeclaraLogic.deepLoad(retencionventa.getPeriodoDeclara(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			retencionventa.setTipoRetencion(retencionventaDataAccess.getTipoRetencion(connexion,retencionventa));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(retencionventa.getTipoRetencion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(RetencionVenta retencionventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			RetencionVentaLogicAdditional.updateRetencionVentaToSave(retencionventa,this.arrDatoGeneral);
			
RetencionVentaDataAccess.save(retencionventa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(retencionventa.getEmpresa(),connexion);

		PeriodoDeclaraDataAccess.save(retencionventa.getPeriodoDeclara(),connexion);

		TipoRetencionDataAccess.save(retencionventa.getTipoRetencion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(retencionventa.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				PeriodoDeclaraDataAccess.save(retencionventa.getPeriodoDeclara(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(retencionventa.getTipoRetencion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(retencionventa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(retencionventa.getEmpresa(),isDeep,deepLoadType,clases);
				

		PeriodoDeclaraDataAccess.save(retencionventa.getPeriodoDeclara(),connexion);
		PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
		periododeclaraLogic.deepLoad(retencionventa.getPeriodoDeclara(),isDeep,deepLoadType,clases);
				

		TipoRetencionDataAccess.save(retencionventa.getTipoRetencion(),connexion);
		TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
		tiporetencionLogic.deepLoad(retencionventa.getTipoRetencion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(retencionventa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(retencionventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				PeriodoDeclaraDataAccess.save(retencionventa.getPeriodoDeclara(),connexion);
				PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
				periododeclaraLogic.deepSave(retencionventa.getPeriodoDeclara(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(retencionventa.getTipoRetencion(),connexion);
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepSave(retencionventa.getTipoRetencion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(RetencionVenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(retencionventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(retencionventa);
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
			this.deepLoad(this.retencionventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(RetencionVenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(retencionventas!=null) {
				for(RetencionVenta retencionventa:retencionventas) {
					this.deepLoad(retencionventa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(retencionventas);
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
			if(retencionventas!=null) {
				for(RetencionVenta retencionventa:retencionventas) {
					this.deepLoad(retencionventa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(retencionventas);
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
			this.getNewConnexionToDeep(RetencionVenta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(retencionventa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(RetencionVenta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(retencionventas!=null) {
				for(RetencionVenta retencionventa:retencionventas) {
					this.deepSave(retencionventa,isDeep,deepLoadType,clases);
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
			if(retencionventas!=null) {
				for(RetencionVenta retencionventa:retencionventas) {
					this.deepSave(retencionventa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getRetencionVentasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RetencionVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencionventas=retencionventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRetencionVentasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RetencionVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencionventas=retencionventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRetencionVentasFK_IdPeriodoDeclaraWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo_declara)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodoDeclara= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodoDeclara.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo_declara,RetencionVentaConstantesFunciones.IDPERIODODECLARA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodoDeclara);

			RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodoDeclara","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencionventas=retencionventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRetencionVentasFK_IdPeriodoDeclara(String sFinalQuery,Pagination pagination,Long id_periodo_declara)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodoDeclara= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodoDeclara.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo_declara,RetencionVentaConstantesFunciones.IDPERIODODECLARA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodoDeclara);

			RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodoDeclara","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencionventas=retencionventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRetencionVentasFK_IdTipoRetencionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RetencionVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion,RetencionVentaConstantesFunciones.IDTIPORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencion);

			RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencionventas=retencionventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRetencionVentasFK_IdTipoRetencion(String sFinalQuery,Pagination pagination,Long id_tipo_retencion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion,RetencionVentaConstantesFunciones.IDTIPORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencion);

			RetencionVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			retencionventas=retencionventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RetencionVentaConstantesFunciones.refrescarForeignKeysDescripcionesRetencionVenta(this.retencionventas);
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
			if(RetencionVentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,RetencionVentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,RetencionVenta retencionventa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(RetencionVentaConstantesFunciones.ISCONAUDITORIA) {
				if(retencionventa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RetencionVentaDataAccess.TABLENAME, retencionventa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RetencionVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RetencionVentaLogic.registrarAuditoriaDetallesRetencionVenta(connexion,retencionventa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(retencionventa.getIsDeleted()) {
					/*if(!retencionventa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,RetencionVentaDataAccess.TABLENAME, retencionventa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////RetencionVentaLogic.registrarAuditoriaDetallesRetencionVenta(connexion,retencionventa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RetencionVentaDataAccess.TABLENAME, retencionventa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(retencionventa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RetencionVentaDataAccess.TABLENAME, retencionventa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RetencionVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RetencionVentaLogic.registrarAuditoriaDetallesRetencionVenta(connexion,retencionventa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesRetencionVenta(Connexion connexion,RetencionVenta retencionventa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(retencionventa.getIsNew()||!retencionventa.getid_empresa().equals(retencionventa.getRetencionVentaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencionventa.getRetencionVentaOriginal().getid_empresa()!=null)
				{
					strValorActual=retencionventa.getRetencionVentaOriginal().getid_empresa().toString();
				}
				if(retencionventa.getid_empresa()!=null)
				{
					strValorNuevo=retencionventa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionVentaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(retencionventa.getIsNew()||!retencionventa.getid_periodo_declara().equals(retencionventa.getRetencionVentaOriginal().getid_periodo_declara()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencionventa.getRetencionVentaOriginal().getid_periodo_declara()!=null)
				{
					strValorActual=retencionventa.getRetencionVentaOriginal().getid_periodo_declara().toString();
				}
				if(retencionventa.getid_periodo_declara()!=null)
				{
					strValorNuevo=retencionventa.getid_periodo_declara().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionVentaConstantesFunciones.IDPERIODODECLARA,strValorActual,strValorNuevo);
			}	
			
			if(retencionventa.getIsNew()||!retencionventa.getid_tipo_retencion().equals(retencionventa.getRetencionVentaOriginal().getid_tipo_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencionventa.getRetencionVentaOriginal().getid_tipo_retencion()!=null)
				{
					strValorActual=retencionventa.getRetencionVentaOriginal().getid_tipo_retencion().toString();
				}
				if(retencionventa.getid_tipo_retencion()!=null)
				{
					strValorNuevo=retencionventa.getid_tipo_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionVentaConstantesFunciones.IDTIPORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(retencionventa.getIsNew()||!retencionventa.getruc().equals(retencionventa.getRetencionVentaOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencionventa.getRetencionVentaOriginal().getruc()!=null)
				{
					strValorActual=retencionventa.getRetencionVentaOriginal().getruc();
				}
				if(retencionventa.getruc()!=null)
				{
					strValorNuevo=retencionventa.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionVentaConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(retencionventa.getIsNew()||!retencionventa.getnumero_retencion().equals(retencionventa.getRetencionVentaOriginal().getnumero_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencionventa.getRetencionVentaOriginal().getnumero_retencion()!=null)
				{
					strValorActual=retencionventa.getRetencionVentaOriginal().getnumero_retencion();
				}
				if(retencionventa.getnumero_retencion()!=null)
				{
					strValorNuevo=retencionventa.getnumero_retencion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionVentaConstantesFunciones.NUMERORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(retencionventa.getIsNew()||!retencionventa.getbase_imponible().equals(retencionventa.getRetencionVentaOriginal().getbase_imponible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencionventa.getRetencionVentaOriginal().getbase_imponible()!=null)
				{
					strValorActual=retencionventa.getRetencionVentaOriginal().getbase_imponible().toString();
				}
				if(retencionventa.getbase_imponible()!=null)
				{
					strValorNuevo=retencionventa.getbase_imponible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionVentaConstantesFunciones.BASEIMPONIBLE,strValorActual,strValorNuevo);
			}	
			
			if(retencionventa.getIsNew()||!retencionventa.getporcentaje().equals(retencionventa.getRetencionVentaOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencionventa.getRetencionVentaOriginal().getporcentaje()!=null)
				{
					strValorActual=retencionventa.getRetencionVentaOriginal().getporcentaje().toString();
				}
				if(retencionventa.getporcentaje()!=null)
				{
					strValorNuevo=retencionventa.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionVentaConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(retencionventa.getIsNew()||!retencionventa.getvalor().equals(retencionventa.getRetencionVentaOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencionventa.getRetencionVentaOriginal().getvalor()!=null)
				{
					strValorActual=retencionventa.getRetencionVentaOriginal().getvalor().toString();
				}
				if(retencionventa.getvalor()!=null)
				{
					strValorNuevo=retencionventa.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionVentaConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(retencionventa.getIsNew()||!retencionventa.getes_debito().equals(retencionventa.getRetencionVentaOriginal().getes_debito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(retencionventa.getRetencionVentaOriginal().getes_debito()!=null)
				{
					strValorActual=retencionventa.getRetencionVentaOriginal().getes_debito().toString();
				}
				if(retencionventa.getes_debito()!=null)
				{
					strValorNuevo=retencionventa.getes_debito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RetencionVentaConstantesFunciones.ESDEBITO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveRetencionVentaRelacionesWithConnection(RetencionVenta retencionventa) throws Exception {

		if(!retencionventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRetencionVentaRelacionesBase(retencionventa,true);
		}
	}

	public void saveRetencionVentaRelaciones(RetencionVenta retencionventa)throws Exception {

		if(!retencionventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRetencionVentaRelacionesBase(retencionventa,false);
		}
	}

	public void saveRetencionVentaRelacionesBase(RetencionVenta retencionventa,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("RetencionVenta-saveRelacionesWithConnection");}
	

			this.setRetencionVenta(retencionventa);

			if(RetencionVentaLogicAdditional.validarSaveRelaciones(retencionventa,this)) {

				RetencionVentaLogicAdditional.updateRelacionesToSave(retencionventa,this);

				if((retencionventa.getIsNew()||retencionventa.getIsChanged())&&!retencionventa.getIsDeleted()) {
					this.saveRetencionVenta();
					this.saveRetencionVentaRelacionesDetalles();

				} else if(retencionventa.getIsDeleted()) {
					this.saveRetencionVentaRelacionesDetalles();
					this.saveRetencionVenta();
				}

				RetencionVentaLogicAdditional.updateRelacionesToSaveAfter(retencionventa,this);

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
	
	
	private void saveRetencionVentaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfRetencionVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RetencionVentaConstantesFunciones.getClassesForeignKeysOfRetencionVenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRetencionVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RetencionVentaConstantesFunciones.getClassesRelationshipsOfRetencionVenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.PresupuestoFlujoCajaConstantesFunciones;
import com.bydan.erp.contabilidad.util.PresupuestoFlujoCajaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.PresupuestoFlujoCajaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.PresupuestoFlujoCaja;
import com.bydan.erp.contabilidad.business.logic.PresupuestoFlujoCajaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class PresupuestoFlujoCajaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PresupuestoFlujoCajaLogic.class);
	
	protected PresupuestoFlujoCajaDataAccess presupuestoflujocajaDataAccess; 	
	protected PresupuestoFlujoCaja presupuestoflujocaja;
	protected List<PresupuestoFlujoCaja> presupuestoflujocajas;
	protected Object presupuestoflujocajaObject;	
	protected List<Object> presupuestoflujocajasObject;
	
	public static ClassValidator<PresupuestoFlujoCaja> presupuestoflujocajaValidator = new ClassValidator<PresupuestoFlujoCaja>(PresupuestoFlujoCaja.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PresupuestoFlujoCajaLogicAdditional presupuestoflujocajaLogicAdditional=null;
	
	public PresupuestoFlujoCajaLogicAdditional getPresupuestoFlujoCajaLogicAdditional() {
		return this.presupuestoflujocajaLogicAdditional;
	}
	
	public void setPresupuestoFlujoCajaLogicAdditional(PresupuestoFlujoCajaLogicAdditional presupuestoflujocajaLogicAdditional) {
		try {
			this.presupuestoflujocajaLogicAdditional=presupuestoflujocajaLogicAdditional;
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
	
	
	
	
	public  PresupuestoFlujoCajaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.presupuestoflujocajaDataAccess = new PresupuestoFlujoCajaDataAccess();
			
			this.presupuestoflujocajas= new ArrayList<PresupuestoFlujoCaja>();
			this.presupuestoflujocaja= new PresupuestoFlujoCaja();
			
			this.presupuestoflujocajaObject=new Object();
			this.presupuestoflujocajasObject=new ArrayList<Object>();
				
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
			
			this.presupuestoflujocajaDataAccess.setConnexionType(this.connexionType);
			this.presupuestoflujocajaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PresupuestoFlujoCajaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.presupuestoflujocajaDataAccess = new PresupuestoFlujoCajaDataAccess();
			this.presupuestoflujocajas= new ArrayList<PresupuestoFlujoCaja>();
			this.presupuestoflujocaja= new PresupuestoFlujoCaja();
			this.presupuestoflujocajaObject=new Object();
			this.presupuestoflujocajasObject=new ArrayList<Object>();
			
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
			
			this.presupuestoflujocajaDataAccess.setConnexionType(this.connexionType);
			this.presupuestoflujocajaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PresupuestoFlujoCaja getPresupuestoFlujoCaja() throws Exception {	
		PresupuestoFlujoCajaLogicAdditional.checkPresupuestoFlujoCajaToGet(presupuestoflujocaja,this.datosCliente,this.arrDatoGeneral);
		PresupuestoFlujoCajaLogicAdditional.updatePresupuestoFlujoCajaToGet(presupuestoflujocaja,this.arrDatoGeneral);
		
		return presupuestoflujocaja;
	}
		
	public void setPresupuestoFlujoCaja(PresupuestoFlujoCaja newPresupuestoFlujoCaja) {
		this.presupuestoflujocaja = newPresupuestoFlujoCaja;
	}
	
	public PresupuestoFlujoCajaDataAccess getPresupuestoFlujoCajaDataAccess() {
		return presupuestoflujocajaDataAccess;
	}
	
	public void setPresupuestoFlujoCajaDataAccess(PresupuestoFlujoCajaDataAccess newpresupuestoflujocajaDataAccess) {
		this.presupuestoflujocajaDataAccess = newpresupuestoflujocajaDataAccess;
	}
	
	public List<PresupuestoFlujoCaja> getPresupuestoFlujoCajas() throws Exception {		
		this.quitarPresupuestoFlujoCajasNulos();
		
		PresupuestoFlujoCajaLogicAdditional.checkPresupuestoFlujoCajaToGets(presupuestoflujocajas,this.datosCliente,this.arrDatoGeneral);
		
		for (PresupuestoFlujoCaja presupuestoflujocajaLocal: presupuestoflujocajas ) {
			PresupuestoFlujoCajaLogicAdditional.updatePresupuestoFlujoCajaToGet(presupuestoflujocajaLocal,this.arrDatoGeneral);
		}
		
		return presupuestoflujocajas;
	}
	
	public void setPresupuestoFlujoCajas(List<PresupuestoFlujoCaja> newPresupuestoFlujoCajas) {
		this.presupuestoflujocajas = newPresupuestoFlujoCajas;
	}
	
	public Object getPresupuestoFlujoCajaObject() {	
		this.presupuestoflujocajaObject=this.presupuestoflujocajaDataAccess.getEntityObject();
		return this.presupuestoflujocajaObject;
	}
		
	public void setPresupuestoFlujoCajaObject(Object newPresupuestoFlujoCajaObject) {
		this.presupuestoflujocajaObject = newPresupuestoFlujoCajaObject;
	}
	
	public List<Object> getPresupuestoFlujoCajasObject() {		
		this.presupuestoflujocajasObject=this.presupuestoflujocajaDataAccess.getEntitiesObject();
		return this.presupuestoflujocajasObject;
	}
		
	public void setPresupuestoFlujoCajasObject(List<Object> newPresupuestoFlujoCajasObject) {
		this.presupuestoflujocajasObject = newPresupuestoFlujoCajasObject;
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
		
		if(this.presupuestoflujocajaDataAccess!=null) {
			this.presupuestoflujocajaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			presupuestoflujocajaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			presupuestoflujocajaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		presupuestoflujocaja = new  PresupuestoFlujoCaja();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presupuestoflujocaja=presupuestoflujocajaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestoflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocaja);
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
		presupuestoflujocaja = new  PresupuestoFlujoCaja();
		  		  
        try {
			
			presupuestoflujocaja=presupuestoflujocajaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestoflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		presupuestoflujocaja = new  PresupuestoFlujoCaja();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presupuestoflujocaja=presupuestoflujocajaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestoflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocaja);
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
		presupuestoflujocaja = new  PresupuestoFlujoCaja();
		  		  
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
		presupuestoflujocaja = new  PresupuestoFlujoCaja();
		  		  
        try {
			
			presupuestoflujocaja=presupuestoflujocajaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestoflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		presupuestoflujocaja = new  PresupuestoFlujoCaja();
		  		  
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
		presupuestoflujocaja = new  PresupuestoFlujoCaja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =presupuestoflujocajaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presupuestoflujocaja = new  PresupuestoFlujoCaja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=presupuestoflujocajaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presupuestoflujocaja = new  PresupuestoFlujoCaja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =presupuestoflujocajaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presupuestoflujocaja = new  PresupuestoFlujoCaja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=presupuestoflujocajaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presupuestoflujocaja = new  PresupuestoFlujoCaja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =presupuestoflujocajaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presupuestoflujocaja = new  PresupuestoFlujoCaja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=presupuestoflujocajaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presupuestoflujocajas = new  ArrayList<PresupuestoFlujoCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoFlujoCaja(presupuestoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
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
		presupuestoflujocajas = new  ArrayList<PresupuestoFlujoCaja>();
		  		  
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
		presupuestoflujocajas = new  ArrayList<PresupuestoFlujoCaja>();
		  		  
        try {			
			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPresupuestoFlujoCaja(presupuestoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		presupuestoflujocajas = new  ArrayList<PresupuestoFlujoCaja>();
		  		  
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
		presupuestoflujocajas = new  ArrayList<PresupuestoFlujoCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoFlujoCaja(presupuestoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
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
		presupuestoflujocajas = new  ArrayList<PresupuestoFlujoCaja>();
		  		  
        try {
			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoFlujoCaja(presupuestoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
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
		presupuestoflujocajas = new  ArrayList<PresupuestoFlujoCaja>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoFlujoCaja(presupuestoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
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
		presupuestoflujocajas = new  ArrayList<PresupuestoFlujoCaja>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoFlujoCaja(presupuestoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		presupuestoflujocaja = new  PresupuestoFlujoCaja();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocaja=presupuestoflujocajaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoFlujoCaja(presupuestoflujocaja);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocaja);
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
		presupuestoflujocaja = new  PresupuestoFlujoCaja();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocaja=presupuestoflujocajaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoFlujoCaja(presupuestoflujocaja);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presupuestoflujocajas = new  ArrayList<PresupuestoFlujoCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoFlujoCaja(presupuestoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
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
		presupuestoflujocajas = new  ArrayList<PresupuestoFlujoCaja>();
		  		  
        try {
			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoFlujoCaja(presupuestoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPresupuestoFlujoCajasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		presupuestoflujocajas = new  ArrayList<PresupuestoFlujoCaja>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-getTodosPresupuestoFlujoCajasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresupuestoFlujoCaja(presupuestoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
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
	
	public  void  getTodosPresupuestoFlujoCajas(String sFinalQuery,Pagination pagination)throws Exception {
		presupuestoflujocajas = new  ArrayList<PresupuestoFlujoCaja>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresupuestoFlujoCaja(presupuestoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPresupuestoFlujoCaja(PresupuestoFlujoCaja presupuestoflujocaja) throws Exception {
		Boolean estaValidado=false;
		
		if(presupuestoflujocaja.getIsNew() || presupuestoflujocaja.getIsChanged()) { 
			this.invalidValues = presupuestoflujocajaValidator.getInvalidValues(presupuestoflujocaja);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(presupuestoflujocaja);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPresupuestoFlujoCaja(List<PresupuestoFlujoCaja> PresupuestoFlujoCajas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PresupuestoFlujoCaja presupuestoflujocajaLocal:presupuestoflujocajas) {				
			estaValidadoObjeto=this.validarGuardarPresupuestoFlujoCaja(presupuestoflujocajaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPresupuestoFlujoCaja(List<PresupuestoFlujoCaja> PresupuestoFlujoCajas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresupuestoFlujoCaja(presupuestoflujocajas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPresupuestoFlujoCaja(PresupuestoFlujoCaja PresupuestoFlujoCaja) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresupuestoFlujoCaja(presupuestoflujocaja)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PresupuestoFlujoCaja presupuestoflujocaja) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+presupuestoflujocaja.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PresupuestoFlujoCajaConstantesFunciones.getPresupuestoFlujoCajaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"presupuestoflujocaja","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PresupuestoFlujoCajaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PresupuestoFlujoCajaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePresupuestoFlujoCajaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-savePresupuestoFlujoCajaWithConnection");connexion.begin();			
			
			PresupuestoFlujoCajaLogicAdditional.checkPresupuestoFlujoCajaToSave(this.presupuestoflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresupuestoFlujoCajaLogicAdditional.updatePresupuestoFlujoCajaToSave(this.presupuestoflujocaja,this.arrDatoGeneral);
			
			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presupuestoflujocaja,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPresupuestoFlujoCaja();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresupuestoFlujoCaja(this.presupuestoflujocaja)) {
				PresupuestoFlujoCajaDataAccess.save(this.presupuestoflujocaja, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.presupuestoflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresupuestoFlujoCajaLogicAdditional.checkPresupuestoFlujoCajaToSaveAfter(this.presupuestoflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresupuestoFlujoCaja();
			
			connexion.commit();			
			
			if(this.presupuestoflujocaja.getIsDeleted()) {
				this.presupuestoflujocaja=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePresupuestoFlujoCaja()throws Exception {	
		try {	
			
			PresupuestoFlujoCajaLogicAdditional.checkPresupuestoFlujoCajaToSave(this.presupuestoflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresupuestoFlujoCajaLogicAdditional.updatePresupuestoFlujoCajaToSave(this.presupuestoflujocaja,this.arrDatoGeneral);
			
			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presupuestoflujocaja,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresupuestoFlujoCaja(this.presupuestoflujocaja)) {			
				PresupuestoFlujoCajaDataAccess.save(this.presupuestoflujocaja, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.presupuestoflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresupuestoFlujoCajaLogicAdditional.checkPresupuestoFlujoCajaToSaveAfter(this.presupuestoflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.presupuestoflujocaja.getIsDeleted()) {
				this.presupuestoflujocaja=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePresupuestoFlujoCajasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-savePresupuestoFlujoCajasWithConnection");connexion.begin();			
			
			PresupuestoFlujoCajaLogicAdditional.checkPresupuestoFlujoCajaToSaves(presupuestoflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPresupuestoFlujoCajas();
			
			Boolean validadoTodosPresupuestoFlujoCaja=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresupuestoFlujoCaja presupuestoflujocajaLocal:presupuestoflujocajas) {		
				if(presupuestoflujocajaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresupuestoFlujoCajaLogicAdditional.updatePresupuestoFlujoCajaToSave(presupuestoflujocajaLocal,this.arrDatoGeneral);
	        	
				PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presupuestoflujocajaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresupuestoFlujoCaja(presupuestoflujocajaLocal)) {
					PresupuestoFlujoCajaDataAccess.save(presupuestoflujocajaLocal, connexion);				
				} else {
					validadoTodosPresupuestoFlujoCaja=false;
				}
			}
			
			if(!validadoTodosPresupuestoFlujoCaja) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresupuestoFlujoCajaLogicAdditional.checkPresupuestoFlujoCajaToSavesAfter(presupuestoflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresupuestoFlujoCajas();
			
			connexion.commit();		
			
			this.quitarPresupuestoFlujoCajasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePresupuestoFlujoCajas()throws Exception {				
		 try {	
			PresupuestoFlujoCajaLogicAdditional.checkPresupuestoFlujoCajaToSaves(presupuestoflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPresupuestoFlujoCaja=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresupuestoFlujoCaja presupuestoflujocajaLocal:presupuestoflujocajas) {				
				if(presupuestoflujocajaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresupuestoFlujoCajaLogicAdditional.updatePresupuestoFlujoCajaToSave(presupuestoflujocajaLocal,this.arrDatoGeneral);
	        	
				PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presupuestoflujocajaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresupuestoFlujoCaja(presupuestoflujocajaLocal)) {				
					PresupuestoFlujoCajaDataAccess.save(presupuestoflujocajaLocal, connexion);				
				} else {
					validadoTodosPresupuestoFlujoCaja=false;
				}
			}
			
			if(!validadoTodosPresupuestoFlujoCaja) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresupuestoFlujoCajaLogicAdditional.checkPresupuestoFlujoCajaToSavesAfter(presupuestoflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPresupuestoFlujoCajasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresupuestoFlujoCajaParameterReturnGeneral procesarAccionPresupuestoFlujoCajas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresupuestoFlujoCaja> presupuestoflujocajas,PresupuestoFlujoCajaParameterReturnGeneral presupuestoflujocajaParameterGeneral)throws Exception {
		 try {	
			PresupuestoFlujoCajaParameterReturnGeneral presupuestoflujocajaReturnGeneral=new PresupuestoFlujoCajaParameterReturnGeneral();
	
			PresupuestoFlujoCajaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presupuestoflujocajas,presupuestoflujocajaParameterGeneral,presupuestoflujocajaReturnGeneral);
			
			return presupuestoflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresupuestoFlujoCajaParameterReturnGeneral procesarAccionPresupuestoFlujoCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresupuestoFlujoCaja> presupuestoflujocajas,PresupuestoFlujoCajaParameterReturnGeneral presupuestoflujocajaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-procesarAccionPresupuestoFlujoCajasWithConnection");connexion.begin();			
			
			PresupuestoFlujoCajaParameterReturnGeneral presupuestoflujocajaReturnGeneral=new PresupuestoFlujoCajaParameterReturnGeneral();
	
			PresupuestoFlujoCajaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presupuestoflujocajas,presupuestoflujocajaParameterGeneral,presupuestoflujocajaReturnGeneral);
			
			this.connexion.commit();
			
			return presupuestoflujocajaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresupuestoFlujoCajaParameterReturnGeneral procesarEventosPresupuestoFlujoCajas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresupuestoFlujoCaja> presupuestoflujocajas,PresupuestoFlujoCaja presupuestoflujocaja,PresupuestoFlujoCajaParameterReturnGeneral presupuestoflujocajaParameterGeneral,Boolean isEsNuevoPresupuestoFlujoCaja,ArrayList<Classe> clases)throws Exception {
		 try {	
			PresupuestoFlujoCajaParameterReturnGeneral presupuestoflujocajaReturnGeneral=new PresupuestoFlujoCajaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presupuestoflujocajaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresupuestoFlujoCajaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presupuestoflujocajas,presupuestoflujocaja,presupuestoflujocajaParameterGeneral,presupuestoflujocajaReturnGeneral,isEsNuevoPresupuestoFlujoCaja,clases);
			
			return presupuestoflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PresupuestoFlujoCajaParameterReturnGeneral procesarEventosPresupuestoFlujoCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresupuestoFlujoCaja> presupuestoflujocajas,PresupuestoFlujoCaja presupuestoflujocaja,PresupuestoFlujoCajaParameterReturnGeneral presupuestoflujocajaParameterGeneral,Boolean isEsNuevoPresupuestoFlujoCaja,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-procesarEventosPresupuestoFlujoCajasWithConnection");connexion.begin();			
			
			PresupuestoFlujoCajaParameterReturnGeneral presupuestoflujocajaReturnGeneral=new PresupuestoFlujoCajaParameterReturnGeneral();
	
			presupuestoflujocajaReturnGeneral.setPresupuestoFlujoCaja(presupuestoflujocaja);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presupuestoflujocajaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresupuestoFlujoCajaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presupuestoflujocajas,presupuestoflujocaja,presupuestoflujocajaParameterGeneral,presupuestoflujocajaReturnGeneral,isEsNuevoPresupuestoFlujoCaja,clases);
			
			this.connexion.commit();
			
			return presupuestoflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresupuestoFlujoCajaParameterReturnGeneral procesarImportacionPresupuestoFlujoCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PresupuestoFlujoCajaParameterReturnGeneral presupuestoflujocajaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-procesarImportacionPresupuestoFlujoCajasWithConnection");connexion.begin();			
			
			PresupuestoFlujoCajaParameterReturnGeneral presupuestoflujocajaReturnGeneral=new PresupuestoFlujoCajaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.presupuestoflujocajas=new ArrayList<PresupuestoFlujoCaja>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.presupuestoflujocaja=new PresupuestoFlujoCaja();
				
				
				if(conColumnasBase) {this.presupuestoflujocaja.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.presupuestoflujocaja.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.presupuestoflujocaja.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.presupuestoflujocaja.setvalor_efectivo(Double.parseDouble(arrColumnas[iColumn++]));
				this.presupuestoflujocaja.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.presupuestoflujocaja.setfecha_presupuesto(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.presupuestoflujocaja.setfecha_proceso(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.presupuestoflujocaja.setobservacion(arrColumnas[iColumn++]);
				
				this.presupuestoflujocajas.add(this.presupuestoflujocaja);
			}
			
			this.savePresupuestoFlujoCajas();
			
			this.connexion.commit();
			
			presupuestoflujocajaReturnGeneral.setConRetornoEstaProcesado(true);
			presupuestoflujocajaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return presupuestoflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPresupuestoFlujoCajasEliminados() throws Exception {				
		
		List<PresupuestoFlujoCaja> presupuestoflujocajasAux= new ArrayList<PresupuestoFlujoCaja>();
		
		for(PresupuestoFlujoCaja presupuestoflujocaja:presupuestoflujocajas) {
			if(!presupuestoflujocaja.getIsDeleted()) {
				presupuestoflujocajasAux.add(presupuestoflujocaja);
			}
		}
		
		presupuestoflujocajas=presupuestoflujocajasAux;
	}
	
	public void quitarPresupuestoFlujoCajasNulos() throws Exception {				
		
		List<PresupuestoFlujoCaja> presupuestoflujocajasAux= new ArrayList<PresupuestoFlujoCaja>();
		
		for(PresupuestoFlujoCaja presupuestoflujocaja : this.presupuestoflujocajas) {
			if(presupuestoflujocaja==null) {
				presupuestoflujocajasAux.add(presupuestoflujocaja);
			}
		}
		
		//this.presupuestoflujocajas=presupuestoflujocajasAux;
		
		this.presupuestoflujocajas.removeAll(presupuestoflujocajasAux);
	}
	
	public void getSetVersionRowPresupuestoFlujoCajaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(presupuestoflujocaja.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((presupuestoflujocaja.getIsDeleted() || (presupuestoflujocaja.getIsChanged()&&!presupuestoflujocaja.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=presupuestoflujocajaDataAccess.getSetVersionRowPresupuestoFlujoCaja(connexion,presupuestoflujocaja.getId());
				
				if(!presupuestoflujocaja.getVersionRow().equals(timestamp)) {	
					presupuestoflujocaja.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				presupuestoflujocaja.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPresupuestoFlujoCaja()throws Exception {	
		
		if(presupuestoflujocaja.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((presupuestoflujocaja.getIsDeleted() || (presupuestoflujocaja.getIsChanged()&&!presupuestoflujocaja.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=presupuestoflujocajaDataAccess.getSetVersionRowPresupuestoFlujoCaja(connexion,presupuestoflujocaja.getId());
			
			try {							
				if(!presupuestoflujocaja.getVersionRow().equals(timestamp)) {	
					presupuestoflujocaja.setVersionRow(timestamp);
				}
				
				presupuestoflujocaja.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPresupuestoFlujoCajasWithConnection()throws Exception {	
		if(presupuestoflujocajas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PresupuestoFlujoCaja presupuestoflujocajaAux:presupuestoflujocajas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(presupuestoflujocajaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presupuestoflujocajaAux.getIsDeleted() || (presupuestoflujocajaAux.getIsChanged()&&!presupuestoflujocajaAux.getIsNew())) {
						
						timestamp=presupuestoflujocajaDataAccess.getSetVersionRowPresupuestoFlujoCaja(connexion,presupuestoflujocajaAux.getId());
						
						if(!presupuestoflujocaja.getVersionRow().equals(timestamp)) {	
							presupuestoflujocajaAux.setVersionRow(timestamp);
						}
								
						presupuestoflujocajaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPresupuestoFlujoCajas()throws Exception {	
		if(presupuestoflujocajas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PresupuestoFlujoCaja presupuestoflujocajaAux:presupuestoflujocajas) {
					if(presupuestoflujocajaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presupuestoflujocajaAux.getIsDeleted() || (presupuestoflujocajaAux.getIsChanged()&&!presupuestoflujocajaAux.getIsNew())) {
						
						timestamp=presupuestoflujocajaDataAccess.getSetVersionRowPresupuestoFlujoCaja(connexion,presupuestoflujocajaAux.getId());
						
						if(!presupuestoflujocajaAux.getVersionRow().equals(timestamp)) {	
							presupuestoflujocajaAux.setVersionRow(timestamp);
						}
						
													
						presupuestoflujocajaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PresupuestoFlujoCajaParameterReturnGeneral cargarCombosLoteForeignKeyPresupuestoFlujoCajaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCuentaContable,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalCentroCosto,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		PresupuestoFlujoCajaParameterReturnGeneral  presupuestoflujocajaReturnGeneral =new PresupuestoFlujoCajaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-cargarCombosLoteForeignKeyPresupuestoFlujoCajaWithConnection");connexion.begin();
			
			presupuestoflujocajaReturnGeneral =new PresupuestoFlujoCajaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			presupuestoflujocajaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			presupuestoflujocajaReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			presupuestoflujocajaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			presupuestoflujocajaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			presupuestoflujocajaReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			presupuestoflujocajaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			presupuestoflujocajaReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return presupuestoflujocajaReturnGeneral;
	}
	
	public PresupuestoFlujoCajaParameterReturnGeneral cargarCombosLoteForeignKeyPresupuestoFlujoCaja(String finalQueryGlobalEmpresa,String finalQueryGlobalCuentaContable,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalCentroCosto,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		PresupuestoFlujoCajaParameterReturnGeneral  presupuestoflujocajaReturnGeneral =new PresupuestoFlujoCajaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			presupuestoflujocajaReturnGeneral =new PresupuestoFlujoCajaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			presupuestoflujocajaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			presupuestoflujocajaReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			presupuestoflujocajaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			presupuestoflujocajaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			presupuestoflujocajaReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			presupuestoflujocajaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			presupuestoflujocajaReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return presupuestoflujocajaReturnGeneral;
	}
	
	
	public void deepLoad(PresupuestoFlujoCaja presupuestoflujocaja,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PresupuestoFlujoCajaLogicAdditional.updatePresupuestoFlujoCajaToGet(presupuestoflujocaja,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presupuestoflujocaja.setEmpresa(presupuestoflujocajaDataAccess.getEmpresa(connexion,presupuestoflujocaja));
		presupuestoflujocaja.setCuentaContable(presupuestoflujocajaDataAccess.getCuentaContable(connexion,presupuestoflujocaja));
		presupuestoflujocaja.setEjercicio(presupuestoflujocajaDataAccess.getEjercicio(connexion,presupuestoflujocaja));
		presupuestoflujocaja.setPeriodo(presupuestoflujocajaDataAccess.getPeriodo(connexion,presupuestoflujocaja));
		presupuestoflujocaja.setCentroCosto(presupuestoflujocajaDataAccess.getCentroCosto(connexion,presupuestoflujocaja));
		presupuestoflujocaja.setAnio(presupuestoflujocajaDataAccess.getAnio(connexion,presupuestoflujocaja));
		presupuestoflujocaja.setMes(presupuestoflujocajaDataAccess.getMes(connexion,presupuestoflujocaja));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				presupuestoflujocaja.setEmpresa(presupuestoflujocajaDataAccess.getEmpresa(connexion,presupuestoflujocaja));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				presupuestoflujocaja.setCuentaContable(presupuestoflujocajaDataAccess.getCuentaContable(connexion,presupuestoflujocaja));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				presupuestoflujocaja.setEjercicio(presupuestoflujocajaDataAccess.getEjercicio(connexion,presupuestoflujocaja));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				presupuestoflujocaja.setPeriodo(presupuestoflujocajaDataAccess.getPeriodo(connexion,presupuestoflujocaja));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				presupuestoflujocaja.setCentroCosto(presupuestoflujocajaDataAccess.getCentroCosto(connexion,presupuestoflujocaja));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				presupuestoflujocaja.setAnio(presupuestoflujocajaDataAccess.getAnio(connexion,presupuestoflujocaja));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				presupuestoflujocaja.setMes(presupuestoflujocajaDataAccess.getMes(connexion,presupuestoflujocaja));
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
			presupuestoflujocaja.setEmpresa(presupuestoflujocajaDataAccess.getEmpresa(connexion,presupuestoflujocaja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocaja.setCuentaContable(presupuestoflujocajaDataAccess.getCuentaContable(connexion,presupuestoflujocaja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocaja.setEjercicio(presupuestoflujocajaDataAccess.getEjercicio(connexion,presupuestoflujocaja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocaja.setPeriodo(presupuestoflujocajaDataAccess.getPeriodo(connexion,presupuestoflujocaja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocaja.setCentroCosto(presupuestoflujocajaDataAccess.getCentroCosto(connexion,presupuestoflujocaja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocaja.setAnio(presupuestoflujocajaDataAccess.getAnio(connexion,presupuestoflujocaja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocaja.setMes(presupuestoflujocajaDataAccess.getMes(connexion,presupuestoflujocaja));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presupuestoflujocaja.setEmpresa(presupuestoflujocajaDataAccess.getEmpresa(connexion,presupuestoflujocaja));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(presupuestoflujocaja.getEmpresa(),isDeep,deepLoadType,clases);
				
		presupuestoflujocaja.setCuentaContable(presupuestoflujocajaDataAccess.getCuentaContable(connexion,presupuestoflujocaja));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(presupuestoflujocaja.getCuentaContable(),isDeep,deepLoadType,clases);
				
		presupuestoflujocaja.setEjercicio(presupuestoflujocajaDataAccess.getEjercicio(connexion,presupuestoflujocaja));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(presupuestoflujocaja.getEjercicio(),isDeep,deepLoadType,clases);
				
		presupuestoflujocaja.setPeriodo(presupuestoflujocajaDataAccess.getPeriodo(connexion,presupuestoflujocaja));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(presupuestoflujocaja.getPeriodo(),isDeep,deepLoadType,clases);
				
		presupuestoflujocaja.setCentroCosto(presupuestoflujocajaDataAccess.getCentroCosto(connexion,presupuestoflujocaja));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(presupuestoflujocaja.getCentroCosto(),isDeep,deepLoadType,clases);
				
		presupuestoflujocaja.setAnio(presupuestoflujocajaDataAccess.getAnio(connexion,presupuestoflujocaja));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(presupuestoflujocaja.getAnio(),isDeep,deepLoadType,clases);
				
		presupuestoflujocaja.setMes(presupuestoflujocajaDataAccess.getMes(connexion,presupuestoflujocaja));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(presupuestoflujocaja.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				presupuestoflujocaja.setEmpresa(presupuestoflujocajaDataAccess.getEmpresa(connexion,presupuestoflujocaja));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(presupuestoflujocaja.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				presupuestoflujocaja.setCuentaContable(presupuestoflujocajaDataAccess.getCuentaContable(connexion,presupuestoflujocaja));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(presupuestoflujocaja.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				presupuestoflujocaja.setEjercicio(presupuestoflujocajaDataAccess.getEjercicio(connexion,presupuestoflujocaja));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(presupuestoflujocaja.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				presupuestoflujocaja.setPeriodo(presupuestoflujocajaDataAccess.getPeriodo(connexion,presupuestoflujocaja));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(presupuestoflujocaja.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				presupuestoflujocaja.setCentroCosto(presupuestoflujocajaDataAccess.getCentroCosto(connexion,presupuestoflujocaja));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(presupuestoflujocaja.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				presupuestoflujocaja.setAnio(presupuestoflujocajaDataAccess.getAnio(connexion,presupuestoflujocaja));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(presupuestoflujocaja.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				presupuestoflujocaja.setMes(presupuestoflujocajaDataAccess.getMes(connexion,presupuestoflujocaja));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(presupuestoflujocaja.getMes(),isDeep,deepLoadType,clases);				
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
			presupuestoflujocaja.setEmpresa(presupuestoflujocajaDataAccess.getEmpresa(connexion,presupuestoflujocaja));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(presupuestoflujocaja.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocaja.setCuentaContable(presupuestoflujocajaDataAccess.getCuentaContable(connexion,presupuestoflujocaja));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(presupuestoflujocaja.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocaja.setEjercicio(presupuestoflujocajaDataAccess.getEjercicio(connexion,presupuestoflujocaja));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(presupuestoflujocaja.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocaja.setPeriodo(presupuestoflujocajaDataAccess.getPeriodo(connexion,presupuestoflujocaja));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(presupuestoflujocaja.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocaja.setCentroCosto(presupuestoflujocajaDataAccess.getCentroCosto(connexion,presupuestoflujocaja));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(presupuestoflujocaja.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocaja.setAnio(presupuestoflujocajaDataAccess.getAnio(connexion,presupuestoflujocaja));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(presupuestoflujocaja.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocaja.setMes(presupuestoflujocajaDataAccess.getMes(connexion,presupuestoflujocaja));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(presupuestoflujocaja.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PresupuestoFlujoCaja presupuestoflujocaja,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PresupuestoFlujoCajaLogicAdditional.updatePresupuestoFlujoCajaToSave(presupuestoflujocaja,this.arrDatoGeneral);
			
PresupuestoFlujoCajaDataAccess.save(presupuestoflujocaja, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(presupuestoflujocaja.getEmpresa(),connexion);

		CuentaContableDataAccess.save(presupuestoflujocaja.getCuentaContable(),connexion);

		EjercicioDataAccess.save(presupuestoflujocaja.getEjercicio(),connexion);

		PeriodoDataAccess.save(presupuestoflujocaja.getPeriodo(),connexion);

		CentroCostoDataAccess.save(presupuestoflujocaja.getCentroCosto(),connexion);

		AnioDataAccess.save(presupuestoflujocaja.getAnio(),connexion);

		MesDataAccess.save(presupuestoflujocaja.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(presupuestoflujocaja.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(presupuestoflujocaja.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(presupuestoflujocaja.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(presupuestoflujocaja.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(presupuestoflujocaja.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(presupuestoflujocaja.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(presupuestoflujocaja.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(presupuestoflujocaja.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(presupuestoflujocaja.getEmpresa(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(presupuestoflujocaja.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(presupuestoflujocaja.getCuentaContable(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(presupuestoflujocaja.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(presupuestoflujocaja.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(presupuestoflujocaja.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(presupuestoflujocaja.getPeriodo(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(presupuestoflujocaja.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(presupuestoflujocaja.getCentroCosto(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(presupuestoflujocaja.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(presupuestoflujocaja.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(presupuestoflujocaja.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(presupuestoflujocaja.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(presupuestoflujocaja.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(presupuestoflujocaja.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(presupuestoflujocaja.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(presupuestoflujocaja.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(presupuestoflujocaja.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(presupuestoflujocaja.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(presupuestoflujocaja.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(presupuestoflujocaja.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(presupuestoflujocaja.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(presupuestoflujocaja.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(presupuestoflujocaja.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(presupuestoflujocaja.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(presupuestoflujocaja.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(presupuestoflujocaja.getMes(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PresupuestoFlujoCaja.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(presupuestoflujocaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(presupuestoflujocaja);
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
			this.deepLoad(this.presupuestoflujocaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PresupuestoFlujoCaja.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(presupuestoflujocajas!=null) {
				for(PresupuestoFlujoCaja presupuestoflujocaja:presupuestoflujocajas) {
					this.deepLoad(presupuestoflujocaja,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(presupuestoflujocajas);
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
			if(presupuestoflujocajas!=null) {
				for(PresupuestoFlujoCaja presupuestoflujocaja:presupuestoflujocajas) {
					this.deepLoad(presupuestoflujocaja,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(presupuestoflujocajas);
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
			this.getNewConnexionToDeep(PresupuestoFlujoCaja.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(presupuestoflujocaja,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PresupuestoFlujoCaja.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(presupuestoflujocajas!=null) {
				for(PresupuestoFlujoCaja presupuestoflujocaja:presupuestoflujocajas) {
					this.deepSave(presupuestoflujocaja,isDeep,deepLoadType,clases);
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
			if(presupuestoflujocajas!=null) {
				for(PresupuestoFlujoCaja presupuestoflujocaja:presupuestoflujocajas) {
					this.deepSave(presupuestoflujocaja,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPresupuestoFlujoCajasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PresupuestoFlujoCajaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PresupuestoFlujoCajaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoFlujoCajasFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,PresupuestoFlujoCajaConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajasFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,PresupuestoFlujoCajaConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoFlujoCajasFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,PresupuestoFlujoCajaConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajasFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,PresupuestoFlujoCajaConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoFlujoCajasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PresupuestoFlujoCajaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PresupuestoFlujoCajaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoFlujoCajasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PresupuestoFlujoCajaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PresupuestoFlujoCajaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoFlujoCajasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PresupuestoFlujoCajaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PresupuestoFlujoCajaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoFlujoCajasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PresupuestoFlujoCajaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PresupuestoFlujoCajaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PresupuestoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(this.presupuestoflujocajas);
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
			if(PresupuestoFlujoCajaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoFlujoCajaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PresupuestoFlujoCaja presupuestoflujocaja,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PresupuestoFlujoCajaConstantesFunciones.ISCONAUDITORIA) {
				if(presupuestoflujocaja.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoFlujoCajaDataAccess.TABLENAME, presupuestoflujocaja.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresupuestoFlujoCajaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresupuestoFlujoCajaLogic.registrarAuditoriaDetallesPresupuestoFlujoCaja(connexion,presupuestoflujocaja,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(presupuestoflujocaja.getIsDeleted()) {
					/*if(!presupuestoflujocaja.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PresupuestoFlujoCajaDataAccess.TABLENAME, presupuestoflujocaja.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PresupuestoFlujoCajaLogic.registrarAuditoriaDetallesPresupuestoFlujoCaja(connexion,presupuestoflujocaja,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoFlujoCajaDataAccess.TABLENAME, presupuestoflujocaja.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(presupuestoflujocaja.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoFlujoCajaDataAccess.TABLENAME, presupuestoflujocaja.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresupuestoFlujoCajaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresupuestoFlujoCajaLogic.registrarAuditoriaDetallesPresupuestoFlujoCaja(connexion,presupuestoflujocaja,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPresupuestoFlujoCaja(Connexion connexion,PresupuestoFlujoCaja presupuestoflujocaja)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(presupuestoflujocaja.getIsNew()||!presupuestoflujocaja.getid_empresa().equals(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getid_empresa()!=null)
				{
					strValorActual=presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getid_empresa().toString();
				}
				if(presupuestoflujocaja.getid_empresa()!=null)
				{
					strValorNuevo=presupuestoflujocaja.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocaja.getIsNew()||!presupuestoflujocaja.getid_cuenta_contable().equals(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getid_cuenta_contable().toString();
				}
				if(presupuestoflujocaja.getid_cuenta_contable()!=null)
				{
					strValorNuevo=presupuestoflujocaja.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocaja.getIsNew()||!presupuestoflujocaja.getid_ejercicio().equals(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getid_ejercicio()!=null)
				{
					strValorActual=presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getid_ejercicio().toString();
				}
				if(presupuestoflujocaja.getid_ejercicio()!=null)
				{
					strValorNuevo=presupuestoflujocaja.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocaja.getIsNew()||!presupuestoflujocaja.getid_periodo().equals(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getid_periodo()!=null)
				{
					strValorActual=presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getid_periodo().toString();
				}
				if(presupuestoflujocaja.getid_periodo()!=null)
				{
					strValorNuevo=presupuestoflujocaja.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocaja.getIsNew()||!presupuestoflujocaja.getid_centro_costo().equals(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getid_centro_costo()!=null)
				{
					strValorActual=presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getid_centro_costo().toString();
				}
				if(presupuestoflujocaja.getid_centro_costo()!=null)
				{
					strValorNuevo=presupuestoflujocaja.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocaja.getIsNew()||!presupuestoflujocaja.getvalor().equals(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getvalor()!=null)
				{
					strValorActual=presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getvalor().toString();
				}
				if(presupuestoflujocaja.getvalor()!=null)
				{
					strValorNuevo=presupuestoflujocaja.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocaja.getIsNew()||!presupuestoflujocaja.getvalor_efectivo().equals(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getvalor_efectivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getvalor_efectivo()!=null)
				{
					strValorActual=presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getvalor_efectivo().toString();
				}
				if(presupuestoflujocaja.getvalor_efectivo()!=null)
				{
					strValorNuevo=presupuestoflujocaja.getvalor_efectivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaConstantesFunciones.VALOREFECTIVO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocaja.getIsNew()||!presupuestoflujocaja.getporcentaje().equals(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getporcentaje()!=null)
				{
					strValorActual=presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getporcentaje().toString();
				}
				if(presupuestoflujocaja.getporcentaje()!=null)
				{
					strValorNuevo=presupuestoflujocaja.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocaja.getIsNew()||!presupuestoflujocaja.getfecha_presupuesto().equals(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getfecha_presupuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getfecha_presupuesto()!=null)
				{
					strValorActual=presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getfecha_presupuesto().toString();
				}
				if(presupuestoflujocaja.getfecha_presupuesto()!=null)
				{
					strValorNuevo=presupuestoflujocaja.getfecha_presupuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaConstantesFunciones.FECHAPRESUPUESTO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocaja.getIsNew()||!presupuestoflujocaja.getfecha_proceso().equals(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getfecha_proceso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getfecha_proceso()!=null)
				{
					strValorActual=presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getfecha_proceso().toString();
				}
				if(presupuestoflujocaja.getfecha_proceso()!=null)
				{
					strValorNuevo=presupuestoflujocaja.getfecha_proceso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaConstantesFunciones.FECHAPROCESO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocaja.getIsNew()||!presupuestoflujocaja.getobservacion().equals(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getobservacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getobservacion()!=null)
				{
					strValorActual=presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getobservacion();
				}
				if(presupuestoflujocaja.getobservacion()!=null)
				{
					strValorNuevo=presupuestoflujocaja.getobservacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaConstantesFunciones.OBSERVACION,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocaja.getIsNew()||!presupuestoflujocaja.getid_anio().equals(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getid_anio()!=null)
				{
					strValorActual=presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getid_anio().toString();
				}
				if(presupuestoflujocaja.getid_anio()!=null)
				{
					strValorNuevo=presupuestoflujocaja.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocaja.getIsNew()||!presupuestoflujocaja.getid_mes().equals(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getid_mes()!=null)
				{
					strValorActual=presupuestoflujocaja.getPresupuestoFlujoCajaOriginal().getid_mes().toString();
				}
				if(presupuestoflujocaja.getid_mes()!=null)
				{
					strValorNuevo=presupuestoflujocaja.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePresupuestoFlujoCajaRelacionesWithConnection(PresupuestoFlujoCaja presupuestoflujocaja) throws Exception {

		if(!presupuestoflujocaja.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresupuestoFlujoCajaRelacionesBase(presupuestoflujocaja,true);
		}
	}

	public void savePresupuestoFlujoCajaRelaciones(PresupuestoFlujoCaja presupuestoflujocaja)throws Exception {

		if(!presupuestoflujocaja.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresupuestoFlujoCajaRelacionesBase(presupuestoflujocaja,false);
		}
	}

	public void savePresupuestoFlujoCajaRelacionesBase(PresupuestoFlujoCaja presupuestoflujocaja,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PresupuestoFlujoCaja-saveRelacionesWithConnection");}
	

			this.setPresupuestoFlujoCaja(presupuestoflujocaja);

			if(PresupuestoFlujoCajaLogicAdditional.validarSaveRelaciones(presupuestoflujocaja,this)) {

				PresupuestoFlujoCajaLogicAdditional.updateRelacionesToSave(presupuestoflujocaja,this);

				if((presupuestoflujocaja.getIsNew()||presupuestoflujocaja.getIsChanged())&&!presupuestoflujocaja.getIsDeleted()) {
					this.savePresupuestoFlujoCaja();
					this.savePresupuestoFlujoCajaRelacionesDetalles();

				} else if(presupuestoflujocaja.getIsDeleted()) {
					this.savePresupuestoFlujoCajaRelacionesDetalles();
					this.savePresupuestoFlujoCaja();
				}

				PresupuestoFlujoCajaLogicAdditional.updateRelacionesToSaveAfter(presupuestoflujocaja,this);

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
	
	
	private void savePresupuestoFlujoCajaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPresupuestoFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresupuestoFlujoCajaConstantesFunciones.getClassesForeignKeysOfPresupuestoFlujoCaja(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestoFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresupuestoFlujoCajaConstantesFunciones.getClassesRelationshipsOfPresupuestoFlujoCaja(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

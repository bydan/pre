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
package com.bydan.erp.tesoreria.business.logic;

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
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.tesoreria.util.PresupuestoFlujoCajaTsrConstantesFunciones;
import com.bydan.erp.tesoreria.util.PresupuestoFlujoCajaTsrParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.PresupuestoFlujoCajaTsrParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.PresupuestoFlujoCajaTsr;
import com.bydan.erp.tesoreria.business.logic.PresupuestoFlujoCajaTsrLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

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
public class PresupuestoFlujoCajaTsrLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PresupuestoFlujoCajaTsrLogic.class);
	
	protected PresupuestoFlujoCajaTsrDataAccess presupuestoflujocajatsrDataAccess; 	
	protected PresupuestoFlujoCajaTsr presupuestoflujocajatsr;
	protected List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrs;
	protected Object presupuestoflujocajatsrObject;	
	protected List<Object> presupuestoflujocajatsrsObject;
	
	public static ClassValidator<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrValidator = new ClassValidator<PresupuestoFlujoCajaTsr>(PresupuestoFlujoCajaTsr.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PresupuestoFlujoCajaTsrLogicAdditional presupuestoflujocajatsrLogicAdditional=null;
	
	public PresupuestoFlujoCajaTsrLogicAdditional getPresupuestoFlujoCajaTsrLogicAdditional() {
		return this.presupuestoflujocajatsrLogicAdditional;
	}
	
	public void setPresupuestoFlujoCajaTsrLogicAdditional(PresupuestoFlujoCajaTsrLogicAdditional presupuestoflujocajatsrLogicAdditional) {
		try {
			this.presupuestoflujocajatsrLogicAdditional=presupuestoflujocajatsrLogicAdditional;
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
	
	
	
	
	public  PresupuestoFlujoCajaTsrLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.presupuestoflujocajatsrDataAccess = new PresupuestoFlujoCajaTsrDataAccess();
			
			this.presupuestoflujocajatsrs= new ArrayList<PresupuestoFlujoCajaTsr>();
			this.presupuestoflujocajatsr= new PresupuestoFlujoCajaTsr();
			
			this.presupuestoflujocajatsrObject=new Object();
			this.presupuestoflujocajatsrsObject=new ArrayList<Object>();
				
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
			
			this.presupuestoflujocajatsrDataAccess.setConnexionType(this.connexionType);
			this.presupuestoflujocajatsrDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PresupuestoFlujoCajaTsrLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.presupuestoflujocajatsrDataAccess = new PresupuestoFlujoCajaTsrDataAccess();
			this.presupuestoflujocajatsrs= new ArrayList<PresupuestoFlujoCajaTsr>();
			this.presupuestoflujocajatsr= new PresupuestoFlujoCajaTsr();
			this.presupuestoflujocajatsrObject=new Object();
			this.presupuestoflujocajatsrsObject=new ArrayList<Object>();
			
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
			
			this.presupuestoflujocajatsrDataAccess.setConnexionType(this.connexionType);
			this.presupuestoflujocajatsrDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PresupuestoFlujoCajaTsr getPresupuestoFlujoCajaTsr() throws Exception {	
		PresupuestoFlujoCajaTsrLogicAdditional.checkPresupuestoFlujoCajaTsrToGet(presupuestoflujocajatsr,this.datosCliente,this.arrDatoGeneral);
		PresupuestoFlujoCajaTsrLogicAdditional.updatePresupuestoFlujoCajaTsrToGet(presupuestoflujocajatsr,this.arrDatoGeneral);
		
		return presupuestoflujocajatsr;
	}
		
	public void setPresupuestoFlujoCajaTsr(PresupuestoFlujoCajaTsr newPresupuestoFlujoCajaTsr) {
		this.presupuestoflujocajatsr = newPresupuestoFlujoCajaTsr;
	}
	
	public PresupuestoFlujoCajaTsrDataAccess getPresupuestoFlujoCajaTsrDataAccess() {
		return presupuestoflujocajatsrDataAccess;
	}
	
	public void setPresupuestoFlujoCajaTsrDataAccess(PresupuestoFlujoCajaTsrDataAccess newpresupuestoflujocajatsrDataAccess) {
		this.presupuestoflujocajatsrDataAccess = newpresupuestoflujocajatsrDataAccess;
	}
	
	public List<PresupuestoFlujoCajaTsr> getPresupuestoFlujoCajaTsrs() throws Exception {		
		this.quitarPresupuestoFlujoCajaTsrsNulos();
		
		PresupuestoFlujoCajaTsrLogicAdditional.checkPresupuestoFlujoCajaTsrToGets(presupuestoflujocajatsrs,this.datosCliente,this.arrDatoGeneral);
		
		for (PresupuestoFlujoCajaTsr presupuestoflujocajatsrLocal: presupuestoflujocajatsrs ) {
			PresupuestoFlujoCajaTsrLogicAdditional.updatePresupuestoFlujoCajaTsrToGet(presupuestoflujocajatsrLocal,this.arrDatoGeneral);
		}
		
		return presupuestoflujocajatsrs;
	}
	
	public void setPresupuestoFlujoCajaTsrs(List<PresupuestoFlujoCajaTsr> newPresupuestoFlujoCajaTsrs) {
		this.presupuestoflujocajatsrs = newPresupuestoFlujoCajaTsrs;
	}
	
	public Object getPresupuestoFlujoCajaTsrObject() {	
		this.presupuestoflujocajatsrObject=this.presupuestoflujocajatsrDataAccess.getEntityObject();
		return this.presupuestoflujocajatsrObject;
	}
		
	public void setPresupuestoFlujoCajaTsrObject(Object newPresupuestoFlujoCajaTsrObject) {
		this.presupuestoflujocajatsrObject = newPresupuestoFlujoCajaTsrObject;
	}
	
	public List<Object> getPresupuestoFlujoCajaTsrsObject() {		
		this.presupuestoflujocajatsrsObject=this.presupuestoflujocajatsrDataAccess.getEntitiesObject();
		return this.presupuestoflujocajatsrsObject;
	}
		
	public void setPresupuestoFlujoCajaTsrsObject(List<Object> newPresupuestoFlujoCajaTsrsObject) {
		this.presupuestoflujocajatsrsObject = newPresupuestoFlujoCajaTsrsObject;
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
		
		if(this.presupuestoflujocajatsrDataAccess!=null) {
			this.presupuestoflujocajatsrDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			presupuestoflujocajatsrDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			presupuestoflujocajatsrDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		presupuestoflujocajatsr = new  PresupuestoFlujoCajaTsr();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presupuestoflujocajatsr=presupuestoflujocajatsrDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestoflujocajatsr,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsr);
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
		presupuestoflujocajatsr = new  PresupuestoFlujoCajaTsr();
		  		  
        try {
			
			presupuestoflujocajatsr=presupuestoflujocajatsrDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestoflujocajatsr,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsr);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		presupuestoflujocajatsr = new  PresupuestoFlujoCajaTsr();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presupuestoflujocajatsr=presupuestoflujocajatsrDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestoflujocajatsr,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsr);
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
		presupuestoflujocajatsr = new  PresupuestoFlujoCajaTsr();
		  		  
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
		presupuestoflujocajatsr = new  PresupuestoFlujoCajaTsr();
		  		  
        try {
			
			presupuestoflujocajatsr=presupuestoflujocajatsrDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestoflujocajatsr,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsr);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		presupuestoflujocajatsr = new  PresupuestoFlujoCajaTsr();
		  		  
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
		presupuestoflujocajatsr = new  PresupuestoFlujoCajaTsr();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =presupuestoflujocajatsrDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presupuestoflujocajatsr = new  PresupuestoFlujoCajaTsr();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=presupuestoflujocajatsrDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presupuestoflujocajatsr = new  PresupuestoFlujoCajaTsr();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =presupuestoflujocajatsrDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presupuestoflujocajatsr = new  PresupuestoFlujoCajaTsr();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=presupuestoflujocajatsrDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presupuestoflujocajatsr = new  PresupuestoFlujoCajaTsr();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =presupuestoflujocajatsrDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presupuestoflujocajatsr = new  PresupuestoFlujoCajaTsr();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=presupuestoflujocajatsrDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presupuestoflujocajatsrs = new  ArrayList<PresupuestoFlujoCajaTsr>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoFlujoCajaTsr(presupuestoflujocajatsrs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
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
		presupuestoflujocajatsrs = new  ArrayList<PresupuestoFlujoCajaTsr>();
		  		  
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
		presupuestoflujocajatsrs = new  ArrayList<PresupuestoFlujoCajaTsr>();
		  		  
        try {			
			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPresupuestoFlujoCajaTsr(presupuestoflujocajatsrs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		presupuestoflujocajatsrs = new  ArrayList<PresupuestoFlujoCajaTsr>();
		  		  
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
		presupuestoflujocajatsrs = new  ArrayList<PresupuestoFlujoCajaTsr>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoFlujoCajaTsr(presupuestoflujocajatsrs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
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
		presupuestoflujocajatsrs = new  ArrayList<PresupuestoFlujoCajaTsr>();
		  		  
        try {
			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoFlujoCajaTsr(presupuestoflujocajatsrs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
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
		presupuestoflujocajatsrs = new  ArrayList<PresupuestoFlujoCajaTsr>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoFlujoCajaTsr(presupuestoflujocajatsrs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
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
		presupuestoflujocajatsrs = new  ArrayList<PresupuestoFlujoCajaTsr>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoFlujoCajaTsr(presupuestoflujocajatsrs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		presupuestoflujocajatsr = new  PresupuestoFlujoCajaTsr();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajatsr=presupuestoflujocajatsrDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoFlujoCajaTsr(presupuestoflujocajatsr);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsr);
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
		presupuestoflujocajatsr = new  PresupuestoFlujoCajaTsr();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajatsr=presupuestoflujocajatsrDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoFlujoCajaTsr(presupuestoflujocajatsr);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsr);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presupuestoflujocajatsrs = new  ArrayList<PresupuestoFlujoCajaTsr>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoFlujoCajaTsr(presupuestoflujocajatsrs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
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
		presupuestoflujocajatsrs = new  ArrayList<PresupuestoFlujoCajaTsr>();
		  		  
        try {
			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoFlujoCajaTsr(presupuestoflujocajatsrs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPresupuestoFlujoCajaTsrsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		presupuestoflujocajatsrs = new  ArrayList<PresupuestoFlujoCajaTsr>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getTodosPresupuestoFlujoCajaTsrsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresupuestoFlujoCajaTsr(presupuestoflujocajatsrs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
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
	
	public  void  getTodosPresupuestoFlujoCajaTsrs(String sFinalQuery,Pagination pagination)throws Exception {
		presupuestoflujocajatsrs = new  ArrayList<PresupuestoFlujoCajaTsr>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresupuestoFlujoCajaTsr(presupuestoflujocajatsrs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPresupuestoFlujoCajaTsr(PresupuestoFlujoCajaTsr presupuestoflujocajatsr) throws Exception {
		Boolean estaValidado=false;
		
		if(presupuestoflujocajatsr.getIsNew() || presupuestoflujocajatsr.getIsChanged()) { 
			this.invalidValues = presupuestoflujocajatsrValidator.getInvalidValues(presupuestoflujocajatsr);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(presupuestoflujocajatsr);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPresupuestoFlujoCajaTsr(List<PresupuestoFlujoCajaTsr> PresupuestoFlujoCajaTsrs) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PresupuestoFlujoCajaTsr presupuestoflujocajatsrLocal:presupuestoflujocajatsrs) {				
			estaValidadoObjeto=this.validarGuardarPresupuestoFlujoCajaTsr(presupuestoflujocajatsrLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPresupuestoFlujoCajaTsr(List<PresupuestoFlujoCajaTsr> PresupuestoFlujoCajaTsrs) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresupuestoFlujoCajaTsr(presupuestoflujocajatsrs)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPresupuestoFlujoCajaTsr(PresupuestoFlujoCajaTsr PresupuestoFlujoCajaTsr) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresupuestoFlujoCajaTsr(presupuestoflujocajatsr)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PresupuestoFlujoCajaTsr presupuestoflujocajatsr) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+presupuestoflujocajatsr.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PresupuestoFlujoCajaTsrConstantesFunciones.getPresupuestoFlujoCajaTsrLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"presupuestoflujocajatsr","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PresupuestoFlujoCajaTsrConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PresupuestoFlujoCajaTsrConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePresupuestoFlujoCajaTsrWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-savePresupuestoFlujoCajaTsrWithConnection");connexion.begin();			
			
			PresupuestoFlujoCajaTsrLogicAdditional.checkPresupuestoFlujoCajaTsrToSave(this.presupuestoflujocajatsr,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresupuestoFlujoCajaTsrLogicAdditional.updatePresupuestoFlujoCajaTsrToSave(this.presupuestoflujocajatsr,this.arrDatoGeneral);
			
			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presupuestoflujocajatsr,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPresupuestoFlujoCajaTsr();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsr)) {
				PresupuestoFlujoCajaTsrDataAccess.save(this.presupuestoflujocajatsr, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.presupuestoflujocajatsr,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresupuestoFlujoCajaTsrLogicAdditional.checkPresupuestoFlujoCajaTsrToSaveAfter(this.presupuestoflujocajatsr,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresupuestoFlujoCajaTsr();
			
			connexion.commit();			
			
			if(this.presupuestoflujocajatsr.getIsDeleted()) {
				this.presupuestoflujocajatsr=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePresupuestoFlujoCajaTsr()throws Exception {	
		try {	
			
			PresupuestoFlujoCajaTsrLogicAdditional.checkPresupuestoFlujoCajaTsrToSave(this.presupuestoflujocajatsr,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresupuestoFlujoCajaTsrLogicAdditional.updatePresupuestoFlujoCajaTsrToSave(this.presupuestoflujocajatsr,this.arrDatoGeneral);
			
			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presupuestoflujocajatsr,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsr)) {			
				PresupuestoFlujoCajaTsrDataAccess.save(this.presupuestoflujocajatsr, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.presupuestoflujocajatsr,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresupuestoFlujoCajaTsrLogicAdditional.checkPresupuestoFlujoCajaTsrToSaveAfter(this.presupuestoflujocajatsr,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.presupuestoflujocajatsr.getIsDeleted()) {
				this.presupuestoflujocajatsr=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePresupuestoFlujoCajaTsrsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-savePresupuestoFlujoCajaTsrsWithConnection");connexion.begin();			
			
			PresupuestoFlujoCajaTsrLogicAdditional.checkPresupuestoFlujoCajaTsrToSaves(presupuestoflujocajatsrs,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPresupuestoFlujoCajaTsrs();
			
			Boolean validadoTodosPresupuestoFlujoCajaTsr=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresupuestoFlujoCajaTsr presupuestoflujocajatsrLocal:presupuestoflujocajatsrs) {		
				if(presupuestoflujocajatsrLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresupuestoFlujoCajaTsrLogicAdditional.updatePresupuestoFlujoCajaTsrToSave(presupuestoflujocajatsrLocal,this.arrDatoGeneral);
	        	
				PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presupuestoflujocajatsrLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresupuestoFlujoCajaTsr(presupuestoflujocajatsrLocal)) {
					PresupuestoFlujoCajaTsrDataAccess.save(presupuestoflujocajatsrLocal, connexion);				
				} else {
					validadoTodosPresupuestoFlujoCajaTsr=false;
				}
			}
			
			if(!validadoTodosPresupuestoFlujoCajaTsr) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresupuestoFlujoCajaTsrLogicAdditional.checkPresupuestoFlujoCajaTsrToSavesAfter(presupuestoflujocajatsrs,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresupuestoFlujoCajaTsrs();
			
			connexion.commit();		
			
			this.quitarPresupuestoFlujoCajaTsrsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePresupuestoFlujoCajaTsrs()throws Exception {				
		 try {	
			PresupuestoFlujoCajaTsrLogicAdditional.checkPresupuestoFlujoCajaTsrToSaves(presupuestoflujocajatsrs,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPresupuestoFlujoCajaTsr=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresupuestoFlujoCajaTsr presupuestoflujocajatsrLocal:presupuestoflujocajatsrs) {				
				if(presupuestoflujocajatsrLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresupuestoFlujoCajaTsrLogicAdditional.updatePresupuestoFlujoCajaTsrToSave(presupuestoflujocajatsrLocal,this.arrDatoGeneral);
	        	
				PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presupuestoflujocajatsrLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresupuestoFlujoCajaTsr(presupuestoflujocajatsrLocal)) {				
					PresupuestoFlujoCajaTsrDataAccess.save(presupuestoflujocajatsrLocal, connexion);				
				} else {
					validadoTodosPresupuestoFlujoCajaTsr=false;
				}
			}
			
			if(!validadoTodosPresupuestoFlujoCajaTsr) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresupuestoFlujoCajaTsrLogicAdditional.checkPresupuestoFlujoCajaTsrToSavesAfter(presupuestoflujocajatsrs,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPresupuestoFlujoCajaTsrsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresupuestoFlujoCajaTsrParameterReturnGeneral procesarAccionPresupuestoFlujoCajaTsrs(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrs,PresupuestoFlujoCajaTsrParameterReturnGeneral presupuestoflujocajatsrParameterGeneral)throws Exception {
		 try {	
			PresupuestoFlujoCajaTsrParameterReturnGeneral presupuestoflujocajatsrReturnGeneral=new PresupuestoFlujoCajaTsrParameterReturnGeneral();
	
			PresupuestoFlujoCajaTsrLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presupuestoflujocajatsrs,presupuestoflujocajatsrParameterGeneral,presupuestoflujocajatsrReturnGeneral);
			
			return presupuestoflujocajatsrReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresupuestoFlujoCajaTsrParameterReturnGeneral procesarAccionPresupuestoFlujoCajaTsrsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrs,PresupuestoFlujoCajaTsrParameterReturnGeneral presupuestoflujocajatsrParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-procesarAccionPresupuestoFlujoCajaTsrsWithConnection");connexion.begin();			
			
			PresupuestoFlujoCajaTsrParameterReturnGeneral presupuestoflujocajatsrReturnGeneral=new PresupuestoFlujoCajaTsrParameterReturnGeneral();
	
			PresupuestoFlujoCajaTsrLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presupuestoflujocajatsrs,presupuestoflujocajatsrParameterGeneral,presupuestoflujocajatsrReturnGeneral);
			
			this.connexion.commit();
			
			return presupuestoflujocajatsrReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresupuestoFlujoCajaTsrParameterReturnGeneral procesarEventosPresupuestoFlujoCajaTsrs(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrs,PresupuestoFlujoCajaTsr presupuestoflujocajatsr,PresupuestoFlujoCajaTsrParameterReturnGeneral presupuestoflujocajatsrParameterGeneral,Boolean isEsNuevoPresupuestoFlujoCajaTsr,ArrayList<Classe> clases)throws Exception {
		 try {	
			PresupuestoFlujoCajaTsrParameterReturnGeneral presupuestoflujocajatsrReturnGeneral=new PresupuestoFlujoCajaTsrParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presupuestoflujocajatsrReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresupuestoFlujoCajaTsrLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presupuestoflujocajatsrs,presupuestoflujocajatsr,presupuestoflujocajatsrParameterGeneral,presupuestoflujocajatsrReturnGeneral,isEsNuevoPresupuestoFlujoCajaTsr,clases);
			
			return presupuestoflujocajatsrReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PresupuestoFlujoCajaTsrParameterReturnGeneral procesarEventosPresupuestoFlujoCajaTsrsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrs,PresupuestoFlujoCajaTsr presupuestoflujocajatsr,PresupuestoFlujoCajaTsrParameterReturnGeneral presupuestoflujocajatsrParameterGeneral,Boolean isEsNuevoPresupuestoFlujoCajaTsr,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-procesarEventosPresupuestoFlujoCajaTsrsWithConnection");connexion.begin();			
			
			PresupuestoFlujoCajaTsrParameterReturnGeneral presupuestoflujocajatsrReturnGeneral=new PresupuestoFlujoCajaTsrParameterReturnGeneral();
	
			presupuestoflujocajatsrReturnGeneral.setPresupuestoFlujoCajaTsr(presupuestoflujocajatsr);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presupuestoflujocajatsrReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresupuestoFlujoCajaTsrLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presupuestoflujocajatsrs,presupuestoflujocajatsr,presupuestoflujocajatsrParameterGeneral,presupuestoflujocajatsrReturnGeneral,isEsNuevoPresupuestoFlujoCajaTsr,clases);
			
			this.connexion.commit();
			
			return presupuestoflujocajatsrReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresupuestoFlujoCajaTsrParameterReturnGeneral procesarImportacionPresupuestoFlujoCajaTsrsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PresupuestoFlujoCajaTsrParameterReturnGeneral presupuestoflujocajatsrParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-procesarImportacionPresupuestoFlujoCajaTsrsWithConnection");connexion.begin();			
			
			PresupuestoFlujoCajaTsrParameterReturnGeneral presupuestoflujocajatsrReturnGeneral=new PresupuestoFlujoCajaTsrParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.presupuestoflujocajatsrs=new ArrayList<PresupuestoFlujoCajaTsr>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.presupuestoflujocajatsr=new PresupuestoFlujoCajaTsr();
				
				
				if(conColumnasBase) {this.presupuestoflujocajatsr.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.presupuestoflujocajatsr.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.presupuestoflujocajatsr.setcodigo(arrColumnas[iColumn++]);
				this.presupuestoflujocajatsr.setnombre(arrColumnas[iColumn++]);
				this.presupuestoflujocajatsr.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.presupuestoflujocajatsr.setfecha_presupuesto(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.presupuestoflujocajatsr.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.presupuestoflujocajatsr.setdescripcion(arrColumnas[iColumn++]);
				
				this.presupuestoflujocajatsrs.add(this.presupuestoflujocajatsr);
			}
			
			this.savePresupuestoFlujoCajaTsrs();
			
			this.connexion.commit();
			
			presupuestoflujocajatsrReturnGeneral.setConRetornoEstaProcesado(true);
			presupuestoflujocajatsrReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return presupuestoflujocajatsrReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPresupuestoFlujoCajaTsrsEliminados() throws Exception {				
		
		List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrsAux= new ArrayList<PresupuestoFlujoCajaTsr>();
		
		for(PresupuestoFlujoCajaTsr presupuestoflujocajatsr:presupuestoflujocajatsrs) {
			if(!presupuestoflujocajatsr.getIsDeleted()) {
				presupuestoflujocajatsrsAux.add(presupuestoflujocajatsr);
			}
		}
		
		presupuestoflujocajatsrs=presupuestoflujocajatsrsAux;
	}
	
	public void quitarPresupuestoFlujoCajaTsrsNulos() throws Exception {				
		
		List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrsAux= new ArrayList<PresupuestoFlujoCajaTsr>();
		
		for(PresupuestoFlujoCajaTsr presupuestoflujocajatsr : this.presupuestoflujocajatsrs) {
			if(presupuestoflujocajatsr==null) {
				presupuestoflujocajatsrsAux.add(presupuestoflujocajatsr);
			}
		}
		
		//this.presupuestoflujocajatsrs=presupuestoflujocajatsrsAux;
		
		this.presupuestoflujocajatsrs.removeAll(presupuestoflujocajatsrsAux);
	}
	
	public void getSetVersionRowPresupuestoFlujoCajaTsrWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(presupuestoflujocajatsr.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((presupuestoflujocajatsr.getIsDeleted() || (presupuestoflujocajatsr.getIsChanged()&&!presupuestoflujocajatsr.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=presupuestoflujocajatsrDataAccess.getSetVersionRowPresupuestoFlujoCajaTsr(connexion,presupuestoflujocajatsr.getId());
				
				if(!presupuestoflujocajatsr.getVersionRow().equals(timestamp)) {	
					presupuestoflujocajatsr.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				presupuestoflujocajatsr.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPresupuestoFlujoCajaTsr()throws Exception {	
		
		if(presupuestoflujocajatsr.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((presupuestoflujocajatsr.getIsDeleted() || (presupuestoflujocajatsr.getIsChanged()&&!presupuestoflujocajatsr.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=presupuestoflujocajatsrDataAccess.getSetVersionRowPresupuestoFlujoCajaTsr(connexion,presupuestoflujocajatsr.getId());
			
			try {							
				if(!presupuestoflujocajatsr.getVersionRow().equals(timestamp)) {	
					presupuestoflujocajatsr.setVersionRow(timestamp);
				}
				
				presupuestoflujocajatsr.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPresupuestoFlujoCajaTsrsWithConnection()throws Exception {	
		if(presupuestoflujocajatsrs!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PresupuestoFlujoCajaTsr presupuestoflujocajatsrAux:presupuestoflujocajatsrs) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(presupuestoflujocajatsrAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presupuestoflujocajatsrAux.getIsDeleted() || (presupuestoflujocajatsrAux.getIsChanged()&&!presupuestoflujocajatsrAux.getIsNew())) {
						
						timestamp=presupuestoflujocajatsrDataAccess.getSetVersionRowPresupuestoFlujoCajaTsr(connexion,presupuestoflujocajatsrAux.getId());
						
						if(!presupuestoflujocajatsr.getVersionRow().equals(timestamp)) {	
							presupuestoflujocajatsrAux.setVersionRow(timestamp);
						}
								
						presupuestoflujocajatsrAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPresupuestoFlujoCajaTsrs()throws Exception {	
		if(presupuestoflujocajatsrs!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PresupuestoFlujoCajaTsr presupuestoflujocajatsrAux:presupuestoflujocajatsrs) {
					if(presupuestoflujocajatsrAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presupuestoflujocajatsrAux.getIsDeleted() || (presupuestoflujocajatsrAux.getIsChanged()&&!presupuestoflujocajatsrAux.getIsNew())) {
						
						timestamp=presupuestoflujocajatsrDataAccess.getSetVersionRowPresupuestoFlujoCajaTsr(connexion,presupuestoflujocajatsrAux.getId());
						
						if(!presupuestoflujocajatsrAux.getVersionRow().equals(timestamp)) {	
							presupuestoflujocajatsrAux.setVersionRow(timestamp);
						}
						
													
						presupuestoflujocajatsrAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PresupuestoFlujoCajaTsrParameterReturnGeneral cargarCombosLoteForeignKeyPresupuestoFlujoCajaTsrWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalUsuario,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalTipoMovimiento,String finalQueryGlobalCentroActividad,String finalQueryGlobalCuentaContable,String finalQueryGlobalCentroCosto) throws Exception {
		PresupuestoFlujoCajaTsrParameterReturnGeneral  presupuestoflujocajatsrReturnGeneral =new PresupuestoFlujoCajaTsrParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-cargarCombosLoteForeignKeyPresupuestoFlujoCajaTsrWithConnection");connexion.begin();
			
			presupuestoflujocajatsrReturnGeneral =new PresupuestoFlujoCajaTsrParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			presupuestoflujocajatsrReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			presupuestoflujocajatsrReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			presupuestoflujocajatsrReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			presupuestoflujocajatsrReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			presupuestoflujocajatsrReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			presupuestoflujocajatsrReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			presupuestoflujocajatsrReturnGeneral.setmessForeignKey(messForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			presupuestoflujocajatsrReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);


			List<CentroActividad> centroactividadsForeignKey=new ArrayList<CentroActividad>();
			CentroActividadLogic centroactividadLogic=new CentroActividadLogic();
			centroactividadLogic.setConnexion(this.connexion);
			centroactividadLogic.getCentroActividadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroActividad.equals("NONE")) {
				centroactividadLogic.getTodosCentroActividads(finalQueryGlobalCentroActividad,new Pagination());
				centroactividadsForeignKey=centroactividadLogic.getCentroActividads();
			}

			presupuestoflujocajatsrReturnGeneral.setcentroactividadsForeignKey(centroactividadsForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			presupuestoflujocajatsrReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			presupuestoflujocajatsrReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return presupuestoflujocajatsrReturnGeneral;
	}
	
	public PresupuestoFlujoCajaTsrParameterReturnGeneral cargarCombosLoteForeignKeyPresupuestoFlujoCajaTsr(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalUsuario,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalTipoMovimiento,String finalQueryGlobalCentroActividad,String finalQueryGlobalCuentaContable,String finalQueryGlobalCentroCosto) throws Exception {
		PresupuestoFlujoCajaTsrParameterReturnGeneral  presupuestoflujocajatsrReturnGeneral =new PresupuestoFlujoCajaTsrParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			presupuestoflujocajatsrReturnGeneral =new PresupuestoFlujoCajaTsrParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			presupuestoflujocajatsrReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			presupuestoflujocajatsrReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			presupuestoflujocajatsrReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			presupuestoflujocajatsrReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			presupuestoflujocajatsrReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			presupuestoflujocajatsrReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			presupuestoflujocajatsrReturnGeneral.setmessForeignKey(messForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			presupuestoflujocajatsrReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);


			List<CentroActividad> centroactividadsForeignKey=new ArrayList<CentroActividad>();
			CentroActividadLogic centroactividadLogic=new CentroActividadLogic();
			centroactividadLogic.setConnexion(this.connexion);
			centroactividadLogic.getCentroActividadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroActividad.equals("NONE")) {
				centroactividadLogic.getTodosCentroActividads(finalQueryGlobalCentroActividad,new Pagination());
				centroactividadsForeignKey=centroactividadLogic.getCentroActividads();
			}

			presupuestoflujocajatsrReturnGeneral.setcentroactividadsForeignKey(centroactividadsForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			presupuestoflujocajatsrReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			presupuestoflujocajatsrReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return presupuestoflujocajatsrReturnGeneral;
	}
	
	
	public void deepLoad(PresupuestoFlujoCajaTsr presupuestoflujocajatsr,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PresupuestoFlujoCajaTsrLogicAdditional.updatePresupuestoFlujoCajaTsrToGet(presupuestoflujocajatsr,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presupuestoflujocajatsr.setEmpresa(presupuestoflujocajatsrDataAccess.getEmpresa(connexion,presupuestoflujocajatsr));
		presupuestoflujocajatsr.setSucursal(presupuestoflujocajatsrDataAccess.getSucursal(connexion,presupuestoflujocajatsr));
		presupuestoflujocajatsr.setEjercicio(presupuestoflujocajatsrDataAccess.getEjercicio(connexion,presupuestoflujocajatsr));
		presupuestoflujocajatsr.setPeriodo(presupuestoflujocajatsrDataAccess.getPeriodo(connexion,presupuestoflujocajatsr));
		presupuestoflujocajatsr.setUsuario(presupuestoflujocajatsrDataAccess.getUsuario(connexion,presupuestoflujocajatsr));
		presupuestoflujocajatsr.setAnio(presupuestoflujocajatsrDataAccess.getAnio(connexion,presupuestoflujocajatsr));
		presupuestoflujocajatsr.setMes(presupuestoflujocajatsrDataAccess.getMes(connexion,presupuestoflujocajatsr));
		presupuestoflujocajatsr.setTipoMovimiento(presupuestoflujocajatsrDataAccess.getTipoMovimiento(connexion,presupuestoflujocajatsr));
		presupuestoflujocajatsr.setCentroActividad(presupuestoflujocajatsrDataAccess.getCentroActividad(connexion,presupuestoflujocajatsr));
		presupuestoflujocajatsr.setCuentaContable(presupuestoflujocajatsrDataAccess.getCuentaContable(connexion,presupuestoflujocajatsr));
		presupuestoflujocajatsr.setCentroCosto(presupuestoflujocajatsrDataAccess.getCentroCosto(connexion,presupuestoflujocajatsr));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				presupuestoflujocajatsr.setEmpresa(presupuestoflujocajatsrDataAccess.getEmpresa(connexion,presupuestoflujocajatsr));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				presupuestoflujocajatsr.setSucursal(presupuestoflujocajatsrDataAccess.getSucursal(connexion,presupuestoflujocajatsr));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				presupuestoflujocajatsr.setEjercicio(presupuestoflujocajatsrDataAccess.getEjercicio(connexion,presupuestoflujocajatsr));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				presupuestoflujocajatsr.setPeriodo(presupuestoflujocajatsrDataAccess.getPeriodo(connexion,presupuestoflujocajatsr));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				presupuestoflujocajatsr.setUsuario(presupuestoflujocajatsrDataAccess.getUsuario(connexion,presupuestoflujocajatsr));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				presupuestoflujocajatsr.setAnio(presupuestoflujocajatsrDataAccess.getAnio(connexion,presupuestoflujocajatsr));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				presupuestoflujocajatsr.setMes(presupuestoflujocajatsrDataAccess.getMes(connexion,presupuestoflujocajatsr));
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				presupuestoflujocajatsr.setTipoMovimiento(presupuestoflujocajatsrDataAccess.getTipoMovimiento(connexion,presupuestoflujocajatsr));
				continue;
			}

			if(clas.clas.equals(CentroActividad.class)) {
				presupuestoflujocajatsr.setCentroActividad(presupuestoflujocajatsrDataAccess.getCentroActividad(connexion,presupuestoflujocajatsr));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				presupuestoflujocajatsr.setCuentaContable(presupuestoflujocajatsrDataAccess.getCuentaContable(connexion,presupuestoflujocajatsr));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				presupuestoflujocajatsr.setCentroCosto(presupuestoflujocajatsrDataAccess.getCentroCosto(connexion,presupuestoflujocajatsr));
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
			presupuestoflujocajatsr.setEmpresa(presupuestoflujocajatsrDataAccess.getEmpresa(connexion,presupuestoflujocajatsr));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocajatsr.setSucursal(presupuestoflujocajatsrDataAccess.getSucursal(connexion,presupuestoflujocajatsr));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocajatsr.setEjercicio(presupuestoflujocajatsrDataAccess.getEjercicio(connexion,presupuestoflujocajatsr));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocajatsr.setPeriodo(presupuestoflujocajatsrDataAccess.getPeriodo(connexion,presupuestoflujocajatsr));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocajatsr.setUsuario(presupuestoflujocajatsrDataAccess.getUsuario(connexion,presupuestoflujocajatsr));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocajatsr.setAnio(presupuestoflujocajatsrDataAccess.getAnio(connexion,presupuestoflujocajatsr));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocajatsr.setMes(presupuestoflujocajatsrDataAccess.getMes(connexion,presupuestoflujocajatsr));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocajatsr.setTipoMovimiento(presupuestoflujocajatsrDataAccess.getTipoMovimiento(connexion,presupuestoflujocajatsr));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroActividad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocajatsr.setCentroActividad(presupuestoflujocajatsrDataAccess.getCentroActividad(connexion,presupuestoflujocajatsr));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocajatsr.setCuentaContable(presupuestoflujocajatsrDataAccess.getCuentaContable(connexion,presupuestoflujocajatsr));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocajatsr.setCentroCosto(presupuestoflujocajatsrDataAccess.getCentroCosto(connexion,presupuestoflujocajatsr));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presupuestoflujocajatsr.setEmpresa(presupuestoflujocajatsrDataAccess.getEmpresa(connexion,presupuestoflujocajatsr));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(presupuestoflujocajatsr.getEmpresa(),isDeep,deepLoadType,clases);
				
		presupuestoflujocajatsr.setSucursal(presupuestoflujocajatsrDataAccess.getSucursal(connexion,presupuestoflujocajatsr));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(presupuestoflujocajatsr.getSucursal(),isDeep,deepLoadType,clases);
				
		presupuestoflujocajatsr.setEjercicio(presupuestoflujocajatsrDataAccess.getEjercicio(connexion,presupuestoflujocajatsr));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(presupuestoflujocajatsr.getEjercicio(),isDeep,deepLoadType,clases);
				
		presupuestoflujocajatsr.setPeriodo(presupuestoflujocajatsrDataAccess.getPeriodo(connexion,presupuestoflujocajatsr));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(presupuestoflujocajatsr.getPeriodo(),isDeep,deepLoadType,clases);
				
		presupuestoflujocajatsr.setUsuario(presupuestoflujocajatsrDataAccess.getUsuario(connexion,presupuestoflujocajatsr));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(presupuestoflujocajatsr.getUsuario(),isDeep,deepLoadType,clases);
				
		presupuestoflujocajatsr.setAnio(presupuestoflujocajatsrDataAccess.getAnio(connexion,presupuestoflujocajatsr));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(presupuestoflujocajatsr.getAnio(),isDeep,deepLoadType,clases);
				
		presupuestoflujocajatsr.setMes(presupuestoflujocajatsrDataAccess.getMes(connexion,presupuestoflujocajatsr));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(presupuestoflujocajatsr.getMes(),isDeep,deepLoadType,clases);
				
		presupuestoflujocajatsr.setTipoMovimiento(presupuestoflujocajatsrDataAccess.getTipoMovimiento(connexion,presupuestoflujocajatsr));
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(presupuestoflujocajatsr.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		presupuestoflujocajatsr.setCentroActividad(presupuestoflujocajatsrDataAccess.getCentroActividad(connexion,presupuestoflujocajatsr));
		CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
		centroactividadLogic.deepLoad(presupuestoflujocajatsr.getCentroActividad(),isDeep,deepLoadType,clases);
				
		presupuestoflujocajatsr.setCuentaContable(presupuestoflujocajatsrDataAccess.getCuentaContable(connexion,presupuestoflujocajatsr));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(presupuestoflujocajatsr.getCuentaContable(),isDeep,deepLoadType,clases);
				
		presupuestoflujocajatsr.setCentroCosto(presupuestoflujocajatsrDataAccess.getCentroCosto(connexion,presupuestoflujocajatsr));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(presupuestoflujocajatsr.getCentroCosto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				presupuestoflujocajatsr.setEmpresa(presupuestoflujocajatsrDataAccess.getEmpresa(connexion,presupuestoflujocajatsr));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(presupuestoflujocajatsr.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				presupuestoflujocajatsr.setSucursal(presupuestoflujocajatsrDataAccess.getSucursal(connexion,presupuestoflujocajatsr));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(presupuestoflujocajatsr.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				presupuestoflujocajatsr.setEjercicio(presupuestoflujocajatsrDataAccess.getEjercicio(connexion,presupuestoflujocajatsr));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(presupuestoflujocajatsr.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				presupuestoflujocajatsr.setPeriodo(presupuestoflujocajatsrDataAccess.getPeriodo(connexion,presupuestoflujocajatsr));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(presupuestoflujocajatsr.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				presupuestoflujocajatsr.setUsuario(presupuestoflujocajatsrDataAccess.getUsuario(connexion,presupuestoflujocajatsr));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(presupuestoflujocajatsr.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				presupuestoflujocajatsr.setAnio(presupuestoflujocajatsrDataAccess.getAnio(connexion,presupuestoflujocajatsr));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(presupuestoflujocajatsr.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				presupuestoflujocajatsr.setMes(presupuestoflujocajatsrDataAccess.getMes(connexion,presupuestoflujocajatsr));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(presupuestoflujocajatsr.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				presupuestoflujocajatsr.setTipoMovimiento(presupuestoflujocajatsrDataAccess.getTipoMovimiento(connexion,presupuestoflujocajatsr));
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepLoad(presupuestoflujocajatsr.getTipoMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroActividad.class)) {
				presupuestoflujocajatsr.setCentroActividad(presupuestoflujocajatsrDataAccess.getCentroActividad(connexion,presupuestoflujocajatsr));
				CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
				centroactividadLogic.deepLoad(presupuestoflujocajatsr.getCentroActividad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				presupuestoflujocajatsr.setCuentaContable(presupuestoflujocajatsrDataAccess.getCuentaContable(connexion,presupuestoflujocajatsr));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(presupuestoflujocajatsr.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				presupuestoflujocajatsr.setCentroCosto(presupuestoflujocajatsrDataAccess.getCentroCosto(connexion,presupuestoflujocajatsr));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(presupuestoflujocajatsr.getCentroCosto(),isDeep,deepLoadType,clases);				
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
			presupuestoflujocajatsr.setEmpresa(presupuestoflujocajatsrDataAccess.getEmpresa(connexion,presupuestoflujocajatsr));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(presupuestoflujocajatsr.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocajatsr.setSucursal(presupuestoflujocajatsrDataAccess.getSucursal(connexion,presupuestoflujocajatsr));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(presupuestoflujocajatsr.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocajatsr.setEjercicio(presupuestoflujocajatsrDataAccess.getEjercicio(connexion,presupuestoflujocajatsr));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(presupuestoflujocajatsr.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocajatsr.setPeriodo(presupuestoflujocajatsrDataAccess.getPeriodo(connexion,presupuestoflujocajatsr));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(presupuestoflujocajatsr.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocajatsr.setUsuario(presupuestoflujocajatsrDataAccess.getUsuario(connexion,presupuestoflujocajatsr));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(presupuestoflujocajatsr.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocajatsr.setAnio(presupuestoflujocajatsrDataAccess.getAnio(connexion,presupuestoflujocajatsr));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(presupuestoflujocajatsr.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocajatsr.setMes(presupuestoflujocajatsrDataAccess.getMes(connexion,presupuestoflujocajatsr));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(presupuestoflujocajatsr.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocajatsr.setTipoMovimiento(presupuestoflujocajatsrDataAccess.getTipoMovimiento(connexion,presupuestoflujocajatsr));
			TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
			tipomovimientoLogic.deepLoad(presupuestoflujocajatsr.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroActividad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocajatsr.setCentroActividad(presupuestoflujocajatsrDataAccess.getCentroActividad(connexion,presupuestoflujocajatsr));
			CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
			centroactividadLogic.deepLoad(presupuestoflujocajatsr.getCentroActividad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocajatsr.setCuentaContable(presupuestoflujocajatsrDataAccess.getCuentaContable(connexion,presupuestoflujocajatsr));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(presupuestoflujocajatsr.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoflujocajatsr.setCentroCosto(presupuestoflujocajatsrDataAccess.getCentroCosto(connexion,presupuestoflujocajatsr));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(presupuestoflujocajatsr.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PresupuestoFlujoCajaTsr presupuestoflujocajatsr,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PresupuestoFlujoCajaTsrLogicAdditional.updatePresupuestoFlujoCajaTsrToSave(presupuestoflujocajatsr,this.arrDatoGeneral);
			
PresupuestoFlujoCajaTsrDataAccess.save(presupuestoflujocajatsr, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(presupuestoflujocajatsr.getEmpresa(),connexion);

		SucursalDataAccess.save(presupuestoflujocajatsr.getSucursal(),connexion);

		EjercicioDataAccess.save(presupuestoflujocajatsr.getEjercicio(),connexion);

		PeriodoDataAccess.save(presupuestoflujocajatsr.getPeriodo(),connexion);

		UsuarioDataAccess.save(presupuestoflujocajatsr.getUsuario(),connexion);

		AnioDataAccess.save(presupuestoflujocajatsr.getAnio(),connexion);

		MesDataAccess.save(presupuestoflujocajatsr.getMes(),connexion);

		TipoMovimientoDataAccess.save(presupuestoflujocajatsr.getTipoMovimiento(),connexion);

		CentroActividadDataAccess.save(presupuestoflujocajatsr.getCentroActividad(),connexion);

		CuentaContableDataAccess.save(presupuestoflujocajatsr.getCuentaContable(),connexion);

		CentroCostoDataAccess.save(presupuestoflujocajatsr.getCentroCosto(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(presupuestoflujocajatsr.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(presupuestoflujocajatsr.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(presupuestoflujocajatsr.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(presupuestoflujocajatsr.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(presupuestoflujocajatsr.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(presupuestoflujocajatsr.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(presupuestoflujocajatsr.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(presupuestoflujocajatsr.getTipoMovimiento(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroActividad.class)) {
				CentroActividadDataAccess.save(presupuestoflujocajatsr.getCentroActividad(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(presupuestoflujocajatsr.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(presupuestoflujocajatsr.getCentroCosto(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(presupuestoflujocajatsr.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(presupuestoflujocajatsr.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(presupuestoflujocajatsr.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(presupuestoflujocajatsr.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(presupuestoflujocajatsr.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(presupuestoflujocajatsr.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(presupuestoflujocajatsr.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(presupuestoflujocajatsr.getPeriodo(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(presupuestoflujocajatsr.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(presupuestoflujocajatsr.getUsuario(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(presupuestoflujocajatsr.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(presupuestoflujocajatsr.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(presupuestoflujocajatsr.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(presupuestoflujocajatsr.getMes(),isDeep,deepLoadType,clases);
				

		TipoMovimientoDataAccess.save(presupuestoflujocajatsr.getTipoMovimiento(),connexion);
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(presupuestoflujocajatsr.getTipoMovimiento(),isDeep,deepLoadType,clases);
				

		CentroActividadDataAccess.save(presupuestoflujocajatsr.getCentroActividad(),connexion);
		CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
		centroactividadLogic.deepLoad(presupuestoflujocajatsr.getCentroActividad(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(presupuestoflujocajatsr.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(presupuestoflujocajatsr.getCuentaContable(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(presupuestoflujocajatsr.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(presupuestoflujocajatsr.getCentroCosto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(presupuestoflujocajatsr.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(presupuestoflujocajatsr.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(presupuestoflujocajatsr.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(presupuestoflujocajatsr.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(presupuestoflujocajatsr.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(presupuestoflujocajatsr.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(presupuestoflujocajatsr.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(presupuestoflujocajatsr.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(presupuestoflujocajatsr.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(presupuestoflujocajatsr.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(presupuestoflujocajatsr.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(presupuestoflujocajatsr.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(presupuestoflujocajatsr.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(presupuestoflujocajatsr.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(presupuestoflujocajatsr.getTipoMovimiento(),connexion);
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepSave(presupuestoflujocajatsr.getTipoMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroActividad.class)) {
				CentroActividadDataAccess.save(presupuestoflujocajatsr.getCentroActividad(),connexion);
				CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
				centroactividadLogic.deepSave(presupuestoflujocajatsr.getCentroActividad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(presupuestoflujocajatsr.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(presupuestoflujocajatsr.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(presupuestoflujocajatsr.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(presupuestoflujocajatsr.getCentroCosto(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PresupuestoFlujoCajaTsr.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(presupuestoflujocajatsr,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(presupuestoflujocajatsr);
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
			this.deepLoad(this.presupuestoflujocajatsr,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsr);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PresupuestoFlujoCajaTsr.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(presupuestoflujocajatsrs!=null) {
				for(PresupuestoFlujoCajaTsr presupuestoflujocajatsr:presupuestoflujocajatsrs) {
					this.deepLoad(presupuestoflujocajatsr,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(presupuestoflujocajatsrs);
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
			if(presupuestoflujocajatsrs!=null) {
				for(PresupuestoFlujoCajaTsr presupuestoflujocajatsr:presupuestoflujocajatsrs) {
					this.deepLoad(presupuestoflujocajatsr,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(presupuestoflujocajatsrs);
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
			this.getNewConnexionToDeep(PresupuestoFlujoCajaTsr.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(presupuestoflujocajatsr,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PresupuestoFlujoCajaTsr.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(presupuestoflujocajatsrs!=null) {
				for(PresupuestoFlujoCajaTsr presupuestoflujocajatsr:presupuestoflujocajatsrs) {
					this.deepSave(presupuestoflujocajatsr,isDeep,deepLoadType,clases);
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
			if(presupuestoflujocajatsrs!=null) {
				for(PresupuestoFlujoCajaTsr presupuestoflujocajatsr:presupuestoflujocajatsrs) {
					this.deepSave(presupuestoflujocajatsr,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPresupuestoFlujoCajaTsrsBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",PresupuestoFlujoCajaTsrConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajaTsrsBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",PresupuestoFlujoCajaTsrConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoFlujoCajaTsrsBusquedaPorFechaWithConnection(String sFinalQuery,Pagination pagination,Date fecha)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFecha= new ParameterSelectionGeneral();
			parameterSelectionGeneralFecha.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha,PresupuestoFlujoCajaTsrConstantesFunciones.FECHA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFecha);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFecha","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajaTsrsBusquedaPorFecha(String sFinalQuery,Pagination pagination,Date fecha)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFecha= new ParameterSelectionGeneral();
			parameterSelectionGeneralFecha.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha,PresupuestoFlujoCajaTsrConstantesFunciones.FECHA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFecha);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFecha","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoFlujoCajaTsrsBusquedaPorFechaPresupuestoWithConnection(String sFinalQuery,Pagination pagination,Date fecha_presupuesto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaPresupuesto= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaPresupuesto.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_presupuesto,PresupuestoFlujoCajaTsrConstantesFunciones.FECHAPRESUPUESTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaPresupuesto);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaPresupuesto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajaTsrsBusquedaPorFechaPresupuesto(String sFinalQuery,Pagination pagination,Date fecha_presupuesto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaPresupuesto= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaPresupuesto.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_presupuesto,PresupuestoFlujoCajaTsrConstantesFunciones.FECHAPRESUPUESTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaPresupuesto);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaPresupuesto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoFlujoCajaTsrsBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",PresupuestoFlujoCajaTsrConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajaTsrsBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",PresupuestoFlujoCajaTsrConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoFlujoCajaTsrsBusquedaPorValorWithConnection(String sFinalQuery,Pagination pagination,Double valor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralValor= new ParameterSelectionGeneral();
			parameterSelectionGeneralValor.setParameterSelectionGeneralEqual(ParameterType.DOUBLE,valor,PresupuestoFlujoCajaTsrConstantesFunciones.VALOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralValor);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorValor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajaTsrsBusquedaPorValor(String sFinalQuery,Pagination pagination,Double valor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralValor= new ParameterSelectionGeneral();
			parameterSelectionGeneralValor.setParameterSelectionGeneralEqual(ParameterType.DOUBLE,valor,PresupuestoFlujoCajaTsrConstantesFunciones.VALOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralValor);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorValor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PresupuestoFlujoCajaTsrConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PresupuestoFlujoCajaTsrConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdCentroActividadWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_actividad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroActividad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroActividad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_actividad,PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROACTIVIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroActividad);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroActividad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdCentroActividad(String sFinalQuery,Pagination pagination,Long id_centro_actividad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroActividad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroActividad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_actividad,PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROACTIVIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroActividad);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroActividad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,PresupuestoFlujoCajaTsrConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,PresupuestoFlujoCajaTsrConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PresupuestoFlujoCajaTsrConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PresupuestoFlujoCajaTsrConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PresupuestoFlujoCajaTsrConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PresupuestoFlujoCajaTsrConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PresupuestoFlujoCajaTsrConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PresupuestoFlujoCajaTsrConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PresupuestoFlujoCajaTsrConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PresupuestoFlujoCajaTsrConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PresupuestoFlujoCajaTsrConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PresupuestoFlujoCajaTsrConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdTipoMovimientoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,PresupuestoFlujoCajaTsrConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdTipoMovimiento(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,PresupuestoFlujoCajaTsrConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoFlujoCajaTsr.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,PresupuestoFlujoCajaTsrConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoFlujoCajaTsrsFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,PresupuestoFlujoCajaTsrConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			PresupuestoFlujoCajaTsrLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoFlujoCajaTsrConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoFlujoCajaTsr(this.presupuestoflujocajatsrs);
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
			if(PresupuestoFlujoCajaTsrConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoFlujoCajaTsrDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PresupuestoFlujoCajaTsr presupuestoflujocajatsr,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PresupuestoFlujoCajaTsrConstantesFunciones.ISCONAUDITORIA) {
				if(presupuestoflujocajatsr.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoFlujoCajaTsrDataAccess.TABLENAME, presupuestoflujocajatsr.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresupuestoFlujoCajaTsrConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresupuestoFlujoCajaTsrLogic.registrarAuditoriaDetallesPresupuestoFlujoCajaTsr(connexion,presupuestoflujocajatsr,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(presupuestoflujocajatsr.getIsDeleted()) {
					/*if(!presupuestoflujocajatsr.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PresupuestoFlujoCajaTsrDataAccess.TABLENAME, presupuestoflujocajatsr.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PresupuestoFlujoCajaTsrLogic.registrarAuditoriaDetallesPresupuestoFlujoCajaTsr(connexion,presupuestoflujocajatsr,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoFlujoCajaTsrDataAccess.TABLENAME, presupuestoflujocajatsr.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(presupuestoflujocajatsr.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoFlujoCajaTsrDataAccess.TABLENAME, presupuestoflujocajatsr.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresupuestoFlujoCajaTsrConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresupuestoFlujoCajaTsrLogic.registrarAuditoriaDetallesPresupuestoFlujoCajaTsr(connexion,presupuestoflujocajatsr,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPresupuestoFlujoCajaTsr(Connexion connexion,PresupuestoFlujoCajaTsr presupuestoflujocajatsr)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(presupuestoflujocajatsr.getIsNew()||!presupuestoflujocajatsr.getid_empresa().equals(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_empresa()!=null)
				{
					strValorActual=presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_empresa().toString();
				}
				if(presupuestoflujocajatsr.getid_empresa()!=null)
				{
					strValorNuevo=presupuestoflujocajatsr.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaTsrConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocajatsr.getIsNew()||!presupuestoflujocajatsr.getid_sucursal().equals(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_sucursal()!=null)
				{
					strValorActual=presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_sucursal().toString();
				}
				if(presupuestoflujocajatsr.getid_sucursal()!=null)
				{
					strValorNuevo=presupuestoflujocajatsr.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaTsrConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocajatsr.getIsNew()||!presupuestoflujocajatsr.getid_ejercicio().equals(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_ejercicio()!=null)
				{
					strValorActual=presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_ejercicio().toString();
				}
				if(presupuestoflujocajatsr.getid_ejercicio()!=null)
				{
					strValorNuevo=presupuestoflujocajatsr.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaTsrConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocajatsr.getIsNew()||!presupuestoflujocajatsr.getid_periodo().equals(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_periodo()!=null)
				{
					strValorActual=presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_periodo().toString();
				}
				if(presupuestoflujocajatsr.getid_periodo()!=null)
				{
					strValorNuevo=presupuestoflujocajatsr.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaTsrConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocajatsr.getIsNew()||!presupuestoflujocajatsr.getid_usuario().equals(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_usuario()!=null)
				{
					strValorActual=presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_usuario().toString();
				}
				if(presupuestoflujocajatsr.getid_usuario()!=null)
				{
					strValorNuevo=presupuestoflujocajatsr.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaTsrConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocajatsr.getIsNew()||!presupuestoflujocajatsr.getid_anio().equals(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_anio()!=null)
				{
					strValorActual=presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_anio().toString();
				}
				if(presupuestoflujocajatsr.getid_anio()!=null)
				{
					strValorNuevo=presupuestoflujocajatsr.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaTsrConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocajatsr.getIsNew()||!presupuestoflujocajatsr.getid_mes().equals(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_mes()!=null)
				{
					strValorActual=presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_mes().toString();
				}
				if(presupuestoflujocajatsr.getid_mes()!=null)
				{
					strValorNuevo=presupuestoflujocajatsr.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaTsrConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocajatsr.getIsNew()||!presupuestoflujocajatsr.getid_tipo_movimiento().equals(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_tipo_movimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_tipo_movimiento()!=null)
				{
					strValorActual=presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_tipo_movimiento().toString();
				}
				if(presupuestoflujocajatsr.getid_tipo_movimiento()!=null)
				{
					strValorNuevo=presupuestoflujocajatsr.getid_tipo_movimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaTsrConstantesFunciones.IDTIPOMOVIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocajatsr.getIsNew()||!presupuestoflujocajatsr.getid_centro_actividad().equals(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_centro_actividad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_centro_actividad()!=null)
				{
					strValorActual=presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_centro_actividad().toString();
				}
				if(presupuestoflujocajatsr.getid_centro_actividad()!=null)
				{
					strValorNuevo=presupuestoflujocajatsr.getid_centro_actividad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROACTIVIDAD,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocajatsr.getIsNew()||!presupuestoflujocajatsr.getcodigo().equals(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getcodigo()!=null)
				{
					strValorActual=presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getcodigo();
				}
				if(presupuestoflujocajatsr.getcodigo()!=null)
				{
					strValorNuevo=presupuestoflujocajatsr.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaTsrConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocajatsr.getIsNew()||!presupuestoflujocajatsr.getnombre().equals(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getnombre()!=null)
				{
					strValorActual=presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getnombre();
				}
				if(presupuestoflujocajatsr.getnombre()!=null)
				{
					strValorNuevo=presupuestoflujocajatsr.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaTsrConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocajatsr.getIsNew()||!presupuestoflujocajatsr.getfecha().equals(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getfecha()!=null)
				{
					strValorActual=presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getfecha().toString();
				}
				if(presupuestoflujocajatsr.getfecha()!=null)
				{
					strValorNuevo=presupuestoflujocajatsr.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaTsrConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocajatsr.getIsNew()||!presupuestoflujocajatsr.getfecha_presupuesto().equals(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getfecha_presupuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getfecha_presupuesto()!=null)
				{
					strValorActual=presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getfecha_presupuesto().toString();
				}
				if(presupuestoflujocajatsr.getfecha_presupuesto()!=null)
				{
					strValorNuevo=presupuestoflujocajatsr.getfecha_presupuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaTsrConstantesFunciones.FECHAPRESUPUESTO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocajatsr.getIsNew()||!presupuestoflujocajatsr.getvalor().equals(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getvalor()!=null)
				{
					strValorActual=presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getvalor().toString();
				}
				if(presupuestoflujocajatsr.getvalor()!=null)
				{
					strValorNuevo=presupuestoflujocajatsr.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaTsrConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocajatsr.getIsNew()||!presupuestoflujocajatsr.getid_cuenta_contable().equals(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_cuenta_contable().toString();
				}
				if(presupuestoflujocajatsr.getid_cuenta_contable()!=null)
				{
					strValorNuevo=presupuestoflujocajatsr.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaTsrConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocajatsr.getIsNew()||!presupuestoflujocajatsr.getid_centro_costo().equals(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_centro_costo()!=null)
				{
					strValorActual=presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getid_centro_costo().toString();
				}
				if(presupuestoflujocajatsr.getid_centro_costo()!=null)
				{
					strValorNuevo=presupuestoflujocajatsr.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoflujocajatsr.getIsNew()||!presupuestoflujocajatsr.getdescripcion().equals(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getdescripcion()!=null)
				{
					strValorActual=presupuestoflujocajatsr.getPresupuestoFlujoCajaTsrOriginal().getdescripcion();
				}
				if(presupuestoflujocajatsr.getdescripcion()!=null)
				{
					strValorNuevo=presupuestoflujocajatsr.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoFlujoCajaTsrConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePresupuestoFlujoCajaTsrRelacionesWithConnection(PresupuestoFlujoCajaTsr presupuestoflujocajatsr) throws Exception {

		if(!presupuestoflujocajatsr.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresupuestoFlujoCajaTsrRelacionesBase(presupuestoflujocajatsr,true);
		}
	}

	public void savePresupuestoFlujoCajaTsrRelaciones(PresupuestoFlujoCajaTsr presupuestoflujocajatsr)throws Exception {

		if(!presupuestoflujocajatsr.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresupuestoFlujoCajaTsrRelacionesBase(presupuestoflujocajatsr,false);
		}
	}

	public void savePresupuestoFlujoCajaTsrRelacionesBase(PresupuestoFlujoCajaTsr presupuestoflujocajatsr,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PresupuestoFlujoCajaTsr-saveRelacionesWithConnection");}
	

			this.setPresupuestoFlujoCajaTsr(presupuestoflujocajatsr);

			if(PresupuestoFlujoCajaTsrLogicAdditional.validarSaveRelaciones(presupuestoflujocajatsr,this)) {

				PresupuestoFlujoCajaTsrLogicAdditional.updateRelacionesToSave(presupuestoflujocajatsr,this);

				if((presupuestoflujocajatsr.getIsNew()||presupuestoflujocajatsr.getIsChanged())&&!presupuestoflujocajatsr.getIsDeleted()) {
					this.savePresupuestoFlujoCajaTsr();
					this.savePresupuestoFlujoCajaTsrRelacionesDetalles();

				} else if(presupuestoflujocajatsr.getIsDeleted()) {
					this.savePresupuestoFlujoCajaTsrRelacionesDetalles();
					this.savePresupuestoFlujoCajaTsr();
				}

				PresupuestoFlujoCajaTsrLogicAdditional.updateRelacionesToSaveAfter(presupuestoflujocajatsr,this);

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
	
	
	private void savePresupuestoFlujoCajaTsrRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPresupuestoFlujoCajaTsr(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresupuestoFlujoCajaTsrConstantesFunciones.getClassesForeignKeysOfPresupuestoFlujoCajaTsr(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestoFlujoCajaTsr(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresupuestoFlujoCajaTsrConstantesFunciones.getClassesRelationshipsOfPresupuestoFlujoCajaTsr(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

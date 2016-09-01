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
import com.bydan.erp.puntoventa.util.PresupuestoVentasPunVenConstantesFunciones;
import com.bydan.erp.puntoventa.util.PresupuestoVentasPunVenParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.PresupuestoVentasPunVenParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.PresupuestoVentasPunVen;
import com.bydan.erp.puntoventa.business.logic.PresupuestoVentasPunVenLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

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
public class PresupuestoVentasPunVenLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PresupuestoVentasPunVenLogic.class);
	
	protected PresupuestoVentasPunVenDataAccess presupuestoventaspunvenDataAccess; 	
	protected PresupuestoVentasPunVen presupuestoventaspunven;
	protected List<PresupuestoVentasPunVen> presupuestoventaspunvens;
	protected Object presupuestoventaspunvenObject;	
	protected List<Object> presupuestoventaspunvensObject;
	
	public static ClassValidator<PresupuestoVentasPunVen> presupuestoventaspunvenValidator = new ClassValidator<PresupuestoVentasPunVen>(PresupuestoVentasPunVen.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PresupuestoVentasPunVenLogicAdditional presupuestoventaspunvenLogicAdditional=null;
	
	public PresupuestoVentasPunVenLogicAdditional getPresupuestoVentasPunVenLogicAdditional() {
		return this.presupuestoventaspunvenLogicAdditional;
	}
	
	public void setPresupuestoVentasPunVenLogicAdditional(PresupuestoVentasPunVenLogicAdditional presupuestoventaspunvenLogicAdditional) {
		try {
			this.presupuestoventaspunvenLogicAdditional=presupuestoventaspunvenLogicAdditional;
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
	
	
	
	
	public  PresupuestoVentasPunVenLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.presupuestoventaspunvenDataAccess = new PresupuestoVentasPunVenDataAccess();
			
			this.presupuestoventaspunvens= new ArrayList<PresupuestoVentasPunVen>();
			this.presupuestoventaspunven= new PresupuestoVentasPunVen();
			
			this.presupuestoventaspunvenObject=new Object();
			this.presupuestoventaspunvensObject=new ArrayList<Object>();
				
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
			
			this.presupuestoventaspunvenDataAccess.setConnexionType(this.connexionType);
			this.presupuestoventaspunvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PresupuestoVentasPunVenLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.presupuestoventaspunvenDataAccess = new PresupuestoVentasPunVenDataAccess();
			this.presupuestoventaspunvens= new ArrayList<PresupuestoVentasPunVen>();
			this.presupuestoventaspunven= new PresupuestoVentasPunVen();
			this.presupuestoventaspunvenObject=new Object();
			this.presupuestoventaspunvensObject=new ArrayList<Object>();
			
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
			
			this.presupuestoventaspunvenDataAccess.setConnexionType(this.connexionType);
			this.presupuestoventaspunvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PresupuestoVentasPunVen getPresupuestoVentasPunVen() throws Exception {	
		PresupuestoVentasPunVenLogicAdditional.checkPresupuestoVentasPunVenToGet(presupuestoventaspunven,this.datosCliente,this.arrDatoGeneral);
		PresupuestoVentasPunVenLogicAdditional.updatePresupuestoVentasPunVenToGet(presupuestoventaspunven,this.arrDatoGeneral);
		
		return presupuestoventaspunven;
	}
		
	public void setPresupuestoVentasPunVen(PresupuestoVentasPunVen newPresupuestoVentasPunVen) {
		this.presupuestoventaspunven = newPresupuestoVentasPunVen;
	}
	
	public PresupuestoVentasPunVenDataAccess getPresupuestoVentasPunVenDataAccess() {
		return presupuestoventaspunvenDataAccess;
	}
	
	public void setPresupuestoVentasPunVenDataAccess(PresupuestoVentasPunVenDataAccess newpresupuestoventaspunvenDataAccess) {
		this.presupuestoventaspunvenDataAccess = newpresupuestoventaspunvenDataAccess;
	}
	
	public List<PresupuestoVentasPunVen> getPresupuestoVentasPunVens() throws Exception {		
		this.quitarPresupuestoVentasPunVensNulos();
		
		PresupuestoVentasPunVenLogicAdditional.checkPresupuestoVentasPunVenToGets(presupuestoventaspunvens,this.datosCliente,this.arrDatoGeneral);
		
		for (PresupuestoVentasPunVen presupuestoventaspunvenLocal: presupuestoventaspunvens ) {
			PresupuestoVentasPunVenLogicAdditional.updatePresupuestoVentasPunVenToGet(presupuestoventaspunvenLocal,this.arrDatoGeneral);
		}
		
		return presupuestoventaspunvens;
	}
	
	public void setPresupuestoVentasPunVens(List<PresupuestoVentasPunVen> newPresupuestoVentasPunVens) {
		this.presupuestoventaspunvens = newPresupuestoVentasPunVens;
	}
	
	public Object getPresupuestoVentasPunVenObject() {	
		this.presupuestoventaspunvenObject=this.presupuestoventaspunvenDataAccess.getEntityObject();
		return this.presupuestoventaspunvenObject;
	}
		
	public void setPresupuestoVentasPunVenObject(Object newPresupuestoVentasPunVenObject) {
		this.presupuestoventaspunvenObject = newPresupuestoVentasPunVenObject;
	}
	
	public List<Object> getPresupuestoVentasPunVensObject() {		
		this.presupuestoventaspunvensObject=this.presupuestoventaspunvenDataAccess.getEntitiesObject();
		return this.presupuestoventaspunvensObject;
	}
		
	public void setPresupuestoVentasPunVensObject(List<Object> newPresupuestoVentasPunVensObject) {
		this.presupuestoventaspunvensObject = newPresupuestoVentasPunVensObject;
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
		
		if(this.presupuestoventaspunvenDataAccess!=null) {
			this.presupuestoventaspunvenDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			presupuestoventaspunvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			presupuestoventaspunvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		presupuestoventaspunven = new  PresupuestoVentasPunVen();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presupuestoventaspunven=presupuestoventaspunvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestoventaspunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunven);
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
		presupuestoventaspunven = new  PresupuestoVentasPunVen();
		  		  
        try {
			
			presupuestoventaspunven=presupuestoventaspunvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestoventaspunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		presupuestoventaspunven = new  PresupuestoVentasPunVen();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presupuestoventaspunven=presupuestoventaspunvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestoventaspunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunven);
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
		presupuestoventaspunven = new  PresupuestoVentasPunVen();
		  		  
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
		presupuestoventaspunven = new  PresupuestoVentasPunVen();
		  		  
        try {
			
			presupuestoventaspunven=presupuestoventaspunvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestoventaspunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		presupuestoventaspunven = new  PresupuestoVentasPunVen();
		  		  
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
		presupuestoventaspunven = new  PresupuestoVentasPunVen();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =presupuestoventaspunvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presupuestoventaspunven = new  PresupuestoVentasPunVen();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=presupuestoventaspunvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presupuestoventaspunven = new  PresupuestoVentasPunVen();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =presupuestoventaspunvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presupuestoventaspunven = new  PresupuestoVentasPunVen();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=presupuestoventaspunvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presupuestoventaspunven = new  PresupuestoVentasPunVen();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =presupuestoventaspunvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presupuestoventaspunven = new  PresupuestoVentasPunVen();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=presupuestoventaspunvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presupuestoventaspunvens = new  ArrayList<PresupuestoVentasPunVen>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaspunvens=presupuestoventaspunvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoVentasPunVen(presupuestoventaspunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunvens);
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
		presupuestoventaspunvens = new  ArrayList<PresupuestoVentasPunVen>();
		  		  
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
		presupuestoventaspunvens = new  ArrayList<PresupuestoVentasPunVen>();
		  		  
        try {			
			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaspunvens=presupuestoventaspunvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPresupuestoVentasPunVen(presupuestoventaspunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		presupuestoventaspunvens = new  ArrayList<PresupuestoVentasPunVen>();
		  		  
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
		presupuestoventaspunvens = new  ArrayList<PresupuestoVentasPunVen>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaspunvens=presupuestoventaspunvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoVentasPunVen(presupuestoventaspunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunvens);
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
		presupuestoventaspunvens = new  ArrayList<PresupuestoVentasPunVen>();
		  		  
        try {
			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaspunvens=presupuestoventaspunvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoVentasPunVen(presupuestoventaspunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunvens);
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
		presupuestoventaspunvens = new  ArrayList<PresupuestoVentasPunVen>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaspunvens=presupuestoventaspunvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoVentasPunVen(presupuestoventaspunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunvens);
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
		presupuestoventaspunvens = new  ArrayList<PresupuestoVentasPunVen>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaspunvens=presupuestoventaspunvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoVentasPunVen(presupuestoventaspunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		presupuestoventaspunven = new  PresupuestoVentasPunVen();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaspunven=presupuestoventaspunvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoVentasPunVen(presupuestoventaspunven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunven);
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
		presupuestoventaspunven = new  PresupuestoVentasPunVen();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaspunven=presupuestoventaspunvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoVentasPunVen(presupuestoventaspunven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presupuestoventaspunvens = new  ArrayList<PresupuestoVentasPunVen>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaspunvens=presupuestoventaspunvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoVentasPunVen(presupuestoventaspunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunvens);
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
		presupuestoventaspunvens = new  ArrayList<PresupuestoVentasPunVen>();
		  		  
        try {
			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaspunvens=presupuestoventaspunvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoVentasPunVen(presupuestoventaspunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPresupuestoVentasPunVensWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		presupuestoventaspunvens = new  ArrayList<PresupuestoVentasPunVen>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-getTodosPresupuestoVentasPunVensWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaspunvens=presupuestoventaspunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresupuestoVentasPunVen(presupuestoventaspunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunvens);
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
	
	public  void  getTodosPresupuestoVentasPunVens(String sFinalQuery,Pagination pagination)throws Exception {
		presupuestoventaspunvens = new  ArrayList<PresupuestoVentasPunVen>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaspunvens=presupuestoventaspunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresupuestoVentasPunVen(presupuestoventaspunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPresupuestoVentasPunVen(PresupuestoVentasPunVen presupuestoventaspunven) throws Exception {
		Boolean estaValidado=false;
		
		if(presupuestoventaspunven.getIsNew() || presupuestoventaspunven.getIsChanged()) { 
			this.invalidValues = presupuestoventaspunvenValidator.getInvalidValues(presupuestoventaspunven);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(presupuestoventaspunven);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPresupuestoVentasPunVen(List<PresupuestoVentasPunVen> PresupuestoVentasPunVens) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PresupuestoVentasPunVen presupuestoventaspunvenLocal:presupuestoventaspunvens) {				
			estaValidadoObjeto=this.validarGuardarPresupuestoVentasPunVen(presupuestoventaspunvenLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPresupuestoVentasPunVen(List<PresupuestoVentasPunVen> PresupuestoVentasPunVens) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresupuestoVentasPunVen(presupuestoventaspunvens)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPresupuestoVentasPunVen(PresupuestoVentasPunVen PresupuestoVentasPunVen) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresupuestoVentasPunVen(presupuestoventaspunven)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PresupuestoVentasPunVen presupuestoventaspunven) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+presupuestoventaspunven.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PresupuestoVentasPunVenConstantesFunciones.getPresupuestoVentasPunVenLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"presupuestoventaspunven","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PresupuestoVentasPunVenConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PresupuestoVentasPunVenConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePresupuestoVentasPunVenWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-savePresupuestoVentasPunVenWithConnection");connexion.begin();			
			
			PresupuestoVentasPunVenLogicAdditional.checkPresupuestoVentasPunVenToSave(this.presupuestoventaspunven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresupuestoVentasPunVenLogicAdditional.updatePresupuestoVentasPunVenToSave(this.presupuestoventaspunven,this.arrDatoGeneral);
			
			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presupuestoventaspunven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPresupuestoVentasPunVen();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresupuestoVentasPunVen(this.presupuestoventaspunven)) {
				PresupuestoVentasPunVenDataAccess.save(this.presupuestoventaspunven, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.presupuestoventaspunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresupuestoVentasPunVenLogicAdditional.checkPresupuestoVentasPunVenToSaveAfter(this.presupuestoventaspunven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresupuestoVentasPunVen();
			
			connexion.commit();			
			
			if(this.presupuestoventaspunven.getIsDeleted()) {
				this.presupuestoventaspunven=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePresupuestoVentasPunVen()throws Exception {	
		try {	
			
			PresupuestoVentasPunVenLogicAdditional.checkPresupuestoVentasPunVenToSave(this.presupuestoventaspunven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresupuestoVentasPunVenLogicAdditional.updatePresupuestoVentasPunVenToSave(this.presupuestoventaspunven,this.arrDatoGeneral);
			
			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presupuestoventaspunven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresupuestoVentasPunVen(this.presupuestoventaspunven)) {			
				PresupuestoVentasPunVenDataAccess.save(this.presupuestoventaspunven, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.presupuestoventaspunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresupuestoVentasPunVenLogicAdditional.checkPresupuestoVentasPunVenToSaveAfter(this.presupuestoventaspunven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.presupuestoventaspunven.getIsDeleted()) {
				this.presupuestoventaspunven=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePresupuestoVentasPunVensWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-savePresupuestoVentasPunVensWithConnection");connexion.begin();			
			
			PresupuestoVentasPunVenLogicAdditional.checkPresupuestoVentasPunVenToSaves(presupuestoventaspunvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPresupuestoVentasPunVens();
			
			Boolean validadoTodosPresupuestoVentasPunVen=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresupuestoVentasPunVen presupuestoventaspunvenLocal:presupuestoventaspunvens) {		
				if(presupuestoventaspunvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresupuestoVentasPunVenLogicAdditional.updatePresupuestoVentasPunVenToSave(presupuestoventaspunvenLocal,this.arrDatoGeneral);
	        	
				PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presupuestoventaspunvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresupuestoVentasPunVen(presupuestoventaspunvenLocal)) {
					PresupuestoVentasPunVenDataAccess.save(presupuestoventaspunvenLocal, connexion);				
				} else {
					validadoTodosPresupuestoVentasPunVen=false;
				}
			}
			
			if(!validadoTodosPresupuestoVentasPunVen) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresupuestoVentasPunVenLogicAdditional.checkPresupuestoVentasPunVenToSavesAfter(presupuestoventaspunvens,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresupuestoVentasPunVens();
			
			connexion.commit();		
			
			this.quitarPresupuestoVentasPunVensEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePresupuestoVentasPunVens()throws Exception {				
		 try {	
			PresupuestoVentasPunVenLogicAdditional.checkPresupuestoVentasPunVenToSaves(presupuestoventaspunvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPresupuestoVentasPunVen=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresupuestoVentasPunVen presupuestoventaspunvenLocal:presupuestoventaspunvens) {				
				if(presupuestoventaspunvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresupuestoVentasPunVenLogicAdditional.updatePresupuestoVentasPunVenToSave(presupuestoventaspunvenLocal,this.arrDatoGeneral);
	        	
				PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presupuestoventaspunvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresupuestoVentasPunVen(presupuestoventaspunvenLocal)) {				
					PresupuestoVentasPunVenDataAccess.save(presupuestoventaspunvenLocal, connexion);				
				} else {
					validadoTodosPresupuestoVentasPunVen=false;
				}
			}
			
			if(!validadoTodosPresupuestoVentasPunVen) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresupuestoVentasPunVenLogicAdditional.checkPresupuestoVentasPunVenToSavesAfter(presupuestoventaspunvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPresupuestoVentasPunVensEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresupuestoVentasPunVenParameterReturnGeneral procesarAccionPresupuestoVentasPunVens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresupuestoVentasPunVen> presupuestoventaspunvens,PresupuestoVentasPunVenParameterReturnGeneral presupuestoventaspunvenParameterGeneral)throws Exception {
		 try {	
			PresupuestoVentasPunVenParameterReturnGeneral presupuestoventaspunvenReturnGeneral=new PresupuestoVentasPunVenParameterReturnGeneral();
	
			PresupuestoVentasPunVenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presupuestoventaspunvens,presupuestoventaspunvenParameterGeneral,presupuestoventaspunvenReturnGeneral);
			
			return presupuestoventaspunvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresupuestoVentasPunVenParameterReturnGeneral procesarAccionPresupuestoVentasPunVensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresupuestoVentasPunVen> presupuestoventaspunvens,PresupuestoVentasPunVenParameterReturnGeneral presupuestoventaspunvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-procesarAccionPresupuestoVentasPunVensWithConnection");connexion.begin();			
			
			PresupuestoVentasPunVenParameterReturnGeneral presupuestoventaspunvenReturnGeneral=new PresupuestoVentasPunVenParameterReturnGeneral();
	
			PresupuestoVentasPunVenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presupuestoventaspunvens,presupuestoventaspunvenParameterGeneral,presupuestoventaspunvenReturnGeneral);
			
			this.connexion.commit();
			
			return presupuestoventaspunvenReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresupuestoVentasPunVenParameterReturnGeneral procesarEventosPresupuestoVentasPunVens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresupuestoVentasPunVen> presupuestoventaspunvens,PresupuestoVentasPunVen presupuestoventaspunven,PresupuestoVentasPunVenParameterReturnGeneral presupuestoventaspunvenParameterGeneral,Boolean isEsNuevoPresupuestoVentasPunVen,ArrayList<Classe> clases)throws Exception {
		 try {	
			PresupuestoVentasPunVenParameterReturnGeneral presupuestoventaspunvenReturnGeneral=new PresupuestoVentasPunVenParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presupuestoventaspunvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresupuestoVentasPunVenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presupuestoventaspunvens,presupuestoventaspunven,presupuestoventaspunvenParameterGeneral,presupuestoventaspunvenReturnGeneral,isEsNuevoPresupuestoVentasPunVen,clases);
			
			return presupuestoventaspunvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PresupuestoVentasPunVenParameterReturnGeneral procesarEventosPresupuestoVentasPunVensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresupuestoVentasPunVen> presupuestoventaspunvens,PresupuestoVentasPunVen presupuestoventaspunven,PresupuestoVentasPunVenParameterReturnGeneral presupuestoventaspunvenParameterGeneral,Boolean isEsNuevoPresupuestoVentasPunVen,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-procesarEventosPresupuestoVentasPunVensWithConnection");connexion.begin();			
			
			PresupuestoVentasPunVenParameterReturnGeneral presupuestoventaspunvenReturnGeneral=new PresupuestoVentasPunVenParameterReturnGeneral();
	
			presupuestoventaspunvenReturnGeneral.setPresupuestoVentasPunVen(presupuestoventaspunven);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presupuestoventaspunvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresupuestoVentasPunVenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presupuestoventaspunvens,presupuestoventaspunven,presupuestoventaspunvenParameterGeneral,presupuestoventaspunvenReturnGeneral,isEsNuevoPresupuestoVentasPunVen,clases);
			
			this.connexion.commit();
			
			return presupuestoventaspunvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresupuestoVentasPunVenParameterReturnGeneral procesarImportacionPresupuestoVentasPunVensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PresupuestoVentasPunVenParameterReturnGeneral presupuestoventaspunvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-procesarImportacionPresupuestoVentasPunVensWithConnection");connexion.begin();			
			
			PresupuestoVentasPunVenParameterReturnGeneral presupuestoventaspunvenReturnGeneral=new PresupuestoVentasPunVenParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.presupuestoventaspunvens=new ArrayList<PresupuestoVentasPunVen>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.presupuestoventaspunven=new PresupuestoVentasPunVen();
				
				
				if(conColumnasBase) {this.presupuestoventaspunven.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.presupuestoventaspunven.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.presupuestoventaspunven.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.presupuestoventaspunven.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.presupuestoventaspunven.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.presupuestoventaspunven.setcantidad_total(Integer.parseInt(arrColumnas[iColumn++]));
				this.presupuestoventaspunven.setvalor_total(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.presupuestoventaspunvens.add(this.presupuestoventaspunven);
			}
			
			this.savePresupuestoVentasPunVens();
			
			this.connexion.commit();
			
			presupuestoventaspunvenReturnGeneral.setConRetornoEstaProcesado(true);
			presupuestoventaspunvenReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return presupuestoventaspunvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPresupuestoVentasPunVensEliminados() throws Exception {				
		
		List<PresupuestoVentasPunVen> presupuestoventaspunvensAux= new ArrayList<PresupuestoVentasPunVen>();
		
		for(PresupuestoVentasPunVen presupuestoventaspunven:presupuestoventaspunvens) {
			if(!presupuestoventaspunven.getIsDeleted()) {
				presupuestoventaspunvensAux.add(presupuestoventaspunven);
			}
		}
		
		presupuestoventaspunvens=presupuestoventaspunvensAux;
	}
	
	public void quitarPresupuestoVentasPunVensNulos() throws Exception {				
		
		List<PresupuestoVentasPunVen> presupuestoventaspunvensAux= new ArrayList<PresupuestoVentasPunVen>();
		
		for(PresupuestoVentasPunVen presupuestoventaspunven : this.presupuestoventaspunvens) {
			if(presupuestoventaspunven==null) {
				presupuestoventaspunvensAux.add(presupuestoventaspunven);
			}
		}
		
		//this.presupuestoventaspunvens=presupuestoventaspunvensAux;
		
		this.presupuestoventaspunvens.removeAll(presupuestoventaspunvensAux);
	}
	
	public void getSetVersionRowPresupuestoVentasPunVenWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(presupuestoventaspunven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((presupuestoventaspunven.getIsDeleted() || (presupuestoventaspunven.getIsChanged()&&!presupuestoventaspunven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=presupuestoventaspunvenDataAccess.getSetVersionRowPresupuestoVentasPunVen(connexion,presupuestoventaspunven.getId());
				
				if(!presupuestoventaspunven.getVersionRow().equals(timestamp)) {	
					presupuestoventaspunven.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				presupuestoventaspunven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPresupuestoVentasPunVen()throws Exception {	
		
		if(presupuestoventaspunven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((presupuestoventaspunven.getIsDeleted() || (presupuestoventaspunven.getIsChanged()&&!presupuestoventaspunven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=presupuestoventaspunvenDataAccess.getSetVersionRowPresupuestoVentasPunVen(connexion,presupuestoventaspunven.getId());
			
			try {							
				if(!presupuestoventaspunven.getVersionRow().equals(timestamp)) {	
					presupuestoventaspunven.setVersionRow(timestamp);
				}
				
				presupuestoventaspunven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPresupuestoVentasPunVensWithConnection()throws Exception {	
		if(presupuestoventaspunvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PresupuestoVentasPunVen presupuestoventaspunvenAux:presupuestoventaspunvens) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(presupuestoventaspunvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presupuestoventaspunvenAux.getIsDeleted() || (presupuestoventaspunvenAux.getIsChanged()&&!presupuestoventaspunvenAux.getIsNew())) {
						
						timestamp=presupuestoventaspunvenDataAccess.getSetVersionRowPresupuestoVentasPunVen(connexion,presupuestoventaspunvenAux.getId());
						
						if(!presupuestoventaspunven.getVersionRow().equals(timestamp)) {	
							presupuestoventaspunvenAux.setVersionRow(timestamp);
						}
								
						presupuestoventaspunvenAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPresupuestoVentasPunVens()throws Exception {	
		if(presupuestoventaspunvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PresupuestoVentasPunVen presupuestoventaspunvenAux:presupuestoventaspunvens) {
					if(presupuestoventaspunvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presupuestoventaspunvenAux.getIsDeleted() || (presupuestoventaspunvenAux.getIsChanged()&&!presupuestoventaspunvenAux.getIsNew())) {
						
						timestamp=presupuestoventaspunvenDataAccess.getSetVersionRowPresupuestoVentasPunVen(connexion,presupuestoventaspunvenAux.getId());
						
						if(!presupuestoventaspunvenAux.getVersionRow().equals(timestamp)) {	
							presupuestoventaspunvenAux.setVersionRow(timestamp);
						}
						
													
						presupuestoventaspunvenAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PresupuestoVentasPunVenParameterReturnGeneral cargarCombosLoteForeignKeyPresupuestoVentasPunVenWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalCaja) throws Exception {
		PresupuestoVentasPunVenParameterReturnGeneral  presupuestoventaspunvenReturnGeneral =new PresupuestoVentasPunVenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-cargarCombosLoteForeignKeyPresupuestoVentasPunVenWithConnection");connexion.begin();
			
			presupuestoventaspunvenReturnGeneral =new PresupuestoVentasPunVenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			presupuestoventaspunvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			presupuestoventaspunvenReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			presupuestoventaspunvenReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			presupuestoventaspunvenReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Caja> cajasForeignKey=new ArrayList<Caja>();
			CajaLogic cajaLogic=new CajaLogic();
			cajaLogic.setConnexion(this.connexion);
			cajaLogic.getCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCaja.equals("NONE")) {
				cajaLogic.getTodosCajas(finalQueryGlobalCaja,new Pagination());
				cajasForeignKey=cajaLogic.getCajas();
			}

			presupuestoventaspunvenReturnGeneral.setcajasForeignKey(cajasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return presupuestoventaspunvenReturnGeneral;
	}
	
	public PresupuestoVentasPunVenParameterReturnGeneral cargarCombosLoteForeignKeyPresupuestoVentasPunVen(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalCaja) throws Exception {
		PresupuestoVentasPunVenParameterReturnGeneral  presupuestoventaspunvenReturnGeneral =new PresupuestoVentasPunVenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			presupuestoventaspunvenReturnGeneral =new PresupuestoVentasPunVenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			presupuestoventaspunvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			presupuestoventaspunvenReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			presupuestoventaspunvenReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			presupuestoventaspunvenReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Caja> cajasForeignKey=new ArrayList<Caja>();
			CajaLogic cajaLogic=new CajaLogic();
			cajaLogic.setConnexion(this.connexion);
			cajaLogic.getCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCaja.equals("NONE")) {
				cajaLogic.getTodosCajas(finalQueryGlobalCaja,new Pagination());
				cajasForeignKey=cajaLogic.getCajas();
			}

			presupuestoventaspunvenReturnGeneral.setcajasForeignKey(cajasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return presupuestoventaspunvenReturnGeneral;
	}
	
	
	public void deepLoad(PresupuestoVentasPunVen presupuestoventaspunven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PresupuestoVentasPunVenLogicAdditional.updatePresupuestoVentasPunVenToGet(presupuestoventaspunven,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presupuestoventaspunven.setEmpresa(presupuestoventaspunvenDataAccess.getEmpresa(connexion,presupuestoventaspunven));
		presupuestoventaspunven.setSucursal(presupuestoventaspunvenDataAccess.getSucursal(connexion,presupuestoventaspunven));
		presupuestoventaspunven.setEjercicio(presupuestoventaspunvenDataAccess.getEjercicio(connexion,presupuestoventaspunven));
		presupuestoventaspunven.setPeriodo(presupuestoventaspunvenDataAccess.getPeriodo(connexion,presupuestoventaspunven));
		presupuestoventaspunven.setCaja(presupuestoventaspunvenDataAccess.getCaja(connexion,presupuestoventaspunven));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				presupuestoventaspunven.setEmpresa(presupuestoventaspunvenDataAccess.getEmpresa(connexion,presupuestoventaspunven));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				presupuestoventaspunven.setSucursal(presupuestoventaspunvenDataAccess.getSucursal(connexion,presupuestoventaspunven));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				presupuestoventaspunven.setEjercicio(presupuestoventaspunvenDataAccess.getEjercicio(connexion,presupuestoventaspunven));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				presupuestoventaspunven.setPeriodo(presupuestoventaspunvenDataAccess.getPeriodo(connexion,presupuestoventaspunven));
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				presupuestoventaspunven.setCaja(presupuestoventaspunvenDataAccess.getCaja(connexion,presupuestoventaspunven));
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
			presupuestoventaspunven.setEmpresa(presupuestoventaspunvenDataAccess.getEmpresa(connexion,presupuestoventaspunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaspunven.setSucursal(presupuestoventaspunvenDataAccess.getSucursal(connexion,presupuestoventaspunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaspunven.setEjercicio(presupuestoventaspunvenDataAccess.getEjercicio(connexion,presupuestoventaspunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaspunven.setPeriodo(presupuestoventaspunvenDataAccess.getPeriodo(connexion,presupuestoventaspunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaspunven.setCaja(presupuestoventaspunvenDataAccess.getCaja(connexion,presupuestoventaspunven));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presupuestoventaspunven.setEmpresa(presupuestoventaspunvenDataAccess.getEmpresa(connexion,presupuestoventaspunven));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(presupuestoventaspunven.getEmpresa(),isDeep,deepLoadType,clases);
				
		presupuestoventaspunven.setSucursal(presupuestoventaspunvenDataAccess.getSucursal(connexion,presupuestoventaspunven));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(presupuestoventaspunven.getSucursal(),isDeep,deepLoadType,clases);
				
		presupuestoventaspunven.setEjercicio(presupuestoventaspunvenDataAccess.getEjercicio(connexion,presupuestoventaspunven));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(presupuestoventaspunven.getEjercicio(),isDeep,deepLoadType,clases);
				
		presupuestoventaspunven.setPeriodo(presupuestoventaspunvenDataAccess.getPeriodo(connexion,presupuestoventaspunven));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(presupuestoventaspunven.getPeriodo(),isDeep,deepLoadType,clases);
				
		presupuestoventaspunven.setCaja(presupuestoventaspunvenDataAccess.getCaja(connexion,presupuestoventaspunven));
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(presupuestoventaspunven.getCaja(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				presupuestoventaspunven.setEmpresa(presupuestoventaspunvenDataAccess.getEmpresa(connexion,presupuestoventaspunven));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(presupuestoventaspunven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				presupuestoventaspunven.setSucursal(presupuestoventaspunvenDataAccess.getSucursal(connexion,presupuestoventaspunven));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(presupuestoventaspunven.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				presupuestoventaspunven.setEjercicio(presupuestoventaspunvenDataAccess.getEjercicio(connexion,presupuestoventaspunven));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(presupuestoventaspunven.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				presupuestoventaspunven.setPeriodo(presupuestoventaspunvenDataAccess.getPeriodo(connexion,presupuestoventaspunven));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(presupuestoventaspunven.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				presupuestoventaspunven.setCaja(presupuestoventaspunvenDataAccess.getCaja(connexion,presupuestoventaspunven));
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepLoad(presupuestoventaspunven.getCaja(),isDeep,deepLoadType,clases);				
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
			presupuestoventaspunven.setEmpresa(presupuestoventaspunvenDataAccess.getEmpresa(connexion,presupuestoventaspunven));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(presupuestoventaspunven.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaspunven.setSucursal(presupuestoventaspunvenDataAccess.getSucursal(connexion,presupuestoventaspunven));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(presupuestoventaspunven.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaspunven.setEjercicio(presupuestoventaspunvenDataAccess.getEjercicio(connexion,presupuestoventaspunven));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(presupuestoventaspunven.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaspunven.setPeriodo(presupuestoventaspunvenDataAccess.getPeriodo(connexion,presupuestoventaspunven));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(presupuestoventaspunven.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaspunven.setCaja(presupuestoventaspunvenDataAccess.getCaja(connexion,presupuestoventaspunven));
			CajaLogic cajaLogic= new CajaLogic(connexion);
			cajaLogic.deepLoad(presupuestoventaspunven.getCaja(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PresupuestoVentasPunVen presupuestoventaspunven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PresupuestoVentasPunVenLogicAdditional.updatePresupuestoVentasPunVenToSave(presupuestoventaspunven,this.arrDatoGeneral);
			
PresupuestoVentasPunVenDataAccess.save(presupuestoventaspunven, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(presupuestoventaspunven.getEmpresa(),connexion);

		SucursalDataAccess.save(presupuestoventaspunven.getSucursal(),connexion);

		EjercicioDataAccess.save(presupuestoventaspunven.getEjercicio(),connexion);

		PeriodoDataAccess.save(presupuestoventaspunven.getPeriodo(),connexion);

		CajaDataAccess.save(presupuestoventaspunven.getCaja(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(presupuestoventaspunven.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(presupuestoventaspunven.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(presupuestoventaspunven.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(presupuestoventaspunven.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				CajaDataAccess.save(presupuestoventaspunven.getCaja(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(presupuestoventaspunven.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(presupuestoventaspunven.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(presupuestoventaspunven.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(presupuestoventaspunven.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(presupuestoventaspunven.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(presupuestoventaspunven.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(presupuestoventaspunven.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(presupuestoventaspunven.getPeriodo(),isDeep,deepLoadType,clases);
				

		CajaDataAccess.save(presupuestoventaspunven.getCaja(),connexion);
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(presupuestoventaspunven.getCaja(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(presupuestoventaspunven.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(presupuestoventaspunven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(presupuestoventaspunven.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(presupuestoventaspunven.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(presupuestoventaspunven.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(presupuestoventaspunven.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(presupuestoventaspunven.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(presupuestoventaspunven.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				CajaDataAccess.save(presupuestoventaspunven.getCaja(),connexion);
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepSave(presupuestoventaspunven.getCaja(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PresupuestoVentasPunVen.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(presupuestoventaspunven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(presupuestoventaspunven);
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
			this.deepLoad(this.presupuestoventaspunven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PresupuestoVentasPunVen.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(presupuestoventaspunvens!=null) {
				for(PresupuestoVentasPunVen presupuestoventaspunven:presupuestoventaspunvens) {
					this.deepLoad(presupuestoventaspunven,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(presupuestoventaspunvens);
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
			if(presupuestoventaspunvens!=null) {
				for(PresupuestoVentasPunVen presupuestoventaspunven:presupuestoventaspunvens) {
					this.deepLoad(presupuestoventaspunven,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(presupuestoventaspunvens);
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
			this.getNewConnexionToDeep(PresupuestoVentasPunVen.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(presupuestoventaspunven,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PresupuestoVentasPunVen.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(presupuestoventaspunvens!=null) {
				for(PresupuestoVentasPunVen presupuestoventaspunven:presupuestoventaspunvens) {
					this.deepSave(presupuestoventaspunven,isDeep,deepLoadType,clases);
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
			if(presupuestoventaspunvens!=null) {
				for(PresupuestoVentasPunVen presupuestoventaspunven:presupuestoventaspunvens) {
					this.deepSave(presupuestoventaspunven,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPresupuestoVentasPunVensFK_IdCajaWithConnection(String sFinalQuery,Pagination pagination,Long id_caja)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_caja,PresupuestoVentasPunVenConstantesFunciones.IDCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCaja);

			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaspunvens=presupuestoventaspunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentasPunVensFK_IdCaja(String sFinalQuery,Pagination pagination,Long id_caja)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_caja,PresupuestoVentasPunVenConstantesFunciones.IDCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCaja);

			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaspunvens=presupuestoventaspunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentasPunVensFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PresupuestoVentasPunVenConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaspunvens=presupuestoventaspunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentasPunVensFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PresupuestoVentasPunVenConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaspunvens=presupuestoventaspunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentasPunVensFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PresupuestoVentasPunVenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaspunvens=presupuestoventaspunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentasPunVensFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PresupuestoVentasPunVenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaspunvens=presupuestoventaspunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentasPunVensFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PresupuestoVentasPunVenConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaspunvens=presupuestoventaspunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentasPunVensFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PresupuestoVentasPunVenConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaspunvens=presupuestoventaspunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentasPunVensFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PresupuestoVentasPunVenConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaspunvens=presupuestoventaspunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentasPunVensFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PresupuestoVentasPunVenConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PresupuestoVentasPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaspunvens=presupuestoventaspunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(this.presupuestoventaspunvens);
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
			if(PresupuestoVentasPunVenConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoVentasPunVenDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PresupuestoVentasPunVen presupuestoventaspunven,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PresupuestoVentasPunVenConstantesFunciones.ISCONAUDITORIA) {
				if(presupuestoventaspunven.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoVentasPunVenDataAccess.TABLENAME, presupuestoventaspunven.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresupuestoVentasPunVenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresupuestoVentasPunVenLogic.registrarAuditoriaDetallesPresupuestoVentasPunVen(connexion,presupuestoventaspunven,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(presupuestoventaspunven.getIsDeleted()) {
					/*if(!presupuestoventaspunven.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PresupuestoVentasPunVenDataAccess.TABLENAME, presupuestoventaspunven.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PresupuestoVentasPunVenLogic.registrarAuditoriaDetallesPresupuestoVentasPunVen(connexion,presupuestoventaspunven,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoVentasPunVenDataAccess.TABLENAME, presupuestoventaspunven.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(presupuestoventaspunven.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoVentasPunVenDataAccess.TABLENAME, presupuestoventaspunven.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresupuestoVentasPunVenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresupuestoVentasPunVenLogic.registrarAuditoriaDetallesPresupuestoVentasPunVen(connexion,presupuestoventaspunven,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPresupuestoVentasPunVen(Connexion connexion,PresupuestoVentasPunVen presupuestoventaspunven)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(presupuestoventaspunven.getIsNew()||!presupuestoventaspunven.getid_empresa().equals(presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getid_empresa()!=null)
				{
					strValorActual=presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getid_empresa().toString();
				}
				if(presupuestoventaspunven.getid_empresa()!=null)
				{
					strValorNuevo=presupuestoventaspunven.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasPunVenConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaspunven.getIsNew()||!presupuestoventaspunven.getid_sucursal().equals(presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getid_sucursal()!=null)
				{
					strValorActual=presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getid_sucursal().toString();
				}
				if(presupuestoventaspunven.getid_sucursal()!=null)
				{
					strValorNuevo=presupuestoventaspunven.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasPunVenConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaspunven.getIsNew()||!presupuestoventaspunven.getid_ejercicio().equals(presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getid_ejercicio()!=null)
				{
					strValorActual=presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getid_ejercicio().toString();
				}
				if(presupuestoventaspunven.getid_ejercicio()!=null)
				{
					strValorNuevo=presupuestoventaspunven.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasPunVenConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaspunven.getIsNew()||!presupuestoventaspunven.getid_periodo().equals(presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getid_periodo()!=null)
				{
					strValorActual=presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getid_periodo().toString();
				}
				if(presupuestoventaspunven.getid_periodo()!=null)
				{
					strValorNuevo=presupuestoventaspunven.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasPunVenConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaspunven.getIsNew()||!presupuestoventaspunven.getid_caja().equals(presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getid_caja()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getid_caja()!=null)
				{
					strValorActual=presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getid_caja().toString();
				}
				if(presupuestoventaspunven.getid_caja()!=null)
				{
					strValorNuevo=presupuestoventaspunven.getid_caja().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasPunVenConstantesFunciones.IDCAJA,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaspunven.getIsNew()||!presupuestoventaspunven.getvalor().equals(presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getvalor()!=null)
				{
					strValorActual=presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getvalor().toString();
				}
				if(presupuestoventaspunven.getvalor()!=null)
				{
					strValorNuevo=presupuestoventaspunven.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasPunVenConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaspunven.getIsNew()||!presupuestoventaspunven.getcantidad().equals(presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getcantidad()!=null)
				{
					strValorActual=presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getcantidad().toString();
				}
				if(presupuestoventaspunven.getcantidad()!=null)
				{
					strValorNuevo=presupuestoventaspunven.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasPunVenConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaspunven.getIsNew()||!presupuestoventaspunven.getporcentaje().equals(presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getporcentaje()!=null)
				{
					strValorActual=presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getporcentaje().toString();
				}
				if(presupuestoventaspunven.getporcentaje()!=null)
				{
					strValorNuevo=presupuestoventaspunven.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasPunVenConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaspunven.getIsNew()||!presupuestoventaspunven.getcantidad_total().equals(presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getcantidad_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getcantidad_total()!=null)
				{
					strValorActual=presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getcantidad_total().toString();
				}
				if(presupuestoventaspunven.getcantidad_total()!=null)
				{
					strValorNuevo=presupuestoventaspunven.getcantidad_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasPunVenConstantesFunciones.CANTIDADTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaspunven.getIsNew()||!presupuestoventaspunven.getvalor_total().equals(presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getvalor_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getvalor_total()!=null)
				{
					strValorActual=presupuestoventaspunven.getPresupuestoVentasPunVenOriginal().getvalor_total().toString();
				}
				if(presupuestoventaspunven.getvalor_total()!=null)
				{
					strValorNuevo=presupuestoventaspunven.getvalor_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasPunVenConstantesFunciones.VALORTOTAL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePresupuestoVentasPunVenRelacionesWithConnection(PresupuestoVentasPunVen presupuestoventaspunven) throws Exception {

		if(!presupuestoventaspunven.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresupuestoVentasPunVenRelacionesBase(presupuestoventaspunven,true);
		}
	}

	public void savePresupuestoVentasPunVenRelaciones(PresupuestoVentasPunVen presupuestoventaspunven)throws Exception {

		if(!presupuestoventaspunven.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresupuestoVentasPunVenRelacionesBase(presupuestoventaspunven,false);
		}
	}

	public void savePresupuestoVentasPunVenRelacionesBase(PresupuestoVentasPunVen presupuestoventaspunven,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PresupuestoVentasPunVen-saveRelacionesWithConnection");}
	

			this.setPresupuestoVentasPunVen(presupuestoventaspunven);

			if(PresupuestoVentasPunVenLogicAdditional.validarSaveRelaciones(presupuestoventaspunven,this)) {

				PresupuestoVentasPunVenLogicAdditional.updateRelacionesToSave(presupuestoventaspunven,this);

				if((presupuestoventaspunven.getIsNew()||presupuestoventaspunven.getIsChanged())&&!presupuestoventaspunven.getIsDeleted()) {
					this.savePresupuestoVentasPunVen();
					this.savePresupuestoVentasPunVenRelacionesDetalles();

				} else if(presupuestoventaspunven.getIsDeleted()) {
					this.savePresupuestoVentasPunVenRelacionesDetalles();
					this.savePresupuestoVentasPunVen();
				}

				PresupuestoVentasPunVenLogicAdditional.updateRelacionesToSaveAfter(presupuestoventaspunven,this);

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
	
	
	private void savePresupuestoVentasPunVenRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPresupuestoVentasPunVen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresupuestoVentasPunVenConstantesFunciones.getClassesForeignKeysOfPresupuestoVentasPunVen(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestoVentasPunVen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresupuestoVentasPunVenConstantesFunciones.getClassesRelationshipsOfPresupuestoVentasPunVen(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

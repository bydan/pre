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
package com.bydan.erp.seguridad.business.logic;

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
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.seguridad.util.CantonConstantesFunciones;
import com.bydan.erp.seguridad.util.CantonParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.CantonParameterGeneral;
import com.bydan.erp.seguridad.business.entity.Canton;
import com.bydan.erp.seguridad.business.logic.CantonLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;








@SuppressWarnings("unused")
public class CantonLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CantonLogic.class);
	
	protected CantonDataAccess cantonDataAccess; 	
	protected Canton canton;
	protected List<Canton> cantons;
	protected Object cantonObject;	
	protected List<Object> cantonsObject;
	
	public static ClassValidator<Canton> cantonValidator = new ClassValidator<Canton>(Canton.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CantonLogicAdditional cantonLogicAdditional=null;
	
	public CantonLogicAdditional getCantonLogicAdditional() {
		return this.cantonLogicAdditional;
	}
	
	public void setCantonLogicAdditional(CantonLogicAdditional cantonLogicAdditional) {
		try {
			this.cantonLogicAdditional=cantonLogicAdditional;
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
	
	
	
	
	public  CantonLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cantonDataAccess = new CantonDataAccess();
			
			this.cantons= new ArrayList<Canton>();
			this.canton= new Canton();
			
			this.cantonObject=new Object();
			this.cantonsObject=new ArrayList<Object>();
				
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
			
			this.cantonDataAccess.setConnexionType(this.connexionType);
			this.cantonDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CantonLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cantonDataAccess = new CantonDataAccess();
			this.cantons= new ArrayList<Canton>();
			this.canton= new Canton();
			this.cantonObject=new Object();
			this.cantonsObject=new ArrayList<Object>();
			
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
			
			this.cantonDataAccess.setConnexionType(this.connexionType);
			this.cantonDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Canton getCanton() throws Exception {	
		CantonLogicAdditional.checkCantonToGet(canton,this.datosCliente,this.arrDatoGeneral);
		CantonLogicAdditional.updateCantonToGet(canton,this.arrDatoGeneral);
		
		return canton;
	}
		
	public void setCanton(Canton newCanton) {
		this.canton = newCanton;
	}
	
	public CantonDataAccess getCantonDataAccess() {
		return cantonDataAccess;
	}
	
	public void setCantonDataAccess(CantonDataAccess newcantonDataAccess) {
		this.cantonDataAccess = newcantonDataAccess;
	}
	
	public List<Canton> getCantons() throws Exception {		
		this.quitarCantonsNulos();
		
		CantonLogicAdditional.checkCantonToGets(cantons,this.datosCliente,this.arrDatoGeneral);
		
		for (Canton cantonLocal: cantons ) {
			CantonLogicAdditional.updateCantonToGet(cantonLocal,this.arrDatoGeneral);
		}
		
		return cantons;
	}
	
	public void setCantons(List<Canton> newCantons) {
		this.cantons = newCantons;
	}
	
	public Object getCantonObject() {	
		this.cantonObject=this.cantonDataAccess.getEntityObject();
		return this.cantonObject;
	}
		
	public void setCantonObject(Object newCantonObject) {
		this.cantonObject = newCantonObject;
	}
	
	public List<Object> getCantonsObject() {		
		this.cantonsObject=this.cantonDataAccess.getEntitiesObject();
		return this.cantonsObject;
	}
		
	public void setCantonsObject(List<Object> newCantonsObject) {
		this.cantonsObject = newCantonsObject;
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
		
		if(this.cantonDataAccess!=null) {
			this.cantonDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Canton.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cantonDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cantonDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		canton = new  Canton();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Canton.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			canton=cantonDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.canton,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(this.canton);
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
		canton = new  Canton();
		  		  
        try {
			
			canton=cantonDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.canton,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(this.canton);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		canton = new  Canton();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Canton.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			canton=cantonDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.canton,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(this.canton);
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
		canton = new  Canton();
		  		  
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
		canton = new  Canton();
		  		  
        try {
			
			canton=cantonDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.canton,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(this.canton);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		canton = new  Canton();
		  		  
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
		canton = new  Canton();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Canton.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cantonDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		canton = new  Canton();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cantonDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		canton = new  Canton();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Canton.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cantonDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		canton = new  Canton();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cantonDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		canton = new  Canton();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Canton.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cantonDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		canton = new  Canton();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cantonDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cantons = new  ArrayList<Canton>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Canton.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CantonLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cantons=cantonDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCanton(cantons);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(this.cantons);
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
		cantons = new  ArrayList<Canton>();
		  		  
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
		cantons = new  ArrayList<Canton>();
		  		  
        try {			
			CantonLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cantons=cantonDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCanton(cantons);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(this.cantons);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cantons = new  ArrayList<Canton>();
		  		  
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
		cantons = new  ArrayList<Canton>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Canton.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CantonLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cantons=cantonDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCanton(cantons);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(this.cantons);
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
		cantons = new  ArrayList<Canton>();
		  		  
        try {
			CantonLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cantons=cantonDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCanton(cantons);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(this.cantons);
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
		cantons = new  ArrayList<Canton>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Canton.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CantonLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cantons=cantonDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCanton(cantons);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(this.cantons);
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
		cantons = new  ArrayList<Canton>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CantonLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cantons=cantonDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCanton(cantons);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(this.cantons);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		canton = new  Canton();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Canton.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CantonLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			canton=cantonDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCanton(canton);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(this.canton);
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
		canton = new  Canton();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CantonLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			canton=cantonDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCanton(canton);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(this.canton);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cantons = new  ArrayList<Canton>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Canton.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CantonLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cantons=cantonDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCanton(cantons);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(this.cantons);
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
		cantons = new  ArrayList<Canton>();
		  		  
        try {
			CantonLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cantons=cantonDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCanton(cantons);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(this.cantons);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCantonsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cantons = new  ArrayList<Canton>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Canton.class.getSimpleName()+"-getTodosCantonsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CantonLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cantons=cantonDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCanton(cantons);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(this.cantons);
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
	
	public  void  getTodosCantons(String sFinalQuery,Pagination pagination)throws Exception {
		cantons = new  ArrayList<Canton>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CantonLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cantons=cantonDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCanton(cantons);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(this.cantons);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCanton(Canton canton) throws Exception {
		Boolean estaValidado=false;
		
		if(canton.getIsNew() || canton.getIsChanged()) { 
			this.invalidValues = cantonValidator.getInvalidValues(canton);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(canton);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCanton(List<Canton> Cantons) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Canton cantonLocal:cantons) {				
			estaValidadoObjeto=this.validarGuardarCanton(cantonLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCanton(List<Canton> Cantons) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCanton(cantons)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCanton(Canton Canton) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCanton(canton)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Canton canton) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+canton.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CantonConstantesFunciones.getCantonLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"canton","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CantonConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CantonConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCantonWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Canton.class.getSimpleName()+"-saveCantonWithConnection");connexion.begin();			
			
			CantonLogicAdditional.checkCantonToSave(this.canton,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CantonLogicAdditional.updateCantonToSave(this.canton,this.arrDatoGeneral);
			
			CantonLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.canton,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCanton();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCanton(this.canton)) {
				CantonDataAccess.save(this.canton, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.canton,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CantonLogicAdditional.checkCantonToSaveAfter(this.canton,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCanton();
			
			connexion.commit();			
			
			if(this.canton.getIsDeleted()) {
				this.canton=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCanton()throws Exception {	
		try {	
			
			CantonLogicAdditional.checkCantonToSave(this.canton,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CantonLogicAdditional.updateCantonToSave(this.canton,this.arrDatoGeneral);
			
			CantonLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.canton,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCanton(this.canton)) {			
				CantonDataAccess.save(this.canton, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.canton,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CantonLogicAdditional.checkCantonToSaveAfter(this.canton,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.canton.getIsDeleted()) {
				this.canton=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCantonsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Canton.class.getSimpleName()+"-saveCantonsWithConnection");connexion.begin();			
			
			CantonLogicAdditional.checkCantonToSaves(cantons,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCantons();
			
			Boolean validadoTodosCanton=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Canton cantonLocal:cantons) {		
				if(cantonLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CantonLogicAdditional.updateCantonToSave(cantonLocal,this.arrDatoGeneral);
	        	
				CantonLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cantonLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCanton(cantonLocal)) {
					CantonDataAccess.save(cantonLocal, connexion);				
				} else {
					validadoTodosCanton=false;
				}
			}
			
			if(!validadoTodosCanton) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CantonLogicAdditional.checkCantonToSavesAfter(cantons,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCantons();
			
			connexion.commit();		
			
			this.quitarCantonsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCantons()throws Exception {				
		 try {	
			CantonLogicAdditional.checkCantonToSaves(cantons,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCanton=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Canton cantonLocal:cantons) {				
				if(cantonLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CantonLogicAdditional.updateCantonToSave(cantonLocal,this.arrDatoGeneral);
	        	
				CantonLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cantonLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCanton(cantonLocal)) {				
					CantonDataAccess.save(cantonLocal, connexion);				
				} else {
					validadoTodosCanton=false;
				}
			}
			
			if(!validadoTodosCanton) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CantonLogicAdditional.checkCantonToSavesAfter(cantons,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCantonsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CantonParameterReturnGeneral procesarAccionCantons(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Canton> cantons,CantonParameterReturnGeneral cantonParameterGeneral)throws Exception {
		 try {	
			CantonParameterReturnGeneral cantonReturnGeneral=new CantonParameterReturnGeneral();
	
			CantonLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cantons,cantonParameterGeneral,cantonReturnGeneral);
			
			return cantonReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CantonParameterReturnGeneral procesarAccionCantonsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Canton> cantons,CantonParameterReturnGeneral cantonParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Canton.class.getSimpleName()+"-procesarAccionCantonsWithConnection");connexion.begin();			
			
			CantonParameterReturnGeneral cantonReturnGeneral=new CantonParameterReturnGeneral();
	
			CantonLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cantons,cantonParameterGeneral,cantonReturnGeneral);
			
			this.connexion.commit();
			
			return cantonReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CantonParameterReturnGeneral procesarEventosCantons(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Canton> cantons,Canton canton,CantonParameterReturnGeneral cantonParameterGeneral,Boolean isEsNuevoCanton,ArrayList<Classe> clases)throws Exception {
		 try {	
			CantonParameterReturnGeneral cantonReturnGeneral=new CantonParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cantonReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CantonLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cantons,canton,cantonParameterGeneral,cantonReturnGeneral,isEsNuevoCanton,clases);
			
			return cantonReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CantonParameterReturnGeneral procesarEventosCantonsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Canton> cantons,Canton canton,CantonParameterReturnGeneral cantonParameterGeneral,Boolean isEsNuevoCanton,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Canton.class.getSimpleName()+"-procesarEventosCantonsWithConnection");connexion.begin();			
			
			CantonParameterReturnGeneral cantonReturnGeneral=new CantonParameterReturnGeneral();
	
			cantonReturnGeneral.setCanton(canton);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cantonReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CantonLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cantons,canton,cantonParameterGeneral,cantonReturnGeneral,isEsNuevoCanton,clases);
			
			this.connexion.commit();
			
			return cantonReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CantonParameterReturnGeneral procesarImportacionCantonsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CantonParameterReturnGeneral cantonParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Canton.class.getSimpleName()+"-procesarImportacionCantonsWithConnection");connexion.begin();			
			
			CantonParameterReturnGeneral cantonReturnGeneral=new CantonParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cantons=new ArrayList<Canton>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.canton=new Canton();
				
				
				if(conColumnasBase) {this.canton.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.canton.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.canton.setcodigo(arrColumnas[iColumn++]);
			this.canton.setnombre(arrColumnas[iColumn++]);
				this.canton.setes_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.cantons.add(this.canton);
			}
			
			this.saveCantons();
			
			this.connexion.commit();
			
			cantonReturnGeneral.setConRetornoEstaProcesado(true);
			cantonReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cantonReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCantonsEliminados() throws Exception {				
		
		List<Canton> cantonsAux= new ArrayList<Canton>();
		
		for(Canton canton:cantons) {
			if(!canton.getIsDeleted()) {
				cantonsAux.add(canton);
			}
		}
		
		cantons=cantonsAux;
	}
	
	public void quitarCantonsNulos() throws Exception {				
		
		List<Canton> cantonsAux= new ArrayList<Canton>();
		
		for(Canton canton : this.cantons) {
			if(canton==null) {
				cantonsAux.add(canton);
			}
		}
		
		//this.cantons=cantonsAux;
		
		this.cantons.removeAll(cantonsAux);
	}
	
	public void getSetVersionRowCantonWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(canton.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((canton.getIsDeleted() || (canton.getIsChanged()&&!canton.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cantonDataAccess.getSetVersionRowCanton(connexion,canton.getId());
				
				if(!canton.getVersionRow().equals(timestamp)) {	
					canton.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				canton.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCanton()throws Exception {	
		
		if(canton.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((canton.getIsDeleted() || (canton.getIsChanged()&&!canton.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cantonDataAccess.getSetVersionRowCanton(connexion,canton.getId());
			
			try {							
				if(!canton.getVersionRow().equals(timestamp)) {	
					canton.setVersionRow(timestamp);
				}
				
				canton.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCantonsWithConnection()throws Exception {	
		if(cantons!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Canton cantonAux:cantons) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cantonAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cantonAux.getIsDeleted() || (cantonAux.getIsChanged()&&!cantonAux.getIsNew())) {
						
						timestamp=cantonDataAccess.getSetVersionRowCanton(connexion,cantonAux.getId());
						
						if(!canton.getVersionRow().equals(timestamp)) {	
							cantonAux.setVersionRow(timestamp);
						}
								
						cantonAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCantons()throws Exception {	
		if(cantons!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Canton cantonAux:cantons) {
					if(cantonAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cantonAux.getIsDeleted() || (cantonAux.getIsChanged()&&!cantonAux.getIsNew())) {
						
						timestamp=cantonDataAccess.getSetVersionRowCanton(connexion,cantonAux.getId());
						
						if(!cantonAux.getVersionRow().equals(timestamp)) {	
							cantonAux.setVersionRow(timestamp);
						}
						
													
						cantonAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CantonParameterReturnGeneral cargarCombosLoteForeignKeyCantonWithConnection(String finalQueryGlobalProvincia) throws Exception {
		CantonParameterReturnGeneral  cantonReturnGeneral =new CantonParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Canton.class.getSimpleName()+"-cargarCombosLoteForeignKeyCantonWithConnection");connexion.begin();
			
			cantonReturnGeneral =new CantonParameterReturnGeneral();
			
			

			List<Provincia> provinciasForeignKey=new ArrayList<Provincia>();
			ProvinciaLogic provinciaLogic=new ProvinciaLogic();
			provinciaLogic.setConnexion(this.connexion);
			provinciaLogic.getProvinciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProvincia.equals("NONE")) {
				provinciaLogic.getTodosProvincias(finalQueryGlobalProvincia,new Pagination());
				provinciasForeignKey=provinciaLogic.getProvincias();
			}

			cantonReturnGeneral.setprovinciasForeignKey(provinciasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cantonReturnGeneral;
	}
	
	public CantonParameterReturnGeneral cargarCombosLoteForeignKeyCanton(String finalQueryGlobalProvincia) throws Exception {
		CantonParameterReturnGeneral  cantonReturnGeneral =new CantonParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cantonReturnGeneral =new CantonParameterReturnGeneral();
			
			

			List<Provincia> provinciasForeignKey=new ArrayList<Provincia>();
			ProvinciaLogic provinciaLogic=new ProvinciaLogic();
			provinciaLogic.setConnexion(this.connexion);
			provinciaLogic.getProvinciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProvincia.equals("NONE")) {
				provinciaLogic.getTodosProvincias(finalQueryGlobalProvincia,new Pagination());
				provinciasForeignKey=provinciaLogic.getProvincias();
			}

			cantonReturnGeneral.setprovinciasForeignKey(provinciasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cantonReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyCantonWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			BarrioLogic barrioLogic=new BarrioLogic();
			ParroquiaLogic parroquiaLogic=new ParroquiaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Canton.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyCantonWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Barrio.class));
			classes.add(new Classe(Parroquia.class));
											
			

			barrioLogic.setConnexion(this.getConnexion());
			barrioLogic.setDatosCliente(this.datosCliente);
			barrioLogic.setIsConRefrescarForeignKeys(true);

			parroquiaLogic.setConnexion(this.getConnexion());
			parroquiaLogic.setDatosCliente(this.datosCliente);
			parroquiaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Canton canton:this.cantons) {
				

				classes=new ArrayList<Classe>();
				classes=BarrioConstantesFunciones.getClassesForeignKeysOfBarrio(new ArrayList<Classe>(),DeepLoadType.NONE);

				barrioLogic.setBarrios(canton.barrios);
				barrioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParroquiaConstantesFunciones.getClassesForeignKeysOfParroquia(new ArrayList<Classe>(),DeepLoadType.NONE);

				parroquiaLogic.setParroquias(canton.parroquias);
				parroquiaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Canton canton,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CantonLogicAdditional.updateCantonToGet(canton,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		canton.setProvincia(cantonDataAccess.getProvincia(connexion,canton));
		canton.setBarrios(cantonDataAccess.getBarrios(connexion,canton));
		canton.setParroquias(cantonDataAccess.getParroquias(connexion,canton));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				canton.setProvincia(cantonDataAccess.getProvincia(connexion,canton));
				continue;
			}

			if(clas.clas.equals(Barrio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				canton.setBarrios(cantonDataAccess.getBarrios(connexion,canton));

				if(this.isConDeep) {
					BarrioLogic barrioLogic= new BarrioLogic(this.connexion);
					barrioLogic.setBarrios(canton.getBarrios());
					ArrayList<Classe> classesLocal=BarrioConstantesFunciones.getClassesForeignKeysOfBarrio(new ArrayList<Classe>(),DeepLoadType.NONE);
					barrioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(barrioLogic.getBarrios());
					canton.setBarrios(barrioLogic.getBarrios());
				}

				continue;
			}

			if(clas.clas.equals(Parroquia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				canton.setParroquias(cantonDataAccess.getParroquias(connexion,canton));

				if(this.isConDeep) {
					ParroquiaLogic parroquiaLogic= new ParroquiaLogic(this.connexion);
					parroquiaLogic.setParroquias(canton.getParroquias());
					ArrayList<Classe> classesLocal=ParroquiaConstantesFunciones.getClassesForeignKeysOfParroquia(new ArrayList<Classe>(),DeepLoadType.NONE);
					parroquiaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParroquiaConstantesFunciones.refrescarForeignKeysDescripcionesParroquia(parroquiaLogic.getParroquias());
					canton.setParroquias(parroquiaLogic.getParroquias());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			canton.setProvincia(cantonDataAccess.getProvincia(connexion,canton));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Barrio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Barrio.class));
			canton.setBarrios(cantonDataAccess.getBarrios(connexion,canton));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Parroquia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Parroquia.class));
			canton.setParroquias(cantonDataAccess.getParroquias(connexion,canton));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		canton.setProvincia(cantonDataAccess.getProvincia(connexion,canton));
		ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
		provinciaLogic.deepLoad(canton.getProvincia(),isDeep,deepLoadType,clases);
				

		canton.setBarrios(cantonDataAccess.getBarrios(connexion,canton));

		for(Barrio barrio:canton.getBarrios()) {
			BarrioLogic barrioLogic= new BarrioLogic(connexion);
			barrioLogic.deepLoad(barrio,isDeep,deepLoadType,clases);
		}

		canton.setParroquias(cantonDataAccess.getParroquias(connexion,canton));

		for(Parroquia parroquia:canton.getParroquias()) {
			ParroquiaLogic parroquiaLogic= new ParroquiaLogic(connexion);
			parroquiaLogic.deepLoad(parroquia,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				canton.setProvincia(cantonDataAccess.getProvincia(connexion,canton));
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepLoad(canton.getProvincia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Barrio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				canton.setBarrios(cantonDataAccess.getBarrios(connexion,canton));

				for(Barrio barrio:canton.getBarrios()) {
					BarrioLogic barrioLogic= new BarrioLogic(connexion);
					barrioLogic.deepLoad(barrio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Parroquia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				canton.setParroquias(cantonDataAccess.getParroquias(connexion,canton));

				for(Parroquia parroquia:canton.getParroquias()) {
					ParroquiaLogic parroquiaLogic= new ParroquiaLogic(connexion);
					parroquiaLogic.deepLoad(parroquia,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			canton.setProvincia(cantonDataAccess.getProvincia(connexion,canton));
			ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
			provinciaLogic.deepLoad(canton.getProvincia(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Barrio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Barrio.class));
			canton.setBarrios(cantonDataAccess.getBarrios(connexion,canton));

			for(Barrio barrio:canton.getBarrios()) {
				BarrioLogic barrioLogic= new BarrioLogic(connexion);
				barrioLogic.deepLoad(barrio,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Parroquia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Parroquia.class));
			canton.setParroquias(cantonDataAccess.getParroquias(connexion,canton));

			for(Parroquia parroquia:canton.getParroquias()) {
				ParroquiaLogic parroquiaLogic= new ParroquiaLogic(connexion);
				parroquiaLogic.deepLoad(parroquia,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Canton canton,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CantonLogicAdditional.updateCantonToSave(canton,this.arrDatoGeneral);
			
CantonDataAccess.save(canton, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ProvinciaDataAccess.save(canton.getProvincia(),connexion);

		for(Barrio barrio:canton.getBarrios()) {
			barrio.setid_canton(canton.getId());
			BarrioDataAccess.save(barrio,connexion);
		}

		for(Parroquia parroquia:canton.getParroquias()) {
			parroquia.setid_canton(canton.getId());
			ParroquiaDataAccess.save(parroquia,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				ProvinciaDataAccess.save(canton.getProvincia(),connexion);
				continue;
			}


			if(clas.clas.equals(Barrio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Barrio barrio:canton.getBarrios()) {
					barrio.setid_canton(canton.getId());
					BarrioDataAccess.save(barrio,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Parroquia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Parroquia parroquia:canton.getParroquias()) {
					parroquia.setid_canton(canton.getId());
					ParroquiaDataAccess.save(parroquia,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ProvinciaDataAccess.save(canton.getProvincia(),connexion);
		ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
		provinciaLogic.deepLoad(canton.getProvincia(),isDeep,deepLoadType,clases);
				

		for(Barrio barrio:canton.getBarrios()) {
			BarrioLogic barrioLogic= new BarrioLogic(connexion);
			barrio.setid_canton(canton.getId());
			BarrioDataAccess.save(barrio,connexion);
			barrioLogic.deepSave(barrio,isDeep,deepLoadType,clases);
		}

		for(Parroquia parroquia:canton.getParroquias()) {
			ParroquiaLogic parroquiaLogic= new ParroquiaLogic(connexion);
			parroquia.setid_canton(canton.getId());
			ParroquiaDataAccess.save(parroquia,connexion);
			parroquiaLogic.deepSave(parroquia,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				ProvinciaDataAccess.save(canton.getProvincia(),connexion);
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepSave(canton.getProvincia(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Barrio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Barrio barrio:canton.getBarrios()) {
					BarrioLogic barrioLogic= new BarrioLogic(connexion);
					barrio.setid_canton(canton.getId());
					BarrioDataAccess.save(barrio,connexion);
					barrioLogic.deepSave(barrio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Parroquia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Parroquia parroquia:canton.getParroquias()) {
					ParroquiaLogic parroquiaLogic= new ParroquiaLogic(connexion);
					parroquia.setid_canton(canton.getId());
					ParroquiaDataAccess.save(parroquia,connexion);
					parroquiaLogic.deepSave(parroquia,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Canton.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(canton,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(canton);
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
			this.deepLoad(this.canton,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(this.canton);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Canton.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cantons!=null) {
				for(Canton canton:cantons) {
					this.deepLoad(canton,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(cantons);
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
			if(cantons!=null) {
				for(Canton canton:cantons) {
					this.deepLoad(canton,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(cantons);
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
			this.getNewConnexionToDeep(Canton.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(canton,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Canton.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cantons!=null) {
				for(Canton canton:cantons) {
					this.deepSave(canton,isDeep,deepLoadType,clases);
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
			if(cantons!=null) {
				for(Canton canton:cantons) {
					this.deepSave(canton,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCantonsFK_IdProvinciaWithConnection(String sFinalQuery,Pagination pagination,Long id_provincia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Canton.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProvincia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProvincia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_provincia,CantonConstantesFunciones.IDPROVINCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProvincia);

			CantonLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProvincia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cantons=cantonDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(this.cantons);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCantonsFK_IdProvincia(String sFinalQuery,Pagination pagination,Long id_provincia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProvincia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProvincia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_provincia,CantonConstantesFunciones.IDPROVINCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProvincia);

			CantonLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProvincia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cantons=cantonDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(this.cantons);
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
			if(CantonConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CantonDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Canton canton,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CantonConstantesFunciones.ISCONAUDITORIA) {
				if(canton.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CantonDataAccess.TABLENAME, canton.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CantonConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CantonLogic.registrarAuditoriaDetallesCanton(connexion,canton,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(canton.getIsDeleted()) {
					/*if(!canton.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CantonDataAccess.TABLENAME, canton.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CantonLogic.registrarAuditoriaDetallesCanton(connexion,canton,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CantonDataAccess.TABLENAME, canton.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(canton.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CantonDataAccess.TABLENAME, canton.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CantonConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CantonLogic.registrarAuditoriaDetallesCanton(connexion,canton,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCanton(Connexion connexion,Canton canton)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(canton.getIsNew()||!canton.getid_provincia().equals(canton.getCantonOriginal().getid_provincia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(canton.getCantonOriginal().getid_provincia()!=null)
				{
					strValorActual=canton.getCantonOriginal().getid_provincia().toString();
				}
				if(canton.getid_provincia()!=null)
				{
					strValorNuevo=canton.getid_provincia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CantonConstantesFunciones.IDPROVINCIA,strValorActual,strValorNuevo);
			}	
			
			if(canton.getIsNew()||!canton.getcodigo().equals(canton.getCantonOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(canton.getCantonOriginal().getcodigo()!=null)
				{
					strValorActual=canton.getCantonOriginal().getcodigo();
				}
				if(canton.getcodigo()!=null)
				{
					strValorNuevo=canton.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CantonConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(canton.getIsNew()||!canton.getnombre().equals(canton.getCantonOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(canton.getCantonOriginal().getnombre()!=null)
				{
					strValorActual=canton.getCantonOriginal().getnombre();
				}
				if(canton.getnombre()!=null)
				{
					strValorNuevo=canton.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CantonConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(canton.getIsNew()||!canton.getes_activo().equals(canton.getCantonOriginal().getes_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(canton.getCantonOriginal().getes_activo()!=null)
				{
					strValorActual=canton.getCantonOriginal().getes_activo().toString();
				}
				if(canton.getes_activo()!=null)
				{
					strValorNuevo=canton.getes_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CantonConstantesFunciones.ESACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCantonRelacionesWithConnection(Canton canton,List<Barrio> barrios,List<Parroquia> parroquias) throws Exception {

		if(!canton.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCantonRelacionesBase(canton,barrios,parroquias,true);
		}
	}

	public void saveCantonRelaciones(Canton canton,List<Barrio> barrios,List<Parroquia> parroquias)throws Exception {

		if(!canton.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCantonRelacionesBase(canton,barrios,parroquias,false);
		}
	}

	public void saveCantonRelacionesBase(Canton canton,List<Barrio> barrios,List<Parroquia> parroquias,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Canton-saveRelacionesWithConnection");}
	
			canton.setBarrios(barrios);
			canton.setParroquias(parroquias);

			this.setCanton(canton);

			if(CantonLogicAdditional.validarSaveRelaciones(canton,this)) {

				CantonLogicAdditional.updateRelacionesToSave(canton,this);

				if((canton.getIsNew()||canton.getIsChanged())&&!canton.getIsDeleted()) {
					this.saveCanton();
					this.saveCantonRelacionesDetalles(barrios,parroquias);

				} else if(canton.getIsDeleted()) {
					this.saveCantonRelacionesDetalles(barrios,parroquias);
					this.saveCanton();
				}

				CantonLogicAdditional.updateRelacionesToSaveAfter(canton,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			BarrioConstantesFunciones.InicializarGeneralEntityAuxiliaresBarrios(barrios,true,true);
			ParroquiaConstantesFunciones.InicializarGeneralEntityAuxiliaresParroquias(parroquias,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveCantonRelacionesDetalles(List<Barrio> barrios,List<Parroquia> parroquias)throws Exception {
		try {
	

			Long idCantonActual=this.getCanton().getId();

			BarrioLogic barrioLogic_Desde_Canton=new BarrioLogic();
			barrioLogic_Desde_Canton.setBarrios(barrios);

			barrioLogic_Desde_Canton.setConnexion(this.getConnexion());
			barrioLogic_Desde_Canton.setDatosCliente(this.datosCliente);

			for(Barrio barrio_Desde_Canton:barrioLogic_Desde_Canton.getBarrios()) {
				barrio_Desde_Canton.setid_canton(idCantonActual);
			}

			barrioLogic_Desde_Canton.saveBarrios();

			ParroquiaLogic parroquiaLogic_Desde_Canton=new ParroquiaLogic();
			parroquiaLogic_Desde_Canton.setParroquias(parroquias);

			parroquiaLogic_Desde_Canton.setConnexion(this.getConnexion());
			parroquiaLogic_Desde_Canton.setDatosCliente(this.datosCliente);

			for(Parroquia parroquia_Desde_Canton:parroquiaLogic_Desde_Canton.getParroquias()) {
				parroquia_Desde_Canton.setid_canton(idCantonActual);
			}

			parroquiaLogic_Desde_Canton.saveParroquias();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCanton(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CantonConstantesFunciones.getClassesForeignKeysOfCanton(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCanton(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CantonConstantesFunciones.getClassesRelationshipsOfCanton(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

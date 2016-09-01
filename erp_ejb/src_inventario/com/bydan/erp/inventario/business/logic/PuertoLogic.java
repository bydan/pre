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
import com.bydan.erp.inventario.util.PuertoConstantesFunciones;
import com.bydan.erp.inventario.util.PuertoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.PuertoParameterGeneral;
import com.bydan.erp.inventario.business.entity.Puerto;
import com.bydan.erp.inventario.business.logic.PuertoLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.importaciones.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class PuertoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PuertoLogic.class);
	
	protected PuertoDataAccess puertoDataAccess; 	
	protected Puerto puerto;
	protected List<Puerto> puertos;
	protected Object puertoObject;	
	protected List<Object> puertosObject;
	
	public static ClassValidator<Puerto> puertoValidator = new ClassValidator<Puerto>(Puerto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PuertoLogicAdditional puertoLogicAdditional=null;
	
	public PuertoLogicAdditional getPuertoLogicAdditional() {
		return this.puertoLogicAdditional;
	}
	
	public void setPuertoLogicAdditional(PuertoLogicAdditional puertoLogicAdditional) {
		try {
			this.puertoLogicAdditional=puertoLogicAdditional;
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
	
	
	
	
	public  PuertoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.puertoDataAccess = new PuertoDataAccess();
			
			this.puertos= new ArrayList<Puerto>();
			this.puerto= new Puerto();
			
			this.puertoObject=new Object();
			this.puertosObject=new ArrayList<Object>();
				
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
			
			this.puertoDataAccess.setConnexionType(this.connexionType);
			this.puertoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PuertoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.puertoDataAccess = new PuertoDataAccess();
			this.puertos= new ArrayList<Puerto>();
			this.puerto= new Puerto();
			this.puertoObject=new Object();
			this.puertosObject=new ArrayList<Object>();
			
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
			
			this.puertoDataAccess.setConnexionType(this.connexionType);
			this.puertoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Puerto getPuerto() throws Exception {	
		PuertoLogicAdditional.checkPuertoToGet(puerto,this.datosCliente,this.arrDatoGeneral);
		PuertoLogicAdditional.updatePuertoToGet(puerto,this.arrDatoGeneral);
		
		return puerto;
	}
		
	public void setPuerto(Puerto newPuerto) {
		this.puerto = newPuerto;
	}
	
	public PuertoDataAccess getPuertoDataAccess() {
		return puertoDataAccess;
	}
	
	public void setPuertoDataAccess(PuertoDataAccess newpuertoDataAccess) {
		this.puertoDataAccess = newpuertoDataAccess;
	}
	
	public List<Puerto> getPuertos() throws Exception {		
		this.quitarPuertosNulos();
		
		PuertoLogicAdditional.checkPuertoToGets(puertos,this.datosCliente,this.arrDatoGeneral);
		
		for (Puerto puertoLocal: puertos ) {
			PuertoLogicAdditional.updatePuertoToGet(puertoLocal,this.arrDatoGeneral);
		}
		
		return puertos;
	}
	
	public void setPuertos(List<Puerto> newPuertos) {
		this.puertos = newPuertos;
	}
	
	public Object getPuertoObject() {	
		this.puertoObject=this.puertoDataAccess.getEntityObject();
		return this.puertoObject;
	}
		
	public void setPuertoObject(Object newPuertoObject) {
		this.puertoObject = newPuertoObject;
	}
	
	public List<Object> getPuertosObject() {		
		this.puertosObject=this.puertoDataAccess.getEntitiesObject();
		return this.puertosObject;
	}
		
	public void setPuertosObject(List<Object> newPuertosObject) {
		this.puertosObject = newPuertosObject;
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
		
		if(this.puertoDataAccess!=null) {
			this.puertoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			puertoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			puertoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		puerto = new  Puerto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			puerto=puertoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.puerto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puerto);
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
		puerto = new  Puerto();
		  		  
        try {
			
			puerto=puertoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.puerto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puerto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		puerto = new  Puerto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			puerto=puertoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.puerto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puerto);
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
		puerto = new  Puerto();
		  		  
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
		puerto = new  Puerto();
		  		  
        try {
			
			puerto=puertoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.puerto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puerto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		puerto = new  Puerto();
		  		  
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
		puerto = new  Puerto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =puertoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		puerto = new  Puerto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=puertoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		puerto = new  Puerto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =puertoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		puerto = new  Puerto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=puertoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		puerto = new  Puerto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =puertoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		puerto = new  Puerto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=puertoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		puertos = new  ArrayList<Puerto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puertos=puertoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPuerto(puertos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puertos);
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
		puertos = new  ArrayList<Puerto>();
		  		  
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
		puertos = new  ArrayList<Puerto>();
		  		  
        try {			
			PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puertos=puertoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPuerto(puertos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puertos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		puertos = new  ArrayList<Puerto>();
		  		  
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
		puertos = new  ArrayList<Puerto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puertos=puertoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPuerto(puertos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puertos);
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
		puertos = new  ArrayList<Puerto>();
		  		  
        try {
			PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puertos=puertoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPuerto(puertos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puertos);
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
		puertos = new  ArrayList<Puerto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puertos=puertoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPuerto(puertos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puertos);
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
		puertos = new  ArrayList<Puerto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puertos=puertoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPuerto(puertos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puertos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		puerto = new  Puerto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puerto=puertoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPuerto(puerto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puerto);
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
		puerto = new  Puerto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puerto=puertoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPuerto(puerto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puerto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		puertos = new  ArrayList<Puerto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puertos=puertoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPuerto(puertos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puertos);
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
		puertos = new  ArrayList<Puerto>();
		  		  
        try {
			PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puertos=puertoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPuerto(puertos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puertos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPuertosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		puertos = new  ArrayList<Puerto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-getTodosPuertosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puertos=puertoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPuerto(puertos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puertos);
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
	
	public  void  getTodosPuertos(String sFinalQuery,Pagination pagination)throws Exception {
		puertos = new  ArrayList<Puerto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			puertos=puertoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPuerto(puertos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puertos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPuerto(Puerto puerto) throws Exception {
		Boolean estaValidado=false;
		
		if(puerto.getIsNew() || puerto.getIsChanged()) { 
			this.invalidValues = puertoValidator.getInvalidValues(puerto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(puerto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPuerto(List<Puerto> Puertos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Puerto puertoLocal:puertos) {				
			estaValidadoObjeto=this.validarGuardarPuerto(puertoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPuerto(List<Puerto> Puertos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPuerto(puertos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPuerto(Puerto Puerto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPuerto(puerto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Puerto puerto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+puerto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PuertoConstantesFunciones.getPuertoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"puerto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PuertoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PuertoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePuertoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-savePuertoWithConnection");connexion.begin();			
			
			PuertoLogicAdditional.checkPuertoToSave(this.puerto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PuertoLogicAdditional.updatePuertoToSave(this.puerto,this.arrDatoGeneral);
			
			PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.puerto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPuerto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPuerto(this.puerto)) {
				PuertoDataAccess.save(this.puerto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.puerto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PuertoLogicAdditional.checkPuertoToSaveAfter(this.puerto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPuerto();
			
			connexion.commit();			
			
			if(this.puerto.getIsDeleted()) {
				this.puerto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePuerto()throws Exception {	
		try {	
			
			PuertoLogicAdditional.checkPuertoToSave(this.puerto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PuertoLogicAdditional.updatePuertoToSave(this.puerto,this.arrDatoGeneral);
			
			PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.puerto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPuerto(this.puerto)) {			
				PuertoDataAccess.save(this.puerto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.puerto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PuertoLogicAdditional.checkPuertoToSaveAfter(this.puerto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.puerto.getIsDeleted()) {
				this.puerto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePuertosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-savePuertosWithConnection");connexion.begin();			
			
			PuertoLogicAdditional.checkPuertoToSaves(puertos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPuertos();
			
			Boolean validadoTodosPuerto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Puerto puertoLocal:puertos) {		
				if(puertoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PuertoLogicAdditional.updatePuertoToSave(puertoLocal,this.arrDatoGeneral);
	        	
				PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),puertoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPuerto(puertoLocal)) {
					PuertoDataAccess.save(puertoLocal, connexion);				
				} else {
					validadoTodosPuerto=false;
				}
			}
			
			if(!validadoTodosPuerto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PuertoLogicAdditional.checkPuertoToSavesAfter(puertos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPuertos();
			
			connexion.commit();		
			
			this.quitarPuertosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePuertos()throws Exception {				
		 try {	
			PuertoLogicAdditional.checkPuertoToSaves(puertos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPuerto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Puerto puertoLocal:puertos) {				
				if(puertoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PuertoLogicAdditional.updatePuertoToSave(puertoLocal,this.arrDatoGeneral);
	        	
				PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),puertoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPuerto(puertoLocal)) {				
					PuertoDataAccess.save(puertoLocal, connexion);				
				} else {
					validadoTodosPuerto=false;
				}
			}
			
			if(!validadoTodosPuerto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PuertoLogicAdditional.checkPuertoToSavesAfter(puertos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPuertosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PuertoParameterReturnGeneral procesarAccionPuertos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Puerto> puertos,PuertoParameterReturnGeneral puertoParameterGeneral)throws Exception {
		 try {	
			PuertoParameterReturnGeneral puertoReturnGeneral=new PuertoParameterReturnGeneral();
	
			PuertoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,puertos,puertoParameterGeneral,puertoReturnGeneral);
			
			return puertoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PuertoParameterReturnGeneral procesarAccionPuertosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Puerto> puertos,PuertoParameterReturnGeneral puertoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-procesarAccionPuertosWithConnection");connexion.begin();			
			
			PuertoParameterReturnGeneral puertoReturnGeneral=new PuertoParameterReturnGeneral();
	
			PuertoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,puertos,puertoParameterGeneral,puertoReturnGeneral);
			
			this.connexion.commit();
			
			return puertoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PuertoParameterReturnGeneral procesarEventosPuertos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Puerto> puertos,Puerto puerto,PuertoParameterReturnGeneral puertoParameterGeneral,Boolean isEsNuevoPuerto,ArrayList<Classe> clases)throws Exception {
		 try {	
			PuertoParameterReturnGeneral puertoReturnGeneral=new PuertoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				puertoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PuertoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,puertos,puerto,puertoParameterGeneral,puertoReturnGeneral,isEsNuevoPuerto,clases);
			
			return puertoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PuertoParameterReturnGeneral procesarEventosPuertosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Puerto> puertos,Puerto puerto,PuertoParameterReturnGeneral puertoParameterGeneral,Boolean isEsNuevoPuerto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-procesarEventosPuertosWithConnection");connexion.begin();			
			
			PuertoParameterReturnGeneral puertoReturnGeneral=new PuertoParameterReturnGeneral();
	
			puertoReturnGeneral.setPuerto(puerto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				puertoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PuertoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,puertos,puerto,puertoParameterGeneral,puertoReturnGeneral,isEsNuevoPuerto,clases);
			
			this.connexion.commit();
			
			return puertoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PuertoParameterReturnGeneral procesarImportacionPuertosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PuertoParameterReturnGeneral puertoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-procesarImportacionPuertosWithConnection");connexion.begin();			
			
			PuertoParameterReturnGeneral puertoReturnGeneral=new PuertoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.puertos=new ArrayList<Puerto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.puerto=new Puerto();
				
				
				if(conColumnasBase) {this.puerto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.puerto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

			this.puerto.setnombre(arrColumnas[iColumn++]);
				this.puerto.setes_local(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.puerto.setdescripcion(arrColumnas[iColumn++]);
				
				this.puertos.add(this.puerto);
			}
			
			this.savePuertos();
			
			this.connexion.commit();
			
			puertoReturnGeneral.setConRetornoEstaProcesado(true);
			puertoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return puertoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPuertosEliminados() throws Exception {				
		
		List<Puerto> puertosAux= new ArrayList<Puerto>();
		
		for(Puerto puerto:puertos) {
			if(!puerto.getIsDeleted()) {
				puertosAux.add(puerto);
			}
		}
		
		puertos=puertosAux;
	}
	
	public void quitarPuertosNulos() throws Exception {				
		
		List<Puerto> puertosAux= new ArrayList<Puerto>();
		
		for(Puerto puerto : this.puertos) {
			if(puerto==null) {
				puertosAux.add(puerto);
			}
		}
		
		//this.puertos=puertosAux;
		
		this.puertos.removeAll(puertosAux);
	}
	
	public void getSetVersionRowPuertoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(puerto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((puerto.getIsDeleted() || (puerto.getIsChanged()&&!puerto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=puertoDataAccess.getSetVersionRowPuerto(connexion,puerto.getId());
				
				if(!puerto.getVersionRow().equals(timestamp)) {	
					puerto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				puerto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPuerto()throws Exception {	
		
		if(puerto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((puerto.getIsDeleted() || (puerto.getIsChanged()&&!puerto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=puertoDataAccess.getSetVersionRowPuerto(connexion,puerto.getId());
			
			try {							
				if(!puerto.getVersionRow().equals(timestamp)) {	
					puerto.setVersionRow(timestamp);
				}
				
				puerto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPuertosWithConnection()throws Exception {	
		if(puertos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Puerto puertoAux:puertos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(puertoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(puertoAux.getIsDeleted() || (puertoAux.getIsChanged()&&!puertoAux.getIsNew())) {
						
						timestamp=puertoDataAccess.getSetVersionRowPuerto(connexion,puertoAux.getId());
						
						if(!puerto.getVersionRow().equals(timestamp)) {	
							puertoAux.setVersionRow(timestamp);
						}
								
						puertoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPuertos()throws Exception {	
		if(puertos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Puerto puertoAux:puertos) {
					if(puertoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(puertoAux.getIsDeleted() || (puertoAux.getIsChanged()&&!puertoAux.getIsNew())) {
						
						timestamp=puertoDataAccess.getSetVersionRowPuerto(connexion,puertoAux.getId());
						
						if(!puertoAux.getVersionRow().equals(timestamp)) {	
							puertoAux.setVersionRow(timestamp);
						}
						
													
						puertoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PuertoParameterReturnGeneral cargarCombosLoteForeignKeyPuertoWithConnection(String finalQueryGlobalTipoPuerto,String finalQueryGlobalPais) throws Exception {
		PuertoParameterReturnGeneral  puertoReturnGeneral =new PuertoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-cargarCombosLoteForeignKeyPuertoWithConnection");connexion.begin();
			
			puertoReturnGeneral =new PuertoParameterReturnGeneral();
			
			

			List<TipoPuerto> tipopuertosForeignKey=new ArrayList<TipoPuerto>();
			TipoPuertoLogic tipopuertoLogic=new TipoPuertoLogic();
			tipopuertoLogic.setConnexion(this.connexion);
			tipopuertoLogic.getTipoPuertoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPuerto.equals("NONE")) {
				tipopuertoLogic.getTodosTipoPuertos(finalQueryGlobalTipoPuerto,new Pagination());
				tipopuertosForeignKey=tipopuertoLogic.getTipoPuertos();
			}

			puertoReturnGeneral.settipopuertosForeignKey(tipopuertosForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			puertoReturnGeneral.setpaissForeignKey(paissForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return puertoReturnGeneral;
	}
	
	public PuertoParameterReturnGeneral cargarCombosLoteForeignKeyPuerto(String finalQueryGlobalTipoPuerto,String finalQueryGlobalPais) throws Exception {
		PuertoParameterReturnGeneral  puertoReturnGeneral =new PuertoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			puertoReturnGeneral =new PuertoParameterReturnGeneral();
			
			

			List<TipoPuerto> tipopuertosForeignKey=new ArrayList<TipoPuerto>();
			TipoPuertoLogic tipopuertoLogic=new TipoPuertoLogic();
			tipopuertoLogic.setConnexion(this.connexion);
			tipopuertoLogic.getTipoPuertoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPuerto.equals("NONE")) {
				tipopuertoLogic.getTodosTipoPuertos(finalQueryGlobalTipoPuerto,new Pagination());
				tipopuertosForeignKey=tipopuertoLogic.getTipoPuertos();
			}

			puertoReturnGeneral.settipopuertosForeignKey(tipopuertosForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			puertoReturnGeneral.setpaissForeignKey(paissForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return puertoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyPuertoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PedidoCompraImporLogic pedidocompraimporLogic=new PedidoCompraImporLogic();
			LiquidacionImporLogic liquidacionimporLogic=new LiquidacionImporLogic();
			EmbarcadorLogic embarcadorLogic=new EmbarcadorLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyPuertoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(PedidoCompraImpor.class));
			classes.add(new Classe(LiquidacionImpor.class));
			classes.add(new Classe(Embarcador.class));
											
			

			pedidocompraimporLogic.setConnexion(this.getConnexion());
			pedidocompraimporLogic.setDatosCliente(this.datosCliente);
			pedidocompraimporLogic.setIsConRefrescarForeignKeys(true);

			liquidacionimporLogic.setConnexion(this.getConnexion());
			liquidacionimporLogic.setDatosCliente(this.datosCliente);
			liquidacionimporLogic.setIsConRefrescarForeignKeys(true);

			embarcadorLogic.setConnexion(this.getConnexion());
			embarcadorLogic.setDatosCliente(this.datosCliente);
			embarcadorLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Puerto puerto:this.puertos) {
				

				classes=new ArrayList<Classe>();
				classes=PedidoCompraImporConstantesFunciones.getClassesForeignKeysOfPedidoCompraImpor(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidocompraimporLogic.setPedidoCompraImpors(puerto.pedidocompraimpors);
				pedidocompraimporLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=LiquidacionImporConstantesFunciones.getClassesForeignKeysOfLiquidacionImpor(new ArrayList<Classe>(),DeepLoadType.NONE);

				liquidacionimporLogic.setLiquidacionImpors(puerto.liquidacionimpors);
				liquidacionimporLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmbarcadorConstantesFunciones.getClassesForeignKeysOfEmbarcador(new ArrayList<Classe>(),DeepLoadType.NONE);

				embarcadorLogic.setEmbarcadors(puerto.embarcadors);
				embarcadorLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Puerto puerto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PuertoLogicAdditional.updatePuertoToGet(puerto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		puerto.setTipoPuerto(puertoDataAccess.getTipoPuerto(connexion,puerto));
		puerto.setPais(puertoDataAccess.getPais(connexion,puerto));
		puerto.setPedidoCompraImpors(puertoDataAccess.getPedidoCompraImpors(connexion,puerto));
		puerto.setLiquidacionImpors(puertoDataAccess.getLiquidacionImpors(connexion,puerto));
		puerto.setEmbarcadors(puertoDataAccess.getEmbarcadors(connexion,puerto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPuerto.class)) {
				puerto.setTipoPuerto(puertoDataAccess.getTipoPuerto(connexion,puerto));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				puerto.setPais(puertoDataAccess.getPais(connexion,puerto));
				continue;
			}

			if(clas.clas.equals(PedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				puerto.setPedidoCompraImpors(puertoDataAccess.getPedidoCompraImpors(connexion,puerto));

				if(this.isConDeep) {
					PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(this.connexion);
					pedidocompraimporLogic.setPedidoCompraImpors(puerto.getPedidoCompraImpors());
					ArrayList<Classe> classesLocal=PedidoCompraImporConstantesFunciones.getClassesForeignKeysOfPedidoCompraImpor(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidocompraimporLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(pedidocompraimporLogic.getPedidoCompraImpors());
					puerto.setPedidoCompraImpors(pedidocompraimporLogic.getPedidoCompraImpors());
				}

				continue;
			}

			if(clas.clas.equals(LiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				puerto.setLiquidacionImpors(puertoDataAccess.getLiquidacionImpors(connexion,puerto));

				if(this.isConDeep) {
					LiquidacionImporLogic liquidacionimporLogic= new LiquidacionImporLogic(this.connexion);
					liquidacionimporLogic.setLiquidacionImpors(puerto.getLiquidacionImpors());
					ArrayList<Classe> classesLocal=LiquidacionImporConstantesFunciones.getClassesForeignKeysOfLiquidacionImpor(new ArrayList<Classe>(),DeepLoadType.NONE);
					liquidacionimporLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(liquidacionimporLogic.getLiquidacionImpors());
					puerto.setLiquidacionImpors(liquidacionimporLogic.getLiquidacionImpors());
				}

				continue;
			}

			if(clas.clas.equals(Embarcador.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				puerto.setEmbarcadors(puertoDataAccess.getEmbarcadors(connexion,puerto));

				if(this.isConDeep) {
					EmbarcadorLogic embarcadorLogic= new EmbarcadorLogic(this.connexion);
					embarcadorLogic.setEmbarcadors(puerto.getEmbarcadors());
					ArrayList<Classe> classesLocal=EmbarcadorConstantesFunciones.getClassesForeignKeysOfEmbarcador(new ArrayList<Classe>(),DeepLoadType.NONE);
					embarcadorLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmbarcadorConstantesFunciones.refrescarForeignKeysDescripcionesEmbarcador(embarcadorLogic.getEmbarcadors());
					puerto.setEmbarcadors(embarcadorLogic.getEmbarcadors());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPuerto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			puerto.setTipoPuerto(puertoDataAccess.getTipoPuerto(connexion,puerto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			puerto.setPais(puertoDataAccess.getPais(connexion,puerto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoCompraImpor.class));
			puerto.setPedidoCompraImpors(puertoDataAccess.getPedidoCompraImpors(connexion,puerto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(LiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(LiquidacionImpor.class));
			puerto.setLiquidacionImpors(puertoDataAccess.getLiquidacionImpors(connexion,puerto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Embarcador.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Embarcador.class));
			puerto.setEmbarcadors(puertoDataAccess.getEmbarcadors(connexion,puerto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		puerto.setTipoPuerto(puertoDataAccess.getTipoPuerto(connexion,puerto));
		TipoPuertoLogic tipopuertoLogic= new TipoPuertoLogic(connexion);
		tipopuertoLogic.deepLoad(puerto.getTipoPuerto(),isDeep,deepLoadType,clases);
				
		puerto.setPais(puertoDataAccess.getPais(connexion,puerto));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(puerto.getPais(),isDeep,deepLoadType,clases);
				

		puerto.setPedidoCompraImpors(puertoDataAccess.getPedidoCompraImpors(connexion,puerto));

		for(PedidoCompraImpor pedidocompraimpor:puerto.getPedidoCompraImpors()) {
			PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
			pedidocompraimporLogic.deepLoad(pedidocompraimpor,isDeep,deepLoadType,clases);
		}

		puerto.setLiquidacionImpors(puertoDataAccess.getLiquidacionImpors(connexion,puerto));

		for(LiquidacionImpor liquidacionimpor:puerto.getLiquidacionImpors()) {
			LiquidacionImporLogic liquidacionimporLogic= new LiquidacionImporLogic(connexion);
			liquidacionimporLogic.deepLoad(liquidacionimpor,isDeep,deepLoadType,clases);
		}

		puerto.setEmbarcadors(puertoDataAccess.getEmbarcadors(connexion,puerto));

		for(Embarcador embarcador:puerto.getEmbarcadors()) {
			EmbarcadorLogic embarcadorLogic= new EmbarcadorLogic(connexion);
			embarcadorLogic.deepLoad(embarcador,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPuerto.class)) {
				puerto.setTipoPuerto(puertoDataAccess.getTipoPuerto(connexion,puerto));
				TipoPuertoLogic tipopuertoLogic= new TipoPuertoLogic(connexion);
				tipopuertoLogic.deepLoad(puerto.getTipoPuerto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				puerto.setPais(puertoDataAccess.getPais(connexion,puerto));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(puerto.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				puerto.setPedidoCompraImpors(puertoDataAccess.getPedidoCompraImpors(connexion,puerto));

				for(PedidoCompraImpor pedidocompraimpor:puerto.getPedidoCompraImpors()) {
					PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
					pedidocompraimporLogic.deepLoad(pedidocompraimpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(LiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				puerto.setLiquidacionImpors(puertoDataAccess.getLiquidacionImpors(connexion,puerto));

				for(LiquidacionImpor liquidacionimpor:puerto.getLiquidacionImpors()) {
					LiquidacionImporLogic liquidacionimporLogic= new LiquidacionImporLogic(connexion);
					liquidacionimporLogic.deepLoad(liquidacionimpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Embarcador.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				puerto.setEmbarcadors(puertoDataAccess.getEmbarcadors(connexion,puerto));

				for(Embarcador embarcador:puerto.getEmbarcadors()) {
					EmbarcadorLogic embarcadorLogic= new EmbarcadorLogic(connexion);
					embarcadorLogic.deepLoad(embarcador,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPuerto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			puerto.setTipoPuerto(puertoDataAccess.getTipoPuerto(connexion,puerto));
			TipoPuertoLogic tipopuertoLogic= new TipoPuertoLogic(connexion);
			tipopuertoLogic.deepLoad(puerto.getTipoPuerto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			puerto.setPais(puertoDataAccess.getPais(connexion,puerto));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(puerto.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoCompraImpor.class));
			puerto.setPedidoCompraImpors(puertoDataAccess.getPedidoCompraImpors(connexion,puerto));

			for(PedidoCompraImpor pedidocompraimpor:puerto.getPedidoCompraImpors()) {
				PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
				pedidocompraimporLogic.deepLoad(pedidocompraimpor,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(LiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(LiquidacionImpor.class));
			puerto.setLiquidacionImpors(puertoDataAccess.getLiquidacionImpors(connexion,puerto));

			for(LiquidacionImpor liquidacionimpor:puerto.getLiquidacionImpors()) {
				LiquidacionImporLogic liquidacionimporLogic= new LiquidacionImporLogic(connexion);
				liquidacionimporLogic.deepLoad(liquidacionimpor,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Embarcador.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Embarcador.class));
			puerto.setEmbarcadors(puertoDataAccess.getEmbarcadors(connexion,puerto));

			for(Embarcador embarcador:puerto.getEmbarcadors()) {
				EmbarcadorLogic embarcadorLogic= new EmbarcadorLogic(connexion);
				embarcadorLogic.deepLoad(embarcador,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Puerto puerto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PuertoLogicAdditional.updatePuertoToSave(puerto,this.arrDatoGeneral);
			
PuertoDataAccess.save(puerto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		TipoPuertoDataAccess.save(puerto.getTipoPuerto(),connexion);

		PaisDataAccess.save(puerto.getPais(),connexion);

		for(PedidoCompraImpor pedidocompraimpor:puerto.getPedidoCompraImpors()) {
			pedidocompraimpor.setid_puerto(puerto.getId());
			PedidoCompraImporDataAccess.save(pedidocompraimpor,connexion);
		}

		for(LiquidacionImpor liquidacionimpor:puerto.getLiquidacionImpors()) {
			liquidacionimpor.setid_puerto(puerto.getId());
			LiquidacionImporDataAccess.save(liquidacionimpor,connexion);
		}

		for(Embarcador embarcador:puerto.getEmbarcadors()) {
			embarcador.setid_puerto(puerto.getId());
			EmbarcadorDataAccess.save(embarcador,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPuerto.class)) {
				TipoPuertoDataAccess.save(puerto.getTipoPuerto(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(puerto.getPais(),connexion);
				continue;
			}


			if(clas.clas.equals(PedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoCompraImpor pedidocompraimpor:puerto.getPedidoCompraImpors()) {
					pedidocompraimpor.setid_puerto(puerto.getId());
					PedidoCompraImporDataAccess.save(pedidocompraimpor,connexion);
				}
				continue;
			}

			if(clas.clas.equals(LiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(LiquidacionImpor liquidacionimpor:puerto.getLiquidacionImpors()) {
					liquidacionimpor.setid_puerto(puerto.getId());
					LiquidacionImporDataAccess.save(liquidacionimpor,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Embarcador.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Embarcador embarcador:puerto.getEmbarcadors()) {
					embarcador.setid_puerto(puerto.getId());
					EmbarcadorDataAccess.save(embarcador,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		TipoPuertoDataAccess.save(puerto.getTipoPuerto(),connexion);
		TipoPuertoLogic tipopuertoLogic= new TipoPuertoLogic(connexion);
		tipopuertoLogic.deepLoad(puerto.getTipoPuerto(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(puerto.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(puerto.getPais(),isDeep,deepLoadType,clases);
				

		for(PedidoCompraImpor pedidocompraimpor:puerto.getPedidoCompraImpors()) {
			PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
			pedidocompraimpor.setid_puerto(puerto.getId());
			PedidoCompraImporDataAccess.save(pedidocompraimpor,connexion);
			pedidocompraimporLogic.deepSave(pedidocompraimpor,isDeep,deepLoadType,clases);
		}

		for(LiquidacionImpor liquidacionimpor:puerto.getLiquidacionImpors()) {
			LiquidacionImporLogic liquidacionimporLogic= new LiquidacionImporLogic(connexion);
			liquidacionimpor.setid_puerto(puerto.getId());
			LiquidacionImporDataAccess.save(liquidacionimpor,connexion);
			liquidacionimporLogic.deepSave(liquidacionimpor,isDeep,deepLoadType,clases);
		}

		for(Embarcador embarcador:puerto.getEmbarcadors()) {
			EmbarcadorLogic embarcadorLogic= new EmbarcadorLogic(connexion);
			embarcador.setid_puerto(puerto.getId());
			EmbarcadorDataAccess.save(embarcador,connexion);
			embarcadorLogic.deepSave(embarcador,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPuerto.class)) {
				TipoPuertoDataAccess.save(puerto.getTipoPuerto(),connexion);
				TipoPuertoLogic tipopuertoLogic= new TipoPuertoLogic(connexion);
				tipopuertoLogic.deepSave(puerto.getTipoPuerto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(puerto.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(puerto.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(PedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoCompraImpor pedidocompraimpor:puerto.getPedidoCompraImpors()) {
					PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
					pedidocompraimpor.setid_puerto(puerto.getId());
					PedidoCompraImporDataAccess.save(pedidocompraimpor,connexion);
					pedidocompraimporLogic.deepSave(pedidocompraimpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(LiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(LiquidacionImpor liquidacionimpor:puerto.getLiquidacionImpors()) {
					LiquidacionImporLogic liquidacionimporLogic= new LiquidacionImporLogic(connexion);
					liquidacionimpor.setid_puerto(puerto.getId());
					LiquidacionImporDataAccess.save(liquidacionimpor,connexion);
					liquidacionimporLogic.deepSave(liquidacionimpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Embarcador.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Embarcador embarcador:puerto.getEmbarcadors()) {
					EmbarcadorLogic embarcadorLogic= new EmbarcadorLogic(connexion);
					embarcador.setid_puerto(puerto.getId());
					EmbarcadorDataAccess.save(embarcador,connexion);
					embarcadorLogic.deepSave(embarcador,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Puerto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(puerto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(puerto);
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
			this.deepLoad(this.puerto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puerto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Puerto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(puertos!=null) {
				for(Puerto puerto:puertos) {
					this.deepLoad(puerto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(puertos);
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
			if(puertos!=null) {
				for(Puerto puerto:puertos) {
					this.deepLoad(puerto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(puertos);
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
			this.getNewConnexionToDeep(Puerto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(puerto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Puerto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(puertos!=null) {
				for(Puerto puerto:puertos) {
					this.deepSave(puerto,isDeep,deepLoadType,clases);
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
			if(puertos!=null) {
				for(Puerto puerto:puertos) {
					this.deepSave(puerto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPuertosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",PuertoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			puertos=puertoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puertos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPuertosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",PuertoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			puertos=puertoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puertos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPuertosFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,PuertoConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			puertos=puertoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puertos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPuertosFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,PuertoConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			puertos=puertoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puertos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPuertosFK_IdTipoPuertoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_puerto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPuerto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPuerto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_puerto,PuertoConstantesFunciones.IDTIPOPUERTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPuerto);

			PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPuerto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			puertos=puertoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puertos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPuertosFK_IdTipoPuerto(String sFinalQuery,Pagination pagination,Long id_tipo_puerto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPuerto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPuerto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_puerto,PuertoConstantesFunciones.IDTIPOPUERTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPuerto);

			PuertoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPuerto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			puertos=puertoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puertos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPuertoPorIdPaisPorNombreWithConnection(Long id_pais,String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Puerto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,PuertoConstantesFunciones.IDPAIS,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,PuertoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			puerto=puertoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.puerto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puerto);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPuertoPorIdPaisPorNombre(Long id_pais,String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,PuertoConstantesFunciones.IDPAIS,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,PuertoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			puerto=puertoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.puerto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				PuertoConstantesFunciones.refrescarForeignKeysDescripcionesPuerto(this.puerto);
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
			if(PuertoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PuertoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Puerto puerto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PuertoConstantesFunciones.ISCONAUDITORIA) {
				if(puerto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PuertoDataAccess.TABLENAME, puerto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PuertoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PuertoLogic.registrarAuditoriaDetallesPuerto(connexion,puerto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(puerto.getIsDeleted()) {
					/*if(!puerto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PuertoDataAccess.TABLENAME, puerto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PuertoLogic.registrarAuditoriaDetallesPuerto(connexion,puerto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PuertoDataAccess.TABLENAME, puerto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(puerto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PuertoDataAccess.TABLENAME, puerto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PuertoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PuertoLogic.registrarAuditoriaDetallesPuerto(connexion,puerto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPuerto(Connexion connexion,Puerto puerto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(puerto.getIsNew()||!puerto.getid_tipo_puerto().equals(puerto.getPuertoOriginal().getid_tipo_puerto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(puerto.getPuertoOriginal().getid_tipo_puerto()!=null)
				{
					strValorActual=puerto.getPuertoOriginal().getid_tipo_puerto().toString();
				}
				if(puerto.getid_tipo_puerto()!=null)
				{
					strValorNuevo=puerto.getid_tipo_puerto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PuertoConstantesFunciones.IDTIPOPUERTO,strValorActual,strValorNuevo);
			}	
			
			if(puerto.getIsNew()||!puerto.getid_pais().equals(puerto.getPuertoOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(puerto.getPuertoOriginal().getid_pais()!=null)
				{
					strValorActual=puerto.getPuertoOriginal().getid_pais().toString();
				}
				if(puerto.getid_pais()!=null)
				{
					strValorNuevo=puerto.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PuertoConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(puerto.getIsNew()||!puerto.getnombre().equals(puerto.getPuertoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(puerto.getPuertoOriginal().getnombre()!=null)
				{
					strValorActual=puerto.getPuertoOriginal().getnombre();
				}
				if(puerto.getnombre()!=null)
				{
					strValorNuevo=puerto.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PuertoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(puerto.getIsNew()||!puerto.getes_local().equals(puerto.getPuertoOriginal().getes_local()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(puerto.getPuertoOriginal().getes_local()!=null)
				{
					strValorActual=puerto.getPuertoOriginal().getes_local().toString();
				}
				if(puerto.getes_local()!=null)
				{
					strValorNuevo=puerto.getes_local().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PuertoConstantesFunciones.ESLOCAL,strValorActual,strValorNuevo);
			}	
			
			if(puerto.getIsNew()||!puerto.getdescripcion().equals(puerto.getPuertoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(puerto.getPuertoOriginal().getdescripcion()!=null)
				{
					strValorActual=puerto.getPuertoOriginal().getdescripcion();
				}
				if(puerto.getdescripcion()!=null)
				{
					strValorNuevo=puerto.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PuertoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePuertoRelacionesWithConnection(Puerto puerto,List<PedidoCompraImpor> pedidocompraimpors,List<LiquidacionImpor> liquidacionimpors,List<Embarcador> embarcadors) throws Exception {

		if(!puerto.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePuertoRelacionesBase(puerto,pedidocompraimpors,liquidacionimpors,embarcadors,true);
		}
	}

	public void savePuertoRelaciones(Puerto puerto,List<PedidoCompraImpor> pedidocompraimpors,List<LiquidacionImpor> liquidacionimpors,List<Embarcador> embarcadors)throws Exception {

		if(!puerto.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePuertoRelacionesBase(puerto,pedidocompraimpors,liquidacionimpors,embarcadors,false);
		}
	}

	public void savePuertoRelacionesBase(Puerto puerto,List<PedidoCompraImpor> pedidocompraimpors,List<LiquidacionImpor> liquidacionimpors,List<Embarcador> embarcadors,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Puerto-saveRelacionesWithConnection");}
	
			puerto.setPedidoCompraImpors(pedidocompraimpors);
			puerto.setLiquidacionImpors(liquidacionimpors);
			puerto.setEmbarcadors(embarcadors);

			this.setPuerto(puerto);

			if(PuertoLogicAdditional.validarSaveRelaciones(puerto,this)) {

				PuertoLogicAdditional.updateRelacionesToSave(puerto,this);

				if((puerto.getIsNew()||puerto.getIsChanged())&&!puerto.getIsDeleted()) {
					this.savePuerto();
					this.savePuertoRelacionesDetalles(pedidocompraimpors,liquidacionimpors,embarcadors);

				} else if(puerto.getIsDeleted()) {
					this.savePuertoRelacionesDetalles(pedidocompraimpors,liquidacionimpors,embarcadors);
					this.savePuerto();
				}

				PuertoLogicAdditional.updateRelacionesToSaveAfter(puerto,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			PedidoCompraImporConstantesFunciones.InicializarGeneralEntityAuxiliaresPedidoCompraImpors(pedidocompraimpors,true,true);
			LiquidacionImporConstantesFunciones.InicializarGeneralEntityAuxiliaresLiquidacionImpors(liquidacionimpors,true,true);
			EmbarcadorConstantesFunciones.InicializarGeneralEntityAuxiliaresEmbarcadors(embarcadors,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void savePuertoRelacionesDetalles(List<PedidoCompraImpor> pedidocompraimpors,List<LiquidacionImpor> liquidacionimpors,List<Embarcador> embarcadors)throws Exception {
		try {
	

			Long idPuertoActual=this.getPuerto().getId();

			PedidoCompraImporLogic pedidocompraimporLogic_Desde_Puerto=new PedidoCompraImporLogic();
			pedidocompraimporLogic_Desde_Puerto.setPedidoCompraImpors(pedidocompraimpors);

			pedidocompraimporLogic_Desde_Puerto.setConnexion(this.getConnexion());
			pedidocompraimporLogic_Desde_Puerto.setDatosCliente(this.datosCliente);

			for(PedidoCompraImpor pedidocompraimpor_Desde_Puerto:pedidocompraimporLogic_Desde_Puerto.getPedidoCompraImpors()) {
				pedidocompraimpor_Desde_Puerto.setid_puerto(idPuertoActual);

				pedidocompraimporLogic_Desde_Puerto.setPedidoCompraImpor(pedidocompraimpor_Desde_Puerto);
				pedidocompraimporLogic_Desde_Puerto.savePedidoCompraImpor();

				Long idPedidoCompraImporActual=pedidocompraimpor_Desde_Puerto.getId();

				DetallePedidoCompraImporLogic detallepedidocompraimporLogic_Desde_PedidoCompraImpor=new DetallePedidoCompraImporLogic();

				if(pedidocompraimpor_Desde_Puerto.getDetallePedidoCompraImpors()==null){
					pedidocompraimpor_Desde_Puerto.setDetallePedidoCompraImpors(new ArrayList<DetallePedidoCompraImpor>());
				}

				detallepedidocompraimporLogic_Desde_PedidoCompraImpor.setDetallePedidoCompraImpors(pedidocompraimpor_Desde_Puerto.getDetallePedidoCompraImpors());

				detallepedidocompraimporLogic_Desde_PedidoCompraImpor.setConnexion(this.getConnexion());
				detallepedidocompraimporLogic_Desde_PedidoCompraImpor.setDatosCliente(this.datosCliente);

				for(DetallePedidoCompraImpor detallepedidocompraimpor_Desde_PedidoCompraImpor:detallepedidocompraimporLogic_Desde_PedidoCompraImpor.getDetallePedidoCompraImpors()) {
					detallepedidocompraimpor_Desde_PedidoCompraImpor.setid_pedido_compra_impor(idPedidoCompraImporActual);
				}

				detallepedidocompraimporLogic_Desde_PedidoCompraImpor.saveDetallePedidoCompraImpors();

				LiquidacionImpuestoImporLogic liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor=new LiquidacionImpuestoImporLogic();

				if(pedidocompraimpor_Desde_Puerto.getLiquidacionImpuestoImpors()==null){
					pedidocompraimpor_Desde_Puerto.setLiquidacionImpuestoImpors(new ArrayList<LiquidacionImpuestoImpor>());
				}

				liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.setLiquidacionImpuestoImpors(pedidocompraimpor_Desde_Puerto.getLiquidacionImpuestoImpors());

				liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.setConnexion(this.getConnexion());
				liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.setDatosCliente(this.datosCliente);

				for(LiquidacionImpuestoImpor liquidacionimpuestoimpor_Desde_PedidoCompraImpor:liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.getLiquidacionImpuestoImpors()) {
					liquidacionimpuestoimpor_Desde_PedidoCompraImpor.setid_pedido_compra_impor(idPedidoCompraImporActual);

					liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.setLiquidacionImpuestoImpor(liquidacionimpuestoimpor_Desde_PedidoCompraImpor);
					liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.saveLiquidacionImpuestoImpor();

					Long idLiquidacionImpuestoImporActual=liquidacionimpuestoimpor_Desde_PedidoCompraImpor.getId();

					DetalleLiquidacionImpuestoImporLogic detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor=new DetalleLiquidacionImpuestoImporLogic();

					if(liquidacionimpuestoimpor_Desde_PedidoCompraImpor.getDetalleLiquidacionImpuestoImpors()==null){
						liquidacionimpuestoimpor_Desde_PedidoCompraImpor.setDetalleLiquidacionImpuestoImpors(new ArrayList<DetalleLiquidacionImpuestoImpor>());
					}

					detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor.setDetalleLiquidacionImpuestoImpors(liquidacionimpuestoimpor_Desde_PedidoCompraImpor.getDetalleLiquidacionImpuestoImpors());

					detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor.setConnexion(this.getConnexion());
					detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor.setDatosCliente(this.datosCliente);

					for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor_Desde_LiquidacionImpuestoImpor:detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor.getDetalleLiquidacionImpuestoImpors()) {
						detalleliquidacionimpuestoimpor_Desde_LiquidacionImpuestoImpor.setid_liquidacion_impuesto_impor(idLiquidacionImpuestoImporActual);
					}

					detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor.saveDetalleLiquidacionImpuestoImpors();
				}

			}


			LiquidacionImporLogic liquidacionimporLogic_Desde_Puerto=new LiquidacionImporLogic();
			liquidacionimporLogic_Desde_Puerto.setLiquidacionImpors(liquidacionimpors);

			liquidacionimporLogic_Desde_Puerto.setConnexion(this.getConnexion());
			liquidacionimporLogic_Desde_Puerto.setDatosCliente(this.datosCliente);

			for(LiquidacionImpor liquidacionimpor_Desde_Puerto:liquidacionimporLogic_Desde_Puerto.getLiquidacionImpors()) {
				liquidacionimpor_Desde_Puerto.setid_puerto(idPuertoActual);

				liquidacionimporLogic_Desde_Puerto.setLiquidacionImpor(liquidacionimpor_Desde_Puerto);
				liquidacionimporLogic_Desde_Puerto.saveLiquidacionImpor();

				Long idLiquidacionImporActual=liquidacionimpor_Desde_Puerto.getId();

				DetalleLiquidacionImporLogic detalleliquidacionimporLogic_Desde_LiquidacionImpor=new DetalleLiquidacionImporLogic();

				if(liquidacionimpor_Desde_Puerto.getDetalleLiquidacionImpors()==null){
					liquidacionimpor_Desde_Puerto.setDetalleLiquidacionImpors(new ArrayList<DetalleLiquidacionImpor>());
				}

				detalleliquidacionimporLogic_Desde_LiquidacionImpor.setDetalleLiquidacionImpors(liquidacionimpor_Desde_Puerto.getDetalleLiquidacionImpors());

				detalleliquidacionimporLogic_Desde_LiquidacionImpor.setConnexion(this.getConnexion());
				detalleliquidacionimporLogic_Desde_LiquidacionImpor.setDatosCliente(this.datosCliente);

				for(DetalleLiquidacionImpor detalleliquidacionimpor_Desde_LiquidacionImpor:detalleliquidacionimporLogic_Desde_LiquidacionImpor.getDetalleLiquidacionImpors()) {
					detalleliquidacionimpor_Desde_LiquidacionImpor.setid_liquidacion_impor(idLiquidacionImporActual);
				}

				detalleliquidacionimporLogic_Desde_LiquidacionImpor.saveDetalleLiquidacionImpors();
			}


			EmbarcadorLogic embarcadorLogic_Desde_Puerto=new EmbarcadorLogic();
			embarcadorLogic_Desde_Puerto.setEmbarcadors(embarcadors);

			embarcadorLogic_Desde_Puerto.setConnexion(this.getConnexion());
			embarcadorLogic_Desde_Puerto.setDatosCliente(this.datosCliente);

			for(Embarcador embarcador_Desde_Puerto:embarcadorLogic_Desde_Puerto.getEmbarcadors()) {
				embarcador_Desde_Puerto.setid_puerto(idPuertoActual);

				embarcadorLogic_Desde_Puerto.setEmbarcador(embarcador_Desde_Puerto);
				embarcadorLogic_Desde_Puerto.saveEmbarcador();

				Long idEmbarcadorActual=embarcador_Desde_Puerto.getId();

				PedidoCompraImporLogic pedidocompraimporLogic_Desde_Embarcador=new PedidoCompraImporLogic();

				if(embarcador_Desde_Puerto.getPedidoCompraImpors()==null){
					embarcador_Desde_Puerto.setPedidoCompraImpors(new ArrayList<PedidoCompraImpor>());
				}

				pedidocompraimporLogic_Desde_Embarcador.setPedidoCompraImpors(embarcador_Desde_Puerto.getPedidoCompraImpors());

				pedidocompraimporLogic_Desde_Embarcador.setConnexion(this.getConnexion());
				pedidocompraimporLogic_Desde_Embarcador.setDatosCliente(this.datosCliente);

				for(PedidoCompraImpor pedidocompraimpor_Desde_Embarcador:pedidocompraimporLogic_Desde_Embarcador.getPedidoCompraImpors()) {
					pedidocompraimpor_Desde_Embarcador.setid_embarcador(idEmbarcadorActual);

					pedidocompraimporLogic_Desde_Embarcador.setPedidoCompraImpor(pedidocompraimpor_Desde_Embarcador);
					pedidocompraimporLogic_Desde_Embarcador.savePedidoCompraImpor();

					Long idPedidoCompraImporActual=pedidocompraimpor_Desde_Embarcador.getId();

					DetallePedidoCompraImporLogic detallepedidocompraimporLogic_Desde_PedidoCompraImpor=new DetallePedidoCompraImporLogic();

					if(pedidocompraimpor_Desde_Embarcador.getDetallePedidoCompraImpors()==null){
						pedidocompraimpor_Desde_Embarcador.setDetallePedidoCompraImpors(new ArrayList<DetallePedidoCompraImpor>());
					}

					detallepedidocompraimporLogic_Desde_PedidoCompraImpor.setDetallePedidoCompraImpors(pedidocompraimpor_Desde_Embarcador.getDetallePedidoCompraImpors());

					detallepedidocompraimporLogic_Desde_PedidoCompraImpor.setConnexion(this.getConnexion());
					detallepedidocompraimporLogic_Desde_PedidoCompraImpor.setDatosCliente(this.datosCliente);

					for(DetallePedidoCompraImpor detallepedidocompraimpor_Desde_PedidoCompraImpor:detallepedidocompraimporLogic_Desde_PedidoCompraImpor.getDetallePedidoCompraImpors()) {
						detallepedidocompraimpor_Desde_PedidoCompraImpor.setid_pedido_compra_impor(idPedidoCompraImporActual);
					}

					detallepedidocompraimporLogic_Desde_PedidoCompraImpor.saveDetallePedidoCompraImpors();

					LiquidacionImpuestoImporLogic liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor=new LiquidacionImpuestoImporLogic();

					if(pedidocompraimpor_Desde_Embarcador.getLiquidacionImpuestoImpors()==null){
						pedidocompraimpor_Desde_Embarcador.setLiquidacionImpuestoImpors(new ArrayList<LiquidacionImpuestoImpor>());
					}

					liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.setLiquidacionImpuestoImpors(pedidocompraimpor_Desde_Embarcador.getLiquidacionImpuestoImpors());

					liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.setConnexion(this.getConnexion());
					liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.setDatosCliente(this.datosCliente);

					for(LiquidacionImpuestoImpor liquidacionimpuestoimpor_Desde_PedidoCompraImpor:liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.getLiquidacionImpuestoImpors()) {
						liquidacionimpuestoimpor_Desde_PedidoCompraImpor.setid_pedido_compra_impor(idPedidoCompraImporActual);

						liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.setLiquidacionImpuestoImpor(liquidacionimpuestoimpor_Desde_PedidoCompraImpor);
						liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.saveLiquidacionImpuestoImpor();
					}

				}


				ParametroCompraLogic parametrocompraLogic_Desde_Embarcador=new ParametroCompraLogic();

				if(embarcador_Desde_Puerto.getParametroCompras()==null){
					embarcador_Desde_Puerto.setParametroCompras(new ArrayList<ParametroCompra>());
				}

				parametrocompraLogic_Desde_Embarcador.setParametroCompras(embarcador_Desde_Puerto.getParametroCompras());

				parametrocompraLogic_Desde_Embarcador.setConnexion(this.getConnexion());
				parametrocompraLogic_Desde_Embarcador.setDatosCliente(this.datosCliente);

				for(ParametroCompra parametrocompra_Desde_Embarcador:parametrocompraLogic_Desde_Embarcador.getParametroCompras()) {
					parametrocompra_Desde_Embarcador.setid_embarcador(idEmbarcadorActual);
				}

				parametrocompraLogic_Desde_Embarcador.saveParametroCompras();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPuerto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PuertoConstantesFunciones.getClassesForeignKeysOfPuerto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPuerto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PuertoConstantesFunciones.getClassesRelationshipsOfPuerto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

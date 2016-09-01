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
import com.bydan.erp.inventario.util.UnidadConstantesFunciones;
import com.bydan.erp.inventario.util.UnidadParameterReturnGeneral;
//import com.bydan.erp.inventario.util.UnidadParameterGeneral;
import com.bydan.erp.inventario.business.entity.Unidad;
import com.bydan.erp.inventario.business.logic.UnidadLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.importaciones.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;








@SuppressWarnings("unused")
public class UnidadLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(UnidadLogic.class);
	
	protected UnidadDataAccess unidadDataAccess; 	
	protected Unidad unidad;
	protected List<Unidad> unidads;
	protected Object unidadObject;	
	protected List<Object> unidadsObject;
	
	public static ClassValidator<Unidad> unidadValidator = new ClassValidator<Unidad>(Unidad.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected UnidadLogicAdditional unidadLogicAdditional=null;
	
	public UnidadLogicAdditional getUnidadLogicAdditional() {
		return this.unidadLogicAdditional;
	}
	
	public void setUnidadLogicAdditional(UnidadLogicAdditional unidadLogicAdditional) {
		try {
			this.unidadLogicAdditional=unidadLogicAdditional;
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
	
	
	
	
	public  UnidadLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.unidadDataAccess = new UnidadDataAccess();
			
			this.unidads= new ArrayList<Unidad>();
			this.unidad= new Unidad();
			
			this.unidadObject=new Object();
			this.unidadsObject=new ArrayList<Object>();
				
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
			
			this.unidadDataAccess.setConnexionType(this.connexionType);
			this.unidadDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  UnidadLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.unidadDataAccess = new UnidadDataAccess();
			this.unidads= new ArrayList<Unidad>();
			this.unidad= new Unidad();
			this.unidadObject=new Object();
			this.unidadsObject=new ArrayList<Object>();
			
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
			
			this.unidadDataAccess.setConnexionType(this.connexionType);
			this.unidadDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Unidad getUnidad() throws Exception {	
		UnidadLogicAdditional.checkUnidadToGet(unidad,this.datosCliente,this.arrDatoGeneral);
		UnidadLogicAdditional.updateUnidadToGet(unidad,this.arrDatoGeneral);
		
		return unidad;
	}
		
	public void setUnidad(Unidad newUnidad) {
		this.unidad = newUnidad;
	}
	
	public UnidadDataAccess getUnidadDataAccess() {
		return unidadDataAccess;
	}
	
	public void setUnidadDataAccess(UnidadDataAccess newunidadDataAccess) {
		this.unidadDataAccess = newunidadDataAccess;
	}
	
	public List<Unidad> getUnidads() throws Exception {		
		this.quitarUnidadsNulos();
		
		UnidadLogicAdditional.checkUnidadToGets(unidads,this.datosCliente,this.arrDatoGeneral);
		
		for (Unidad unidadLocal: unidads ) {
			UnidadLogicAdditional.updateUnidadToGet(unidadLocal,this.arrDatoGeneral);
		}
		
		return unidads;
	}
	
	public void setUnidads(List<Unidad> newUnidads) {
		this.unidads = newUnidads;
	}
	
	public Object getUnidadObject() {	
		this.unidadObject=this.unidadDataAccess.getEntityObject();
		return this.unidadObject;
	}
		
	public void setUnidadObject(Object newUnidadObject) {
		this.unidadObject = newUnidadObject;
	}
	
	public List<Object> getUnidadsObject() {		
		this.unidadsObject=this.unidadDataAccess.getEntitiesObject();
		return this.unidadsObject;
	}
		
	public void setUnidadsObject(List<Object> newUnidadsObject) {
		this.unidadsObject = newUnidadsObject;
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
		
		if(this.unidadDataAccess!=null) {
			this.unidadDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			unidadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			unidadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		unidad = new  Unidad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			unidad=unidadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.unidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidad);
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
		unidad = new  Unidad();
		  		  
        try {
			
			unidad=unidadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.unidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		unidad = new  Unidad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			unidad=unidadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.unidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidad);
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
		unidad = new  Unidad();
		  		  
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
		unidad = new  Unidad();
		  		  
        try {
			
			unidad=unidadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.unidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		unidad = new  Unidad();
		  		  
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
		unidad = new  Unidad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =unidadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		unidad = new  Unidad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=unidadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		unidad = new  Unidad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =unidadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		unidad = new  Unidad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=unidadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		unidad = new  Unidad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =unidadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		unidad = new  Unidad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=unidadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		unidads = new  ArrayList<Unidad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			unidads=unidadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUnidad(unidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidads);
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
		unidads = new  ArrayList<Unidad>();
		  		  
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
		unidads = new  ArrayList<Unidad>();
		  		  
        try {			
			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			unidads=unidadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarUnidad(unidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		unidads = new  ArrayList<Unidad>();
		  		  
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
		unidads = new  ArrayList<Unidad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			unidads=unidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUnidad(unidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidads);
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
		unidads = new  ArrayList<Unidad>();
		  		  
        try {
			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			unidads=unidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUnidad(unidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidads);
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
		unidads = new  ArrayList<Unidad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			unidads=unidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUnidad(unidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidads);
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
		unidads = new  ArrayList<Unidad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			unidads=unidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUnidad(unidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidads);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		unidad = new  Unidad();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			unidad=unidadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUnidad(unidad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidad);
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
		unidad = new  Unidad();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			unidad=unidadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUnidad(unidad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		unidads = new  ArrayList<Unidad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			unidads=unidadDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUnidad(unidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidads);
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
		unidads = new  ArrayList<Unidad>();
		  		  
        try {
			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			unidads=unidadDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUnidad(unidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidads);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosUnidadsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		unidads = new  ArrayList<Unidad>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-getTodosUnidadsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			unidads=unidadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarUnidad(unidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidads);
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
	
	public  void  getTodosUnidads(String sFinalQuery,Pagination pagination)throws Exception {
		unidads = new  ArrayList<Unidad>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			unidads=unidadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarUnidad(unidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarUnidad(Unidad unidad) throws Exception {
		Boolean estaValidado=false;
		
		if(unidad.getIsNew() || unidad.getIsChanged()) { 
			this.invalidValues = unidadValidator.getInvalidValues(unidad);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(unidad);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarUnidad(List<Unidad> Unidads) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Unidad unidadLocal:unidads) {				
			estaValidadoObjeto=this.validarGuardarUnidad(unidadLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarUnidad(List<Unidad> Unidads) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarUnidad(unidads)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarUnidad(Unidad Unidad) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarUnidad(unidad)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Unidad unidad) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+unidad.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=UnidadConstantesFunciones.getUnidadLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"unidad","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(UnidadConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(UnidadConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveUnidadWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-saveUnidadWithConnection");connexion.begin();			
			
			UnidadLogicAdditional.checkUnidadToSave(this.unidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			UnidadLogicAdditional.updateUnidadToSave(this.unidad,this.arrDatoGeneral);
			
			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.unidad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowUnidad();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarUnidad(this.unidad)) {
				UnidadDataAccess.save(this.unidad, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.unidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			UnidadLogicAdditional.checkUnidadToSaveAfter(this.unidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowUnidad();
			
			connexion.commit();			
			
			if(this.unidad.getIsDeleted()) {
				this.unidad=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveUnidad()throws Exception {	
		try {	
			
			UnidadLogicAdditional.checkUnidadToSave(this.unidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			UnidadLogicAdditional.updateUnidadToSave(this.unidad,this.arrDatoGeneral);
			
			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.unidad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarUnidad(this.unidad)) {			
				UnidadDataAccess.save(this.unidad, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.unidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			UnidadLogicAdditional.checkUnidadToSaveAfter(this.unidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.unidad.getIsDeleted()) {
				this.unidad=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveUnidadsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-saveUnidadsWithConnection");connexion.begin();			
			
			UnidadLogicAdditional.checkUnidadToSaves(unidads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowUnidads();
			
			Boolean validadoTodosUnidad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Unidad unidadLocal:unidads) {		
				if(unidadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				UnidadLogicAdditional.updateUnidadToSave(unidadLocal,this.arrDatoGeneral);
	        	
				UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),unidadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarUnidad(unidadLocal)) {
					UnidadDataAccess.save(unidadLocal, connexion);				
				} else {
					validadoTodosUnidad=false;
				}
			}
			
			if(!validadoTodosUnidad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			UnidadLogicAdditional.checkUnidadToSavesAfter(unidads,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowUnidads();
			
			connexion.commit();		
			
			this.quitarUnidadsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveUnidads()throws Exception {				
		 try {	
			UnidadLogicAdditional.checkUnidadToSaves(unidads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosUnidad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Unidad unidadLocal:unidads) {				
				if(unidadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				UnidadLogicAdditional.updateUnidadToSave(unidadLocal,this.arrDatoGeneral);
	        	
				UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),unidadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarUnidad(unidadLocal)) {				
					UnidadDataAccess.save(unidadLocal, connexion);				
				} else {
					validadoTodosUnidad=false;
				}
			}
			
			if(!validadoTodosUnidad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			UnidadLogicAdditional.checkUnidadToSavesAfter(unidads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarUnidadsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public UnidadParameterReturnGeneral procesarAccionUnidads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Unidad> unidads,UnidadParameterReturnGeneral unidadParameterGeneral)throws Exception {
		 try {	
			UnidadParameterReturnGeneral unidadReturnGeneral=new UnidadParameterReturnGeneral();
	
			UnidadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,unidads,unidadParameterGeneral,unidadReturnGeneral);
			
			return unidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public UnidadParameterReturnGeneral procesarAccionUnidadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Unidad> unidads,UnidadParameterReturnGeneral unidadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-procesarAccionUnidadsWithConnection");connexion.begin();			
			
			UnidadParameterReturnGeneral unidadReturnGeneral=new UnidadParameterReturnGeneral();
	
			UnidadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,unidads,unidadParameterGeneral,unidadReturnGeneral);
			
			this.connexion.commit();
			
			return unidadReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public UnidadParameterReturnGeneral procesarEventosUnidads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Unidad> unidads,Unidad unidad,UnidadParameterReturnGeneral unidadParameterGeneral,Boolean isEsNuevoUnidad,ArrayList<Classe> clases)throws Exception {
		 try {	
			UnidadParameterReturnGeneral unidadReturnGeneral=new UnidadParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				unidadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			UnidadLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,unidads,unidad,unidadParameterGeneral,unidadReturnGeneral,isEsNuevoUnidad,clases);
			
			return unidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public UnidadParameterReturnGeneral procesarEventosUnidadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Unidad> unidads,Unidad unidad,UnidadParameterReturnGeneral unidadParameterGeneral,Boolean isEsNuevoUnidad,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-procesarEventosUnidadsWithConnection");connexion.begin();			
			
			UnidadParameterReturnGeneral unidadReturnGeneral=new UnidadParameterReturnGeneral();
	
			unidadReturnGeneral.setUnidad(unidad);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				unidadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			UnidadLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,unidads,unidad,unidadParameterGeneral,unidadReturnGeneral,isEsNuevoUnidad,clases);
			
			this.connexion.commit();
			
			return unidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public UnidadParameterReturnGeneral procesarImportacionUnidadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,UnidadParameterReturnGeneral unidadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-procesarImportacionUnidadsWithConnection");connexion.begin();			
			
			UnidadParameterReturnGeneral unidadReturnGeneral=new UnidadParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.unidads=new ArrayList<Unidad>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.unidad=new Unidad();
				
				
				if(conColumnasBase) {this.unidad.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.unidad.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.unidad.setnombre(arrColumnas[iColumn++]);
				this.unidad.setsiglas(arrColumnas[iColumn++]);
				
				this.unidads.add(this.unidad);
			}
			
			this.saveUnidads();
			
			this.connexion.commit();
			
			unidadReturnGeneral.setConRetornoEstaProcesado(true);
			unidadReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return unidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarUnidadsEliminados() throws Exception {				
		
		List<Unidad> unidadsAux= new ArrayList<Unidad>();
		
		for(Unidad unidad:unidads) {
			if(!unidad.getIsDeleted()) {
				unidadsAux.add(unidad);
			}
		}
		
		unidads=unidadsAux;
	}
	
	public void quitarUnidadsNulos() throws Exception {				
		
		List<Unidad> unidadsAux= new ArrayList<Unidad>();
		
		for(Unidad unidad : this.unidads) {
			if(unidad==null) {
				unidadsAux.add(unidad);
			}
		}
		
		//this.unidads=unidadsAux;
		
		this.unidads.removeAll(unidadsAux);
	}
	
	public void getSetVersionRowUnidadWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(unidad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((unidad.getIsDeleted() || (unidad.getIsChanged()&&!unidad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=unidadDataAccess.getSetVersionRowUnidad(connexion,unidad.getId());
				
				if(!unidad.getVersionRow().equals(timestamp)) {	
					unidad.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				unidad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowUnidad()throws Exception {	
		
		if(unidad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((unidad.getIsDeleted() || (unidad.getIsChanged()&&!unidad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=unidadDataAccess.getSetVersionRowUnidad(connexion,unidad.getId());
			
			try {							
				if(!unidad.getVersionRow().equals(timestamp)) {	
					unidad.setVersionRow(timestamp);
				}
				
				unidad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowUnidadsWithConnection()throws Exception {	
		if(unidads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Unidad unidadAux:unidads) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(unidadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(unidadAux.getIsDeleted() || (unidadAux.getIsChanged()&&!unidadAux.getIsNew())) {
						
						timestamp=unidadDataAccess.getSetVersionRowUnidad(connexion,unidadAux.getId());
						
						if(!unidad.getVersionRow().equals(timestamp)) {	
							unidadAux.setVersionRow(timestamp);
						}
								
						unidadAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowUnidads()throws Exception {	
		if(unidads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Unidad unidadAux:unidads) {
					if(unidadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(unidadAux.getIsDeleted() || (unidadAux.getIsChanged()&&!unidadAux.getIsNew())) {
						
						timestamp=unidadDataAccess.getSetVersionRowUnidad(connexion,unidadAux.getId());
						
						if(!unidadAux.getVersionRow().equals(timestamp)) {	
							unidadAux.setVersionRow(timestamp);
						}
						
													
						unidadAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public UnidadParameterReturnGeneral cargarCombosLoteForeignKeyUnidadWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoUnidad) throws Exception {
		UnidadParameterReturnGeneral  unidadReturnGeneral =new UnidadParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-cargarCombosLoteForeignKeyUnidadWithConnection");connexion.begin();
			
			unidadReturnGeneral =new UnidadParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			unidadReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoUnidad> tipounidadsForeignKey=new ArrayList<TipoUnidad>();
			TipoUnidadLogic tipounidadLogic=new TipoUnidadLogic();
			tipounidadLogic.setConnexion(this.connexion);
			tipounidadLogic.getTipoUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoUnidad.equals("NONE")) {
				tipounidadLogic.getTodosTipoUnidads(finalQueryGlobalTipoUnidad,new Pagination());
				tipounidadsForeignKey=tipounidadLogic.getTipoUnidads();
			}

			unidadReturnGeneral.settipounidadsForeignKey(tipounidadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return unidadReturnGeneral;
	}
	
	public UnidadParameterReturnGeneral cargarCombosLoteForeignKeyUnidad(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoUnidad) throws Exception {
		UnidadParameterReturnGeneral  unidadReturnGeneral =new UnidadParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			unidadReturnGeneral =new UnidadParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			unidadReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoUnidad> tipounidadsForeignKey=new ArrayList<TipoUnidad>();
			TipoUnidadLogic tipounidadLogic=new TipoUnidadLogic();
			tipounidadLogic.setConnexion(this.connexion);
			tipounidadLogic.getTipoUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoUnidad.equals("NONE")) {
				tipounidadLogic.getTodosTipoUnidads(finalQueryGlobalTipoUnidad,new Pagination());
				tipounidadsForeignKey=tipounidadLogic.getTipoUnidads();
			}

			unidadReturnGeneral.settipounidadsForeignKey(tipounidadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return unidadReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyUnidadWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ProductoLogic productoLogic=new ProductoLogic();
			ConversionInvenLogic conversioninvenLogic=new ConversionInvenLogic();
			RangoUnidadVentaLogic rangounidadventaLogic=new RangoUnidadVentaLogic();
			ValorPorUnidadLogic valorporunidadLogic=new ValorPorUnidadLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyUnidadWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Producto.class));
			classes.add(new Classe(ConversionInven.class));
			classes.add(new Classe(RangoUnidadVenta.class));
			classes.add(new Classe(ValorPorUnidad.class));
											
			

			productoLogic.setConnexion(this.getConnexion());
			productoLogic.setDatosCliente(this.datosCliente);
			productoLogic.setIsConRefrescarForeignKeys(true);

			conversioninvenLogic.setConnexion(this.getConnexion());
			conversioninvenLogic.setDatosCliente(this.datosCliente);
			conversioninvenLogic.setIsConRefrescarForeignKeys(true);

			rangounidadventaLogic.setConnexion(this.getConnexion());
			rangounidadventaLogic.setDatosCliente(this.datosCliente);
			rangounidadventaLogic.setIsConRefrescarForeignKeys(true);

			valorporunidadLogic.setConnexion(this.getConnexion());
			valorporunidadLogic.setDatosCliente(this.datosCliente);
			valorporunidadLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Unidad unidad:this.unidads) {
				

				classes=new ArrayList<Classe>();
				classes=ProductoConstantesFunciones.getClassesForeignKeysOfProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoLogic.setProductos(unidad.productos);
				productoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ConversionInvenConstantesFunciones.getClassesForeignKeysOfConversionInven(new ArrayList<Classe>(),DeepLoadType.NONE);

				conversioninvenLogic.setConversionInvens(unidad.conversioninvenConversions);
				conversioninvenLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=RangoUnidadVentaConstantesFunciones.getClassesForeignKeysOfRangoUnidadVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				rangounidadventaLogic.setRangoUnidadVentas(unidad.rangounidadventas);
				rangounidadventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ValorPorUnidadConstantesFunciones.getClassesForeignKeysOfValorPorUnidad(new ArrayList<Classe>(),DeepLoadType.NONE);

				valorporunidadLogic.setValorPorUnidads(unidad.valorporunidads);
				valorporunidadLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Unidad unidad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			UnidadLogicAdditional.updateUnidadToGet(unidad,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		unidad.setEmpresa(unidadDataAccess.getEmpresa(connexion,unidad));
		unidad.setTipoUnidad(unidadDataAccess.getTipoUnidad(connexion,unidad));
		unidad.setProductos(unidadDataAccess.getProductos(connexion,unidad));
		unidad.setConversionInvenConversions(unidadDataAccess.getConversionInvenConversions(connexion,unidad));
		unidad.setRangoUnidadVentas(unidadDataAccess.getRangoUnidadVentas(connexion,unidad));
		unidad.setValorPorUnidads(unidadDataAccess.getValorPorUnidads(connexion,unidad));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				unidad.setEmpresa(unidadDataAccess.getEmpresa(connexion,unidad));
				continue;
			}

			if(clas.clas.equals(TipoUnidad.class)) {
				unidad.setTipoUnidad(unidadDataAccess.getTipoUnidad(connexion,unidad));
				continue;
			}

			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				unidad.setProductos(unidadDataAccess.getProductos(connexion,unidad));

				if(this.isConDeep) {
					ProductoLogic productoLogic= new ProductoLogic(this.connexion);
					productoLogic.setProductos(unidad.getProductos());
					ArrayList<Classe> classesLocal=ProductoConstantesFunciones.getClassesForeignKeysOfProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(productoLogic.getProductos());
					unidad.setProductos(productoLogic.getProductos());
				}

				continue;
			}

			if(clas.clas.equals(ConversionInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				unidad.setConversionInvenConversions(unidadDataAccess.getConversionInvenConversions(connexion,unidad));

				if(this.isConDeep) {
					ConversionInvenLogic conversioninvenLogic= new ConversionInvenLogic(this.connexion);
					conversioninvenLogic.setConversionInvens(unidad.getConversionInvenConversions());
					ArrayList<Classe> classesLocal=ConversionInvenConstantesFunciones.getClassesForeignKeysOfConversionInven(new ArrayList<Classe>(),DeepLoadType.NONE);
					conversioninvenLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(conversioninvenLogic.getConversionInvens());
					unidad.setConversionInvenConversions(conversioninvenLogic.getConversionInvens());
				}

				continue;
			}

			if(clas.clas.equals(RangoUnidadVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				unidad.setRangoUnidadVentas(unidadDataAccess.getRangoUnidadVentas(connexion,unidad));

				if(this.isConDeep) {
					RangoUnidadVentaLogic rangounidadventaLogic= new RangoUnidadVentaLogic(this.connexion);
					rangounidadventaLogic.setRangoUnidadVentas(unidad.getRangoUnidadVentas());
					ArrayList<Classe> classesLocal=RangoUnidadVentaConstantesFunciones.getClassesForeignKeysOfRangoUnidadVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					rangounidadventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RangoUnidadVentaConstantesFunciones.refrescarForeignKeysDescripcionesRangoUnidadVenta(rangounidadventaLogic.getRangoUnidadVentas());
					unidad.setRangoUnidadVentas(rangounidadventaLogic.getRangoUnidadVentas());
				}

				continue;
			}

			if(clas.clas.equals(ValorPorUnidad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				unidad.setValorPorUnidads(unidadDataAccess.getValorPorUnidads(connexion,unidad));

				if(this.isConDeep) {
					ValorPorUnidadLogic valorporunidadLogic= new ValorPorUnidadLogic(this.connexion);
					valorporunidadLogic.setValorPorUnidads(unidad.getValorPorUnidads());
					ArrayList<Classe> classesLocal=ValorPorUnidadConstantesFunciones.getClassesForeignKeysOfValorPorUnidad(new ArrayList<Classe>(),DeepLoadType.NONE);
					valorporunidadLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(valorporunidadLogic.getValorPorUnidads());
					unidad.setValorPorUnidads(valorporunidadLogic.getValorPorUnidads());
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
			unidad.setEmpresa(unidadDataAccess.getEmpresa(connexion,unidad));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoUnidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			unidad.setTipoUnidad(unidadDataAccess.getTipoUnidad(connexion,unidad));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Producto.class));
			unidad.setProductos(unidadDataAccess.getProductos(connexion,unidad));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ConversionInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ConversionInven.class));
			unidad.setConversionInvenConversions(unidadDataAccess.getConversionInvenConversions(connexion,unidad));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RangoUnidadVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RangoUnidadVenta.class));
			unidad.setRangoUnidadVentas(unidadDataAccess.getRangoUnidadVentas(connexion,unidad));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ValorPorUnidad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ValorPorUnidad.class));
			unidad.setValorPorUnidads(unidadDataAccess.getValorPorUnidads(connexion,unidad));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		unidad.setEmpresa(unidadDataAccess.getEmpresa(connexion,unidad));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(unidad.getEmpresa(),isDeep,deepLoadType,clases);
				
		unidad.setTipoUnidad(unidadDataAccess.getTipoUnidad(connexion,unidad));
		TipoUnidadLogic tipounidadLogic= new TipoUnidadLogic(connexion);
		tipounidadLogic.deepLoad(unidad.getTipoUnidad(),isDeep,deepLoadType,clases);
				

		unidad.setProductos(unidadDataAccess.getProductos(connexion,unidad));

		for(Producto producto:unidad.getProductos()) {
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(producto,isDeep,deepLoadType,clases);
		}

		unidad.setConversionInvenConversions(unidadDataAccess.getConversionInvenConversions(connexion,unidad));

		for(ConversionInven conversioninven:unidad.getConversionInvenConversions()) {
			ConversionInvenLogic conversioninvenLogic= new ConversionInvenLogic(connexion);
			conversioninvenLogic.deepLoad(conversioninven,isDeep,deepLoadType,clases);
		}

		unidad.setRangoUnidadVentas(unidadDataAccess.getRangoUnidadVentas(connexion,unidad));

		for(RangoUnidadVenta rangounidadventa:unidad.getRangoUnidadVentas()) {
			RangoUnidadVentaLogic rangounidadventaLogic= new RangoUnidadVentaLogic(connexion);
			rangounidadventaLogic.deepLoad(rangounidadventa,isDeep,deepLoadType,clases);
		}

		unidad.setValorPorUnidads(unidadDataAccess.getValorPorUnidads(connexion,unidad));

		for(ValorPorUnidad valorporunidad:unidad.getValorPorUnidads()) {
			ValorPorUnidadLogic valorporunidadLogic= new ValorPorUnidadLogic(connexion);
			valorporunidadLogic.deepLoad(valorporunidad,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				unidad.setEmpresa(unidadDataAccess.getEmpresa(connexion,unidad));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(unidad.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoUnidad.class)) {
				unidad.setTipoUnidad(unidadDataAccess.getTipoUnidad(connexion,unidad));
				TipoUnidadLogic tipounidadLogic= new TipoUnidadLogic(connexion);
				tipounidadLogic.deepLoad(unidad.getTipoUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				unidad.setProductos(unidadDataAccess.getProductos(connexion,unidad));

				for(Producto producto:unidad.getProductos()) {
					ProductoLogic productoLogic= new ProductoLogic(connexion);
					productoLogic.deepLoad(producto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ConversionInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				unidad.setConversionInvenConversions(unidadDataAccess.getConversionInvenConversions(connexion,unidad));

				for(ConversionInven conversioninven:unidad.getConversionInvenConversions()) {
					ConversionInvenLogic conversioninvenLogic= new ConversionInvenLogic(connexion);
					conversioninvenLogic.deepLoad(conversioninven,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RangoUnidadVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				unidad.setRangoUnidadVentas(unidadDataAccess.getRangoUnidadVentas(connexion,unidad));

				for(RangoUnidadVenta rangounidadventa:unidad.getRangoUnidadVentas()) {
					RangoUnidadVentaLogic rangounidadventaLogic= new RangoUnidadVentaLogic(connexion);
					rangounidadventaLogic.deepLoad(rangounidadventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ValorPorUnidad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				unidad.setValorPorUnidads(unidadDataAccess.getValorPorUnidads(connexion,unidad));

				for(ValorPorUnidad valorporunidad:unidad.getValorPorUnidads()) {
					ValorPorUnidadLogic valorporunidadLogic= new ValorPorUnidadLogic(connexion);
					valorporunidadLogic.deepLoad(valorporunidad,isDeep,deepLoadType,clases);
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
			unidad.setEmpresa(unidadDataAccess.getEmpresa(connexion,unidad));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(unidad.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoUnidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			unidad.setTipoUnidad(unidadDataAccess.getTipoUnidad(connexion,unidad));
			TipoUnidadLogic tipounidadLogic= new TipoUnidadLogic(connexion);
			tipounidadLogic.deepLoad(unidad.getTipoUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Producto.class));
			unidad.setProductos(unidadDataAccess.getProductos(connexion,unidad));

			for(Producto producto:unidad.getProductos()) {
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(producto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ConversionInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ConversionInven.class));
			unidad.setConversionInvenConversions(unidadDataAccess.getConversionInvenConversions(connexion,unidad));

			for(ConversionInven conversioninven:unidad.getConversionInvenConversions()) {
				ConversionInvenLogic conversioninvenLogic= new ConversionInvenLogic(connexion);
				conversioninvenLogic.deepLoad(conversioninven,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RangoUnidadVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RangoUnidadVenta.class));
			unidad.setRangoUnidadVentas(unidadDataAccess.getRangoUnidadVentas(connexion,unidad));

			for(RangoUnidadVenta rangounidadventa:unidad.getRangoUnidadVentas()) {
				RangoUnidadVentaLogic rangounidadventaLogic= new RangoUnidadVentaLogic(connexion);
				rangounidadventaLogic.deepLoad(rangounidadventa,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ValorPorUnidad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ValorPorUnidad.class));
			unidad.setValorPorUnidads(unidadDataAccess.getValorPorUnidads(connexion,unidad));

			for(ValorPorUnidad valorporunidad:unidad.getValorPorUnidads()) {
				ValorPorUnidadLogic valorporunidadLogic= new ValorPorUnidadLogic(connexion);
				valorporunidadLogic.deepLoad(valorporunidad,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Unidad unidad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			UnidadLogicAdditional.updateUnidadToSave(unidad,this.arrDatoGeneral);
			
UnidadDataAccess.save(unidad, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(unidad.getEmpresa(),connexion);

		TipoUnidadDataAccess.save(unidad.getTipoUnidad(),connexion);

		for(Producto producto:unidad.getProductos()) {
			producto.setid_unidad(unidad.getId());
			ProductoDataAccess.save(producto,connexion);
		}

		for(ConversionInven conversioninven:unidad.getConversionInvenConversions()) {
			conversioninven.setid_unidad_conversion(unidad.getId());
			ConversionInvenDataAccess.save(conversioninven,connexion);
		}

		for(RangoUnidadVenta rangounidadventa:unidad.getRangoUnidadVentas()) {
			rangounidadventa.setid_unidad(unidad.getId());
			RangoUnidadVentaDataAccess.save(rangounidadventa,connexion);
		}

		for(ValorPorUnidad valorporunidad:unidad.getValorPorUnidads()) {
			valorporunidad.setid_unidad(unidad.getId());
			ValorPorUnidadDataAccess.save(valorporunidad,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(unidad.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoUnidad.class)) {
				TipoUnidadDataAccess.save(unidad.getTipoUnidad(),connexion);
				continue;
			}


			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Producto producto:unidad.getProductos()) {
					producto.setid_unidad(unidad.getId());
					ProductoDataAccess.save(producto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ConversionInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ConversionInven conversioninven:unidad.getConversionInvenConversions()) {
					conversioninven.setid_unidad_conversion(unidad.getId());
					ConversionInvenDataAccess.save(conversioninven,connexion);
				}
				continue;
			}

			if(clas.clas.equals(RangoUnidadVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RangoUnidadVenta rangounidadventa:unidad.getRangoUnidadVentas()) {
					rangounidadventa.setid_unidad(unidad.getId());
					RangoUnidadVentaDataAccess.save(rangounidadventa,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ValorPorUnidad.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ValorPorUnidad valorporunidad:unidad.getValorPorUnidads()) {
					valorporunidad.setid_unidad(unidad.getId());
					ValorPorUnidadDataAccess.save(valorporunidad,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(unidad.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(unidad.getEmpresa(),isDeep,deepLoadType,clases);
				

		TipoUnidadDataAccess.save(unidad.getTipoUnidad(),connexion);
		TipoUnidadLogic tipounidadLogic= new TipoUnidadLogic(connexion);
		tipounidadLogic.deepLoad(unidad.getTipoUnidad(),isDeep,deepLoadType,clases);
				

		for(Producto producto:unidad.getProductos()) {
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			producto.setid_unidad(unidad.getId());
			ProductoDataAccess.save(producto,connexion);
			productoLogic.deepSave(producto,isDeep,deepLoadType,clases);
		}

		for(ConversionInven conversioninven:unidad.getConversionInvenConversions()) {
			ConversionInvenLogic conversioninvenLogic= new ConversionInvenLogic(connexion);
			conversioninven.setid_unidad_conversion(unidad.getId());
			ConversionInvenDataAccess.save(conversioninven,connexion);
			conversioninvenLogic.deepSave(conversioninven,isDeep,deepLoadType,clases);
		}

		for(RangoUnidadVenta rangounidadventa:unidad.getRangoUnidadVentas()) {
			RangoUnidadVentaLogic rangounidadventaLogic= new RangoUnidadVentaLogic(connexion);
			rangounidadventa.setid_unidad(unidad.getId());
			RangoUnidadVentaDataAccess.save(rangounidadventa,connexion);
			rangounidadventaLogic.deepSave(rangounidadventa,isDeep,deepLoadType,clases);
		}

		for(ValorPorUnidad valorporunidad:unidad.getValorPorUnidads()) {
			ValorPorUnidadLogic valorporunidadLogic= new ValorPorUnidadLogic(connexion);
			valorporunidad.setid_unidad(unidad.getId());
			ValorPorUnidadDataAccess.save(valorporunidad,connexion);
			valorporunidadLogic.deepSave(valorporunidad,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(unidad.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(unidad.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoUnidad.class)) {
				TipoUnidadDataAccess.save(unidad.getTipoUnidad(),connexion);
				TipoUnidadLogic tipounidadLogic= new TipoUnidadLogic(connexion);
				tipounidadLogic.deepSave(unidad.getTipoUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Producto producto:unidad.getProductos()) {
					ProductoLogic productoLogic= new ProductoLogic(connexion);
					producto.setid_unidad(unidad.getId());
					ProductoDataAccess.save(producto,connexion);
					productoLogic.deepSave(producto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ConversionInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ConversionInven conversioninven:unidad.getConversionInvenConversions()) {
					ConversionInvenLogic conversioninvenLogic= new ConversionInvenLogic(connexion);
					conversioninven.setid_unidad_conversion(unidad.getId());
					ConversionInvenDataAccess.save(conversioninven,connexion);
					conversioninvenLogic.deepSave(conversioninven,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RangoUnidadVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RangoUnidadVenta rangounidadventa:unidad.getRangoUnidadVentas()) {
					RangoUnidadVentaLogic rangounidadventaLogic= new RangoUnidadVentaLogic(connexion);
					rangounidadventa.setid_unidad(unidad.getId());
					RangoUnidadVentaDataAccess.save(rangounidadventa,connexion);
					rangounidadventaLogic.deepSave(rangounidadventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ValorPorUnidad.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ValorPorUnidad valorporunidad:unidad.getValorPorUnidads()) {
					ValorPorUnidadLogic valorporunidadLogic= new ValorPorUnidadLogic(connexion);
					valorporunidad.setid_unidad(unidad.getId());
					ValorPorUnidadDataAccess.save(valorporunidad,connexion);
					valorporunidadLogic.deepSave(valorporunidad,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Unidad.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(unidad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(unidad);
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
			this.deepLoad(this.unidad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Unidad.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(unidads!=null) {
				for(Unidad unidad:unidads) {
					this.deepLoad(unidad,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(unidads);
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
			if(unidads!=null) {
				for(Unidad unidad:unidads) {
					this.deepLoad(unidad,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(unidads);
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
			this.getNewConnexionToDeep(Unidad.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(unidad,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Unidad.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(unidads!=null) {
				for(Unidad unidad:unidads) {
					this.deepSave(unidad,isDeep,deepLoadType,clases);
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
			if(unidads!=null) {
				for(Unidad unidad:unidads) {
					this.deepSave(unidad,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getUnidadsBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",UnidadConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			unidads=unidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUnidadsBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",UnidadConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			unidads=unidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidads);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUnidadsBusquedaPorSiglasWithConnection(String sFinalQuery,Pagination pagination,String siglas)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralSiglas= new ParameterSelectionGeneral();
			parameterSelectionGeneralSiglas.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+siglas+"%",UnidadConstantesFunciones.SIGLAS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralSiglas);

			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorSiglas","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			unidads=unidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUnidadsBusquedaPorSiglas(String sFinalQuery,Pagination pagination,String siglas)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralSiglas= new ParameterSelectionGeneral();
			parameterSelectionGeneralSiglas.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+siglas+"%",UnidadConstantesFunciones.SIGLAS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralSiglas);

			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorSiglas","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			unidads=unidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidads);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUnidadsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,UnidadConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			unidads=unidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUnidadsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,UnidadConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			unidads=unidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidads);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUnidadsFK_IdTipoUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_unidad,UnidadConstantesFunciones.IDTIPOUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoUnidad);

			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			unidads=unidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUnidadsFK_IdTipoUnidad(String sFinalQuery,Pagination pagination,Long id_tipo_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_unidad,UnidadConstantesFunciones.IDTIPOUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoUnidad);

			UnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			unidads=unidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidads);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUnidadPorNombreWithConnection(Long id_empresa,String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Unidad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,UnidadConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,UnidadConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			unidad=unidadDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.unidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidad);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUnidadPorNombre(Long id_empresa,String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,UnidadConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,UnidadConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			unidad=unidadDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.unidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(this.unidad);
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
			if(UnidadConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,UnidadDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Unidad unidad,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(UnidadConstantesFunciones.ISCONAUDITORIA) {
				if(unidad.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UnidadDataAccess.TABLENAME, unidad.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(UnidadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////UnidadLogic.registrarAuditoriaDetallesUnidad(connexion,unidad,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(unidad.getIsDeleted()) {
					/*if(!unidad.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,UnidadDataAccess.TABLENAME, unidad.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////UnidadLogic.registrarAuditoriaDetallesUnidad(connexion,unidad,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UnidadDataAccess.TABLENAME, unidad.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(unidad.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UnidadDataAccess.TABLENAME, unidad.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(UnidadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////UnidadLogic.registrarAuditoriaDetallesUnidad(connexion,unidad,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesUnidad(Connexion connexion,Unidad unidad)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(unidad.getIsNew()||!unidad.getid_empresa().equals(unidad.getUnidadOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(unidad.getUnidadOriginal().getid_empresa()!=null)
				{
					strValorActual=unidad.getUnidadOriginal().getid_empresa().toString();
				}
				if(unidad.getid_empresa()!=null)
				{
					strValorNuevo=unidad.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UnidadConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(unidad.getIsNew()||!unidad.getid_tipo_unidad().equals(unidad.getUnidadOriginal().getid_tipo_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(unidad.getUnidadOriginal().getid_tipo_unidad()!=null)
				{
					strValorActual=unidad.getUnidadOriginal().getid_tipo_unidad().toString();
				}
				if(unidad.getid_tipo_unidad()!=null)
				{
					strValorNuevo=unidad.getid_tipo_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UnidadConstantesFunciones.IDTIPOUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(unidad.getIsNew()||!unidad.getnombre().equals(unidad.getUnidadOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(unidad.getUnidadOriginal().getnombre()!=null)
				{
					strValorActual=unidad.getUnidadOriginal().getnombre();
				}
				if(unidad.getnombre()!=null)
				{
					strValorNuevo=unidad.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UnidadConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(unidad.getIsNew()||!unidad.getsiglas().equals(unidad.getUnidadOriginal().getsiglas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(unidad.getUnidadOriginal().getsiglas()!=null)
				{
					strValorActual=unidad.getUnidadOriginal().getsiglas();
				}
				if(unidad.getsiglas()!=null)
				{
					strValorNuevo=unidad.getsiglas() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UnidadConstantesFunciones.SIGLAS,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveUnidadRelacionesWithConnection(Unidad unidad,List<Producto> productos,List<ConversionInven> conversioninvenConversions,List<RangoUnidadVenta> rangounidadventas,List<ValorPorUnidad> valorporunidads) throws Exception {

		if(!unidad.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveUnidadRelacionesBase(unidad,productos,conversioninvenConversions,rangounidadventas,valorporunidads,true);
		}
	}

	public void saveUnidadRelaciones(Unidad unidad,List<Producto> productos,List<ConversionInven> conversioninvenConversions,List<RangoUnidadVenta> rangounidadventas,List<ValorPorUnidad> valorporunidads)throws Exception {

		if(!unidad.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveUnidadRelacionesBase(unidad,productos,conversioninvenConversions,rangounidadventas,valorporunidads,false);
		}
	}

	public void saveUnidadRelacionesBase(Unidad unidad,List<Producto> productos,List<ConversionInven> conversioninvenConversions,List<RangoUnidadVenta> rangounidadventas,List<ValorPorUnidad> valorporunidads,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Unidad-saveRelacionesWithConnection");}
	
			unidad.setProductos(productos);
			unidad.setConversionInvenConversions(conversioninvenConversions);
			unidad.setRangoUnidadVentas(rangounidadventas);
			unidad.setValorPorUnidads(valorporunidads);

			this.setUnidad(unidad);

			if(UnidadLogicAdditional.validarSaveRelaciones(unidad,this)) {

				UnidadLogicAdditional.updateRelacionesToSave(unidad,this);

				if((unidad.getIsNew()||unidad.getIsChanged())&&!unidad.getIsDeleted()) {
					this.saveUnidad();
					this.saveUnidadRelacionesDetalles(productos,conversioninvenConversions,rangounidadventas,valorporunidads);

				} else if(unidad.getIsDeleted()) {
					this.saveUnidadRelacionesDetalles(productos,conversioninvenConversions,rangounidadventas,valorporunidads);
					this.saveUnidad();
				}

				UnidadLogicAdditional.updateRelacionesToSaveAfter(unidad,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresProductos(productos,true,true);
			ConversionInvenConstantesFunciones.InicializarGeneralEntityAuxiliaresConversionInvens(conversioninvenConversions,true,true);
			RangoUnidadVentaConstantesFunciones.InicializarGeneralEntityAuxiliaresRangoUnidadVentas(rangounidadventas,true,true);
			ValorPorUnidadConstantesFunciones.InicializarGeneralEntityAuxiliaresValorPorUnidads(valorporunidads,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveUnidadRelacionesDetalles(List<Producto> productos,List<ConversionInven> conversioninvenConversions,List<RangoUnidadVenta> rangounidadventas,List<ValorPorUnidad> valorporunidads)throws Exception {
		try {
	

			Long idUnidadActual=this.getUnidad().getId();

			ProductoLogic productoLogic_Desde_Unidad=new ProductoLogic();
			productoLogic_Desde_Unidad.setProductos(productos);

			productoLogic_Desde_Unidad.setConnexion(this.getConnexion());
			productoLogic_Desde_Unidad.setDatosCliente(this.datosCliente);

			for(Producto producto_Desde_Unidad:productoLogic_Desde_Unidad.getProductos()) {
				producto_Desde_Unidad.setid_unidad(idUnidadActual);

				productoLogic_Desde_Unidad.setProducto(producto_Desde_Unidad);
				productoLogic_Desde_Unidad.saveProducto();
			}


			ConversionInvenLogic conversioninvenConversionLogic_Desde_Unidad=new ConversionInvenLogic();
			conversioninvenConversionLogic_Desde_Unidad.setConversionInvens(conversioninvenConversions);

			conversioninvenConversionLogic_Desde_Unidad.setConnexion(this.getConnexion());
			conversioninvenConversionLogic_Desde_Unidad.setDatosCliente(this.datosCliente);

			for(ConversionInven conversioninven_Desde_Unidad:conversioninvenConversionLogic_Desde_Unidad.getConversionInvens()) {
				conversioninven_Desde_Unidad.setid_unidad_conversion(idUnidadActual);
			}

			conversioninvenConversionLogic_Desde_Unidad.saveConversionInvens();

			RangoUnidadVentaLogic rangounidadventaLogic_Desde_Unidad=new RangoUnidadVentaLogic();
			rangounidadventaLogic_Desde_Unidad.setRangoUnidadVentas(rangounidadventas);

			rangounidadventaLogic_Desde_Unidad.setConnexion(this.getConnexion());
			rangounidadventaLogic_Desde_Unidad.setDatosCliente(this.datosCliente);

			for(RangoUnidadVenta rangounidadventa_Desde_Unidad:rangounidadventaLogic_Desde_Unidad.getRangoUnidadVentas()) {
				rangounidadventa_Desde_Unidad.setid_unidad(idUnidadActual);

				rangounidadventaLogic_Desde_Unidad.setRangoUnidadVenta(rangounidadventa_Desde_Unidad);
				rangounidadventaLogic_Desde_Unidad.saveRangoUnidadVenta();

				Long idRangoUnidadVentaActual=rangounidadventa_Desde_Unidad.getId();

				PrecioLogic precioLogic_Desde_RangoUnidadVenta=new PrecioLogic();

				if(rangounidadventa_Desde_Unidad.getPrecios()==null){
					rangounidadventa_Desde_Unidad.setPrecios(new ArrayList<Precio>());
				}

				precioLogic_Desde_RangoUnidadVenta.setPrecios(rangounidadventa_Desde_Unidad.getPrecios());

				precioLogic_Desde_RangoUnidadVenta.setConnexion(this.getConnexion());
				precioLogic_Desde_RangoUnidadVenta.setDatosCliente(this.datosCliente);

				for(Precio precio_Desde_RangoUnidadVenta:precioLogic_Desde_RangoUnidadVenta.getPrecios()) {
					precio_Desde_RangoUnidadVenta.setid_rango_unidad_venta(idRangoUnidadVentaActual);
				}

				precioLogic_Desde_RangoUnidadVenta.savePrecios();

				ParametroInventarioDefectoLogic parametroinventariodefectoLogic_Desde_RangoUnidadVenta=new ParametroInventarioDefectoLogic();

				if(rangounidadventa_Desde_Unidad.getParametroInventarioDefectos()==null){
					rangounidadventa_Desde_Unidad.setParametroInventarioDefectos(new ArrayList<ParametroInventarioDefecto>());
				}

				parametroinventariodefectoLogic_Desde_RangoUnidadVenta.setParametroInventarioDefectos(rangounidadventa_Desde_Unidad.getParametroInventarioDefectos());

				parametroinventariodefectoLogic_Desde_RangoUnidadVenta.setConnexion(this.getConnexion());
				parametroinventariodefectoLogic_Desde_RangoUnidadVenta.setDatosCliente(this.datosCliente);

				for(ParametroInventarioDefecto parametroinventariodefecto_Desde_RangoUnidadVenta:parametroinventariodefectoLogic_Desde_RangoUnidadVenta.getParametroInventarioDefectos()) {
					parametroinventariodefecto_Desde_RangoUnidadVenta.setid_rango_unidad_venta(idRangoUnidadVentaActual);
				}

				parametroinventariodefectoLogic_Desde_RangoUnidadVenta.saveParametroInventarioDefectos();
			}


			ValorPorUnidadLogic valorporunidadLogic_Desde_Unidad=new ValorPorUnidadLogic();
			valorporunidadLogic_Desde_Unidad.setValorPorUnidads(valorporunidads);

			valorporunidadLogic_Desde_Unidad.setConnexion(this.getConnexion());
			valorporunidadLogic_Desde_Unidad.setDatosCliente(this.datosCliente);

			for(ValorPorUnidad valorporunidad_Desde_Unidad:valorporunidadLogic_Desde_Unidad.getValorPorUnidads()) {
				valorporunidad_Desde_Unidad.setid_unidad(idUnidadActual);
			}

			valorporunidadLogic_Desde_Unidad.saveValorPorUnidads();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=UnidadConstantesFunciones.getClassesForeignKeysOfUnidad(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=UnidadConstantesFunciones.getClassesRelationshipsOfUnidad(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

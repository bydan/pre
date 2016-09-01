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
import com.bydan.erp.inventario.util.TipoUnidadConstantesFunciones;
import com.bydan.erp.inventario.util.TipoUnidadParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoUnidadParameterGeneral;
import com.bydan.erp.inventario.business.entity.TipoUnidad;
import com.bydan.erp.inventario.business.logic.TipoUnidadLogicAdditional;
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
public class TipoUnidadLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoUnidadLogic.class);
	
	protected TipoUnidadDataAccess tipounidadDataAccess; 	
	protected TipoUnidad tipounidad;
	protected List<TipoUnidad> tipounidads;
	protected Object tipounidadObject;	
	protected List<Object> tipounidadsObject;
	
	public static ClassValidator<TipoUnidad> tipounidadValidator = new ClassValidator<TipoUnidad>(TipoUnidad.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoUnidadLogicAdditional tipounidadLogicAdditional=null;
	
	public TipoUnidadLogicAdditional getTipoUnidadLogicAdditional() {
		return this.tipounidadLogicAdditional;
	}
	
	public void setTipoUnidadLogicAdditional(TipoUnidadLogicAdditional tipounidadLogicAdditional) {
		try {
			this.tipounidadLogicAdditional=tipounidadLogicAdditional;
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
	
	
	
	
	public  TipoUnidadLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipounidadDataAccess = new TipoUnidadDataAccess();
			
			this.tipounidads= new ArrayList<TipoUnidad>();
			this.tipounidad= new TipoUnidad();
			
			this.tipounidadObject=new Object();
			this.tipounidadsObject=new ArrayList<Object>();
				
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
			
			this.tipounidadDataAccess.setConnexionType(this.connexionType);
			this.tipounidadDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoUnidadLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipounidadDataAccess = new TipoUnidadDataAccess();
			this.tipounidads= new ArrayList<TipoUnidad>();
			this.tipounidad= new TipoUnidad();
			this.tipounidadObject=new Object();
			this.tipounidadsObject=new ArrayList<Object>();
			
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
			
			this.tipounidadDataAccess.setConnexionType(this.connexionType);
			this.tipounidadDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoUnidad getTipoUnidad() throws Exception {	
		TipoUnidadLogicAdditional.checkTipoUnidadToGet(tipounidad,this.datosCliente,this.arrDatoGeneral);
		TipoUnidadLogicAdditional.updateTipoUnidadToGet(tipounidad,this.arrDatoGeneral);
		
		return tipounidad;
	}
		
	public void setTipoUnidad(TipoUnidad newTipoUnidad) {
		this.tipounidad = newTipoUnidad;
	}
	
	public TipoUnidadDataAccess getTipoUnidadDataAccess() {
		return tipounidadDataAccess;
	}
	
	public void setTipoUnidadDataAccess(TipoUnidadDataAccess newtipounidadDataAccess) {
		this.tipounidadDataAccess = newtipounidadDataAccess;
	}
	
	public List<TipoUnidad> getTipoUnidads() throws Exception {		
		this.quitarTipoUnidadsNulos();
		
		TipoUnidadLogicAdditional.checkTipoUnidadToGets(tipounidads,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoUnidad tipounidadLocal: tipounidads ) {
			TipoUnidadLogicAdditional.updateTipoUnidadToGet(tipounidadLocal,this.arrDatoGeneral);
		}
		
		return tipounidads;
	}
	
	public void setTipoUnidads(List<TipoUnidad> newTipoUnidads) {
		this.tipounidads = newTipoUnidads;
	}
	
	public Object getTipoUnidadObject() {	
		this.tipounidadObject=this.tipounidadDataAccess.getEntityObject();
		return this.tipounidadObject;
	}
		
	public void setTipoUnidadObject(Object newTipoUnidadObject) {
		this.tipounidadObject = newTipoUnidadObject;
	}
	
	public List<Object> getTipoUnidadsObject() {		
		this.tipounidadsObject=this.tipounidadDataAccess.getEntitiesObject();
		return this.tipounidadsObject;
	}
		
	public void setTipoUnidadsObject(List<Object> newTipoUnidadsObject) {
		this.tipounidadsObject = newTipoUnidadsObject;
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
		
		if(this.tipounidadDataAccess!=null) {
			this.tipounidadDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUnidad.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipounidadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipounidadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipounidad = new  TipoUnidad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUnidad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipounidad=tipounidadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipounidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidad);
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
		tipounidad = new  TipoUnidad();
		  		  
        try {
			
			tipounidad=tipounidadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipounidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipounidad = new  TipoUnidad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUnidad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipounidad=tipounidadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipounidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidad);
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
		tipounidad = new  TipoUnidad();
		  		  
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
		tipounidad = new  TipoUnidad();
		  		  
        try {
			
			tipounidad=tipounidadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipounidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipounidad = new  TipoUnidad();
		  		  
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
		tipounidad = new  TipoUnidad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUnidad.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipounidadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipounidad = new  TipoUnidad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipounidadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipounidad = new  TipoUnidad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUnidad.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipounidadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipounidad = new  TipoUnidad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipounidadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipounidad = new  TipoUnidad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUnidad.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipounidadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipounidad = new  TipoUnidad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipounidadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipounidads = new  ArrayList<TipoUnidad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUnidad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipounidads=tipounidadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoUnidad(tipounidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidads);
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
		tipounidads = new  ArrayList<TipoUnidad>();
		  		  
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
		tipounidads = new  ArrayList<TipoUnidad>();
		  		  
        try {			
			TipoUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipounidads=tipounidadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoUnidad(tipounidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipounidads = new  ArrayList<TipoUnidad>();
		  		  
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
		tipounidads = new  ArrayList<TipoUnidad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUnidad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipounidads=tipounidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoUnidad(tipounidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidads);
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
		tipounidads = new  ArrayList<TipoUnidad>();
		  		  
        try {
			TipoUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipounidads=tipounidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoUnidad(tipounidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidads);
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
		tipounidads = new  ArrayList<TipoUnidad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUnidad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipounidads=tipounidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoUnidad(tipounidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidads);
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
		tipounidads = new  ArrayList<TipoUnidad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipounidads=tipounidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoUnidad(tipounidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidads);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipounidad = new  TipoUnidad();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUnidad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipounidad=tipounidadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoUnidad(tipounidad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidad);
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
		tipounidad = new  TipoUnidad();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipounidad=tipounidadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoUnidad(tipounidad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipounidads = new  ArrayList<TipoUnidad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUnidad.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipounidads=tipounidadDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoUnidad(tipounidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidads);
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
		tipounidads = new  ArrayList<TipoUnidad>();
		  		  
        try {
			TipoUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipounidads=tipounidadDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoUnidad(tipounidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidads);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoUnidadsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipounidads = new  ArrayList<TipoUnidad>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUnidad.class.getSimpleName()+"-getTodosTipoUnidadsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipounidads=tipounidadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoUnidad(tipounidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidads);
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
	
	public  void  getTodosTipoUnidads(String sFinalQuery,Pagination pagination)throws Exception {
		tipounidads = new  ArrayList<TipoUnidad>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipounidads=tipounidadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoUnidad(tipounidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoUnidad(TipoUnidad tipounidad) throws Exception {
		Boolean estaValidado=false;
		
		if(tipounidad.getIsNew() || tipounidad.getIsChanged()) { 
			this.invalidValues = tipounidadValidator.getInvalidValues(tipounidad);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipounidad);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoUnidad(List<TipoUnidad> TipoUnidads) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoUnidad tipounidadLocal:tipounidads) {				
			estaValidadoObjeto=this.validarGuardarTipoUnidad(tipounidadLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoUnidad(List<TipoUnidad> TipoUnidads) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoUnidad(tipounidads)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoUnidad(TipoUnidad TipoUnidad) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoUnidad(tipounidad)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoUnidad tipounidad) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipounidad.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoUnidadConstantesFunciones.getTipoUnidadLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipounidad","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoUnidadConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoUnidadConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoUnidadWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUnidad.class.getSimpleName()+"-saveTipoUnidadWithConnection");connexion.begin();			
			
			TipoUnidadLogicAdditional.checkTipoUnidadToSave(this.tipounidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoUnidadLogicAdditional.updateTipoUnidadToSave(this.tipounidad,this.arrDatoGeneral);
			
			TipoUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipounidad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoUnidad();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoUnidad(this.tipounidad)) {
				TipoUnidadDataAccess.save(this.tipounidad, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipounidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoUnidadLogicAdditional.checkTipoUnidadToSaveAfter(this.tipounidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoUnidad();
			
			connexion.commit();			
			
			if(this.tipounidad.getIsDeleted()) {
				this.tipounidad=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoUnidad()throws Exception {	
		try {	
			
			TipoUnidadLogicAdditional.checkTipoUnidadToSave(this.tipounidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoUnidadLogicAdditional.updateTipoUnidadToSave(this.tipounidad,this.arrDatoGeneral);
			
			TipoUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipounidad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoUnidad(this.tipounidad)) {			
				TipoUnidadDataAccess.save(this.tipounidad, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipounidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoUnidadLogicAdditional.checkTipoUnidadToSaveAfter(this.tipounidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipounidad.getIsDeleted()) {
				this.tipounidad=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoUnidadsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUnidad.class.getSimpleName()+"-saveTipoUnidadsWithConnection");connexion.begin();			
			
			TipoUnidadLogicAdditional.checkTipoUnidadToSaves(tipounidads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoUnidads();
			
			Boolean validadoTodosTipoUnidad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoUnidad tipounidadLocal:tipounidads) {		
				if(tipounidadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoUnidadLogicAdditional.updateTipoUnidadToSave(tipounidadLocal,this.arrDatoGeneral);
	        	
				TipoUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipounidadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoUnidad(tipounidadLocal)) {
					TipoUnidadDataAccess.save(tipounidadLocal, connexion);				
				} else {
					validadoTodosTipoUnidad=false;
				}
			}
			
			if(!validadoTodosTipoUnidad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoUnidadLogicAdditional.checkTipoUnidadToSavesAfter(tipounidads,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoUnidads();
			
			connexion.commit();		
			
			this.quitarTipoUnidadsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoUnidads()throws Exception {				
		 try {	
			TipoUnidadLogicAdditional.checkTipoUnidadToSaves(tipounidads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoUnidad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoUnidad tipounidadLocal:tipounidads) {				
				if(tipounidadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoUnidadLogicAdditional.updateTipoUnidadToSave(tipounidadLocal,this.arrDatoGeneral);
	        	
				TipoUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipounidadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoUnidad(tipounidadLocal)) {				
					TipoUnidadDataAccess.save(tipounidadLocal, connexion);				
				} else {
					validadoTodosTipoUnidad=false;
				}
			}
			
			if(!validadoTodosTipoUnidad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoUnidadLogicAdditional.checkTipoUnidadToSavesAfter(tipounidads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoUnidadsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoUnidadParameterReturnGeneral procesarAccionTipoUnidads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoUnidad> tipounidads,TipoUnidadParameterReturnGeneral tipounidadParameterGeneral)throws Exception {
		 try {	
			TipoUnidadParameterReturnGeneral tipounidadReturnGeneral=new TipoUnidadParameterReturnGeneral();
	
			TipoUnidadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipounidads,tipounidadParameterGeneral,tipounidadReturnGeneral);
			
			return tipounidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoUnidadParameterReturnGeneral procesarAccionTipoUnidadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoUnidad> tipounidads,TipoUnidadParameterReturnGeneral tipounidadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUnidad.class.getSimpleName()+"-procesarAccionTipoUnidadsWithConnection");connexion.begin();			
			
			TipoUnidadParameterReturnGeneral tipounidadReturnGeneral=new TipoUnidadParameterReturnGeneral();
	
			TipoUnidadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipounidads,tipounidadParameterGeneral,tipounidadReturnGeneral);
			
			this.connexion.commit();
			
			return tipounidadReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoUnidadParameterReturnGeneral procesarEventosTipoUnidads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoUnidad> tipounidads,TipoUnidad tipounidad,TipoUnidadParameterReturnGeneral tipounidadParameterGeneral,Boolean isEsNuevoTipoUnidad,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoUnidadParameterReturnGeneral tipounidadReturnGeneral=new TipoUnidadParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipounidadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoUnidadLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipounidads,tipounidad,tipounidadParameterGeneral,tipounidadReturnGeneral,isEsNuevoTipoUnidad,clases);
			
			return tipounidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoUnidadParameterReturnGeneral procesarEventosTipoUnidadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoUnidad> tipounidads,TipoUnidad tipounidad,TipoUnidadParameterReturnGeneral tipounidadParameterGeneral,Boolean isEsNuevoTipoUnidad,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUnidad.class.getSimpleName()+"-procesarEventosTipoUnidadsWithConnection");connexion.begin();			
			
			TipoUnidadParameterReturnGeneral tipounidadReturnGeneral=new TipoUnidadParameterReturnGeneral();
	
			tipounidadReturnGeneral.setTipoUnidad(tipounidad);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipounidadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoUnidadLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipounidads,tipounidad,tipounidadParameterGeneral,tipounidadReturnGeneral,isEsNuevoTipoUnidad,clases);
			
			this.connexion.commit();
			
			return tipounidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoUnidadParameterReturnGeneral procesarImportacionTipoUnidadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoUnidadParameterReturnGeneral tipounidadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUnidad.class.getSimpleName()+"-procesarImportacionTipoUnidadsWithConnection");connexion.begin();			
			
			TipoUnidadParameterReturnGeneral tipounidadReturnGeneral=new TipoUnidadParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipounidads=new ArrayList<TipoUnidad>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipounidad=new TipoUnidad();
				
				
				if(conColumnasBase) {this.tipounidad.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipounidad.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipounidad.setnombre(arrColumnas[iColumn++]);
				this.tipounidad.setsiglas(arrColumnas[iColumn++]);
				
				this.tipounidads.add(this.tipounidad);
			}
			
			this.saveTipoUnidads();
			
			this.connexion.commit();
			
			tipounidadReturnGeneral.setConRetornoEstaProcesado(true);
			tipounidadReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipounidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoUnidadsEliminados() throws Exception {				
		
		List<TipoUnidad> tipounidadsAux= new ArrayList<TipoUnidad>();
		
		for(TipoUnidad tipounidad:tipounidads) {
			if(!tipounidad.getIsDeleted()) {
				tipounidadsAux.add(tipounidad);
			}
		}
		
		tipounidads=tipounidadsAux;
	}
	
	public void quitarTipoUnidadsNulos() throws Exception {				
		
		List<TipoUnidad> tipounidadsAux= new ArrayList<TipoUnidad>();
		
		for(TipoUnidad tipounidad : this.tipounidads) {
			if(tipounidad==null) {
				tipounidadsAux.add(tipounidad);
			}
		}
		
		//this.tipounidads=tipounidadsAux;
		
		this.tipounidads.removeAll(tipounidadsAux);
	}
	
	public void getSetVersionRowTipoUnidadWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipounidad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipounidad.getIsDeleted() || (tipounidad.getIsChanged()&&!tipounidad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipounidadDataAccess.getSetVersionRowTipoUnidad(connexion,tipounidad.getId());
				
				if(!tipounidad.getVersionRow().equals(timestamp)) {	
					tipounidad.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipounidad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoUnidad()throws Exception {	
		
		if(tipounidad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipounidad.getIsDeleted() || (tipounidad.getIsChanged()&&!tipounidad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipounidadDataAccess.getSetVersionRowTipoUnidad(connexion,tipounidad.getId());
			
			try {							
				if(!tipounidad.getVersionRow().equals(timestamp)) {	
					tipounidad.setVersionRow(timestamp);
				}
				
				tipounidad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoUnidadsWithConnection()throws Exception {	
		if(tipounidads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoUnidad tipounidadAux:tipounidads) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipounidadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipounidadAux.getIsDeleted() || (tipounidadAux.getIsChanged()&&!tipounidadAux.getIsNew())) {
						
						timestamp=tipounidadDataAccess.getSetVersionRowTipoUnidad(connexion,tipounidadAux.getId());
						
						if(!tipounidad.getVersionRow().equals(timestamp)) {	
							tipounidadAux.setVersionRow(timestamp);
						}
								
						tipounidadAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoUnidads()throws Exception {	
		if(tipounidads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoUnidad tipounidadAux:tipounidads) {
					if(tipounidadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipounidadAux.getIsDeleted() || (tipounidadAux.getIsChanged()&&!tipounidadAux.getIsNew())) {
						
						timestamp=tipounidadDataAccess.getSetVersionRowTipoUnidad(connexion,tipounidadAux.getId());
						
						if(!tipounidadAux.getVersionRow().equals(timestamp)) {	
							tipounidadAux.setVersionRow(timestamp);
						}
						
													
						tipounidadAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoUnidadWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			UnidadLogic unidadLogic=new UnidadLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUnidad.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoUnidadWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Unidad.class));
											
			

			unidadLogic.setConnexion(this.getConnexion());
			unidadLogic.setDatosCliente(this.datosCliente);
			unidadLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoUnidad tipounidad:this.tipounidads) {
				

				classes=new ArrayList<Classe>();
				classes=UnidadConstantesFunciones.getClassesForeignKeysOfUnidad(new ArrayList<Classe>(),DeepLoadType.NONE);

				unidadLogic.setUnidads(tipounidad.unidads);
				unidadLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoUnidad tipounidad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoUnidadLogicAdditional.updateTipoUnidadToGet(tipounidad,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipounidad.setUnidads(tipounidadDataAccess.getUnidads(connexion,tipounidad));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipounidad.setUnidads(tipounidadDataAccess.getUnidads(connexion,tipounidad));

				if(this.isConDeep) {
					UnidadLogic unidadLogic= new UnidadLogic(this.connexion);
					unidadLogic.setUnidads(tipounidad.getUnidads());
					ArrayList<Classe> classesLocal=UnidadConstantesFunciones.getClassesForeignKeysOfUnidad(new ArrayList<Classe>(),DeepLoadType.NONE);
					unidadLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					UnidadConstantesFunciones.refrescarForeignKeysDescripcionesUnidad(unidadLogic.getUnidads());
					tipounidad.setUnidads(unidadLogic.getUnidads());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Unidad.class));
			tipounidad.setUnidads(tipounidadDataAccess.getUnidads(connexion,tipounidad));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipounidad.setUnidads(tipounidadDataAccess.getUnidads(connexion,tipounidad));

		for(Unidad unidad:tipounidad.getUnidads()) {
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(unidad,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipounidad.setUnidads(tipounidadDataAccess.getUnidads(connexion,tipounidad));

				for(Unidad unidad:tipounidad.getUnidads()) {
					UnidadLogic unidadLogic= new UnidadLogic(connexion);
					unidadLogic.deepLoad(unidad,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Unidad.class));
			tipounidad.setUnidads(tipounidadDataAccess.getUnidads(connexion,tipounidad));

			for(Unidad unidad:tipounidad.getUnidads()) {
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(unidad,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoUnidad tipounidad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoUnidadLogicAdditional.updateTipoUnidadToSave(tipounidad,this.arrDatoGeneral);
			
TipoUnidadDataAccess.save(tipounidad, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Unidad unidad:tipounidad.getUnidads()) {
			unidad.setid_tipo_unidad(tipounidad.getId());
			UnidadDataAccess.save(unidad,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Unidad.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Unidad unidad:tipounidad.getUnidads()) {
					unidad.setid_tipo_unidad(tipounidad.getId());
					UnidadDataAccess.save(unidad,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Unidad unidad:tipounidad.getUnidads()) {
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidad.setid_tipo_unidad(tipounidad.getId());
			UnidadDataAccess.save(unidad,connexion);
			unidadLogic.deepSave(unidad,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Unidad.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Unidad unidad:tipounidad.getUnidads()) {
					UnidadLogic unidadLogic= new UnidadLogic(connexion);
					unidad.setid_tipo_unidad(tipounidad.getId());
					UnidadDataAccess.save(unidad,connexion);
					unidadLogic.deepSave(unidad,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoUnidad.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipounidad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(tipounidad);
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
			this.deepLoad(this.tipounidad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoUnidad.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipounidads!=null) {
				for(TipoUnidad tipounidad:tipounidads) {
					this.deepLoad(tipounidad,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(tipounidads);
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
			if(tipounidads!=null) {
				for(TipoUnidad tipounidad:tipounidads) {
					this.deepLoad(tipounidad,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(tipounidads);
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
			this.getNewConnexionToDeep(TipoUnidad.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipounidad,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoUnidad.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipounidads!=null) {
				for(TipoUnidad tipounidad:tipounidads) {
					this.deepSave(tipounidad,isDeep,deepLoadType,clases);
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
			if(tipounidads!=null) {
				for(TipoUnidad tipounidad:tipounidads) {
					this.deepSave(tipounidad,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoUnidadsBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUnidad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoUnidadConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipounidads=tipounidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoUnidadsBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoUnidadConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipounidads=tipounidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidads);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoUnidadsBusquedaPorSiglasWithConnection(String sFinalQuery,Pagination pagination,String siglas)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUnidad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralSiglas= new ParameterSelectionGeneral();
			parameterSelectionGeneralSiglas.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+siglas+"%",TipoUnidadConstantesFunciones.SIGLAS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralSiglas);

			TipoUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorSiglas","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipounidads=tipounidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoUnidadsBusquedaPorSiglas(String sFinalQuery,Pagination pagination,String siglas)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralSiglas= new ParameterSelectionGeneral();
			parameterSelectionGeneralSiglas.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+siglas+"%",TipoUnidadConstantesFunciones.SIGLAS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralSiglas);

			TipoUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorSiglas","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipounidads=tipounidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidads);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoUnidadPorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUnidad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoUnidadConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipounidad=tipounidadDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipounidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidad);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoUnidadPorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoUnidadConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipounidad=tipounidadDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipounidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoUnidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoUnidad(this.tipounidad);
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
			if(TipoUnidadConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoUnidadDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoUnidad tipounidad,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoUnidadConstantesFunciones.ISCONAUDITORIA) {
				if(tipounidad.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoUnidadDataAccess.TABLENAME, tipounidad.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoUnidadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoUnidadLogic.registrarAuditoriaDetallesTipoUnidad(connexion,tipounidad,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipounidad.getIsDeleted()) {
					/*if(!tipounidad.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoUnidadDataAccess.TABLENAME, tipounidad.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoUnidadLogic.registrarAuditoriaDetallesTipoUnidad(connexion,tipounidad,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoUnidadDataAccess.TABLENAME, tipounidad.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipounidad.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoUnidadDataAccess.TABLENAME, tipounidad.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoUnidadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoUnidadLogic.registrarAuditoriaDetallesTipoUnidad(connexion,tipounidad,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoUnidad(Connexion connexion,TipoUnidad tipounidad)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipounidad.getIsNew()||!tipounidad.getnombre().equals(tipounidad.getTipoUnidadOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipounidad.getTipoUnidadOriginal().getnombre()!=null)
				{
					strValorActual=tipounidad.getTipoUnidadOriginal().getnombre();
				}
				if(tipounidad.getnombre()!=null)
				{
					strValorNuevo=tipounidad.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoUnidadConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipounidad.getIsNew()||!tipounidad.getsiglas().equals(tipounidad.getTipoUnidadOriginal().getsiglas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipounidad.getTipoUnidadOriginal().getsiglas()!=null)
				{
					strValorActual=tipounidad.getTipoUnidadOriginal().getsiglas();
				}
				if(tipounidad.getsiglas()!=null)
				{
					strValorNuevo=tipounidad.getsiglas() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoUnidadConstantesFunciones.SIGLAS,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoUnidadRelacionesWithConnection(TipoUnidad tipounidad,List<Unidad> unidads) throws Exception {

		if(!tipounidad.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoUnidadRelacionesBase(tipounidad,unidads,true);
		}
	}

	public void saveTipoUnidadRelaciones(TipoUnidad tipounidad,List<Unidad> unidads)throws Exception {

		if(!tipounidad.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoUnidadRelacionesBase(tipounidad,unidads,false);
		}
	}

	public void saveTipoUnidadRelacionesBase(TipoUnidad tipounidad,List<Unidad> unidads,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoUnidad-saveRelacionesWithConnection");}
	
			tipounidad.setUnidads(unidads);

			this.setTipoUnidad(tipounidad);

				if((tipounidad.getIsNew()||tipounidad.getIsChanged())&&!tipounidad.getIsDeleted()) {
					this.saveTipoUnidad();
					this.saveTipoUnidadRelacionesDetalles(unidads);

				} else if(tipounidad.getIsDeleted()) {
					this.saveTipoUnidadRelacionesDetalles(unidads);
					this.saveTipoUnidad();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			UnidadConstantesFunciones.InicializarGeneralEntityAuxiliaresUnidads(unidads,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoUnidadRelacionesDetalles(List<Unidad> unidads)throws Exception {
		try {
	

			Long idTipoUnidadActual=this.getTipoUnidad().getId();

			UnidadLogic unidadLogic_Desde_TipoUnidad=new UnidadLogic();
			unidadLogic_Desde_TipoUnidad.setUnidads(unidads);

			unidadLogic_Desde_TipoUnidad.setConnexion(this.getConnexion());
			unidadLogic_Desde_TipoUnidad.setDatosCliente(this.datosCliente);

			for(Unidad unidad_Desde_TipoUnidad:unidadLogic_Desde_TipoUnidad.getUnidads()) {
				unidad_Desde_TipoUnidad.setid_tipo_unidad(idTipoUnidadActual);

				unidadLogic_Desde_TipoUnidad.setUnidad(unidad_Desde_TipoUnidad);
				unidadLogic_Desde_TipoUnidad.saveUnidad();

				Long idUnidadActual=unidad_Desde_TipoUnidad.getId();

				ProductoLogic productoLogic_Desde_Unidad=new ProductoLogic();

				if(unidad_Desde_TipoUnidad.getProductos()==null){
					unidad_Desde_TipoUnidad.setProductos(new ArrayList<Producto>());
				}

				productoLogic_Desde_Unidad.setProductos(unidad_Desde_TipoUnidad.getProductos());

				productoLogic_Desde_Unidad.setConnexion(this.getConnexion());
				productoLogic_Desde_Unidad.setDatosCliente(this.datosCliente);

				for(Producto producto_Desde_Unidad:productoLogic_Desde_Unidad.getProductos()) {
					producto_Desde_Unidad.setid_unidad(idUnidadActual);

					productoLogic_Desde_Unidad.setProducto(producto_Desde_Unidad);
					productoLogic_Desde_Unidad.saveProducto();
				}


				ConversionInvenLogic conversioninvenConversionLogic_Desde_Unidad=new ConversionInvenLogic();

				if(unidad_Desde_TipoUnidad.getConversionInvenConversions()==null){
					unidad_Desde_TipoUnidad.setConversionInvenConversions(new ArrayList<ConversionInven>());
				}

				conversioninvenConversionLogic_Desde_Unidad.setConversionInvens(unidad_Desde_TipoUnidad.getConversionInvenConversions());

				conversioninvenConversionLogic_Desde_Unidad.setConnexion(this.getConnexion());
				conversioninvenConversionLogic_Desde_Unidad.setDatosCliente(this.datosCliente);

				for(ConversionInven conversioninven_Desde_Unidad:conversioninvenConversionLogic_Desde_Unidad.getConversionInvens()) {
					conversioninven_Desde_Unidad.setid_unidad_conversion(idUnidadActual);
				}

				conversioninvenConversionLogic_Desde_Unidad.saveConversionInvens();

				RangoUnidadVentaLogic rangounidadventaLogic_Desde_Unidad=new RangoUnidadVentaLogic();

				if(unidad_Desde_TipoUnidad.getRangoUnidadVentas()==null){
					unidad_Desde_TipoUnidad.setRangoUnidadVentas(new ArrayList<RangoUnidadVenta>());
				}

				rangounidadventaLogic_Desde_Unidad.setRangoUnidadVentas(unidad_Desde_TipoUnidad.getRangoUnidadVentas());

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

				if(unidad_Desde_TipoUnidad.getValorPorUnidads()==null){
					unidad_Desde_TipoUnidad.setValorPorUnidads(new ArrayList<ValorPorUnidad>());
				}

				valorporunidadLogic_Desde_Unidad.setValorPorUnidads(unidad_Desde_TipoUnidad.getValorPorUnidads());

				valorporunidadLogic_Desde_Unidad.setConnexion(this.getConnexion());
				valorporunidadLogic_Desde_Unidad.setDatosCliente(this.datosCliente);

				for(ValorPorUnidad valorporunidad_Desde_Unidad:valorporunidadLogic_Desde_Unidad.getValorPorUnidads()) {
					valorporunidad_Desde_Unidad.setid_unidad(idUnidadActual);
				}

				valorporunidadLogic_Desde_Unidad.saveValorPorUnidads();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoUnidadConstantesFunciones.getClassesForeignKeysOfTipoUnidad(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoUnidadConstantesFunciones.getClassesRelationshipsOfTipoUnidad(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

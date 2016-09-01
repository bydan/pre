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
import com.bydan.erp.inventario.util.SerieProductoConstantesFunciones;
import com.bydan.erp.inventario.util.SerieProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.SerieProductoParameterGeneral;
import com.bydan.erp.inventario.business.entity.SerieProducto;
import com.bydan.erp.inventario.business.logic.SerieProductoLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class SerieProductoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(SerieProductoLogic.class);
	
	protected SerieProductoDataAccess serieproductoDataAccess; 	
	protected SerieProducto serieproducto;
	protected List<SerieProducto> serieproductos;
	protected Object serieproductoObject;	
	protected List<Object> serieproductosObject;
	
	public static ClassValidator<SerieProducto> serieproductoValidator = new ClassValidator<SerieProducto>(SerieProducto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected SerieProductoLogicAdditional serieproductoLogicAdditional=null;
	
	public SerieProductoLogicAdditional getSerieProductoLogicAdditional() {
		return this.serieproductoLogicAdditional;
	}
	
	public void setSerieProductoLogicAdditional(SerieProductoLogicAdditional serieproductoLogicAdditional) {
		try {
			this.serieproductoLogicAdditional=serieproductoLogicAdditional;
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
	
	
	
	
	public  SerieProductoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.serieproductoDataAccess = new SerieProductoDataAccess();
			
			this.serieproductos= new ArrayList<SerieProducto>();
			this.serieproducto= new SerieProducto();
			
			this.serieproductoObject=new Object();
			this.serieproductosObject=new ArrayList<Object>();
				
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
			
			this.serieproductoDataAccess.setConnexionType(this.connexionType);
			this.serieproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SerieProductoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.serieproductoDataAccess = new SerieProductoDataAccess();
			this.serieproductos= new ArrayList<SerieProducto>();
			this.serieproducto= new SerieProducto();
			this.serieproductoObject=new Object();
			this.serieproductosObject=new ArrayList<Object>();
			
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
			
			this.serieproductoDataAccess.setConnexionType(this.connexionType);
			this.serieproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public SerieProducto getSerieProducto() throws Exception {	
		SerieProductoLogicAdditional.checkSerieProductoToGet(serieproducto,this.datosCliente,this.arrDatoGeneral);
		SerieProductoLogicAdditional.updateSerieProductoToGet(serieproducto,this.arrDatoGeneral);
		
		return serieproducto;
	}
		
	public void setSerieProducto(SerieProducto newSerieProducto) {
		this.serieproducto = newSerieProducto;
	}
	
	public SerieProductoDataAccess getSerieProductoDataAccess() {
		return serieproductoDataAccess;
	}
	
	public void setSerieProductoDataAccess(SerieProductoDataAccess newserieproductoDataAccess) {
		this.serieproductoDataAccess = newserieproductoDataAccess;
	}
	
	public List<SerieProducto> getSerieProductos() throws Exception {		
		this.quitarSerieProductosNulos();
		
		SerieProductoLogicAdditional.checkSerieProductoToGets(serieproductos,this.datosCliente,this.arrDatoGeneral);
		
		for (SerieProducto serieproductoLocal: serieproductos ) {
			SerieProductoLogicAdditional.updateSerieProductoToGet(serieproductoLocal,this.arrDatoGeneral);
		}
		
		return serieproductos;
	}
	
	public void setSerieProductos(List<SerieProducto> newSerieProductos) {
		this.serieproductos = newSerieProductos;
	}
	
	public Object getSerieProductoObject() {	
		this.serieproductoObject=this.serieproductoDataAccess.getEntityObject();
		return this.serieproductoObject;
	}
		
	public void setSerieProductoObject(Object newSerieProductoObject) {
		this.serieproductoObject = newSerieProductoObject;
	}
	
	public List<Object> getSerieProductosObject() {		
		this.serieproductosObject=this.serieproductoDataAccess.getEntitiesObject();
		return this.serieproductosObject;
	}
		
	public void setSerieProductosObject(List<Object> newSerieProductosObject) {
		this.serieproductosObject = newSerieProductosObject;
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
		
		if(this.serieproductoDataAccess!=null) {
			this.serieproductoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			serieproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			serieproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		serieproducto = new  SerieProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			serieproducto=serieproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.serieproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproducto);
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
		serieproducto = new  SerieProducto();
		  		  
        try {
			
			serieproducto=serieproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.serieproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		serieproducto = new  SerieProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			serieproducto=serieproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.serieproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproducto);
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
		serieproducto = new  SerieProducto();
		  		  
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
		serieproducto = new  SerieProducto();
		  		  
        try {
			
			serieproducto=serieproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.serieproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		serieproducto = new  SerieProducto();
		  		  
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
		serieproducto = new  SerieProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =serieproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		serieproducto = new  SerieProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=serieproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		serieproducto = new  SerieProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =serieproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		serieproducto = new  SerieProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=serieproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		serieproducto = new  SerieProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =serieproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		serieproducto = new  SerieProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=serieproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		serieproductos = new  ArrayList<SerieProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serieproductos=serieproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSerieProducto(serieproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
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
		serieproductos = new  ArrayList<SerieProducto>();
		  		  
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
		serieproductos = new  ArrayList<SerieProducto>();
		  		  
        try {			
			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serieproductos=serieproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarSerieProducto(serieproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		serieproductos = new  ArrayList<SerieProducto>();
		  		  
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
		serieproductos = new  ArrayList<SerieProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serieproductos=serieproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSerieProducto(serieproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
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
		serieproductos = new  ArrayList<SerieProducto>();
		  		  
        try {
			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serieproductos=serieproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSerieProducto(serieproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
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
		serieproductos = new  ArrayList<SerieProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serieproductos=serieproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSerieProducto(serieproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
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
		serieproductos = new  ArrayList<SerieProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serieproductos=serieproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSerieProducto(serieproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		serieproducto = new  SerieProducto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serieproducto=serieproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSerieProducto(serieproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproducto);
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
		serieproducto = new  SerieProducto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serieproducto=serieproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSerieProducto(serieproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		serieproductos = new  ArrayList<SerieProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serieproductos=serieproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSerieProducto(serieproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
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
		serieproductos = new  ArrayList<SerieProducto>();
		  		  
        try {
			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serieproductos=serieproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSerieProducto(serieproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosSerieProductosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		serieproductos = new  ArrayList<SerieProducto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-getTodosSerieProductosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serieproductos=serieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSerieProducto(serieproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
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
	
	public  void  getTodosSerieProductos(String sFinalQuery,Pagination pagination)throws Exception {
		serieproductos = new  ArrayList<SerieProducto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serieproductos=serieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSerieProducto(serieproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarSerieProducto(SerieProducto serieproducto) throws Exception {
		Boolean estaValidado=false;
		
		if(serieproducto.getIsNew() || serieproducto.getIsChanged()) { 
			this.invalidValues = serieproductoValidator.getInvalidValues(serieproducto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(serieproducto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarSerieProducto(List<SerieProducto> SerieProductos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(SerieProducto serieproductoLocal:serieproductos) {				
			estaValidadoObjeto=this.validarGuardarSerieProducto(serieproductoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarSerieProducto(List<SerieProducto> SerieProductos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSerieProducto(serieproductos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarSerieProducto(SerieProducto SerieProducto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSerieProducto(serieproducto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(SerieProducto serieproducto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+serieproducto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=SerieProductoConstantesFunciones.getSerieProductoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"serieproducto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(SerieProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(SerieProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveSerieProductoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-saveSerieProductoWithConnection");connexion.begin();			
			
			SerieProductoLogicAdditional.checkSerieProductoToSave(this.serieproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SerieProductoLogicAdditional.updateSerieProductoToSave(this.serieproducto,this.arrDatoGeneral);
			
			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.serieproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowSerieProducto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSerieProducto(this.serieproducto)) {
				SerieProductoDataAccess.save(this.serieproducto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.serieproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SerieProductoLogicAdditional.checkSerieProductoToSaveAfter(this.serieproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSerieProducto();
			
			connexion.commit();			
			
			if(this.serieproducto.getIsDeleted()) {
				this.serieproducto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveSerieProducto()throws Exception {	
		try {	
			
			SerieProductoLogicAdditional.checkSerieProductoToSave(this.serieproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SerieProductoLogicAdditional.updateSerieProductoToSave(this.serieproducto,this.arrDatoGeneral);
			
			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.serieproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSerieProducto(this.serieproducto)) {			
				SerieProductoDataAccess.save(this.serieproducto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.serieproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SerieProductoLogicAdditional.checkSerieProductoToSaveAfter(this.serieproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.serieproducto.getIsDeleted()) {
				this.serieproducto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveSerieProductosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-saveSerieProductosWithConnection");connexion.begin();			
			
			SerieProductoLogicAdditional.checkSerieProductoToSaves(serieproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowSerieProductos();
			
			Boolean validadoTodosSerieProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SerieProducto serieproductoLocal:serieproductos) {		
				if(serieproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SerieProductoLogicAdditional.updateSerieProductoToSave(serieproductoLocal,this.arrDatoGeneral);
	        	
				SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),serieproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSerieProducto(serieproductoLocal)) {
					SerieProductoDataAccess.save(serieproductoLocal, connexion);				
				} else {
					validadoTodosSerieProducto=false;
				}
			}
			
			if(!validadoTodosSerieProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SerieProductoLogicAdditional.checkSerieProductoToSavesAfter(serieproductos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSerieProductos();
			
			connexion.commit();		
			
			this.quitarSerieProductosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveSerieProductos()throws Exception {				
		 try {	
			SerieProductoLogicAdditional.checkSerieProductoToSaves(serieproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosSerieProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SerieProducto serieproductoLocal:serieproductos) {				
				if(serieproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SerieProductoLogicAdditional.updateSerieProductoToSave(serieproductoLocal,this.arrDatoGeneral);
	        	
				SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),serieproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSerieProducto(serieproductoLocal)) {				
					SerieProductoDataAccess.save(serieproductoLocal, connexion);				
				} else {
					validadoTodosSerieProducto=false;
				}
			}
			
			if(!validadoTodosSerieProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SerieProductoLogicAdditional.checkSerieProductoToSavesAfter(serieproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarSerieProductosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SerieProductoParameterReturnGeneral procesarAccionSerieProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SerieProducto> serieproductos,SerieProductoParameterReturnGeneral serieproductoParameterGeneral)throws Exception {
		 try {	
			SerieProductoParameterReturnGeneral serieproductoReturnGeneral=new SerieProductoParameterReturnGeneral();
	
			SerieProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,serieproductos,serieproductoParameterGeneral,serieproductoReturnGeneral);
			
			return serieproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SerieProductoParameterReturnGeneral procesarAccionSerieProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SerieProducto> serieproductos,SerieProductoParameterReturnGeneral serieproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-procesarAccionSerieProductosWithConnection");connexion.begin();			
			
			SerieProductoParameterReturnGeneral serieproductoReturnGeneral=new SerieProductoParameterReturnGeneral();
	
			SerieProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,serieproductos,serieproductoParameterGeneral,serieproductoReturnGeneral);
			
			this.connexion.commit();
			
			return serieproductoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SerieProductoParameterReturnGeneral procesarEventosSerieProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SerieProducto> serieproductos,SerieProducto serieproducto,SerieProductoParameterReturnGeneral serieproductoParameterGeneral,Boolean isEsNuevoSerieProducto,ArrayList<Classe> clases)throws Exception {
		 try {	
			SerieProductoParameterReturnGeneral serieproductoReturnGeneral=new SerieProductoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				serieproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SerieProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,serieproductos,serieproducto,serieproductoParameterGeneral,serieproductoReturnGeneral,isEsNuevoSerieProducto,clases);
			
			return serieproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public SerieProductoParameterReturnGeneral procesarEventosSerieProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SerieProducto> serieproductos,SerieProducto serieproducto,SerieProductoParameterReturnGeneral serieproductoParameterGeneral,Boolean isEsNuevoSerieProducto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-procesarEventosSerieProductosWithConnection");connexion.begin();			
			
			SerieProductoParameterReturnGeneral serieproductoReturnGeneral=new SerieProductoParameterReturnGeneral();
	
			serieproductoReturnGeneral.setSerieProducto(serieproducto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				serieproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SerieProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,serieproductos,serieproducto,serieproductoParameterGeneral,serieproductoReturnGeneral,isEsNuevoSerieProducto,clases);
			
			this.connexion.commit();
			
			return serieproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SerieProductoParameterReturnGeneral procesarImportacionSerieProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,SerieProductoParameterReturnGeneral serieproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-procesarImportacionSerieProductosWithConnection");connexion.begin();			
			
			SerieProductoParameterReturnGeneral serieproductoReturnGeneral=new SerieProductoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.serieproductos=new ArrayList<SerieProducto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.serieproducto=new SerieProducto();
				
				
				if(conColumnasBase) {this.serieproducto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.serieproducto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.serieproducto.setcodigo(Double.parseDouble(arrColumnas[iColumn++]));
				this.serieproducto.setfecha_compra(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.serieproducto.setfecha_entrega(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.serieproducto.setfecha_venta(Funciones.ConvertToDate(arrColumnas[iColumn++]));
			this.serieproducto.setdescripcion(arrColumnas[iColumn++]);
				
				this.serieproductos.add(this.serieproducto);
			}
			
			this.saveSerieProductos();
			
			this.connexion.commit();
			
			serieproductoReturnGeneral.setConRetornoEstaProcesado(true);
			serieproductoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return serieproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarSerieProductosEliminados() throws Exception {				
		
		List<SerieProducto> serieproductosAux= new ArrayList<SerieProducto>();
		
		for(SerieProducto serieproducto:serieproductos) {
			if(!serieproducto.getIsDeleted()) {
				serieproductosAux.add(serieproducto);
			}
		}
		
		serieproductos=serieproductosAux;
	}
	
	public void quitarSerieProductosNulos() throws Exception {				
		
		List<SerieProducto> serieproductosAux= new ArrayList<SerieProducto>();
		
		for(SerieProducto serieproducto : this.serieproductos) {
			if(serieproducto==null) {
				serieproductosAux.add(serieproducto);
			}
		}
		
		//this.serieproductos=serieproductosAux;
		
		this.serieproductos.removeAll(serieproductosAux);
	}
	
	public void getSetVersionRowSerieProductoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(serieproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((serieproducto.getIsDeleted() || (serieproducto.getIsChanged()&&!serieproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=serieproductoDataAccess.getSetVersionRowSerieProducto(connexion,serieproducto.getId());
				
				if(!serieproducto.getVersionRow().equals(timestamp)) {	
					serieproducto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				serieproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowSerieProducto()throws Exception {	
		
		if(serieproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((serieproducto.getIsDeleted() || (serieproducto.getIsChanged()&&!serieproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=serieproductoDataAccess.getSetVersionRowSerieProducto(connexion,serieproducto.getId());
			
			try {							
				if(!serieproducto.getVersionRow().equals(timestamp)) {	
					serieproducto.setVersionRow(timestamp);
				}
				
				serieproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowSerieProductosWithConnection()throws Exception {	
		if(serieproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(SerieProducto serieproductoAux:serieproductos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(serieproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(serieproductoAux.getIsDeleted() || (serieproductoAux.getIsChanged()&&!serieproductoAux.getIsNew())) {
						
						timestamp=serieproductoDataAccess.getSetVersionRowSerieProducto(connexion,serieproductoAux.getId());
						
						if(!serieproducto.getVersionRow().equals(timestamp)) {	
							serieproductoAux.setVersionRow(timestamp);
						}
								
						serieproductoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowSerieProductos()throws Exception {	
		if(serieproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(SerieProducto serieproductoAux:serieproductos) {
					if(serieproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(serieproductoAux.getIsDeleted() || (serieproductoAux.getIsChanged()&&!serieproductoAux.getIsNew())) {
						
						timestamp=serieproductoDataAccess.getSetVersionRowSerieProducto(connexion,serieproductoAux.getId());
						
						if(!serieproductoAux.getVersionRow().equals(timestamp)) {	
							serieproductoAux.setVersionRow(timestamp);
						}
						
													
						serieproductoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public SerieProductoParameterReturnGeneral cargarCombosLoteForeignKeySerieProductoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalBodega,String finalQueryGlobalProducto) throws Exception {
		SerieProductoParameterReturnGeneral  serieproductoReturnGeneral =new SerieProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-cargarCombosLoteForeignKeySerieProductoWithConnection");connexion.begin();
			
			serieproductoReturnGeneral =new SerieProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			serieproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			serieproductoReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			serieproductoReturnGeneral.setproductosForeignKey(productosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return serieproductoReturnGeneral;
	}
	
	public SerieProductoParameterReturnGeneral cargarCombosLoteForeignKeySerieProducto(String finalQueryGlobalEmpresa,String finalQueryGlobalBodega,String finalQueryGlobalProducto) throws Exception {
		SerieProductoParameterReturnGeneral  serieproductoReturnGeneral =new SerieProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			serieproductoReturnGeneral =new SerieProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			serieproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			serieproductoReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			serieproductoReturnGeneral.setproductosForeignKey(productosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return serieproductoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeySerieProductoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleSerieProductoLogic detalleserieproductoLogic=new DetalleSerieProductoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-cargarRelacionesLoteForeignKeySerieProductoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleSerieProducto.class));
											
			

			detalleserieproductoLogic.setConnexion(this.getConnexion());
			detalleserieproductoLogic.setDatosCliente(this.datosCliente);
			detalleserieproductoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(SerieProducto serieproducto:this.serieproductos) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleSerieProductoConstantesFunciones.getClassesForeignKeysOfDetalleSerieProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleserieproductoLogic.setDetalleSerieProductos(serieproducto.detalleserieproductos);
				detalleserieproductoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(SerieProducto serieproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SerieProductoLogicAdditional.updateSerieProductoToGet(serieproducto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		serieproducto.setEmpresa(serieproductoDataAccess.getEmpresa(connexion,serieproducto));
		serieproducto.setBodega(serieproductoDataAccess.getBodega(connexion,serieproducto));
		serieproducto.setProducto(serieproductoDataAccess.getProducto(connexion,serieproducto));
		serieproducto.setDetalleSerieProductos(serieproductoDataAccess.getDetalleSerieProductos(connexion,serieproducto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				serieproducto.setEmpresa(serieproductoDataAccess.getEmpresa(connexion,serieproducto));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				serieproducto.setBodega(serieproductoDataAccess.getBodega(connexion,serieproducto));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				serieproducto.setProducto(serieproductoDataAccess.getProducto(connexion,serieproducto));
				continue;
			}

			if(clas.clas.equals(DetalleSerieProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				serieproducto.setDetalleSerieProductos(serieproductoDataAccess.getDetalleSerieProductos(connexion,serieproducto));

				if(this.isConDeep) {
					DetalleSerieProductoLogic detalleserieproductoLogic= new DetalleSerieProductoLogic(this.connexion);
					detalleserieproductoLogic.setDetalleSerieProductos(serieproducto.getDetalleSerieProductos());
					ArrayList<Classe> classesLocal=DetalleSerieProductoConstantesFunciones.getClassesForeignKeysOfDetalleSerieProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleserieproductoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleSerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleSerieProducto(detalleserieproductoLogic.getDetalleSerieProductos());
					serieproducto.setDetalleSerieProductos(detalleserieproductoLogic.getDetalleSerieProductos());
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
			serieproducto.setEmpresa(serieproductoDataAccess.getEmpresa(connexion,serieproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serieproducto.setBodega(serieproductoDataAccess.getBodega(connexion,serieproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serieproducto.setProducto(serieproductoDataAccess.getProducto(connexion,serieproducto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleSerieProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleSerieProducto.class));
			serieproducto.setDetalleSerieProductos(serieproductoDataAccess.getDetalleSerieProductos(connexion,serieproducto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		serieproducto.setEmpresa(serieproductoDataAccess.getEmpresa(connexion,serieproducto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(serieproducto.getEmpresa(),isDeep,deepLoadType,clases);
				
		serieproducto.setBodega(serieproductoDataAccess.getBodega(connexion,serieproducto));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(serieproducto.getBodega(),isDeep,deepLoadType,clases);
				
		serieproducto.setProducto(serieproductoDataAccess.getProducto(connexion,serieproducto));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(serieproducto.getProducto(),isDeep,deepLoadType,clases);
				

		serieproducto.setDetalleSerieProductos(serieproductoDataAccess.getDetalleSerieProductos(connexion,serieproducto));

		for(DetalleSerieProducto detalleserieproducto:serieproducto.getDetalleSerieProductos()) {
			DetalleSerieProductoLogic detalleserieproductoLogic= new DetalleSerieProductoLogic(connexion);
			detalleserieproductoLogic.deepLoad(detalleserieproducto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				serieproducto.setEmpresa(serieproductoDataAccess.getEmpresa(connexion,serieproducto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(serieproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				serieproducto.setBodega(serieproductoDataAccess.getBodega(connexion,serieproducto));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(serieproducto.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				serieproducto.setProducto(serieproductoDataAccess.getProducto(connexion,serieproducto));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(serieproducto.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleSerieProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				serieproducto.setDetalleSerieProductos(serieproductoDataAccess.getDetalleSerieProductos(connexion,serieproducto));

				for(DetalleSerieProducto detalleserieproducto:serieproducto.getDetalleSerieProductos()) {
					DetalleSerieProductoLogic detalleserieproductoLogic= new DetalleSerieProductoLogic(connexion);
					detalleserieproductoLogic.deepLoad(detalleserieproducto,isDeep,deepLoadType,clases);
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
			serieproducto.setEmpresa(serieproductoDataAccess.getEmpresa(connexion,serieproducto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(serieproducto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serieproducto.setBodega(serieproductoDataAccess.getBodega(connexion,serieproducto));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(serieproducto.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serieproducto.setProducto(serieproductoDataAccess.getProducto(connexion,serieproducto));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(serieproducto.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleSerieProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleSerieProducto.class));
			serieproducto.setDetalleSerieProductos(serieproductoDataAccess.getDetalleSerieProductos(connexion,serieproducto));

			for(DetalleSerieProducto detalleserieproducto:serieproducto.getDetalleSerieProductos()) {
				DetalleSerieProductoLogic detalleserieproductoLogic= new DetalleSerieProductoLogic(connexion);
				detalleserieproductoLogic.deepLoad(detalleserieproducto,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(SerieProducto serieproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			SerieProductoLogicAdditional.updateSerieProductoToSave(serieproducto,this.arrDatoGeneral);
			
SerieProductoDataAccess.save(serieproducto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(serieproducto.getEmpresa(),connexion);

		BodegaDataAccess.save(serieproducto.getBodega(),connexion);

		ProductoDataAccess.save(serieproducto.getProducto(),connexion);

		for(DetalleSerieProducto detalleserieproducto:serieproducto.getDetalleSerieProductos()) {
			detalleserieproducto.setid_serie_producto(serieproducto.getId());
			DetalleSerieProductoDataAccess.save(detalleserieproducto,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(serieproducto.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(serieproducto.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(serieproducto.getProducto(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleSerieProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleSerieProducto detalleserieproducto:serieproducto.getDetalleSerieProductos()) {
					detalleserieproducto.setid_serie_producto(serieproducto.getId());
					DetalleSerieProductoDataAccess.save(detalleserieproducto,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(serieproducto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(serieproducto.getEmpresa(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(serieproducto.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(serieproducto.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(serieproducto.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(serieproducto.getProducto(),isDeep,deepLoadType,clases);
				

		for(DetalleSerieProducto detalleserieproducto:serieproducto.getDetalleSerieProductos()) {
			DetalleSerieProductoLogic detalleserieproductoLogic= new DetalleSerieProductoLogic(connexion);
			detalleserieproducto.setid_serie_producto(serieproducto.getId());
			DetalleSerieProductoDataAccess.save(detalleserieproducto,connexion);
			detalleserieproductoLogic.deepSave(detalleserieproducto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(serieproducto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(serieproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(serieproducto.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(serieproducto.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(serieproducto.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(serieproducto.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleSerieProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleSerieProducto detalleserieproducto:serieproducto.getDetalleSerieProductos()) {
					DetalleSerieProductoLogic detalleserieproductoLogic= new DetalleSerieProductoLogic(connexion);
					detalleserieproducto.setid_serie_producto(serieproducto.getId());
					DetalleSerieProductoDataAccess.save(detalleserieproducto,connexion);
					detalleserieproductoLogic.deepSave(detalleserieproducto,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(SerieProducto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(serieproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(serieproducto);
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
			this.deepLoad(this.serieproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(SerieProducto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(serieproductos!=null) {
				for(SerieProducto serieproducto:serieproductos) {
					this.deepLoad(serieproducto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(serieproductos);
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
			if(serieproductos!=null) {
				for(SerieProducto serieproducto:serieproductos) {
					this.deepLoad(serieproducto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(serieproductos);
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
			this.getNewConnexionToDeep(SerieProducto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(serieproducto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(SerieProducto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(serieproductos!=null) {
				for(SerieProducto serieproducto:serieproductos) {
					this.deepSave(serieproducto,isDeep,deepLoadType,clases);
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
			if(serieproductos!=null) {
				for(SerieProducto serieproducto:serieproductos) {
					this.deepSave(serieproducto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getSerieProductosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,Double codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.DOUBLE,codigo,SerieProductoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serieproductos=serieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSerieProductosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,Double codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.DOUBLE,codigo,SerieProductoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serieproductos=serieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSerieProductosBusquedaPorFechaCompraWithConnection(String sFinalQuery,Pagination pagination,Date fecha_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaCompra.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_compra,SerieProductoConstantesFunciones.FECHACOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaCompra);

			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serieproductos=serieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSerieProductosBusquedaPorFechaCompra(String sFinalQuery,Pagination pagination,Date fecha_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaCompra.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_compra,SerieProductoConstantesFunciones.FECHACOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaCompra);

			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serieproductos=serieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSerieProductosBusquedaPorFechaEntregaWithConnection(String sFinalQuery,Pagination pagination,Date fecha_entrega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaEntrega= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaEntrega.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_entrega,SerieProductoConstantesFunciones.FECHAENTREGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaEntrega);

			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaEntrega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serieproductos=serieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSerieProductosBusquedaPorFechaEntrega(String sFinalQuery,Pagination pagination,Date fecha_entrega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaEntrega= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaEntrega.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_entrega,SerieProductoConstantesFunciones.FECHAENTREGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaEntrega);

			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaEntrega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serieproductos=serieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSerieProductosBusquedaPorFechaVentaWithConnection(String sFinalQuery,Pagination pagination,Date fecha_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaVenta.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_venta,SerieProductoConstantesFunciones.FECHAVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaVenta);

			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serieproductos=serieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSerieProductosBusquedaPorFechaVenta(String sFinalQuery,Pagination pagination,Date fecha_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaVenta.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_venta,SerieProductoConstantesFunciones.FECHAVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaVenta);

			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serieproductos=serieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSerieProductosFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,SerieProductoConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serieproductos=serieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSerieProductosFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,SerieProductoConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serieproductos=serieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSerieProductosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SerieProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serieproductos=serieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSerieProductosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SerieProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serieproductos=serieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSerieProductosFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SerieProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,SerieProductoConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serieproductos=serieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSerieProductosFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,SerieProductoConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			SerieProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serieproductos=serieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SerieProductoConstantesFunciones.refrescarForeignKeysDescripcionesSerieProducto(this.serieproductos);
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
			if(SerieProductoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,SerieProductoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,SerieProducto serieproducto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(SerieProductoConstantesFunciones.ISCONAUDITORIA) {
				if(serieproducto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SerieProductoDataAccess.TABLENAME, serieproducto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SerieProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SerieProductoLogic.registrarAuditoriaDetallesSerieProducto(connexion,serieproducto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(serieproducto.getIsDeleted()) {
					/*if(!serieproducto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,SerieProductoDataAccess.TABLENAME, serieproducto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////SerieProductoLogic.registrarAuditoriaDetallesSerieProducto(connexion,serieproducto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SerieProductoDataAccess.TABLENAME, serieproducto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(serieproducto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SerieProductoDataAccess.TABLENAME, serieproducto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SerieProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SerieProductoLogic.registrarAuditoriaDetallesSerieProducto(connexion,serieproducto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesSerieProducto(Connexion connexion,SerieProducto serieproducto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(serieproducto.getIsNew()||!serieproducto.getid_empresa().equals(serieproducto.getSerieProductoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serieproducto.getSerieProductoOriginal().getid_empresa()!=null)
				{
					strValorActual=serieproducto.getSerieProductoOriginal().getid_empresa().toString();
				}
				if(serieproducto.getid_empresa()!=null)
				{
					strValorNuevo=serieproducto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SerieProductoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(serieproducto.getIsNew()||!serieproducto.getid_bodega().equals(serieproducto.getSerieProductoOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serieproducto.getSerieProductoOriginal().getid_bodega()!=null)
				{
					strValorActual=serieproducto.getSerieProductoOriginal().getid_bodega().toString();
				}
				if(serieproducto.getid_bodega()!=null)
				{
					strValorNuevo=serieproducto.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SerieProductoConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(serieproducto.getIsNew()||!serieproducto.getid_producto().equals(serieproducto.getSerieProductoOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serieproducto.getSerieProductoOriginal().getid_producto()!=null)
				{
					strValorActual=serieproducto.getSerieProductoOriginal().getid_producto().toString();
				}
				if(serieproducto.getid_producto()!=null)
				{
					strValorNuevo=serieproducto.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SerieProductoConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(serieproducto.getIsNew()||!serieproducto.getcodigo().equals(serieproducto.getSerieProductoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serieproducto.getSerieProductoOriginal().getcodigo()!=null)
				{
					strValorActual=serieproducto.getSerieProductoOriginal().getcodigo().toString();
				}
				if(serieproducto.getcodigo()!=null)
				{
					strValorNuevo=serieproducto.getcodigo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SerieProductoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(serieproducto.getIsNew()||!serieproducto.getfecha_compra().equals(serieproducto.getSerieProductoOriginal().getfecha_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serieproducto.getSerieProductoOriginal().getfecha_compra()!=null)
				{
					strValorActual=serieproducto.getSerieProductoOriginal().getfecha_compra().toString();
				}
				if(serieproducto.getfecha_compra()!=null)
				{
					strValorNuevo=serieproducto.getfecha_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SerieProductoConstantesFunciones.FECHACOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(serieproducto.getIsNew()||!serieproducto.getfecha_entrega().equals(serieproducto.getSerieProductoOriginal().getfecha_entrega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serieproducto.getSerieProductoOriginal().getfecha_entrega()!=null)
				{
					strValorActual=serieproducto.getSerieProductoOriginal().getfecha_entrega().toString();
				}
				if(serieproducto.getfecha_entrega()!=null)
				{
					strValorNuevo=serieproducto.getfecha_entrega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SerieProductoConstantesFunciones.FECHAENTREGA,strValorActual,strValorNuevo);
			}	
			
			if(serieproducto.getIsNew()||!serieproducto.getfecha_venta().equals(serieproducto.getSerieProductoOriginal().getfecha_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serieproducto.getSerieProductoOriginal().getfecha_venta()!=null)
				{
					strValorActual=serieproducto.getSerieProductoOriginal().getfecha_venta().toString();
				}
				if(serieproducto.getfecha_venta()!=null)
				{
					strValorNuevo=serieproducto.getfecha_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SerieProductoConstantesFunciones.FECHAVENTA,strValorActual,strValorNuevo);
			}	
			
			if(serieproducto.getIsNew()||!serieproducto.getdescripcion().equals(serieproducto.getSerieProductoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serieproducto.getSerieProductoOriginal().getdescripcion()!=null)
				{
					strValorActual=serieproducto.getSerieProductoOriginal().getdescripcion();
				}
				if(serieproducto.getdescripcion()!=null)
				{
					strValorNuevo=serieproducto.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SerieProductoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveSerieProductoRelacionesWithConnection(SerieProducto serieproducto,List<DetalleSerieProducto> detalleserieproductos) throws Exception {

		if(!serieproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSerieProductoRelacionesBase(serieproducto,detalleserieproductos,true);
		}
	}

	public void saveSerieProductoRelaciones(SerieProducto serieproducto,List<DetalleSerieProducto> detalleserieproductos)throws Exception {

		if(!serieproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSerieProductoRelacionesBase(serieproducto,detalleserieproductos,false);
		}
	}

	public void saveSerieProductoRelacionesBase(SerieProducto serieproducto,List<DetalleSerieProducto> detalleserieproductos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("SerieProducto-saveRelacionesWithConnection");}
	
			serieproducto.setDetalleSerieProductos(detalleserieproductos);

			this.setSerieProducto(serieproducto);

			if(SerieProductoLogicAdditional.validarSaveRelaciones(serieproducto,this)) {

				SerieProductoLogicAdditional.updateRelacionesToSave(serieproducto,this);

				if((serieproducto.getIsNew()||serieproducto.getIsChanged())&&!serieproducto.getIsDeleted()) {
					this.saveSerieProducto();
					this.saveSerieProductoRelacionesDetalles(detalleserieproductos);

				} else if(serieproducto.getIsDeleted()) {
					this.saveSerieProductoRelacionesDetalles(detalleserieproductos);
					this.saveSerieProducto();
				}

				SerieProductoLogicAdditional.updateRelacionesToSaveAfter(serieproducto,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleSerieProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleSerieProductos(detalleserieproductos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveSerieProductoRelacionesDetalles(List<DetalleSerieProducto> detalleserieproductos)throws Exception {
		try {
	

			Long idSerieProductoActual=this.getSerieProducto().getId();

			DetalleSerieProductoLogic detalleserieproductoLogic_Desde_SerieProducto=new DetalleSerieProductoLogic();
			detalleserieproductoLogic_Desde_SerieProducto.setDetalleSerieProductos(detalleserieproductos);

			detalleserieproductoLogic_Desde_SerieProducto.setConnexion(this.getConnexion());
			detalleserieproductoLogic_Desde_SerieProducto.setDatosCliente(this.datosCliente);

			for(DetalleSerieProducto detalleserieproducto_Desde_SerieProducto:detalleserieproductoLogic_Desde_SerieProducto.getDetalleSerieProductos()) {
				detalleserieproducto_Desde_SerieProducto.setid_serie_producto(idSerieProductoActual);
			}

			detalleserieproductoLogic_Desde_SerieProducto.saveDetalleSerieProductos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfSerieProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SerieProductoConstantesFunciones.getClassesForeignKeysOfSerieProducto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSerieProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SerieProductoConstantesFunciones.getClassesRelationshipsOfSerieProducto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

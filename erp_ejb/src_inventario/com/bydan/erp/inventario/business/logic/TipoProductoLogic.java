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
import com.bydan.erp.inventario.util.TipoProductoConstantesFunciones;
import com.bydan.erp.inventario.util.TipoProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoProductoParameterGeneral;
import com.bydan.erp.inventario.business.entity.TipoProducto;
import com.bydan.erp.inventario.business.logic.TipoProductoLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoProductoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoProductoLogic.class);
	
	protected TipoProductoDataAccess tipoproductoDataAccess; 	
	protected TipoProducto tipoproducto;
	protected List<TipoProducto> tipoproductos;
	protected Object tipoproductoObject;	
	protected List<Object> tipoproductosObject;
	
	public static ClassValidator<TipoProducto> tipoproductoValidator = new ClassValidator<TipoProducto>(TipoProducto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoProductoLogicAdditional tipoproductoLogicAdditional=null;
	
	public TipoProductoLogicAdditional getTipoProductoLogicAdditional() {
		return this.tipoproductoLogicAdditional;
	}
	
	public void setTipoProductoLogicAdditional(TipoProductoLogicAdditional tipoproductoLogicAdditional) {
		try {
			this.tipoproductoLogicAdditional=tipoproductoLogicAdditional;
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
	
	
	
	
	public  TipoProductoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoproductoDataAccess = new TipoProductoDataAccess();
			
			this.tipoproductos= new ArrayList<TipoProducto>();
			this.tipoproducto= new TipoProducto();
			
			this.tipoproductoObject=new Object();
			this.tipoproductosObject=new ArrayList<Object>();
				
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
			
			this.tipoproductoDataAccess.setConnexionType(this.connexionType);
			this.tipoproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoProductoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoproductoDataAccess = new TipoProductoDataAccess();
			this.tipoproductos= new ArrayList<TipoProducto>();
			this.tipoproducto= new TipoProducto();
			this.tipoproductoObject=new Object();
			this.tipoproductosObject=new ArrayList<Object>();
			
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
			
			this.tipoproductoDataAccess.setConnexionType(this.connexionType);
			this.tipoproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoProducto getTipoProducto() throws Exception {	
		TipoProductoLogicAdditional.checkTipoProductoToGet(tipoproducto,this.datosCliente,this.arrDatoGeneral);
		TipoProductoLogicAdditional.updateTipoProductoToGet(tipoproducto,this.arrDatoGeneral);
		
		return tipoproducto;
	}
		
	public void setTipoProducto(TipoProducto newTipoProducto) {
		this.tipoproducto = newTipoProducto;
	}
	
	public TipoProductoDataAccess getTipoProductoDataAccess() {
		return tipoproductoDataAccess;
	}
	
	public void setTipoProductoDataAccess(TipoProductoDataAccess newtipoproductoDataAccess) {
		this.tipoproductoDataAccess = newtipoproductoDataAccess;
	}
	
	public List<TipoProducto> getTipoProductos() throws Exception {		
		this.quitarTipoProductosNulos();
		
		TipoProductoLogicAdditional.checkTipoProductoToGets(tipoproductos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoProducto tipoproductoLocal: tipoproductos ) {
			TipoProductoLogicAdditional.updateTipoProductoToGet(tipoproductoLocal,this.arrDatoGeneral);
		}
		
		return tipoproductos;
	}
	
	public void setTipoProductos(List<TipoProducto> newTipoProductos) {
		this.tipoproductos = newTipoProductos;
	}
	
	public Object getTipoProductoObject() {	
		this.tipoproductoObject=this.tipoproductoDataAccess.getEntityObject();
		return this.tipoproductoObject;
	}
		
	public void setTipoProductoObject(Object newTipoProductoObject) {
		this.tipoproductoObject = newTipoProductoObject;
	}
	
	public List<Object> getTipoProductosObject() {		
		this.tipoproductosObject=this.tipoproductoDataAccess.getEntitiesObject();
		return this.tipoproductosObject;
	}
		
	public void setTipoProductosObject(List<Object> newTipoProductosObject) {
		this.tipoproductosObject = newTipoProductosObject;
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
		
		if(this.tipoproductoDataAccess!=null) {
			this.tipoproductoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoproducto = new  TipoProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoproducto=tipoproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproducto);
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
		tipoproducto = new  TipoProducto();
		  		  
        try {
			
			tipoproducto=tipoproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoproducto = new  TipoProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoproducto=tipoproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproducto);
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
		tipoproducto = new  TipoProducto();
		  		  
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
		tipoproducto = new  TipoProducto();
		  		  
        try {
			
			tipoproducto=tipoproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoproducto = new  TipoProducto();
		  		  
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
		tipoproducto = new  TipoProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoproducto = new  TipoProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoproducto = new  TipoProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoproducto = new  TipoProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoproducto = new  TipoProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoproducto = new  TipoProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoproductos = new  ArrayList<TipoProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductos=tipoproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProducto(tipoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproductos);
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
		tipoproductos = new  ArrayList<TipoProducto>();
		  		  
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
		tipoproductos = new  ArrayList<TipoProducto>();
		  		  
        try {			
			TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductos=tipoproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoProducto(tipoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoproductos = new  ArrayList<TipoProducto>();
		  		  
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
		tipoproductos = new  ArrayList<TipoProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductos=tipoproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProducto(tipoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproductos);
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
		tipoproductos = new  ArrayList<TipoProducto>();
		  		  
        try {
			TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductos=tipoproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProducto(tipoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproductos);
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
		tipoproductos = new  ArrayList<TipoProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductos=tipoproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProducto(tipoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproductos);
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
		tipoproductos = new  ArrayList<TipoProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductos=tipoproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProducto(tipoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoproducto = new  TipoProducto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproducto=tipoproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProducto(tipoproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproducto);
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
		tipoproducto = new  TipoProducto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproducto=tipoproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProducto(tipoproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoproductos = new  ArrayList<TipoProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductos=tipoproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProducto(tipoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproductos);
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
		tipoproductos = new  ArrayList<TipoProducto>();
		  		  
        try {
			TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductos=tipoproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProducto(tipoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoProductosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoproductos = new  ArrayList<TipoProducto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-getTodosTipoProductosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductos=tipoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoProducto(tipoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproductos);
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
	
	public  void  getTodosTipoProductos(String sFinalQuery,Pagination pagination)throws Exception {
		tipoproductos = new  ArrayList<TipoProducto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductos=tipoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoProducto(tipoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoProducto(TipoProducto tipoproducto) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoproducto.getIsNew() || tipoproducto.getIsChanged()) { 
			this.invalidValues = tipoproductoValidator.getInvalidValues(tipoproducto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoproducto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoProducto(List<TipoProducto> TipoProductos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoProducto tipoproductoLocal:tipoproductos) {				
			estaValidadoObjeto=this.validarGuardarTipoProducto(tipoproductoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoProducto(List<TipoProducto> TipoProductos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoProducto(tipoproductos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoProducto(TipoProducto TipoProducto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoProducto(tipoproducto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoProducto tipoproducto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoproducto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoProductoConstantesFunciones.getTipoProductoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoproducto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoProductoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-saveTipoProductoWithConnection");connexion.begin();			
			
			TipoProductoLogicAdditional.checkTipoProductoToSave(this.tipoproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoProductoLogicAdditional.updateTipoProductoToSave(this.tipoproducto,this.arrDatoGeneral);
			
			TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoProducto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoProducto(this.tipoproducto)) {
				TipoProductoDataAccess.save(this.tipoproducto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoProductoLogicAdditional.checkTipoProductoToSaveAfter(this.tipoproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoProducto();
			
			connexion.commit();			
			
			if(this.tipoproducto.getIsDeleted()) {
				this.tipoproducto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoProducto()throws Exception {	
		try {	
			
			TipoProductoLogicAdditional.checkTipoProductoToSave(this.tipoproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoProductoLogicAdditional.updateTipoProductoToSave(this.tipoproducto,this.arrDatoGeneral);
			
			TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoProducto(this.tipoproducto)) {			
				TipoProductoDataAccess.save(this.tipoproducto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoProductoLogicAdditional.checkTipoProductoToSaveAfter(this.tipoproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoproducto.getIsDeleted()) {
				this.tipoproducto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoProductosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-saveTipoProductosWithConnection");connexion.begin();			
			
			TipoProductoLogicAdditional.checkTipoProductoToSaves(tipoproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoProductos();
			
			Boolean validadoTodosTipoProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoProducto tipoproductoLocal:tipoproductos) {		
				if(tipoproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoProductoLogicAdditional.updateTipoProductoToSave(tipoproductoLocal,this.arrDatoGeneral);
	        	
				TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoProducto(tipoproductoLocal)) {
					TipoProductoDataAccess.save(tipoproductoLocal, connexion);				
				} else {
					validadoTodosTipoProducto=false;
				}
			}
			
			if(!validadoTodosTipoProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoProductoLogicAdditional.checkTipoProductoToSavesAfter(tipoproductos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoProductos();
			
			connexion.commit();		
			
			this.quitarTipoProductosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoProductos()throws Exception {				
		 try {	
			TipoProductoLogicAdditional.checkTipoProductoToSaves(tipoproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoProducto tipoproductoLocal:tipoproductos) {				
				if(tipoproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoProductoLogicAdditional.updateTipoProductoToSave(tipoproductoLocal,this.arrDatoGeneral);
	        	
				TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoProducto(tipoproductoLocal)) {				
					TipoProductoDataAccess.save(tipoproductoLocal, connexion);				
				} else {
					validadoTodosTipoProducto=false;
				}
			}
			
			if(!validadoTodosTipoProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoProductoLogicAdditional.checkTipoProductoToSavesAfter(tipoproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoProductosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoProductoParameterReturnGeneral procesarAccionTipoProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoProducto> tipoproductos,TipoProductoParameterReturnGeneral tipoproductoParameterGeneral)throws Exception {
		 try {	
			TipoProductoParameterReturnGeneral tipoproductoReturnGeneral=new TipoProductoParameterReturnGeneral();
	
			TipoProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoproductos,tipoproductoParameterGeneral,tipoproductoReturnGeneral);
			
			return tipoproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoProductoParameterReturnGeneral procesarAccionTipoProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoProducto> tipoproductos,TipoProductoParameterReturnGeneral tipoproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-procesarAccionTipoProductosWithConnection");connexion.begin();			
			
			TipoProductoParameterReturnGeneral tipoproductoReturnGeneral=new TipoProductoParameterReturnGeneral();
	
			TipoProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoproductos,tipoproductoParameterGeneral,tipoproductoReturnGeneral);
			
			this.connexion.commit();
			
			return tipoproductoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoProductoParameterReturnGeneral procesarEventosTipoProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoProducto> tipoproductos,TipoProducto tipoproducto,TipoProductoParameterReturnGeneral tipoproductoParameterGeneral,Boolean isEsNuevoTipoProducto,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoProductoParameterReturnGeneral tipoproductoReturnGeneral=new TipoProductoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoproductos,tipoproducto,tipoproductoParameterGeneral,tipoproductoReturnGeneral,isEsNuevoTipoProducto,clases);
			
			return tipoproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoProductoParameterReturnGeneral procesarEventosTipoProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoProducto> tipoproductos,TipoProducto tipoproducto,TipoProductoParameterReturnGeneral tipoproductoParameterGeneral,Boolean isEsNuevoTipoProducto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-procesarEventosTipoProductosWithConnection");connexion.begin();			
			
			TipoProductoParameterReturnGeneral tipoproductoReturnGeneral=new TipoProductoParameterReturnGeneral();
	
			tipoproductoReturnGeneral.setTipoProducto(tipoproducto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoproductos,tipoproducto,tipoproductoParameterGeneral,tipoproductoReturnGeneral,isEsNuevoTipoProducto,clases);
			
			this.connexion.commit();
			
			return tipoproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoProductoParameterReturnGeneral procesarImportacionTipoProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoProductoParameterReturnGeneral tipoproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-procesarImportacionTipoProductosWithConnection");connexion.begin();			
			
			TipoProductoParameterReturnGeneral tipoproductoReturnGeneral=new TipoProductoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoproductos=new ArrayList<TipoProducto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoproducto=new TipoProducto();
				
				
				if(conColumnasBase) {this.tipoproducto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoproducto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoproducto.setcodigo(arrColumnas[iColumn++]);
				this.tipoproducto.setnombre(arrColumnas[iColumn++]);
			this.tipoproducto.setdescripcion(arrColumnas[iColumn++]);
				
				this.tipoproductos.add(this.tipoproducto);
			}
			
			this.saveTipoProductos();
			
			this.connexion.commit();
			
			tipoproductoReturnGeneral.setConRetornoEstaProcesado(true);
			tipoproductoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoProductosEliminados() throws Exception {				
		
		List<TipoProducto> tipoproductosAux= new ArrayList<TipoProducto>();
		
		for(TipoProducto tipoproducto:tipoproductos) {
			if(!tipoproducto.getIsDeleted()) {
				tipoproductosAux.add(tipoproducto);
			}
		}
		
		tipoproductos=tipoproductosAux;
	}
	
	public void quitarTipoProductosNulos() throws Exception {				
		
		List<TipoProducto> tipoproductosAux= new ArrayList<TipoProducto>();
		
		for(TipoProducto tipoproducto : this.tipoproductos) {
			if(tipoproducto==null) {
				tipoproductosAux.add(tipoproducto);
			}
		}
		
		//this.tipoproductos=tipoproductosAux;
		
		this.tipoproductos.removeAll(tipoproductosAux);
	}
	
	public void getSetVersionRowTipoProductoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoproducto.getIsDeleted() || (tipoproducto.getIsChanged()&&!tipoproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoproductoDataAccess.getSetVersionRowTipoProducto(connexion,tipoproducto.getId());
				
				if(!tipoproducto.getVersionRow().equals(timestamp)) {	
					tipoproducto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoProducto()throws Exception {	
		
		if(tipoproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoproducto.getIsDeleted() || (tipoproducto.getIsChanged()&&!tipoproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoproductoDataAccess.getSetVersionRowTipoProducto(connexion,tipoproducto.getId());
			
			try {							
				if(!tipoproducto.getVersionRow().equals(timestamp)) {	
					tipoproducto.setVersionRow(timestamp);
				}
				
				tipoproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoProductosWithConnection()throws Exception {	
		if(tipoproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoProducto tipoproductoAux:tipoproductos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoproductoAux.getIsDeleted() || (tipoproductoAux.getIsChanged()&&!tipoproductoAux.getIsNew())) {
						
						timestamp=tipoproductoDataAccess.getSetVersionRowTipoProducto(connexion,tipoproductoAux.getId());
						
						if(!tipoproducto.getVersionRow().equals(timestamp)) {	
							tipoproductoAux.setVersionRow(timestamp);
						}
								
						tipoproductoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoProductos()throws Exception {	
		if(tipoproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoProducto tipoproductoAux:tipoproductos) {
					if(tipoproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoproductoAux.getIsDeleted() || (tipoproductoAux.getIsChanged()&&!tipoproductoAux.getIsNew())) {
						
						timestamp=tipoproductoDataAccess.getSetVersionRowTipoProducto(connexion,tipoproductoAux.getId());
						
						if(!tipoproductoAux.getVersionRow().equals(timestamp)) {	
							tipoproductoAux.setVersionRow(timestamp);
						}
						
													
						tipoproductoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoProductoParameterReturnGeneral cargarCombosLoteForeignKeyTipoProductoWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoProductoParameterReturnGeneral  tipoproductoReturnGeneral =new TipoProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoProductoWithConnection");connexion.begin();
			
			tipoproductoReturnGeneral =new TipoProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoproductoReturnGeneral;
	}
	
	public TipoProductoParameterReturnGeneral cargarCombosLoteForeignKeyTipoProducto(String finalQueryGlobalEmpresa) throws Exception {
		TipoProductoParameterReturnGeneral  tipoproductoReturnGeneral =new TipoProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoproductoReturnGeneral =new TipoProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoproductoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoProductoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ModeloProductoLogic modeloproductoLogic=new ModeloProductoLogic();
			MaterialProductoLogic materialproductoLogic=new MaterialProductoLogic();
			MarcaProductoLogic marcaproductoLogic=new MarcaProductoLogic();
			SegmentoProductoLogic segmentoproductoLogic=new SegmentoProductoLogic();
			ColorProductoLogic colorproductoLogic=new ColorProductoLogic();
			EfectoProductoLogic efectoproductoLogic=new EfectoProductoLogic();
			TallaProductoLogic tallaproductoLogic=new TallaProductoLogic();
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic=new ParametroInventarioDefectoLogic();
			ClaseProductoLogic claseproductoLogic=new ClaseProductoLogic();
			ProductoLogic productoLogic=new ProductoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoProductoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ModeloProducto.class));
			classes.add(new Classe(MaterialProducto.class));
			classes.add(new Classe(MarcaProducto.class));
			classes.add(new Classe(SegmentoProducto.class));
			classes.add(new Classe(ColorProducto.class));
			classes.add(new Classe(EfectoProducto.class));
			classes.add(new Classe(TallaProducto.class));
			classes.add(new Classe(ParametroInventarioDefecto.class));
			classes.add(new Classe(ClaseProducto.class));
			classes.add(new Classe(Producto.class));
											
			

			modeloproductoLogic.setConnexion(this.getConnexion());
			modeloproductoLogic.setDatosCliente(this.datosCliente);
			modeloproductoLogic.setIsConRefrescarForeignKeys(true);

			materialproductoLogic.setConnexion(this.getConnexion());
			materialproductoLogic.setDatosCliente(this.datosCliente);
			materialproductoLogic.setIsConRefrescarForeignKeys(true);

			marcaproductoLogic.setConnexion(this.getConnexion());
			marcaproductoLogic.setDatosCliente(this.datosCliente);
			marcaproductoLogic.setIsConRefrescarForeignKeys(true);

			segmentoproductoLogic.setConnexion(this.getConnexion());
			segmentoproductoLogic.setDatosCliente(this.datosCliente);
			segmentoproductoLogic.setIsConRefrescarForeignKeys(true);

			colorproductoLogic.setConnexion(this.getConnexion());
			colorproductoLogic.setDatosCliente(this.datosCliente);
			colorproductoLogic.setIsConRefrescarForeignKeys(true);

			efectoproductoLogic.setConnexion(this.getConnexion());
			efectoproductoLogic.setDatosCliente(this.datosCliente);
			efectoproductoLogic.setIsConRefrescarForeignKeys(true);

			tallaproductoLogic.setConnexion(this.getConnexion());
			tallaproductoLogic.setDatosCliente(this.datosCliente);
			tallaproductoLogic.setIsConRefrescarForeignKeys(true);

			parametroinventariodefectoLogic.setConnexion(this.getConnexion());
			parametroinventariodefectoLogic.setDatosCliente(this.datosCliente);
			parametroinventariodefectoLogic.setIsConRefrescarForeignKeys(true);

			claseproductoLogic.setConnexion(this.getConnexion());
			claseproductoLogic.setDatosCliente(this.datosCliente);
			claseproductoLogic.setIsConRefrescarForeignKeys(true);

			productoLogic.setConnexion(this.getConnexion());
			productoLogic.setDatosCliente(this.datosCliente);
			productoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoProducto tipoproducto:this.tipoproductos) {
				

				classes=new ArrayList<Classe>();
				classes=ModeloProductoConstantesFunciones.getClassesForeignKeysOfModeloProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				modeloproductoLogic.setModeloProductos(tipoproducto.modeloproductos);
				modeloproductoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=MaterialProductoConstantesFunciones.getClassesForeignKeysOfMaterialProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				materialproductoLogic.setMaterialProductos(tipoproducto.materialproductos);
				materialproductoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=MarcaProductoConstantesFunciones.getClassesForeignKeysOfMarcaProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				marcaproductoLogic.setMarcaProductos(tipoproducto.marcaproductos);
				marcaproductoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=SegmentoProductoConstantesFunciones.getClassesForeignKeysOfSegmentoProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				segmentoproductoLogic.setSegmentoProductos(tipoproducto.segmentoproductos);
				segmentoproductoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ColorProductoConstantesFunciones.getClassesForeignKeysOfColorProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				colorproductoLogic.setColorProductos(tipoproducto.colorproductos);
				colorproductoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EfectoProductoConstantesFunciones.getClassesForeignKeysOfEfectoProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				efectoproductoLogic.setEfectoProductos(tipoproducto.efectoproductos);
				efectoproductoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=TallaProductoConstantesFunciones.getClassesForeignKeysOfTallaProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				tallaproductoLogic.setTallaProductos(tipoproducto.tallaproductos);
				tallaproductoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroInventarioDefectoConstantesFunciones.getClassesForeignKeysOfParametroInventarioDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametroinventariodefectoLogic.setParametroInventarioDefectos(tipoproducto.parametroinventariodefectos);
				parametroinventariodefectoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ClaseProductoConstantesFunciones.getClassesForeignKeysOfClaseProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				claseproductoLogic.setClaseProductos(tipoproducto.claseproductos);
				claseproductoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoConstantesFunciones.getClassesForeignKeysOfProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoLogic.setProductos(tipoproducto.productos);
				productoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoProducto tipoproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoProductoLogicAdditional.updateTipoProductoToGet(tipoproducto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoproducto.setEmpresa(tipoproductoDataAccess.getEmpresa(connexion,tipoproducto));
		tipoproducto.setModeloProductos(tipoproductoDataAccess.getModeloProductos(connexion,tipoproducto));
		tipoproducto.setMaterialProductos(tipoproductoDataAccess.getMaterialProductos(connexion,tipoproducto));
		tipoproducto.setMarcaProductos(tipoproductoDataAccess.getMarcaProductos(connexion,tipoproducto));
		tipoproducto.setSegmentoProductos(tipoproductoDataAccess.getSegmentoProductos(connexion,tipoproducto));
		tipoproducto.setColorProductos(tipoproductoDataAccess.getColorProductos(connexion,tipoproducto));
		tipoproducto.setEfectoProductos(tipoproductoDataAccess.getEfectoProductos(connexion,tipoproducto));
		tipoproducto.setTallaProductos(tipoproductoDataAccess.getTallaProductos(connexion,tipoproducto));
		tipoproducto.setParametroInventarioDefectos(tipoproductoDataAccess.getParametroInventarioDefectos(connexion,tipoproducto));
		tipoproducto.setClaseProductos(tipoproductoDataAccess.getClaseProductos(connexion,tipoproducto));
		tipoproducto.setProductos(tipoproductoDataAccess.getProductos(connexion,tipoproducto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoproducto.setEmpresa(tipoproductoDataAccess.getEmpresa(connexion,tipoproducto));
				continue;
			}

			if(clas.clas.equals(ModeloProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproducto.setModeloProductos(tipoproductoDataAccess.getModeloProductos(connexion,tipoproducto));

				if(this.isConDeep) {
					ModeloProductoLogic modeloproductoLogic= new ModeloProductoLogic(this.connexion);
					modeloproductoLogic.setModeloProductos(tipoproducto.getModeloProductos());
					ArrayList<Classe> classesLocal=ModeloProductoConstantesFunciones.getClassesForeignKeysOfModeloProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					modeloproductoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ModeloProductoConstantesFunciones.refrescarForeignKeysDescripcionesModeloProducto(modeloproductoLogic.getModeloProductos());
					tipoproducto.setModeloProductos(modeloproductoLogic.getModeloProductos());
				}

				continue;
			}

			if(clas.clas.equals(MaterialProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproducto.setMaterialProductos(tipoproductoDataAccess.getMaterialProductos(connexion,tipoproducto));

				if(this.isConDeep) {
					MaterialProductoLogic materialproductoLogic= new MaterialProductoLogic(this.connexion);
					materialproductoLogic.setMaterialProductos(tipoproducto.getMaterialProductos());
					ArrayList<Classe> classesLocal=MaterialProductoConstantesFunciones.getClassesForeignKeysOfMaterialProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					materialproductoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					MaterialProductoConstantesFunciones.refrescarForeignKeysDescripcionesMaterialProducto(materialproductoLogic.getMaterialProductos());
					tipoproducto.setMaterialProductos(materialproductoLogic.getMaterialProductos());
				}

				continue;
			}

			if(clas.clas.equals(MarcaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproducto.setMarcaProductos(tipoproductoDataAccess.getMarcaProductos(connexion,tipoproducto));

				if(this.isConDeep) {
					MarcaProductoLogic marcaproductoLogic= new MarcaProductoLogic(this.connexion);
					marcaproductoLogic.setMarcaProductos(tipoproducto.getMarcaProductos());
					ArrayList<Classe> classesLocal=MarcaProductoConstantesFunciones.getClassesForeignKeysOfMarcaProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					marcaproductoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(marcaproductoLogic.getMarcaProductos());
					tipoproducto.setMarcaProductos(marcaproductoLogic.getMarcaProductos());
				}

				continue;
			}

			if(clas.clas.equals(SegmentoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproducto.setSegmentoProductos(tipoproductoDataAccess.getSegmentoProductos(connexion,tipoproducto));

				if(this.isConDeep) {
					SegmentoProductoLogic segmentoproductoLogic= new SegmentoProductoLogic(this.connexion);
					segmentoproductoLogic.setSegmentoProductos(tipoproducto.getSegmentoProductos());
					ArrayList<Classe> classesLocal=SegmentoProductoConstantesFunciones.getClassesForeignKeysOfSegmentoProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					segmentoproductoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(segmentoproductoLogic.getSegmentoProductos());
					tipoproducto.setSegmentoProductos(segmentoproductoLogic.getSegmentoProductos());
				}

				continue;
			}

			if(clas.clas.equals(ColorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproducto.setColorProductos(tipoproductoDataAccess.getColorProductos(connexion,tipoproducto));

				if(this.isConDeep) {
					ColorProductoLogic colorproductoLogic= new ColorProductoLogic(this.connexion);
					colorproductoLogic.setColorProductos(tipoproducto.getColorProductos());
					ArrayList<Classe> classesLocal=ColorProductoConstantesFunciones.getClassesForeignKeysOfColorProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					colorproductoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ColorProductoConstantesFunciones.refrescarForeignKeysDescripcionesColorProducto(colorproductoLogic.getColorProductos());
					tipoproducto.setColorProductos(colorproductoLogic.getColorProductos());
				}

				continue;
			}

			if(clas.clas.equals(EfectoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproducto.setEfectoProductos(tipoproductoDataAccess.getEfectoProductos(connexion,tipoproducto));

				if(this.isConDeep) {
					EfectoProductoLogic efectoproductoLogic= new EfectoProductoLogic(this.connexion);
					efectoproductoLogic.setEfectoProductos(tipoproducto.getEfectoProductos());
					ArrayList<Classe> classesLocal=EfectoProductoConstantesFunciones.getClassesForeignKeysOfEfectoProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					efectoproductoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(efectoproductoLogic.getEfectoProductos());
					tipoproducto.setEfectoProductos(efectoproductoLogic.getEfectoProductos());
				}

				continue;
			}

			if(clas.clas.equals(TallaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproducto.setTallaProductos(tipoproductoDataAccess.getTallaProductos(connexion,tipoproducto));

				if(this.isConDeep) {
					TallaProductoLogic tallaproductoLogic= new TallaProductoLogic(this.connexion);
					tallaproductoLogic.setTallaProductos(tipoproducto.getTallaProductos());
					ArrayList<Classe> classesLocal=TallaProductoConstantesFunciones.getClassesForeignKeysOfTallaProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					tallaproductoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TallaProductoConstantesFunciones.refrescarForeignKeysDescripcionesTallaProducto(tallaproductoLogic.getTallaProductos());
					tipoproducto.setTallaProductos(tallaproductoLogic.getTallaProductos());
				}

				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproducto.setParametroInventarioDefectos(tipoproductoDataAccess.getParametroInventarioDefectos(connexion,tipoproducto));

				if(this.isConDeep) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(this.connexion);
					parametroinventariodefectoLogic.setParametroInventarioDefectos(tipoproducto.getParametroInventarioDefectos());
					ArrayList<Classe> classesLocal=ParametroInventarioDefectoConstantesFunciones.getClassesForeignKeysOfParametroInventarioDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametroinventariodefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(parametroinventariodefectoLogic.getParametroInventarioDefectos());
					tipoproducto.setParametroInventarioDefectos(parametroinventariodefectoLogic.getParametroInventarioDefectos());
				}

				continue;
			}

			if(clas.clas.equals(ClaseProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproducto.setClaseProductos(tipoproductoDataAccess.getClaseProductos(connexion,tipoproducto));

				if(this.isConDeep) {
					ClaseProductoLogic claseproductoLogic= new ClaseProductoLogic(this.connexion);
					claseproductoLogic.setClaseProductos(tipoproducto.getClaseProductos());
					ArrayList<Classe> classesLocal=ClaseProductoConstantesFunciones.getClassesForeignKeysOfClaseProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					claseproductoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClaseProductoConstantesFunciones.refrescarForeignKeysDescripcionesClaseProducto(claseproductoLogic.getClaseProductos());
					tipoproducto.setClaseProductos(claseproductoLogic.getClaseProductos());
				}

				continue;
			}

			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproducto.setProductos(tipoproductoDataAccess.getProductos(connexion,tipoproducto));

				if(this.isConDeep) {
					ProductoLogic productoLogic= new ProductoLogic(this.connexion);
					productoLogic.setProductos(tipoproducto.getProductos());
					ArrayList<Classe> classesLocal=ProductoConstantesFunciones.getClassesForeignKeysOfProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(productoLogic.getProductos());
					tipoproducto.setProductos(productoLogic.getProductos());
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
			tipoproducto.setEmpresa(tipoproductoDataAccess.getEmpresa(connexion,tipoproducto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ModeloProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ModeloProducto.class));
			tipoproducto.setModeloProductos(tipoproductoDataAccess.getModeloProductos(connexion,tipoproducto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MaterialProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(MaterialProducto.class));
			tipoproducto.setMaterialProductos(tipoproductoDataAccess.getMaterialProductos(connexion,tipoproducto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MarcaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(MarcaProducto.class));
			tipoproducto.setMarcaProductos(tipoproductoDataAccess.getMarcaProductos(connexion,tipoproducto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SegmentoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SegmentoProducto.class));
			tipoproducto.setSegmentoProductos(tipoproductoDataAccess.getSegmentoProductos(connexion,tipoproducto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ColorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ColorProducto.class));
			tipoproducto.setColorProductos(tipoproductoDataAccess.getColorProductos(connexion,tipoproducto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EfectoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EfectoProducto.class));
			tipoproducto.setEfectoProductos(tipoproductoDataAccess.getEfectoProductos(connexion,tipoproducto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TallaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TallaProducto.class));
			tipoproducto.setTallaProductos(tipoproductoDataAccess.getTallaProductos(connexion,tipoproducto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroInventarioDefecto.class));
			tipoproducto.setParametroInventarioDefectos(tipoproductoDataAccess.getParametroInventarioDefectos(connexion,tipoproducto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ClaseProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ClaseProducto.class));
			tipoproducto.setClaseProductos(tipoproductoDataAccess.getClaseProductos(connexion,tipoproducto));
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
			tipoproducto.setProductos(tipoproductoDataAccess.getProductos(connexion,tipoproducto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoproducto.setEmpresa(tipoproductoDataAccess.getEmpresa(connexion,tipoproducto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoproducto.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipoproducto.setModeloProductos(tipoproductoDataAccess.getModeloProductos(connexion,tipoproducto));

		for(ModeloProducto modeloproducto:tipoproducto.getModeloProductos()) {
			ModeloProductoLogic modeloproductoLogic= new ModeloProductoLogic(connexion);
			modeloproductoLogic.deepLoad(modeloproducto,isDeep,deepLoadType,clases);
		}

		tipoproducto.setMaterialProductos(tipoproductoDataAccess.getMaterialProductos(connexion,tipoproducto));

		for(MaterialProducto materialproducto:tipoproducto.getMaterialProductos()) {
			MaterialProductoLogic materialproductoLogic= new MaterialProductoLogic(connexion);
			materialproductoLogic.deepLoad(materialproducto,isDeep,deepLoadType,clases);
		}

		tipoproducto.setMarcaProductos(tipoproductoDataAccess.getMarcaProductos(connexion,tipoproducto));

		for(MarcaProducto marcaproducto:tipoproducto.getMarcaProductos()) {
			MarcaProductoLogic marcaproductoLogic= new MarcaProductoLogic(connexion);
			marcaproductoLogic.deepLoad(marcaproducto,isDeep,deepLoadType,clases);
		}

		tipoproducto.setSegmentoProductos(tipoproductoDataAccess.getSegmentoProductos(connexion,tipoproducto));

		for(SegmentoProducto segmentoproducto:tipoproducto.getSegmentoProductos()) {
			SegmentoProductoLogic segmentoproductoLogic= new SegmentoProductoLogic(connexion);
			segmentoproductoLogic.deepLoad(segmentoproducto,isDeep,deepLoadType,clases);
		}

		tipoproducto.setColorProductos(tipoproductoDataAccess.getColorProductos(connexion,tipoproducto));

		for(ColorProducto colorproducto:tipoproducto.getColorProductos()) {
			ColorProductoLogic colorproductoLogic= new ColorProductoLogic(connexion);
			colorproductoLogic.deepLoad(colorproducto,isDeep,deepLoadType,clases);
		}

		tipoproducto.setEfectoProductos(tipoproductoDataAccess.getEfectoProductos(connexion,tipoproducto));

		for(EfectoProducto efectoproducto:tipoproducto.getEfectoProductos()) {
			EfectoProductoLogic efectoproductoLogic= new EfectoProductoLogic(connexion);
			efectoproductoLogic.deepLoad(efectoproducto,isDeep,deepLoadType,clases);
		}

		tipoproducto.setTallaProductos(tipoproductoDataAccess.getTallaProductos(connexion,tipoproducto));

		for(TallaProducto tallaproducto:tipoproducto.getTallaProductos()) {
			TallaProductoLogic tallaproductoLogic= new TallaProductoLogic(connexion);
			tallaproductoLogic.deepLoad(tallaproducto,isDeep,deepLoadType,clases);
		}

		tipoproducto.setParametroInventarioDefectos(tipoproductoDataAccess.getParametroInventarioDefectos(connexion,tipoproducto));

		for(ParametroInventarioDefecto parametroinventariodefecto:tipoproducto.getParametroInventarioDefectos()) {
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
			parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
		}

		tipoproducto.setClaseProductos(tipoproductoDataAccess.getClaseProductos(connexion,tipoproducto));

		for(ClaseProducto claseproducto:tipoproducto.getClaseProductos()) {
			ClaseProductoLogic claseproductoLogic= new ClaseProductoLogic(connexion);
			claseproductoLogic.deepLoad(claseproducto,isDeep,deepLoadType,clases);
		}

		tipoproducto.setProductos(tipoproductoDataAccess.getProductos(connexion,tipoproducto));

		for(Producto producto:tipoproducto.getProductos()) {
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(producto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoproducto.setEmpresa(tipoproductoDataAccess.getEmpresa(connexion,tipoproducto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ModeloProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproducto.setModeloProductos(tipoproductoDataAccess.getModeloProductos(connexion,tipoproducto));

				for(ModeloProducto modeloproducto:tipoproducto.getModeloProductos()) {
					ModeloProductoLogic modeloproductoLogic= new ModeloProductoLogic(connexion);
					modeloproductoLogic.deepLoad(modeloproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(MaterialProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproducto.setMaterialProductos(tipoproductoDataAccess.getMaterialProductos(connexion,tipoproducto));

				for(MaterialProducto materialproducto:tipoproducto.getMaterialProductos()) {
					MaterialProductoLogic materialproductoLogic= new MaterialProductoLogic(connexion);
					materialproductoLogic.deepLoad(materialproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(MarcaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproducto.setMarcaProductos(tipoproductoDataAccess.getMarcaProductos(connexion,tipoproducto));

				for(MarcaProducto marcaproducto:tipoproducto.getMarcaProductos()) {
					MarcaProductoLogic marcaproductoLogic= new MarcaProductoLogic(connexion);
					marcaproductoLogic.deepLoad(marcaproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SegmentoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproducto.setSegmentoProductos(tipoproductoDataAccess.getSegmentoProductos(connexion,tipoproducto));

				for(SegmentoProducto segmentoproducto:tipoproducto.getSegmentoProductos()) {
					SegmentoProductoLogic segmentoproductoLogic= new SegmentoProductoLogic(connexion);
					segmentoproductoLogic.deepLoad(segmentoproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ColorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproducto.setColorProductos(tipoproductoDataAccess.getColorProductos(connexion,tipoproducto));

				for(ColorProducto colorproducto:tipoproducto.getColorProductos()) {
					ColorProductoLogic colorproductoLogic= new ColorProductoLogic(connexion);
					colorproductoLogic.deepLoad(colorproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EfectoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproducto.setEfectoProductos(tipoproductoDataAccess.getEfectoProductos(connexion,tipoproducto));

				for(EfectoProducto efectoproducto:tipoproducto.getEfectoProductos()) {
					EfectoProductoLogic efectoproductoLogic= new EfectoProductoLogic(connexion);
					efectoproductoLogic.deepLoad(efectoproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TallaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproducto.setTallaProductos(tipoproductoDataAccess.getTallaProductos(connexion,tipoproducto));

				for(TallaProducto tallaproducto:tipoproducto.getTallaProductos()) {
					TallaProductoLogic tallaproductoLogic= new TallaProductoLogic(connexion);
					tallaproductoLogic.deepLoad(tallaproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproducto.setParametroInventarioDefectos(tipoproductoDataAccess.getParametroInventarioDefectos(connexion,tipoproducto));

				for(ParametroInventarioDefecto parametroinventariodefecto:tipoproducto.getParametroInventarioDefectos()) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
					parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ClaseProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproducto.setClaseProductos(tipoproductoDataAccess.getClaseProductos(connexion,tipoproducto));

				for(ClaseProducto claseproducto:tipoproducto.getClaseProductos()) {
					ClaseProductoLogic claseproductoLogic= new ClaseProductoLogic(connexion);
					claseproductoLogic.deepLoad(claseproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproducto.setProductos(tipoproductoDataAccess.getProductos(connexion,tipoproducto));

				for(Producto producto:tipoproducto.getProductos()) {
					ProductoLogic productoLogic= new ProductoLogic(connexion);
					productoLogic.deepLoad(producto,isDeep,deepLoadType,clases);
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
			tipoproducto.setEmpresa(tipoproductoDataAccess.getEmpresa(connexion,tipoproducto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoproducto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ModeloProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ModeloProducto.class));
			tipoproducto.setModeloProductos(tipoproductoDataAccess.getModeloProductos(connexion,tipoproducto));

			for(ModeloProducto modeloproducto:tipoproducto.getModeloProductos()) {
				ModeloProductoLogic modeloproductoLogic= new ModeloProductoLogic(connexion);
				modeloproductoLogic.deepLoad(modeloproducto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MaterialProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(MaterialProducto.class));
			tipoproducto.setMaterialProductos(tipoproductoDataAccess.getMaterialProductos(connexion,tipoproducto));

			for(MaterialProducto materialproducto:tipoproducto.getMaterialProductos()) {
				MaterialProductoLogic materialproductoLogic= new MaterialProductoLogic(connexion);
				materialproductoLogic.deepLoad(materialproducto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MarcaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(MarcaProducto.class));
			tipoproducto.setMarcaProductos(tipoproductoDataAccess.getMarcaProductos(connexion,tipoproducto));

			for(MarcaProducto marcaproducto:tipoproducto.getMarcaProductos()) {
				MarcaProductoLogic marcaproductoLogic= new MarcaProductoLogic(connexion);
				marcaproductoLogic.deepLoad(marcaproducto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SegmentoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SegmentoProducto.class));
			tipoproducto.setSegmentoProductos(tipoproductoDataAccess.getSegmentoProductos(connexion,tipoproducto));

			for(SegmentoProducto segmentoproducto:tipoproducto.getSegmentoProductos()) {
				SegmentoProductoLogic segmentoproductoLogic= new SegmentoProductoLogic(connexion);
				segmentoproductoLogic.deepLoad(segmentoproducto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ColorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ColorProducto.class));
			tipoproducto.setColorProductos(tipoproductoDataAccess.getColorProductos(connexion,tipoproducto));

			for(ColorProducto colorproducto:tipoproducto.getColorProductos()) {
				ColorProductoLogic colorproductoLogic= new ColorProductoLogic(connexion);
				colorproductoLogic.deepLoad(colorproducto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EfectoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EfectoProducto.class));
			tipoproducto.setEfectoProductos(tipoproductoDataAccess.getEfectoProductos(connexion,tipoproducto));

			for(EfectoProducto efectoproducto:tipoproducto.getEfectoProductos()) {
				EfectoProductoLogic efectoproductoLogic= new EfectoProductoLogic(connexion);
				efectoproductoLogic.deepLoad(efectoproducto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TallaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TallaProducto.class));
			tipoproducto.setTallaProductos(tipoproductoDataAccess.getTallaProductos(connexion,tipoproducto));

			for(TallaProducto tallaproducto:tipoproducto.getTallaProductos()) {
				TallaProductoLogic tallaproductoLogic= new TallaProductoLogic(connexion);
				tallaproductoLogic.deepLoad(tallaproducto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroInventarioDefecto.class));
			tipoproducto.setParametroInventarioDefectos(tipoproductoDataAccess.getParametroInventarioDefectos(connexion,tipoproducto));

			for(ParametroInventarioDefecto parametroinventariodefecto:tipoproducto.getParametroInventarioDefectos()) {
				ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
				parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ClaseProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ClaseProducto.class));
			tipoproducto.setClaseProductos(tipoproductoDataAccess.getClaseProductos(connexion,tipoproducto));

			for(ClaseProducto claseproducto:tipoproducto.getClaseProductos()) {
				ClaseProductoLogic claseproductoLogic= new ClaseProductoLogic(connexion);
				claseproductoLogic.deepLoad(claseproducto,isDeep,deepLoadType,clases);
			}
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
			tipoproducto.setProductos(tipoproductoDataAccess.getProductos(connexion,tipoproducto));

			for(Producto producto:tipoproducto.getProductos()) {
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(producto,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoProducto tipoproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoProductoLogicAdditional.updateTipoProductoToSave(tipoproducto,this.arrDatoGeneral);
			
TipoProductoDataAccess.save(tipoproducto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoproducto.getEmpresa(),connexion);

		for(ModeloProducto modeloproducto:tipoproducto.getModeloProductos()) {
			modeloproducto.setid_tipo_producto(tipoproducto.getId());
			ModeloProductoDataAccess.save(modeloproducto,connexion);
		}

		for(MaterialProducto materialproducto:tipoproducto.getMaterialProductos()) {
			materialproducto.setid_tipo_producto(tipoproducto.getId());
			MaterialProductoDataAccess.save(materialproducto,connexion);
		}

		for(MarcaProducto marcaproducto:tipoproducto.getMarcaProductos()) {
			marcaproducto.setid_tipo_producto(tipoproducto.getId());
			MarcaProductoDataAccess.save(marcaproducto,connexion);
		}

		for(SegmentoProducto segmentoproducto:tipoproducto.getSegmentoProductos()) {
			segmentoproducto.setid_tipo_producto(tipoproducto.getId());
			SegmentoProductoDataAccess.save(segmentoproducto,connexion);
		}

		for(ColorProducto colorproducto:tipoproducto.getColorProductos()) {
			colorproducto.setid_tipo_producto(tipoproducto.getId());
			ColorProductoDataAccess.save(colorproducto,connexion);
		}

		for(EfectoProducto efectoproducto:tipoproducto.getEfectoProductos()) {
			efectoproducto.setid_tipo_producto(tipoproducto.getId());
			EfectoProductoDataAccess.save(efectoproducto,connexion);
		}

		for(TallaProducto tallaproducto:tipoproducto.getTallaProductos()) {
			tallaproducto.setid_tipo_producto(tipoproducto.getId());
			TallaProductoDataAccess.save(tallaproducto,connexion);
		}

		for(ParametroInventarioDefecto parametroinventariodefecto:tipoproducto.getParametroInventarioDefectos()) {
			parametroinventariodefecto.setid_tipo_producto(tipoproducto.getId());
			ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
		}

		for(ClaseProducto claseproducto:tipoproducto.getClaseProductos()) {
			claseproducto.setid_tipo_producto(tipoproducto.getId());
			ClaseProductoDataAccess.save(claseproducto,connexion);
		}

		for(Producto producto:tipoproducto.getProductos()) {
			producto.setid_tipo_producto(tipoproducto.getId());
			ProductoDataAccess.save(producto,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoproducto.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(ModeloProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ModeloProducto modeloproducto:tipoproducto.getModeloProductos()) {
					modeloproducto.setid_tipo_producto(tipoproducto.getId());
					ModeloProductoDataAccess.save(modeloproducto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(MaterialProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(MaterialProducto materialproducto:tipoproducto.getMaterialProductos()) {
					materialproducto.setid_tipo_producto(tipoproducto.getId());
					MaterialProductoDataAccess.save(materialproducto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(MarcaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(MarcaProducto marcaproducto:tipoproducto.getMarcaProductos()) {
					marcaproducto.setid_tipo_producto(tipoproducto.getId());
					MarcaProductoDataAccess.save(marcaproducto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(SegmentoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SegmentoProducto segmentoproducto:tipoproducto.getSegmentoProductos()) {
					segmentoproducto.setid_tipo_producto(tipoproducto.getId());
					SegmentoProductoDataAccess.save(segmentoproducto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ColorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ColorProducto colorproducto:tipoproducto.getColorProductos()) {
					colorproducto.setid_tipo_producto(tipoproducto.getId());
					ColorProductoDataAccess.save(colorproducto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(EfectoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EfectoProducto efectoproducto:tipoproducto.getEfectoProductos()) {
					efectoproducto.setid_tipo_producto(tipoproducto.getId());
					EfectoProductoDataAccess.save(efectoproducto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(TallaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TallaProducto tallaproducto:tipoproducto.getTallaProductos()) {
					tallaproducto.setid_tipo_producto(tipoproducto.getId());
					TallaProductoDataAccess.save(tallaproducto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroInventarioDefecto parametroinventariodefecto:tipoproducto.getParametroInventarioDefectos()) {
					parametroinventariodefecto.setid_tipo_producto(tipoproducto.getId());
					ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ClaseProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ClaseProducto claseproducto:tipoproducto.getClaseProductos()) {
					claseproducto.setid_tipo_producto(tipoproducto.getId());
					ClaseProductoDataAccess.save(claseproducto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Producto producto:tipoproducto.getProductos()) {
					producto.setid_tipo_producto(tipoproducto.getId());
					ProductoDataAccess.save(producto,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoproducto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoproducto.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(ModeloProducto modeloproducto:tipoproducto.getModeloProductos()) {
			ModeloProductoLogic modeloproductoLogic= new ModeloProductoLogic(connexion);
			modeloproducto.setid_tipo_producto(tipoproducto.getId());
			ModeloProductoDataAccess.save(modeloproducto,connexion);
			modeloproductoLogic.deepSave(modeloproducto,isDeep,deepLoadType,clases);
		}

		for(MaterialProducto materialproducto:tipoproducto.getMaterialProductos()) {
			MaterialProductoLogic materialproductoLogic= new MaterialProductoLogic(connexion);
			materialproducto.setid_tipo_producto(tipoproducto.getId());
			MaterialProductoDataAccess.save(materialproducto,connexion);
			materialproductoLogic.deepSave(materialproducto,isDeep,deepLoadType,clases);
		}

		for(MarcaProducto marcaproducto:tipoproducto.getMarcaProductos()) {
			MarcaProductoLogic marcaproductoLogic= new MarcaProductoLogic(connexion);
			marcaproducto.setid_tipo_producto(tipoproducto.getId());
			MarcaProductoDataAccess.save(marcaproducto,connexion);
			marcaproductoLogic.deepSave(marcaproducto,isDeep,deepLoadType,clases);
		}

		for(SegmentoProducto segmentoproducto:tipoproducto.getSegmentoProductos()) {
			SegmentoProductoLogic segmentoproductoLogic= new SegmentoProductoLogic(connexion);
			segmentoproducto.setid_tipo_producto(tipoproducto.getId());
			SegmentoProductoDataAccess.save(segmentoproducto,connexion);
			segmentoproductoLogic.deepSave(segmentoproducto,isDeep,deepLoadType,clases);
		}

		for(ColorProducto colorproducto:tipoproducto.getColorProductos()) {
			ColorProductoLogic colorproductoLogic= new ColorProductoLogic(connexion);
			colorproducto.setid_tipo_producto(tipoproducto.getId());
			ColorProductoDataAccess.save(colorproducto,connexion);
			colorproductoLogic.deepSave(colorproducto,isDeep,deepLoadType,clases);
		}

		for(EfectoProducto efectoproducto:tipoproducto.getEfectoProductos()) {
			EfectoProductoLogic efectoproductoLogic= new EfectoProductoLogic(connexion);
			efectoproducto.setid_tipo_producto(tipoproducto.getId());
			EfectoProductoDataAccess.save(efectoproducto,connexion);
			efectoproductoLogic.deepSave(efectoproducto,isDeep,deepLoadType,clases);
		}

		for(TallaProducto tallaproducto:tipoproducto.getTallaProductos()) {
			TallaProductoLogic tallaproductoLogic= new TallaProductoLogic(connexion);
			tallaproducto.setid_tipo_producto(tipoproducto.getId());
			TallaProductoDataAccess.save(tallaproducto,connexion);
			tallaproductoLogic.deepSave(tallaproducto,isDeep,deepLoadType,clases);
		}

		for(ParametroInventarioDefecto parametroinventariodefecto:tipoproducto.getParametroInventarioDefectos()) {
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
			parametroinventariodefecto.setid_tipo_producto(tipoproducto.getId());
			ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
			parametroinventariodefectoLogic.deepSave(parametroinventariodefecto,isDeep,deepLoadType,clases);
		}

		for(ClaseProducto claseproducto:tipoproducto.getClaseProductos()) {
			ClaseProductoLogic claseproductoLogic= new ClaseProductoLogic(connexion);
			claseproducto.setid_tipo_producto(tipoproducto.getId());
			ClaseProductoDataAccess.save(claseproducto,connexion);
			claseproductoLogic.deepSave(claseproducto,isDeep,deepLoadType,clases);
		}

		for(Producto producto:tipoproducto.getProductos()) {
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			producto.setid_tipo_producto(tipoproducto.getId());
			ProductoDataAccess.save(producto,connexion);
			productoLogic.deepSave(producto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoproducto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipoproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ModeloProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ModeloProducto modeloproducto:tipoproducto.getModeloProductos()) {
					ModeloProductoLogic modeloproductoLogic= new ModeloProductoLogic(connexion);
					modeloproducto.setid_tipo_producto(tipoproducto.getId());
					ModeloProductoDataAccess.save(modeloproducto,connexion);
					modeloproductoLogic.deepSave(modeloproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(MaterialProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(MaterialProducto materialproducto:tipoproducto.getMaterialProductos()) {
					MaterialProductoLogic materialproductoLogic= new MaterialProductoLogic(connexion);
					materialproducto.setid_tipo_producto(tipoproducto.getId());
					MaterialProductoDataAccess.save(materialproducto,connexion);
					materialproductoLogic.deepSave(materialproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(MarcaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(MarcaProducto marcaproducto:tipoproducto.getMarcaProductos()) {
					MarcaProductoLogic marcaproductoLogic= new MarcaProductoLogic(connexion);
					marcaproducto.setid_tipo_producto(tipoproducto.getId());
					MarcaProductoDataAccess.save(marcaproducto,connexion);
					marcaproductoLogic.deepSave(marcaproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SegmentoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SegmentoProducto segmentoproducto:tipoproducto.getSegmentoProductos()) {
					SegmentoProductoLogic segmentoproductoLogic= new SegmentoProductoLogic(connexion);
					segmentoproducto.setid_tipo_producto(tipoproducto.getId());
					SegmentoProductoDataAccess.save(segmentoproducto,connexion);
					segmentoproductoLogic.deepSave(segmentoproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ColorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ColorProducto colorproducto:tipoproducto.getColorProductos()) {
					ColorProductoLogic colorproductoLogic= new ColorProductoLogic(connexion);
					colorproducto.setid_tipo_producto(tipoproducto.getId());
					ColorProductoDataAccess.save(colorproducto,connexion);
					colorproductoLogic.deepSave(colorproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EfectoProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EfectoProducto efectoproducto:tipoproducto.getEfectoProductos()) {
					EfectoProductoLogic efectoproductoLogic= new EfectoProductoLogic(connexion);
					efectoproducto.setid_tipo_producto(tipoproducto.getId());
					EfectoProductoDataAccess.save(efectoproducto,connexion);
					efectoproductoLogic.deepSave(efectoproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TallaProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TallaProducto tallaproducto:tipoproducto.getTallaProductos()) {
					TallaProductoLogic tallaproductoLogic= new TallaProductoLogic(connexion);
					tallaproducto.setid_tipo_producto(tipoproducto.getId());
					TallaProductoDataAccess.save(tallaproducto,connexion);
					tallaproductoLogic.deepSave(tallaproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroInventarioDefecto parametroinventariodefecto:tipoproducto.getParametroInventarioDefectos()) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
					parametroinventariodefecto.setid_tipo_producto(tipoproducto.getId());
					ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
					parametroinventariodefectoLogic.deepSave(parametroinventariodefecto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ClaseProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ClaseProducto claseproducto:tipoproducto.getClaseProductos()) {
					ClaseProductoLogic claseproductoLogic= new ClaseProductoLogic(connexion);
					claseproducto.setid_tipo_producto(tipoproducto.getId());
					ClaseProductoDataAccess.save(claseproducto,connexion);
					claseproductoLogic.deepSave(claseproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Producto producto:tipoproducto.getProductos()) {
					ProductoLogic productoLogic= new ProductoLogic(connexion);
					producto.setid_tipo_producto(tipoproducto.getId());
					ProductoDataAccess.save(producto,connexion);
					productoLogic.deepSave(producto,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoProducto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(tipoproducto);
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
			this.deepLoad(this.tipoproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoProducto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoproductos!=null) {
				for(TipoProducto tipoproducto:tipoproductos) {
					this.deepLoad(tipoproducto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(tipoproductos);
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
			if(tipoproductos!=null) {
				for(TipoProducto tipoproducto:tipoproductos) {
					this.deepLoad(tipoproducto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(tipoproductos);
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
			this.getNewConnexionToDeep(TipoProducto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoproducto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoProducto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoproductos!=null) {
				for(TipoProducto tipoproducto:tipoproductos) {
					this.deepSave(tipoproducto,isDeep,deepLoadType,clases);
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
			if(tipoproductos!=null) {
				for(TipoProducto tipoproducto:tipoproductos) {
					this.deepSave(tipoproducto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoProductosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoProductoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoproductos=tipoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoProductosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoProductoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoproductos=tipoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoProductosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoProductoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoproductos=tipoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoProductosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoProductoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoproductos=tipoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoProductosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoproductos=tipoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoProductosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoproductos=tipoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoProductoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProducto(this.tipoproductos);
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
			if(TipoProductoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProductoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoProducto tipoproducto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoProductoConstantesFunciones.ISCONAUDITORIA) {
				if(tipoproducto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProductoDataAccess.TABLENAME, tipoproducto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoProductoLogic.registrarAuditoriaDetallesTipoProducto(connexion,tipoproducto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoproducto.getIsDeleted()) {
					/*if(!tipoproducto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoProductoDataAccess.TABLENAME, tipoproducto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoProductoLogic.registrarAuditoriaDetallesTipoProducto(connexion,tipoproducto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProductoDataAccess.TABLENAME, tipoproducto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoproducto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProductoDataAccess.TABLENAME, tipoproducto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoProductoLogic.registrarAuditoriaDetallesTipoProducto(connexion,tipoproducto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoProducto(Connexion connexion,TipoProducto tipoproducto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoproducto.getIsNew()||!tipoproducto.getid_empresa().equals(tipoproducto.getTipoProductoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoproducto.getTipoProductoOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoproducto.getTipoProductoOriginal().getid_empresa().toString();
				}
				if(tipoproducto.getid_empresa()!=null)
				{
					strValorNuevo=tipoproducto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProductoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoproducto.getIsNew()||!tipoproducto.getcodigo().equals(tipoproducto.getTipoProductoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoproducto.getTipoProductoOriginal().getcodigo()!=null)
				{
					strValorActual=tipoproducto.getTipoProductoOriginal().getcodigo();
				}
				if(tipoproducto.getcodigo()!=null)
				{
					strValorNuevo=tipoproducto.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProductoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoproducto.getIsNew()||!tipoproducto.getnombre().equals(tipoproducto.getTipoProductoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoproducto.getTipoProductoOriginal().getnombre()!=null)
				{
					strValorActual=tipoproducto.getTipoProductoOriginal().getnombre();
				}
				if(tipoproducto.getnombre()!=null)
				{
					strValorNuevo=tipoproducto.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProductoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipoproducto.getIsNew()||!tipoproducto.getdescripcion().equals(tipoproducto.getTipoProductoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoproducto.getTipoProductoOriginal().getdescripcion()!=null)
				{
					strValorActual=tipoproducto.getTipoProductoOriginal().getdescripcion();
				}
				if(tipoproducto.getdescripcion()!=null)
				{
					strValorNuevo=tipoproducto.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProductoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoProductoRelacionesWithConnection(TipoProducto tipoproducto,List<ModeloProducto> modeloproductos,List<MaterialProducto> materialproductos,List<MarcaProducto> marcaproductos,List<SegmentoProducto> segmentoproductos,List<ColorProducto> colorproductos,List<EfectoProducto> efectoproductos,List<TallaProducto> tallaproductos,List<ParametroInventarioDefecto> parametroinventariodefectos,List<ClaseProducto> claseproductos,List<Producto> productos) throws Exception {

		if(!tipoproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoProductoRelacionesBase(tipoproducto,modeloproductos,materialproductos,marcaproductos,segmentoproductos,colorproductos,efectoproductos,tallaproductos,parametroinventariodefectos,claseproductos,productos,true);
		}
	}

	public void saveTipoProductoRelaciones(TipoProducto tipoproducto,List<ModeloProducto> modeloproductos,List<MaterialProducto> materialproductos,List<MarcaProducto> marcaproductos,List<SegmentoProducto> segmentoproductos,List<ColorProducto> colorproductos,List<EfectoProducto> efectoproductos,List<TallaProducto> tallaproductos,List<ParametroInventarioDefecto> parametroinventariodefectos,List<ClaseProducto> claseproductos,List<Producto> productos)throws Exception {

		if(!tipoproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoProductoRelacionesBase(tipoproducto,modeloproductos,materialproductos,marcaproductos,segmentoproductos,colorproductos,efectoproductos,tallaproductos,parametroinventariodefectos,claseproductos,productos,false);
		}
	}

	public void saveTipoProductoRelacionesBase(TipoProducto tipoproducto,List<ModeloProducto> modeloproductos,List<MaterialProducto> materialproductos,List<MarcaProducto> marcaproductos,List<SegmentoProducto> segmentoproductos,List<ColorProducto> colorproductos,List<EfectoProducto> efectoproductos,List<TallaProducto> tallaproductos,List<ParametroInventarioDefecto> parametroinventariodefectos,List<ClaseProducto> claseproductos,List<Producto> productos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoProducto-saveRelacionesWithConnection");}
	
			tipoproducto.setModeloProductos(modeloproductos);
			tipoproducto.setMaterialProductos(materialproductos);
			tipoproducto.setMarcaProductos(marcaproductos);
			tipoproducto.setSegmentoProductos(segmentoproductos);
			tipoproducto.setColorProductos(colorproductos);
			tipoproducto.setEfectoProductos(efectoproductos);
			tipoproducto.setTallaProductos(tallaproductos);
			tipoproducto.setParametroInventarioDefectos(parametroinventariodefectos);
			tipoproducto.setClaseProductos(claseproductos);
			tipoproducto.setProductos(productos);

			this.setTipoProducto(tipoproducto);

			if(TipoProductoLogicAdditional.validarSaveRelaciones(tipoproducto,this)) {

				TipoProductoLogicAdditional.updateRelacionesToSave(tipoproducto,this);

				if((tipoproducto.getIsNew()||tipoproducto.getIsChanged())&&!tipoproducto.getIsDeleted()) {
					this.saveTipoProducto();
					this.saveTipoProductoRelacionesDetalles(modeloproductos,materialproductos,marcaproductos,segmentoproductos,colorproductos,efectoproductos,tallaproductos,parametroinventariodefectos,claseproductos,productos);

				} else if(tipoproducto.getIsDeleted()) {
					this.saveTipoProductoRelacionesDetalles(modeloproductos,materialproductos,marcaproductos,segmentoproductos,colorproductos,efectoproductos,tallaproductos,parametroinventariodefectos,claseproductos,productos);
					this.saveTipoProducto();
				}

				TipoProductoLogicAdditional.updateRelacionesToSaveAfter(tipoproducto,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ModeloProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresModeloProductos(modeloproductos,true,true);
			MaterialProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresMaterialProductos(materialproductos,true,true);
			MarcaProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresMarcaProductos(marcaproductos,true,true);
			SegmentoProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresSegmentoProductos(segmentoproductos,true,true);
			ColorProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresColorProductos(colorproductos,true,true);
			EfectoProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresEfectoProductos(efectoproductos,true,true);
			TallaProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresTallaProductos(tallaproductos,true,true);
			ParametroInventarioDefectoConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroInventarioDefectos(parametroinventariodefectos,true,true);
			ClaseProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresClaseProductos(claseproductos,true,true);
			ProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresProductos(productos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoProductoRelacionesDetalles(List<ModeloProducto> modeloproductos,List<MaterialProducto> materialproductos,List<MarcaProducto> marcaproductos,List<SegmentoProducto> segmentoproductos,List<ColorProducto> colorproductos,List<EfectoProducto> efectoproductos,List<TallaProducto> tallaproductos,List<ParametroInventarioDefecto> parametroinventariodefectos,List<ClaseProducto> claseproductos,List<Producto> productos)throws Exception {
		try {
	

			Long idTipoProductoActual=this.getTipoProducto().getId();

			ModeloProductoLogic modeloproductoLogic_Desde_TipoProducto=new ModeloProductoLogic();
			modeloproductoLogic_Desde_TipoProducto.setModeloProductos(modeloproductos);

			modeloproductoLogic_Desde_TipoProducto.setConnexion(this.getConnexion());
			modeloproductoLogic_Desde_TipoProducto.setDatosCliente(this.datosCliente);

			for(ModeloProducto modeloproducto_Desde_TipoProducto:modeloproductoLogic_Desde_TipoProducto.getModeloProductos()) {
				modeloproducto_Desde_TipoProducto.setid_tipo_producto(idTipoProductoActual);

				modeloproductoLogic_Desde_TipoProducto.setModeloProducto(modeloproducto_Desde_TipoProducto);
				modeloproductoLogic_Desde_TipoProducto.saveModeloProducto();

				Long idModeloProductoActual=modeloproducto_Desde_TipoProducto.getId();

				ProductoLogic productoLogic_Desde_ModeloProducto=new ProductoLogic();

				if(modeloproducto_Desde_TipoProducto.getProductos()==null){
					modeloproducto_Desde_TipoProducto.setProductos(new ArrayList<Producto>());
				}

				productoLogic_Desde_ModeloProducto.setProductos(modeloproducto_Desde_TipoProducto.getProductos());

				productoLogic_Desde_ModeloProducto.setConnexion(this.getConnexion());
				productoLogic_Desde_ModeloProducto.setDatosCliente(this.datosCliente);

				for(Producto producto_Desde_ModeloProducto:productoLogic_Desde_ModeloProducto.getProductos()) {
					producto_Desde_ModeloProducto.setid_modelo_producto(idModeloProductoActual);

					productoLogic_Desde_ModeloProducto.setProducto(producto_Desde_ModeloProducto);
					productoLogic_Desde_ModeloProducto.saveProducto();
				}


				ParametroInventarioDefectoLogic parametroinventariodefectoLogic_Desde_ModeloProducto=new ParametroInventarioDefectoLogic();

				if(modeloproducto_Desde_TipoProducto.getParametroInventarioDefectos()==null){
					modeloproducto_Desde_TipoProducto.setParametroInventarioDefectos(new ArrayList<ParametroInventarioDefecto>());
				}

				parametroinventariodefectoLogic_Desde_ModeloProducto.setParametroInventarioDefectos(modeloproducto_Desde_TipoProducto.getParametroInventarioDefectos());

				parametroinventariodefectoLogic_Desde_ModeloProducto.setConnexion(this.getConnexion());
				parametroinventariodefectoLogic_Desde_ModeloProducto.setDatosCliente(this.datosCliente);

				for(ParametroInventarioDefecto parametroinventariodefecto_Desde_ModeloProducto:parametroinventariodefectoLogic_Desde_ModeloProducto.getParametroInventarioDefectos()) {
					parametroinventariodefecto_Desde_ModeloProducto.setid_modelo_producto(idModeloProductoActual);
				}

				parametroinventariodefectoLogic_Desde_ModeloProducto.saveParametroInventarioDefectos();
			}


			MaterialProductoLogic materialproductoLogic_Desde_TipoProducto=new MaterialProductoLogic();
			materialproductoLogic_Desde_TipoProducto.setMaterialProductos(materialproductos);

			materialproductoLogic_Desde_TipoProducto.setConnexion(this.getConnexion());
			materialproductoLogic_Desde_TipoProducto.setDatosCliente(this.datosCliente);

			for(MaterialProducto materialproducto_Desde_TipoProducto:materialproductoLogic_Desde_TipoProducto.getMaterialProductos()) {
				materialproducto_Desde_TipoProducto.setid_tipo_producto(idTipoProductoActual);

				materialproductoLogic_Desde_TipoProducto.setMaterialProducto(materialproducto_Desde_TipoProducto);
				materialproductoLogic_Desde_TipoProducto.saveMaterialProducto();

				Long idMaterialProductoActual=materialproducto_Desde_TipoProducto.getId();

				ProductoLogic productoLogic_Desde_MaterialProducto=new ProductoLogic();

				if(materialproducto_Desde_TipoProducto.getProductos()==null){
					materialproducto_Desde_TipoProducto.setProductos(new ArrayList<Producto>());
				}

				productoLogic_Desde_MaterialProducto.setProductos(materialproducto_Desde_TipoProducto.getProductos());

				productoLogic_Desde_MaterialProducto.setConnexion(this.getConnexion());
				productoLogic_Desde_MaterialProducto.setDatosCliente(this.datosCliente);

				for(Producto producto_Desde_MaterialProducto:productoLogic_Desde_MaterialProducto.getProductos()) {
					producto_Desde_MaterialProducto.setid_material_producto(idMaterialProductoActual);

					productoLogic_Desde_MaterialProducto.setProducto(producto_Desde_MaterialProducto);
					productoLogic_Desde_MaterialProducto.saveProducto();
				}


				ParametroInventarioDefectoLogic parametroinventariodefectoLogic_Desde_MaterialProducto=new ParametroInventarioDefectoLogic();

				if(materialproducto_Desde_TipoProducto.getParametroInventarioDefectos()==null){
					materialproducto_Desde_TipoProducto.setParametroInventarioDefectos(new ArrayList<ParametroInventarioDefecto>());
				}

				parametroinventariodefectoLogic_Desde_MaterialProducto.setParametroInventarioDefectos(materialproducto_Desde_TipoProducto.getParametroInventarioDefectos());

				parametroinventariodefectoLogic_Desde_MaterialProducto.setConnexion(this.getConnexion());
				parametroinventariodefectoLogic_Desde_MaterialProducto.setDatosCliente(this.datosCliente);

				for(ParametroInventarioDefecto parametroinventariodefecto_Desde_MaterialProducto:parametroinventariodefectoLogic_Desde_MaterialProducto.getParametroInventarioDefectos()) {
					parametroinventariodefecto_Desde_MaterialProducto.setid_material_producto(idMaterialProductoActual);
				}

				parametroinventariodefectoLogic_Desde_MaterialProducto.saveParametroInventarioDefectos();
			}


			MarcaProductoLogic marcaproductoLogic_Desde_TipoProducto=new MarcaProductoLogic();
			marcaproductoLogic_Desde_TipoProducto.setMarcaProductos(marcaproductos);

			marcaproductoLogic_Desde_TipoProducto.setConnexion(this.getConnexion());
			marcaproductoLogic_Desde_TipoProducto.setDatosCliente(this.datosCliente);

			for(MarcaProducto marcaproducto_Desde_TipoProducto:marcaproductoLogic_Desde_TipoProducto.getMarcaProductos()) {
				marcaproducto_Desde_TipoProducto.setid_tipo_producto(idTipoProductoActual);

				marcaproductoLogic_Desde_TipoProducto.setMarcaProducto(marcaproducto_Desde_TipoProducto);
				marcaproductoLogic_Desde_TipoProducto.saveMarcaProducto();

				Long idMarcaProductoActual=marcaproducto_Desde_TipoProducto.getId();

				ProductoLogic productoLogic_Desde_MarcaProducto=new ProductoLogic();

				if(marcaproducto_Desde_TipoProducto.getProductos()==null){
					marcaproducto_Desde_TipoProducto.setProductos(new ArrayList<Producto>());
				}

				productoLogic_Desde_MarcaProducto.setProductos(marcaproducto_Desde_TipoProducto.getProductos());

				productoLogic_Desde_MarcaProducto.setConnexion(this.getConnexion());
				productoLogic_Desde_MarcaProducto.setDatosCliente(this.datosCliente);

				for(Producto producto_Desde_MarcaProducto:productoLogic_Desde_MarcaProducto.getProductos()) {
					producto_Desde_MarcaProducto.setid_marca_producto(idMarcaProductoActual);

					productoLogic_Desde_MarcaProducto.setProducto(producto_Desde_MarcaProducto);
					productoLogic_Desde_MarcaProducto.saveProducto();
				}


				ParametroInventarioDefectoLogic parametroinventariodefectoLogic_Desde_MarcaProducto=new ParametroInventarioDefectoLogic();

				if(marcaproducto_Desde_TipoProducto.getParametroInventarioDefectos()==null){
					marcaproducto_Desde_TipoProducto.setParametroInventarioDefectos(new ArrayList<ParametroInventarioDefecto>());
				}

				parametroinventariodefectoLogic_Desde_MarcaProducto.setParametroInventarioDefectos(marcaproducto_Desde_TipoProducto.getParametroInventarioDefectos());

				parametroinventariodefectoLogic_Desde_MarcaProducto.setConnexion(this.getConnexion());
				parametroinventariodefectoLogic_Desde_MarcaProducto.setDatosCliente(this.datosCliente);

				for(ParametroInventarioDefecto parametroinventariodefecto_Desde_MarcaProducto:parametroinventariodefectoLogic_Desde_MarcaProducto.getParametroInventarioDefectos()) {
					parametroinventariodefecto_Desde_MarcaProducto.setid_marca_producto(idMarcaProductoActual);
				}

				parametroinventariodefectoLogic_Desde_MarcaProducto.saveParametroInventarioDefectos();
			}


			SegmentoProductoLogic segmentoproductoLogic_Desde_TipoProducto=new SegmentoProductoLogic();
			segmentoproductoLogic_Desde_TipoProducto.setSegmentoProductos(segmentoproductos);

			segmentoproductoLogic_Desde_TipoProducto.setConnexion(this.getConnexion());
			segmentoproductoLogic_Desde_TipoProducto.setDatosCliente(this.datosCliente);

			for(SegmentoProducto segmentoproducto_Desde_TipoProducto:segmentoproductoLogic_Desde_TipoProducto.getSegmentoProductos()) {
				segmentoproducto_Desde_TipoProducto.setid_tipo_producto(idTipoProductoActual);

				segmentoproductoLogic_Desde_TipoProducto.setSegmentoProducto(segmentoproducto_Desde_TipoProducto);
				segmentoproductoLogic_Desde_TipoProducto.saveSegmentoProducto();
			}


			ColorProductoLogic colorproductoLogic_Desde_TipoProducto=new ColorProductoLogic();
			colorproductoLogic_Desde_TipoProducto.setColorProductos(colorproductos);

			colorproductoLogic_Desde_TipoProducto.setConnexion(this.getConnexion());
			colorproductoLogic_Desde_TipoProducto.setDatosCliente(this.datosCliente);

			for(ColorProducto colorproducto_Desde_TipoProducto:colorproductoLogic_Desde_TipoProducto.getColorProductos()) {
				colorproducto_Desde_TipoProducto.setid_tipo_producto(idTipoProductoActual);

				colorproductoLogic_Desde_TipoProducto.setColorProducto(colorproducto_Desde_TipoProducto);
				colorproductoLogic_Desde_TipoProducto.saveColorProducto();
			}


			EfectoProductoLogic efectoproductoLogic_Desde_TipoProducto=new EfectoProductoLogic();
			efectoproductoLogic_Desde_TipoProducto.setEfectoProductos(efectoproductos);

			efectoproductoLogic_Desde_TipoProducto.setConnexion(this.getConnexion());
			efectoproductoLogic_Desde_TipoProducto.setDatosCliente(this.datosCliente);

			for(EfectoProducto efectoproducto_Desde_TipoProducto:efectoproductoLogic_Desde_TipoProducto.getEfectoProductos()) {
				efectoproducto_Desde_TipoProducto.setid_tipo_producto(idTipoProductoActual);

				efectoproductoLogic_Desde_TipoProducto.setEfectoProducto(efectoproducto_Desde_TipoProducto);
				efectoproductoLogic_Desde_TipoProducto.saveEfectoProducto();
			}


			TallaProductoLogic tallaproductoLogic_Desde_TipoProducto=new TallaProductoLogic();
			tallaproductoLogic_Desde_TipoProducto.setTallaProductos(tallaproductos);

			tallaproductoLogic_Desde_TipoProducto.setConnexion(this.getConnexion());
			tallaproductoLogic_Desde_TipoProducto.setDatosCliente(this.datosCliente);

			for(TallaProducto tallaproducto_Desde_TipoProducto:tallaproductoLogic_Desde_TipoProducto.getTallaProductos()) {
				tallaproducto_Desde_TipoProducto.setid_tipo_producto(idTipoProductoActual);

				tallaproductoLogic_Desde_TipoProducto.setTallaProducto(tallaproducto_Desde_TipoProducto);
				tallaproductoLogic_Desde_TipoProducto.saveTallaProducto();
			}


			ParametroInventarioDefectoLogic parametroinventariodefectoLogic_Desde_TipoProducto=new ParametroInventarioDefectoLogic();
			parametroinventariodefectoLogic_Desde_TipoProducto.setParametroInventarioDefectos(parametroinventariodefectos);

			parametroinventariodefectoLogic_Desde_TipoProducto.setConnexion(this.getConnexion());
			parametroinventariodefectoLogic_Desde_TipoProducto.setDatosCliente(this.datosCliente);

			for(ParametroInventarioDefecto parametroinventariodefecto_Desde_TipoProducto:parametroinventariodefectoLogic_Desde_TipoProducto.getParametroInventarioDefectos()) {
				parametroinventariodefecto_Desde_TipoProducto.setid_tipo_producto(idTipoProductoActual);
			}

			parametroinventariodefectoLogic_Desde_TipoProducto.saveParametroInventarioDefectos();

			ClaseProductoLogic claseproductoLogic_Desde_TipoProducto=new ClaseProductoLogic();
			claseproductoLogic_Desde_TipoProducto.setClaseProductos(claseproductos);

			claseproductoLogic_Desde_TipoProducto.setConnexion(this.getConnexion());
			claseproductoLogic_Desde_TipoProducto.setDatosCliente(this.datosCliente);

			for(ClaseProducto claseproducto_Desde_TipoProducto:claseproductoLogic_Desde_TipoProducto.getClaseProductos()) {
				claseproducto_Desde_TipoProducto.setid_tipo_producto(idTipoProductoActual);

				claseproductoLogic_Desde_TipoProducto.setClaseProducto(claseproducto_Desde_TipoProducto);
				claseproductoLogic_Desde_TipoProducto.saveClaseProducto();
			}


			ProductoLogic productoLogic_Desde_TipoProducto=new ProductoLogic();
			productoLogic_Desde_TipoProducto.setProductos(productos);

			productoLogic_Desde_TipoProducto.setConnexion(this.getConnexion());
			productoLogic_Desde_TipoProducto.setDatosCliente(this.datosCliente);

			for(Producto producto_Desde_TipoProducto:productoLogic_Desde_TipoProducto.getProductos()) {
				producto_Desde_TipoProducto.setid_tipo_producto(idTipoProductoActual);

				productoLogic_Desde_TipoProducto.setProducto(producto_Desde_TipoProducto);
				productoLogic_Desde_TipoProducto.saveProducto();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoProductoConstantesFunciones.getClassesForeignKeysOfTipoProducto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoProductoConstantesFunciones.getClassesRelationshipsOfTipoProducto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.inventario.util.BodegaProductoConstantesFunciones;
import com.bydan.erp.inventario.util.BodegaProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.BodegaProductoParameterGeneral;
import com.bydan.erp.inventario.business.entity.BodegaProducto;
import com.bydan.erp.inventario.business.logic.BodegaProductoLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

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
public class BodegaProductoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(BodegaProductoLogic.class);
	
	protected BodegaProductoDataAccess bodegaproductoDataAccess; 	
	protected BodegaProducto bodegaproducto;
	protected List<BodegaProducto> bodegaproductos;
	protected Object bodegaproductoObject;	
	protected List<Object> bodegaproductosObject;
	
	public static ClassValidator<BodegaProducto> bodegaproductoValidator = new ClassValidator<BodegaProducto>(BodegaProducto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected BodegaProductoLogicAdditional bodegaproductoLogicAdditional=null;
	
	public BodegaProductoLogicAdditional getBodegaProductoLogicAdditional() {
		return this.bodegaproductoLogicAdditional;
	}
	
	public void setBodegaProductoLogicAdditional(BodegaProductoLogicAdditional bodegaproductoLogicAdditional) {
		try {
			this.bodegaproductoLogicAdditional=bodegaproductoLogicAdditional;
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
	
	
	
	
	public  BodegaProductoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.bodegaproductoDataAccess = new BodegaProductoDataAccess();
			
			this.bodegaproductos= new ArrayList<BodegaProducto>();
			this.bodegaproducto= new BodegaProducto();
			
			this.bodegaproductoObject=new Object();
			this.bodegaproductosObject=new ArrayList<Object>();
				
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
			
			this.bodegaproductoDataAccess.setConnexionType(this.connexionType);
			this.bodegaproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  BodegaProductoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.bodegaproductoDataAccess = new BodegaProductoDataAccess();
			this.bodegaproductos= new ArrayList<BodegaProducto>();
			this.bodegaproducto= new BodegaProducto();
			this.bodegaproductoObject=new Object();
			this.bodegaproductosObject=new ArrayList<Object>();
			
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
			
			this.bodegaproductoDataAccess.setConnexionType(this.connexionType);
			this.bodegaproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public BodegaProducto getBodegaProducto() throws Exception {	
		BodegaProductoLogicAdditional.checkBodegaProductoToGet(bodegaproducto,this.datosCliente,this.arrDatoGeneral);
		BodegaProductoLogicAdditional.updateBodegaProductoToGet(bodegaproducto,this.arrDatoGeneral);
		
		return bodegaproducto;
	}
		
	public void setBodegaProducto(BodegaProducto newBodegaProducto) {
		this.bodegaproducto = newBodegaProducto;
	}
	
	public BodegaProductoDataAccess getBodegaProductoDataAccess() {
		return bodegaproductoDataAccess;
	}
	
	public void setBodegaProductoDataAccess(BodegaProductoDataAccess newbodegaproductoDataAccess) {
		this.bodegaproductoDataAccess = newbodegaproductoDataAccess;
	}
	
	public List<BodegaProducto> getBodegaProductos() throws Exception {		
		this.quitarBodegaProductosNulos();
		
		BodegaProductoLogicAdditional.checkBodegaProductoToGets(bodegaproductos,this.datosCliente,this.arrDatoGeneral);
		
		for (BodegaProducto bodegaproductoLocal: bodegaproductos ) {
			BodegaProductoLogicAdditional.updateBodegaProductoToGet(bodegaproductoLocal,this.arrDatoGeneral);
		}
		
		return bodegaproductos;
	}
	
	public void setBodegaProductos(List<BodegaProducto> newBodegaProductos) {
		this.bodegaproductos = newBodegaProductos;
	}
	
	public Object getBodegaProductoObject() {	
		this.bodegaproductoObject=this.bodegaproductoDataAccess.getEntityObject();
		return this.bodegaproductoObject;
	}
		
	public void setBodegaProductoObject(Object newBodegaProductoObject) {
		this.bodegaproductoObject = newBodegaProductoObject;
	}
	
	public List<Object> getBodegaProductosObject() {		
		this.bodegaproductosObject=this.bodegaproductoDataAccess.getEntitiesObject();
		return this.bodegaproductosObject;
	}
		
	public void setBodegaProductosObject(List<Object> newBodegaProductosObject) {
		this.bodegaproductosObject = newBodegaProductosObject;
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
		
		if(this.bodegaproductoDataAccess!=null) {
			this.bodegaproductoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			bodegaproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			bodegaproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		bodegaproducto = new  BodegaProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			bodegaproducto=bodegaproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bodegaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproducto);
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
		bodegaproducto = new  BodegaProducto();
		  		  
        try {
			
			bodegaproducto=bodegaproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bodegaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		bodegaproducto = new  BodegaProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			bodegaproducto=bodegaproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bodegaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproducto);
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
		bodegaproducto = new  BodegaProducto();
		  		  
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
		bodegaproducto = new  BodegaProducto();
		  		  
        try {
			
			bodegaproducto=bodegaproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bodegaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		bodegaproducto = new  BodegaProducto();
		  		  
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
		bodegaproducto = new  BodegaProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =bodegaproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		bodegaproducto = new  BodegaProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=bodegaproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		bodegaproducto = new  BodegaProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =bodegaproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		bodegaproducto = new  BodegaProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=bodegaproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		bodegaproducto = new  BodegaProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =bodegaproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		bodegaproducto = new  BodegaProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=bodegaproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		bodegaproductos = new  ArrayList<BodegaProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBodegaProducto(bodegaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
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
		bodegaproductos = new  ArrayList<BodegaProducto>();
		  		  
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
		bodegaproductos = new  ArrayList<BodegaProducto>();
		  		  
        try {			
			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarBodegaProducto(bodegaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		bodegaproductos = new  ArrayList<BodegaProducto>();
		  		  
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
		bodegaproductos = new  ArrayList<BodegaProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBodegaProducto(bodegaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
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
		bodegaproductos = new  ArrayList<BodegaProducto>();
		  		  
        try {
			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBodegaProducto(bodegaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
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
		bodegaproductos = new  ArrayList<BodegaProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBodegaProducto(bodegaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
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
		bodegaproductos = new  ArrayList<BodegaProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBodegaProducto(bodegaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		bodegaproducto = new  BodegaProducto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegaproducto=bodegaproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBodegaProducto(bodegaproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproducto);
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
		bodegaproducto = new  BodegaProducto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegaproducto=bodegaproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBodegaProducto(bodegaproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		bodegaproductos = new  ArrayList<BodegaProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegaproductos=bodegaproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBodegaProducto(bodegaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
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
		bodegaproductos = new  ArrayList<BodegaProducto>();
		  		  
        try {
			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegaproductos=bodegaproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBodegaProducto(bodegaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosBodegaProductosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		bodegaproductos = new  ArrayList<BodegaProducto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getTodosBodegaProductosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarBodegaProducto(bodegaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
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
	
	public  void  getTodosBodegaProductos(String sFinalQuery,Pagination pagination)throws Exception {
		bodegaproductos = new  ArrayList<BodegaProducto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarBodegaProducto(bodegaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarBodegaProducto(BodegaProducto bodegaproducto) throws Exception {
		Boolean estaValidado=false;
		
		if(bodegaproducto.getIsNew() || bodegaproducto.getIsChanged()) { 
			this.invalidValues = bodegaproductoValidator.getInvalidValues(bodegaproducto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(bodegaproducto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarBodegaProducto(List<BodegaProducto> BodegaProductos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(BodegaProducto bodegaproductoLocal:bodegaproductos) {				
			estaValidadoObjeto=this.validarGuardarBodegaProducto(bodegaproductoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarBodegaProducto(List<BodegaProducto> BodegaProductos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarBodegaProducto(bodegaproductos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarBodegaProducto(BodegaProducto BodegaProducto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarBodegaProducto(bodegaproducto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(BodegaProducto bodegaproducto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+bodegaproducto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=BodegaProductoConstantesFunciones.getBodegaProductoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"bodegaproducto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(BodegaProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(BodegaProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveBodegaProductoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-saveBodegaProductoWithConnection");connexion.begin();			
			
			BodegaProductoLogicAdditional.checkBodegaProductoToSave(this.bodegaproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			BodegaProductoLogicAdditional.updateBodegaProductoToSave(this.bodegaproducto,this.arrDatoGeneral);
			
			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.bodegaproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowBodegaProducto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarBodegaProducto(this.bodegaproducto)) {
				BodegaProductoDataAccess.save(this.bodegaproducto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.bodegaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			BodegaProductoLogicAdditional.checkBodegaProductoToSaveAfter(this.bodegaproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowBodegaProducto();
			
			connexion.commit();			
			
			if(this.bodegaproducto.getIsDeleted()) {
				this.bodegaproducto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveBodegaProducto()throws Exception {	
		try {	
			
			BodegaProductoLogicAdditional.checkBodegaProductoToSave(this.bodegaproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			BodegaProductoLogicAdditional.updateBodegaProductoToSave(this.bodegaproducto,this.arrDatoGeneral);
			
			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.bodegaproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarBodegaProducto(this.bodegaproducto)) {			
				BodegaProductoDataAccess.save(this.bodegaproducto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.bodegaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			BodegaProductoLogicAdditional.checkBodegaProductoToSaveAfter(this.bodegaproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.bodegaproducto.getIsDeleted()) {
				this.bodegaproducto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveBodegaProductosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-saveBodegaProductosWithConnection");connexion.begin();			
			
			BodegaProductoLogicAdditional.checkBodegaProductoToSaves(bodegaproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowBodegaProductos();
			
			Boolean validadoTodosBodegaProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(BodegaProducto bodegaproductoLocal:bodegaproductos) {		
				if(bodegaproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				BodegaProductoLogicAdditional.updateBodegaProductoToSave(bodegaproductoLocal,this.arrDatoGeneral);
	        	
				BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),bodegaproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarBodegaProducto(bodegaproductoLocal)) {
					BodegaProductoDataAccess.save(bodegaproductoLocal, connexion);				
				} else {
					validadoTodosBodegaProducto=false;
				}
			}
			
			if(!validadoTodosBodegaProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			BodegaProductoLogicAdditional.checkBodegaProductoToSavesAfter(bodegaproductos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowBodegaProductos();
			
			connexion.commit();		
			
			this.quitarBodegaProductosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveBodegaProductos()throws Exception {				
		 try {	
			BodegaProductoLogicAdditional.checkBodegaProductoToSaves(bodegaproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosBodegaProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(BodegaProducto bodegaproductoLocal:bodegaproductos) {				
				if(bodegaproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				BodegaProductoLogicAdditional.updateBodegaProductoToSave(bodegaproductoLocal,this.arrDatoGeneral);
	        	
				BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),bodegaproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarBodegaProducto(bodegaproductoLocal)) {				
					BodegaProductoDataAccess.save(bodegaproductoLocal, connexion);				
				} else {
					validadoTodosBodegaProducto=false;
				}
			}
			
			if(!validadoTodosBodegaProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			BodegaProductoLogicAdditional.checkBodegaProductoToSavesAfter(bodegaproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarBodegaProductosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public BodegaProductoParameterReturnGeneral procesarAccionBodegaProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<BodegaProducto> bodegaproductos,BodegaProductoParameterReturnGeneral bodegaproductoParameterGeneral)throws Exception {
		 try {	
			BodegaProductoParameterReturnGeneral bodegaproductoReturnGeneral=new BodegaProductoParameterReturnGeneral();
	
			BodegaProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,bodegaproductos,bodegaproductoParameterGeneral,bodegaproductoReturnGeneral);
			
			return bodegaproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public BodegaProductoParameterReturnGeneral procesarAccionBodegaProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<BodegaProducto> bodegaproductos,BodegaProductoParameterReturnGeneral bodegaproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-procesarAccionBodegaProductosWithConnection");connexion.begin();			
			
			BodegaProductoParameterReturnGeneral bodegaproductoReturnGeneral=new BodegaProductoParameterReturnGeneral();
	
			BodegaProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,bodegaproductos,bodegaproductoParameterGeneral,bodegaproductoReturnGeneral);
			
			this.connexion.commit();
			
			return bodegaproductoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public BodegaProductoParameterReturnGeneral procesarEventosBodegaProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<BodegaProducto> bodegaproductos,BodegaProducto bodegaproducto,BodegaProductoParameterReturnGeneral bodegaproductoParameterGeneral,Boolean isEsNuevoBodegaProducto,ArrayList<Classe> clases)throws Exception {
		 try {	
			BodegaProductoParameterReturnGeneral bodegaproductoReturnGeneral=new BodegaProductoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				bodegaproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			BodegaProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,bodegaproductos,bodegaproducto,bodegaproductoParameterGeneral,bodegaproductoReturnGeneral,isEsNuevoBodegaProducto,clases);
			
			return bodegaproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public BodegaProductoParameterReturnGeneral procesarEventosBodegaProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<BodegaProducto> bodegaproductos,BodegaProducto bodegaproducto,BodegaProductoParameterReturnGeneral bodegaproductoParameterGeneral,Boolean isEsNuevoBodegaProducto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-procesarEventosBodegaProductosWithConnection");connexion.begin();			
			
			BodegaProductoParameterReturnGeneral bodegaproductoReturnGeneral=new BodegaProductoParameterReturnGeneral();
	
			bodegaproductoReturnGeneral.setBodegaProducto(bodegaproducto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				bodegaproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			BodegaProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,bodegaproductos,bodegaproducto,bodegaproductoParameterGeneral,bodegaproductoReturnGeneral,isEsNuevoBodegaProducto,clases);
			
			this.connexion.commit();
			
			return bodegaproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public BodegaProductoParameterReturnGeneral procesarImportacionBodegaProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,BodegaProductoParameterReturnGeneral bodegaproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-procesarImportacionBodegaProductosWithConnection");connexion.begin();			
			
			BodegaProductoParameterReturnGeneral bodegaproductoReturnGeneral=new BodegaProductoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.bodegaproductos=new ArrayList<BodegaProducto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.bodegaproducto=new BodegaProducto();
				
				
				if(conColumnasBase) {this.bodegaproducto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.bodegaproducto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.bodegaproducto.setdescripcion(arrColumnas[iColumn++]);
				this.bodegaproducto.setcantidad_disponible(Integer.parseInt(arrColumnas[iColumn++]));
				this.bodegaproducto.setstock_maximo(Integer.parseInt(arrColumnas[iColumn++]));
				this.bodegaproducto.setstock_minimo(Integer.parseInt(arrColumnas[iColumn++]));
				this.bodegaproducto.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.bodegaproducto.setiva_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.bodegaproducto.setdescuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.bodegaproducto.setdescuento_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.bodegaproducto.setice(Double.parseDouble(arrColumnas[iColumn++]));
				this.bodegaproducto.setice_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.bodegaproducto.setcosto_promedio(Double.parseDouble(arrColumnas[iColumn++]));
				this.bodegaproducto.setporcentaje_comision(Double.parseDouble(arrColumnas[iColumn++]));
				this.bodegaproducto.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
				this.bodegaproducto.setultimo_costo(Double.parseDouble(arrColumnas[iColumn++]));
				this.bodegaproducto.setcosto(Double.parseDouble(arrColumnas[iColumn++]));
				this.bodegaproducto.setarancel_porcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.bodegaproducto.setice_porcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.bodegaproducto.setpeso(Double.parseDouble(arrColumnas[iColumn++]));
				this.bodegaproducto.setcon_iva(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.bodegaproducto.setcon_impuesto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.bodegaproducto.setcon_ice(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.bodegaproducto.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.bodegaproducto.setcon_balanza(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.bodegaproducto.setcantidad_pedida(Integer.parseInt(arrColumnas[iColumn++]));
				this.bodegaproducto.setcantidad_fisica(Integer.parseInt(arrColumnas[iColumn++]));
				this.bodegaproducto.setcantidad_requerido(Integer.parseInt(arrColumnas[iColumn++]));
				this.bodegaproducto.setprecio_costo(Double.parseDouble(arrColumnas[iColumn++]));
				this.bodegaproducto.setprecio_promedio(Double.parseDouble(arrColumnas[iColumn++]));
				this.bodegaproducto.settotal_ingresos(Integer.parseInt(arrColumnas[iColumn++]));
				this.bodegaproducto.settotal_egresos(Integer.parseInt(arrColumnas[iColumn++]));
				this.bodegaproducto.settotal_provision(Double.parseDouble(arrColumnas[iColumn++]));
				this.bodegaproducto.settotal_proceso(Double.parseDouble(arrColumnas[iColumn++]));
				this.bodegaproducto.setcosto_calculado(Double.parseDouble(arrColumnas[iColumn++]));
				this.bodegaproducto.setdias_produccion(Double.parseDouble(arrColumnas[iColumn++]));
				this.bodegaproducto.setprecio_reposicion(Double.parseDouble(arrColumnas[iColumn++]));
				this.bodegaproducto.setfecha_ultimo_pedido(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.bodegaproducto.setfecha_ingreso(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.bodegaproducto.setfecha_egreso(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.bodegaproducto.setfecha_ultima_compra(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.bodegaproducto.setfecha_ultima_venta(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.bodegaproducto.setfecha_ultima_devolucion(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				
				this.bodegaproductos.add(this.bodegaproducto);
			}
			
			this.saveBodegaProductos();
			
			this.connexion.commit();
			
			bodegaproductoReturnGeneral.setConRetornoEstaProcesado(true);
			bodegaproductoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return bodegaproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarBodegaProductosEliminados() throws Exception {				
		
		List<BodegaProducto> bodegaproductosAux= new ArrayList<BodegaProducto>();
		
		for(BodegaProducto bodegaproducto:bodegaproductos) {
			if(!bodegaproducto.getIsDeleted()) {
				bodegaproductosAux.add(bodegaproducto);
			}
		}
		
		bodegaproductos=bodegaproductosAux;
	}
	
	public void quitarBodegaProductosNulos() throws Exception {				
		
		List<BodegaProducto> bodegaproductosAux= new ArrayList<BodegaProducto>();
		
		for(BodegaProducto bodegaproducto : this.bodegaproductos) {
			if(bodegaproducto==null) {
				bodegaproductosAux.add(bodegaproducto);
			}
		}
		
		//this.bodegaproductos=bodegaproductosAux;
		
		this.bodegaproductos.removeAll(bodegaproductosAux);
	}
	
	public void getSetVersionRowBodegaProductoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(bodegaproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((bodegaproducto.getIsDeleted() || (bodegaproducto.getIsChanged()&&!bodegaproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=bodegaproductoDataAccess.getSetVersionRowBodegaProducto(connexion,bodegaproducto.getId());
				
				if(!bodegaproducto.getVersionRow().equals(timestamp)) {	
					bodegaproducto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				bodegaproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowBodegaProducto()throws Exception {	
		
		if(bodegaproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((bodegaproducto.getIsDeleted() || (bodegaproducto.getIsChanged()&&!bodegaproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=bodegaproductoDataAccess.getSetVersionRowBodegaProducto(connexion,bodegaproducto.getId());
			
			try {							
				if(!bodegaproducto.getVersionRow().equals(timestamp)) {	
					bodegaproducto.setVersionRow(timestamp);
				}
				
				bodegaproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowBodegaProductosWithConnection()throws Exception {	
		if(bodegaproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(BodegaProducto bodegaproductoAux:bodegaproductos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(bodegaproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(bodegaproductoAux.getIsDeleted() || (bodegaproductoAux.getIsChanged()&&!bodegaproductoAux.getIsNew())) {
						
						timestamp=bodegaproductoDataAccess.getSetVersionRowBodegaProducto(connexion,bodegaproductoAux.getId());
						
						if(!bodegaproducto.getVersionRow().equals(timestamp)) {	
							bodegaproductoAux.setVersionRow(timestamp);
						}
								
						bodegaproductoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowBodegaProductos()throws Exception {	
		if(bodegaproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(BodegaProducto bodegaproductoAux:bodegaproductos) {
					if(bodegaproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(bodegaproductoAux.getIsDeleted() || (bodegaproductoAux.getIsChanged()&&!bodegaproductoAux.getIsNew())) {
						
						timestamp=bodegaproductoDataAccess.getSetVersionRowBodegaProducto(connexion,bodegaproductoAux.getId());
						
						if(!bodegaproductoAux.getVersionRow().equals(timestamp)) {	
							bodegaproductoAux.setVersionRow(timestamp);
						}
						
													
						bodegaproductoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public BodegaProductoParameterReturnGeneral cargarCombosLoteForeignKeyBodegaProductoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalCentroCosto,String finalQueryGlobalEstadoBodegaProducto,String finalQueryGlobalCuentaContableInventario,String finalQueryGlobalCuentaContableCostoVenta,String finalQueryGlobalCuentaContableVenta,String finalQueryGlobalCuentaContableDescuento,String finalQueryGlobalCuentaContableProduccion,String finalQueryGlobalCuentaContableDevolucion,String finalQueryGlobalCuentaContableIngresoDebito,String finalQueryGlobalCuentaContableIngresoCredito,String finalQueryGlobalCuentaContableResultadoDebito,String finalQueryGlobalCuentaContableResultadoCredito) throws Exception {
		BodegaProductoParameterReturnGeneral  bodegaproductoReturnGeneral =new BodegaProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-cargarCombosLoteForeignKeyBodegaProductoWithConnection");connexion.begin();
			
			bodegaproductoReturnGeneral =new BodegaProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			bodegaproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			bodegaproductoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			bodegaproductoReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			bodegaproductoReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			bodegaproductoReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			bodegaproductoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<EstadoBodegaProducto> estadobodegaproductosForeignKey=new ArrayList<EstadoBodegaProducto>();
			EstadoBodegaProductoLogic estadobodegaproductoLogic=new EstadoBodegaProductoLogic();
			estadobodegaproductoLogic.setConnexion(this.connexion);
			//estadobodegaproductoLogic.getEstadoBodegaProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoBodegaProducto.equals("NONE")) {
				estadobodegaproductoLogic.getTodosEstadoBodegaProductos(finalQueryGlobalEstadoBodegaProducto,new Pagination());
				estadobodegaproductosForeignKey=estadobodegaproductoLogic.getEstadoBodegaProductos();
			}

			bodegaproductoReturnGeneral.setestadobodegaproductosForeignKey(estadobodegaproductosForeignKey);


			List<CuentaContable> cuentacontableinventariosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableinventarioLogic=new CuentaContableLogic();
			cuentacontableinventarioLogic.setConnexion(this.connexion);
			cuentacontableinventarioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableInventario.equals("NONE")) {
				cuentacontableinventarioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableInventario,new Pagination());
				cuentacontableinventariosForeignKey=cuentacontableinventarioLogic.getCuentaContables();
			}

			bodegaproductoReturnGeneral.setcuentacontableinventariosForeignKey(cuentacontableinventariosForeignKey);


			List<CuentaContable> cuentacontablecostoventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostoventaLogic=new CuentaContableLogic();
			cuentacontablecostoventaLogic.setConnexion(this.connexion);
			cuentacontablecostoventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCostoVenta.equals("NONE")) {
				cuentacontablecostoventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCostoVenta,new Pagination());
				cuentacontablecostoventasForeignKey=cuentacontablecostoventaLogic.getCuentaContables();
			}

			bodegaproductoReturnGeneral.setcuentacontablecostoventasForeignKey(cuentacontablecostoventasForeignKey);


			List<CuentaContable> cuentacontableventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableventaLogic=new CuentaContableLogic();
			cuentacontableventaLogic.setConnexion(this.connexion);
			cuentacontableventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableVenta.equals("NONE")) {
				cuentacontableventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableVenta,new Pagination());
				cuentacontableventasForeignKey=cuentacontableventaLogic.getCuentaContables();
			}

			bodegaproductoReturnGeneral.setcuentacontableventasForeignKey(cuentacontableventasForeignKey);


			List<CuentaContable> cuentacontabledescuentosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledescuentoLogic=new CuentaContableLogic();
			cuentacontabledescuentoLogic.setConnexion(this.connexion);
			cuentacontabledescuentoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDescuento.equals("NONE")) {
				cuentacontabledescuentoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDescuento,new Pagination());
				cuentacontabledescuentosForeignKey=cuentacontabledescuentoLogic.getCuentaContables();
			}

			bodegaproductoReturnGeneral.setcuentacontabledescuentosForeignKey(cuentacontabledescuentosForeignKey);


			List<CuentaContable> cuentacontableproduccionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableproduccionLogic=new CuentaContableLogic();
			cuentacontableproduccionLogic.setConnexion(this.connexion);
			cuentacontableproduccionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableProduccion.equals("NONE")) {
				cuentacontableproduccionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableProduccion,new Pagination());
				cuentacontableproduccionsForeignKey=cuentacontableproduccionLogic.getCuentaContables();
			}

			bodegaproductoReturnGeneral.setcuentacontableproduccionsForeignKey(cuentacontableproduccionsForeignKey);


			List<CuentaContable> cuentacontabledevolucionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledevolucionLogic=new CuentaContableLogic();
			cuentacontabledevolucionLogic.setConnexion(this.connexion);
			cuentacontabledevolucionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDevolucion.equals("NONE")) {
				cuentacontabledevolucionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDevolucion,new Pagination());
				cuentacontabledevolucionsForeignKey=cuentacontabledevolucionLogic.getCuentaContables();
			}

			bodegaproductoReturnGeneral.setcuentacontabledevolucionsForeignKey(cuentacontabledevolucionsForeignKey);


			List<CuentaContable> cuentacontableingresodebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableingresodebitoLogic=new CuentaContableLogic();
			cuentacontableingresodebitoLogic.setConnexion(this.connexion);
			cuentacontableingresodebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIngresoDebito.equals("NONE")) {
				cuentacontableingresodebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableIngresoDebito,new Pagination());
				cuentacontableingresodebitosForeignKey=cuentacontableingresodebitoLogic.getCuentaContables();
			}

			bodegaproductoReturnGeneral.setcuentacontableingresodebitosForeignKey(cuentacontableingresodebitosForeignKey);


			List<CuentaContable> cuentacontableingresocreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableingresocreditoLogic=new CuentaContableLogic();
			cuentacontableingresocreditoLogic.setConnexion(this.connexion);
			cuentacontableingresocreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIngresoCredito.equals("NONE")) {
				cuentacontableingresocreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableIngresoCredito,new Pagination());
				cuentacontableingresocreditosForeignKey=cuentacontableingresocreditoLogic.getCuentaContables();
			}

			bodegaproductoReturnGeneral.setcuentacontableingresocreditosForeignKey(cuentacontableingresocreditosForeignKey);


			List<CuentaContable> cuentacontableresultadodebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableresultadodebitoLogic=new CuentaContableLogic();
			cuentacontableresultadodebitoLogic.setConnexion(this.connexion);
			cuentacontableresultadodebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableResultadoDebito.equals("NONE")) {
				cuentacontableresultadodebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableResultadoDebito,new Pagination());
				cuentacontableresultadodebitosForeignKey=cuentacontableresultadodebitoLogic.getCuentaContables();
			}

			bodegaproductoReturnGeneral.setcuentacontableresultadodebitosForeignKey(cuentacontableresultadodebitosForeignKey);


			List<CuentaContable> cuentacontableresultadocreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableresultadocreditoLogic=new CuentaContableLogic();
			cuentacontableresultadocreditoLogic.setConnexion(this.connexion);
			cuentacontableresultadocreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableResultadoCredito.equals("NONE")) {
				cuentacontableresultadocreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableResultadoCredito,new Pagination());
				cuentacontableresultadocreditosForeignKey=cuentacontableresultadocreditoLogic.getCuentaContables();
			}

			bodegaproductoReturnGeneral.setcuentacontableresultadocreditosForeignKey(cuentacontableresultadocreditosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return bodegaproductoReturnGeneral;
	}
	
	public BodegaProductoParameterReturnGeneral cargarCombosLoteForeignKeyBodegaProducto(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalCentroCosto,String finalQueryGlobalEstadoBodegaProducto,String finalQueryGlobalCuentaContableInventario,String finalQueryGlobalCuentaContableCostoVenta,String finalQueryGlobalCuentaContableVenta,String finalQueryGlobalCuentaContableDescuento,String finalQueryGlobalCuentaContableProduccion,String finalQueryGlobalCuentaContableDevolucion,String finalQueryGlobalCuentaContableIngresoDebito,String finalQueryGlobalCuentaContableIngresoCredito,String finalQueryGlobalCuentaContableResultadoDebito,String finalQueryGlobalCuentaContableResultadoCredito) throws Exception {
		BodegaProductoParameterReturnGeneral  bodegaproductoReturnGeneral =new BodegaProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			bodegaproductoReturnGeneral =new BodegaProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			bodegaproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			bodegaproductoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			bodegaproductoReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			bodegaproductoReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			bodegaproductoReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			bodegaproductoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<EstadoBodegaProducto> estadobodegaproductosForeignKey=new ArrayList<EstadoBodegaProducto>();
			EstadoBodegaProductoLogic estadobodegaproductoLogic=new EstadoBodegaProductoLogic();
			estadobodegaproductoLogic.setConnexion(this.connexion);
			//estadobodegaproductoLogic.getEstadoBodegaProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoBodegaProducto.equals("NONE")) {
				estadobodegaproductoLogic.getTodosEstadoBodegaProductos(finalQueryGlobalEstadoBodegaProducto,new Pagination());
				estadobodegaproductosForeignKey=estadobodegaproductoLogic.getEstadoBodegaProductos();
			}

			bodegaproductoReturnGeneral.setestadobodegaproductosForeignKey(estadobodegaproductosForeignKey);


			List<CuentaContable> cuentacontableinventariosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableinventarioLogic=new CuentaContableLogic();
			cuentacontableinventarioLogic.setConnexion(this.connexion);
			cuentacontableinventarioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableInventario.equals("NONE")) {
				cuentacontableinventarioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableInventario,new Pagination());
				cuentacontableinventariosForeignKey=cuentacontableinventarioLogic.getCuentaContables();
			}

			bodegaproductoReturnGeneral.setcuentacontableinventariosForeignKey(cuentacontableinventariosForeignKey);


			List<CuentaContable> cuentacontablecostoventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostoventaLogic=new CuentaContableLogic();
			cuentacontablecostoventaLogic.setConnexion(this.connexion);
			cuentacontablecostoventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCostoVenta.equals("NONE")) {
				cuentacontablecostoventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCostoVenta,new Pagination());
				cuentacontablecostoventasForeignKey=cuentacontablecostoventaLogic.getCuentaContables();
			}

			bodegaproductoReturnGeneral.setcuentacontablecostoventasForeignKey(cuentacontablecostoventasForeignKey);


			List<CuentaContable> cuentacontableventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableventaLogic=new CuentaContableLogic();
			cuentacontableventaLogic.setConnexion(this.connexion);
			cuentacontableventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableVenta.equals("NONE")) {
				cuentacontableventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableVenta,new Pagination());
				cuentacontableventasForeignKey=cuentacontableventaLogic.getCuentaContables();
			}

			bodegaproductoReturnGeneral.setcuentacontableventasForeignKey(cuentacontableventasForeignKey);


			List<CuentaContable> cuentacontabledescuentosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledescuentoLogic=new CuentaContableLogic();
			cuentacontabledescuentoLogic.setConnexion(this.connexion);
			cuentacontabledescuentoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDescuento.equals("NONE")) {
				cuentacontabledescuentoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDescuento,new Pagination());
				cuentacontabledescuentosForeignKey=cuentacontabledescuentoLogic.getCuentaContables();
			}

			bodegaproductoReturnGeneral.setcuentacontabledescuentosForeignKey(cuentacontabledescuentosForeignKey);


			List<CuentaContable> cuentacontableproduccionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableproduccionLogic=new CuentaContableLogic();
			cuentacontableproduccionLogic.setConnexion(this.connexion);
			cuentacontableproduccionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableProduccion.equals("NONE")) {
				cuentacontableproduccionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableProduccion,new Pagination());
				cuentacontableproduccionsForeignKey=cuentacontableproduccionLogic.getCuentaContables();
			}

			bodegaproductoReturnGeneral.setcuentacontableproduccionsForeignKey(cuentacontableproduccionsForeignKey);


			List<CuentaContable> cuentacontabledevolucionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledevolucionLogic=new CuentaContableLogic();
			cuentacontabledevolucionLogic.setConnexion(this.connexion);
			cuentacontabledevolucionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDevolucion.equals("NONE")) {
				cuentacontabledevolucionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDevolucion,new Pagination());
				cuentacontabledevolucionsForeignKey=cuentacontabledevolucionLogic.getCuentaContables();
			}

			bodegaproductoReturnGeneral.setcuentacontabledevolucionsForeignKey(cuentacontabledevolucionsForeignKey);


			List<CuentaContable> cuentacontableingresodebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableingresodebitoLogic=new CuentaContableLogic();
			cuentacontableingresodebitoLogic.setConnexion(this.connexion);
			cuentacontableingresodebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIngresoDebito.equals("NONE")) {
				cuentacontableingresodebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableIngresoDebito,new Pagination());
				cuentacontableingresodebitosForeignKey=cuentacontableingresodebitoLogic.getCuentaContables();
			}

			bodegaproductoReturnGeneral.setcuentacontableingresodebitosForeignKey(cuentacontableingresodebitosForeignKey);


			List<CuentaContable> cuentacontableingresocreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableingresocreditoLogic=new CuentaContableLogic();
			cuentacontableingresocreditoLogic.setConnexion(this.connexion);
			cuentacontableingresocreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIngresoCredito.equals("NONE")) {
				cuentacontableingresocreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableIngresoCredito,new Pagination());
				cuentacontableingresocreditosForeignKey=cuentacontableingresocreditoLogic.getCuentaContables();
			}

			bodegaproductoReturnGeneral.setcuentacontableingresocreditosForeignKey(cuentacontableingresocreditosForeignKey);


			List<CuentaContable> cuentacontableresultadodebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableresultadodebitoLogic=new CuentaContableLogic();
			cuentacontableresultadodebitoLogic.setConnexion(this.connexion);
			cuentacontableresultadodebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableResultadoDebito.equals("NONE")) {
				cuentacontableresultadodebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableResultadoDebito,new Pagination());
				cuentacontableresultadodebitosForeignKey=cuentacontableresultadodebitoLogic.getCuentaContables();
			}

			bodegaproductoReturnGeneral.setcuentacontableresultadodebitosForeignKey(cuentacontableresultadodebitosForeignKey);


			List<CuentaContable> cuentacontableresultadocreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableresultadocreditoLogic=new CuentaContableLogic();
			cuentacontableresultadocreditoLogic.setConnexion(this.connexion);
			cuentacontableresultadocreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableResultadoCredito.equals("NONE")) {
				cuentacontableresultadocreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableResultadoCredito,new Pagination());
				cuentacontableresultadocreditosForeignKey=cuentacontableresultadocreditoLogic.getCuentaContables();
			}

			bodegaproductoReturnGeneral.setcuentacontableresultadocreditosForeignKey(cuentacontableresultadocreditosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return bodegaproductoReturnGeneral;
	}
	
	
	public void deepLoad(BodegaProducto bodegaproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			BodegaProductoLogicAdditional.updateBodegaProductoToGet(bodegaproducto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		bodegaproducto.setEmpresa(bodegaproductoDataAccess.getEmpresa(connexion,bodegaproducto));
		bodegaproducto.setSucursal(bodegaproductoDataAccess.getSucursal(connexion,bodegaproducto));
		bodegaproducto.setBodega(bodegaproductoDataAccess.getBodega(connexion,bodegaproducto));
		bodegaproducto.setProducto(bodegaproductoDataAccess.getProducto(connexion,bodegaproducto));
		bodegaproducto.setUnidad(bodegaproductoDataAccess.getUnidad(connexion,bodegaproducto));
		bodegaproducto.setCentroCosto(bodegaproductoDataAccess.getCentroCosto(connexion,bodegaproducto));
		bodegaproducto.setEstadoBodegaProducto(bodegaproductoDataAccess.getEstadoBodegaProducto(connexion,bodegaproducto));
		bodegaproducto.setCuentaContableInventario(bodegaproductoDataAccess.getCuentaContableInventario(connexion,bodegaproducto));
		bodegaproducto.setCuentaContableCostoVenta(bodegaproductoDataAccess.getCuentaContableCostoVenta(connexion,bodegaproducto));
		bodegaproducto.setCuentaContableVenta(bodegaproductoDataAccess.getCuentaContableVenta(connexion,bodegaproducto));
		bodegaproducto.setCuentaContableDescuento(bodegaproductoDataAccess.getCuentaContableDescuento(connexion,bodegaproducto));
		bodegaproducto.setCuentaContableProduccion(bodegaproductoDataAccess.getCuentaContableProduccion(connexion,bodegaproducto));
		bodegaproducto.setCuentaContableDevolucion(bodegaproductoDataAccess.getCuentaContableDevolucion(connexion,bodegaproducto));
		bodegaproducto.setCuentaContableIngresoDebito(bodegaproductoDataAccess.getCuentaContableIngresoDebito(connexion,bodegaproducto));
		bodegaproducto.setCuentaContableIngresoCredito(bodegaproductoDataAccess.getCuentaContableIngresoCredito(connexion,bodegaproducto));
		bodegaproducto.setCuentaContableResultadoDebito(bodegaproductoDataAccess.getCuentaContableResultadoDebito(connexion,bodegaproducto));
		bodegaproducto.setCuentaContableResultadoCredito(bodegaproductoDataAccess.getCuentaContableResultadoCredito(connexion,bodegaproducto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				bodegaproducto.setEmpresa(bodegaproductoDataAccess.getEmpresa(connexion,bodegaproducto));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				bodegaproducto.setSucursal(bodegaproductoDataAccess.getSucursal(connexion,bodegaproducto));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				bodegaproducto.setBodega(bodegaproductoDataAccess.getBodega(connexion,bodegaproducto));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				bodegaproducto.setProducto(bodegaproductoDataAccess.getProducto(connexion,bodegaproducto));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				bodegaproducto.setUnidad(bodegaproductoDataAccess.getUnidad(connexion,bodegaproducto));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				bodegaproducto.setCentroCosto(bodegaproductoDataAccess.getCentroCosto(connexion,bodegaproducto));
				continue;
			}

			if(clas.clas.equals(EstadoBodegaProducto.class)) {
				bodegaproducto.setEstadoBodegaProducto(bodegaproductoDataAccess.getEstadoBodegaProducto(connexion,bodegaproducto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodegaproducto.setCuentaContableInventario(bodegaproductoDataAccess.getCuentaContableInventario(connexion,bodegaproducto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodegaproducto.setCuentaContableCostoVenta(bodegaproductoDataAccess.getCuentaContableCostoVenta(connexion,bodegaproducto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodegaproducto.setCuentaContableVenta(bodegaproductoDataAccess.getCuentaContableVenta(connexion,bodegaproducto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodegaproducto.setCuentaContableDescuento(bodegaproductoDataAccess.getCuentaContableDescuento(connexion,bodegaproducto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodegaproducto.setCuentaContableProduccion(bodegaproductoDataAccess.getCuentaContableProduccion(connexion,bodegaproducto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodegaproducto.setCuentaContableDevolucion(bodegaproductoDataAccess.getCuentaContableDevolucion(connexion,bodegaproducto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodegaproducto.setCuentaContableIngresoDebito(bodegaproductoDataAccess.getCuentaContableIngresoDebito(connexion,bodegaproducto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodegaproducto.setCuentaContableIngresoCredito(bodegaproductoDataAccess.getCuentaContableIngresoCredito(connexion,bodegaproducto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodegaproducto.setCuentaContableResultadoDebito(bodegaproductoDataAccess.getCuentaContableResultadoDebito(connexion,bodegaproducto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodegaproducto.setCuentaContableResultadoCredito(bodegaproductoDataAccess.getCuentaContableResultadoCredito(connexion,bodegaproducto));
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
			bodegaproducto.setEmpresa(bodegaproductoDataAccess.getEmpresa(connexion,bodegaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setSucursal(bodegaproductoDataAccess.getSucursal(connexion,bodegaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setBodega(bodegaproductoDataAccess.getBodega(connexion,bodegaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setProducto(bodegaproductoDataAccess.getProducto(connexion,bodegaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setUnidad(bodegaproductoDataAccess.getUnidad(connexion,bodegaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCentroCosto(bodegaproductoDataAccess.getCentroCosto(connexion,bodegaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoBodegaProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setEstadoBodegaProducto(bodegaproductoDataAccess.getEstadoBodegaProducto(connexion,bodegaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCuentaContableInventario(bodegaproductoDataAccess.getCuentaContableInventario(connexion,bodegaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCuentaContableCostoVenta(bodegaproductoDataAccess.getCuentaContableCostoVenta(connexion,bodegaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCuentaContableVenta(bodegaproductoDataAccess.getCuentaContableVenta(connexion,bodegaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCuentaContableDescuento(bodegaproductoDataAccess.getCuentaContableDescuento(connexion,bodegaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCuentaContableProduccion(bodegaproductoDataAccess.getCuentaContableProduccion(connexion,bodegaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCuentaContableDevolucion(bodegaproductoDataAccess.getCuentaContableDevolucion(connexion,bodegaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCuentaContableIngresoDebito(bodegaproductoDataAccess.getCuentaContableIngresoDebito(connexion,bodegaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCuentaContableIngresoCredito(bodegaproductoDataAccess.getCuentaContableIngresoCredito(connexion,bodegaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCuentaContableResultadoDebito(bodegaproductoDataAccess.getCuentaContableResultadoDebito(connexion,bodegaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCuentaContableResultadoCredito(bodegaproductoDataAccess.getCuentaContableResultadoCredito(connexion,bodegaproducto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		bodegaproducto.setEmpresa(bodegaproductoDataAccess.getEmpresa(connexion,bodegaproducto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(bodegaproducto.getEmpresa(),isDeep,deepLoadType,clases);
				
		bodegaproducto.setSucursal(bodegaproductoDataAccess.getSucursal(connexion,bodegaproducto));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(bodegaproducto.getSucursal(),isDeep,deepLoadType,clases);
				
		bodegaproducto.setBodega(bodegaproductoDataAccess.getBodega(connexion,bodegaproducto));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(bodegaproducto.getBodega(),isDeep,deepLoadType,clases);
				
		bodegaproducto.setProducto(bodegaproductoDataAccess.getProducto(connexion,bodegaproducto));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(bodegaproducto.getProducto(),isDeep,deepLoadType,clases);
				
		bodegaproducto.setUnidad(bodegaproductoDataAccess.getUnidad(connexion,bodegaproducto));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(bodegaproducto.getUnidad(),isDeep,deepLoadType,clases);
				
		bodegaproducto.setCentroCosto(bodegaproductoDataAccess.getCentroCosto(connexion,bodegaproducto));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(bodegaproducto.getCentroCosto(),isDeep,deepLoadType,clases);
				
		bodegaproducto.setEstadoBodegaProducto(bodegaproductoDataAccess.getEstadoBodegaProducto(connexion,bodegaproducto));
		EstadoBodegaProductoLogic estadobodegaproductoLogic= new EstadoBodegaProductoLogic(connexion);
		estadobodegaproductoLogic.deepLoad(bodegaproducto.getEstadoBodegaProducto(),isDeep,deepLoadType,clases);
				
		bodegaproducto.setCuentaContableInventario(bodegaproductoDataAccess.getCuentaContableInventario(connexion,bodegaproducto));
		CuentaContableLogic cuentacontableinventarioLogic= new CuentaContableLogic(connexion);
		cuentacontableinventarioLogic.deepLoad(bodegaproducto.getCuentaContableInventario(),isDeep,deepLoadType,clases);
				
		bodegaproducto.setCuentaContableCostoVenta(bodegaproductoDataAccess.getCuentaContableCostoVenta(connexion,bodegaproducto));
		CuentaContableLogic cuentacontablecostoventaLogic= new CuentaContableLogic(connexion);
		cuentacontablecostoventaLogic.deepLoad(bodegaproducto.getCuentaContableCostoVenta(),isDeep,deepLoadType,clases);
				
		bodegaproducto.setCuentaContableVenta(bodegaproductoDataAccess.getCuentaContableVenta(connexion,bodegaproducto));
		CuentaContableLogic cuentacontableventaLogic= new CuentaContableLogic(connexion);
		cuentacontableventaLogic.deepLoad(bodegaproducto.getCuentaContableVenta(),isDeep,deepLoadType,clases);
				
		bodegaproducto.setCuentaContableDescuento(bodegaproductoDataAccess.getCuentaContableDescuento(connexion,bodegaproducto));
		CuentaContableLogic cuentacontabledescuentoLogic= new CuentaContableLogic(connexion);
		cuentacontabledescuentoLogic.deepLoad(bodegaproducto.getCuentaContableDescuento(),isDeep,deepLoadType,clases);
				
		bodegaproducto.setCuentaContableProduccion(bodegaproductoDataAccess.getCuentaContableProduccion(connexion,bodegaproducto));
		CuentaContableLogic cuentacontableproduccionLogic= new CuentaContableLogic(connexion);
		cuentacontableproduccionLogic.deepLoad(bodegaproducto.getCuentaContableProduccion(),isDeep,deepLoadType,clases);
				
		bodegaproducto.setCuentaContableDevolucion(bodegaproductoDataAccess.getCuentaContableDevolucion(connexion,bodegaproducto));
		CuentaContableLogic cuentacontabledevolucionLogic= new CuentaContableLogic(connexion);
		cuentacontabledevolucionLogic.deepLoad(bodegaproducto.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);
				
		bodegaproducto.setCuentaContableIngresoDebito(bodegaproductoDataAccess.getCuentaContableIngresoDebito(connexion,bodegaproducto));
		CuentaContableLogic cuentacontableingresodebitoLogic= new CuentaContableLogic(connexion);
		cuentacontableingresodebitoLogic.deepLoad(bodegaproducto.getCuentaContableIngresoDebito(),isDeep,deepLoadType,clases);
				
		bodegaproducto.setCuentaContableIngresoCredito(bodegaproductoDataAccess.getCuentaContableIngresoCredito(connexion,bodegaproducto));
		CuentaContableLogic cuentacontableingresocreditoLogic= new CuentaContableLogic(connexion);
		cuentacontableingresocreditoLogic.deepLoad(bodegaproducto.getCuentaContableIngresoCredito(),isDeep,deepLoadType,clases);
				
		bodegaproducto.setCuentaContableResultadoDebito(bodegaproductoDataAccess.getCuentaContableResultadoDebito(connexion,bodegaproducto));
		CuentaContableLogic cuentacontableresultadodebitoLogic= new CuentaContableLogic(connexion);
		cuentacontableresultadodebitoLogic.deepLoad(bodegaproducto.getCuentaContableResultadoDebito(),isDeep,deepLoadType,clases);
				
		bodegaproducto.setCuentaContableResultadoCredito(bodegaproductoDataAccess.getCuentaContableResultadoCredito(connexion,bodegaproducto));
		CuentaContableLogic cuentacontableresultadocreditoLogic= new CuentaContableLogic(connexion);
		cuentacontableresultadocreditoLogic.deepLoad(bodegaproducto.getCuentaContableResultadoCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				bodegaproducto.setEmpresa(bodegaproductoDataAccess.getEmpresa(connexion,bodegaproducto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(bodegaproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				bodegaproducto.setSucursal(bodegaproductoDataAccess.getSucursal(connexion,bodegaproducto));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(bodegaproducto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				bodegaproducto.setBodega(bodegaproductoDataAccess.getBodega(connexion,bodegaproducto));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(bodegaproducto.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				bodegaproducto.setProducto(bodegaproductoDataAccess.getProducto(connexion,bodegaproducto));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(bodegaproducto.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				bodegaproducto.setUnidad(bodegaproductoDataAccess.getUnidad(connexion,bodegaproducto));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(bodegaproducto.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				bodegaproducto.setCentroCosto(bodegaproductoDataAccess.getCentroCosto(connexion,bodegaproducto));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(bodegaproducto.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoBodegaProducto.class)) {
				bodegaproducto.setEstadoBodegaProducto(bodegaproductoDataAccess.getEstadoBodegaProducto(connexion,bodegaproducto));
				EstadoBodegaProductoLogic estadobodegaproductoLogic= new EstadoBodegaProductoLogic(connexion);
				estadobodegaproductoLogic.deepLoad(bodegaproducto.getEstadoBodegaProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodegaproducto.setCuentaContableInventario(bodegaproductoDataAccess.getCuentaContableInventario(connexion,bodegaproducto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(bodegaproducto.getCuentaContableInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodegaproducto.setCuentaContableCostoVenta(bodegaproductoDataAccess.getCuentaContableCostoVenta(connexion,bodegaproducto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(bodegaproducto.getCuentaContableCostoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodegaproducto.setCuentaContableVenta(bodegaproductoDataAccess.getCuentaContableVenta(connexion,bodegaproducto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(bodegaproducto.getCuentaContableVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodegaproducto.setCuentaContableDescuento(bodegaproductoDataAccess.getCuentaContableDescuento(connexion,bodegaproducto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(bodegaproducto.getCuentaContableDescuento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodegaproducto.setCuentaContableProduccion(bodegaproductoDataAccess.getCuentaContableProduccion(connexion,bodegaproducto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(bodegaproducto.getCuentaContableProduccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodegaproducto.setCuentaContableDevolucion(bodegaproductoDataAccess.getCuentaContableDevolucion(connexion,bodegaproducto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(bodegaproducto.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodegaproducto.setCuentaContableIngresoDebito(bodegaproductoDataAccess.getCuentaContableIngresoDebito(connexion,bodegaproducto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(bodegaproducto.getCuentaContableIngresoDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodegaproducto.setCuentaContableIngresoCredito(bodegaproductoDataAccess.getCuentaContableIngresoCredito(connexion,bodegaproducto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(bodegaproducto.getCuentaContableIngresoCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodegaproducto.setCuentaContableResultadoDebito(bodegaproductoDataAccess.getCuentaContableResultadoDebito(connexion,bodegaproducto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(bodegaproducto.getCuentaContableResultadoDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodegaproducto.setCuentaContableResultadoCredito(bodegaproductoDataAccess.getCuentaContableResultadoCredito(connexion,bodegaproducto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(bodegaproducto.getCuentaContableResultadoCredito(),isDeep,deepLoadType,clases);				
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
			bodegaproducto.setEmpresa(bodegaproductoDataAccess.getEmpresa(connexion,bodegaproducto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(bodegaproducto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setSucursal(bodegaproductoDataAccess.getSucursal(connexion,bodegaproducto));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(bodegaproducto.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setBodega(bodegaproductoDataAccess.getBodega(connexion,bodegaproducto));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(bodegaproducto.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setProducto(bodegaproductoDataAccess.getProducto(connexion,bodegaproducto));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(bodegaproducto.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setUnidad(bodegaproductoDataAccess.getUnidad(connexion,bodegaproducto));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(bodegaproducto.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCentroCosto(bodegaproductoDataAccess.getCentroCosto(connexion,bodegaproducto));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(bodegaproducto.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoBodegaProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setEstadoBodegaProducto(bodegaproductoDataAccess.getEstadoBodegaProducto(connexion,bodegaproducto));
			EstadoBodegaProductoLogic estadobodegaproductoLogic= new EstadoBodegaProductoLogic(connexion);
			estadobodegaproductoLogic.deepLoad(bodegaproducto.getEstadoBodegaProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCuentaContableInventario(bodegaproductoDataAccess.getCuentaContableInventario(connexion,bodegaproducto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(bodegaproducto.getCuentaContableInventario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCuentaContableCostoVenta(bodegaproductoDataAccess.getCuentaContableCostoVenta(connexion,bodegaproducto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(bodegaproducto.getCuentaContableCostoVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCuentaContableVenta(bodegaproductoDataAccess.getCuentaContableVenta(connexion,bodegaproducto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(bodegaproducto.getCuentaContableVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCuentaContableDescuento(bodegaproductoDataAccess.getCuentaContableDescuento(connexion,bodegaproducto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(bodegaproducto.getCuentaContableDescuento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCuentaContableProduccion(bodegaproductoDataAccess.getCuentaContableProduccion(connexion,bodegaproducto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(bodegaproducto.getCuentaContableProduccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCuentaContableDevolucion(bodegaproductoDataAccess.getCuentaContableDevolucion(connexion,bodegaproducto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(bodegaproducto.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCuentaContableIngresoDebito(bodegaproductoDataAccess.getCuentaContableIngresoDebito(connexion,bodegaproducto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(bodegaproducto.getCuentaContableIngresoDebito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCuentaContableIngresoCredito(bodegaproductoDataAccess.getCuentaContableIngresoCredito(connexion,bodegaproducto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(bodegaproducto.getCuentaContableIngresoCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCuentaContableResultadoDebito(bodegaproductoDataAccess.getCuentaContableResultadoDebito(connexion,bodegaproducto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(bodegaproducto.getCuentaContableResultadoDebito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegaproducto.setCuentaContableResultadoCredito(bodegaproductoDataAccess.getCuentaContableResultadoCredito(connexion,bodegaproducto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(bodegaproducto.getCuentaContableResultadoCredito(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(BodegaProducto bodegaproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			BodegaProductoLogicAdditional.updateBodegaProductoToSave(bodegaproducto,this.arrDatoGeneral);
			
BodegaProductoDataAccess.save(bodegaproducto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(bodegaproducto.getEmpresa(),connexion);

		SucursalDataAccess.save(bodegaproducto.getSucursal(),connexion);

		BodegaDataAccess.save(bodegaproducto.getBodega(),connexion);

		ProductoDataAccess.save(bodegaproducto.getProducto(),connexion);

		UnidadDataAccess.save(bodegaproducto.getUnidad(),connexion);

		CentroCostoDataAccess.save(bodegaproducto.getCentroCosto(),connexion);

		EstadoBodegaProductoDataAccess.save(bodegaproducto.getEstadoBodegaProducto(),connexion);

		CuentaContableDataAccess.save(bodegaproducto.getCuentaContableInventario(),connexion);

		CuentaContableDataAccess.save(bodegaproducto.getCuentaContableCostoVenta(),connexion);

		CuentaContableDataAccess.save(bodegaproducto.getCuentaContableVenta(),connexion);

		CuentaContableDataAccess.save(bodegaproducto.getCuentaContableDescuento(),connexion);

		CuentaContableDataAccess.save(bodegaproducto.getCuentaContableProduccion(),connexion);

		CuentaContableDataAccess.save(bodegaproducto.getCuentaContableDevolucion(),connexion);

		CuentaContableDataAccess.save(bodegaproducto.getCuentaContableIngresoDebito(),connexion);

		CuentaContableDataAccess.save(bodegaproducto.getCuentaContableIngresoCredito(),connexion);

		CuentaContableDataAccess.save(bodegaproducto.getCuentaContableResultadoDebito(),connexion);

		CuentaContableDataAccess.save(bodegaproducto.getCuentaContableResultadoCredito(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(bodegaproducto.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(bodegaproducto.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(bodegaproducto.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(bodegaproducto.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(bodegaproducto.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(bodegaproducto.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoBodegaProducto.class)) {
				EstadoBodegaProductoDataAccess.save(bodegaproducto.getEstadoBodegaProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodegaproducto.getCuentaContableInventario(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodegaproducto.getCuentaContableCostoVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodegaproducto.getCuentaContableVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodegaproducto.getCuentaContableDescuento(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodegaproducto.getCuentaContableProduccion(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodegaproducto.getCuentaContableDevolucion(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodegaproducto.getCuentaContableIngresoDebito(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodegaproducto.getCuentaContableIngresoCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodegaproducto.getCuentaContableResultadoDebito(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodegaproducto.getCuentaContableResultadoCredito(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(bodegaproducto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(bodegaproducto.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(bodegaproducto.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(bodegaproducto.getSucursal(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(bodegaproducto.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(bodegaproducto.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(bodegaproducto.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(bodegaproducto.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(bodegaproducto.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(bodegaproducto.getUnidad(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(bodegaproducto.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(bodegaproducto.getCentroCosto(),isDeep,deepLoadType,clases);
				

		EstadoBodegaProductoDataAccess.save(bodegaproducto.getEstadoBodegaProducto(),connexion);
		EstadoBodegaProductoLogic estadobodegaproductoLogic= new EstadoBodegaProductoLogic(connexion);
		estadobodegaproductoLogic.deepLoad(bodegaproducto.getEstadoBodegaProducto(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(bodegaproducto.getCuentaContableInventario(),connexion);
		CuentaContableLogic cuentacontableinventarioLogic= new CuentaContableLogic(connexion);
		cuentacontableinventarioLogic.deepLoad(bodegaproducto.getCuentaContableInventario(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(bodegaproducto.getCuentaContableCostoVenta(),connexion);
		CuentaContableLogic cuentacontablecostoventaLogic= new CuentaContableLogic(connexion);
		cuentacontablecostoventaLogic.deepLoad(bodegaproducto.getCuentaContableCostoVenta(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(bodegaproducto.getCuentaContableVenta(),connexion);
		CuentaContableLogic cuentacontableventaLogic= new CuentaContableLogic(connexion);
		cuentacontableventaLogic.deepLoad(bodegaproducto.getCuentaContableVenta(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(bodegaproducto.getCuentaContableDescuento(),connexion);
		CuentaContableLogic cuentacontabledescuentoLogic= new CuentaContableLogic(connexion);
		cuentacontabledescuentoLogic.deepLoad(bodegaproducto.getCuentaContableDescuento(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(bodegaproducto.getCuentaContableProduccion(),connexion);
		CuentaContableLogic cuentacontableproduccionLogic= new CuentaContableLogic(connexion);
		cuentacontableproduccionLogic.deepLoad(bodegaproducto.getCuentaContableProduccion(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(bodegaproducto.getCuentaContableDevolucion(),connexion);
		CuentaContableLogic cuentacontabledevolucionLogic= new CuentaContableLogic(connexion);
		cuentacontabledevolucionLogic.deepLoad(bodegaproducto.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(bodegaproducto.getCuentaContableIngresoDebito(),connexion);
		CuentaContableLogic cuentacontableingresodebitoLogic= new CuentaContableLogic(connexion);
		cuentacontableingresodebitoLogic.deepLoad(bodegaproducto.getCuentaContableIngresoDebito(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(bodegaproducto.getCuentaContableIngresoCredito(),connexion);
		CuentaContableLogic cuentacontableingresocreditoLogic= new CuentaContableLogic(connexion);
		cuentacontableingresocreditoLogic.deepLoad(bodegaproducto.getCuentaContableIngresoCredito(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(bodegaproducto.getCuentaContableResultadoDebito(),connexion);
		CuentaContableLogic cuentacontableresultadodebitoLogic= new CuentaContableLogic(connexion);
		cuentacontableresultadodebitoLogic.deepLoad(bodegaproducto.getCuentaContableResultadoDebito(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(bodegaproducto.getCuentaContableResultadoCredito(),connexion);
		CuentaContableLogic cuentacontableresultadocreditoLogic= new CuentaContableLogic(connexion);
		cuentacontableresultadocreditoLogic.deepLoad(bodegaproducto.getCuentaContableResultadoCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(bodegaproducto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(bodegaproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(bodegaproducto.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(bodegaproducto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(bodegaproducto.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(bodegaproducto.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(bodegaproducto.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(bodegaproducto.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(bodegaproducto.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(bodegaproducto.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(bodegaproducto.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(bodegaproducto.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoBodegaProducto.class)) {
				EstadoBodegaProductoDataAccess.save(bodegaproducto.getEstadoBodegaProducto(),connexion);
				EstadoBodegaProductoLogic estadobodegaproductoLogic= new EstadoBodegaProductoLogic(connexion);
				estadobodegaproductoLogic.deepSave(bodegaproducto.getEstadoBodegaProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodegaproducto.getCuentaContableInventario(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(bodegaproducto.getCuentaContableInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodegaproducto.getCuentaContableCostoVenta(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(bodegaproducto.getCuentaContableCostoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodegaproducto.getCuentaContableVenta(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(bodegaproducto.getCuentaContableVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodegaproducto.getCuentaContableDescuento(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(bodegaproducto.getCuentaContableDescuento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodegaproducto.getCuentaContableProduccion(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(bodegaproducto.getCuentaContableProduccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodegaproducto.getCuentaContableDevolucion(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(bodegaproducto.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodegaproducto.getCuentaContableIngresoDebito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(bodegaproducto.getCuentaContableIngresoDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodegaproducto.getCuentaContableIngresoCredito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(bodegaproducto.getCuentaContableIngresoCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodegaproducto.getCuentaContableResultadoDebito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(bodegaproducto.getCuentaContableResultadoDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodegaproducto.getCuentaContableResultadoCredito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(bodegaproducto.getCuentaContableResultadoCredito(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(BodegaProducto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(bodegaproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(bodegaproducto);
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
			this.deepLoad(this.bodegaproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(BodegaProducto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(bodegaproductos!=null) {
				for(BodegaProducto bodegaproducto:bodegaproductos) {
					this.deepLoad(bodegaproducto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(bodegaproductos);
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
			if(bodegaproductos!=null) {
				for(BodegaProducto bodegaproducto:bodegaproductos) {
					this.deepLoad(bodegaproducto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(bodegaproductos);
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
			this.getNewConnexionToDeep(BodegaProducto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(bodegaproducto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(BodegaProducto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(bodegaproductos!=null) {
				for(BodegaProducto bodegaproducto:bodegaproductos) {
					this.deepSave(bodegaproducto,isDeep,deepLoadType,clases);
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
			if(bodegaproductos!=null) {
				for(BodegaProducto bodegaproducto:bodegaproductos) {
					this.deepSave(bodegaproducto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getBodegaProductosFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,BodegaProductoConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaProductosFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,BodegaProductoConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegaProductosFK_IdBodegaProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_bodega_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoBodegaProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoBodegaProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_bodega_producto,BodegaProductoConstantesFunciones.IDESTADOBODEGAPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoBodegaProducto);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaProductosFK_IdBodegaProducto(String sFinalQuery,Pagination pagination,Long id_estado_bodega_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoBodegaProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoBodegaProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_bodega_producto,BodegaProductoConstantesFunciones.IDESTADOBODEGAPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoBodegaProducto);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegaProductosFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,BodegaProductoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaProductosFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,BodegaProductoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegaProductosFK_IdCuentaContableCostoVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCostoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCostoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo_venta,BodegaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCostoVenta);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCostoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaProductosFK_IdCuentaContableCostoVenta(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCostoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCostoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo_venta,BodegaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCostoVenta);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCostoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegaProductosFK_IdCuentaContableDescuentoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_descuento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDescuento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDescuento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_descuento,BodegaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDescuento);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDescuento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaProductosFK_IdCuentaContableDescuento(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_descuento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDescuento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDescuento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_descuento,BodegaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDescuento);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDescuento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegaProductosFK_IdCuentaContableDevolucionWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_devolucion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDevolucion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDevolucion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_devolucion,BodegaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDevolucion);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDevolucion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaProductosFK_IdCuentaContableDevolucion(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_devolucion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDevolucion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDevolucion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_devolucion,BodegaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDevolucion);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDevolucion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegaProductosFK_IdCuentaContableIngresoCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_ingreso_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIngresoCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIngresoCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_ingreso_credito,BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESOCREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIngresoCredito);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIngresoCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaProductosFK_IdCuentaContableIngresoCredito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_ingreso_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIngresoCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIngresoCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_ingreso_credito,BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESOCREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIngresoCredito);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIngresoCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegaProductosFK_IdCuentaContableIngresoDebitoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_ingreso_debito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIngresoDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIngresoDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_ingreso_debito,BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESODEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIngresoDebito);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIngresoDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaProductosFK_IdCuentaContableIngresoDebito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_ingreso_debito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIngresoDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIngresoDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_ingreso_debito,BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESODEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIngresoDebito);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIngresoDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegaProductosFK_IdCuentaContableInventarioWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_inventario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_inventario,BodegaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableInventario);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaProductosFK_IdCuentaContableInventario(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_inventario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_inventario,BodegaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableInventario);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegaProductosFK_IdCuentaContableProduccionWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_produccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableProduccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableProduccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_produccion,BodegaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableProduccion);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableProduccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaProductosFK_IdCuentaContableProduccion(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_produccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableProduccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableProduccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_produccion,BodegaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableProduccion);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableProduccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegaProductosFK_IdCuentaContableResultadoCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_resultado_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableResultadoCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableResultadoCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_resultado_credito,BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADOCREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableResultadoCredito);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableResultadoCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaProductosFK_IdCuentaContableResultadoCredito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_resultado_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableResultadoCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableResultadoCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_resultado_credito,BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADOCREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableResultadoCredito);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableResultadoCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegaProductosFK_IdCuentaContableResultadoDebitoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_resultado_debito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableResultadoDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableResultadoDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_resultado_debito,BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADODEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableResultadoDebito);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableResultadoDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaProductosFK_IdCuentaContableResultadoDebito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_resultado_debito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableResultadoDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableResultadoDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_resultado_debito,BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADODEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableResultadoDebito);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableResultadoDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegaProductosFK_IdCuentaContableVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_venta,BodegaProductoConstantesFunciones.IDCUENTACONTABLEVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableVenta);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaProductosFK_IdCuentaContableVenta(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_venta,BodegaProductoConstantesFunciones.IDCUENTACONTABLEVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableVenta);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegaProductosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,BodegaProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaProductosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,BodegaProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegaProductosFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,BodegaProductoConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaProductosFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,BodegaProductoConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegaProductosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,BodegaProductoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaProductosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,BodegaProductoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegaProductosFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,BodegaProductoConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaProductosFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,BodegaProductoConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			BodegaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegaProductoPorIdBodegaPorIdProductoPorIdUnidadWithConnection(Long id_bodega,Long id_producto,Long id_unidad)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,BodegaProductoConstantesFunciones.IDBODEGA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,BodegaProductoConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,BodegaProductoConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			bodegaproducto=bodegaproductoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.bodegaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproducto);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaProductoPorIdBodegaPorIdProductoPorIdUnidad(Long id_bodega,Long id_producto,Long id_unidad)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,BodegaProductoConstantesFunciones.IDBODEGA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,BodegaProductoConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,BodegaProductoConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			bodegaproducto=bodegaproductoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.bodegaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				BodegaProductoConstantesFunciones.refrescarForeignKeysDescripcionesBodegaProducto(this.bodegaproducto);
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
			if(BodegaProductoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,BodegaProductoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,BodegaProducto bodegaproducto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(BodegaProductoConstantesFunciones.ISCONAUDITORIA) {
				if(bodegaproducto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BodegaProductoDataAccess.TABLENAME, bodegaproducto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(BodegaProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////BodegaProductoLogic.registrarAuditoriaDetallesBodegaProducto(connexion,bodegaproducto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(bodegaproducto.getIsDeleted()) {
					/*if(!bodegaproducto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,BodegaProductoDataAccess.TABLENAME, bodegaproducto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////BodegaProductoLogic.registrarAuditoriaDetallesBodegaProducto(connexion,bodegaproducto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BodegaProductoDataAccess.TABLENAME, bodegaproducto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(bodegaproducto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BodegaProductoDataAccess.TABLENAME, bodegaproducto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(BodegaProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////BodegaProductoLogic.registrarAuditoriaDetallesBodegaProducto(connexion,bodegaproducto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesBodegaProducto(Connexion connexion,BodegaProducto bodegaproducto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getid_empresa().equals(bodegaproducto.getBodegaProductoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getid_empresa()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getid_empresa().toString();
				}
				if(bodegaproducto.getid_empresa()!=null)
				{
					strValorNuevo=bodegaproducto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getid_sucursal().equals(bodegaproducto.getBodegaProductoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getid_sucursal()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getid_sucursal().toString();
				}
				if(bodegaproducto.getid_sucursal()!=null)
				{
					strValorNuevo=bodegaproducto.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getid_bodega().equals(bodegaproducto.getBodegaProductoOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getid_bodega()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getid_bodega().toString();
				}
				if(bodegaproducto.getid_bodega()!=null)
				{
					strValorNuevo=bodegaproducto.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getid_producto().equals(bodegaproducto.getBodegaProductoOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getid_producto()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getid_producto().toString();
				}
				if(bodegaproducto.getid_producto()!=null)
				{
					strValorNuevo=bodegaproducto.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getid_unidad().equals(bodegaproducto.getBodegaProductoOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getid_unidad()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getid_unidad().toString();
				}
				if(bodegaproducto.getid_unidad()!=null)
				{
					strValorNuevo=bodegaproducto.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getid_centro_costo().equals(bodegaproducto.getBodegaProductoOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getid_centro_costo()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getid_centro_costo().toString();
				}
				if(bodegaproducto.getid_centro_costo()!=null)
				{
					strValorNuevo=bodegaproducto.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getid_estado_bodega_producto().equals(bodegaproducto.getBodegaProductoOriginal().getid_estado_bodega_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getid_estado_bodega_producto()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getid_estado_bodega_producto().toString();
				}
				if(bodegaproducto.getid_estado_bodega_producto()!=null)
				{
					strValorNuevo=bodegaproducto.getid_estado_bodega_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.IDESTADOBODEGAPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getdescripcion().equals(bodegaproducto.getBodegaProductoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getdescripcion()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getdescripcion();
				}
				if(bodegaproducto.getdescripcion()!=null)
				{
					strValorNuevo=bodegaproducto.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getcantidad_disponible().equals(bodegaproducto.getBodegaProductoOriginal().getcantidad_disponible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getcantidad_disponible()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getcantidad_disponible().toString();
				}
				if(bodegaproducto.getcantidad_disponible()!=null)
				{
					strValorNuevo=bodegaproducto.getcantidad_disponible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.CANTIDADDISPONIBLE,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getstock_maximo().equals(bodegaproducto.getBodegaProductoOriginal().getstock_maximo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getstock_maximo()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getstock_maximo().toString();
				}
				if(bodegaproducto.getstock_maximo()!=null)
				{
					strValorNuevo=bodegaproducto.getstock_maximo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.STOCKMAXIMO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getstock_minimo().equals(bodegaproducto.getBodegaProductoOriginal().getstock_minimo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getstock_minimo()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getstock_minimo().toString();
				}
				if(bodegaproducto.getstock_minimo()!=null)
				{
					strValorNuevo=bodegaproducto.getstock_minimo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.STOCKMINIMO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getiva().equals(bodegaproducto.getBodegaProductoOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getiva()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getiva().toString();
				}
				if(bodegaproducto.getiva()!=null)
				{
					strValorNuevo=bodegaproducto.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getiva_valor().equals(bodegaproducto.getBodegaProductoOriginal().getiva_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getiva_valor()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getiva_valor().toString();
				}
				if(bodegaproducto.getiva_valor()!=null)
				{
					strValorNuevo=bodegaproducto.getiva_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.IVAVALOR,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getdescuento().equals(bodegaproducto.getBodegaProductoOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getdescuento()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getdescuento().toString();
				}
				if(bodegaproducto.getdescuento()!=null)
				{
					strValorNuevo=bodegaproducto.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getdescuento_valor().equals(bodegaproducto.getBodegaProductoOriginal().getdescuento_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getdescuento_valor()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getdescuento_valor().toString();
				}
				if(bodegaproducto.getdescuento_valor()!=null)
				{
					strValorNuevo=bodegaproducto.getdescuento_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.DESCUENTOVALOR,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getice().equals(bodegaproducto.getBodegaProductoOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getice()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getice().toString();
				}
				if(bodegaproducto.getice()!=null)
				{
					strValorNuevo=bodegaproducto.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getice_valor().equals(bodegaproducto.getBodegaProductoOriginal().getice_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getice_valor()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getice_valor().toString();
				}
				if(bodegaproducto.getice_valor()!=null)
				{
					strValorNuevo=bodegaproducto.getice_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.ICEVALOR,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getcosto_promedio().equals(bodegaproducto.getBodegaProductoOriginal().getcosto_promedio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getcosto_promedio()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getcosto_promedio().toString();
				}
				if(bodegaproducto.getcosto_promedio()!=null)
				{
					strValorNuevo=bodegaproducto.getcosto_promedio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.COSTOPROMEDIO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getporcentaje_comision().equals(bodegaproducto.getBodegaProductoOriginal().getporcentaje_comision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getporcentaje_comision()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getporcentaje_comision().toString();
				}
				if(bodegaproducto.getporcentaje_comision()!=null)
				{
					strValorNuevo=bodegaproducto.getporcentaje_comision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.PORCENTAJECOMISION,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getprecio().equals(bodegaproducto.getBodegaProductoOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getprecio()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getprecio().toString();
				}
				if(bodegaproducto.getprecio()!=null)
				{
					strValorNuevo=bodegaproducto.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getultimo_costo().equals(bodegaproducto.getBodegaProductoOriginal().getultimo_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getultimo_costo()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getultimo_costo().toString();
				}
				if(bodegaproducto.getultimo_costo()!=null)
				{
					strValorNuevo=bodegaproducto.getultimo_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.ULTIMOCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getcosto().equals(bodegaproducto.getBodegaProductoOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getcosto()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getcosto().toString();
				}
				if(bodegaproducto.getcosto()!=null)
				{
					strValorNuevo=bodegaproducto.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getarancel_porcentaje().equals(bodegaproducto.getBodegaProductoOriginal().getarancel_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getarancel_porcentaje()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getarancel_porcentaje().toString();
				}
				if(bodegaproducto.getarancel_porcentaje()!=null)
				{
					strValorNuevo=bodegaproducto.getarancel_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.ARANCELPORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getice_porcentaje().equals(bodegaproducto.getBodegaProductoOriginal().getice_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getice_porcentaje()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getice_porcentaje().toString();
				}
				if(bodegaproducto.getice_porcentaje()!=null)
				{
					strValorNuevo=bodegaproducto.getice_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.ICEPORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getpeso().equals(bodegaproducto.getBodegaProductoOriginal().getpeso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getpeso()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getpeso().toString();
				}
				if(bodegaproducto.getpeso()!=null)
				{
					strValorNuevo=bodegaproducto.getpeso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.PESO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getcon_iva().equals(bodegaproducto.getBodegaProductoOriginal().getcon_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getcon_iva()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getcon_iva().toString();
				}
				if(bodegaproducto.getcon_iva()!=null)
				{
					strValorNuevo=bodegaproducto.getcon_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.CONIVA,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getcon_impuesto().equals(bodegaproducto.getBodegaProductoOriginal().getcon_impuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getcon_impuesto()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getcon_impuesto().toString();
				}
				if(bodegaproducto.getcon_impuesto()!=null)
				{
					strValorNuevo=bodegaproducto.getcon_impuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.CONIMPUESTO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getcon_ice().equals(bodegaproducto.getBodegaProductoOriginal().getcon_ice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getcon_ice()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getcon_ice().toString();
				}
				if(bodegaproducto.getcon_ice()!=null)
				{
					strValorNuevo=bodegaproducto.getcon_ice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.CONICE,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getesta_activo().equals(bodegaproducto.getBodegaProductoOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getesta_activo()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getesta_activo().toString();
				}
				if(bodegaproducto.getesta_activo()!=null)
				{
					strValorNuevo=bodegaproducto.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getcon_balanza().equals(bodegaproducto.getBodegaProductoOriginal().getcon_balanza()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getcon_balanza()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getcon_balanza().toString();
				}
				if(bodegaproducto.getcon_balanza()!=null)
				{
					strValorNuevo=bodegaproducto.getcon_balanza().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.CONBALANZA,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getcantidad_pedida().equals(bodegaproducto.getBodegaProductoOriginal().getcantidad_pedida()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getcantidad_pedida()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getcantidad_pedida().toString();
				}
				if(bodegaproducto.getcantidad_pedida()!=null)
				{
					strValorNuevo=bodegaproducto.getcantidad_pedida().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.CANTIDADPEDIDA,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getcantidad_fisica().equals(bodegaproducto.getBodegaProductoOriginal().getcantidad_fisica()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getcantidad_fisica()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getcantidad_fisica().toString();
				}
				if(bodegaproducto.getcantidad_fisica()!=null)
				{
					strValorNuevo=bodegaproducto.getcantidad_fisica().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.CANTIDADFISICA,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getcantidad_requerido().equals(bodegaproducto.getBodegaProductoOriginal().getcantidad_requerido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getcantidad_requerido()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getcantidad_requerido().toString();
				}
				if(bodegaproducto.getcantidad_requerido()!=null)
				{
					strValorNuevo=bodegaproducto.getcantidad_requerido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.CANTIDADREQUERIDO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getprecio_costo().equals(bodegaproducto.getBodegaProductoOriginal().getprecio_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getprecio_costo()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getprecio_costo().toString();
				}
				if(bodegaproducto.getprecio_costo()!=null)
				{
					strValorNuevo=bodegaproducto.getprecio_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.PRECIOCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getprecio_promedio().equals(bodegaproducto.getBodegaProductoOriginal().getprecio_promedio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getprecio_promedio()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getprecio_promedio().toString();
				}
				if(bodegaproducto.getprecio_promedio()!=null)
				{
					strValorNuevo=bodegaproducto.getprecio_promedio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.PRECIOPROMEDIO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.gettotal_ingresos().equals(bodegaproducto.getBodegaProductoOriginal().gettotal_ingresos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().gettotal_ingresos()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().gettotal_ingresos().toString();
				}
				if(bodegaproducto.gettotal_ingresos()!=null)
				{
					strValorNuevo=bodegaproducto.gettotal_ingresos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.TOTALINGRESOS,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.gettotal_egresos().equals(bodegaproducto.getBodegaProductoOriginal().gettotal_egresos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().gettotal_egresos()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().gettotal_egresos().toString();
				}
				if(bodegaproducto.gettotal_egresos()!=null)
				{
					strValorNuevo=bodegaproducto.gettotal_egresos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.TOTALEGRESOS,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.gettotal_provision().equals(bodegaproducto.getBodegaProductoOriginal().gettotal_provision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().gettotal_provision()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().gettotal_provision().toString();
				}
				if(bodegaproducto.gettotal_provision()!=null)
				{
					strValorNuevo=bodegaproducto.gettotal_provision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.TOTALPROVISION,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.gettotal_proceso().equals(bodegaproducto.getBodegaProductoOriginal().gettotal_proceso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().gettotal_proceso()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().gettotal_proceso().toString();
				}
				if(bodegaproducto.gettotal_proceso()!=null)
				{
					strValorNuevo=bodegaproducto.gettotal_proceso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.TOTALPROCESO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getcosto_calculado().equals(bodegaproducto.getBodegaProductoOriginal().getcosto_calculado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getcosto_calculado()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getcosto_calculado().toString();
				}
				if(bodegaproducto.getcosto_calculado()!=null)
				{
					strValorNuevo=bodegaproducto.getcosto_calculado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.COSTOCALCULADO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getdias_produccion().equals(bodegaproducto.getBodegaProductoOriginal().getdias_produccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getdias_produccion()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getdias_produccion().toString();
				}
				if(bodegaproducto.getdias_produccion()!=null)
				{
					strValorNuevo=bodegaproducto.getdias_produccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.DIASPRODUCCION,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getprecio_reposicion().equals(bodegaproducto.getBodegaProductoOriginal().getprecio_reposicion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getprecio_reposicion()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getprecio_reposicion().toString();
				}
				if(bodegaproducto.getprecio_reposicion()!=null)
				{
					strValorNuevo=bodegaproducto.getprecio_reposicion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.PRECIOREPOSICION,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getfecha_ultimo_pedido().equals(bodegaproducto.getBodegaProductoOriginal().getfecha_ultimo_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getfecha_ultimo_pedido()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getfecha_ultimo_pedido().toString();
				}
				if(bodegaproducto.getfecha_ultimo_pedido()!=null)
				{
					strValorNuevo=bodegaproducto.getfecha_ultimo_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.FECHAULTIMOPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getfecha_ingreso().equals(bodegaproducto.getBodegaProductoOriginal().getfecha_ingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getfecha_ingreso()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getfecha_ingreso().toString();
				}
				if(bodegaproducto.getfecha_ingreso()!=null)
				{
					strValorNuevo=bodegaproducto.getfecha_ingreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.FECHAINGRESO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getfecha_egreso().equals(bodegaproducto.getBodegaProductoOriginal().getfecha_egreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getfecha_egreso()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getfecha_egreso().toString();
				}
				if(bodegaproducto.getfecha_egreso()!=null)
				{
					strValorNuevo=bodegaproducto.getfecha_egreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.FECHAEGRESO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getfecha_ultima_compra().equals(bodegaproducto.getBodegaProductoOriginal().getfecha_ultima_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getfecha_ultima_compra()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getfecha_ultima_compra().toString();
				}
				if(bodegaproducto.getfecha_ultima_compra()!=null)
				{
					strValorNuevo=bodegaproducto.getfecha_ultima_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.FECHAULTIMACOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getfecha_ultima_venta().equals(bodegaproducto.getBodegaProductoOriginal().getfecha_ultima_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getfecha_ultima_venta()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getfecha_ultima_venta().toString();
				}
				if(bodegaproducto.getfecha_ultima_venta()!=null)
				{
					strValorNuevo=bodegaproducto.getfecha_ultima_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.FECHAULTIMAVENTA,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getfecha_ultima_devolucion().equals(bodegaproducto.getBodegaProductoOriginal().getfecha_ultima_devolucion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getfecha_ultima_devolucion()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getfecha_ultima_devolucion().toString();
				}
				if(bodegaproducto.getfecha_ultima_devolucion()!=null)
				{
					strValorNuevo=bodegaproducto.getfecha_ultima_devolucion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.FECHAULTIMADEVOLUCION,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getid_cuenta_contable_inventario().equals(bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_inventario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_inventario()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_inventario().toString();
				}
				if(bodegaproducto.getid_cuenta_contable_inventario()!=null)
				{
					strValorNuevo=bodegaproducto.getid_cuenta_contable_inventario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getid_cuenta_contable_costo_venta().equals(bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_costo_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_costo_venta()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_costo_venta().toString();
				}
				if(bodegaproducto.getid_cuenta_contable_costo_venta()!=null)
				{
					strValorNuevo=bodegaproducto.getid_cuenta_contable_costo_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getid_cuenta_contable_venta().equals(bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_venta()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_venta().toString();
				}
				if(bodegaproducto.getid_cuenta_contable_venta()!=null)
				{
					strValorNuevo=bodegaproducto.getid_cuenta_contable_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.IDCUENTACONTABLEVENTA,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getid_cuenta_contable_descuento().equals(bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_descuento()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_descuento().toString();
				}
				if(bodegaproducto.getid_cuenta_contable_descuento()!=null)
				{
					strValorNuevo=bodegaproducto.getid_cuenta_contable_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getid_cuenta_contable_produccion().equals(bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_produccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_produccion()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_produccion().toString();
				}
				if(bodegaproducto.getid_cuenta_contable_produccion()!=null)
				{
					strValorNuevo=bodegaproducto.getid_cuenta_contable_produccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getid_cuenta_contable_devolucion().equals(bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_devolucion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_devolucion()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_devolucion().toString();
				}
				if(bodegaproducto.getid_cuenta_contable_devolucion()!=null)
				{
					strValorNuevo=bodegaproducto.getid_cuenta_contable_devolucion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getid_cuenta_contable_ingreso_debito().equals(bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_ingreso_debito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_ingreso_debito()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_ingreso_debito().toString();
				}
				if(bodegaproducto.getid_cuenta_contable_ingreso_debito()!=null)
				{
					strValorNuevo=bodegaproducto.getid_cuenta_contable_ingreso_debito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESODEBITO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getid_cuenta_contable_ingreso_credito().equals(bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_ingreso_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_ingreso_credito()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_ingreso_credito().toString();
				}
				if(bodegaproducto.getid_cuenta_contable_ingreso_credito()!=null)
				{
					strValorNuevo=bodegaproducto.getid_cuenta_contable_ingreso_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESOCREDITO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getid_cuenta_contable_resultado_debito().equals(bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_resultado_debito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_resultado_debito()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_resultado_debito().toString();
				}
				if(bodegaproducto.getid_cuenta_contable_resultado_debito()!=null)
				{
					strValorNuevo=bodegaproducto.getid_cuenta_contable_resultado_debito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADODEBITO,strValorActual,strValorNuevo);
			}	
			
			if(bodegaproducto.getIsNew()||!bodegaproducto.getid_cuenta_contable_resultado_credito().equals(bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_resultado_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_resultado_credito()!=null)
				{
					strValorActual=bodegaproducto.getBodegaProductoOriginal().getid_cuenta_contable_resultado_credito().toString();
				}
				if(bodegaproducto.getid_cuenta_contable_resultado_credito()!=null)
				{
					strValorNuevo=bodegaproducto.getid_cuenta_contable_resultado_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADOCREDITO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveBodegaProductoRelacionesWithConnection(BodegaProducto bodegaproducto) throws Exception {

		if(!bodegaproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveBodegaProductoRelacionesBase(bodegaproducto,true);
		}
	}

	public void saveBodegaProductoRelaciones(BodegaProducto bodegaproducto)throws Exception {

		if(!bodegaproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveBodegaProductoRelacionesBase(bodegaproducto,false);
		}
	}

	public void saveBodegaProductoRelacionesBase(BodegaProducto bodegaproducto,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("BodegaProducto-saveRelacionesWithConnection");}
	

			this.setBodegaProducto(bodegaproducto);

			if(BodegaProductoLogicAdditional.validarSaveRelaciones(bodegaproducto,this)) {

				BodegaProductoLogicAdditional.updateRelacionesToSave(bodegaproducto,this);

				if((bodegaproducto.getIsNew()||bodegaproducto.getIsChanged())&&!bodegaproducto.getIsDeleted()) {
					this.saveBodegaProducto();
					this.saveBodegaProductoRelacionesDetalles();

				} else if(bodegaproducto.getIsDeleted()) {
					this.saveBodegaProductoRelacionesDetalles();
					this.saveBodegaProducto();
				}

				BodegaProductoLogicAdditional.updateRelacionesToSaveAfter(bodegaproducto,this);

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
	
	
	private void saveBodegaProductoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfBodegaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=BodegaProductoConstantesFunciones.getClassesForeignKeysOfBodegaProducto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBodegaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=BodegaProductoConstantesFunciones.getClassesRelationshipsOfBodegaProducto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

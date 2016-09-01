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
import com.bydan.erp.inventario.util.CuentasContablesLineaProductoConstantesFunciones;
import com.bydan.erp.inventario.util.CuentasContablesLineaProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.CuentasContablesLineaProductoParameterGeneral;
import com.bydan.erp.inventario.business.entity.CuentasContablesLineaProducto;
import com.bydan.erp.inventario.business.logic.CuentasContablesLineaProductoLogicAdditional;
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
public class CuentasContablesLineaProductoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CuentasContablesLineaProductoLogic.class);
	
	protected CuentasContablesLineaProductoDataAccess cuentascontableslineaproductoDataAccess; 	
	protected CuentasContablesLineaProducto cuentascontableslineaproducto;
	protected List<CuentasContablesLineaProducto> cuentascontableslineaproductos;
	protected Object cuentascontableslineaproductoObject;	
	protected List<Object> cuentascontableslineaproductosObject;
	
	public static ClassValidator<CuentasContablesLineaProducto> cuentascontableslineaproductoValidator = new ClassValidator<CuentasContablesLineaProducto>(CuentasContablesLineaProducto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CuentasContablesLineaProductoLogicAdditional cuentascontableslineaproductoLogicAdditional=null;
	
	public CuentasContablesLineaProductoLogicAdditional getCuentasContablesLineaProductoLogicAdditional() {
		return this.cuentascontableslineaproductoLogicAdditional;
	}
	
	public void setCuentasContablesLineaProductoLogicAdditional(CuentasContablesLineaProductoLogicAdditional cuentascontableslineaproductoLogicAdditional) {
		try {
			this.cuentascontableslineaproductoLogicAdditional=cuentascontableslineaproductoLogicAdditional;
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
	
	
	
	
	public  CuentasContablesLineaProductoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cuentascontableslineaproductoDataAccess = new CuentasContablesLineaProductoDataAccess();
			
			this.cuentascontableslineaproductos= new ArrayList<CuentasContablesLineaProducto>();
			this.cuentascontableslineaproducto= new CuentasContablesLineaProducto();
			
			this.cuentascontableslineaproductoObject=new Object();
			this.cuentascontableslineaproductosObject=new ArrayList<Object>();
				
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
			
			this.cuentascontableslineaproductoDataAccess.setConnexionType(this.connexionType);
			this.cuentascontableslineaproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CuentasContablesLineaProductoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cuentascontableslineaproductoDataAccess = new CuentasContablesLineaProductoDataAccess();
			this.cuentascontableslineaproductos= new ArrayList<CuentasContablesLineaProducto>();
			this.cuentascontableslineaproducto= new CuentasContablesLineaProducto();
			this.cuentascontableslineaproductoObject=new Object();
			this.cuentascontableslineaproductosObject=new ArrayList<Object>();
			
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
			
			this.cuentascontableslineaproductoDataAccess.setConnexionType(this.connexionType);
			this.cuentascontableslineaproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CuentasContablesLineaProducto getCuentasContablesLineaProducto() throws Exception {	
		CuentasContablesLineaProductoLogicAdditional.checkCuentasContablesLineaProductoToGet(cuentascontableslineaproducto,this.datosCliente,this.arrDatoGeneral);
		CuentasContablesLineaProductoLogicAdditional.updateCuentasContablesLineaProductoToGet(cuentascontableslineaproducto,this.arrDatoGeneral);
		
		return cuentascontableslineaproducto;
	}
		
	public void setCuentasContablesLineaProducto(CuentasContablesLineaProducto newCuentasContablesLineaProducto) {
		this.cuentascontableslineaproducto = newCuentasContablesLineaProducto;
	}
	
	public CuentasContablesLineaProductoDataAccess getCuentasContablesLineaProductoDataAccess() {
		return cuentascontableslineaproductoDataAccess;
	}
	
	public void setCuentasContablesLineaProductoDataAccess(CuentasContablesLineaProductoDataAccess newcuentascontableslineaproductoDataAccess) {
		this.cuentascontableslineaproductoDataAccess = newcuentascontableslineaproductoDataAccess;
	}
	
	public List<CuentasContablesLineaProducto> getCuentasContablesLineaProductos() throws Exception {		
		this.quitarCuentasContablesLineaProductosNulos();
		
		CuentasContablesLineaProductoLogicAdditional.checkCuentasContablesLineaProductoToGets(cuentascontableslineaproductos,this.datosCliente,this.arrDatoGeneral);
		
		for (CuentasContablesLineaProducto cuentascontableslineaproductoLocal: cuentascontableslineaproductos ) {
			CuentasContablesLineaProductoLogicAdditional.updateCuentasContablesLineaProductoToGet(cuentascontableslineaproductoLocal,this.arrDatoGeneral);
		}
		
		return cuentascontableslineaproductos;
	}
	
	public void setCuentasContablesLineaProductos(List<CuentasContablesLineaProducto> newCuentasContablesLineaProductos) {
		this.cuentascontableslineaproductos = newCuentasContablesLineaProductos;
	}
	
	public Object getCuentasContablesLineaProductoObject() {	
		this.cuentascontableslineaproductoObject=this.cuentascontableslineaproductoDataAccess.getEntityObject();
		return this.cuentascontableslineaproductoObject;
	}
		
	public void setCuentasContablesLineaProductoObject(Object newCuentasContablesLineaProductoObject) {
		this.cuentascontableslineaproductoObject = newCuentasContablesLineaProductoObject;
	}
	
	public List<Object> getCuentasContablesLineaProductosObject() {		
		this.cuentascontableslineaproductosObject=this.cuentascontableslineaproductoDataAccess.getEntitiesObject();
		return this.cuentascontableslineaproductosObject;
	}
		
	public void setCuentasContablesLineaProductosObject(List<Object> newCuentasContablesLineaProductosObject) {
		this.cuentascontableslineaproductosObject = newCuentasContablesLineaProductosObject;
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
		
		if(this.cuentascontableslineaproductoDataAccess!=null) {
			this.cuentascontableslineaproductoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cuentascontableslineaproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cuentascontableslineaproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cuentascontableslineaproducto = new  CuentasContablesLineaProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuentascontableslineaproducto=cuentascontableslineaproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentascontableslineaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproducto);
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
		cuentascontableslineaproducto = new  CuentasContablesLineaProducto();
		  		  
        try {
			
			cuentascontableslineaproducto=cuentascontableslineaproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentascontableslineaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cuentascontableslineaproducto = new  CuentasContablesLineaProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuentascontableslineaproducto=cuentascontableslineaproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentascontableslineaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproducto);
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
		cuentascontableslineaproducto = new  CuentasContablesLineaProducto();
		  		  
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
		cuentascontableslineaproducto = new  CuentasContablesLineaProducto();
		  		  
        try {
			
			cuentascontableslineaproducto=cuentascontableslineaproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentascontableslineaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cuentascontableslineaproducto = new  CuentasContablesLineaProducto();
		  		  
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
		cuentascontableslineaproducto = new  CuentasContablesLineaProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cuentascontableslineaproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentascontableslineaproducto = new  CuentasContablesLineaProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cuentascontableslineaproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuentascontableslineaproducto = new  CuentasContablesLineaProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cuentascontableslineaproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentascontableslineaproducto = new  CuentasContablesLineaProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cuentascontableslineaproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuentascontableslineaproducto = new  CuentasContablesLineaProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cuentascontableslineaproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentascontableslineaproducto = new  CuentasContablesLineaProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cuentascontableslineaproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuentascontableslineaproductos = new  ArrayList<CuentasContablesLineaProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentasContablesLineaProducto(cuentascontableslineaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
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
		cuentascontableslineaproductos = new  ArrayList<CuentasContablesLineaProducto>();
		  		  
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
		cuentascontableslineaproductos = new  ArrayList<CuentasContablesLineaProducto>();
		  		  
        try {			
			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCuentasContablesLineaProducto(cuentascontableslineaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cuentascontableslineaproductos = new  ArrayList<CuentasContablesLineaProducto>();
		  		  
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
		cuentascontableslineaproductos = new  ArrayList<CuentasContablesLineaProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentasContablesLineaProducto(cuentascontableslineaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
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
		cuentascontableslineaproductos = new  ArrayList<CuentasContablesLineaProducto>();
		  		  
        try {
			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentasContablesLineaProducto(cuentascontableslineaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
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
		cuentascontableslineaproductos = new  ArrayList<CuentasContablesLineaProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentasContablesLineaProducto(cuentascontableslineaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
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
		cuentascontableslineaproductos = new  ArrayList<CuentasContablesLineaProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentasContablesLineaProducto(cuentascontableslineaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cuentascontableslineaproducto = new  CuentasContablesLineaProducto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentascontableslineaproducto=cuentascontableslineaproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentasContablesLineaProducto(cuentascontableslineaproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproducto);
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
		cuentascontableslineaproducto = new  CuentasContablesLineaProducto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentascontableslineaproducto=cuentascontableslineaproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentasContablesLineaProducto(cuentascontableslineaproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuentascontableslineaproductos = new  ArrayList<CuentasContablesLineaProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentasContablesLineaProducto(cuentascontableslineaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
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
		cuentascontableslineaproductos = new  ArrayList<CuentasContablesLineaProducto>();
		  		  
        try {
			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentasContablesLineaProducto(cuentascontableslineaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCuentasContablesLineaProductosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cuentascontableslineaproductos = new  ArrayList<CuentasContablesLineaProducto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getTodosCuentasContablesLineaProductosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuentasContablesLineaProducto(cuentascontableslineaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
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
	
	public  void  getTodosCuentasContablesLineaProductos(String sFinalQuery,Pagination pagination)throws Exception {
		cuentascontableslineaproductos = new  ArrayList<CuentasContablesLineaProducto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuentasContablesLineaProducto(cuentascontableslineaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCuentasContablesLineaProducto(CuentasContablesLineaProducto cuentascontableslineaproducto) throws Exception {
		Boolean estaValidado=false;
		
		if(cuentascontableslineaproducto.getIsNew() || cuentascontableslineaproducto.getIsChanged()) { 
			this.invalidValues = cuentascontableslineaproductoValidator.getInvalidValues(cuentascontableslineaproducto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cuentascontableslineaproducto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCuentasContablesLineaProducto(List<CuentasContablesLineaProducto> CuentasContablesLineaProductos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CuentasContablesLineaProducto cuentascontableslineaproductoLocal:cuentascontableslineaproductos) {				
			estaValidadoObjeto=this.validarGuardarCuentasContablesLineaProducto(cuentascontableslineaproductoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCuentasContablesLineaProducto(List<CuentasContablesLineaProducto> CuentasContablesLineaProductos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuentasContablesLineaProducto(cuentascontableslineaproductos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCuentasContablesLineaProducto(CuentasContablesLineaProducto CuentasContablesLineaProducto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuentasContablesLineaProducto(cuentascontableslineaproducto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CuentasContablesLineaProducto cuentascontableslineaproducto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cuentascontableslineaproducto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CuentasContablesLineaProductoConstantesFunciones.getCuentasContablesLineaProductoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cuentascontableslineaproducto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CuentasContablesLineaProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CuentasContablesLineaProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCuentasContablesLineaProductoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-saveCuentasContablesLineaProductoWithConnection");connexion.begin();			
			
			CuentasContablesLineaProductoLogicAdditional.checkCuentasContablesLineaProductoToSave(this.cuentascontableslineaproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuentasContablesLineaProductoLogicAdditional.updateCuentasContablesLineaProductoToSave(this.cuentascontableslineaproducto,this.arrDatoGeneral);
			
			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuentascontableslineaproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCuentasContablesLineaProducto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuentasContablesLineaProducto(this.cuentascontableslineaproducto)) {
				CuentasContablesLineaProductoDataAccess.save(this.cuentascontableslineaproducto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cuentascontableslineaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuentasContablesLineaProductoLogicAdditional.checkCuentasContablesLineaProductoToSaveAfter(this.cuentascontableslineaproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuentasContablesLineaProducto();
			
			connexion.commit();			
			
			if(this.cuentascontableslineaproducto.getIsDeleted()) {
				this.cuentascontableslineaproducto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCuentasContablesLineaProducto()throws Exception {	
		try {	
			
			CuentasContablesLineaProductoLogicAdditional.checkCuentasContablesLineaProductoToSave(this.cuentascontableslineaproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuentasContablesLineaProductoLogicAdditional.updateCuentasContablesLineaProductoToSave(this.cuentascontableslineaproducto,this.arrDatoGeneral);
			
			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuentascontableslineaproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuentasContablesLineaProducto(this.cuentascontableslineaproducto)) {			
				CuentasContablesLineaProductoDataAccess.save(this.cuentascontableslineaproducto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cuentascontableslineaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuentasContablesLineaProductoLogicAdditional.checkCuentasContablesLineaProductoToSaveAfter(this.cuentascontableslineaproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cuentascontableslineaproducto.getIsDeleted()) {
				this.cuentascontableslineaproducto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCuentasContablesLineaProductosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-saveCuentasContablesLineaProductosWithConnection");connexion.begin();			
			
			CuentasContablesLineaProductoLogicAdditional.checkCuentasContablesLineaProductoToSaves(cuentascontableslineaproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCuentasContablesLineaProductos();
			
			Boolean validadoTodosCuentasContablesLineaProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CuentasContablesLineaProducto cuentascontableslineaproductoLocal:cuentascontableslineaproductos) {		
				if(cuentascontableslineaproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuentasContablesLineaProductoLogicAdditional.updateCuentasContablesLineaProductoToSave(cuentascontableslineaproductoLocal,this.arrDatoGeneral);
	        	
				CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuentascontableslineaproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuentasContablesLineaProducto(cuentascontableslineaproductoLocal)) {
					CuentasContablesLineaProductoDataAccess.save(cuentascontableslineaproductoLocal, connexion);				
				} else {
					validadoTodosCuentasContablesLineaProducto=false;
				}
			}
			
			if(!validadoTodosCuentasContablesLineaProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuentasContablesLineaProductoLogicAdditional.checkCuentasContablesLineaProductoToSavesAfter(cuentascontableslineaproductos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuentasContablesLineaProductos();
			
			connexion.commit();		
			
			this.quitarCuentasContablesLineaProductosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCuentasContablesLineaProductos()throws Exception {				
		 try {	
			CuentasContablesLineaProductoLogicAdditional.checkCuentasContablesLineaProductoToSaves(cuentascontableslineaproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCuentasContablesLineaProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CuentasContablesLineaProducto cuentascontableslineaproductoLocal:cuentascontableslineaproductos) {				
				if(cuentascontableslineaproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuentasContablesLineaProductoLogicAdditional.updateCuentasContablesLineaProductoToSave(cuentascontableslineaproductoLocal,this.arrDatoGeneral);
	        	
				CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuentascontableslineaproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuentasContablesLineaProducto(cuentascontableslineaproductoLocal)) {				
					CuentasContablesLineaProductoDataAccess.save(cuentascontableslineaproductoLocal, connexion);				
				} else {
					validadoTodosCuentasContablesLineaProducto=false;
				}
			}
			
			if(!validadoTodosCuentasContablesLineaProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuentasContablesLineaProductoLogicAdditional.checkCuentasContablesLineaProductoToSavesAfter(cuentascontableslineaproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCuentasContablesLineaProductosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuentasContablesLineaProductoParameterReturnGeneral procesarAccionCuentasContablesLineaProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CuentasContablesLineaProducto> cuentascontableslineaproductos,CuentasContablesLineaProductoParameterReturnGeneral cuentascontableslineaproductoParameterGeneral)throws Exception {
		 try {	
			CuentasContablesLineaProductoParameterReturnGeneral cuentascontableslineaproductoReturnGeneral=new CuentasContablesLineaProductoParameterReturnGeneral();
	
			CuentasContablesLineaProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuentascontableslineaproductos,cuentascontableslineaproductoParameterGeneral,cuentascontableslineaproductoReturnGeneral);
			
			return cuentascontableslineaproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuentasContablesLineaProductoParameterReturnGeneral procesarAccionCuentasContablesLineaProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CuentasContablesLineaProducto> cuentascontableslineaproductos,CuentasContablesLineaProductoParameterReturnGeneral cuentascontableslineaproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-procesarAccionCuentasContablesLineaProductosWithConnection");connexion.begin();			
			
			CuentasContablesLineaProductoParameterReturnGeneral cuentascontableslineaproductoReturnGeneral=new CuentasContablesLineaProductoParameterReturnGeneral();
	
			CuentasContablesLineaProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuentascontableslineaproductos,cuentascontableslineaproductoParameterGeneral,cuentascontableslineaproductoReturnGeneral);
			
			this.connexion.commit();
			
			return cuentascontableslineaproductoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuentasContablesLineaProductoParameterReturnGeneral procesarEventosCuentasContablesLineaProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CuentasContablesLineaProducto> cuentascontableslineaproductos,CuentasContablesLineaProducto cuentascontableslineaproducto,CuentasContablesLineaProductoParameterReturnGeneral cuentascontableslineaproductoParameterGeneral,Boolean isEsNuevoCuentasContablesLineaProducto,ArrayList<Classe> clases)throws Exception {
		 try {	
			CuentasContablesLineaProductoParameterReturnGeneral cuentascontableslineaproductoReturnGeneral=new CuentasContablesLineaProductoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuentascontableslineaproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuentasContablesLineaProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuentascontableslineaproductos,cuentascontableslineaproducto,cuentascontableslineaproductoParameterGeneral,cuentascontableslineaproductoReturnGeneral,isEsNuevoCuentasContablesLineaProducto,clases);
			
			return cuentascontableslineaproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CuentasContablesLineaProductoParameterReturnGeneral procesarEventosCuentasContablesLineaProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CuentasContablesLineaProducto> cuentascontableslineaproductos,CuentasContablesLineaProducto cuentascontableslineaproducto,CuentasContablesLineaProductoParameterReturnGeneral cuentascontableslineaproductoParameterGeneral,Boolean isEsNuevoCuentasContablesLineaProducto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-procesarEventosCuentasContablesLineaProductosWithConnection");connexion.begin();			
			
			CuentasContablesLineaProductoParameterReturnGeneral cuentascontableslineaproductoReturnGeneral=new CuentasContablesLineaProductoParameterReturnGeneral();
	
			cuentascontableslineaproductoReturnGeneral.setCuentasContablesLineaProducto(cuentascontableslineaproducto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuentascontableslineaproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuentasContablesLineaProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuentascontableslineaproductos,cuentascontableslineaproducto,cuentascontableslineaproductoParameterGeneral,cuentascontableslineaproductoReturnGeneral,isEsNuevoCuentasContablesLineaProducto,clases);
			
			this.connexion.commit();
			
			return cuentascontableslineaproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuentasContablesLineaProductoParameterReturnGeneral procesarImportacionCuentasContablesLineaProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CuentasContablesLineaProductoParameterReturnGeneral cuentascontableslineaproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-procesarImportacionCuentasContablesLineaProductosWithConnection");connexion.begin();			
			
			CuentasContablesLineaProductoParameterReturnGeneral cuentascontableslineaproductoReturnGeneral=new CuentasContablesLineaProductoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cuentascontableslineaproductos=new ArrayList<CuentasContablesLineaProducto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cuentascontableslineaproducto=new CuentasContablesLineaProducto();
				
				
				if(conColumnasBase) {this.cuentascontableslineaproducto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cuentascontableslineaproducto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.cuentascontableslineaproductos.add(this.cuentascontableslineaproducto);
			}
			
			this.saveCuentasContablesLineaProductos();
			
			this.connexion.commit();
			
			cuentascontableslineaproductoReturnGeneral.setConRetornoEstaProcesado(true);
			cuentascontableslineaproductoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cuentascontableslineaproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCuentasContablesLineaProductosEliminados() throws Exception {				
		
		List<CuentasContablesLineaProducto> cuentascontableslineaproductosAux= new ArrayList<CuentasContablesLineaProducto>();
		
		for(CuentasContablesLineaProducto cuentascontableslineaproducto:cuentascontableslineaproductos) {
			if(!cuentascontableslineaproducto.getIsDeleted()) {
				cuentascontableslineaproductosAux.add(cuentascontableslineaproducto);
			}
		}
		
		cuentascontableslineaproductos=cuentascontableslineaproductosAux;
	}
	
	public void quitarCuentasContablesLineaProductosNulos() throws Exception {				
		
		List<CuentasContablesLineaProducto> cuentascontableslineaproductosAux= new ArrayList<CuentasContablesLineaProducto>();
		
		for(CuentasContablesLineaProducto cuentascontableslineaproducto : this.cuentascontableslineaproductos) {
			if(cuentascontableslineaproducto==null) {
				cuentascontableslineaproductosAux.add(cuentascontableslineaproducto);
			}
		}
		
		//this.cuentascontableslineaproductos=cuentascontableslineaproductosAux;
		
		this.cuentascontableslineaproductos.removeAll(cuentascontableslineaproductosAux);
	}
	
	public void getSetVersionRowCuentasContablesLineaProductoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cuentascontableslineaproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cuentascontableslineaproducto.getIsDeleted() || (cuentascontableslineaproducto.getIsChanged()&&!cuentascontableslineaproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cuentascontableslineaproductoDataAccess.getSetVersionRowCuentasContablesLineaProducto(connexion,cuentascontableslineaproducto.getId());
				
				if(!cuentascontableslineaproducto.getVersionRow().equals(timestamp)) {	
					cuentascontableslineaproducto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cuentascontableslineaproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCuentasContablesLineaProducto()throws Exception {	
		
		if(cuentascontableslineaproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cuentascontableslineaproducto.getIsDeleted() || (cuentascontableslineaproducto.getIsChanged()&&!cuentascontableslineaproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cuentascontableslineaproductoDataAccess.getSetVersionRowCuentasContablesLineaProducto(connexion,cuentascontableslineaproducto.getId());
			
			try {							
				if(!cuentascontableslineaproducto.getVersionRow().equals(timestamp)) {	
					cuentascontableslineaproducto.setVersionRow(timestamp);
				}
				
				cuentascontableslineaproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCuentasContablesLineaProductosWithConnection()throws Exception {	
		if(cuentascontableslineaproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CuentasContablesLineaProducto cuentascontableslineaproductoAux:cuentascontableslineaproductos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cuentascontableslineaproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuentascontableslineaproductoAux.getIsDeleted() || (cuentascontableslineaproductoAux.getIsChanged()&&!cuentascontableslineaproductoAux.getIsNew())) {
						
						timestamp=cuentascontableslineaproductoDataAccess.getSetVersionRowCuentasContablesLineaProducto(connexion,cuentascontableslineaproductoAux.getId());
						
						if(!cuentascontableslineaproducto.getVersionRow().equals(timestamp)) {	
							cuentascontableslineaproductoAux.setVersionRow(timestamp);
						}
								
						cuentascontableslineaproductoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCuentasContablesLineaProductos()throws Exception {	
		if(cuentascontableslineaproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CuentasContablesLineaProducto cuentascontableslineaproductoAux:cuentascontableslineaproductos) {
					if(cuentascontableslineaproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuentascontableslineaproductoAux.getIsDeleted() || (cuentascontableslineaproductoAux.getIsChanged()&&!cuentascontableslineaproductoAux.getIsNew())) {
						
						timestamp=cuentascontableslineaproductoDataAccess.getSetVersionRowCuentasContablesLineaProducto(connexion,cuentascontableslineaproductoAux.getId());
						
						if(!cuentascontableslineaproductoAux.getVersionRow().equals(timestamp)) {	
							cuentascontableslineaproductoAux.setVersionRow(timestamp);
						}
						
													
						cuentascontableslineaproductoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CuentasContablesLineaProductoParameterReturnGeneral cargarCombosLoteForeignKeyCuentasContablesLineaProductoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalBodega,String finalQueryGlobalCentroCosto,String finalQueryGlobalLinea,String finalQueryGlobalLineaGrupo,String finalQueryGlobalLineaCategoria,String finalQueryGlobalCuentaContableInventario,String finalQueryGlobalCuentaContableCostoVenta,String finalQueryGlobalCuentaContableVenta,String finalQueryGlobalCuentaContableDescuento,String finalQueryGlobalCuentaContableProduccion,String finalQueryGlobalCuentaContableDevolucion,String finalQueryGlobalCuentaContableIvaDebito,String finalQueryGlobalCuentaContableIvaCredito,String finalQueryGlobalCuentaContableBonifica,String finalQueryGlobalCuentaContableCostoBonifica) throws Exception {
		CuentasContablesLineaProductoParameterReturnGeneral  cuentascontableslineaproductoReturnGeneral =new CuentasContablesLineaProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-cargarCombosLoteForeignKeyCuentasContablesLineaProductoWithConnection");connexion.begin();
			
			cuentascontableslineaproductoReturnGeneral =new CuentasContablesLineaProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cuentascontableslineaproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			cuentascontableslineaproductoReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			cuentascontableslineaproductoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			cuentascontableslineaproductoReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Linea> lineagruposForeignKey=new ArrayList<Linea>();
			LineaLogic lineagrupoLogic=new LineaLogic();
			lineagrupoLogic.setConnexion(this.connexion);
			lineagrupoLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaGrupo.equals("NONE")) {
				lineagrupoLogic.getTodosLineas(finalQueryGlobalLineaGrupo,new Pagination());
				lineagruposForeignKey=lineagrupoLogic.getLineas();
			}

			cuentascontableslineaproductoReturnGeneral.setlineagruposForeignKey(lineagruposForeignKey);


			List<Linea> lineacategoriasForeignKey=new ArrayList<Linea>();
			LineaLogic lineacategoriaLogic=new LineaLogic();
			lineacategoriaLogic.setConnexion(this.connexion);
			lineacategoriaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaCategoria.equals("NONE")) {
				lineacategoriaLogic.getTodosLineas(finalQueryGlobalLineaCategoria,new Pagination());
				lineacategoriasForeignKey=lineacategoriaLogic.getLineas();
			}

			cuentascontableslineaproductoReturnGeneral.setlineacategoriasForeignKey(lineacategoriasForeignKey);


			List<CuentaContable> cuentacontableinventariosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableinventarioLogic=new CuentaContableLogic();
			cuentacontableinventarioLogic.setConnexion(this.connexion);
			cuentacontableinventarioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableInventario.equals("NONE")) {
				cuentacontableinventarioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableInventario,new Pagination());
				cuentacontableinventariosForeignKey=cuentacontableinventarioLogic.getCuentaContables();
			}

			cuentascontableslineaproductoReturnGeneral.setcuentacontableinventariosForeignKey(cuentacontableinventariosForeignKey);


			List<CuentaContable> cuentacontablecostoventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostoventaLogic=new CuentaContableLogic();
			cuentacontablecostoventaLogic.setConnexion(this.connexion);
			cuentacontablecostoventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCostoVenta.equals("NONE")) {
				cuentacontablecostoventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCostoVenta,new Pagination());
				cuentacontablecostoventasForeignKey=cuentacontablecostoventaLogic.getCuentaContables();
			}

			cuentascontableslineaproductoReturnGeneral.setcuentacontablecostoventasForeignKey(cuentacontablecostoventasForeignKey);


			List<CuentaContable> cuentacontableventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableventaLogic=new CuentaContableLogic();
			cuentacontableventaLogic.setConnexion(this.connexion);
			cuentacontableventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableVenta.equals("NONE")) {
				cuentacontableventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableVenta,new Pagination());
				cuentacontableventasForeignKey=cuentacontableventaLogic.getCuentaContables();
			}

			cuentascontableslineaproductoReturnGeneral.setcuentacontableventasForeignKey(cuentacontableventasForeignKey);


			List<CuentaContable> cuentacontabledescuentosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledescuentoLogic=new CuentaContableLogic();
			cuentacontabledescuentoLogic.setConnexion(this.connexion);
			cuentacontabledescuentoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDescuento.equals("NONE")) {
				cuentacontabledescuentoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDescuento,new Pagination());
				cuentacontabledescuentosForeignKey=cuentacontabledescuentoLogic.getCuentaContables();
			}

			cuentascontableslineaproductoReturnGeneral.setcuentacontabledescuentosForeignKey(cuentacontabledescuentosForeignKey);


			List<CuentaContable> cuentacontableproduccionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableproduccionLogic=new CuentaContableLogic();
			cuentacontableproduccionLogic.setConnexion(this.connexion);
			cuentacontableproduccionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableProduccion.equals("NONE")) {
				cuentacontableproduccionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableProduccion,new Pagination());
				cuentacontableproduccionsForeignKey=cuentacontableproduccionLogic.getCuentaContables();
			}

			cuentascontableslineaproductoReturnGeneral.setcuentacontableproduccionsForeignKey(cuentacontableproduccionsForeignKey);


			List<CuentaContable> cuentacontabledevolucionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledevolucionLogic=new CuentaContableLogic();
			cuentacontabledevolucionLogic.setConnexion(this.connexion);
			cuentacontabledevolucionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDevolucion.equals("NONE")) {
				cuentacontabledevolucionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDevolucion,new Pagination());
				cuentacontabledevolucionsForeignKey=cuentacontabledevolucionLogic.getCuentaContables();
			}

			cuentascontableslineaproductoReturnGeneral.setcuentacontabledevolucionsForeignKey(cuentacontabledevolucionsForeignKey);


			List<CuentaContable> cuentacontableivadebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableivadebitoLogic=new CuentaContableLogic();
			cuentacontableivadebitoLogic.setConnexion(this.connexion);
			cuentacontableivadebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIvaDebito.equals("NONE")) {
				cuentacontableivadebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableIvaDebito,new Pagination());
				cuentacontableivadebitosForeignKey=cuentacontableivadebitoLogic.getCuentaContables();
			}

			cuentascontableslineaproductoReturnGeneral.setcuentacontableivadebitosForeignKey(cuentacontableivadebitosForeignKey);


			List<CuentaContable> cuentacontableivacreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableivacreditoLogic=new CuentaContableLogic();
			cuentacontableivacreditoLogic.setConnexion(this.connexion);
			cuentacontableivacreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIvaCredito.equals("NONE")) {
				cuentacontableivacreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableIvaCredito,new Pagination());
				cuentacontableivacreditosForeignKey=cuentacontableivacreditoLogic.getCuentaContables();
			}

			cuentascontableslineaproductoReturnGeneral.setcuentacontableivacreditosForeignKey(cuentacontableivacreditosForeignKey);


			List<CuentaContable> cuentacontablebonificasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablebonificaLogic=new CuentaContableLogic();
			cuentacontablebonificaLogic.setConnexion(this.connexion);
			cuentacontablebonificaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableBonifica.equals("NONE")) {
				cuentacontablebonificaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableBonifica,new Pagination());
				cuentacontablebonificasForeignKey=cuentacontablebonificaLogic.getCuentaContables();
			}

			cuentascontableslineaproductoReturnGeneral.setcuentacontablebonificasForeignKey(cuentacontablebonificasForeignKey);


			List<CuentaContable> cuentacontablecostobonificasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostobonificaLogic=new CuentaContableLogic();
			cuentacontablecostobonificaLogic.setConnexion(this.connexion);
			cuentacontablecostobonificaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCostoBonifica.equals("NONE")) {
				cuentacontablecostobonificaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCostoBonifica,new Pagination());
				cuentacontablecostobonificasForeignKey=cuentacontablecostobonificaLogic.getCuentaContables();
			}

			cuentascontableslineaproductoReturnGeneral.setcuentacontablecostobonificasForeignKey(cuentacontablecostobonificasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cuentascontableslineaproductoReturnGeneral;
	}
	
	public CuentasContablesLineaProductoParameterReturnGeneral cargarCombosLoteForeignKeyCuentasContablesLineaProducto(String finalQueryGlobalEmpresa,String finalQueryGlobalBodega,String finalQueryGlobalCentroCosto,String finalQueryGlobalLinea,String finalQueryGlobalLineaGrupo,String finalQueryGlobalLineaCategoria,String finalQueryGlobalCuentaContableInventario,String finalQueryGlobalCuentaContableCostoVenta,String finalQueryGlobalCuentaContableVenta,String finalQueryGlobalCuentaContableDescuento,String finalQueryGlobalCuentaContableProduccion,String finalQueryGlobalCuentaContableDevolucion,String finalQueryGlobalCuentaContableIvaDebito,String finalQueryGlobalCuentaContableIvaCredito,String finalQueryGlobalCuentaContableBonifica,String finalQueryGlobalCuentaContableCostoBonifica) throws Exception {
		CuentasContablesLineaProductoParameterReturnGeneral  cuentascontableslineaproductoReturnGeneral =new CuentasContablesLineaProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cuentascontableslineaproductoReturnGeneral =new CuentasContablesLineaProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cuentascontableslineaproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			cuentascontableslineaproductoReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			cuentascontableslineaproductoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			cuentascontableslineaproductoReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Linea> lineagruposForeignKey=new ArrayList<Linea>();
			LineaLogic lineagrupoLogic=new LineaLogic();
			lineagrupoLogic.setConnexion(this.connexion);
			lineagrupoLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaGrupo.equals("NONE")) {
				lineagrupoLogic.getTodosLineas(finalQueryGlobalLineaGrupo,new Pagination());
				lineagruposForeignKey=lineagrupoLogic.getLineas();
			}

			cuentascontableslineaproductoReturnGeneral.setlineagruposForeignKey(lineagruposForeignKey);


			List<Linea> lineacategoriasForeignKey=new ArrayList<Linea>();
			LineaLogic lineacategoriaLogic=new LineaLogic();
			lineacategoriaLogic.setConnexion(this.connexion);
			lineacategoriaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaCategoria.equals("NONE")) {
				lineacategoriaLogic.getTodosLineas(finalQueryGlobalLineaCategoria,new Pagination());
				lineacategoriasForeignKey=lineacategoriaLogic.getLineas();
			}

			cuentascontableslineaproductoReturnGeneral.setlineacategoriasForeignKey(lineacategoriasForeignKey);


			List<CuentaContable> cuentacontableinventariosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableinventarioLogic=new CuentaContableLogic();
			cuentacontableinventarioLogic.setConnexion(this.connexion);
			cuentacontableinventarioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableInventario.equals("NONE")) {
				cuentacontableinventarioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableInventario,new Pagination());
				cuentacontableinventariosForeignKey=cuentacontableinventarioLogic.getCuentaContables();
			}

			cuentascontableslineaproductoReturnGeneral.setcuentacontableinventariosForeignKey(cuentacontableinventariosForeignKey);


			List<CuentaContable> cuentacontablecostoventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostoventaLogic=new CuentaContableLogic();
			cuentacontablecostoventaLogic.setConnexion(this.connexion);
			cuentacontablecostoventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCostoVenta.equals("NONE")) {
				cuentacontablecostoventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCostoVenta,new Pagination());
				cuentacontablecostoventasForeignKey=cuentacontablecostoventaLogic.getCuentaContables();
			}

			cuentascontableslineaproductoReturnGeneral.setcuentacontablecostoventasForeignKey(cuentacontablecostoventasForeignKey);


			List<CuentaContable> cuentacontableventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableventaLogic=new CuentaContableLogic();
			cuentacontableventaLogic.setConnexion(this.connexion);
			cuentacontableventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableVenta.equals("NONE")) {
				cuentacontableventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableVenta,new Pagination());
				cuentacontableventasForeignKey=cuentacontableventaLogic.getCuentaContables();
			}

			cuentascontableslineaproductoReturnGeneral.setcuentacontableventasForeignKey(cuentacontableventasForeignKey);


			List<CuentaContable> cuentacontabledescuentosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledescuentoLogic=new CuentaContableLogic();
			cuentacontabledescuentoLogic.setConnexion(this.connexion);
			cuentacontabledescuentoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDescuento.equals("NONE")) {
				cuentacontabledescuentoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDescuento,new Pagination());
				cuentacontabledescuentosForeignKey=cuentacontabledescuentoLogic.getCuentaContables();
			}

			cuentascontableslineaproductoReturnGeneral.setcuentacontabledescuentosForeignKey(cuentacontabledescuentosForeignKey);


			List<CuentaContable> cuentacontableproduccionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableproduccionLogic=new CuentaContableLogic();
			cuentacontableproduccionLogic.setConnexion(this.connexion);
			cuentacontableproduccionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableProduccion.equals("NONE")) {
				cuentacontableproduccionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableProduccion,new Pagination());
				cuentacontableproduccionsForeignKey=cuentacontableproduccionLogic.getCuentaContables();
			}

			cuentascontableslineaproductoReturnGeneral.setcuentacontableproduccionsForeignKey(cuentacontableproduccionsForeignKey);


			List<CuentaContable> cuentacontabledevolucionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledevolucionLogic=new CuentaContableLogic();
			cuentacontabledevolucionLogic.setConnexion(this.connexion);
			cuentacontabledevolucionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDevolucion.equals("NONE")) {
				cuentacontabledevolucionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDevolucion,new Pagination());
				cuentacontabledevolucionsForeignKey=cuentacontabledevolucionLogic.getCuentaContables();
			}

			cuentascontableslineaproductoReturnGeneral.setcuentacontabledevolucionsForeignKey(cuentacontabledevolucionsForeignKey);


			List<CuentaContable> cuentacontableivadebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableivadebitoLogic=new CuentaContableLogic();
			cuentacontableivadebitoLogic.setConnexion(this.connexion);
			cuentacontableivadebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIvaDebito.equals("NONE")) {
				cuentacontableivadebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableIvaDebito,new Pagination());
				cuentacontableivadebitosForeignKey=cuentacontableivadebitoLogic.getCuentaContables();
			}

			cuentascontableslineaproductoReturnGeneral.setcuentacontableivadebitosForeignKey(cuentacontableivadebitosForeignKey);


			List<CuentaContable> cuentacontableivacreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableivacreditoLogic=new CuentaContableLogic();
			cuentacontableivacreditoLogic.setConnexion(this.connexion);
			cuentacontableivacreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIvaCredito.equals("NONE")) {
				cuentacontableivacreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableIvaCredito,new Pagination());
				cuentacontableivacreditosForeignKey=cuentacontableivacreditoLogic.getCuentaContables();
			}

			cuentascontableslineaproductoReturnGeneral.setcuentacontableivacreditosForeignKey(cuentacontableivacreditosForeignKey);


			List<CuentaContable> cuentacontablebonificasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablebonificaLogic=new CuentaContableLogic();
			cuentacontablebonificaLogic.setConnexion(this.connexion);
			cuentacontablebonificaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableBonifica.equals("NONE")) {
				cuentacontablebonificaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableBonifica,new Pagination());
				cuentacontablebonificasForeignKey=cuentacontablebonificaLogic.getCuentaContables();
			}

			cuentascontableslineaproductoReturnGeneral.setcuentacontablebonificasForeignKey(cuentacontablebonificasForeignKey);


			List<CuentaContable> cuentacontablecostobonificasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostobonificaLogic=new CuentaContableLogic();
			cuentacontablecostobonificaLogic.setConnexion(this.connexion);
			cuentacontablecostobonificaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCostoBonifica.equals("NONE")) {
				cuentacontablecostobonificaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCostoBonifica,new Pagination());
				cuentacontablecostobonificasForeignKey=cuentacontablecostobonificaLogic.getCuentaContables();
			}

			cuentascontableslineaproductoReturnGeneral.setcuentacontablecostobonificasForeignKey(cuentacontablecostobonificasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cuentascontableslineaproductoReturnGeneral;
	}
	
	
	public void deepLoad(CuentasContablesLineaProducto cuentascontableslineaproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CuentasContablesLineaProductoLogicAdditional.updateCuentasContablesLineaProductoToGet(cuentascontableslineaproducto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuentascontableslineaproducto.setEmpresa(cuentascontableslineaproductoDataAccess.getEmpresa(connexion,cuentascontableslineaproducto));
		cuentascontableslineaproducto.setBodega(cuentascontableslineaproductoDataAccess.getBodega(connexion,cuentascontableslineaproducto));
		cuentascontableslineaproducto.setCentroCosto(cuentascontableslineaproductoDataAccess.getCentroCosto(connexion,cuentascontableslineaproducto));
		cuentascontableslineaproducto.setLinea(cuentascontableslineaproductoDataAccess.getLinea(connexion,cuentascontableslineaproducto));
		cuentascontableslineaproducto.setLineaGrupo(cuentascontableslineaproductoDataAccess.getLineaGrupo(connexion,cuentascontableslineaproducto));
		cuentascontableslineaproducto.setLineaCategoria(cuentascontableslineaproductoDataAccess.getLineaCategoria(connexion,cuentascontableslineaproducto));
		cuentascontableslineaproducto.setCuentaContableInventario(cuentascontableslineaproductoDataAccess.getCuentaContableInventario(connexion,cuentascontableslineaproducto));
		cuentascontableslineaproducto.setCuentaContableCostoVenta(cuentascontableslineaproductoDataAccess.getCuentaContableCostoVenta(connexion,cuentascontableslineaproducto));
		cuentascontableslineaproducto.setCuentaContableVenta(cuentascontableslineaproductoDataAccess.getCuentaContableVenta(connexion,cuentascontableslineaproducto));
		cuentascontableslineaproducto.setCuentaContableDescuento(cuentascontableslineaproductoDataAccess.getCuentaContableDescuento(connexion,cuentascontableslineaproducto));
		cuentascontableslineaproducto.setCuentaContableProduccion(cuentascontableslineaproductoDataAccess.getCuentaContableProduccion(connexion,cuentascontableslineaproducto));
		cuentascontableslineaproducto.setCuentaContableDevolucion(cuentascontableslineaproductoDataAccess.getCuentaContableDevolucion(connexion,cuentascontableslineaproducto));
		cuentascontableslineaproducto.setCuentaContableIvaDebito(cuentascontableslineaproductoDataAccess.getCuentaContableIvaDebito(connexion,cuentascontableslineaproducto));
		cuentascontableslineaproducto.setCuentaContableIvaCredito(cuentascontableslineaproductoDataAccess.getCuentaContableIvaCredito(connexion,cuentascontableslineaproducto));
		cuentascontableslineaproducto.setCuentaContableBonifica(cuentascontableslineaproductoDataAccess.getCuentaContableBonifica(connexion,cuentascontableslineaproducto));
		cuentascontableslineaproducto.setCuentaContableCostoBonifica(cuentascontableslineaproductoDataAccess.getCuentaContableCostoBonifica(connexion,cuentascontableslineaproducto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cuentascontableslineaproducto.setEmpresa(cuentascontableslineaproductoDataAccess.getEmpresa(connexion,cuentascontableslineaproducto));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				cuentascontableslineaproducto.setBodega(cuentascontableslineaproductoDataAccess.getBodega(connexion,cuentascontableslineaproducto));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				cuentascontableslineaproducto.setCentroCosto(cuentascontableslineaproductoDataAccess.getCentroCosto(connexion,cuentascontableslineaproducto));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				cuentascontableslineaproducto.setLinea(cuentascontableslineaproductoDataAccess.getLinea(connexion,cuentascontableslineaproducto));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				cuentascontableslineaproducto.setLineaGrupo(cuentascontableslineaproductoDataAccess.getLineaGrupo(connexion,cuentascontableslineaproducto));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				cuentascontableslineaproducto.setLineaCategoria(cuentascontableslineaproductoDataAccess.getLineaCategoria(connexion,cuentascontableslineaproducto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentascontableslineaproducto.setCuentaContableInventario(cuentascontableslineaproductoDataAccess.getCuentaContableInventario(connexion,cuentascontableslineaproducto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentascontableslineaproducto.setCuentaContableCostoVenta(cuentascontableslineaproductoDataAccess.getCuentaContableCostoVenta(connexion,cuentascontableslineaproducto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentascontableslineaproducto.setCuentaContableVenta(cuentascontableslineaproductoDataAccess.getCuentaContableVenta(connexion,cuentascontableslineaproducto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentascontableslineaproducto.setCuentaContableDescuento(cuentascontableslineaproductoDataAccess.getCuentaContableDescuento(connexion,cuentascontableslineaproducto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentascontableslineaproducto.setCuentaContableProduccion(cuentascontableslineaproductoDataAccess.getCuentaContableProduccion(connexion,cuentascontableslineaproducto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentascontableslineaproducto.setCuentaContableDevolucion(cuentascontableslineaproductoDataAccess.getCuentaContableDevolucion(connexion,cuentascontableslineaproducto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentascontableslineaproducto.setCuentaContableIvaDebito(cuentascontableslineaproductoDataAccess.getCuentaContableIvaDebito(connexion,cuentascontableslineaproducto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentascontableslineaproducto.setCuentaContableIvaCredito(cuentascontableslineaproductoDataAccess.getCuentaContableIvaCredito(connexion,cuentascontableslineaproducto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentascontableslineaproducto.setCuentaContableBonifica(cuentascontableslineaproductoDataAccess.getCuentaContableBonifica(connexion,cuentascontableslineaproducto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentascontableslineaproducto.setCuentaContableCostoBonifica(cuentascontableslineaproductoDataAccess.getCuentaContableCostoBonifica(connexion,cuentascontableslineaproducto));
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
			cuentascontableslineaproducto.setEmpresa(cuentascontableslineaproductoDataAccess.getEmpresa(connexion,cuentascontableslineaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setBodega(cuentascontableslineaproductoDataAccess.getBodega(connexion,cuentascontableslineaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCentroCosto(cuentascontableslineaproductoDataAccess.getCentroCosto(connexion,cuentascontableslineaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setLinea(cuentascontableslineaproductoDataAccess.getLinea(connexion,cuentascontableslineaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setLineaGrupo(cuentascontableslineaproductoDataAccess.getLineaGrupo(connexion,cuentascontableslineaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setLineaCategoria(cuentascontableslineaproductoDataAccess.getLineaCategoria(connexion,cuentascontableslineaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCuentaContableInventario(cuentascontableslineaproductoDataAccess.getCuentaContableInventario(connexion,cuentascontableslineaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCuentaContableCostoVenta(cuentascontableslineaproductoDataAccess.getCuentaContableCostoVenta(connexion,cuentascontableslineaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCuentaContableVenta(cuentascontableslineaproductoDataAccess.getCuentaContableVenta(connexion,cuentascontableslineaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCuentaContableDescuento(cuentascontableslineaproductoDataAccess.getCuentaContableDescuento(connexion,cuentascontableslineaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCuentaContableProduccion(cuentascontableslineaproductoDataAccess.getCuentaContableProduccion(connexion,cuentascontableslineaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCuentaContableDevolucion(cuentascontableslineaproductoDataAccess.getCuentaContableDevolucion(connexion,cuentascontableslineaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCuentaContableIvaDebito(cuentascontableslineaproductoDataAccess.getCuentaContableIvaDebito(connexion,cuentascontableslineaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCuentaContableIvaCredito(cuentascontableslineaproductoDataAccess.getCuentaContableIvaCredito(connexion,cuentascontableslineaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCuentaContableBonifica(cuentascontableslineaproductoDataAccess.getCuentaContableBonifica(connexion,cuentascontableslineaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCuentaContableCostoBonifica(cuentascontableslineaproductoDataAccess.getCuentaContableCostoBonifica(connexion,cuentascontableslineaproducto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuentascontableslineaproducto.setEmpresa(cuentascontableslineaproductoDataAccess.getEmpresa(connexion,cuentascontableslineaproducto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cuentascontableslineaproducto.getEmpresa(),isDeep,deepLoadType,clases);
				
		cuentascontableslineaproducto.setBodega(cuentascontableslineaproductoDataAccess.getBodega(connexion,cuentascontableslineaproducto));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(cuentascontableslineaproducto.getBodega(),isDeep,deepLoadType,clases);
				
		cuentascontableslineaproducto.setCentroCosto(cuentascontableslineaproductoDataAccess.getCentroCosto(connexion,cuentascontableslineaproducto));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(cuentascontableslineaproducto.getCentroCosto(),isDeep,deepLoadType,clases);
				
		cuentascontableslineaproducto.setLinea(cuentascontableslineaproductoDataAccess.getLinea(connexion,cuentascontableslineaproducto));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(cuentascontableslineaproducto.getLinea(),isDeep,deepLoadType,clases);
				
		cuentascontableslineaproducto.setLineaGrupo(cuentascontableslineaproductoDataAccess.getLineaGrupo(connexion,cuentascontableslineaproducto));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(cuentascontableslineaproducto.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		cuentascontableslineaproducto.setLineaCategoria(cuentascontableslineaproductoDataAccess.getLineaCategoria(connexion,cuentascontableslineaproducto));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(cuentascontableslineaproducto.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		cuentascontableslineaproducto.setCuentaContableInventario(cuentascontableslineaproductoDataAccess.getCuentaContableInventario(connexion,cuentascontableslineaproducto));
		CuentaContableLogic cuentacontableinventarioLogic= new CuentaContableLogic(connexion);
		cuentacontableinventarioLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableInventario(),isDeep,deepLoadType,clases);
				
		cuentascontableslineaproducto.setCuentaContableCostoVenta(cuentascontableslineaproductoDataAccess.getCuentaContableCostoVenta(connexion,cuentascontableslineaproducto));
		CuentaContableLogic cuentacontablecostoventaLogic= new CuentaContableLogic(connexion);
		cuentacontablecostoventaLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableCostoVenta(),isDeep,deepLoadType,clases);
				
		cuentascontableslineaproducto.setCuentaContableVenta(cuentascontableslineaproductoDataAccess.getCuentaContableVenta(connexion,cuentascontableslineaproducto));
		CuentaContableLogic cuentacontableventaLogic= new CuentaContableLogic(connexion);
		cuentacontableventaLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableVenta(),isDeep,deepLoadType,clases);
				
		cuentascontableslineaproducto.setCuentaContableDescuento(cuentascontableslineaproductoDataAccess.getCuentaContableDescuento(connexion,cuentascontableslineaproducto));
		CuentaContableLogic cuentacontabledescuentoLogic= new CuentaContableLogic(connexion);
		cuentacontabledescuentoLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableDescuento(),isDeep,deepLoadType,clases);
				
		cuentascontableslineaproducto.setCuentaContableProduccion(cuentascontableslineaproductoDataAccess.getCuentaContableProduccion(connexion,cuentascontableslineaproducto));
		CuentaContableLogic cuentacontableproduccionLogic= new CuentaContableLogic(connexion);
		cuentacontableproduccionLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableProduccion(),isDeep,deepLoadType,clases);
				
		cuentascontableslineaproducto.setCuentaContableDevolucion(cuentascontableslineaproductoDataAccess.getCuentaContableDevolucion(connexion,cuentascontableslineaproducto));
		CuentaContableLogic cuentacontabledevolucionLogic= new CuentaContableLogic(connexion);
		cuentacontabledevolucionLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);
				
		cuentascontableslineaproducto.setCuentaContableIvaDebito(cuentascontableslineaproductoDataAccess.getCuentaContableIvaDebito(connexion,cuentascontableslineaproducto));
		CuentaContableLogic cuentacontableivadebitoLogic= new CuentaContableLogic(connexion);
		cuentacontableivadebitoLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableIvaDebito(),isDeep,deepLoadType,clases);
				
		cuentascontableslineaproducto.setCuentaContableIvaCredito(cuentascontableslineaproductoDataAccess.getCuentaContableIvaCredito(connexion,cuentascontableslineaproducto));
		CuentaContableLogic cuentacontableivacreditoLogic= new CuentaContableLogic(connexion);
		cuentacontableivacreditoLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableIvaCredito(),isDeep,deepLoadType,clases);
				
		cuentascontableslineaproducto.setCuentaContableBonifica(cuentascontableslineaproductoDataAccess.getCuentaContableBonifica(connexion,cuentascontableslineaproducto));
		CuentaContableLogic cuentacontablebonificaLogic= new CuentaContableLogic(connexion);
		cuentacontablebonificaLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableBonifica(),isDeep,deepLoadType,clases);
				
		cuentascontableslineaproducto.setCuentaContableCostoBonifica(cuentascontableslineaproductoDataAccess.getCuentaContableCostoBonifica(connexion,cuentascontableslineaproducto));
		CuentaContableLogic cuentacontablecostobonificaLogic= new CuentaContableLogic(connexion);
		cuentacontablecostobonificaLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableCostoBonifica(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cuentascontableslineaproducto.setEmpresa(cuentascontableslineaproductoDataAccess.getEmpresa(connexion,cuentascontableslineaproducto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cuentascontableslineaproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				cuentascontableslineaproducto.setBodega(cuentascontableslineaproductoDataAccess.getBodega(connexion,cuentascontableslineaproducto));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(cuentascontableslineaproducto.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				cuentascontableslineaproducto.setCentroCosto(cuentascontableslineaproductoDataAccess.getCentroCosto(connexion,cuentascontableslineaproducto));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(cuentascontableslineaproducto.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				cuentascontableslineaproducto.setLinea(cuentascontableslineaproductoDataAccess.getLinea(connexion,cuentascontableslineaproducto));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(cuentascontableslineaproducto.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				cuentascontableslineaproducto.setLineaGrupo(cuentascontableslineaproductoDataAccess.getLineaGrupo(connexion,cuentascontableslineaproducto));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(cuentascontableslineaproducto.getLineaGrupo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				cuentascontableslineaproducto.setLineaCategoria(cuentascontableslineaproductoDataAccess.getLineaCategoria(connexion,cuentascontableslineaproducto));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(cuentascontableslineaproducto.getLineaCategoria(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentascontableslineaproducto.setCuentaContableInventario(cuentascontableslineaproductoDataAccess.getCuentaContableInventario(connexion,cuentascontableslineaproducto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentascontableslineaproducto.setCuentaContableCostoVenta(cuentascontableslineaproductoDataAccess.getCuentaContableCostoVenta(connexion,cuentascontableslineaproducto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableCostoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentascontableslineaproducto.setCuentaContableVenta(cuentascontableslineaproductoDataAccess.getCuentaContableVenta(connexion,cuentascontableslineaproducto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentascontableslineaproducto.setCuentaContableDescuento(cuentascontableslineaproductoDataAccess.getCuentaContableDescuento(connexion,cuentascontableslineaproducto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableDescuento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentascontableslineaproducto.setCuentaContableProduccion(cuentascontableslineaproductoDataAccess.getCuentaContableProduccion(connexion,cuentascontableslineaproducto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableProduccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentascontableslineaproducto.setCuentaContableDevolucion(cuentascontableslineaproductoDataAccess.getCuentaContableDevolucion(connexion,cuentascontableslineaproducto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentascontableslineaproducto.setCuentaContableIvaDebito(cuentascontableslineaproductoDataAccess.getCuentaContableIvaDebito(connexion,cuentascontableslineaproducto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableIvaDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentascontableslineaproducto.setCuentaContableIvaCredito(cuentascontableslineaproductoDataAccess.getCuentaContableIvaCredito(connexion,cuentascontableslineaproducto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableIvaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentascontableslineaproducto.setCuentaContableBonifica(cuentascontableslineaproductoDataAccess.getCuentaContableBonifica(connexion,cuentascontableslineaproducto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableBonifica(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentascontableslineaproducto.setCuentaContableCostoBonifica(cuentascontableslineaproductoDataAccess.getCuentaContableCostoBonifica(connexion,cuentascontableslineaproducto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableCostoBonifica(),isDeep,deepLoadType,clases);				
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
			cuentascontableslineaproducto.setEmpresa(cuentascontableslineaproductoDataAccess.getEmpresa(connexion,cuentascontableslineaproducto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cuentascontableslineaproducto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setBodega(cuentascontableslineaproductoDataAccess.getBodega(connexion,cuentascontableslineaproducto));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(cuentascontableslineaproducto.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCentroCosto(cuentascontableslineaproductoDataAccess.getCentroCosto(connexion,cuentascontableslineaproducto));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(cuentascontableslineaproducto.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setLinea(cuentascontableslineaproductoDataAccess.getLinea(connexion,cuentascontableslineaproducto));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(cuentascontableslineaproducto.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setLineaGrupo(cuentascontableslineaproductoDataAccess.getLineaGrupo(connexion,cuentascontableslineaproducto));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(cuentascontableslineaproducto.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setLineaCategoria(cuentascontableslineaproductoDataAccess.getLineaCategoria(connexion,cuentascontableslineaproducto));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(cuentascontableslineaproducto.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCuentaContableInventario(cuentascontableslineaproductoDataAccess.getCuentaContableInventario(connexion,cuentascontableslineaproducto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableInventario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCuentaContableCostoVenta(cuentascontableslineaproductoDataAccess.getCuentaContableCostoVenta(connexion,cuentascontableslineaproducto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableCostoVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCuentaContableVenta(cuentascontableslineaproductoDataAccess.getCuentaContableVenta(connexion,cuentascontableslineaproducto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCuentaContableDescuento(cuentascontableslineaproductoDataAccess.getCuentaContableDescuento(connexion,cuentascontableslineaproducto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableDescuento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCuentaContableProduccion(cuentascontableslineaproductoDataAccess.getCuentaContableProduccion(connexion,cuentascontableslineaproducto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableProduccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCuentaContableDevolucion(cuentascontableslineaproductoDataAccess.getCuentaContableDevolucion(connexion,cuentascontableslineaproducto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCuentaContableIvaDebito(cuentascontableslineaproductoDataAccess.getCuentaContableIvaDebito(connexion,cuentascontableslineaproducto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableIvaDebito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCuentaContableIvaCredito(cuentascontableslineaproductoDataAccess.getCuentaContableIvaCredito(connexion,cuentascontableslineaproducto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableIvaCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCuentaContableBonifica(cuentascontableslineaproductoDataAccess.getCuentaContableBonifica(connexion,cuentascontableslineaproducto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableBonifica(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentascontableslineaproducto.setCuentaContableCostoBonifica(cuentascontableslineaproductoDataAccess.getCuentaContableCostoBonifica(connexion,cuentascontableslineaproducto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableCostoBonifica(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CuentasContablesLineaProducto cuentascontableslineaproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CuentasContablesLineaProductoLogicAdditional.updateCuentasContablesLineaProductoToSave(cuentascontableslineaproducto,this.arrDatoGeneral);
			
CuentasContablesLineaProductoDataAccess.save(cuentascontableslineaproducto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cuentascontableslineaproducto.getEmpresa(),connexion);

		BodegaDataAccess.save(cuentascontableslineaproducto.getBodega(),connexion);

		CentroCostoDataAccess.save(cuentascontableslineaproducto.getCentroCosto(),connexion);

		LineaDataAccess.save(cuentascontableslineaproducto.getLinea(),connexion);

		LineaDataAccess.save(cuentascontableslineaproducto.getLineaGrupo(),connexion);

		LineaDataAccess.save(cuentascontableslineaproducto.getLineaCategoria(),connexion);

		CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableInventario(),connexion);

		CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableCostoVenta(),connexion);

		CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableVenta(),connexion);

		CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableDescuento(),connexion);

		CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableProduccion(),connexion);

		CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableDevolucion(),connexion);

		CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableIvaDebito(),connexion);

		CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableIvaCredito(),connexion);

		CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableBonifica(),connexion);

		CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableCostoBonifica(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cuentascontableslineaproducto.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(cuentascontableslineaproducto.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(cuentascontableslineaproducto.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(cuentascontableslineaproducto.getLinea(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(cuentascontableslineaproducto.getLineaGrupo(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(cuentascontableslineaproducto.getLineaCategoria(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableInventario(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableCostoVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableDescuento(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableProduccion(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableDevolucion(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableIvaDebito(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableIvaCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableBonifica(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableCostoBonifica(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cuentascontableslineaproducto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cuentascontableslineaproducto.getEmpresa(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(cuentascontableslineaproducto.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(cuentascontableslineaproducto.getBodega(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(cuentascontableslineaproducto.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(cuentascontableslineaproducto.getCentroCosto(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(cuentascontableslineaproducto.getLinea(),connexion);
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(cuentascontableslineaproducto.getLinea(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(cuentascontableslineaproducto.getLineaGrupo(),connexion);
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(cuentascontableslineaproducto.getLineaGrupo(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(cuentascontableslineaproducto.getLineaCategoria(),connexion);
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(cuentascontableslineaproducto.getLineaCategoria(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableInventario(),connexion);
		CuentaContableLogic cuentacontableinventarioLogic= new CuentaContableLogic(connexion);
		cuentacontableinventarioLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableInventario(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableCostoVenta(),connexion);
		CuentaContableLogic cuentacontablecostoventaLogic= new CuentaContableLogic(connexion);
		cuentacontablecostoventaLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableCostoVenta(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableVenta(),connexion);
		CuentaContableLogic cuentacontableventaLogic= new CuentaContableLogic(connexion);
		cuentacontableventaLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableVenta(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableDescuento(),connexion);
		CuentaContableLogic cuentacontabledescuentoLogic= new CuentaContableLogic(connexion);
		cuentacontabledescuentoLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableDescuento(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableProduccion(),connexion);
		CuentaContableLogic cuentacontableproduccionLogic= new CuentaContableLogic(connexion);
		cuentacontableproduccionLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableProduccion(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableDevolucion(),connexion);
		CuentaContableLogic cuentacontabledevolucionLogic= new CuentaContableLogic(connexion);
		cuentacontabledevolucionLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableIvaDebito(),connexion);
		CuentaContableLogic cuentacontableivadebitoLogic= new CuentaContableLogic(connexion);
		cuentacontableivadebitoLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableIvaDebito(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableIvaCredito(),connexion);
		CuentaContableLogic cuentacontableivacreditoLogic= new CuentaContableLogic(connexion);
		cuentacontableivacreditoLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableIvaCredito(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableBonifica(),connexion);
		CuentaContableLogic cuentacontablebonificaLogic= new CuentaContableLogic(connexion);
		cuentacontablebonificaLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableBonifica(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableCostoBonifica(),connexion);
		CuentaContableLogic cuentacontablecostobonificaLogic= new CuentaContableLogic(connexion);
		cuentacontablecostobonificaLogic.deepLoad(cuentascontableslineaproducto.getCuentaContableCostoBonifica(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cuentascontableslineaproducto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(cuentascontableslineaproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(cuentascontableslineaproducto.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(cuentascontableslineaproducto.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(cuentascontableslineaproducto.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(cuentascontableslineaproducto.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(cuentascontableslineaproducto.getLinea(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(cuentascontableslineaproducto.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(cuentascontableslineaproducto.getLineaGrupo(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(cuentascontableslineaproducto.getLineaGrupo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(cuentascontableslineaproducto.getLineaCategoria(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(cuentascontableslineaproducto.getLineaCategoria(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableInventario(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentascontableslineaproducto.getCuentaContableInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableCostoVenta(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentascontableslineaproducto.getCuentaContableCostoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableVenta(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentascontableslineaproducto.getCuentaContableVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableDescuento(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentascontableslineaproducto.getCuentaContableDescuento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableProduccion(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentascontableslineaproducto.getCuentaContableProduccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableDevolucion(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentascontableslineaproducto.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableIvaDebito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentascontableslineaproducto.getCuentaContableIvaDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableIvaCredito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentascontableslineaproducto.getCuentaContableIvaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableBonifica(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentascontableslineaproducto.getCuentaContableBonifica(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentascontableslineaproducto.getCuentaContableCostoBonifica(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentascontableslineaproducto.getCuentaContableCostoBonifica(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(CuentasContablesLineaProducto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cuentascontableslineaproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(cuentascontableslineaproducto);
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
			this.deepLoad(this.cuentascontableslineaproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CuentasContablesLineaProducto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cuentascontableslineaproductos!=null) {
				for(CuentasContablesLineaProducto cuentascontableslineaproducto:cuentascontableslineaproductos) {
					this.deepLoad(cuentascontableslineaproducto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(cuentascontableslineaproductos);
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
			if(cuentascontableslineaproductos!=null) {
				for(CuentasContablesLineaProducto cuentascontableslineaproducto:cuentascontableslineaproductos) {
					this.deepLoad(cuentascontableslineaproducto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(cuentascontableslineaproductos);
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
			this.getNewConnexionToDeep(CuentasContablesLineaProducto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cuentascontableslineaproducto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CuentasContablesLineaProducto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cuentascontableslineaproductos!=null) {
				for(CuentasContablesLineaProducto cuentascontableslineaproducto:cuentascontableslineaproductos) {
					this.deepSave(cuentascontableslineaproducto,isDeep,deepLoadType,clases);
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
			if(cuentascontableslineaproductos!=null) {
				for(CuentasContablesLineaProducto cuentascontableslineaproducto:cuentascontableslineaproductos) {
					this.deepSave(cuentascontableslineaproducto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCuentasContablesLineaProductosFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,CuentasContablesLineaProductoConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentasContablesLineaProductosFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,CuentasContablesLineaProductoConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,CuentasContablesLineaProductoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,CuentasContablesLineaProductoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCuentaContableBonificaWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_bonifica)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableBonifica= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableBonifica.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_bonifica,CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEBONIFICA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableBonifica);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableBonifica","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCuentaContableBonifica(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_bonifica)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableBonifica= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableBonifica.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_bonifica,CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEBONIFICA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableBonifica);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableBonifica","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCuentaContableCostoBonificaWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo_bonifica)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCostoBonifica= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCostoBonifica.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo_bonifica,CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCostoBonifica);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCostoBonifica","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCuentaContableCostoBonifica(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo_bonifica)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCostoBonifica= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCostoBonifica.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo_bonifica,CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCostoBonifica);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCostoBonifica","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCuentaContableCostoVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCostoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCostoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo_venta,CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCostoVenta);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCostoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCuentaContableCostoVenta(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCostoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCostoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo_venta,CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCostoVenta);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCostoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCuentaContableDescuentoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_descuento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDescuento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDescuento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_descuento,CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDescuento);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDescuento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCuentaContableDescuento(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_descuento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDescuento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDescuento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_descuento,CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDescuento);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDescuento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCuentaContableDevolucionWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_devolucion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDevolucion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDevolucion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_devolucion,CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDevolucion);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDevolucion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCuentaContableDevolucion(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_devolucion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDevolucion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDevolucion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_devolucion,CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDevolucion);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDevolucion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCuentaContableInventarioWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_inventario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_inventario,CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableInventario);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCuentaContableInventario(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_inventario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_inventario,CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableInventario);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCuentaContableIvaCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_iva_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIvaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIvaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_iva_credito,CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIvaCredito);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIvaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCuentaContableIvaCredito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_iva_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIvaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIvaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_iva_credito,CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIvaCredito);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIvaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCuentaContableIvaDebitoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_iva_debito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIvaDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIvaDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_iva_debito,CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVADEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIvaDebito);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIvaDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCuentaContableIvaDebito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_iva_debito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIvaDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIvaDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_iva_debito,CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVADEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIvaDebito);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIvaDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCuentaContableProduccionWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_produccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableProduccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableProduccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_produccion,CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableProduccion);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableProduccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCuentaContableProduccion(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_produccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableProduccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableProduccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_produccion,CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableProduccion);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableProduccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCuentaContableVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_venta,CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableVenta);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentasContablesLineaProductosFK_IdCuentaContableVenta(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_venta,CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableVenta);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentasContablesLineaProductosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CuentasContablesLineaProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentasContablesLineaProductosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CuentasContablesLineaProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentasContablesLineaProductosFK_IdLineaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,CuentasContablesLineaProductoConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentasContablesLineaProductosFK_IdLinea(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,CuentasContablesLineaProductoConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentasContablesLineaProductosFK_IdLineaCategoriaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_categoria)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaCategoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaCategoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_categoria,CuentasContablesLineaProductoConstantesFunciones.IDLINEACATEGORIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaCategoria);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaCategoria","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentasContablesLineaProductosFK_IdLineaCategoria(String sFinalQuery,Pagination pagination,Long id_linea_categoria)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaCategoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaCategoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_categoria,CuentasContablesLineaProductoConstantesFunciones.IDLINEACATEGORIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaCategoria);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaCategoria","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentasContablesLineaProductosFK_IdLineaGrupoWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_grupo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentasContablesLineaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,CuentasContablesLineaProductoConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentasContablesLineaProductosFK_IdLineaGrupo(String sFinalQuery,Pagination pagination,Long id_linea_grupo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,CuentasContablesLineaProductoConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			CuentasContablesLineaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentasContablesLineaProductoConstantesFunciones.refrescarForeignKeysDescripcionesCuentasContablesLineaProducto(this.cuentascontableslineaproductos);
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
			if(CuentasContablesLineaProductoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentasContablesLineaProductoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CuentasContablesLineaProducto cuentascontableslineaproducto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CuentasContablesLineaProductoConstantesFunciones.ISCONAUDITORIA) {
				if(cuentascontableslineaproducto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentasContablesLineaProductoDataAccess.TABLENAME, cuentascontableslineaproducto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuentasContablesLineaProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuentasContablesLineaProductoLogic.registrarAuditoriaDetallesCuentasContablesLineaProducto(connexion,cuentascontableslineaproducto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cuentascontableslineaproducto.getIsDeleted()) {
					/*if(!cuentascontableslineaproducto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CuentasContablesLineaProductoDataAccess.TABLENAME, cuentascontableslineaproducto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CuentasContablesLineaProductoLogic.registrarAuditoriaDetallesCuentasContablesLineaProducto(connexion,cuentascontableslineaproducto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentasContablesLineaProductoDataAccess.TABLENAME, cuentascontableslineaproducto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cuentascontableslineaproducto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentasContablesLineaProductoDataAccess.TABLENAME, cuentascontableslineaproducto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuentasContablesLineaProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuentasContablesLineaProductoLogic.registrarAuditoriaDetallesCuentasContablesLineaProducto(connexion,cuentascontableslineaproducto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCuentasContablesLineaProducto(Connexion connexion,CuentasContablesLineaProducto cuentascontableslineaproducto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cuentascontableslineaproducto.getIsNew()||!cuentascontableslineaproducto.getid_empresa().equals(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_empresa()!=null)
				{
					strValorActual=cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_empresa().toString();
				}
				if(cuentascontableslineaproducto.getid_empresa()!=null)
				{
					strValorNuevo=cuentascontableslineaproducto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentasContablesLineaProductoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cuentascontableslineaproducto.getIsNew()||!cuentascontableslineaproducto.getid_bodega().equals(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_bodega()!=null)
				{
					strValorActual=cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_bodega().toString();
				}
				if(cuentascontableslineaproducto.getid_bodega()!=null)
				{
					strValorNuevo=cuentascontableslineaproducto.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentasContablesLineaProductoConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(cuentascontableslineaproducto.getIsNew()||!cuentascontableslineaproducto.getid_centro_costo().equals(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_centro_costo()!=null)
				{
					strValorActual=cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_centro_costo().toString();
				}
				if(cuentascontableslineaproducto.getid_centro_costo()!=null)
				{
					strValorNuevo=cuentascontableslineaproducto.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentasContablesLineaProductoConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(cuentascontableslineaproducto.getIsNew()||!cuentascontableslineaproducto.getid_linea().equals(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_linea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_linea()!=null)
				{
					strValorActual=cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_linea().toString();
				}
				if(cuentascontableslineaproducto.getid_linea()!=null)
				{
					strValorNuevo=cuentascontableslineaproducto.getid_linea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentasContablesLineaProductoConstantesFunciones.IDLINEA,strValorActual,strValorNuevo);
			}	
			
			if(cuentascontableslineaproducto.getIsNew()||!cuentascontableslineaproducto.getid_linea_grupo().equals(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_linea_grupo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_linea_grupo()!=null)
				{
					strValorActual=cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_linea_grupo().toString();
				}
				if(cuentascontableslineaproducto.getid_linea_grupo()!=null)
				{
					strValorNuevo=cuentascontableslineaproducto.getid_linea_grupo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentasContablesLineaProductoConstantesFunciones.IDLINEAGRUPO,strValorActual,strValorNuevo);
			}	
			
			if(cuentascontableslineaproducto.getIsNew()||!cuentascontableslineaproducto.getid_linea_categoria().equals(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_linea_categoria()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_linea_categoria()!=null)
				{
					strValorActual=cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_linea_categoria().toString();
				}
				if(cuentascontableslineaproducto.getid_linea_categoria()!=null)
				{
					strValorNuevo=cuentascontableslineaproducto.getid_linea_categoria().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentasContablesLineaProductoConstantesFunciones.IDLINEACATEGORIA,strValorActual,strValorNuevo);
			}	
			
			if(cuentascontableslineaproducto.getIsNew()||!cuentascontableslineaproducto.getid_cuenta_contable_inventario().equals(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_inventario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_inventario()!=null)
				{
					strValorActual=cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_inventario().toString();
				}
				if(cuentascontableslineaproducto.getid_cuenta_contable_inventario()!=null)
				{
					strValorNuevo=cuentascontableslineaproducto.getid_cuenta_contable_inventario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO,strValorActual,strValorNuevo);
			}	
			
			if(cuentascontableslineaproducto.getIsNew()||!cuentascontableslineaproducto.getid_cuenta_contable_costo_venta().equals(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_costo_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_costo_venta()!=null)
				{
					strValorActual=cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_costo_venta().toString();
				}
				if(cuentascontableslineaproducto.getid_cuenta_contable_costo_venta()!=null)
				{
					strValorNuevo=cuentascontableslineaproducto.getid_cuenta_contable_costo_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA,strValorActual,strValorNuevo);
			}	
			
			if(cuentascontableslineaproducto.getIsNew()||!cuentascontableslineaproducto.getid_cuenta_contable_venta().equals(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_venta()!=null)
				{
					strValorActual=cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_venta().toString();
				}
				if(cuentascontableslineaproducto.getid_cuenta_contable_venta()!=null)
				{
					strValorNuevo=cuentascontableslineaproducto.getid_cuenta_contable_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEVENTA,strValorActual,strValorNuevo);
			}	
			
			if(cuentascontableslineaproducto.getIsNew()||!cuentascontableslineaproducto.getid_cuenta_contable_descuento().equals(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_descuento()!=null)
				{
					strValorActual=cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_descuento().toString();
				}
				if(cuentascontableslineaproducto.getid_cuenta_contable_descuento()!=null)
				{
					strValorNuevo=cuentascontableslineaproducto.getid_cuenta_contable_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(cuentascontableslineaproducto.getIsNew()||!cuentascontableslineaproducto.getid_cuenta_contable_produccion().equals(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_produccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_produccion()!=null)
				{
					strValorActual=cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_produccion().toString();
				}
				if(cuentascontableslineaproducto.getid_cuenta_contable_produccion()!=null)
				{
					strValorNuevo=cuentascontableslineaproducto.getid_cuenta_contable_produccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION,strValorActual,strValorNuevo);
			}	
			
			if(cuentascontableslineaproducto.getIsNew()||!cuentascontableslineaproducto.getid_cuenta_contable_devolucion().equals(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_devolucion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_devolucion()!=null)
				{
					strValorActual=cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_devolucion().toString();
				}
				if(cuentascontableslineaproducto.getid_cuenta_contable_devolucion()!=null)
				{
					strValorNuevo=cuentascontableslineaproducto.getid_cuenta_contable_devolucion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,strValorActual,strValorNuevo);
			}	
			
			if(cuentascontableslineaproducto.getIsNew()||!cuentascontableslineaproducto.getid_cuenta_contable_iva_debito().equals(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_iva_debito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_iva_debito()!=null)
				{
					strValorActual=cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_iva_debito().toString();
				}
				if(cuentascontableslineaproducto.getid_cuenta_contable_iva_debito()!=null)
				{
					strValorNuevo=cuentascontableslineaproducto.getid_cuenta_contable_iva_debito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVADEBITO,strValorActual,strValorNuevo);
			}	
			
			if(cuentascontableslineaproducto.getIsNew()||!cuentascontableslineaproducto.getid_cuenta_contable_iva_credito().equals(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_iva_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_iva_credito()!=null)
				{
					strValorActual=cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_iva_credito().toString();
				}
				if(cuentascontableslineaproducto.getid_cuenta_contable_iva_credito()!=null)
				{
					strValorNuevo=cuentascontableslineaproducto.getid_cuenta_contable_iva_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(cuentascontableslineaproducto.getIsNew()||!cuentascontableslineaproducto.getid_cuenta_contable_bonifica().equals(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_bonifica()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_bonifica()!=null)
				{
					strValorActual=cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_bonifica().toString();
				}
				if(cuentascontableslineaproducto.getid_cuenta_contable_bonifica()!=null)
				{
					strValorNuevo=cuentascontableslineaproducto.getid_cuenta_contable_bonifica().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEBONIFICA,strValorActual,strValorNuevo);
			}	
			
			if(cuentascontableslineaproducto.getIsNew()||!cuentascontableslineaproducto.getid_cuenta_contable_costo_bonifica().equals(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_costo_bonifica()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_costo_bonifica()!=null)
				{
					strValorActual=cuentascontableslineaproducto.getCuentasContablesLineaProductoOriginal().getid_cuenta_contable_costo_bonifica().toString();
				}
				if(cuentascontableslineaproducto.getid_cuenta_contable_costo_bonifica()!=null)
				{
					strValorNuevo=cuentascontableslineaproducto.getid_cuenta_contable_costo_bonifica().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCuentasContablesLineaProductoRelacionesWithConnection(CuentasContablesLineaProducto cuentascontableslineaproducto) throws Exception {

		if(!cuentascontableslineaproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuentasContablesLineaProductoRelacionesBase(cuentascontableslineaproducto,true);
		}
	}

	public void saveCuentasContablesLineaProductoRelaciones(CuentasContablesLineaProducto cuentascontableslineaproducto)throws Exception {

		if(!cuentascontableslineaproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuentasContablesLineaProductoRelacionesBase(cuentascontableslineaproducto,false);
		}
	}

	public void saveCuentasContablesLineaProductoRelacionesBase(CuentasContablesLineaProducto cuentascontableslineaproducto,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CuentasContablesLineaProducto-saveRelacionesWithConnection");}
	

			this.setCuentasContablesLineaProducto(cuentascontableslineaproducto);

			if(CuentasContablesLineaProductoLogicAdditional.validarSaveRelaciones(cuentascontableslineaproducto,this)) {

				CuentasContablesLineaProductoLogicAdditional.updateRelacionesToSave(cuentascontableslineaproducto,this);

				if((cuentascontableslineaproducto.getIsNew()||cuentascontableslineaproducto.getIsChanged())&&!cuentascontableslineaproducto.getIsDeleted()) {
					this.saveCuentasContablesLineaProducto();
					this.saveCuentasContablesLineaProductoRelacionesDetalles();

				} else if(cuentascontableslineaproducto.getIsDeleted()) {
					this.saveCuentasContablesLineaProductoRelacionesDetalles();
					this.saveCuentasContablesLineaProducto();
				}

				CuentasContablesLineaProductoLogicAdditional.updateRelacionesToSaveAfter(cuentascontableslineaproducto,this);

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
	
	
	private void saveCuentasContablesLineaProductoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCuentasContablesLineaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuentasContablesLineaProductoConstantesFunciones.getClassesForeignKeysOfCuentasContablesLineaProducto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentasContablesLineaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuentasContablesLineaProductoConstantesFunciones.getClassesRelationshipsOfCuentasContablesLineaProducto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

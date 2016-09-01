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
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.util.CentroCostoGrupoProductoConstantesFunciones;
import com.bydan.erp.facturacion.util.CentroCostoGrupoProductoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.CentroCostoGrupoProductoParameterGeneral;
import com.bydan.erp.facturacion.business.entity.CentroCostoGrupoProducto;
import com.bydan.erp.facturacion.business.logic.CentroCostoGrupoProductoLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class CentroCostoGrupoProductoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CentroCostoGrupoProductoLogic.class);
	
	protected CentroCostoGrupoProductoDataAccess centrocostogrupoproductoDataAccess; 	
	protected CentroCostoGrupoProducto centrocostogrupoproducto;
	protected List<CentroCostoGrupoProducto> centrocostogrupoproductos;
	protected Object centrocostogrupoproductoObject;	
	protected List<Object> centrocostogrupoproductosObject;
	
	public static ClassValidator<CentroCostoGrupoProducto> centrocostogrupoproductoValidator = new ClassValidator<CentroCostoGrupoProducto>(CentroCostoGrupoProducto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CentroCostoGrupoProductoLogicAdditional centrocostogrupoproductoLogicAdditional=null;
	
	public CentroCostoGrupoProductoLogicAdditional getCentroCostoGrupoProductoLogicAdditional() {
		return this.centrocostogrupoproductoLogicAdditional;
	}
	
	public void setCentroCostoGrupoProductoLogicAdditional(CentroCostoGrupoProductoLogicAdditional centrocostogrupoproductoLogicAdditional) {
		try {
			this.centrocostogrupoproductoLogicAdditional=centrocostogrupoproductoLogicAdditional;
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
	
	
	
	
	public  CentroCostoGrupoProductoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.centrocostogrupoproductoDataAccess = new CentroCostoGrupoProductoDataAccess();
			
			this.centrocostogrupoproductos= new ArrayList<CentroCostoGrupoProducto>();
			this.centrocostogrupoproducto= new CentroCostoGrupoProducto();
			
			this.centrocostogrupoproductoObject=new Object();
			this.centrocostogrupoproductosObject=new ArrayList<Object>();
				
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
			
			this.centrocostogrupoproductoDataAccess.setConnexionType(this.connexionType);
			this.centrocostogrupoproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CentroCostoGrupoProductoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.centrocostogrupoproductoDataAccess = new CentroCostoGrupoProductoDataAccess();
			this.centrocostogrupoproductos= new ArrayList<CentroCostoGrupoProducto>();
			this.centrocostogrupoproducto= new CentroCostoGrupoProducto();
			this.centrocostogrupoproductoObject=new Object();
			this.centrocostogrupoproductosObject=new ArrayList<Object>();
			
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
			
			this.centrocostogrupoproductoDataAccess.setConnexionType(this.connexionType);
			this.centrocostogrupoproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CentroCostoGrupoProducto getCentroCostoGrupoProducto() throws Exception {	
		CentroCostoGrupoProductoLogicAdditional.checkCentroCostoGrupoProductoToGet(centrocostogrupoproducto,this.datosCliente,this.arrDatoGeneral);
		CentroCostoGrupoProductoLogicAdditional.updateCentroCostoGrupoProductoToGet(centrocostogrupoproducto,this.arrDatoGeneral);
		
		return centrocostogrupoproducto;
	}
		
	public void setCentroCostoGrupoProducto(CentroCostoGrupoProducto newCentroCostoGrupoProducto) {
		this.centrocostogrupoproducto = newCentroCostoGrupoProducto;
	}
	
	public CentroCostoGrupoProductoDataAccess getCentroCostoGrupoProductoDataAccess() {
		return centrocostogrupoproductoDataAccess;
	}
	
	public void setCentroCostoGrupoProductoDataAccess(CentroCostoGrupoProductoDataAccess newcentrocostogrupoproductoDataAccess) {
		this.centrocostogrupoproductoDataAccess = newcentrocostogrupoproductoDataAccess;
	}
	
	public List<CentroCostoGrupoProducto> getCentroCostoGrupoProductos() throws Exception {		
		this.quitarCentroCostoGrupoProductosNulos();
		
		CentroCostoGrupoProductoLogicAdditional.checkCentroCostoGrupoProductoToGets(centrocostogrupoproductos,this.datosCliente,this.arrDatoGeneral);
		
		for (CentroCostoGrupoProducto centrocostogrupoproductoLocal: centrocostogrupoproductos ) {
			CentroCostoGrupoProductoLogicAdditional.updateCentroCostoGrupoProductoToGet(centrocostogrupoproductoLocal,this.arrDatoGeneral);
		}
		
		return centrocostogrupoproductos;
	}
	
	public void setCentroCostoGrupoProductos(List<CentroCostoGrupoProducto> newCentroCostoGrupoProductos) {
		this.centrocostogrupoproductos = newCentroCostoGrupoProductos;
	}
	
	public Object getCentroCostoGrupoProductoObject() {	
		this.centrocostogrupoproductoObject=this.centrocostogrupoproductoDataAccess.getEntityObject();
		return this.centrocostogrupoproductoObject;
	}
		
	public void setCentroCostoGrupoProductoObject(Object newCentroCostoGrupoProductoObject) {
		this.centrocostogrupoproductoObject = newCentroCostoGrupoProductoObject;
	}
	
	public List<Object> getCentroCostoGrupoProductosObject() {		
		this.centrocostogrupoproductosObject=this.centrocostogrupoproductoDataAccess.getEntitiesObject();
		return this.centrocostogrupoproductosObject;
	}
		
	public void setCentroCostoGrupoProductosObject(List<Object> newCentroCostoGrupoProductosObject) {
		this.centrocostogrupoproductosObject = newCentroCostoGrupoProductosObject;
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
		
		if(this.centrocostogrupoproductoDataAccess!=null) {
			this.centrocostogrupoproductoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			centrocostogrupoproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			centrocostogrupoproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		centrocostogrupoproducto = new  CentroCostoGrupoProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			centrocostogrupoproducto=centrocostogrupoproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.centrocostogrupoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproducto);
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
		centrocostogrupoproducto = new  CentroCostoGrupoProducto();
		  		  
        try {
			
			centrocostogrupoproducto=centrocostogrupoproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.centrocostogrupoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		centrocostogrupoproducto = new  CentroCostoGrupoProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			centrocostogrupoproducto=centrocostogrupoproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.centrocostogrupoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproducto);
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
		centrocostogrupoproducto = new  CentroCostoGrupoProducto();
		  		  
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
		centrocostogrupoproducto = new  CentroCostoGrupoProducto();
		  		  
        try {
			
			centrocostogrupoproducto=centrocostogrupoproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.centrocostogrupoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		centrocostogrupoproducto = new  CentroCostoGrupoProducto();
		  		  
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
		centrocostogrupoproducto = new  CentroCostoGrupoProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =centrocostogrupoproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		centrocostogrupoproducto = new  CentroCostoGrupoProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=centrocostogrupoproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		centrocostogrupoproducto = new  CentroCostoGrupoProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =centrocostogrupoproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		centrocostogrupoproducto = new  CentroCostoGrupoProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=centrocostogrupoproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		centrocostogrupoproducto = new  CentroCostoGrupoProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =centrocostogrupoproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		centrocostogrupoproducto = new  CentroCostoGrupoProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=centrocostogrupoproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		centrocostogrupoproductos = new  ArrayList<CentroCostoGrupoProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCentroCostoGrupoProducto(centrocostogrupoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
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
		centrocostogrupoproductos = new  ArrayList<CentroCostoGrupoProducto>();
		  		  
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
		centrocostogrupoproductos = new  ArrayList<CentroCostoGrupoProducto>();
		  		  
        try {			
			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCentroCostoGrupoProducto(centrocostogrupoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		centrocostogrupoproductos = new  ArrayList<CentroCostoGrupoProducto>();
		  		  
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
		centrocostogrupoproductos = new  ArrayList<CentroCostoGrupoProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCentroCostoGrupoProducto(centrocostogrupoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
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
		centrocostogrupoproductos = new  ArrayList<CentroCostoGrupoProducto>();
		  		  
        try {
			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCentroCostoGrupoProducto(centrocostogrupoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
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
		centrocostogrupoproductos = new  ArrayList<CentroCostoGrupoProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCentroCostoGrupoProducto(centrocostogrupoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
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
		centrocostogrupoproductos = new  ArrayList<CentroCostoGrupoProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCentroCostoGrupoProducto(centrocostogrupoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		centrocostogrupoproducto = new  CentroCostoGrupoProducto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostogrupoproducto=centrocostogrupoproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCentroCostoGrupoProducto(centrocostogrupoproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproducto);
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
		centrocostogrupoproducto = new  CentroCostoGrupoProducto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostogrupoproducto=centrocostogrupoproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCentroCostoGrupoProducto(centrocostogrupoproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		centrocostogrupoproductos = new  ArrayList<CentroCostoGrupoProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCentroCostoGrupoProducto(centrocostogrupoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
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
		centrocostogrupoproductos = new  ArrayList<CentroCostoGrupoProducto>();
		  		  
        try {
			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCentroCostoGrupoProducto(centrocostogrupoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCentroCostoGrupoProductosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		centrocostogrupoproductos = new  ArrayList<CentroCostoGrupoProducto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-getTodosCentroCostoGrupoProductosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCentroCostoGrupoProducto(centrocostogrupoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
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
	
	public  void  getTodosCentroCostoGrupoProductos(String sFinalQuery,Pagination pagination)throws Exception {
		centrocostogrupoproductos = new  ArrayList<CentroCostoGrupoProducto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCentroCostoGrupoProducto(centrocostogrupoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCentroCostoGrupoProducto(CentroCostoGrupoProducto centrocostogrupoproducto) throws Exception {
		Boolean estaValidado=false;
		
		if(centrocostogrupoproducto.getIsNew() || centrocostogrupoproducto.getIsChanged()) { 
			this.invalidValues = centrocostogrupoproductoValidator.getInvalidValues(centrocostogrupoproducto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(centrocostogrupoproducto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCentroCostoGrupoProducto(List<CentroCostoGrupoProducto> CentroCostoGrupoProductos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CentroCostoGrupoProducto centrocostogrupoproductoLocal:centrocostogrupoproductos) {				
			estaValidadoObjeto=this.validarGuardarCentroCostoGrupoProducto(centrocostogrupoproductoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCentroCostoGrupoProducto(List<CentroCostoGrupoProducto> CentroCostoGrupoProductos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCentroCostoGrupoProducto(centrocostogrupoproductos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCentroCostoGrupoProducto(CentroCostoGrupoProducto CentroCostoGrupoProducto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCentroCostoGrupoProducto(centrocostogrupoproducto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CentroCostoGrupoProducto centrocostogrupoproducto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+centrocostogrupoproducto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CentroCostoGrupoProductoConstantesFunciones.getCentroCostoGrupoProductoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"centrocostogrupoproducto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CentroCostoGrupoProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CentroCostoGrupoProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCentroCostoGrupoProductoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-saveCentroCostoGrupoProductoWithConnection");connexion.begin();			
			
			CentroCostoGrupoProductoLogicAdditional.checkCentroCostoGrupoProductoToSave(this.centrocostogrupoproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CentroCostoGrupoProductoLogicAdditional.updateCentroCostoGrupoProductoToSave(this.centrocostogrupoproducto,this.arrDatoGeneral);
			
			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.centrocostogrupoproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCentroCostoGrupoProducto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCentroCostoGrupoProducto(this.centrocostogrupoproducto)) {
				CentroCostoGrupoProductoDataAccess.save(this.centrocostogrupoproducto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.centrocostogrupoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CentroCostoGrupoProductoLogicAdditional.checkCentroCostoGrupoProductoToSaveAfter(this.centrocostogrupoproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCentroCostoGrupoProducto();
			
			connexion.commit();			
			
			if(this.centrocostogrupoproducto.getIsDeleted()) {
				this.centrocostogrupoproducto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCentroCostoGrupoProducto()throws Exception {	
		try {	
			
			CentroCostoGrupoProductoLogicAdditional.checkCentroCostoGrupoProductoToSave(this.centrocostogrupoproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CentroCostoGrupoProductoLogicAdditional.updateCentroCostoGrupoProductoToSave(this.centrocostogrupoproducto,this.arrDatoGeneral);
			
			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.centrocostogrupoproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCentroCostoGrupoProducto(this.centrocostogrupoproducto)) {			
				CentroCostoGrupoProductoDataAccess.save(this.centrocostogrupoproducto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.centrocostogrupoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CentroCostoGrupoProductoLogicAdditional.checkCentroCostoGrupoProductoToSaveAfter(this.centrocostogrupoproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.centrocostogrupoproducto.getIsDeleted()) {
				this.centrocostogrupoproducto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCentroCostoGrupoProductosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-saveCentroCostoGrupoProductosWithConnection");connexion.begin();			
			
			CentroCostoGrupoProductoLogicAdditional.checkCentroCostoGrupoProductoToSaves(centrocostogrupoproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCentroCostoGrupoProductos();
			
			Boolean validadoTodosCentroCostoGrupoProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CentroCostoGrupoProducto centrocostogrupoproductoLocal:centrocostogrupoproductos) {		
				if(centrocostogrupoproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CentroCostoGrupoProductoLogicAdditional.updateCentroCostoGrupoProductoToSave(centrocostogrupoproductoLocal,this.arrDatoGeneral);
	        	
				CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),centrocostogrupoproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCentroCostoGrupoProducto(centrocostogrupoproductoLocal)) {
					CentroCostoGrupoProductoDataAccess.save(centrocostogrupoproductoLocal, connexion);				
				} else {
					validadoTodosCentroCostoGrupoProducto=false;
				}
			}
			
			if(!validadoTodosCentroCostoGrupoProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CentroCostoGrupoProductoLogicAdditional.checkCentroCostoGrupoProductoToSavesAfter(centrocostogrupoproductos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCentroCostoGrupoProductos();
			
			connexion.commit();		
			
			this.quitarCentroCostoGrupoProductosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCentroCostoGrupoProductos()throws Exception {				
		 try {	
			CentroCostoGrupoProductoLogicAdditional.checkCentroCostoGrupoProductoToSaves(centrocostogrupoproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCentroCostoGrupoProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CentroCostoGrupoProducto centrocostogrupoproductoLocal:centrocostogrupoproductos) {				
				if(centrocostogrupoproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CentroCostoGrupoProductoLogicAdditional.updateCentroCostoGrupoProductoToSave(centrocostogrupoproductoLocal,this.arrDatoGeneral);
	        	
				CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),centrocostogrupoproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCentroCostoGrupoProducto(centrocostogrupoproductoLocal)) {				
					CentroCostoGrupoProductoDataAccess.save(centrocostogrupoproductoLocal, connexion);				
				} else {
					validadoTodosCentroCostoGrupoProducto=false;
				}
			}
			
			if(!validadoTodosCentroCostoGrupoProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CentroCostoGrupoProductoLogicAdditional.checkCentroCostoGrupoProductoToSavesAfter(centrocostogrupoproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCentroCostoGrupoProductosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CentroCostoGrupoProductoParameterReturnGeneral procesarAccionCentroCostoGrupoProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CentroCostoGrupoProducto> centrocostogrupoproductos,CentroCostoGrupoProductoParameterReturnGeneral centrocostogrupoproductoParameterGeneral)throws Exception {
		 try {	
			CentroCostoGrupoProductoParameterReturnGeneral centrocostogrupoproductoReturnGeneral=new CentroCostoGrupoProductoParameterReturnGeneral();
	
			CentroCostoGrupoProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,centrocostogrupoproductos,centrocostogrupoproductoParameterGeneral,centrocostogrupoproductoReturnGeneral);
			
			return centrocostogrupoproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CentroCostoGrupoProductoParameterReturnGeneral procesarAccionCentroCostoGrupoProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CentroCostoGrupoProducto> centrocostogrupoproductos,CentroCostoGrupoProductoParameterReturnGeneral centrocostogrupoproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-procesarAccionCentroCostoGrupoProductosWithConnection");connexion.begin();			
			
			CentroCostoGrupoProductoParameterReturnGeneral centrocostogrupoproductoReturnGeneral=new CentroCostoGrupoProductoParameterReturnGeneral();
	
			CentroCostoGrupoProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,centrocostogrupoproductos,centrocostogrupoproductoParameterGeneral,centrocostogrupoproductoReturnGeneral);
			
			this.connexion.commit();
			
			return centrocostogrupoproductoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CentroCostoGrupoProductoParameterReturnGeneral procesarEventosCentroCostoGrupoProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CentroCostoGrupoProducto> centrocostogrupoproductos,CentroCostoGrupoProducto centrocostogrupoproducto,CentroCostoGrupoProductoParameterReturnGeneral centrocostogrupoproductoParameterGeneral,Boolean isEsNuevoCentroCostoGrupoProducto,ArrayList<Classe> clases)throws Exception {
		 try {	
			CentroCostoGrupoProductoParameterReturnGeneral centrocostogrupoproductoReturnGeneral=new CentroCostoGrupoProductoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				centrocostogrupoproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CentroCostoGrupoProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,centrocostogrupoproductos,centrocostogrupoproducto,centrocostogrupoproductoParameterGeneral,centrocostogrupoproductoReturnGeneral,isEsNuevoCentroCostoGrupoProducto,clases);
			
			return centrocostogrupoproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CentroCostoGrupoProductoParameterReturnGeneral procesarEventosCentroCostoGrupoProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CentroCostoGrupoProducto> centrocostogrupoproductos,CentroCostoGrupoProducto centrocostogrupoproducto,CentroCostoGrupoProductoParameterReturnGeneral centrocostogrupoproductoParameterGeneral,Boolean isEsNuevoCentroCostoGrupoProducto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-procesarEventosCentroCostoGrupoProductosWithConnection");connexion.begin();			
			
			CentroCostoGrupoProductoParameterReturnGeneral centrocostogrupoproductoReturnGeneral=new CentroCostoGrupoProductoParameterReturnGeneral();
	
			centrocostogrupoproductoReturnGeneral.setCentroCostoGrupoProducto(centrocostogrupoproducto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				centrocostogrupoproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CentroCostoGrupoProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,centrocostogrupoproductos,centrocostogrupoproducto,centrocostogrupoproductoParameterGeneral,centrocostogrupoproductoReturnGeneral,isEsNuevoCentroCostoGrupoProducto,clases);
			
			this.connexion.commit();
			
			return centrocostogrupoproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CentroCostoGrupoProductoParameterReturnGeneral procesarImportacionCentroCostoGrupoProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CentroCostoGrupoProductoParameterReturnGeneral centrocostogrupoproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-procesarImportacionCentroCostoGrupoProductosWithConnection");connexion.begin();			
			
			CentroCostoGrupoProductoParameterReturnGeneral centrocostogrupoproductoReturnGeneral=new CentroCostoGrupoProductoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.centrocostogrupoproductos=new ArrayList<CentroCostoGrupoProducto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.centrocostogrupoproducto=new CentroCostoGrupoProducto();
				
				
				if(conColumnasBase) {this.centrocostogrupoproducto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.centrocostogrupoproducto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.centrocostogrupoproducto.setdescripcion(arrColumnas[iColumn++]);
				
				this.centrocostogrupoproductos.add(this.centrocostogrupoproducto);
			}
			
			this.saveCentroCostoGrupoProductos();
			
			this.connexion.commit();
			
			centrocostogrupoproductoReturnGeneral.setConRetornoEstaProcesado(true);
			centrocostogrupoproductoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return centrocostogrupoproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCentroCostoGrupoProductosEliminados() throws Exception {				
		
		List<CentroCostoGrupoProducto> centrocostogrupoproductosAux= new ArrayList<CentroCostoGrupoProducto>();
		
		for(CentroCostoGrupoProducto centrocostogrupoproducto:centrocostogrupoproductos) {
			if(!centrocostogrupoproducto.getIsDeleted()) {
				centrocostogrupoproductosAux.add(centrocostogrupoproducto);
			}
		}
		
		centrocostogrupoproductos=centrocostogrupoproductosAux;
	}
	
	public void quitarCentroCostoGrupoProductosNulos() throws Exception {				
		
		List<CentroCostoGrupoProducto> centrocostogrupoproductosAux= new ArrayList<CentroCostoGrupoProducto>();
		
		for(CentroCostoGrupoProducto centrocostogrupoproducto : this.centrocostogrupoproductos) {
			if(centrocostogrupoproducto==null) {
				centrocostogrupoproductosAux.add(centrocostogrupoproducto);
			}
		}
		
		//this.centrocostogrupoproductos=centrocostogrupoproductosAux;
		
		this.centrocostogrupoproductos.removeAll(centrocostogrupoproductosAux);
	}
	
	public void getSetVersionRowCentroCostoGrupoProductoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(centrocostogrupoproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((centrocostogrupoproducto.getIsDeleted() || (centrocostogrupoproducto.getIsChanged()&&!centrocostogrupoproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=centrocostogrupoproductoDataAccess.getSetVersionRowCentroCostoGrupoProducto(connexion,centrocostogrupoproducto.getId());
				
				if(!centrocostogrupoproducto.getVersionRow().equals(timestamp)) {	
					centrocostogrupoproducto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				centrocostogrupoproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCentroCostoGrupoProducto()throws Exception {	
		
		if(centrocostogrupoproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((centrocostogrupoproducto.getIsDeleted() || (centrocostogrupoproducto.getIsChanged()&&!centrocostogrupoproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=centrocostogrupoproductoDataAccess.getSetVersionRowCentroCostoGrupoProducto(connexion,centrocostogrupoproducto.getId());
			
			try {							
				if(!centrocostogrupoproducto.getVersionRow().equals(timestamp)) {	
					centrocostogrupoproducto.setVersionRow(timestamp);
				}
				
				centrocostogrupoproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCentroCostoGrupoProductosWithConnection()throws Exception {	
		if(centrocostogrupoproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CentroCostoGrupoProducto centrocostogrupoproductoAux:centrocostogrupoproductos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(centrocostogrupoproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(centrocostogrupoproductoAux.getIsDeleted() || (centrocostogrupoproductoAux.getIsChanged()&&!centrocostogrupoproductoAux.getIsNew())) {
						
						timestamp=centrocostogrupoproductoDataAccess.getSetVersionRowCentroCostoGrupoProducto(connexion,centrocostogrupoproductoAux.getId());
						
						if(!centrocostogrupoproducto.getVersionRow().equals(timestamp)) {	
							centrocostogrupoproductoAux.setVersionRow(timestamp);
						}
								
						centrocostogrupoproductoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCentroCostoGrupoProductos()throws Exception {	
		if(centrocostogrupoproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CentroCostoGrupoProducto centrocostogrupoproductoAux:centrocostogrupoproductos) {
					if(centrocostogrupoproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(centrocostogrupoproductoAux.getIsDeleted() || (centrocostogrupoproductoAux.getIsChanged()&&!centrocostogrupoproductoAux.getIsNew())) {
						
						timestamp=centrocostogrupoproductoDataAccess.getSetVersionRowCentroCostoGrupoProducto(connexion,centrocostogrupoproductoAux.getId());
						
						if(!centrocostogrupoproductoAux.getVersionRow().equals(timestamp)) {	
							centrocostogrupoproductoAux.setVersionRow(timestamp);
						}
						
													
						centrocostogrupoproductoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CentroCostoGrupoProductoParameterReturnGeneral cargarCombosLoteForeignKeyCentroCostoGrupoProductoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCentroCosto,String finalQueryGlobalLinea,String finalQueryGlobalLineaGrupo) throws Exception {
		CentroCostoGrupoProductoParameterReturnGeneral  centrocostogrupoproductoReturnGeneral =new CentroCostoGrupoProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-cargarCombosLoteForeignKeyCentroCostoGrupoProductoWithConnection");connexion.begin();
			
			centrocostogrupoproductoReturnGeneral =new CentroCostoGrupoProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			centrocostogrupoproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			centrocostogrupoproductoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			centrocostogrupoproductoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			centrocostogrupoproductoReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Linea> lineagruposForeignKey=new ArrayList<Linea>();
			LineaLogic lineagrupoLogic=new LineaLogic();
			lineagrupoLogic.setConnexion(this.connexion);
			lineagrupoLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaGrupo.equals("NONE")) {
				lineagrupoLogic.getTodosLineas(finalQueryGlobalLineaGrupo,new Pagination());
				lineagruposForeignKey=lineagrupoLogic.getLineas();
			}

			centrocostogrupoproductoReturnGeneral.setlineagruposForeignKey(lineagruposForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return centrocostogrupoproductoReturnGeneral;
	}
	
	public CentroCostoGrupoProductoParameterReturnGeneral cargarCombosLoteForeignKeyCentroCostoGrupoProducto(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCentroCosto,String finalQueryGlobalLinea,String finalQueryGlobalLineaGrupo) throws Exception {
		CentroCostoGrupoProductoParameterReturnGeneral  centrocostogrupoproductoReturnGeneral =new CentroCostoGrupoProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			centrocostogrupoproductoReturnGeneral =new CentroCostoGrupoProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			centrocostogrupoproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			centrocostogrupoproductoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			centrocostogrupoproductoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			centrocostogrupoproductoReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Linea> lineagruposForeignKey=new ArrayList<Linea>();
			LineaLogic lineagrupoLogic=new LineaLogic();
			lineagrupoLogic.setConnexion(this.connexion);
			lineagrupoLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaGrupo.equals("NONE")) {
				lineagrupoLogic.getTodosLineas(finalQueryGlobalLineaGrupo,new Pagination());
				lineagruposForeignKey=lineagrupoLogic.getLineas();
			}

			centrocostogrupoproductoReturnGeneral.setlineagruposForeignKey(lineagruposForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return centrocostogrupoproductoReturnGeneral;
	}
	
	
	public void deepLoad(CentroCostoGrupoProducto centrocostogrupoproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CentroCostoGrupoProductoLogicAdditional.updateCentroCostoGrupoProductoToGet(centrocostogrupoproducto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		centrocostogrupoproducto.setEmpresa(centrocostogrupoproductoDataAccess.getEmpresa(connexion,centrocostogrupoproducto));
		centrocostogrupoproducto.setSucursal(centrocostogrupoproductoDataAccess.getSucursal(connexion,centrocostogrupoproducto));
		centrocostogrupoproducto.setCentroCosto(centrocostogrupoproductoDataAccess.getCentroCosto(connexion,centrocostogrupoproducto));
		centrocostogrupoproducto.setLinea(centrocostogrupoproductoDataAccess.getLinea(connexion,centrocostogrupoproducto));
		centrocostogrupoproducto.setLineaGrupo(centrocostogrupoproductoDataAccess.getLineaGrupo(connexion,centrocostogrupoproducto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				centrocostogrupoproducto.setEmpresa(centrocostogrupoproductoDataAccess.getEmpresa(connexion,centrocostogrupoproducto));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				centrocostogrupoproducto.setSucursal(centrocostogrupoproductoDataAccess.getSucursal(connexion,centrocostogrupoproducto));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				centrocostogrupoproducto.setCentroCosto(centrocostogrupoproductoDataAccess.getCentroCosto(connexion,centrocostogrupoproducto));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				centrocostogrupoproducto.setLinea(centrocostogrupoproductoDataAccess.getLinea(connexion,centrocostogrupoproducto));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				centrocostogrupoproducto.setLineaGrupo(centrocostogrupoproductoDataAccess.getLineaGrupo(connexion,centrocostogrupoproducto));
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
			centrocostogrupoproducto.setEmpresa(centrocostogrupoproductoDataAccess.getEmpresa(connexion,centrocostogrupoproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			centrocostogrupoproducto.setSucursal(centrocostogrupoproductoDataAccess.getSucursal(connexion,centrocostogrupoproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			centrocostogrupoproducto.setCentroCosto(centrocostogrupoproductoDataAccess.getCentroCosto(connexion,centrocostogrupoproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			centrocostogrupoproducto.setLinea(centrocostogrupoproductoDataAccess.getLinea(connexion,centrocostogrupoproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			centrocostogrupoproducto.setLineaGrupo(centrocostogrupoproductoDataAccess.getLineaGrupo(connexion,centrocostogrupoproducto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		centrocostogrupoproducto.setEmpresa(centrocostogrupoproductoDataAccess.getEmpresa(connexion,centrocostogrupoproducto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(centrocostogrupoproducto.getEmpresa(),isDeep,deepLoadType,clases);
				
		centrocostogrupoproducto.setSucursal(centrocostogrupoproductoDataAccess.getSucursal(connexion,centrocostogrupoproducto));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(centrocostogrupoproducto.getSucursal(),isDeep,deepLoadType,clases);
				
		centrocostogrupoproducto.setCentroCosto(centrocostogrupoproductoDataAccess.getCentroCosto(connexion,centrocostogrupoproducto));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(centrocostogrupoproducto.getCentroCosto(),isDeep,deepLoadType,clases);
				
		centrocostogrupoproducto.setLinea(centrocostogrupoproductoDataAccess.getLinea(connexion,centrocostogrupoproducto));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(centrocostogrupoproducto.getLinea(),isDeep,deepLoadType,clases);
				
		centrocostogrupoproducto.setLineaGrupo(centrocostogrupoproductoDataAccess.getLineaGrupo(connexion,centrocostogrupoproducto));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(centrocostogrupoproducto.getLineaGrupo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				centrocostogrupoproducto.setEmpresa(centrocostogrupoproductoDataAccess.getEmpresa(connexion,centrocostogrupoproducto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(centrocostogrupoproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				centrocostogrupoproducto.setSucursal(centrocostogrupoproductoDataAccess.getSucursal(connexion,centrocostogrupoproducto));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(centrocostogrupoproducto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				centrocostogrupoproducto.setCentroCosto(centrocostogrupoproductoDataAccess.getCentroCosto(connexion,centrocostogrupoproducto));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(centrocostogrupoproducto.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				centrocostogrupoproducto.setLinea(centrocostogrupoproductoDataAccess.getLinea(connexion,centrocostogrupoproducto));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(centrocostogrupoproducto.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				centrocostogrupoproducto.setLineaGrupo(centrocostogrupoproductoDataAccess.getLineaGrupo(connexion,centrocostogrupoproducto));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(centrocostogrupoproducto.getLineaGrupo(),isDeep,deepLoadType,clases);				
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
			centrocostogrupoproducto.setEmpresa(centrocostogrupoproductoDataAccess.getEmpresa(connexion,centrocostogrupoproducto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(centrocostogrupoproducto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			centrocostogrupoproducto.setSucursal(centrocostogrupoproductoDataAccess.getSucursal(connexion,centrocostogrupoproducto));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(centrocostogrupoproducto.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			centrocostogrupoproducto.setCentroCosto(centrocostogrupoproductoDataAccess.getCentroCosto(connexion,centrocostogrupoproducto));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(centrocostogrupoproducto.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			centrocostogrupoproducto.setLinea(centrocostogrupoproductoDataAccess.getLinea(connexion,centrocostogrupoproducto));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(centrocostogrupoproducto.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			centrocostogrupoproducto.setLineaGrupo(centrocostogrupoproductoDataAccess.getLineaGrupo(connexion,centrocostogrupoproducto));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(centrocostogrupoproducto.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CentroCostoGrupoProducto centrocostogrupoproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CentroCostoGrupoProductoLogicAdditional.updateCentroCostoGrupoProductoToSave(centrocostogrupoproducto,this.arrDatoGeneral);
			
CentroCostoGrupoProductoDataAccess.save(centrocostogrupoproducto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(centrocostogrupoproducto.getEmpresa(),connexion);

		SucursalDataAccess.save(centrocostogrupoproducto.getSucursal(),connexion);

		CentroCostoDataAccess.save(centrocostogrupoproducto.getCentroCosto(),connexion);

		LineaDataAccess.save(centrocostogrupoproducto.getLinea(),connexion);

		LineaDataAccess.save(centrocostogrupoproducto.getLineaGrupo(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(centrocostogrupoproducto.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(centrocostogrupoproducto.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(centrocostogrupoproducto.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(centrocostogrupoproducto.getLinea(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(centrocostogrupoproducto.getLineaGrupo(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(centrocostogrupoproducto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(centrocostogrupoproducto.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(centrocostogrupoproducto.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(centrocostogrupoproducto.getSucursal(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(centrocostogrupoproducto.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(centrocostogrupoproducto.getCentroCosto(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(centrocostogrupoproducto.getLinea(),connexion);
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(centrocostogrupoproducto.getLinea(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(centrocostogrupoproducto.getLineaGrupo(),connexion);
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(centrocostogrupoproducto.getLineaGrupo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(centrocostogrupoproducto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(centrocostogrupoproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(centrocostogrupoproducto.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(centrocostogrupoproducto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(centrocostogrupoproducto.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(centrocostogrupoproducto.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(centrocostogrupoproducto.getLinea(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(centrocostogrupoproducto.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(centrocostogrupoproducto.getLineaGrupo(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(centrocostogrupoproducto.getLineaGrupo(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(CentroCostoGrupoProducto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(centrocostogrupoproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(centrocostogrupoproducto);
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
			this.deepLoad(this.centrocostogrupoproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CentroCostoGrupoProducto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(centrocostogrupoproductos!=null) {
				for(CentroCostoGrupoProducto centrocostogrupoproducto:centrocostogrupoproductos) {
					this.deepLoad(centrocostogrupoproducto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(centrocostogrupoproductos);
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
			if(centrocostogrupoproductos!=null) {
				for(CentroCostoGrupoProducto centrocostogrupoproducto:centrocostogrupoproductos) {
					this.deepLoad(centrocostogrupoproducto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(centrocostogrupoproductos);
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
			this.getNewConnexionToDeep(CentroCostoGrupoProducto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(centrocostogrupoproducto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CentroCostoGrupoProducto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(centrocostogrupoproductos!=null) {
				for(CentroCostoGrupoProducto centrocostogrupoproducto:centrocostogrupoproductos) {
					this.deepSave(centrocostogrupoproducto,isDeep,deepLoadType,clases);
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
			if(centrocostogrupoproductos!=null) {
				for(CentroCostoGrupoProducto centrocostogrupoproducto:centrocostogrupoproductos) {
					this.deepSave(centrocostogrupoproducto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCentroCostoGrupoProductosBusquedaPorIdCentroCostoPorIdLineaWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo,Long id_linea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,CentroCostoGrupoProductoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,CentroCostoGrupoProductoConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdCentroCostoPorIdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCentroCostoGrupoProductosBusquedaPorIdCentroCostoPorIdLinea(String sFinalQuery,Pagination pagination,Long id_centro_costo,Long id_linea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,CentroCostoGrupoProductoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,CentroCostoGrupoProductoConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdCentroCostoPorIdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCentroCostoGrupoProductosFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,CentroCostoGrupoProductoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCentroCostoGrupoProductosFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,CentroCostoGrupoProductoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCentroCostoGrupoProductosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CentroCostoGrupoProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCentroCostoGrupoProductosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CentroCostoGrupoProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCentroCostoGrupoProductosFK_IdLineaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,CentroCostoGrupoProductoConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCentroCostoGrupoProductosFK_IdLinea(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,CentroCostoGrupoProductoConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCentroCostoGrupoProductosFK_IdLineaGrupoWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_grupo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,CentroCostoGrupoProductoConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCentroCostoGrupoProductosFK_IdLineaGrupo(String sFinalQuery,Pagination pagination,Long id_linea_grupo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,CentroCostoGrupoProductoConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCentroCostoGrupoProductosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoGrupoProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CentroCostoGrupoProductoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCentroCostoGrupoProductosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CentroCostoGrupoProductoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CentroCostoGrupoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoGrupoProductoConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(this.centrocostogrupoproductos);
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
			if(CentroCostoGrupoProductoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CentroCostoGrupoProductoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CentroCostoGrupoProducto centrocostogrupoproducto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CentroCostoGrupoProductoConstantesFunciones.ISCONAUDITORIA) {
				if(centrocostogrupoproducto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CentroCostoGrupoProductoDataAccess.TABLENAME, centrocostogrupoproducto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CentroCostoGrupoProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CentroCostoGrupoProductoLogic.registrarAuditoriaDetallesCentroCostoGrupoProducto(connexion,centrocostogrupoproducto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(centrocostogrupoproducto.getIsDeleted()) {
					/*if(!centrocostogrupoproducto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CentroCostoGrupoProductoDataAccess.TABLENAME, centrocostogrupoproducto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CentroCostoGrupoProductoLogic.registrarAuditoriaDetallesCentroCostoGrupoProducto(connexion,centrocostogrupoproducto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CentroCostoGrupoProductoDataAccess.TABLENAME, centrocostogrupoproducto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(centrocostogrupoproducto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CentroCostoGrupoProductoDataAccess.TABLENAME, centrocostogrupoproducto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CentroCostoGrupoProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CentroCostoGrupoProductoLogic.registrarAuditoriaDetallesCentroCostoGrupoProducto(connexion,centrocostogrupoproducto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCentroCostoGrupoProducto(Connexion connexion,CentroCostoGrupoProducto centrocostogrupoproducto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(centrocostogrupoproducto.getIsNew()||!centrocostogrupoproducto.getid_empresa().equals(centrocostogrupoproducto.getCentroCostoGrupoProductoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostogrupoproducto.getCentroCostoGrupoProductoOriginal().getid_empresa()!=null)
				{
					strValorActual=centrocostogrupoproducto.getCentroCostoGrupoProductoOriginal().getid_empresa().toString();
				}
				if(centrocostogrupoproducto.getid_empresa()!=null)
				{
					strValorNuevo=centrocostogrupoproducto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoGrupoProductoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(centrocostogrupoproducto.getIsNew()||!centrocostogrupoproducto.getid_sucursal().equals(centrocostogrupoproducto.getCentroCostoGrupoProductoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostogrupoproducto.getCentroCostoGrupoProductoOriginal().getid_sucursal()!=null)
				{
					strValorActual=centrocostogrupoproducto.getCentroCostoGrupoProductoOriginal().getid_sucursal().toString();
				}
				if(centrocostogrupoproducto.getid_sucursal()!=null)
				{
					strValorNuevo=centrocostogrupoproducto.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoGrupoProductoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(centrocostogrupoproducto.getIsNew()||!centrocostogrupoproducto.getid_centro_costo().equals(centrocostogrupoproducto.getCentroCostoGrupoProductoOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostogrupoproducto.getCentroCostoGrupoProductoOriginal().getid_centro_costo()!=null)
				{
					strValorActual=centrocostogrupoproducto.getCentroCostoGrupoProductoOriginal().getid_centro_costo().toString();
				}
				if(centrocostogrupoproducto.getid_centro_costo()!=null)
				{
					strValorNuevo=centrocostogrupoproducto.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoGrupoProductoConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(centrocostogrupoproducto.getIsNew()||!centrocostogrupoproducto.getid_linea().equals(centrocostogrupoproducto.getCentroCostoGrupoProductoOriginal().getid_linea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostogrupoproducto.getCentroCostoGrupoProductoOriginal().getid_linea()!=null)
				{
					strValorActual=centrocostogrupoproducto.getCentroCostoGrupoProductoOriginal().getid_linea().toString();
				}
				if(centrocostogrupoproducto.getid_linea()!=null)
				{
					strValorNuevo=centrocostogrupoproducto.getid_linea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoGrupoProductoConstantesFunciones.IDLINEA,strValorActual,strValorNuevo);
			}	
			
			if(centrocostogrupoproducto.getIsNew()||!centrocostogrupoproducto.getid_linea_grupo().equals(centrocostogrupoproducto.getCentroCostoGrupoProductoOriginal().getid_linea_grupo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostogrupoproducto.getCentroCostoGrupoProductoOriginal().getid_linea_grupo()!=null)
				{
					strValorActual=centrocostogrupoproducto.getCentroCostoGrupoProductoOriginal().getid_linea_grupo().toString();
				}
				if(centrocostogrupoproducto.getid_linea_grupo()!=null)
				{
					strValorNuevo=centrocostogrupoproducto.getid_linea_grupo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoGrupoProductoConstantesFunciones.IDLINEAGRUPO,strValorActual,strValorNuevo);
			}	
			
			if(centrocostogrupoproducto.getIsNew()||!centrocostogrupoproducto.getdescripcion().equals(centrocostogrupoproducto.getCentroCostoGrupoProductoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostogrupoproducto.getCentroCostoGrupoProductoOriginal().getdescripcion()!=null)
				{
					strValorActual=centrocostogrupoproducto.getCentroCostoGrupoProductoOriginal().getdescripcion();
				}
				if(centrocostogrupoproducto.getdescripcion()!=null)
				{
					strValorNuevo=centrocostogrupoproducto.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoGrupoProductoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCentroCostoGrupoProductoRelacionesWithConnection(CentroCostoGrupoProducto centrocostogrupoproducto) throws Exception {

		if(!centrocostogrupoproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCentroCostoGrupoProductoRelacionesBase(centrocostogrupoproducto,true);
		}
	}

	public void saveCentroCostoGrupoProductoRelaciones(CentroCostoGrupoProducto centrocostogrupoproducto)throws Exception {

		if(!centrocostogrupoproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCentroCostoGrupoProductoRelacionesBase(centrocostogrupoproducto,false);
		}
	}

	public void saveCentroCostoGrupoProductoRelacionesBase(CentroCostoGrupoProducto centrocostogrupoproducto,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CentroCostoGrupoProducto-saveRelacionesWithConnection");}
	

			this.setCentroCostoGrupoProducto(centrocostogrupoproducto);

			if(CentroCostoGrupoProductoLogicAdditional.validarSaveRelaciones(centrocostogrupoproducto,this)) {

				CentroCostoGrupoProductoLogicAdditional.updateRelacionesToSave(centrocostogrupoproducto,this);

				if((centrocostogrupoproducto.getIsNew()||centrocostogrupoproducto.getIsChanged())&&!centrocostogrupoproducto.getIsDeleted()) {
					this.saveCentroCostoGrupoProducto();
					this.saveCentroCostoGrupoProductoRelacionesDetalles();

				} else if(centrocostogrupoproducto.getIsDeleted()) {
					this.saveCentroCostoGrupoProductoRelacionesDetalles();
					this.saveCentroCostoGrupoProducto();
				}

				CentroCostoGrupoProductoLogicAdditional.updateRelacionesToSaveAfter(centrocostogrupoproducto,this);

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
	
	
	private void saveCentroCostoGrupoProductoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCentroCostoGrupoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CentroCostoGrupoProductoConstantesFunciones.getClassesForeignKeysOfCentroCostoGrupoProducto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCentroCostoGrupoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CentroCostoGrupoProductoConstantesFunciones.getClassesRelationshipsOfCentroCostoGrupoProducto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

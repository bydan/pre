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
import com.bydan.erp.inventario.util.CalidadProductoConstantesFunciones;
import com.bydan.erp.inventario.util.CalidadProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.CalidadProductoParameterGeneral;
import com.bydan.erp.inventario.business.entity.CalidadProducto;
import com.bydan.erp.inventario.business.logic.CalidadProductoLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class CalidadProductoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CalidadProductoLogic.class);
	
	protected CalidadProductoDataAccess calidadproductoDataAccess; 	
	protected CalidadProducto calidadproducto;
	protected List<CalidadProducto> calidadproductos;
	protected Object calidadproductoObject;	
	protected List<Object> calidadproductosObject;
	
	public static ClassValidator<CalidadProducto> calidadproductoValidator = new ClassValidator<CalidadProducto>(CalidadProducto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CalidadProductoLogicAdditional calidadproductoLogicAdditional=null;
	
	public CalidadProductoLogicAdditional getCalidadProductoLogicAdditional() {
		return this.calidadproductoLogicAdditional;
	}
	
	public void setCalidadProductoLogicAdditional(CalidadProductoLogicAdditional calidadproductoLogicAdditional) {
		try {
			this.calidadproductoLogicAdditional=calidadproductoLogicAdditional;
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
	
	
	
	
	public  CalidadProductoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.calidadproductoDataAccess = new CalidadProductoDataAccess();
			
			this.calidadproductos= new ArrayList<CalidadProducto>();
			this.calidadproducto= new CalidadProducto();
			
			this.calidadproductoObject=new Object();
			this.calidadproductosObject=new ArrayList<Object>();
				
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
			
			this.calidadproductoDataAccess.setConnexionType(this.connexionType);
			this.calidadproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CalidadProductoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.calidadproductoDataAccess = new CalidadProductoDataAccess();
			this.calidadproductos= new ArrayList<CalidadProducto>();
			this.calidadproducto= new CalidadProducto();
			this.calidadproductoObject=new Object();
			this.calidadproductosObject=new ArrayList<Object>();
			
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
			
			this.calidadproductoDataAccess.setConnexionType(this.connexionType);
			this.calidadproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CalidadProducto getCalidadProducto() throws Exception {	
		CalidadProductoLogicAdditional.checkCalidadProductoToGet(calidadproducto,this.datosCliente,this.arrDatoGeneral);
		CalidadProductoLogicAdditional.updateCalidadProductoToGet(calidadproducto,this.arrDatoGeneral);
		
		return calidadproducto;
	}
		
	public void setCalidadProducto(CalidadProducto newCalidadProducto) {
		this.calidadproducto = newCalidadProducto;
	}
	
	public CalidadProductoDataAccess getCalidadProductoDataAccess() {
		return calidadproductoDataAccess;
	}
	
	public void setCalidadProductoDataAccess(CalidadProductoDataAccess newcalidadproductoDataAccess) {
		this.calidadproductoDataAccess = newcalidadproductoDataAccess;
	}
	
	public List<CalidadProducto> getCalidadProductos() throws Exception {		
		this.quitarCalidadProductosNulos();
		
		CalidadProductoLogicAdditional.checkCalidadProductoToGets(calidadproductos,this.datosCliente,this.arrDatoGeneral);
		
		for (CalidadProducto calidadproductoLocal: calidadproductos ) {
			CalidadProductoLogicAdditional.updateCalidadProductoToGet(calidadproductoLocal,this.arrDatoGeneral);
		}
		
		return calidadproductos;
	}
	
	public void setCalidadProductos(List<CalidadProducto> newCalidadProductos) {
		this.calidadproductos = newCalidadProductos;
	}
	
	public Object getCalidadProductoObject() {	
		this.calidadproductoObject=this.calidadproductoDataAccess.getEntityObject();
		return this.calidadproductoObject;
	}
		
	public void setCalidadProductoObject(Object newCalidadProductoObject) {
		this.calidadproductoObject = newCalidadProductoObject;
	}
	
	public List<Object> getCalidadProductosObject() {		
		this.calidadproductosObject=this.calidadproductoDataAccess.getEntitiesObject();
		return this.calidadproductosObject;
	}
		
	public void setCalidadProductosObject(List<Object> newCalidadProductosObject) {
		this.calidadproductosObject = newCalidadProductosObject;
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
		
		if(this.calidadproductoDataAccess!=null) {
			this.calidadproductoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalidadProducto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			calidadproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			calidadproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		calidadproducto = new  CalidadProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalidadProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			calidadproducto=calidadproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.calidadproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(this.calidadproducto);
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
		calidadproducto = new  CalidadProducto();
		  		  
        try {
			
			calidadproducto=calidadproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.calidadproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(this.calidadproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		calidadproducto = new  CalidadProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalidadProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			calidadproducto=calidadproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.calidadproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(this.calidadproducto);
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
		calidadproducto = new  CalidadProducto();
		  		  
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
		calidadproducto = new  CalidadProducto();
		  		  
        try {
			
			calidadproducto=calidadproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.calidadproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(this.calidadproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		calidadproducto = new  CalidadProducto();
		  		  
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
		calidadproducto = new  CalidadProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalidadProducto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =calidadproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		calidadproducto = new  CalidadProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=calidadproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		calidadproducto = new  CalidadProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalidadProducto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =calidadproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		calidadproducto = new  CalidadProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=calidadproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		calidadproducto = new  CalidadProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalidadProducto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =calidadproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		calidadproducto = new  CalidadProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=calidadproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		calidadproductos = new  ArrayList<CalidadProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalidadProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CalidadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calidadproductos=calidadproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCalidadProducto(calidadproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(this.calidadproductos);
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
		calidadproductos = new  ArrayList<CalidadProducto>();
		  		  
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
		calidadproductos = new  ArrayList<CalidadProducto>();
		  		  
        try {			
			CalidadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calidadproductos=calidadproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCalidadProducto(calidadproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(this.calidadproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		calidadproductos = new  ArrayList<CalidadProducto>();
		  		  
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
		calidadproductos = new  ArrayList<CalidadProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalidadProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CalidadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calidadproductos=calidadproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCalidadProducto(calidadproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(this.calidadproductos);
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
		calidadproductos = new  ArrayList<CalidadProducto>();
		  		  
        try {
			CalidadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calidadproductos=calidadproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCalidadProducto(calidadproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(this.calidadproductos);
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
		calidadproductos = new  ArrayList<CalidadProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalidadProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CalidadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calidadproductos=calidadproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCalidadProducto(calidadproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(this.calidadproductos);
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
		calidadproductos = new  ArrayList<CalidadProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CalidadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calidadproductos=calidadproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCalidadProducto(calidadproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(this.calidadproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		calidadproducto = new  CalidadProducto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalidadProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CalidadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calidadproducto=calidadproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCalidadProducto(calidadproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(this.calidadproducto);
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
		calidadproducto = new  CalidadProducto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CalidadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calidadproducto=calidadproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCalidadProducto(calidadproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(this.calidadproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		calidadproductos = new  ArrayList<CalidadProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalidadProducto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CalidadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calidadproductos=calidadproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCalidadProducto(calidadproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(this.calidadproductos);
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
		calidadproductos = new  ArrayList<CalidadProducto>();
		  		  
        try {
			CalidadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calidadproductos=calidadproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCalidadProducto(calidadproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(this.calidadproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCalidadProductosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		calidadproductos = new  ArrayList<CalidadProducto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalidadProducto.class.getSimpleName()+"-getTodosCalidadProductosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CalidadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calidadproductos=calidadproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCalidadProducto(calidadproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(this.calidadproductos);
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
	
	public  void  getTodosCalidadProductos(String sFinalQuery,Pagination pagination)throws Exception {
		calidadproductos = new  ArrayList<CalidadProducto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CalidadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			calidadproductos=calidadproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCalidadProducto(calidadproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(this.calidadproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCalidadProducto(CalidadProducto calidadproducto) throws Exception {
		Boolean estaValidado=false;
		
		if(calidadproducto.getIsNew() || calidadproducto.getIsChanged()) { 
			this.invalidValues = calidadproductoValidator.getInvalidValues(calidadproducto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(calidadproducto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCalidadProducto(List<CalidadProducto> CalidadProductos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CalidadProducto calidadproductoLocal:calidadproductos) {				
			estaValidadoObjeto=this.validarGuardarCalidadProducto(calidadproductoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCalidadProducto(List<CalidadProducto> CalidadProductos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCalidadProducto(calidadproductos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCalidadProducto(CalidadProducto CalidadProducto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCalidadProducto(calidadproducto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CalidadProducto calidadproducto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+calidadproducto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CalidadProductoConstantesFunciones.getCalidadProductoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"calidadproducto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CalidadProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CalidadProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCalidadProductoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalidadProducto.class.getSimpleName()+"-saveCalidadProductoWithConnection");connexion.begin();			
			
			CalidadProductoLogicAdditional.checkCalidadProductoToSave(this.calidadproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CalidadProductoLogicAdditional.updateCalidadProductoToSave(this.calidadproducto,this.arrDatoGeneral);
			
			CalidadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.calidadproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCalidadProducto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCalidadProducto(this.calidadproducto)) {
				CalidadProductoDataAccess.save(this.calidadproducto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.calidadproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CalidadProductoLogicAdditional.checkCalidadProductoToSaveAfter(this.calidadproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCalidadProducto();
			
			connexion.commit();			
			
			if(this.calidadproducto.getIsDeleted()) {
				this.calidadproducto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCalidadProducto()throws Exception {	
		try {	
			
			CalidadProductoLogicAdditional.checkCalidadProductoToSave(this.calidadproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CalidadProductoLogicAdditional.updateCalidadProductoToSave(this.calidadproducto,this.arrDatoGeneral);
			
			CalidadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.calidadproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCalidadProducto(this.calidadproducto)) {			
				CalidadProductoDataAccess.save(this.calidadproducto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.calidadproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CalidadProductoLogicAdditional.checkCalidadProductoToSaveAfter(this.calidadproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.calidadproducto.getIsDeleted()) {
				this.calidadproducto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCalidadProductosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalidadProducto.class.getSimpleName()+"-saveCalidadProductosWithConnection");connexion.begin();			
			
			CalidadProductoLogicAdditional.checkCalidadProductoToSaves(calidadproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCalidadProductos();
			
			Boolean validadoTodosCalidadProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CalidadProducto calidadproductoLocal:calidadproductos) {		
				if(calidadproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CalidadProductoLogicAdditional.updateCalidadProductoToSave(calidadproductoLocal,this.arrDatoGeneral);
	        	
				CalidadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),calidadproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCalidadProducto(calidadproductoLocal)) {
					CalidadProductoDataAccess.save(calidadproductoLocal, connexion);				
				} else {
					validadoTodosCalidadProducto=false;
				}
			}
			
			if(!validadoTodosCalidadProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CalidadProductoLogicAdditional.checkCalidadProductoToSavesAfter(calidadproductos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCalidadProductos();
			
			connexion.commit();		
			
			this.quitarCalidadProductosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCalidadProductos()throws Exception {				
		 try {	
			CalidadProductoLogicAdditional.checkCalidadProductoToSaves(calidadproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCalidadProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CalidadProducto calidadproductoLocal:calidadproductos) {				
				if(calidadproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CalidadProductoLogicAdditional.updateCalidadProductoToSave(calidadproductoLocal,this.arrDatoGeneral);
	        	
				CalidadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),calidadproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCalidadProducto(calidadproductoLocal)) {				
					CalidadProductoDataAccess.save(calidadproductoLocal, connexion);				
				} else {
					validadoTodosCalidadProducto=false;
				}
			}
			
			if(!validadoTodosCalidadProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CalidadProductoLogicAdditional.checkCalidadProductoToSavesAfter(calidadproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCalidadProductosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CalidadProductoParameterReturnGeneral procesarAccionCalidadProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CalidadProducto> calidadproductos,CalidadProductoParameterReturnGeneral calidadproductoParameterGeneral)throws Exception {
		 try {	
			CalidadProductoParameterReturnGeneral calidadproductoReturnGeneral=new CalidadProductoParameterReturnGeneral();
	
			CalidadProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,calidadproductos,calidadproductoParameterGeneral,calidadproductoReturnGeneral);
			
			return calidadproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CalidadProductoParameterReturnGeneral procesarAccionCalidadProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CalidadProducto> calidadproductos,CalidadProductoParameterReturnGeneral calidadproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalidadProducto.class.getSimpleName()+"-procesarAccionCalidadProductosWithConnection");connexion.begin();			
			
			CalidadProductoParameterReturnGeneral calidadproductoReturnGeneral=new CalidadProductoParameterReturnGeneral();
	
			CalidadProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,calidadproductos,calidadproductoParameterGeneral,calidadproductoReturnGeneral);
			
			this.connexion.commit();
			
			return calidadproductoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CalidadProductoParameterReturnGeneral procesarEventosCalidadProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CalidadProducto> calidadproductos,CalidadProducto calidadproducto,CalidadProductoParameterReturnGeneral calidadproductoParameterGeneral,Boolean isEsNuevoCalidadProducto,ArrayList<Classe> clases)throws Exception {
		 try {	
			CalidadProductoParameterReturnGeneral calidadproductoReturnGeneral=new CalidadProductoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				calidadproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CalidadProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,calidadproductos,calidadproducto,calidadproductoParameterGeneral,calidadproductoReturnGeneral,isEsNuevoCalidadProducto,clases);
			
			return calidadproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CalidadProductoParameterReturnGeneral procesarEventosCalidadProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CalidadProducto> calidadproductos,CalidadProducto calidadproducto,CalidadProductoParameterReturnGeneral calidadproductoParameterGeneral,Boolean isEsNuevoCalidadProducto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalidadProducto.class.getSimpleName()+"-procesarEventosCalidadProductosWithConnection");connexion.begin();			
			
			CalidadProductoParameterReturnGeneral calidadproductoReturnGeneral=new CalidadProductoParameterReturnGeneral();
	
			calidadproductoReturnGeneral.setCalidadProducto(calidadproducto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				calidadproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CalidadProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,calidadproductos,calidadproducto,calidadproductoParameterGeneral,calidadproductoReturnGeneral,isEsNuevoCalidadProducto,clases);
			
			this.connexion.commit();
			
			return calidadproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CalidadProductoParameterReturnGeneral procesarImportacionCalidadProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CalidadProductoParameterReturnGeneral calidadproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalidadProducto.class.getSimpleName()+"-procesarImportacionCalidadProductosWithConnection");connexion.begin();			
			
			CalidadProductoParameterReturnGeneral calidadproductoReturnGeneral=new CalidadProductoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.calidadproductos=new ArrayList<CalidadProducto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.calidadproducto=new CalidadProducto();
				
				
				if(conColumnasBase) {this.calidadproducto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.calidadproducto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.calidadproducto.setcodigo(arrColumnas[iColumn++]);
				this.calidadproducto.setnombre(arrColumnas[iColumn++]);
				
				this.calidadproductos.add(this.calidadproducto);
			}
			
			this.saveCalidadProductos();
			
			this.connexion.commit();
			
			calidadproductoReturnGeneral.setConRetornoEstaProcesado(true);
			calidadproductoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return calidadproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCalidadProductosEliminados() throws Exception {				
		
		List<CalidadProducto> calidadproductosAux= new ArrayList<CalidadProducto>();
		
		for(CalidadProducto calidadproducto:calidadproductos) {
			if(!calidadproducto.getIsDeleted()) {
				calidadproductosAux.add(calidadproducto);
			}
		}
		
		calidadproductos=calidadproductosAux;
	}
	
	public void quitarCalidadProductosNulos() throws Exception {				
		
		List<CalidadProducto> calidadproductosAux= new ArrayList<CalidadProducto>();
		
		for(CalidadProducto calidadproducto : this.calidadproductos) {
			if(calidadproducto==null) {
				calidadproductosAux.add(calidadproducto);
			}
		}
		
		//this.calidadproductos=calidadproductosAux;
		
		this.calidadproductos.removeAll(calidadproductosAux);
	}
	
	public void getSetVersionRowCalidadProductoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(calidadproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((calidadproducto.getIsDeleted() || (calidadproducto.getIsChanged()&&!calidadproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=calidadproductoDataAccess.getSetVersionRowCalidadProducto(connexion,calidadproducto.getId());
				
				if(!calidadproducto.getVersionRow().equals(timestamp)) {	
					calidadproducto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				calidadproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCalidadProducto()throws Exception {	
		
		if(calidadproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((calidadproducto.getIsDeleted() || (calidadproducto.getIsChanged()&&!calidadproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=calidadproductoDataAccess.getSetVersionRowCalidadProducto(connexion,calidadproducto.getId());
			
			try {							
				if(!calidadproducto.getVersionRow().equals(timestamp)) {	
					calidadproducto.setVersionRow(timestamp);
				}
				
				calidadproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCalidadProductosWithConnection()throws Exception {	
		if(calidadproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CalidadProducto calidadproductoAux:calidadproductos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(calidadproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(calidadproductoAux.getIsDeleted() || (calidadproductoAux.getIsChanged()&&!calidadproductoAux.getIsNew())) {
						
						timestamp=calidadproductoDataAccess.getSetVersionRowCalidadProducto(connexion,calidadproductoAux.getId());
						
						if(!calidadproducto.getVersionRow().equals(timestamp)) {	
							calidadproductoAux.setVersionRow(timestamp);
						}
								
						calidadproductoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCalidadProductos()throws Exception {	
		if(calidadproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CalidadProducto calidadproductoAux:calidadproductos) {
					if(calidadproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(calidadproductoAux.getIsDeleted() || (calidadproductoAux.getIsChanged()&&!calidadproductoAux.getIsNew())) {
						
						timestamp=calidadproductoDataAccess.getSetVersionRowCalidadProducto(connexion,calidadproductoAux.getId());
						
						if(!calidadproductoAux.getVersionRow().equals(timestamp)) {	
							calidadproductoAux.setVersionRow(timestamp);
						}
						
													
						calidadproductoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyCalidadProductoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			BodegaLogic bodegaLogic=new BodegaLogic();
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic=new ParametroInventarioDefectoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalidadProducto.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyCalidadProductoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Bodega.class));
			classes.add(new Classe(ParametroInventarioDefecto.class));
											
			

			bodegaLogic.setConnexion(this.getConnexion());
			bodegaLogic.setDatosCliente(this.datosCliente);
			bodegaLogic.setIsConRefrescarForeignKeys(true);

			parametroinventariodefectoLogic.setConnexion(this.getConnexion());
			parametroinventariodefectoLogic.setDatosCliente(this.datosCliente);
			parametroinventariodefectoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(CalidadProducto calidadproducto:this.calidadproductos) {
				

				classes=new ArrayList<Classe>();
				classes=BodegaConstantesFunciones.getClassesForeignKeysOfBodega(new ArrayList<Classe>(),DeepLoadType.NONE);

				bodegaLogic.setBodegas(calidadproducto.bodegas);
				bodegaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroInventarioDefectoConstantesFunciones.getClassesForeignKeysOfParametroInventarioDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametroinventariodefectoLogic.setParametroInventarioDefectos(calidadproducto.parametroinventariodefectos);
				parametroinventariodefectoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(CalidadProducto calidadproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CalidadProductoLogicAdditional.updateCalidadProductoToGet(calidadproducto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		calidadproducto.setBodegas(calidadproductoDataAccess.getBodegas(connexion,calidadproducto));
		calidadproducto.setParametroInventarioDefectos(calidadproductoDataAccess.getParametroInventarioDefectos(connexion,calidadproducto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				calidadproducto.setBodegas(calidadproductoDataAccess.getBodegas(connexion,calidadproducto));

				if(this.isConDeep) {
					BodegaLogic bodegaLogic= new BodegaLogic(this.connexion);
					bodegaLogic.setBodegas(calidadproducto.getBodegas());
					ArrayList<Classe> classesLocal=BodegaConstantesFunciones.getClassesForeignKeysOfBodega(new ArrayList<Classe>(),DeepLoadType.NONE);
					bodegaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(bodegaLogic.getBodegas());
					calidadproducto.setBodegas(bodegaLogic.getBodegas());
				}

				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				calidadproducto.setParametroInventarioDefectos(calidadproductoDataAccess.getParametroInventarioDefectos(connexion,calidadproducto));

				if(this.isConDeep) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(this.connexion);
					parametroinventariodefectoLogic.setParametroInventarioDefectos(calidadproducto.getParametroInventarioDefectos());
					ArrayList<Classe> classesLocal=ParametroInventarioDefectoConstantesFunciones.getClassesForeignKeysOfParametroInventarioDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametroinventariodefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(parametroinventariodefectoLogic.getParametroInventarioDefectos());
					calidadproducto.setParametroInventarioDefectos(parametroinventariodefectoLogic.getParametroInventarioDefectos());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Bodega.class));
			calidadproducto.setBodegas(calidadproductoDataAccess.getBodegas(connexion,calidadproducto));
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
			calidadproducto.setParametroInventarioDefectos(calidadproductoDataAccess.getParametroInventarioDefectos(connexion,calidadproducto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		calidadproducto.setBodegas(calidadproductoDataAccess.getBodegas(connexion,calidadproducto));

		for(Bodega bodega:calidadproducto.getBodegas()) {
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(bodega,isDeep,deepLoadType,clases);
		}

		calidadproducto.setParametroInventarioDefectos(calidadproductoDataAccess.getParametroInventarioDefectos(connexion,calidadproducto));

		for(ParametroInventarioDefecto parametroinventariodefecto:calidadproducto.getParametroInventarioDefectos()) {
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
			parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				calidadproducto.setBodegas(calidadproductoDataAccess.getBodegas(connexion,calidadproducto));

				for(Bodega bodega:calidadproducto.getBodegas()) {
					BodegaLogic bodegaLogic= new BodegaLogic(connexion);
					bodegaLogic.deepLoad(bodega,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				calidadproducto.setParametroInventarioDefectos(calidadproductoDataAccess.getParametroInventarioDefectos(connexion,calidadproducto));

				for(ParametroInventarioDefecto parametroinventariodefecto:calidadproducto.getParametroInventarioDefectos()) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
					parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Bodega.class));
			calidadproducto.setBodegas(calidadproductoDataAccess.getBodegas(connexion,calidadproducto));

			for(Bodega bodega:calidadproducto.getBodegas()) {
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(bodega,isDeep,deepLoadType,clases);
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
			calidadproducto.setParametroInventarioDefectos(calidadproductoDataAccess.getParametroInventarioDefectos(connexion,calidadproducto));

			for(ParametroInventarioDefecto parametroinventariodefecto:calidadproducto.getParametroInventarioDefectos()) {
				ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
				parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CalidadProducto calidadproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CalidadProductoLogicAdditional.updateCalidadProductoToSave(calidadproducto,this.arrDatoGeneral);
			
CalidadProductoDataAccess.save(calidadproducto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Bodega bodega:calidadproducto.getBodegas()) {
			bodega.setid_calidad_producto(calidadproducto.getId());
			BodegaDataAccess.save(bodega,connexion);
		}

		for(ParametroInventarioDefecto parametroinventariodefecto:calidadproducto.getParametroInventarioDefectos()) {
			parametroinventariodefecto.setid_calidad_producto(calidadproducto.getId());
			ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Bodega.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Bodega bodega:calidadproducto.getBodegas()) {
					bodega.setid_calidad_producto(calidadproducto.getId());
					BodegaDataAccess.save(bodega,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroInventarioDefecto parametroinventariodefecto:calidadproducto.getParametroInventarioDefectos()) {
					parametroinventariodefecto.setid_calidad_producto(calidadproducto.getId());
					ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Bodega bodega:calidadproducto.getBodegas()) {
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodega.setid_calidad_producto(calidadproducto.getId());
			BodegaDataAccess.save(bodega,connexion);
			bodegaLogic.deepSave(bodega,isDeep,deepLoadType,clases);
		}

		for(ParametroInventarioDefecto parametroinventariodefecto:calidadproducto.getParametroInventarioDefectos()) {
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
			parametroinventariodefecto.setid_calidad_producto(calidadproducto.getId());
			ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
			parametroinventariodefectoLogic.deepSave(parametroinventariodefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Bodega.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Bodega bodega:calidadproducto.getBodegas()) {
					BodegaLogic bodegaLogic= new BodegaLogic(connexion);
					bodega.setid_calidad_producto(calidadproducto.getId());
					BodegaDataAccess.save(bodega,connexion);
					bodegaLogic.deepSave(bodega,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroInventarioDefecto parametroinventariodefecto:calidadproducto.getParametroInventarioDefectos()) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
					parametroinventariodefecto.setid_calidad_producto(calidadproducto.getId());
					ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
					parametroinventariodefectoLogic.deepSave(parametroinventariodefecto,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(CalidadProducto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(calidadproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(calidadproducto);
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
			this.deepLoad(this.calidadproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(this.calidadproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CalidadProducto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(calidadproductos!=null) {
				for(CalidadProducto calidadproducto:calidadproductos) {
					this.deepLoad(calidadproducto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(calidadproductos);
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
			if(calidadproductos!=null) {
				for(CalidadProducto calidadproducto:calidadproductos) {
					this.deepLoad(calidadproducto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(calidadproductos);
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
			this.getNewConnexionToDeep(CalidadProducto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(calidadproducto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CalidadProducto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(calidadproductos!=null) {
				for(CalidadProducto calidadproducto:calidadproductos) {
					this.deepSave(calidadproducto,isDeep,deepLoadType,clases);
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
			if(calidadproductos!=null) {
				for(CalidadProducto calidadproducto:calidadproductos) {
					this.deepSave(calidadproducto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCalidadProductosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalidadProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",CalidadProductoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			CalidadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calidadproductos=calidadproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(this.calidadproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCalidadProductosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",CalidadProductoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			CalidadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calidadproductos=calidadproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(this.calidadproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCalidadProductosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CalidadProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",CalidadProductoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			CalidadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calidadproductos=calidadproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(this.calidadproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCalidadProductosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",CalidadProductoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			CalidadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			calidadproductos=calidadproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CalidadProductoConstantesFunciones.refrescarForeignKeysDescripcionesCalidadProducto(this.calidadproductos);
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
			if(CalidadProductoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CalidadProductoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CalidadProducto calidadproducto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CalidadProductoConstantesFunciones.ISCONAUDITORIA) {
				if(calidadproducto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CalidadProductoDataAccess.TABLENAME, calidadproducto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CalidadProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CalidadProductoLogic.registrarAuditoriaDetallesCalidadProducto(connexion,calidadproducto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(calidadproducto.getIsDeleted()) {
					/*if(!calidadproducto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CalidadProductoDataAccess.TABLENAME, calidadproducto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CalidadProductoLogic.registrarAuditoriaDetallesCalidadProducto(connexion,calidadproducto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CalidadProductoDataAccess.TABLENAME, calidadproducto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(calidadproducto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CalidadProductoDataAccess.TABLENAME, calidadproducto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CalidadProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CalidadProductoLogic.registrarAuditoriaDetallesCalidadProducto(connexion,calidadproducto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCalidadProducto(Connexion connexion,CalidadProducto calidadproducto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(calidadproducto.getIsNew()||!calidadproducto.getcodigo().equals(calidadproducto.getCalidadProductoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(calidadproducto.getCalidadProductoOriginal().getcodigo()!=null)
				{
					strValorActual=calidadproducto.getCalidadProductoOriginal().getcodigo();
				}
				if(calidadproducto.getcodigo()!=null)
				{
					strValorNuevo=calidadproducto.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CalidadProductoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(calidadproducto.getIsNew()||!calidadproducto.getnombre().equals(calidadproducto.getCalidadProductoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(calidadproducto.getCalidadProductoOriginal().getnombre()!=null)
				{
					strValorActual=calidadproducto.getCalidadProductoOriginal().getnombre();
				}
				if(calidadproducto.getnombre()!=null)
				{
					strValorNuevo=calidadproducto.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CalidadProductoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCalidadProductoRelacionesWithConnection(CalidadProducto calidadproducto,List<Bodega> bodegas,List<ParametroInventarioDefecto> parametroinventariodefectos) throws Exception {

		if(!calidadproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCalidadProductoRelacionesBase(calidadproducto,bodegas,parametroinventariodefectos,true);
		}
	}

	public void saveCalidadProductoRelaciones(CalidadProducto calidadproducto,List<Bodega> bodegas,List<ParametroInventarioDefecto> parametroinventariodefectos)throws Exception {

		if(!calidadproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCalidadProductoRelacionesBase(calidadproducto,bodegas,parametroinventariodefectos,false);
		}
	}

	public void saveCalidadProductoRelacionesBase(CalidadProducto calidadproducto,List<Bodega> bodegas,List<ParametroInventarioDefecto> parametroinventariodefectos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CalidadProducto-saveRelacionesWithConnection");}
	
			calidadproducto.setBodegas(bodegas);
			calidadproducto.setParametroInventarioDefectos(parametroinventariodefectos);

			this.setCalidadProducto(calidadproducto);

				if((calidadproducto.getIsNew()||calidadproducto.getIsChanged())&&!calidadproducto.getIsDeleted()) {
					this.saveCalidadProducto();
					this.saveCalidadProductoRelacionesDetalles(bodegas,parametroinventariodefectos);

				} else if(calidadproducto.getIsDeleted()) {
					this.saveCalidadProductoRelacionesDetalles(bodegas,parametroinventariodefectos);
					this.saveCalidadProducto();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			BodegaConstantesFunciones.InicializarGeneralEntityAuxiliaresBodegas(bodegas,true,true);
			ParametroInventarioDefectoConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroInventarioDefectos(parametroinventariodefectos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveCalidadProductoRelacionesDetalles(List<Bodega> bodegas,List<ParametroInventarioDefecto> parametroinventariodefectos)throws Exception {
		try {
	

			Long idCalidadProductoActual=this.getCalidadProducto().getId();

			BodegaLogic bodegaLogic_Desde_CalidadProducto=new BodegaLogic();
			bodegaLogic_Desde_CalidadProducto.setBodegas(bodegas);

			bodegaLogic_Desde_CalidadProducto.setConnexion(this.getConnexion());
			bodegaLogic_Desde_CalidadProducto.setDatosCliente(this.datosCliente);

			for(Bodega bodega_Desde_CalidadProducto:bodegaLogic_Desde_CalidadProducto.getBodegas()) {
				bodega_Desde_CalidadProducto.setid_calidad_producto(idCalidadProductoActual);
			}

			bodegaLogic_Desde_CalidadProducto.saveBodegas();

			ParametroInventarioDefectoLogic parametroinventariodefectoLogic_Desde_CalidadProducto=new ParametroInventarioDefectoLogic();
			parametroinventariodefectoLogic_Desde_CalidadProducto.setParametroInventarioDefectos(parametroinventariodefectos);

			parametroinventariodefectoLogic_Desde_CalidadProducto.setConnexion(this.getConnexion());
			parametroinventariodefectoLogic_Desde_CalidadProducto.setDatosCliente(this.datosCliente);

			for(ParametroInventarioDefecto parametroinventariodefecto_Desde_CalidadProducto:parametroinventariodefectoLogic_Desde_CalidadProducto.getParametroInventarioDefectos()) {
				parametroinventariodefecto_Desde_CalidadProducto.setid_calidad_producto(idCalidadProductoActual);
			}

			parametroinventariodefectoLogic_Desde_CalidadProducto.saveParametroInventarioDefectos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCalidadProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CalidadProductoConstantesFunciones.getClassesForeignKeysOfCalidadProducto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCalidadProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CalidadProductoConstantesFunciones.getClassesRelationshipsOfCalidadProducto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

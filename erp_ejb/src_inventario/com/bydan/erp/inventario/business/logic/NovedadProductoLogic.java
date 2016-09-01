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
import com.bydan.erp.inventario.util.NovedadProductoConstantesFunciones;
import com.bydan.erp.inventario.util.NovedadProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.NovedadProductoParameterGeneral;
import com.bydan.erp.inventario.business.entity.NovedadProducto;
import com.bydan.erp.inventario.business.logic.NovedadProductoLogicAdditional;
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
public class NovedadProductoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(NovedadProductoLogic.class);
	
	protected NovedadProductoDataAccess novedadproductoDataAccess; 	
	protected NovedadProducto novedadproducto;
	protected List<NovedadProducto> novedadproductos;
	protected Object novedadproductoObject;	
	protected List<Object> novedadproductosObject;
	
	public static ClassValidator<NovedadProducto> novedadproductoValidator = new ClassValidator<NovedadProducto>(NovedadProducto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected NovedadProductoLogicAdditional novedadproductoLogicAdditional=null;
	
	public NovedadProductoLogicAdditional getNovedadProductoLogicAdditional() {
		return this.novedadproductoLogicAdditional;
	}
	
	public void setNovedadProductoLogicAdditional(NovedadProductoLogicAdditional novedadproductoLogicAdditional) {
		try {
			this.novedadproductoLogicAdditional=novedadproductoLogicAdditional;
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
	
	
	
	
	public  NovedadProductoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.novedadproductoDataAccess = new NovedadProductoDataAccess();
			
			this.novedadproductos= new ArrayList<NovedadProducto>();
			this.novedadproducto= new NovedadProducto();
			
			this.novedadproductoObject=new Object();
			this.novedadproductosObject=new ArrayList<Object>();
				
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
			
			this.novedadproductoDataAccess.setConnexionType(this.connexionType);
			this.novedadproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  NovedadProductoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.novedadproductoDataAccess = new NovedadProductoDataAccess();
			this.novedadproductos= new ArrayList<NovedadProducto>();
			this.novedadproducto= new NovedadProducto();
			this.novedadproductoObject=new Object();
			this.novedadproductosObject=new ArrayList<Object>();
			
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
			
			this.novedadproductoDataAccess.setConnexionType(this.connexionType);
			this.novedadproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public NovedadProducto getNovedadProducto() throws Exception {	
		NovedadProductoLogicAdditional.checkNovedadProductoToGet(novedadproducto,this.datosCliente,this.arrDatoGeneral);
		NovedadProductoLogicAdditional.updateNovedadProductoToGet(novedadproducto,this.arrDatoGeneral);
		
		return novedadproducto;
	}
		
	public void setNovedadProducto(NovedadProducto newNovedadProducto) {
		this.novedadproducto = newNovedadProducto;
	}
	
	public NovedadProductoDataAccess getNovedadProductoDataAccess() {
		return novedadproductoDataAccess;
	}
	
	public void setNovedadProductoDataAccess(NovedadProductoDataAccess newnovedadproductoDataAccess) {
		this.novedadproductoDataAccess = newnovedadproductoDataAccess;
	}
	
	public List<NovedadProducto> getNovedadProductos() throws Exception {		
		this.quitarNovedadProductosNulos();
		
		NovedadProductoLogicAdditional.checkNovedadProductoToGets(novedadproductos,this.datosCliente,this.arrDatoGeneral);
		
		for (NovedadProducto novedadproductoLocal: novedadproductos ) {
			NovedadProductoLogicAdditional.updateNovedadProductoToGet(novedadproductoLocal,this.arrDatoGeneral);
		}
		
		return novedadproductos;
	}
	
	public void setNovedadProductos(List<NovedadProducto> newNovedadProductos) {
		this.novedadproductos = newNovedadProductos;
	}
	
	public Object getNovedadProductoObject() {	
		this.novedadproductoObject=this.novedadproductoDataAccess.getEntityObject();
		return this.novedadproductoObject;
	}
		
	public void setNovedadProductoObject(Object newNovedadProductoObject) {
		this.novedadproductoObject = newNovedadProductoObject;
	}
	
	public List<Object> getNovedadProductosObject() {		
		this.novedadproductosObject=this.novedadproductoDataAccess.getEntitiesObject();
		return this.novedadproductosObject;
	}
		
	public void setNovedadProductosObject(List<Object> newNovedadProductosObject) {
		this.novedadproductosObject = newNovedadProductosObject;
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
		
		if(this.novedadproductoDataAccess!=null) {
			this.novedadproductoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			novedadproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			novedadproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		novedadproducto = new  NovedadProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			novedadproducto=novedadproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.novedadproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproducto);
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
		novedadproducto = new  NovedadProducto();
		  		  
        try {
			
			novedadproducto=novedadproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.novedadproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		novedadproducto = new  NovedadProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			novedadproducto=novedadproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.novedadproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproducto);
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
		novedadproducto = new  NovedadProducto();
		  		  
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
		novedadproducto = new  NovedadProducto();
		  		  
        try {
			
			novedadproducto=novedadproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.novedadproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		novedadproducto = new  NovedadProducto();
		  		  
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
		novedadproducto = new  NovedadProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =novedadproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		novedadproducto = new  NovedadProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=novedadproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		novedadproducto = new  NovedadProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =novedadproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		novedadproducto = new  NovedadProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=novedadproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		novedadproducto = new  NovedadProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =novedadproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		novedadproducto = new  NovedadProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=novedadproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		novedadproductos = new  ArrayList<NovedadProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadproductos=novedadproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNovedadProducto(novedadproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproductos);
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
		novedadproductos = new  ArrayList<NovedadProducto>();
		  		  
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
		novedadproductos = new  ArrayList<NovedadProducto>();
		  		  
        try {			
			NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadproductos=novedadproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarNovedadProducto(novedadproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		novedadproductos = new  ArrayList<NovedadProducto>();
		  		  
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
		novedadproductos = new  ArrayList<NovedadProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadproductos=novedadproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNovedadProducto(novedadproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproductos);
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
		novedadproductos = new  ArrayList<NovedadProducto>();
		  		  
        try {
			NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadproductos=novedadproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNovedadProducto(novedadproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproductos);
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
		novedadproductos = new  ArrayList<NovedadProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadproductos=novedadproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNovedadProducto(novedadproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproductos);
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
		novedadproductos = new  ArrayList<NovedadProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadproductos=novedadproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNovedadProducto(novedadproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		novedadproducto = new  NovedadProducto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadproducto=novedadproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNovedadProducto(novedadproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproducto);
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
		novedadproducto = new  NovedadProducto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadproducto=novedadproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNovedadProducto(novedadproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		novedadproductos = new  ArrayList<NovedadProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadproductos=novedadproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNovedadProducto(novedadproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproductos);
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
		novedadproductos = new  ArrayList<NovedadProducto>();
		  		  
        try {
			NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadproductos=novedadproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNovedadProducto(novedadproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosNovedadProductosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		novedadproductos = new  ArrayList<NovedadProducto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-getTodosNovedadProductosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadproductos=novedadproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNovedadProducto(novedadproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproductos);
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
	
	public  void  getTodosNovedadProductos(String sFinalQuery,Pagination pagination)throws Exception {
		novedadproductos = new  ArrayList<NovedadProducto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadproductos=novedadproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNovedadProducto(novedadproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarNovedadProducto(NovedadProducto novedadproducto) throws Exception {
		Boolean estaValidado=false;
		
		if(novedadproducto.getIsNew() || novedadproducto.getIsChanged()) { 
			this.invalidValues = novedadproductoValidator.getInvalidValues(novedadproducto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(novedadproducto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarNovedadProducto(List<NovedadProducto> NovedadProductos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(NovedadProducto novedadproductoLocal:novedadproductos) {				
			estaValidadoObjeto=this.validarGuardarNovedadProducto(novedadproductoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarNovedadProducto(List<NovedadProducto> NovedadProductos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNovedadProducto(novedadproductos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarNovedadProducto(NovedadProducto NovedadProducto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNovedadProducto(novedadproducto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(NovedadProducto novedadproducto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+novedadproducto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=NovedadProductoConstantesFunciones.getNovedadProductoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"novedadproducto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(NovedadProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(NovedadProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveNovedadProductoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-saveNovedadProductoWithConnection");connexion.begin();			
			
			NovedadProductoLogicAdditional.checkNovedadProductoToSave(this.novedadproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NovedadProductoLogicAdditional.updateNovedadProductoToSave(this.novedadproducto,this.arrDatoGeneral);
			
			NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.novedadproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowNovedadProducto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNovedadProducto(this.novedadproducto)) {
				NovedadProductoDataAccess.save(this.novedadproducto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.novedadproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NovedadProductoLogicAdditional.checkNovedadProductoToSaveAfter(this.novedadproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNovedadProducto();
			
			connexion.commit();			
			
			if(this.novedadproducto.getIsDeleted()) {
				this.novedadproducto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveNovedadProducto()throws Exception {	
		try {	
			
			NovedadProductoLogicAdditional.checkNovedadProductoToSave(this.novedadproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NovedadProductoLogicAdditional.updateNovedadProductoToSave(this.novedadproducto,this.arrDatoGeneral);
			
			NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.novedadproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNovedadProducto(this.novedadproducto)) {			
				NovedadProductoDataAccess.save(this.novedadproducto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.novedadproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NovedadProductoLogicAdditional.checkNovedadProductoToSaveAfter(this.novedadproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.novedadproducto.getIsDeleted()) {
				this.novedadproducto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveNovedadProductosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-saveNovedadProductosWithConnection");connexion.begin();			
			
			NovedadProductoLogicAdditional.checkNovedadProductoToSaves(novedadproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowNovedadProductos();
			
			Boolean validadoTodosNovedadProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NovedadProducto novedadproductoLocal:novedadproductos) {		
				if(novedadproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NovedadProductoLogicAdditional.updateNovedadProductoToSave(novedadproductoLocal,this.arrDatoGeneral);
	        	
				NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),novedadproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNovedadProducto(novedadproductoLocal)) {
					NovedadProductoDataAccess.save(novedadproductoLocal, connexion);				
				} else {
					validadoTodosNovedadProducto=false;
				}
			}
			
			if(!validadoTodosNovedadProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NovedadProductoLogicAdditional.checkNovedadProductoToSavesAfter(novedadproductos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNovedadProductos();
			
			connexion.commit();		
			
			this.quitarNovedadProductosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveNovedadProductos()throws Exception {				
		 try {	
			NovedadProductoLogicAdditional.checkNovedadProductoToSaves(novedadproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosNovedadProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NovedadProducto novedadproductoLocal:novedadproductos) {				
				if(novedadproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NovedadProductoLogicAdditional.updateNovedadProductoToSave(novedadproductoLocal,this.arrDatoGeneral);
	        	
				NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),novedadproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNovedadProducto(novedadproductoLocal)) {				
					NovedadProductoDataAccess.save(novedadproductoLocal, connexion);				
				} else {
					validadoTodosNovedadProducto=false;
				}
			}
			
			if(!validadoTodosNovedadProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NovedadProductoLogicAdditional.checkNovedadProductoToSavesAfter(novedadproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarNovedadProductosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NovedadProductoParameterReturnGeneral procesarAccionNovedadProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NovedadProducto> novedadproductos,NovedadProductoParameterReturnGeneral novedadproductoParameterGeneral)throws Exception {
		 try {	
			NovedadProductoParameterReturnGeneral novedadproductoReturnGeneral=new NovedadProductoParameterReturnGeneral();
	
			NovedadProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,novedadproductos,novedadproductoParameterGeneral,novedadproductoReturnGeneral);
			
			return novedadproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NovedadProductoParameterReturnGeneral procesarAccionNovedadProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NovedadProducto> novedadproductos,NovedadProductoParameterReturnGeneral novedadproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-procesarAccionNovedadProductosWithConnection");connexion.begin();			
			
			NovedadProductoParameterReturnGeneral novedadproductoReturnGeneral=new NovedadProductoParameterReturnGeneral();
	
			NovedadProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,novedadproductos,novedadproductoParameterGeneral,novedadproductoReturnGeneral);
			
			this.connexion.commit();
			
			return novedadproductoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NovedadProductoParameterReturnGeneral procesarEventosNovedadProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NovedadProducto> novedadproductos,NovedadProducto novedadproducto,NovedadProductoParameterReturnGeneral novedadproductoParameterGeneral,Boolean isEsNuevoNovedadProducto,ArrayList<Classe> clases)throws Exception {
		 try {	
			NovedadProductoParameterReturnGeneral novedadproductoReturnGeneral=new NovedadProductoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				novedadproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NovedadProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,novedadproductos,novedadproducto,novedadproductoParameterGeneral,novedadproductoReturnGeneral,isEsNuevoNovedadProducto,clases);
			
			return novedadproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public NovedadProductoParameterReturnGeneral procesarEventosNovedadProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NovedadProducto> novedadproductos,NovedadProducto novedadproducto,NovedadProductoParameterReturnGeneral novedadproductoParameterGeneral,Boolean isEsNuevoNovedadProducto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-procesarEventosNovedadProductosWithConnection");connexion.begin();			
			
			NovedadProductoParameterReturnGeneral novedadproductoReturnGeneral=new NovedadProductoParameterReturnGeneral();
	
			novedadproductoReturnGeneral.setNovedadProducto(novedadproducto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				novedadproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NovedadProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,novedadproductos,novedadproducto,novedadproductoParameterGeneral,novedadproductoReturnGeneral,isEsNuevoNovedadProducto,clases);
			
			this.connexion.commit();
			
			return novedadproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NovedadProductoParameterReturnGeneral procesarImportacionNovedadProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,NovedadProductoParameterReturnGeneral novedadproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-procesarImportacionNovedadProductosWithConnection");connexion.begin();			
			
			NovedadProductoParameterReturnGeneral novedadproductoReturnGeneral=new NovedadProductoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.novedadproductos=new ArrayList<NovedadProducto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.novedadproducto=new NovedadProducto();
				
				
				if(conColumnasBase) {this.novedadproducto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.novedadproducto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.novedadproducto.setcodigo(arrColumnas[iColumn++]);
				this.novedadproducto.setnombre(arrColumnas[iColumn++]);
				
				this.novedadproductos.add(this.novedadproducto);
			}
			
			this.saveNovedadProductos();
			
			this.connexion.commit();
			
			novedadproductoReturnGeneral.setConRetornoEstaProcesado(true);
			novedadproductoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return novedadproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarNovedadProductosEliminados() throws Exception {				
		
		List<NovedadProducto> novedadproductosAux= new ArrayList<NovedadProducto>();
		
		for(NovedadProducto novedadproducto:novedadproductos) {
			if(!novedadproducto.getIsDeleted()) {
				novedadproductosAux.add(novedadproducto);
			}
		}
		
		novedadproductos=novedadproductosAux;
	}
	
	public void quitarNovedadProductosNulos() throws Exception {				
		
		List<NovedadProducto> novedadproductosAux= new ArrayList<NovedadProducto>();
		
		for(NovedadProducto novedadproducto : this.novedadproductos) {
			if(novedadproducto==null) {
				novedadproductosAux.add(novedadproducto);
			}
		}
		
		//this.novedadproductos=novedadproductosAux;
		
		this.novedadproductos.removeAll(novedadproductosAux);
	}
	
	public void getSetVersionRowNovedadProductoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(novedadproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((novedadproducto.getIsDeleted() || (novedadproducto.getIsChanged()&&!novedadproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=novedadproductoDataAccess.getSetVersionRowNovedadProducto(connexion,novedadproducto.getId());
				
				if(!novedadproducto.getVersionRow().equals(timestamp)) {	
					novedadproducto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				novedadproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowNovedadProducto()throws Exception {	
		
		if(novedadproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((novedadproducto.getIsDeleted() || (novedadproducto.getIsChanged()&&!novedadproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=novedadproductoDataAccess.getSetVersionRowNovedadProducto(connexion,novedadproducto.getId());
			
			try {							
				if(!novedadproducto.getVersionRow().equals(timestamp)) {	
					novedadproducto.setVersionRow(timestamp);
				}
				
				novedadproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowNovedadProductosWithConnection()throws Exception {	
		if(novedadproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(NovedadProducto novedadproductoAux:novedadproductos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(novedadproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(novedadproductoAux.getIsDeleted() || (novedadproductoAux.getIsChanged()&&!novedadproductoAux.getIsNew())) {
						
						timestamp=novedadproductoDataAccess.getSetVersionRowNovedadProducto(connexion,novedadproductoAux.getId());
						
						if(!novedadproducto.getVersionRow().equals(timestamp)) {	
							novedadproductoAux.setVersionRow(timestamp);
						}
								
						novedadproductoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowNovedadProductos()throws Exception {	
		if(novedadproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(NovedadProducto novedadproductoAux:novedadproductos) {
					if(novedadproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(novedadproductoAux.getIsDeleted() || (novedadproductoAux.getIsChanged()&&!novedadproductoAux.getIsNew())) {
						
						timestamp=novedadproductoDataAccess.getSetVersionRowNovedadProducto(connexion,novedadproductoAux.getId());
						
						if(!novedadproductoAux.getVersionRow().equals(timestamp)) {	
							novedadproductoAux.setVersionRow(timestamp);
						}
						
													
						novedadproductoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public NovedadProductoParameterReturnGeneral cargarCombosLoteForeignKeyNovedadProductoWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		NovedadProductoParameterReturnGeneral  novedadproductoReturnGeneral =new NovedadProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-cargarCombosLoteForeignKeyNovedadProductoWithConnection");connexion.begin();
			
			novedadproductoReturnGeneral =new NovedadProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			novedadproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return novedadproductoReturnGeneral;
	}
	
	public NovedadProductoParameterReturnGeneral cargarCombosLoteForeignKeyNovedadProducto(String finalQueryGlobalEmpresa) throws Exception {
		NovedadProductoParameterReturnGeneral  novedadproductoReturnGeneral =new NovedadProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			novedadproductoReturnGeneral =new NovedadProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			novedadproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return novedadproductoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyNovedadProductoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleFacturaProveedorLogic detallefacturaproveedorLogic=new DetalleFacturaProveedorLogic();
			NovedadSeguimientoLogic novedadseguimientoLogic=new NovedadSeguimientoLogic();
			DetalleTransferenciaLogic detalletransferenciaLogic=new DetalleTransferenciaLogic();
			DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic=new DetalleMovimientoInventarioLogic();
			DetalleOrdenCompraLogic detalleordencompraLogic=new DetalleOrdenCompraLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyNovedadProductoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleFacturaProveedor.class));
			classes.add(new Classe(NovedadSeguimiento.class));
			classes.add(new Classe(DetalleTransferencia.class));
			classes.add(new Classe(DetalleMovimientoInventario.class));
			classes.add(new Classe(DetalleOrdenCompra.class));
											
			

			detallefacturaproveedorLogic.setConnexion(this.getConnexion());
			detallefacturaproveedorLogic.setDatosCliente(this.datosCliente);
			detallefacturaproveedorLogic.setIsConRefrescarForeignKeys(true);

			novedadseguimientoLogic.setConnexion(this.getConnexion());
			novedadseguimientoLogic.setDatosCliente(this.datosCliente);
			novedadseguimientoLogic.setIsConRefrescarForeignKeys(true);

			detalletransferenciaLogic.setConnexion(this.getConnexion());
			detalletransferenciaLogic.setDatosCliente(this.datosCliente);
			detalletransferenciaLogic.setIsConRefrescarForeignKeys(true);

			detallemovimientoinventarioLogic.setConnexion(this.getConnexion());
			detallemovimientoinventarioLogic.setDatosCliente(this.datosCliente);
			detallemovimientoinventarioLogic.setIsConRefrescarForeignKeys(true);

			detalleordencompraLogic.setConnexion(this.getConnexion());
			detalleordencompraLogic.setDatosCliente(this.datosCliente);
			detalleordencompraLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(NovedadProducto novedadproducto:this.novedadproductos) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleFacturaProveedorConstantesFunciones.getClassesForeignKeysOfDetalleFacturaProveedor(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallefacturaproveedorLogic.setDetalleFacturaProveedors(novedadproducto.detallefacturaproveedors);
				detallefacturaproveedorLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=NovedadSeguimientoConstantesFunciones.getClassesForeignKeysOfNovedadSeguimiento(new ArrayList<Classe>(),DeepLoadType.NONE);

				novedadseguimientoLogic.setNovedadSeguimientos(novedadproducto.novedadseguimientos);
				novedadseguimientoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetalleTransferenciaConstantesFunciones.getClassesForeignKeysOfDetalleTransferencia(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalletransferenciaLogic.setDetalleTransferencias(novedadproducto.detalletransferencias);
				detalletransferenciaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetalleMovimientoInventarioConstantesFunciones.getClassesForeignKeysOfDetalleMovimientoInventario(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallemovimientoinventarioLogic.setDetalleMovimientoInventarios(novedadproducto.detallemovimientoinventarios);
				detallemovimientoinventarioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetalleOrdenCompraConstantesFunciones.getClassesForeignKeysOfDetalleOrdenCompra(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleordencompraLogic.setDetalleOrdenCompras(novedadproducto.detalleordencompras);
				detalleordencompraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(NovedadProducto novedadproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			NovedadProductoLogicAdditional.updateNovedadProductoToGet(novedadproducto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		novedadproducto.setEmpresa(novedadproductoDataAccess.getEmpresa(connexion,novedadproducto));
		novedadproducto.setDetalleFacturaProveedors(novedadproductoDataAccess.getDetalleFacturaProveedors(connexion,novedadproducto));
		novedadproducto.setNovedadSeguimientos(novedadproductoDataAccess.getNovedadSeguimientos(connexion,novedadproducto));
		novedadproducto.setDetalleTransferencias(novedadproductoDataAccess.getDetalleTransferencias(connexion,novedadproducto));
		novedadproducto.setDetalleMovimientoInventarios(novedadproductoDataAccess.getDetalleMovimientoInventarios(connexion,novedadproducto));
		novedadproducto.setDetalleOrdenCompras(novedadproductoDataAccess.getDetalleOrdenCompras(connexion,novedadproducto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				novedadproducto.setEmpresa(novedadproductoDataAccess.getEmpresa(connexion,novedadproducto));
				continue;
			}

			if(clas.clas.equals(DetalleFacturaProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				novedadproducto.setDetalleFacturaProveedors(novedadproductoDataAccess.getDetalleFacturaProveedors(connexion,novedadproducto));

				if(this.isConDeep) {
					DetalleFacturaProveedorLogic detallefacturaproveedorLogic= new DetalleFacturaProveedorLogic(this.connexion);
					detallefacturaproveedorLogic.setDetalleFacturaProveedors(novedadproducto.getDetalleFacturaProveedors());
					ArrayList<Classe> classesLocal=DetalleFacturaProveedorConstantesFunciones.getClassesForeignKeysOfDetalleFacturaProveedor(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallefacturaproveedorLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(detallefacturaproveedorLogic.getDetalleFacturaProveedors());
					novedadproducto.setDetalleFacturaProveedors(detallefacturaproveedorLogic.getDetalleFacturaProveedors());
				}

				continue;
			}

			if(clas.clas.equals(NovedadSeguimiento.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				novedadproducto.setNovedadSeguimientos(novedadproductoDataAccess.getNovedadSeguimientos(connexion,novedadproducto));

				if(this.isConDeep) {
					NovedadSeguimientoLogic novedadseguimientoLogic= new NovedadSeguimientoLogic(this.connexion);
					novedadseguimientoLogic.setNovedadSeguimientos(novedadproducto.getNovedadSeguimientos());
					ArrayList<Classe> classesLocal=NovedadSeguimientoConstantesFunciones.getClassesForeignKeysOfNovedadSeguimiento(new ArrayList<Classe>(),DeepLoadType.NONE);
					novedadseguimientoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(novedadseguimientoLogic.getNovedadSeguimientos());
					novedadproducto.setNovedadSeguimientos(novedadseguimientoLogic.getNovedadSeguimientos());
				}

				continue;
			}

			if(clas.clas.equals(DetalleTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				novedadproducto.setDetalleTransferencias(novedadproductoDataAccess.getDetalleTransferencias(connexion,novedadproducto));

				if(this.isConDeep) {
					DetalleTransferenciaLogic detalletransferenciaLogic= new DetalleTransferenciaLogic(this.connexion);
					detalletransferenciaLogic.setDetalleTransferencias(novedadproducto.getDetalleTransferencias());
					ArrayList<Classe> classesLocal=DetalleTransferenciaConstantesFunciones.getClassesForeignKeysOfDetalleTransferencia(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalletransferenciaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTransferencia(detalletransferenciaLogic.getDetalleTransferencias());
					novedadproducto.setDetalleTransferencias(detalletransferenciaLogic.getDetalleTransferencias());
				}

				continue;
			}

			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				novedadproducto.setDetalleMovimientoInventarios(novedadproductoDataAccess.getDetalleMovimientoInventarios(connexion,novedadproducto));

				if(this.isConDeep) {
					DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(this.connexion);
					detallemovimientoinventarioLogic.setDetalleMovimientoInventarios(novedadproducto.getDetalleMovimientoInventarios());
					ArrayList<Classe> classesLocal=DetalleMovimientoInventarioConstantesFunciones.getClassesForeignKeysOfDetalleMovimientoInventario(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallemovimientoinventarioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(detallemovimientoinventarioLogic.getDetalleMovimientoInventarios());
					novedadproducto.setDetalleMovimientoInventarios(detallemovimientoinventarioLogic.getDetalleMovimientoInventarios());
				}

				continue;
			}

			if(clas.clas.equals(DetalleOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				novedadproducto.setDetalleOrdenCompras(novedadproductoDataAccess.getDetalleOrdenCompras(connexion,novedadproducto));

				if(this.isConDeep) {
					DetalleOrdenCompraLogic detalleordencompraLogic= new DetalleOrdenCompraLogic(this.connexion);
					detalleordencompraLogic.setDetalleOrdenCompras(novedadproducto.getDetalleOrdenCompras());
					ArrayList<Classe> classesLocal=DetalleOrdenCompraConstantesFunciones.getClassesForeignKeysOfDetalleOrdenCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleordencompraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(detalleordencompraLogic.getDetalleOrdenCompras());
					novedadproducto.setDetalleOrdenCompras(detalleordencompraLogic.getDetalleOrdenCompras());
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
			novedadproducto.setEmpresa(novedadproductoDataAccess.getEmpresa(connexion,novedadproducto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleFacturaProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleFacturaProveedor.class));
			novedadproducto.setDetalleFacturaProveedors(novedadproductoDataAccess.getDetalleFacturaProveedors(connexion,novedadproducto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadSeguimiento.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NovedadSeguimiento.class));
			novedadproducto.setNovedadSeguimientos(novedadproductoDataAccess.getNovedadSeguimientos(connexion,novedadproducto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleTransferencia.class));
			novedadproducto.setDetalleTransferencias(novedadproductoDataAccess.getDetalleTransferencias(connexion,novedadproducto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleMovimientoInventario.class));
			novedadproducto.setDetalleMovimientoInventarios(novedadproductoDataAccess.getDetalleMovimientoInventarios(connexion,novedadproducto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleOrdenCompra.class));
			novedadproducto.setDetalleOrdenCompras(novedadproductoDataAccess.getDetalleOrdenCompras(connexion,novedadproducto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		novedadproducto.setEmpresa(novedadproductoDataAccess.getEmpresa(connexion,novedadproducto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(novedadproducto.getEmpresa(),isDeep,deepLoadType,clases);
				

		novedadproducto.setDetalleFacturaProveedors(novedadproductoDataAccess.getDetalleFacturaProveedors(connexion,novedadproducto));

		for(DetalleFacturaProveedor detallefacturaproveedor:novedadproducto.getDetalleFacturaProveedors()) {
			DetalleFacturaProveedorLogic detallefacturaproveedorLogic= new DetalleFacturaProveedorLogic(connexion);
			detallefacturaproveedorLogic.deepLoad(detallefacturaproveedor,isDeep,deepLoadType,clases);
		}

		novedadproducto.setNovedadSeguimientos(novedadproductoDataAccess.getNovedadSeguimientos(connexion,novedadproducto));

		for(NovedadSeguimiento novedadseguimiento:novedadproducto.getNovedadSeguimientos()) {
			NovedadSeguimientoLogic novedadseguimientoLogic= new NovedadSeguimientoLogic(connexion);
			novedadseguimientoLogic.deepLoad(novedadseguimiento,isDeep,deepLoadType,clases);
		}

		novedadproducto.setDetalleTransferencias(novedadproductoDataAccess.getDetalleTransferencias(connexion,novedadproducto));

		for(DetalleTransferencia detalletransferencia:novedadproducto.getDetalleTransferencias()) {
			DetalleTransferenciaLogic detalletransferenciaLogic= new DetalleTransferenciaLogic(connexion);
			detalletransferenciaLogic.deepLoad(detalletransferencia,isDeep,deepLoadType,clases);
		}

		novedadproducto.setDetalleMovimientoInventarios(novedadproductoDataAccess.getDetalleMovimientoInventarios(connexion,novedadproducto));

		for(DetalleMovimientoInventario detallemovimientoinventario:novedadproducto.getDetalleMovimientoInventarios()) {
			DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
			detallemovimientoinventarioLogic.deepLoad(detallemovimientoinventario,isDeep,deepLoadType,clases);
		}

		novedadproducto.setDetalleOrdenCompras(novedadproductoDataAccess.getDetalleOrdenCompras(connexion,novedadproducto));

		for(DetalleOrdenCompra detalleordencompra:novedadproducto.getDetalleOrdenCompras()) {
			DetalleOrdenCompraLogic detalleordencompraLogic= new DetalleOrdenCompraLogic(connexion);
			detalleordencompraLogic.deepLoad(detalleordencompra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				novedadproducto.setEmpresa(novedadproductoDataAccess.getEmpresa(connexion,novedadproducto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(novedadproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleFacturaProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				novedadproducto.setDetalleFacturaProveedors(novedadproductoDataAccess.getDetalleFacturaProveedors(connexion,novedadproducto));

				for(DetalleFacturaProveedor detallefacturaproveedor:novedadproducto.getDetalleFacturaProveedors()) {
					DetalleFacturaProveedorLogic detallefacturaproveedorLogic= new DetalleFacturaProveedorLogic(connexion);
					detallefacturaproveedorLogic.deepLoad(detallefacturaproveedor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NovedadSeguimiento.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				novedadproducto.setNovedadSeguimientos(novedadproductoDataAccess.getNovedadSeguimientos(connexion,novedadproducto));

				for(NovedadSeguimiento novedadseguimiento:novedadproducto.getNovedadSeguimientos()) {
					NovedadSeguimientoLogic novedadseguimientoLogic= new NovedadSeguimientoLogic(connexion);
					novedadseguimientoLogic.deepLoad(novedadseguimiento,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				novedadproducto.setDetalleTransferencias(novedadproductoDataAccess.getDetalleTransferencias(connexion,novedadproducto));

				for(DetalleTransferencia detalletransferencia:novedadproducto.getDetalleTransferencias()) {
					DetalleTransferenciaLogic detalletransferenciaLogic= new DetalleTransferenciaLogic(connexion);
					detalletransferenciaLogic.deepLoad(detalletransferencia,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				novedadproducto.setDetalleMovimientoInventarios(novedadproductoDataAccess.getDetalleMovimientoInventarios(connexion,novedadproducto));

				for(DetalleMovimientoInventario detallemovimientoinventario:novedadproducto.getDetalleMovimientoInventarios()) {
					DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
					detallemovimientoinventarioLogic.deepLoad(detallemovimientoinventario,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				novedadproducto.setDetalleOrdenCompras(novedadproductoDataAccess.getDetalleOrdenCompras(connexion,novedadproducto));

				for(DetalleOrdenCompra detalleordencompra:novedadproducto.getDetalleOrdenCompras()) {
					DetalleOrdenCompraLogic detalleordencompraLogic= new DetalleOrdenCompraLogic(connexion);
					detalleordencompraLogic.deepLoad(detalleordencompra,isDeep,deepLoadType,clases);
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
			novedadproducto.setEmpresa(novedadproductoDataAccess.getEmpresa(connexion,novedadproducto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(novedadproducto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleFacturaProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleFacturaProveedor.class));
			novedadproducto.setDetalleFacturaProveedors(novedadproductoDataAccess.getDetalleFacturaProveedors(connexion,novedadproducto));

			for(DetalleFacturaProveedor detallefacturaproveedor:novedadproducto.getDetalleFacturaProveedors()) {
				DetalleFacturaProveedorLogic detallefacturaproveedorLogic= new DetalleFacturaProveedorLogic(connexion);
				detallefacturaproveedorLogic.deepLoad(detallefacturaproveedor,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadSeguimiento.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NovedadSeguimiento.class));
			novedadproducto.setNovedadSeguimientos(novedadproductoDataAccess.getNovedadSeguimientos(connexion,novedadproducto));

			for(NovedadSeguimiento novedadseguimiento:novedadproducto.getNovedadSeguimientos()) {
				NovedadSeguimientoLogic novedadseguimientoLogic= new NovedadSeguimientoLogic(connexion);
				novedadseguimientoLogic.deepLoad(novedadseguimiento,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleTransferencia.class));
			novedadproducto.setDetalleTransferencias(novedadproductoDataAccess.getDetalleTransferencias(connexion,novedadproducto));

			for(DetalleTransferencia detalletransferencia:novedadproducto.getDetalleTransferencias()) {
				DetalleTransferenciaLogic detalletransferenciaLogic= new DetalleTransferenciaLogic(connexion);
				detalletransferenciaLogic.deepLoad(detalletransferencia,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleMovimientoInventario.class));
			novedadproducto.setDetalleMovimientoInventarios(novedadproductoDataAccess.getDetalleMovimientoInventarios(connexion,novedadproducto));

			for(DetalleMovimientoInventario detallemovimientoinventario:novedadproducto.getDetalleMovimientoInventarios()) {
				DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
				detallemovimientoinventarioLogic.deepLoad(detallemovimientoinventario,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleOrdenCompra.class));
			novedadproducto.setDetalleOrdenCompras(novedadproductoDataAccess.getDetalleOrdenCompras(connexion,novedadproducto));

			for(DetalleOrdenCompra detalleordencompra:novedadproducto.getDetalleOrdenCompras()) {
				DetalleOrdenCompraLogic detalleordencompraLogic= new DetalleOrdenCompraLogic(connexion);
				detalleordencompraLogic.deepLoad(detalleordencompra,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(NovedadProducto novedadproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			NovedadProductoLogicAdditional.updateNovedadProductoToSave(novedadproducto,this.arrDatoGeneral);
			
NovedadProductoDataAccess.save(novedadproducto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(novedadproducto.getEmpresa(),connexion);

		for(DetalleFacturaProveedor detallefacturaproveedor:novedadproducto.getDetalleFacturaProveedors()) {
			detallefacturaproveedor.setid_novedad_producto(novedadproducto.getId());
			DetalleFacturaProveedorDataAccess.save(detallefacturaproveedor,connexion);
		}

		for(NovedadSeguimiento novedadseguimiento:novedadproducto.getNovedadSeguimientos()) {
			novedadseguimiento.setid_novedad_producto(novedadproducto.getId());
			NovedadSeguimientoDataAccess.save(novedadseguimiento,connexion);
		}

		for(DetalleTransferencia detalletransferencia:novedadproducto.getDetalleTransferencias()) {
			detalletransferencia.setid_novedad_producto(novedadproducto.getId());
			DetalleTransferenciaDataAccess.save(detalletransferencia,connexion);
		}

		for(DetalleMovimientoInventario detallemovimientoinventario:novedadproducto.getDetalleMovimientoInventarios()) {
			detallemovimientoinventario.setid_novedad_producto(novedadproducto.getId());
			DetalleMovimientoInventarioDataAccess.save(detallemovimientoinventario,connexion);
		}

		for(DetalleOrdenCompra detalleordencompra:novedadproducto.getDetalleOrdenCompras()) {
			detalleordencompra.setid_novedad_producto(novedadproducto.getId());
			DetalleOrdenCompraDataAccess.save(detalleordencompra,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(novedadproducto.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleFacturaProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleFacturaProveedor detallefacturaproveedor:novedadproducto.getDetalleFacturaProveedors()) {
					detallefacturaproveedor.setid_novedad_producto(novedadproducto.getId());
					DetalleFacturaProveedorDataAccess.save(detallefacturaproveedor,connexion);
				}
				continue;
			}

			if(clas.clas.equals(NovedadSeguimiento.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NovedadSeguimiento novedadseguimiento:novedadproducto.getNovedadSeguimientos()) {
					novedadseguimiento.setid_novedad_producto(novedadproducto.getId());
					NovedadSeguimientoDataAccess.save(novedadseguimiento,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetalleTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleTransferencia detalletransferencia:novedadproducto.getDetalleTransferencias()) {
					detalletransferencia.setid_novedad_producto(novedadproducto.getId());
					DetalleTransferenciaDataAccess.save(detalletransferencia,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleMovimientoInventario detallemovimientoinventario:novedadproducto.getDetalleMovimientoInventarios()) {
					detallemovimientoinventario.setid_novedad_producto(novedadproducto.getId());
					DetalleMovimientoInventarioDataAccess.save(detallemovimientoinventario,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetalleOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleOrdenCompra detalleordencompra:novedadproducto.getDetalleOrdenCompras()) {
					detalleordencompra.setid_novedad_producto(novedadproducto.getId());
					DetalleOrdenCompraDataAccess.save(detalleordencompra,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(novedadproducto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(novedadproducto.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(DetalleFacturaProveedor detallefacturaproveedor:novedadproducto.getDetalleFacturaProveedors()) {
			DetalleFacturaProveedorLogic detallefacturaproveedorLogic= new DetalleFacturaProveedorLogic(connexion);
			detallefacturaproveedor.setid_novedad_producto(novedadproducto.getId());
			DetalleFacturaProveedorDataAccess.save(detallefacturaproveedor,connexion);
			detallefacturaproveedorLogic.deepSave(detallefacturaproveedor,isDeep,deepLoadType,clases);
		}

		for(NovedadSeguimiento novedadseguimiento:novedadproducto.getNovedadSeguimientos()) {
			NovedadSeguimientoLogic novedadseguimientoLogic= new NovedadSeguimientoLogic(connexion);
			novedadseguimiento.setid_novedad_producto(novedadproducto.getId());
			NovedadSeguimientoDataAccess.save(novedadseguimiento,connexion);
			novedadseguimientoLogic.deepSave(novedadseguimiento,isDeep,deepLoadType,clases);
		}

		for(DetalleTransferencia detalletransferencia:novedadproducto.getDetalleTransferencias()) {
			DetalleTransferenciaLogic detalletransferenciaLogic= new DetalleTransferenciaLogic(connexion);
			detalletransferencia.setid_novedad_producto(novedadproducto.getId());
			DetalleTransferenciaDataAccess.save(detalletransferencia,connexion);
			detalletransferenciaLogic.deepSave(detalletransferencia,isDeep,deepLoadType,clases);
		}

		for(DetalleMovimientoInventario detallemovimientoinventario:novedadproducto.getDetalleMovimientoInventarios()) {
			DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
			detallemovimientoinventario.setid_novedad_producto(novedadproducto.getId());
			DetalleMovimientoInventarioDataAccess.save(detallemovimientoinventario,connexion);
			detallemovimientoinventarioLogic.deepSave(detallemovimientoinventario,isDeep,deepLoadType,clases);
		}

		for(DetalleOrdenCompra detalleordencompra:novedadproducto.getDetalleOrdenCompras()) {
			DetalleOrdenCompraLogic detalleordencompraLogic= new DetalleOrdenCompraLogic(connexion);
			detalleordencompra.setid_novedad_producto(novedadproducto.getId());
			DetalleOrdenCompraDataAccess.save(detalleordencompra,connexion);
			detalleordencompraLogic.deepSave(detalleordencompra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(novedadproducto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(novedadproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleFacturaProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleFacturaProveedor detallefacturaproveedor:novedadproducto.getDetalleFacturaProveedors()) {
					DetalleFacturaProveedorLogic detallefacturaproveedorLogic= new DetalleFacturaProveedorLogic(connexion);
					detallefacturaproveedor.setid_novedad_producto(novedadproducto.getId());
					DetalleFacturaProveedorDataAccess.save(detallefacturaproveedor,connexion);
					detallefacturaproveedorLogic.deepSave(detallefacturaproveedor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NovedadSeguimiento.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NovedadSeguimiento novedadseguimiento:novedadproducto.getNovedadSeguimientos()) {
					NovedadSeguimientoLogic novedadseguimientoLogic= new NovedadSeguimientoLogic(connexion);
					novedadseguimiento.setid_novedad_producto(novedadproducto.getId());
					NovedadSeguimientoDataAccess.save(novedadseguimiento,connexion);
					novedadseguimientoLogic.deepSave(novedadseguimiento,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleTransferencia detalletransferencia:novedadproducto.getDetalleTransferencias()) {
					DetalleTransferenciaLogic detalletransferenciaLogic= new DetalleTransferenciaLogic(connexion);
					detalletransferencia.setid_novedad_producto(novedadproducto.getId());
					DetalleTransferenciaDataAccess.save(detalletransferencia,connexion);
					detalletransferenciaLogic.deepSave(detalletransferencia,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleMovimientoInventario detallemovimientoinventario:novedadproducto.getDetalleMovimientoInventarios()) {
					DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
					detallemovimientoinventario.setid_novedad_producto(novedadproducto.getId());
					DetalleMovimientoInventarioDataAccess.save(detallemovimientoinventario,connexion);
					detallemovimientoinventarioLogic.deepSave(detallemovimientoinventario,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleOrdenCompra detalleordencompra:novedadproducto.getDetalleOrdenCompras()) {
					DetalleOrdenCompraLogic detalleordencompraLogic= new DetalleOrdenCompraLogic(connexion);
					detalleordencompra.setid_novedad_producto(novedadproducto.getId());
					DetalleOrdenCompraDataAccess.save(detalleordencompra,connexion);
					detalleordencompraLogic.deepSave(detalleordencompra,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(NovedadProducto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(novedadproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(novedadproducto);
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
			this.deepLoad(this.novedadproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(NovedadProducto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(novedadproductos!=null) {
				for(NovedadProducto novedadproducto:novedadproductos) {
					this.deepLoad(novedadproducto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(novedadproductos);
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
			if(novedadproductos!=null) {
				for(NovedadProducto novedadproducto:novedadproductos) {
					this.deepLoad(novedadproducto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(novedadproductos);
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
			this.getNewConnexionToDeep(NovedadProducto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(novedadproducto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(NovedadProducto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(novedadproductos!=null) {
				for(NovedadProducto novedadproducto:novedadproductos) {
					this.deepSave(novedadproducto,isDeep,deepLoadType,clases);
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
			if(novedadproductos!=null) {
				for(NovedadProducto novedadproducto:novedadproductos) {
					this.deepSave(novedadproducto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getNovedadProductosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",NovedadProductoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadproductos=novedadproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNovedadProductosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",NovedadProductoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadproductos=novedadproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNovedadProductosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",NovedadProductoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadproductos=novedadproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNovedadProductosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",NovedadProductoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadproductos=novedadproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNovedadProductosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NovedadProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadproductos=novedadproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNovedadProductosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NovedadProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NovedadProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadproductos=novedadproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadProductoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadProducto(this.novedadproductos);
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
			if(NovedadProductoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,NovedadProductoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,NovedadProducto novedadproducto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(NovedadProductoConstantesFunciones.ISCONAUDITORIA) {
				if(novedadproducto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NovedadProductoDataAccess.TABLENAME, novedadproducto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NovedadProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NovedadProductoLogic.registrarAuditoriaDetallesNovedadProducto(connexion,novedadproducto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(novedadproducto.getIsDeleted()) {
					/*if(!novedadproducto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,NovedadProductoDataAccess.TABLENAME, novedadproducto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////NovedadProductoLogic.registrarAuditoriaDetallesNovedadProducto(connexion,novedadproducto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NovedadProductoDataAccess.TABLENAME, novedadproducto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(novedadproducto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NovedadProductoDataAccess.TABLENAME, novedadproducto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NovedadProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NovedadProductoLogic.registrarAuditoriaDetallesNovedadProducto(connexion,novedadproducto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesNovedadProducto(Connexion connexion,NovedadProducto novedadproducto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(novedadproducto.getIsNew()||!novedadproducto.getid_empresa().equals(novedadproducto.getNovedadProductoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadproducto.getNovedadProductoOriginal().getid_empresa()!=null)
				{
					strValorActual=novedadproducto.getNovedadProductoOriginal().getid_empresa().toString();
				}
				if(novedadproducto.getid_empresa()!=null)
				{
					strValorNuevo=novedadproducto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadProductoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(novedadproducto.getIsNew()||!novedadproducto.getcodigo().equals(novedadproducto.getNovedadProductoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadproducto.getNovedadProductoOriginal().getcodigo()!=null)
				{
					strValorActual=novedadproducto.getNovedadProductoOriginal().getcodigo();
				}
				if(novedadproducto.getcodigo()!=null)
				{
					strValorNuevo=novedadproducto.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadProductoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(novedadproducto.getIsNew()||!novedadproducto.getnombre().equals(novedadproducto.getNovedadProductoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadproducto.getNovedadProductoOriginal().getnombre()!=null)
				{
					strValorActual=novedadproducto.getNovedadProductoOriginal().getnombre();
				}
				if(novedadproducto.getnombre()!=null)
				{
					strValorNuevo=novedadproducto.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadProductoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveNovedadProductoRelacionesWithConnection(NovedadProducto novedadproducto,List<DetalleFacturaProveedor> detallefacturaproveedors,List<NovedadSeguimiento> novedadseguimientos,List<DetalleTransferencia> detalletransferencias,List<DetalleMovimientoInventario> detallemovimientoinventarios,List<DetalleOrdenCompra> detalleordencompras) throws Exception {

		if(!novedadproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNovedadProductoRelacionesBase(novedadproducto,detallefacturaproveedors,novedadseguimientos,detalletransferencias,detallemovimientoinventarios,detalleordencompras,true);
		}
	}

	public void saveNovedadProductoRelaciones(NovedadProducto novedadproducto,List<DetalleFacturaProveedor> detallefacturaproveedors,List<NovedadSeguimiento> novedadseguimientos,List<DetalleTransferencia> detalletransferencias,List<DetalleMovimientoInventario> detallemovimientoinventarios,List<DetalleOrdenCompra> detalleordencompras)throws Exception {

		if(!novedadproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNovedadProductoRelacionesBase(novedadproducto,detallefacturaproveedors,novedadseguimientos,detalletransferencias,detallemovimientoinventarios,detalleordencompras,false);
		}
	}

	public void saveNovedadProductoRelacionesBase(NovedadProducto novedadproducto,List<DetalleFacturaProveedor> detallefacturaproveedors,List<NovedadSeguimiento> novedadseguimientos,List<DetalleTransferencia> detalletransferencias,List<DetalleMovimientoInventario> detallemovimientoinventarios,List<DetalleOrdenCompra> detalleordencompras,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("NovedadProducto-saveRelacionesWithConnection");}
	
			novedadproducto.setDetalleFacturaProveedors(detallefacturaproveedors);
			novedadproducto.setNovedadSeguimientos(novedadseguimientos);
			novedadproducto.setDetalleTransferencias(detalletransferencias);
			novedadproducto.setDetalleMovimientoInventarios(detallemovimientoinventarios);
			novedadproducto.setDetalleOrdenCompras(detalleordencompras);

			this.setNovedadProducto(novedadproducto);

			if(NovedadProductoLogicAdditional.validarSaveRelaciones(novedadproducto,this)) {

				NovedadProductoLogicAdditional.updateRelacionesToSave(novedadproducto,this);

				if((novedadproducto.getIsNew()||novedadproducto.getIsChanged())&&!novedadproducto.getIsDeleted()) {
					this.saveNovedadProducto();
					this.saveNovedadProductoRelacionesDetalles(detallefacturaproveedors,novedadseguimientos,detalletransferencias,detallemovimientoinventarios,detalleordencompras);

				} else if(novedadproducto.getIsDeleted()) {
					this.saveNovedadProductoRelacionesDetalles(detallefacturaproveedors,novedadseguimientos,detalletransferencias,detallemovimientoinventarios,detalleordencompras);
					this.saveNovedadProducto();
				}

				NovedadProductoLogicAdditional.updateRelacionesToSaveAfter(novedadproducto,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleFacturaProveedorConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleFacturaProveedors(detallefacturaproveedors,true,true);
			NovedadSeguimientoConstantesFunciones.InicializarGeneralEntityAuxiliaresNovedadSeguimientos(novedadseguimientos,true,true);
			DetalleTransferenciaConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleTransferencias(detalletransferencias,true,true);
			DetalleMovimientoInventarioConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleMovimientoInventarios(detallemovimientoinventarios,true,true);
			DetalleOrdenCompraConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleOrdenCompras(detalleordencompras,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveNovedadProductoRelacionesDetalles(List<DetalleFacturaProveedor> detallefacturaproveedors,List<NovedadSeguimiento> novedadseguimientos,List<DetalleTransferencia> detalletransferencias,List<DetalleMovimientoInventario> detallemovimientoinventarios,List<DetalleOrdenCompra> detalleordencompras)throws Exception {
		try {
	

			Long idNovedadProductoActual=this.getNovedadProducto().getId();

			DetalleFacturaProveedorLogic detallefacturaproveedorLogic_Desde_NovedadProducto=new DetalleFacturaProveedorLogic();
			detallefacturaproveedorLogic_Desde_NovedadProducto.setDetalleFacturaProveedors(detallefacturaproveedors);

			detallefacturaproveedorLogic_Desde_NovedadProducto.setConnexion(this.getConnexion());
			detallefacturaproveedorLogic_Desde_NovedadProducto.setDatosCliente(this.datosCliente);

			for(DetalleFacturaProveedor detallefacturaproveedor_Desde_NovedadProducto:detallefacturaproveedorLogic_Desde_NovedadProducto.getDetalleFacturaProveedors()) {
				detallefacturaproveedor_Desde_NovedadProducto.setid_novedad_producto(idNovedadProductoActual);
			}

			detallefacturaproveedorLogic_Desde_NovedadProducto.saveDetalleFacturaProveedors();

			NovedadSeguimientoLogic novedadseguimientoLogic_Desde_NovedadProducto=new NovedadSeguimientoLogic();
			novedadseguimientoLogic_Desde_NovedadProducto.setNovedadSeguimientos(novedadseguimientos);

			novedadseguimientoLogic_Desde_NovedadProducto.setConnexion(this.getConnexion());
			novedadseguimientoLogic_Desde_NovedadProducto.setDatosCliente(this.datosCliente);

			for(NovedadSeguimiento novedadseguimiento_Desde_NovedadProducto:novedadseguimientoLogic_Desde_NovedadProducto.getNovedadSeguimientos()) {
				novedadseguimiento_Desde_NovedadProducto.setid_novedad_producto(idNovedadProductoActual);
			}

			novedadseguimientoLogic_Desde_NovedadProducto.saveNovedadSeguimientos();

			DetalleTransferenciaLogic detalletransferenciaLogic_Desde_NovedadProducto=new DetalleTransferenciaLogic();
			detalletransferenciaLogic_Desde_NovedadProducto.setDetalleTransferencias(detalletransferencias);

			detalletransferenciaLogic_Desde_NovedadProducto.setConnexion(this.getConnexion());
			detalletransferenciaLogic_Desde_NovedadProducto.setDatosCliente(this.datosCliente);

			for(DetalleTransferencia detalletransferencia_Desde_NovedadProducto:detalletransferenciaLogic_Desde_NovedadProducto.getDetalleTransferencias()) {
				detalletransferencia_Desde_NovedadProducto.setid_novedad_producto(idNovedadProductoActual);
			}

			detalletransferenciaLogic_Desde_NovedadProducto.saveDetalleTransferencias();

			DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic_Desde_NovedadProducto=new DetalleMovimientoInventarioLogic();
			detallemovimientoinventarioLogic_Desde_NovedadProducto.setDetalleMovimientoInventarios(detallemovimientoinventarios);

			detallemovimientoinventarioLogic_Desde_NovedadProducto.setConnexion(this.getConnexion());
			detallemovimientoinventarioLogic_Desde_NovedadProducto.setDatosCliente(this.datosCliente);

			for(DetalleMovimientoInventario detallemovimientoinventario_Desde_NovedadProducto:detallemovimientoinventarioLogic_Desde_NovedadProducto.getDetalleMovimientoInventarios()) {
				detallemovimientoinventario_Desde_NovedadProducto.setid_novedad_producto(idNovedadProductoActual);

				detallemovimientoinventarioLogic_Desde_NovedadProducto.setDetalleMovimientoInventario(detallemovimientoinventario_Desde_NovedadProducto);
				detallemovimientoinventarioLogic_Desde_NovedadProducto.saveDetalleMovimientoInventario();

				Long idDetalleMovimientoInventarioActual=detallemovimientoinventario_Desde_NovedadProducto.getId();

				NovedadSeguimientoLogic novedadseguimientoLogic_Desde_DetalleMovimientoInventario=new NovedadSeguimientoLogic();

				if(detallemovimientoinventario_Desde_NovedadProducto.getNovedadSeguimientos()==null){
					detallemovimientoinventario_Desde_NovedadProducto.setNovedadSeguimientos(new ArrayList<NovedadSeguimiento>());
				}

				novedadseguimientoLogic_Desde_DetalleMovimientoInventario.setNovedadSeguimientos(detallemovimientoinventario_Desde_NovedadProducto.getNovedadSeguimientos());

				novedadseguimientoLogic_Desde_DetalleMovimientoInventario.setConnexion(this.getConnexion());
				novedadseguimientoLogic_Desde_DetalleMovimientoInventario.setDatosCliente(this.datosCliente);

				for(NovedadSeguimiento novedadseguimiento_Desde_DetalleMovimientoInventario:novedadseguimientoLogic_Desde_DetalleMovimientoInventario.getNovedadSeguimientos()) {
					novedadseguimiento_Desde_DetalleMovimientoInventario.setid_detalle_movimiento_inventario(idDetalleMovimientoInventarioActual);
				}

				novedadseguimientoLogic_Desde_DetalleMovimientoInventario.saveNovedadSeguimientos();
			}


			DetalleOrdenCompraLogic detalleordencompraLogic_Desde_NovedadProducto=new DetalleOrdenCompraLogic();
			detalleordencompraLogic_Desde_NovedadProducto.setDetalleOrdenCompras(detalleordencompras);

			detalleordencompraLogic_Desde_NovedadProducto.setConnexion(this.getConnexion());
			detalleordencompraLogic_Desde_NovedadProducto.setDatosCliente(this.datosCliente);

			for(DetalleOrdenCompra detalleordencompra_Desde_NovedadProducto:detalleordencompraLogic_Desde_NovedadProducto.getDetalleOrdenCompras()) {
				detalleordencompra_Desde_NovedadProducto.setid_novedad_producto(idNovedadProductoActual);
			}

			detalleordencompraLogic_Desde_NovedadProducto.saveDetalleOrdenCompras();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfNovedadProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NovedadProductoConstantesFunciones.getClassesForeignKeysOfNovedadProducto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNovedadProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NovedadProductoConstantesFunciones.getClassesRelationshipsOfNovedadProducto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

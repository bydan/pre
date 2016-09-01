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
import com.bydan.erp.inventario.util.MarcaProductoConstantesFunciones;
import com.bydan.erp.inventario.util.MarcaProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.MarcaProductoParameterGeneral;
import com.bydan.erp.inventario.business.entity.MarcaProducto;
import com.bydan.erp.inventario.business.logic.MarcaProductoLogicAdditional;
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
public class MarcaProductoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(MarcaProductoLogic.class);
	
	protected MarcaProductoDataAccess marcaproductoDataAccess; 	
	protected MarcaProducto marcaproducto;
	protected List<MarcaProducto> marcaproductos;
	protected Object marcaproductoObject;	
	protected List<Object> marcaproductosObject;
	
	public static ClassValidator<MarcaProducto> marcaproductoValidator = new ClassValidator<MarcaProducto>(MarcaProducto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected MarcaProductoLogicAdditional marcaproductoLogicAdditional=null;
	
	public MarcaProductoLogicAdditional getMarcaProductoLogicAdditional() {
		return this.marcaproductoLogicAdditional;
	}
	
	public void setMarcaProductoLogicAdditional(MarcaProductoLogicAdditional marcaproductoLogicAdditional) {
		try {
			this.marcaproductoLogicAdditional=marcaproductoLogicAdditional;
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
	
	
	
	
	public  MarcaProductoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.marcaproductoDataAccess = new MarcaProductoDataAccess();
			
			this.marcaproductos= new ArrayList<MarcaProducto>();
			this.marcaproducto= new MarcaProducto();
			
			this.marcaproductoObject=new Object();
			this.marcaproductosObject=new ArrayList<Object>();
				
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
			
			this.marcaproductoDataAccess.setConnexionType(this.connexionType);
			this.marcaproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  MarcaProductoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.marcaproductoDataAccess = new MarcaProductoDataAccess();
			this.marcaproductos= new ArrayList<MarcaProducto>();
			this.marcaproducto= new MarcaProducto();
			this.marcaproductoObject=new Object();
			this.marcaproductosObject=new ArrayList<Object>();
			
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
			
			this.marcaproductoDataAccess.setConnexionType(this.connexionType);
			this.marcaproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public MarcaProducto getMarcaProducto() throws Exception {	
		MarcaProductoLogicAdditional.checkMarcaProductoToGet(marcaproducto,this.datosCliente,this.arrDatoGeneral);
		MarcaProductoLogicAdditional.updateMarcaProductoToGet(marcaproducto,this.arrDatoGeneral);
		
		return marcaproducto;
	}
		
	public void setMarcaProducto(MarcaProducto newMarcaProducto) {
		this.marcaproducto = newMarcaProducto;
	}
	
	public MarcaProductoDataAccess getMarcaProductoDataAccess() {
		return marcaproductoDataAccess;
	}
	
	public void setMarcaProductoDataAccess(MarcaProductoDataAccess newmarcaproductoDataAccess) {
		this.marcaproductoDataAccess = newmarcaproductoDataAccess;
	}
	
	public List<MarcaProducto> getMarcaProductos() throws Exception {		
		this.quitarMarcaProductosNulos();
		
		MarcaProductoLogicAdditional.checkMarcaProductoToGets(marcaproductos,this.datosCliente,this.arrDatoGeneral);
		
		for (MarcaProducto marcaproductoLocal: marcaproductos ) {
			MarcaProductoLogicAdditional.updateMarcaProductoToGet(marcaproductoLocal,this.arrDatoGeneral);
		}
		
		return marcaproductos;
	}
	
	public void setMarcaProductos(List<MarcaProducto> newMarcaProductos) {
		this.marcaproductos = newMarcaProductos;
	}
	
	public Object getMarcaProductoObject() {	
		this.marcaproductoObject=this.marcaproductoDataAccess.getEntityObject();
		return this.marcaproductoObject;
	}
		
	public void setMarcaProductoObject(Object newMarcaProductoObject) {
		this.marcaproductoObject = newMarcaProductoObject;
	}
	
	public List<Object> getMarcaProductosObject() {		
		this.marcaproductosObject=this.marcaproductoDataAccess.getEntitiesObject();
		return this.marcaproductosObject;
	}
		
	public void setMarcaProductosObject(List<Object> newMarcaProductosObject) {
		this.marcaproductosObject = newMarcaProductosObject;
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
		
		if(this.marcaproductoDataAccess!=null) {
			this.marcaproductoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			marcaproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			marcaproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		marcaproducto = new  MarcaProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			marcaproducto=marcaproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.marcaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproducto);
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
		marcaproducto = new  MarcaProducto();
		  		  
        try {
			
			marcaproducto=marcaproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.marcaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		marcaproducto = new  MarcaProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			marcaproducto=marcaproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.marcaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproducto);
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
		marcaproducto = new  MarcaProducto();
		  		  
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
		marcaproducto = new  MarcaProducto();
		  		  
        try {
			
			marcaproducto=marcaproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.marcaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		marcaproducto = new  MarcaProducto();
		  		  
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
		marcaproducto = new  MarcaProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =marcaproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		marcaproducto = new  MarcaProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=marcaproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		marcaproducto = new  MarcaProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =marcaproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		marcaproducto = new  MarcaProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=marcaproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		marcaproducto = new  MarcaProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =marcaproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		marcaproducto = new  MarcaProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=marcaproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		marcaproductos = new  ArrayList<MarcaProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			marcaproductos=marcaproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMarcaProducto(marcaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproductos);
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
		marcaproductos = new  ArrayList<MarcaProducto>();
		  		  
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
		marcaproductos = new  ArrayList<MarcaProducto>();
		  		  
        try {			
			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			marcaproductos=marcaproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarMarcaProducto(marcaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		marcaproductos = new  ArrayList<MarcaProducto>();
		  		  
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
		marcaproductos = new  ArrayList<MarcaProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			marcaproductos=marcaproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMarcaProducto(marcaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproductos);
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
		marcaproductos = new  ArrayList<MarcaProducto>();
		  		  
        try {
			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			marcaproductos=marcaproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMarcaProducto(marcaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproductos);
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
		marcaproductos = new  ArrayList<MarcaProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			marcaproductos=marcaproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMarcaProducto(marcaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproductos);
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
		marcaproductos = new  ArrayList<MarcaProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			marcaproductos=marcaproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMarcaProducto(marcaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		marcaproducto = new  MarcaProducto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			marcaproducto=marcaproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMarcaProducto(marcaproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproducto);
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
		marcaproducto = new  MarcaProducto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			marcaproducto=marcaproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMarcaProducto(marcaproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		marcaproductos = new  ArrayList<MarcaProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			marcaproductos=marcaproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMarcaProducto(marcaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproductos);
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
		marcaproductos = new  ArrayList<MarcaProducto>();
		  		  
        try {
			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			marcaproductos=marcaproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMarcaProducto(marcaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosMarcaProductosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		marcaproductos = new  ArrayList<MarcaProducto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-getTodosMarcaProductosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			marcaproductos=marcaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarMarcaProducto(marcaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproductos);
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
	
	public  void  getTodosMarcaProductos(String sFinalQuery,Pagination pagination)throws Exception {
		marcaproductos = new  ArrayList<MarcaProducto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			marcaproductos=marcaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarMarcaProducto(marcaproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarMarcaProducto(MarcaProducto marcaproducto) throws Exception {
		Boolean estaValidado=false;
		
		if(marcaproducto.getIsNew() || marcaproducto.getIsChanged()) { 
			this.invalidValues = marcaproductoValidator.getInvalidValues(marcaproducto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(marcaproducto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarMarcaProducto(List<MarcaProducto> MarcaProductos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(MarcaProducto marcaproductoLocal:marcaproductos) {				
			estaValidadoObjeto=this.validarGuardarMarcaProducto(marcaproductoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarMarcaProducto(List<MarcaProducto> MarcaProductos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarMarcaProducto(marcaproductos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarMarcaProducto(MarcaProducto MarcaProducto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarMarcaProducto(marcaproducto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(MarcaProducto marcaproducto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+marcaproducto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=MarcaProductoConstantesFunciones.getMarcaProductoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"marcaproducto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(MarcaProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(MarcaProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveMarcaProductoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-saveMarcaProductoWithConnection");connexion.begin();			
			
			MarcaProductoLogicAdditional.checkMarcaProductoToSave(this.marcaproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			MarcaProductoLogicAdditional.updateMarcaProductoToSave(this.marcaproducto,this.arrDatoGeneral);
			
			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.marcaproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowMarcaProducto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarMarcaProducto(this.marcaproducto)) {
				MarcaProductoDataAccess.save(this.marcaproducto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.marcaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			MarcaProductoLogicAdditional.checkMarcaProductoToSaveAfter(this.marcaproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowMarcaProducto();
			
			connexion.commit();			
			
			if(this.marcaproducto.getIsDeleted()) {
				this.marcaproducto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveMarcaProducto()throws Exception {	
		try {	
			
			MarcaProductoLogicAdditional.checkMarcaProductoToSave(this.marcaproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			MarcaProductoLogicAdditional.updateMarcaProductoToSave(this.marcaproducto,this.arrDatoGeneral);
			
			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.marcaproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarMarcaProducto(this.marcaproducto)) {			
				MarcaProductoDataAccess.save(this.marcaproducto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.marcaproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			MarcaProductoLogicAdditional.checkMarcaProductoToSaveAfter(this.marcaproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.marcaproducto.getIsDeleted()) {
				this.marcaproducto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveMarcaProductosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-saveMarcaProductosWithConnection");connexion.begin();			
			
			MarcaProductoLogicAdditional.checkMarcaProductoToSaves(marcaproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowMarcaProductos();
			
			Boolean validadoTodosMarcaProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(MarcaProducto marcaproductoLocal:marcaproductos) {		
				if(marcaproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				MarcaProductoLogicAdditional.updateMarcaProductoToSave(marcaproductoLocal,this.arrDatoGeneral);
	        	
				MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),marcaproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarMarcaProducto(marcaproductoLocal)) {
					MarcaProductoDataAccess.save(marcaproductoLocal, connexion);				
				} else {
					validadoTodosMarcaProducto=false;
				}
			}
			
			if(!validadoTodosMarcaProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			MarcaProductoLogicAdditional.checkMarcaProductoToSavesAfter(marcaproductos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowMarcaProductos();
			
			connexion.commit();		
			
			this.quitarMarcaProductosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveMarcaProductos()throws Exception {				
		 try {	
			MarcaProductoLogicAdditional.checkMarcaProductoToSaves(marcaproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosMarcaProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(MarcaProducto marcaproductoLocal:marcaproductos) {				
				if(marcaproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				MarcaProductoLogicAdditional.updateMarcaProductoToSave(marcaproductoLocal,this.arrDatoGeneral);
	        	
				MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),marcaproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarMarcaProducto(marcaproductoLocal)) {				
					MarcaProductoDataAccess.save(marcaproductoLocal, connexion);				
				} else {
					validadoTodosMarcaProducto=false;
				}
			}
			
			if(!validadoTodosMarcaProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			MarcaProductoLogicAdditional.checkMarcaProductoToSavesAfter(marcaproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarMarcaProductosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public MarcaProductoParameterReturnGeneral procesarAccionMarcaProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MarcaProducto> marcaproductos,MarcaProductoParameterReturnGeneral marcaproductoParameterGeneral)throws Exception {
		 try {	
			MarcaProductoParameterReturnGeneral marcaproductoReturnGeneral=new MarcaProductoParameterReturnGeneral();
	
			MarcaProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,marcaproductos,marcaproductoParameterGeneral,marcaproductoReturnGeneral);
			
			return marcaproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public MarcaProductoParameterReturnGeneral procesarAccionMarcaProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MarcaProducto> marcaproductos,MarcaProductoParameterReturnGeneral marcaproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-procesarAccionMarcaProductosWithConnection");connexion.begin();			
			
			MarcaProductoParameterReturnGeneral marcaproductoReturnGeneral=new MarcaProductoParameterReturnGeneral();
	
			MarcaProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,marcaproductos,marcaproductoParameterGeneral,marcaproductoReturnGeneral);
			
			this.connexion.commit();
			
			return marcaproductoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public MarcaProductoParameterReturnGeneral procesarEventosMarcaProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<MarcaProducto> marcaproductos,MarcaProducto marcaproducto,MarcaProductoParameterReturnGeneral marcaproductoParameterGeneral,Boolean isEsNuevoMarcaProducto,ArrayList<Classe> clases)throws Exception {
		 try {	
			MarcaProductoParameterReturnGeneral marcaproductoReturnGeneral=new MarcaProductoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				marcaproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			MarcaProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,marcaproductos,marcaproducto,marcaproductoParameterGeneral,marcaproductoReturnGeneral,isEsNuevoMarcaProducto,clases);
			
			return marcaproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public MarcaProductoParameterReturnGeneral procesarEventosMarcaProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<MarcaProducto> marcaproductos,MarcaProducto marcaproducto,MarcaProductoParameterReturnGeneral marcaproductoParameterGeneral,Boolean isEsNuevoMarcaProducto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-procesarEventosMarcaProductosWithConnection");connexion.begin();			
			
			MarcaProductoParameterReturnGeneral marcaproductoReturnGeneral=new MarcaProductoParameterReturnGeneral();
	
			marcaproductoReturnGeneral.setMarcaProducto(marcaproducto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				marcaproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			MarcaProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,marcaproductos,marcaproducto,marcaproductoParameterGeneral,marcaproductoReturnGeneral,isEsNuevoMarcaProducto,clases);
			
			this.connexion.commit();
			
			return marcaproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public MarcaProductoParameterReturnGeneral procesarImportacionMarcaProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,MarcaProductoParameterReturnGeneral marcaproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-procesarImportacionMarcaProductosWithConnection");connexion.begin();			
			
			MarcaProductoParameterReturnGeneral marcaproductoReturnGeneral=new MarcaProductoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.marcaproductos=new ArrayList<MarcaProducto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.marcaproducto=new MarcaProducto();
				
				
				if(conColumnasBase) {this.marcaproducto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.marcaproducto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.marcaproducto.setcodigo(arrColumnas[iColumn++]);
				this.marcaproducto.setnombre(arrColumnas[iColumn++]);
				
				this.marcaproductos.add(this.marcaproducto);
			}
			
			this.saveMarcaProductos();
			
			this.connexion.commit();
			
			marcaproductoReturnGeneral.setConRetornoEstaProcesado(true);
			marcaproductoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return marcaproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarMarcaProductosEliminados() throws Exception {				
		
		List<MarcaProducto> marcaproductosAux= new ArrayList<MarcaProducto>();
		
		for(MarcaProducto marcaproducto:marcaproductos) {
			if(!marcaproducto.getIsDeleted()) {
				marcaproductosAux.add(marcaproducto);
			}
		}
		
		marcaproductos=marcaproductosAux;
	}
	
	public void quitarMarcaProductosNulos() throws Exception {				
		
		List<MarcaProducto> marcaproductosAux= new ArrayList<MarcaProducto>();
		
		for(MarcaProducto marcaproducto : this.marcaproductos) {
			if(marcaproducto==null) {
				marcaproductosAux.add(marcaproducto);
			}
		}
		
		//this.marcaproductos=marcaproductosAux;
		
		this.marcaproductos.removeAll(marcaproductosAux);
	}
	
	public void getSetVersionRowMarcaProductoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(marcaproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((marcaproducto.getIsDeleted() || (marcaproducto.getIsChanged()&&!marcaproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=marcaproductoDataAccess.getSetVersionRowMarcaProducto(connexion,marcaproducto.getId());
				
				if(!marcaproducto.getVersionRow().equals(timestamp)) {	
					marcaproducto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				marcaproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowMarcaProducto()throws Exception {	
		
		if(marcaproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((marcaproducto.getIsDeleted() || (marcaproducto.getIsChanged()&&!marcaproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=marcaproductoDataAccess.getSetVersionRowMarcaProducto(connexion,marcaproducto.getId());
			
			try {							
				if(!marcaproducto.getVersionRow().equals(timestamp)) {	
					marcaproducto.setVersionRow(timestamp);
				}
				
				marcaproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowMarcaProductosWithConnection()throws Exception {	
		if(marcaproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(MarcaProducto marcaproductoAux:marcaproductos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(marcaproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(marcaproductoAux.getIsDeleted() || (marcaproductoAux.getIsChanged()&&!marcaproductoAux.getIsNew())) {
						
						timestamp=marcaproductoDataAccess.getSetVersionRowMarcaProducto(connexion,marcaproductoAux.getId());
						
						if(!marcaproducto.getVersionRow().equals(timestamp)) {	
							marcaproductoAux.setVersionRow(timestamp);
						}
								
						marcaproductoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowMarcaProductos()throws Exception {	
		if(marcaproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(MarcaProducto marcaproductoAux:marcaproductos) {
					if(marcaproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(marcaproductoAux.getIsDeleted() || (marcaproductoAux.getIsChanged()&&!marcaproductoAux.getIsNew())) {
						
						timestamp=marcaproductoDataAccess.getSetVersionRowMarcaProducto(connexion,marcaproductoAux.getId());
						
						if(!marcaproductoAux.getVersionRow().equals(timestamp)) {	
							marcaproductoAux.setVersionRow(timestamp);
						}
						
													
						marcaproductoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public MarcaProductoParameterReturnGeneral cargarCombosLoteForeignKeyMarcaProductoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoProducto) throws Exception {
		MarcaProductoParameterReturnGeneral  marcaproductoReturnGeneral =new MarcaProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-cargarCombosLoteForeignKeyMarcaProductoWithConnection");connexion.begin();
			
			marcaproductoReturnGeneral =new MarcaProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			marcaproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoProducto> tipoproductosForeignKey=new ArrayList<TipoProducto>();
			TipoProductoLogic tipoproductoLogic=new TipoProductoLogic();
			tipoproductoLogic.setConnexion(this.connexion);
			tipoproductoLogic.getTipoProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProducto.equals("NONE")) {
				tipoproductoLogic.getTodosTipoProductos(finalQueryGlobalTipoProducto,new Pagination());
				tipoproductosForeignKey=tipoproductoLogic.getTipoProductos();
			}

			marcaproductoReturnGeneral.settipoproductosForeignKey(tipoproductosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return marcaproductoReturnGeneral;
	}
	
	public MarcaProductoParameterReturnGeneral cargarCombosLoteForeignKeyMarcaProducto(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoProducto) throws Exception {
		MarcaProductoParameterReturnGeneral  marcaproductoReturnGeneral =new MarcaProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			marcaproductoReturnGeneral =new MarcaProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			marcaproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoProducto> tipoproductosForeignKey=new ArrayList<TipoProducto>();
			TipoProductoLogic tipoproductoLogic=new TipoProductoLogic();
			tipoproductoLogic.setConnexion(this.connexion);
			tipoproductoLogic.getTipoProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProducto.equals("NONE")) {
				tipoproductoLogic.getTodosTipoProductos(finalQueryGlobalTipoProducto,new Pagination());
				tipoproductosForeignKey=tipoproductoLogic.getTipoProductos();
			}

			marcaproductoReturnGeneral.settipoproductosForeignKey(tipoproductosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return marcaproductoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyMarcaProductoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ProductoLogic productoLogic=new ProductoLogic();
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic=new ParametroInventarioDefectoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyMarcaProductoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Producto.class));
			classes.add(new Classe(ParametroInventarioDefecto.class));
											
			

			productoLogic.setConnexion(this.getConnexion());
			productoLogic.setDatosCliente(this.datosCliente);
			productoLogic.setIsConRefrescarForeignKeys(true);

			parametroinventariodefectoLogic.setConnexion(this.getConnexion());
			parametroinventariodefectoLogic.setDatosCliente(this.datosCliente);
			parametroinventariodefectoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(MarcaProducto marcaproducto:this.marcaproductos) {
				

				classes=new ArrayList<Classe>();
				classes=ProductoConstantesFunciones.getClassesForeignKeysOfProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoLogic.setProductos(marcaproducto.productos);
				productoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroInventarioDefectoConstantesFunciones.getClassesForeignKeysOfParametroInventarioDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametroinventariodefectoLogic.setParametroInventarioDefectos(marcaproducto.parametroinventariodefectos);
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
	
	public void deepLoad(MarcaProducto marcaproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			MarcaProductoLogicAdditional.updateMarcaProductoToGet(marcaproducto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		marcaproducto.setEmpresa(marcaproductoDataAccess.getEmpresa(connexion,marcaproducto));
		marcaproducto.setTipoProducto(marcaproductoDataAccess.getTipoProducto(connexion,marcaproducto));
		marcaproducto.setProductos(marcaproductoDataAccess.getProductos(connexion,marcaproducto));
		marcaproducto.setParametroInventarioDefectos(marcaproductoDataAccess.getParametroInventarioDefectos(connexion,marcaproducto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				marcaproducto.setEmpresa(marcaproductoDataAccess.getEmpresa(connexion,marcaproducto));
				continue;
			}

			if(clas.clas.equals(TipoProducto.class)) {
				marcaproducto.setTipoProducto(marcaproductoDataAccess.getTipoProducto(connexion,marcaproducto));
				continue;
			}

			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				marcaproducto.setProductos(marcaproductoDataAccess.getProductos(connexion,marcaproducto));

				if(this.isConDeep) {
					ProductoLogic productoLogic= new ProductoLogic(this.connexion);
					productoLogic.setProductos(marcaproducto.getProductos());
					ArrayList<Classe> classesLocal=ProductoConstantesFunciones.getClassesForeignKeysOfProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(productoLogic.getProductos());
					marcaproducto.setProductos(productoLogic.getProductos());
				}

				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				marcaproducto.setParametroInventarioDefectos(marcaproductoDataAccess.getParametroInventarioDefectos(connexion,marcaproducto));

				if(this.isConDeep) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(this.connexion);
					parametroinventariodefectoLogic.setParametroInventarioDefectos(marcaproducto.getParametroInventarioDefectos());
					ArrayList<Classe> classesLocal=ParametroInventarioDefectoConstantesFunciones.getClassesForeignKeysOfParametroInventarioDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametroinventariodefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(parametroinventariodefectoLogic.getParametroInventarioDefectos());
					marcaproducto.setParametroInventarioDefectos(parametroinventariodefectoLogic.getParametroInventarioDefectos());
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
			marcaproducto.setEmpresa(marcaproductoDataAccess.getEmpresa(connexion,marcaproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			marcaproducto.setTipoProducto(marcaproductoDataAccess.getTipoProducto(connexion,marcaproducto));
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
			marcaproducto.setProductos(marcaproductoDataAccess.getProductos(connexion,marcaproducto));
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
			marcaproducto.setParametroInventarioDefectos(marcaproductoDataAccess.getParametroInventarioDefectos(connexion,marcaproducto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		marcaproducto.setEmpresa(marcaproductoDataAccess.getEmpresa(connexion,marcaproducto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(marcaproducto.getEmpresa(),isDeep,deepLoadType,clases);
				
		marcaproducto.setTipoProducto(marcaproductoDataAccess.getTipoProducto(connexion,marcaproducto));
		TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
		tipoproductoLogic.deepLoad(marcaproducto.getTipoProducto(),isDeep,deepLoadType,clases);
				

		marcaproducto.setProductos(marcaproductoDataAccess.getProductos(connexion,marcaproducto));

		for(Producto producto:marcaproducto.getProductos()) {
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(producto,isDeep,deepLoadType,clases);
		}

		marcaproducto.setParametroInventarioDefectos(marcaproductoDataAccess.getParametroInventarioDefectos(connexion,marcaproducto));

		for(ParametroInventarioDefecto parametroinventariodefecto:marcaproducto.getParametroInventarioDefectos()) {
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
			parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				marcaproducto.setEmpresa(marcaproductoDataAccess.getEmpresa(connexion,marcaproducto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(marcaproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProducto.class)) {
				marcaproducto.setTipoProducto(marcaproductoDataAccess.getTipoProducto(connexion,marcaproducto));
				TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
				tipoproductoLogic.deepLoad(marcaproducto.getTipoProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				marcaproducto.setProductos(marcaproductoDataAccess.getProductos(connexion,marcaproducto));

				for(Producto producto:marcaproducto.getProductos()) {
					ProductoLogic productoLogic= new ProductoLogic(connexion);
					productoLogic.deepLoad(producto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				marcaproducto.setParametroInventarioDefectos(marcaproductoDataAccess.getParametroInventarioDefectos(connexion,marcaproducto));

				for(ParametroInventarioDefecto parametroinventariodefecto:marcaproducto.getParametroInventarioDefectos()) {
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
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			marcaproducto.setEmpresa(marcaproductoDataAccess.getEmpresa(connexion,marcaproducto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(marcaproducto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			marcaproducto.setTipoProducto(marcaproductoDataAccess.getTipoProducto(connexion,marcaproducto));
			TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
			tipoproductoLogic.deepLoad(marcaproducto.getTipoProducto(),isDeep,deepLoadType,clases);
				
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
			marcaproducto.setProductos(marcaproductoDataAccess.getProductos(connexion,marcaproducto));

			for(Producto producto:marcaproducto.getProductos()) {
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(producto,isDeep,deepLoadType,clases);
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
			marcaproducto.setParametroInventarioDefectos(marcaproductoDataAccess.getParametroInventarioDefectos(connexion,marcaproducto));

			for(ParametroInventarioDefecto parametroinventariodefecto:marcaproducto.getParametroInventarioDefectos()) {
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
	
	public void deepSave(MarcaProducto marcaproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			MarcaProductoLogicAdditional.updateMarcaProductoToSave(marcaproducto,this.arrDatoGeneral);
			
MarcaProductoDataAccess.save(marcaproducto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(marcaproducto.getEmpresa(),connexion);

		TipoProductoDataAccess.save(marcaproducto.getTipoProducto(),connexion);

		for(Producto producto:marcaproducto.getProductos()) {
			producto.setid_marca_producto(marcaproducto.getId());
			ProductoDataAccess.save(producto,connexion);
		}

		for(ParametroInventarioDefecto parametroinventariodefecto:marcaproducto.getParametroInventarioDefectos()) {
			parametroinventariodefecto.setid_marca_producto(marcaproducto.getId());
			ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(marcaproducto.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoProducto.class)) {
				TipoProductoDataAccess.save(marcaproducto.getTipoProducto(),connexion);
				continue;
			}


			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Producto producto:marcaproducto.getProductos()) {
					producto.setid_marca_producto(marcaproducto.getId());
					ProductoDataAccess.save(producto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroInventarioDefecto parametroinventariodefecto:marcaproducto.getParametroInventarioDefectos()) {
					parametroinventariodefecto.setid_marca_producto(marcaproducto.getId());
					ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(marcaproducto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(marcaproducto.getEmpresa(),isDeep,deepLoadType,clases);
				

		TipoProductoDataAccess.save(marcaproducto.getTipoProducto(),connexion);
		TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
		tipoproductoLogic.deepLoad(marcaproducto.getTipoProducto(),isDeep,deepLoadType,clases);
				

		for(Producto producto:marcaproducto.getProductos()) {
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			producto.setid_marca_producto(marcaproducto.getId());
			ProductoDataAccess.save(producto,connexion);
			productoLogic.deepSave(producto,isDeep,deepLoadType,clases);
		}

		for(ParametroInventarioDefecto parametroinventariodefecto:marcaproducto.getParametroInventarioDefectos()) {
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
			parametroinventariodefecto.setid_marca_producto(marcaproducto.getId());
			ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
			parametroinventariodefectoLogic.deepSave(parametroinventariodefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(marcaproducto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(marcaproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProducto.class)) {
				TipoProductoDataAccess.save(marcaproducto.getTipoProducto(),connexion);
				TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
				tipoproductoLogic.deepSave(marcaproducto.getTipoProducto(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Producto producto:marcaproducto.getProductos()) {
					ProductoLogic productoLogic= new ProductoLogic(connexion);
					producto.setid_marca_producto(marcaproducto.getId());
					ProductoDataAccess.save(producto,connexion);
					productoLogic.deepSave(producto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroInventarioDefecto parametroinventariodefecto:marcaproducto.getParametroInventarioDefectos()) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
					parametroinventariodefecto.setid_marca_producto(marcaproducto.getId());
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
			this.getNewConnexionToDeep(MarcaProducto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(marcaproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(marcaproducto);
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
			this.deepLoad(this.marcaproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(MarcaProducto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(marcaproductos!=null) {
				for(MarcaProducto marcaproducto:marcaproductos) {
					this.deepLoad(marcaproducto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(marcaproductos);
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
			if(marcaproductos!=null) {
				for(MarcaProducto marcaproducto:marcaproductos) {
					this.deepLoad(marcaproducto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(marcaproductos);
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
			this.getNewConnexionToDeep(MarcaProducto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(marcaproducto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(MarcaProducto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(marcaproductos!=null) {
				for(MarcaProducto marcaproducto:marcaproductos) {
					this.deepSave(marcaproducto,isDeep,deepLoadType,clases);
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
			if(marcaproductos!=null) {
				for(MarcaProducto marcaproducto:marcaproductos) {
					this.deepSave(marcaproducto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getMarcaProductosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",MarcaProductoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			marcaproductos=marcaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMarcaProductosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",MarcaProductoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			marcaproductos=marcaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMarcaProductosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",MarcaProductoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			marcaproductos=marcaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMarcaProductosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",MarcaProductoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			marcaproductos=marcaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMarcaProductosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,MarcaProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			marcaproductos=marcaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMarcaProductosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,MarcaProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			marcaproductos=marcaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMarcaProductosFK_IdTipoProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MarcaProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto,MarcaProductoConstantesFunciones.IDTIPOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProducto);

			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			marcaproductos=marcaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMarcaProductosFK_IdTipoProducto(String sFinalQuery,Pagination pagination,Long id_tipo_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto,MarcaProductoConstantesFunciones.IDTIPOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProducto);

			MarcaProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			marcaproductos=marcaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MarcaProductoConstantesFunciones.refrescarForeignKeysDescripcionesMarcaProducto(this.marcaproductos);
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
			if(MarcaProductoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,MarcaProductoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,MarcaProducto marcaproducto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(MarcaProductoConstantesFunciones.ISCONAUDITORIA) {
				if(marcaproducto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MarcaProductoDataAccess.TABLENAME, marcaproducto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(MarcaProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////MarcaProductoLogic.registrarAuditoriaDetallesMarcaProducto(connexion,marcaproducto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(marcaproducto.getIsDeleted()) {
					/*if(!marcaproducto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,MarcaProductoDataAccess.TABLENAME, marcaproducto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////MarcaProductoLogic.registrarAuditoriaDetallesMarcaProducto(connexion,marcaproducto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MarcaProductoDataAccess.TABLENAME, marcaproducto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(marcaproducto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MarcaProductoDataAccess.TABLENAME, marcaproducto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(MarcaProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////MarcaProductoLogic.registrarAuditoriaDetallesMarcaProducto(connexion,marcaproducto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesMarcaProducto(Connexion connexion,MarcaProducto marcaproducto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(marcaproducto.getIsNew()||!marcaproducto.getid_empresa().equals(marcaproducto.getMarcaProductoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(marcaproducto.getMarcaProductoOriginal().getid_empresa()!=null)
				{
					strValorActual=marcaproducto.getMarcaProductoOriginal().getid_empresa().toString();
				}
				if(marcaproducto.getid_empresa()!=null)
				{
					strValorNuevo=marcaproducto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MarcaProductoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(marcaproducto.getIsNew()||!marcaproducto.getid_tipo_producto().equals(marcaproducto.getMarcaProductoOriginal().getid_tipo_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(marcaproducto.getMarcaProductoOriginal().getid_tipo_producto()!=null)
				{
					strValorActual=marcaproducto.getMarcaProductoOriginal().getid_tipo_producto().toString();
				}
				if(marcaproducto.getid_tipo_producto()!=null)
				{
					strValorNuevo=marcaproducto.getid_tipo_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MarcaProductoConstantesFunciones.IDTIPOPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(marcaproducto.getIsNew()||!marcaproducto.getcodigo().equals(marcaproducto.getMarcaProductoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(marcaproducto.getMarcaProductoOriginal().getcodigo()!=null)
				{
					strValorActual=marcaproducto.getMarcaProductoOriginal().getcodigo();
				}
				if(marcaproducto.getcodigo()!=null)
				{
					strValorNuevo=marcaproducto.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MarcaProductoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(marcaproducto.getIsNew()||!marcaproducto.getnombre().equals(marcaproducto.getMarcaProductoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(marcaproducto.getMarcaProductoOriginal().getnombre()!=null)
				{
					strValorActual=marcaproducto.getMarcaProductoOriginal().getnombre();
				}
				if(marcaproducto.getnombre()!=null)
				{
					strValorNuevo=marcaproducto.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MarcaProductoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveMarcaProductoRelacionesWithConnection(MarcaProducto marcaproducto,List<Producto> productos,List<ParametroInventarioDefecto> parametroinventariodefectos) throws Exception {

		if(!marcaproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveMarcaProductoRelacionesBase(marcaproducto,productos,parametroinventariodefectos,true);
		}
	}

	public void saveMarcaProductoRelaciones(MarcaProducto marcaproducto,List<Producto> productos,List<ParametroInventarioDefecto> parametroinventariodefectos)throws Exception {

		if(!marcaproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveMarcaProductoRelacionesBase(marcaproducto,productos,parametroinventariodefectos,false);
		}
	}

	public void saveMarcaProductoRelacionesBase(MarcaProducto marcaproducto,List<Producto> productos,List<ParametroInventarioDefecto> parametroinventariodefectos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("MarcaProducto-saveRelacionesWithConnection");}
	
			marcaproducto.setProductos(productos);
			marcaproducto.setParametroInventarioDefectos(parametroinventariodefectos);

			this.setMarcaProducto(marcaproducto);

			if(MarcaProductoLogicAdditional.validarSaveRelaciones(marcaproducto,this)) {

				MarcaProductoLogicAdditional.updateRelacionesToSave(marcaproducto,this);

				if((marcaproducto.getIsNew()||marcaproducto.getIsChanged())&&!marcaproducto.getIsDeleted()) {
					this.saveMarcaProducto();
					this.saveMarcaProductoRelacionesDetalles(productos,parametroinventariodefectos);

				} else if(marcaproducto.getIsDeleted()) {
					this.saveMarcaProductoRelacionesDetalles(productos,parametroinventariodefectos);
					this.saveMarcaProducto();
				}

				MarcaProductoLogicAdditional.updateRelacionesToSaveAfter(marcaproducto,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresProductos(productos,true,true);
			ParametroInventarioDefectoConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroInventarioDefectos(parametroinventariodefectos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveMarcaProductoRelacionesDetalles(List<Producto> productos,List<ParametroInventarioDefecto> parametroinventariodefectos)throws Exception {
		try {
	

			Long idMarcaProductoActual=this.getMarcaProducto().getId();

			ProductoLogic productoLogic_Desde_MarcaProducto=new ProductoLogic();
			productoLogic_Desde_MarcaProducto.setProductos(productos);

			productoLogic_Desde_MarcaProducto.setConnexion(this.getConnexion());
			productoLogic_Desde_MarcaProducto.setDatosCliente(this.datosCliente);

			for(Producto producto_Desde_MarcaProducto:productoLogic_Desde_MarcaProducto.getProductos()) {
				producto_Desde_MarcaProducto.setid_marca_producto(idMarcaProductoActual);

				productoLogic_Desde_MarcaProducto.setProducto(producto_Desde_MarcaProducto);
				productoLogic_Desde_MarcaProducto.saveProducto();
			}


			ParametroInventarioDefectoLogic parametroinventariodefectoLogic_Desde_MarcaProducto=new ParametroInventarioDefectoLogic();
			parametroinventariodefectoLogic_Desde_MarcaProducto.setParametroInventarioDefectos(parametroinventariodefectos);

			parametroinventariodefectoLogic_Desde_MarcaProducto.setConnexion(this.getConnexion());
			parametroinventariodefectoLogic_Desde_MarcaProducto.setDatosCliente(this.datosCliente);

			for(ParametroInventarioDefecto parametroinventariodefecto_Desde_MarcaProducto:parametroinventariodefectoLogic_Desde_MarcaProducto.getParametroInventarioDefectos()) {
				parametroinventariodefecto_Desde_MarcaProducto.setid_marca_producto(idMarcaProductoActual);
			}

			parametroinventariodefectoLogic_Desde_MarcaProducto.saveParametroInventarioDefectos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfMarcaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=MarcaProductoConstantesFunciones.getClassesForeignKeysOfMarcaProducto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMarcaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=MarcaProductoConstantesFunciones.getClassesRelationshipsOfMarcaProducto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.inventario.util.EfectoProductoConstantesFunciones;
import com.bydan.erp.inventario.util.EfectoProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EfectoProductoParameterGeneral;
import com.bydan.erp.inventario.business.entity.EfectoProducto;
import com.bydan.erp.inventario.business.logic.EfectoProductoLogicAdditional;
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
public class EfectoProductoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EfectoProductoLogic.class);
	
	protected EfectoProductoDataAccess efectoproductoDataAccess; 	
	protected EfectoProducto efectoproducto;
	protected List<EfectoProducto> efectoproductos;
	protected Object efectoproductoObject;	
	protected List<Object> efectoproductosObject;
	
	public static ClassValidator<EfectoProducto> efectoproductoValidator = new ClassValidator<EfectoProducto>(EfectoProducto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EfectoProductoLogicAdditional efectoproductoLogicAdditional=null;
	
	public EfectoProductoLogicAdditional getEfectoProductoLogicAdditional() {
		return this.efectoproductoLogicAdditional;
	}
	
	public void setEfectoProductoLogicAdditional(EfectoProductoLogicAdditional efectoproductoLogicAdditional) {
		try {
			this.efectoproductoLogicAdditional=efectoproductoLogicAdditional;
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
	
	
	
	
	public  EfectoProductoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.efectoproductoDataAccess = new EfectoProductoDataAccess();
			
			this.efectoproductos= new ArrayList<EfectoProducto>();
			this.efectoproducto= new EfectoProducto();
			
			this.efectoproductoObject=new Object();
			this.efectoproductosObject=new ArrayList<Object>();
				
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
			
			this.efectoproductoDataAccess.setConnexionType(this.connexionType);
			this.efectoproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EfectoProductoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.efectoproductoDataAccess = new EfectoProductoDataAccess();
			this.efectoproductos= new ArrayList<EfectoProducto>();
			this.efectoproducto= new EfectoProducto();
			this.efectoproductoObject=new Object();
			this.efectoproductosObject=new ArrayList<Object>();
			
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
			
			this.efectoproductoDataAccess.setConnexionType(this.connexionType);
			this.efectoproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EfectoProducto getEfectoProducto() throws Exception {	
		EfectoProductoLogicAdditional.checkEfectoProductoToGet(efectoproducto,this.datosCliente,this.arrDatoGeneral);
		EfectoProductoLogicAdditional.updateEfectoProductoToGet(efectoproducto,this.arrDatoGeneral);
		
		return efectoproducto;
	}
		
	public void setEfectoProducto(EfectoProducto newEfectoProducto) {
		this.efectoproducto = newEfectoProducto;
	}
	
	public EfectoProductoDataAccess getEfectoProductoDataAccess() {
		return efectoproductoDataAccess;
	}
	
	public void setEfectoProductoDataAccess(EfectoProductoDataAccess newefectoproductoDataAccess) {
		this.efectoproductoDataAccess = newefectoproductoDataAccess;
	}
	
	public List<EfectoProducto> getEfectoProductos() throws Exception {		
		this.quitarEfectoProductosNulos();
		
		EfectoProductoLogicAdditional.checkEfectoProductoToGets(efectoproductos,this.datosCliente,this.arrDatoGeneral);
		
		for (EfectoProducto efectoproductoLocal: efectoproductos ) {
			EfectoProductoLogicAdditional.updateEfectoProductoToGet(efectoproductoLocal,this.arrDatoGeneral);
		}
		
		return efectoproductos;
	}
	
	public void setEfectoProductos(List<EfectoProducto> newEfectoProductos) {
		this.efectoproductos = newEfectoProductos;
	}
	
	public Object getEfectoProductoObject() {	
		this.efectoproductoObject=this.efectoproductoDataAccess.getEntityObject();
		return this.efectoproductoObject;
	}
		
	public void setEfectoProductoObject(Object newEfectoProductoObject) {
		this.efectoproductoObject = newEfectoProductoObject;
	}
	
	public List<Object> getEfectoProductosObject() {		
		this.efectoproductosObject=this.efectoproductoDataAccess.getEntitiesObject();
		return this.efectoproductosObject;
	}
		
	public void setEfectoProductosObject(List<Object> newEfectoProductosObject) {
		this.efectoproductosObject = newEfectoProductosObject;
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
		
		if(this.efectoproductoDataAccess!=null) {
			this.efectoproductoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			efectoproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			efectoproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		efectoproducto = new  EfectoProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			efectoproducto=efectoproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.efectoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproducto);
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
		efectoproducto = new  EfectoProducto();
		  		  
        try {
			
			efectoproducto=efectoproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.efectoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		efectoproducto = new  EfectoProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			efectoproducto=efectoproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.efectoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproducto);
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
		efectoproducto = new  EfectoProducto();
		  		  
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
		efectoproducto = new  EfectoProducto();
		  		  
        try {
			
			efectoproducto=efectoproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.efectoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		efectoproducto = new  EfectoProducto();
		  		  
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
		efectoproducto = new  EfectoProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =efectoproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		efectoproducto = new  EfectoProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=efectoproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		efectoproducto = new  EfectoProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =efectoproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		efectoproducto = new  EfectoProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=efectoproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		efectoproducto = new  EfectoProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =efectoproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		efectoproducto = new  EfectoProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=efectoproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		efectoproductos = new  ArrayList<EfectoProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			efectoproductos=efectoproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEfectoProducto(efectoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproductos);
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
		efectoproductos = new  ArrayList<EfectoProducto>();
		  		  
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
		efectoproductos = new  ArrayList<EfectoProducto>();
		  		  
        try {			
			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			efectoproductos=efectoproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEfectoProducto(efectoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		efectoproductos = new  ArrayList<EfectoProducto>();
		  		  
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
		efectoproductos = new  ArrayList<EfectoProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			efectoproductos=efectoproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEfectoProducto(efectoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproductos);
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
		efectoproductos = new  ArrayList<EfectoProducto>();
		  		  
        try {
			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			efectoproductos=efectoproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEfectoProducto(efectoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproductos);
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
		efectoproductos = new  ArrayList<EfectoProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			efectoproductos=efectoproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEfectoProducto(efectoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproductos);
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
		efectoproductos = new  ArrayList<EfectoProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			efectoproductos=efectoproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEfectoProducto(efectoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		efectoproducto = new  EfectoProducto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			efectoproducto=efectoproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEfectoProducto(efectoproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproducto);
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
		efectoproducto = new  EfectoProducto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			efectoproducto=efectoproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEfectoProducto(efectoproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		efectoproductos = new  ArrayList<EfectoProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			efectoproductos=efectoproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEfectoProducto(efectoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproductos);
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
		efectoproductos = new  ArrayList<EfectoProducto>();
		  		  
        try {
			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			efectoproductos=efectoproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEfectoProducto(efectoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEfectoProductosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		efectoproductos = new  ArrayList<EfectoProducto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-getTodosEfectoProductosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			efectoproductos=efectoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEfectoProducto(efectoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproductos);
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
	
	public  void  getTodosEfectoProductos(String sFinalQuery,Pagination pagination)throws Exception {
		efectoproductos = new  ArrayList<EfectoProducto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			efectoproductos=efectoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEfectoProducto(efectoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEfectoProducto(EfectoProducto efectoproducto) throws Exception {
		Boolean estaValidado=false;
		
		if(efectoproducto.getIsNew() || efectoproducto.getIsChanged()) { 
			this.invalidValues = efectoproductoValidator.getInvalidValues(efectoproducto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(efectoproducto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEfectoProducto(List<EfectoProducto> EfectoProductos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EfectoProducto efectoproductoLocal:efectoproductos) {				
			estaValidadoObjeto=this.validarGuardarEfectoProducto(efectoproductoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEfectoProducto(List<EfectoProducto> EfectoProductos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEfectoProducto(efectoproductos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEfectoProducto(EfectoProducto EfectoProducto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEfectoProducto(efectoproducto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EfectoProducto efectoproducto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+efectoproducto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EfectoProductoConstantesFunciones.getEfectoProductoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"efectoproducto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EfectoProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EfectoProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEfectoProductoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-saveEfectoProductoWithConnection");connexion.begin();			
			
			EfectoProductoLogicAdditional.checkEfectoProductoToSave(this.efectoproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EfectoProductoLogicAdditional.updateEfectoProductoToSave(this.efectoproducto,this.arrDatoGeneral);
			
			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.efectoproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEfectoProducto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEfectoProducto(this.efectoproducto)) {
				EfectoProductoDataAccess.save(this.efectoproducto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.efectoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EfectoProductoLogicAdditional.checkEfectoProductoToSaveAfter(this.efectoproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEfectoProducto();
			
			connexion.commit();			
			
			if(this.efectoproducto.getIsDeleted()) {
				this.efectoproducto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEfectoProducto()throws Exception {	
		try {	
			
			EfectoProductoLogicAdditional.checkEfectoProductoToSave(this.efectoproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EfectoProductoLogicAdditional.updateEfectoProductoToSave(this.efectoproducto,this.arrDatoGeneral);
			
			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.efectoproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEfectoProducto(this.efectoproducto)) {			
				EfectoProductoDataAccess.save(this.efectoproducto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.efectoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EfectoProductoLogicAdditional.checkEfectoProductoToSaveAfter(this.efectoproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.efectoproducto.getIsDeleted()) {
				this.efectoproducto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEfectoProductosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-saveEfectoProductosWithConnection");connexion.begin();			
			
			EfectoProductoLogicAdditional.checkEfectoProductoToSaves(efectoproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEfectoProductos();
			
			Boolean validadoTodosEfectoProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EfectoProducto efectoproductoLocal:efectoproductos) {		
				if(efectoproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EfectoProductoLogicAdditional.updateEfectoProductoToSave(efectoproductoLocal,this.arrDatoGeneral);
	        	
				EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),efectoproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEfectoProducto(efectoproductoLocal)) {
					EfectoProductoDataAccess.save(efectoproductoLocal, connexion);				
				} else {
					validadoTodosEfectoProducto=false;
				}
			}
			
			if(!validadoTodosEfectoProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EfectoProductoLogicAdditional.checkEfectoProductoToSavesAfter(efectoproductos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEfectoProductos();
			
			connexion.commit();		
			
			this.quitarEfectoProductosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEfectoProductos()throws Exception {				
		 try {	
			EfectoProductoLogicAdditional.checkEfectoProductoToSaves(efectoproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEfectoProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EfectoProducto efectoproductoLocal:efectoproductos) {				
				if(efectoproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EfectoProductoLogicAdditional.updateEfectoProductoToSave(efectoproductoLocal,this.arrDatoGeneral);
	        	
				EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),efectoproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEfectoProducto(efectoproductoLocal)) {				
					EfectoProductoDataAccess.save(efectoproductoLocal, connexion);				
				} else {
					validadoTodosEfectoProducto=false;
				}
			}
			
			if(!validadoTodosEfectoProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EfectoProductoLogicAdditional.checkEfectoProductoToSavesAfter(efectoproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEfectoProductosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EfectoProductoParameterReturnGeneral procesarAccionEfectoProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EfectoProducto> efectoproductos,EfectoProductoParameterReturnGeneral efectoproductoParameterGeneral)throws Exception {
		 try {	
			EfectoProductoParameterReturnGeneral efectoproductoReturnGeneral=new EfectoProductoParameterReturnGeneral();
	
			EfectoProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,efectoproductos,efectoproductoParameterGeneral,efectoproductoReturnGeneral);
			
			return efectoproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EfectoProductoParameterReturnGeneral procesarAccionEfectoProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EfectoProducto> efectoproductos,EfectoProductoParameterReturnGeneral efectoproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-procesarAccionEfectoProductosWithConnection");connexion.begin();			
			
			EfectoProductoParameterReturnGeneral efectoproductoReturnGeneral=new EfectoProductoParameterReturnGeneral();
	
			EfectoProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,efectoproductos,efectoproductoParameterGeneral,efectoproductoReturnGeneral);
			
			this.connexion.commit();
			
			return efectoproductoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EfectoProductoParameterReturnGeneral procesarEventosEfectoProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EfectoProducto> efectoproductos,EfectoProducto efectoproducto,EfectoProductoParameterReturnGeneral efectoproductoParameterGeneral,Boolean isEsNuevoEfectoProducto,ArrayList<Classe> clases)throws Exception {
		 try {	
			EfectoProductoParameterReturnGeneral efectoproductoReturnGeneral=new EfectoProductoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				efectoproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EfectoProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,efectoproductos,efectoproducto,efectoproductoParameterGeneral,efectoproductoReturnGeneral,isEsNuevoEfectoProducto,clases);
			
			return efectoproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EfectoProductoParameterReturnGeneral procesarEventosEfectoProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EfectoProducto> efectoproductos,EfectoProducto efectoproducto,EfectoProductoParameterReturnGeneral efectoproductoParameterGeneral,Boolean isEsNuevoEfectoProducto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-procesarEventosEfectoProductosWithConnection");connexion.begin();			
			
			EfectoProductoParameterReturnGeneral efectoproductoReturnGeneral=new EfectoProductoParameterReturnGeneral();
	
			efectoproductoReturnGeneral.setEfectoProducto(efectoproducto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				efectoproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EfectoProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,efectoproductos,efectoproducto,efectoproductoParameterGeneral,efectoproductoReturnGeneral,isEsNuevoEfectoProducto,clases);
			
			this.connexion.commit();
			
			return efectoproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EfectoProductoParameterReturnGeneral procesarImportacionEfectoProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EfectoProductoParameterReturnGeneral efectoproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-procesarImportacionEfectoProductosWithConnection");connexion.begin();			
			
			EfectoProductoParameterReturnGeneral efectoproductoReturnGeneral=new EfectoProductoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.efectoproductos=new ArrayList<EfectoProducto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.efectoproducto=new EfectoProducto();
				
				
				if(conColumnasBase) {this.efectoproducto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.efectoproducto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.efectoproducto.setcodigo(arrColumnas[iColumn++]);
				this.efectoproducto.setnombre(arrColumnas[iColumn++]);
				
				this.efectoproductos.add(this.efectoproducto);
			}
			
			this.saveEfectoProductos();
			
			this.connexion.commit();
			
			efectoproductoReturnGeneral.setConRetornoEstaProcesado(true);
			efectoproductoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return efectoproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEfectoProductosEliminados() throws Exception {				
		
		List<EfectoProducto> efectoproductosAux= new ArrayList<EfectoProducto>();
		
		for(EfectoProducto efectoproducto:efectoproductos) {
			if(!efectoproducto.getIsDeleted()) {
				efectoproductosAux.add(efectoproducto);
			}
		}
		
		efectoproductos=efectoproductosAux;
	}
	
	public void quitarEfectoProductosNulos() throws Exception {				
		
		List<EfectoProducto> efectoproductosAux= new ArrayList<EfectoProducto>();
		
		for(EfectoProducto efectoproducto : this.efectoproductos) {
			if(efectoproducto==null) {
				efectoproductosAux.add(efectoproducto);
			}
		}
		
		//this.efectoproductos=efectoproductosAux;
		
		this.efectoproductos.removeAll(efectoproductosAux);
	}
	
	public void getSetVersionRowEfectoProductoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(efectoproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((efectoproducto.getIsDeleted() || (efectoproducto.getIsChanged()&&!efectoproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=efectoproductoDataAccess.getSetVersionRowEfectoProducto(connexion,efectoproducto.getId());
				
				if(!efectoproducto.getVersionRow().equals(timestamp)) {	
					efectoproducto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				efectoproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEfectoProducto()throws Exception {	
		
		if(efectoproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((efectoproducto.getIsDeleted() || (efectoproducto.getIsChanged()&&!efectoproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=efectoproductoDataAccess.getSetVersionRowEfectoProducto(connexion,efectoproducto.getId());
			
			try {							
				if(!efectoproducto.getVersionRow().equals(timestamp)) {	
					efectoproducto.setVersionRow(timestamp);
				}
				
				efectoproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEfectoProductosWithConnection()throws Exception {	
		if(efectoproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EfectoProducto efectoproductoAux:efectoproductos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(efectoproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(efectoproductoAux.getIsDeleted() || (efectoproductoAux.getIsChanged()&&!efectoproductoAux.getIsNew())) {
						
						timestamp=efectoproductoDataAccess.getSetVersionRowEfectoProducto(connexion,efectoproductoAux.getId());
						
						if(!efectoproducto.getVersionRow().equals(timestamp)) {	
							efectoproductoAux.setVersionRow(timestamp);
						}
								
						efectoproductoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEfectoProductos()throws Exception {	
		if(efectoproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EfectoProducto efectoproductoAux:efectoproductos) {
					if(efectoproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(efectoproductoAux.getIsDeleted() || (efectoproductoAux.getIsChanged()&&!efectoproductoAux.getIsNew())) {
						
						timestamp=efectoproductoDataAccess.getSetVersionRowEfectoProducto(connexion,efectoproductoAux.getId());
						
						if(!efectoproductoAux.getVersionRow().equals(timestamp)) {	
							efectoproductoAux.setVersionRow(timestamp);
						}
						
													
						efectoproductoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EfectoProductoParameterReturnGeneral cargarCombosLoteForeignKeyEfectoProductoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoProducto) throws Exception {
		EfectoProductoParameterReturnGeneral  efectoproductoReturnGeneral =new EfectoProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-cargarCombosLoteForeignKeyEfectoProductoWithConnection");connexion.begin();
			
			efectoproductoReturnGeneral =new EfectoProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			efectoproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoProducto> tipoproductosForeignKey=new ArrayList<TipoProducto>();
			TipoProductoLogic tipoproductoLogic=new TipoProductoLogic();
			tipoproductoLogic.setConnexion(this.connexion);
			tipoproductoLogic.getTipoProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProducto.equals("NONE")) {
				tipoproductoLogic.getTodosTipoProductos(finalQueryGlobalTipoProducto,new Pagination());
				tipoproductosForeignKey=tipoproductoLogic.getTipoProductos();
			}

			efectoproductoReturnGeneral.settipoproductosForeignKey(tipoproductosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return efectoproductoReturnGeneral;
	}
	
	public EfectoProductoParameterReturnGeneral cargarCombosLoteForeignKeyEfectoProducto(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoProducto) throws Exception {
		EfectoProductoParameterReturnGeneral  efectoproductoReturnGeneral =new EfectoProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			efectoproductoReturnGeneral =new EfectoProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			efectoproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoProducto> tipoproductosForeignKey=new ArrayList<TipoProducto>();
			TipoProductoLogic tipoproductoLogic=new TipoProductoLogic();
			tipoproductoLogic.setConnexion(this.connexion);
			tipoproductoLogic.getTipoProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProducto.equals("NONE")) {
				tipoproductoLogic.getTodosTipoProductos(finalQueryGlobalTipoProducto,new Pagination());
				tipoproductosForeignKey=tipoproductoLogic.getTipoProductos();
			}

			efectoproductoReturnGeneral.settipoproductosForeignKey(tipoproductosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return efectoproductoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyEfectoProductoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ProductoLogic productoLogic=new ProductoLogic();
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic=new ParametroInventarioDefectoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEfectoProductoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Producto.class));
			classes.add(new Classe(ParametroInventarioDefecto.class));
											
			

			productoLogic.setConnexion(this.getConnexion());
			productoLogic.setDatosCliente(this.datosCliente);
			productoLogic.setIsConRefrescarForeignKeys(true);

			parametroinventariodefectoLogic.setConnexion(this.getConnexion());
			parametroinventariodefectoLogic.setDatosCliente(this.datosCliente);
			parametroinventariodefectoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EfectoProducto efectoproducto:this.efectoproductos) {
				

				classes=new ArrayList<Classe>();
				classes=ProductoConstantesFunciones.getClassesForeignKeysOfProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoLogic.setProductos(efectoproducto.productos);
				productoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroInventarioDefectoConstantesFunciones.getClassesForeignKeysOfParametroInventarioDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametroinventariodefectoLogic.setParametroInventarioDefectos(efectoproducto.parametroinventariodefectos);
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
	
	public void deepLoad(EfectoProducto efectoproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EfectoProductoLogicAdditional.updateEfectoProductoToGet(efectoproducto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		efectoproducto.setEmpresa(efectoproductoDataAccess.getEmpresa(connexion,efectoproducto));
		efectoproducto.setTipoProducto(efectoproductoDataAccess.getTipoProducto(connexion,efectoproducto));
		efectoproducto.setProductos(efectoproductoDataAccess.getProductos(connexion,efectoproducto));
		efectoproducto.setParametroInventarioDefectos(efectoproductoDataAccess.getParametroInventarioDefectos(connexion,efectoproducto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				efectoproducto.setEmpresa(efectoproductoDataAccess.getEmpresa(connexion,efectoproducto));
				continue;
			}

			if(clas.clas.equals(TipoProducto.class)) {
				efectoproducto.setTipoProducto(efectoproductoDataAccess.getTipoProducto(connexion,efectoproducto));
				continue;
			}

			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				efectoproducto.setProductos(efectoproductoDataAccess.getProductos(connexion,efectoproducto));

				if(this.isConDeep) {
					ProductoLogic productoLogic= new ProductoLogic(this.connexion);
					productoLogic.setProductos(efectoproducto.getProductos());
					ArrayList<Classe> classesLocal=ProductoConstantesFunciones.getClassesForeignKeysOfProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(productoLogic.getProductos());
					efectoproducto.setProductos(productoLogic.getProductos());
				}

				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				efectoproducto.setParametroInventarioDefectos(efectoproductoDataAccess.getParametroInventarioDefectos(connexion,efectoproducto));

				if(this.isConDeep) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(this.connexion);
					parametroinventariodefectoLogic.setParametroInventarioDefectos(efectoproducto.getParametroInventarioDefectos());
					ArrayList<Classe> classesLocal=ParametroInventarioDefectoConstantesFunciones.getClassesForeignKeysOfParametroInventarioDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametroinventariodefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(parametroinventariodefectoLogic.getParametroInventarioDefectos());
					efectoproducto.setParametroInventarioDefectos(parametroinventariodefectoLogic.getParametroInventarioDefectos());
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
			efectoproducto.setEmpresa(efectoproductoDataAccess.getEmpresa(connexion,efectoproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			efectoproducto.setTipoProducto(efectoproductoDataAccess.getTipoProducto(connexion,efectoproducto));
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
			efectoproducto.setProductos(efectoproductoDataAccess.getProductos(connexion,efectoproducto));
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
			efectoproducto.setParametroInventarioDefectos(efectoproductoDataAccess.getParametroInventarioDefectos(connexion,efectoproducto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		efectoproducto.setEmpresa(efectoproductoDataAccess.getEmpresa(connexion,efectoproducto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(efectoproducto.getEmpresa(),isDeep,deepLoadType,clases);
				
		efectoproducto.setTipoProducto(efectoproductoDataAccess.getTipoProducto(connexion,efectoproducto));
		TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
		tipoproductoLogic.deepLoad(efectoproducto.getTipoProducto(),isDeep,deepLoadType,clases);
				

		efectoproducto.setProductos(efectoproductoDataAccess.getProductos(connexion,efectoproducto));

		for(Producto producto:efectoproducto.getProductos()) {
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(producto,isDeep,deepLoadType,clases);
		}

		efectoproducto.setParametroInventarioDefectos(efectoproductoDataAccess.getParametroInventarioDefectos(connexion,efectoproducto));

		for(ParametroInventarioDefecto parametroinventariodefecto:efectoproducto.getParametroInventarioDefectos()) {
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
			parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				efectoproducto.setEmpresa(efectoproductoDataAccess.getEmpresa(connexion,efectoproducto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(efectoproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProducto.class)) {
				efectoproducto.setTipoProducto(efectoproductoDataAccess.getTipoProducto(connexion,efectoproducto));
				TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
				tipoproductoLogic.deepLoad(efectoproducto.getTipoProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				efectoproducto.setProductos(efectoproductoDataAccess.getProductos(connexion,efectoproducto));

				for(Producto producto:efectoproducto.getProductos()) {
					ProductoLogic productoLogic= new ProductoLogic(connexion);
					productoLogic.deepLoad(producto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				efectoproducto.setParametroInventarioDefectos(efectoproductoDataAccess.getParametroInventarioDefectos(connexion,efectoproducto));

				for(ParametroInventarioDefecto parametroinventariodefecto:efectoproducto.getParametroInventarioDefectos()) {
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
			efectoproducto.setEmpresa(efectoproductoDataAccess.getEmpresa(connexion,efectoproducto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(efectoproducto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			efectoproducto.setTipoProducto(efectoproductoDataAccess.getTipoProducto(connexion,efectoproducto));
			TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
			tipoproductoLogic.deepLoad(efectoproducto.getTipoProducto(),isDeep,deepLoadType,clases);
				
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
			efectoproducto.setProductos(efectoproductoDataAccess.getProductos(connexion,efectoproducto));

			for(Producto producto:efectoproducto.getProductos()) {
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
			efectoproducto.setParametroInventarioDefectos(efectoproductoDataAccess.getParametroInventarioDefectos(connexion,efectoproducto));

			for(ParametroInventarioDefecto parametroinventariodefecto:efectoproducto.getParametroInventarioDefectos()) {
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
	
	public void deepSave(EfectoProducto efectoproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EfectoProductoLogicAdditional.updateEfectoProductoToSave(efectoproducto,this.arrDatoGeneral);
			
EfectoProductoDataAccess.save(efectoproducto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(efectoproducto.getEmpresa(),connexion);

		TipoProductoDataAccess.save(efectoproducto.getTipoProducto(),connexion);

		for(Producto producto:efectoproducto.getProductos()) {
			producto.setid_efecto_producto(efectoproducto.getId());
			ProductoDataAccess.save(producto,connexion);
		}

		for(ParametroInventarioDefecto parametroinventariodefecto:efectoproducto.getParametroInventarioDefectos()) {
			parametroinventariodefecto.setid_efecto_producto(efectoproducto.getId());
			ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(efectoproducto.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoProducto.class)) {
				TipoProductoDataAccess.save(efectoproducto.getTipoProducto(),connexion);
				continue;
			}


			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Producto producto:efectoproducto.getProductos()) {
					producto.setid_efecto_producto(efectoproducto.getId());
					ProductoDataAccess.save(producto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroInventarioDefecto parametroinventariodefecto:efectoproducto.getParametroInventarioDefectos()) {
					parametroinventariodefecto.setid_efecto_producto(efectoproducto.getId());
					ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(efectoproducto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(efectoproducto.getEmpresa(),isDeep,deepLoadType,clases);
				

		TipoProductoDataAccess.save(efectoproducto.getTipoProducto(),connexion);
		TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
		tipoproductoLogic.deepLoad(efectoproducto.getTipoProducto(),isDeep,deepLoadType,clases);
				

		for(Producto producto:efectoproducto.getProductos()) {
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			producto.setid_efecto_producto(efectoproducto.getId());
			ProductoDataAccess.save(producto,connexion);
			productoLogic.deepSave(producto,isDeep,deepLoadType,clases);
		}

		for(ParametroInventarioDefecto parametroinventariodefecto:efectoproducto.getParametroInventarioDefectos()) {
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
			parametroinventariodefecto.setid_efecto_producto(efectoproducto.getId());
			ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
			parametroinventariodefectoLogic.deepSave(parametroinventariodefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(efectoproducto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(efectoproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProducto.class)) {
				TipoProductoDataAccess.save(efectoproducto.getTipoProducto(),connexion);
				TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
				tipoproductoLogic.deepSave(efectoproducto.getTipoProducto(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Producto producto:efectoproducto.getProductos()) {
					ProductoLogic productoLogic= new ProductoLogic(connexion);
					producto.setid_efecto_producto(efectoproducto.getId());
					ProductoDataAccess.save(producto,connexion);
					productoLogic.deepSave(producto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroInventarioDefecto parametroinventariodefecto:efectoproducto.getParametroInventarioDefectos()) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
					parametroinventariodefecto.setid_efecto_producto(efectoproducto.getId());
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
			this.getNewConnexionToDeep(EfectoProducto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(efectoproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(efectoproducto);
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
			this.deepLoad(this.efectoproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EfectoProducto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(efectoproductos!=null) {
				for(EfectoProducto efectoproducto:efectoproductos) {
					this.deepLoad(efectoproducto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(efectoproductos);
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
			if(efectoproductos!=null) {
				for(EfectoProducto efectoproducto:efectoproductos) {
					this.deepLoad(efectoproducto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(efectoproductos);
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
			this.getNewConnexionToDeep(EfectoProducto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(efectoproducto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EfectoProducto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(efectoproductos!=null) {
				for(EfectoProducto efectoproducto:efectoproductos) {
					this.deepSave(efectoproducto,isDeep,deepLoadType,clases);
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
			if(efectoproductos!=null) {
				for(EfectoProducto efectoproducto:efectoproductos) {
					this.deepSave(efectoproducto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEfectoProductosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",EfectoProductoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			efectoproductos=efectoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEfectoProductosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",EfectoProductoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			efectoproductos=efectoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEfectoProductosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",EfectoProductoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			efectoproductos=efectoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEfectoProductosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",EfectoProductoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			efectoproductos=efectoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEfectoProductosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EfectoProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			efectoproductos=efectoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEfectoProductosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EfectoProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			efectoproductos=efectoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEfectoProductosFK_IdTipoProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EfectoProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto,EfectoProductoConstantesFunciones.IDTIPOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProducto);

			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			efectoproductos=efectoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEfectoProductosFK_IdTipoProducto(String sFinalQuery,Pagination pagination,Long id_tipo_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto,EfectoProductoConstantesFunciones.IDTIPOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProducto);

			EfectoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			efectoproductos=efectoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EfectoProductoConstantesFunciones.refrescarForeignKeysDescripcionesEfectoProducto(this.efectoproductos);
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
			if(EfectoProductoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EfectoProductoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EfectoProducto efectoproducto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EfectoProductoConstantesFunciones.ISCONAUDITORIA) {
				if(efectoproducto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EfectoProductoDataAccess.TABLENAME, efectoproducto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EfectoProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EfectoProductoLogic.registrarAuditoriaDetallesEfectoProducto(connexion,efectoproducto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(efectoproducto.getIsDeleted()) {
					/*if(!efectoproducto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EfectoProductoDataAccess.TABLENAME, efectoproducto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EfectoProductoLogic.registrarAuditoriaDetallesEfectoProducto(connexion,efectoproducto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EfectoProductoDataAccess.TABLENAME, efectoproducto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(efectoproducto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EfectoProductoDataAccess.TABLENAME, efectoproducto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EfectoProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EfectoProductoLogic.registrarAuditoriaDetallesEfectoProducto(connexion,efectoproducto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEfectoProducto(Connexion connexion,EfectoProducto efectoproducto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(efectoproducto.getIsNew()||!efectoproducto.getid_empresa().equals(efectoproducto.getEfectoProductoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(efectoproducto.getEfectoProductoOriginal().getid_empresa()!=null)
				{
					strValorActual=efectoproducto.getEfectoProductoOriginal().getid_empresa().toString();
				}
				if(efectoproducto.getid_empresa()!=null)
				{
					strValorNuevo=efectoproducto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EfectoProductoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(efectoproducto.getIsNew()||!efectoproducto.getid_tipo_producto().equals(efectoproducto.getEfectoProductoOriginal().getid_tipo_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(efectoproducto.getEfectoProductoOriginal().getid_tipo_producto()!=null)
				{
					strValorActual=efectoproducto.getEfectoProductoOriginal().getid_tipo_producto().toString();
				}
				if(efectoproducto.getid_tipo_producto()!=null)
				{
					strValorNuevo=efectoproducto.getid_tipo_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EfectoProductoConstantesFunciones.IDTIPOPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(efectoproducto.getIsNew()||!efectoproducto.getcodigo().equals(efectoproducto.getEfectoProductoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(efectoproducto.getEfectoProductoOriginal().getcodigo()!=null)
				{
					strValorActual=efectoproducto.getEfectoProductoOriginal().getcodigo();
				}
				if(efectoproducto.getcodigo()!=null)
				{
					strValorNuevo=efectoproducto.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EfectoProductoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(efectoproducto.getIsNew()||!efectoproducto.getnombre().equals(efectoproducto.getEfectoProductoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(efectoproducto.getEfectoProductoOriginal().getnombre()!=null)
				{
					strValorActual=efectoproducto.getEfectoProductoOriginal().getnombre();
				}
				if(efectoproducto.getnombre()!=null)
				{
					strValorNuevo=efectoproducto.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EfectoProductoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEfectoProductoRelacionesWithConnection(EfectoProducto efectoproducto,List<Producto> productos,List<ParametroInventarioDefecto> parametroinventariodefectos) throws Exception {

		if(!efectoproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEfectoProductoRelacionesBase(efectoproducto,productos,parametroinventariodefectos,true);
		}
	}

	public void saveEfectoProductoRelaciones(EfectoProducto efectoproducto,List<Producto> productos,List<ParametroInventarioDefecto> parametroinventariodefectos)throws Exception {

		if(!efectoproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEfectoProductoRelacionesBase(efectoproducto,productos,parametroinventariodefectos,false);
		}
	}

	public void saveEfectoProductoRelacionesBase(EfectoProducto efectoproducto,List<Producto> productos,List<ParametroInventarioDefecto> parametroinventariodefectos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EfectoProducto-saveRelacionesWithConnection");}
	
			efectoproducto.setProductos(productos);
			efectoproducto.setParametroInventarioDefectos(parametroinventariodefectos);

			this.setEfectoProducto(efectoproducto);

			if(EfectoProductoLogicAdditional.validarSaveRelaciones(efectoproducto,this)) {

				EfectoProductoLogicAdditional.updateRelacionesToSave(efectoproducto,this);

				if((efectoproducto.getIsNew()||efectoproducto.getIsChanged())&&!efectoproducto.getIsDeleted()) {
					this.saveEfectoProducto();
					this.saveEfectoProductoRelacionesDetalles(productos,parametroinventariodefectos);

				} else if(efectoproducto.getIsDeleted()) {
					this.saveEfectoProductoRelacionesDetalles(productos,parametroinventariodefectos);
					this.saveEfectoProducto();
				}

				EfectoProductoLogicAdditional.updateRelacionesToSaveAfter(efectoproducto,this);

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
	
	
	private void saveEfectoProductoRelacionesDetalles(List<Producto> productos,List<ParametroInventarioDefecto> parametroinventariodefectos)throws Exception {
		try {
	

			Long idEfectoProductoActual=this.getEfectoProducto().getId();

			ProductoLogic productoLogic_Desde_EfectoProducto=new ProductoLogic();
			productoLogic_Desde_EfectoProducto.setProductos(productos);

			productoLogic_Desde_EfectoProducto.setConnexion(this.getConnexion());
			productoLogic_Desde_EfectoProducto.setDatosCliente(this.datosCliente);

			for(Producto producto_Desde_EfectoProducto:productoLogic_Desde_EfectoProducto.getProductos()) {
				producto_Desde_EfectoProducto.setid_efecto_producto(idEfectoProductoActual);

				productoLogic_Desde_EfectoProducto.setProducto(producto_Desde_EfectoProducto);
				productoLogic_Desde_EfectoProducto.saveProducto();
			}


			ParametroInventarioDefectoLogic parametroinventariodefectoLogic_Desde_EfectoProducto=new ParametroInventarioDefectoLogic();
			parametroinventariodefectoLogic_Desde_EfectoProducto.setParametroInventarioDefectos(parametroinventariodefectos);

			parametroinventariodefectoLogic_Desde_EfectoProducto.setConnexion(this.getConnexion());
			parametroinventariodefectoLogic_Desde_EfectoProducto.setDatosCliente(this.datosCliente);

			for(ParametroInventarioDefecto parametroinventariodefecto_Desde_EfectoProducto:parametroinventariodefectoLogic_Desde_EfectoProducto.getParametroInventarioDefectos()) {
				parametroinventariodefecto_Desde_EfectoProducto.setid_efecto_producto(idEfectoProductoActual);
			}

			parametroinventariodefectoLogic_Desde_EfectoProducto.saveParametroInventarioDefectos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEfectoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EfectoProductoConstantesFunciones.getClassesForeignKeysOfEfectoProducto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEfectoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EfectoProductoConstantesFunciones.getClassesRelationshipsOfEfectoProducto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

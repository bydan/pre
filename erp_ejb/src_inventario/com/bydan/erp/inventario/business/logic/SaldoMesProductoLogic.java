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
import com.bydan.erp.inventario.util.SaldoMesProductoConstantesFunciones;
import com.bydan.erp.inventario.util.SaldoMesProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.SaldoMesProductoParameterGeneral;
import com.bydan.erp.inventario.business.entity.SaldoMesProducto;
import com.bydan.erp.inventario.business.logic.SaldoMesProductoLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class SaldoMesProductoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(SaldoMesProductoLogic.class);
	
	protected SaldoMesProductoDataAccess saldomesproductoDataAccess; 	
	protected SaldoMesProducto saldomesproducto;
	protected List<SaldoMesProducto> saldomesproductos;
	protected Object saldomesproductoObject;	
	protected List<Object> saldomesproductosObject;
	
	public static ClassValidator<SaldoMesProducto> saldomesproductoValidator = new ClassValidator<SaldoMesProducto>(SaldoMesProducto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected SaldoMesProductoLogicAdditional saldomesproductoLogicAdditional=null;
	
	public SaldoMesProductoLogicAdditional getSaldoMesProductoLogicAdditional() {
		return this.saldomesproductoLogicAdditional;
	}
	
	public void setSaldoMesProductoLogicAdditional(SaldoMesProductoLogicAdditional saldomesproductoLogicAdditional) {
		try {
			this.saldomesproductoLogicAdditional=saldomesproductoLogicAdditional;
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
	
	
	
	
	public  SaldoMesProductoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.saldomesproductoDataAccess = new SaldoMesProductoDataAccess();
			
			this.saldomesproductos= new ArrayList<SaldoMesProducto>();
			this.saldomesproducto= new SaldoMesProducto();
			
			this.saldomesproductoObject=new Object();
			this.saldomesproductosObject=new ArrayList<Object>();
				
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
			
			this.saldomesproductoDataAccess.setConnexionType(this.connexionType);
			this.saldomesproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SaldoMesProductoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.saldomesproductoDataAccess = new SaldoMesProductoDataAccess();
			this.saldomesproductos= new ArrayList<SaldoMesProducto>();
			this.saldomesproducto= new SaldoMesProducto();
			this.saldomesproductoObject=new Object();
			this.saldomesproductosObject=new ArrayList<Object>();
			
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
			
			this.saldomesproductoDataAccess.setConnexionType(this.connexionType);
			this.saldomesproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public SaldoMesProducto getSaldoMesProducto() throws Exception {	
		SaldoMesProductoLogicAdditional.checkSaldoMesProductoToGet(saldomesproducto,this.datosCliente,this.arrDatoGeneral);
		SaldoMesProductoLogicAdditional.updateSaldoMesProductoToGet(saldomesproducto,this.arrDatoGeneral);
		
		return saldomesproducto;
	}
		
	public void setSaldoMesProducto(SaldoMesProducto newSaldoMesProducto) {
		this.saldomesproducto = newSaldoMesProducto;
	}
	
	public SaldoMesProductoDataAccess getSaldoMesProductoDataAccess() {
		return saldomesproductoDataAccess;
	}
	
	public void setSaldoMesProductoDataAccess(SaldoMesProductoDataAccess newsaldomesproductoDataAccess) {
		this.saldomesproductoDataAccess = newsaldomesproductoDataAccess;
	}
	
	public List<SaldoMesProducto> getSaldoMesProductos() throws Exception {		
		this.quitarSaldoMesProductosNulos();
		
		SaldoMesProductoLogicAdditional.checkSaldoMesProductoToGets(saldomesproductos,this.datosCliente,this.arrDatoGeneral);
		
		for (SaldoMesProducto saldomesproductoLocal: saldomesproductos ) {
			SaldoMesProductoLogicAdditional.updateSaldoMesProductoToGet(saldomesproductoLocal,this.arrDatoGeneral);
		}
		
		return saldomesproductos;
	}
	
	public void setSaldoMesProductos(List<SaldoMesProducto> newSaldoMesProductos) {
		this.saldomesproductos = newSaldoMesProductos;
	}
	
	public Object getSaldoMesProductoObject() {	
		this.saldomesproductoObject=this.saldomesproductoDataAccess.getEntityObject();
		return this.saldomesproductoObject;
	}
		
	public void setSaldoMesProductoObject(Object newSaldoMesProductoObject) {
		this.saldomesproductoObject = newSaldoMesProductoObject;
	}
	
	public List<Object> getSaldoMesProductosObject() {		
		this.saldomesproductosObject=this.saldomesproductoDataAccess.getEntitiesObject();
		return this.saldomesproductosObject;
	}
		
	public void setSaldoMesProductosObject(List<Object> newSaldoMesProductosObject) {
		this.saldomesproductosObject = newSaldoMesProductosObject;
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
		
		if(this.saldomesproductoDataAccess!=null) {
			this.saldomesproductoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			saldomesproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			saldomesproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		saldomesproducto = new  SaldoMesProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			saldomesproducto=saldomesproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.saldomesproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproducto);
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
		saldomesproducto = new  SaldoMesProducto();
		  		  
        try {
			
			saldomesproducto=saldomesproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.saldomesproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		saldomesproducto = new  SaldoMesProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			saldomesproducto=saldomesproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.saldomesproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproducto);
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
		saldomesproducto = new  SaldoMesProducto();
		  		  
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
		saldomesproducto = new  SaldoMesProducto();
		  		  
        try {
			
			saldomesproducto=saldomesproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.saldomesproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		saldomesproducto = new  SaldoMesProducto();
		  		  
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
		saldomesproducto = new  SaldoMesProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =saldomesproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		saldomesproducto = new  SaldoMesProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=saldomesproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		saldomesproducto = new  SaldoMesProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =saldomesproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		saldomesproducto = new  SaldoMesProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=saldomesproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		saldomesproducto = new  SaldoMesProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =saldomesproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		saldomesproducto = new  SaldoMesProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=saldomesproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		saldomesproductos = new  ArrayList<SaldoMesProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldomesproductos=saldomesproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSaldoMesProducto(saldomesproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
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
		saldomesproductos = new  ArrayList<SaldoMesProducto>();
		  		  
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
		saldomesproductos = new  ArrayList<SaldoMesProducto>();
		  		  
        try {			
			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldomesproductos=saldomesproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarSaldoMesProducto(saldomesproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		saldomesproductos = new  ArrayList<SaldoMesProducto>();
		  		  
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
		saldomesproductos = new  ArrayList<SaldoMesProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldomesproductos=saldomesproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSaldoMesProducto(saldomesproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
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
		saldomesproductos = new  ArrayList<SaldoMesProducto>();
		  		  
        try {
			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldomesproductos=saldomesproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSaldoMesProducto(saldomesproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
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
		saldomesproductos = new  ArrayList<SaldoMesProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldomesproductos=saldomesproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSaldoMesProducto(saldomesproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
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
		saldomesproductos = new  ArrayList<SaldoMesProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldomesproductos=saldomesproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSaldoMesProducto(saldomesproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		saldomesproducto = new  SaldoMesProducto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldomesproducto=saldomesproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSaldoMesProducto(saldomesproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproducto);
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
		saldomesproducto = new  SaldoMesProducto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldomesproducto=saldomesproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSaldoMesProducto(saldomesproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		saldomesproductos = new  ArrayList<SaldoMesProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldomesproductos=saldomesproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSaldoMesProducto(saldomesproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
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
		saldomesproductos = new  ArrayList<SaldoMesProducto>();
		  		  
        try {
			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldomesproductos=saldomesproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSaldoMesProducto(saldomesproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosSaldoMesProductosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		saldomesproductos = new  ArrayList<SaldoMesProducto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-getTodosSaldoMesProductosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldomesproductos=saldomesproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSaldoMesProducto(saldomesproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
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
	
	public  void  getTodosSaldoMesProductos(String sFinalQuery,Pagination pagination)throws Exception {
		saldomesproductos = new  ArrayList<SaldoMesProducto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldomesproductos=saldomesproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSaldoMesProducto(saldomesproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarSaldoMesProducto(SaldoMesProducto saldomesproducto) throws Exception {
		Boolean estaValidado=false;
		
		if(saldomesproducto.getIsNew() || saldomesproducto.getIsChanged()) { 
			this.invalidValues = saldomesproductoValidator.getInvalidValues(saldomesproducto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(saldomesproducto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarSaldoMesProducto(List<SaldoMesProducto> SaldoMesProductos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(SaldoMesProducto saldomesproductoLocal:saldomesproductos) {				
			estaValidadoObjeto=this.validarGuardarSaldoMesProducto(saldomesproductoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarSaldoMesProducto(List<SaldoMesProducto> SaldoMesProductos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSaldoMesProducto(saldomesproductos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarSaldoMesProducto(SaldoMesProducto SaldoMesProducto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSaldoMesProducto(saldomesproducto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(SaldoMesProducto saldomesproducto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+saldomesproducto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=SaldoMesProductoConstantesFunciones.getSaldoMesProductoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"saldomesproducto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(SaldoMesProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(SaldoMesProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveSaldoMesProductoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-saveSaldoMesProductoWithConnection");connexion.begin();			
			
			SaldoMesProductoLogicAdditional.checkSaldoMesProductoToSave(this.saldomesproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SaldoMesProductoLogicAdditional.updateSaldoMesProductoToSave(this.saldomesproducto,this.arrDatoGeneral);
			
			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.saldomesproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowSaldoMesProducto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSaldoMesProducto(this.saldomesproducto)) {
				SaldoMesProductoDataAccess.save(this.saldomesproducto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.saldomesproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SaldoMesProductoLogicAdditional.checkSaldoMesProductoToSaveAfter(this.saldomesproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSaldoMesProducto();
			
			connexion.commit();			
			
			if(this.saldomesproducto.getIsDeleted()) {
				this.saldomesproducto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveSaldoMesProducto()throws Exception {	
		try {	
			
			SaldoMesProductoLogicAdditional.checkSaldoMesProductoToSave(this.saldomesproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SaldoMesProductoLogicAdditional.updateSaldoMesProductoToSave(this.saldomesproducto,this.arrDatoGeneral);
			
			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.saldomesproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSaldoMesProducto(this.saldomesproducto)) {			
				SaldoMesProductoDataAccess.save(this.saldomesproducto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.saldomesproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SaldoMesProductoLogicAdditional.checkSaldoMesProductoToSaveAfter(this.saldomesproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.saldomesproducto.getIsDeleted()) {
				this.saldomesproducto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveSaldoMesProductosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-saveSaldoMesProductosWithConnection");connexion.begin();			
			
			SaldoMesProductoLogicAdditional.checkSaldoMesProductoToSaves(saldomesproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowSaldoMesProductos();
			
			Boolean validadoTodosSaldoMesProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SaldoMesProducto saldomesproductoLocal:saldomesproductos) {		
				if(saldomesproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SaldoMesProductoLogicAdditional.updateSaldoMesProductoToSave(saldomesproductoLocal,this.arrDatoGeneral);
	        	
				SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),saldomesproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSaldoMesProducto(saldomesproductoLocal)) {
					SaldoMesProductoDataAccess.save(saldomesproductoLocal, connexion);				
				} else {
					validadoTodosSaldoMesProducto=false;
				}
			}
			
			if(!validadoTodosSaldoMesProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SaldoMesProductoLogicAdditional.checkSaldoMesProductoToSavesAfter(saldomesproductos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSaldoMesProductos();
			
			connexion.commit();		
			
			this.quitarSaldoMesProductosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveSaldoMesProductos()throws Exception {				
		 try {	
			SaldoMesProductoLogicAdditional.checkSaldoMesProductoToSaves(saldomesproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosSaldoMesProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SaldoMesProducto saldomesproductoLocal:saldomesproductos) {				
				if(saldomesproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SaldoMesProductoLogicAdditional.updateSaldoMesProductoToSave(saldomesproductoLocal,this.arrDatoGeneral);
	        	
				SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),saldomesproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSaldoMesProducto(saldomesproductoLocal)) {				
					SaldoMesProductoDataAccess.save(saldomesproductoLocal, connexion);				
				} else {
					validadoTodosSaldoMesProducto=false;
				}
			}
			
			if(!validadoTodosSaldoMesProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SaldoMesProductoLogicAdditional.checkSaldoMesProductoToSavesAfter(saldomesproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarSaldoMesProductosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SaldoMesProductoParameterReturnGeneral procesarAccionSaldoMesProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SaldoMesProducto> saldomesproductos,SaldoMesProductoParameterReturnGeneral saldomesproductoParameterGeneral)throws Exception {
		 try {	
			SaldoMesProductoParameterReturnGeneral saldomesproductoReturnGeneral=new SaldoMesProductoParameterReturnGeneral();
	
			SaldoMesProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,saldomesproductos,saldomesproductoParameterGeneral,saldomesproductoReturnGeneral);
			
			return saldomesproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SaldoMesProductoParameterReturnGeneral procesarAccionSaldoMesProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SaldoMesProducto> saldomesproductos,SaldoMesProductoParameterReturnGeneral saldomesproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-procesarAccionSaldoMesProductosWithConnection");connexion.begin();			
			
			SaldoMesProductoParameterReturnGeneral saldomesproductoReturnGeneral=new SaldoMesProductoParameterReturnGeneral();
	
			SaldoMesProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,saldomesproductos,saldomesproductoParameterGeneral,saldomesproductoReturnGeneral);
			
			this.connexion.commit();
			
			return saldomesproductoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SaldoMesProductoParameterReturnGeneral procesarEventosSaldoMesProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SaldoMesProducto> saldomesproductos,SaldoMesProducto saldomesproducto,SaldoMesProductoParameterReturnGeneral saldomesproductoParameterGeneral,Boolean isEsNuevoSaldoMesProducto,ArrayList<Classe> clases)throws Exception {
		 try {	
			SaldoMesProductoParameterReturnGeneral saldomesproductoReturnGeneral=new SaldoMesProductoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				saldomesproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SaldoMesProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,saldomesproductos,saldomesproducto,saldomesproductoParameterGeneral,saldomesproductoReturnGeneral,isEsNuevoSaldoMesProducto,clases);
			
			return saldomesproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public SaldoMesProductoParameterReturnGeneral procesarEventosSaldoMesProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SaldoMesProducto> saldomesproductos,SaldoMesProducto saldomesproducto,SaldoMesProductoParameterReturnGeneral saldomesproductoParameterGeneral,Boolean isEsNuevoSaldoMesProducto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-procesarEventosSaldoMesProductosWithConnection");connexion.begin();			
			
			SaldoMesProductoParameterReturnGeneral saldomesproductoReturnGeneral=new SaldoMesProductoParameterReturnGeneral();
	
			saldomesproductoReturnGeneral.setSaldoMesProducto(saldomesproducto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				saldomesproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SaldoMesProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,saldomesproductos,saldomesproducto,saldomesproductoParameterGeneral,saldomesproductoReturnGeneral,isEsNuevoSaldoMesProducto,clases);
			
			this.connexion.commit();
			
			return saldomesproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SaldoMesProductoParameterReturnGeneral procesarImportacionSaldoMesProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,SaldoMesProductoParameterReturnGeneral saldomesproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-procesarImportacionSaldoMesProductosWithConnection");connexion.begin();			
			
			SaldoMesProductoParameterReturnGeneral saldomesproductoReturnGeneral=new SaldoMesProductoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.saldomesproductos=new ArrayList<SaldoMesProducto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.saldomesproducto=new SaldoMesProducto();
				
				
				if(conColumnasBase) {this.saldomesproducto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.saldomesproducto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.saldomesproducto.setsaldo(Double.parseDouble(arrColumnas[iColumn++]));
				this.saldomesproducto.setcosto(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.saldomesproductos.add(this.saldomesproducto);
			}
			
			this.saveSaldoMesProductos();
			
			this.connexion.commit();
			
			saldomesproductoReturnGeneral.setConRetornoEstaProcesado(true);
			saldomesproductoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return saldomesproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarSaldoMesProductosEliminados() throws Exception {				
		
		List<SaldoMesProducto> saldomesproductosAux= new ArrayList<SaldoMesProducto>();
		
		for(SaldoMesProducto saldomesproducto:saldomesproductos) {
			if(!saldomesproducto.getIsDeleted()) {
				saldomesproductosAux.add(saldomesproducto);
			}
		}
		
		saldomesproductos=saldomesproductosAux;
	}
	
	public void quitarSaldoMesProductosNulos() throws Exception {				
		
		List<SaldoMesProducto> saldomesproductosAux= new ArrayList<SaldoMesProducto>();
		
		for(SaldoMesProducto saldomesproducto : this.saldomesproductos) {
			if(saldomesproducto==null) {
				saldomesproductosAux.add(saldomesproducto);
			}
		}
		
		//this.saldomesproductos=saldomesproductosAux;
		
		this.saldomesproductos.removeAll(saldomesproductosAux);
	}
	
	public void getSetVersionRowSaldoMesProductoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(saldomesproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((saldomesproducto.getIsDeleted() || (saldomesproducto.getIsChanged()&&!saldomesproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=saldomesproductoDataAccess.getSetVersionRowSaldoMesProducto(connexion,saldomesproducto.getId());
				
				if(!saldomesproducto.getVersionRow().equals(timestamp)) {	
					saldomesproducto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				saldomesproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowSaldoMesProducto()throws Exception {	
		
		if(saldomesproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((saldomesproducto.getIsDeleted() || (saldomesproducto.getIsChanged()&&!saldomesproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=saldomesproductoDataAccess.getSetVersionRowSaldoMesProducto(connexion,saldomesproducto.getId());
			
			try {							
				if(!saldomesproducto.getVersionRow().equals(timestamp)) {	
					saldomesproducto.setVersionRow(timestamp);
				}
				
				saldomesproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowSaldoMesProductosWithConnection()throws Exception {	
		if(saldomesproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(SaldoMesProducto saldomesproductoAux:saldomesproductos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(saldomesproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(saldomesproductoAux.getIsDeleted() || (saldomesproductoAux.getIsChanged()&&!saldomesproductoAux.getIsNew())) {
						
						timestamp=saldomesproductoDataAccess.getSetVersionRowSaldoMesProducto(connexion,saldomesproductoAux.getId());
						
						if(!saldomesproducto.getVersionRow().equals(timestamp)) {	
							saldomesproductoAux.setVersionRow(timestamp);
						}
								
						saldomesproductoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowSaldoMesProductos()throws Exception {	
		if(saldomesproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(SaldoMesProducto saldomesproductoAux:saldomesproductos) {
					if(saldomesproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(saldomesproductoAux.getIsDeleted() || (saldomesproductoAux.getIsChanged()&&!saldomesproductoAux.getIsNew())) {
						
						timestamp=saldomesproductoDataAccess.getSetVersionRowSaldoMesProducto(connexion,saldomesproductoAux.getId());
						
						if(!saldomesproductoAux.getVersionRow().equals(timestamp)) {	
							saldomesproductoAux.setVersionRow(timestamp);
						}
						
													
						saldomesproductoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public SaldoMesProductoParameterReturnGeneral cargarCombosLoteForeignKeySaldoMesProductoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		SaldoMesProductoParameterReturnGeneral  saldomesproductoReturnGeneral =new SaldoMesProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-cargarCombosLoteForeignKeySaldoMesProductoWithConnection");connexion.begin();
			
			saldomesproductoReturnGeneral =new SaldoMesProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			saldomesproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			saldomesproductoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			saldomesproductoReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			saldomesproductoReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			saldomesproductoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			saldomesproductoReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return saldomesproductoReturnGeneral;
	}
	
	public SaldoMesProductoParameterReturnGeneral cargarCombosLoteForeignKeySaldoMesProducto(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		SaldoMesProductoParameterReturnGeneral  saldomesproductoReturnGeneral =new SaldoMesProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			saldomesproductoReturnGeneral =new SaldoMesProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			saldomesproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			saldomesproductoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			saldomesproductoReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			saldomesproductoReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			saldomesproductoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			saldomesproductoReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return saldomesproductoReturnGeneral;
	}
	
	
	public void deepLoad(SaldoMesProducto saldomesproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SaldoMesProductoLogicAdditional.updateSaldoMesProductoToGet(saldomesproducto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		saldomesproducto.setEmpresa(saldomesproductoDataAccess.getEmpresa(connexion,saldomesproducto));
		saldomesproducto.setSucursal(saldomesproductoDataAccess.getSucursal(connexion,saldomesproducto));
		saldomesproducto.setBodega(saldomesproductoDataAccess.getBodega(connexion,saldomesproducto));
		saldomesproducto.setProducto(saldomesproductoDataAccess.getProducto(connexion,saldomesproducto));
		saldomesproducto.setAnio(saldomesproductoDataAccess.getAnio(connexion,saldomesproducto));
		saldomesproducto.setMes(saldomesproductoDataAccess.getMes(connexion,saldomesproducto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				saldomesproducto.setEmpresa(saldomesproductoDataAccess.getEmpresa(connexion,saldomesproducto));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				saldomesproducto.setSucursal(saldomesproductoDataAccess.getSucursal(connexion,saldomesproducto));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				saldomesproducto.setBodega(saldomesproductoDataAccess.getBodega(connexion,saldomesproducto));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				saldomesproducto.setProducto(saldomesproductoDataAccess.getProducto(connexion,saldomesproducto));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				saldomesproducto.setAnio(saldomesproductoDataAccess.getAnio(connexion,saldomesproducto));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				saldomesproducto.setMes(saldomesproductoDataAccess.getMes(connexion,saldomesproducto));
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
			saldomesproducto.setEmpresa(saldomesproductoDataAccess.getEmpresa(connexion,saldomesproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldomesproducto.setSucursal(saldomesproductoDataAccess.getSucursal(connexion,saldomesproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldomesproducto.setBodega(saldomesproductoDataAccess.getBodega(connexion,saldomesproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldomesproducto.setProducto(saldomesproductoDataAccess.getProducto(connexion,saldomesproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldomesproducto.setAnio(saldomesproductoDataAccess.getAnio(connexion,saldomesproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldomesproducto.setMes(saldomesproductoDataAccess.getMes(connexion,saldomesproducto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		saldomesproducto.setEmpresa(saldomesproductoDataAccess.getEmpresa(connexion,saldomesproducto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(saldomesproducto.getEmpresa(),isDeep,deepLoadType,clases);
				
		saldomesproducto.setSucursal(saldomesproductoDataAccess.getSucursal(connexion,saldomesproducto));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(saldomesproducto.getSucursal(),isDeep,deepLoadType,clases);
				
		saldomesproducto.setBodega(saldomesproductoDataAccess.getBodega(connexion,saldomesproducto));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(saldomesproducto.getBodega(),isDeep,deepLoadType,clases);
				
		saldomesproducto.setProducto(saldomesproductoDataAccess.getProducto(connexion,saldomesproducto));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(saldomesproducto.getProducto(),isDeep,deepLoadType,clases);
				
		saldomesproducto.setAnio(saldomesproductoDataAccess.getAnio(connexion,saldomesproducto));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(saldomesproducto.getAnio(),isDeep,deepLoadType,clases);
				
		saldomesproducto.setMes(saldomesproductoDataAccess.getMes(connexion,saldomesproducto));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(saldomesproducto.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				saldomesproducto.setEmpresa(saldomesproductoDataAccess.getEmpresa(connexion,saldomesproducto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(saldomesproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				saldomesproducto.setSucursal(saldomesproductoDataAccess.getSucursal(connexion,saldomesproducto));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(saldomesproducto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				saldomesproducto.setBodega(saldomesproductoDataAccess.getBodega(connexion,saldomesproducto));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(saldomesproducto.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				saldomesproducto.setProducto(saldomesproductoDataAccess.getProducto(connexion,saldomesproducto));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(saldomesproducto.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				saldomesproducto.setAnio(saldomesproductoDataAccess.getAnio(connexion,saldomesproducto));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(saldomesproducto.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				saldomesproducto.setMes(saldomesproductoDataAccess.getMes(connexion,saldomesproducto));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(saldomesproducto.getMes(),isDeep,deepLoadType,clases);				
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
			saldomesproducto.setEmpresa(saldomesproductoDataAccess.getEmpresa(connexion,saldomesproducto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(saldomesproducto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldomesproducto.setSucursal(saldomesproductoDataAccess.getSucursal(connexion,saldomesproducto));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(saldomesproducto.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldomesproducto.setBodega(saldomesproductoDataAccess.getBodega(connexion,saldomesproducto));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(saldomesproducto.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldomesproducto.setProducto(saldomesproductoDataAccess.getProducto(connexion,saldomesproducto));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(saldomesproducto.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldomesproducto.setAnio(saldomesproductoDataAccess.getAnio(connexion,saldomesproducto));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(saldomesproducto.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldomesproducto.setMes(saldomesproductoDataAccess.getMes(connexion,saldomesproducto));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(saldomesproducto.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(SaldoMesProducto saldomesproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			SaldoMesProductoLogicAdditional.updateSaldoMesProductoToSave(saldomesproducto,this.arrDatoGeneral);
			
SaldoMesProductoDataAccess.save(saldomesproducto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(saldomesproducto.getEmpresa(),connexion);

		SucursalDataAccess.save(saldomesproducto.getSucursal(),connexion);

		BodegaDataAccess.save(saldomesproducto.getBodega(),connexion);

		ProductoDataAccess.save(saldomesproducto.getProducto(),connexion);

		AnioDataAccess.save(saldomesproducto.getAnio(),connexion);

		MesDataAccess.save(saldomesproducto.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(saldomesproducto.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(saldomesproducto.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(saldomesproducto.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(saldomesproducto.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(saldomesproducto.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(saldomesproducto.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(saldomesproducto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(saldomesproducto.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(saldomesproducto.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(saldomesproducto.getSucursal(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(saldomesproducto.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(saldomesproducto.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(saldomesproducto.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(saldomesproducto.getProducto(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(saldomesproducto.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(saldomesproducto.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(saldomesproducto.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(saldomesproducto.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(saldomesproducto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(saldomesproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(saldomesproducto.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(saldomesproducto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(saldomesproducto.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(saldomesproducto.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(saldomesproducto.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(saldomesproducto.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(saldomesproducto.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(saldomesproducto.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(saldomesproducto.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(saldomesproducto.getMes(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(SaldoMesProducto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(saldomesproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(saldomesproducto);
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
			this.deepLoad(this.saldomesproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(SaldoMesProducto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(saldomesproductos!=null) {
				for(SaldoMesProducto saldomesproducto:saldomesproductos) {
					this.deepLoad(saldomesproducto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(saldomesproductos);
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
			if(saldomesproductos!=null) {
				for(SaldoMesProducto saldomesproducto:saldomesproductos) {
					this.deepLoad(saldomesproducto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(saldomesproductos);
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
			this.getNewConnexionToDeep(SaldoMesProducto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(saldomesproducto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(SaldoMesProducto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(saldomesproductos!=null) {
				for(SaldoMesProducto saldomesproducto:saldomesproductos) {
					this.deepSave(saldomesproducto,isDeep,deepLoadType,clases);
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
			if(saldomesproductos!=null) {
				for(SaldoMesProducto saldomesproducto:saldomesproductos) {
					this.deepSave(saldomesproducto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getSaldoMesProductosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,SaldoMesProductoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldomesproductos=saldomesproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSaldoMesProductosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,SaldoMesProductoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldomesproductos=saldomesproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSaldoMesProductosFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,SaldoMesProductoConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldomesproductos=saldomesproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSaldoMesProductosFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,SaldoMesProductoConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldomesproductos=saldomesproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSaldoMesProductosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SaldoMesProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldomesproductos=saldomesproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSaldoMesProductosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SaldoMesProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldomesproductos=saldomesproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSaldoMesProductosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,SaldoMesProductoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldomesproductos=saldomesproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSaldoMesProductosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,SaldoMesProductoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldomesproductos=saldomesproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSaldoMesProductosFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,SaldoMesProductoConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldomesproductos=saldomesproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSaldoMesProductosFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,SaldoMesProductoConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldomesproductos=saldomesproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSaldoMesProductosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoMesProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,SaldoMesProductoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldomesproductos=saldomesproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSaldoMesProductosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,SaldoMesProductoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			SaldoMesProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldomesproductos=saldomesproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoMesProductoConstantesFunciones.refrescarForeignKeysDescripcionesSaldoMesProducto(this.saldomesproductos);
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
			if(SaldoMesProductoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,SaldoMesProductoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,SaldoMesProducto saldomesproducto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(SaldoMesProductoConstantesFunciones.ISCONAUDITORIA) {
				if(saldomesproducto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SaldoMesProductoDataAccess.TABLENAME, saldomesproducto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SaldoMesProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SaldoMesProductoLogic.registrarAuditoriaDetallesSaldoMesProducto(connexion,saldomesproducto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(saldomesproducto.getIsDeleted()) {
					/*if(!saldomesproducto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,SaldoMesProductoDataAccess.TABLENAME, saldomesproducto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////SaldoMesProductoLogic.registrarAuditoriaDetallesSaldoMesProducto(connexion,saldomesproducto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SaldoMesProductoDataAccess.TABLENAME, saldomesproducto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(saldomesproducto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SaldoMesProductoDataAccess.TABLENAME, saldomesproducto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SaldoMesProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SaldoMesProductoLogic.registrarAuditoriaDetallesSaldoMesProducto(connexion,saldomesproducto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesSaldoMesProducto(Connexion connexion,SaldoMesProducto saldomesproducto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(saldomesproducto.getIsNew()||!saldomesproducto.getid_empresa().equals(saldomesproducto.getSaldoMesProductoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(saldomesproducto.getSaldoMesProductoOriginal().getid_empresa()!=null)
				{
					strValorActual=saldomesproducto.getSaldoMesProductoOriginal().getid_empresa().toString();
				}
				if(saldomesproducto.getid_empresa()!=null)
				{
					strValorNuevo=saldomesproducto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SaldoMesProductoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(saldomesproducto.getIsNew()||!saldomesproducto.getid_sucursal().equals(saldomesproducto.getSaldoMesProductoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(saldomesproducto.getSaldoMesProductoOriginal().getid_sucursal()!=null)
				{
					strValorActual=saldomesproducto.getSaldoMesProductoOriginal().getid_sucursal().toString();
				}
				if(saldomesproducto.getid_sucursal()!=null)
				{
					strValorNuevo=saldomesproducto.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SaldoMesProductoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(saldomesproducto.getIsNew()||!saldomesproducto.getid_bodega().equals(saldomesproducto.getSaldoMesProductoOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(saldomesproducto.getSaldoMesProductoOriginal().getid_bodega()!=null)
				{
					strValorActual=saldomesproducto.getSaldoMesProductoOriginal().getid_bodega().toString();
				}
				if(saldomesproducto.getid_bodega()!=null)
				{
					strValorNuevo=saldomesproducto.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SaldoMesProductoConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(saldomesproducto.getIsNew()||!saldomesproducto.getid_producto().equals(saldomesproducto.getSaldoMesProductoOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(saldomesproducto.getSaldoMesProductoOriginal().getid_producto()!=null)
				{
					strValorActual=saldomesproducto.getSaldoMesProductoOriginal().getid_producto().toString();
				}
				if(saldomesproducto.getid_producto()!=null)
				{
					strValorNuevo=saldomesproducto.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SaldoMesProductoConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(saldomesproducto.getIsNew()||!saldomesproducto.getid_anio().equals(saldomesproducto.getSaldoMesProductoOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(saldomesproducto.getSaldoMesProductoOriginal().getid_anio()!=null)
				{
					strValorActual=saldomesproducto.getSaldoMesProductoOriginal().getid_anio().toString();
				}
				if(saldomesproducto.getid_anio()!=null)
				{
					strValorNuevo=saldomesproducto.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SaldoMesProductoConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(saldomesproducto.getIsNew()||!saldomesproducto.getid_mes().equals(saldomesproducto.getSaldoMesProductoOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(saldomesproducto.getSaldoMesProductoOriginal().getid_mes()!=null)
				{
					strValorActual=saldomesproducto.getSaldoMesProductoOriginal().getid_mes().toString();
				}
				if(saldomesproducto.getid_mes()!=null)
				{
					strValorNuevo=saldomesproducto.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SaldoMesProductoConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(saldomesproducto.getIsNew()||!saldomesproducto.getsaldo().equals(saldomesproducto.getSaldoMesProductoOriginal().getsaldo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(saldomesproducto.getSaldoMesProductoOriginal().getsaldo()!=null)
				{
					strValorActual=saldomesproducto.getSaldoMesProductoOriginal().getsaldo().toString();
				}
				if(saldomesproducto.getsaldo()!=null)
				{
					strValorNuevo=saldomesproducto.getsaldo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SaldoMesProductoConstantesFunciones.SALDO,strValorActual,strValorNuevo);
			}	
			
			if(saldomesproducto.getIsNew()||!saldomesproducto.getcosto().equals(saldomesproducto.getSaldoMesProductoOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(saldomesproducto.getSaldoMesProductoOriginal().getcosto()!=null)
				{
					strValorActual=saldomesproducto.getSaldoMesProductoOriginal().getcosto().toString();
				}
				if(saldomesproducto.getcosto()!=null)
				{
					strValorNuevo=saldomesproducto.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SaldoMesProductoConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveSaldoMesProductoRelacionesWithConnection(SaldoMesProducto saldomesproducto) throws Exception {

		if(!saldomesproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSaldoMesProductoRelacionesBase(saldomesproducto,true);
		}
	}

	public void saveSaldoMesProductoRelaciones(SaldoMesProducto saldomesproducto)throws Exception {

		if(!saldomesproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSaldoMesProductoRelacionesBase(saldomesproducto,false);
		}
	}

	public void saveSaldoMesProductoRelacionesBase(SaldoMesProducto saldomesproducto,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("SaldoMesProducto-saveRelacionesWithConnection");}
	

			this.setSaldoMesProducto(saldomesproducto);

			if(SaldoMesProductoLogicAdditional.validarSaveRelaciones(saldomesproducto,this)) {

				SaldoMesProductoLogicAdditional.updateRelacionesToSave(saldomesproducto,this);

				if((saldomesproducto.getIsNew()||saldomesproducto.getIsChanged())&&!saldomesproducto.getIsDeleted()) {
					this.saveSaldoMesProducto();
					this.saveSaldoMesProductoRelacionesDetalles();

				} else if(saldomesproducto.getIsDeleted()) {
					this.saveSaldoMesProductoRelacionesDetalles();
					this.saveSaldoMesProducto();
				}

				SaldoMesProductoLogicAdditional.updateRelacionesToSaveAfter(saldomesproducto,this);

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
	
	
	private void saveSaldoMesProductoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfSaldoMesProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SaldoMesProductoConstantesFunciones.getClassesForeignKeysOfSaldoMesProducto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSaldoMesProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SaldoMesProductoConstantesFunciones.getClassesRelationshipsOfSaldoMesProducto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

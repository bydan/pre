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
import com.bydan.erp.facturacion.util.TipoEstadoPedidoConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoEstadoPedidoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoEstadoPedidoParameterGeneral;
import com.bydan.erp.facturacion.business.entity.TipoEstadoPedido;
//import com.bydan.erp.facturacion.business.logic.TipoEstadoPedidoLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoEstadoPedidoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoEstadoPedidoLogic.class);
	
	protected TipoEstadoPedidoDataAccess tipoestadopedidoDataAccess; 	
	protected TipoEstadoPedido tipoestadopedido;
	protected List<TipoEstadoPedido> tipoestadopedidos;
	protected Object tipoestadopedidoObject;	
	protected List<Object> tipoestadopedidosObject;
	
	public static ClassValidator<TipoEstadoPedido> tipoestadopedidoValidator = new ClassValidator<TipoEstadoPedido>(TipoEstadoPedido.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
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
	
	
	
	
	public  TipoEstadoPedidoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoestadopedidoDataAccess = new TipoEstadoPedidoDataAccess();
			
			this.tipoestadopedidos= new ArrayList<TipoEstadoPedido>();
			this.tipoestadopedido= new TipoEstadoPedido();
			
			this.tipoestadopedidoObject=new Object();
			this.tipoestadopedidosObject=new ArrayList<Object>();
				
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
			
			this.tipoestadopedidoDataAccess.setConnexionType(this.connexionType);
			this.tipoestadopedidoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoEstadoPedidoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoestadopedidoDataAccess = new TipoEstadoPedidoDataAccess();
			this.tipoestadopedidos= new ArrayList<TipoEstadoPedido>();
			this.tipoestadopedido= new TipoEstadoPedido();
			this.tipoestadopedidoObject=new Object();
			this.tipoestadopedidosObject=new ArrayList<Object>();
			
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
			
			this.tipoestadopedidoDataAccess.setConnexionType(this.connexionType);
			this.tipoestadopedidoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoEstadoPedido getTipoEstadoPedido() throws Exception {	
		//TipoEstadoPedidoLogicAdditional.checkTipoEstadoPedidoToGet(tipoestadopedido,this.datosCliente,this.arrDatoGeneral);
		//TipoEstadoPedidoLogicAdditional.updateTipoEstadoPedidoToGet(tipoestadopedido,this.arrDatoGeneral);
		
		return tipoestadopedido;
	}
		
	public void setTipoEstadoPedido(TipoEstadoPedido newTipoEstadoPedido) {
		this.tipoestadopedido = newTipoEstadoPedido;
	}
	
	public TipoEstadoPedidoDataAccess getTipoEstadoPedidoDataAccess() {
		return tipoestadopedidoDataAccess;
	}
	
	public void setTipoEstadoPedidoDataAccess(TipoEstadoPedidoDataAccess newtipoestadopedidoDataAccess) {
		this.tipoestadopedidoDataAccess = newtipoestadopedidoDataAccess;
	}
	
	public List<TipoEstadoPedido> getTipoEstadoPedidos() throws Exception {		
		this.quitarTipoEstadoPedidosNulos();
		
		//TipoEstadoPedidoLogicAdditional.checkTipoEstadoPedidoToGets(tipoestadopedidos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoEstadoPedido tipoestadopedidoLocal: tipoestadopedidos ) {
			//TipoEstadoPedidoLogicAdditional.updateTipoEstadoPedidoToGet(tipoestadopedidoLocal,this.arrDatoGeneral);
		}
		
		return tipoestadopedidos;
	}
	
	public void setTipoEstadoPedidos(List<TipoEstadoPedido> newTipoEstadoPedidos) {
		this.tipoestadopedidos = newTipoEstadoPedidos;
	}
	
	public Object getTipoEstadoPedidoObject() {	
		this.tipoestadopedidoObject=this.tipoestadopedidoDataAccess.getEntityObject();
		return this.tipoestadopedidoObject;
	}
		
	public void setTipoEstadoPedidoObject(Object newTipoEstadoPedidoObject) {
		this.tipoestadopedidoObject = newTipoEstadoPedidoObject;
	}
	
	public List<Object> getTipoEstadoPedidosObject() {		
		this.tipoestadopedidosObject=this.tipoestadopedidoDataAccess.getEntitiesObject();
		return this.tipoestadopedidosObject;
	}
		
	public void setTipoEstadoPedidosObject(List<Object> newTipoEstadoPedidosObject) {
		this.tipoestadopedidosObject = newTipoEstadoPedidosObject;
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
		
		if(this.tipoestadopedidoDataAccess!=null) {
			this.tipoestadopedidoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEstadoPedido.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoestadopedidoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoestadopedidoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoestadopedido = new  TipoEstadoPedido();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEstadoPedido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoestadopedido=tipoestadopedidoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoestadopedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(this.tipoestadopedido);
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
		tipoestadopedido = new  TipoEstadoPedido();
		  		  
        try {
			
			tipoestadopedido=tipoestadopedidoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoestadopedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(this.tipoestadopedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoestadopedido = new  TipoEstadoPedido();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEstadoPedido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoestadopedido=tipoestadopedidoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoestadopedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(this.tipoestadopedido);
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
		tipoestadopedido = new  TipoEstadoPedido();
		  		  
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
		tipoestadopedido = new  TipoEstadoPedido();
		  		  
        try {
			
			tipoestadopedido=tipoestadopedidoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoestadopedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(this.tipoestadopedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoestadopedido = new  TipoEstadoPedido();
		  		  
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
		tipoestadopedido = new  TipoEstadoPedido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEstadoPedido.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoestadopedidoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoestadopedido = new  TipoEstadoPedido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoestadopedidoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoestadopedido = new  TipoEstadoPedido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEstadoPedido.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoestadopedidoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoestadopedido = new  TipoEstadoPedido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoestadopedidoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoestadopedido = new  TipoEstadoPedido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEstadoPedido.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoestadopedidoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoestadopedido = new  TipoEstadoPedido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoestadopedidoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoestadopedidos = new  ArrayList<TipoEstadoPedido>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEstadoPedido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoEstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoestadopedidos=tipoestadopedidoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoEstadoPedido(tipoestadopedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(this.tipoestadopedidos);
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
		tipoestadopedidos = new  ArrayList<TipoEstadoPedido>();
		  		  
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
		tipoestadopedidos = new  ArrayList<TipoEstadoPedido>();
		  		  
        try {			
			TipoEstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoestadopedidos=tipoestadopedidoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoEstadoPedido(tipoestadopedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(this.tipoestadopedidos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoestadopedidos = new  ArrayList<TipoEstadoPedido>();
		  		  
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
		tipoestadopedidos = new  ArrayList<TipoEstadoPedido>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEstadoPedido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoEstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoestadopedidos=tipoestadopedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoEstadoPedido(tipoestadopedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(this.tipoestadopedidos);
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
		tipoestadopedidos = new  ArrayList<TipoEstadoPedido>();
		  		  
        try {
			TipoEstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoestadopedidos=tipoestadopedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoEstadoPedido(tipoestadopedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(this.tipoestadopedidos);
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
		tipoestadopedidos = new  ArrayList<TipoEstadoPedido>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEstadoPedido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoEstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoestadopedidos=tipoestadopedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoEstadoPedido(tipoestadopedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(this.tipoestadopedidos);
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
		tipoestadopedidos = new  ArrayList<TipoEstadoPedido>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoEstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoestadopedidos=tipoestadopedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoEstadoPedido(tipoestadopedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(this.tipoestadopedidos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoestadopedido = new  TipoEstadoPedido();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEstadoPedido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoEstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoestadopedido=tipoestadopedidoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoEstadoPedido(tipoestadopedido);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(this.tipoestadopedido);
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
		tipoestadopedido = new  TipoEstadoPedido();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoEstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoestadopedido=tipoestadopedidoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoEstadoPedido(tipoestadopedido);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(this.tipoestadopedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoEstadoPedidosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoestadopedidos = new  ArrayList<TipoEstadoPedido>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEstadoPedido.class.getSimpleName()+"-getTodosTipoEstadoPedidosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoEstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoestadopedidos=tipoestadopedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoEstadoPedido(tipoestadopedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(this.tipoestadopedidos);
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
	
	public  void  getTodosTipoEstadoPedidos(String sFinalQuery,Pagination pagination)throws Exception {
		tipoestadopedidos = new  ArrayList<TipoEstadoPedido>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoEstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoestadopedidos=tipoestadopedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoEstadoPedido(tipoestadopedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(this.tipoestadopedidos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoEstadoPedido(TipoEstadoPedido tipoestadopedido) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoestadopedido.getIsNew() || tipoestadopedido.getIsChanged()) { 
			this.invalidValues = tipoestadopedidoValidator.getInvalidValues(tipoestadopedido);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoestadopedido);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoEstadoPedido(List<TipoEstadoPedido> TipoEstadoPedidos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoEstadoPedido tipoestadopedidoLocal:tipoestadopedidos) {				
			estaValidadoObjeto=this.validarGuardarTipoEstadoPedido(tipoestadopedidoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoEstadoPedido(List<TipoEstadoPedido> TipoEstadoPedidos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoEstadoPedido(tipoestadopedidos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoEstadoPedido(TipoEstadoPedido TipoEstadoPedido) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoEstadoPedido(tipoestadopedido)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoEstadoPedido tipoestadopedido) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoestadopedido.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoEstadoPedidoConstantesFunciones.getTipoEstadoPedidoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoestadopedido","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoEstadoPedidoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoEstadoPedidoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoEstadoPedidoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEstadoPedido.class.getSimpleName()+"-saveTipoEstadoPedidoWithConnection");connexion.begin();			
			
			//TipoEstadoPedidoLogicAdditional.checkTipoEstadoPedidoToSave(this.tipoestadopedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoEstadoPedidoLogicAdditional.updateTipoEstadoPedidoToSave(this.tipoestadopedido,this.arrDatoGeneral);
			
			TipoEstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoestadopedido,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoEstadoPedido();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoEstadoPedido(this.tipoestadopedido)) {
				TipoEstadoPedidoDataAccess.save(this.tipoestadopedido, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoestadopedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoEstadoPedidoLogicAdditional.checkTipoEstadoPedidoToSaveAfter(this.tipoestadopedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoEstadoPedido();
			
			connexion.commit();			
			
			if(this.tipoestadopedido.getIsDeleted()) {
				this.tipoestadopedido=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoEstadoPedido()throws Exception {	
		try {	
			
			//TipoEstadoPedidoLogicAdditional.checkTipoEstadoPedidoToSave(this.tipoestadopedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoEstadoPedidoLogicAdditional.updateTipoEstadoPedidoToSave(this.tipoestadopedido,this.arrDatoGeneral);
			
			TipoEstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoestadopedido,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoEstadoPedido(this.tipoestadopedido)) {			
				TipoEstadoPedidoDataAccess.save(this.tipoestadopedido, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoestadopedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoEstadoPedidoLogicAdditional.checkTipoEstadoPedidoToSaveAfter(this.tipoestadopedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoestadopedido.getIsDeleted()) {
				this.tipoestadopedido=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoEstadoPedidosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEstadoPedido.class.getSimpleName()+"-saveTipoEstadoPedidosWithConnection");connexion.begin();			
			
			//TipoEstadoPedidoLogicAdditional.checkTipoEstadoPedidoToSaves(tipoestadopedidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoEstadoPedidos();
			
			Boolean validadoTodosTipoEstadoPedido=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoEstadoPedido tipoestadopedidoLocal:tipoestadopedidos) {		
				if(tipoestadopedidoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoEstadoPedidoLogicAdditional.updateTipoEstadoPedidoToSave(tipoestadopedidoLocal,this.arrDatoGeneral);
	        	
				TipoEstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoestadopedidoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoEstadoPedido(tipoestadopedidoLocal)) {
					TipoEstadoPedidoDataAccess.save(tipoestadopedidoLocal, connexion);				
				} else {
					validadoTodosTipoEstadoPedido=false;
				}
			}
			
			if(!validadoTodosTipoEstadoPedido) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoEstadoPedidoLogicAdditional.checkTipoEstadoPedidoToSavesAfter(tipoestadopedidos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoEstadoPedidos();
			
			connexion.commit();		
			
			this.quitarTipoEstadoPedidosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoEstadoPedidos()throws Exception {				
		 try {	
			//TipoEstadoPedidoLogicAdditional.checkTipoEstadoPedidoToSaves(tipoestadopedidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoEstadoPedido=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoEstadoPedido tipoestadopedidoLocal:tipoestadopedidos) {				
				if(tipoestadopedidoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoEstadoPedidoLogicAdditional.updateTipoEstadoPedidoToSave(tipoestadopedidoLocal,this.arrDatoGeneral);
	        	
				TipoEstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoestadopedidoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoEstadoPedido(tipoestadopedidoLocal)) {				
					TipoEstadoPedidoDataAccess.save(tipoestadopedidoLocal, connexion);				
				} else {
					validadoTodosTipoEstadoPedido=false;
				}
			}
			
			if(!validadoTodosTipoEstadoPedido) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoEstadoPedidoLogicAdditional.checkTipoEstadoPedidoToSavesAfter(tipoestadopedidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoEstadoPedidosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoEstadoPedidoParameterReturnGeneral procesarAccionTipoEstadoPedidos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoEstadoPedido> tipoestadopedidos,TipoEstadoPedidoParameterReturnGeneral tipoestadopedidoParameterGeneral)throws Exception {
		 try {	
			TipoEstadoPedidoParameterReturnGeneral tipoestadopedidoReturnGeneral=new TipoEstadoPedidoParameterReturnGeneral();
	
			
			return tipoestadopedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoEstadoPedidoParameterReturnGeneral procesarAccionTipoEstadoPedidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoEstadoPedido> tipoestadopedidos,TipoEstadoPedidoParameterReturnGeneral tipoestadopedidoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEstadoPedido.class.getSimpleName()+"-procesarAccionTipoEstadoPedidosWithConnection");connexion.begin();			
			
			TipoEstadoPedidoParameterReturnGeneral tipoestadopedidoReturnGeneral=new TipoEstadoPedidoParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipoestadopedidoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoEstadoPedidoParameterReturnGeneral procesarEventosTipoEstadoPedidos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoEstadoPedido> tipoestadopedidos,TipoEstadoPedido tipoestadopedido,TipoEstadoPedidoParameterReturnGeneral tipoestadopedidoParameterGeneral,Boolean isEsNuevoTipoEstadoPedido,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoEstadoPedidoParameterReturnGeneral tipoestadopedidoReturnGeneral=new TipoEstadoPedidoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoestadopedidoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipoestadopedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoEstadoPedidoParameterReturnGeneral procesarEventosTipoEstadoPedidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoEstadoPedido> tipoestadopedidos,TipoEstadoPedido tipoestadopedido,TipoEstadoPedidoParameterReturnGeneral tipoestadopedidoParameterGeneral,Boolean isEsNuevoTipoEstadoPedido,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEstadoPedido.class.getSimpleName()+"-procesarEventosTipoEstadoPedidosWithConnection");connexion.begin();			
			
			TipoEstadoPedidoParameterReturnGeneral tipoestadopedidoReturnGeneral=new TipoEstadoPedidoParameterReturnGeneral();
	
			tipoestadopedidoReturnGeneral.setTipoEstadoPedido(tipoestadopedido);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoestadopedidoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipoestadopedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoEstadoPedidoParameterReturnGeneral procesarImportacionTipoEstadoPedidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoEstadoPedidoParameterReturnGeneral tipoestadopedidoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEstadoPedido.class.getSimpleName()+"-procesarImportacionTipoEstadoPedidosWithConnection");connexion.begin();			
			
			TipoEstadoPedidoParameterReturnGeneral tipoestadopedidoReturnGeneral=new TipoEstadoPedidoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoestadopedidos=new ArrayList<TipoEstadoPedido>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoestadopedido=new TipoEstadoPedido();
				
				
				if(conColumnasBase) {this.tipoestadopedido.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoestadopedido.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoestadopedido.setnombre(arrColumnas[iColumn++]);
				
				this.tipoestadopedidos.add(this.tipoestadopedido);
			}
			
			this.saveTipoEstadoPedidos();
			
			this.connexion.commit();
			
			tipoestadopedidoReturnGeneral.setConRetornoEstaProcesado(true);
			tipoestadopedidoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoestadopedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoEstadoPedidosEliminados() throws Exception {				
		
		List<TipoEstadoPedido> tipoestadopedidosAux= new ArrayList<TipoEstadoPedido>();
		
		for(TipoEstadoPedido tipoestadopedido:tipoestadopedidos) {
			if(!tipoestadopedido.getIsDeleted()) {
				tipoestadopedidosAux.add(tipoestadopedido);
			}
		}
		
		tipoestadopedidos=tipoestadopedidosAux;
	}
	
	public void quitarTipoEstadoPedidosNulos() throws Exception {				
		
		List<TipoEstadoPedido> tipoestadopedidosAux= new ArrayList<TipoEstadoPedido>();
		
		for(TipoEstadoPedido tipoestadopedido : this.tipoestadopedidos) {
			if(tipoestadopedido==null) {
				tipoestadopedidosAux.add(tipoestadopedido);
			}
		}
		
		//this.tipoestadopedidos=tipoestadopedidosAux;
		
		this.tipoestadopedidos.removeAll(tipoestadopedidosAux);
	}
	
	public void getSetVersionRowTipoEstadoPedidoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoestadopedido.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoestadopedido.getIsDeleted() || (tipoestadopedido.getIsChanged()&&!tipoestadopedido.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoestadopedidoDataAccess.getSetVersionRowTipoEstadoPedido(connexion,tipoestadopedido.getId());
				
				if(!tipoestadopedido.getVersionRow().equals(timestamp)) {	
					tipoestadopedido.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoestadopedido.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoEstadoPedido()throws Exception {	
		
		if(tipoestadopedido.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoestadopedido.getIsDeleted() || (tipoestadopedido.getIsChanged()&&!tipoestadopedido.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoestadopedidoDataAccess.getSetVersionRowTipoEstadoPedido(connexion,tipoestadopedido.getId());
			
			try {							
				if(!tipoestadopedido.getVersionRow().equals(timestamp)) {	
					tipoestadopedido.setVersionRow(timestamp);
				}
				
				tipoestadopedido.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoEstadoPedidosWithConnection()throws Exception {	
		if(tipoestadopedidos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoEstadoPedido tipoestadopedidoAux:tipoestadopedidos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoestadopedidoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoestadopedidoAux.getIsDeleted() || (tipoestadopedidoAux.getIsChanged()&&!tipoestadopedidoAux.getIsNew())) {
						
						timestamp=tipoestadopedidoDataAccess.getSetVersionRowTipoEstadoPedido(connexion,tipoestadopedidoAux.getId());
						
						if(!tipoestadopedido.getVersionRow().equals(timestamp)) {	
							tipoestadopedidoAux.setVersionRow(timestamp);
						}
								
						tipoestadopedidoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoEstadoPedidos()throws Exception {	
		if(tipoestadopedidos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoEstadoPedido tipoestadopedidoAux:tipoestadopedidos) {
					if(tipoestadopedidoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoestadopedidoAux.getIsDeleted() || (tipoestadopedidoAux.getIsChanged()&&!tipoestadopedidoAux.getIsNew())) {
						
						timestamp=tipoestadopedidoDataAccess.getSetVersionRowTipoEstadoPedido(connexion,tipoestadopedidoAux.getId());
						
						if(!tipoestadopedidoAux.getVersionRow().equals(timestamp)) {	
							tipoestadopedidoAux.setVersionRow(timestamp);
						}
						
													
						tipoestadopedidoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoEstadoPedidoParameterReturnGeneral cargarCombosLoteForeignKeyTipoEstadoPedidoWithConnection(String finalQueryGlobalPais) throws Exception {
		TipoEstadoPedidoParameterReturnGeneral  tipoestadopedidoReturnGeneral =new TipoEstadoPedidoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEstadoPedido.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoEstadoPedidoWithConnection");connexion.begin();
			
			tipoestadopedidoReturnGeneral =new TipoEstadoPedidoParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			tipoestadopedidoReturnGeneral.setpaissForeignKey(paissForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoestadopedidoReturnGeneral;
	}
	
	public TipoEstadoPedidoParameterReturnGeneral cargarCombosLoteForeignKeyTipoEstadoPedido(String finalQueryGlobalPais) throws Exception {
		TipoEstadoPedidoParameterReturnGeneral  tipoestadopedidoReturnGeneral =new TipoEstadoPedidoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoestadopedidoReturnGeneral =new TipoEstadoPedidoParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			tipoestadopedidoReturnGeneral.setpaissForeignKey(paissForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoestadopedidoReturnGeneral;
	}
	
	
	public void deepLoad(TipoEstadoPedido tipoestadopedido,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoEstadoPedidoLogicAdditional.updateTipoEstadoPedidoToGet(tipoestadopedido,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoestadopedido.setPais(tipoestadopedidoDataAccess.getPais(connexion,tipoestadopedido));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				tipoestadopedido.setPais(tipoestadopedidoDataAccess.getPais(connexion,tipoestadopedido));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipoestadopedido.setPais(tipoestadopedidoDataAccess.getPais(connexion,tipoestadopedido));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoestadopedido.setPais(tipoestadopedidoDataAccess.getPais(connexion,tipoestadopedido));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(tipoestadopedido.getPais(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				tipoestadopedido.setPais(tipoestadopedidoDataAccess.getPais(connexion,tipoestadopedido));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(tipoestadopedido.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipoestadopedido.setPais(tipoestadopedidoDataAccess.getPais(connexion,tipoestadopedido));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(tipoestadopedido.getPais(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoEstadoPedido tipoestadopedido,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoEstadoPedido.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoestadopedido,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(tipoestadopedido);
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
			this.deepLoad(this.tipoestadopedido,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(this.tipoestadopedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoEstadoPedido.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoestadopedidos!=null) {
				for(TipoEstadoPedido tipoestadopedido:tipoestadopedidos) {
					this.deepLoad(tipoestadopedido,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(tipoestadopedidos);
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
			if(tipoestadopedidos!=null) {
				for(TipoEstadoPedido tipoestadopedido:tipoestadopedidos) {
					this.deepLoad(tipoestadopedido,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(tipoestadopedidos);
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
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoEstadoPedidosFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEstadoPedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,TipoEstadoPedidoConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			TipoEstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoestadopedidos=tipoestadopedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(this.tipoestadopedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoEstadoPedidosFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,TipoEstadoPedidoConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			TipoEstadoPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoestadopedidos=tipoestadopedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(this.tipoestadopedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoEstadoPedidoPorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEstadoPedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoEstadoPedidoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipoestadopedido=tipoestadopedidoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipoestadopedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(this.tipoestadopedido);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoEstadoPedidoPorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoEstadoPedidoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipoestadopedido=tipoestadopedidoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipoestadopedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoEstadoPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEstadoPedido(this.tipoestadopedido);
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
			if(TipoEstadoPedidoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoEstadoPedidoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoEstadoPedido tipoestadopedido,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoEstadoPedidoConstantesFunciones.ISCONAUDITORIA) {
				if(tipoestadopedido.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoEstadoPedidoDataAccess.TABLENAME, tipoestadopedido.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoEstadoPedidoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoEstadoPedidoLogic.registrarAuditoriaDetallesTipoEstadoPedido(connexion,tipoestadopedido,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoestadopedido.getIsDeleted()) {
					/*if(!tipoestadopedido.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoEstadoPedidoDataAccess.TABLENAME, tipoestadopedido.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoEstadoPedidoLogic.registrarAuditoriaDetallesTipoEstadoPedido(connexion,tipoestadopedido,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoEstadoPedidoDataAccess.TABLENAME, tipoestadopedido.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoestadopedido.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoEstadoPedidoDataAccess.TABLENAME, tipoestadopedido.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoEstadoPedidoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoEstadoPedidoLogic.registrarAuditoriaDetallesTipoEstadoPedido(connexion,tipoestadopedido,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoEstadoPedido(Connexion connexion,TipoEstadoPedido tipoestadopedido)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoestadopedido.getIsNew()||!tipoestadopedido.getid_pais().equals(tipoestadopedido.getTipoEstadoPedidoOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoestadopedido.getTipoEstadoPedidoOriginal().getid_pais()!=null)
				{
					strValorActual=tipoestadopedido.getTipoEstadoPedidoOriginal().getid_pais().toString();
				}
				if(tipoestadopedido.getid_pais()!=null)
				{
					strValorNuevo=tipoestadopedido.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoEstadoPedidoConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(tipoestadopedido.getIsNew()||!tipoestadopedido.getnombre().equals(tipoestadopedido.getTipoEstadoPedidoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoestadopedido.getTipoEstadoPedidoOriginal().getnombre()!=null)
				{
					strValorActual=tipoestadopedido.getTipoEstadoPedidoOriginal().getnombre();
				}
				if(tipoestadopedido.getnombre()!=null)
				{
					strValorNuevo=tipoestadopedido.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoEstadoPedidoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoEstadoPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoEstadoPedidoConstantesFunciones.getClassesForeignKeysOfTipoEstadoPedido(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoEstadoPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoEstadoPedidoConstantesFunciones.getClassesRelationshipsOfTipoEstadoPedido(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

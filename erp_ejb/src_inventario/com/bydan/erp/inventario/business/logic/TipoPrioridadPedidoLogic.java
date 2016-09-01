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
import com.bydan.erp.inventario.util.TipoPrioridadPedidoConstantesFunciones;
import com.bydan.erp.inventario.util.TipoPrioridadPedidoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoPrioridadPedidoParameterGeneral;
import com.bydan.erp.inventario.business.entity.TipoPrioridadPedido;
//import com.bydan.erp.inventario.business.logic.TipoPrioridadPedidoLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoPrioridadPedidoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoPrioridadPedidoLogic.class);
	
	protected TipoPrioridadPedidoDataAccess tipoprioridadpedidoDataAccess; 	
	protected TipoPrioridadPedido tipoprioridadpedido;
	protected List<TipoPrioridadPedido> tipoprioridadpedidos;
	protected Object tipoprioridadpedidoObject;	
	protected List<Object> tipoprioridadpedidosObject;
	
	public static ClassValidator<TipoPrioridadPedido> tipoprioridadpedidoValidator = new ClassValidator<TipoPrioridadPedido>(TipoPrioridadPedido.class);	
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
	
	
	
	
	public  TipoPrioridadPedidoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoprioridadpedidoDataAccess = new TipoPrioridadPedidoDataAccess();
			
			this.tipoprioridadpedidos= new ArrayList<TipoPrioridadPedido>();
			this.tipoprioridadpedido= new TipoPrioridadPedido();
			
			this.tipoprioridadpedidoObject=new Object();
			this.tipoprioridadpedidosObject=new ArrayList<Object>();
				
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
			
			this.tipoprioridadpedidoDataAccess.setConnexionType(this.connexionType);
			this.tipoprioridadpedidoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoPrioridadPedidoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoprioridadpedidoDataAccess = new TipoPrioridadPedidoDataAccess();
			this.tipoprioridadpedidos= new ArrayList<TipoPrioridadPedido>();
			this.tipoprioridadpedido= new TipoPrioridadPedido();
			this.tipoprioridadpedidoObject=new Object();
			this.tipoprioridadpedidosObject=new ArrayList<Object>();
			
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
			
			this.tipoprioridadpedidoDataAccess.setConnexionType(this.connexionType);
			this.tipoprioridadpedidoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoPrioridadPedido getTipoPrioridadPedido() throws Exception {	
		//TipoPrioridadPedidoLogicAdditional.checkTipoPrioridadPedidoToGet(tipoprioridadpedido,this.datosCliente,this.arrDatoGeneral);
		//TipoPrioridadPedidoLogicAdditional.updateTipoPrioridadPedidoToGet(tipoprioridadpedido,this.arrDatoGeneral);
		
		return tipoprioridadpedido;
	}
		
	public void setTipoPrioridadPedido(TipoPrioridadPedido newTipoPrioridadPedido) {
		this.tipoprioridadpedido = newTipoPrioridadPedido;
	}
	
	public TipoPrioridadPedidoDataAccess getTipoPrioridadPedidoDataAccess() {
		return tipoprioridadpedidoDataAccess;
	}
	
	public void setTipoPrioridadPedidoDataAccess(TipoPrioridadPedidoDataAccess newtipoprioridadpedidoDataAccess) {
		this.tipoprioridadpedidoDataAccess = newtipoprioridadpedidoDataAccess;
	}
	
	public List<TipoPrioridadPedido> getTipoPrioridadPedidos() throws Exception {		
		this.quitarTipoPrioridadPedidosNulos();
		
		//TipoPrioridadPedidoLogicAdditional.checkTipoPrioridadPedidoToGets(tipoprioridadpedidos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoPrioridadPedido tipoprioridadpedidoLocal: tipoprioridadpedidos ) {
			//TipoPrioridadPedidoLogicAdditional.updateTipoPrioridadPedidoToGet(tipoprioridadpedidoLocal,this.arrDatoGeneral);
		}
		
		return tipoprioridadpedidos;
	}
	
	public void setTipoPrioridadPedidos(List<TipoPrioridadPedido> newTipoPrioridadPedidos) {
		this.tipoprioridadpedidos = newTipoPrioridadPedidos;
	}
	
	public Object getTipoPrioridadPedidoObject() {	
		this.tipoprioridadpedidoObject=this.tipoprioridadpedidoDataAccess.getEntityObject();
		return this.tipoprioridadpedidoObject;
	}
		
	public void setTipoPrioridadPedidoObject(Object newTipoPrioridadPedidoObject) {
		this.tipoprioridadpedidoObject = newTipoPrioridadPedidoObject;
	}
	
	public List<Object> getTipoPrioridadPedidosObject() {		
		this.tipoprioridadpedidosObject=this.tipoprioridadpedidoDataAccess.getEntitiesObject();
		return this.tipoprioridadpedidosObject;
	}
		
	public void setTipoPrioridadPedidosObject(List<Object> newTipoPrioridadPedidosObject) {
		this.tipoprioridadpedidosObject = newTipoPrioridadPedidosObject;
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
		
		if(this.tipoprioridadpedidoDataAccess!=null) {
			this.tipoprioridadpedidoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadPedido.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoprioridadpedidoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoprioridadpedidoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoprioridadpedido = new  TipoPrioridadPedido();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadPedido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoprioridadpedido=tipoprioridadpedidoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprioridadpedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(this.tipoprioridadpedido);
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
		tipoprioridadpedido = new  TipoPrioridadPedido();
		  		  
        try {
			
			tipoprioridadpedido=tipoprioridadpedidoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprioridadpedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(this.tipoprioridadpedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoprioridadpedido = new  TipoPrioridadPedido();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadPedido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoprioridadpedido=tipoprioridadpedidoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprioridadpedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(this.tipoprioridadpedido);
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
		tipoprioridadpedido = new  TipoPrioridadPedido();
		  		  
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
		tipoprioridadpedido = new  TipoPrioridadPedido();
		  		  
        try {
			
			tipoprioridadpedido=tipoprioridadpedidoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprioridadpedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(this.tipoprioridadpedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoprioridadpedido = new  TipoPrioridadPedido();
		  		  
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
		tipoprioridadpedido = new  TipoPrioridadPedido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadPedido.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoprioridadpedidoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprioridadpedido = new  TipoPrioridadPedido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoprioridadpedidoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoprioridadpedido = new  TipoPrioridadPedido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadPedido.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoprioridadpedidoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprioridadpedido = new  TipoPrioridadPedido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoprioridadpedidoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoprioridadpedido = new  TipoPrioridadPedido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadPedido.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoprioridadpedidoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprioridadpedido = new  TipoPrioridadPedido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoprioridadpedidoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoprioridadpedidos = new  ArrayList<TipoPrioridadPedido>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadPedido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoPrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadpedidos=tipoprioridadpedidoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPrioridadPedido(tipoprioridadpedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(this.tipoprioridadpedidos);
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
		tipoprioridadpedidos = new  ArrayList<TipoPrioridadPedido>();
		  		  
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
		tipoprioridadpedidos = new  ArrayList<TipoPrioridadPedido>();
		  		  
        try {			
			TipoPrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadpedidos=tipoprioridadpedidoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoPrioridadPedido(tipoprioridadpedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(this.tipoprioridadpedidos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoprioridadpedidos = new  ArrayList<TipoPrioridadPedido>();
		  		  
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
		tipoprioridadpedidos = new  ArrayList<TipoPrioridadPedido>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadPedido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoPrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadpedidos=tipoprioridadpedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPrioridadPedido(tipoprioridadpedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(this.tipoprioridadpedidos);
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
		tipoprioridadpedidos = new  ArrayList<TipoPrioridadPedido>();
		  		  
        try {
			TipoPrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadpedidos=tipoprioridadpedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPrioridadPedido(tipoprioridadpedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(this.tipoprioridadpedidos);
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
		tipoprioridadpedidos = new  ArrayList<TipoPrioridadPedido>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadPedido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadpedidos=tipoprioridadpedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPrioridadPedido(tipoprioridadpedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(this.tipoprioridadpedidos);
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
		tipoprioridadpedidos = new  ArrayList<TipoPrioridadPedido>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadpedidos=tipoprioridadpedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPrioridadPedido(tipoprioridadpedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(this.tipoprioridadpedidos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoprioridadpedido = new  TipoPrioridadPedido();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadPedido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadpedido=tipoprioridadpedidoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPrioridadPedido(tipoprioridadpedido);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(this.tipoprioridadpedido);
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
		tipoprioridadpedido = new  TipoPrioridadPedido();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadpedido=tipoprioridadpedidoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPrioridadPedido(tipoprioridadpedido);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(this.tipoprioridadpedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoPrioridadPedidosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoprioridadpedidos = new  ArrayList<TipoPrioridadPedido>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadPedido.class.getSimpleName()+"-getTodosTipoPrioridadPedidosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadpedidos=tipoprioridadpedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoPrioridadPedido(tipoprioridadpedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(this.tipoprioridadpedidos);
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
	
	public  void  getTodosTipoPrioridadPedidos(String sFinalQuery,Pagination pagination)throws Exception {
		tipoprioridadpedidos = new  ArrayList<TipoPrioridadPedido>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadpedidos=tipoprioridadpedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoPrioridadPedido(tipoprioridadpedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(this.tipoprioridadpedidos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoPrioridadPedido(TipoPrioridadPedido tipoprioridadpedido) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoprioridadpedido.getIsNew() || tipoprioridadpedido.getIsChanged()) { 
			this.invalidValues = tipoprioridadpedidoValidator.getInvalidValues(tipoprioridadpedido);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoprioridadpedido);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoPrioridadPedido(List<TipoPrioridadPedido> TipoPrioridadPedidos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoPrioridadPedido tipoprioridadpedidoLocal:tipoprioridadpedidos) {				
			estaValidadoObjeto=this.validarGuardarTipoPrioridadPedido(tipoprioridadpedidoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoPrioridadPedido(List<TipoPrioridadPedido> TipoPrioridadPedidos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoPrioridadPedido(tipoprioridadpedidos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoPrioridadPedido(TipoPrioridadPedido TipoPrioridadPedido) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoPrioridadPedido(tipoprioridadpedido)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoPrioridadPedido tipoprioridadpedido) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoprioridadpedido.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoPrioridadPedidoConstantesFunciones.getTipoPrioridadPedidoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoprioridadpedido","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoPrioridadPedidoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoPrioridadPedidoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoPrioridadPedidoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadPedido.class.getSimpleName()+"-saveTipoPrioridadPedidoWithConnection");connexion.begin();			
			
			//TipoPrioridadPedidoLogicAdditional.checkTipoPrioridadPedidoToSave(this.tipoprioridadpedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoPrioridadPedidoLogicAdditional.updateTipoPrioridadPedidoToSave(this.tipoprioridadpedido,this.arrDatoGeneral);
			
			TipoPrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoprioridadpedido,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoPrioridadPedido();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoPrioridadPedido(this.tipoprioridadpedido)) {
				TipoPrioridadPedidoDataAccess.save(this.tipoprioridadpedido, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoprioridadpedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoPrioridadPedidoLogicAdditional.checkTipoPrioridadPedidoToSaveAfter(this.tipoprioridadpedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoPrioridadPedido();
			
			connexion.commit();			
			
			if(this.tipoprioridadpedido.getIsDeleted()) {
				this.tipoprioridadpedido=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoPrioridadPedido()throws Exception {	
		try {	
			
			//TipoPrioridadPedidoLogicAdditional.checkTipoPrioridadPedidoToSave(this.tipoprioridadpedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoPrioridadPedidoLogicAdditional.updateTipoPrioridadPedidoToSave(this.tipoprioridadpedido,this.arrDatoGeneral);
			
			TipoPrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoprioridadpedido,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoPrioridadPedido(this.tipoprioridadpedido)) {			
				TipoPrioridadPedidoDataAccess.save(this.tipoprioridadpedido, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoprioridadpedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoPrioridadPedidoLogicAdditional.checkTipoPrioridadPedidoToSaveAfter(this.tipoprioridadpedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoprioridadpedido.getIsDeleted()) {
				this.tipoprioridadpedido=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoPrioridadPedidosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadPedido.class.getSimpleName()+"-saveTipoPrioridadPedidosWithConnection");connexion.begin();			
			
			//TipoPrioridadPedidoLogicAdditional.checkTipoPrioridadPedidoToSaves(tipoprioridadpedidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoPrioridadPedidos();
			
			Boolean validadoTodosTipoPrioridadPedido=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoPrioridadPedido tipoprioridadpedidoLocal:tipoprioridadpedidos) {		
				if(tipoprioridadpedidoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoPrioridadPedidoLogicAdditional.updateTipoPrioridadPedidoToSave(tipoprioridadpedidoLocal,this.arrDatoGeneral);
	        	
				TipoPrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoprioridadpedidoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoPrioridadPedido(tipoprioridadpedidoLocal)) {
					TipoPrioridadPedidoDataAccess.save(tipoprioridadpedidoLocal, connexion);				
				} else {
					validadoTodosTipoPrioridadPedido=false;
				}
			}
			
			if(!validadoTodosTipoPrioridadPedido) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoPrioridadPedidoLogicAdditional.checkTipoPrioridadPedidoToSavesAfter(tipoprioridadpedidos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoPrioridadPedidos();
			
			connexion.commit();		
			
			this.quitarTipoPrioridadPedidosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoPrioridadPedidos()throws Exception {				
		 try {	
			//TipoPrioridadPedidoLogicAdditional.checkTipoPrioridadPedidoToSaves(tipoprioridadpedidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoPrioridadPedido=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoPrioridadPedido tipoprioridadpedidoLocal:tipoprioridadpedidos) {				
				if(tipoprioridadpedidoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoPrioridadPedidoLogicAdditional.updateTipoPrioridadPedidoToSave(tipoprioridadpedidoLocal,this.arrDatoGeneral);
	        	
				TipoPrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoprioridadpedidoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoPrioridadPedido(tipoprioridadpedidoLocal)) {				
					TipoPrioridadPedidoDataAccess.save(tipoprioridadpedidoLocal, connexion);				
				} else {
					validadoTodosTipoPrioridadPedido=false;
				}
			}
			
			if(!validadoTodosTipoPrioridadPedido) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoPrioridadPedidoLogicAdditional.checkTipoPrioridadPedidoToSavesAfter(tipoprioridadpedidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoPrioridadPedidosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoPrioridadPedidoParameterReturnGeneral procesarAccionTipoPrioridadPedidos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoPrioridadPedido> tipoprioridadpedidos,TipoPrioridadPedidoParameterReturnGeneral tipoprioridadpedidoParameterGeneral)throws Exception {
		 try {	
			TipoPrioridadPedidoParameterReturnGeneral tipoprioridadpedidoReturnGeneral=new TipoPrioridadPedidoParameterReturnGeneral();
	
			
			return tipoprioridadpedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoPrioridadPedidoParameterReturnGeneral procesarAccionTipoPrioridadPedidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoPrioridadPedido> tipoprioridadpedidos,TipoPrioridadPedidoParameterReturnGeneral tipoprioridadpedidoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadPedido.class.getSimpleName()+"-procesarAccionTipoPrioridadPedidosWithConnection");connexion.begin();			
			
			TipoPrioridadPedidoParameterReturnGeneral tipoprioridadpedidoReturnGeneral=new TipoPrioridadPedidoParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipoprioridadpedidoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoPrioridadPedidoParameterReturnGeneral procesarEventosTipoPrioridadPedidos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoPrioridadPedido> tipoprioridadpedidos,TipoPrioridadPedido tipoprioridadpedido,TipoPrioridadPedidoParameterReturnGeneral tipoprioridadpedidoParameterGeneral,Boolean isEsNuevoTipoPrioridadPedido,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoPrioridadPedidoParameterReturnGeneral tipoprioridadpedidoReturnGeneral=new TipoPrioridadPedidoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoprioridadpedidoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipoprioridadpedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoPrioridadPedidoParameterReturnGeneral procesarEventosTipoPrioridadPedidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoPrioridadPedido> tipoprioridadpedidos,TipoPrioridadPedido tipoprioridadpedido,TipoPrioridadPedidoParameterReturnGeneral tipoprioridadpedidoParameterGeneral,Boolean isEsNuevoTipoPrioridadPedido,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadPedido.class.getSimpleName()+"-procesarEventosTipoPrioridadPedidosWithConnection");connexion.begin();			
			
			TipoPrioridadPedidoParameterReturnGeneral tipoprioridadpedidoReturnGeneral=new TipoPrioridadPedidoParameterReturnGeneral();
	
			tipoprioridadpedidoReturnGeneral.setTipoPrioridadPedido(tipoprioridadpedido);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoprioridadpedidoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipoprioridadpedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoPrioridadPedidoParameterReturnGeneral procesarImportacionTipoPrioridadPedidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoPrioridadPedidoParameterReturnGeneral tipoprioridadpedidoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadPedido.class.getSimpleName()+"-procesarImportacionTipoPrioridadPedidosWithConnection");connexion.begin();			
			
			TipoPrioridadPedidoParameterReturnGeneral tipoprioridadpedidoReturnGeneral=new TipoPrioridadPedidoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoprioridadpedidos=new ArrayList<TipoPrioridadPedido>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoprioridadpedido=new TipoPrioridadPedido();
				
				
				if(conColumnasBase) {this.tipoprioridadpedido.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoprioridadpedido.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoprioridadpedido.setnombre(arrColumnas[iColumn++]);
				
				this.tipoprioridadpedidos.add(this.tipoprioridadpedido);
			}
			
			this.saveTipoPrioridadPedidos();
			
			this.connexion.commit();
			
			tipoprioridadpedidoReturnGeneral.setConRetornoEstaProcesado(true);
			tipoprioridadpedidoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoprioridadpedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoPrioridadPedidosEliminados() throws Exception {				
		
		List<TipoPrioridadPedido> tipoprioridadpedidosAux= new ArrayList<TipoPrioridadPedido>();
		
		for(TipoPrioridadPedido tipoprioridadpedido:tipoprioridadpedidos) {
			if(!tipoprioridadpedido.getIsDeleted()) {
				tipoprioridadpedidosAux.add(tipoprioridadpedido);
			}
		}
		
		tipoprioridadpedidos=tipoprioridadpedidosAux;
	}
	
	public void quitarTipoPrioridadPedidosNulos() throws Exception {				
		
		List<TipoPrioridadPedido> tipoprioridadpedidosAux= new ArrayList<TipoPrioridadPedido>();
		
		for(TipoPrioridadPedido tipoprioridadpedido : this.tipoprioridadpedidos) {
			if(tipoprioridadpedido==null) {
				tipoprioridadpedidosAux.add(tipoprioridadpedido);
			}
		}
		
		//this.tipoprioridadpedidos=tipoprioridadpedidosAux;
		
		this.tipoprioridadpedidos.removeAll(tipoprioridadpedidosAux);
	}
	
	public void getSetVersionRowTipoPrioridadPedidoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoprioridadpedido.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoprioridadpedido.getIsDeleted() || (tipoprioridadpedido.getIsChanged()&&!tipoprioridadpedido.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoprioridadpedidoDataAccess.getSetVersionRowTipoPrioridadPedido(connexion,tipoprioridadpedido.getId());
				
				if(!tipoprioridadpedido.getVersionRow().equals(timestamp)) {	
					tipoprioridadpedido.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoprioridadpedido.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoPrioridadPedido()throws Exception {	
		
		if(tipoprioridadpedido.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoprioridadpedido.getIsDeleted() || (tipoprioridadpedido.getIsChanged()&&!tipoprioridadpedido.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoprioridadpedidoDataAccess.getSetVersionRowTipoPrioridadPedido(connexion,tipoprioridadpedido.getId());
			
			try {							
				if(!tipoprioridadpedido.getVersionRow().equals(timestamp)) {	
					tipoprioridadpedido.setVersionRow(timestamp);
				}
				
				tipoprioridadpedido.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoPrioridadPedidosWithConnection()throws Exception {	
		if(tipoprioridadpedidos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoPrioridadPedido tipoprioridadpedidoAux:tipoprioridadpedidos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoprioridadpedidoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoprioridadpedidoAux.getIsDeleted() || (tipoprioridadpedidoAux.getIsChanged()&&!tipoprioridadpedidoAux.getIsNew())) {
						
						timestamp=tipoprioridadpedidoDataAccess.getSetVersionRowTipoPrioridadPedido(connexion,tipoprioridadpedidoAux.getId());
						
						if(!tipoprioridadpedido.getVersionRow().equals(timestamp)) {	
							tipoprioridadpedidoAux.setVersionRow(timestamp);
						}
								
						tipoprioridadpedidoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoPrioridadPedidos()throws Exception {	
		if(tipoprioridadpedidos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoPrioridadPedido tipoprioridadpedidoAux:tipoprioridadpedidos) {
					if(tipoprioridadpedidoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoprioridadpedidoAux.getIsDeleted() || (tipoprioridadpedidoAux.getIsChanged()&&!tipoprioridadpedidoAux.getIsNew())) {
						
						timestamp=tipoprioridadpedidoDataAccess.getSetVersionRowTipoPrioridadPedido(connexion,tipoprioridadpedidoAux.getId());
						
						if(!tipoprioridadpedidoAux.getVersionRow().equals(timestamp)) {	
							tipoprioridadpedidoAux.setVersionRow(timestamp);
						}
						
													
						tipoprioridadpedidoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoPrioridadPedidoParameterReturnGeneral cargarCombosLoteForeignKeyTipoPrioridadPedidoWithConnection(String finalQueryGlobalPais) throws Exception {
		TipoPrioridadPedidoParameterReturnGeneral  tipoprioridadpedidoReturnGeneral =new TipoPrioridadPedidoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadPedido.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoPrioridadPedidoWithConnection");connexion.begin();
			
			tipoprioridadpedidoReturnGeneral =new TipoPrioridadPedidoParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			tipoprioridadpedidoReturnGeneral.setpaissForeignKey(paissForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoprioridadpedidoReturnGeneral;
	}
	
	public TipoPrioridadPedidoParameterReturnGeneral cargarCombosLoteForeignKeyTipoPrioridadPedido(String finalQueryGlobalPais) throws Exception {
		TipoPrioridadPedidoParameterReturnGeneral  tipoprioridadpedidoReturnGeneral =new TipoPrioridadPedidoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoprioridadpedidoReturnGeneral =new TipoPrioridadPedidoParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			tipoprioridadpedidoReturnGeneral.setpaissForeignKey(paissForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoprioridadpedidoReturnGeneral;
	}
	
	
	public void deepLoad(TipoPrioridadPedido tipoprioridadpedido,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoPrioridadPedidoLogicAdditional.updateTipoPrioridadPedidoToGet(tipoprioridadpedido,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoprioridadpedido.setPais(tipoprioridadpedidoDataAccess.getPais(connexion,tipoprioridadpedido));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				tipoprioridadpedido.setPais(tipoprioridadpedidoDataAccess.getPais(connexion,tipoprioridadpedido));
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
			tipoprioridadpedido.setPais(tipoprioridadpedidoDataAccess.getPais(connexion,tipoprioridadpedido));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoprioridadpedido.setPais(tipoprioridadpedidoDataAccess.getPais(connexion,tipoprioridadpedido));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(tipoprioridadpedido.getPais(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				tipoprioridadpedido.setPais(tipoprioridadpedidoDataAccess.getPais(connexion,tipoprioridadpedido));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(tipoprioridadpedido.getPais(),isDeep,deepLoadType,clases);				
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
			tipoprioridadpedido.setPais(tipoprioridadpedidoDataAccess.getPais(connexion,tipoprioridadpedido));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(tipoprioridadpedido.getPais(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoPrioridadPedido tipoprioridadpedido,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoPrioridadPedido.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoprioridadpedido,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(tipoprioridadpedido);
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
			this.deepLoad(this.tipoprioridadpedido,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(this.tipoprioridadpedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoPrioridadPedido.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoprioridadpedidos!=null) {
				for(TipoPrioridadPedido tipoprioridadpedido:tipoprioridadpedidos) {
					this.deepLoad(tipoprioridadpedido,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(tipoprioridadpedidos);
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
			if(tipoprioridadpedidos!=null) {
				for(TipoPrioridadPedido tipoprioridadpedido:tipoprioridadpedidos) {
					this.deepLoad(tipoprioridadpedido,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(tipoprioridadpedidos);
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
	
	
	public void getTipoPrioridadPedidosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadPedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoPrioridadPedidoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoPrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprioridadpedidos=tipoprioridadpedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(this.tipoprioridadpedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoPrioridadPedidosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoPrioridadPedidoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoPrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprioridadpedidos=tipoprioridadpedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(this.tipoprioridadpedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoPrioridadPedidosFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadPedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,TipoPrioridadPedidoConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			TipoPrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprioridadpedidos=tipoprioridadpedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(this.tipoprioridadpedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoPrioridadPedidosFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,TipoPrioridadPedidoConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			TipoPrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprioridadpedidos=tipoprioridadpedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(this.tipoprioridadpedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoPrioridadPedidoPorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadPedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoPrioridadPedidoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipoprioridadpedido=tipoprioridadpedidoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipoprioridadpedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(this.tipoprioridadpedido);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoPrioridadPedidoPorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoPrioridadPedidoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipoprioridadpedido=tipoprioridadpedidoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipoprioridadpedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoPrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadPedido(this.tipoprioridadpedido);
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
			if(TipoPrioridadPedidoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPrioridadPedidoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoPrioridadPedido tipoprioridadpedido,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoPrioridadPedidoConstantesFunciones.ISCONAUDITORIA) {
				if(tipoprioridadpedido.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPrioridadPedidoDataAccess.TABLENAME, tipoprioridadpedido.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoPrioridadPedidoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoPrioridadPedidoLogic.registrarAuditoriaDetallesTipoPrioridadPedido(connexion,tipoprioridadpedido,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoprioridadpedido.getIsDeleted()) {
					/*if(!tipoprioridadpedido.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoPrioridadPedidoDataAccess.TABLENAME, tipoprioridadpedido.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoPrioridadPedidoLogic.registrarAuditoriaDetallesTipoPrioridadPedido(connexion,tipoprioridadpedido,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPrioridadPedidoDataAccess.TABLENAME, tipoprioridadpedido.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoprioridadpedido.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPrioridadPedidoDataAccess.TABLENAME, tipoprioridadpedido.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoPrioridadPedidoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoPrioridadPedidoLogic.registrarAuditoriaDetallesTipoPrioridadPedido(connexion,tipoprioridadpedido,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoPrioridadPedido(Connexion connexion,TipoPrioridadPedido tipoprioridadpedido)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoprioridadpedido.getIsNew()||!tipoprioridadpedido.getid_pais().equals(tipoprioridadpedido.getTipoPrioridadPedidoOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprioridadpedido.getTipoPrioridadPedidoOriginal().getid_pais()!=null)
				{
					strValorActual=tipoprioridadpedido.getTipoPrioridadPedidoOriginal().getid_pais().toString();
				}
				if(tipoprioridadpedido.getid_pais()!=null)
				{
					strValorNuevo=tipoprioridadpedido.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPrioridadPedidoConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(tipoprioridadpedido.getIsNew()||!tipoprioridadpedido.getnombre().equals(tipoprioridadpedido.getTipoPrioridadPedidoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprioridadpedido.getTipoPrioridadPedidoOriginal().getnombre()!=null)
				{
					strValorActual=tipoprioridadpedido.getTipoPrioridadPedidoOriginal().getnombre();
				}
				if(tipoprioridadpedido.getnombre()!=null)
				{
					strValorNuevo=tipoprioridadpedido.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPrioridadPedidoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoPrioridadPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoPrioridadPedidoConstantesFunciones.getClassesForeignKeysOfTipoPrioridadPedido(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPrioridadPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoPrioridadPedidoConstantesFunciones.getClassesRelationshipsOfTipoPrioridadPedido(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

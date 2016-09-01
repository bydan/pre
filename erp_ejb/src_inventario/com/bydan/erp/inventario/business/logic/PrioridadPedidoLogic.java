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
import com.bydan.erp.inventario.util.PrioridadPedidoConstantesFunciones;
import com.bydan.erp.inventario.util.PrioridadPedidoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.PrioridadPedidoParameterGeneral;
import com.bydan.erp.inventario.business.entity.PrioridadPedido;
import com.bydan.erp.inventario.business.logic.PrioridadPedidoLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class PrioridadPedidoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PrioridadPedidoLogic.class);
	
	protected PrioridadPedidoDataAccess prioridadpedidoDataAccess; 	
	protected PrioridadPedido prioridadpedido;
	protected List<PrioridadPedido> prioridadpedidos;
	protected Object prioridadpedidoObject;	
	protected List<Object> prioridadpedidosObject;
	
	public static ClassValidator<PrioridadPedido> prioridadpedidoValidator = new ClassValidator<PrioridadPedido>(PrioridadPedido.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PrioridadPedidoLogicAdditional prioridadpedidoLogicAdditional=null;
	
	public PrioridadPedidoLogicAdditional getPrioridadPedidoLogicAdditional() {
		return this.prioridadpedidoLogicAdditional;
	}
	
	public void setPrioridadPedidoLogicAdditional(PrioridadPedidoLogicAdditional prioridadpedidoLogicAdditional) {
		try {
			this.prioridadpedidoLogicAdditional=prioridadpedidoLogicAdditional;
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
	
	
	
	
	public  PrioridadPedidoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.prioridadpedidoDataAccess = new PrioridadPedidoDataAccess();
			
			this.prioridadpedidos= new ArrayList<PrioridadPedido>();
			this.prioridadpedido= new PrioridadPedido();
			
			this.prioridadpedidoObject=new Object();
			this.prioridadpedidosObject=new ArrayList<Object>();
				
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
			
			this.prioridadpedidoDataAccess.setConnexionType(this.connexionType);
			this.prioridadpedidoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PrioridadPedidoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.prioridadpedidoDataAccess = new PrioridadPedidoDataAccess();
			this.prioridadpedidos= new ArrayList<PrioridadPedido>();
			this.prioridadpedido= new PrioridadPedido();
			this.prioridadpedidoObject=new Object();
			this.prioridadpedidosObject=new ArrayList<Object>();
			
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
			
			this.prioridadpedidoDataAccess.setConnexionType(this.connexionType);
			this.prioridadpedidoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PrioridadPedido getPrioridadPedido() throws Exception {	
		PrioridadPedidoLogicAdditional.checkPrioridadPedidoToGet(prioridadpedido,this.datosCliente,this.arrDatoGeneral);
		PrioridadPedidoLogicAdditional.updatePrioridadPedidoToGet(prioridadpedido,this.arrDatoGeneral);
		
		return prioridadpedido;
	}
		
	public void setPrioridadPedido(PrioridadPedido newPrioridadPedido) {
		this.prioridadpedido = newPrioridadPedido;
	}
	
	public PrioridadPedidoDataAccess getPrioridadPedidoDataAccess() {
		return prioridadpedidoDataAccess;
	}
	
	public void setPrioridadPedidoDataAccess(PrioridadPedidoDataAccess newprioridadpedidoDataAccess) {
		this.prioridadpedidoDataAccess = newprioridadpedidoDataAccess;
	}
	
	public List<PrioridadPedido> getPrioridadPedidos() throws Exception {		
		this.quitarPrioridadPedidosNulos();
		
		PrioridadPedidoLogicAdditional.checkPrioridadPedidoToGets(prioridadpedidos,this.datosCliente,this.arrDatoGeneral);
		
		for (PrioridadPedido prioridadpedidoLocal: prioridadpedidos ) {
			PrioridadPedidoLogicAdditional.updatePrioridadPedidoToGet(prioridadpedidoLocal,this.arrDatoGeneral);
		}
		
		return prioridadpedidos;
	}
	
	public void setPrioridadPedidos(List<PrioridadPedido> newPrioridadPedidos) {
		this.prioridadpedidos = newPrioridadPedidos;
	}
	
	public Object getPrioridadPedidoObject() {	
		this.prioridadpedidoObject=this.prioridadpedidoDataAccess.getEntityObject();
		return this.prioridadpedidoObject;
	}
		
	public void setPrioridadPedidoObject(Object newPrioridadPedidoObject) {
		this.prioridadpedidoObject = newPrioridadPedidoObject;
	}
	
	public List<Object> getPrioridadPedidosObject() {		
		this.prioridadpedidosObject=this.prioridadpedidoDataAccess.getEntitiesObject();
		return this.prioridadpedidosObject;
	}
		
	public void setPrioridadPedidosObject(List<Object> newPrioridadPedidosObject) {
		this.prioridadpedidosObject = newPrioridadPedidosObject;
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
		
		if(this.prioridadpedidoDataAccess!=null) {
			this.prioridadpedidoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PrioridadPedido.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			prioridadpedidoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			prioridadpedidoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		prioridadpedido = new  PrioridadPedido();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PrioridadPedido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			prioridadpedido=prioridadpedidoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.prioridadpedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(this.prioridadpedido);
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
		prioridadpedido = new  PrioridadPedido();
		  		  
        try {
			
			prioridadpedido=prioridadpedidoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.prioridadpedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(this.prioridadpedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		prioridadpedido = new  PrioridadPedido();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PrioridadPedido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			prioridadpedido=prioridadpedidoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.prioridadpedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(this.prioridadpedido);
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
		prioridadpedido = new  PrioridadPedido();
		  		  
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
		prioridadpedido = new  PrioridadPedido();
		  		  
        try {
			
			prioridadpedido=prioridadpedidoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.prioridadpedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(this.prioridadpedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		prioridadpedido = new  PrioridadPedido();
		  		  
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
		prioridadpedido = new  PrioridadPedido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PrioridadPedido.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =prioridadpedidoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		prioridadpedido = new  PrioridadPedido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=prioridadpedidoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		prioridadpedido = new  PrioridadPedido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PrioridadPedido.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =prioridadpedidoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		prioridadpedido = new  PrioridadPedido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=prioridadpedidoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		prioridadpedido = new  PrioridadPedido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PrioridadPedido.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =prioridadpedidoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		prioridadpedido = new  PrioridadPedido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=prioridadpedidoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		prioridadpedidos = new  ArrayList<PrioridadPedido>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PrioridadPedido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prioridadpedidos=prioridadpedidoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPrioridadPedido(prioridadpedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(this.prioridadpedidos);
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
		prioridadpedidos = new  ArrayList<PrioridadPedido>();
		  		  
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
		prioridadpedidos = new  ArrayList<PrioridadPedido>();
		  		  
        try {			
			PrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prioridadpedidos=prioridadpedidoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPrioridadPedido(prioridadpedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(this.prioridadpedidos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		prioridadpedidos = new  ArrayList<PrioridadPedido>();
		  		  
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
		prioridadpedidos = new  ArrayList<PrioridadPedido>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PrioridadPedido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prioridadpedidos=prioridadpedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPrioridadPedido(prioridadpedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(this.prioridadpedidos);
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
		prioridadpedidos = new  ArrayList<PrioridadPedido>();
		  		  
        try {
			PrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prioridadpedidos=prioridadpedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPrioridadPedido(prioridadpedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(this.prioridadpedidos);
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
		prioridadpedidos = new  ArrayList<PrioridadPedido>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PrioridadPedido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prioridadpedidos=prioridadpedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPrioridadPedido(prioridadpedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(this.prioridadpedidos);
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
		prioridadpedidos = new  ArrayList<PrioridadPedido>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prioridadpedidos=prioridadpedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPrioridadPedido(prioridadpedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(this.prioridadpedidos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		prioridadpedido = new  PrioridadPedido();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PrioridadPedido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prioridadpedido=prioridadpedidoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPrioridadPedido(prioridadpedido);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(this.prioridadpedido);
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
		prioridadpedido = new  PrioridadPedido();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prioridadpedido=prioridadpedidoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPrioridadPedido(prioridadpedido);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(this.prioridadpedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		prioridadpedidos = new  ArrayList<PrioridadPedido>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PrioridadPedido.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prioridadpedidos=prioridadpedidoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPrioridadPedido(prioridadpedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(this.prioridadpedidos);
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
		prioridadpedidos = new  ArrayList<PrioridadPedido>();
		  		  
        try {
			PrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prioridadpedidos=prioridadpedidoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPrioridadPedido(prioridadpedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(this.prioridadpedidos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPrioridadPedidosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		prioridadpedidos = new  ArrayList<PrioridadPedido>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PrioridadPedido.class.getSimpleName()+"-getTodosPrioridadPedidosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prioridadpedidos=prioridadpedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPrioridadPedido(prioridadpedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(this.prioridadpedidos);
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
	
	public  void  getTodosPrioridadPedidos(String sFinalQuery,Pagination pagination)throws Exception {
		prioridadpedidos = new  ArrayList<PrioridadPedido>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prioridadpedidos=prioridadpedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPrioridadPedido(prioridadpedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(this.prioridadpedidos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPrioridadPedido(PrioridadPedido prioridadpedido) throws Exception {
		Boolean estaValidado=false;
		
		if(prioridadpedido.getIsNew() || prioridadpedido.getIsChanged()) { 
			this.invalidValues = prioridadpedidoValidator.getInvalidValues(prioridadpedido);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(prioridadpedido);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPrioridadPedido(List<PrioridadPedido> PrioridadPedidos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PrioridadPedido prioridadpedidoLocal:prioridadpedidos) {				
			estaValidadoObjeto=this.validarGuardarPrioridadPedido(prioridadpedidoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPrioridadPedido(List<PrioridadPedido> PrioridadPedidos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPrioridadPedido(prioridadpedidos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPrioridadPedido(PrioridadPedido PrioridadPedido) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPrioridadPedido(prioridadpedido)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PrioridadPedido prioridadpedido) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+prioridadpedido.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PrioridadPedidoConstantesFunciones.getPrioridadPedidoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"prioridadpedido","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PrioridadPedidoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PrioridadPedidoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePrioridadPedidoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PrioridadPedido.class.getSimpleName()+"-savePrioridadPedidoWithConnection");connexion.begin();			
			
			PrioridadPedidoLogicAdditional.checkPrioridadPedidoToSave(this.prioridadpedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PrioridadPedidoLogicAdditional.updatePrioridadPedidoToSave(this.prioridadpedido,this.arrDatoGeneral);
			
			PrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.prioridadpedido,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPrioridadPedido();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPrioridadPedido(this.prioridadpedido)) {
				PrioridadPedidoDataAccess.save(this.prioridadpedido, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.prioridadpedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PrioridadPedidoLogicAdditional.checkPrioridadPedidoToSaveAfter(this.prioridadpedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPrioridadPedido();
			
			connexion.commit();			
			
			if(this.prioridadpedido.getIsDeleted()) {
				this.prioridadpedido=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePrioridadPedido()throws Exception {	
		try {	
			
			PrioridadPedidoLogicAdditional.checkPrioridadPedidoToSave(this.prioridadpedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PrioridadPedidoLogicAdditional.updatePrioridadPedidoToSave(this.prioridadpedido,this.arrDatoGeneral);
			
			PrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.prioridadpedido,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPrioridadPedido(this.prioridadpedido)) {			
				PrioridadPedidoDataAccess.save(this.prioridadpedido, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.prioridadpedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PrioridadPedidoLogicAdditional.checkPrioridadPedidoToSaveAfter(this.prioridadpedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.prioridadpedido.getIsDeleted()) {
				this.prioridadpedido=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePrioridadPedidosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PrioridadPedido.class.getSimpleName()+"-savePrioridadPedidosWithConnection");connexion.begin();			
			
			PrioridadPedidoLogicAdditional.checkPrioridadPedidoToSaves(prioridadpedidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPrioridadPedidos();
			
			Boolean validadoTodosPrioridadPedido=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PrioridadPedido prioridadpedidoLocal:prioridadpedidos) {		
				if(prioridadpedidoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PrioridadPedidoLogicAdditional.updatePrioridadPedidoToSave(prioridadpedidoLocal,this.arrDatoGeneral);
	        	
				PrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),prioridadpedidoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPrioridadPedido(prioridadpedidoLocal)) {
					PrioridadPedidoDataAccess.save(prioridadpedidoLocal, connexion);				
				} else {
					validadoTodosPrioridadPedido=false;
				}
			}
			
			if(!validadoTodosPrioridadPedido) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PrioridadPedidoLogicAdditional.checkPrioridadPedidoToSavesAfter(prioridadpedidos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPrioridadPedidos();
			
			connexion.commit();		
			
			this.quitarPrioridadPedidosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePrioridadPedidos()throws Exception {				
		 try {	
			PrioridadPedidoLogicAdditional.checkPrioridadPedidoToSaves(prioridadpedidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPrioridadPedido=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PrioridadPedido prioridadpedidoLocal:prioridadpedidos) {				
				if(prioridadpedidoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PrioridadPedidoLogicAdditional.updatePrioridadPedidoToSave(prioridadpedidoLocal,this.arrDatoGeneral);
	        	
				PrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),prioridadpedidoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPrioridadPedido(prioridadpedidoLocal)) {				
					PrioridadPedidoDataAccess.save(prioridadpedidoLocal, connexion);				
				} else {
					validadoTodosPrioridadPedido=false;
				}
			}
			
			if(!validadoTodosPrioridadPedido) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PrioridadPedidoLogicAdditional.checkPrioridadPedidoToSavesAfter(prioridadpedidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPrioridadPedidosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PrioridadPedidoParameterReturnGeneral procesarAccionPrioridadPedidos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PrioridadPedido> prioridadpedidos,PrioridadPedidoParameterReturnGeneral prioridadpedidoParameterGeneral)throws Exception {
		 try {	
			PrioridadPedidoParameterReturnGeneral prioridadpedidoReturnGeneral=new PrioridadPedidoParameterReturnGeneral();
	
			PrioridadPedidoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,prioridadpedidos,prioridadpedidoParameterGeneral,prioridadpedidoReturnGeneral);
			
			return prioridadpedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PrioridadPedidoParameterReturnGeneral procesarAccionPrioridadPedidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PrioridadPedido> prioridadpedidos,PrioridadPedidoParameterReturnGeneral prioridadpedidoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PrioridadPedido.class.getSimpleName()+"-procesarAccionPrioridadPedidosWithConnection");connexion.begin();			
			
			PrioridadPedidoParameterReturnGeneral prioridadpedidoReturnGeneral=new PrioridadPedidoParameterReturnGeneral();
	
			PrioridadPedidoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,prioridadpedidos,prioridadpedidoParameterGeneral,prioridadpedidoReturnGeneral);
			
			this.connexion.commit();
			
			return prioridadpedidoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PrioridadPedidoParameterReturnGeneral procesarEventosPrioridadPedidos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PrioridadPedido> prioridadpedidos,PrioridadPedido prioridadpedido,PrioridadPedidoParameterReturnGeneral prioridadpedidoParameterGeneral,Boolean isEsNuevoPrioridadPedido,ArrayList<Classe> clases)throws Exception {
		 try {	
			PrioridadPedidoParameterReturnGeneral prioridadpedidoReturnGeneral=new PrioridadPedidoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				prioridadpedidoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PrioridadPedidoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,prioridadpedidos,prioridadpedido,prioridadpedidoParameterGeneral,prioridadpedidoReturnGeneral,isEsNuevoPrioridadPedido,clases);
			
			return prioridadpedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PrioridadPedidoParameterReturnGeneral procesarEventosPrioridadPedidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PrioridadPedido> prioridadpedidos,PrioridadPedido prioridadpedido,PrioridadPedidoParameterReturnGeneral prioridadpedidoParameterGeneral,Boolean isEsNuevoPrioridadPedido,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PrioridadPedido.class.getSimpleName()+"-procesarEventosPrioridadPedidosWithConnection");connexion.begin();			
			
			PrioridadPedidoParameterReturnGeneral prioridadpedidoReturnGeneral=new PrioridadPedidoParameterReturnGeneral();
	
			prioridadpedidoReturnGeneral.setPrioridadPedido(prioridadpedido);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				prioridadpedidoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PrioridadPedidoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,prioridadpedidos,prioridadpedido,prioridadpedidoParameterGeneral,prioridadpedidoReturnGeneral,isEsNuevoPrioridadPedido,clases);
			
			this.connexion.commit();
			
			return prioridadpedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PrioridadPedidoParameterReturnGeneral procesarImportacionPrioridadPedidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PrioridadPedidoParameterReturnGeneral prioridadpedidoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PrioridadPedido.class.getSimpleName()+"-procesarImportacionPrioridadPedidosWithConnection");connexion.begin();			
			
			PrioridadPedidoParameterReturnGeneral prioridadpedidoReturnGeneral=new PrioridadPedidoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.prioridadpedidos=new ArrayList<PrioridadPedido>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.prioridadpedido=new PrioridadPedido();
				
				
				if(conColumnasBase) {this.prioridadpedido.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.prioridadpedido.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.prioridadpedido.setnombre(arrColumnas[iColumn++]);
				this.prioridadpedido.setdia(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.prioridadpedidos.add(this.prioridadpedido);
			}
			
			this.savePrioridadPedidos();
			
			this.connexion.commit();
			
			prioridadpedidoReturnGeneral.setConRetornoEstaProcesado(true);
			prioridadpedidoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return prioridadpedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPrioridadPedidosEliminados() throws Exception {				
		
		List<PrioridadPedido> prioridadpedidosAux= new ArrayList<PrioridadPedido>();
		
		for(PrioridadPedido prioridadpedido:prioridadpedidos) {
			if(!prioridadpedido.getIsDeleted()) {
				prioridadpedidosAux.add(prioridadpedido);
			}
		}
		
		prioridadpedidos=prioridadpedidosAux;
	}
	
	public void quitarPrioridadPedidosNulos() throws Exception {				
		
		List<PrioridadPedido> prioridadpedidosAux= new ArrayList<PrioridadPedido>();
		
		for(PrioridadPedido prioridadpedido : this.prioridadpedidos) {
			if(prioridadpedido==null) {
				prioridadpedidosAux.add(prioridadpedido);
			}
		}
		
		//this.prioridadpedidos=prioridadpedidosAux;
		
		this.prioridadpedidos.removeAll(prioridadpedidosAux);
	}
	
	public void getSetVersionRowPrioridadPedidoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(prioridadpedido.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((prioridadpedido.getIsDeleted() || (prioridadpedido.getIsChanged()&&!prioridadpedido.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=prioridadpedidoDataAccess.getSetVersionRowPrioridadPedido(connexion,prioridadpedido.getId());
				
				if(!prioridadpedido.getVersionRow().equals(timestamp)) {	
					prioridadpedido.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				prioridadpedido.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPrioridadPedido()throws Exception {	
		
		if(prioridadpedido.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((prioridadpedido.getIsDeleted() || (prioridadpedido.getIsChanged()&&!prioridadpedido.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=prioridadpedidoDataAccess.getSetVersionRowPrioridadPedido(connexion,prioridadpedido.getId());
			
			try {							
				if(!prioridadpedido.getVersionRow().equals(timestamp)) {	
					prioridadpedido.setVersionRow(timestamp);
				}
				
				prioridadpedido.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPrioridadPedidosWithConnection()throws Exception {	
		if(prioridadpedidos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PrioridadPedido prioridadpedidoAux:prioridadpedidos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(prioridadpedidoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(prioridadpedidoAux.getIsDeleted() || (prioridadpedidoAux.getIsChanged()&&!prioridadpedidoAux.getIsNew())) {
						
						timestamp=prioridadpedidoDataAccess.getSetVersionRowPrioridadPedido(connexion,prioridadpedidoAux.getId());
						
						if(!prioridadpedido.getVersionRow().equals(timestamp)) {	
							prioridadpedidoAux.setVersionRow(timestamp);
						}
								
						prioridadpedidoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPrioridadPedidos()throws Exception {	
		if(prioridadpedidos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PrioridadPedido prioridadpedidoAux:prioridadpedidos) {
					if(prioridadpedidoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(prioridadpedidoAux.getIsDeleted() || (prioridadpedidoAux.getIsChanged()&&!prioridadpedidoAux.getIsNew())) {
						
						timestamp=prioridadpedidoDataAccess.getSetVersionRowPrioridadPedido(connexion,prioridadpedidoAux.getId());
						
						if(!prioridadpedidoAux.getVersionRow().equals(timestamp)) {	
							prioridadpedidoAux.setVersionRow(timestamp);
						}
						
													
						prioridadpedidoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PrioridadPedidoParameterReturnGeneral cargarCombosLoteForeignKeyPrioridadPedidoWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		PrioridadPedidoParameterReturnGeneral  prioridadpedidoReturnGeneral =new PrioridadPedidoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PrioridadPedido.class.getSimpleName()+"-cargarCombosLoteForeignKeyPrioridadPedidoWithConnection");connexion.begin();
			
			prioridadpedidoReturnGeneral =new PrioridadPedidoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			prioridadpedidoReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return prioridadpedidoReturnGeneral;
	}
	
	public PrioridadPedidoParameterReturnGeneral cargarCombosLoteForeignKeyPrioridadPedido(String finalQueryGlobalEmpresa) throws Exception {
		PrioridadPedidoParameterReturnGeneral  prioridadpedidoReturnGeneral =new PrioridadPedidoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			prioridadpedidoReturnGeneral =new PrioridadPedidoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			prioridadpedidoReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return prioridadpedidoReturnGeneral;
	}
	
	
	public void deepLoad(PrioridadPedido prioridadpedido,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PrioridadPedidoLogicAdditional.updatePrioridadPedidoToGet(prioridadpedido,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		prioridadpedido.setEmpresa(prioridadpedidoDataAccess.getEmpresa(connexion,prioridadpedido));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				prioridadpedido.setEmpresa(prioridadpedidoDataAccess.getEmpresa(connexion,prioridadpedido));
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
			prioridadpedido.setEmpresa(prioridadpedidoDataAccess.getEmpresa(connexion,prioridadpedido));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		prioridadpedido.setEmpresa(prioridadpedidoDataAccess.getEmpresa(connexion,prioridadpedido));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(prioridadpedido.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				prioridadpedido.setEmpresa(prioridadpedidoDataAccess.getEmpresa(connexion,prioridadpedido));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(prioridadpedido.getEmpresa(),isDeep,deepLoadType,clases);				
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
			prioridadpedido.setEmpresa(prioridadpedidoDataAccess.getEmpresa(connexion,prioridadpedido));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(prioridadpedido.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PrioridadPedido prioridadpedido,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PrioridadPedidoLogicAdditional.updatePrioridadPedidoToSave(prioridadpedido,this.arrDatoGeneral);
			
PrioridadPedidoDataAccess.save(prioridadpedido, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(prioridadpedido.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(prioridadpedido.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(prioridadpedido.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(prioridadpedido.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(prioridadpedido.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(prioridadpedido.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PrioridadPedido.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(prioridadpedido,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(prioridadpedido);
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
			this.deepLoad(this.prioridadpedido,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(this.prioridadpedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PrioridadPedido.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(prioridadpedidos!=null) {
				for(PrioridadPedido prioridadpedido:prioridadpedidos) {
					this.deepLoad(prioridadpedido,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(prioridadpedidos);
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
			if(prioridadpedidos!=null) {
				for(PrioridadPedido prioridadpedido:prioridadpedidos) {
					this.deepLoad(prioridadpedido,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(prioridadpedidos);
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
			this.getNewConnexionToDeep(PrioridadPedido.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(prioridadpedido,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PrioridadPedido.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(prioridadpedidos!=null) {
				for(PrioridadPedido prioridadpedido:prioridadpedidos) {
					this.deepSave(prioridadpedido,isDeep,deepLoadType,clases);
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
			if(prioridadpedidos!=null) {
				for(PrioridadPedido prioridadpedido:prioridadpedidos) {
					this.deepSave(prioridadpedido,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPrioridadPedidosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PrioridadPedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",PrioridadPedidoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			PrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			prioridadpedidos=prioridadpedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(this.prioridadpedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPrioridadPedidosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",PrioridadPedidoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			PrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			prioridadpedidos=prioridadpedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(this.prioridadpedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPrioridadPedidosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PrioridadPedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PrioridadPedidoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			prioridadpedidos=prioridadpedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(this.prioridadpedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPrioridadPedidosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PrioridadPedidoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PrioridadPedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			prioridadpedidos=prioridadpedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrioridadPedidoConstantesFunciones.refrescarForeignKeysDescripcionesPrioridadPedido(this.prioridadpedidos);
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
			if(PrioridadPedidoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PrioridadPedidoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PrioridadPedido prioridadpedido,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PrioridadPedidoConstantesFunciones.ISCONAUDITORIA) {
				if(prioridadpedido.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PrioridadPedidoDataAccess.TABLENAME, prioridadpedido.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PrioridadPedidoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PrioridadPedidoLogic.registrarAuditoriaDetallesPrioridadPedido(connexion,prioridadpedido,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(prioridadpedido.getIsDeleted()) {
					/*if(!prioridadpedido.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PrioridadPedidoDataAccess.TABLENAME, prioridadpedido.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PrioridadPedidoLogic.registrarAuditoriaDetallesPrioridadPedido(connexion,prioridadpedido,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PrioridadPedidoDataAccess.TABLENAME, prioridadpedido.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(prioridadpedido.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PrioridadPedidoDataAccess.TABLENAME, prioridadpedido.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PrioridadPedidoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PrioridadPedidoLogic.registrarAuditoriaDetallesPrioridadPedido(connexion,prioridadpedido,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPrioridadPedido(Connexion connexion,PrioridadPedido prioridadpedido)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(prioridadpedido.getIsNew()||!prioridadpedido.getid_empresa().equals(prioridadpedido.getPrioridadPedidoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(prioridadpedido.getPrioridadPedidoOriginal().getid_empresa()!=null)
				{
					strValorActual=prioridadpedido.getPrioridadPedidoOriginal().getid_empresa().toString();
				}
				if(prioridadpedido.getid_empresa()!=null)
				{
					strValorNuevo=prioridadpedido.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrioridadPedidoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(prioridadpedido.getIsNew()||!prioridadpedido.getnombre().equals(prioridadpedido.getPrioridadPedidoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(prioridadpedido.getPrioridadPedidoOriginal().getnombre()!=null)
				{
					strValorActual=prioridadpedido.getPrioridadPedidoOriginal().getnombre();
				}
				if(prioridadpedido.getnombre()!=null)
				{
					strValorNuevo=prioridadpedido.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrioridadPedidoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(prioridadpedido.getIsNew()||!prioridadpedido.getdia().equals(prioridadpedido.getPrioridadPedidoOriginal().getdia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(prioridadpedido.getPrioridadPedidoOriginal().getdia()!=null)
				{
					strValorActual=prioridadpedido.getPrioridadPedidoOriginal().getdia().toString();
				}
				if(prioridadpedido.getdia()!=null)
				{
					strValorNuevo=prioridadpedido.getdia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrioridadPedidoConstantesFunciones.DIA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePrioridadPedidoRelacionesWithConnection(PrioridadPedido prioridadpedido) throws Exception {

		if(!prioridadpedido.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePrioridadPedidoRelacionesBase(prioridadpedido,true);
		}
	}

	public void savePrioridadPedidoRelaciones(PrioridadPedido prioridadpedido)throws Exception {

		if(!prioridadpedido.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePrioridadPedidoRelacionesBase(prioridadpedido,false);
		}
	}

	public void savePrioridadPedidoRelacionesBase(PrioridadPedido prioridadpedido,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PrioridadPedido-saveRelacionesWithConnection");}
	

			this.setPrioridadPedido(prioridadpedido);

			if(PrioridadPedidoLogicAdditional.validarSaveRelaciones(prioridadpedido,this)) {

				PrioridadPedidoLogicAdditional.updateRelacionesToSave(prioridadpedido,this);

				if((prioridadpedido.getIsNew()||prioridadpedido.getIsChanged())&&!prioridadpedido.getIsDeleted()) {
					this.savePrioridadPedido();
					this.savePrioridadPedidoRelacionesDetalles();

				} else if(prioridadpedido.getIsDeleted()) {
					this.savePrioridadPedidoRelacionesDetalles();
					this.savePrioridadPedido();
				}

				PrioridadPedidoLogicAdditional.updateRelacionesToSaveAfter(prioridadpedido,this);

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
	
	
	private void savePrioridadPedidoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPrioridadPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PrioridadPedidoConstantesFunciones.getClassesForeignKeysOfPrioridadPedido(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPrioridadPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PrioridadPedidoConstantesFunciones.getClassesRelationshipsOfPrioridadPedido(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

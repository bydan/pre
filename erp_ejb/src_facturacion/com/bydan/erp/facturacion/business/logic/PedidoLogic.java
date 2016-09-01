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
import com.bydan.erp.facturacion.util.PedidoConstantesFunciones;
import com.bydan.erp.facturacion.util.PedidoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.PedidoParameterGeneral;
import com.bydan.erp.facturacion.business.entity.Pedido;
import com.bydan.erp.facturacion.business.logic.PedidoLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class PedidoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PedidoLogic.class);
	
	protected PedidoDataAccess pedidoDataAccess; 	
	protected Pedido pedido;
	protected List<Pedido> pedidos;
	protected Object pedidoObject;	
	protected List<Object> pedidosObject;
	
	public static ClassValidator<Pedido> pedidoValidator = new ClassValidator<Pedido>(Pedido.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PedidoLogicAdditional pedidoLogicAdditional=null;
	
	public PedidoLogicAdditional getPedidoLogicAdditional() {
		return this.pedidoLogicAdditional;
	}
	
	public void setPedidoLogicAdditional(PedidoLogicAdditional pedidoLogicAdditional) {
		try {
			this.pedidoLogicAdditional=pedidoLogicAdditional;
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
	
	
	
	
	public  PedidoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.pedidoDataAccess = new PedidoDataAccess();
			
			this.pedidos= new ArrayList<Pedido>();
			this.pedido= new Pedido();
			
			this.pedidoObject=new Object();
			this.pedidosObject=new ArrayList<Object>();
				
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
			
			this.pedidoDataAccess.setConnexionType(this.connexionType);
			this.pedidoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PedidoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.pedidoDataAccess = new PedidoDataAccess();
			this.pedidos= new ArrayList<Pedido>();
			this.pedido= new Pedido();
			this.pedidoObject=new Object();
			this.pedidosObject=new ArrayList<Object>();
			
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
			
			this.pedidoDataAccess.setConnexionType(this.connexionType);
			this.pedidoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Pedido getPedido() throws Exception {	
		PedidoLogicAdditional.checkPedidoToGet(pedido,this.datosCliente,this.arrDatoGeneral);
		PedidoLogicAdditional.updatePedidoToGet(pedido,this.arrDatoGeneral);
		
		return pedido;
	}
		
	public void setPedido(Pedido newPedido) {
		this.pedido = newPedido;
	}
	
	public PedidoDataAccess getPedidoDataAccess() {
		return pedidoDataAccess;
	}
	
	public void setPedidoDataAccess(PedidoDataAccess newpedidoDataAccess) {
		this.pedidoDataAccess = newpedidoDataAccess;
	}
	
	public List<Pedido> getPedidos() throws Exception {		
		this.quitarPedidosNulos();
		
		PedidoLogicAdditional.checkPedidoToGets(pedidos,this.datosCliente,this.arrDatoGeneral);
		
		for (Pedido pedidoLocal: pedidos ) {
			PedidoLogicAdditional.updatePedidoToGet(pedidoLocal,this.arrDatoGeneral);
		}
		
		return pedidos;
	}
	
	public void setPedidos(List<Pedido> newPedidos) {
		this.pedidos = newPedidos;
	}
	
	public Object getPedidoObject() {	
		this.pedidoObject=this.pedidoDataAccess.getEntityObject();
		return this.pedidoObject;
	}
		
	public void setPedidoObject(Object newPedidoObject) {
		this.pedidoObject = newPedidoObject;
	}
	
	public List<Object> getPedidosObject() {		
		this.pedidosObject=this.pedidoDataAccess.getEntitiesObject();
		return this.pedidosObject;
	}
		
	public void setPedidosObject(List<Object> newPedidosObject) {
		this.pedidosObject = newPedidosObject;
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
		
		if(this.pedidoDataAccess!=null) {
			this.pedidoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			pedidoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			pedidoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		pedido = new  Pedido();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			pedido=pedidoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedido);
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
		pedido = new  Pedido();
		  		  
        try {
			
			pedido=pedidoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		pedido = new  Pedido();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			pedido=pedidoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedido);
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
		pedido = new  Pedido();
		  		  
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
		pedido = new  Pedido();
		  		  
        try {
			
			pedido=pedidoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		pedido = new  Pedido();
		  		  
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
		pedido = new  Pedido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =pedidoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pedido = new  Pedido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=pedidoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		pedido = new  Pedido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =pedidoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pedido = new  Pedido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=pedidoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		pedido = new  Pedido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =pedidoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pedido = new  Pedido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=pedidoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		pedidos = new  ArrayList<Pedido>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidos=pedidoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedido(pedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
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
		pedidos = new  ArrayList<Pedido>();
		  		  
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
		pedidos = new  ArrayList<Pedido>();
		  		  
        try {			
			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidos=pedidoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPedido(pedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		pedidos = new  ArrayList<Pedido>();
		  		  
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
		pedidos = new  ArrayList<Pedido>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidos=pedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedido(pedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
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
		pedidos = new  ArrayList<Pedido>();
		  		  
        try {
			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidos=pedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedido(pedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
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
		pedidos = new  ArrayList<Pedido>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidos=pedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedido(pedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
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
		pedidos = new  ArrayList<Pedido>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidos=pedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedido(pedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		pedido = new  Pedido();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedido=pedidoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedido(pedido);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedido);
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
		pedido = new  Pedido();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedido=pedidoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedido(pedido);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		pedidos = new  ArrayList<Pedido>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidos=pedidoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedido(pedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
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
		pedidos = new  ArrayList<Pedido>();
		  		  
        try {
			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidos=pedidoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedido(pedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPedidosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		pedidos = new  ArrayList<Pedido>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getTodosPedidosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPedido(pedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
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
	
	public  void  getTodosPedidos(String sFinalQuery,Pagination pagination)throws Exception {
		pedidos = new  ArrayList<Pedido>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPedido(pedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPedido(Pedido pedido) throws Exception {
		Boolean estaValidado=false;
		
		if(pedido.getIsNew() || pedido.getIsChanged()) { 
			this.invalidValues = pedidoValidator.getInvalidValues(pedido);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(pedido);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPedido(List<Pedido> Pedidos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Pedido pedidoLocal:pedidos) {				
			estaValidadoObjeto=this.validarGuardarPedido(pedidoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPedido(List<Pedido> Pedidos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPedido(pedidos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPedido(Pedido Pedido) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPedido(pedido)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Pedido pedido) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+pedido.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PedidoConstantesFunciones.getPedidoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"pedido","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PedidoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PedidoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePedidoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-savePedidoWithConnection");connexion.begin();			
			
			PedidoLogicAdditional.checkPedidoToSave(this.pedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PedidoLogicAdditional.updatePedidoToSave(this.pedido,this.arrDatoGeneral);
			
			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.pedido,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPedido();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPedido(this.pedido)) {
				PedidoDataAccess.save(this.pedido, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.pedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PedidoLogicAdditional.checkPedidoToSaveAfter(this.pedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPedido();
			
			connexion.commit();			
			
			if(this.pedido.getIsDeleted()) {
				this.pedido=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePedido()throws Exception {	
		try {	
			
			PedidoLogicAdditional.checkPedidoToSave(this.pedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PedidoLogicAdditional.updatePedidoToSave(this.pedido,this.arrDatoGeneral);
			
			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.pedido,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPedido(this.pedido)) {			
				PedidoDataAccess.save(this.pedido, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.pedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PedidoLogicAdditional.checkPedidoToSaveAfter(this.pedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.pedido.getIsDeleted()) {
				this.pedido=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePedidosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-savePedidosWithConnection");connexion.begin();			
			
			PedidoLogicAdditional.checkPedidoToSaves(pedidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPedidos();
			
			Boolean validadoTodosPedido=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Pedido pedidoLocal:pedidos) {		
				if(pedidoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PedidoLogicAdditional.updatePedidoToSave(pedidoLocal,this.arrDatoGeneral);
	        	
				PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),pedidoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPedido(pedidoLocal)) {
					PedidoDataAccess.save(pedidoLocal, connexion);				
				} else {
					validadoTodosPedido=false;
				}
			}
			
			if(!validadoTodosPedido) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PedidoLogicAdditional.checkPedidoToSavesAfter(pedidos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPedidos();
			
			connexion.commit();		
			
			this.quitarPedidosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePedidos()throws Exception {				
		 try {	
			PedidoLogicAdditional.checkPedidoToSaves(pedidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPedido=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Pedido pedidoLocal:pedidos) {				
				if(pedidoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PedidoLogicAdditional.updatePedidoToSave(pedidoLocal,this.arrDatoGeneral);
	        	
				PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),pedidoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPedido(pedidoLocal)) {				
					PedidoDataAccess.save(pedidoLocal, connexion);				
				} else {
					validadoTodosPedido=false;
				}
			}
			
			if(!validadoTodosPedido) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PedidoLogicAdditional.checkPedidoToSavesAfter(pedidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPedidosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PedidoParameterReturnGeneral procesarAccionPedidos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Pedido> pedidos,PedidoParameterReturnGeneral pedidoParameterGeneral)throws Exception {
		 try {	
			PedidoParameterReturnGeneral pedidoReturnGeneral=new PedidoParameterReturnGeneral();
	
			PedidoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pedidos,pedidoParameterGeneral,pedidoReturnGeneral);
			
			return pedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PedidoParameterReturnGeneral procesarAccionPedidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Pedido> pedidos,PedidoParameterReturnGeneral pedidoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-procesarAccionPedidosWithConnection");connexion.begin();			
			
			PedidoParameterReturnGeneral pedidoReturnGeneral=new PedidoParameterReturnGeneral();
	
			PedidoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pedidos,pedidoParameterGeneral,pedidoReturnGeneral);
			
			this.connexion.commit();
			
			return pedidoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PedidoParameterReturnGeneral procesarEventosPedidos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Pedido> pedidos,Pedido pedido,PedidoParameterReturnGeneral pedidoParameterGeneral,Boolean isEsNuevoPedido,ArrayList<Classe> clases)throws Exception {
		 try {	
			PedidoParameterReturnGeneral pedidoReturnGeneral=new PedidoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				pedidoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PedidoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,pedidos,pedido,pedidoParameterGeneral,pedidoReturnGeneral,isEsNuevoPedido,clases);
			
			return pedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PedidoParameterReturnGeneral procesarEventosPedidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Pedido> pedidos,Pedido pedido,PedidoParameterReturnGeneral pedidoParameterGeneral,Boolean isEsNuevoPedido,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-procesarEventosPedidosWithConnection");connexion.begin();			
			
			PedidoParameterReturnGeneral pedidoReturnGeneral=new PedidoParameterReturnGeneral();
	
			pedidoReturnGeneral.setPedido(pedido);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				pedidoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PedidoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,pedidos,pedido,pedidoParameterGeneral,pedidoReturnGeneral,isEsNuevoPedido,clases);
			
			this.connexion.commit();
			
			return pedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PedidoParameterReturnGeneral procesarImportacionPedidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PedidoParameterReturnGeneral pedidoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-procesarImportacionPedidosWithConnection");connexion.begin();			
			
			PedidoParameterReturnGeneral pedidoReturnGeneral=new PedidoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.pedidos=new ArrayList<Pedido>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.pedido=new Pedido();
				
				
				if(conColumnasBase) {this.pedido.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.pedido.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.pedido.setnumero(arrColumnas[iColumn++]);
				this.pedido.setpre_impreso(arrColumnas[iColumn++]);
				this.pedido.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.pedido.setfecha_entrega(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.pedido.setcotizacion(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedido.setdireccion(arrColumnas[iColumn++]);
				this.pedido.settelefono(arrColumnas[iColumn++]);
				this.pedido.setruc(arrColumnas[iColumn++]);
				this.pedido.setorden(arrColumnas[iColumn++]);
				this.pedido.setvalor_ruta(Double.parseDouble(arrColumnas[iColumn++]));
				//this.pedido.sethora_inicio(arrColumnas[iColumn++]);
				//this.pedido.sethora_fin(arrColumnas[iColumn++]);
				this.pedido.setdescripcion(arrColumnas[iColumn++]);
				this.pedido.setcupo(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedido.setsaldo(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedido.setpedidos(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedido.setdocumentos(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedido.setdisponible(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedido.setdescuento_porcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedido.settotal_con_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedido.setsuman(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedido.setdescuento_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedido.settotal_sin_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedido.setdescuento_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedido.setflete(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedido.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedido.setsubtotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedido.setotro(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedido.setultimo_costo(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedido.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedido.setfinanciamiento(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedido.setmargen_utilidad(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedido.setotros_valores(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedido.setanticipo(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.pedidos.add(this.pedido);
			}
			
			this.savePedidos();
			
			this.connexion.commit();
			
			pedidoReturnGeneral.setConRetornoEstaProcesado(true);
			pedidoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return pedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPedidosEliminados() throws Exception {				
		
		List<Pedido> pedidosAux= new ArrayList<Pedido>();
		
		for(Pedido pedido:pedidos) {
			if(!pedido.getIsDeleted()) {
				pedidosAux.add(pedido);
			}
		}
		
		pedidos=pedidosAux;
	}
	
	public void quitarPedidosNulos() throws Exception {				
		
		List<Pedido> pedidosAux= new ArrayList<Pedido>();
		
		for(Pedido pedido : this.pedidos) {
			if(pedido==null) {
				pedidosAux.add(pedido);
			}
		}
		
		//this.pedidos=pedidosAux;
		
		this.pedidos.removeAll(pedidosAux);
	}
	
	public void getSetVersionRowPedidoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(pedido.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((pedido.getIsDeleted() || (pedido.getIsChanged()&&!pedido.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=pedidoDataAccess.getSetVersionRowPedido(connexion,pedido.getId());
				
				if(!pedido.getVersionRow().equals(timestamp)) {	
					pedido.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				pedido.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPedido()throws Exception {	
		
		if(pedido.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((pedido.getIsDeleted() || (pedido.getIsChanged()&&!pedido.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=pedidoDataAccess.getSetVersionRowPedido(connexion,pedido.getId());
			
			try {							
				if(!pedido.getVersionRow().equals(timestamp)) {	
					pedido.setVersionRow(timestamp);
				}
				
				pedido.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPedidosWithConnection()throws Exception {	
		if(pedidos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Pedido pedidoAux:pedidos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(pedidoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(pedidoAux.getIsDeleted() || (pedidoAux.getIsChanged()&&!pedidoAux.getIsNew())) {
						
						timestamp=pedidoDataAccess.getSetVersionRowPedido(connexion,pedidoAux.getId());
						
						if(!pedido.getVersionRow().equals(timestamp)) {	
							pedidoAux.setVersionRow(timestamp);
						}
								
						pedidoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPedidos()throws Exception {	
		if(pedidos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Pedido pedidoAux:pedidos) {
					if(pedidoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(pedidoAux.getIsDeleted() || (pedidoAux.getIsChanged()&&!pedidoAux.getIsNew())) {
						
						timestamp=pedidoDataAccess.getSetVersionRowPedido(connexion,pedidoAux.getId());
						
						if(!pedidoAux.getVersionRow().equals(timestamp)) {	
							pedidoAux.setVersionRow(timestamp);
						}
						
													
						pedidoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PedidoParameterReturnGeneral cargarCombosLoteForeignKeyPedidoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoPrecio,String finalQueryGlobalFormato,String finalQueryGlobalCliente,String finalQueryGlobalSubCliente,String finalQueryGlobalVendedor,String finalQueryGlobalConsultor,String finalQueryGlobalResponsable,String finalQueryGlobalEstadoPedido,String finalQueryGlobalTransporte,String finalQueryGlobalRutaTransporte,String finalQueryGlobalTipoLlamada,String finalQueryGlobalTransportista,String finalQueryGlobalTipoCambio,String finalQueryGlobalCentroCosto,String finalQueryGlobalZona) throws Exception {
		PedidoParameterReturnGeneral  pedidoReturnGeneral =new PedidoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-cargarCombosLoteForeignKeyPedidoWithConnection");connexion.begin();
			
			pedidoReturnGeneral =new PedidoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			pedidoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			pedidoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			pedidoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			pedidoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			pedidoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			pedidoReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			pedidoReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			pedidoReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			pedidoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			pedidoReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			pedidoReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			pedidoReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<SubCliente> subclientesForeignKey=new ArrayList<SubCliente>();
			SubClienteLogic subclienteLogic=new SubClienteLogic();
			subclienteLogic.setConnexion(this.connexion);
			subclienteLogic.getSubClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSubCliente.equals("NONE")) {
				subclienteLogic.getTodosSubClientes(finalQueryGlobalSubCliente,new Pagination());
				subclientesForeignKey=subclienteLogic.getSubClientes();
			}

			pedidoReturnGeneral.setsubclientesForeignKey(subclientesForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			pedidoReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Consultor> consultorsForeignKey=new ArrayList<Consultor>();
			ConsultorLogic consultorLogic=new ConsultorLogic();
			consultorLogic.setConnexion(this.connexion);
			consultorLogic.getConsultorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConsultor.equals("NONE")) {
				consultorLogic.getTodosConsultors(finalQueryGlobalConsultor,new Pagination());
				consultorsForeignKey=consultorLogic.getConsultors();
			}

			pedidoReturnGeneral.setconsultorsForeignKey(consultorsForeignKey);


			List<Responsable> responsablesForeignKey=new ArrayList<Responsable>();
			ResponsableLogic responsableLogic=new ResponsableLogic();
			responsableLogic.setConnexion(this.connexion);
			responsableLogic.getResponsableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalResponsable.equals("NONE")) {
				responsableLogic.getTodosResponsables(finalQueryGlobalResponsable,new Pagination());
				responsablesForeignKey=responsableLogic.getResponsables();
			}

			pedidoReturnGeneral.setresponsablesForeignKey(responsablesForeignKey);


			List<EstadoPedido> estadopedidosForeignKey=new ArrayList<EstadoPedido>();
			EstadoPedidoLogic estadopedidoLogic=new EstadoPedidoLogic();
			estadopedidoLogic.setConnexion(this.connexion);
			estadopedidoLogic.getEstadoPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedido.equals("NONE")) {
				estadopedidoLogic.getTodosEstadoPedidos(finalQueryGlobalEstadoPedido,new Pagination());
				estadopedidosForeignKey=estadopedidoLogic.getEstadoPedidos();
			}

			pedidoReturnGeneral.setestadopedidosForeignKey(estadopedidosForeignKey);


			List<Transporte> transportesForeignKey=new ArrayList<Transporte>();
			TransporteLogic transporteLogic=new TransporteLogic();
			transporteLogic.setConnexion(this.connexion);
			transporteLogic.getTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransporte.equals("NONE")) {
				transporteLogic.getTodosTransportes(finalQueryGlobalTransporte,new Pagination());
				transportesForeignKey=transporteLogic.getTransportes();
			}

			pedidoReturnGeneral.settransportesForeignKey(transportesForeignKey);


			List<RutaTransporte> rutatransportesForeignKey=new ArrayList<RutaTransporte>();
			RutaTransporteLogic rutatransporteLogic=new RutaTransporteLogic();
			rutatransporteLogic.setConnexion(this.connexion);
			rutatransporteLogic.getRutaTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRutaTransporte.equals("NONE")) {
				rutatransporteLogic.getTodosRutaTransportes(finalQueryGlobalRutaTransporte,new Pagination());
				rutatransportesForeignKey=rutatransporteLogic.getRutaTransportes();
			}

			pedidoReturnGeneral.setrutatransportesForeignKey(rutatransportesForeignKey);


			List<TipoLlamada> tipollamadasForeignKey=new ArrayList<TipoLlamada>();
			TipoLlamadaLogic tipollamadaLogic=new TipoLlamadaLogic();
			tipollamadaLogic.setConnexion(this.connexion);
			tipollamadaLogic.getTipoLlamadaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoLlamada.equals("NONE")) {
				tipollamadaLogic.getTodosTipoLlamadas(finalQueryGlobalTipoLlamada,new Pagination());
				tipollamadasForeignKey=tipollamadaLogic.getTipoLlamadas();
			}

			pedidoReturnGeneral.settipollamadasForeignKey(tipollamadasForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			pedidoReturnGeneral.settransportistasForeignKey(transportistasForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			pedidoReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			pedidoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Zona> zonasForeignKey=new ArrayList<Zona>();
			ZonaLogic zonaLogic=new ZonaLogic();
			zonaLogic.setConnexion(this.connexion);
			zonaLogic.getZonaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalZona.equals("NONE")) {
				zonaLogic.getTodosZonas(finalQueryGlobalZona,new Pagination());
				zonasForeignKey=zonaLogic.getZonas();
			}

			pedidoReturnGeneral.setzonasForeignKey(zonasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return pedidoReturnGeneral;
	}
	
	public PedidoParameterReturnGeneral cargarCombosLoteForeignKeyPedido(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoPrecio,String finalQueryGlobalFormato,String finalQueryGlobalCliente,String finalQueryGlobalSubCliente,String finalQueryGlobalVendedor,String finalQueryGlobalConsultor,String finalQueryGlobalResponsable,String finalQueryGlobalEstadoPedido,String finalQueryGlobalTransporte,String finalQueryGlobalRutaTransporte,String finalQueryGlobalTipoLlamada,String finalQueryGlobalTransportista,String finalQueryGlobalTipoCambio,String finalQueryGlobalCentroCosto,String finalQueryGlobalZona) throws Exception {
		PedidoParameterReturnGeneral  pedidoReturnGeneral =new PedidoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			pedidoReturnGeneral =new PedidoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			pedidoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			pedidoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			pedidoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			pedidoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			pedidoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			pedidoReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			pedidoReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			pedidoReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			pedidoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			pedidoReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			pedidoReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			pedidoReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<SubCliente> subclientesForeignKey=new ArrayList<SubCliente>();
			SubClienteLogic subclienteLogic=new SubClienteLogic();
			subclienteLogic.setConnexion(this.connexion);
			subclienteLogic.getSubClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSubCliente.equals("NONE")) {
				subclienteLogic.getTodosSubClientes(finalQueryGlobalSubCliente,new Pagination());
				subclientesForeignKey=subclienteLogic.getSubClientes();
			}

			pedidoReturnGeneral.setsubclientesForeignKey(subclientesForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			pedidoReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Consultor> consultorsForeignKey=new ArrayList<Consultor>();
			ConsultorLogic consultorLogic=new ConsultorLogic();
			consultorLogic.setConnexion(this.connexion);
			consultorLogic.getConsultorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConsultor.equals("NONE")) {
				consultorLogic.getTodosConsultors(finalQueryGlobalConsultor,new Pagination());
				consultorsForeignKey=consultorLogic.getConsultors();
			}

			pedidoReturnGeneral.setconsultorsForeignKey(consultorsForeignKey);


			List<Responsable> responsablesForeignKey=new ArrayList<Responsable>();
			ResponsableLogic responsableLogic=new ResponsableLogic();
			responsableLogic.setConnexion(this.connexion);
			responsableLogic.getResponsableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalResponsable.equals("NONE")) {
				responsableLogic.getTodosResponsables(finalQueryGlobalResponsable,new Pagination());
				responsablesForeignKey=responsableLogic.getResponsables();
			}

			pedidoReturnGeneral.setresponsablesForeignKey(responsablesForeignKey);


			List<EstadoPedido> estadopedidosForeignKey=new ArrayList<EstadoPedido>();
			EstadoPedidoLogic estadopedidoLogic=new EstadoPedidoLogic();
			estadopedidoLogic.setConnexion(this.connexion);
			estadopedidoLogic.getEstadoPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedido.equals("NONE")) {
				estadopedidoLogic.getTodosEstadoPedidos(finalQueryGlobalEstadoPedido,new Pagination());
				estadopedidosForeignKey=estadopedidoLogic.getEstadoPedidos();
			}

			pedidoReturnGeneral.setestadopedidosForeignKey(estadopedidosForeignKey);


			List<Transporte> transportesForeignKey=new ArrayList<Transporte>();
			TransporteLogic transporteLogic=new TransporteLogic();
			transporteLogic.setConnexion(this.connexion);
			transporteLogic.getTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransporte.equals("NONE")) {
				transporteLogic.getTodosTransportes(finalQueryGlobalTransporte,new Pagination());
				transportesForeignKey=transporteLogic.getTransportes();
			}

			pedidoReturnGeneral.settransportesForeignKey(transportesForeignKey);


			List<RutaTransporte> rutatransportesForeignKey=new ArrayList<RutaTransporte>();
			RutaTransporteLogic rutatransporteLogic=new RutaTransporteLogic();
			rutatransporteLogic.setConnexion(this.connexion);
			rutatransporteLogic.getRutaTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRutaTransporte.equals("NONE")) {
				rutatransporteLogic.getTodosRutaTransportes(finalQueryGlobalRutaTransporte,new Pagination());
				rutatransportesForeignKey=rutatransporteLogic.getRutaTransportes();
			}

			pedidoReturnGeneral.setrutatransportesForeignKey(rutatransportesForeignKey);


			List<TipoLlamada> tipollamadasForeignKey=new ArrayList<TipoLlamada>();
			TipoLlamadaLogic tipollamadaLogic=new TipoLlamadaLogic();
			tipollamadaLogic.setConnexion(this.connexion);
			tipollamadaLogic.getTipoLlamadaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoLlamada.equals("NONE")) {
				tipollamadaLogic.getTodosTipoLlamadas(finalQueryGlobalTipoLlamada,new Pagination());
				tipollamadasForeignKey=tipollamadaLogic.getTipoLlamadas();
			}

			pedidoReturnGeneral.settipollamadasForeignKey(tipollamadasForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			pedidoReturnGeneral.settransportistasForeignKey(transportistasForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			pedidoReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			pedidoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Zona> zonasForeignKey=new ArrayList<Zona>();
			ZonaLogic zonaLogic=new ZonaLogic();
			zonaLogic.setConnexion(this.connexion);
			zonaLogic.getZonaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalZona.equals("NONE")) {
				zonaLogic.getTodosZonas(finalQueryGlobalZona,new Pagination());
				zonasForeignKey=zonaLogic.getZonas();
			}

			pedidoReturnGeneral.setzonasForeignKey(zonasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return pedidoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyPedidoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetallePedidoLogic detallepedidoLogic=new DetallePedidoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyPedidoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetallePedido.class));
											
			

			detallepedidoLogic.setConnexion(this.getConnexion());
			detallepedidoLogic.setDatosCliente(this.datosCliente);
			detallepedidoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Pedido pedido:this.pedidos) {
				

				classes=new ArrayList<Classe>();
				classes=DetallePedidoConstantesFunciones.getClassesForeignKeysOfDetallePedido(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallepedidoLogic.setDetallePedidos(pedido.detallepedidos);
				detallepedidoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Pedido pedido,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PedidoLogicAdditional.updatePedidoToGet(pedido,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pedido.setEmpresa(pedidoDataAccess.getEmpresa(connexion,pedido));
		pedido.setSucursal(pedidoDataAccess.getSucursal(connexion,pedido));
		pedido.setEjercicio(pedidoDataAccess.getEjercicio(connexion,pedido));
		pedido.setPeriodo(pedidoDataAccess.getPeriodo(connexion,pedido));
		pedido.setAnio(pedidoDataAccess.getAnio(connexion,pedido));
		pedido.setMes(pedidoDataAccess.getMes(connexion,pedido));
		pedido.setUsuario(pedidoDataAccess.getUsuario(connexion,pedido));
		pedido.setMoneda(pedidoDataAccess.getMoneda(connexion,pedido));
		pedido.setEmpleado(pedidoDataAccess.getEmpleado(connexion,pedido));
		pedido.setTipoPrecio(pedidoDataAccess.getTipoPrecio(connexion,pedido));
		pedido.setFormato(pedidoDataAccess.getFormato(connexion,pedido));
		pedido.setCliente(pedidoDataAccess.getCliente(connexion,pedido));
		pedido.setSubCliente(pedidoDataAccess.getSubCliente(connexion,pedido));
		pedido.setVendedor(pedidoDataAccess.getVendedor(connexion,pedido));
		pedido.setConsultor(pedidoDataAccess.getConsultor(connexion,pedido));
		pedido.setResponsable(pedidoDataAccess.getResponsable(connexion,pedido));
		pedido.setEstadoPedido(pedidoDataAccess.getEstadoPedido(connexion,pedido));
		pedido.setTransporte(pedidoDataAccess.getTransporte(connexion,pedido));
		pedido.setRutaTransporte(pedidoDataAccess.getRutaTransporte(connexion,pedido));
		pedido.setTipoLlamada(pedidoDataAccess.getTipoLlamada(connexion,pedido));
		pedido.setTransportista(pedidoDataAccess.getTransportista(connexion,pedido));
		pedido.setTipoCambio(pedidoDataAccess.getTipoCambio(connexion,pedido));
		pedido.setCentroCosto(pedidoDataAccess.getCentroCosto(connexion,pedido));
		pedido.setZona(pedidoDataAccess.getZona(connexion,pedido));
		pedido.setDetallePedidos(pedidoDataAccess.getDetallePedidos(connexion,pedido));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pedido.setEmpresa(pedidoDataAccess.getEmpresa(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				pedido.setSucursal(pedidoDataAccess.getSucursal(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				pedido.setEjercicio(pedidoDataAccess.getEjercicio(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				pedido.setPeriodo(pedidoDataAccess.getPeriodo(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				pedido.setAnio(pedidoDataAccess.getAnio(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				pedido.setMes(pedidoDataAccess.getMes(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				pedido.setUsuario(pedidoDataAccess.getUsuario(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				pedido.setMoneda(pedidoDataAccess.getMoneda(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				pedido.setEmpleado(pedidoDataAccess.getEmpleado(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				pedido.setTipoPrecio(pedidoDataAccess.getTipoPrecio(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				pedido.setFormato(pedidoDataAccess.getFormato(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				pedido.setCliente(pedidoDataAccess.getCliente(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				pedido.setSubCliente(pedidoDataAccess.getSubCliente(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				pedido.setVendedor(pedidoDataAccess.getVendedor(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(Consultor.class)) {
				pedido.setConsultor(pedidoDataAccess.getConsultor(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				pedido.setResponsable(pedidoDataAccess.getResponsable(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				pedido.setEstadoPedido(pedidoDataAccess.getEstadoPedido(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				pedido.setTransporte(pedidoDataAccess.getTransporte(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(RutaTransporte.class)) {
				pedido.setRutaTransporte(pedidoDataAccess.getRutaTransporte(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(TipoLlamada.class)) {
				pedido.setTipoLlamada(pedidoDataAccess.getTipoLlamada(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				pedido.setTransportista(pedidoDataAccess.getTransportista(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				pedido.setTipoCambio(pedidoDataAccess.getTipoCambio(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				pedido.setCentroCosto(pedidoDataAccess.getCentroCosto(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				pedido.setZona(pedidoDataAccess.getZona(connexion,pedido));
				continue;
			}

			if(clas.clas.equals(DetallePedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				pedido.setDetallePedidos(pedidoDataAccess.getDetallePedidos(connexion,pedido));

				if(this.isConDeep) {
					DetallePedidoLogic detallepedidoLogic= new DetallePedidoLogic(this.connexion);
					detallepedidoLogic.setDetallePedidos(pedido.getDetallePedidos());
					ArrayList<Classe> classesLocal=DetallePedidoConstantesFunciones.getClassesForeignKeysOfDetallePedido(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallepedidoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(detallepedidoLogic.getDetallePedidos());
					pedido.setDetallePedidos(detallepedidoLogic.getDetallePedidos());
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
			pedido.setEmpresa(pedidoDataAccess.getEmpresa(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setSucursal(pedidoDataAccess.getSucursal(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setEjercicio(pedidoDataAccess.getEjercicio(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setPeriodo(pedidoDataAccess.getPeriodo(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setAnio(pedidoDataAccess.getAnio(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setMes(pedidoDataAccess.getMes(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setUsuario(pedidoDataAccess.getUsuario(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setMoneda(pedidoDataAccess.getMoneda(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setEmpleado(pedidoDataAccess.getEmpleado(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setTipoPrecio(pedidoDataAccess.getTipoPrecio(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setFormato(pedidoDataAccess.getFormato(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setCliente(pedidoDataAccess.getCliente(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setSubCliente(pedidoDataAccess.getSubCliente(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setVendedor(pedidoDataAccess.getVendedor(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consultor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setConsultor(pedidoDataAccess.getConsultor(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Responsable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setResponsable(pedidoDataAccess.getResponsable(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setEstadoPedido(pedidoDataAccess.getEstadoPedido(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setTransporte(pedidoDataAccess.getTransporte(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RutaTransporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setRutaTransporte(pedidoDataAccess.getRutaTransporte(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoLlamada.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setTipoLlamada(pedidoDataAccess.getTipoLlamada(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setTransportista(pedidoDataAccess.getTransportista(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setTipoCambio(pedidoDataAccess.getTipoCambio(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setCentroCosto(pedidoDataAccess.getCentroCosto(connexion,pedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setZona(pedidoDataAccess.getZona(connexion,pedido));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetallePedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetallePedido.class));
			pedido.setDetallePedidos(pedidoDataAccess.getDetallePedidos(connexion,pedido));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pedido.setEmpresa(pedidoDataAccess.getEmpresa(connexion,pedido));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(pedido.getEmpresa(),isDeep,deepLoadType,clases);
				
		pedido.setSucursal(pedidoDataAccess.getSucursal(connexion,pedido));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(pedido.getSucursal(),isDeep,deepLoadType,clases);
				
		pedido.setEjercicio(pedidoDataAccess.getEjercicio(connexion,pedido));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(pedido.getEjercicio(),isDeep,deepLoadType,clases);
				
		pedido.setPeriodo(pedidoDataAccess.getPeriodo(connexion,pedido));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(pedido.getPeriodo(),isDeep,deepLoadType,clases);
				
		pedido.setAnio(pedidoDataAccess.getAnio(connexion,pedido));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(pedido.getAnio(),isDeep,deepLoadType,clases);
				
		pedido.setMes(pedidoDataAccess.getMes(connexion,pedido));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(pedido.getMes(),isDeep,deepLoadType,clases);
				
		pedido.setUsuario(pedidoDataAccess.getUsuario(connexion,pedido));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(pedido.getUsuario(),isDeep,deepLoadType,clases);
				
		pedido.setMoneda(pedidoDataAccess.getMoneda(connexion,pedido));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(pedido.getMoneda(),isDeep,deepLoadType,clases);
				
		pedido.setEmpleado(pedidoDataAccess.getEmpleado(connexion,pedido));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(pedido.getEmpleado(),isDeep,deepLoadType,clases);
				
		pedido.setTipoPrecio(pedidoDataAccess.getTipoPrecio(connexion,pedido));
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(pedido.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		pedido.setFormato(pedidoDataAccess.getFormato(connexion,pedido));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(pedido.getFormato(),isDeep,deepLoadType,clases);
				
		pedido.setCliente(pedidoDataAccess.getCliente(connexion,pedido));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(pedido.getCliente(),isDeep,deepLoadType,clases);
				
		pedido.setSubCliente(pedidoDataAccess.getSubCliente(connexion,pedido));
		SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
		subclienteLogic.deepLoad(pedido.getSubCliente(),isDeep,deepLoadType,clases);
				
		pedido.setVendedor(pedidoDataAccess.getVendedor(connexion,pedido));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(pedido.getVendedor(),isDeep,deepLoadType,clases);
				
		pedido.setConsultor(pedidoDataAccess.getConsultor(connexion,pedido));
		ConsultorLogic consultorLogic= new ConsultorLogic(connexion);
		consultorLogic.deepLoad(pedido.getConsultor(),isDeep,deepLoadType,clases);
				
		pedido.setResponsable(pedidoDataAccess.getResponsable(connexion,pedido));
		ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
		responsableLogic.deepLoad(pedido.getResponsable(),isDeep,deepLoadType,clases);
				
		pedido.setEstadoPedido(pedidoDataAccess.getEstadoPedido(connexion,pedido));
		EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
		estadopedidoLogic.deepLoad(pedido.getEstadoPedido(),isDeep,deepLoadType,clases);
				
		pedido.setTransporte(pedidoDataAccess.getTransporte(connexion,pedido));
		TransporteLogic transporteLogic= new TransporteLogic(connexion);
		transporteLogic.deepLoad(pedido.getTransporte(),isDeep,deepLoadType,clases);
				
		pedido.setRutaTransporte(pedidoDataAccess.getRutaTransporte(connexion,pedido));
		RutaTransporteLogic rutatransporteLogic= new RutaTransporteLogic(connexion);
		rutatransporteLogic.deepLoad(pedido.getRutaTransporte(),isDeep,deepLoadType,clases);
				
		pedido.setTipoLlamada(pedidoDataAccess.getTipoLlamada(connexion,pedido));
		TipoLlamadaLogic tipollamadaLogic= new TipoLlamadaLogic(connexion);
		tipollamadaLogic.deepLoad(pedido.getTipoLlamada(),isDeep,deepLoadType,clases);
				
		pedido.setTransportista(pedidoDataAccess.getTransportista(connexion,pedido));
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(pedido.getTransportista(),isDeep,deepLoadType,clases);
				
		pedido.setTipoCambio(pedidoDataAccess.getTipoCambio(connexion,pedido));
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(pedido.getTipoCambio(),isDeep,deepLoadType,clases);
				
		pedido.setCentroCosto(pedidoDataAccess.getCentroCosto(connexion,pedido));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(pedido.getCentroCosto(),isDeep,deepLoadType,clases);
				
		pedido.setZona(pedidoDataAccess.getZona(connexion,pedido));
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(pedido.getZona(),isDeep,deepLoadType,clases);
				

		pedido.setDetallePedidos(pedidoDataAccess.getDetallePedidos(connexion,pedido));

		for(DetallePedido detallepedido:pedido.getDetallePedidos()) {
			DetallePedidoLogic detallepedidoLogic= new DetallePedidoLogic(connexion);
			detallepedidoLogic.deepLoad(detallepedido,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pedido.setEmpresa(pedidoDataAccess.getEmpresa(connexion,pedido));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(pedido.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				pedido.setSucursal(pedidoDataAccess.getSucursal(connexion,pedido));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(pedido.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				pedido.setEjercicio(pedidoDataAccess.getEjercicio(connexion,pedido));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(pedido.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				pedido.setPeriodo(pedidoDataAccess.getPeriodo(connexion,pedido));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(pedido.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				pedido.setAnio(pedidoDataAccess.getAnio(connexion,pedido));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(pedido.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				pedido.setMes(pedidoDataAccess.getMes(connexion,pedido));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(pedido.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				pedido.setUsuario(pedidoDataAccess.getUsuario(connexion,pedido));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(pedido.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				pedido.setMoneda(pedidoDataAccess.getMoneda(connexion,pedido));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(pedido.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				pedido.setEmpleado(pedidoDataAccess.getEmpleado(connexion,pedido));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(pedido.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				pedido.setTipoPrecio(pedidoDataAccess.getTipoPrecio(connexion,pedido));
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepLoad(pedido.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				pedido.setFormato(pedidoDataAccess.getFormato(connexion,pedido));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(pedido.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				pedido.setCliente(pedidoDataAccess.getCliente(connexion,pedido));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(pedido.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				pedido.setSubCliente(pedidoDataAccess.getSubCliente(connexion,pedido));
				SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
				subclienteLogic.deepLoad(pedido.getSubCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				pedido.setVendedor(pedidoDataAccess.getVendedor(connexion,pedido));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(pedido.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Consultor.class)) {
				pedido.setConsultor(pedidoDataAccess.getConsultor(connexion,pedido));
				ConsultorLogic consultorLogic= new ConsultorLogic(connexion);
				consultorLogic.deepLoad(pedido.getConsultor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				pedido.setResponsable(pedidoDataAccess.getResponsable(connexion,pedido));
				ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
				responsableLogic.deepLoad(pedido.getResponsable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				pedido.setEstadoPedido(pedidoDataAccess.getEstadoPedido(connexion,pedido));
				EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
				estadopedidoLogic.deepLoad(pedido.getEstadoPedido(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				pedido.setTransporte(pedidoDataAccess.getTransporte(connexion,pedido));
				TransporteLogic transporteLogic= new TransporteLogic(connexion);
				transporteLogic.deepLoad(pedido.getTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RutaTransporte.class)) {
				pedido.setRutaTransporte(pedidoDataAccess.getRutaTransporte(connexion,pedido));
				RutaTransporteLogic rutatransporteLogic= new RutaTransporteLogic(connexion);
				rutatransporteLogic.deepLoad(pedido.getRutaTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoLlamada.class)) {
				pedido.setTipoLlamada(pedidoDataAccess.getTipoLlamada(connexion,pedido));
				TipoLlamadaLogic tipollamadaLogic= new TipoLlamadaLogic(connexion);
				tipollamadaLogic.deepLoad(pedido.getTipoLlamada(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				pedido.setTransportista(pedidoDataAccess.getTransportista(connexion,pedido));
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepLoad(pedido.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				pedido.setTipoCambio(pedidoDataAccess.getTipoCambio(connexion,pedido));
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepLoad(pedido.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				pedido.setCentroCosto(pedidoDataAccess.getCentroCosto(connexion,pedido));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(pedido.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				pedido.setZona(pedidoDataAccess.getZona(connexion,pedido));
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepLoad(pedido.getZona(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetallePedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				pedido.setDetallePedidos(pedidoDataAccess.getDetallePedidos(connexion,pedido));

				for(DetallePedido detallepedido:pedido.getDetallePedidos()) {
					DetallePedidoLogic detallepedidoLogic= new DetallePedidoLogic(connexion);
					detallepedidoLogic.deepLoad(detallepedido,isDeep,deepLoadType,clases);
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
			pedido.setEmpresa(pedidoDataAccess.getEmpresa(connexion,pedido));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(pedido.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setSucursal(pedidoDataAccess.getSucursal(connexion,pedido));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(pedido.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setEjercicio(pedidoDataAccess.getEjercicio(connexion,pedido));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(pedido.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setPeriodo(pedidoDataAccess.getPeriodo(connexion,pedido));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(pedido.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setAnio(pedidoDataAccess.getAnio(connexion,pedido));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(pedido.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setMes(pedidoDataAccess.getMes(connexion,pedido));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(pedido.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setUsuario(pedidoDataAccess.getUsuario(connexion,pedido));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(pedido.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setMoneda(pedidoDataAccess.getMoneda(connexion,pedido));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(pedido.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setEmpleado(pedidoDataAccess.getEmpleado(connexion,pedido));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(pedido.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setTipoPrecio(pedidoDataAccess.getTipoPrecio(connexion,pedido));
			TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
			tipoprecioLogic.deepLoad(pedido.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setFormato(pedidoDataAccess.getFormato(connexion,pedido));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(pedido.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setCliente(pedidoDataAccess.getCliente(connexion,pedido));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(pedido.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(SubCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setSubCliente(pedidoDataAccess.getSubCliente(connexion,pedido));
			SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
			subclienteLogic.deepLoad(pedido.getSubCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setVendedor(pedidoDataAccess.getVendedor(connexion,pedido));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(pedido.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Consultor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setConsultor(pedidoDataAccess.getConsultor(connexion,pedido));
			ConsultorLogic consultorLogic= new ConsultorLogic(connexion);
			consultorLogic.deepLoad(pedido.getConsultor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Responsable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setResponsable(pedidoDataAccess.getResponsable(connexion,pedido));
			ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
			responsableLogic.deepLoad(pedido.getResponsable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setEstadoPedido(pedidoDataAccess.getEstadoPedido(connexion,pedido));
			EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
			estadopedidoLogic.deepLoad(pedido.getEstadoPedido(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setTransporte(pedidoDataAccess.getTransporte(connexion,pedido));
			TransporteLogic transporteLogic= new TransporteLogic(connexion);
			transporteLogic.deepLoad(pedido.getTransporte(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(RutaTransporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setRutaTransporte(pedidoDataAccess.getRutaTransporte(connexion,pedido));
			RutaTransporteLogic rutatransporteLogic= new RutaTransporteLogic(connexion);
			rutatransporteLogic.deepLoad(pedido.getRutaTransporte(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoLlamada.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setTipoLlamada(pedidoDataAccess.getTipoLlamada(connexion,pedido));
			TipoLlamadaLogic tipollamadaLogic= new TipoLlamadaLogic(connexion);
			tipollamadaLogic.deepLoad(pedido.getTipoLlamada(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setTransportista(pedidoDataAccess.getTransportista(connexion,pedido));
			TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
			transportistaLogic.deepLoad(pedido.getTransportista(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setTipoCambio(pedidoDataAccess.getTipoCambio(connexion,pedido));
			TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
			tipocambioLogic.deepLoad(pedido.getTipoCambio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setCentroCosto(pedidoDataAccess.getCentroCosto(connexion,pedido));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(pedido.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedido.setZona(pedidoDataAccess.getZona(connexion,pedido));
			ZonaLogic zonaLogic= new ZonaLogic(connexion);
			zonaLogic.deepLoad(pedido.getZona(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetallePedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetallePedido.class));
			pedido.setDetallePedidos(pedidoDataAccess.getDetallePedidos(connexion,pedido));

			for(DetallePedido detallepedido:pedido.getDetallePedidos()) {
				DetallePedidoLogic detallepedidoLogic= new DetallePedidoLogic(connexion);
				detallepedidoLogic.deepLoad(detallepedido,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Pedido pedido,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PedidoLogicAdditional.updatePedidoToSave(pedido,this.arrDatoGeneral);
			
PedidoDataAccess.save(pedido, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(pedido.getEmpresa(),connexion);

		SucursalDataAccess.save(pedido.getSucursal(),connexion);

		EjercicioDataAccess.save(pedido.getEjercicio(),connexion);

		PeriodoDataAccess.save(pedido.getPeriodo(),connexion);

		AnioDataAccess.save(pedido.getAnio(),connexion);

		MesDataAccess.save(pedido.getMes(),connexion);

		UsuarioDataAccess.save(pedido.getUsuario(),connexion);

		MonedaDataAccess.save(pedido.getMoneda(),connexion);

		EmpleadoDataAccess.save(pedido.getEmpleado(),connexion);

		TipoPrecioDataAccess.save(pedido.getTipoPrecio(),connexion);

		FormatoDataAccess.save(pedido.getFormato(),connexion);

		ClienteDataAccess.save(pedido.getCliente(),connexion);

		SubClienteDataAccess.save(pedido.getSubCliente(),connexion);

		VendedorDataAccess.save(pedido.getVendedor(),connexion);

		ConsultorDataAccess.save(pedido.getConsultor(),connexion);

		ResponsableDataAccess.save(pedido.getResponsable(),connexion);

		EstadoPedidoDataAccess.save(pedido.getEstadoPedido(),connexion);

		TransporteDataAccess.save(pedido.getTransporte(),connexion);

		RutaTransporteDataAccess.save(pedido.getRutaTransporte(),connexion);

		TipoLlamadaDataAccess.save(pedido.getTipoLlamada(),connexion);

		TransportistaDataAccess.save(pedido.getTransportista(),connexion);

		TipoCambioDataAccess.save(pedido.getTipoCambio(),connexion);

		CentroCostoDataAccess.save(pedido.getCentroCosto(),connexion);

		ZonaDataAccess.save(pedido.getZona(),connexion);

		for(DetallePedido detallepedido:pedido.getDetallePedidos()) {
			detallepedido.setid_pedido(pedido.getId());
			DetallePedidoDataAccess.save(detallepedido,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(pedido.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(pedido.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(pedido.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(pedido.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(pedido.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(pedido.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(pedido.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(pedido.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(pedido.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(pedido.getTipoPrecio(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(pedido.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(pedido.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				SubClienteDataAccess.save(pedido.getSubCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(pedido.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Consultor.class)) {
				ConsultorDataAccess.save(pedido.getConsultor(),connexion);
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				ResponsableDataAccess.save(pedido.getResponsable(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				EstadoPedidoDataAccess.save(pedido.getEstadoPedido(),connexion);
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				TransporteDataAccess.save(pedido.getTransporte(),connexion);
				continue;
			}

			if(clas.clas.equals(RutaTransporte.class)) {
				RutaTransporteDataAccess.save(pedido.getRutaTransporte(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoLlamada.class)) {
				TipoLlamadaDataAccess.save(pedido.getTipoLlamada(),connexion);
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(pedido.getTransportista(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(pedido.getTipoCambio(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(pedido.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				ZonaDataAccess.save(pedido.getZona(),connexion);
				continue;
			}


			if(clas.clas.equals(DetallePedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetallePedido detallepedido:pedido.getDetallePedidos()) {
					detallepedido.setid_pedido(pedido.getId());
					DetallePedidoDataAccess.save(detallepedido,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(pedido.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(pedido.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(pedido.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(pedido.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(pedido.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(pedido.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(pedido.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(pedido.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(pedido.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(pedido.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(pedido.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(pedido.getMes(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(pedido.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(pedido.getUsuario(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(pedido.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(pedido.getMoneda(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(pedido.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(pedido.getEmpleado(),isDeep,deepLoadType,clases);
				

		TipoPrecioDataAccess.save(pedido.getTipoPrecio(),connexion);
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(pedido.getTipoPrecio(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(pedido.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(pedido.getFormato(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(pedido.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(pedido.getCliente(),isDeep,deepLoadType,clases);
				

		SubClienteDataAccess.save(pedido.getSubCliente(),connexion);
		SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
		subclienteLogic.deepLoad(pedido.getSubCliente(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(pedido.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(pedido.getVendedor(),isDeep,deepLoadType,clases);
				

		ConsultorDataAccess.save(pedido.getConsultor(),connexion);
		ConsultorLogic consultorLogic= new ConsultorLogic(connexion);
		consultorLogic.deepLoad(pedido.getConsultor(),isDeep,deepLoadType,clases);
				

		ResponsableDataAccess.save(pedido.getResponsable(),connexion);
		ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
		responsableLogic.deepLoad(pedido.getResponsable(),isDeep,deepLoadType,clases);
				

		EstadoPedidoDataAccess.save(pedido.getEstadoPedido(),connexion);
		EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
		estadopedidoLogic.deepLoad(pedido.getEstadoPedido(),isDeep,deepLoadType,clases);
				

		TransporteDataAccess.save(pedido.getTransporte(),connexion);
		TransporteLogic transporteLogic= new TransporteLogic(connexion);
		transporteLogic.deepLoad(pedido.getTransporte(),isDeep,deepLoadType,clases);
				

		RutaTransporteDataAccess.save(pedido.getRutaTransporte(),connexion);
		RutaTransporteLogic rutatransporteLogic= new RutaTransporteLogic(connexion);
		rutatransporteLogic.deepLoad(pedido.getRutaTransporte(),isDeep,deepLoadType,clases);
				

		TipoLlamadaDataAccess.save(pedido.getTipoLlamada(),connexion);
		TipoLlamadaLogic tipollamadaLogic= new TipoLlamadaLogic(connexion);
		tipollamadaLogic.deepLoad(pedido.getTipoLlamada(),isDeep,deepLoadType,clases);
				

		TransportistaDataAccess.save(pedido.getTransportista(),connexion);
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(pedido.getTransportista(),isDeep,deepLoadType,clases);
				

		TipoCambioDataAccess.save(pedido.getTipoCambio(),connexion);
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(pedido.getTipoCambio(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(pedido.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(pedido.getCentroCosto(),isDeep,deepLoadType,clases);
				

		ZonaDataAccess.save(pedido.getZona(),connexion);
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(pedido.getZona(),isDeep,deepLoadType,clases);
				

		for(DetallePedido detallepedido:pedido.getDetallePedidos()) {
			DetallePedidoLogic detallepedidoLogic= new DetallePedidoLogic(connexion);
			detallepedido.setid_pedido(pedido.getId());
			DetallePedidoDataAccess.save(detallepedido,connexion);
			detallepedidoLogic.deepSave(detallepedido,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(pedido.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(pedido.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(pedido.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(pedido.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(pedido.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(pedido.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(pedido.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(pedido.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(pedido.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(pedido.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(pedido.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(pedido.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(pedido.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(pedido.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(pedido.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(pedido.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(pedido.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(pedido.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(pedido.getTipoPrecio(),connexion);
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepSave(pedido.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(pedido.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(pedido.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(pedido.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(pedido.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				SubClienteDataAccess.save(pedido.getSubCliente(),connexion);
				SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
				subclienteLogic.deepSave(pedido.getSubCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(pedido.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(pedido.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Consultor.class)) {
				ConsultorDataAccess.save(pedido.getConsultor(),connexion);
				ConsultorLogic consultorLogic= new ConsultorLogic(connexion);
				consultorLogic.deepSave(pedido.getConsultor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				ResponsableDataAccess.save(pedido.getResponsable(),connexion);
				ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
				responsableLogic.deepSave(pedido.getResponsable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				EstadoPedidoDataAccess.save(pedido.getEstadoPedido(),connexion);
				EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
				estadopedidoLogic.deepSave(pedido.getEstadoPedido(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				TransporteDataAccess.save(pedido.getTransporte(),connexion);
				TransporteLogic transporteLogic= new TransporteLogic(connexion);
				transporteLogic.deepSave(pedido.getTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RutaTransporte.class)) {
				RutaTransporteDataAccess.save(pedido.getRutaTransporte(),connexion);
				RutaTransporteLogic rutatransporteLogic= new RutaTransporteLogic(connexion);
				rutatransporteLogic.deepSave(pedido.getRutaTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoLlamada.class)) {
				TipoLlamadaDataAccess.save(pedido.getTipoLlamada(),connexion);
				TipoLlamadaLogic tipollamadaLogic= new TipoLlamadaLogic(connexion);
				tipollamadaLogic.deepSave(pedido.getTipoLlamada(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(pedido.getTransportista(),connexion);
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepSave(pedido.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(pedido.getTipoCambio(),connexion);
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepSave(pedido.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(pedido.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(pedido.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				ZonaDataAccess.save(pedido.getZona(),connexion);
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepSave(pedido.getZona(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetallePedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetallePedido detallepedido:pedido.getDetallePedidos()) {
					DetallePedidoLogic detallepedidoLogic= new DetallePedidoLogic(connexion);
					detallepedido.setid_pedido(pedido.getId());
					DetallePedidoDataAccess.save(detallepedido,connexion);
					detallepedidoLogic.deepSave(detallepedido,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Pedido.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(pedido,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(pedido);
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
			this.deepLoad(this.pedido,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Pedido.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(pedidos!=null) {
				for(Pedido pedido:pedidos) {
					this.deepLoad(pedido,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(pedidos);
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
			if(pedidos!=null) {
				for(Pedido pedido:pedidos) {
					this.deepLoad(pedido,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(pedidos);
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
			this.getNewConnexionToDeep(Pedido.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(pedido,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Pedido.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(pedidos!=null) {
				for(Pedido pedido:pedidos) {
					this.deepSave(pedido,isDeep,deepLoadType,clases);
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
			if(pedidos!=null) {
				for(Pedido pedido:pedidos) {
					this.deepSave(pedido,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPedidosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PedidoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PedidoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,PedidoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,PedidoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,PedidoConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,PedidoConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdConsultorWithConnection(String sFinalQuery,Pagination pagination,Long id_consultor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConsultor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConsultor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_consultor,PedidoConstantesFunciones.IDCONSULTOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConsultor);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConsultor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdConsultor(String sFinalQuery,Pagination pagination,Long id_consultor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConsultor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConsultor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_consultor,PedidoConstantesFunciones.IDCONSULTOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConsultor);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConsultor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PedidoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PedidoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,PedidoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,PedidoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PedidoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PedidoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdEstadoPedidoWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_pedido)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido,PedidoConstantesFunciones.IDESTADOPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedido);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedido","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdEstadoPedido(String sFinalQuery,Pagination pagination,Long id_estado_pedido)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido,PedidoConstantesFunciones.IDESTADOPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedido);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedido","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,PedidoConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,PedidoConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PedidoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PedidoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,PedidoConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,PedidoConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PedidoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PedidoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdResponsableWithConnection(String sFinalQuery,Pagination pagination,Long id_responsable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidResponsable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidResponsable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_responsable,PedidoConstantesFunciones.IDRESPONSABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidResponsable);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdResponsable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdResponsable(String sFinalQuery,Pagination pagination,Long id_responsable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidResponsable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidResponsable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_responsable,PedidoConstantesFunciones.IDRESPONSABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidResponsable);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdResponsable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdRutaTransporteWithConnection(String sFinalQuery,Pagination pagination,Long id_ruta_transporte)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRutaTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRutaTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ruta_transporte,PedidoConstantesFunciones.IDRUTATRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRutaTransporte);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRutaTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdRutaTransporte(String sFinalQuery,Pagination pagination,Long id_ruta_transporte)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRutaTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRutaTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ruta_transporte,PedidoConstantesFunciones.IDRUTATRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRutaTransporte);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRutaTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdSubClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_sub_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSubCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSubCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sub_cliente,PedidoConstantesFunciones.IDSUBCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSubCliente);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSubCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdSubCliente(String sFinalQuery,Pagination pagination,Long id_sub_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSubCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSubCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sub_cliente,PedidoConstantesFunciones.IDSUBCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSubCliente);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSubCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PedidoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PedidoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdTipoCambioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,PedidoConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdTipoCambio(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,PedidoConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdTipoLlamadaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_llamada)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoLlamada= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoLlamada.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_llamada,PedidoConstantesFunciones.IDTIPOLLAMADA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoLlamada);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoLlamada","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdTipoLlamada(String sFinalQuery,Pagination pagination,Long id_tipo_llamada)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoLlamada= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoLlamada.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_llamada,PedidoConstantesFunciones.IDTIPOLLAMADA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoLlamada);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoLlamada","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdTipoPrecioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,PedidoConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdTipoPrecio(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,PedidoConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdTransporteWithConnection(String sFinalQuery,Pagination pagination,Long id_transporte)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transporte,PedidoConstantesFunciones.IDTRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransporte);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdTransporte(String sFinalQuery,Pagination pagination,Long id_transporte)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transporte,PedidoConstantesFunciones.IDTRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransporte);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdTransportistaWithConnection(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,PedidoConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdTransportista(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,PedidoConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,PedidoConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,PedidoConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,PedidoConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,PedidoConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidosFK_IdZonaWithConnection(String sFinalQuery,Pagination pagination,Long id_zona)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidZona= new ParameterSelectionGeneral();
			parameterSelectionGeneralidZona.setParameterSelectionGeneralEqual(ParameterType.LONG,id_zona,PedidoConstantesFunciones.IDZONA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidZona);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdZona","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidosFK_IdZona(String sFinalQuery,Pagination pagination,Long id_zona)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidZona= new ParameterSelectionGeneral();
			parameterSelectionGeneralidZona.setParameterSelectionGeneralEqual(ParameterType.LONG,id_zona,PedidoConstantesFunciones.IDZONA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidZona);

			PedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdZona","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(this.pedidos);
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
			if(PedidoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Pedido pedido,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PedidoConstantesFunciones.ISCONAUDITORIA) {
				if(pedido.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoDataAccess.TABLENAME, pedido.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PedidoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PedidoLogic.registrarAuditoriaDetallesPedido(connexion,pedido,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(pedido.getIsDeleted()) {
					/*if(!pedido.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PedidoDataAccess.TABLENAME, pedido.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PedidoLogic.registrarAuditoriaDetallesPedido(connexion,pedido,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoDataAccess.TABLENAME, pedido.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(pedido.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoDataAccess.TABLENAME, pedido.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PedidoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PedidoLogic.registrarAuditoriaDetallesPedido(connexion,pedido,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPedido(Connexion connexion,Pedido pedido)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(pedido.getIsNew()||!pedido.getid_empresa().equals(pedido.getPedidoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_empresa()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_empresa().toString();
				}
				if(pedido.getid_empresa()!=null)
				{
					strValorNuevo=pedido.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_sucursal().equals(pedido.getPedidoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_sucursal()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_sucursal().toString();
				}
				if(pedido.getid_sucursal()!=null)
				{
					strValorNuevo=pedido.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_ejercicio().equals(pedido.getPedidoOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_ejercicio()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_ejercicio().toString();
				}
				if(pedido.getid_ejercicio()!=null)
				{
					strValorNuevo=pedido.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_periodo().equals(pedido.getPedidoOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_periodo()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_periodo().toString();
				}
				if(pedido.getid_periodo()!=null)
				{
					strValorNuevo=pedido.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_anio().equals(pedido.getPedidoOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_anio()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_anio().toString();
				}
				if(pedido.getid_anio()!=null)
				{
					strValorNuevo=pedido.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_mes().equals(pedido.getPedidoOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_mes()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_mes().toString();
				}
				if(pedido.getid_mes()!=null)
				{
					strValorNuevo=pedido.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_usuario().equals(pedido.getPedidoOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_usuario()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_usuario().toString();
				}
				if(pedido.getid_usuario()!=null)
				{
					strValorNuevo=pedido.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getnumero().equals(pedido.getPedidoOriginal().getnumero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getnumero()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getnumero();
				}
				if(pedido.getnumero()!=null)
				{
					strValorNuevo=pedido.getnumero() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.NUMERO,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getpre_impreso().equals(pedido.getPedidoOriginal().getpre_impreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getpre_impreso()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getpre_impreso();
				}
				if(pedido.getpre_impreso()!=null)
				{
					strValorNuevo=pedido.getpre_impreso() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.PREIMPRESO,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getfecha_emision().equals(pedido.getPedidoOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getfecha_emision()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getfecha_emision().toString();
				}
				if(pedido.getfecha_emision()!=null)
				{
					strValorNuevo=pedido.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getfecha_entrega().equals(pedido.getPedidoOriginal().getfecha_entrega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getfecha_entrega()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getfecha_entrega().toString();
				}
				if(pedido.getfecha_entrega()!=null)
				{
					strValorNuevo=pedido.getfecha_entrega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.FECHAENTREGA,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_moneda().equals(pedido.getPedidoOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_moneda()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_moneda().toString();
				}
				if(pedido.getid_moneda()!=null)
				{
					strValorNuevo=pedido.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getcotizacion().equals(pedido.getPedidoOriginal().getcotizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getcotizacion()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getcotizacion().toString();
				}
				if(pedido.getcotizacion()!=null)
				{
					strValorNuevo=pedido.getcotizacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.COTIZACION,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_empleado().equals(pedido.getPedidoOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_empleado()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_empleado().toString();
				}
				if(pedido.getid_empleado()!=null)
				{
					strValorNuevo=pedido.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_tipo_precio().equals(pedido.getPedidoOriginal().getid_tipo_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_tipo_precio()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_tipo_precio().toString();
				}
				if(pedido.getid_tipo_precio()!=null)
				{
					strValorNuevo=pedido.getid_tipo_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDTIPOPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_formato().equals(pedido.getPedidoOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_formato()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_formato().toString();
				}
				if(pedido.getid_formato()!=null)
				{
					strValorNuevo=pedido.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getdireccion().equals(pedido.getPedidoOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getdireccion()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getdireccion();
				}
				if(pedido.getdireccion()!=null)
				{
					strValorNuevo=pedido.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_cliente().equals(pedido.getPedidoOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_cliente()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_cliente().toString();
				}
				if(pedido.getid_cliente()!=null)
				{
					strValorNuevo=pedido.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.gettelefono().equals(pedido.getPedidoOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().gettelefono()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().gettelefono();
				}
				if(pedido.gettelefono()!=null)
				{
					strValorNuevo=pedido.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getruc().equals(pedido.getPedidoOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getruc()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getruc();
				}
				if(pedido.getruc()!=null)
				{
					strValorNuevo=pedido.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_sub_cliente().equals(pedido.getPedidoOriginal().getid_sub_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_sub_cliente()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_sub_cliente().toString();
				}
				if(pedido.getid_sub_cliente()!=null)
				{
					strValorNuevo=pedido.getid_sub_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDSUBCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_vendedor().equals(pedido.getPedidoOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_vendedor()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_vendedor().toString();
				}
				if(pedido.getid_vendedor()!=null)
				{
					strValorNuevo=pedido.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_consultor().equals(pedido.getPedidoOriginal().getid_consultor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_consultor()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_consultor().toString();
				}
				if(pedido.getid_consultor()!=null)
				{
					strValorNuevo=pedido.getid_consultor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDCONSULTOR,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getorden().equals(pedido.getPedidoOriginal().getorden()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getorden()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getorden();
				}
				if(pedido.getorden()!=null)
				{
					strValorNuevo=pedido.getorden() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.ORDEN,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_responsable().equals(pedido.getPedidoOriginal().getid_responsable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_responsable()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_responsable().toString();
				}
				if(pedido.getid_responsable()!=null)
				{
					strValorNuevo=pedido.getid_responsable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDRESPONSABLE,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_estado_pedido().equals(pedido.getPedidoOriginal().getid_estado_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_estado_pedido()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_estado_pedido().toString();
				}
				if(pedido.getid_estado_pedido()!=null)
				{
					strValorNuevo=pedido.getid_estado_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDESTADOPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_transporte().equals(pedido.getPedidoOriginal().getid_transporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_transporte()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_transporte().toString();
				}
				if(pedido.getid_transporte()!=null)
				{
					strValorNuevo=pedido.getid_transporte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDTRANSPORTE,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_ruta_transporte().equals(pedido.getPedidoOriginal().getid_ruta_transporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_ruta_transporte()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_ruta_transporte().toString();
				}
				if(pedido.getid_ruta_transporte()!=null)
				{
					strValorNuevo=pedido.getid_ruta_transporte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDRUTATRANSPORTE,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getvalor_ruta().equals(pedido.getPedidoOriginal().getvalor_ruta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getvalor_ruta()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getvalor_ruta().toString();
				}
				if(pedido.getvalor_ruta()!=null)
				{
					strValorNuevo=pedido.getvalor_ruta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.VALORRUTA,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_tipo_llamada().equals(pedido.getPedidoOriginal().getid_tipo_llamada()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_tipo_llamada()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_tipo_llamada().toString();
				}
				if(pedido.getid_tipo_llamada()!=null)
				{
					strValorNuevo=pedido.getid_tipo_llamada().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDTIPOLLAMADA,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_transportista().equals(pedido.getPedidoOriginal().getid_transportista()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_transportista()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_transportista().toString();
				}
				if(pedido.getid_transportista()!=null)
				{
					strValorNuevo=pedido.getid_transportista().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDTRANSPORTISTA,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.gethora_inicio().equals(pedido.getPedidoOriginal().gethora_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().gethora_inicio()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().gethora_inicio().toString();
				}
				if(pedido.gethora_inicio()!=null)
				{
					strValorNuevo=pedido.gethora_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.HORAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.gethora_fin().equals(pedido.getPedidoOriginal().gethora_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().gethora_fin()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().gethora_fin().toString();
				}
				if(pedido.gethora_fin()!=null)
				{
					strValorNuevo=pedido.gethora_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.HORAFIN,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getdescripcion().equals(pedido.getPedidoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getdescripcion()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getdescripcion();
				}
				if(pedido.getdescripcion()!=null)
				{
					strValorNuevo=pedido.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getcupo().equals(pedido.getPedidoOriginal().getcupo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getcupo()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getcupo().toString();
				}
				if(pedido.getcupo()!=null)
				{
					strValorNuevo=pedido.getcupo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.CUPO,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getsaldo().equals(pedido.getPedidoOriginal().getsaldo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getsaldo()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getsaldo().toString();
				}
				if(pedido.getsaldo()!=null)
				{
					strValorNuevo=pedido.getsaldo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.SALDO,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getpedidos().equals(pedido.getPedidoOriginal().getpedidos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getpedidos()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getpedidos().toString();
				}
				if(pedido.getpedidos()!=null)
				{
					strValorNuevo=pedido.getpedidos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.PEDIDOS,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getdocumentos().equals(pedido.getPedidoOriginal().getdocumentos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getdocumentos()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getdocumentos().toString();
				}
				if(pedido.getdocumentos()!=null)
				{
					strValorNuevo=pedido.getdocumentos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.DOCUMENTOS,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getdisponible().equals(pedido.getPedidoOriginal().getdisponible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getdisponible()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getdisponible().toString();
				}
				if(pedido.getdisponible()!=null)
				{
					strValorNuevo=pedido.getdisponible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.DISPONIBLE,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getdescuento_porcentaje().equals(pedido.getPedidoOriginal().getdescuento_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getdescuento_porcentaje()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getdescuento_porcentaje().toString();
				}
				if(pedido.getdescuento_porcentaje()!=null)
				{
					strValorNuevo=pedido.getdescuento_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.DESCUENTOPORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.gettotal_con_iva().equals(pedido.getPedidoOriginal().gettotal_con_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().gettotal_con_iva()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().gettotal_con_iva().toString();
				}
				if(pedido.gettotal_con_iva()!=null)
				{
					strValorNuevo=pedido.gettotal_con_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.TOTALCONIVA,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getsuman().equals(pedido.getPedidoOriginal().getsuman()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getsuman()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getsuman().toString();
				}
				if(pedido.getsuman()!=null)
				{
					strValorNuevo=pedido.getsuman().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.SUMAN,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getdescuento_valor().equals(pedido.getPedidoOriginal().getdescuento_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getdescuento_valor()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getdescuento_valor().toString();
				}
				if(pedido.getdescuento_valor()!=null)
				{
					strValorNuevo=pedido.getdescuento_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.DESCUENTOVALOR,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.gettotal_sin_iva().equals(pedido.getPedidoOriginal().gettotal_sin_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().gettotal_sin_iva()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().gettotal_sin_iva().toString();
				}
				if(pedido.gettotal_sin_iva()!=null)
				{
					strValorNuevo=pedido.gettotal_sin_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.TOTALSINIVA,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getdescuento_total().equals(pedido.getPedidoOriginal().getdescuento_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getdescuento_total()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getdescuento_total().toString();
				}
				if(pedido.getdescuento_total()!=null)
				{
					strValorNuevo=pedido.getdescuento_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.DESCUENTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getflete().equals(pedido.getPedidoOriginal().getflete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getflete()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getflete().toString();
				}
				if(pedido.getflete()!=null)
				{
					strValorNuevo=pedido.getflete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.FLETE,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.gettotal().equals(pedido.getPedidoOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().gettotal()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().gettotal().toString();
				}
				if(pedido.gettotal()!=null)
				{
					strValorNuevo=pedido.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getsubtotal().equals(pedido.getPedidoOriginal().getsubtotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getsubtotal()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getsubtotal().toString();
				}
				if(pedido.getsubtotal()!=null)
				{
					strValorNuevo=pedido.getsubtotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.SUBTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getotro().equals(pedido.getPedidoOriginal().getotro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getotro()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getotro().toString();
				}
				if(pedido.getotro()!=null)
				{
					strValorNuevo=pedido.getotro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.OTRO,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getultimo_costo().equals(pedido.getPedidoOriginal().getultimo_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getultimo_costo()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getultimo_costo().toString();
				}
				if(pedido.getultimo_costo()!=null)
				{
					strValorNuevo=pedido.getultimo_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.ULTIMOCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getiva().equals(pedido.getPedidoOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getiva()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getiva().toString();
				}
				if(pedido.getiva()!=null)
				{
					strValorNuevo=pedido.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getfinanciamiento().equals(pedido.getPedidoOriginal().getfinanciamiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getfinanciamiento()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getfinanciamiento().toString();
				}
				if(pedido.getfinanciamiento()!=null)
				{
					strValorNuevo=pedido.getfinanciamiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.FINANCIAMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getmargen_utilidad().equals(pedido.getPedidoOriginal().getmargen_utilidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getmargen_utilidad()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getmargen_utilidad().toString();
				}
				if(pedido.getmargen_utilidad()!=null)
				{
					strValorNuevo=pedido.getmargen_utilidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.MARGENUTILIDAD,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getotros_valores().equals(pedido.getPedidoOriginal().getotros_valores()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getotros_valores()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getotros_valores().toString();
				}
				if(pedido.getotros_valores()!=null)
				{
					strValorNuevo=pedido.getotros_valores().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.OTROSVALORES,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getanticipo().equals(pedido.getPedidoOriginal().getanticipo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getanticipo()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getanticipo().toString();
				}
				if(pedido.getanticipo()!=null)
				{
					strValorNuevo=pedido.getanticipo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.ANTICIPO,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_tipo_cambio().equals(pedido.getPedidoOriginal().getid_tipo_cambio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_tipo_cambio()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_tipo_cambio().toString();
				}
				if(pedido.getid_tipo_cambio()!=null)
				{
					strValorNuevo=pedido.getid_tipo_cambio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDTIPOCAMBIO,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_centro_costo().equals(pedido.getPedidoOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_centro_costo()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_centro_costo().toString();
				}
				if(pedido.getid_centro_costo()!=null)
				{
					strValorNuevo=pedido.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getid_zona().equals(pedido.getPedidoOriginal().getid_zona()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getid_zona()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getid_zona().toString();
				}
				if(pedido.getid_zona()!=null)
				{
					strValorNuevo=pedido.getid_zona().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.IDZONA,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getfecha().equals(pedido.getPedidoOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getfecha()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getfecha().toString();
				}
				if(pedido.getfecha()!=null)
				{
					strValorNuevo=pedido.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getnumero_fue().equals(pedido.getPedidoOriginal().getnumero_fue()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getnumero_fue()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getnumero_fue();
				}
				if(pedido.getnumero_fue()!=null)
				{
					strValorNuevo=pedido.getnumero_fue() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.NUMEROFUE,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getfecha_servidor().equals(pedido.getPedidoOriginal().getfecha_servidor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getfecha_servidor()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getfecha_servidor().toString();
				}
				if(pedido.getfecha_servidor()!=null)
				{
					strValorNuevo=pedido.getfecha_servidor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.FECHASERVIDOR,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getmonto_retencion().equals(pedido.getPedidoOriginal().getmonto_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getmonto_retencion()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getmonto_retencion().toString();
				}
				if(pedido.getmonto_retencion()!=null)
				{
					strValorNuevo=pedido.getmonto_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.MONTORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(pedido.getIsNew()||!pedido.getice().equals(pedido.getPedidoOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedido.getPedidoOriginal().getice()!=null)
				{
					strValorActual=pedido.getPedidoOriginal().getice().toString();
				}
				if(pedido.getice()!=null)
				{
					strValorNuevo=pedido.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePedidoRelacionesWithConnection(Pedido pedido,List<DetallePedido> detallepedidos) throws Exception {

		if(!pedido.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePedidoRelacionesBase(pedido,detallepedidos,true);
		}
	}

	public void savePedidoRelaciones(Pedido pedido,List<DetallePedido> detallepedidos)throws Exception {

		if(!pedido.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePedidoRelacionesBase(pedido,detallepedidos,false);
		}
	}

	public void savePedidoRelacionesBase(Pedido pedido,List<DetallePedido> detallepedidos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Pedido-saveRelacionesWithConnection");}
	
			pedido.setDetallePedidos(detallepedidos);

			this.setPedido(pedido);

			if(PedidoLogicAdditional.validarSaveRelaciones(pedido,this)) {

				PedidoLogicAdditional.updateRelacionesToSave(pedido,this);

				if((pedido.getIsNew()||pedido.getIsChanged())&&!pedido.getIsDeleted()) {
					this.savePedido();
					this.savePedidoRelacionesDetalles(detallepedidos);

				} else if(pedido.getIsDeleted()) {
					this.savePedidoRelacionesDetalles(detallepedidos);
					this.savePedido();
				}

				PedidoLogicAdditional.updateRelacionesToSaveAfter(pedido,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetallePedidoConstantesFunciones.InicializarGeneralEntityAuxiliaresDetallePedidos(detallepedidos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void savePedidoRelacionesDetalles(List<DetallePedido> detallepedidos)throws Exception {
		try {
	

			Long idPedidoActual=this.getPedido().getId();

			DetallePedidoLogic detallepedidoLogic_Desde_Pedido=new DetallePedidoLogic();
			detallepedidoLogic_Desde_Pedido.setDetallePedidos(detallepedidos);

			detallepedidoLogic_Desde_Pedido.setConnexion(this.getConnexion());
			detallepedidoLogic_Desde_Pedido.setDatosCliente(this.datosCliente);

			for(DetallePedido detallepedido_Desde_Pedido:detallepedidoLogic_Desde_Pedido.getDetallePedidos()) {
				detallepedido_Desde_Pedido.setid_pedido(idPedidoActual);
			}

			detallepedidoLogic_Desde_Pedido.saveDetallePedidos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PedidoConstantesFunciones.getClassesForeignKeysOfPedido(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PedidoConstantesFunciones.getClassesRelationshipsOfPedido(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

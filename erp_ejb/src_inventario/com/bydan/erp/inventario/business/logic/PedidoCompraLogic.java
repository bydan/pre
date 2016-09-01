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
import com.bydan.erp.inventario.util.PedidoCompraConstantesFunciones;
import com.bydan.erp.inventario.util.PedidoCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.PedidoCompraParameterGeneral;
import com.bydan.erp.inventario.business.entity.PedidoCompra;
import com.bydan.erp.inventario.business.logic.PedidoCompraLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.sris.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class PedidoCompraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PedidoCompraLogic.class);
	
	protected PedidoCompraDataAccess pedidocompraDataAccess; 	
	protected PedidoCompra pedidocompra;
	protected List<PedidoCompra> pedidocompras;
	protected Object pedidocompraObject;	
	protected List<Object> pedidocomprasObject;
	
	public static ClassValidator<PedidoCompra> pedidocompraValidator = new ClassValidator<PedidoCompra>(PedidoCompra.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PedidoCompraLogicAdditional pedidocompraLogicAdditional=null;
	
	public PedidoCompraLogicAdditional getPedidoCompraLogicAdditional() {
		return this.pedidocompraLogicAdditional;
	}
	
	public void setPedidoCompraLogicAdditional(PedidoCompraLogicAdditional pedidocompraLogicAdditional) {
		try {
			this.pedidocompraLogicAdditional=pedidocompraLogicAdditional;
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
	
	
	
	
	public  PedidoCompraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.pedidocompraDataAccess = new PedidoCompraDataAccess();
			
			this.pedidocompras= new ArrayList<PedidoCompra>();
			this.pedidocompra= new PedidoCompra();
			
			this.pedidocompraObject=new Object();
			this.pedidocomprasObject=new ArrayList<Object>();
				
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
			
			this.pedidocompraDataAccess.setConnexionType(this.connexionType);
			this.pedidocompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PedidoCompraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.pedidocompraDataAccess = new PedidoCompraDataAccess();
			this.pedidocompras= new ArrayList<PedidoCompra>();
			this.pedidocompra= new PedidoCompra();
			this.pedidocompraObject=new Object();
			this.pedidocomprasObject=new ArrayList<Object>();
			
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
			
			this.pedidocompraDataAccess.setConnexionType(this.connexionType);
			this.pedidocompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PedidoCompra getPedidoCompra() throws Exception {	
		PedidoCompraLogicAdditional.checkPedidoCompraToGet(pedidocompra,this.datosCliente,this.arrDatoGeneral);
		PedidoCompraLogicAdditional.updatePedidoCompraToGet(pedidocompra,this.arrDatoGeneral);
		
		return pedidocompra;
	}
		
	public void setPedidoCompra(PedidoCompra newPedidoCompra) {
		this.pedidocompra = newPedidoCompra;
	}
	
	public PedidoCompraDataAccess getPedidoCompraDataAccess() {
		return pedidocompraDataAccess;
	}
	
	public void setPedidoCompraDataAccess(PedidoCompraDataAccess newpedidocompraDataAccess) {
		this.pedidocompraDataAccess = newpedidocompraDataAccess;
	}
	
	public List<PedidoCompra> getPedidoCompras() throws Exception {		
		this.quitarPedidoComprasNulos();
		
		PedidoCompraLogicAdditional.checkPedidoCompraToGets(pedidocompras,this.datosCliente,this.arrDatoGeneral);
		
		for (PedidoCompra pedidocompraLocal: pedidocompras ) {
			PedidoCompraLogicAdditional.updatePedidoCompraToGet(pedidocompraLocal,this.arrDatoGeneral);
		}
		
		return pedidocompras;
	}
	
	public void setPedidoCompras(List<PedidoCompra> newPedidoCompras) {
		this.pedidocompras = newPedidoCompras;
	}
	
	public Object getPedidoCompraObject() {	
		this.pedidocompraObject=this.pedidocompraDataAccess.getEntityObject();
		return this.pedidocompraObject;
	}
		
	public void setPedidoCompraObject(Object newPedidoCompraObject) {
		this.pedidocompraObject = newPedidoCompraObject;
	}
	
	public List<Object> getPedidoComprasObject() {		
		this.pedidocomprasObject=this.pedidocompraDataAccess.getEntitiesObject();
		return this.pedidocomprasObject;
	}
		
	public void setPedidoComprasObject(List<Object> newPedidoComprasObject) {
		this.pedidocomprasObject = newPedidoComprasObject;
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
		
		if(this.pedidocompraDataAccess!=null) {
			this.pedidocompraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			pedidocompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			pedidocompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		pedidocompra = new  PedidoCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			pedidocompra=pedidocompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompra);
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
		pedidocompra = new  PedidoCompra();
		  		  
        try {
			
			pedidocompra=pedidocompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		pedidocompra = new  PedidoCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			pedidocompra=pedidocompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompra);
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
		pedidocompra = new  PedidoCompra();
		  		  
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
		pedidocompra = new  PedidoCompra();
		  		  
        try {
			
			pedidocompra=pedidocompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		pedidocompra = new  PedidoCompra();
		  		  
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
		pedidocompra = new  PedidoCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =pedidocompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pedidocompra = new  PedidoCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=pedidocompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		pedidocompra = new  PedidoCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =pedidocompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pedidocompra = new  PedidoCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=pedidocompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		pedidocompra = new  PedidoCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =pedidocompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pedidocompra = new  PedidoCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=pedidocompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		pedidocompras = new  ArrayList<PedidoCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompras=pedidocompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoCompra(pedidocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
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
		pedidocompras = new  ArrayList<PedidoCompra>();
		  		  
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
		pedidocompras = new  ArrayList<PedidoCompra>();
		  		  
        try {			
			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompras=pedidocompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPedidoCompra(pedidocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		pedidocompras = new  ArrayList<PedidoCompra>();
		  		  
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
		pedidocompras = new  ArrayList<PedidoCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompras=pedidocompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoCompra(pedidocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
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
		pedidocompras = new  ArrayList<PedidoCompra>();
		  		  
        try {
			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompras=pedidocompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoCompra(pedidocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
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
		pedidocompras = new  ArrayList<PedidoCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompras=pedidocompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoCompra(pedidocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
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
		pedidocompras = new  ArrayList<PedidoCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompras=pedidocompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoCompra(pedidocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		pedidocompra = new  PedidoCompra();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompra=pedidocompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoCompra(pedidocompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompra);
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
		pedidocompra = new  PedidoCompra();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompra=pedidocompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoCompra(pedidocompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		pedidocompras = new  ArrayList<PedidoCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompras=pedidocompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoCompra(pedidocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
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
		pedidocompras = new  ArrayList<PedidoCompra>();
		  		  
        try {
			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompras=pedidocompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoCompra(pedidocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPedidoComprasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		pedidocompras = new  ArrayList<PedidoCompra>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getTodosPedidoComprasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPedidoCompra(pedidocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
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
	
	public  void  getTodosPedidoCompras(String sFinalQuery,Pagination pagination)throws Exception {
		pedidocompras = new  ArrayList<PedidoCompra>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPedidoCompra(pedidocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPedidoCompra(PedidoCompra pedidocompra) throws Exception {
		Boolean estaValidado=false;
		
		if(pedidocompra.getIsNew() || pedidocompra.getIsChanged()) { 
			this.invalidValues = pedidocompraValidator.getInvalidValues(pedidocompra);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(pedidocompra);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPedidoCompra(List<PedidoCompra> PedidoCompras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PedidoCompra pedidocompraLocal:pedidocompras) {				
			estaValidadoObjeto=this.validarGuardarPedidoCompra(pedidocompraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPedidoCompra(List<PedidoCompra> PedidoCompras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPedidoCompra(pedidocompras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPedidoCompra(PedidoCompra PedidoCompra) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPedidoCompra(pedidocompra)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PedidoCompra pedidocompra) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+pedidocompra.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PedidoCompraConstantesFunciones.getPedidoCompraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"pedidocompra","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PedidoCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PedidoCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePedidoCompraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-savePedidoCompraWithConnection");connexion.begin();			
			
			PedidoCompraLogicAdditional.checkPedidoCompraToSave(this.pedidocompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PedidoCompraLogicAdditional.updatePedidoCompraToSave(this.pedidocompra,this.arrDatoGeneral);
			
			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.pedidocompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPedidoCompra();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPedidoCompra(this.pedidocompra)) {
				PedidoCompraDataAccess.save(this.pedidocompra, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.pedidocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PedidoCompraLogicAdditional.checkPedidoCompraToSaveAfter(this.pedidocompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPedidoCompra();
			
			connexion.commit();			
			
			if(this.pedidocompra.getIsDeleted()) {
				this.pedidocompra=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePedidoCompra()throws Exception {	
		try {	
			
			PedidoCompraLogicAdditional.checkPedidoCompraToSave(this.pedidocompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PedidoCompraLogicAdditional.updatePedidoCompraToSave(this.pedidocompra,this.arrDatoGeneral);
			
			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.pedidocompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPedidoCompra(this.pedidocompra)) {			
				PedidoCompraDataAccess.save(this.pedidocompra, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.pedidocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PedidoCompraLogicAdditional.checkPedidoCompraToSaveAfter(this.pedidocompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.pedidocompra.getIsDeleted()) {
				this.pedidocompra=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePedidoComprasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-savePedidoComprasWithConnection");connexion.begin();			
			
			PedidoCompraLogicAdditional.checkPedidoCompraToSaves(pedidocompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPedidoCompras();
			
			Boolean validadoTodosPedidoCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PedidoCompra pedidocompraLocal:pedidocompras) {		
				if(pedidocompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PedidoCompraLogicAdditional.updatePedidoCompraToSave(pedidocompraLocal,this.arrDatoGeneral);
	        	
				PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),pedidocompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPedidoCompra(pedidocompraLocal)) {
					PedidoCompraDataAccess.save(pedidocompraLocal, connexion);				
				} else {
					validadoTodosPedidoCompra=false;
				}
			}
			
			if(!validadoTodosPedidoCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PedidoCompraLogicAdditional.checkPedidoCompraToSavesAfter(pedidocompras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPedidoCompras();
			
			connexion.commit();		
			
			this.quitarPedidoComprasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePedidoCompras()throws Exception {				
		 try {	
			PedidoCompraLogicAdditional.checkPedidoCompraToSaves(pedidocompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPedidoCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PedidoCompra pedidocompraLocal:pedidocompras) {				
				if(pedidocompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PedidoCompraLogicAdditional.updatePedidoCompraToSave(pedidocompraLocal,this.arrDatoGeneral);
	        	
				PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),pedidocompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPedidoCompra(pedidocompraLocal)) {				
					PedidoCompraDataAccess.save(pedidocompraLocal, connexion);				
				} else {
					validadoTodosPedidoCompra=false;
				}
			}
			
			if(!validadoTodosPedidoCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PedidoCompraLogicAdditional.checkPedidoCompraToSavesAfter(pedidocompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPedidoComprasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PedidoCompraParameterReturnGeneral procesarAccionPedidoCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PedidoCompra> pedidocompras,PedidoCompraParameterReturnGeneral pedidocompraParameterGeneral)throws Exception {
		 try {	
			PedidoCompraParameterReturnGeneral pedidocompraReturnGeneral=new PedidoCompraParameterReturnGeneral();
	
			PedidoCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pedidocompras,pedidocompraParameterGeneral,pedidocompraReturnGeneral);
			
			return pedidocompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PedidoCompraParameterReturnGeneral procesarAccionPedidoComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PedidoCompra> pedidocompras,PedidoCompraParameterReturnGeneral pedidocompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-procesarAccionPedidoComprasWithConnection");connexion.begin();			
			
			PedidoCompraParameterReturnGeneral pedidocompraReturnGeneral=new PedidoCompraParameterReturnGeneral();
	
			PedidoCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pedidocompras,pedidocompraParameterGeneral,pedidocompraReturnGeneral);
			
			this.connexion.commit();
			
			return pedidocompraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PedidoCompraParameterReturnGeneral procesarEventosPedidoCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PedidoCompra> pedidocompras,PedidoCompra pedidocompra,PedidoCompraParameterReturnGeneral pedidocompraParameterGeneral,Boolean isEsNuevoPedidoCompra,ArrayList<Classe> clases)throws Exception {
		 try {	
			PedidoCompraParameterReturnGeneral pedidocompraReturnGeneral=new PedidoCompraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				pedidocompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PedidoCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,pedidocompras,pedidocompra,pedidocompraParameterGeneral,pedidocompraReturnGeneral,isEsNuevoPedidoCompra,clases);
			
			return pedidocompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PedidoCompraParameterReturnGeneral procesarEventosPedidoComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PedidoCompra> pedidocompras,PedidoCompra pedidocompra,PedidoCompraParameterReturnGeneral pedidocompraParameterGeneral,Boolean isEsNuevoPedidoCompra,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-procesarEventosPedidoComprasWithConnection");connexion.begin();			
			
			PedidoCompraParameterReturnGeneral pedidocompraReturnGeneral=new PedidoCompraParameterReturnGeneral();
	
			pedidocompraReturnGeneral.setPedidoCompra(pedidocompra);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				pedidocompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PedidoCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,pedidocompras,pedidocompra,pedidocompraParameterGeneral,pedidocompraReturnGeneral,isEsNuevoPedidoCompra,clases);
			
			this.connexion.commit();
			
			return pedidocompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PedidoCompraParameterReturnGeneral procesarImportacionPedidoComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PedidoCompraParameterReturnGeneral pedidocompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-procesarImportacionPedidoComprasWithConnection");connexion.begin();			
			
			PedidoCompraParameterReturnGeneral pedidocompraReturnGeneral=new PedidoCompraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.pedidocompras=new ArrayList<PedidoCompra>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.pedidocompra=new PedidoCompra();
				
				
				if(conColumnasBase) {this.pedidocompra.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.pedidocompra.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.pedidocompra.setnumero_secuencial(arrColumnas[iColumn++]);
				this.pedidocompra.setresponsable(arrColumnas[iColumn++]);
				this.pedidocompra.setsolicitado_por(arrColumnas[iColumn++]);
				this.pedidocompra.setmotivo_solicitud(arrColumnas[iColumn++]);
				this.pedidocompra.setarea_solicitud(arrColumnas[iColumn++]);
				this.pedidocompra.setpara_uso_de(arrColumnas[iColumn++]);
				this.pedidocompra.setlugar_entrega(arrColumnas[iColumn++]);
			this.pedidocompra.setdescripcion(arrColumnas[iColumn++]);
				this.pedidocompra.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.pedidocompra.setfecha_entrega(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				
				this.pedidocompras.add(this.pedidocompra);
			}
			
			this.savePedidoCompras();
			
			this.connexion.commit();
			
			pedidocompraReturnGeneral.setConRetornoEstaProcesado(true);
			pedidocompraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return pedidocompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPedidoComprasEliminados() throws Exception {				
		
		List<PedidoCompra> pedidocomprasAux= new ArrayList<PedidoCompra>();
		
		for(PedidoCompra pedidocompra:pedidocompras) {
			if(!pedidocompra.getIsDeleted()) {
				pedidocomprasAux.add(pedidocompra);
			}
		}
		
		pedidocompras=pedidocomprasAux;
	}
	
	public void quitarPedidoComprasNulos() throws Exception {				
		
		List<PedidoCompra> pedidocomprasAux= new ArrayList<PedidoCompra>();
		
		for(PedidoCompra pedidocompra : this.pedidocompras) {
			if(pedidocompra==null) {
				pedidocomprasAux.add(pedidocompra);
			}
		}
		
		//this.pedidocompras=pedidocomprasAux;
		
		this.pedidocompras.removeAll(pedidocomprasAux);
	}
	
	public void getSetVersionRowPedidoCompraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(pedidocompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((pedidocompra.getIsDeleted() || (pedidocompra.getIsChanged()&&!pedidocompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=pedidocompraDataAccess.getSetVersionRowPedidoCompra(connexion,pedidocompra.getId());
				
				if(!pedidocompra.getVersionRow().equals(timestamp)) {	
					pedidocompra.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				pedidocompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPedidoCompra()throws Exception {	
		
		if(pedidocompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((pedidocompra.getIsDeleted() || (pedidocompra.getIsChanged()&&!pedidocompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=pedidocompraDataAccess.getSetVersionRowPedidoCompra(connexion,pedidocompra.getId());
			
			try {							
				if(!pedidocompra.getVersionRow().equals(timestamp)) {	
					pedidocompra.setVersionRow(timestamp);
				}
				
				pedidocompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPedidoComprasWithConnection()throws Exception {	
		if(pedidocompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PedidoCompra pedidocompraAux:pedidocompras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(pedidocompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(pedidocompraAux.getIsDeleted() || (pedidocompraAux.getIsChanged()&&!pedidocompraAux.getIsNew())) {
						
						timestamp=pedidocompraDataAccess.getSetVersionRowPedidoCompra(connexion,pedidocompraAux.getId());
						
						if(!pedidocompra.getVersionRow().equals(timestamp)) {	
							pedidocompraAux.setVersionRow(timestamp);
						}
								
						pedidocompraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPedidoCompras()throws Exception {	
		if(pedidocompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PedidoCompra pedidocompraAux:pedidocompras) {
					if(pedidocompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(pedidocompraAux.getIsDeleted() || (pedidocompraAux.getIsChanged()&&!pedidocompraAux.getIsNew())) {
						
						timestamp=pedidocompraDataAccess.getSetVersionRowPedidoCompra(connexion,pedidocompraAux.getId());
						
						if(!pedidocompraAux.getVersionRow().equals(timestamp)) {	
							pedidocompraAux.setVersionRow(timestamp);
						}
						
													
						pedidocompraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PedidoCompraParameterReturnGeneral cargarCombosLoteForeignKeyPedidoCompraWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalCliente,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalEstadoPedidoCompra,String finalQueryGlobalEmpleado,String finalQueryGlobalFormato,String finalQueryGlobalTipoCambio) throws Exception {
		PedidoCompraParameterReturnGeneral  pedidocompraReturnGeneral =new PedidoCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-cargarCombosLoteForeignKeyPedidoCompraWithConnection");connexion.begin();
			
			pedidocompraReturnGeneral =new PedidoCompraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			pedidocompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			pedidocompraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			pedidocompraReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			pedidocompraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			pedidocompraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			pedidocompraReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			pedidocompraReturnGeneral.setmessForeignKey(messForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			pedidocompraReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			pedidocompraReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			pedidocompraReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<EstadoPedidoCompra> estadopedidocomprasForeignKey=new ArrayList<EstadoPedidoCompra>();
			EstadoPedidoCompraLogic estadopedidocompraLogic=new EstadoPedidoCompraLogic();
			estadopedidocompraLogic.setConnexion(this.connexion);
			estadopedidocompraLogic.getEstadoPedidoCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedidoCompra.equals("NONE")) {
				estadopedidocompraLogic.getTodosEstadoPedidoCompras(finalQueryGlobalEstadoPedidoCompra,new Pagination());
				estadopedidocomprasForeignKey=estadopedidocompraLogic.getEstadoPedidoCompras();
			}

			pedidocompraReturnGeneral.setestadopedidocomprasForeignKey(estadopedidocomprasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			pedidocompraReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			pedidocompraReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			pedidocompraReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return pedidocompraReturnGeneral;
	}
	
	public PedidoCompraParameterReturnGeneral cargarCombosLoteForeignKeyPedidoCompra(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalCliente,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalEstadoPedidoCompra,String finalQueryGlobalEmpleado,String finalQueryGlobalFormato,String finalQueryGlobalTipoCambio) throws Exception {
		PedidoCompraParameterReturnGeneral  pedidocompraReturnGeneral =new PedidoCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			pedidocompraReturnGeneral =new PedidoCompraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			pedidocompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			pedidocompraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			pedidocompraReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			pedidocompraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			pedidocompraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			pedidocompraReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			pedidocompraReturnGeneral.setmessForeignKey(messForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			pedidocompraReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			pedidocompraReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			pedidocompraReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<EstadoPedidoCompra> estadopedidocomprasForeignKey=new ArrayList<EstadoPedidoCompra>();
			EstadoPedidoCompraLogic estadopedidocompraLogic=new EstadoPedidoCompraLogic();
			estadopedidocompraLogic.setConnexion(this.connexion);
			estadopedidocompraLogic.getEstadoPedidoCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedidoCompra.equals("NONE")) {
				estadopedidocompraLogic.getTodosEstadoPedidoCompras(finalQueryGlobalEstadoPedidoCompra,new Pagination());
				estadopedidocomprasForeignKey=estadopedidocompraLogic.getEstadoPedidoCompras();
			}

			pedidocompraReturnGeneral.setestadopedidocomprasForeignKey(estadopedidocomprasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			pedidocompraReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			pedidocompraReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			pedidocompraReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return pedidocompraReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyPedidoCompraWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetallePedidoCompraLogic detallepedidocompraLogic=new DetallePedidoCompraLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyPedidoCompraWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetallePedidoCompra.class));
											
			

			detallepedidocompraLogic.setConnexion(this.getConnexion());
			detallepedidocompraLogic.setDatosCliente(this.datosCliente);
			detallepedidocompraLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(PedidoCompra pedidocompra:this.pedidocompras) {
				

				classes=new ArrayList<Classe>();
				classes=DetallePedidoCompraConstantesFunciones.getClassesForeignKeysOfDetallePedidoCompra(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallepedidocompraLogic.setDetallePedidoCompras(pedidocompra.detallepedidocompras);
				detallepedidocompraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(PedidoCompra pedidocompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PedidoCompraLogicAdditional.updatePedidoCompraToGet(pedidocompra,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pedidocompra.setEmpresa(pedidocompraDataAccess.getEmpresa(connexion,pedidocompra));
		pedidocompra.setSucursal(pedidocompraDataAccess.getSucursal(connexion,pedidocompra));
		pedidocompra.setModulo(pedidocompraDataAccess.getModulo(connexion,pedidocompra));
		pedidocompra.setEjercicio(pedidocompraDataAccess.getEjercicio(connexion,pedidocompra));
		pedidocompra.setPeriodo(pedidocompraDataAccess.getPeriodo(connexion,pedidocompra));
		pedidocompra.setAnio(pedidocompraDataAccess.getAnio(connexion,pedidocompra));
		pedidocompra.setMes(pedidocompraDataAccess.getMes(connexion,pedidocompra));
		pedidocompra.setCliente(pedidocompraDataAccess.getCliente(connexion,pedidocompra));
		pedidocompra.setUsuario(pedidocompraDataAccess.getUsuario(connexion,pedidocompra));
		pedidocompra.setMoneda(pedidocompraDataAccess.getMoneda(connexion,pedidocompra));
		pedidocompra.setEstadoPedidoCompra(pedidocompraDataAccess.getEstadoPedidoCompra(connexion,pedidocompra));
		pedidocompra.setEmpleado(pedidocompraDataAccess.getEmpleado(connexion,pedidocompra));
		pedidocompra.setFormato(pedidocompraDataAccess.getFormato(connexion,pedidocompra));
		pedidocompra.setTipoCambio(pedidocompraDataAccess.getTipoCambio(connexion,pedidocompra));
		pedidocompra.setDetallePedidoCompras(pedidocompraDataAccess.getDetallePedidoCompras(connexion,pedidocompra));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pedidocompra.setEmpresa(pedidocompraDataAccess.getEmpresa(connexion,pedidocompra));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				pedidocompra.setSucursal(pedidocompraDataAccess.getSucursal(connexion,pedidocompra));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				pedidocompra.setModulo(pedidocompraDataAccess.getModulo(connexion,pedidocompra));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				pedidocompra.setEjercicio(pedidocompraDataAccess.getEjercicio(connexion,pedidocompra));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				pedidocompra.setPeriodo(pedidocompraDataAccess.getPeriodo(connexion,pedidocompra));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				pedidocompra.setAnio(pedidocompraDataAccess.getAnio(connexion,pedidocompra));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				pedidocompra.setMes(pedidocompraDataAccess.getMes(connexion,pedidocompra));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				pedidocompra.setCliente(pedidocompraDataAccess.getCliente(connexion,pedidocompra));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				pedidocompra.setUsuario(pedidocompraDataAccess.getUsuario(connexion,pedidocompra));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				pedidocompra.setMoneda(pedidocompraDataAccess.getMoneda(connexion,pedidocompra));
				continue;
			}

			if(clas.clas.equals(EstadoPedidoCompra.class)) {
				pedidocompra.setEstadoPedidoCompra(pedidocompraDataAccess.getEstadoPedidoCompra(connexion,pedidocompra));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				pedidocompra.setEmpleado(pedidocompraDataAccess.getEmpleado(connexion,pedidocompra));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				pedidocompra.setFormato(pedidocompraDataAccess.getFormato(connexion,pedidocompra));
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				pedidocompra.setTipoCambio(pedidocompraDataAccess.getTipoCambio(connexion,pedidocompra));
				continue;
			}

			if(clas.clas.equals(DetallePedidoCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				pedidocompra.setDetallePedidoCompras(pedidocompraDataAccess.getDetallePedidoCompras(connexion,pedidocompra));

				if(this.isConDeep) {
					DetallePedidoCompraLogic detallepedidocompraLogic= new DetallePedidoCompraLogic(this.connexion);
					detallepedidocompraLogic.setDetallePedidoCompras(pedidocompra.getDetallePedidoCompras());
					ArrayList<Classe> classesLocal=DetallePedidoCompraConstantesFunciones.getClassesForeignKeysOfDetallePedidoCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallepedidocompraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(detallepedidocompraLogic.getDetallePedidoCompras());
					pedidocompra.setDetallePedidoCompras(detallepedidocompraLogic.getDetallePedidoCompras());
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
			pedidocompra.setEmpresa(pedidocompraDataAccess.getEmpresa(connexion,pedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setSucursal(pedidocompraDataAccess.getSucursal(connexion,pedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setModulo(pedidocompraDataAccess.getModulo(connexion,pedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setEjercicio(pedidocompraDataAccess.getEjercicio(connexion,pedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setPeriodo(pedidocompraDataAccess.getPeriodo(connexion,pedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setAnio(pedidocompraDataAccess.getAnio(connexion,pedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setMes(pedidocompraDataAccess.getMes(connexion,pedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setCliente(pedidocompraDataAccess.getCliente(connexion,pedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setUsuario(pedidocompraDataAccess.getUsuario(connexion,pedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setMoneda(pedidocompraDataAccess.getMoneda(connexion,pedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedidoCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setEstadoPedidoCompra(pedidocompraDataAccess.getEstadoPedidoCompra(connexion,pedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setEmpleado(pedidocompraDataAccess.getEmpleado(connexion,pedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setFormato(pedidocompraDataAccess.getFormato(connexion,pedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setTipoCambio(pedidocompraDataAccess.getTipoCambio(connexion,pedidocompra));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetallePedidoCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetallePedidoCompra.class));
			pedidocompra.setDetallePedidoCompras(pedidocompraDataAccess.getDetallePedidoCompras(connexion,pedidocompra));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pedidocompra.setEmpresa(pedidocompraDataAccess.getEmpresa(connexion,pedidocompra));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(pedidocompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		pedidocompra.setSucursal(pedidocompraDataAccess.getSucursal(connexion,pedidocompra));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(pedidocompra.getSucursal(),isDeep,deepLoadType,clases);
				
		pedidocompra.setModulo(pedidocompraDataAccess.getModulo(connexion,pedidocompra));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(pedidocompra.getModulo(),isDeep,deepLoadType,clases);
				
		pedidocompra.setEjercicio(pedidocompraDataAccess.getEjercicio(connexion,pedidocompra));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(pedidocompra.getEjercicio(),isDeep,deepLoadType,clases);
				
		pedidocompra.setPeriodo(pedidocompraDataAccess.getPeriodo(connexion,pedidocompra));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(pedidocompra.getPeriodo(),isDeep,deepLoadType,clases);
				
		pedidocompra.setAnio(pedidocompraDataAccess.getAnio(connexion,pedidocompra));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(pedidocompra.getAnio(),isDeep,deepLoadType,clases);
				
		pedidocompra.setMes(pedidocompraDataAccess.getMes(connexion,pedidocompra));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(pedidocompra.getMes(),isDeep,deepLoadType,clases);
				
		pedidocompra.setCliente(pedidocompraDataAccess.getCliente(connexion,pedidocompra));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(pedidocompra.getCliente(),isDeep,deepLoadType,clases);
				
		pedidocompra.setUsuario(pedidocompraDataAccess.getUsuario(connexion,pedidocompra));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(pedidocompra.getUsuario(),isDeep,deepLoadType,clases);
				
		pedidocompra.setMoneda(pedidocompraDataAccess.getMoneda(connexion,pedidocompra));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(pedidocompra.getMoneda(),isDeep,deepLoadType,clases);
				
		pedidocompra.setEstadoPedidoCompra(pedidocompraDataAccess.getEstadoPedidoCompra(connexion,pedidocompra));
		EstadoPedidoCompraLogic estadopedidocompraLogic= new EstadoPedidoCompraLogic(connexion);
		estadopedidocompraLogic.deepLoad(pedidocompra.getEstadoPedidoCompra(),isDeep,deepLoadType,clases);
				
		pedidocompra.setEmpleado(pedidocompraDataAccess.getEmpleado(connexion,pedidocompra));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(pedidocompra.getEmpleado(),isDeep,deepLoadType,clases);
				
		pedidocompra.setFormato(pedidocompraDataAccess.getFormato(connexion,pedidocompra));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(pedidocompra.getFormato(),isDeep,deepLoadType,clases);
				
		pedidocompra.setTipoCambio(pedidocompraDataAccess.getTipoCambio(connexion,pedidocompra));
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(pedidocompra.getTipoCambio(),isDeep,deepLoadType,clases);
				

		pedidocompra.setDetallePedidoCompras(pedidocompraDataAccess.getDetallePedidoCompras(connexion,pedidocompra));

		for(DetallePedidoCompra detallepedidocompra:pedidocompra.getDetallePedidoCompras()) {
			DetallePedidoCompraLogic detallepedidocompraLogic= new DetallePedidoCompraLogic(connexion);
			detallepedidocompraLogic.deepLoad(detallepedidocompra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pedidocompra.setEmpresa(pedidocompraDataAccess.getEmpresa(connexion,pedidocompra));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(pedidocompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				pedidocompra.setSucursal(pedidocompraDataAccess.getSucursal(connexion,pedidocompra));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(pedidocompra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				pedidocompra.setModulo(pedidocompraDataAccess.getModulo(connexion,pedidocompra));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(pedidocompra.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				pedidocompra.setEjercicio(pedidocompraDataAccess.getEjercicio(connexion,pedidocompra));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(pedidocompra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				pedidocompra.setPeriodo(pedidocompraDataAccess.getPeriodo(connexion,pedidocompra));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(pedidocompra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				pedidocompra.setAnio(pedidocompraDataAccess.getAnio(connexion,pedidocompra));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(pedidocompra.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				pedidocompra.setMes(pedidocompraDataAccess.getMes(connexion,pedidocompra));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(pedidocompra.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				pedidocompra.setCliente(pedidocompraDataAccess.getCliente(connexion,pedidocompra));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(pedidocompra.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				pedidocompra.setUsuario(pedidocompraDataAccess.getUsuario(connexion,pedidocompra));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(pedidocompra.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				pedidocompra.setMoneda(pedidocompraDataAccess.getMoneda(connexion,pedidocompra));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(pedidocompra.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedidoCompra.class)) {
				pedidocompra.setEstadoPedidoCompra(pedidocompraDataAccess.getEstadoPedidoCompra(connexion,pedidocompra));
				EstadoPedidoCompraLogic estadopedidocompraLogic= new EstadoPedidoCompraLogic(connexion);
				estadopedidocompraLogic.deepLoad(pedidocompra.getEstadoPedidoCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				pedidocompra.setEmpleado(pedidocompraDataAccess.getEmpleado(connexion,pedidocompra));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(pedidocompra.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				pedidocompra.setFormato(pedidocompraDataAccess.getFormato(connexion,pedidocompra));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(pedidocompra.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				pedidocompra.setTipoCambio(pedidocompraDataAccess.getTipoCambio(connexion,pedidocompra));
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepLoad(pedidocompra.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetallePedidoCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				pedidocompra.setDetallePedidoCompras(pedidocompraDataAccess.getDetallePedidoCompras(connexion,pedidocompra));

				for(DetallePedidoCompra detallepedidocompra:pedidocompra.getDetallePedidoCompras()) {
					DetallePedidoCompraLogic detallepedidocompraLogic= new DetallePedidoCompraLogic(connexion);
					detallepedidocompraLogic.deepLoad(detallepedidocompra,isDeep,deepLoadType,clases);
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
			pedidocompra.setEmpresa(pedidocompraDataAccess.getEmpresa(connexion,pedidocompra));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(pedidocompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setSucursal(pedidocompraDataAccess.getSucursal(connexion,pedidocompra));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(pedidocompra.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setModulo(pedidocompraDataAccess.getModulo(connexion,pedidocompra));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(pedidocompra.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setEjercicio(pedidocompraDataAccess.getEjercicio(connexion,pedidocompra));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(pedidocompra.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setPeriodo(pedidocompraDataAccess.getPeriodo(connexion,pedidocompra));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(pedidocompra.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setAnio(pedidocompraDataAccess.getAnio(connexion,pedidocompra));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(pedidocompra.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setMes(pedidocompraDataAccess.getMes(connexion,pedidocompra));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(pedidocompra.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setCliente(pedidocompraDataAccess.getCliente(connexion,pedidocompra));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(pedidocompra.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setUsuario(pedidocompraDataAccess.getUsuario(connexion,pedidocompra));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(pedidocompra.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setMoneda(pedidocompraDataAccess.getMoneda(connexion,pedidocompra));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(pedidocompra.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedidoCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setEstadoPedidoCompra(pedidocompraDataAccess.getEstadoPedidoCompra(connexion,pedidocompra));
			EstadoPedidoCompraLogic estadopedidocompraLogic= new EstadoPedidoCompraLogic(connexion);
			estadopedidocompraLogic.deepLoad(pedidocompra.getEstadoPedidoCompra(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setEmpleado(pedidocompraDataAccess.getEmpleado(connexion,pedidocompra));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(pedidocompra.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setFormato(pedidocompraDataAccess.getFormato(connexion,pedidocompra));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(pedidocompra.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompra.setTipoCambio(pedidocompraDataAccess.getTipoCambio(connexion,pedidocompra));
			TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
			tipocambioLogic.deepLoad(pedidocompra.getTipoCambio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetallePedidoCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetallePedidoCompra.class));
			pedidocompra.setDetallePedidoCompras(pedidocompraDataAccess.getDetallePedidoCompras(connexion,pedidocompra));

			for(DetallePedidoCompra detallepedidocompra:pedidocompra.getDetallePedidoCompras()) {
				DetallePedidoCompraLogic detallepedidocompraLogic= new DetallePedidoCompraLogic(connexion);
				detallepedidocompraLogic.deepLoad(detallepedidocompra,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PedidoCompra pedidocompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PedidoCompraLogicAdditional.updatePedidoCompraToSave(pedidocompra,this.arrDatoGeneral);
			
PedidoCompraDataAccess.save(pedidocompra, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(pedidocompra.getEmpresa(),connexion);

		SucursalDataAccess.save(pedidocompra.getSucursal(),connexion);

		ModuloDataAccess.save(pedidocompra.getModulo(),connexion);

		EjercicioDataAccess.save(pedidocompra.getEjercicio(),connexion);

		PeriodoDataAccess.save(pedidocompra.getPeriodo(),connexion);

		AnioDataAccess.save(pedidocompra.getAnio(),connexion);

		MesDataAccess.save(pedidocompra.getMes(),connexion);

		ClienteDataAccess.save(pedidocompra.getCliente(),connexion);

		UsuarioDataAccess.save(pedidocompra.getUsuario(),connexion);

		MonedaDataAccess.save(pedidocompra.getMoneda(),connexion);

		EstadoPedidoCompraDataAccess.save(pedidocompra.getEstadoPedidoCompra(),connexion);

		EmpleadoDataAccess.save(pedidocompra.getEmpleado(),connexion);

		FormatoDataAccess.save(pedidocompra.getFormato(),connexion);

		TipoCambioDataAccess.save(pedidocompra.getTipoCambio(),connexion);

		for(DetallePedidoCompra detallepedidocompra:pedidocompra.getDetallePedidoCompras()) {
			detallepedidocompra.setid_pedido_compra(pedidocompra.getId());
			DetallePedidoCompraDataAccess.save(detallepedidocompra,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(pedidocompra.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(pedidocompra.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(pedidocompra.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(pedidocompra.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(pedidocompra.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(pedidocompra.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(pedidocompra.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(pedidocompra.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(pedidocompra.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(pedidocompra.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoPedidoCompra.class)) {
				EstadoPedidoCompraDataAccess.save(pedidocompra.getEstadoPedidoCompra(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(pedidocompra.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(pedidocompra.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(pedidocompra.getTipoCambio(),connexion);
				continue;
			}


			if(clas.clas.equals(DetallePedidoCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetallePedidoCompra detallepedidocompra:pedidocompra.getDetallePedidoCompras()) {
					detallepedidocompra.setid_pedido_compra(pedidocompra.getId());
					DetallePedidoCompraDataAccess.save(detallepedidocompra,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(pedidocompra.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(pedidocompra.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(pedidocompra.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(pedidocompra.getSucursal(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(pedidocompra.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(pedidocompra.getModulo(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(pedidocompra.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(pedidocompra.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(pedidocompra.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(pedidocompra.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(pedidocompra.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(pedidocompra.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(pedidocompra.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(pedidocompra.getMes(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(pedidocompra.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(pedidocompra.getCliente(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(pedidocompra.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(pedidocompra.getUsuario(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(pedidocompra.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(pedidocompra.getMoneda(),isDeep,deepLoadType,clases);
				

		EstadoPedidoCompraDataAccess.save(pedidocompra.getEstadoPedidoCompra(),connexion);
		EstadoPedidoCompraLogic estadopedidocompraLogic= new EstadoPedidoCompraLogic(connexion);
		estadopedidocompraLogic.deepLoad(pedidocompra.getEstadoPedidoCompra(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(pedidocompra.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(pedidocompra.getEmpleado(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(pedidocompra.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(pedidocompra.getFormato(),isDeep,deepLoadType,clases);
				

		TipoCambioDataAccess.save(pedidocompra.getTipoCambio(),connexion);
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(pedidocompra.getTipoCambio(),isDeep,deepLoadType,clases);
				

		for(DetallePedidoCompra detallepedidocompra:pedidocompra.getDetallePedidoCompras()) {
			DetallePedidoCompraLogic detallepedidocompraLogic= new DetallePedidoCompraLogic(connexion);
			detallepedidocompra.setid_pedido_compra(pedidocompra.getId());
			DetallePedidoCompraDataAccess.save(detallepedidocompra,connexion);
			detallepedidocompraLogic.deepSave(detallepedidocompra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(pedidocompra.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(pedidocompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(pedidocompra.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(pedidocompra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(pedidocompra.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(pedidocompra.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(pedidocompra.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(pedidocompra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(pedidocompra.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(pedidocompra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(pedidocompra.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(pedidocompra.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(pedidocompra.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(pedidocompra.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(pedidocompra.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(pedidocompra.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(pedidocompra.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(pedidocompra.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(pedidocompra.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(pedidocompra.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedidoCompra.class)) {
				EstadoPedidoCompraDataAccess.save(pedidocompra.getEstadoPedidoCompra(),connexion);
				EstadoPedidoCompraLogic estadopedidocompraLogic= new EstadoPedidoCompraLogic(connexion);
				estadopedidocompraLogic.deepSave(pedidocompra.getEstadoPedidoCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(pedidocompra.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(pedidocompra.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(pedidocompra.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(pedidocompra.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(pedidocompra.getTipoCambio(),connexion);
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepSave(pedidocompra.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetallePedidoCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetallePedidoCompra detallepedidocompra:pedidocompra.getDetallePedidoCompras()) {
					DetallePedidoCompraLogic detallepedidocompraLogic= new DetallePedidoCompraLogic(connexion);
					detallepedidocompra.setid_pedido_compra(pedidocompra.getId());
					DetallePedidoCompraDataAccess.save(detallepedidocompra,connexion);
					detallepedidocompraLogic.deepSave(detallepedidocompra,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(PedidoCompra.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(pedidocompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(pedidocompra);
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
			this.deepLoad(this.pedidocompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PedidoCompra.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(pedidocompras!=null) {
				for(PedidoCompra pedidocompra:pedidocompras) {
					this.deepLoad(pedidocompra,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(pedidocompras);
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
			if(pedidocompras!=null) {
				for(PedidoCompra pedidocompra:pedidocompras) {
					this.deepLoad(pedidocompra,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(pedidocompras);
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
			this.getNewConnexionToDeep(PedidoCompra.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(pedidocompra,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PedidoCompra.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(pedidocompras!=null) {
				for(PedidoCompra pedidocompra:pedidocompras) {
					this.deepSave(pedidocompra,isDeep,deepLoadType,clases);
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
			if(pedidocompras!=null) {
				for(PedidoCompra pedidocompra:pedidocompras) {
					this.deepSave(pedidocompra,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPedidoComprasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PedidoCompraConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoComprasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PedidoCompraConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoComprasFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,PedidoCompraConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoComprasFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,PedidoCompraConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoComprasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PedidoCompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoComprasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PedidoCompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoComprasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,PedidoCompraConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoComprasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,PedidoCompraConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoComprasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PedidoCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoComprasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PedidoCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoComprasFK_IdEstadoPedidoCompraEstadoPedoCompraWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_pedido_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedidoCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedidoCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido_compra,PedidoCompraConstantesFunciones.IDESTADOPEDIDOCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedidoCompra);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedidoCompraEstadoPedoCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoComprasFK_IdEstadoPedidoCompraEstadoPedoCompra(String sFinalQuery,Pagination pagination,Long id_estado_pedido_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedidoCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedidoCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido_compra,PedidoCompraConstantesFunciones.IDESTADOPEDIDOCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedidoCompra);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedidoCompraEstadoPedoCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoComprasFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,PedidoCompraConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoComprasFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,PedidoCompraConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoComprasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PedidoCompraConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoComprasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PedidoCompraConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoComprasFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,PedidoCompraConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoComprasFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,PedidoCompraConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoComprasFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,PedidoCompraConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoComprasFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,PedidoCompraConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoComprasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PedidoCompraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoComprasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PedidoCompraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoComprasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PedidoCompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoComprasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PedidoCompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoComprasFK_IdTipoCambioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,PedidoCompraConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoComprasFK_IdTipoCambio(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,PedidoCompraConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoComprasFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,PedidoCompraConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoComprasFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,PedidoCompraConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			PedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(this.pedidocompras);
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
			if(PedidoCompraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoCompraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PedidoCompra pedidocompra,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PedidoCompraConstantesFunciones.ISCONAUDITORIA) {
				if(pedidocompra.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoCompraDataAccess.TABLENAME, pedidocompra.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PedidoCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PedidoCompraLogic.registrarAuditoriaDetallesPedidoCompra(connexion,pedidocompra,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(pedidocompra.getIsDeleted()) {
					/*if(!pedidocompra.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PedidoCompraDataAccess.TABLENAME, pedidocompra.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PedidoCompraLogic.registrarAuditoriaDetallesPedidoCompra(connexion,pedidocompra,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoCompraDataAccess.TABLENAME, pedidocompra.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(pedidocompra.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoCompraDataAccess.TABLENAME, pedidocompra.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PedidoCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PedidoCompraLogic.registrarAuditoriaDetallesPedidoCompra(connexion,pedidocompra,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPedidoCompra(Connexion connexion,PedidoCompra pedidocompra)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(pedidocompra.getIsNew()||!pedidocompra.getid_empresa().equals(pedidocompra.getPedidoCompraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getid_empresa()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getid_empresa().toString();
				}
				if(pedidocompra.getid_empresa()!=null)
				{
					strValorNuevo=pedidocompra.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getid_sucursal().equals(pedidocompra.getPedidoCompraOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getid_sucursal()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getid_sucursal().toString();
				}
				if(pedidocompra.getid_sucursal()!=null)
				{
					strValorNuevo=pedidocompra.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getid_modulo().equals(pedidocompra.getPedidoCompraOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getid_modulo()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getid_modulo().toString();
				}
				if(pedidocompra.getid_modulo()!=null)
				{
					strValorNuevo=pedidocompra.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getid_ejercicio().equals(pedidocompra.getPedidoCompraOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getid_ejercicio()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getid_ejercicio().toString();
				}
				if(pedidocompra.getid_ejercicio()!=null)
				{
					strValorNuevo=pedidocompra.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getid_periodo().equals(pedidocompra.getPedidoCompraOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getid_periodo()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getid_periodo().toString();
				}
				if(pedidocompra.getid_periodo()!=null)
				{
					strValorNuevo=pedidocompra.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getid_anio().equals(pedidocompra.getPedidoCompraOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getid_anio()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getid_anio().toString();
				}
				if(pedidocompra.getid_anio()!=null)
				{
					strValorNuevo=pedidocompra.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getid_mes().equals(pedidocompra.getPedidoCompraOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getid_mes()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getid_mes().toString();
				}
				if(pedidocompra.getid_mes()!=null)
				{
					strValorNuevo=pedidocompra.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getnumero_secuencial().equals(pedidocompra.getPedidoCompraOriginal().getnumero_secuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getnumero_secuencial()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getnumero_secuencial();
				}
				if(pedidocompra.getnumero_secuencial()!=null)
				{
					strValorNuevo=pedidocompra.getnumero_secuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.NUMEROSECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getid_cliente().equals(pedidocompra.getPedidoCompraOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getid_cliente()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getid_cliente().toString();
				}
				if(pedidocompra.getid_cliente()!=null)
				{
					strValorNuevo=pedidocompra.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getid_usuario().equals(pedidocompra.getPedidoCompraOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getid_usuario()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getid_usuario().toString();
				}
				if(pedidocompra.getid_usuario()!=null)
				{
					strValorNuevo=pedidocompra.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getid_moneda().equals(pedidocompra.getPedidoCompraOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getid_moneda()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getid_moneda().toString();
				}
				if(pedidocompra.getid_moneda()!=null)
				{
					strValorNuevo=pedidocompra.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getid_estado_pedido_compra().equals(pedidocompra.getPedidoCompraOriginal().getid_estado_pedido_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getid_estado_pedido_compra()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getid_estado_pedido_compra().toString();
				}
				if(pedidocompra.getid_estado_pedido_compra()!=null)
				{
					strValorNuevo=pedidocompra.getid_estado_pedido_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.IDESTADOPEDIDOCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.gettotal().equals(pedidocompra.getPedidoCompraOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().gettotal()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().gettotal().toString();
				}
				if(pedidocompra.gettotal()!=null)
				{
					strValorNuevo=pedidocompra.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getfecha().equals(pedidocompra.getPedidoCompraOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getfecha()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getfecha().toString();
				}
				if(pedidocompra.getfecha()!=null)
				{
					strValorNuevo=pedidocompra.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getid_empleado().equals(pedidocompra.getPedidoCompraOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getid_empleado()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getid_empleado().toString();
				}
				if(pedidocompra.getid_empleado()!=null)
				{
					strValorNuevo=pedidocompra.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getresponsable().equals(pedidocompra.getPedidoCompraOriginal().getresponsable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getresponsable()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getresponsable();
				}
				if(pedidocompra.getresponsable()!=null)
				{
					strValorNuevo=pedidocompra.getresponsable() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.RESPONSABLE,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getsolicitado_por().equals(pedidocompra.getPedidoCompraOriginal().getsolicitado_por()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getsolicitado_por()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getsolicitado_por();
				}
				if(pedidocompra.getsolicitado_por()!=null)
				{
					strValorNuevo=pedidocompra.getsolicitado_por() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.SOLICITADOPOR,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getmotivo_solicitud().equals(pedidocompra.getPedidoCompraOriginal().getmotivo_solicitud()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getmotivo_solicitud()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getmotivo_solicitud();
				}
				if(pedidocompra.getmotivo_solicitud()!=null)
				{
					strValorNuevo=pedidocompra.getmotivo_solicitud() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.MOTIVOSOLICITUD,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getarea_solicitud().equals(pedidocompra.getPedidoCompraOriginal().getarea_solicitud()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getarea_solicitud()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getarea_solicitud();
				}
				if(pedidocompra.getarea_solicitud()!=null)
				{
					strValorNuevo=pedidocompra.getarea_solicitud() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.AREASOLICITUD,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getpara_uso_de().equals(pedidocompra.getPedidoCompraOriginal().getpara_uso_de()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getpara_uso_de()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getpara_uso_de();
				}
				if(pedidocompra.getpara_uso_de()!=null)
				{
					strValorNuevo=pedidocompra.getpara_uso_de() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.PARAUSODE,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getlugar_entrega().equals(pedidocompra.getPedidoCompraOriginal().getlugar_entrega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getlugar_entrega()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getlugar_entrega();
				}
				if(pedidocompra.getlugar_entrega()!=null)
				{
					strValorNuevo=pedidocompra.getlugar_entrega() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.LUGARENTREGA,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getdescripcion().equals(pedidocompra.getPedidoCompraOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getdescripcion()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getdescripcion();
				}
				if(pedidocompra.getdescripcion()!=null)
				{
					strValorNuevo=pedidocompra.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getfecha_emision().equals(pedidocompra.getPedidoCompraOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getfecha_emision()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getfecha_emision().toString();
				}
				if(pedidocompra.getfecha_emision()!=null)
				{
					strValorNuevo=pedidocompra.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getfecha_entrega().equals(pedidocompra.getPedidoCompraOriginal().getfecha_entrega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getfecha_entrega()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getfecha_entrega().toString();
				}
				if(pedidocompra.getfecha_entrega()!=null)
				{
					strValorNuevo=pedidocompra.getfecha_entrega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.FECHAENTREGA,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getid_formato().equals(pedidocompra.getPedidoCompraOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getid_formato()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getid_formato().toString();
				}
				if(pedidocompra.getid_formato()!=null)
				{
					strValorNuevo=pedidocompra.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompra.getIsNew()||!pedidocompra.getid_tipo_cambio().equals(pedidocompra.getPedidoCompraOriginal().getid_tipo_cambio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompra.getPedidoCompraOriginal().getid_tipo_cambio()!=null)
				{
					strValorActual=pedidocompra.getPedidoCompraOriginal().getid_tipo_cambio().toString();
				}
				if(pedidocompra.getid_tipo_cambio()!=null)
				{
					strValorNuevo=pedidocompra.getid_tipo_cambio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraConstantesFunciones.IDTIPOCAMBIO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePedidoCompraRelacionesWithConnection(PedidoCompra pedidocompra,List<DetallePedidoCompra> detallepedidocompras) throws Exception {

		if(!pedidocompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePedidoCompraRelacionesBase(pedidocompra,detallepedidocompras,true);
		}
	}

	public void savePedidoCompraRelaciones(PedidoCompra pedidocompra,List<DetallePedidoCompra> detallepedidocompras)throws Exception {

		if(!pedidocompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePedidoCompraRelacionesBase(pedidocompra,detallepedidocompras,false);
		}
	}

	public void savePedidoCompraRelacionesBase(PedidoCompra pedidocompra,List<DetallePedidoCompra> detallepedidocompras,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PedidoCompra-saveRelacionesWithConnection");}
	
			pedidocompra.setDetallePedidoCompras(detallepedidocompras);

			this.setPedidoCompra(pedidocompra);

			if(PedidoCompraLogicAdditional.validarSaveRelaciones(pedidocompra,this)) {

				PedidoCompraLogicAdditional.updateRelacionesToSave(pedidocompra,this);

				if((pedidocompra.getIsNew()||pedidocompra.getIsChanged())&&!pedidocompra.getIsDeleted()) {
					this.savePedidoCompra();
					this.savePedidoCompraRelacionesDetalles(detallepedidocompras);

				} else if(pedidocompra.getIsDeleted()) {
					this.savePedidoCompraRelacionesDetalles(detallepedidocompras);
					this.savePedidoCompra();
				}

				PedidoCompraLogicAdditional.updateRelacionesToSaveAfter(pedidocompra,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetallePedidoCompraConstantesFunciones.InicializarGeneralEntityAuxiliaresDetallePedidoCompras(detallepedidocompras,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void savePedidoCompraRelacionesDetalles(List<DetallePedidoCompra> detallepedidocompras)throws Exception {
		try {
	

			Long idPedidoCompraActual=this.getPedidoCompra().getId();

			DetallePedidoCompraLogic detallepedidocompraLogic_Desde_PedidoCompra=new DetallePedidoCompraLogic();
			detallepedidocompraLogic_Desde_PedidoCompra.setDetallePedidoCompras(detallepedidocompras);

			detallepedidocompraLogic_Desde_PedidoCompra.setConnexion(this.getConnexion());
			detallepedidocompraLogic_Desde_PedidoCompra.setDatosCliente(this.datosCliente);

			for(DetallePedidoCompra detallepedidocompra_Desde_PedidoCompra:detallepedidocompraLogic_Desde_PedidoCompra.getDetallePedidoCompras()) {
				detallepedidocompra_Desde_PedidoCompra.setid_pedido_compra(idPedidoCompraActual);
			}

			detallepedidocompraLogic_Desde_PedidoCompra.saveDetallePedidoCompras();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPedidoCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PedidoCompraConstantesFunciones.getClassesForeignKeysOfPedidoCompra(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidoCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PedidoCompraConstantesFunciones.getClassesRelationshipsOfPedidoCompra(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

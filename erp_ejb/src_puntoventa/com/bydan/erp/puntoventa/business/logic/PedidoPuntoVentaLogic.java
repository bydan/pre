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
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.puntoventa.util.PedidoPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.PedidoPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.PedidoPuntoVentaParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.PedidoPuntoVenta;
import com.bydan.erp.puntoventa.business.logic.PedidoPuntoVentaLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class PedidoPuntoVentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PedidoPuntoVentaLogic.class);
	
	protected PedidoPuntoVentaDataAccess pedidopuntoventaDataAccess; 	
	protected PedidoPuntoVenta pedidopuntoventa;
	protected List<PedidoPuntoVenta> pedidopuntoventas;
	protected Object pedidopuntoventaObject;	
	protected List<Object> pedidopuntoventasObject;
	
	public static ClassValidator<PedidoPuntoVenta> pedidopuntoventaValidator = new ClassValidator<PedidoPuntoVenta>(PedidoPuntoVenta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PedidoPuntoVentaLogicAdditional pedidopuntoventaLogicAdditional=null;
	
	public PedidoPuntoVentaLogicAdditional getPedidoPuntoVentaLogicAdditional() {
		return this.pedidopuntoventaLogicAdditional;
	}
	
	public void setPedidoPuntoVentaLogicAdditional(PedidoPuntoVentaLogicAdditional pedidopuntoventaLogicAdditional) {
		try {
			this.pedidopuntoventaLogicAdditional=pedidopuntoventaLogicAdditional;
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
	
	
	
	
	public  PedidoPuntoVentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.pedidopuntoventaDataAccess = new PedidoPuntoVentaDataAccess();
			
			this.pedidopuntoventas= new ArrayList<PedidoPuntoVenta>();
			this.pedidopuntoventa= new PedidoPuntoVenta();
			
			this.pedidopuntoventaObject=new Object();
			this.pedidopuntoventasObject=new ArrayList<Object>();
				
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
			
			this.pedidopuntoventaDataAccess.setConnexionType(this.connexionType);
			this.pedidopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PedidoPuntoVentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.pedidopuntoventaDataAccess = new PedidoPuntoVentaDataAccess();
			this.pedidopuntoventas= new ArrayList<PedidoPuntoVenta>();
			this.pedidopuntoventa= new PedidoPuntoVenta();
			this.pedidopuntoventaObject=new Object();
			this.pedidopuntoventasObject=new ArrayList<Object>();
			
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
			
			this.pedidopuntoventaDataAccess.setConnexionType(this.connexionType);
			this.pedidopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PedidoPuntoVenta getPedidoPuntoVenta() throws Exception {	
		PedidoPuntoVentaLogicAdditional.checkPedidoPuntoVentaToGet(pedidopuntoventa,this.datosCliente,this.arrDatoGeneral);
		PedidoPuntoVentaLogicAdditional.updatePedidoPuntoVentaToGet(pedidopuntoventa,this.arrDatoGeneral);
		
		return pedidopuntoventa;
	}
		
	public void setPedidoPuntoVenta(PedidoPuntoVenta newPedidoPuntoVenta) {
		this.pedidopuntoventa = newPedidoPuntoVenta;
	}
	
	public PedidoPuntoVentaDataAccess getPedidoPuntoVentaDataAccess() {
		return pedidopuntoventaDataAccess;
	}
	
	public void setPedidoPuntoVentaDataAccess(PedidoPuntoVentaDataAccess newpedidopuntoventaDataAccess) {
		this.pedidopuntoventaDataAccess = newpedidopuntoventaDataAccess;
	}
	
	public List<PedidoPuntoVenta> getPedidoPuntoVentas() throws Exception {		
		this.quitarPedidoPuntoVentasNulos();
		
		PedidoPuntoVentaLogicAdditional.checkPedidoPuntoVentaToGets(pedidopuntoventas,this.datosCliente,this.arrDatoGeneral);
		
		for (PedidoPuntoVenta pedidopuntoventaLocal: pedidopuntoventas ) {
			PedidoPuntoVentaLogicAdditional.updatePedidoPuntoVentaToGet(pedidopuntoventaLocal,this.arrDatoGeneral);
		}
		
		return pedidopuntoventas;
	}
	
	public void setPedidoPuntoVentas(List<PedidoPuntoVenta> newPedidoPuntoVentas) {
		this.pedidopuntoventas = newPedidoPuntoVentas;
	}
	
	public Object getPedidoPuntoVentaObject() {	
		this.pedidopuntoventaObject=this.pedidopuntoventaDataAccess.getEntityObject();
		return this.pedidopuntoventaObject;
	}
		
	public void setPedidoPuntoVentaObject(Object newPedidoPuntoVentaObject) {
		this.pedidopuntoventaObject = newPedidoPuntoVentaObject;
	}
	
	public List<Object> getPedidoPuntoVentasObject() {		
		this.pedidopuntoventasObject=this.pedidopuntoventaDataAccess.getEntitiesObject();
		return this.pedidopuntoventasObject;
	}
		
	public void setPedidoPuntoVentasObject(List<Object> newPedidoPuntoVentasObject) {
		this.pedidopuntoventasObject = newPedidoPuntoVentasObject;
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
		
		if(this.pedidopuntoventaDataAccess!=null) {
			this.pedidopuntoventaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			pedidopuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			pedidopuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		pedidopuntoventa = new  PedidoPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			pedidopuntoventa=pedidopuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventa);
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
		pedidopuntoventa = new  PedidoPuntoVenta();
		  		  
        try {
			
			pedidopuntoventa=pedidopuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		pedidopuntoventa = new  PedidoPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			pedidopuntoventa=pedidopuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventa);
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
		pedidopuntoventa = new  PedidoPuntoVenta();
		  		  
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
		pedidopuntoventa = new  PedidoPuntoVenta();
		  		  
        try {
			
			pedidopuntoventa=pedidopuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		pedidopuntoventa = new  PedidoPuntoVenta();
		  		  
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
		pedidopuntoventa = new  PedidoPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =pedidopuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pedidopuntoventa = new  PedidoPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=pedidopuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		pedidopuntoventa = new  PedidoPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =pedidopuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pedidopuntoventa = new  PedidoPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=pedidopuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		pedidopuntoventa = new  PedidoPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =pedidopuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pedidopuntoventa = new  PedidoPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=pedidopuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		pedidopuntoventas = new  ArrayList<PedidoPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoPuntoVenta(pedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
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
		pedidopuntoventas = new  ArrayList<PedidoPuntoVenta>();
		  		  
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
		pedidopuntoventas = new  ArrayList<PedidoPuntoVenta>();
		  		  
        try {			
			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPedidoPuntoVenta(pedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		pedidopuntoventas = new  ArrayList<PedidoPuntoVenta>();
		  		  
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
		pedidopuntoventas = new  ArrayList<PedidoPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoPuntoVenta(pedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
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
		pedidopuntoventas = new  ArrayList<PedidoPuntoVenta>();
		  		  
        try {
			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoPuntoVenta(pedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
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
		pedidopuntoventas = new  ArrayList<PedidoPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoPuntoVenta(pedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
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
		pedidopuntoventas = new  ArrayList<PedidoPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoPuntoVenta(pedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		pedidopuntoventa = new  PedidoPuntoVenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidopuntoventa=pedidopuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoPuntoVenta(pedidopuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventa);
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
		pedidopuntoventa = new  PedidoPuntoVenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidopuntoventa=pedidopuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoPuntoVenta(pedidopuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		pedidopuntoventas = new  ArrayList<PedidoPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidopuntoventas=pedidopuntoventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoPuntoVenta(pedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
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
		pedidopuntoventas = new  ArrayList<PedidoPuntoVenta>();
		  		  
        try {
			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidopuntoventas=pedidopuntoventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoPuntoVenta(pedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPedidoPuntoVentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		pedidopuntoventas = new  ArrayList<PedidoPuntoVenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-getTodosPedidoPuntoVentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPedidoPuntoVenta(pedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
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
	
	public  void  getTodosPedidoPuntoVentas(String sFinalQuery,Pagination pagination)throws Exception {
		pedidopuntoventas = new  ArrayList<PedidoPuntoVenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPedidoPuntoVenta(pedidopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPedidoPuntoVenta(PedidoPuntoVenta pedidopuntoventa) throws Exception {
		Boolean estaValidado=false;
		
		if(pedidopuntoventa.getIsNew() || pedidopuntoventa.getIsChanged()) { 
			this.invalidValues = pedidopuntoventaValidator.getInvalidValues(pedidopuntoventa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(pedidopuntoventa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPedidoPuntoVenta(List<PedidoPuntoVenta> PedidoPuntoVentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PedidoPuntoVenta pedidopuntoventaLocal:pedidopuntoventas) {				
			estaValidadoObjeto=this.validarGuardarPedidoPuntoVenta(pedidopuntoventaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPedidoPuntoVenta(List<PedidoPuntoVenta> PedidoPuntoVentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPedidoPuntoVenta(pedidopuntoventas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPedidoPuntoVenta(PedidoPuntoVenta PedidoPuntoVenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPedidoPuntoVenta(pedidopuntoventa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PedidoPuntoVenta pedidopuntoventa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+pedidopuntoventa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PedidoPuntoVentaConstantesFunciones.getPedidoPuntoVentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"pedidopuntoventa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PedidoPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PedidoPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePedidoPuntoVentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-savePedidoPuntoVentaWithConnection");connexion.begin();			
			
			PedidoPuntoVentaLogicAdditional.checkPedidoPuntoVentaToSave(this.pedidopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PedidoPuntoVentaLogicAdditional.updatePedidoPuntoVentaToSave(this.pedidopuntoventa,this.arrDatoGeneral);
			
			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.pedidopuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPedidoPuntoVenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPedidoPuntoVenta(this.pedidopuntoventa)) {
				PedidoPuntoVentaDataAccess.save(this.pedidopuntoventa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.pedidopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PedidoPuntoVentaLogicAdditional.checkPedidoPuntoVentaToSaveAfter(this.pedidopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPedidoPuntoVenta();
			
			connexion.commit();			
			
			if(this.pedidopuntoventa.getIsDeleted()) {
				this.pedidopuntoventa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePedidoPuntoVenta()throws Exception {	
		try {	
			
			PedidoPuntoVentaLogicAdditional.checkPedidoPuntoVentaToSave(this.pedidopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PedidoPuntoVentaLogicAdditional.updatePedidoPuntoVentaToSave(this.pedidopuntoventa,this.arrDatoGeneral);
			
			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.pedidopuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPedidoPuntoVenta(this.pedidopuntoventa)) {			
				PedidoPuntoVentaDataAccess.save(this.pedidopuntoventa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.pedidopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PedidoPuntoVentaLogicAdditional.checkPedidoPuntoVentaToSaveAfter(this.pedidopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.pedidopuntoventa.getIsDeleted()) {
				this.pedidopuntoventa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePedidoPuntoVentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-savePedidoPuntoVentasWithConnection");connexion.begin();			
			
			PedidoPuntoVentaLogicAdditional.checkPedidoPuntoVentaToSaves(pedidopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPedidoPuntoVentas();
			
			Boolean validadoTodosPedidoPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PedidoPuntoVenta pedidopuntoventaLocal:pedidopuntoventas) {		
				if(pedidopuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PedidoPuntoVentaLogicAdditional.updatePedidoPuntoVentaToSave(pedidopuntoventaLocal,this.arrDatoGeneral);
	        	
				PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),pedidopuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPedidoPuntoVenta(pedidopuntoventaLocal)) {
					PedidoPuntoVentaDataAccess.save(pedidopuntoventaLocal, connexion);				
				} else {
					validadoTodosPedidoPuntoVenta=false;
				}
			}
			
			if(!validadoTodosPedidoPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PedidoPuntoVentaLogicAdditional.checkPedidoPuntoVentaToSavesAfter(pedidopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPedidoPuntoVentas();
			
			connexion.commit();		
			
			this.quitarPedidoPuntoVentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePedidoPuntoVentas()throws Exception {				
		 try {	
			PedidoPuntoVentaLogicAdditional.checkPedidoPuntoVentaToSaves(pedidopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPedidoPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PedidoPuntoVenta pedidopuntoventaLocal:pedidopuntoventas) {				
				if(pedidopuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PedidoPuntoVentaLogicAdditional.updatePedidoPuntoVentaToSave(pedidopuntoventaLocal,this.arrDatoGeneral);
	        	
				PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),pedidopuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPedidoPuntoVenta(pedidopuntoventaLocal)) {				
					PedidoPuntoVentaDataAccess.save(pedidopuntoventaLocal, connexion);				
				} else {
					validadoTodosPedidoPuntoVenta=false;
				}
			}
			
			if(!validadoTodosPedidoPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PedidoPuntoVentaLogicAdditional.checkPedidoPuntoVentaToSavesAfter(pedidopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPedidoPuntoVentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PedidoPuntoVentaParameterReturnGeneral procesarAccionPedidoPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PedidoPuntoVenta> pedidopuntoventas,PedidoPuntoVentaParameterReturnGeneral pedidopuntoventaParameterGeneral)throws Exception {
		 try {	
			PedidoPuntoVentaParameterReturnGeneral pedidopuntoventaReturnGeneral=new PedidoPuntoVentaParameterReturnGeneral();
	
			PedidoPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pedidopuntoventas,pedidopuntoventaParameterGeneral,pedidopuntoventaReturnGeneral);
			
			return pedidopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PedidoPuntoVentaParameterReturnGeneral procesarAccionPedidoPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PedidoPuntoVenta> pedidopuntoventas,PedidoPuntoVentaParameterReturnGeneral pedidopuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-procesarAccionPedidoPuntoVentasWithConnection");connexion.begin();			
			
			PedidoPuntoVentaParameterReturnGeneral pedidopuntoventaReturnGeneral=new PedidoPuntoVentaParameterReturnGeneral();
	
			PedidoPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pedidopuntoventas,pedidopuntoventaParameterGeneral,pedidopuntoventaReturnGeneral);
			
			this.connexion.commit();
			
			return pedidopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PedidoPuntoVentaParameterReturnGeneral procesarEventosPedidoPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PedidoPuntoVenta> pedidopuntoventas,PedidoPuntoVenta pedidopuntoventa,PedidoPuntoVentaParameterReturnGeneral pedidopuntoventaParameterGeneral,Boolean isEsNuevoPedidoPuntoVenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			PedidoPuntoVentaParameterReturnGeneral pedidopuntoventaReturnGeneral=new PedidoPuntoVentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				pedidopuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PedidoPuntoVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,pedidopuntoventas,pedidopuntoventa,pedidopuntoventaParameterGeneral,pedidopuntoventaReturnGeneral,isEsNuevoPedidoPuntoVenta,clases);
			
			return pedidopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PedidoPuntoVentaParameterReturnGeneral procesarEventosPedidoPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PedidoPuntoVenta> pedidopuntoventas,PedidoPuntoVenta pedidopuntoventa,PedidoPuntoVentaParameterReturnGeneral pedidopuntoventaParameterGeneral,Boolean isEsNuevoPedidoPuntoVenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-procesarEventosPedidoPuntoVentasWithConnection");connexion.begin();			
			
			PedidoPuntoVentaParameterReturnGeneral pedidopuntoventaReturnGeneral=new PedidoPuntoVentaParameterReturnGeneral();
	
			pedidopuntoventaReturnGeneral.setPedidoPuntoVenta(pedidopuntoventa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				pedidopuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PedidoPuntoVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,pedidopuntoventas,pedidopuntoventa,pedidopuntoventaParameterGeneral,pedidopuntoventaReturnGeneral,isEsNuevoPedidoPuntoVenta,clases);
			
			this.connexion.commit();
			
			return pedidopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PedidoPuntoVentaParameterReturnGeneral procesarImportacionPedidoPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PedidoPuntoVentaParameterReturnGeneral pedidopuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-procesarImportacionPedidoPuntoVentasWithConnection");connexion.begin();			
			
			PedidoPuntoVentaParameterReturnGeneral pedidopuntoventaReturnGeneral=new PedidoPuntoVentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.pedidopuntoventas=new ArrayList<PedidoPuntoVenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.pedidopuntoventa=new PedidoPuntoVenta();
				
				
				if(conColumnasBase) {this.pedidopuntoventa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.pedidopuntoventa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.pedidopuntoventa.setnumero_secuencial(arrColumnas[iColumn++]);
				this.pedidopuntoventa.setcodigo_cliente(arrColumnas[iColumn++]);
				this.pedidopuntoventa.setnombre_cliente(arrColumnas[iColumn++]);
				this.pedidopuntoventa.setdireccion_cliente(arrColumnas[iColumn++]);
				this.pedidopuntoventa.settelefono_cliente(arrColumnas[iColumn++]);
				this.pedidopuntoventa.settarjeta_cliente(arrColumnas[iColumn++]);
				this.pedidopuntoventa.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				//this.pedidopuntoventa.sethora(arrColumnas[iColumn++]);
				this.pedidopuntoventa.setsub_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidopuntoventa.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidopuntoventa.setice(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidopuntoventa.setdescuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidopuntoventa.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.pedidopuntoventas.add(this.pedidopuntoventa);
			}
			
			this.savePedidoPuntoVentas();
			
			this.connexion.commit();
			
			pedidopuntoventaReturnGeneral.setConRetornoEstaProcesado(true);
			pedidopuntoventaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return pedidopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPedidoPuntoVentasEliminados() throws Exception {				
		
		List<PedidoPuntoVenta> pedidopuntoventasAux= new ArrayList<PedidoPuntoVenta>();
		
		for(PedidoPuntoVenta pedidopuntoventa:pedidopuntoventas) {
			if(!pedidopuntoventa.getIsDeleted()) {
				pedidopuntoventasAux.add(pedidopuntoventa);
			}
		}
		
		pedidopuntoventas=pedidopuntoventasAux;
	}
	
	public void quitarPedidoPuntoVentasNulos() throws Exception {				
		
		List<PedidoPuntoVenta> pedidopuntoventasAux= new ArrayList<PedidoPuntoVenta>();
		
		for(PedidoPuntoVenta pedidopuntoventa : this.pedidopuntoventas) {
			if(pedidopuntoventa==null) {
				pedidopuntoventasAux.add(pedidopuntoventa);
			}
		}
		
		//this.pedidopuntoventas=pedidopuntoventasAux;
		
		this.pedidopuntoventas.removeAll(pedidopuntoventasAux);
	}
	
	public void getSetVersionRowPedidoPuntoVentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(pedidopuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((pedidopuntoventa.getIsDeleted() || (pedidopuntoventa.getIsChanged()&&!pedidopuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=pedidopuntoventaDataAccess.getSetVersionRowPedidoPuntoVenta(connexion,pedidopuntoventa.getId());
				
				if(!pedidopuntoventa.getVersionRow().equals(timestamp)) {	
					pedidopuntoventa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				pedidopuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPedidoPuntoVenta()throws Exception {	
		
		if(pedidopuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((pedidopuntoventa.getIsDeleted() || (pedidopuntoventa.getIsChanged()&&!pedidopuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=pedidopuntoventaDataAccess.getSetVersionRowPedidoPuntoVenta(connexion,pedidopuntoventa.getId());
			
			try {							
				if(!pedidopuntoventa.getVersionRow().equals(timestamp)) {	
					pedidopuntoventa.setVersionRow(timestamp);
				}
				
				pedidopuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPedidoPuntoVentasWithConnection()throws Exception {	
		if(pedidopuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PedidoPuntoVenta pedidopuntoventaAux:pedidopuntoventas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(pedidopuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(pedidopuntoventaAux.getIsDeleted() || (pedidopuntoventaAux.getIsChanged()&&!pedidopuntoventaAux.getIsNew())) {
						
						timestamp=pedidopuntoventaDataAccess.getSetVersionRowPedidoPuntoVenta(connexion,pedidopuntoventaAux.getId());
						
						if(!pedidopuntoventa.getVersionRow().equals(timestamp)) {	
							pedidopuntoventaAux.setVersionRow(timestamp);
						}
								
						pedidopuntoventaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPedidoPuntoVentas()throws Exception {	
		if(pedidopuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PedidoPuntoVenta pedidopuntoventaAux:pedidopuntoventas) {
					if(pedidopuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(pedidopuntoventaAux.getIsDeleted() || (pedidopuntoventaAux.getIsChanged()&&!pedidopuntoventaAux.getIsNew())) {
						
						timestamp=pedidopuntoventaDataAccess.getSetVersionRowPedidoPuntoVenta(connexion,pedidopuntoventaAux.getId());
						
						if(!pedidopuntoventaAux.getVersionRow().equals(timestamp)) {	
							pedidopuntoventaAux.setVersionRow(timestamp);
						}
						
													
						pedidopuntoventaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PedidoPuntoVentaParameterReturnGeneral cargarCombosLoteForeignKeyPedidoPuntoVentaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalVendedor,String finalQueryGlobalCaja,String finalQueryGlobalCliente,String finalQueryGlobalTipoPrecio,String finalQueryGlobalMesa,String finalQueryGlobalEstadoPedidoPuntoVenta) throws Exception {
		PedidoPuntoVentaParameterReturnGeneral  pedidopuntoventaReturnGeneral =new PedidoPuntoVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-cargarCombosLoteForeignKeyPedidoPuntoVentaWithConnection");connexion.begin();
			
			pedidopuntoventaReturnGeneral =new PedidoPuntoVentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			pedidopuntoventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			pedidopuntoventaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			pedidopuntoventaReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			pedidopuntoventaReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Caja> cajasForeignKey=new ArrayList<Caja>();
			CajaLogic cajaLogic=new CajaLogic();
			cajaLogic.setConnexion(this.connexion);
			cajaLogic.getCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCaja.equals("NONE")) {
				cajaLogic.getTodosCajas(finalQueryGlobalCaja,new Pagination());
				cajasForeignKey=cajaLogic.getCajas();
			}

			pedidopuntoventaReturnGeneral.setcajasForeignKey(cajasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			//clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			pedidopuntoventaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			pedidopuntoventaReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Mesa> mesasForeignKey=new ArrayList<Mesa>();
			MesaLogic mesaLogic=new MesaLogic();
			mesaLogic.setConnexion(this.connexion);
			mesaLogic.getMesaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMesa.equals("NONE")) {
				mesaLogic.getTodosMesas(finalQueryGlobalMesa,new Pagination());
				mesasForeignKey=mesaLogic.getMesas();
			}

			pedidopuntoventaReturnGeneral.setmesasForeignKey(mesasForeignKey);


			List<EstadoPedidoPuntoVenta> estadopedidopuntoventasForeignKey=new ArrayList<EstadoPedidoPuntoVenta>();
			EstadoPedidoPuntoVentaLogic estadopedidopuntoventaLogic=new EstadoPedidoPuntoVentaLogic();
			estadopedidopuntoventaLogic.setConnexion(this.connexion);
			estadopedidopuntoventaLogic.getEstadoPedidoPuntoVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedidoPuntoVenta.equals("NONE")) {
				estadopedidopuntoventaLogic.getTodosEstadoPedidoPuntoVentas(finalQueryGlobalEstadoPedidoPuntoVenta,new Pagination());
				estadopedidopuntoventasForeignKey=estadopedidopuntoventaLogic.getEstadoPedidoPuntoVentas();
			}

			pedidopuntoventaReturnGeneral.setestadopedidopuntoventasForeignKey(estadopedidopuntoventasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return pedidopuntoventaReturnGeneral;
	}
	
	public PedidoPuntoVentaParameterReturnGeneral cargarCombosLoteForeignKeyPedidoPuntoVenta(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalVendedor,String finalQueryGlobalCaja,String finalQueryGlobalCliente,String finalQueryGlobalTipoPrecio,String finalQueryGlobalMesa,String finalQueryGlobalEstadoPedidoPuntoVenta) throws Exception {
		PedidoPuntoVentaParameterReturnGeneral  pedidopuntoventaReturnGeneral =new PedidoPuntoVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			pedidopuntoventaReturnGeneral =new PedidoPuntoVentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			pedidopuntoventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			pedidopuntoventaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			pedidopuntoventaReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			pedidopuntoventaReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Caja> cajasForeignKey=new ArrayList<Caja>();
			CajaLogic cajaLogic=new CajaLogic();
			cajaLogic.setConnexion(this.connexion);
			cajaLogic.getCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCaja.equals("NONE")) {
				cajaLogic.getTodosCajas(finalQueryGlobalCaja,new Pagination());
				cajasForeignKey=cajaLogic.getCajas();
			}

			pedidopuntoventaReturnGeneral.setcajasForeignKey(cajasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			//clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			pedidopuntoventaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			pedidopuntoventaReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Mesa> mesasForeignKey=new ArrayList<Mesa>();
			MesaLogic mesaLogic=new MesaLogic();
			mesaLogic.setConnexion(this.connexion);
			mesaLogic.getMesaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMesa.equals("NONE")) {
				mesaLogic.getTodosMesas(finalQueryGlobalMesa,new Pagination());
				mesasForeignKey=mesaLogic.getMesas();
			}

			pedidopuntoventaReturnGeneral.setmesasForeignKey(mesasForeignKey);


			List<EstadoPedidoPuntoVenta> estadopedidopuntoventasForeignKey=new ArrayList<EstadoPedidoPuntoVenta>();
			EstadoPedidoPuntoVentaLogic estadopedidopuntoventaLogic=new EstadoPedidoPuntoVentaLogic();
			estadopedidopuntoventaLogic.setConnexion(this.connexion);
			estadopedidopuntoventaLogic.getEstadoPedidoPuntoVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedidoPuntoVenta.equals("NONE")) {
				estadopedidopuntoventaLogic.getTodosEstadoPedidoPuntoVentas(finalQueryGlobalEstadoPedidoPuntoVenta,new Pagination());
				estadopedidopuntoventasForeignKey=estadopedidopuntoventaLogic.getEstadoPedidoPuntoVentas();
			}

			pedidopuntoventaReturnGeneral.setestadopedidopuntoventasForeignKey(estadopedidopuntoventasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return pedidopuntoventaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyPedidoPuntoVentaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetallePedidoPuntoVentaLogic detallepedidopuntoventaLogic=new DetallePedidoPuntoVentaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyPedidoPuntoVentaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetallePedidoPuntoVenta.class));
											
			

			detallepedidopuntoventaLogic.setConnexion(this.getConnexion());
			detallepedidopuntoventaLogic.setDatosCliente(this.datosCliente);
			detallepedidopuntoventaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(PedidoPuntoVenta pedidopuntoventa:this.pedidopuntoventas) {
				

				classes=new ArrayList<Classe>();
				classes=DetallePedidoPuntoVentaConstantesFunciones.getClassesForeignKeysOfDetallePedidoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallepedidopuntoventaLogic.setDetallePedidoPuntoVentas(pedidopuntoventa.detallepedidopuntoventas);
				detallepedidopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(PedidoPuntoVenta pedidopuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PedidoPuntoVentaLogicAdditional.updatePedidoPuntoVentaToGet(pedidopuntoventa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pedidopuntoventa.setEmpresa(pedidopuntoventaDataAccess.getEmpresa(connexion,pedidopuntoventa));
		pedidopuntoventa.setSucursal(pedidopuntoventaDataAccess.getSucursal(connexion,pedidopuntoventa));
		pedidopuntoventa.setUsuario(pedidopuntoventaDataAccess.getUsuario(connexion,pedidopuntoventa));
		pedidopuntoventa.setVendedor(pedidopuntoventaDataAccess.getVendedor(connexion,pedidopuntoventa));
		pedidopuntoventa.setCaja(pedidopuntoventaDataAccess.getCaja(connexion,pedidopuntoventa));
		pedidopuntoventa.setCliente(pedidopuntoventaDataAccess.getCliente(connexion,pedidopuntoventa));
		pedidopuntoventa.setTipoPrecio(pedidopuntoventaDataAccess.getTipoPrecio(connexion,pedidopuntoventa));
		pedidopuntoventa.setMesa(pedidopuntoventaDataAccess.getMesa(connexion,pedidopuntoventa));
		pedidopuntoventa.setEstadoPedidoPuntoVenta(pedidopuntoventaDataAccess.getEstadoPedidoPuntoVenta(connexion,pedidopuntoventa));
		pedidopuntoventa.setDetallePedidoPuntoVentas(pedidopuntoventaDataAccess.getDetallePedidoPuntoVentas(connexion,pedidopuntoventa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pedidopuntoventa.setEmpresa(pedidopuntoventaDataAccess.getEmpresa(connexion,pedidopuntoventa));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				pedidopuntoventa.setSucursal(pedidopuntoventaDataAccess.getSucursal(connexion,pedidopuntoventa));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				pedidopuntoventa.setUsuario(pedidopuntoventaDataAccess.getUsuario(connexion,pedidopuntoventa));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				pedidopuntoventa.setVendedor(pedidopuntoventaDataAccess.getVendedor(connexion,pedidopuntoventa));
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				pedidopuntoventa.setCaja(pedidopuntoventaDataAccess.getCaja(connexion,pedidopuntoventa));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				pedidopuntoventa.setCliente(pedidopuntoventaDataAccess.getCliente(connexion,pedidopuntoventa));
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				pedidopuntoventa.setTipoPrecio(pedidopuntoventaDataAccess.getTipoPrecio(connexion,pedidopuntoventa));
				continue;
			}

			if(clas.clas.equals(Mesa.class)) {
				pedidopuntoventa.setMesa(pedidopuntoventaDataAccess.getMesa(connexion,pedidopuntoventa));
				continue;
			}

			if(clas.clas.equals(EstadoPedidoPuntoVenta.class)) {
				pedidopuntoventa.setEstadoPedidoPuntoVenta(pedidopuntoventaDataAccess.getEstadoPedidoPuntoVenta(connexion,pedidopuntoventa));
				continue;
			}

			if(clas.clas.equals(DetallePedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				pedidopuntoventa.setDetallePedidoPuntoVentas(pedidopuntoventaDataAccess.getDetallePedidoPuntoVentas(connexion,pedidopuntoventa));

				if(this.isConDeep) {
					DetallePedidoPuntoVentaLogic detallepedidopuntoventaLogic= new DetallePedidoPuntoVentaLogic(this.connexion);
					detallepedidopuntoventaLogic.setDetallePedidoPuntoVentas(pedidopuntoventa.getDetallePedidoPuntoVentas());
					ArrayList<Classe> classesLocal=DetallePedidoPuntoVentaConstantesFunciones.getClassesForeignKeysOfDetallePedidoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallepedidopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetallePedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(detallepedidopuntoventaLogic.getDetallePedidoPuntoVentas());
					pedidopuntoventa.setDetallePedidoPuntoVentas(detallepedidopuntoventaLogic.getDetallePedidoPuntoVentas());
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
			pedidopuntoventa.setEmpresa(pedidopuntoventaDataAccess.getEmpresa(connexion,pedidopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidopuntoventa.setSucursal(pedidopuntoventaDataAccess.getSucursal(connexion,pedidopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidopuntoventa.setUsuario(pedidopuntoventaDataAccess.getUsuario(connexion,pedidopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidopuntoventa.setVendedor(pedidopuntoventaDataAccess.getVendedor(connexion,pedidopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidopuntoventa.setCaja(pedidopuntoventaDataAccess.getCaja(connexion,pedidopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidopuntoventa.setCliente(pedidopuntoventaDataAccess.getCliente(connexion,pedidopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidopuntoventa.setTipoPrecio(pedidopuntoventaDataAccess.getTipoPrecio(connexion,pedidopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mesa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidopuntoventa.setMesa(pedidopuntoventaDataAccess.getMesa(connexion,pedidopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedidoPuntoVenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidopuntoventa.setEstadoPedidoPuntoVenta(pedidopuntoventaDataAccess.getEstadoPedidoPuntoVenta(connexion,pedidopuntoventa));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetallePedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetallePedidoPuntoVenta.class));
			pedidopuntoventa.setDetallePedidoPuntoVentas(pedidopuntoventaDataAccess.getDetallePedidoPuntoVentas(connexion,pedidopuntoventa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pedidopuntoventa.setEmpresa(pedidopuntoventaDataAccess.getEmpresa(connexion,pedidopuntoventa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(pedidopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		pedidopuntoventa.setSucursal(pedidopuntoventaDataAccess.getSucursal(connexion,pedidopuntoventa));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(pedidopuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				
		pedidopuntoventa.setUsuario(pedidopuntoventaDataAccess.getUsuario(connexion,pedidopuntoventa));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(pedidopuntoventa.getUsuario(),isDeep,deepLoadType,clases);
				
		pedidopuntoventa.setVendedor(pedidopuntoventaDataAccess.getVendedor(connexion,pedidopuntoventa));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(pedidopuntoventa.getVendedor(),isDeep,deepLoadType,clases);
				
		pedidopuntoventa.setCaja(pedidopuntoventaDataAccess.getCaja(connexion,pedidopuntoventa));
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(pedidopuntoventa.getCaja(),isDeep,deepLoadType,clases);
				
		pedidopuntoventa.setCliente(pedidopuntoventaDataAccess.getCliente(connexion,pedidopuntoventa));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(pedidopuntoventa.getCliente(),isDeep,deepLoadType,clases);
				
		pedidopuntoventa.setTipoPrecio(pedidopuntoventaDataAccess.getTipoPrecio(connexion,pedidopuntoventa));
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(pedidopuntoventa.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		pedidopuntoventa.setMesa(pedidopuntoventaDataAccess.getMesa(connexion,pedidopuntoventa));
		MesaLogic mesaLogic= new MesaLogic(connexion);
		mesaLogic.deepLoad(pedidopuntoventa.getMesa(),isDeep,deepLoadType,clases);
				
		pedidopuntoventa.setEstadoPedidoPuntoVenta(pedidopuntoventaDataAccess.getEstadoPedidoPuntoVenta(connexion,pedidopuntoventa));
		EstadoPedidoPuntoVentaLogic estadopedidopuntoventaLogic= new EstadoPedidoPuntoVentaLogic(connexion);
		estadopedidopuntoventaLogic.deepLoad(pedidopuntoventa.getEstadoPedidoPuntoVenta(),isDeep,deepLoadType,clases);
				

		pedidopuntoventa.setDetallePedidoPuntoVentas(pedidopuntoventaDataAccess.getDetallePedidoPuntoVentas(connexion,pedidopuntoventa));

		for(DetallePedidoPuntoVenta detallepedidopuntoventa:pedidopuntoventa.getDetallePedidoPuntoVentas()) {
			DetallePedidoPuntoVentaLogic detallepedidopuntoventaLogic= new DetallePedidoPuntoVentaLogic(connexion);
			detallepedidopuntoventaLogic.deepLoad(detallepedidopuntoventa,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pedidopuntoventa.setEmpresa(pedidopuntoventaDataAccess.getEmpresa(connexion,pedidopuntoventa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(pedidopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				pedidopuntoventa.setSucursal(pedidopuntoventaDataAccess.getSucursal(connexion,pedidopuntoventa));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(pedidopuntoventa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				pedidopuntoventa.setUsuario(pedidopuntoventaDataAccess.getUsuario(connexion,pedidopuntoventa));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(pedidopuntoventa.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				pedidopuntoventa.setVendedor(pedidopuntoventaDataAccess.getVendedor(connexion,pedidopuntoventa));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(pedidopuntoventa.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				pedidopuntoventa.setCaja(pedidopuntoventaDataAccess.getCaja(connexion,pedidopuntoventa));
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepLoad(pedidopuntoventa.getCaja(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				pedidopuntoventa.setCliente(pedidopuntoventaDataAccess.getCliente(connexion,pedidopuntoventa));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(pedidopuntoventa.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				pedidopuntoventa.setTipoPrecio(pedidopuntoventaDataAccess.getTipoPrecio(connexion,pedidopuntoventa));
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepLoad(pedidopuntoventa.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mesa.class)) {
				pedidopuntoventa.setMesa(pedidopuntoventaDataAccess.getMesa(connexion,pedidopuntoventa));
				MesaLogic mesaLogic= new MesaLogic(connexion);
				mesaLogic.deepLoad(pedidopuntoventa.getMesa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedidoPuntoVenta.class)) {
				pedidopuntoventa.setEstadoPedidoPuntoVenta(pedidopuntoventaDataAccess.getEstadoPedidoPuntoVenta(connexion,pedidopuntoventa));
				EstadoPedidoPuntoVentaLogic estadopedidopuntoventaLogic= new EstadoPedidoPuntoVentaLogic(connexion);
				estadopedidopuntoventaLogic.deepLoad(pedidopuntoventa.getEstadoPedidoPuntoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetallePedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				pedidopuntoventa.setDetallePedidoPuntoVentas(pedidopuntoventaDataAccess.getDetallePedidoPuntoVentas(connexion,pedidopuntoventa));

				for(DetallePedidoPuntoVenta detallepedidopuntoventa:pedidopuntoventa.getDetallePedidoPuntoVentas()) {
					DetallePedidoPuntoVentaLogic detallepedidopuntoventaLogic= new DetallePedidoPuntoVentaLogic(connexion);
					detallepedidopuntoventaLogic.deepLoad(detallepedidopuntoventa,isDeep,deepLoadType,clases);
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
			pedidopuntoventa.setEmpresa(pedidopuntoventaDataAccess.getEmpresa(connexion,pedidopuntoventa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(pedidopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidopuntoventa.setSucursal(pedidopuntoventaDataAccess.getSucursal(connexion,pedidopuntoventa));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(pedidopuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidopuntoventa.setUsuario(pedidopuntoventaDataAccess.getUsuario(connexion,pedidopuntoventa));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(pedidopuntoventa.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidopuntoventa.setVendedor(pedidopuntoventaDataAccess.getVendedor(connexion,pedidopuntoventa));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(pedidopuntoventa.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidopuntoventa.setCaja(pedidopuntoventaDataAccess.getCaja(connexion,pedidopuntoventa));
			CajaLogic cajaLogic= new CajaLogic(connexion);
			cajaLogic.deepLoad(pedidopuntoventa.getCaja(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidopuntoventa.setCliente(pedidopuntoventaDataAccess.getCliente(connexion,pedidopuntoventa));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(pedidopuntoventa.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidopuntoventa.setTipoPrecio(pedidopuntoventaDataAccess.getTipoPrecio(connexion,pedidopuntoventa));
			TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
			tipoprecioLogic.deepLoad(pedidopuntoventa.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mesa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidopuntoventa.setMesa(pedidopuntoventaDataAccess.getMesa(connexion,pedidopuntoventa));
			MesaLogic mesaLogic= new MesaLogic(connexion);
			mesaLogic.deepLoad(pedidopuntoventa.getMesa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedidoPuntoVenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidopuntoventa.setEstadoPedidoPuntoVenta(pedidopuntoventaDataAccess.getEstadoPedidoPuntoVenta(connexion,pedidopuntoventa));
			EstadoPedidoPuntoVentaLogic estadopedidopuntoventaLogic= new EstadoPedidoPuntoVentaLogic(connexion);
			estadopedidopuntoventaLogic.deepLoad(pedidopuntoventa.getEstadoPedidoPuntoVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetallePedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetallePedidoPuntoVenta.class));
			pedidopuntoventa.setDetallePedidoPuntoVentas(pedidopuntoventaDataAccess.getDetallePedidoPuntoVentas(connexion,pedidopuntoventa));

			for(DetallePedidoPuntoVenta detallepedidopuntoventa:pedidopuntoventa.getDetallePedidoPuntoVentas()) {
				DetallePedidoPuntoVentaLogic detallepedidopuntoventaLogic= new DetallePedidoPuntoVentaLogic(connexion);
				detallepedidopuntoventaLogic.deepLoad(detallepedidopuntoventa,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PedidoPuntoVenta pedidopuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PedidoPuntoVentaLogicAdditional.updatePedidoPuntoVentaToSave(pedidopuntoventa,this.arrDatoGeneral);
			
PedidoPuntoVentaDataAccess.save(pedidopuntoventa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(pedidopuntoventa.getEmpresa(),connexion);

		SucursalDataAccess.save(pedidopuntoventa.getSucursal(),connexion);

		UsuarioDataAccess.save(pedidopuntoventa.getUsuario(),connexion);

		VendedorDataAccess.save(pedidopuntoventa.getVendedor(),connexion);

		CajaDataAccess.save(pedidopuntoventa.getCaja(),connexion);

		ClienteDataAccess.save(pedidopuntoventa.getCliente(),connexion);

		TipoPrecioDataAccess.save(pedidopuntoventa.getTipoPrecio(),connexion);

		MesaDataAccess.save(pedidopuntoventa.getMesa(),connexion);

		EstadoPedidoPuntoVentaDataAccess.save(pedidopuntoventa.getEstadoPedidoPuntoVenta(),connexion);

		for(DetallePedidoPuntoVenta detallepedidopuntoventa:pedidopuntoventa.getDetallePedidoPuntoVentas()) {
			detallepedidopuntoventa.setid_pedido_punto_venta(pedidopuntoventa.getId());
			DetallePedidoPuntoVentaDataAccess.save(detallepedidopuntoventa,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(pedidopuntoventa.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(pedidopuntoventa.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(pedidopuntoventa.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(pedidopuntoventa.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				CajaDataAccess.save(pedidopuntoventa.getCaja(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(pedidopuntoventa.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(pedidopuntoventa.getTipoPrecio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mesa.class)) {
				MesaDataAccess.save(pedidopuntoventa.getMesa(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoPedidoPuntoVenta.class)) {
				EstadoPedidoPuntoVentaDataAccess.save(pedidopuntoventa.getEstadoPedidoPuntoVenta(),connexion);
				continue;
			}


			if(clas.clas.equals(DetallePedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetallePedidoPuntoVenta detallepedidopuntoventa:pedidopuntoventa.getDetallePedidoPuntoVentas()) {
					detallepedidopuntoventa.setid_pedido_punto_venta(pedidopuntoventa.getId());
					DetallePedidoPuntoVentaDataAccess.save(detallepedidopuntoventa,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(pedidopuntoventa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(pedidopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(pedidopuntoventa.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(pedidopuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(pedidopuntoventa.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(pedidopuntoventa.getUsuario(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(pedidopuntoventa.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(pedidopuntoventa.getVendedor(),isDeep,deepLoadType,clases);
				

		CajaDataAccess.save(pedidopuntoventa.getCaja(),connexion);
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(pedidopuntoventa.getCaja(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(pedidopuntoventa.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(pedidopuntoventa.getCliente(),isDeep,deepLoadType,clases);
				

		TipoPrecioDataAccess.save(pedidopuntoventa.getTipoPrecio(),connexion);
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(pedidopuntoventa.getTipoPrecio(),isDeep,deepLoadType,clases);
				

		MesaDataAccess.save(pedidopuntoventa.getMesa(),connexion);
		MesaLogic mesaLogic= new MesaLogic(connexion);
		mesaLogic.deepLoad(pedidopuntoventa.getMesa(),isDeep,deepLoadType,clases);
				

		EstadoPedidoPuntoVentaDataAccess.save(pedidopuntoventa.getEstadoPedidoPuntoVenta(),connexion);
		EstadoPedidoPuntoVentaLogic estadopedidopuntoventaLogic= new EstadoPedidoPuntoVentaLogic(connexion);
		estadopedidopuntoventaLogic.deepLoad(pedidopuntoventa.getEstadoPedidoPuntoVenta(),isDeep,deepLoadType,clases);
				

		for(DetallePedidoPuntoVenta detallepedidopuntoventa:pedidopuntoventa.getDetallePedidoPuntoVentas()) {
			DetallePedidoPuntoVentaLogic detallepedidopuntoventaLogic= new DetallePedidoPuntoVentaLogic(connexion);
			detallepedidopuntoventa.setid_pedido_punto_venta(pedidopuntoventa.getId());
			DetallePedidoPuntoVentaDataAccess.save(detallepedidopuntoventa,connexion);
			detallepedidopuntoventaLogic.deepSave(detallepedidopuntoventa,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(pedidopuntoventa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(pedidopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(pedidopuntoventa.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(pedidopuntoventa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(pedidopuntoventa.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(pedidopuntoventa.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(pedidopuntoventa.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(pedidopuntoventa.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				CajaDataAccess.save(pedidopuntoventa.getCaja(),connexion);
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepSave(pedidopuntoventa.getCaja(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(pedidopuntoventa.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(pedidopuntoventa.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(pedidopuntoventa.getTipoPrecio(),connexion);
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepSave(pedidopuntoventa.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mesa.class)) {
				MesaDataAccess.save(pedidopuntoventa.getMesa(),connexion);
				MesaLogic mesaLogic= new MesaLogic(connexion);
				mesaLogic.deepSave(pedidopuntoventa.getMesa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedidoPuntoVenta.class)) {
				EstadoPedidoPuntoVentaDataAccess.save(pedidopuntoventa.getEstadoPedidoPuntoVenta(),connexion);
				EstadoPedidoPuntoVentaLogic estadopedidopuntoventaLogic= new EstadoPedidoPuntoVentaLogic(connexion);
				estadopedidopuntoventaLogic.deepSave(pedidopuntoventa.getEstadoPedidoPuntoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetallePedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetallePedidoPuntoVenta detallepedidopuntoventa:pedidopuntoventa.getDetallePedidoPuntoVentas()) {
					DetallePedidoPuntoVentaLogic detallepedidopuntoventaLogic= new DetallePedidoPuntoVentaLogic(connexion);
					detallepedidopuntoventa.setid_pedido_punto_venta(pedidopuntoventa.getId());
					DetallePedidoPuntoVentaDataAccess.save(detallepedidopuntoventa,connexion);
					detallepedidopuntoventaLogic.deepSave(detallepedidopuntoventa,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(PedidoPuntoVenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(pedidopuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(pedidopuntoventa);
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
			this.deepLoad(this.pedidopuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PedidoPuntoVenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(pedidopuntoventas!=null) {
				for(PedidoPuntoVenta pedidopuntoventa:pedidopuntoventas) {
					this.deepLoad(pedidopuntoventa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(pedidopuntoventas);
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
			if(pedidopuntoventas!=null) {
				for(PedidoPuntoVenta pedidopuntoventa:pedidopuntoventas) {
					this.deepLoad(pedidopuntoventa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(pedidopuntoventas);
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
			this.getNewConnexionToDeep(PedidoPuntoVenta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(pedidopuntoventa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PedidoPuntoVenta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(pedidopuntoventas!=null) {
				for(PedidoPuntoVenta pedidopuntoventa:pedidopuntoventas) {
					this.deepSave(pedidopuntoventa,isDeep,deepLoadType,clases);
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
			if(pedidopuntoventas!=null) {
				for(PedidoPuntoVenta pedidopuntoventa:pedidopuntoventas) {
					this.deepSave(pedidopuntoventa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPedidoPuntoVentasFK_IdCajaWithConnection(String sFinalQuery,Pagination pagination,Long id_caja)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_caja,PedidoPuntoVentaConstantesFunciones.IDCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCaja);

			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoPuntoVentasFK_IdCaja(String sFinalQuery,Pagination pagination,Long id_caja)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_caja,PedidoPuntoVentaConstantesFunciones.IDCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCaja);

			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoPuntoVentasFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,PedidoPuntoVentaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoPuntoVentasFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,PedidoPuntoVentaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoPuntoVentasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PedidoPuntoVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoPuntoVentasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PedidoPuntoVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoPuntoVentasFK_IdEstadoPedidoPuntoVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_pedido_punto_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedidoPuntoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedidoPuntoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido_punto_venta,PedidoPuntoVentaConstantesFunciones.IDESTADOPEDIDOPUNTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedidoPuntoVenta);

			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedidoPuntoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoPuntoVentasFK_IdEstadoPedidoPuntoVenta(String sFinalQuery,Pagination pagination,Long id_estado_pedido_punto_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedidoPuntoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedidoPuntoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido_punto_venta,PedidoPuntoVentaConstantesFunciones.IDESTADOPEDIDOPUNTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedidoPuntoVenta);

			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedidoPuntoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoPuntoVentasFK_IdMesaWithConnection(String sFinalQuery,Pagination pagination,Long id_mesa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMesa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMesa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mesa,PedidoPuntoVentaConstantesFunciones.IDMESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMesa);

			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMesa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoPuntoVentasFK_IdMesa(String sFinalQuery,Pagination pagination,Long id_mesa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMesa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMesa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mesa,PedidoPuntoVentaConstantesFunciones.IDMESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMesa);

			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMesa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoPuntoVentasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PedidoPuntoVentaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoPuntoVentasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PedidoPuntoVentaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoPuntoVentasFK_IdTipoPrecioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,PedidoPuntoVentaConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoPuntoVentasFK_IdTipoPrecio(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,PedidoPuntoVentaConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoPuntoVentasFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,PedidoPuntoVentaConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoPuntoVentasFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,PedidoPuntoVentaConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoPuntoVentasFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,PedidoPuntoVentaConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoPuntoVentasFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,PedidoPuntoVentaConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			PedidoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(this.pedidopuntoventas);
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
			if(PedidoPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoPuntoVentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PedidoPuntoVenta pedidopuntoventa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PedidoPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				if(pedidopuntoventa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoPuntoVentaDataAccess.TABLENAME, pedidopuntoventa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PedidoPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PedidoPuntoVentaLogic.registrarAuditoriaDetallesPedidoPuntoVenta(connexion,pedidopuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(pedidopuntoventa.getIsDeleted()) {
					/*if(!pedidopuntoventa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PedidoPuntoVentaDataAccess.TABLENAME, pedidopuntoventa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PedidoPuntoVentaLogic.registrarAuditoriaDetallesPedidoPuntoVenta(connexion,pedidopuntoventa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoPuntoVentaDataAccess.TABLENAME, pedidopuntoventa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(pedidopuntoventa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoPuntoVentaDataAccess.TABLENAME, pedidopuntoventa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PedidoPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PedidoPuntoVentaLogic.registrarAuditoriaDetallesPedidoPuntoVenta(connexion,pedidopuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPedidoPuntoVenta(Connexion connexion,PedidoPuntoVenta pedidopuntoventa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.getid_empresa().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_empresa()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_empresa().toString();
				}
				if(pedidopuntoventa.getid_empresa()!=null)
				{
					strValorNuevo=pedidopuntoventa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.getid_sucursal().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_sucursal()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_sucursal().toString();
				}
				if(pedidopuntoventa.getid_sucursal()!=null)
				{
					strValorNuevo=pedidopuntoventa.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.getid_usuario().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_usuario()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_usuario().toString();
				}
				if(pedidopuntoventa.getid_usuario()!=null)
				{
					strValorNuevo=pedidopuntoventa.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.getid_vendedor().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_vendedor()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_vendedor().toString();
				}
				if(pedidopuntoventa.getid_vendedor()!=null)
				{
					strValorNuevo=pedidopuntoventa.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.getid_caja().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_caja()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_caja()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_caja().toString();
				}
				if(pedidopuntoventa.getid_caja()!=null)
				{
					strValorNuevo=pedidopuntoventa.getid_caja().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.IDCAJA,strValorActual,strValorNuevo);
			}	
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.getid_cliente().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_cliente()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_cliente().toString();
				}
				if(pedidopuntoventa.getid_cliente()!=null)
				{
					strValorNuevo=pedidopuntoventa.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.getid_tipo_precio().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_tipo_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_tipo_precio()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_tipo_precio().toString();
				}
				if(pedidopuntoventa.getid_tipo_precio()!=null)
				{
					strValorNuevo=pedidopuntoventa.getid_tipo_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.IDTIPOPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.getid_mesa().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_mesa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_mesa()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_mesa().toString();
				}
				if(pedidopuntoventa.getid_mesa()!=null)
				{
					strValorNuevo=pedidopuntoventa.getid_mesa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.IDMESA,strValorActual,strValorNuevo);
			}	
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.getid_estado_pedido_punto_venta().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_estado_pedido_punto_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_estado_pedido_punto_venta()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().getid_estado_pedido_punto_venta().toString();
				}
				if(pedidopuntoventa.getid_estado_pedido_punto_venta()!=null)
				{
					strValorNuevo=pedidopuntoventa.getid_estado_pedido_punto_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.IDESTADOPEDIDOPUNTOVENTA,strValorActual,strValorNuevo);
			}	
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.getnumero_secuencial().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().getnumero_secuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().getnumero_secuencial()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().getnumero_secuencial();
				}
				if(pedidopuntoventa.getnumero_secuencial()!=null)
				{
					strValorNuevo=pedidopuntoventa.getnumero_secuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.NUMERO_SECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.getcodigo_cliente().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().getcodigo_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().getcodigo_cliente()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().getcodigo_cliente();
				}
				if(pedidopuntoventa.getcodigo_cliente()!=null)
				{
					strValorNuevo=pedidopuntoventa.getcodigo_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.CODIGOCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.getnombre_cliente().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().getnombre_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().getnombre_cliente()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().getnombre_cliente();
				}
				if(pedidopuntoventa.getnombre_cliente()!=null)
				{
					strValorNuevo=pedidopuntoventa.getnombre_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.NOMBRECLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.getdireccion_cliente().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().getdireccion_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().getdireccion_cliente()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().getdireccion_cliente();
				}
				if(pedidopuntoventa.getdireccion_cliente()!=null)
				{
					strValorNuevo=pedidopuntoventa.getdireccion_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.DIRECCIONCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.gettelefono_cliente().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().gettelefono_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().gettelefono_cliente()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().gettelefono_cliente();
				}
				if(pedidopuntoventa.gettelefono_cliente()!=null)
				{
					strValorNuevo=pedidopuntoventa.gettelefono_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.TELEFONOCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.gettarjeta_cliente().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().gettarjeta_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().gettarjeta_cliente()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().gettarjeta_cliente();
				}
				if(pedidopuntoventa.gettarjeta_cliente()!=null)
				{
					strValorNuevo=pedidopuntoventa.gettarjeta_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.TARJETACLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.getfecha().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().getfecha()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().getfecha().toString();
				}
				if(pedidopuntoventa.getfecha()!=null)
				{
					strValorNuevo=pedidopuntoventa.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.gethora().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().gethora()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().gethora()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().gethora().toString();
				}
				if(pedidopuntoventa.gethora()!=null)
				{
					strValorNuevo=pedidopuntoventa.gethora().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.HORA,strValorActual,strValorNuevo);
			}	
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.getsub_total().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().getsub_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().getsub_total()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().getsub_total().toString();
				}
				if(pedidopuntoventa.getsub_total()!=null)
				{
					strValorNuevo=pedidopuntoventa.getsub_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.SUBTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.getiva().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().getiva()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().getiva().toString();
				}
				if(pedidopuntoventa.getiva()!=null)
				{
					strValorNuevo=pedidopuntoventa.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.getice().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().getice()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().getice().toString();
				}
				if(pedidopuntoventa.getice()!=null)
				{
					strValorNuevo=pedidopuntoventa.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.getdescuento().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().getdescuento()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().getdescuento().toString();
				}
				if(pedidopuntoventa.getdescuento()!=null)
				{
					strValorNuevo=pedidopuntoventa.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(pedidopuntoventa.getIsNew()||!pedidopuntoventa.gettotal().equals(pedidopuntoventa.getPedidoPuntoVentaOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidopuntoventa.getPedidoPuntoVentaOriginal().gettotal()!=null)
				{
					strValorActual=pedidopuntoventa.getPedidoPuntoVentaOriginal().gettotal().toString();
				}
				if(pedidopuntoventa.gettotal()!=null)
				{
					strValorNuevo=pedidopuntoventa.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoPuntoVentaConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePedidoPuntoVentaRelacionesWithConnection(PedidoPuntoVenta pedidopuntoventa,List<DetallePedidoPuntoVenta> detallepedidopuntoventas) throws Exception {

		if(!pedidopuntoventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePedidoPuntoVentaRelacionesBase(pedidopuntoventa,detallepedidopuntoventas,true);
		}
	}

	public void savePedidoPuntoVentaRelaciones(PedidoPuntoVenta pedidopuntoventa,List<DetallePedidoPuntoVenta> detallepedidopuntoventas)throws Exception {

		if(!pedidopuntoventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePedidoPuntoVentaRelacionesBase(pedidopuntoventa,detallepedidopuntoventas,false);
		}
	}

	public void savePedidoPuntoVentaRelacionesBase(PedidoPuntoVenta pedidopuntoventa,List<DetallePedidoPuntoVenta> detallepedidopuntoventas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PedidoPuntoVenta-saveRelacionesWithConnection");}
	
			pedidopuntoventa.setDetallePedidoPuntoVentas(detallepedidopuntoventas);

			this.setPedidoPuntoVenta(pedidopuntoventa);

			if(PedidoPuntoVentaLogicAdditional.validarSaveRelaciones(pedidopuntoventa,this)) {

				PedidoPuntoVentaLogicAdditional.updateRelacionesToSave(pedidopuntoventa,this);

				if((pedidopuntoventa.getIsNew()||pedidopuntoventa.getIsChanged())&&!pedidopuntoventa.getIsDeleted()) {
					this.savePedidoPuntoVenta();
					this.savePedidoPuntoVentaRelacionesDetalles(detallepedidopuntoventas);

				} else if(pedidopuntoventa.getIsDeleted()) {
					this.savePedidoPuntoVentaRelacionesDetalles(detallepedidopuntoventas);
					this.savePedidoPuntoVenta();
				}

				PedidoPuntoVentaLogicAdditional.updateRelacionesToSaveAfter(pedidopuntoventa,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetallePedidoPuntoVentaConstantesFunciones.InicializarGeneralEntityAuxiliaresDetallePedidoPuntoVentas(detallepedidopuntoventas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void savePedidoPuntoVentaRelacionesDetalles(List<DetallePedidoPuntoVenta> detallepedidopuntoventas)throws Exception {
		try {
	

			Long idPedidoPuntoVentaActual=this.getPedidoPuntoVenta().getId();

			DetallePedidoPuntoVentaLogic detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta=new DetallePedidoPuntoVentaLogic();
			detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta.setDetallePedidoPuntoVentas(detallepedidopuntoventas);

			detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta.setConnexion(this.getConnexion());
			detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta.setDatosCliente(this.datosCliente);

			for(DetallePedidoPuntoVenta detallepedidopuntoventa_Desde_PedidoPuntoVenta:detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta.getDetallePedidoPuntoVentas()) {
				detallepedidopuntoventa_Desde_PedidoPuntoVenta.setid_pedido_punto_venta(idPedidoPuntoVentaActual);
			}

			detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta.saveDetallePedidoPuntoVentas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPedidoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PedidoPuntoVentaConstantesFunciones.getClassesForeignKeysOfPedidoPuntoVenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PedidoPuntoVentaConstantesFunciones.getClassesRelationshipsOfPedidoPuntoVenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

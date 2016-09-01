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
import com.bydan.erp.inventario.util.DetallePedidoConstantesFunciones;
import com.bydan.erp.inventario.util.DetallePedidoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetallePedidoParameterGeneral;
import com.bydan.erp.inventario.business.entity.DetallePedido;
import com.bydan.erp.inventario.business.logic.DetallePedidoLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetallePedidoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetallePedidoLogic.class);
	
	protected DetallePedidoDataAccess detallepedidoDataAccess; 	
	protected DetallePedido detallepedido;
	protected List<DetallePedido> detallepedidos;
	protected Object detallepedidoObject;	
	protected List<Object> detallepedidosObject;
	
	public static ClassValidator<DetallePedido> detallepedidoValidator = new ClassValidator<DetallePedido>(DetallePedido.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetallePedidoLogicAdditional detallepedidoLogicAdditional=null;
	
	public DetallePedidoLogicAdditional getDetallePedidoLogicAdditional() {
		return this.detallepedidoLogicAdditional;
	}
	
	public void setDetallePedidoLogicAdditional(DetallePedidoLogicAdditional detallepedidoLogicAdditional) {
		try {
			this.detallepedidoLogicAdditional=detallepedidoLogicAdditional;
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
	
	
	
	
	public  DetallePedidoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detallepedidoDataAccess = new DetallePedidoDataAccess();
			
			this.detallepedidos= new ArrayList<DetallePedido>();
			this.detallepedido= new DetallePedido();
			
			this.detallepedidoObject=new Object();
			this.detallepedidosObject=new ArrayList<Object>();
				
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
			
			this.detallepedidoDataAccess.setConnexionType(this.connexionType);
			this.detallepedidoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetallePedidoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detallepedidoDataAccess = new DetallePedidoDataAccess();
			this.detallepedidos= new ArrayList<DetallePedido>();
			this.detallepedido= new DetallePedido();
			this.detallepedidoObject=new Object();
			this.detallepedidosObject=new ArrayList<Object>();
			
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
			
			this.detallepedidoDataAccess.setConnexionType(this.connexionType);
			this.detallepedidoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetallePedido getDetallePedido() throws Exception {	
		DetallePedidoLogicAdditional.checkDetallePedidoToGet(detallepedido,this.datosCliente,this.arrDatoGeneral);
		DetallePedidoLogicAdditional.updateDetallePedidoToGet(detallepedido,this.arrDatoGeneral);
		
		return detallepedido;
	}
		
	public void setDetallePedido(DetallePedido newDetallePedido) {
		this.detallepedido = newDetallePedido;
	}
	
	public DetallePedidoDataAccess getDetallePedidoDataAccess() {
		return detallepedidoDataAccess;
	}
	
	public void setDetallePedidoDataAccess(DetallePedidoDataAccess newdetallepedidoDataAccess) {
		this.detallepedidoDataAccess = newdetallepedidoDataAccess;
	}
	
	public List<DetallePedido> getDetallePedidos() throws Exception {		
		this.quitarDetallePedidosNulos();
		
		DetallePedidoLogicAdditional.checkDetallePedidoToGets(detallepedidos,this.datosCliente,this.arrDatoGeneral);
		
		for (DetallePedido detallepedidoLocal: detallepedidos ) {
			DetallePedidoLogicAdditional.updateDetallePedidoToGet(detallepedidoLocal,this.arrDatoGeneral);
		}
		
		return detallepedidos;
	}
	
	public void setDetallePedidos(List<DetallePedido> newDetallePedidos) {
		this.detallepedidos = newDetallePedidos;
	}
	
	public Object getDetallePedidoObject() {	
		this.detallepedidoObject=this.detallepedidoDataAccess.getEntityObject();
		return this.detallepedidoObject;
	}
		
	public void setDetallePedidoObject(Object newDetallePedidoObject) {
		this.detallepedidoObject = newDetallePedidoObject;
	}
	
	public List<Object> getDetallePedidosObject() {		
		this.detallepedidosObject=this.detallepedidoDataAccess.getEntitiesObject();
		return this.detallepedidosObject;
	}
		
	public void setDetallePedidosObject(List<Object> newDetallePedidosObject) {
		this.detallepedidosObject = newDetallePedidosObject;
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
		
		if(this.detallepedidoDataAccess!=null) {
			this.detallepedidoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detallepedidoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detallepedidoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detallepedido = new  DetallePedido();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallepedido=detallepedidoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallepedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedido);
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
		detallepedido = new  DetallePedido();
		  		  
        try {
			
			detallepedido=detallepedidoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallepedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detallepedido = new  DetallePedido();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallepedido=detallepedidoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallepedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedido);
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
		detallepedido = new  DetallePedido();
		  		  
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
		detallepedido = new  DetallePedido();
		  		  
        try {
			
			detallepedido=detallepedidoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallepedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detallepedido = new  DetallePedido();
		  		  
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
		detallepedido = new  DetallePedido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detallepedidoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallepedido = new  DetallePedido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detallepedidoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallepedido = new  DetallePedido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detallepedidoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallepedido = new  DetallePedido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detallepedidoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallepedido = new  DetallePedido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detallepedidoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallepedido = new  DetallePedido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detallepedidoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallepedidos = new  ArrayList<DetallePedido>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidos=detallepedidoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedido(detallepedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
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
		detallepedidos = new  ArrayList<DetallePedido>();
		  		  
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
		detallepedidos = new  ArrayList<DetallePedido>();
		  		  
        try {			
			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidos=detallepedidoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetallePedido(detallepedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detallepedidos = new  ArrayList<DetallePedido>();
		  		  
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
		detallepedidos = new  ArrayList<DetallePedido>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidos=detallepedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedido(detallepedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
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
		detallepedidos = new  ArrayList<DetallePedido>();
		  		  
        try {
			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidos=detallepedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedido(detallepedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
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
		detallepedidos = new  ArrayList<DetallePedido>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidos=detallepedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePedido(detallepedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
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
		detallepedidos = new  ArrayList<DetallePedido>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidos=detallepedidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePedido(detallepedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detallepedido = new  DetallePedido();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedido=detallepedidoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePedido(detallepedido);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedido);
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
		detallepedido = new  DetallePedido();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedido=detallepedidoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePedido(detallepedido);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallepedidos = new  ArrayList<DetallePedido>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidos=detallepedidoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedido(detallepedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
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
		detallepedidos = new  ArrayList<DetallePedido>();
		  		  
        try {
			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidos=detallepedidoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedido(detallepedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetallePedidosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detallepedidos = new  ArrayList<DetallePedido>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getTodosDetallePedidosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetallePedido(detallepedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
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
	
	public  void  getTodosDetallePedidos(String sFinalQuery,Pagination pagination)throws Exception {
		detallepedidos = new  ArrayList<DetallePedido>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetallePedido(detallepedidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetallePedido(DetallePedido detallepedido) throws Exception {
		Boolean estaValidado=false;
		
		if(detallepedido.getIsNew() || detallepedido.getIsChanged()) { 
			this.invalidValues = detallepedidoValidator.getInvalidValues(detallepedido);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detallepedido);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetallePedido(List<DetallePedido> DetallePedidos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetallePedido detallepedidoLocal:detallepedidos) {				
			estaValidadoObjeto=this.validarGuardarDetallePedido(detallepedidoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetallePedido(List<DetallePedido> DetallePedidos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetallePedido(detallepedidos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetallePedido(DetallePedido DetallePedido) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetallePedido(detallepedido)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetallePedido detallepedido) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detallepedido.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetallePedidoConstantesFunciones.getDetallePedidoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detallepedido","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetallePedidoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetallePedidoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetallePedidoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-saveDetallePedidoWithConnection");connexion.begin();			
			
			DetallePedidoLogicAdditional.checkDetallePedidoToSave(this.detallepedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetallePedidoLogicAdditional.updateDetallePedidoToSave(this.detallepedido,this.arrDatoGeneral);
			
			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallepedido,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetallePedido();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetallePedido(this.detallepedido)) {
				DetallePedidoDataAccess.save(this.detallepedido, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detallepedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetallePedidoLogicAdditional.checkDetallePedidoToSaveAfter(this.detallepedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetallePedido();
			
			connexion.commit();			
			
			if(this.detallepedido.getIsDeleted()) {
				this.detallepedido=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetallePedido()throws Exception {	
		try {	
			
			DetallePedidoLogicAdditional.checkDetallePedidoToSave(this.detallepedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetallePedidoLogicAdditional.updateDetallePedidoToSave(this.detallepedido,this.arrDatoGeneral);
			
			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallepedido,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetallePedido(this.detallepedido)) {			
				DetallePedidoDataAccess.save(this.detallepedido, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detallepedido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetallePedidoLogicAdditional.checkDetallePedidoToSaveAfter(this.detallepedido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detallepedido.getIsDeleted()) {
				this.detallepedido=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetallePedidosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-saveDetallePedidosWithConnection");connexion.begin();			
			
			DetallePedidoLogicAdditional.checkDetallePedidoToSaves(detallepedidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetallePedidos();
			
			Boolean validadoTodosDetallePedido=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetallePedido detallepedidoLocal:detallepedidos) {		
				if(detallepedidoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetallePedidoLogicAdditional.updateDetallePedidoToSave(detallepedidoLocal,this.arrDatoGeneral);
	        	
				DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallepedidoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetallePedido(detallepedidoLocal)) {
					DetallePedidoDataAccess.save(detallepedidoLocal, connexion);				
				} else {
					validadoTodosDetallePedido=false;
				}
			}
			
			if(!validadoTodosDetallePedido) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetallePedidoLogicAdditional.checkDetallePedidoToSavesAfter(detallepedidos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetallePedidos();
			
			connexion.commit();		
			
			this.quitarDetallePedidosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetallePedidos()throws Exception {				
		 try {	
			DetallePedidoLogicAdditional.checkDetallePedidoToSaves(detallepedidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetallePedido=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetallePedido detallepedidoLocal:detallepedidos) {				
				if(detallepedidoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetallePedidoLogicAdditional.updateDetallePedidoToSave(detallepedidoLocal,this.arrDatoGeneral);
	        	
				DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallepedidoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetallePedido(detallepedidoLocal)) {				
					DetallePedidoDataAccess.save(detallepedidoLocal, connexion);				
				} else {
					validadoTodosDetallePedido=false;
				}
			}
			
			if(!validadoTodosDetallePedido) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetallePedidoLogicAdditional.checkDetallePedidoToSavesAfter(detallepedidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetallePedidosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetallePedidoParameterReturnGeneral procesarAccionDetallePedidos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetallePedido> detallepedidos,DetallePedidoParameterReturnGeneral detallepedidoParameterGeneral)throws Exception {
		 try {	
			DetallePedidoParameterReturnGeneral detallepedidoReturnGeneral=new DetallePedidoParameterReturnGeneral();
	
			DetallePedidoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallepedidos,detallepedidoParameterGeneral,detallepedidoReturnGeneral);
			
			return detallepedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetallePedidoParameterReturnGeneral procesarAccionDetallePedidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetallePedido> detallepedidos,DetallePedidoParameterReturnGeneral detallepedidoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-procesarAccionDetallePedidosWithConnection");connexion.begin();			
			
			DetallePedidoParameterReturnGeneral detallepedidoReturnGeneral=new DetallePedidoParameterReturnGeneral();
	
			DetallePedidoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallepedidos,detallepedidoParameterGeneral,detallepedidoReturnGeneral);
			
			this.connexion.commit();
			
			return detallepedidoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetallePedidoParameterReturnGeneral procesarEventosDetallePedidos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetallePedido> detallepedidos,DetallePedido detallepedido,DetallePedidoParameterReturnGeneral detallepedidoParameterGeneral,Boolean isEsNuevoDetallePedido,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetallePedidoParameterReturnGeneral detallepedidoReturnGeneral=new DetallePedidoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallepedidoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetallePedidoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallepedidos,detallepedido,detallepedidoParameterGeneral,detallepedidoReturnGeneral,isEsNuevoDetallePedido,clases);
			
			return detallepedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetallePedidoParameterReturnGeneral procesarEventosDetallePedidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetallePedido> detallepedidos,DetallePedido detallepedido,DetallePedidoParameterReturnGeneral detallepedidoParameterGeneral,Boolean isEsNuevoDetallePedido,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-procesarEventosDetallePedidosWithConnection");connexion.begin();			
			
			DetallePedidoParameterReturnGeneral detallepedidoReturnGeneral=new DetallePedidoParameterReturnGeneral();
	
			detallepedidoReturnGeneral.setDetallePedido(detallepedido);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallepedidoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetallePedidoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallepedidos,detallepedido,detallepedidoParameterGeneral,detallepedidoReturnGeneral,isEsNuevoDetallePedido,clases);
			
			this.connexion.commit();
			
			return detallepedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetallePedidoParameterReturnGeneral procesarImportacionDetallePedidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetallePedidoParameterReturnGeneral detallepedidoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-procesarImportacionDetallePedidosWithConnection");connexion.begin();			
			
			DetallePedidoParameterReturnGeneral detallepedidoReturnGeneral=new DetallePedidoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detallepedidos=new ArrayList<DetallePedido>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detallepedido=new DetallePedido();
				
				
				if(conColumnasBase) {this.detallepedido.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detallepedido.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detallepedido.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.detallepedido.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedido.setdescuento_porcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedido.setdescuento_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedido.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedido.setice(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedido.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.detallepedidos.add(this.detallepedido);
			}
			
			this.saveDetallePedidos();
			
			this.connexion.commit();
			
			detallepedidoReturnGeneral.setConRetornoEstaProcesado(true);
			detallepedidoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detallepedidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetallePedidosEliminados() throws Exception {				
		
		List<DetallePedido> detallepedidosAux= new ArrayList<DetallePedido>();
		
		for(DetallePedido detallepedido:detallepedidos) {
			if(!detallepedido.getIsDeleted()) {
				detallepedidosAux.add(detallepedido);
			}
		}
		
		detallepedidos=detallepedidosAux;
	}
	
	public void quitarDetallePedidosNulos() throws Exception {				
		
		List<DetallePedido> detallepedidosAux= new ArrayList<DetallePedido>();
		
		for(DetallePedido detallepedido : this.detallepedidos) {
			if(detallepedido==null) {
				detallepedidosAux.add(detallepedido);
			}
		}
		
		//this.detallepedidos=detallepedidosAux;
		
		this.detallepedidos.removeAll(detallepedidosAux);
	}
	
	public void getSetVersionRowDetallePedidoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detallepedido.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detallepedido.getIsDeleted() || (detallepedido.getIsChanged()&&!detallepedido.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detallepedidoDataAccess.getSetVersionRowDetallePedido(connexion,detallepedido.getId());
				
				if(!detallepedido.getVersionRow().equals(timestamp)) {	
					detallepedido.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detallepedido.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetallePedido()throws Exception {	
		
		if(detallepedido.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detallepedido.getIsDeleted() || (detallepedido.getIsChanged()&&!detallepedido.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detallepedidoDataAccess.getSetVersionRowDetallePedido(connexion,detallepedido.getId());
			
			try {							
				if(!detallepedido.getVersionRow().equals(timestamp)) {	
					detallepedido.setVersionRow(timestamp);
				}
				
				detallepedido.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetallePedidosWithConnection()throws Exception {	
		if(detallepedidos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetallePedido detallepedidoAux:detallepedidos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detallepedidoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallepedidoAux.getIsDeleted() || (detallepedidoAux.getIsChanged()&&!detallepedidoAux.getIsNew())) {
						
						timestamp=detallepedidoDataAccess.getSetVersionRowDetallePedido(connexion,detallepedidoAux.getId());
						
						if(!detallepedido.getVersionRow().equals(timestamp)) {	
							detallepedidoAux.setVersionRow(timestamp);
						}
								
						detallepedidoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetallePedidos()throws Exception {	
		if(detallepedidos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetallePedido detallepedidoAux:detallepedidos) {
					if(detallepedidoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallepedidoAux.getIsDeleted() || (detallepedidoAux.getIsChanged()&&!detallepedidoAux.getIsNew())) {
						
						timestamp=detallepedidoDataAccess.getSetVersionRowDetallePedido(connexion,detallepedidoAux.getId());
						
						if(!detallepedidoAux.getVersionRow().equals(timestamp)) {	
							detallepedidoAux.setVersionRow(timestamp);
						}
						
													
						detallepedidoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetallePedidoParameterReturnGeneral cargarCombosLoteForeignKeyDetallePedidoWithConnection(String finalQueryGlobalPedido,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalProducto,String finalQueryGlobalBodega,String finalQueryGlobalUnidad,String finalQueryGlobalEstadoDetallePedido) throws Exception {
		DetallePedidoParameterReturnGeneral  detallepedidoReturnGeneral =new DetallePedidoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetallePedidoWithConnection");connexion.begin();
			
			detallepedidoReturnGeneral =new DetallePedidoParameterReturnGeneral();
			
			

			List<Pedido> pedidosForeignKey=new ArrayList<Pedido>();
			PedidoLogic pedidoLogic=new PedidoLogic();
			pedidoLogic.setConnexion(this.connexion);
			pedidoLogic.getPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPedido.equals("NONE")) {
				pedidoLogic.getTodosPedidos(finalQueryGlobalPedido,new Pagination());
				pedidosForeignKey=pedidoLogic.getPedidos();
			}

			detallepedidoReturnGeneral.setpedidosForeignKey(pedidosForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallepedidoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallepedidoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallepedidoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallepedidoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallepedidoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallepedidoReturnGeneral.setmessForeignKey(messForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallepedidoReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallepedidoReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallepedidoReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<EstadoDetallePedido> estadodetallepedidosForeignKey=new ArrayList<EstadoDetallePedido>();
			EstadoDetallePedidoLogic estadodetallepedidoLogic=new EstadoDetallePedidoLogic();
			estadodetallepedidoLogic.setConnexion(this.connexion);
			estadodetallepedidoLogic.getEstadoDetallePedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetallePedido.equals("NONE")) {
				estadodetallepedidoLogic.getTodosEstadoDetallePedidos(finalQueryGlobalEstadoDetallePedido,new Pagination());
				estadodetallepedidosForeignKey=estadodetallepedidoLogic.getEstadoDetallePedidos();
			}

			detallepedidoReturnGeneral.setestadodetallepedidosForeignKey(estadodetallepedidosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detallepedidoReturnGeneral;
	}
	
	public DetallePedidoParameterReturnGeneral cargarCombosLoteForeignKeyDetallePedido(String finalQueryGlobalPedido,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalProducto,String finalQueryGlobalBodega,String finalQueryGlobalUnidad,String finalQueryGlobalEstadoDetallePedido) throws Exception {
		DetallePedidoParameterReturnGeneral  detallepedidoReturnGeneral =new DetallePedidoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detallepedidoReturnGeneral =new DetallePedidoParameterReturnGeneral();
			
			

			List<Pedido> pedidosForeignKey=new ArrayList<Pedido>();
			PedidoLogic pedidoLogic=new PedidoLogic();
			pedidoLogic.setConnexion(this.connexion);
			pedidoLogic.getPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPedido.equals("NONE")) {
				pedidoLogic.getTodosPedidos(finalQueryGlobalPedido,new Pagination());
				pedidosForeignKey=pedidoLogic.getPedidos();
			}

			detallepedidoReturnGeneral.setpedidosForeignKey(pedidosForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallepedidoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallepedidoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallepedidoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallepedidoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallepedidoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallepedidoReturnGeneral.setmessForeignKey(messForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallepedidoReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallepedidoReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallepedidoReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<EstadoDetallePedido> estadodetallepedidosForeignKey=new ArrayList<EstadoDetallePedido>();
			EstadoDetallePedidoLogic estadodetallepedidoLogic=new EstadoDetallePedidoLogic();
			estadodetallepedidoLogic.setConnexion(this.connexion);
			estadodetallepedidoLogic.getEstadoDetallePedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetallePedido.equals("NONE")) {
				estadodetallepedidoLogic.getTodosEstadoDetallePedidos(finalQueryGlobalEstadoDetallePedido,new Pagination());
				estadodetallepedidosForeignKey=estadodetallepedidoLogic.getEstadoDetallePedidos();
			}

			detallepedidoReturnGeneral.setestadodetallepedidosForeignKey(estadodetallepedidosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detallepedidoReturnGeneral;
	}
	
	
	public void deepLoad(DetallePedido detallepedido,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetallePedidoLogicAdditional.updateDetallePedidoToGet(detallepedido,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallepedido.setPedido(detallepedidoDataAccess.getPedido(connexion,detallepedido));
		detallepedido.setEmpresa(detallepedidoDataAccess.getEmpresa(connexion,detallepedido));
		detallepedido.setSucursal(detallepedidoDataAccess.getSucursal(connexion,detallepedido));
		detallepedido.setEjercicio(detallepedidoDataAccess.getEjercicio(connexion,detallepedido));
		detallepedido.setPeriodo(detallepedidoDataAccess.getPeriodo(connexion,detallepedido));
		detallepedido.setAnio(detallepedidoDataAccess.getAnio(connexion,detallepedido));
		detallepedido.setMes(detallepedidoDataAccess.getMes(connexion,detallepedido));
		detallepedido.setProducto(detallepedidoDataAccess.getProducto(connexion,detallepedido));
		detallepedido.setBodega(detallepedidoDataAccess.getBodega(connexion,detallepedido));
		detallepedido.setUnidad(detallepedidoDataAccess.getUnidad(connexion,detallepedido));
		detallepedido.setEstadoDetallePedido(detallepedidoDataAccess.getEstadoDetallePedido(connexion,detallepedido));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pedido.class)) {
				detallepedido.setPedido(detallepedidoDataAccess.getPedido(connexion,detallepedido));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallepedido.setEmpresa(detallepedidoDataAccess.getEmpresa(connexion,detallepedido));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallepedido.setSucursal(detallepedidoDataAccess.getSucursal(connexion,detallepedido));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallepedido.setEjercicio(detallepedidoDataAccess.getEjercicio(connexion,detallepedido));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallepedido.setPeriodo(detallepedidoDataAccess.getPeriodo(connexion,detallepedido));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallepedido.setAnio(detallepedidoDataAccess.getAnio(connexion,detallepedido));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallepedido.setMes(detallepedidoDataAccess.getMes(connexion,detallepedido));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallepedido.setProducto(detallepedidoDataAccess.getProducto(connexion,detallepedido));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallepedido.setBodega(detallepedidoDataAccess.getBodega(connexion,detallepedido));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallepedido.setUnidad(detallepedidoDataAccess.getUnidad(connexion,detallepedido));
				continue;
			}

			if(clas.clas.equals(EstadoDetallePedido.class)) {
				detallepedido.setEstadoDetallePedido(detallepedidoDataAccess.getEstadoDetallePedido(connexion,detallepedido));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setPedido(detallepedidoDataAccess.getPedido(connexion,detallepedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setEmpresa(detallepedidoDataAccess.getEmpresa(connexion,detallepedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setSucursal(detallepedidoDataAccess.getSucursal(connexion,detallepedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setEjercicio(detallepedidoDataAccess.getEjercicio(connexion,detallepedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setPeriodo(detallepedidoDataAccess.getPeriodo(connexion,detallepedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setAnio(detallepedidoDataAccess.getAnio(connexion,detallepedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setMes(detallepedidoDataAccess.getMes(connexion,detallepedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setProducto(detallepedidoDataAccess.getProducto(connexion,detallepedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setBodega(detallepedidoDataAccess.getBodega(connexion,detallepedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setUnidad(detallepedidoDataAccess.getUnidad(connexion,detallepedido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetallePedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setEstadoDetallePedido(detallepedidoDataAccess.getEstadoDetallePedido(connexion,detallepedido));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallepedido.setPedido(detallepedidoDataAccess.getPedido(connexion,detallepedido));
		PedidoLogic pedidoLogic= new PedidoLogic(connexion);
		pedidoLogic.deepLoad(detallepedido.getPedido(),isDeep,deepLoadType,clases);
				
		detallepedido.setEmpresa(detallepedidoDataAccess.getEmpresa(connexion,detallepedido));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallepedido.getEmpresa(),isDeep,deepLoadType,clases);
				
		detallepedido.setSucursal(detallepedidoDataAccess.getSucursal(connexion,detallepedido));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallepedido.getSucursal(),isDeep,deepLoadType,clases);
				
		detallepedido.setEjercicio(detallepedidoDataAccess.getEjercicio(connexion,detallepedido));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallepedido.getEjercicio(),isDeep,deepLoadType,clases);
				
		detallepedido.setPeriodo(detallepedidoDataAccess.getPeriodo(connexion,detallepedido));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallepedido.getPeriodo(),isDeep,deepLoadType,clases);
				
		detallepedido.setAnio(detallepedidoDataAccess.getAnio(connexion,detallepedido));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallepedido.getAnio(),isDeep,deepLoadType,clases);
				
		detallepedido.setMes(detallepedidoDataAccess.getMes(connexion,detallepedido));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallepedido.getMes(),isDeep,deepLoadType,clases);
				
		detallepedido.setProducto(detallepedidoDataAccess.getProducto(connexion,detallepedido));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallepedido.getProducto(),isDeep,deepLoadType,clases);
				
		detallepedido.setBodega(detallepedidoDataAccess.getBodega(connexion,detallepedido));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallepedido.getBodega(),isDeep,deepLoadType,clases);
				
		detallepedido.setUnidad(detallepedidoDataAccess.getUnidad(connexion,detallepedido));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallepedido.getUnidad(),isDeep,deepLoadType,clases);
				
		detallepedido.setEstadoDetallePedido(detallepedidoDataAccess.getEstadoDetallePedido(connexion,detallepedido));
		EstadoDetallePedidoLogic estadodetallepedidoLogic= new EstadoDetallePedidoLogic(connexion);
		estadodetallepedidoLogic.deepLoad(detallepedido.getEstadoDetallePedido(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pedido.class)) {
				detallepedido.setPedido(detallepedidoDataAccess.getPedido(connexion,detallepedido));
				PedidoLogic pedidoLogic= new PedidoLogic(connexion);
				pedidoLogic.deepLoad(detallepedido.getPedido(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallepedido.setEmpresa(detallepedidoDataAccess.getEmpresa(connexion,detallepedido));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detallepedido.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallepedido.setSucursal(detallepedidoDataAccess.getSucursal(connexion,detallepedido));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detallepedido.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallepedido.setEjercicio(detallepedidoDataAccess.getEjercicio(connexion,detallepedido));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detallepedido.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallepedido.setPeriodo(detallepedidoDataAccess.getPeriodo(connexion,detallepedido));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detallepedido.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallepedido.setAnio(detallepedidoDataAccess.getAnio(connexion,detallepedido));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detallepedido.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallepedido.setMes(detallepedidoDataAccess.getMes(connexion,detallepedido));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detallepedido.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallepedido.setProducto(detallepedidoDataAccess.getProducto(connexion,detallepedido));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detallepedido.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallepedido.setBodega(detallepedidoDataAccess.getBodega(connexion,detallepedido));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detallepedido.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallepedido.setUnidad(detallepedidoDataAccess.getUnidad(connexion,detallepedido));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detallepedido.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetallePedido.class)) {
				detallepedido.setEstadoDetallePedido(detallepedidoDataAccess.getEstadoDetallePedido(connexion,detallepedido));
				EstadoDetallePedidoLogic estadodetallepedidoLogic= new EstadoDetallePedidoLogic(connexion);
				estadodetallepedidoLogic.deepLoad(detallepedido.getEstadoDetallePedido(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setPedido(detallepedidoDataAccess.getPedido(connexion,detallepedido));
			PedidoLogic pedidoLogic= new PedidoLogic(connexion);
			pedidoLogic.deepLoad(detallepedido.getPedido(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setEmpresa(detallepedidoDataAccess.getEmpresa(connexion,detallepedido));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detallepedido.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setSucursal(detallepedidoDataAccess.getSucursal(connexion,detallepedido));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detallepedido.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setEjercicio(detallepedidoDataAccess.getEjercicio(connexion,detallepedido));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detallepedido.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setPeriodo(detallepedidoDataAccess.getPeriodo(connexion,detallepedido));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detallepedido.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setAnio(detallepedidoDataAccess.getAnio(connexion,detallepedido));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detallepedido.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setMes(detallepedidoDataAccess.getMes(connexion,detallepedido));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detallepedido.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setProducto(detallepedidoDataAccess.getProducto(connexion,detallepedido));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detallepedido.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setBodega(detallepedidoDataAccess.getBodega(connexion,detallepedido));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detallepedido.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setUnidad(detallepedidoDataAccess.getUnidad(connexion,detallepedido));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detallepedido.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetallePedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedido.setEstadoDetallePedido(detallepedidoDataAccess.getEstadoDetallePedido(connexion,detallepedido));
			EstadoDetallePedidoLogic estadodetallepedidoLogic= new EstadoDetallePedidoLogic(connexion);
			estadodetallepedidoLogic.deepLoad(detallepedido.getEstadoDetallePedido(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetallePedido detallepedido,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetallePedidoLogicAdditional.updateDetallePedidoToSave(detallepedido,this.arrDatoGeneral);
			
DetallePedidoDataAccess.save(detallepedido, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PedidoDataAccess.save(detallepedido.getPedido(),connexion);

		EmpresaDataAccess.save(detallepedido.getEmpresa(),connexion);

		SucursalDataAccess.save(detallepedido.getSucursal(),connexion);

		EjercicioDataAccess.save(detallepedido.getEjercicio(),connexion);

		PeriodoDataAccess.save(detallepedido.getPeriodo(),connexion);

		AnioDataAccess.save(detallepedido.getAnio(),connexion);

		MesDataAccess.save(detallepedido.getMes(),connexion);

		ProductoDataAccess.save(detallepedido.getProducto(),connexion);

		BodegaDataAccess.save(detallepedido.getBodega(),connexion);

		UnidadDataAccess.save(detallepedido.getUnidad(),connexion);

		EstadoDetallePedidoDataAccess.save(detallepedido.getEstadoDetallePedido(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pedido.class)) {
				PedidoDataAccess.save(detallepedido.getPedido(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallepedido.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallepedido.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallepedido.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallepedido.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallepedido.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallepedido.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallepedido.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallepedido.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallepedido.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoDetallePedido.class)) {
				EstadoDetallePedidoDataAccess.save(detallepedido.getEstadoDetallePedido(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PedidoDataAccess.save(detallepedido.getPedido(),connexion);
		PedidoLogic pedidoLogic= new PedidoLogic(connexion);
		pedidoLogic.deepLoad(detallepedido.getPedido(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(detallepedido.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallepedido.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detallepedido.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallepedido.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detallepedido.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallepedido.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detallepedido.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallepedido.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detallepedido.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallepedido.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detallepedido.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallepedido.getMes(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detallepedido.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallepedido.getProducto(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detallepedido.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallepedido.getBodega(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detallepedido.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallepedido.getUnidad(),isDeep,deepLoadType,clases);
				

		EstadoDetallePedidoDataAccess.save(detallepedido.getEstadoDetallePedido(),connexion);
		EstadoDetallePedidoLogic estadodetallepedidoLogic= new EstadoDetallePedidoLogic(connexion);
		estadodetallepedidoLogic.deepLoad(detallepedido.getEstadoDetallePedido(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pedido.class)) {
				PedidoDataAccess.save(detallepedido.getPedido(),connexion);
				PedidoLogic pedidoLogic= new PedidoLogic(connexion);
				pedidoLogic.deepSave(detallepedido.getPedido(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallepedido.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detallepedido.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallepedido.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detallepedido.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallepedido.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detallepedido.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallepedido.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detallepedido.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallepedido.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detallepedido.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallepedido.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detallepedido.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallepedido.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detallepedido.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallepedido.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detallepedido.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallepedido.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detallepedido.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetallePedido.class)) {
				EstadoDetallePedidoDataAccess.save(detallepedido.getEstadoDetallePedido(),connexion);
				EstadoDetallePedidoLogic estadodetallepedidoLogic= new EstadoDetallePedidoLogic(connexion);
				estadodetallepedidoLogic.deepSave(detallepedido.getEstadoDetallePedido(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetallePedido.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detallepedido,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(detallepedido);
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
			this.deepLoad(this.detallepedido,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetallePedido.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detallepedidos!=null) {
				for(DetallePedido detallepedido:detallepedidos) {
					this.deepLoad(detallepedido,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(detallepedidos);
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
			if(detallepedidos!=null) {
				for(DetallePedido detallepedido:detallepedidos) {
					this.deepLoad(detallepedido,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(detallepedidos);
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
			this.getNewConnexionToDeep(DetallePedido.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detallepedido,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetallePedido.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detallepedidos!=null) {
				for(DetallePedido detallepedido:detallepedidos) {
					this.deepSave(detallepedido,isDeep,deepLoadType,clases);
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
			if(detallepedidos!=null) {
				for(DetallePedido detallepedido:detallepedidos) {
					this.deepSave(detallepedido,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetallePedidosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetallePedidoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetallePedidoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidosFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetallePedidoConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidosFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetallePedidoConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetallePedidoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetallePedidoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetallePedidoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetallePedidoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidosFK_IdEstadoDetallePedidoWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_detalle_pedido)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetallePedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetallePedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_pedido,DetallePedidoConstantesFunciones.IDESTADODETALLEPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetallePedido);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetallePedido","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidosFK_IdEstadoDetallePedido(String sFinalQuery,Pagination pagination,Long id_estado_detalle_pedido)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetallePedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetallePedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_pedido,DetallePedidoConstantesFunciones.IDESTADODETALLEPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetallePedido);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetallePedido","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetallePedidoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetallePedidoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidosFK_IdPedidoWithConnection(String sFinalQuery,Pagination pagination,Long id_pedido)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pedido,DetallePedidoConstantesFunciones.IDPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPedido);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPedido","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidosFK_IdPedido(String sFinalQuery,Pagination pagination,Long id_pedido)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pedido,DetallePedidoConstantesFunciones.IDPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPedido);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPedido","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidosFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetallePedidoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidosFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetallePedidoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidosFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetallePedidoConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidosFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetallePedidoConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetallePedidoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetallePedidoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidosFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetallePedidoConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidosFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetallePedidoConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetallePedidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedido(this.detallepedidos);
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
			if(DetallePedidoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePedidoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetallePedido detallepedido,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetallePedidoConstantesFunciones.ISCONAUDITORIA) {
				if(detallepedido.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePedidoDataAccess.TABLENAME, detallepedido.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetallePedidoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetallePedidoLogic.registrarAuditoriaDetallesDetallePedido(connexion,detallepedido,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detallepedido.getIsDeleted()) {
					/*if(!detallepedido.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetallePedidoDataAccess.TABLENAME, detallepedido.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetallePedidoLogic.registrarAuditoriaDetallesDetallePedido(connexion,detallepedido,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePedidoDataAccess.TABLENAME, detallepedido.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detallepedido.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePedidoDataAccess.TABLENAME, detallepedido.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetallePedidoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetallePedidoLogic.registrarAuditoriaDetallesDetallePedido(connexion,detallepedido,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetallePedido(Connexion connexion,DetallePedido detallepedido)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detallepedido.getIsNew()||!detallepedido.getid_pedido().equals(detallepedido.getDetallePedidoOriginal().getid_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedido.getDetallePedidoOriginal().getid_pedido()!=null)
				{
					strValorActual=detallepedido.getDetallePedidoOriginal().getid_pedido().toString();
				}
				if(detallepedido.getid_pedido()!=null)
				{
					strValorNuevo=detallepedido.getid_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoConstantesFunciones.IDPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedido.getIsNew()||!detallepedido.getid_empresa().equals(detallepedido.getDetallePedidoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedido.getDetallePedidoOriginal().getid_empresa()!=null)
				{
					strValorActual=detallepedido.getDetallePedidoOriginal().getid_empresa().toString();
				}
				if(detallepedido.getid_empresa()!=null)
				{
					strValorNuevo=detallepedido.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detallepedido.getIsNew()||!detallepedido.getid_sucursal().equals(detallepedido.getDetallePedidoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedido.getDetallePedidoOriginal().getid_sucursal()!=null)
				{
					strValorActual=detallepedido.getDetallePedidoOriginal().getid_sucursal().toString();
				}
				if(detallepedido.getid_sucursal()!=null)
				{
					strValorNuevo=detallepedido.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detallepedido.getIsNew()||!detallepedido.getid_ejercicio().equals(detallepedido.getDetallePedidoOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedido.getDetallePedidoOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detallepedido.getDetallePedidoOriginal().getid_ejercicio().toString();
				}
				if(detallepedido.getid_ejercicio()!=null)
				{
					strValorNuevo=detallepedido.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedido.getIsNew()||!detallepedido.getid_periodo().equals(detallepedido.getDetallePedidoOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedido.getDetallePedidoOriginal().getid_periodo()!=null)
				{
					strValorActual=detallepedido.getDetallePedidoOriginal().getid_periodo().toString();
				}
				if(detallepedido.getid_periodo()!=null)
				{
					strValorNuevo=detallepedido.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedido.getIsNew()||!detallepedido.getid_anio().equals(detallepedido.getDetallePedidoOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedido.getDetallePedidoOriginal().getid_anio()!=null)
				{
					strValorActual=detallepedido.getDetallePedidoOriginal().getid_anio().toString();
				}
				if(detallepedido.getid_anio()!=null)
				{
					strValorNuevo=detallepedido.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedido.getIsNew()||!detallepedido.getid_mes().equals(detallepedido.getDetallePedidoOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedido.getDetallePedidoOriginal().getid_mes()!=null)
				{
					strValorActual=detallepedido.getDetallePedidoOriginal().getid_mes().toString();
				}
				if(detallepedido.getid_mes()!=null)
				{
					strValorNuevo=detallepedido.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(detallepedido.getIsNew()||!detallepedido.getid_producto().equals(detallepedido.getDetallePedidoOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedido.getDetallePedidoOriginal().getid_producto()!=null)
				{
					strValorActual=detallepedido.getDetallePedidoOriginal().getid_producto().toString();
				}
				if(detallepedido.getid_producto()!=null)
				{
					strValorNuevo=detallepedido.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedido.getIsNew()||!detallepedido.getid_bodega().equals(detallepedido.getDetallePedidoOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedido.getDetallePedidoOriginal().getid_bodega()!=null)
				{
					strValorActual=detallepedido.getDetallePedidoOriginal().getid_bodega().toString();
				}
				if(detallepedido.getid_bodega()!=null)
				{
					strValorNuevo=detallepedido.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detallepedido.getIsNew()||!detallepedido.getid_unidad().equals(detallepedido.getDetallePedidoOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedido.getDetallePedidoOriginal().getid_unidad()!=null)
				{
					strValorActual=detallepedido.getDetallePedidoOriginal().getid_unidad().toString();
				}
				if(detallepedido.getid_unidad()!=null)
				{
					strValorNuevo=detallepedido.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallepedido.getIsNew()||!detallepedido.getid_estado_detalle_pedido().equals(detallepedido.getDetallePedidoOriginal().getid_estado_detalle_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedido.getDetallePedidoOriginal().getid_estado_detalle_pedido()!=null)
				{
					strValorActual=detallepedido.getDetallePedidoOriginal().getid_estado_detalle_pedido().toString();
				}
				if(detallepedido.getid_estado_detalle_pedido()!=null)
				{
					strValorNuevo=detallepedido.getid_estado_detalle_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoConstantesFunciones.IDESTADODETALLEPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedido.getIsNew()||!detallepedido.getcantidad().equals(detallepedido.getDetallePedidoOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedido.getDetallePedidoOriginal().getcantidad()!=null)
				{
					strValorActual=detallepedido.getDetallePedidoOriginal().getcantidad().toString();
				}
				if(detallepedido.getcantidad()!=null)
				{
					strValorNuevo=detallepedido.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallepedido.getIsNew()||!detallepedido.getprecio().equals(detallepedido.getDetallePedidoOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedido.getDetallePedidoOriginal().getprecio()!=null)
				{
					strValorActual=detallepedido.getDetallePedidoOriginal().getprecio().toString();
				}
				if(detallepedido.getprecio()!=null)
				{
					strValorNuevo=detallepedido.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedido.getIsNew()||!detallepedido.getdescuento_porcentaje().equals(detallepedido.getDetallePedidoOriginal().getdescuento_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedido.getDetallePedidoOriginal().getdescuento_porcentaje()!=null)
				{
					strValorActual=detallepedido.getDetallePedidoOriginal().getdescuento_porcentaje().toString();
				}
				if(detallepedido.getdescuento_porcentaje()!=null)
				{
					strValorNuevo=detallepedido.getdescuento_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoConstantesFunciones.DESCUENTOPORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(detallepedido.getIsNew()||!detallepedido.getdescuento_valor().equals(detallepedido.getDetallePedidoOriginal().getdescuento_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedido.getDetallePedidoOriginal().getdescuento_valor()!=null)
				{
					strValorActual=detallepedido.getDetallePedidoOriginal().getdescuento_valor().toString();
				}
				if(detallepedido.getdescuento_valor()!=null)
				{
					strValorNuevo=detallepedido.getdescuento_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoConstantesFunciones.DESCUENTOVALOR,strValorActual,strValorNuevo);
			}	
			
			if(detallepedido.getIsNew()||!detallepedido.getiva().equals(detallepedido.getDetallePedidoOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedido.getDetallePedidoOriginal().getiva()!=null)
				{
					strValorActual=detallepedido.getDetallePedidoOriginal().getiva().toString();
				}
				if(detallepedido.getiva()!=null)
				{
					strValorNuevo=detallepedido.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(detallepedido.getIsNew()||!detallepedido.getice().equals(detallepedido.getDetallePedidoOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedido.getDetallePedidoOriginal().getice()!=null)
				{
					strValorActual=detallepedido.getDetallePedidoOriginal().getice().toString();
				}
				if(detallepedido.getice()!=null)
				{
					strValorNuevo=detallepedido.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(detallepedido.getIsNew()||!detallepedido.gettotal().equals(detallepedido.getDetallePedidoOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedido.getDetallePedidoOriginal().gettotal()!=null)
				{
					strValorActual=detallepedido.getDetallePedidoOriginal().gettotal().toString();
				}
				if(detallepedido.gettotal()!=null)
				{
					strValorNuevo=detallepedido.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detallepedido.getIsNew()||!detallepedido.getcosto().equals(detallepedido.getDetallePedidoOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedido.getDetallePedidoOriginal().getcosto()!=null)
				{
					strValorActual=detallepedido.getDetallePedidoOriginal().getcosto().toString();
				}
				if(detallepedido.getcosto()!=null)
				{
					strValorNuevo=detallepedido.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedido.getIsNew()||!detallepedido.getutilidad().equals(detallepedido.getDetallePedidoOriginal().getutilidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedido.getDetallePedidoOriginal().getutilidad()!=null)
				{
					strValorActual=detallepedido.getDetallePedidoOriginal().getutilidad().toString();
				}
				if(detallepedido.getutilidad()!=null)
				{
					strValorNuevo=detallepedido.getutilidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoConstantesFunciones.UTILIDAD,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetallePedidoRelacionesWithConnection(DetallePedido detallepedido) throws Exception {

		if(!detallepedido.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetallePedidoRelacionesBase(detallepedido,true);
		}
	}

	public void saveDetallePedidoRelaciones(DetallePedido detallepedido)throws Exception {

		if(!detallepedido.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetallePedidoRelacionesBase(detallepedido,false);
		}
	}

	public void saveDetallePedidoRelacionesBase(DetallePedido detallepedido,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetallePedido-saveRelacionesWithConnection");}
	

			this.setDetallePedido(detallepedido);

			if(DetallePedidoLogicAdditional.validarSaveRelaciones(detallepedido,this)) {

				DetallePedidoLogicAdditional.updateRelacionesToSave(detallepedido,this);

				if((detallepedido.getIsNew()||detallepedido.getIsChanged())&&!detallepedido.getIsDeleted()) {
					this.saveDetallePedido();
					this.saveDetallePedidoRelacionesDetalles();

				} else if(detallepedido.getIsDeleted()) {
					this.saveDetallePedidoRelacionesDetalles();
					this.saveDetallePedido();
				}

				DetallePedidoLogicAdditional.updateRelacionesToSaveAfter(detallepedido,this);

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
	
	
	private void saveDetallePedidoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetallePedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetallePedidoConstantesFunciones.getClassesForeignKeysOfDetallePedido(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetallePedidoConstantesFunciones.getClassesRelationshipsOfDetallePedido(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

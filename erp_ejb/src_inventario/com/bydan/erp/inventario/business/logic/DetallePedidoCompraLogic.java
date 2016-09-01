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
import com.bydan.erp.inventario.util.DetallePedidoCompraConstantesFunciones;
import com.bydan.erp.inventario.util.DetallePedidoCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetallePedidoCompraParameterGeneral;
import com.bydan.erp.inventario.business.entity.DetallePedidoCompra;
import com.bydan.erp.inventario.business.logic.DetallePedidoCompraLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetallePedidoCompraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetallePedidoCompraLogic.class);
	
	protected DetallePedidoCompraDataAccess detallepedidocompraDataAccess; 	
	protected DetallePedidoCompra detallepedidocompra;
	protected List<DetallePedidoCompra> detallepedidocompras;
	protected Object detallepedidocompraObject;	
	protected List<Object> detallepedidocomprasObject;
	
	public static ClassValidator<DetallePedidoCompra> detallepedidocompraValidator = new ClassValidator<DetallePedidoCompra>(DetallePedidoCompra.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetallePedidoCompraLogicAdditional detallepedidocompraLogicAdditional=null;
	
	public DetallePedidoCompraLogicAdditional getDetallePedidoCompraLogicAdditional() {
		return this.detallepedidocompraLogicAdditional;
	}
	
	public void setDetallePedidoCompraLogicAdditional(DetallePedidoCompraLogicAdditional detallepedidocompraLogicAdditional) {
		try {
			this.detallepedidocompraLogicAdditional=detallepedidocompraLogicAdditional;
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
	
	
	
	
	public  DetallePedidoCompraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detallepedidocompraDataAccess = new DetallePedidoCompraDataAccess();
			
			this.detallepedidocompras= new ArrayList<DetallePedidoCompra>();
			this.detallepedidocompra= new DetallePedidoCompra();
			
			this.detallepedidocompraObject=new Object();
			this.detallepedidocomprasObject=new ArrayList<Object>();
				
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
			
			this.detallepedidocompraDataAccess.setConnexionType(this.connexionType);
			this.detallepedidocompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetallePedidoCompraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detallepedidocompraDataAccess = new DetallePedidoCompraDataAccess();
			this.detallepedidocompras= new ArrayList<DetallePedidoCompra>();
			this.detallepedidocompra= new DetallePedidoCompra();
			this.detallepedidocompraObject=new Object();
			this.detallepedidocomprasObject=new ArrayList<Object>();
			
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
			
			this.detallepedidocompraDataAccess.setConnexionType(this.connexionType);
			this.detallepedidocompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetallePedidoCompra getDetallePedidoCompra() throws Exception {	
		DetallePedidoCompraLogicAdditional.checkDetallePedidoCompraToGet(detallepedidocompra,this.datosCliente,this.arrDatoGeneral);
		DetallePedidoCompraLogicAdditional.updateDetallePedidoCompraToGet(detallepedidocompra,this.arrDatoGeneral);
		
		return detallepedidocompra;
	}
		
	public void setDetallePedidoCompra(DetallePedidoCompra newDetallePedidoCompra) {
		this.detallepedidocompra = newDetallePedidoCompra;
	}
	
	public DetallePedidoCompraDataAccess getDetallePedidoCompraDataAccess() {
		return detallepedidocompraDataAccess;
	}
	
	public void setDetallePedidoCompraDataAccess(DetallePedidoCompraDataAccess newdetallepedidocompraDataAccess) {
		this.detallepedidocompraDataAccess = newdetallepedidocompraDataAccess;
	}
	
	public List<DetallePedidoCompra> getDetallePedidoCompras() throws Exception {		
		this.quitarDetallePedidoComprasNulos();
		
		DetallePedidoCompraLogicAdditional.checkDetallePedidoCompraToGets(detallepedidocompras,this.datosCliente,this.arrDatoGeneral);
		
		for (DetallePedidoCompra detallepedidocompraLocal: detallepedidocompras ) {
			DetallePedidoCompraLogicAdditional.updateDetallePedidoCompraToGet(detallepedidocompraLocal,this.arrDatoGeneral);
		}
		
		return detallepedidocompras;
	}
	
	public void setDetallePedidoCompras(List<DetallePedidoCompra> newDetallePedidoCompras) {
		this.detallepedidocompras = newDetallePedidoCompras;
	}
	
	public Object getDetallePedidoCompraObject() {	
		this.detallepedidocompraObject=this.detallepedidocompraDataAccess.getEntityObject();
		return this.detallepedidocompraObject;
	}
		
	public void setDetallePedidoCompraObject(Object newDetallePedidoCompraObject) {
		this.detallepedidocompraObject = newDetallePedidoCompraObject;
	}
	
	public List<Object> getDetallePedidoComprasObject() {		
		this.detallepedidocomprasObject=this.detallepedidocompraDataAccess.getEntitiesObject();
		return this.detallepedidocomprasObject;
	}
		
	public void setDetallePedidoComprasObject(List<Object> newDetallePedidoComprasObject) {
		this.detallepedidocomprasObject = newDetallePedidoComprasObject;
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
		
		if(this.detallepedidocompraDataAccess!=null) {
			this.detallepedidocompraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detallepedidocompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detallepedidocompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detallepedidocompra = new  DetallePedidoCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallepedidocompra=detallepedidocompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallepedidocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompra);
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
		detallepedidocompra = new  DetallePedidoCompra();
		  		  
        try {
			
			detallepedidocompra=detallepedidocompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallepedidocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detallepedidocompra = new  DetallePedidoCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallepedidocompra=detallepedidocompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallepedidocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompra);
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
		detallepedidocompra = new  DetallePedidoCompra();
		  		  
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
		detallepedidocompra = new  DetallePedidoCompra();
		  		  
        try {
			
			detallepedidocompra=detallepedidocompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallepedidocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detallepedidocompra = new  DetallePedidoCompra();
		  		  
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
		detallepedidocompra = new  DetallePedidoCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detallepedidocompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallepedidocompra = new  DetallePedidoCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detallepedidocompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallepedidocompra = new  DetallePedidoCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detallepedidocompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallepedidocompra = new  DetallePedidoCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detallepedidocompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallepedidocompra = new  DetallePedidoCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detallepedidocompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallepedidocompra = new  DetallePedidoCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detallepedidocompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallepedidocompras = new  ArrayList<DetallePedidoCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedidoCompra(detallepedidocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
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
		detallepedidocompras = new  ArrayList<DetallePedidoCompra>();
		  		  
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
		detallepedidocompras = new  ArrayList<DetallePedidoCompra>();
		  		  
        try {			
			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetallePedidoCompra(detallepedidocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detallepedidocompras = new  ArrayList<DetallePedidoCompra>();
		  		  
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
		detallepedidocompras = new  ArrayList<DetallePedidoCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedidoCompra(detallepedidocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
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
		detallepedidocompras = new  ArrayList<DetallePedidoCompra>();
		  		  
        try {
			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedidoCompra(detallepedidocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
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
		detallepedidocompras = new  ArrayList<DetallePedidoCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePedidoCompra(detallepedidocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
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
		detallepedidocompras = new  ArrayList<DetallePedidoCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePedidoCompra(detallepedidocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detallepedidocompra = new  DetallePedidoCompra();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompra=detallepedidocompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePedidoCompra(detallepedidocompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompra);
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
		detallepedidocompra = new  DetallePedidoCompra();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompra=detallepedidocompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePedidoCompra(detallepedidocompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallepedidocompras = new  ArrayList<DetallePedidoCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompras=detallepedidocompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedidoCompra(detallepedidocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
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
		detallepedidocompras = new  ArrayList<DetallePedidoCompra>();
		  		  
        try {
			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompras=detallepedidocompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedidoCompra(detallepedidocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetallePedidoComprasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detallepedidocompras = new  ArrayList<DetallePedidoCompra>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getTodosDetallePedidoComprasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetallePedidoCompra(detallepedidocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
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
	
	public  void  getTodosDetallePedidoCompras(String sFinalQuery,Pagination pagination)throws Exception {
		detallepedidocompras = new  ArrayList<DetallePedidoCompra>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetallePedidoCompra(detallepedidocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetallePedidoCompra(DetallePedidoCompra detallepedidocompra) throws Exception {
		Boolean estaValidado=false;
		
		if(detallepedidocompra.getIsNew() || detallepedidocompra.getIsChanged()) { 
			this.invalidValues = detallepedidocompraValidator.getInvalidValues(detallepedidocompra);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detallepedidocompra);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetallePedidoCompra(List<DetallePedidoCompra> DetallePedidoCompras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetallePedidoCompra detallepedidocompraLocal:detallepedidocompras) {				
			estaValidadoObjeto=this.validarGuardarDetallePedidoCompra(detallepedidocompraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetallePedidoCompra(List<DetallePedidoCompra> DetallePedidoCompras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetallePedidoCompra(detallepedidocompras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetallePedidoCompra(DetallePedidoCompra DetallePedidoCompra) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetallePedidoCompra(detallepedidocompra)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetallePedidoCompra detallepedidocompra) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detallepedidocompra.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetallePedidoCompraConstantesFunciones.getDetallePedidoCompraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detallepedidocompra","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetallePedidoCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetallePedidoCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetallePedidoCompraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-saveDetallePedidoCompraWithConnection");connexion.begin();			
			
			DetallePedidoCompraLogicAdditional.checkDetallePedidoCompraToSave(this.detallepedidocompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetallePedidoCompraLogicAdditional.updateDetallePedidoCompraToSave(this.detallepedidocompra,this.arrDatoGeneral);
			
			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallepedidocompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetallePedidoCompra();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetallePedidoCompra(this.detallepedidocompra)) {
				DetallePedidoCompraDataAccess.save(this.detallepedidocompra, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detallepedidocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetallePedidoCompraLogicAdditional.checkDetallePedidoCompraToSaveAfter(this.detallepedidocompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetallePedidoCompra();
			
			connexion.commit();			
			
			if(this.detallepedidocompra.getIsDeleted()) {
				this.detallepedidocompra=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetallePedidoCompra()throws Exception {	
		try {	
			
			DetallePedidoCompraLogicAdditional.checkDetallePedidoCompraToSave(this.detallepedidocompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetallePedidoCompraLogicAdditional.updateDetallePedidoCompraToSave(this.detallepedidocompra,this.arrDatoGeneral);
			
			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallepedidocompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetallePedidoCompra(this.detallepedidocompra)) {			
				DetallePedidoCompraDataAccess.save(this.detallepedidocompra, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detallepedidocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetallePedidoCompraLogicAdditional.checkDetallePedidoCompraToSaveAfter(this.detallepedidocompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detallepedidocompra.getIsDeleted()) {
				this.detallepedidocompra=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetallePedidoComprasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-saveDetallePedidoComprasWithConnection");connexion.begin();			
			
			DetallePedidoCompraLogicAdditional.checkDetallePedidoCompraToSaves(detallepedidocompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetallePedidoCompras();
			
			Boolean validadoTodosDetallePedidoCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetallePedidoCompra detallepedidocompraLocal:detallepedidocompras) {		
				if(detallepedidocompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetallePedidoCompraLogicAdditional.updateDetallePedidoCompraToSave(detallepedidocompraLocal,this.arrDatoGeneral);
	        	
				DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallepedidocompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetallePedidoCompra(detallepedidocompraLocal)) {
					DetallePedidoCompraDataAccess.save(detallepedidocompraLocal, connexion);				
				} else {
					validadoTodosDetallePedidoCompra=false;
				}
			}
			
			if(!validadoTodosDetallePedidoCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetallePedidoCompraLogicAdditional.checkDetallePedidoCompraToSavesAfter(detallepedidocompras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetallePedidoCompras();
			
			connexion.commit();		
			
			this.quitarDetallePedidoComprasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetallePedidoCompras()throws Exception {				
		 try {	
			DetallePedidoCompraLogicAdditional.checkDetallePedidoCompraToSaves(detallepedidocompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetallePedidoCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetallePedidoCompra detallepedidocompraLocal:detallepedidocompras) {				
				if(detallepedidocompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetallePedidoCompraLogicAdditional.updateDetallePedidoCompraToSave(detallepedidocompraLocal,this.arrDatoGeneral);
	        	
				DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallepedidocompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetallePedidoCompra(detallepedidocompraLocal)) {				
					DetallePedidoCompraDataAccess.save(detallepedidocompraLocal, connexion);				
				} else {
					validadoTodosDetallePedidoCompra=false;
				}
			}
			
			if(!validadoTodosDetallePedidoCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetallePedidoCompraLogicAdditional.checkDetallePedidoCompraToSavesAfter(detallepedidocompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetallePedidoComprasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetallePedidoCompraParameterReturnGeneral procesarAccionDetallePedidoCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetallePedidoCompra> detallepedidocompras,DetallePedidoCompraParameterReturnGeneral detallepedidocompraParameterGeneral)throws Exception {
		 try {	
			DetallePedidoCompraParameterReturnGeneral detallepedidocompraReturnGeneral=new DetallePedidoCompraParameterReturnGeneral();
	
			DetallePedidoCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallepedidocompras,detallepedidocompraParameterGeneral,detallepedidocompraReturnGeneral);
			
			return detallepedidocompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetallePedidoCompraParameterReturnGeneral procesarAccionDetallePedidoComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetallePedidoCompra> detallepedidocompras,DetallePedidoCompraParameterReturnGeneral detallepedidocompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-procesarAccionDetallePedidoComprasWithConnection");connexion.begin();			
			
			DetallePedidoCompraParameterReturnGeneral detallepedidocompraReturnGeneral=new DetallePedidoCompraParameterReturnGeneral();
	
			DetallePedidoCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallepedidocompras,detallepedidocompraParameterGeneral,detallepedidocompraReturnGeneral);
			
			this.connexion.commit();
			
			return detallepedidocompraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetallePedidoCompraParameterReturnGeneral procesarEventosDetallePedidoCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetallePedidoCompra> detallepedidocompras,DetallePedidoCompra detallepedidocompra,DetallePedidoCompraParameterReturnGeneral detallepedidocompraParameterGeneral,Boolean isEsNuevoDetallePedidoCompra,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetallePedidoCompraParameterReturnGeneral detallepedidocompraReturnGeneral=new DetallePedidoCompraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallepedidocompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetallePedidoCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallepedidocompras,detallepedidocompra,detallepedidocompraParameterGeneral,detallepedidocompraReturnGeneral,isEsNuevoDetallePedidoCompra,clases);
			
			return detallepedidocompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetallePedidoCompraParameterReturnGeneral procesarEventosDetallePedidoComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetallePedidoCompra> detallepedidocompras,DetallePedidoCompra detallepedidocompra,DetallePedidoCompraParameterReturnGeneral detallepedidocompraParameterGeneral,Boolean isEsNuevoDetallePedidoCompra,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-procesarEventosDetallePedidoComprasWithConnection");connexion.begin();			
			
			DetallePedidoCompraParameterReturnGeneral detallepedidocompraReturnGeneral=new DetallePedidoCompraParameterReturnGeneral();
	
			detallepedidocompraReturnGeneral.setDetallePedidoCompra(detallepedidocompra);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallepedidocompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetallePedidoCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallepedidocompras,detallepedidocompra,detallepedidocompraParameterGeneral,detallepedidocompraReturnGeneral,isEsNuevoDetallePedidoCompra,clases);
			
			this.connexion.commit();
			
			return detallepedidocompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetallePedidoCompraParameterReturnGeneral procesarImportacionDetallePedidoComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetallePedidoCompraParameterReturnGeneral detallepedidocompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-procesarImportacionDetallePedidoComprasWithConnection");connexion.begin();			
			
			DetallePedidoCompraParameterReturnGeneral detallepedidocompraReturnGeneral=new DetallePedidoCompraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detallepedidocompras=new ArrayList<DetallePedidoCompra>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detallepedidocompra=new DetallePedidoCompra();
				
				
				if(conColumnasBase) {this.detallepedidocompra.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detallepedidocompra.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detallepedidocompra.setcantidad_pedido(Integer.parseInt(arrColumnas[iColumn++]));
				this.detallepedidocompra.setcosto_unitario(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidocompra.setcosto_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidocompra.setdescripcion(arrColumnas[iColumn++]);
				this.detallepedidocompra.setcantidad_entregada(Integer.parseInt(arrColumnas[iColumn++]));
				this.detallepedidocompra.setcantidad_pendiente(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.detallepedidocompras.add(this.detallepedidocompra);
			}
			
			this.saveDetallePedidoCompras();
			
			this.connexion.commit();
			
			detallepedidocompraReturnGeneral.setConRetornoEstaProcesado(true);
			detallepedidocompraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detallepedidocompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetallePedidoComprasEliminados() throws Exception {				
		
		List<DetallePedidoCompra> detallepedidocomprasAux= new ArrayList<DetallePedidoCompra>();
		
		for(DetallePedidoCompra detallepedidocompra:detallepedidocompras) {
			if(!detallepedidocompra.getIsDeleted()) {
				detallepedidocomprasAux.add(detallepedidocompra);
			}
		}
		
		detallepedidocompras=detallepedidocomprasAux;
	}
	
	public void quitarDetallePedidoComprasNulos() throws Exception {				
		
		List<DetallePedidoCompra> detallepedidocomprasAux= new ArrayList<DetallePedidoCompra>();
		
		for(DetallePedidoCompra detallepedidocompra : this.detallepedidocompras) {
			if(detallepedidocompra==null) {
				detallepedidocomprasAux.add(detallepedidocompra);
			}
		}
		
		//this.detallepedidocompras=detallepedidocomprasAux;
		
		this.detallepedidocompras.removeAll(detallepedidocomprasAux);
	}
	
	public void getSetVersionRowDetallePedidoCompraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detallepedidocompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detallepedidocompra.getIsDeleted() || (detallepedidocompra.getIsChanged()&&!detallepedidocompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detallepedidocompraDataAccess.getSetVersionRowDetallePedidoCompra(connexion,detallepedidocompra.getId());
				
				if(!detallepedidocompra.getVersionRow().equals(timestamp)) {	
					detallepedidocompra.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detallepedidocompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetallePedidoCompra()throws Exception {	
		
		if(detallepedidocompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detallepedidocompra.getIsDeleted() || (detallepedidocompra.getIsChanged()&&!detallepedidocompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detallepedidocompraDataAccess.getSetVersionRowDetallePedidoCompra(connexion,detallepedidocompra.getId());
			
			try {							
				if(!detallepedidocompra.getVersionRow().equals(timestamp)) {	
					detallepedidocompra.setVersionRow(timestamp);
				}
				
				detallepedidocompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetallePedidoComprasWithConnection()throws Exception {	
		if(detallepedidocompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetallePedidoCompra detallepedidocompraAux:detallepedidocompras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detallepedidocompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallepedidocompraAux.getIsDeleted() || (detallepedidocompraAux.getIsChanged()&&!detallepedidocompraAux.getIsNew())) {
						
						timestamp=detallepedidocompraDataAccess.getSetVersionRowDetallePedidoCompra(connexion,detallepedidocompraAux.getId());
						
						if(!detallepedidocompra.getVersionRow().equals(timestamp)) {	
							detallepedidocompraAux.setVersionRow(timestamp);
						}
								
						detallepedidocompraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetallePedidoCompras()throws Exception {	
		if(detallepedidocompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetallePedidoCompra detallepedidocompraAux:detallepedidocompras) {
					if(detallepedidocompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallepedidocompraAux.getIsDeleted() || (detallepedidocompraAux.getIsChanged()&&!detallepedidocompraAux.getIsNew())) {
						
						timestamp=detallepedidocompraDataAccess.getSetVersionRowDetallePedidoCompra(connexion,detallepedidocompraAux.getId());
						
						if(!detallepedidocompraAux.getVersionRow().equals(timestamp)) {	
							detallepedidocompraAux.setVersionRow(timestamp);
						}
						
													
						detallepedidocompraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetallePedidoCompraParameterReturnGeneral cargarCombosLoteForeignKeyDetallePedidoCompraWithConnection(String finalQueryGlobalPedidoCompra,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalCentroCosto) throws Exception {
		DetallePedidoCompraParameterReturnGeneral  detallepedidocompraReturnGeneral =new DetallePedidoCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetallePedidoCompraWithConnection");connexion.begin();
			
			detallepedidocompraReturnGeneral =new DetallePedidoCompraParameterReturnGeneral();
			
			

			List<PedidoCompra> pedidocomprasForeignKey=new ArrayList<PedidoCompra>();
			PedidoCompraLogic pedidocompraLogic=new PedidoCompraLogic();
			pedidocompraLogic.setConnexion(this.connexion);
			pedidocompraLogic.getPedidoCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPedidoCompra.equals("NONE")) {
				pedidocompraLogic.getTodosPedidoCompras(finalQueryGlobalPedidoCompra,new Pagination());
				pedidocomprasForeignKey=pedidocompraLogic.getPedidoCompras();
			}

			detallepedidocompraReturnGeneral.setpedidocomprasForeignKey(pedidocomprasForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallepedidocompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallepedidocompraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallepedidocompraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallepedidocompraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallepedidocompraReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallepedidocompraReturnGeneral.setmessForeignKey(messForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallepedidocompraReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallepedidocompraReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallepedidocompraReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detallepedidocompraReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detallepedidocompraReturnGeneral;
	}
	
	public DetallePedidoCompraParameterReturnGeneral cargarCombosLoteForeignKeyDetallePedidoCompra(String finalQueryGlobalPedidoCompra,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalCentroCosto) throws Exception {
		DetallePedidoCompraParameterReturnGeneral  detallepedidocompraReturnGeneral =new DetallePedidoCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detallepedidocompraReturnGeneral =new DetallePedidoCompraParameterReturnGeneral();
			
			

			List<PedidoCompra> pedidocomprasForeignKey=new ArrayList<PedidoCompra>();
			PedidoCompraLogic pedidocompraLogic=new PedidoCompraLogic();
			pedidocompraLogic.setConnexion(this.connexion);
			pedidocompraLogic.getPedidoCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPedidoCompra.equals("NONE")) {
				pedidocompraLogic.getTodosPedidoCompras(finalQueryGlobalPedidoCompra,new Pagination());
				pedidocomprasForeignKey=pedidocompraLogic.getPedidoCompras();
			}

			detallepedidocompraReturnGeneral.setpedidocomprasForeignKey(pedidocomprasForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallepedidocompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallepedidocompraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallepedidocompraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallepedidocompraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallepedidocompraReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallepedidocompraReturnGeneral.setmessForeignKey(messForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallepedidocompraReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallepedidocompraReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallepedidocompraReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detallepedidocompraReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detallepedidocompraReturnGeneral;
	}
	
	
	public void deepLoad(DetallePedidoCompra detallepedidocompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetallePedidoCompraLogicAdditional.updateDetallePedidoCompraToGet(detallepedidocompra,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallepedidocompra.setPedidoCompra(detallepedidocompraDataAccess.getPedidoCompra(connexion,detallepedidocompra));
		detallepedidocompra.setEmpresa(detallepedidocompraDataAccess.getEmpresa(connexion,detallepedidocompra));
		detallepedidocompra.setSucursal(detallepedidocompraDataAccess.getSucursal(connexion,detallepedidocompra));
		detallepedidocompra.setEjercicio(detallepedidocompraDataAccess.getEjercicio(connexion,detallepedidocompra));
		detallepedidocompra.setPeriodo(detallepedidocompraDataAccess.getPeriodo(connexion,detallepedidocompra));
		detallepedidocompra.setAnio(detallepedidocompraDataAccess.getAnio(connexion,detallepedidocompra));
		detallepedidocompra.setMes(detallepedidocompraDataAccess.getMes(connexion,detallepedidocompra));
		detallepedidocompra.setBodega(detallepedidocompraDataAccess.getBodega(connexion,detallepedidocompra));
		detallepedidocompra.setProducto(detallepedidocompraDataAccess.getProducto(connexion,detallepedidocompra));
		detallepedidocompra.setUnidad(detallepedidocompraDataAccess.getUnidad(connexion,detallepedidocompra));
		detallepedidocompra.setCentroCosto(detallepedidocompraDataAccess.getCentroCosto(connexion,detallepedidocompra));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompra.class)) {
				detallepedidocompra.setPedidoCompra(detallepedidocompraDataAccess.getPedidoCompra(connexion,detallepedidocompra));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallepedidocompra.setEmpresa(detallepedidocompraDataAccess.getEmpresa(connexion,detallepedidocompra));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallepedidocompra.setSucursal(detallepedidocompraDataAccess.getSucursal(connexion,detallepedidocompra));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallepedidocompra.setEjercicio(detallepedidocompraDataAccess.getEjercicio(connexion,detallepedidocompra));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallepedidocompra.setPeriodo(detallepedidocompraDataAccess.getPeriodo(connexion,detallepedidocompra));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallepedidocompra.setAnio(detallepedidocompraDataAccess.getAnio(connexion,detallepedidocompra));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallepedidocompra.setMes(detallepedidocompraDataAccess.getMes(connexion,detallepedidocompra));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallepedidocompra.setBodega(detallepedidocompraDataAccess.getBodega(connexion,detallepedidocompra));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallepedidocompra.setProducto(detallepedidocompraDataAccess.getProducto(connexion,detallepedidocompra));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallepedidocompra.setUnidad(detallepedidocompraDataAccess.getUnidad(connexion,detallepedidocompra));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detallepedidocompra.setCentroCosto(detallepedidocompraDataAccess.getCentroCosto(connexion,detallepedidocompra));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setPedidoCompra(detallepedidocompraDataAccess.getPedidoCompra(connexion,detallepedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setEmpresa(detallepedidocompraDataAccess.getEmpresa(connexion,detallepedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setSucursal(detallepedidocompraDataAccess.getSucursal(connexion,detallepedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setEjercicio(detallepedidocompraDataAccess.getEjercicio(connexion,detallepedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setPeriodo(detallepedidocompraDataAccess.getPeriodo(connexion,detallepedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setAnio(detallepedidocompraDataAccess.getAnio(connexion,detallepedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setMes(detallepedidocompraDataAccess.getMes(connexion,detallepedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setBodega(detallepedidocompraDataAccess.getBodega(connexion,detallepedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setProducto(detallepedidocompraDataAccess.getProducto(connexion,detallepedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setUnidad(detallepedidocompraDataAccess.getUnidad(connexion,detallepedidocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setCentroCosto(detallepedidocompraDataAccess.getCentroCosto(connexion,detallepedidocompra));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallepedidocompra.setPedidoCompra(detallepedidocompraDataAccess.getPedidoCompra(connexion,detallepedidocompra));
		PedidoCompraLogic pedidocompraLogic= new PedidoCompraLogic(connexion);
		pedidocompraLogic.deepLoad(detallepedidocompra.getPedidoCompra(),isDeep,deepLoadType,clases);
				
		detallepedidocompra.setEmpresa(detallepedidocompraDataAccess.getEmpresa(connexion,detallepedidocompra));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallepedidocompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		detallepedidocompra.setSucursal(detallepedidocompraDataAccess.getSucursal(connexion,detallepedidocompra));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallepedidocompra.getSucursal(),isDeep,deepLoadType,clases);
				
		detallepedidocompra.setEjercicio(detallepedidocompraDataAccess.getEjercicio(connexion,detallepedidocompra));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallepedidocompra.getEjercicio(),isDeep,deepLoadType,clases);
				
		detallepedidocompra.setPeriodo(detallepedidocompraDataAccess.getPeriodo(connexion,detallepedidocompra));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallepedidocompra.getPeriodo(),isDeep,deepLoadType,clases);
				
		detallepedidocompra.setAnio(detallepedidocompraDataAccess.getAnio(connexion,detallepedidocompra));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallepedidocompra.getAnio(),isDeep,deepLoadType,clases);
				
		detallepedidocompra.setMes(detallepedidocompraDataAccess.getMes(connexion,detallepedidocompra));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallepedidocompra.getMes(),isDeep,deepLoadType,clases);
				
		detallepedidocompra.setBodega(detallepedidocompraDataAccess.getBodega(connexion,detallepedidocompra));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallepedidocompra.getBodega(),isDeep,deepLoadType,clases);
				
		detallepedidocompra.setProducto(detallepedidocompraDataAccess.getProducto(connexion,detallepedidocompra));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallepedidocompra.getProducto(),isDeep,deepLoadType,clases);
				
		detallepedidocompra.setUnidad(detallepedidocompraDataAccess.getUnidad(connexion,detallepedidocompra));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallepedidocompra.getUnidad(),isDeep,deepLoadType,clases);
				
		detallepedidocompra.setCentroCosto(detallepedidocompraDataAccess.getCentroCosto(connexion,detallepedidocompra));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detallepedidocompra.getCentroCosto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompra.class)) {
				detallepedidocompra.setPedidoCompra(detallepedidocompraDataAccess.getPedidoCompra(connexion,detallepedidocompra));
				PedidoCompraLogic pedidocompraLogic= new PedidoCompraLogic(connexion);
				pedidocompraLogic.deepLoad(detallepedidocompra.getPedidoCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallepedidocompra.setEmpresa(detallepedidocompraDataAccess.getEmpresa(connexion,detallepedidocompra));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detallepedidocompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallepedidocompra.setSucursal(detallepedidocompraDataAccess.getSucursal(connexion,detallepedidocompra));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detallepedidocompra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallepedidocompra.setEjercicio(detallepedidocompraDataAccess.getEjercicio(connexion,detallepedidocompra));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detallepedidocompra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallepedidocompra.setPeriodo(detallepedidocompraDataAccess.getPeriodo(connexion,detallepedidocompra));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detallepedidocompra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallepedidocompra.setAnio(detallepedidocompraDataAccess.getAnio(connexion,detallepedidocompra));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detallepedidocompra.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallepedidocompra.setMes(detallepedidocompraDataAccess.getMes(connexion,detallepedidocompra));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detallepedidocompra.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallepedidocompra.setBodega(detallepedidocompraDataAccess.getBodega(connexion,detallepedidocompra));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detallepedidocompra.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallepedidocompra.setProducto(detallepedidocompraDataAccess.getProducto(connexion,detallepedidocompra));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detallepedidocompra.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallepedidocompra.setUnidad(detallepedidocompraDataAccess.getUnidad(connexion,detallepedidocompra));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detallepedidocompra.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detallepedidocompra.setCentroCosto(detallepedidocompraDataAccess.getCentroCosto(connexion,detallepedidocompra));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(detallepedidocompra.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setPedidoCompra(detallepedidocompraDataAccess.getPedidoCompra(connexion,detallepedidocompra));
			PedidoCompraLogic pedidocompraLogic= new PedidoCompraLogic(connexion);
			pedidocompraLogic.deepLoad(detallepedidocompra.getPedidoCompra(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setEmpresa(detallepedidocompraDataAccess.getEmpresa(connexion,detallepedidocompra));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detallepedidocompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setSucursal(detallepedidocompraDataAccess.getSucursal(connexion,detallepedidocompra));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detallepedidocompra.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setEjercicio(detallepedidocompraDataAccess.getEjercicio(connexion,detallepedidocompra));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detallepedidocompra.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setPeriodo(detallepedidocompraDataAccess.getPeriodo(connexion,detallepedidocompra));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detallepedidocompra.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setAnio(detallepedidocompraDataAccess.getAnio(connexion,detallepedidocompra));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detallepedidocompra.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setMes(detallepedidocompraDataAccess.getMes(connexion,detallepedidocompra));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detallepedidocompra.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setBodega(detallepedidocompraDataAccess.getBodega(connexion,detallepedidocompra));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detallepedidocompra.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setProducto(detallepedidocompraDataAccess.getProducto(connexion,detallepedidocompra));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detallepedidocompra.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setUnidad(detallepedidocompraDataAccess.getUnidad(connexion,detallepedidocompra));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detallepedidocompra.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompra.setCentroCosto(detallepedidocompraDataAccess.getCentroCosto(connexion,detallepedidocompra));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(detallepedidocompra.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetallePedidoCompra detallepedidocompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetallePedidoCompraLogicAdditional.updateDetallePedidoCompraToSave(detallepedidocompra,this.arrDatoGeneral);
			
DetallePedidoCompraDataAccess.save(detallepedidocompra, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PedidoCompraDataAccess.save(detallepedidocompra.getPedidoCompra(),connexion);

		EmpresaDataAccess.save(detallepedidocompra.getEmpresa(),connexion);

		SucursalDataAccess.save(detallepedidocompra.getSucursal(),connexion);

		EjercicioDataAccess.save(detallepedidocompra.getEjercicio(),connexion);

		PeriodoDataAccess.save(detallepedidocompra.getPeriodo(),connexion);

		AnioDataAccess.save(detallepedidocompra.getAnio(),connexion);

		MesDataAccess.save(detallepedidocompra.getMes(),connexion);

		BodegaDataAccess.save(detallepedidocompra.getBodega(),connexion);

		ProductoDataAccess.save(detallepedidocompra.getProducto(),connexion);

		UnidadDataAccess.save(detallepedidocompra.getUnidad(),connexion);

		CentroCostoDataAccess.save(detallepedidocompra.getCentroCosto(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompra.class)) {
				PedidoCompraDataAccess.save(detallepedidocompra.getPedidoCompra(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallepedidocompra.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallepedidocompra.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallepedidocompra.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallepedidocompra.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallepedidocompra.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallepedidocompra.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallepedidocompra.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallepedidocompra.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallepedidocompra.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detallepedidocompra.getCentroCosto(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PedidoCompraDataAccess.save(detallepedidocompra.getPedidoCompra(),connexion);
		PedidoCompraLogic pedidocompraLogic= new PedidoCompraLogic(connexion);
		pedidocompraLogic.deepLoad(detallepedidocompra.getPedidoCompra(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(detallepedidocompra.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallepedidocompra.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detallepedidocompra.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallepedidocompra.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detallepedidocompra.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallepedidocompra.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detallepedidocompra.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallepedidocompra.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detallepedidocompra.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallepedidocompra.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detallepedidocompra.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallepedidocompra.getMes(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detallepedidocompra.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallepedidocompra.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detallepedidocompra.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallepedidocompra.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detallepedidocompra.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallepedidocompra.getUnidad(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(detallepedidocompra.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detallepedidocompra.getCentroCosto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompra.class)) {
				PedidoCompraDataAccess.save(detallepedidocompra.getPedidoCompra(),connexion);
				PedidoCompraLogic pedidocompraLogic= new PedidoCompraLogic(connexion);
				pedidocompraLogic.deepSave(detallepedidocompra.getPedidoCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallepedidocompra.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detallepedidocompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallepedidocompra.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detallepedidocompra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallepedidocompra.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detallepedidocompra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallepedidocompra.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detallepedidocompra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallepedidocompra.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detallepedidocompra.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallepedidocompra.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detallepedidocompra.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallepedidocompra.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detallepedidocompra.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallepedidocompra.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detallepedidocompra.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallepedidocompra.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detallepedidocompra.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detallepedidocompra.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(detallepedidocompra.getCentroCosto(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetallePedidoCompra.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detallepedidocompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(detallepedidocompra);
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
			this.deepLoad(this.detallepedidocompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetallePedidoCompra.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detallepedidocompras!=null) {
				for(DetallePedidoCompra detallepedidocompra:detallepedidocompras) {
					this.deepLoad(detallepedidocompra,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(detallepedidocompras);
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
			if(detallepedidocompras!=null) {
				for(DetallePedidoCompra detallepedidocompra:detallepedidocompras) {
					this.deepLoad(detallepedidocompra,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(detallepedidocompras);
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
			this.getNewConnexionToDeep(DetallePedidoCompra.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detallepedidocompra,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetallePedidoCompra.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detallepedidocompras!=null) {
				for(DetallePedidoCompra detallepedidocompra:detallepedidocompras) {
					this.deepSave(detallepedidocompra,isDeep,deepLoadType,clases);
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
			if(detallepedidocompras!=null) {
				for(DetallePedidoCompra detallepedidocompra:detallepedidocompras) {
					this.deepSave(detallepedidocompra,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetallePedidoComprasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetallePedidoCompraConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoComprasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetallePedidoCompraConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoComprasFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetallePedidoCompraConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoComprasFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetallePedidoCompraConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoComprasFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetallePedidoCompraConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoComprasFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetallePedidoCompraConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoComprasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetallePedidoCompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoComprasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetallePedidoCompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoComprasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetallePedidoCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoComprasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetallePedidoCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoComprasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetallePedidoCompraConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoComprasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetallePedidoCompraConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoComprasFK_IdPedidoCompraWithConnection(String sFinalQuery,Pagination pagination,Long id_pedido_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPedidoCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPedidoCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pedido_compra,DetallePedidoCompraConstantesFunciones.IDPEDIDOCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPedidoCompra);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPedidoCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoComprasFK_IdPedidoCompra(String sFinalQuery,Pagination pagination,Long id_pedido_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPedidoCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPedidoCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pedido_compra,DetallePedidoCompraConstantesFunciones.IDPEDIDOCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPedidoCompra);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPedidoCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoComprasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetallePedidoCompraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoComprasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetallePedidoCompraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoComprasFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetallePedidoCompraConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoComprasFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetallePedidoCompraConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoComprasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetallePedidoCompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoComprasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetallePedidoCompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoComprasFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetallePedidoCompraConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoComprasFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetallePedidoCompraConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetallePedidoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompra(this.detallepedidocompras);
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
			if(DetallePedidoCompraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePedidoCompraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetallePedidoCompra detallepedidocompra,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetallePedidoCompraConstantesFunciones.ISCONAUDITORIA) {
				if(detallepedidocompra.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePedidoCompraDataAccess.TABLENAME, detallepedidocompra.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetallePedidoCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetallePedidoCompraLogic.registrarAuditoriaDetallesDetallePedidoCompra(connexion,detallepedidocompra,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detallepedidocompra.getIsDeleted()) {
					/*if(!detallepedidocompra.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetallePedidoCompraDataAccess.TABLENAME, detallepedidocompra.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetallePedidoCompraLogic.registrarAuditoriaDetallesDetallePedidoCompra(connexion,detallepedidocompra,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePedidoCompraDataAccess.TABLENAME, detallepedidocompra.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detallepedidocompra.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePedidoCompraDataAccess.TABLENAME, detallepedidocompra.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetallePedidoCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetallePedidoCompraLogic.registrarAuditoriaDetallesDetallePedidoCompra(connexion,detallepedidocompra,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetallePedidoCompra(Connexion connexion,DetallePedidoCompra detallepedidocompra)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detallepedidocompra.getIsNew()||!detallepedidocompra.getid_pedido_compra().equals(detallepedidocompra.getDetallePedidoCompraOriginal().getid_pedido_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompra.getDetallePedidoCompraOriginal().getid_pedido_compra()!=null)
				{
					strValorActual=detallepedidocompra.getDetallePedidoCompraOriginal().getid_pedido_compra().toString();
				}
				if(detallepedidocompra.getid_pedido_compra()!=null)
				{
					strValorNuevo=detallepedidocompra.getid_pedido_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraConstantesFunciones.IDPEDIDOCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompra.getIsNew()||!detallepedidocompra.getid_empresa().equals(detallepedidocompra.getDetallePedidoCompraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompra.getDetallePedidoCompraOriginal().getid_empresa()!=null)
				{
					strValorActual=detallepedidocompra.getDetallePedidoCompraOriginal().getid_empresa().toString();
				}
				if(detallepedidocompra.getid_empresa()!=null)
				{
					strValorNuevo=detallepedidocompra.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompra.getIsNew()||!detallepedidocompra.getid_sucursal().equals(detallepedidocompra.getDetallePedidoCompraOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompra.getDetallePedidoCompraOriginal().getid_sucursal()!=null)
				{
					strValorActual=detallepedidocompra.getDetallePedidoCompraOriginal().getid_sucursal().toString();
				}
				if(detallepedidocompra.getid_sucursal()!=null)
				{
					strValorNuevo=detallepedidocompra.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompra.getIsNew()||!detallepedidocompra.getid_ejercicio().equals(detallepedidocompra.getDetallePedidoCompraOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompra.getDetallePedidoCompraOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detallepedidocompra.getDetallePedidoCompraOriginal().getid_ejercicio().toString();
				}
				if(detallepedidocompra.getid_ejercicio()!=null)
				{
					strValorNuevo=detallepedidocompra.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompra.getIsNew()||!detallepedidocompra.getid_periodo().equals(detallepedidocompra.getDetallePedidoCompraOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompra.getDetallePedidoCompraOriginal().getid_periodo()!=null)
				{
					strValorActual=detallepedidocompra.getDetallePedidoCompraOriginal().getid_periodo().toString();
				}
				if(detallepedidocompra.getid_periodo()!=null)
				{
					strValorNuevo=detallepedidocompra.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompra.getIsNew()||!detallepedidocompra.getid_anio().equals(detallepedidocompra.getDetallePedidoCompraOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompra.getDetallePedidoCompraOriginal().getid_anio()!=null)
				{
					strValorActual=detallepedidocompra.getDetallePedidoCompraOriginal().getid_anio().toString();
				}
				if(detallepedidocompra.getid_anio()!=null)
				{
					strValorNuevo=detallepedidocompra.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompra.getIsNew()||!detallepedidocompra.getid_mes().equals(detallepedidocompra.getDetallePedidoCompraOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompra.getDetallePedidoCompraOriginal().getid_mes()!=null)
				{
					strValorActual=detallepedidocompra.getDetallePedidoCompraOriginal().getid_mes().toString();
				}
				if(detallepedidocompra.getid_mes()!=null)
				{
					strValorNuevo=detallepedidocompra.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompra.getIsNew()||!detallepedidocompra.getid_bodega().equals(detallepedidocompra.getDetallePedidoCompraOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompra.getDetallePedidoCompraOriginal().getid_bodega()!=null)
				{
					strValorActual=detallepedidocompra.getDetallePedidoCompraOriginal().getid_bodega().toString();
				}
				if(detallepedidocompra.getid_bodega()!=null)
				{
					strValorNuevo=detallepedidocompra.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompra.getIsNew()||!detallepedidocompra.getid_producto().equals(detallepedidocompra.getDetallePedidoCompraOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompra.getDetallePedidoCompraOriginal().getid_producto()!=null)
				{
					strValorActual=detallepedidocompra.getDetallePedidoCompraOriginal().getid_producto().toString();
				}
				if(detallepedidocompra.getid_producto()!=null)
				{
					strValorNuevo=detallepedidocompra.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompra.getIsNew()||!detallepedidocompra.getid_unidad().equals(detallepedidocompra.getDetallePedidoCompraOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompra.getDetallePedidoCompraOriginal().getid_unidad()!=null)
				{
					strValorActual=detallepedidocompra.getDetallePedidoCompraOriginal().getid_unidad().toString();
				}
				if(detallepedidocompra.getid_unidad()!=null)
				{
					strValorNuevo=detallepedidocompra.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompra.getIsNew()||!detallepedidocompra.getid_centro_costo().equals(detallepedidocompra.getDetallePedidoCompraOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompra.getDetallePedidoCompraOriginal().getid_centro_costo()!=null)
				{
					strValorActual=detallepedidocompra.getDetallePedidoCompraOriginal().getid_centro_costo().toString();
				}
				if(detallepedidocompra.getid_centro_costo()!=null)
				{
					strValorNuevo=detallepedidocompra.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompra.getIsNew()||!detallepedidocompra.getcantidad_pedido().equals(detallepedidocompra.getDetallePedidoCompraOriginal().getcantidad_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompra.getDetallePedidoCompraOriginal().getcantidad_pedido()!=null)
				{
					strValorActual=detallepedidocompra.getDetallePedidoCompraOriginal().getcantidad_pedido().toString();
				}
				if(detallepedidocompra.getcantidad_pedido()!=null)
				{
					strValorNuevo=detallepedidocompra.getcantidad_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraConstantesFunciones.CANTIDADPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompra.getIsNew()||!detallepedidocompra.getcosto_unitario().equals(detallepedidocompra.getDetallePedidoCompraOriginal().getcosto_unitario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompra.getDetallePedidoCompraOriginal().getcosto_unitario()!=null)
				{
					strValorActual=detallepedidocompra.getDetallePedidoCompraOriginal().getcosto_unitario().toString();
				}
				if(detallepedidocompra.getcosto_unitario()!=null)
				{
					strValorNuevo=detallepedidocompra.getcosto_unitario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraConstantesFunciones.COSTOUNITARIO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompra.getIsNew()||!detallepedidocompra.getcosto_total().equals(detallepedidocompra.getDetallePedidoCompraOriginal().getcosto_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompra.getDetallePedidoCompraOriginal().getcosto_total()!=null)
				{
					strValorActual=detallepedidocompra.getDetallePedidoCompraOriginal().getcosto_total().toString();
				}
				if(detallepedidocompra.getcosto_total()!=null)
				{
					strValorNuevo=detallepedidocompra.getcosto_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraConstantesFunciones.COSTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompra.getIsNew()||!detallepedidocompra.getdescripcion().equals(detallepedidocompra.getDetallePedidoCompraOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompra.getDetallePedidoCompraOriginal().getdescripcion()!=null)
				{
					strValorActual=detallepedidocompra.getDetallePedidoCompraOriginal().getdescripcion();
				}
				if(detallepedidocompra.getdescripcion()!=null)
				{
					strValorNuevo=detallepedidocompra.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompra.getIsNew()||!detallepedidocompra.getcantidad_entregada().equals(detallepedidocompra.getDetallePedidoCompraOriginal().getcantidad_entregada()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompra.getDetallePedidoCompraOriginal().getcantidad_entregada()!=null)
				{
					strValorActual=detallepedidocompra.getDetallePedidoCompraOriginal().getcantidad_entregada().toString();
				}
				if(detallepedidocompra.getcantidad_entregada()!=null)
				{
					strValorNuevo=detallepedidocompra.getcantidad_entregada().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraConstantesFunciones.CANTIDADENTREGADA,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompra.getIsNew()||!detallepedidocompra.getcantidad_pendiente().equals(detallepedidocompra.getDetallePedidoCompraOriginal().getcantidad_pendiente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompra.getDetallePedidoCompraOriginal().getcantidad_pendiente()!=null)
				{
					strValorActual=detallepedidocompra.getDetallePedidoCompraOriginal().getcantidad_pendiente().toString();
				}
				if(detallepedidocompra.getcantidad_pendiente()!=null)
				{
					strValorNuevo=detallepedidocompra.getcantidad_pendiente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraConstantesFunciones.CANTIDADPENDIENTE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetallePedidoCompraRelacionesWithConnection(DetallePedidoCompra detallepedidocompra) throws Exception {

		if(!detallepedidocompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetallePedidoCompraRelacionesBase(detallepedidocompra,true);
		}
	}

	public void saveDetallePedidoCompraRelaciones(DetallePedidoCompra detallepedidocompra)throws Exception {

		if(!detallepedidocompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetallePedidoCompraRelacionesBase(detallepedidocompra,false);
		}
	}

	public void saveDetallePedidoCompraRelacionesBase(DetallePedidoCompra detallepedidocompra,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetallePedidoCompra-saveRelacionesWithConnection");}
	

			this.setDetallePedidoCompra(detallepedidocompra);

			if(DetallePedidoCompraLogicAdditional.validarSaveRelaciones(detallepedidocompra,this)) {

				DetallePedidoCompraLogicAdditional.updateRelacionesToSave(detallepedidocompra,this);

				if((detallepedidocompra.getIsNew()||detallepedidocompra.getIsChanged())&&!detallepedidocompra.getIsDeleted()) {
					this.saveDetallePedidoCompra();
					this.saveDetallePedidoCompraRelacionesDetalles();

				} else if(detallepedidocompra.getIsDeleted()) {
					this.saveDetallePedidoCompraRelacionesDetalles();
					this.saveDetallePedidoCompra();
				}

				DetallePedidoCompraLogicAdditional.updateRelacionesToSaveAfter(detallepedidocompra,this);

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
	
	
	private void saveDetallePedidoCompraRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetallePedidoCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetallePedidoCompraConstantesFunciones.getClassesForeignKeysOfDetallePedidoCompra(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePedidoCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetallePedidoCompraConstantesFunciones.getClassesRelationshipsOfDetallePedidoCompra(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

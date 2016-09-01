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
import com.bydan.erp.inventario.util.EstadoOrdenCompraConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoOrdenCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoOrdenCompraParameterGeneral;
import com.bydan.erp.inventario.business.entity.EstadoOrdenCompra;
import com.bydan.erp.inventario.business.logic.EstadoOrdenCompraLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.sris.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;








@SuppressWarnings("unused")
public class EstadoOrdenCompraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoOrdenCompraLogic.class);
	
	protected EstadoOrdenCompraDataAccess estadoordencompraDataAccess; 	
	protected EstadoOrdenCompra estadoordencompra;
	protected List<EstadoOrdenCompra> estadoordencompras;
	protected Object estadoordencompraObject;	
	protected List<Object> estadoordencomprasObject;
	
	public static ClassValidator<EstadoOrdenCompra> estadoordencompraValidator = new ClassValidator<EstadoOrdenCompra>(EstadoOrdenCompra.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoOrdenCompraLogicAdditional estadoordencompraLogicAdditional=null;
	
	public EstadoOrdenCompraLogicAdditional getEstadoOrdenCompraLogicAdditional() {
		return this.estadoordencompraLogicAdditional;
	}
	
	public void setEstadoOrdenCompraLogicAdditional(EstadoOrdenCompraLogicAdditional estadoordencompraLogicAdditional) {
		try {
			this.estadoordencompraLogicAdditional=estadoordencompraLogicAdditional;
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
	
	
	
	
	public  EstadoOrdenCompraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadoordencompraDataAccess = new EstadoOrdenCompraDataAccess();
			
			this.estadoordencompras= new ArrayList<EstadoOrdenCompra>();
			this.estadoordencompra= new EstadoOrdenCompra();
			
			this.estadoordencompraObject=new Object();
			this.estadoordencomprasObject=new ArrayList<Object>();
				
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
			
			this.estadoordencompraDataAccess.setConnexionType(this.connexionType);
			this.estadoordencompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoOrdenCompraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadoordencompraDataAccess = new EstadoOrdenCompraDataAccess();
			this.estadoordencompras= new ArrayList<EstadoOrdenCompra>();
			this.estadoordencompra= new EstadoOrdenCompra();
			this.estadoordencompraObject=new Object();
			this.estadoordencomprasObject=new ArrayList<Object>();
			
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
			
			this.estadoordencompraDataAccess.setConnexionType(this.connexionType);
			this.estadoordencompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoOrdenCompra getEstadoOrdenCompra() throws Exception {	
		EstadoOrdenCompraLogicAdditional.checkEstadoOrdenCompraToGet(estadoordencompra,this.datosCliente,this.arrDatoGeneral);
		EstadoOrdenCompraLogicAdditional.updateEstadoOrdenCompraToGet(estadoordencompra,this.arrDatoGeneral);
		
		return estadoordencompra;
	}
		
	public void setEstadoOrdenCompra(EstadoOrdenCompra newEstadoOrdenCompra) {
		this.estadoordencompra = newEstadoOrdenCompra;
	}
	
	public EstadoOrdenCompraDataAccess getEstadoOrdenCompraDataAccess() {
		return estadoordencompraDataAccess;
	}
	
	public void setEstadoOrdenCompraDataAccess(EstadoOrdenCompraDataAccess newestadoordencompraDataAccess) {
		this.estadoordencompraDataAccess = newestadoordencompraDataAccess;
	}
	
	public List<EstadoOrdenCompra> getEstadoOrdenCompras() throws Exception {		
		this.quitarEstadoOrdenComprasNulos();
		
		EstadoOrdenCompraLogicAdditional.checkEstadoOrdenCompraToGets(estadoordencompras,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoOrdenCompra estadoordencompraLocal: estadoordencompras ) {
			EstadoOrdenCompraLogicAdditional.updateEstadoOrdenCompraToGet(estadoordencompraLocal,this.arrDatoGeneral);
		}
		
		return estadoordencompras;
	}
	
	public void setEstadoOrdenCompras(List<EstadoOrdenCompra> newEstadoOrdenCompras) {
		this.estadoordencompras = newEstadoOrdenCompras;
	}
	
	public Object getEstadoOrdenCompraObject() {	
		this.estadoordencompraObject=this.estadoordencompraDataAccess.getEntityObject();
		return this.estadoordencompraObject;
	}
		
	public void setEstadoOrdenCompraObject(Object newEstadoOrdenCompraObject) {
		this.estadoordencompraObject = newEstadoOrdenCompraObject;
	}
	
	public List<Object> getEstadoOrdenComprasObject() {		
		this.estadoordencomprasObject=this.estadoordencompraDataAccess.getEntitiesObject();
		return this.estadoordencomprasObject;
	}
		
	public void setEstadoOrdenComprasObject(List<Object> newEstadoOrdenComprasObject) {
		this.estadoordencomprasObject = newEstadoOrdenComprasObject;
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
		
		if(this.estadoordencompraDataAccess!=null) {
			this.estadoordencompraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenCompra.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadoordencompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadoordencompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadoordencompra = new  EstadoOrdenCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoordencompra=estadoordencompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenCompra(this.estadoordencompra);
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
		estadoordencompra = new  EstadoOrdenCompra();
		  		  
        try {
			
			estadoordencompra=estadoordencompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenCompra(this.estadoordencompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadoordencompra = new  EstadoOrdenCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoordencompra=estadoordencompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenCompra(this.estadoordencompra);
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
		estadoordencompra = new  EstadoOrdenCompra();
		  		  
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
		estadoordencompra = new  EstadoOrdenCompra();
		  		  
        try {
			
			estadoordencompra=estadoordencompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenCompra(this.estadoordencompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadoordencompra = new  EstadoOrdenCompra();
		  		  
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
		estadoordencompra = new  EstadoOrdenCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenCompra.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadoordencompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoordencompra = new  EstadoOrdenCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadoordencompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoordencompra = new  EstadoOrdenCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenCompra.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadoordencompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoordencompra = new  EstadoOrdenCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadoordencompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoordencompra = new  EstadoOrdenCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenCompra.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadoordencompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoordencompra = new  EstadoOrdenCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadoordencompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadoordencompras = new  ArrayList<EstadoOrdenCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordencompras=estadoordencompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoOrdenCompra(estadoordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenCompra(this.estadoordencompras);
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
		estadoordencompras = new  ArrayList<EstadoOrdenCompra>();
		  		  
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
		estadoordencompras = new  ArrayList<EstadoOrdenCompra>();
		  		  
        try {			
			EstadoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordencompras=estadoordencompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoOrdenCompra(estadoordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenCompra(this.estadoordencompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadoordencompras = new  ArrayList<EstadoOrdenCompra>();
		  		  
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
		estadoordencompras = new  ArrayList<EstadoOrdenCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordencompras=estadoordencompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoOrdenCompra(estadoordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenCompra(this.estadoordencompras);
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
		estadoordencompras = new  ArrayList<EstadoOrdenCompra>();
		  		  
        try {
			EstadoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordencompras=estadoordencompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoOrdenCompra(estadoordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenCompra(this.estadoordencompras);
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
		estadoordencompras = new  ArrayList<EstadoOrdenCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordencompras=estadoordencompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoOrdenCompra(estadoordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenCompra(this.estadoordencompras);
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
		estadoordencompras = new  ArrayList<EstadoOrdenCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordencompras=estadoordencompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoOrdenCompra(estadoordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenCompra(this.estadoordencompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadoordencompra = new  EstadoOrdenCompra();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordencompra=estadoordencompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoOrdenCompra(estadoordencompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenCompra(this.estadoordencompra);
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
		estadoordencompra = new  EstadoOrdenCompra();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordencompra=estadoordencompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoOrdenCompra(estadoordencompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenCompra(this.estadoordencompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadoordencompras = new  ArrayList<EstadoOrdenCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenCompra.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordencompras=estadoordencompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoOrdenCompra(estadoordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenCompra(this.estadoordencompras);
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
		estadoordencompras = new  ArrayList<EstadoOrdenCompra>();
		  		  
        try {
			EstadoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordencompras=estadoordencompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoOrdenCompra(estadoordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenCompra(this.estadoordencompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoOrdenComprasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadoordencompras = new  ArrayList<EstadoOrdenCompra>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenCompra.class.getSimpleName()+"-getTodosEstadoOrdenComprasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordencompras=estadoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoOrdenCompra(estadoordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenCompra(this.estadoordencompras);
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
	
	public  void  getTodosEstadoOrdenCompras(String sFinalQuery,Pagination pagination)throws Exception {
		estadoordencompras = new  ArrayList<EstadoOrdenCompra>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordencompras=estadoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoOrdenCompra(estadoordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenCompra(this.estadoordencompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoOrdenCompra(EstadoOrdenCompra estadoordencompra) throws Exception {
		Boolean estaValidado=false;
		
		if(estadoordencompra.getIsNew() || estadoordencompra.getIsChanged()) { 
			this.invalidValues = estadoordencompraValidator.getInvalidValues(estadoordencompra);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadoordencompra);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoOrdenCompra(List<EstadoOrdenCompra> EstadoOrdenCompras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoOrdenCompra estadoordencompraLocal:estadoordencompras) {				
			estaValidadoObjeto=this.validarGuardarEstadoOrdenCompra(estadoordencompraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoOrdenCompra(List<EstadoOrdenCompra> EstadoOrdenCompras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoOrdenCompra(estadoordencompras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoOrdenCompra(EstadoOrdenCompra EstadoOrdenCompra) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoOrdenCompra(estadoordencompra)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoOrdenCompra estadoordencompra) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadoordencompra.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoOrdenCompraConstantesFunciones.getEstadoOrdenCompraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadoordencompra","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoOrdenCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoOrdenCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoOrdenCompraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenCompra.class.getSimpleName()+"-saveEstadoOrdenCompraWithConnection");connexion.begin();			
			
			EstadoOrdenCompraLogicAdditional.checkEstadoOrdenCompraToSave(this.estadoordencompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoOrdenCompraLogicAdditional.updateEstadoOrdenCompraToSave(this.estadoordencompra,this.arrDatoGeneral);
			
			EstadoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoordencompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoOrdenCompra();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoOrdenCompra(this.estadoordencompra)) {
				EstadoOrdenCompraDataAccess.save(this.estadoordencompra, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadoordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoOrdenCompraLogicAdditional.checkEstadoOrdenCompraToSaveAfter(this.estadoordencompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoOrdenCompra();
			
			connexion.commit();			
			
			if(this.estadoordencompra.getIsDeleted()) {
				this.estadoordencompra=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoOrdenCompra()throws Exception {	
		try {	
			
			EstadoOrdenCompraLogicAdditional.checkEstadoOrdenCompraToSave(this.estadoordencompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoOrdenCompraLogicAdditional.updateEstadoOrdenCompraToSave(this.estadoordencompra,this.arrDatoGeneral);
			
			EstadoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoordencompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoOrdenCompra(this.estadoordencompra)) {			
				EstadoOrdenCompraDataAccess.save(this.estadoordencompra, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadoordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoOrdenCompraLogicAdditional.checkEstadoOrdenCompraToSaveAfter(this.estadoordencompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadoordencompra.getIsDeleted()) {
				this.estadoordencompra=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoOrdenComprasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenCompra.class.getSimpleName()+"-saveEstadoOrdenComprasWithConnection");connexion.begin();			
			
			EstadoOrdenCompraLogicAdditional.checkEstadoOrdenCompraToSaves(estadoordencompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoOrdenCompras();
			
			Boolean validadoTodosEstadoOrdenCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoOrdenCompra estadoordencompraLocal:estadoordencompras) {		
				if(estadoordencompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoOrdenCompraLogicAdditional.updateEstadoOrdenCompraToSave(estadoordencompraLocal,this.arrDatoGeneral);
	        	
				EstadoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoordencompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoOrdenCompra(estadoordencompraLocal)) {
					EstadoOrdenCompraDataAccess.save(estadoordencompraLocal, connexion);				
				} else {
					validadoTodosEstadoOrdenCompra=false;
				}
			}
			
			if(!validadoTodosEstadoOrdenCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoOrdenCompraLogicAdditional.checkEstadoOrdenCompraToSavesAfter(estadoordencompras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoOrdenCompras();
			
			connexion.commit();		
			
			this.quitarEstadoOrdenComprasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoOrdenCompras()throws Exception {				
		 try {	
			EstadoOrdenCompraLogicAdditional.checkEstadoOrdenCompraToSaves(estadoordencompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoOrdenCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoOrdenCompra estadoordencompraLocal:estadoordencompras) {				
				if(estadoordencompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoOrdenCompraLogicAdditional.updateEstadoOrdenCompraToSave(estadoordencompraLocal,this.arrDatoGeneral);
	        	
				EstadoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoordencompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoOrdenCompra(estadoordencompraLocal)) {				
					EstadoOrdenCompraDataAccess.save(estadoordencompraLocal, connexion);				
				} else {
					validadoTodosEstadoOrdenCompra=false;
				}
			}
			
			if(!validadoTodosEstadoOrdenCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoOrdenCompraLogicAdditional.checkEstadoOrdenCompraToSavesAfter(estadoordencompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoOrdenComprasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoOrdenCompraParameterReturnGeneral procesarAccionEstadoOrdenCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoOrdenCompra> estadoordencompras,EstadoOrdenCompraParameterReturnGeneral estadoordencompraParameterGeneral)throws Exception {
		 try {	
			EstadoOrdenCompraParameterReturnGeneral estadoordencompraReturnGeneral=new EstadoOrdenCompraParameterReturnGeneral();
	
			EstadoOrdenCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadoordencompras,estadoordencompraParameterGeneral,estadoordencompraReturnGeneral);
			
			return estadoordencompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoOrdenCompraParameterReturnGeneral procesarAccionEstadoOrdenComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoOrdenCompra> estadoordencompras,EstadoOrdenCompraParameterReturnGeneral estadoordencompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenCompra.class.getSimpleName()+"-procesarAccionEstadoOrdenComprasWithConnection");connexion.begin();			
			
			EstadoOrdenCompraParameterReturnGeneral estadoordencompraReturnGeneral=new EstadoOrdenCompraParameterReturnGeneral();
	
			EstadoOrdenCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadoordencompras,estadoordencompraParameterGeneral,estadoordencompraReturnGeneral);
			
			this.connexion.commit();
			
			return estadoordencompraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoOrdenCompraParameterReturnGeneral procesarEventosEstadoOrdenCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoOrdenCompra> estadoordencompras,EstadoOrdenCompra estadoordencompra,EstadoOrdenCompraParameterReturnGeneral estadoordencompraParameterGeneral,Boolean isEsNuevoEstadoOrdenCompra,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoOrdenCompraParameterReturnGeneral estadoordencompraReturnGeneral=new EstadoOrdenCompraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoordencompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoOrdenCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadoordencompras,estadoordencompra,estadoordencompraParameterGeneral,estadoordencompraReturnGeneral,isEsNuevoEstadoOrdenCompra,clases);
			
			return estadoordencompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoOrdenCompraParameterReturnGeneral procesarEventosEstadoOrdenComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoOrdenCompra> estadoordencompras,EstadoOrdenCompra estadoordencompra,EstadoOrdenCompraParameterReturnGeneral estadoordencompraParameterGeneral,Boolean isEsNuevoEstadoOrdenCompra,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenCompra.class.getSimpleName()+"-procesarEventosEstadoOrdenComprasWithConnection");connexion.begin();			
			
			EstadoOrdenCompraParameterReturnGeneral estadoordencompraReturnGeneral=new EstadoOrdenCompraParameterReturnGeneral();
	
			estadoordencompraReturnGeneral.setEstadoOrdenCompra(estadoordencompra);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoordencompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoOrdenCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadoordencompras,estadoordencompra,estadoordencompraParameterGeneral,estadoordencompraReturnGeneral,isEsNuevoEstadoOrdenCompra,clases);
			
			this.connexion.commit();
			
			return estadoordencompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoOrdenCompraParameterReturnGeneral procesarImportacionEstadoOrdenComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoOrdenCompraParameterReturnGeneral estadoordencompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenCompra.class.getSimpleName()+"-procesarImportacionEstadoOrdenComprasWithConnection");connexion.begin();			
			
			EstadoOrdenCompraParameterReturnGeneral estadoordencompraReturnGeneral=new EstadoOrdenCompraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadoordencompras=new ArrayList<EstadoOrdenCompra>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadoordencompra=new EstadoOrdenCompra();
				
				
				if(conColumnasBase) {this.estadoordencompra.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadoordencompra.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadoordencompra.setcodigo(arrColumnas[iColumn++]);
				this.estadoordencompra.setnombre(arrColumnas[iColumn++]);
				
				this.estadoordencompras.add(this.estadoordencompra);
			}
			
			this.saveEstadoOrdenCompras();
			
			this.connexion.commit();
			
			estadoordencompraReturnGeneral.setConRetornoEstaProcesado(true);
			estadoordencompraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadoordencompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoOrdenComprasEliminados() throws Exception {				
		
		List<EstadoOrdenCompra> estadoordencomprasAux= new ArrayList<EstadoOrdenCompra>();
		
		for(EstadoOrdenCompra estadoordencompra:estadoordencompras) {
			if(!estadoordencompra.getIsDeleted()) {
				estadoordencomprasAux.add(estadoordencompra);
			}
		}
		
		estadoordencompras=estadoordencomprasAux;
	}
	
	public void quitarEstadoOrdenComprasNulos() throws Exception {				
		
		List<EstadoOrdenCompra> estadoordencomprasAux= new ArrayList<EstadoOrdenCompra>();
		
		for(EstadoOrdenCompra estadoordencompra : this.estadoordencompras) {
			if(estadoordencompra==null) {
				estadoordencomprasAux.add(estadoordencompra);
			}
		}
		
		//this.estadoordencompras=estadoordencomprasAux;
		
		this.estadoordencompras.removeAll(estadoordencomprasAux);
	}
	
	public void getSetVersionRowEstadoOrdenCompraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadoordencompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadoordencompra.getIsDeleted() || (estadoordencompra.getIsChanged()&&!estadoordencompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadoordencompraDataAccess.getSetVersionRowEstadoOrdenCompra(connexion,estadoordencompra.getId());
				
				if(!estadoordencompra.getVersionRow().equals(timestamp)) {	
					estadoordencompra.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadoordencompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoOrdenCompra()throws Exception {	
		
		if(estadoordencompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadoordencompra.getIsDeleted() || (estadoordencompra.getIsChanged()&&!estadoordencompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadoordencompraDataAccess.getSetVersionRowEstadoOrdenCompra(connexion,estadoordencompra.getId());
			
			try {							
				if(!estadoordencompra.getVersionRow().equals(timestamp)) {	
					estadoordencompra.setVersionRow(timestamp);
				}
				
				estadoordencompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoOrdenComprasWithConnection()throws Exception {	
		if(estadoordencompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoOrdenCompra estadoordencompraAux:estadoordencompras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadoordencompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoordencompraAux.getIsDeleted() || (estadoordencompraAux.getIsChanged()&&!estadoordencompraAux.getIsNew())) {
						
						timestamp=estadoordencompraDataAccess.getSetVersionRowEstadoOrdenCompra(connexion,estadoordencompraAux.getId());
						
						if(!estadoordencompra.getVersionRow().equals(timestamp)) {	
							estadoordencompraAux.setVersionRow(timestamp);
						}
								
						estadoordencompraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoOrdenCompras()throws Exception {	
		if(estadoordencompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoOrdenCompra estadoordencompraAux:estadoordencompras) {
					if(estadoordencompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoordencompraAux.getIsDeleted() || (estadoordencompraAux.getIsChanged()&&!estadoordencompraAux.getIsNew())) {
						
						timestamp=estadoordencompraDataAccess.getSetVersionRowEstadoOrdenCompra(connexion,estadoordencompraAux.getId());
						
						if(!estadoordencompraAux.getVersionRow().equals(timestamp)) {	
							estadoordencompraAux.setVersionRow(timestamp);
						}
						
													
						estadoordencompraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoOrdenCompraWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			OrdenCompraLogic ordencompraLogic=new OrdenCompraLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenCompra.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoOrdenCompraWithConnection");connexion.begin();
			
			
			classes.add(new Classe(OrdenCompra.class));
											
			

			ordencompraLogic.setConnexion(this.getConnexion());
			ordencompraLogic.setDatosCliente(this.datosCliente);
			ordencompraLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoOrdenCompra estadoordencompra:this.estadoordencompras) {
				

				classes=new ArrayList<Classe>();
				classes=OrdenCompraConstantesFunciones.getClassesForeignKeysOfOrdenCompra(new ArrayList<Classe>(),DeepLoadType.NONE);

				ordencompraLogic.setOrdenCompras(estadoordencompra.ordencompras);
				ordencompraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoOrdenCompra estadoordencompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoOrdenCompraLogicAdditional.updateEstadoOrdenCompraToGet(estadoordencompra,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadoordencompra.setOrdenCompras(estadoordencompraDataAccess.getOrdenCompras(connexion,estadoordencompra));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoordencompra.setOrdenCompras(estadoordencompraDataAccess.getOrdenCompras(connexion,estadoordencompra));

				if(this.isConDeep) {
					OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(this.connexion);
					ordencompraLogic.setOrdenCompras(estadoordencompra.getOrdenCompras());
					ArrayList<Classe> classesLocal=OrdenCompraConstantesFunciones.getClassesForeignKeysOfOrdenCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
					ordencompraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(ordencompraLogic.getOrdenCompras());
					estadoordencompra.setOrdenCompras(ordencompraLogic.getOrdenCompras());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(OrdenCompra.class));
			estadoordencompra.setOrdenCompras(estadoordencompraDataAccess.getOrdenCompras(connexion,estadoordencompra));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadoordencompra.setOrdenCompras(estadoordencompraDataAccess.getOrdenCompras(connexion,estadoordencompra));

		for(OrdenCompra ordencompra:estadoordencompra.getOrdenCompras()) {
			OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
			ordencompraLogic.deepLoad(ordencompra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoordencompra.setOrdenCompras(estadoordencompraDataAccess.getOrdenCompras(connexion,estadoordencompra));

				for(OrdenCompra ordencompra:estadoordencompra.getOrdenCompras()) {
					OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
					ordencompraLogic.deepLoad(ordencompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(OrdenCompra.class));
			estadoordencompra.setOrdenCompras(estadoordencompraDataAccess.getOrdenCompras(connexion,estadoordencompra));

			for(OrdenCompra ordencompra:estadoordencompra.getOrdenCompras()) {
				OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
				ordencompraLogic.deepLoad(ordencompra,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoOrdenCompra estadoordencompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoOrdenCompraLogicAdditional.updateEstadoOrdenCompraToSave(estadoordencompra,this.arrDatoGeneral);
			
EstadoOrdenCompraDataAccess.save(estadoordencompra, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(OrdenCompra ordencompra:estadoordencompra.getOrdenCompras()) {
			ordencompra.setid_estado_orden_compra(estadoordencompra.getId());
			OrdenCompraDataAccess.save(ordencompra,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(OrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(OrdenCompra ordencompra:estadoordencompra.getOrdenCompras()) {
					ordencompra.setid_estado_orden_compra(estadoordencompra.getId());
					OrdenCompraDataAccess.save(ordencompra,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(OrdenCompra ordencompra:estadoordencompra.getOrdenCompras()) {
			OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
			ordencompra.setid_estado_orden_compra(estadoordencompra.getId());
			OrdenCompraDataAccess.save(ordencompra,connexion);
			ordencompraLogic.deepSave(ordencompra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(OrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(OrdenCompra ordencompra:estadoordencompra.getOrdenCompras()) {
					OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
					ordencompra.setid_estado_orden_compra(estadoordencompra.getId());
					OrdenCompraDataAccess.save(ordencompra,connexion);
					ordencompraLogic.deepSave(ordencompra,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EstadoOrdenCompra.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadoordencompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenCompra(estadoordencompra);
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
			this.deepLoad(this.estadoordencompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenCompra(this.estadoordencompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoOrdenCompra.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadoordencompras!=null) {
				for(EstadoOrdenCompra estadoordencompra:estadoordencompras) {
					this.deepLoad(estadoordencompra,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenCompra(estadoordencompras);
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
			if(estadoordencompras!=null) {
				for(EstadoOrdenCompra estadoordencompra:estadoordencompras) {
					this.deepLoad(estadoordencompra,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenCompra(estadoordencompras);
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
			this.getNewConnexionToDeep(EstadoOrdenCompra.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadoordencompra,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoOrdenCompra.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadoordencompras!=null) {
				for(EstadoOrdenCompra estadoordencompra:estadoordencompras) {
					this.deepSave(estadoordencompra,isDeep,deepLoadType,clases);
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
			if(estadoordencompras!=null) {
				for(EstadoOrdenCompra estadoordencompra:estadoordencompras) {
					this.deepSave(estadoordencompra,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoOrdenCompraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoOrdenCompraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoOrdenCompra estadoordencompra,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoOrdenCompraConstantesFunciones.ISCONAUDITORIA) {
				if(estadoordencompra.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoOrdenCompraDataAccess.TABLENAME, estadoordencompra.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoOrdenCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoOrdenCompraLogic.registrarAuditoriaDetallesEstadoOrdenCompra(connexion,estadoordencompra,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadoordencompra.getIsDeleted()) {
					/*if(!estadoordencompra.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoOrdenCompraDataAccess.TABLENAME, estadoordencompra.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoOrdenCompraLogic.registrarAuditoriaDetallesEstadoOrdenCompra(connexion,estadoordencompra,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoOrdenCompraDataAccess.TABLENAME, estadoordencompra.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadoordencompra.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoOrdenCompraDataAccess.TABLENAME, estadoordencompra.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoOrdenCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoOrdenCompraLogic.registrarAuditoriaDetallesEstadoOrdenCompra(connexion,estadoordencompra,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoOrdenCompra(Connexion connexion,EstadoOrdenCompra estadoordencompra)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadoordencompra.getIsNew()||!estadoordencompra.getcodigo().equals(estadoordencompra.getEstadoOrdenCompraOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoordencompra.getEstadoOrdenCompraOriginal().getcodigo()!=null)
				{
					strValorActual=estadoordencompra.getEstadoOrdenCompraOriginal().getcodigo();
				}
				if(estadoordencompra.getcodigo()!=null)
				{
					strValorNuevo=estadoordencompra.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoOrdenCompraConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadoordencompra.getIsNew()||!estadoordencompra.getnombre().equals(estadoordencompra.getEstadoOrdenCompraOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoordencompra.getEstadoOrdenCompraOriginal().getnombre()!=null)
				{
					strValorActual=estadoordencompra.getEstadoOrdenCompraOriginal().getnombre();
				}
				if(estadoordencompra.getnombre()!=null)
				{
					strValorNuevo=estadoordencompra.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoOrdenCompraConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoOrdenCompraRelacionesWithConnection(EstadoOrdenCompra estadoordencompra,List<OrdenCompra> ordencompras) throws Exception {

		if(!estadoordencompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoOrdenCompraRelacionesBase(estadoordencompra,ordencompras,true);
		}
	}

	public void saveEstadoOrdenCompraRelaciones(EstadoOrdenCompra estadoordencompra,List<OrdenCompra> ordencompras)throws Exception {

		if(!estadoordencompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoOrdenCompraRelacionesBase(estadoordencompra,ordencompras,false);
		}
	}

	public void saveEstadoOrdenCompraRelacionesBase(EstadoOrdenCompra estadoordencompra,List<OrdenCompra> ordencompras,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoOrdenCompra-saveRelacionesWithConnection");}
	
			estadoordencompra.setOrdenCompras(ordencompras);

			this.setEstadoOrdenCompra(estadoordencompra);

				if((estadoordencompra.getIsNew()||estadoordencompra.getIsChanged())&&!estadoordencompra.getIsDeleted()) {
					this.saveEstadoOrdenCompra();
					this.saveEstadoOrdenCompraRelacionesDetalles(ordencompras);

				} else if(estadoordencompra.getIsDeleted()) {
					this.saveEstadoOrdenCompraRelacionesDetalles(ordencompras);
					this.saveEstadoOrdenCompra();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			OrdenCompraConstantesFunciones.InicializarGeneralEntityAuxiliaresOrdenCompras(ordencompras,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoOrdenCompraRelacionesDetalles(List<OrdenCompra> ordencompras)throws Exception {
		try {
	

			Long idEstadoOrdenCompraActual=this.getEstadoOrdenCompra().getId();

			OrdenCompraLogic ordencompraLogic_Desde_EstadoOrdenCompra=new OrdenCompraLogic();
			ordencompraLogic_Desde_EstadoOrdenCompra.setOrdenCompras(ordencompras);

			ordencompraLogic_Desde_EstadoOrdenCompra.setConnexion(this.getConnexion());
			ordencompraLogic_Desde_EstadoOrdenCompra.setDatosCliente(this.datosCliente);

			for(OrdenCompra ordencompra_Desde_EstadoOrdenCompra:ordencompraLogic_Desde_EstadoOrdenCompra.getOrdenCompras()) {
				ordencompra_Desde_EstadoOrdenCompra.setid_estado_orden_compra(idEstadoOrdenCompraActual);

				ordencompraLogic_Desde_EstadoOrdenCompra.setOrdenCompra(ordencompra_Desde_EstadoOrdenCompra);
				ordencompraLogic_Desde_EstadoOrdenCompra.saveOrdenCompra();

				Long idOrdenCompraActual=ordencompra_Desde_EstadoOrdenCompra.getId();

				DetalleOrdenCompraLogic detalleordencompraLogic_Desde_OrdenCompra=new DetalleOrdenCompraLogic();

				if(ordencompra_Desde_EstadoOrdenCompra.getDetalleOrdenCompras()==null){
					ordencompra_Desde_EstadoOrdenCompra.setDetalleOrdenCompras(new ArrayList<DetalleOrdenCompra>());
				}

				detalleordencompraLogic_Desde_OrdenCompra.setDetalleOrdenCompras(ordencompra_Desde_EstadoOrdenCompra.getDetalleOrdenCompras());

				detalleordencompraLogic_Desde_OrdenCompra.setConnexion(this.getConnexion());
				detalleordencompraLogic_Desde_OrdenCompra.setDatosCliente(this.datosCliente);

				for(DetalleOrdenCompra detalleordencompra_Desde_OrdenCompra:detalleordencompraLogic_Desde_OrdenCompra.getDetalleOrdenCompras()) {
					detalleordencompra_Desde_OrdenCompra.setid_orden_compra(idOrdenCompraActual);
				}

				detalleordencompraLogic_Desde_OrdenCompra.saveDetalleOrdenCompras();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoOrdenCompraConstantesFunciones.getClassesForeignKeysOfEstadoOrdenCompra(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoOrdenCompraConstantesFunciones.getClassesRelationshipsOfEstadoOrdenCompra(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.facturacion.util.EstadoFisicoFacturaEmpresaConstantesFunciones;
import com.bydan.erp.facturacion.util.EstadoFisicoFacturaEmpresaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.EstadoFisicoFacturaEmpresaParameterGeneral;
import com.bydan.erp.facturacion.business.entity.EstadoFisicoFacturaEmpresa;
import com.bydan.erp.facturacion.business.logic.EstadoFisicoFacturaEmpresaLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class EstadoFisicoFacturaEmpresaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoFisicoFacturaEmpresaLogic.class);
	
	protected EstadoFisicoFacturaEmpresaDataAccess estadofisicofacturaempresaDataAccess; 	
	protected EstadoFisicoFacturaEmpresa estadofisicofacturaempresa;
	protected List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresas;
	protected Object estadofisicofacturaempresaObject;	
	protected List<Object> estadofisicofacturaempresasObject;
	
	public static ClassValidator<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresaValidator = new ClassValidator<EstadoFisicoFacturaEmpresa>(EstadoFisicoFacturaEmpresa.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoFisicoFacturaEmpresaLogicAdditional estadofisicofacturaempresaLogicAdditional=null;
	
	public EstadoFisicoFacturaEmpresaLogicAdditional getEstadoFisicoFacturaEmpresaLogicAdditional() {
		return this.estadofisicofacturaempresaLogicAdditional;
	}
	
	public void setEstadoFisicoFacturaEmpresaLogicAdditional(EstadoFisicoFacturaEmpresaLogicAdditional estadofisicofacturaempresaLogicAdditional) {
		try {
			this.estadofisicofacturaempresaLogicAdditional=estadofisicofacturaempresaLogicAdditional;
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
	
	
	
	
	public  EstadoFisicoFacturaEmpresaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadofisicofacturaempresaDataAccess = new EstadoFisicoFacturaEmpresaDataAccess();
			
			this.estadofisicofacturaempresas= new ArrayList<EstadoFisicoFacturaEmpresa>();
			this.estadofisicofacturaempresa= new EstadoFisicoFacturaEmpresa();
			
			this.estadofisicofacturaempresaObject=new Object();
			this.estadofisicofacturaempresasObject=new ArrayList<Object>();
				
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
			
			this.estadofisicofacturaempresaDataAccess.setConnexionType(this.connexionType);
			this.estadofisicofacturaempresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoFisicoFacturaEmpresaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadofisicofacturaempresaDataAccess = new EstadoFisicoFacturaEmpresaDataAccess();
			this.estadofisicofacturaempresas= new ArrayList<EstadoFisicoFacturaEmpresa>();
			this.estadofisicofacturaempresa= new EstadoFisicoFacturaEmpresa();
			this.estadofisicofacturaempresaObject=new Object();
			this.estadofisicofacturaempresasObject=new ArrayList<Object>();
			
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
			
			this.estadofisicofacturaempresaDataAccess.setConnexionType(this.connexionType);
			this.estadofisicofacturaempresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoFisicoFacturaEmpresa getEstadoFisicoFacturaEmpresa() throws Exception {	
		EstadoFisicoFacturaEmpresaLogicAdditional.checkEstadoFisicoFacturaEmpresaToGet(estadofisicofacturaempresa,this.datosCliente,this.arrDatoGeneral);
		EstadoFisicoFacturaEmpresaLogicAdditional.updateEstadoFisicoFacturaEmpresaToGet(estadofisicofacturaempresa,this.arrDatoGeneral);
		
		return estadofisicofacturaempresa;
	}
		
	public void setEstadoFisicoFacturaEmpresa(EstadoFisicoFacturaEmpresa newEstadoFisicoFacturaEmpresa) {
		this.estadofisicofacturaempresa = newEstadoFisicoFacturaEmpresa;
	}
	
	public EstadoFisicoFacturaEmpresaDataAccess getEstadoFisicoFacturaEmpresaDataAccess() {
		return estadofisicofacturaempresaDataAccess;
	}
	
	public void setEstadoFisicoFacturaEmpresaDataAccess(EstadoFisicoFacturaEmpresaDataAccess newestadofisicofacturaempresaDataAccess) {
		this.estadofisicofacturaempresaDataAccess = newestadofisicofacturaempresaDataAccess;
	}
	
	public List<EstadoFisicoFacturaEmpresa> getEstadoFisicoFacturaEmpresas() throws Exception {		
		this.quitarEstadoFisicoFacturaEmpresasNulos();
		
		EstadoFisicoFacturaEmpresaLogicAdditional.checkEstadoFisicoFacturaEmpresaToGets(estadofisicofacturaempresas,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoFisicoFacturaEmpresa estadofisicofacturaempresaLocal: estadofisicofacturaempresas ) {
			EstadoFisicoFacturaEmpresaLogicAdditional.updateEstadoFisicoFacturaEmpresaToGet(estadofisicofacturaempresaLocal,this.arrDatoGeneral);
		}
		
		return estadofisicofacturaempresas;
	}
	
	public void setEstadoFisicoFacturaEmpresas(List<EstadoFisicoFacturaEmpresa> newEstadoFisicoFacturaEmpresas) {
		this.estadofisicofacturaempresas = newEstadoFisicoFacturaEmpresas;
	}
	
	public Object getEstadoFisicoFacturaEmpresaObject() {	
		this.estadofisicofacturaempresaObject=this.estadofisicofacturaempresaDataAccess.getEntityObject();
		return this.estadofisicofacturaempresaObject;
	}
		
	public void setEstadoFisicoFacturaEmpresaObject(Object newEstadoFisicoFacturaEmpresaObject) {
		this.estadofisicofacturaempresaObject = newEstadoFisicoFacturaEmpresaObject;
	}
	
	public List<Object> getEstadoFisicoFacturaEmpresasObject() {		
		this.estadofisicofacturaempresasObject=this.estadofisicofacturaempresaDataAccess.getEntitiesObject();
		return this.estadofisicofacturaempresasObject;
	}
		
	public void setEstadoFisicoFacturaEmpresasObject(List<Object> newEstadoFisicoFacturaEmpresasObject) {
		this.estadofisicofacturaempresasObject = newEstadoFisicoFacturaEmpresasObject;
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
		
		if(this.estadofisicofacturaempresaDataAccess!=null) {
			this.estadofisicofacturaempresaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadofisicofacturaempresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadofisicofacturaempresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadofisicofacturaempresa = new  EstadoFisicoFacturaEmpresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadofisicofacturaempresa=estadofisicofacturaempresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadofisicofacturaempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(this.estadofisicofacturaempresa);
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
		estadofisicofacturaempresa = new  EstadoFisicoFacturaEmpresa();
		  		  
        try {
			
			estadofisicofacturaempresa=estadofisicofacturaempresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadofisicofacturaempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(this.estadofisicofacturaempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadofisicofacturaempresa = new  EstadoFisicoFacturaEmpresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadofisicofacturaempresa=estadofisicofacturaempresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadofisicofacturaempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(this.estadofisicofacturaempresa);
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
		estadofisicofacturaempresa = new  EstadoFisicoFacturaEmpresa();
		  		  
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
		estadofisicofacturaempresa = new  EstadoFisicoFacturaEmpresa();
		  		  
        try {
			
			estadofisicofacturaempresa=estadofisicofacturaempresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadofisicofacturaempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(this.estadofisicofacturaempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadofisicofacturaempresa = new  EstadoFisicoFacturaEmpresa();
		  		  
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
		estadofisicofacturaempresa = new  EstadoFisicoFacturaEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadofisicofacturaempresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadofisicofacturaempresa = new  EstadoFisicoFacturaEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadofisicofacturaempresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadofisicofacturaempresa = new  EstadoFisicoFacturaEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadofisicofacturaempresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadofisicofacturaempresa = new  EstadoFisicoFacturaEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadofisicofacturaempresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadofisicofacturaempresa = new  EstadoFisicoFacturaEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadofisicofacturaempresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadofisicofacturaempresa = new  EstadoFisicoFacturaEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadofisicofacturaempresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadofisicofacturaempresas = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoFisicoFacturaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofacturaempresas=estadofisicofacturaempresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoFisicoFacturaEmpresa(estadofisicofacturaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(this.estadofisicofacturaempresas);
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
		estadofisicofacturaempresas = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		  		  
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
		estadofisicofacturaempresas = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		  		  
        try {			
			EstadoFisicoFacturaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofacturaempresas=estadofisicofacturaempresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoFisicoFacturaEmpresa(estadofisicofacturaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(this.estadofisicofacturaempresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadofisicofacturaempresas = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		  		  
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
		estadofisicofacturaempresas = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoFisicoFacturaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofacturaempresas=estadofisicofacturaempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoFisicoFacturaEmpresa(estadofisicofacturaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(this.estadofisicofacturaempresas);
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
		estadofisicofacturaempresas = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		  		  
        try {
			EstadoFisicoFacturaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofacturaempresas=estadofisicofacturaempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoFisicoFacturaEmpresa(estadofisicofacturaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(this.estadofisicofacturaempresas);
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
		estadofisicofacturaempresas = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFisicoFacturaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofacturaempresas=estadofisicofacturaempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoFisicoFacturaEmpresa(estadofisicofacturaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(this.estadofisicofacturaempresas);
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
		estadofisicofacturaempresas = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFisicoFacturaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofacturaempresas=estadofisicofacturaempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoFisicoFacturaEmpresa(estadofisicofacturaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(this.estadofisicofacturaempresas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadofisicofacturaempresa = new  EstadoFisicoFacturaEmpresa();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFisicoFacturaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofacturaempresa=estadofisicofacturaempresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoFisicoFacturaEmpresa(estadofisicofacturaempresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(this.estadofisicofacturaempresa);
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
		estadofisicofacturaempresa = new  EstadoFisicoFacturaEmpresa();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFisicoFacturaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofacturaempresa=estadofisicofacturaempresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoFisicoFacturaEmpresa(estadofisicofacturaempresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(this.estadofisicofacturaempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadofisicofacturaempresas = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoFisicoFacturaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofacturaempresas=estadofisicofacturaempresaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoFisicoFacturaEmpresa(estadofisicofacturaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(this.estadofisicofacturaempresas);
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
		estadofisicofacturaempresas = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		  		  
        try {
			EstadoFisicoFacturaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofacturaempresas=estadofisicofacturaempresaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoFisicoFacturaEmpresa(estadofisicofacturaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(this.estadofisicofacturaempresas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoFisicoFacturaEmpresasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadofisicofacturaempresas = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-getTodosEstadoFisicoFacturaEmpresasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFisicoFacturaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofacturaempresas=estadofisicofacturaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoFisicoFacturaEmpresa(estadofisicofacturaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(this.estadofisicofacturaempresas);
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
	
	public  void  getTodosEstadoFisicoFacturaEmpresas(String sFinalQuery,Pagination pagination)throws Exception {
		estadofisicofacturaempresas = new  ArrayList<EstadoFisicoFacturaEmpresa>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFisicoFacturaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofacturaempresas=estadofisicofacturaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoFisicoFacturaEmpresa(estadofisicofacturaempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(this.estadofisicofacturaempresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoFisicoFacturaEmpresa(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa) throws Exception {
		Boolean estaValidado=false;
		
		if(estadofisicofacturaempresa.getIsNew() || estadofisicofacturaempresa.getIsChanged()) { 
			this.invalidValues = estadofisicofacturaempresaValidator.getInvalidValues(estadofisicofacturaempresa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadofisicofacturaempresa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoFisicoFacturaEmpresa(List<EstadoFisicoFacturaEmpresa> EstadoFisicoFacturaEmpresas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresaLocal:estadofisicofacturaempresas) {				
			estaValidadoObjeto=this.validarGuardarEstadoFisicoFacturaEmpresa(estadofisicofacturaempresaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoFisicoFacturaEmpresa(List<EstadoFisicoFacturaEmpresa> EstadoFisicoFacturaEmpresas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoFisicoFacturaEmpresa(estadofisicofacturaempresas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoFisicoFacturaEmpresa(EstadoFisicoFacturaEmpresa EstadoFisicoFacturaEmpresa) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoFisicoFacturaEmpresa(estadofisicofacturaempresa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadofisicofacturaempresa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoFisicoFacturaEmpresaConstantesFunciones.getEstadoFisicoFacturaEmpresaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadofisicofacturaempresa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoFisicoFacturaEmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoFisicoFacturaEmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoFisicoFacturaEmpresaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-saveEstadoFisicoFacturaEmpresaWithConnection");connexion.begin();			
			
			EstadoFisicoFacturaEmpresaLogicAdditional.checkEstadoFisicoFacturaEmpresaToSave(this.estadofisicofacturaempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoFisicoFacturaEmpresaLogicAdditional.updateEstadoFisicoFacturaEmpresaToSave(this.estadofisicofacturaempresa,this.arrDatoGeneral);
			
			EstadoFisicoFacturaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadofisicofacturaempresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoFisicoFacturaEmpresa();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoFisicoFacturaEmpresa(this.estadofisicofacturaempresa)) {
				EstadoFisicoFacturaEmpresaDataAccess.save(this.estadofisicofacturaempresa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadofisicofacturaempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoFisicoFacturaEmpresaLogicAdditional.checkEstadoFisicoFacturaEmpresaToSaveAfter(this.estadofisicofacturaempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoFisicoFacturaEmpresa();
			
			connexion.commit();			
			
			if(this.estadofisicofacturaempresa.getIsDeleted()) {
				this.estadofisicofacturaempresa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoFisicoFacturaEmpresa()throws Exception {	
		try {	
			
			EstadoFisicoFacturaEmpresaLogicAdditional.checkEstadoFisicoFacturaEmpresaToSave(this.estadofisicofacturaempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoFisicoFacturaEmpresaLogicAdditional.updateEstadoFisicoFacturaEmpresaToSave(this.estadofisicofacturaempresa,this.arrDatoGeneral);
			
			EstadoFisicoFacturaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadofisicofacturaempresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoFisicoFacturaEmpresa(this.estadofisicofacturaempresa)) {			
				EstadoFisicoFacturaEmpresaDataAccess.save(this.estadofisicofacturaempresa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadofisicofacturaempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoFisicoFacturaEmpresaLogicAdditional.checkEstadoFisicoFacturaEmpresaToSaveAfter(this.estadofisicofacturaempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadofisicofacturaempresa.getIsDeleted()) {
				this.estadofisicofacturaempresa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoFisicoFacturaEmpresasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-saveEstadoFisicoFacturaEmpresasWithConnection");connexion.begin();			
			
			EstadoFisicoFacturaEmpresaLogicAdditional.checkEstadoFisicoFacturaEmpresaToSaves(estadofisicofacturaempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoFisicoFacturaEmpresas();
			
			Boolean validadoTodosEstadoFisicoFacturaEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresaLocal:estadofisicofacturaempresas) {		
				if(estadofisicofacturaempresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoFisicoFacturaEmpresaLogicAdditional.updateEstadoFisicoFacturaEmpresaToSave(estadofisicofacturaempresaLocal,this.arrDatoGeneral);
	        	
				EstadoFisicoFacturaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadofisicofacturaempresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoFisicoFacturaEmpresa(estadofisicofacturaempresaLocal)) {
					EstadoFisicoFacturaEmpresaDataAccess.save(estadofisicofacturaempresaLocal, connexion);				
				} else {
					validadoTodosEstadoFisicoFacturaEmpresa=false;
				}
			}
			
			if(!validadoTodosEstadoFisicoFacturaEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoFisicoFacturaEmpresaLogicAdditional.checkEstadoFisicoFacturaEmpresaToSavesAfter(estadofisicofacturaempresas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoFisicoFacturaEmpresas();
			
			connexion.commit();		
			
			this.quitarEstadoFisicoFacturaEmpresasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoFisicoFacturaEmpresas()throws Exception {				
		 try {	
			EstadoFisicoFacturaEmpresaLogicAdditional.checkEstadoFisicoFacturaEmpresaToSaves(estadofisicofacturaempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoFisicoFacturaEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresaLocal:estadofisicofacturaempresas) {				
				if(estadofisicofacturaempresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoFisicoFacturaEmpresaLogicAdditional.updateEstadoFisicoFacturaEmpresaToSave(estadofisicofacturaempresaLocal,this.arrDatoGeneral);
	        	
				EstadoFisicoFacturaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadofisicofacturaempresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoFisicoFacturaEmpresa(estadofisicofacturaempresaLocal)) {				
					EstadoFisicoFacturaEmpresaDataAccess.save(estadofisicofacturaempresaLocal, connexion);				
				} else {
					validadoTodosEstadoFisicoFacturaEmpresa=false;
				}
			}
			
			if(!validadoTodosEstadoFisicoFacturaEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoFisicoFacturaEmpresaLogicAdditional.checkEstadoFisicoFacturaEmpresaToSavesAfter(estadofisicofacturaempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoFisicoFacturaEmpresasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoFisicoFacturaEmpresaParameterReturnGeneral procesarAccionEstadoFisicoFacturaEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresas,EstadoFisicoFacturaEmpresaParameterReturnGeneral estadofisicofacturaempresaParameterGeneral)throws Exception {
		 try {	
			EstadoFisicoFacturaEmpresaParameterReturnGeneral estadofisicofacturaempresaReturnGeneral=new EstadoFisicoFacturaEmpresaParameterReturnGeneral();
	
			EstadoFisicoFacturaEmpresaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadofisicofacturaempresas,estadofisicofacturaempresaParameterGeneral,estadofisicofacturaempresaReturnGeneral);
			
			return estadofisicofacturaempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoFisicoFacturaEmpresaParameterReturnGeneral procesarAccionEstadoFisicoFacturaEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresas,EstadoFisicoFacturaEmpresaParameterReturnGeneral estadofisicofacturaempresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-procesarAccionEstadoFisicoFacturaEmpresasWithConnection");connexion.begin();			
			
			EstadoFisicoFacturaEmpresaParameterReturnGeneral estadofisicofacturaempresaReturnGeneral=new EstadoFisicoFacturaEmpresaParameterReturnGeneral();
	
			EstadoFisicoFacturaEmpresaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadofisicofacturaempresas,estadofisicofacturaempresaParameterGeneral,estadofisicofacturaempresaReturnGeneral);
			
			this.connexion.commit();
			
			return estadofisicofacturaempresaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoFisicoFacturaEmpresaParameterReturnGeneral procesarEventosEstadoFisicoFacturaEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresas,EstadoFisicoFacturaEmpresa estadofisicofacturaempresa,EstadoFisicoFacturaEmpresaParameterReturnGeneral estadofisicofacturaempresaParameterGeneral,Boolean isEsNuevoEstadoFisicoFacturaEmpresa,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoFisicoFacturaEmpresaParameterReturnGeneral estadofisicofacturaempresaReturnGeneral=new EstadoFisicoFacturaEmpresaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadofisicofacturaempresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoFisicoFacturaEmpresaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadofisicofacturaempresas,estadofisicofacturaempresa,estadofisicofacturaempresaParameterGeneral,estadofisicofacturaempresaReturnGeneral,isEsNuevoEstadoFisicoFacturaEmpresa,clases);
			
			return estadofisicofacturaempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoFisicoFacturaEmpresaParameterReturnGeneral procesarEventosEstadoFisicoFacturaEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresas,EstadoFisicoFacturaEmpresa estadofisicofacturaempresa,EstadoFisicoFacturaEmpresaParameterReturnGeneral estadofisicofacturaempresaParameterGeneral,Boolean isEsNuevoEstadoFisicoFacturaEmpresa,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-procesarEventosEstadoFisicoFacturaEmpresasWithConnection");connexion.begin();			
			
			EstadoFisicoFacturaEmpresaParameterReturnGeneral estadofisicofacturaempresaReturnGeneral=new EstadoFisicoFacturaEmpresaParameterReturnGeneral();
	
			estadofisicofacturaempresaReturnGeneral.setEstadoFisicoFacturaEmpresa(estadofisicofacturaempresa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadofisicofacturaempresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoFisicoFacturaEmpresaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadofisicofacturaempresas,estadofisicofacturaempresa,estadofisicofacturaempresaParameterGeneral,estadofisicofacturaempresaReturnGeneral,isEsNuevoEstadoFisicoFacturaEmpresa,clases);
			
			this.connexion.commit();
			
			return estadofisicofacturaempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoFisicoFacturaEmpresaParameterReturnGeneral procesarImportacionEstadoFisicoFacturaEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoFisicoFacturaEmpresaParameterReturnGeneral estadofisicofacturaempresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-procesarImportacionEstadoFisicoFacturaEmpresasWithConnection");connexion.begin();			
			
			EstadoFisicoFacturaEmpresaParameterReturnGeneral estadofisicofacturaempresaReturnGeneral=new EstadoFisicoFacturaEmpresaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadofisicofacturaempresas=new ArrayList<EstadoFisicoFacturaEmpresa>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadofisicofacturaempresa=new EstadoFisicoFacturaEmpresa();
				
				
				if(conColumnasBase) {this.estadofisicofacturaempresa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadofisicofacturaempresa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadofisicofacturaempresa.setcodigo(arrColumnas[iColumn++]);
				this.estadofisicofacturaempresa.setnombre(arrColumnas[iColumn++]);
				this.estadofisicofacturaempresa.setes_pendiente(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.estadofisicofacturaempresas.add(this.estadofisicofacturaempresa);
			}
			
			this.saveEstadoFisicoFacturaEmpresas();
			
			this.connexion.commit();
			
			estadofisicofacturaempresaReturnGeneral.setConRetornoEstaProcesado(true);
			estadofisicofacturaempresaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadofisicofacturaempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoFisicoFacturaEmpresasEliminados() throws Exception {				
		
		List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresasAux= new ArrayList<EstadoFisicoFacturaEmpresa>();
		
		for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa:estadofisicofacturaempresas) {
			if(!estadofisicofacturaempresa.getIsDeleted()) {
				estadofisicofacturaempresasAux.add(estadofisicofacturaempresa);
			}
		}
		
		estadofisicofacturaempresas=estadofisicofacturaempresasAux;
	}
	
	public void quitarEstadoFisicoFacturaEmpresasNulos() throws Exception {				
		
		List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresasAux= new ArrayList<EstadoFisicoFacturaEmpresa>();
		
		for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa : this.estadofisicofacturaempresas) {
			if(estadofisicofacturaempresa==null) {
				estadofisicofacturaempresasAux.add(estadofisicofacturaempresa);
			}
		}
		
		//this.estadofisicofacturaempresas=estadofisicofacturaempresasAux;
		
		this.estadofisicofacturaempresas.removeAll(estadofisicofacturaempresasAux);
	}
	
	public void getSetVersionRowEstadoFisicoFacturaEmpresaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadofisicofacturaempresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadofisicofacturaempresa.getIsDeleted() || (estadofisicofacturaempresa.getIsChanged()&&!estadofisicofacturaempresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadofisicofacturaempresaDataAccess.getSetVersionRowEstadoFisicoFacturaEmpresa(connexion,estadofisicofacturaempresa.getId());
				
				if(!estadofisicofacturaempresa.getVersionRow().equals(timestamp)) {	
					estadofisicofacturaempresa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadofisicofacturaempresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoFisicoFacturaEmpresa()throws Exception {	
		
		if(estadofisicofacturaempresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadofisicofacturaempresa.getIsDeleted() || (estadofisicofacturaempresa.getIsChanged()&&!estadofisicofacturaempresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadofisicofacturaempresaDataAccess.getSetVersionRowEstadoFisicoFacturaEmpresa(connexion,estadofisicofacturaempresa.getId());
			
			try {							
				if(!estadofisicofacturaempresa.getVersionRow().equals(timestamp)) {	
					estadofisicofacturaempresa.setVersionRow(timestamp);
				}
				
				estadofisicofacturaempresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoFisicoFacturaEmpresasWithConnection()throws Exception {	
		if(estadofisicofacturaempresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresaAux:estadofisicofacturaempresas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadofisicofacturaempresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadofisicofacturaempresaAux.getIsDeleted() || (estadofisicofacturaempresaAux.getIsChanged()&&!estadofisicofacturaempresaAux.getIsNew())) {
						
						timestamp=estadofisicofacturaempresaDataAccess.getSetVersionRowEstadoFisicoFacturaEmpresa(connexion,estadofisicofacturaempresaAux.getId());
						
						if(!estadofisicofacturaempresa.getVersionRow().equals(timestamp)) {	
							estadofisicofacturaempresaAux.setVersionRow(timestamp);
						}
								
						estadofisicofacturaempresaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoFisicoFacturaEmpresas()throws Exception {	
		if(estadofisicofacturaempresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresaAux:estadofisicofacturaempresas) {
					if(estadofisicofacturaempresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadofisicofacturaempresaAux.getIsDeleted() || (estadofisicofacturaempresaAux.getIsChanged()&&!estadofisicofacturaempresaAux.getIsNew())) {
						
						timestamp=estadofisicofacturaempresaDataAccess.getSetVersionRowEstadoFisicoFacturaEmpresa(connexion,estadofisicofacturaempresaAux.getId());
						
						if(!estadofisicofacturaempresaAux.getVersionRow().equals(timestamp)) {	
							estadofisicofacturaempresaAux.setVersionRow(timestamp);
						}
						
													
						estadofisicofacturaempresaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EstadoFisicoFacturaEmpresaParameterReturnGeneral cargarCombosLoteForeignKeyEstadoFisicoFacturaEmpresaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		EstadoFisicoFacturaEmpresaParameterReturnGeneral  estadofisicofacturaempresaReturnGeneral =new EstadoFisicoFacturaEmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-cargarCombosLoteForeignKeyEstadoFisicoFacturaEmpresaWithConnection");connexion.begin();
			
			estadofisicofacturaempresaReturnGeneral =new EstadoFisicoFacturaEmpresaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			estadofisicofacturaempresaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return estadofisicofacturaempresaReturnGeneral;
	}
	
	public EstadoFisicoFacturaEmpresaParameterReturnGeneral cargarCombosLoteForeignKeyEstadoFisicoFacturaEmpresa(String finalQueryGlobalEmpresa) throws Exception {
		EstadoFisicoFacturaEmpresaParameterReturnGeneral  estadofisicofacturaempresaReturnGeneral =new EstadoFisicoFacturaEmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			estadofisicofacturaempresaReturnGeneral =new EstadoFisicoFacturaEmpresaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			estadofisicofacturaempresaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return estadofisicofacturaempresaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyEstadoFisicoFacturaEmpresaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			FacturaLogic facturaLogic=new FacturaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoFisicoFacturaEmpresaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Factura.class));
											
			

			facturaLogic.setConnexion(this.getConnexion());
			facturaLogic.setDatosCliente(this.datosCliente);
			facturaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa:this.estadofisicofacturaempresas) {
				

				classes=new ArrayList<Classe>();
				classes=FacturaConstantesFunciones.getClassesForeignKeysOfFactura(new ArrayList<Classe>(),DeepLoadType.NONE);

				facturaLogic.setFacturas(estadofisicofacturaempresa.facturas);
				facturaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoFisicoFacturaEmpresaLogicAdditional.updateEstadoFisicoFacturaEmpresaToGet(estadofisicofacturaempresa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadofisicofacturaempresa.setEmpresa(estadofisicofacturaempresaDataAccess.getEmpresa(connexion,estadofisicofacturaempresa));
		estadofisicofacturaempresa.setFacturas(estadofisicofacturaempresaDataAccess.getFacturas(connexion,estadofisicofacturaempresa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				estadofisicofacturaempresa.setEmpresa(estadofisicofacturaempresaDataAccess.getEmpresa(connexion,estadofisicofacturaempresa));
				continue;
			}

			if(clas.clas.equals(Factura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadofisicofacturaempresa.setFacturas(estadofisicofacturaempresaDataAccess.getFacturas(connexion,estadofisicofacturaempresa));

				if(this.isConDeep) {
					FacturaLogic facturaLogic= new FacturaLogic(this.connexion);
					facturaLogic.setFacturas(estadofisicofacturaempresa.getFacturas());
					ArrayList<Classe> classesLocal=FacturaConstantesFunciones.getClassesForeignKeysOfFactura(new ArrayList<Classe>(),DeepLoadType.NONE);
					facturaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(facturaLogic.getFacturas());
					estadofisicofacturaempresa.setFacturas(facturaLogic.getFacturas());
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
			estadofisicofacturaempresa.setEmpresa(estadofisicofacturaempresaDataAccess.getEmpresa(connexion,estadofisicofacturaempresa));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Factura.class));
			estadofisicofacturaempresa.setFacturas(estadofisicofacturaempresaDataAccess.getFacturas(connexion,estadofisicofacturaempresa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadofisicofacturaempresa.setEmpresa(estadofisicofacturaempresaDataAccess.getEmpresa(connexion,estadofisicofacturaempresa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(estadofisicofacturaempresa.getEmpresa(),isDeep,deepLoadType,clases);
				

		estadofisicofacturaempresa.setFacturas(estadofisicofacturaempresaDataAccess.getFacturas(connexion,estadofisicofacturaempresa));

		for(Factura factura:estadofisicofacturaempresa.getFacturas()) {
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(factura,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				estadofisicofacturaempresa.setEmpresa(estadofisicofacturaempresaDataAccess.getEmpresa(connexion,estadofisicofacturaempresa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(estadofisicofacturaempresa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadofisicofacturaempresa.setFacturas(estadofisicofacturaempresaDataAccess.getFacturas(connexion,estadofisicofacturaempresa));

				for(Factura factura:estadofisicofacturaempresa.getFacturas()) {
					FacturaLogic facturaLogic= new FacturaLogic(connexion);
					facturaLogic.deepLoad(factura,isDeep,deepLoadType,clases);
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
			estadofisicofacturaempresa.setEmpresa(estadofisicofacturaempresaDataAccess.getEmpresa(connexion,estadofisicofacturaempresa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(estadofisicofacturaempresa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Factura.class));
			estadofisicofacturaempresa.setFacturas(estadofisicofacturaempresaDataAccess.getFacturas(connexion,estadofisicofacturaempresa));

			for(Factura factura:estadofisicofacturaempresa.getFacturas()) {
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(factura,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoFisicoFacturaEmpresaLogicAdditional.updateEstadoFisicoFacturaEmpresaToSave(estadofisicofacturaempresa,this.arrDatoGeneral);
			
EstadoFisicoFacturaEmpresaDataAccess.save(estadofisicofacturaempresa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(estadofisicofacturaempresa.getEmpresa(),connexion);

		for(Factura factura:estadofisicofacturaempresa.getFacturas()) {
			factura.setid_estado_fisico_factura_empresa(estadofisicofacturaempresa.getId());
			FacturaDataAccess.save(factura,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(estadofisicofacturaempresa.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(Factura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Factura factura:estadofisicofacturaempresa.getFacturas()) {
					factura.setid_estado_fisico_factura_empresa(estadofisicofacturaempresa.getId());
					FacturaDataAccess.save(factura,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(estadofisicofacturaempresa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(estadofisicofacturaempresa.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(Factura factura:estadofisicofacturaempresa.getFacturas()) {
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			factura.setid_estado_fisico_factura_empresa(estadofisicofacturaempresa.getId());
			FacturaDataAccess.save(factura,connexion);
			facturaLogic.deepSave(factura,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(estadofisicofacturaempresa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(estadofisicofacturaempresa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Factura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Factura factura:estadofisicofacturaempresa.getFacturas()) {
					FacturaLogic facturaLogic= new FacturaLogic(connexion);
					factura.setid_estado_fisico_factura_empresa(estadofisicofacturaempresa.getId());
					FacturaDataAccess.save(factura,connexion);
					facturaLogic.deepSave(factura,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadofisicofacturaempresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(estadofisicofacturaempresa);
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
			this.deepLoad(this.estadofisicofacturaempresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(this.estadofisicofacturaempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadofisicofacturaempresas!=null) {
				for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa:estadofisicofacturaempresas) {
					this.deepLoad(estadofisicofacturaempresa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(estadofisicofacturaempresas);
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
			if(estadofisicofacturaempresas!=null) {
				for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa:estadofisicofacturaempresas) {
					this.deepLoad(estadofisicofacturaempresa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(estadofisicofacturaempresas);
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
			this.getNewConnexionToDeep(EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadofisicofacturaempresa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadofisicofacturaempresas!=null) {
				for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa:estadofisicofacturaempresas) {
					this.deepSave(estadofisicofacturaempresa,isDeep,deepLoadType,clases);
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
			if(estadofisicofacturaempresas!=null) {
				for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa:estadofisicofacturaempresas) {
					this.deepSave(estadofisicofacturaempresa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEstadoFisicoFacturaEmpresasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFacturaEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EstadoFisicoFacturaEmpresaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EstadoFisicoFacturaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estadofisicofacturaempresas=estadofisicofacturaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(this.estadofisicofacturaempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoFisicoFacturaEmpresasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EstadoFisicoFacturaEmpresaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EstadoFisicoFacturaEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estadofisicofacturaempresas=estadofisicofacturaempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstadoFisicoFacturaEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(this.estadofisicofacturaempresas);
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
			if(EstadoFisicoFacturaEmpresaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoFisicoFacturaEmpresaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoFisicoFacturaEmpresa estadofisicofacturaempresa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoFisicoFacturaEmpresaConstantesFunciones.ISCONAUDITORIA) {
				if(estadofisicofacturaempresa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoFisicoFacturaEmpresaDataAccess.TABLENAME, estadofisicofacturaempresa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoFisicoFacturaEmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoFisicoFacturaEmpresaLogic.registrarAuditoriaDetallesEstadoFisicoFacturaEmpresa(connexion,estadofisicofacturaempresa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadofisicofacturaempresa.getIsDeleted()) {
					/*if(!estadofisicofacturaempresa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoFisicoFacturaEmpresaDataAccess.TABLENAME, estadofisicofacturaempresa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoFisicoFacturaEmpresaLogic.registrarAuditoriaDetallesEstadoFisicoFacturaEmpresa(connexion,estadofisicofacturaempresa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoFisicoFacturaEmpresaDataAccess.TABLENAME, estadofisicofacturaempresa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadofisicofacturaempresa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoFisicoFacturaEmpresaDataAccess.TABLENAME, estadofisicofacturaempresa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoFisicoFacturaEmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoFisicoFacturaEmpresaLogic.registrarAuditoriaDetallesEstadoFisicoFacturaEmpresa(connexion,estadofisicofacturaempresa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoFisicoFacturaEmpresa(Connexion connexion,EstadoFisicoFacturaEmpresa estadofisicofacturaempresa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadofisicofacturaempresa.getIsNew()||!estadofisicofacturaempresa.getid_empresa().equals(estadofisicofacturaempresa.getEstadoFisicoFacturaEmpresaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadofisicofacturaempresa.getEstadoFisicoFacturaEmpresaOriginal().getid_empresa()!=null)
				{
					strValorActual=estadofisicofacturaempresa.getEstadoFisicoFacturaEmpresaOriginal().getid_empresa().toString();
				}
				if(estadofisicofacturaempresa.getid_empresa()!=null)
				{
					strValorNuevo=estadofisicofacturaempresa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoFisicoFacturaEmpresaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(estadofisicofacturaempresa.getIsNew()||!estadofisicofacturaempresa.getcodigo().equals(estadofisicofacturaempresa.getEstadoFisicoFacturaEmpresaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadofisicofacturaempresa.getEstadoFisicoFacturaEmpresaOriginal().getcodigo()!=null)
				{
					strValorActual=estadofisicofacturaempresa.getEstadoFisicoFacturaEmpresaOriginal().getcodigo();
				}
				if(estadofisicofacturaempresa.getcodigo()!=null)
				{
					strValorNuevo=estadofisicofacturaempresa.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoFisicoFacturaEmpresaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadofisicofacturaempresa.getIsNew()||!estadofisicofacturaempresa.getnombre().equals(estadofisicofacturaempresa.getEstadoFisicoFacturaEmpresaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadofisicofacturaempresa.getEstadoFisicoFacturaEmpresaOriginal().getnombre()!=null)
				{
					strValorActual=estadofisicofacturaempresa.getEstadoFisicoFacturaEmpresaOriginal().getnombre();
				}
				if(estadofisicofacturaempresa.getnombre()!=null)
				{
					strValorNuevo=estadofisicofacturaempresa.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoFisicoFacturaEmpresaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(estadofisicofacturaempresa.getIsNew()||!estadofisicofacturaempresa.getes_pendiente().equals(estadofisicofacturaempresa.getEstadoFisicoFacturaEmpresaOriginal().getes_pendiente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadofisicofacturaempresa.getEstadoFisicoFacturaEmpresaOriginal().getes_pendiente()!=null)
				{
					strValorActual=estadofisicofacturaempresa.getEstadoFisicoFacturaEmpresaOriginal().getes_pendiente().toString();
				}
				if(estadofisicofacturaempresa.getes_pendiente()!=null)
				{
					strValorNuevo=estadofisicofacturaempresa.getes_pendiente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoFisicoFacturaEmpresaConstantesFunciones.ESPENDIENTE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoFisicoFacturaEmpresaRelacionesWithConnection(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa,List<Factura> facturas) throws Exception {

		if(!estadofisicofacturaempresa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoFisicoFacturaEmpresaRelacionesBase(estadofisicofacturaempresa,facturas,true);
		}
	}

	public void saveEstadoFisicoFacturaEmpresaRelaciones(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa,List<Factura> facturas)throws Exception {

		if(!estadofisicofacturaempresa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoFisicoFacturaEmpresaRelacionesBase(estadofisicofacturaempresa,facturas,false);
		}
	}

	public void saveEstadoFisicoFacturaEmpresaRelacionesBase(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa,List<Factura> facturas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoFisicoFacturaEmpresa-saveRelacionesWithConnection");}
	
			estadofisicofacturaempresa.setFacturas(facturas);

			this.setEstadoFisicoFacturaEmpresa(estadofisicofacturaempresa);

			if(EstadoFisicoFacturaEmpresaLogicAdditional.validarSaveRelaciones(estadofisicofacturaempresa,this)) {

				EstadoFisicoFacturaEmpresaLogicAdditional.updateRelacionesToSave(estadofisicofacturaempresa,this);

				if((estadofisicofacturaempresa.getIsNew()||estadofisicofacturaempresa.getIsChanged())&&!estadofisicofacturaempresa.getIsDeleted()) {
					this.saveEstadoFisicoFacturaEmpresa();
					this.saveEstadoFisicoFacturaEmpresaRelacionesDetalles(facturas);

				} else if(estadofisicofacturaempresa.getIsDeleted()) {
					this.saveEstadoFisicoFacturaEmpresaRelacionesDetalles(facturas);
					this.saveEstadoFisicoFacturaEmpresa();
				}

				EstadoFisicoFacturaEmpresaLogicAdditional.updateRelacionesToSaveAfter(estadofisicofacturaempresa,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			FacturaConstantesFunciones.InicializarGeneralEntityAuxiliaresFacturas(facturas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoFisicoFacturaEmpresaRelacionesDetalles(List<Factura> facturas)throws Exception {
		try {
	

			Long idEstadoFisicoFacturaEmpresaActual=this.getEstadoFisicoFacturaEmpresa().getId();

			FacturaLogic facturaLogic_Desde_EstadoFisicoFacturaEmpresa=new FacturaLogic();
			facturaLogic_Desde_EstadoFisicoFacturaEmpresa.setFacturas(facturas);

			facturaLogic_Desde_EstadoFisicoFacturaEmpresa.setConnexion(this.getConnexion());
			facturaLogic_Desde_EstadoFisicoFacturaEmpresa.setDatosCliente(this.datosCliente);

			for(Factura factura_Desde_EstadoFisicoFacturaEmpresa:facturaLogic_Desde_EstadoFisicoFacturaEmpresa.getFacturas()) {
				factura_Desde_EstadoFisicoFacturaEmpresa.setid_estado_fisico_factura_empresa(idEstadoFisicoFacturaEmpresaActual);

				facturaLogic_Desde_EstadoFisicoFacturaEmpresa.setFactura(factura_Desde_EstadoFisicoFacturaEmpresa);
				facturaLogic_Desde_EstadoFisicoFacturaEmpresa.saveFactura();

				Long idFacturaActual=factura_Desde_EstadoFisicoFacturaEmpresa.getId();

				DetaFormaPagoLogic detaformapagoLogic_Desde_Factura=new DetaFormaPagoLogic();

				if(factura_Desde_EstadoFisicoFacturaEmpresa.getDetaFormaPagos()==null){
					factura_Desde_EstadoFisicoFacturaEmpresa.setDetaFormaPagos(new ArrayList<DetaFormaPago>());
				}

				detaformapagoLogic_Desde_Factura.setDetaFormaPagos(factura_Desde_EstadoFisicoFacturaEmpresa.getDetaFormaPagos());

				detaformapagoLogic_Desde_Factura.setConnexion(this.getConnexion());
				detaformapagoLogic_Desde_Factura.setDatosCliente(this.datosCliente);

				for(DetaFormaPago detaformapago_Desde_Factura:detaformapagoLogic_Desde_Factura.getDetaFormaPagos()) {
					detaformapago_Desde_Factura.setid_factura(idFacturaActual);

					detaformapagoLogic_Desde_Factura.setDetaFormaPago(detaformapago_Desde_Factura);
					detaformapagoLogic_Desde_Factura.saveDetaFormaPago();

					Long idDetaFormaPagoActual=detaformapago_Desde_Factura.getId();

					BancoFormaPagoLogic bancoformapagoLogic_Desde_DetaFormaPago=new BancoFormaPagoLogic();

					if(detaformapago_Desde_Factura.getBancoFormaPagos()==null){
						detaformapago_Desde_Factura.setBancoFormaPagos(new ArrayList<BancoFormaPago>());
					}

					bancoformapagoLogic_Desde_DetaFormaPago.setBancoFormaPagos(detaformapago_Desde_Factura.getBancoFormaPagos());

					bancoformapagoLogic_Desde_DetaFormaPago.setConnexion(this.getConnexion());
					bancoformapagoLogic_Desde_DetaFormaPago.setDatosCliente(this.datosCliente);

					for(BancoFormaPago bancoformapago_Desde_DetaFormaPago:bancoformapagoLogic_Desde_DetaFormaPago.getBancoFormaPagos()) {
						bancoformapago_Desde_DetaFormaPago.setid_deta_forma_pago(idDetaFormaPagoActual);
					}

					bancoformapagoLogic_Desde_DetaFormaPago.saveBancoFormaPagos();
				}


				DetalleFacturaLogic detallefacturaLogic_Desde_Factura=new DetalleFacturaLogic();

				if(factura_Desde_EstadoFisicoFacturaEmpresa.getDetalleFacturas()==null){
					factura_Desde_EstadoFisicoFacturaEmpresa.setDetalleFacturas(new ArrayList<DetalleFactura>());
				}

				detallefacturaLogic_Desde_Factura.setDetalleFacturas(factura_Desde_EstadoFisicoFacturaEmpresa.getDetalleFacturas());

				detallefacturaLogic_Desde_Factura.setConnexion(this.getConnexion());
				detallefacturaLogic_Desde_Factura.setDatosCliente(this.datosCliente);

				for(DetalleFactura detallefactura_Desde_Factura:detallefacturaLogic_Desde_Factura.getDetalleFacturas()) {
					detallefactura_Desde_Factura.setid_factura(idFacturaActual);
				}

				detallefacturaLogic_Desde_Factura.saveDetalleFacturas();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoFisicoFacturaEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoFisicoFacturaEmpresaConstantesFunciones.getClassesForeignKeysOfEstadoFisicoFacturaEmpresa(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoFisicoFacturaEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoFisicoFacturaEmpresaConstantesFunciones.getClassesRelationshipsOfEstadoFisicoFacturaEmpresa(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

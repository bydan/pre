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
import com.bydan.erp.facturacion.util.ParametroFactuEmpresaConstantesFunciones;
import com.bydan.erp.facturacion.util.ParametroFactuEmpresaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ParametroFactuEmpresaParameterGeneral;
import com.bydan.erp.facturacion.business.entity.ParametroFactuEmpresa;
import com.bydan.erp.facturacion.business.logic.ParametroFactuEmpresaLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroFactuEmpresaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroFactuEmpresaLogic.class);
	
	protected ParametroFactuEmpresaDataAccess parametrofactuempresaDataAccess; 	
	protected ParametroFactuEmpresa parametrofactuempresa;
	protected List<ParametroFactuEmpresa> parametrofactuempresas;
	protected Object parametrofactuempresaObject;	
	protected List<Object> parametrofactuempresasObject;
	
	public static ClassValidator<ParametroFactuEmpresa> parametrofactuempresaValidator = new ClassValidator<ParametroFactuEmpresa>(ParametroFactuEmpresa.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroFactuEmpresaLogicAdditional parametrofactuempresaLogicAdditional=null;
	
	public ParametroFactuEmpresaLogicAdditional getParametroFactuEmpresaLogicAdditional() {
		return this.parametrofactuempresaLogicAdditional;
	}
	
	public void setParametroFactuEmpresaLogicAdditional(ParametroFactuEmpresaLogicAdditional parametrofactuempresaLogicAdditional) {
		try {
			this.parametrofactuempresaLogicAdditional=parametrofactuempresaLogicAdditional;
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
	
	
	
	
	public  ParametroFactuEmpresaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametrofactuempresaDataAccess = new ParametroFactuEmpresaDataAccess();
			
			this.parametrofactuempresas= new ArrayList<ParametroFactuEmpresa>();
			this.parametrofactuempresa= new ParametroFactuEmpresa();
			
			this.parametrofactuempresaObject=new Object();
			this.parametrofactuempresasObject=new ArrayList<Object>();
				
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
			
			this.parametrofactuempresaDataAccess.setConnexionType(this.connexionType);
			this.parametrofactuempresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroFactuEmpresaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametrofactuempresaDataAccess = new ParametroFactuEmpresaDataAccess();
			this.parametrofactuempresas= new ArrayList<ParametroFactuEmpresa>();
			this.parametrofactuempresa= new ParametroFactuEmpresa();
			this.parametrofactuempresaObject=new Object();
			this.parametrofactuempresasObject=new ArrayList<Object>();
			
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
			
			this.parametrofactuempresaDataAccess.setConnexionType(this.connexionType);
			this.parametrofactuempresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroFactuEmpresa getParametroFactuEmpresa() throws Exception {	
		ParametroFactuEmpresaLogicAdditional.checkParametroFactuEmpresaToGet(parametrofactuempresa,this.datosCliente,this.arrDatoGeneral);
		ParametroFactuEmpresaLogicAdditional.updateParametroFactuEmpresaToGet(parametrofactuempresa,this.arrDatoGeneral);
		
		return parametrofactuempresa;
	}
		
	public void setParametroFactuEmpresa(ParametroFactuEmpresa newParametroFactuEmpresa) {
		this.parametrofactuempresa = newParametroFactuEmpresa;
	}
	
	public ParametroFactuEmpresaDataAccess getParametroFactuEmpresaDataAccess() {
		return parametrofactuempresaDataAccess;
	}
	
	public void setParametroFactuEmpresaDataAccess(ParametroFactuEmpresaDataAccess newparametrofactuempresaDataAccess) {
		this.parametrofactuempresaDataAccess = newparametrofactuempresaDataAccess;
	}
	
	public List<ParametroFactuEmpresa> getParametroFactuEmpresas() throws Exception {		
		this.quitarParametroFactuEmpresasNulos();
		
		ParametroFactuEmpresaLogicAdditional.checkParametroFactuEmpresaToGets(parametrofactuempresas,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroFactuEmpresa parametrofactuempresaLocal: parametrofactuempresas ) {
			ParametroFactuEmpresaLogicAdditional.updateParametroFactuEmpresaToGet(parametrofactuempresaLocal,this.arrDatoGeneral);
		}
		
		return parametrofactuempresas;
	}
	
	public void setParametroFactuEmpresas(List<ParametroFactuEmpresa> newParametroFactuEmpresas) {
		this.parametrofactuempresas = newParametroFactuEmpresas;
	}
	
	public Object getParametroFactuEmpresaObject() {	
		this.parametrofactuempresaObject=this.parametrofactuempresaDataAccess.getEntityObject();
		return this.parametrofactuempresaObject;
	}
		
	public void setParametroFactuEmpresaObject(Object newParametroFactuEmpresaObject) {
		this.parametrofactuempresaObject = newParametroFactuEmpresaObject;
	}
	
	public List<Object> getParametroFactuEmpresasObject() {		
		this.parametrofactuempresasObject=this.parametrofactuempresaDataAccess.getEntitiesObject();
		return this.parametrofactuempresasObject;
	}
		
	public void setParametroFactuEmpresasObject(List<Object> newParametroFactuEmpresasObject) {
		this.parametrofactuempresasObject = newParametroFactuEmpresasObject;
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
		
		if(this.parametrofactuempresaDataAccess!=null) {
			this.parametrofactuempresaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametrofactuempresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametrofactuempresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametrofactuempresa = new  ParametroFactuEmpresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrofactuempresa=parametrofactuempresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofactuempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresa);
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
		parametrofactuempresa = new  ParametroFactuEmpresa();
		  		  
        try {
			
			parametrofactuempresa=parametrofactuempresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofactuempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametrofactuempresa = new  ParametroFactuEmpresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrofactuempresa=parametrofactuempresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofactuempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresa);
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
		parametrofactuempresa = new  ParametroFactuEmpresa();
		  		  
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
		parametrofactuempresa = new  ParametroFactuEmpresa();
		  		  
        try {
			
			parametrofactuempresa=parametrofactuempresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofactuempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametrofactuempresa = new  ParametroFactuEmpresa();
		  		  
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
		parametrofactuempresa = new  ParametroFactuEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametrofactuempresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrofactuempresa = new  ParametroFactuEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametrofactuempresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrofactuempresa = new  ParametroFactuEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametrofactuempresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrofactuempresa = new  ParametroFactuEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametrofactuempresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrofactuempresa = new  ParametroFactuEmpresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametrofactuempresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrofactuempresa = new  ParametroFactuEmpresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametrofactuempresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrofactuempresas = new  ArrayList<ParametroFactuEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactuEmpresa(parametrofactuempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
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
		parametrofactuempresas = new  ArrayList<ParametroFactuEmpresa>();
		  		  
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
		parametrofactuempresas = new  ArrayList<ParametroFactuEmpresa>();
		  		  
        try {			
			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroFactuEmpresa(parametrofactuempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametrofactuempresas = new  ArrayList<ParametroFactuEmpresa>();
		  		  
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
		parametrofactuempresas = new  ArrayList<ParametroFactuEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactuEmpresa(parametrofactuempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
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
		parametrofactuempresas = new  ArrayList<ParametroFactuEmpresa>();
		  		  
        try {
			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactuEmpresa(parametrofactuempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
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
		parametrofactuempresas = new  ArrayList<ParametroFactuEmpresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFactuEmpresa(parametrofactuempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
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
		parametrofactuempresas = new  ArrayList<ParametroFactuEmpresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFactuEmpresa(parametrofactuempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametrofactuempresa = new  ParametroFactuEmpresa();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuempresa=parametrofactuempresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFactuEmpresa(parametrofactuempresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresa);
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
		parametrofactuempresa = new  ParametroFactuEmpresa();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuempresa=parametrofactuempresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFactuEmpresa(parametrofactuempresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrofactuempresas = new  ArrayList<ParametroFactuEmpresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuempresas=parametrofactuempresaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactuEmpresa(parametrofactuempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
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
		parametrofactuempresas = new  ArrayList<ParametroFactuEmpresa>();
		  		  
        try {
			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuempresas=parametrofactuempresaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactuEmpresa(parametrofactuempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroFactuEmpresasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametrofactuempresas = new  ArrayList<ParametroFactuEmpresa>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getTodosParametroFactuEmpresasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroFactuEmpresa(parametrofactuempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
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
	
	public  void  getTodosParametroFactuEmpresas(String sFinalQuery,Pagination pagination)throws Exception {
		parametrofactuempresas = new  ArrayList<ParametroFactuEmpresa>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroFactuEmpresa(parametrofactuempresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroFactuEmpresa(ParametroFactuEmpresa parametrofactuempresa) throws Exception {
		Boolean estaValidado=false;
		
		if(parametrofactuempresa.getIsNew() || parametrofactuempresa.getIsChanged()) { 
			this.invalidValues = parametrofactuempresaValidator.getInvalidValues(parametrofactuempresa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametrofactuempresa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroFactuEmpresa(List<ParametroFactuEmpresa> ParametroFactuEmpresas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroFactuEmpresa parametrofactuempresaLocal:parametrofactuempresas) {				
			estaValidadoObjeto=this.validarGuardarParametroFactuEmpresa(parametrofactuempresaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroFactuEmpresa(List<ParametroFactuEmpresa> ParametroFactuEmpresas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroFactuEmpresa(parametrofactuempresas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroFactuEmpresa(ParametroFactuEmpresa ParametroFactuEmpresa) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroFactuEmpresa(parametrofactuempresa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroFactuEmpresa parametrofactuempresa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametrofactuempresa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroFactuEmpresaConstantesFunciones.getParametroFactuEmpresaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametrofactuempresa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroFactuEmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroFactuEmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroFactuEmpresaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-saveParametroFactuEmpresaWithConnection");connexion.begin();			
			
			ParametroFactuEmpresaLogicAdditional.checkParametroFactuEmpresaToSave(this.parametrofactuempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroFactuEmpresaLogicAdditional.updateParametroFactuEmpresaToSave(this.parametrofactuempresa,this.arrDatoGeneral);
			
			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrofactuempresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroFactuEmpresa();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroFactuEmpresa(this.parametrofactuempresa)) {
				ParametroFactuEmpresaDataAccess.save(this.parametrofactuempresa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametrofactuempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroFactuEmpresaLogicAdditional.checkParametroFactuEmpresaToSaveAfter(this.parametrofactuempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroFactuEmpresa();
			
			connexion.commit();			
			
			if(this.parametrofactuempresa.getIsDeleted()) {
				this.parametrofactuempresa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroFactuEmpresa()throws Exception {	
		try {	
			
			ParametroFactuEmpresaLogicAdditional.checkParametroFactuEmpresaToSave(this.parametrofactuempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroFactuEmpresaLogicAdditional.updateParametroFactuEmpresaToSave(this.parametrofactuempresa,this.arrDatoGeneral);
			
			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrofactuempresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroFactuEmpresa(this.parametrofactuempresa)) {			
				ParametroFactuEmpresaDataAccess.save(this.parametrofactuempresa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametrofactuempresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroFactuEmpresaLogicAdditional.checkParametroFactuEmpresaToSaveAfter(this.parametrofactuempresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametrofactuempresa.getIsDeleted()) {
				this.parametrofactuempresa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroFactuEmpresasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-saveParametroFactuEmpresasWithConnection");connexion.begin();			
			
			ParametroFactuEmpresaLogicAdditional.checkParametroFactuEmpresaToSaves(parametrofactuempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroFactuEmpresas();
			
			Boolean validadoTodosParametroFactuEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroFactuEmpresa parametrofactuempresaLocal:parametrofactuempresas) {		
				if(parametrofactuempresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroFactuEmpresaLogicAdditional.updateParametroFactuEmpresaToSave(parametrofactuempresaLocal,this.arrDatoGeneral);
	        	
				ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrofactuempresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroFactuEmpresa(parametrofactuempresaLocal)) {
					ParametroFactuEmpresaDataAccess.save(parametrofactuempresaLocal, connexion);				
				} else {
					validadoTodosParametroFactuEmpresa=false;
				}
			}
			
			if(!validadoTodosParametroFactuEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroFactuEmpresaLogicAdditional.checkParametroFactuEmpresaToSavesAfter(parametrofactuempresas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroFactuEmpresas();
			
			connexion.commit();		
			
			this.quitarParametroFactuEmpresasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroFactuEmpresas()throws Exception {				
		 try {	
			ParametroFactuEmpresaLogicAdditional.checkParametroFactuEmpresaToSaves(parametrofactuempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroFactuEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroFactuEmpresa parametrofactuempresaLocal:parametrofactuempresas) {				
				if(parametrofactuempresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroFactuEmpresaLogicAdditional.updateParametroFactuEmpresaToSave(parametrofactuempresaLocal,this.arrDatoGeneral);
	        	
				ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrofactuempresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroFactuEmpresa(parametrofactuempresaLocal)) {				
					ParametroFactuEmpresaDataAccess.save(parametrofactuempresaLocal, connexion);				
				} else {
					validadoTodosParametroFactuEmpresa=false;
				}
			}
			
			if(!validadoTodosParametroFactuEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroFactuEmpresaLogicAdditional.checkParametroFactuEmpresaToSavesAfter(parametrofactuempresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroFactuEmpresasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroFactuEmpresaParameterReturnGeneral procesarAccionParametroFactuEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroFactuEmpresa> parametrofactuempresas,ParametroFactuEmpresaParameterReturnGeneral parametrofactuempresaParameterGeneral)throws Exception {
		 try {	
			ParametroFactuEmpresaParameterReturnGeneral parametrofactuempresaReturnGeneral=new ParametroFactuEmpresaParameterReturnGeneral();
	
			ParametroFactuEmpresaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrofactuempresas,parametrofactuempresaParameterGeneral,parametrofactuempresaReturnGeneral);
			
			return parametrofactuempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroFactuEmpresaParameterReturnGeneral procesarAccionParametroFactuEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroFactuEmpresa> parametrofactuempresas,ParametroFactuEmpresaParameterReturnGeneral parametrofactuempresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-procesarAccionParametroFactuEmpresasWithConnection");connexion.begin();			
			
			ParametroFactuEmpresaParameterReturnGeneral parametrofactuempresaReturnGeneral=new ParametroFactuEmpresaParameterReturnGeneral();
	
			ParametroFactuEmpresaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrofactuempresas,parametrofactuempresaParameterGeneral,parametrofactuempresaReturnGeneral);
			
			this.connexion.commit();
			
			return parametrofactuempresaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroFactuEmpresaParameterReturnGeneral procesarEventosParametroFactuEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroFactuEmpresa> parametrofactuempresas,ParametroFactuEmpresa parametrofactuempresa,ParametroFactuEmpresaParameterReturnGeneral parametrofactuempresaParameterGeneral,Boolean isEsNuevoParametroFactuEmpresa,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroFactuEmpresaParameterReturnGeneral parametrofactuempresaReturnGeneral=new ParametroFactuEmpresaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrofactuempresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroFactuEmpresaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrofactuempresas,parametrofactuempresa,parametrofactuempresaParameterGeneral,parametrofactuempresaReturnGeneral,isEsNuevoParametroFactuEmpresa,clases);
			
			return parametrofactuempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroFactuEmpresaParameterReturnGeneral procesarEventosParametroFactuEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroFactuEmpresa> parametrofactuempresas,ParametroFactuEmpresa parametrofactuempresa,ParametroFactuEmpresaParameterReturnGeneral parametrofactuempresaParameterGeneral,Boolean isEsNuevoParametroFactuEmpresa,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-procesarEventosParametroFactuEmpresasWithConnection");connexion.begin();			
			
			ParametroFactuEmpresaParameterReturnGeneral parametrofactuempresaReturnGeneral=new ParametroFactuEmpresaParameterReturnGeneral();
	
			parametrofactuempresaReturnGeneral.setParametroFactuEmpresa(parametrofactuempresa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrofactuempresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroFactuEmpresaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrofactuempresas,parametrofactuempresa,parametrofactuempresaParameterGeneral,parametrofactuempresaReturnGeneral,isEsNuevoParametroFactuEmpresa,clases);
			
			this.connexion.commit();
			
			return parametrofactuempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroFactuEmpresaParameterReturnGeneral procesarImportacionParametroFactuEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroFactuEmpresaParameterReturnGeneral parametrofactuempresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-procesarImportacionParametroFactuEmpresasWithConnection");connexion.begin();			
			
			ParametroFactuEmpresaParameterReturnGeneral parametrofactuempresaReturnGeneral=new ParametroFactuEmpresaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametrofactuempresas=new ArrayList<ParametroFactuEmpresa>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametrofactuempresa=new ParametroFactuEmpresa();
				
				
				if(conColumnasBase) {this.parametrofactuempresa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametrofactuempresa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parametrofactuempresa.setcosto_origen(Double.parseDouble(arrColumnas[iColumn++]));
				this.parametrofactuempresa.setcosto_destino(Double.parseDouble(arrColumnas[iColumn++]));
				this.parametrofactuempresa.setcon_transferencia(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.parametrofactuempresas.add(this.parametrofactuempresa);
			}
			
			this.saveParametroFactuEmpresas();
			
			this.connexion.commit();
			
			parametrofactuempresaReturnGeneral.setConRetornoEstaProcesado(true);
			parametrofactuempresaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametrofactuempresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroFactuEmpresasEliminados() throws Exception {				
		
		List<ParametroFactuEmpresa> parametrofactuempresasAux= new ArrayList<ParametroFactuEmpresa>();
		
		for(ParametroFactuEmpresa parametrofactuempresa:parametrofactuempresas) {
			if(!parametrofactuempresa.getIsDeleted()) {
				parametrofactuempresasAux.add(parametrofactuempresa);
			}
		}
		
		parametrofactuempresas=parametrofactuempresasAux;
	}
	
	public void quitarParametroFactuEmpresasNulos() throws Exception {				
		
		List<ParametroFactuEmpresa> parametrofactuempresasAux= new ArrayList<ParametroFactuEmpresa>();
		
		for(ParametroFactuEmpresa parametrofactuempresa : this.parametrofactuempresas) {
			if(parametrofactuempresa==null) {
				parametrofactuempresasAux.add(parametrofactuempresa);
			}
		}
		
		//this.parametrofactuempresas=parametrofactuempresasAux;
		
		this.parametrofactuempresas.removeAll(parametrofactuempresasAux);
	}
	
	public void getSetVersionRowParametroFactuEmpresaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametrofactuempresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametrofactuempresa.getIsDeleted() || (parametrofactuempresa.getIsChanged()&&!parametrofactuempresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametrofactuempresaDataAccess.getSetVersionRowParametroFactuEmpresa(connexion,parametrofactuempresa.getId());
				
				if(!parametrofactuempresa.getVersionRow().equals(timestamp)) {	
					parametrofactuempresa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametrofactuempresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroFactuEmpresa()throws Exception {	
		
		if(parametrofactuempresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametrofactuempresa.getIsDeleted() || (parametrofactuempresa.getIsChanged()&&!parametrofactuempresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametrofactuempresaDataAccess.getSetVersionRowParametroFactuEmpresa(connexion,parametrofactuempresa.getId());
			
			try {							
				if(!parametrofactuempresa.getVersionRow().equals(timestamp)) {	
					parametrofactuempresa.setVersionRow(timestamp);
				}
				
				parametrofactuempresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroFactuEmpresasWithConnection()throws Exception {	
		if(parametrofactuempresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroFactuEmpresa parametrofactuempresaAux:parametrofactuempresas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametrofactuempresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrofactuempresaAux.getIsDeleted() || (parametrofactuempresaAux.getIsChanged()&&!parametrofactuempresaAux.getIsNew())) {
						
						timestamp=parametrofactuempresaDataAccess.getSetVersionRowParametroFactuEmpresa(connexion,parametrofactuempresaAux.getId());
						
						if(!parametrofactuempresa.getVersionRow().equals(timestamp)) {	
							parametrofactuempresaAux.setVersionRow(timestamp);
						}
								
						parametrofactuempresaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroFactuEmpresas()throws Exception {	
		if(parametrofactuempresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroFactuEmpresa parametrofactuempresaAux:parametrofactuempresas) {
					if(parametrofactuempresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrofactuempresaAux.getIsDeleted() || (parametrofactuempresaAux.getIsChanged()&&!parametrofactuempresaAux.getIsNew())) {
						
						timestamp=parametrofactuempresaDataAccess.getSetVersionRowParametroFactuEmpresa(connexion,parametrofactuempresaAux.getId());
						
						if(!parametrofactuempresaAux.getVersionRow().equals(timestamp)) {	
							parametrofactuempresaAux.setVersionRow(timestamp);
						}
						
													
						parametrofactuempresaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroFactuEmpresaParameterReturnGeneral cargarCombosLoteForeignKeyParametroFactuEmpresaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpresaOrigen,String finalQueryGlobalSucursal,String finalQueryGlobalTransaccionOrigen,String finalQueryGlobalBodegaOrigen,String finalQueryGlobalClienteOrigen,String finalQueryGlobalEmpresaDestino,String finalQueryGlobalSucursalDestino,String finalQueryGlobalTransaccionDestino,String finalQueryGlobalBodegaDestino,String finalQueryGlobalClienteDestino,String finalQueryGlobalEmpresaMultiDestino,String finalQueryGlobalSucursalMultiDestino,String finalQueryGlobalTransaccionMultiDestino,String finalQueryGlobalBodegaMultiOrigen,String finalQueryGlobalBodegaMultiDestino) throws Exception {
		ParametroFactuEmpresaParameterReturnGeneral  parametrofactuempresaReturnGeneral =new ParametroFactuEmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroFactuEmpresaWithConnection");connexion.begin();
			
			parametrofactuempresaReturnGeneral =new ParametroFactuEmpresaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrofactuempresaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empresa> empresaorigensForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaorigenLogic=new EmpresaLogic();
			empresaorigenLogic.setConnexion(this.connexion);
			empresaorigenLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresaOrigen.equals("NONE")) {
				empresaorigenLogic.getTodosEmpresas(finalQueryGlobalEmpresaOrigen,new Pagination());
				empresaorigensForeignKey=empresaorigenLogic.getEmpresas();
			}

			parametrofactuempresaReturnGeneral.setempresaorigensForeignKey(empresaorigensForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrofactuempresaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Transaccion> transaccionorigensForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionorigenLogic=new TransaccionLogic();
			transaccionorigenLogic.setConnexion(this.connexion);
			transaccionorigenLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionOrigen.equals("NONE")) {
				transaccionorigenLogic.getTodosTransaccions(finalQueryGlobalTransaccionOrigen,new Pagination());
				transaccionorigensForeignKey=transaccionorigenLogic.getTransaccions();
			}

			parametrofactuempresaReturnGeneral.settransaccionorigensForeignKey(transaccionorigensForeignKey);


			List<Bodega> bodegaorigensForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaorigenLogic=new BodegaLogic();
			bodegaorigenLogic.setConnexion(this.connexion);
			bodegaorigenLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaOrigen.equals("NONE")) {
				bodegaorigenLogic.getTodosBodegas(finalQueryGlobalBodegaOrigen,new Pagination());
				bodegaorigensForeignKey=bodegaorigenLogic.getBodegas();
			}

			parametrofactuempresaReturnGeneral.setbodegaorigensForeignKey(bodegaorigensForeignKey);


			List<Cliente> clienteorigensForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteorigenLogic=new ClienteLogic();
			clienteorigenLogic.setConnexion(this.connexion);
			clienteorigenLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalClienteOrigen.equals("NONE")) {
				clienteorigenLogic.getTodosClientes(finalQueryGlobalClienteOrigen,new Pagination());
				clienteorigensForeignKey=clienteorigenLogic.getClientes();
			}

			parametrofactuempresaReturnGeneral.setclienteorigensForeignKey(clienteorigensForeignKey);


			List<Empresa> empresadestinosForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresadestinoLogic=new EmpresaLogic();
			empresadestinoLogic.setConnexion(this.connexion);
			empresadestinoLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresaDestino.equals("NONE")) {
				empresadestinoLogic.getTodosEmpresas(finalQueryGlobalEmpresaDestino,new Pagination());
				empresadestinosForeignKey=empresadestinoLogic.getEmpresas();
			}

			parametrofactuempresaReturnGeneral.setempresadestinosForeignKey(empresadestinosForeignKey);


			List<Sucursal> sucursaldestinosForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursaldestinoLogic=new SucursalLogic();
			sucursaldestinoLogic.setConnexion(this.connexion);
			sucursaldestinoLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursalDestino.equals("NONE")) {
				sucursaldestinoLogic.getTodosSucursals(finalQueryGlobalSucursalDestino,new Pagination());
				sucursaldestinosForeignKey=sucursaldestinoLogic.getSucursals();
			}

			parametrofactuempresaReturnGeneral.setsucursaldestinosForeignKey(sucursaldestinosForeignKey);


			List<Transaccion> transacciondestinosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transacciondestinoLogic=new TransaccionLogic();
			transacciondestinoLogic.setConnexion(this.connexion);
			transacciondestinoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionDestino.equals("NONE")) {
				transacciondestinoLogic.getTodosTransaccions(finalQueryGlobalTransaccionDestino,new Pagination());
				transacciondestinosForeignKey=transacciondestinoLogic.getTransaccions();
			}

			parametrofactuempresaReturnGeneral.settransacciondestinosForeignKey(transacciondestinosForeignKey);


			List<Bodega> bodegadestinosForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegadestinoLogic=new BodegaLogic();
			bodegadestinoLogic.setConnexion(this.connexion);
			bodegadestinoLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaDestino.equals("NONE")) {
				bodegadestinoLogic.getTodosBodegas(finalQueryGlobalBodegaDestino,new Pagination());
				bodegadestinosForeignKey=bodegadestinoLogic.getBodegas();
			}

			parametrofactuempresaReturnGeneral.setbodegadestinosForeignKey(bodegadestinosForeignKey);


			List<Cliente> clientedestinosForeignKey=new ArrayList<Cliente>();
			ClienteLogic clientedestinoLogic=new ClienteLogic();
			clientedestinoLogic.setConnexion(this.connexion);
			clientedestinoLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalClienteDestino.equals("NONE")) {
				clientedestinoLogic.getTodosClientes(finalQueryGlobalClienteDestino,new Pagination());
				clientedestinosForeignKey=clientedestinoLogic.getClientes();
			}

			parametrofactuempresaReturnGeneral.setclientedestinosForeignKey(clientedestinosForeignKey);


			List<Empresa> empresamultidestinosForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresamultidestinoLogic=new EmpresaLogic();
			empresamultidestinoLogic.setConnexion(this.connexion);
			empresamultidestinoLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresaMultiDestino.equals("NONE")) {
				empresamultidestinoLogic.getTodosEmpresas(finalQueryGlobalEmpresaMultiDestino,new Pagination());
				empresamultidestinosForeignKey=empresamultidestinoLogic.getEmpresas();
			}

			parametrofactuempresaReturnGeneral.setempresamultidestinosForeignKey(empresamultidestinosForeignKey);


			List<Sucursal> sucursalmultidestinosForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalmultidestinoLogic=new SucursalLogic();
			sucursalmultidestinoLogic.setConnexion(this.connexion);
			sucursalmultidestinoLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursalMultiDestino.equals("NONE")) {
				sucursalmultidestinoLogic.getTodosSucursals(finalQueryGlobalSucursalMultiDestino,new Pagination());
				sucursalmultidestinosForeignKey=sucursalmultidestinoLogic.getSucursals();
			}

			parametrofactuempresaReturnGeneral.setsucursalmultidestinosForeignKey(sucursalmultidestinosForeignKey);


			List<Transaccion> transaccionmultidestinosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionmultidestinoLogic=new TransaccionLogic();
			transaccionmultidestinoLogic.setConnexion(this.connexion);
			transaccionmultidestinoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionMultiDestino.equals("NONE")) {
				transaccionmultidestinoLogic.getTodosTransaccions(finalQueryGlobalTransaccionMultiDestino,new Pagination());
				transaccionmultidestinosForeignKey=transaccionmultidestinoLogic.getTransaccions();
			}

			parametrofactuempresaReturnGeneral.settransaccionmultidestinosForeignKey(transaccionmultidestinosForeignKey);


			List<Bodega> bodegamultiorigensForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegamultiorigenLogic=new BodegaLogic();
			bodegamultiorigenLogic.setConnexion(this.connexion);
			bodegamultiorigenLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaMultiOrigen.equals("NONE")) {
				bodegamultiorigenLogic.getTodosBodegas(finalQueryGlobalBodegaMultiOrigen,new Pagination());
				bodegamultiorigensForeignKey=bodegamultiorigenLogic.getBodegas();
			}

			parametrofactuempresaReturnGeneral.setbodegamultiorigensForeignKey(bodegamultiorigensForeignKey);


			List<Bodega> bodegamultidestinosForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegamultidestinoLogic=new BodegaLogic();
			bodegamultidestinoLogic.setConnexion(this.connexion);
			bodegamultidestinoLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaMultiDestino.equals("NONE")) {
				bodegamultidestinoLogic.getTodosBodegas(finalQueryGlobalBodegaMultiDestino,new Pagination());
				bodegamultidestinosForeignKey=bodegamultidestinoLogic.getBodegas();
			}

			parametrofactuempresaReturnGeneral.setbodegamultidestinosForeignKey(bodegamultidestinosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametrofactuempresaReturnGeneral;
	}
	
	public ParametroFactuEmpresaParameterReturnGeneral cargarCombosLoteForeignKeyParametroFactuEmpresa(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpresaOrigen,String finalQueryGlobalSucursal,String finalQueryGlobalTransaccionOrigen,String finalQueryGlobalBodegaOrigen,String finalQueryGlobalClienteOrigen,String finalQueryGlobalEmpresaDestino,String finalQueryGlobalSucursalDestino,String finalQueryGlobalTransaccionDestino,String finalQueryGlobalBodegaDestino,String finalQueryGlobalClienteDestino,String finalQueryGlobalEmpresaMultiDestino,String finalQueryGlobalSucursalMultiDestino,String finalQueryGlobalTransaccionMultiDestino,String finalQueryGlobalBodegaMultiOrigen,String finalQueryGlobalBodegaMultiDestino) throws Exception {
		ParametroFactuEmpresaParameterReturnGeneral  parametrofactuempresaReturnGeneral =new ParametroFactuEmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametrofactuempresaReturnGeneral =new ParametroFactuEmpresaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrofactuempresaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empresa> empresaorigensForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaorigenLogic=new EmpresaLogic();
			empresaorigenLogic.setConnexion(this.connexion);
			empresaorigenLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresaOrigen.equals("NONE")) {
				empresaorigenLogic.getTodosEmpresas(finalQueryGlobalEmpresaOrigen,new Pagination());
				empresaorigensForeignKey=empresaorigenLogic.getEmpresas();
			}

			parametrofactuempresaReturnGeneral.setempresaorigensForeignKey(empresaorigensForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrofactuempresaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Transaccion> transaccionorigensForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionorigenLogic=new TransaccionLogic();
			transaccionorigenLogic.setConnexion(this.connexion);
			transaccionorigenLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionOrigen.equals("NONE")) {
				transaccionorigenLogic.getTodosTransaccions(finalQueryGlobalTransaccionOrigen,new Pagination());
				transaccionorigensForeignKey=transaccionorigenLogic.getTransaccions();
			}

			parametrofactuempresaReturnGeneral.settransaccionorigensForeignKey(transaccionorigensForeignKey);


			List<Bodega> bodegaorigensForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaorigenLogic=new BodegaLogic();
			bodegaorigenLogic.setConnexion(this.connexion);
			bodegaorigenLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaOrigen.equals("NONE")) {
				bodegaorigenLogic.getTodosBodegas(finalQueryGlobalBodegaOrigen,new Pagination());
				bodegaorigensForeignKey=bodegaorigenLogic.getBodegas();
			}

			parametrofactuempresaReturnGeneral.setbodegaorigensForeignKey(bodegaorigensForeignKey);


			List<Cliente> clienteorigensForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteorigenLogic=new ClienteLogic();
			clienteorigenLogic.setConnexion(this.connexion);
			clienteorigenLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalClienteOrigen.equals("NONE")) {
				clienteorigenLogic.getTodosClientes(finalQueryGlobalClienteOrigen,new Pagination());
				clienteorigensForeignKey=clienteorigenLogic.getClientes();
			}

			parametrofactuempresaReturnGeneral.setclienteorigensForeignKey(clienteorigensForeignKey);


			List<Empresa> empresadestinosForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresadestinoLogic=new EmpresaLogic();
			empresadestinoLogic.setConnexion(this.connexion);
			empresadestinoLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresaDestino.equals("NONE")) {
				empresadestinoLogic.getTodosEmpresas(finalQueryGlobalEmpresaDestino,new Pagination());
				empresadestinosForeignKey=empresadestinoLogic.getEmpresas();
			}

			parametrofactuempresaReturnGeneral.setempresadestinosForeignKey(empresadestinosForeignKey);


			List<Sucursal> sucursaldestinosForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursaldestinoLogic=new SucursalLogic();
			sucursaldestinoLogic.setConnexion(this.connexion);
			sucursaldestinoLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursalDestino.equals("NONE")) {
				sucursaldestinoLogic.getTodosSucursals(finalQueryGlobalSucursalDestino,new Pagination());
				sucursaldestinosForeignKey=sucursaldestinoLogic.getSucursals();
			}

			parametrofactuempresaReturnGeneral.setsucursaldestinosForeignKey(sucursaldestinosForeignKey);


			List<Transaccion> transacciondestinosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transacciondestinoLogic=new TransaccionLogic();
			transacciondestinoLogic.setConnexion(this.connexion);
			transacciondestinoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionDestino.equals("NONE")) {
				transacciondestinoLogic.getTodosTransaccions(finalQueryGlobalTransaccionDestino,new Pagination());
				transacciondestinosForeignKey=transacciondestinoLogic.getTransaccions();
			}

			parametrofactuempresaReturnGeneral.settransacciondestinosForeignKey(transacciondestinosForeignKey);


			List<Bodega> bodegadestinosForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegadestinoLogic=new BodegaLogic();
			bodegadestinoLogic.setConnexion(this.connexion);
			bodegadestinoLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaDestino.equals("NONE")) {
				bodegadestinoLogic.getTodosBodegas(finalQueryGlobalBodegaDestino,new Pagination());
				bodegadestinosForeignKey=bodegadestinoLogic.getBodegas();
			}

			parametrofactuempresaReturnGeneral.setbodegadestinosForeignKey(bodegadestinosForeignKey);


			List<Cliente> clientedestinosForeignKey=new ArrayList<Cliente>();
			ClienteLogic clientedestinoLogic=new ClienteLogic();
			clientedestinoLogic.setConnexion(this.connexion);
			clientedestinoLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalClienteDestino.equals("NONE")) {
				clientedestinoLogic.getTodosClientes(finalQueryGlobalClienteDestino,new Pagination());
				clientedestinosForeignKey=clientedestinoLogic.getClientes();
			}

			parametrofactuempresaReturnGeneral.setclientedestinosForeignKey(clientedestinosForeignKey);


			List<Empresa> empresamultidestinosForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresamultidestinoLogic=new EmpresaLogic();
			empresamultidestinoLogic.setConnexion(this.connexion);
			empresamultidestinoLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresaMultiDestino.equals("NONE")) {
				empresamultidestinoLogic.getTodosEmpresas(finalQueryGlobalEmpresaMultiDestino,new Pagination());
				empresamultidestinosForeignKey=empresamultidestinoLogic.getEmpresas();
			}

			parametrofactuempresaReturnGeneral.setempresamultidestinosForeignKey(empresamultidestinosForeignKey);


			List<Sucursal> sucursalmultidestinosForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalmultidestinoLogic=new SucursalLogic();
			sucursalmultidestinoLogic.setConnexion(this.connexion);
			sucursalmultidestinoLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursalMultiDestino.equals("NONE")) {
				sucursalmultidestinoLogic.getTodosSucursals(finalQueryGlobalSucursalMultiDestino,new Pagination());
				sucursalmultidestinosForeignKey=sucursalmultidestinoLogic.getSucursals();
			}

			parametrofactuempresaReturnGeneral.setsucursalmultidestinosForeignKey(sucursalmultidestinosForeignKey);


			List<Transaccion> transaccionmultidestinosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionmultidestinoLogic=new TransaccionLogic();
			transaccionmultidestinoLogic.setConnexion(this.connexion);
			transaccionmultidestinoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionMultiDestino.equals("NONE")) {
				transaccionmultidestinoLogic.getTodosTransaccions(finalQueryGlobalTransaccionMultiDestino,new Pagination());
				transaccionmultidestinosForeignKey=transaccionmultidestinoLogic.getTransaccions();
			}

			parametrofactuempresaReturnGeneral.settransaccionmultidestinosForeignKey(transaccionmultidestinosForeignKey);


			List<Bodega> bodegamultiorigensForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegamultiorigenLogic=new BodegaLogic();
			bodegamultiorigenLogic.setConnexion(this.connexion);
			bodegamultiorigenLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaMultiOrigen.equals("NONE")) {
				bodegamultiorigenLogic.getTodosBodegas(finalQueryGlobalBodegaMultiOrigen,new Pagination());
				bodegamultiorigensForeignKey=bodegamultiorigenLogic.getBodegas();
			}

			parametrofactuempresaReturnGeneral.setbodegamultiorigensForeignKey(bodegamultiorigensForeignKey);


			List<Bodega> bodegamultidestinosForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegamultidestinoLogic=new BodegaLogic();
			bodegamultidestinoLogic.setConnexion(this.connexion);
			bodegamultidestinoLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaMultiDestino.equals("NONE")) {
				bodegamultidestinoLogic.getTodosBodegas(finalQueryGlobalBodegaMultiDestino,new Pagination());
				bodegamultidestinosForeignKey=bodegamultidestinoLogic.getBodegas();
			}

			parametrofactuempresaReturnGeneral.setbodegamultidestinosForeignKey(bodegamultidestinosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametrofactuempresaReturnGeneral;
	}
	
	
	public void deepLoad(ParametroFactuEmpresa parametrofactuempresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroFactuEmpresaLogicAdditional.updateParametroFactuEmpresaToGet(parametrofactuempresa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrofactuempresa.setEmpresa(parametrofactuempresaDataAccess.getEmpresa(connexion,parametrofactuempresa));
		parametrofactuempresa.setEmpresaOrigen(parametrofactuempresaDataAccess.getEmpresaOrigen(connexion,parametrofactuempresa));
		parametrofactuempresa.setSucursal(parametrofactuempresaDataAccess.getSucursal(connexion,parametrofactuempresa));
		parametrofactuempresa.setTransaccionOrigen(parametrofactuempresaDataAccess.getTransaccionOrigen(connexion,parametrofactuempresa));
		parametrofactuempresa.setBodegaOrigen(parametrofactuempresaDataAccess.getBodegaOrigen(connexion,parametrofactuempresa));
		parametrofactuempresa.setClienteOrigen(parametrofactuempresaDataAccess.getClienteOrigen(connexion,parametrofactuempresa));
		parametrofactuempresa.setEmpresaDestino(parametrofactuempresaDataAccess.getEmpresaDestino(connexion,parametrofactuempresa));
		parametrofactuempresa.setSucursalDestino(parametrofactuempresaDataAccess.getSucursalDestino(connexion,parametrofactuempresa));
		parametrofactuempresa.setTransaccionDestino(parametrofactuempresaDataAccess.getTransaccionDestino(connexion,parametrofactuempresa));
		parametrofactuempresa.setBodegaDestino(parametrofactuempresaDataAccess.getBodegaDestino(connexion,parametrofactuempresa));
		parametrofactuempresa.setClienteDestino(parametrofactuempresaDataAccess.getClienteDestino(connexion,parametrofactuempresa));
		parametrofactuempresa.setEmpresaMultiDestino(parametrofactuempresaDataAccess.getEmpresaMultiDestino(connexion,parametrofactuempresa));
		parametrofactuempresa.setSucursalMultiDestino(parametrofactuempresaDataAccess.getSucursalMultiDestino(connexion,parametrofactuempresa));
		parametrofactuempresa.setTransaccionMultiDestino(parametrofactuempresaDataAccess.getTransaccionMultiDestino(connexion,parametrofactuempresa));
		parametrofactuempresa.setBodegaMultiOrigen(parametrofactuempresaDataAccess.getBodegaMultiOrigen(connexion,parametrofactuempresa));
		parametrofactuempresa.setBodegaMultiDestino(parametrofactuempresaDataAccess.getBodegaMultiDestino(connexion,parametrofactuempresa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrofactuempresa.setEmpresa(parametrofactuempresaDataAccess.getEmpresa(connexion,parametrofactuempresa));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				parametrofactuempresa.setEmpresaOrigen(parametrofactuempresaDataAccess.getEmpresaOrigen(connexion,parametrofactuempresa));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrofactuempresa.setSucursal(parametrofactuempresaDataAccess.getSucursal(connexion,parametrofactuempresa));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactuempresa.setTransaccionOrigen(parametrofactuempresaDataAccess.getTransaccionOrigen(connexion,parametrofactuempresa));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametrofactuempresa.setBodegaOrigen(parametrofactuempresaDataAccess.getBodegaOrigen(connexion,parametrofactuempresa));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				parametrofactuempresa.setClienteOrigen(parametrofactuempresaDataAccess.getClienteOrigen(connexion,parametrofactuempresa));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				parametrofactuempresa.setEmpresaDestino(parametrofactuempresaDataAccess.getEmpresaDestino(connexion,parametrofactuempresa));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrofactuempresa.setSucursalDestino(parametrofactuempresaDataAccess.getSucursalDestino(connexion,parametrofactuempresa));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactuempresa.setTransaccionDestino(parametrofactuempresaDataAccess.getTransaccionDestino(connexion,parametrofactuempresa));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametrofactuempresa.setBodegaDestino(parametrofactuempresaDataAccess.getBodegaDestino(connexion,parametrofactuempresa));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				parametrofactuempresa.setClienteDestino(parametrofactuempresaDataAccess.getClienteDestino(connexion,parametrofactuempresa));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				parametrofactuempresa.setEmpresaMultiDestino(parametrofactuempresaDataAccess.getEmpresaMultiDestino(connexion,parametrofactuempresa));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrofactuempresa.setSucursalMultiDestino(parametrofactuempresaDataAccess.getSucursalMultiDestino(connexion,parametrofactuempresa));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactuempresa.setTransaccionMultiDestino(parametrofactuempresaDataAccess.getTransaccionMultiDestino(connexion,parametrofactuempresa));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametrofactuempresa.setBodegaMultiOrigen(parametrofactuempresaDataAccess.getBodegaMultiOrigen(connexion,parametrofactuempresa));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametrofactuempresa.setBodegaMultiDestino(parametrofactuempresaDataAccess.getBodegaMultiDestino(connexion,parametrofactuempresa));
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
			parametrofactuempresa.setEmpresa(parametrofactuempresaDataAccess.getEmpresa(connexion,parametrofactuempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setEmpresaOrigen(parametrofactuempresaDataAccess.getEmpresaOrigen(connexion,parametrofactuempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setSucursal(parametrofactuempresaDataAccess.getSucursal(connexion,parametrofactuempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setTransaccionOrigen(parametrofactuempresaDataAccess.getTransaccionOrigen(connexion,parametrofactuempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setBodegaOrigen(parametrofactuempresaDataAccess.getBodegaOrigen(connexion,parametrofactuempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setClienteOrigen(parametrofactuempresaDataAccess.getClienteOrigen(connexion,parametrofactuempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setEmpresaDestino(parametrofactuempresaDataAccess.getEmpresaDestino(connexion,parametrofactuempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setSucursalDestino(parametrofactuempresaDataAccess.getSucursalDestino(connexion,parametrofactuempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setTransaccionDestino(parametrofactuempresaDataAccess.getTransaccionDestino(connexion,parametrofactuempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setBodegaDestino(parametrofactuempresaDataAccess.getBodegaDestino(connexion,parametrofactuempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setClienteDestino(parametrofactuempresaDataAccess.getClienteDestino(connexion,parametrofactuempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setEmpresaMultiDestino(parametrofactuempresaDataAccess.getEmpresaMultiDestino(connexion,parametrofactuempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setSucursalMultiDestino(parametrofactuempresaDataAccess.getSucursalMultiDestino(connexion,parametrofactuempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setTransaccionMultiDestino(parametrofactuempresaDataAccess.getTransaccionMultiDestino(connexion,parametrofactuempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setBodegaMultiOrigen(parametrofactuempresaDataAccess.getBodegaMultiOrigen(connexion,parametrofactuempresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setBodegaMultiDestino(parametrofactuempresaDataAccess.getBodegaMultiDestino(connexion,parametrofactuempresa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrofactuempresa.setEmpresa(parametrofactuempresaDataAccess.getEmpresa(connexion,parametrofactuempresa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrofactuempresa.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametrofactuempresa.setEmpresaOrigen(parametrofactuempresaDataAccess.getEmpresaOrigen(connexion,parametrofactuempresa));
		EmpresaLogic empresaorigenLogic= new EmpresaLogic(connexion);
		empresaorigenLogic.deepLoad(parametrofactuempresa.getEmpresaOrigen(),isDeep,deepLoadType,clases);
				
		parametrofactuempresa.setSucursal(parametrofactuempresaDataAccess.getSucursal(connexion,parametrofactuempresa));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrofactuempresa.getSucursal(),isDeep,deepLoadType,clases);
				
		parametrofactuempresa.setTransaccionOrigen(parametrofactuempresaDataAccess.getTransaccionOrigen(connexion,parametrofactuempresa));
		TransaccionLogic transaccionorigenLogic= new TransaccionLogic(connexion);
		transaccionorigenLogic.deepLoad(parametrofactuempresa.getTransaccionOrigen(),isDeep,deepLoadType,clases);
				
		parametrofactuempresa.setBodegaOrigen(parametrofactuempresaDataAccess.getBodegaOrigen(connexion,parametrofactuempresa));
		BodegaLogic bodegaorigenLogic= new BodegaLogic(connexion);
		bodegaorigenLogic.deepLoad(parametrofactuempresa.getBodegaOrigen(),isDeep,deepLoadType,clases);
				
		parametrofactuempresa.setClienteOrigen(parametrofactuempresaDataAccess.getClienteOrigen(connexion,parametrofactuempresa));
		ClienteLogic clienteorigenLogic= new ClienteLogic(connexion);
		clienteorigenLogic.deepLoad(parametrofactuempresa.getClienteOrigen(),isDeep,deepLoadType,clases);
				
		parametrofactuempresa.setEmpresaDestino(parametrofactuempresaDataAccess.getEmpresaDestino(connexion,parametrofactuempresa));
		EmpresaLogic empresadestinoLogic= new EmpresaLogic(connexion);
		empresadestinoLogic.deepLoad(parametrofactuempresa.getEmpresaDestino(),isDeep,deepLoadType,clases);
				
		parametrofactuempresa.setSucursalDestino(parametrofactuempresaDataAccess.getSucursalDestino(connexion,parametrofactuempresa));
		SucursalLogic sucursaldestinoLogic= new SucursalLogic(connexion);
		sucursaldestinoLogic.deepLoad(parametrofactuempresa.getSucursalDestino(),isDeep,deepLoadType,clases);
				
		parametrofactuempresa.setTransaccionDestino(parametrofactuempresaDataAccess.getTransaccionDestino(connexion,parametrofactuempresa));
		TransaccionLogic transacciondestinoLogic= new TransaccionLogic(connexion);
		transacciondestinoLogic.deepLoad(parametrofactuempresa.getTransaccionDestino(),isDeep,deepLoadType,clases);
				
		parametrofactuempresa.setBodegaDestino(parametrofactuempresaDataAccess.getBodegaDestino(connexion,parametrofactuempresa));
		BodegaLogic bodegadestinoLogic= new BodegaLogic(connexion);
		bodegadestinoLogic.deepLoad(parametrofactuempresa.getBodegaDestino(),isDeep,deepLoadType,clases);
				
		parametrofactuempresa.setClienteDestino(parametrofactuempresaDataAccess.getClienteDestino(connexion,parametrofactuempresa));
		ClienteLogic clientedestinoLogic= new ClienteLogic(connexion);
		clientedestinoLogic.deepLoad(parametrofactuempresa.getClienteDestino(),isDeep,deepLoadType,clases);
				
		parametrofactuempresa.setEmpresaMultiDestino(parametrofactuempresaDataAccess.getEmpresaMultiDestino(connexion,parametrofactuempresa));
		EmpresaLogic empresamultidestinoLogic= new EmpresaLogic(connexion);
		empresamultidestinoLogic.deepLoad(parametrofactuempresa.getEmpresaMultiDestino(),isDeep,deepLoadType,clases);
				
		parametrofactuempresa.setSucursalMultiDestino(parametrofactuempresaDataAccess.getSucursalMultiDestino(connexion,parametrofactuempresa));
		SucursalLogic sucursalmultidestinoLogic= new SucursalLogic(connexion);
		sucursalmultidestinoLogic.deepLoad(parametrofactuempresa.getSucursalMultiDestino(),isDeep,deepLoadType,clases);
				
		parametrofactuempresa.setTransaccionMultiDestino(parametrofactuempresaDataAccess.getTransaccionMultiDestino(connexion,parametrofactuempresa));
		TransaccionLogic transaccionmultidestinoLogic= new TransaccionLogic(connexion);
		transaccionmultidestinoLogic.deepLoad(parametrofactuempresa.getTransaccionMultiDestino(),isDeep,deepLoadType,clases);
				
		parametrofactuempresa.setBodegaMultiOrigen(parametrofactuempresaDataAccess.getBodegaMultiOrigen(connexion,parametrofactuempresa));
		BodegaLogic bodegamultiorigenLogic= new BodegaLogic(connexion);
		bodegamultiorigenLogic.deepLoad(parametrofactuempresa.getBodegaMultiOrigen(),isDeep,deepLoadType,clases);
				
		parametrofactuempresa.setBodegaMultiDestino(parametrofactuempresaDataAccess.getBodegaMultiDestino(connexion,parametrofactuempresa));
		BodegaLogic bodegamultidestinoLogic= new BodegaLogic(connexion);
		bodegamultidestinoLogic.deepLoad(parametrofactuempresa.getBodegaMultiDestino(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrofactuempresa.setEmpresa(parametrofactuempresaDataAccess.getEmpresa(connexion,parametrofactuempresa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametrofactuempresa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				parametrofactuempresa.setEmpresaOrigen(parametrofactuempresaDataAccess.getEmpresaOrigen(connexion,parametrofactuempresa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametrofactuempresa.getEmpresaOrigen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrofactuempresa.setSucursal(parametrofactuempresaDataAccess.getSucursal(connexion,parametrofactuempresa));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(parametrofactuempresa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactuempresa.setTransaccionOrigen(parametrofactuempresaDataAccess.getTransaccionOrigen(connexion,parametrofactuempresa));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrofactuempresa.getTransaccionOrigen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametrofactuempresa.setBodegaOrigen(parametrofactuempresaDataAccess.getBodegaOrigen(connexion,parametrofactuempresa));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(parametrofactuempresa.getBodegaOrigen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				parametrofactuempresa.setClienteOrigen(parametrofactuempresaDataAccess.getClienteOrigen(connexion,parametrofactuempresa));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(parametrofactuempresa.getClienteOrigen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				parametrofactuempresa.setEmpresaDestino(parametrofactuempresaDataAccess.getEmpresaDestino(connexion,parametrofactuempresa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametrofactuempresa.getEmpresaDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrofactuempresa.setSucursalDestino(parametrofactuempresaDataAccess.getSucursalDestino(connexion,parametrofactuempresa));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(parametrofactuempresa.getSucursalDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactuempresa.setTransaccionDestino(parametrofactuempresaDataAccess.getTransaccionDestino(connexion,parametrofactuempresa));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrofactuempresa.getTransaccionDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametrofactuempresa.setBodegaDestino(parametrofactuempresaDataAccess.getBodegaDestino(connexion,parametrofactuempresa));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(parametrofactuempresa.getBodegaDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				parametrofactuempresa.setClienteDestino(parametrofactuempresaDataAccess.getClienteDestino(connexion,parametrofactuempresa));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(parametrofactuempresa.getClienteDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				parametrofactuempresa.setEmpresaMultiDestino(parametrofactuempresaDataAccess.getEmpresaMultiDestino(connexion,parametrofactuempresa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametrofactuempresa.getEmpresaMultiDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrofactuempresa.setSucursalMultiDestino(parametrofactuempresaDataAccess.getSucursalMultiDestino(connexion,parametrofactuempresa));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(parametrofactuempresa.getSucursalMultiDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactuempresa.setTransaccionMultiDestino(parametrofactuempresaDataAccess.getTransaccionMultiDestino(connexion,parametrofactuempresa));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrofactuempresa.getTransaccionMultiDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametrofactuempresa.setBodegaMultiOrigen(parametrofactuempresaDataAccess.getBodegaMultiOrigen(connexion,parametrofactuempresa));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(parametrofactuempresa.getBodegaMultiOrigen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametrofactuempresa.setBodegaMultiDestino(parametrofactuempresaDataAccess.getBodegaMultiDestino(connexion,parametrofactuempresa));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(parametrofactuempresa.getBodegaMultiDestino(),isDeep,deepLoadType,clases);				
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
			parametrofactuempresa.setEmpresa(parametrofactuempresaDataAccess.getEmpresa(connexion,parametrofactuempresa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametrofactuempresa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setEmpresaOrigen(parametrofactuempresaDataAccess.getEmpresaOrigen(connexion,parametrofactuempresa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametrofactuempresa.getEmpresaOrigen(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setSucursal(parametrofactuempresaDataAccess.getSucursal(connexion,parametrofactuempresa));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(parametrofactuempresa.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setTransaccionOrigen(parametrofactuempresaDataAccess.getTransaccionOrigen(connexion,parametrofactuempresa));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrofactuempresa.getTransaccionOrigen(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setBodegaOrigen(parametrofactuempresaDataAccess.getBodegaOrigen(connexion,parametrofactuempresa));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(parametrofactuempresa.getBodegaOrigen(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setClienteOrigen(parametrofactuempresaDataAccess.getClienteOrigen(connexion,parametrofactuempresa));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(parametrofactuempresa.getClienteOrigen(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setEmpresaDestino(parametrofactuempresaDataAccess.getEmpresaDestino(connexion,parametrofactuempresa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametrofactuempresa.getEmpresaDestino(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setSucursalDestino(parametrofactuempresaDataAccess.getSucursalDestino(connexion,parametrofactuempresa));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(parametrofactuempresa.getSucursalDestino(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setTransaccionDestino(parametrofactuempresaDataAccess.getTransaccionDestino(connexion,parametrofactuempresa));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrofactuempresa.getTransaccionDestino(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setBodegaDestino(parametrofactuempresaDataAccess.getBodegaDestino(connexion,parametrofactuempresa));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(parametrofactuempresa.getBodegaDestino(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setClienteDestino(parametrofactuempresaDataAccess.getClienteDestino(connexion,parametrofactuempresa));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(parametrofactuempresa.getClienteDestino(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setEmpresaMultiDestino(parametrofactuempresaDataAccess.getEmpresaMultiDestino(connexion,parametrofactuempresa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametrofactuempresa.getEmpresaMultiDestino(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setSucursalMultiDestino(parametrofactuempresaDataAccess.getSucursalMultiDestino(connexion,parametrofactuempresa));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(parametrofactuempresa.getSucursalMultiDestino(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setTransaccionMultiDestino(parametrofactuempresaDataAccess.getTransaccionMultiDestino(connexion,parametrofactuempresa));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrofactuempresa.getTransaccionMultiDestino(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setBodegaMultiOrigen(parametrofactuempresaDataAccess.getBodegaMultiOrigen(connexion,parametrofactuempresa));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(parametrofactuempresa.getBodegaMultiOrigen(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactuempresa.setBodegaMultiDestino(parametrofactuempresaDataAccess.getBodegaMultiDestino(connexion,parametrofactuempresa));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(parametrofactuempresa.getBodegaMultiDestino(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroFactuEmpresa parametrofactuempresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroFactuEmpresaLogicAdditional.updateParametroFactuEmpresaToSave(parametrofactuempresa,this.arrDatoGeneral);
			
ParametroFactuEmpresaDataAccess.save(parametrofactuempresa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrofactuempresa.getEmpresa(),connexion);

		EmpresaDataAccess.save(parametrofactuempresa.getEmpresaOrigen(),connexion);

		SucursalDataAccess.save(parametrofactuempresa.getSucursal(),connexion);

		TransaccionDataAccess.save(parametrofactuempresa.getTransaccionOrigen(),connexion);

		BodegaDataAccess.save(parametrofactuempresa.getBodegaOrigen(),connexion);

		ClienteDataAccess.save(parametrofactuempresa.getClienteOrigen(),connexion);

		EmpresaDataAccess.save(parametrofactuempresa.getEmpresaDestino(),connexion);

		SucursalDataAccess.save(parametrofactuempresa.getSucursalDestino(),connexion);

		TransaccionDataAccess.save(parametrofactuempresa.getTransaccionDestino(),connexion);

		BodegaDataAccess.save(parametrofactuempresa.getBodegaDestino(),connexion);

		ClienteDataAccess.save(parametrofactuempresa.getClienteDestino(),connexion);

		EmpresaDataAccess.save(parametrofactuempresa.getEmpresaMultiDestino(),connexion);

		SucursalDataAccess.save(parametrofactuempresa.getSucursalMultiDestino(),connexion);

		TransaccionDataAccess.save(parametrofactuempresa.getTransaccionMultiDestino(),connexion);

		BodegaDataAccess.save(parametrofactuempresa.getBodegaMultiOrigen(),connexion);

		BodegaDataAccess.save(parametrofactuempresa.getBodegaMultiDestino(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrofactuempresa.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrofactuempresa.getEmpresaOrigen(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrofactuempresa.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactuempresa.getTransaccionOrigen(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametrofactuempresa.getBodegaOrigen(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(parametrofactuempresa.getClienteOrigen(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrofactuempresa.getEmpresaDestino(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrofactuempresa.getSucursalDestino(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactuempresa.getTransaccionDestino(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametrofactuempresa.getBodegaDestino(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(parametrofactuempresa.getClienteDestino(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrofactuempresa.getEmpresaMultiDestino(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrofactuempresa.getSucursalMultiDestino(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactuempresa.getTransaccionMultiDestino(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametrofactuempresa.getBodegaMultiOrigen(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametrofactuempresa.getBodegaMultiDestino(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrofactuempresa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrofactuempresa.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(parametrofactuempresa.getEmpresaOrigen(),connexion);
		EmpresaLogic empresaorigenLogic= new EmpresaLogic(connexion);
		empresaorigenLogic.deepLoad(parametrofactuempresa.getEmpresaOrigen(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(parametrofactuempresa.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrofactuempresa.getSucursal(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrofactuempresa.getTransaccionOrigen(),connexion);
		TransaccionLogic transaccionorigenLogic= new TransaccionLogic(connexion);
		transaccionorigenLogic.deepLoad(parametrofactuempresa.getTransaccionOrigen(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(parametrofactuempresa.getBodegaOrigen(),connexion);
		BodegaLogic bodegaorigenLogic= new BodegaLogic(connexion);
		bodegaorigenLogic.deepLoad(parametrofactuempresa.getBodegaOrigen(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(parametrofactuempresa.getClienteOrigen(),connexion);
		ClienteLogic clienteorigenLogic= new ClienteLogic(connexion);
		clienteorigenLogic.deepLoad(parametrofactuempresa.getClienteOrigen(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(parametrofactuempresa.getEmpresaDestino(),connexion);
		EmpresaLogic empresadestinoLogic= new EmpresaLogic(connexion);
		empresadestinoLogic.deepLoad(parametrofactuempresa.getEmpresaDestino(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(parametrofactuempresa.getSucursalDestino(),connexion);
		SucursalLogic sucursaldestinoLogic= new SucursalLogic(connexion);
		sucursaldestinoLogic.deepLoad(parametrofactuempresa.getSucursalDestino(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrofactuempresa.getTransaccionDestino(),connexion);
		TransaccionLogic transacciondestinoLogic= new TransaccionLogic(connexion);
		transacciondestinoLogic.deepLoad(parametrofactuempresa.getTransaccionDestino(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(parametrofactuempresa.getBodegaDestino(),connexion);
		BodegaLogic bodegadestinoLogic= new BodegaLogic(connexion);
		bodegadestinoLogic.deepLoad(parametrofactuempresa.getBodegaDestino(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(parametrofactuempresa.getClienteDestino(),connexion);
		ClienteLogic clientedestinoLogic= new ClienteLogic(connexion);
		clientedestinoLogic.deepLoad(parametrofactuempresa.getClienteDestino(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(parametrofactuempresa.getEmpresaMultiDestino(),connexion);
		EmpresaLogic empresamultidestinoLogic= new EmpresaLogic(connexion);
		empresamultidestinoLogic.deepLoad(parametrofactuempresa.getEmpresaMultiDestino(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(parametrofactuempresa.getSucursalMultiDestino(),connexion);
		SucursalLogic sucursalmultidestinoLogic= new SucursalLogic(connexion);
		sucursalmultidestinoLogic.deepLoad(parametrofactuempresa.getSucursalMultiDestino(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrofactuempresa.getTransaccionMultiDestino(),connexion);
		TransaccionLogic transaccionmultidestinoLogic= new TransaccionLogic(connexion);
		transaccionmultidestinoLogic.deepLoad(parametrofactuempresa.getTransaccionMultiDestino(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(parametrofactuempresa.getBodegaMultiOrigen(),connexion);
		BodegaLogic bodegamultiorigenLogic= new BodegaLogic(connexion);
		bodegamultiorigenLogic.deepLoad(parametrofactuempresa.getBodegaMultiOrigen(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(parametrofactuempresa.getBodegaMultiDestino(),connexion);
		BodegaLogic bodegamultidestinoLogic= new BodegaLogic(connexion);
		bodegamultidestinoLogic.deepLoad(parametrofactuempresa.getBodegaMultiDestino(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrofactuempresa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametrofactuempresa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrofactuempresa.getEmpresaOrigen(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametrofactuempresa.getEmpresaOrigen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrofactuempresa.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(parametrofactuempresa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactuempresa.getTransaccionOrigen(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrofactuempresa.getTransaccionOrigen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametrofactuempresa.getBodegaOrigen(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(parametrofactuempresa.getBodegaOrigen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(parametrofactuempresa.getClienteOrigen(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(parametrofactuempresa.getClienteOrigen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrofactuempresa.getEmpresaDestino(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametrofactuempresa.getEmpresaDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrofactuempresa.getSucursalDestino(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(parametrofactuempresa.getSucursalDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactuempresa.getTransaccionDestino(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrofactuempresa.getTransaccionDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametrofactuempresa.getBodegaDestino(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(parametrofactuempresa.getBodegaDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(parametrofactuempresa.getClienteDestino(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(parametrofactuempresa.getClienteDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrofactuempresa.getEmpresaMultiDestino(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametrofactuempresa.getEmpresaMultiDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrofactuempresa.getSucursalMultiDestino(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(parametrofactuempresa.getSucursalMultiDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactuempresa.getTransaccionMultiDestino(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrofactuempresa.getTransaccionMultiDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametrofactuempresa.getBodegaMultiOrigen(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(parametrofactuempresa.getBodegaMultiOrigen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametrofactuempresa.getBodegaMultiDestino(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(parametrofactuempresa.getBodegaMultiDestino(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroFactuEmpresa.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametrofactuempresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(parametrofactuempresa);
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
			this.deepLoad(this.parametrofactuempresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroFactuEmpresa.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametrofactuempresas!=null) {
				for(ParametroFactuEmpresa parametrofactuempresa:parametrofactuempresas) {
					this.deepLoad(parametrofactuempresa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(parametrofactuempresas);
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
			if(parametrofactuempresas!=null) {
				for(ParametroFactuEmpresa parametrofactuempresa:parametrofactuempresas) {
					this.deepLoad(parametrofactuempresa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(parametrofactuempresas);
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
			this.getNewConnexionToDeep(ParametroFactuEmpresa.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametrofactuempresa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroFactuEmpresa.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametrofactuempresas!=null) {
				for(ParametroFactuEmpresa parametrofactuempresa:parametrofactuempresas) {
					this.deepSave(parametrofactuempresa,isDeep,deepLoadType,clases);
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
			if(parametrofactuempresas!=null) {
				for(ParametroFactuEmpresa parametrofactuempresa:parametrofactuempresas) {
					this.deepSave(parametrofactuempresa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroFactuEmpresasFK_IdBodegaDestinoWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega_destino)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_destino,ParametroFactuEmpresaConstantesFunciones.IDBODEGADESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaDestino);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuEmpresasFK_IdBodegaDestino(String sFinalQuery,Pagination pagination,Long id_bodega_destino)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_destino,ParametroFactuEmpresaConstantesFunciones.IDBODEGADESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaDestino);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuEmpresasFK_IdBodegaMultiDestinoWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega_multi_destino)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaMultiDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaMultiDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_multi_destino,ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaMultiDestino);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaMultiDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuEmpresasFK_IdBodegaMultiDestino(String sFinalQuery,Pagination pagination,Long id_bodega_multi_destino)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaMultiDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaMultiDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_multi_destino,ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaMultiDestino);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaMultiDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuEmpresasFK_IdBodegaMultiOrigenWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega_multi_origen)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaMultiOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaMultiOrigen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_multi_origen,ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaMultiOrigen);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaMultiOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuEmpresasFK_IdBodegaMultiOrigen(String sFinalQuery,Pagination pagination,Long id_bodega_multi_origen)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaMultiOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaMultiOrigen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_multi_origen,ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaMultiOrigen);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaMultiOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuEmpresasFK_IdBodegaOrigenWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega_origen)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaOrigen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_origen,ParametroFactuEmpresaConstantesFunciones.IDBODEGAORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaOrigen);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuEmpresasFK_IdBodegaOrigen(String sFinalQuery,Pagination pagination,Long id_bodega_origen)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaOrigen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_origen,ParametroFactuEmpresaConstantesFunciones.IDBODEGAORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaOrigen);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuEmpresasFK_IdClienteDestinoWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente_destino)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidClienteDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidClienteDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente_destino,ParametroFactuEmpresaConstantesFunciones.IDCLIENTEDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidClienteDestino);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdClienteDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuEmpresasFK_IdClienteDestino(String sFinalQuery,Pagination pagination,Long id_cliente_destino)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidClienteDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidClienteDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente_destino,ParametroFactuEmpresaConstantesFunciones.IDCLIENTEDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidClienteDestino);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdClienteDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuEmpresasFK_IdClienteOrigenWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente_origen)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidClienteOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidClienteOrigen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente_origen,ParametroFactuEmpresaConstantesFunciones.IDCLIENTEORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidClienteOrigen);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdClienteOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuEmpresasFK_IdClienteOrigen(String sFinalQuery,Pagination pagination,Long id_cliente_origen)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidClienteOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidClienteOrigen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente_origen,ParametroFactuEmpresaConstantesFunciones.IDCLIENTEORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidClienteOrigen);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdClienteOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuEmpresasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroFactuEmpresaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuEmpresasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroFactuEmpresaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuEmpresasFK_IdEmpresaDestinoWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa_destino)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresaDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresaDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa_destino,ParametroFactuEmpresaConstantesFunciones.IDEMPRESADESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresaDestino);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresaDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuEmpresasFK_IdEmpresaDestino(String sFinalQuery,Pagination pagination,Long id_empresa_destino)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresaDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresaDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa_destino,ParametroFactuEmpresaConstantesFunciones.IDEMPRESADESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresaDestino);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresaDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuEmpresasFK_IdEmpresaMultiDestinoWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa_multi_destino)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresaMultiDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresaMultiDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa_multi_destino,ParametroFactuEmpresaConstantesFunciones.IDEMPRESAMULTIDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresaMultiDestino);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresaMultiDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuEmpresasFK_IdEmpresaMultiDestino(String sFinalQuery,Pagination pagination,Long id_empresa_multi_destino)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresaMultiDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresaMultiDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa_multi_destino,ParametroFactuEmpresaConstantesFunciones.IDEMPRESAMULTIDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresaMultiDestino);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresaMultiDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuEmpresasFK_IdEmpresaOrigenWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa_origen)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresaOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresaOrigen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa_origen,ParametroFactuEmpresaConstantesFunciones.IDEMPRESAORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresaOrigen);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresaOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuEmpresasFK_IdEmpresaOrigen(String sFinalQuery,Pagination pagination,Long id_empresa_origen)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresaOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresaOrigen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa_origen,ParametroFactuEmpresaConstantesFunciones.IDEMPRESAORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresaOrigen);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresaOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuEmpresasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroFactuEmpresaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuEmpresasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroFactuEmpresaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuEmpresasFK_IdSucursalDestinoWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal_destino)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursalDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursalDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal_destino,ParametroFactuEmpresaConstantesFunciones.IDSUCURSALDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursalDestino);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursalDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuEmpresasFK_IdSucursalDestino(String sFinalQuery,Pagination pagination,Long id_sucursal_destino)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursalDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursalDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal_destino,ParametroFactuEmpresaConstantesFunciones.IDSUCURSALDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursalDestino);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursalDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuEmpresasFK_IdSucursalMultiDestinoWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal_multi_destino)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursalMultiDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursalMultiDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal_multi_destino,ParametroFactuEmpresaConstantesFunciones.IDSUCURSALMULTIDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursalMultiDestino);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursalMultiDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuEmpresasFK_IdSucursalMultiDestino(String sFinalQuery,Pagination pagination,Long id_sucursal_multi_destino)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursalMultiDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursalMultiDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal_multi_destino,ParametroFactuEmpresaConstantesFunciones.IDSUCURSALMULTIDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursalMultiDestino);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursalMultiDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuEmpresasFK_IdTransaccionDestinoWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_destino)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_destino,ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionDestino);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuEmpresasFK_IdTransaccionDestino(String sFinalQuery,Pagination pagination,Long id_transaccion_destino)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_destino,ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionDestino);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuEmpresasFK_IdTransaccionMultiDestinoWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_multi_destino)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionMultiDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionMultiDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_multi_destino,ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONMULTIDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionMultiDestino);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionMultiDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuEmpresasFK_IdTransaccionMultiDestino(String sFinalQuery,Pagination pagination,Long id_transaccion_multi_destino)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionMultiDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionMultiDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_multi_destino,ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONMULTIDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionMultiDestino);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionMultiDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuEmpresasFK_IdTransaccionOrigenWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_origen)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuEmpresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionOrigen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_origen,ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionOrigen);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuEmpresasFK_IdTransaccionOrigen(String sFinalQuery,Pagination pagination,Long id_transaccion_origen)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionOrigen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_origen,ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionOrigen);

			ParametroFactuEmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactuempresas=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuEmpresaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuEmpresa(this.parametrofactuempresas);
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
			if(ParametroFactuEmpresaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFactuEmpresaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroFactuEmpresa parametrofactuempresa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroFactuEmpresaConstantesFunciones.ISCONAUDITORIA) {
				if(parametrofactuempresa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFactuEmpresaDataAccess.TABLENAME, parametrofactuempresa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroFactuEmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroFactuEmpresaLogic.registrarAuditoriaDetallesParametroFactuEmpresa(connexion,parametrofactuempresa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametrofactuempresa.getIsDeleted()) {
					/*if(!parametrofactuempresa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroFactuEmpresaDataAccess.TABLENAME, parametrofactuempresa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroFactuEmpresaLogic.registrarAuditoriaDetallesParametroFactuEmpresa(connexion,parametrofactuempresa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFactuEmpresaDataAccess.TABLENAME, parametrofactuempresa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametrofactuempresa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFactuEmpresaDataAccess.TABLENAME, parametrofactuempresa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroFactuEmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroFactuEmpresaLogic.registrarAuditoriaDetallesParametroFactuEmpresa(connexion,parametrofactuempresa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroFactuEmpresa(Connexion connexion,ParametroFactuEmpresa parametrofactuempresa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametrofactuempresa.getIsNew()||!parametrofactuempresa.getid_empresa().equals(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_empresa()!=null)
				{
					strValorActual=parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_empresa().toString();
				}
				if(parametrofactuempresa.getid_empresa()!=null)
				{
					strValorNuevo=parametrofactuempresa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuEmpresaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuempresa.getIsNew()||!parametrofactuempresa.getid_empresa_origen().equals(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_empresa_origen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_empresa_origen()!=null)
				{
					strValorActual=parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_empresa_origen().toString();
				}
				if(parametrofactuempresa.getid_empresa_origen()!=null)
				{
					strValorNuevo=parametrofactuempresa.getid_empresa_origen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuEmpresaConstantesFunciones.IDEMPRESAORIGEN,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuempresa.getIsNew()||!parametrofactuempresa.getid_sucursal().equals(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_sucursal()!=null)
				{
					strValorActual=parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_sucursal().toString();
				}
				if(parametrofactuempresa.getid_sucursal()!=null)
				{
					strValorNuevo=parametrofactuempresa.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuEmpresaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuempresa.getIsNew()||!parametrofactuempresa.getid_transaccion_origen().equals(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_transaccion_origen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_transaccion_origen()!=null)
				{
					strValorActual=parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_transaccion_origen().toString();
				}
				if(parametrofactuempresa.getid_transaccion_origen()!=null)
				{
					strValorNuevo=parametrofactuempresa.getid_transaccion_origen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONORIGEN,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuempresa.getIsNew()||!parametrofactuempresa.getid_bodega_origen().equals(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_bodega_origen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_bodega_origen()!=null)
				{
					strValorActual=parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_bodega_origen().toString();
				}
				if(parametrofactuempresa.getid_bodega_origen()!=null)
				{
					strValorNuevo=parametrofactuempresa.getid_bodega_origen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuEmpresaConstantesFunciones.IDBODEGAORIGEN,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuempresa.getIsNew()||!parametrofactuempresa.getid_cliente_origen().equals(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_cliente_origen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_cliente_origen()!=null)
				{
					strValorActual=parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_cliente_origen().toString();
				}
				if(parametrofactuempresa.getid_cliente_origen()!=null)
				{
					strValorNuevo=parametrofactuempresa.getid_cliente_origen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuEmpresaConstantesFunciones.IDCLIENTEORIGEN,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuempresa.getIsNew()||!parametrofactuempresa.getcosto_origen().equals(parametrofactuempresa.getParametroFactuEmpresaOriginal().getcosto_origen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuempresa.getParametroFactuEmpresaOriginal().getcosto_origen()!=null)
				{
					strValorActual=parametrofactuempresa.getParametroFactuEmpresaOriginal().getcosto_origen().toString();
				}
				if(parametrofactuempresa.getcosto_origen()!=null)
				{
					strValorNuevo=parametrofactuempresa.getcosto_origen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuEmpresaConstantesFunciones.COSTOORIGEN,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuempresa.getIsNew()||!parametrofactuempresa.getid_empresa_destino().equals(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_empresa_destino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_empresa_destino()!=null)
				{
					strValorActual=parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_empresa_destino().toString();
				}
				if(parametrofactuempresa.getid_empresa_destino()!=null)
				{
					strValorNuevo=parametrofactuempresa.getid_empresa_destino().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuEmpresaConstantesFunciones.IDEMPRESADESTINO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuempresa.getIsNew()||!parametrofactuempresa.getid_sucursal_destino().equals(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_sucursal_destino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_sucursal_destino()!=null)
				{
					strValorActual=parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_sucursal_destino().toString();
				}
				if(parametrofactuempresa.getid_sucursal_destino()!=null)
				{
					strValorNuevo=parametrofactuempresa.getid_sucursal_destino().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuEmpresaConstantesFunciones.IDSUCURSALDESTINO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuempresa.getIsNew()||!parametrofactuempresa.getid_transaccion_destino().equals(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_transaccion_destino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_transaccion_destino()!=null)
				{
					strValorActual=parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_transaccion_destino().toString();
				}
				if(parametrofactuempresa.getid_transaccion_destino()!=null)
				{
					strValorNuevo=parametrofactuempresa.getid_transaccion_destino().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONDESTINO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuempresa.getIsNew()||!parametrofactuempresa.getid_bodega_destino().equals(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_bodega_destino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_bodega_destino()!=null)
				{
					strValorActual=parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_bodega_destino().toString();
				}
				if(parametrofactuempresa.getid_bodega_destino()!=null)
				{
					strValorNuevo=parametrofactuempresa.getid_bodega_destino().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuEmpresaConstantesFunciones.IDBODEGADESTINO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuempresa.getIsNew()||!parametrofactuempresa.getid_cliente_destino().equals(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_cliente_destino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_cliente_destino()!=null)
				{
					strValorActual=parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_cliente_destino().toString();
				}
				if(parametrofactuempresa.getid_cliente_destino()!=null)
				{
					strValorNuevo=parametrofactuempresa.getid_cliente_destino().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuEmpresaConstantesFunciones.IDCLIENTEDESTINO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuempresa.getIsNew()||!parametrofactuempresa.getcosto_destino().equals(parametrofactuempresa.getParametroFactuEmpresaOriginal().getcosto_destino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuempresa.getParametroFactuEmpresaOriginal().getcosto_destino()!=null)
				{
					strValorActual=parametrofactuempresa.getParametroFactuEmpresaOriginal().getcosto_destino().toString();
				}
				if(parametrofactuempresa.getcosto_destino()!=null)
				{
					strValorNuevo=parametrofactuempresa.getcosto_destino().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuEmpresaConstantesFunciones.COSTODESTINO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuempresa.getIsNew()||!parametrofactuempresa.getcon_transferencia().equals(parametrofactuempresa.getParametroFactuEmpresaOriginal().getcon_transferencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuempresa.getParametroFactuEmpresaOriginal().getcon_transferencia()!=null)
				{
					strValorActual=parametrofactuempresa.getParametroFactuEmpresaOriginal().getcon_transferencia().toString();
				}
				if(parametrofactuempresa.getcon_transferencia()!=null)
				{
					strValorNuevo=parametrofactuempresa.getcon_transferencia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuEmpresaConstantesFunciones.CONTRANSFERENCIA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuempresa.getIsNew()||!parametrofactuempresa.getid_empresa_multi_destino().equals(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_empresa_multi_destino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_empresa_multi_destino()!=null)
				{
					strValorActual=parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_empresa_multi_destino().toString();
				}
				if(parametrofactuempresa.getid_empresa_multi_destino()!=null)
				{
					strValorNuevo=parametrofactuempresa.getid_empresa_multi_destino().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuEmpresaConstantesFunciones.IDEMPRESAMULTIDESTINO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuempresa.getIsNew()||!parametrofactuempresa.getid_sucursal_multi_destino().equals(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_sucursal_multi_destino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_sucursal_multi_destino()!=null)
				{
					strValorActual=parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_sucursal_multi_destino().toString();
				}
				if(parametrofactuempresa.getid_sucursal_multi_destino()!=null)
				{
					strValorNuevo=parametrofactuempresa.getid_sucursal_multi_destino().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuEmpresaConstantesFunciones.IDSUCURSALMULTIDESTINO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuempresa.getIsNew()||!parametrofactuempresa.getid_transaccion_multi_destino().equals(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_transaccion_multi_destino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_transaccion_multi_destino()!=null)
				{
					strValorActual=parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_transaccion_multi_destino().toString();
				}
				if(parametrofactuempresa.getid_transaccion_multi_destino()!=null)
				{
					strValorNuevo=parametrofactuempresa.getid_transaccion_multi_destino().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuEmpresaConstantesFunciones.IDTRANSACCIONMULTIDESTINO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuempresa.getIsNew()||!parametrofactuempresa.getid_bodega_multi_origen().equals(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_bodega_multi_origen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_bodega_multi_origen()!=null)
				{
					strValorActual=parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_bodega_multi_origen().toString();
				}
				if(parametrofactuempresa.getid_bodega_multi_origen()!=null)
				{
					strValorNuevo=parametrofactuempresa.getid_bodega_multi_origen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIORIGEN,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactuempresa.getIsNew()||!parametrofactuempresa.getid_bodega_multi_destino().equals(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_bodega_multi_destino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_bodega_multi_destino()!=null)
				{
					strValorActual=parametrofactuempresa.getParametroFactuEmpresaOriginal().getid_bodega_multi_destino().toString();
				}
				if(parametrofactuempresa.getid_bodega_multi_destino()!=null)
				{
					strValorNuevo=parametrofactuempresa.getid_bodega_multi_destino().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuEmpresaConstantesFunciones.IDBODEGAMULTIDESTINO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroFactuEmpresaRelacionesWithConnection(ParametroFactuEmpresa parametrofactuempresa) throws Exception {

		if(!parametrofactuempresa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroFactuEmpresaRelacionesBase(parametrofactuempresa,true);
		}
	}

	public void saveParametroFactuEmpresaRelaciones(ParametroFactuEmpresa parametrofactuempresa)throws Exception {

		if(!parametrofactuempresa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroFactuEmpresaRelacionesBase(parametrofactuempresa,false);
		}
	}

	public void saveParametroFactuEmpresaRelacionesBase(ParametroFactuEmpresa parametrofactuempresa,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroFactuEmpresa-saveRelacionesWithConnection");}
	

			this.setParametroFactuEmpresa(parametrofactuempresa);

			if(ParametroFactuEmpresaLogicAdditional.validarSaveRelaciones(parametrofactuempresa,this)) {

				ParametroFactuEmpresaLogicAdditional.updateRelacionesToSave(parametrofactuempresa,this);

				if((parametrofactuempresa.getIsNew()||parametrofactuempresa.getIsChanged())&&!parametrofactuempresa.getIsDeleted()) {
					this.saveParametroFactuEmpresa();
					this.saveParametroFactuEmpresaRelacionesDetalles();

				} else if(parametrofactuempresa.getIsDeleted()) {
					this.saveParametroFactuEmpresaRelacionesDetalles();
					this.saveParametroFactuEmpresa();
				}

				ParametroFactuEmpresaLogicAdditional.updateRelacionesToSaveAfter(parametrofactuempresa,this);

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
	
	
	private void saveParametroFactuEmpresaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroFactuEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroFactuEmpresaConstantesFunciones.getClassesForeignKeysOfParametroFactuEmpresa(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFactuEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroFactuEmpresaConstantesFunciones.getClassesRelationshipsOfParametroFactuEmpresa(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

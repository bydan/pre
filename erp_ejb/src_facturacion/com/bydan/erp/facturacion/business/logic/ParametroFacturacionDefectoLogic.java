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
import com.bydan.erp.facturacion.util.ParametroFacturacionDefectoConstantesFunciones;
import com.bydan.erp.facturacion.util.ParametroFacturacionDefectoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ParametroFacturacionDefectoParameterGeneral;
import com.bydan.erp.facturacion.business.entity.ParametroFacturacionDefecto;
import com.bydan.erp.facturacion.business.logic.ParametroFacturacionDefectoLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroFacturacionDefectoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroFacturacionDefectoLogic.class);
	
	protected ParametroFacturacionDefectoDataAccess parametrofacturaciondefectoDataAccess; 	
	protected ParametroFacturacionDefecto parametrofacturaciondefecto;
	protected List<ParametroFacturacionDefecto> parametrofacturaciondefectos;
	protected Object parametrofacturaciondefectoObject;	
	protected List<Object> parametrofacturaciondefectosObject;
	
	public static ClassValidator<ParametroFacturacionDefecto> parametrofacturaciondefectoValidator = new ClassValidator<ParametroFacturacionDefecto>(ParametroFacturacionDefecto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroFacturacionDefectoLogicAdditional parametrofacturaciondefectoLogicAdditional=null;
	
	public ParametroFacturacionDefectoLogicAdditional getParametroFacturacionDefectoLogicAdditional() {
		return this.parametrofacturaciondefectoLogicAdditional;
	}
	
	public void setParametroFacturacionDefectoLogicAdditional(ParametroFacturacionDefectoLogicAdditional parametrofacturaciondefectoLogicAdditional) {
		try {
			this.parametrofacturaciondefectoLogicAdditional=parametrofacturaciondefectoLogicAdditional;
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
	
	
	
	
	public  ParametroFacturacionDefectoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametrofacturaciondefectoDataAccess = new ParametroFacturacionDefectoDataAccess();
			
			this.parametrofacturaciondefectos= new ArrayList<ParametroFacturacionDefecto>();
			this.parametrofacturaciondefecto= new ParametroFacturacionDefecto();
			
			this.parametrofacturaciondefectoObject=new Object();
			this.parametrofacturaciondefectosObject=new ArrayList<Object>();
				
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
			
			this.parametrofacturaciondefectoDataAccess.setConnexionType(this.connexionType);
			this.parametrofacturaciondefectoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroFacturacionDefectoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametrofacturaciondefectoDataAccess = new ParametroFacturacionDefectoDataAccess();
			this.parametrofacturaciondefectos= new ArrayList<ParametroFacturacionDefecto>();
			this.parametrofacturaciondefecto= new ParametroFacturacionDefecto();
			this.parametrofacturaciondefectoObject=new Object();
			this.parametrofacturaciondefectosObject=new ArrayList<Object>();
			
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
			
			this.parametrofacturaciondefectoDataAccess.setConnexionType(this.connexionType);
			this.parametrofacturaciondefectoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroFacturacionDefecto getParametroFacturacionDefecto() throws Exception {	
		ParametroFacturacionDefectoLogicAdditional.checkParametroFacturacionDefectoToGet(parametrofacturaciondefecto,this.datosCliente,this.arrDatoGeneral);
		ParametroFacturacionDefectoLogicAdditional.updateParametroFacturacionDefectoToGet(parametrofacturaciondefecto,this.arrDatoGeneral);
		
		return parametrofacturaciondefecto;
	}
		
	public void setParametroFacturacionDefecto(ParametroFacturacionDefecto newParametroFacturacionDefecto) {
		this.parametrofacturaciondefecto = newParametroFacturacionDefecto;
	}
	
	public ParametroFacturacionDefectoDataAccess getParametroFacturacionDefectoDataAccess() {
		return parametrofacturaciondefectoDataAccess;
	}
	
	public void setParametroFacturacionDefectoDataAccess(ParametroFacturacionDefectoDataAccess newparametrofacturaciondefectoDataAccess) {
		this.parametrofacturaciondefectoDataAccess = newparametrofacturaciondefectoDataAccess;
	}
	
	public List<ParametroFacturacionDefecto> getParametroFacturacionDefectos() throws Exception {		
		this.quitarParametroFacturacionDefectosNulos();
		
		ParametroFacturacionDefectoLogicAdditional.checkParametroFacturacionDefectoToGets(parametrofacturaciondefectos,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroFacturacionDefecto parametrofacturaciondefectoLocal: parametrofacturaciondefectos ) {
			ParametroFacturacionDefectoLogicAdditional.updateParametroFacturacionDefectoToGet(parametrofacturaciondefectoLocal,this.arrDatoGeneral);
		}
		
		return parametrofacturaciondefectos;
	}
	
	public void setParametroFacturacionDefectos(List<ParametroFacturacionDefecto> newParametroFacturacionDefectos) {
		this.parametrofacturaciondefectos = newParametroFacturacionDefectos;
	}
	
	public Object getParametroFacturacionDefectoObject() {	
		this.parametrofacturaciondefectoObject=this.parametrofacturaciondefectoDataAccess.getEntityObject();
		return this.parametrofacturaciondefectoObject;
	}
		
	public void setParametroFacturacionDefectoObject(Object newParametroFacturacionDefectoObject) {
		this.parametrofacturaciondefectoObject = newParametroFacturacionDefectoObject;
	}
	
	public List<Object> getParametroFacturacionDefectosObject() {		
		this.parametrofacturaciondefectosObject=this.parametrofacturaciondefectoDataAccess.getEntitiesObject();
		return this.parametrofacturaciondefectosObject;
	}
		
	public void setParametroFacturacionDefectosObject(List<Object> newParametroFacturacionDefectosObject) {
		this.parametrofacturaciondefectosObject = newParametroFacturacionDefectosObject;
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
		
		if(this.parametrofacturaciondefectoDataAccess!=null) {
			this.parametrofacturaciondefectoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFacturacionDefecto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametrofacturaciondefectoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametrofacturaciondefectoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametrofacturaciondefecto = new  ParametroFacturacionDefecto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFacturacionDefecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrofacturaciondefecto=parametrofacturaciondefectoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofacturaciondefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefecto);
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
		parametrofacturaciondefecto = new  ParametroFacturacionDefecto();
		  		  
        try {
			
			parametrofacturaciondefecto=parametrofacturaciondefectoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofacturaciondefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametrofacturaciondefecto = new  ParametroFacturacionDefecto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFacturacionDefecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrofacturaciondefecto=parametrofacturaciondefectoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofacturaciondefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefecto);
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
		parametrofacturaciondefecto = new  ParametroFacturacionDefecto();
		  		  
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
		parametrofacturaciondefecto = new  ParametroFacturacionDefecto();
		  		  
        try {
			
			parametrofacturaciondefecto=parametrofacturaciondefectoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofacturaciondefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametrofacturaciondefecto = new  ParametroFacturacionDefecto();
		  		  
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
		parametrofacturaciondefecto = new  ParametroFacturacionDefecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFacturacionDefecto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametrofacturaciondefectoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrofacturaciondefecto = new  ParametroFacturacionDefecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametrofacturaciondefectoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrofacturaciondefecto = new  ParametroFacturacionDefecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFacturacionDefecto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametrofacturaciondefectoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrofacturaciondefecto = new  ParametroFacturacionDefecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametrofacturaciondefectoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrofacturaciondefecto = new  ParametroFacturacionDefecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFacturacionDefecto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametrofacturaciondefectoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrofacturaciondefecto = new  ParametroFacturacionDefecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametrofacturaciondefectoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrofacturaciondefectos = new  ArrayList<ParametroFacturacionDefecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFacturacionDefecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofacturaciondefectos=parametrofacturaciondefectoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFacturacionDefecto(parametrofacturaciondefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefectos);
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
		parametrofacturaciondefectos = new  ArrayList<ParametroFacturacionDefecto>();
		  		  
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
		parametrofacturaciondefectos = new  ArrayList<ParametroFacturacionDefecto>();
		  		  
        try {			
			ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofacturaciondefectos=parametrofacturaciondefectoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroFacturacionDefecto(parametrofacturaciondefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefectos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametrofacturaciondefectos = new  ArrayList<ParametroFacturacionDefecto>();
		  		  
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
		parametrofacturaciondefectos = new  ArrayList<ParametroFacturacionDefecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFacturacionDefecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofacturaciondefectos=parametrofacturaciondefectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFacturacionDefecto(parametrofacturaciondefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefectos);
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
		parametrofacturaciondefectos = new  ArrayList<ParametroFacturacionDefecto>();
		  		  
        try {
			ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofacturaciondefectos=parametrofacturaciondefectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFacturacionDefecto(parametrofacturaciondefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefectos);
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
		parametrofacturaciondefectos = new  ArrayList<ParametroFacturacionDefecto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFacturacionDefecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofacturaciondefectos=parametrofacturaciondefectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFacturacionDefecto(parametrofacturaciondefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefectos);
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
		parametrofacturaciondefectos = new  ArrayList<ParametroFacturacionDefecto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofacturaciondefectos=parametrofacturaciondefectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFacturacionDefecto(parametrofacturaciondefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefectos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametrofacturaciondefecto = new  ParametroFacturacionDefecto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFacturacionDefecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofacturaciondefecto=parametrofacturaciondefectoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFacturacionDefecto(parametrofacturaciondefecto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefecto);
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
		parametrofacturaciondefecto = new  ParametroFacturacionDefecto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofacturaciondefecto=parametrofacturaciondefectoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFacturacionDefecto(parametrofacturaciondefecto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrofacturaciondefectos = new  ArrayList<ParametroFacturacionDefecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFacturacionDefecto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofacturaciondefectos=parametrofacturaciondefectoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFacturacionDefecto(parametrofacturaciondefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefectos);
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
		parametrofacturaciondefectos = new  ArrayList<ParametroFacturacionDefecto>();
		  		  
        try {
			ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofacturaciondefectos=parametrofacturaciondefectoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFacturacionDefecto(parametrofacturaciondefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefectos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroFacturacionDefectosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametrofacturaciondefectos = new  ArrayList<ParametroFacturacionDefecto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFacturacionDefecto.class.getSimpleName()+"-getTodosParametroFacturacionDefectosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofacturaciondefectos=parametrofacturaciondefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroFacturacionDefecto(parametrofacturaciondefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefectos);
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
	
	public  void  getTodosParametroFacturacionDefectos(String sFinalQuery,Pagination pagination)throws Exception {
		parametrofacturaciondefectos = new  ArrayList<ParametroFacturacionDefecto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofacturaciondefectos=parametrofacturaciondefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroFacturacionDefecto(parametrofacturaciondefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefectos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroFacturacionDefecto(ParametroFacturacionDefecto parametrofacturaciondefecto) throws Exception {
		Boolean estaValidado=false;
		
		if(parametrofacturaciondefecto.getIsNew() || parametrofacturaciondefecto.getIsChanged()) { 
			this.invalidValues = parametrofacturaciondefectoValidator.getInvalidValues(parametrofacturaciondefecto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametrofacturaciondefecto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroFacturacionDefecto(List<ParametroFacturacionDefecto> ParametroFacturacionDefectos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroFacturacionDefecto parametrofacturaciondefectoLocal:parametrofacturaciondefectos) {				
			estaValidadoObjeto=this.validarGuardarParametroFacturacionDefecto(parametrofacturaciondefectoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroFacturacionDefecto(List<ParametroFacturacionDefecto> ParametroFacturacionDefectos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroFacturacionDefecto(parametrofacturaciondefectos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroFacturacionDefecto(ParametroFacturacionDefecto ParametroFacturacionDefecto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroFacturacionDefecto(parametrofacturaciondefecto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroFacturacionDefecto parametrofacturaciondefecto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametrofacturaciondefecto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroFacturacionDefectoConstantesFunciones.getParametroFacturacionDefectoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametrofacturaciondefecto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroFacturacionDefectoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroFacturacionDefectoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroFacturacionDefectoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFacturacionDefecto.class.getSimpleName()+"-saveParametroFacturacionDefectoWithConnection");connexion.begin();			
			
			ParametroFacturacionDefectoLogicAdditional.checkParametroFacturacionDefectoToSave(this.parametrofacturaciondefecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroFacturacionDefectoLogicAdditional.updateParametroFacturacionDefectoToSave(this.parametrofacturaciondefecto,this.arrDatoGeneral);
			
			ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrofacturaciondefecto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroFacturacionDefecto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroFacturacionDefecto(this.parametrofacturaciondefecto)) {
				ParametroFacturacionDefectoDataAccess.save(this.parametrofacturaciondefecto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametrofacturaciondefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroFacturacionDefectoLogicAdditional.checkParametroFacturacionDefectoToSaveAfter(this.parametrofacturaciondefecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroFacturacionDefecto();
			
			connexion.commit();			
			
			if(this.parametrofacturaciondefecto.getIsDeleted()) {
				this.parametrofacturaciondefecto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroFacturacionDefecto()throws Exception {	
		try {	
			
			ParametroFacturacionDefectoLogicAdditional.checkParametroFacturacionDefectoToSave(this.parametrofacturaciondefecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroFacturacionDefectoLogicAdditional.updateParametroFacturacionDefectoToSave(this.parametrofacturaciondefecto,this.arrDatoGeneral);
			
			ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrofacturaciondefecto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroFacturacionDefecto(this.parametrofacturaciondefecto)) {			
				ParametroFacturacionDefectoDataAccess.save(this.parametrofacturaciondefecto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametrofacturaciondefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroFacturacionDefectoLogicAdditional.checkParametroFacturacionDefectoToSaveAfter(this.parametrofacturaciondefecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametrofacturaciondefecto.getIsDeleted()) {
				this.parametrofacturaciondefecto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroFacturacionDefectosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFacturacionDefecto.class.getSimpleName()+"-saveParametroFacturacionDefectosWithConnection");connexion.begin();			
			
			ParametroFacturacionDefectoLogicAdditional.checkParametroFacturacionDefectoToSaves(parametrofacturaciondefectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroFacturacionDefectos();
			
			Boolean validadoTodosParametroFacturacionDefecto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroFacturacionDefecto parametrofacturaciondefectoLocal:parametrofacturaciondefectos) {		
				if(parametrofacturaciondefectoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroFacturacionDefectoLogicAdditional.updateParametroFacturacionDefectoToSave(parametrofacturaciondefectoLocal,this.arrDatoGeneral);
	        	
				ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrofacturaciondefectoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroFacturacionDefecto(parametrofacturaciondefectoLocal)) {
					ParametroFacturacionDefectoDataAccess.save(parametrofacturaciondefectoLocal, connexion);				
				} else {
					validadoTodosParametroFacturacionDefecto=false;
				}
			}
			
			if(!validadoTodosParametroFacturacionDefecto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroFacturacionDefectoLogicAdditional.checkParametroFacturacionDefectoToSavesAfter(parametrofacturaciondefectos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroFacturacionDefectos();
			
			connexion.commit();		
			
			this.quitarParametroFacturacionDefectosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroFacturacionDefectos()throws Exception {				
		 try {	
			ParametroFacturacionDefectoLogicAdditional.checkParametroFacturacionDefectoToSaves(parametrofacturaciondefectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroFacturacionDefecto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroFacturacionDefecto parametrofacturaciondefectoLocal:parametrofacturaciondefectos) {				
				if(parametrofacturaciondefectoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroFacturacionDefectoLogicAdditional.updateParametroFacturacionDefectoToSave(parametrofacturaciondefectoLocal,this.arrDatoGeneral);
	        	
				ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrofacturaciondefectoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroFacturacionDefecto(parametrofacturaciondefectoLocal)) {				
					ParametroFacturacionDefectoDataAccess.save(parametrofacturaciondefectoLocal, connexion);				
				} else {
					validadoTodosParametroFacturacionDefecto=false;
				}
			}
			
			if(!validadoTodosParametroFacturacionDefecto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroFacturacionDefectoLogicAdditional.checkParametroFacturacionDefectoToSavesAfter(parametrofacturaciondefectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroFacturacionDefectosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroFacturacionDefectoParameterReturnGeneral procesarAccionParametroFacturacionDefectos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroFacturacionDefecto> parametrofacturaciondefectos,ParametroFacturacionDefectoParameterReturnGeneral parametrofacturaciondefectoParameterGeneral)throws Exception {
		 try {	
			ParametroFacturacionDefectoParameterReturnGeneral parametrofacturaciondefectoReturnGeneral=new ParametroFacturacionDefectoParameterReturnGeneral();
	
			ParametroFacturacionDefectoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrofacturaciondefectos,parametrofacturaciondefectoParameterGeneral,parametrofacturaciondefectoReturnGeneral);
			
			return parametrofacturaciondefectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroFacturacionDefectoParameterReturnGeneral procesarAccionParametroFacturacionDefectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroFacturacionDefecto> parametrofacturaciondefectos,ParametroFacturacionDefectoParameterReturnGeneral parametrofacturaciondefectoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFacturacionDefecto.class.getSimpleName()+"-procesarAccionParametroFacturacionDefectosWithConnection");connexion.begin();			
			
			ParametroFacturacionDefectoParameterReturnGeneral parametrofacturaciondefectoReturnGeneral=new ParametroFacturacionDefectoParameterReturnGeneral();
	
			ParametroFacturacionDefectoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrofacturaciondefectos,parametrofacturaciondefectoParameterGeneral,parametrofacturaciondefectoReturnGeneral);
			
			this.connexion.commit();
			
			return parametrofacturaciondefectoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroFacturacionDefectoParameterReturnGeneral procesarEventosParametroFacturacionDefectos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroFacturacionDefecto> parametrofacturaciondefectos,ParametroFacturacionDefecto parametrofacturaciondefecto,ParametroFacturacionDefectoParameterReturnGeneral parametrofacturaciondefectoParameterGeneral,Boolean isEsNuevoParametroFacturacionDefecto,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroFacturacionDefectoParameterReturnGeneral parametrofacturaciondefectoReturnGeneral=new ParametroFacturacionDefectoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrofacturaciondefectoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroFacturacionDefectoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrofacturaciondefectos,parametrofacturaciondefecto,parametrofacturaciondefectoParameterGeneral,parametrofacturaciondefectoReturnGeneral,isEsNuevoParametroFacturacionDefecto,clases);
			
			return parametrofacturaciondefectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroFacturacionDefectoParameterReturnGeneral procesarEventosParametroFacturacionDefectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroFacturacionDefecto> parametrofacturaciondefectos,ParametroFacturacionDefecto parametrofacturaciondefecto,ParametroFacturacionDefectoParameterReturnGeneral parametrofacturaciondefectoParameterGeneral,Boolean isEsNuevoParametroFacturacionDefecto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFacturacionDefecto.class.getSimpleName()+"-procesarEventosParametroFacturacionDefectosWithConnection");connexion.begin();			
			
			ParametroFacturacionDefectoParameterReturnGeneral parametrofacturaciondefectoReturnGeneral=new ParametroFacturacionDefectoParameterReturnGeneral();
	
			parametrofacturaciondefectoReturnGeneral.setParametroFacturacionDefecto(parametrofacturaciondefecto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrofacturaciondefectoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroFacturacionDefectoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrofacturaciondefectos,parametrofacturaciondefecto,parametrofacturaciondefectoParameterGeneral,parametrofacturaciondefectoReturnGeneral,isEsNuevoParametroFacturacionDefecto,clases);
			
			this.connexion.commit();
			
			return parametrofacturaciondefectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroFacturacionDefectoParameterReturnGeneral procesarImportacionParametroFacturacionDefectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroFacturacionDefectoParameterReturnGeneral parametrofacturaciondefectoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFacturacionDefecto.class.getSimpleName()+"-procesarImportacionParametroFacturacionDefectosWithConnection");connexion.begin();			
			
			ParametroFacturacionDefectoParameterReturnGeneral parametrofacturaciondefectoReturnGeneral=new ParametroFacturacionDefectoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametrofacturaciondefectos=new ArrayList<ParametroFacturacionDefecto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametrofacturaciondefecto=new ParametroFacturacionDefecto();
				
				
				if(conColumnasBase) {this.parametrofacturaciondefecto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametrofacturaciondefecto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.parametrofacturaciondefectos.add(this.parametrofacturaciondefecto);
			}
			
			this.saveParametroFacturacionDefectos();
			
			this.connexion.commit();
			
			parametrofacturaciondefectoReturnGeneral.setConRetornoEstaProcesado(true);
			parametrofacturaciondefectoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametrofacturaciondefectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroFacturacionDefectosEliminados() throws Exception {				
		
		List<ParametroFacturacionDefecto> parametrofacturaciondefectosAux= new ArrayList<ParametroFacturacionDefecto>();
		
		for(ParametroFacturacionDefecto parametrofacturaciondefecto:parametrofacturaciondefectos) {
			if(!parametrofacturaciondefecto.getIsDeleted()) {
				parametrofacturaciondefectosAux.add(parametrofacturaciondefecto);
			}
		}
		
		parametrofacturaciondefectos=parametrofacturaciondefectosAux;
	}
	
	public void quitarParametroFacturacionDefectosNulos() throws Exception {				
		
		List<ParametroFacturacionDefecto> parametrofacturaciondefectosAux= new ArrayList<ParametroFacturacionDefecto>();
		
		for(ParametroFacturacionDefecto parametrofacturaciondefecto : this.parametrofacturaciondefectos) {
			if(parametrofacturaciondefecto==null) {
				parametrofacturaciondefectosAux.add(parametrofacturaciondefecto);
			}
		}
		
		//this.parametrofacturaciondefectos=parametrofacturaciondefectosAux;
		
		this.parametrofacturaciondefectos.removeAll(parametrofacturaciondefectosAux);
	}
	
	public void getSetVersionRowParametroFacturacionDefectoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametrofacturaciondefecto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametrofacturaciondefecto.getIsDeleted() || (parametrofacturaciondefecto.getIsChanged()&&!parametrofacturaciondefecto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametrofacturaciondefectoDataAccess.getSetVersionRowParametroFacturacionDefecto(connexion,parametrofacturaciondefecto.getId());
				
				if(!parametrofacturaciondefecto.getVersionRow().equals(timestamp)) {	
					parametrofacturaciondefecto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametrofacturaciondefecto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroFacturacionDefecto()throws Exception {	
		
		if(parametrofacturaciondefecto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametrofacturaciondefecto.getIsDeleted() || (parametrofacturaciondefecto.getIsChanged()&&!parametrofacturaciondefecto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametrofacturaciondefectoDataAccess.getSetVersionRowParametroFacturacionDefecto(connexion,parametrofacturaciondefecto.getId());
			
			try {							
				if(!parametrofacturaciondefecto.getVersionRow().equals(timestamp)) {	
					parametrofacturaciondefecto.setVersionRow(timestamp);
				}
				
				parametrofacturaciondefecto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroFacturacionDefectosWithConnection()throws Exception {	
		if(parametrofacturaciondefectos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroFacturacionDefecto parametrofacturaciondefectoAux:parametrofacturaciondefectos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametrofacturaciondefectoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrofacturaciondefectoAux.getIsDeleted() || (parametrofacturaciondefectoAux.getIsChanged()&&!parametrofacturaciondefectoAux.getIsNew())) {
						
						timestamp=parametrofacturaciondefectoDataAccess.getSetVersionRowParametroFacturacionDefecto(connexion,parametrofacturaciondefectoAux.getId());
						
						if(!parametrofacturaciondefecto.getVersionRow().equals(timestamp)) {	
							parametrofacturaciondefectoAux.setVersionRow(timestamp);
						}
								
						parametrofacturaciondefectoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroFacturacionDefectos()throws Exception {	
		if(parametrofacturaciondefectos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroFacturacionDefecto parametrofacturaciondefectoAux:parametrofacturaciondefectos) {
					if(parametrofacturaciondefectoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrofacturaciondefectoAux.getIsDeleted() || (parametrofacturaciondefectoAux.getIsChanged()&&!parametrofacturaciondefectoAux.getIsNew())) {
						
						timestamp=parametrofacturaciondefectoDataAccess.getSetVersionRowParametroFacturacionDefecto(connexion,parametrofacturaciondefectoAux.getId());
						
						if(!parametrofacturaciondefectoAux.getVersionRow().equals(timestamp)) {	
							parametrofacturaciondefectoAux.setVersionRow(timestamp);
						}
						
													
						parametrofacturaciondefectoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroFacturacionDefectoParameterReturnGeneral cargarCombosLoteForeignKeyParametroFacturacionDefectoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoViaTransporte) throws Exception {
		ParametroFacturacionDefectoParameterReturnGeneral  parametrofacturaciondefectoReturnGeneral =new ParametroFacturacionDefectoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFacturacionDefecto.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroFacturacionDefectoWithConnection");connexion.begin();
			
			parametrofacturaciondefectoReturnGeneral =new ParametroFacturacionDefectoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrofacturaciondefectoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrofacturaciondefectoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoViaTransporte> tipoviatransportesForeignKey=new ArrayList<TipoViaTransporte>();
			TipoViaTransporteLogic tipoviatransporteLogic=new TipoViaTransporteLogic();
			tipoviatransporteLogic.setConnexion(this.connexion);
			tipoviatransporteLogic.getTipoViaTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoViaTransporte.equals("NONE")) {
				tipoviatransporteLogic.getTodosTipoViaTransportes(finalQueryGlobalTipoViaTransporte,new Pagination());
				tipoviatransportesForeignKey=tipoviatransporteLogic.getTipoViaTransportes();
			}

			parametrofacturaciondefectoReturnGeneral.settipoviatransportesForeignKey(tipoviatransportesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametrofacturaciondefectoReturnGeneral;
	}
	
	public ParametroFacturacionDefectoParameterReturnGeneral cargarCombosLoteForeignKeyParametroFacturacionDefecto(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoViaTransporte) throws Exception {
		ParametroFacturacionDefectoParameterReturnGeneral  parametrofacturaciondefectoReturnGeneral =new ParametroFacturacionDefectoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametrofacturaciondefectoReturnGeneral =new ParametroFacturacionDefectoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrofacturaciondefectoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrofacturaciondefectoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoViaTransporte> tipoviatransportesForeignKey=new ArrayList<TipoViaTransporte>();
			TipoViaTransporteLogic tipoviatransporteLogic=new TipoViaTransporteLogic();
			tipoviatransporteLogic.setConnexion(this.connexion);
			tipoviatransporteLogic.getTipoViaTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoViaTransporte.equals("NONE")) {
				tipoviatransporteLogic.getTodosTipoViaTransportes(finalQueryGlobalTipoViaTransporte,new Pagination());
				tipoviatransportesForeignKey=tipoviatransporteLogic.getTipoViaTransportes();
			}

			parametrofacturaciondefectoReturnGeneral.settipoviatransportesForeignKey(tipoviatransportesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametrofacturaciondefectoReturnGeneral;
	}
	
	
	public void deepLoad(ParametroFacturacionDefecto parametrofacturaciondefecto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroFacturacionDefectoLogicAdditional.updateParametroFacturacionDefectoToGet(parametrofacturaciondefecto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrofacturaciondefecto.setEmpresa(parametrofacturaciondefectoDataAccess.getEmpresa(connexion,parametrofacturaciondefecto));
		parametrofacturaciondefecto.setSucursal(parametrofacturaciondefectoDataAccess.getSucursal(connexion,parametrofacturaciondefecto));
		parametrofacturaciondefecto.setTipoViaTransporte(parametrofacturaciondefectoDataAccess.getTipoViaTransporte(connexion,parametrofacturaciondefecto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrofacturaciondefecto.setEmpresa(parametrofacturaciondefectoDataAccess.getEmpresa(connexion,parametrofacturaciondefecto));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrofacturaciondefecto.setSucursal(parametrofacturaciondefectoDataAccess.getSucursal(connexion,parametrofacturaciondefecto));
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				parametrofacturaciondefecto.setTipoViaTransporte(parametrofacturaciondefectoDataAccess.getTipoViaTransporte(connexion,parametrofacturaciondefecto));
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
			parametrofacturaciondefecto.setEmpresa(parametrofacturaciondefectoDataAccess.getEmpresa(connexion,parametrofacturaciondefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofacturaciondefecto.setSucursal(parametrofacturaciondefectoDataAccess.getSucursal(connexion,parametrofacturaciondefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoViaTransporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofacturaciondefecto.setTipoViaTransporte(parametrofacturaciondefectoDataAccess.getTipoViaTransporte(connexion,parametrofacturaciondefecto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrofacturaciondefecto.setEmpresa(parametrofacturaciondefectoDataAccess.getEmpresa(connexion,parametrofacturaciondefecto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrofacturaciondefecto.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametrofacturaciondefecto.setSucursal(parametrofacturaciondefectoDataAccess.getSucursal(connexion,parametrofacturaciondefecto));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrofacturaciondefecto.getSucursal(),isDeep,deepLoadType,clases);
				
		parametrofacturaciondefecto.setTipoViaTransporte(parametrofacturaciondefectoDataAccess.getTipoViaTransporte(connexion,parametrofacturaciondefecto));
		TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
		tipoviatransporteLogic.deepLoad(parametrofacturaciondefecto.getTipoViaTransporte(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrofacturaciondefecto.setEmpresa(parametrofacturaciondefectoDataAccess.getEmpresa(connexion,parametrofacturaciondefecto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametrofacturaciondefecto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrofacturaciondefecto.setSucursal(parametrofacturaciondefectoDataAccess.getSucursal(connexion,parametrofacturaciondefecto));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(parametrofacturaciondefecto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				parametrofacturaciondefecto.setTipoViaTransporte(parametrofacturaciondefectoDataAccess.getTipoViaTransporte(connexion,parametrofacturaciondefecto));
				TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
				tipoviatransporteLogic.deepLoad(parametrofacturaciondefecto.getTipoViaTransporte(),isDeep,deepLoadType,clases);				
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
			parametrofacturaciondefecto.setEmpresa(parametrofacturaciondefectoDataAccess.getEmpresa(connexion,parametrofacturaciondefecto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametrofacturaciondefecto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofacturaciondefecto.setSucursal(parametrofacturaciondefectoDataAccess.getSucursal(connexion,parametrofacturaciondefecto));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(parametrofacturaciondefecto.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoViaTransporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofacturaciondefecto.setTipoViaTransporte(parametrofacturaciondefectoDataAccess.getTipoViaTransporte(connexion,parametrofacturaciondefecto));
			TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
			tipoviatransporteLogic.deepLoad(parametrofacturaciondefecto.getTipoViaTransporte(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroFacturacionDefecto parametrofacturaciondefecto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroFacturacionDefectoLogicAdditional.updateParametroFacturacionDefectoToSave(parametrofacturaciondefecto,this.arrDatoGeneral);
			
ParametroFacturacionDefectoDataAccess.save(parametrofacturaciondefecto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrofacturaciondefecto.getEmpresa(),connexion);

		SucursalDataAccess.save(parametrofacturaciondefecto.getSucursal(),connexion);

		TipoViaTransporteDataAccess.save(parametrofacturaciondefecto.getTipoViaTransporte(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrofacturaciondefecto.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrofacturaciondefecto.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				TipoViaTransporteDataAccess.save(parametrofacturaciondefecto.getTipoViaTransporte(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrofacturaciondefecto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrofacturaciondefecto.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(parametrofacturaciondefecto.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrofacturaciondefecto.getSucursal(),isDeep,deepLoadType,clases);
				

		TipoViaTransporteDataAccess.save(parametrofacturaciondefecto.getTipoViaTransporte(),connexion);
		TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
		tipoviatransporteLogic.deepLoad(parametrofacturaciondefecto.getTipoViaTransporte(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrofacturaciondefecto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametrofacturaciondefecto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrofacturaciondefecto.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(parametrofacturaciondefecto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				TipoViaTransporteDataAccess.save(parametrofacturaciondefecto.getTipoViaTransporte(),connexion);
				TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
				tipoviatransporteLogic.deepSave(parametrofacturaciondefecto.getTipoViaTransporte(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroFacturacionDefecto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametrofacturaciondefecto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(parametrofacturaciondefecto);
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
			this.deepLoad(this.parametrofacturaciondefecto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroFacturacionDefecto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametrofacturaciondefectos!=null) {
				for(ParametroFacturacionDefecto parametrofacturaciondefecto:parametrofacturaciondefectos) {
					this.deepLoad(parametrofacturaciondefecto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(parametrofacturaciondefectos);
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
			if(parametrofacturaciondefectos!=null) {
				for(ParametroFacturacionDefecto parametrofacturaciondefecto:parametrofacturaciondefectos) {
					this.deepLoad(parametrofacturaciondefecto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(parametrofacturaciondefectos);
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
			this.getNewConnexionToDeep(ParametroFacturacionDefecto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametrofacturaciondefecto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroFacturacionDefecto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametrofacturaciondefectos!=null) {
				for(ParametroFacturacionDefecto parametrofacturaciondefecto:parametrofacturaciondefectos) {
					this.deepSave(parametrofacturaciondefecto,isDeep,deepLoadType,clases);
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
			if(parametrofacturaciondefectos!=null) {
				for(ParametroFacturacionDefecto parametrofacturaciondefecto:parametrofacturaciondefectos) {
					this.deepSave(parametrofacturaciondefecto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroFacturacionDefectosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFacturacionDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroFacturacionDefectoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofacturaciondefectos=parametrofacturaciondefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFacturacionDefectosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroFacturacionDefectoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofacturaciondefectos=parametrofacturaciondefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFacturacionDefectosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFacturacionDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroFacturacionDefectoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofacturaciondefectos=parametrofacturaciondefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFacturacionDefectosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroFacturacionDefectoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofacturaciondefectos=parametrofacturaciondefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFacturacionDefectosFK_IdTipoViaTransporteWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_via_transporte)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFacturacionDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoViaTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoViaTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_via_transporte,ParametroFacturacionDefectoConstantesFunciones.IDTIPOVIATRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoViaTransporte);

			ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoViaTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofacturaciondefectos=parametrofacturaciondefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFacturacionDefectosFK_IdTipoViaTransporte(String sFinalQuery,Pagination pagination,Long id_tipo_via_transporte)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoViaTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoViaTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_via_transporte,ParametroFacturacionDefectoConstantesFunciones.IDTIPOVIATRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoViaTransporte);

			ParametroFacturacionDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoViaTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofacturaciondefectos=parametrofacturaciondefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFacturacionDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroFacturacionDefecto(this.parametrofacturaciondefectos);
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
			if(ParametroFacturacionDefectoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFacturacionDefectoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroFacturacionDefecto parametrofacturaciondefecto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroFacturacionDefectoConstantesFunciones.ISCONAUDITORIA) {
				if(parametrofacturaciondefecto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFacturacionDefectoDataAccess.TABLENAME, parametrofacturaciondefecto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroFacturacionDefectoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroFacturacionDefectoLogic.registrarAuditoriaDetallesParametroFacturacionDefecto(connexion,parametrofacturaciondefecto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametrofacturaciondefecto.getIsDeleted()) {
					/*if(!parametrofacturaciondefecto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroFacturacionDefectoDataAccess.TABLENAME, parametrofacturaciondefecto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroFacturacionDefectoLogic.registrarAuditoriaDetallesParametroFacturacionDefecto(connexion,parametrofacturaciondefecto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFacturacionDefectoDataAccess.TABLENAME, parametrofacturaciondefecto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametrofacturaciondefecto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFacturacionDefectoDataAccess.TABLENAME, parametrofacturaciondefecto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroFacturacionDefectoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroFacturacionDefectoLogic.registrarAuditoriaDetallesParametroFacturacionDefecto(connexion,parametrofacturaciondefecto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroFacturacionDefecto(Connexion connexion,ParametroFacturacionDefecto parametrofacturaciondefecto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametrofacturaciondefecto.getIsNew()||!parametrofacturaciondefecto.getid_empresa().equals(parametrofacturaciondefecto.getParametroFacturacionDefectoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofacturaciondefecto.getParametroFacturacionDefectoOriginal().getid_empresa()!=null)
				{
					strValorActual=parametrofacturaciondefecto.getParametroFacturacionDefectoOriginal().getid_empresa().toString();
				}
				if(parametrofacturaciondefecto.getid_empresa()!=null)
				{
					strValorNuevo=parametrofacturaciondefecto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFacturacionDefectoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofacturaciondefecto.getIsNew()||!parametrofacturaciondefecto.getid_sucursal().equals(parametrofacturaciondefecto.getParametroFacturacionDefectoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofacturaciondefecto.getParametroFacturacionDefectoOriginal().getid_sucursal()!=null)
				{
					strValorActual=parametrofacturaciondefecto.getParametroFacturacionDefectoOriginal().getid_sucursal().toString();
				}
				if(parametrofacturaciondefecto.getid_sucursal()!=null)
				{
					strValorNuevo=parametrofacturaciondefecto.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFacturacionDefectoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrofacturaciondefecto.getIsNew()||!parametrofacturaciondefecto.getid_tipo_via_transporte().equals(parametrofacturaciondefecto.getParametroFacturacionDefectoOriginal().getid_tipo_via_transporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofacturaciondefecto.getParametroFacturacionDefectoOriginal().getid_tipo_via_transporte()!=null)
				{
					strValorActual=parametrofacturaciondefecto.getParametroFacturacionDefectoOriginal().getid_tipo_via_transporte().toString();
				}
				if(parametrofacturaciondefecto.getid_tipo_via_transporte()!=null)
				{
					strValorNuevo=parametrofacturaciondefecto.getid_tipo_via_transporte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFacturacionDefectoConstantesFunciones.IDTIPOVIATRANSPORTE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroFacturacionDefectoRelacionesWithConnection(ParametroFacturacionDefecto parametrofacturaciondefecto) throws Exception {

		if(!parametrofacturaciondefecto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroFacturacionDefectoRelacionesBase(parametrofacturaciondefecto,true);
		}
	}

	public void saveParametroFacturacionDefectoRelaciones(ParametroFacturacionDefecto parametrofacturaciondefecto)throws Exception {

		if(!parametrofacturaciondefecto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroFacturacionDefectoRelacionesBase(parametrofacturaciondefecto,false);
		}
	}

	public void saveParametroFacturacionDefectoRelacionesBase(ParametroFacturacionDefecto parametrofacturaciondefecto,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroFacturacionDefecto-saveRelacionesWithConnection");}
	

			this.setParametroFacturacionDefecto(parametrofacturaciondefecto);

			if(ParametroFacturacionDefectoLogicAdditional.validarSaveRelaciones(parametrofacturaciondefecto,this)) {

				ParametroFacturacionDefectoLogicAdditional.updateRelacionesToSave(parametrofacturaciondefecto,this);

				if((parametrofacturaciondefecto.getIsNew()||parametrofacturaciondefecto.getIsChanged())&&!parametrofacturaciondefecto.getIsDeleted()) {
					this.saveParametroFacturacionDefecto();
					this.saveParametroFacturacionDefectoRelacionesDetalles();

				} else if(parametrofacturaciondefecto.getIsDeleted()) {
					this.saveParametroFacturacionDefectoRelacionesDetalles();
					this.saveParametroFacturacionDefecto();
				}

				ParametroFacturacionDefectoLogicAdditional.updateRelacionesToSaveAfter(parametrofacturaciondefecto,this);

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
	
	
	private void saveParametroFacturacionDefectoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroFacturacionDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroFacturacionDefectoConstantesFunciones.getClassesForeignKeysOfParametroFacturacionDefecto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFacturacionDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroFacturacionDefectoConstantesFunciones.getClassesRelationshipsOfParametroFacturacionDefecto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

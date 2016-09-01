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
import com.bydan.erp.facturacion.util.ParametroFactuSecuencialConstantesFunciones;
import com.bydan.erp.facturacion.util.ParametroFactuSecuencialParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ParametroFactuSecuencialParameterGeneral;
import com.bydan.erp.facturacion.business.entity.ParametroFactuSecuencial;
import com.bydan.erp.facturacion.business.logic.ParametroFactuSecuencialLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroFactuSecuencialLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroFactuSecuencialLogic.class);
	
	protected ParametroFactuSecuencialDataAccess parametrofactusecuencialDataAccess; 	
	protected ParametroFactuSecuencial parametrofactusecuencial;
	protected List<ParametroFactuSecuencial> parametrofactusecuencials;
	protected Object parametrofactusecuencialObject;	
	protected List<Object> parametrofactusecuencialsObject;
	
	public static ClassValidator<ParametroFactuSecuencial> parametrofactusecuencialValidator = new ClassValidator<ParametroFactuSecuencial>(ParametroFactuSecuencial.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroFactuSecuencialLogicAdditional parametrofactusecuencialLogicAdditional=null;
	
	public ParametroFactuSecuencialLogicAdditional getParametroFactuSecuencialLogicAdditional() {
		return this.parametrofactusecuencialLogicAdditional;
	}
	
	public void setParametroFactuSecuencialLogicAdditional(ParametroFactuSecuencialLogicAdditional parametrofactusecuencialLogicAdditional) {
		try {
			this.parametrofactusecuencialLogicAdditional=parametrofactusecuencialLogicAdditional;
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
	
	
	
	
	public  ParametroFactuSecuencialLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametrofactusecuencialDataAccess = new ParametroFactuSecuencialDataAccess();
			
			this.parametrofactusecuencials= new ArrayList<ParametroFactuSecuencial>();
			this.parametrofactusecuencial= new ParametroFactuSecuencial();
			
			this.parametrofactusecuencialObject=new Object();
			this.parametrofactusecuencialsObject=new ArrayList<Object>();
				
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
			
			this.parametrofactusecuencialDataAccess.setConnexionType(this.connexionType);
			this.parametrofactusecuencialDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroFactuSecuencialLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametrofactusecuencialDataAccess = new ParametroFactuSecuencialDataAccess();
			this.parametrofactusecuencials= new ArrayList<ParametroFactuSecuencial>();
			this.parametrofactusecuencial= new ParametroFactuSecuencial();
			this.parametrofactusecuencialObject=new Object();
			this.parametrofactusecuencialsObject=new ArrayList<Object>();
			
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
			
			this.parametrofactusecuencialDataAccess.setConnexionType(this.connexionType);
			this.parametrofactusecuencialDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroFactuSecuencial getParametroFactuSecuencial() throws Exception {	
		ParametroFactuSecuencialLogicAdditional.checkParametroFactuSecuencialToGet(parametrofactusecuencial,this.datosCliente,this.arrDatoGeneral);
		ParametroFactuSecuencialLogicAdditional.updateParametroFactuSecuencialToGet(parametrofactusecuencial,this.arrDatoGeneral);
		
		return parametrofactusecuencial;
	}
		
	public void setParametroFactuSecuencial(ParametroFactuSecuencial newParametroFactuSecuencial) {
		this.parametrofactusecuencial = newParametroFactuSecuencial;
	}
	
	public ParametroFactuSecuencialDataAccess getParametroFactuSecuencialDataAccess() {
		return parametrofactusecuencialDataAccess;
	}
	
	public void setParametroFactuSecuencialDataAccess(ParametroFactuSecuencialDataAccess newparametrofactusecuencialDataAccess) {
		this.parametrofactusecuencialDataAccess = newparametrofactusecuencialDataAccess;
	}
	
	public List<ParametroFactuSecuencial> getParametroFactuSecuencials() throws Exception {		
		this.quitarParametroFactuSecuencialsNulos();
		
		ParametroFactuSecuencialLogicAdditional.checkParametroFactuSecuencialToGets(parametrofactusecuencials,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroFactuSecuencial parametrofactusecuencialLocal: parametrofactusecuencials ) {
			ParametroFactuSecuencialLogicAdditional.updateParametroFactuSecuencialToGet(parametrofactusecuencialLocal,this.arrDatoGeneral);
		}
		
		return parametrofactusecuencials;
	}
	
	public void setParametroFactuSecuencials(List<ParametroFactuSecuencial> newParametroFactuSecuencials) {
		this.parametrofactusecuencials = newParametroFactuSecuencials;
	}
	
	public Object getParametroFactuSecuencialObject() {	
		this.parametrofactusecuencialObject=this.parametrofactusecuencialDataAccess.getEntityObject();
		return this.parametrofactusecuencialObject;
	}
		
	public void setParametroFactuSecuencialObject(Object newParametroFactuSecuencialObject) {
		this.parametrofactusecuencialObject = newParametroFactuSecuencialObject;
	}
	
	public List<Object> getParametroFactuSecuencialsObject() {		
		this.parametrofactusecuencialsObject=this.parametrofactusecuencialDataAccess.getEntitiesObject();
		return this.parametrofactusecuencialsObject;
	}
		
	public void setParametroFactuSecuencialsObject(List<Object> newParametroFactuSecuencialsObject) {
		this.parametrofactusecuencialsObject = newParametroFactuSecuencialsObject;
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
		
		if(this.parametrofactusecuencialDataAccess!=null) {
			this.parametrofactusecuencialDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametrofactusecuencialDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametrofactusecuencialDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametrofactusecuencial = new  ParametroFactuSecuencial();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrofactusecuencial=parametrofactusecuencialDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofactusecuencial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencial);
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
		parametrofactusecuencial = new  ParametroFactuSecuencial();
		  		  
        try {
			
			parametrofactusecuencial=parametrofactusecuencialDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofactusecuencial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencial);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametrofactusecuencial = new  ParametroFactuSecuencial();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrofactusecuencial=parametrofactusecuencialDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofactusecuencial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencial);
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
		parametrofactusecuencial = new  ParametroFactuSecuencial();
		  		  
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
		parametrofactusecuencial = new  ParametroFactuSecuencial();
		  		  
        try {
			
			parametrofactusecuencial=parametrofactusecuencialDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofactusecuencial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencial);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametrofactusecuencial = new  ParametroFactuSecuencial();
		  		  
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
		parametrofactusecuencial = new  ParametroFactuSecuencial();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametrofactusecuencialDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrofactusecuencial = new  ParametroFactuSecuencial();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametrofactusecuencialDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrofactusecuencial = new  ParametroFactuSecuencial();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametrofactusecuencialDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrofactusecuencial = new  ParametroFactuSecuencial();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametrofactusecuencialDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrofactusecuencial = new  ParametroFactuSecuencial();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametrofactusecuencialDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrofactusecuencial = new  ParametroFactuSecuencial();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametrofactusecuencialDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrofactusecuencials = new  ArrayList<ParametroFactuSecuencial>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactuSecuencial(parametrofactusecuencials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
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
		parametrofactusecuencials = new  ArrayList<ParametroFactuSecuencial>();
		  		  
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
		parametrofactusecuencials = new  ArrayList<ParametroFactuSecuencial>();
		  		  
        try {			
			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroFactuSecuencial(parametrofactusecuencials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametrofactusecuencials = new  ArrayList<ParametroFactuSecuencial>();
		  		  
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
		parametrofactusecuencials = new  ArrayList<ParametroFactuSecuencial>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactuSecuencial(parametrofactusecuencials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
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
		parametrofactusecuencials = new  ArrayList<ParametroFactuSecuencial>();
		  		  
        try {
			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactuSecuencial(parametrofactusecuencials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
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
		parametrofactusecuencials = new  ArrayList<ParametroFactuSecuencial>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFactuSecuencial(parametrofactusecuencials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
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
		parametrofactusecuencials = new  ArrayList<ParametroFactuSecuencial>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFactuSecuencial(parametrofactusecuencials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametrofactusecuencial = new  ParametroFactuSecuencial();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactusecuencial=parametrofactusecuencialDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFactuSecuencial(parametrofactusecuencial);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencial);
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
		parametrofactusecuencial = new  ParametroFactuSecuencial();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactusecuencial=parametrofactusecuencialDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFactuSecuencial(parametrofactusecuencial);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencial);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrofactusecuencials = new  ArrayList<ParametroFactuSecuencial>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactuSecuencial(parametrofactusecuencials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
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
		parametrofactusecuencials = new  ArrayList<ParametroFactuSecuencial>();
		  		  
        try {
			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactuSecuencial(parametrofactusecuencials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroFactuSecuencialsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametrofactusecuencials = new  ArrayList<ParametroFactuSecuencial>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-getTodosParametroFactuSecuencialsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroFactuSecuencial(parametrofactusecuencials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
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
	
	public  void  getTodosParametroFactuSecuencials(String sFinalQuery,Pagination pagination)throws Exception {
		parametrofactusecuencials = new  ArrayList<ParametroFactuSecuencial>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroFactuSecuencial(parametrofactusecuencials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroFactuSecuencial(ParametroFactuSecuencial parametrofactusecuencial) throws Exception {
		Boolean estaValidado=false;
		
		if(parametrofactusecuencial.getIsNew() || parametrofactusecuencial.getIsChanged()) { 
			this.invalidValues = parametrofactusecuencialValidator.getInvalidValues(parametrofactusecuencial);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametrofactusecuencial);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroFactuSecuencial(List<ParametroFactuSecuencial> ParametroFactuSecuencials) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroFactuSecuencial parametrofactusecuencialLocal:parametrofactusecuencials) {				
			estaValidadoObjeto=this.validarGuardarParametroFactuSecuencial(parametrofactusecuencialLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroFactuSecuencial(List<ParametroFactuSecuencial> ParametroFactuSecuencials) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroFactuSecuencial(parametrofactusecuencials)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroFactuSecuencial(ParametroFactuSecuencial ParametroFactuSecuencial) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroFactuSecuencial(parametrofactusecuencial)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroFactuSecuencial parametrofactusecuencial) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametrofactusecuencial.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroFactuSecuencialConstantesFunciones.getParametroFactuSecuencialLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametrofactusecuencial","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroFactuSecuencialConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroFactuSecuencialConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroFactuSecuencialWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-saveParametroFactuSecuencialWithConnection");connexion.begin();			
			
			ParametroFactuSecuencialLogicAdditional.checkParametroFactuSecuencialToSave(this.parametrofactusecuencial,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroFactuSecuencialLogicAdditional.updateParametroFactuSecuencialToSave(this.parametrofactusecuencial,this.arrDatoGeneral);
			
			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrofactusecuencial,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroFactuSecuencial();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroFactuSecuencial(this.parametrofactusecuencial)) {
				ParametroFactuSecuencialDataAccess.save(this.parametrofactusecuencial, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametrofactusecuencial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroFactuSecuencialLogicAdditional.checkParametroFactuSecuencialToSaveAfter(this.parametrofactusecuencial,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroFactuSecuencial();
			
			connexion.commit();			
			
			if(this.parametrofactusecuencial.getIsDeleted()) {
				this.parametrofactusecuencial=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroFactuSecuencial()throws Exception {	
		try {	
			
			ParametroFactuSecuencialLogicAdditional.checkParametroFactuSecuencialToSave(this.parametrofactusecuencial,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroFactuSecuencialLogicAdditional.updateParametroFactuSecuencialToSave(this.parametrofactusecuencial,this.arrDatoGeneral);
			
			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrofactusecuencial,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroFactuSecuencial(this.parametrofactusecuencial)) {			
				ParametroFactuSecuencialDataAccess.save(this.parametrofactusecuencial, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametrofactusecuencial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroFactuSecuencialLogicAdditional.checkParametroFactuSecuencialToSaveAfter(this.parametrofactusecuencial,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametrofactusecuencial.getIsDeleted()) {
				this.parametrofactusecuencial=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroFactuSecuencialsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-saveParametroFactuSecuencialsWithConnection");connexion.begin();			
			
			ParametroFactuSecuencialLogicAdditional.checkParametroFactuSecuencialToSaves(parametrofactusecuencials,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroFactuSecuencials();
			
			Boolean validadoTodosParametroFactuSecuencial=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroFactuSecuencial parametrofactusecuencialLocal:parametrofactusecuencials) {		
				if(parametrofactusecuencialLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroFactuSecuencialLogicAdditional.updateParametroFactuSecuencialToSave(parametrofactusecuencialLocal,this.arrDatoGeneral);
	        	
				ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrofactusecuencialLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroFactuSecuencial(parametrofactusecuencialLocal)) {
					ParametroFactuSecuencialDataAccess.save(parametrofactusecuencialLocal, connexion);				
				} else {
					validadoTodosParametroFactuSecuencial=false;
				}
			}
			
			if(!validadoTodosParametroFactuSecuencial) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroFactuSecuencialLogicAdditional.checkParametroFactuSecuencialToSavesAfter(parametrofactusecuencials,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroFactuSecuencials();
			
			connexion.commit();		
			
			this.quitarParametroFactuSecuencialsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroFactuSecuencials()throws Exception {				
		 try {	
			ParametroFactuSecuencialLogicAdditional.checkParametroFactuSecuencialToSaves(parametrofactusecuencials,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroFactuSecuencial=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroFactuSecuencial parametrofactusecuencialLocal:parametrofactusecuencials) {				
				if(parametrofactusecuencialLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroFactuSecuencialLogicAdditional.updateParametroFactuSecuencialToSave(parametrofactusecuencialLocal,this.arrDatoGeneral);
	        	
				ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrofactusecuencialLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroFactuSecuencial(parametrofactusecuencialLocal)) {				
					ParametroFactuSecuencialDataAccess.save(parametrofactusecuencialLocal, connexion);				
				} else {
					validadoTodosParametroFactuSecuencial=false;
				}
			}
			
			if(!validadoTodosParametroFactuSecuencial) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroFactuSecuencialLogicAdditional.checkParametroFactuSecuencialToSavesAfter(parametrofactusecuencials,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroFactuSecuencialsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroFactuSecuencialParameterReturnGeneral procesarAccionParametroFactuSecuencials(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroFactuSecuencial> parametrofactusecuencials,ParametroFactuSecuencialParameterReturnGeneral parametrofactusecuencialParameterGeneral)throws Exception {
		 try {	
			ParametroFactuSecuencialParameterReturnGeneral parametrofactusecuencialReturnGeneral=new ParametroFactuSecuencialParameterReturnGeneral();
	
			ParametroFactuSecuencialLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrofactusecuencials,parametrofactusecuencialParameterGeneral,parametrofactusecuencialReturnGeneral);
			
			return parametrofactusecuencialReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroFactuSecuencialParameterReturnGeneral procesarAccionParametroFactuSecuencialsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroFactuSecuencial> parametrofactusecuencials,ParametroFactuSecuencialParameterReturnGeneral parametrofactusecuencialParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-procesarAccionParametroFactuSecuencialsWithConnection");connexion.begin();			
			
			ParametroFactuSecuencialParameterReturnGeneral parametrofactusecuencialReturnGeneral=new ParametroFactuSecuencialParameterReturnGeneral();
	
			ParametroFactuSecuencialLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrofactusecuencials,parametrofactusecuencialParameterGeneral,parametrofactusecuencialReturnGeneral);
			
			this.connexion.commit();
			
			return parametrofactusecuencialReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroFactuSecuencialParameterReturnGeneral procesarEventosParametroFactuSecuencials(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroFactuSecuencial> parametrofactusecuencials,ParametroFactuSecuencial parametrofactusecuencial,ParametroFactuSecuencialParameterReturnGeneral parametrofactusecuencialParameterGeneral,Boolean isEsNuevoParametroFactuSecuencial,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroFactuSecuencialParameterReturnGeneral parametrofactusecuencialReturnGeneral=new ParametroFactuSecuencialParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrofactusecuencialReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroFactuSecuencialLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrofactusecuencials,parametrofactusecuencial,parametrofactusecuencialParameterGeneral,parametrofactusecuencialReturnGeneral,isEsNuevoParametroFactuSecuencial,clases);
			
			return parametrofactusecuencialReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroFactuSecuencialParameterReturnGeneral procesarEventosParametroFactuSecuencialsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroFactuSecuencial> parametrofactusecuencials,ParametroFactuSecuencial parametrofactusecuencial,ParametroFactuSecuencialParameterReturnGeneral parametrofactusecuencialParameterGeneral,Boolean isEsNuevoParametroFactuSecuencial,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-procesarEventosParametroFactuSecuencialsWithConnection");connexion.begin();			
			
			ParametroFactuSecuencialParameterReturnGeneral parametrofactusecuencialReturnGeneral=new ParametroFactuSecuencialParameterReturnGeneral();
	
			parametrofactusecuencialReturnGeneral.setParametroFactuSecuencial(parametrofactusecuencial);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrofactusecuencialReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroFactuSecuencialLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrofactusecuencials,parametrofactusecuencial,parametrofactusecuencialParameterGeneral,parametrofactusecuencialReturnGeneral,isEsNuevoParametroFactuSecuencial,clases);
			
			this.connexion.commit();
			
			return parametrofactusecuencialReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroFactuSecuencialParameterReturnGeneral procesarImportacionParametroFactuSecuencialsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroFactuSecuencialParameterReturnGeneral parametrofactusecuencialParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-procesarImportacionParametroFactuSecuencialsWithConnection");connexion.begin();			
			
			ParametroFactuSecuencialParameterReturnGeneral parametrofactusecuencialReturnGeneral=new ParametroFactuSecuencialParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametrofactusecuencials=new ArrayList<ParametroFactuSecuencial>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametrofactusecuencial=new ParametroFactuSecuencial();
				
				
				if(conColumnasBase) {this.parametrofactusecuencial.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametrofactusecuencial.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parametrofactusecuencial.setsecuencial(arrColumnas[iColumn++]);
				this.parametrofactusecuencial.setnumero_digitos(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametrofactusecuencial.setnumero_items(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametrofactusecuencial.setnumero_descuento(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametrofactusecuencial.setnumero_adiicionales(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametrofactusecuencial.setnumero_digito_inicio(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametrofactusecuencial.setnumero_digito_fin(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametrofactusecuencial.setnumero_dias_plazo(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametrofactusecuencial.setcon_detalle(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactusecuencial.setcon_lector(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactusecuencial.setcon_transferencia(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.parametrofactusecuencials.add(this.parametrofactusecuencial);
			}
			
			this.saveParametroFactuSecuencials();
			
			this.connexion.commit();
			
			parametrofactusecuencialReturnGeneral.setConRetornoEstaProcesado(true);
			parametrofactusecuencialReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametrofactusecuencialReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroFactuSecuencialsEliminados() throws Exception {				
		
		List<ParametroFactuSecuencial> parametrofactusecuencialsAux= new ArrayList<ParametroFactuSecuencial>();
		
		for(ParametroFactuSecuencial parametrofactusecuencial:parametrofactusecuencials) {
			if(!parametrofactusecuencial.getIsDeleted()) {
				parametrofactusecuencialsAux.add(parametrofactusecuencial);
			}
		}
		
		parametrofactusecuencials=parametrofactusecuencialsAux;
	}
	
	public void quitarParametroFactuSecuencialsNulos() throws Exception {				
		
		List<ParametroFactuSecuencial> parametrofactusecuencialsAux= new ArrayList<ParametroFactuSecuencial>();
		
		for(ParametroFactuSecuencial parametrofactusecuencial : this.parametrofactusecuencials) {
			if(parametrofactusecuencial==null) {
				parametrofactusecuencialsAux.add(parametrofactusecuencial);
			}
		}
		
		//this.parametrofactusecuencials=parametrofactusecuencialsAux;
		
		this.parametrofactusecuencials.removeAll(parametrofactusecuencialsAux);
	}
	
	public void getSetVersionRowParametroFactuSecuencialWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametrofactusecuencial.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametrofactusecuencial.getIsDeleted() || (parametrofactusecuencial.getIsChanged()&&!parametrofactusecuencial.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametrofactusecuencialDataAccess.getSetVersionRowParametroFactuSecuencial(connexion,parametrofactusecuencial.getId());
				
				if(!parametrofactusecuencial.getVersionRow().equals(timestamp)) {	
					parametrofactusecuencial.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametrofactusecuencial.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroFactuSecuencial()throws Exception {	
		
		if(parametrofactusecuencial.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametrofactusecuencial.getIsDeleted() || (parametrofactusecuencial.getIsChanged()&&!parametrofactusecuencial.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametrofactusecuencialDataAccess.getSetVersionRowParametroFactuSecuencial(connexion,parametrofactusecuencial.getId());
			
			try {							
				if(!parametrofactusecuencial.getVersionRow().equals(timestamp)) {	
					parametrofactusecuencial.setVersionRow(timestamp);
				}
				
				parametrofactusecuencial.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroFactuSecuencialsWithConnection()throws Exception {	
		if(parametrofactusecuencials!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroFactuSecuencial parametrofactusecuencialAux:parametrofactusecuencials) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametrofactusecuencialAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrofactusecuencialAux.getIsDeleted() || (parametrofactusecuencialAux.getIsChanged()&&!parametrofactusecuencialAux.getIsNew())) {
						
						timestamp=parametrofactusecuencialDataAccess.getSetVersionRowParametroFactuSecuencial(connexion,parametrofactusecuencialAux.getId());
						
						if(!parametrofactusecuencial.getVersionRow().equals(timestamp)) {	
							parametrofactusecuencialAux.setVersionRow(timestamp);
						}
								
						parametrofactusecuencialAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroFactuSecuencials()throws Exception {	
		if(parametrofactusecuencials!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroFactuSecuencial parametrofactusecuencialAux:parametrofactusecuencials) {
					if(parametrofactusecuencialAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrofactusecuencialAux.getIsDeleted() || (parametrofactusecuencialAux.getIsChanged()&&!parametrofactusecuencialAux.getIsNew())) {
						
						timestamp=parametrofactusecuencialDataAccess.getSetVersionRowParametroFactuSecuencial(connexion,parametrofactusecuencialAux.getId());
						
						if(!parametrofactusecuencialAux.getVersionRow().equals(timestamp)) {	
							parametrofactusecuencialAux.setVersionRow(timestamp);
						}
						
													
						parametrofactusecuencialAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroFactuSecuencialParameterReturnGeneral cargarCombosLoteForeignKeyParametroFactuSecuencialWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoDocumentoGeneral,String finalQueryGlobalBodega,String finalQueryGlobalTipoParamFactuPlazo,String finalQueryGlobalFormato,String finalQueryGlobalBodegaTransferencia,String finalQueryGlobalTransaccionTransferencia) throws Exception {
		ParametroFactuSecuencialParameterReturnGeneral  parametrofactusecuencialReturnGeneral =new ParametroFactuSecuencialParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroFactuSecuencialWithConnection");connexion.begin();
			
			parametrofactusecuencialReturnGeneral =new ParametroFactuSecuencialParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrofactusecuencialReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrofactusecuencialReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoDocumentoGeneral> tipodocumentogeneralsForeignKey=new ArrayList<TipoDocumentoGeneral>();
			TipoDocumentoGeneralLogic tipodocumentogeneralLogic=new TipoDocumentoGeneralLogic();
			tipodocumentogeneralLogic.setConnexion(this.connexion);
			tipodocumentogeneralLogic.getTipoDocumentoGeneralDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoGeneral.equals("NONE")) {
				tipodocumentogeneralLogic.getTodosTipoDocumentoGenerals(finalQueryGlobalTipoDocumentoGeneral,new Pagination());
				tipodocumentogeneralsForeignKey=tipodocumentogeneralLogic.getTipoDocumentoGenerals();
			}

			parametrofactusecuencialReturnGeneral.settipodocumentogeneralsForeignKey(tipodocumentogeneralsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			parametrofactusecuencialReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<TipoParamFactuPlazo> tipoparamfactuplazosForeignKey=new ArrayList<TipoParamFactuPlazo>();
			TipoParamFactuPlazoLogic tipoparamfactuplazoLogic=new TipoParamFactuPlazoLogic();
			tipoparamfactuplazoLogic.setConnexion(this.connexion);
			tipoparamfactuplazoLogic.getTipoParamFactuPlazoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoParamFactuPlazo.equals("NONE")) {
				tipoparamfactuplazoLogic.getTodosTipoParamFactuPlazos(finalQueryGlobalTipoParamFactuPlazo,new Pagination());
				tipoparamfactuplazosForeignKey=tipoparamfactuplazoLogic.getTipoParamFactuPlazos();
			}

			parametrofactusecuencialReturnGeneral.settipoparamfactuplazosForeignKey(tipoparamfactuplazosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			parametrofactusecuencialReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Bodega> bodegatransferenciasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegatransferenciaLogic=new BodegaLogic();
			bodegatransferenciaLogic.setConnexion(this.connexion);
			bodegatransferenciaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaTransferencia.equals("NONE")) {
				bodegatransferenciaLogic.getTodosBodegas(finalQueryGlobalBodegaTransferencia,new Pagination());
				bodegatransferenciasForeignKey=bodegatransferenciaLogic.getBodegas();
			}

			parametrofactusecuencialReturnGeneral.setbodegatransferenciasForeignKey(bodegatransferenciasForeignKey);


			List<Transaccion> transacciontransferenciasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transacciontransferenciaLogic=new TransaccionLogic();
			transacciontransferenciaLogic.setConnexion(this.connexion);
			transacciontransferenciaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionTransferencia.equals("NONE")) {
				transacciontransferenciaLogic.getTodosTransaccions(finalQueryGlobalTransaccionTransferencia,new Pagination());
				transacciontransferenciasForeignKey=transacciontransferenciaLogic.getTransaccions();
			}

			parametrofactusecuencialReturnGeneral.settransacciontransferenciasForeignKey(transacciontransferenciasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametrofactusecuencialReturnGeneral;
	}
	
	public ParametroFactuSecuencialParameterReturnGeneral cargarCombosLoteForeignKeyParametroFactuSecuencial(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoDocumentoGeneral,String finalQueryGlobalBodega,String finalQueryGlobalTipoParamFactuPlazo,String finalQueryGlobalFormato,String finalQueryGlobalBodegaTransferencia,String finalQueryGlobalTransaccionTransferencia) throws Exception {
		ParametroFactuSecuencialParameterReturnGeneral  parametrofactusecuencialReturnGeneral =new ParametroFactuSecuencialParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametrofactusecuencialReturnGeneral =new ParametroFactuSecuencialParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrofactusecuencialReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrofactusecuencialReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoDocumentoGeneral> tipodocumentogeneralsForeignKey=new ArrayList<TipoDocumentoGeneral>();
			TipoDocumentoGeneralLogic tipodocumentogeneralLogic=new TipoDocumentoGeneralLogic();
			tipodocumentogeneralLogic.setConnexion(this.connexion);
			tipodocumentogeneralLogic.getTipoDocumentoGeneralDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoGeneral.equals("NONE")) {
				tipodocumentogeneralLogic.getTodosTipoDocumentoGenerals(finalQueryGlobalTipoDocumentoGeneral,new Pagination());
				tipodocumentogeneralsForeignKey=tipodocumentogeneralLogic.getTipoDocumentoGenerals();
			}

			parametrofactusecuencialReturnGeneral.settipodocumentogeneralsForeignKey(tipodocumentogeneralsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			parametrofactusecuencialReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<TipoParamFactuPlazo> tipoparamfactuplazosForeignKey=new ArrayList<TipoParamFactuPlazo>();
			TipoParamFactuPlazoLogic tipoparamfactuplazoLogic=new TipoParamFactuPlazoLogic();
			tipoparamfactuplazoLogic.setConnexion(this.connexion);
			tipoparamfactuplazoLogic.getTipoParamFactuPlazoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoParamFactuPlazo.equals("NONE")) {
				tipoparamfactuplazoLogic.getTodosTipoParamFactuPlazos(finalQueryGlobalTipoParamFactuPlazo,new Pagination());
				tipoparamfactuplazosForeignKey=tipoparamfactuplazoLogic.getTipoParamFactuPlazos();
			}

			parametrofactusecuencialReturnGeneral.settipoparamfactuplazosForeignKey(tipoparamfactuplazosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			parametrofactusecuencialReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Bodega> bodegatransferenciasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegatransferenciaLogic=new BodegaLogic();
			bodegatransferenciaLogic.setConnexion(this.connexion);
			bodegatransferenciaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaTransferencia.equals("NONE")) {
				bodegatransferenciaLogic.getTodosBodegas(finalQueryGlobalBodegaTransferencia,new Pagination());
				bodegatransferenciasForeignKey=bodegatransferenciaLogic.getBodegas();
			}

			parametrofactusecuencialReturnGeneral.setbodegatransferenciasForeignKey(bodegatransferenciasForeignKey);


			List<Transaccion> transacciontransferenciasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transacciontransferenciaLogic=new TransaccionLogic();
			transacciontransferenciaLogic.setConnexion(this.connexion);
			transacciontransferenciaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionTransferencia.equals("NONE")) {
				transacciontransferenciaLogic.getTodosTransaccions(finalQueryGlobalTransaccionTransferencia,new Pagination());
				transacciontransferenciasForeignKey=transacciontransferenciaLogic.getTransaccions();
			}

			parametrofactusecuencialReturnGeneral.settransacciontransferenciasForeignKey(transacciontransferenciasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametrofactusecuencialReturnGeneral;
	}
	
	
	public void deepLoad(ParametroFactuSecuencial parametrofactusecuencial,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroFactuSecuencialLogicAdditional.updateParametroFactuSecuencialToGet(parametrofactusecuencial,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrofactusecuencial.setEmpresa(parametrofactusecuencialDataAccess.getEmpresa(connexion,parametrofactusecuencial));
		parametrofactusecuencial.setSucursal(parametrofactusecuencialDataAccess.getSucursal(connexion,parametrofactusecuencial));
		parametrofactusecuencial.setTipoDocumentoGeneral(parametrofactusecuencialDataAccess.getTipoDocumentoGeneral(connexion,parametrofactusecuencial));
		parametrofactusecuencial.setBodega(parametrofactusecuencialDataAccess.getBodega(connexion,parametrofactusecuencial));
		parametrofactusecuencial.setTipoParamFactuPlazo(parametrofactusecuencialDataAccess.getTipoParamFactuPlazo(connexion,parametrofactusecuencial));
		parametrofactusecuencial.setFormato(parametrofactusecuencialDataAccess.getFormato(connexion,parametrofactusecuencial));
		parametrofactusecuencial.setBodegaTransferencia(parametrofactusecuencialDataAccess.getBodegaTransferencia(connexion,parametrofactusecuencial));
		parametrofactusecuencial.setTransaccionTransferencia(parametrofactusecuencialDataAccess.getTransaccionTransferencia(connexion,parametrofactusecuencial));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrofactusecuencial.setEmpresa(parametrofactusecuencialDataAccess.getEmpresa(connexion,parametrofactusecuencial));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrofactusecuencial.setSucursal(parametrofactusecuencialDataAccess.getSucursal(connexion,parametrofactusecuencial));
				continue;
			}

			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				parametrofactusecuencial.setTipoDocumentoGeneral(parametrofactusecuencialDataAccess.getTipoDocumentoGeneral(connexion,parametrofactusecuencial));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametrofactusecuencial.setBodega(parametrofactusecuencialDataAccess.getBodega(connexion,parametrofactusecuencial));
				continue;
			}

			if(clas.clas.equals(TipoParamFactuPlazo.class)) {
				parametrofactusecuencial.setTipoParamFactuPlazo(parametrofactusecuencialDataAccess.getTipoParamFactuPlazo(connexion,parametrofactusecuencial));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrofactusecuencial.setFormato(parametrofactusecuencialDataAccess.getFormato(connexion,parametrofactusecuencial));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametrofactusecuencial.setBodegaTransferencia(parametrofactusecuencialDataAccess.getBodegaTransferencia(connexion,parametrofactusecuencial));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactusecuencial.setTransaccionTransferencia(parametrofactusecuencialDataAccess.getTransaccionTransferencia(connexion,parametrofactusecuencial));
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
			parametrofactusecuencial.setEmpresa(parametrofactusecuencialDataAccess.getEmpresa(connexion,parametrofactusecuencial));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactusecuencial.setSucursal(parametrofactusecuencialDataAccess.getSucursal(connexion,parametrofactusecuencial));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactusecuencial.setTipoDocumentoGeneral(parametrofactusecuencialDataAccess.getTipoDocumentoGeneral(connexion,parametrofactusecuencial));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactusecuencial.setBodega(parametrofactusecuencialDataAccess.getBodega(connexion,parametrofactusecuencial));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoParamFactuPlazo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactusecuencial.setTipoParamFactuPlazo(parametrofactusecuencialDataAccess.getTipoParamFactuPlazo(connexion,parametrofactusecuencial));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactusecuencial.setFormato(parametrofactusecuencialDataAccess.getFormato(connexion,parametrofactusecuencial));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactusecuencial.setBodegaTransferencia(parametrofactusecuencialDataAccess.getBodegaTransferencia(connexion,parametrofactusecuencial));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactusecuencial.setTransaccionTransferencia(parametrofactusecuencialDataAccess.getTransaccionTransferencia(connexion,parametrofactusecuencial));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrofactusecuencial.setEmpresa(parametrofactusecuencialDataAccess.getEmpresa(connexion,parametrofactusecuencial));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrofactusecuencial.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametrofactusecuencial.setSucursal(parametrofactusecuencialDataAccess.getSucursal(connexion,parametrofactusecuencial));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrofactusecuencial.getSucursal(),isDeep,deepLoadType,clases);
				
		parametrofactusecuencial.setTipoDocumentoGeneral(parametrofactusecuencialDataAccess.getTipoDocumentoGeneral(connexion,parametrofactusecuencial));
		TipoDocumentoGeneralLogic tipodocumentogeneralLogic= new TipoDocumentoGeneralLogic(connexion);
		tipodocumentogeneralLogic.deepLoad(parametrofactusecuencial.getTipoDocumentoGeneral(),isDeep,deepLoadType,clases);
				
		parametrofactusecuencial.setBodega(parametrofactusecuencialDataAccess.getBodega(connexion,parametrofactusecuencial));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(parametrofactusecuencial.getBodega(),isDeep,deepLoadType,clases);
				
		parametrofactusecuencial.setTipoParamFactuPlazo(parametrofactusecuencialDataAccess.getTipoParamFactuPlazo(connexion,parametrofactusecuencial));
		TipoParamFactuPlazoLogic tipoparamfactuplazoLogic= new TipoParamFactuPlazoLogic(connexion);
		tipoparamfactuplazoLogic.deepLoad(parametrofactusecuencial.getTipoParamFactuPlazo(),isDeep,deepLoadType,clases);
				
		parametrofactusecuencial.setFormato(parametrofactusecuencialDataAccess.getFormato(connexion,parametrofactusecuencial));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(parametrofactusecuencial.getFormato(),isDeep,deepLoadType,clases);
				
		parametrofactusecuencial.setBodegaTransferencia(parametrofactusecuencialDataAccess.getBodegaTransferencia(connexion,parametrofactusecuencial));
		BodegaLogic bodegatransferenciaLogic= new BodegaLogic(connexion);
		bodegatransferenciaLogic.deepLoad(parametrofactusecuencial.getBodegaTransferencia(),isDeep,deepLoadType,clases);
				
		parametrofactusecuencial.setTransaccionTransferencia(parametrofactusecuencialDataAccess.getTransaccionTransferencia(connexion,parametrofactusecuencial));
		TransaccionLogic transacciontransferenciaLogic= new TransaccionLogic(connexion);
		transacciontransferenciaLogic.deepLoad(parametrofactusecuencial.getTransaccionTransferencia(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrofactusecuencial.setEmpresa(parametrofactusecuencialDataAccess.getEmpresa(connexion,parametrofactusecuencial));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametrofactusecuencial.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrofactusecuencial.setSucursal(parametrofactusecuencialDataAccess.getSucursal(connexion,parametrofactusecuencial));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(parametrofactusecuencial.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				parametrofactusecuencial.setTipoDocumentoGeneral(parametrofactusecuencialDataAccess.getTipoDocumentoGeneral(connexion,parametrofactusecuencial));
				TipoDocumentoGeneralLogic tipodocumentogeneralLogic= new TipoDocumentoGeneralLogic(connexion);
				tipodocumentogeneralLogic.deepLoad(parametrofactusecuencial.getTipoDocumentoGeneral(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametrofactusecuencial.setBodega(parametrofactusecuencialDataAccess.getBodega(connexion,parametrofactusecuencial));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(parametrofactusecuencial.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoParamFactuPlazo.class)) {
				parametrofactusecuencial.setTipoParamFactuPlazo(parametrofactusecuencialDataAccess.getTipoParamFactuPlazo(connexion,parametrofactusecuencial));
				TipoParamFactuPlazoLogic tipoparamfactuplazoLogic= new TipoParamFactuPlazoLogic(connexion);
				tipoparamfactuplazoLogic.deepLoad(parametrofactusecuencial.getTipoParamFactuPlazo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrofactusecuencial.setFormato(parametrofactusecuencialDataAccess.getFormato(connexion,parametrofactusecuencial));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(parametrofactusecuencial.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametrofactusecuencial.setBodegaTransferencia(parametrofactusecuencialDataAccess.getBodegaTransferencia(connexion,parametrofactusecuencial));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(parametrofactusecuencial.getBodegaTransferencia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactusecuencial.setTransaccionTransferencia(parametrofactusecuencialDataAccess.getTransaccionTransferencia(connexion,parametrofactusecuencial));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrofactusecuencial.getTransaccionTransferencia(),isDeep,deepLoadType,clases);				
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
			parametrofactusecuencial.setEmpresa(parametrofactusecuencialDataAccess.getEmpresa(connexion,parametrofactusecuencial));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametrofactusecuencial.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactusecuencial.setSucursal(parametrofactusecuencialDataAccess.getSucursal(connexion,parametrofactusecuencial));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(parametrofactusecuencial.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactusecuencial.setTipoDocumentoGeneral(parametrofactusecuencialDataAccess.getTipoDocumentoGeneral(connexion,parametrofactusecuencial));
			TipoDocumentoGeneralLogic tipodocumentogeneralLogic= new TipoDocumentoGeneralLogic(connexion);
			tipodocumentogeneralLogic.deepLoad(parametrofactusecuencial.getTipoDocumentoGeneral(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactusecuencial.setBodega(parametrofactusecuencialDataAccess.getBodega(connexion,parametrofactusecuencial));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(parametrofactusecuencial.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoParamFactuPlazo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactusecuencial.setTipoParamFactuPlazo(parametrofactusecuencialDataAccess.getTipoParamFactuPlazo(connexion,parametrofactusecuencial));
			TipoParamFactuPlazoLogic tipoparamfactuplazoLogic= new TipoParamFactuPlazoLogic(connexion);
			tipoparamfactuplazoLogic.deepLoad(parametrofactusecuencial.getTipoParamFactuPlazo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactusecuencial.setFormato(parametrofactusecuencialDataAccess.getFormato(connexion,parametrofactusecuencial));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(parametrofactusecuencial.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactusecuencial.setBodegaTransferencia(parametrofactusecuencialDataAccess.getBodegaTransferencia(connexion,parametrofactusecuencial));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(parametrofactusecuencial.getBodegaTransferencia(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactusecuencial.setTransaccionTransferencia(parametrofactusecuencialDataAccess.getTransaccionTransferencia(connexion,parametrofactusecuencial));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrofactusecuencial.getTransaccionTransferencia(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroFactuSecuencial parametrofactusecuencial,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroFactuSecuencialLogicAdditional.updateParametroFactuSecuencialToSave(parametrofactusecuencial,this.arrDatoGeneral);
			
ParametroFactuSecuencialDataAccess.save(parametrofactusecuencial, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrofactusecuencial.getEmpresa(),connexion);

		SucursalDataAccess.save(parametrofactusecuencial.getSucursal(),connexion);

		TipoDocumentoGeneralDataAccess.save(parametrofactusecuencial.getTipoDocumentoGeneral(),connexion);

		BodegaDataAccess.save(parametrofactusecuencial.getBodega(),connexion);

		TipoParamFactuPlazoDataAccess.save(parametrofactusecuencial.getTipoParamFactuPlazo(),connexion);

		FormatoDataAccess.save(parametrofactusecuencial.getFormato(),connexion);

		BodegaDataAccess.save(parametrofactusecuencial.getBodegaTransferencia(),connexion);

		TransaccionDataAccess.save(parametrofactusecuencial.getTransaccionTransferencia(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrofactusecuencial.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrofactusecuencial.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				TipoDocumentoGeneralDataAccess.save(parametrofactusecuencial.getTipoDocumentoGeneral(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametrofactusecuencial.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoParamFactuPlazo.class)) {
				TipoParamFactuPlazoDataAccess.save(parametrofactusecuencial.getTipoParamFactuPlazo(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrofactusecuencial.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametrofactusecuencial.getBodegaTransferencia(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactusecuencial.getTransaccionTransferencia(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrofactusecuencial.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrofactusecuencial.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(parametrofactusecuencial.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrofactusecuencial.getSucursal(),isDeep,deepLoadType,clases);
				

		TipoDocumentoGeneralDataAccess.save(parametrofactusecuencial.getTipoDocumentoGeneral(),connexion);
		TipoDocumentoGeneralLogic tipodocumentogeneralLogic= new TipoDocumentoGeneralLogic(connexion);
		tipodocumentogeneralLogic.deepLoad(parametrofactusecuencial.getTipoDocumentoGeneral(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(parametrofactusecuencial.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(parametrofactusecuencial.getBodega(),isDeep,deepLoadType,clases);
				

		TipoParamFactuPlazoDataAccess.save(parametrofactusecuencial.getTipoParamFactuPlazo(),connexion);
		TipoParamFactuPlazoLogic tipoparamfactuplazoLogic= new TipoParamFactuPlazoLogic(connexion);
		tipoparamfactuplazoLogic.deepLoad(parametrofactusecuencial.getTipoParamFactuPlazo(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(parametrofactusecuencial.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(parametrofactusecuencial.getFormato(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(parametrofactusecuencial.getBodegaTransferencia(),connexion);
		BodegaLogic bodegatransferenciaLogic= new BodegaLogic(connexion);
		bodegatransferenciaLogic.deepLoad(parametrofactusecuencial.getBodegaTransferencia(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrofactusecuencial.getTransaccionTransferencia(),connexion);
		TransaccionLogic transacciontransferenciaLogic= new TransaccionLogic(connexion);
		transacciontransferenciaLogic.deepLoad(parametrofactusecuencial.getTransaccionTransferencia(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrofactusecuencial.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametrofactusecuencial.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrofactusecuencial.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(parametrofactusecuencial.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				TipoDocumentoGeneralDataAccess.save(parametrofactusecuencial.getTipoDocumentoGeneral(),connexion);
				TipoDocumentoGeneralLogic tipodocumentogeneralLogic= new TipoDocumentoGeneralLogic(connexion);
				tipodocumentogeneralLogic.deepSave(parametrofactusecuencial.getTipoDocumentoGeneral(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametrofactusecuencial.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(parametrofactusecuencial.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoParamFactuPlazo.class)) {
				TipoParamFactuPlazoDataAccess.save(parametrofactusecuencial.getTipoParamFactuPlazo(),connexion);
				TipoParamFactuPlazoLogic tipoparamfactuplazoLogic= new TipoParamFactuPlazoLogic(connexion);
				tipoparamfactuplazoLogic.deepSave(parametrofactusecuencial.getTipoParamFactuPlazo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrofactusecuencial.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(parametrofactusecuencial.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametrofactusecuencial.getBodegaTransferencia(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(parametrofactusecuencial.getBodegaTransferencia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactusecuencial.getTransaccionTransferencia(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrofactusecuencial.getTransaccionTransferencia(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroFactuSecuencial.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametrofactusecuencial,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(parametrofactusecuencial);
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
			this.deepLoad(this.parametrofactusecuencial,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencial);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroFactuSecuencial.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametrofactusecuencials!=null) {
				for(ParametroFactuSecuencial parametrofactusecuencial:parametrofactusecuencials) {
					this.deepLoad(parametrofactusecuencial,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(parametrofactusecuencials);
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
			if(parametrofactusecuencials!=null) {
				for(ParametroFactuSecuencial parametrofactusecuencial:parametrofactusecuencials) {
					this.deepLoad(parametrofactusecuencial,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(parametrofactusecuencials);
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
			this.getNewConnexionToDeep(ParametroFactuSecuencial.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametrofactusecuencial,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroFactuSecuencial.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametrofactusecuencials!=null) {
				for(ParametroFactuSecuencial parametrofactusecuencial:parametrofactusecuencials) {
					this.deepSave(parametrofactusecuencial,isDeep,deepLoadType,clases);
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
			if(parametrofactusecuencials!=null) {
				for(ParametroFactuSecuencial parametrofactusecuencial:parametrofactusecuencials) {
					this.deepSave(parametrofactusecuencial,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroFactuSecuencialsFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ParametroFactuSecuencialConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuSecuencialsFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ParametroFactuSecuencialConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuSecuencialsFK_IdBodegaTransferenciaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega_transferencia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaTransferencia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaTransferencia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_transferencia,ParametroFactuSecuencialConstantesFunciones.IDBODEGATRANSFERENCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaTransferencia);

			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaTransferencia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuSecuencialsFK_IdBodegaTransferencia(String sFinalQuery,Pagination pagination,Long id_bodega_transferencia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaTransferencia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaTransferencia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_transferencia,ParametroFactuSecuencialConstantesFunciones.IDBODEGATRANSFERENCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaTransferencia);

			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaTransferencia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuSecuencialsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroFactuSecuencialConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuSecuencialsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroFactuSecuencialConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuSecuencialsFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,ParametroFactuSecuencialConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuSecuencialsFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,ParametroFactuSecuencialConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuSecuencialsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroFactuSecuencialConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuSecuencialsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroFactuSecuencialConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuSecuencialsFK_IdTipoDocumentoGeneralWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_documento_general)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoGeneral= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoGeneral.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_general,ParametroFactuSecuencialConstantesFunciones.IDTIPODOCUMENTOGENERAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoGeneral);

			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoGeneral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuSecuencialsFK_IdTipoDocumentoGeneral(String sFinalQuery,Pagination pagination,Long id_tipo_documento_general)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoGeneral= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoGeneral.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_general,ParametroFactuSecuencialConstantesFunciones.IDTIPODOCUMENTOGENERAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoGeneral);

			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoGeneral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuSecuencialsFK_IdTipoParamFactuPlazoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_param_factu_plazo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoParamFactuPlazo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoParamFactuPlazo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_param_factu_plazo,ParametroFactuSecuencialConstantesFunciones.IDTIPOPARAMFACTUPLAZO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoParamFactuPlazo);

			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoParamFactuPlazo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuSecuencialsFK_IdTipoParamFactuPlazo(String sFinalQuery,Pagination pagination,Long id_tipo_param_factu_plazo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoParamFactuPlazo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoParamFactuPlazo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_param_factu_plazo,ParametroFactuSecuencialConstantesFunciones.IDTIPOPARAMFACTUPLAZO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoParamFactuPlazo);

			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoParamFactuPlazo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuSecuencialsFK_IdTransaccionTransferenciaWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_transferencia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuSecuencial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionTransferencia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionTransferencia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_transferencia,ParametroFactuSecuencialConstantesFunciones.IDTRANSACCIONTRANSFERENCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionTransferencia);

			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionTransferencia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuSecuencialsFK_IdTransaccionTransferencia(String sFinalQuery,Pagination pagination,Long id_transaccion_transferencia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionTransferencia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionTransferencia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_transferencia,ParametroFactuSecuencialConstantesFunciones.IDTRANSACCIONTRANSFERENCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionTransferencia);

			ParametroFactuSecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionTransferencia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuSecuencialConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuSecuencial(this.parametrofactusecuencials);
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
			if(ParametroFactuSecuencialConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFactuSecuencialDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroFactuSecuencial parametrofactusecuencial,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroFactuSecuencialConstantesFunciones.ISCONAUDITORIA) {
				if(parametrofactusecuencial.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFactuSecuencialDataAccess.TABLENAME, parametrofactusecuencial.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroFactuSecuencialConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroFactuSecuencialLogic.registrarAuditoriaDetallesParametroFactuSecuencial(connexion,parametrofactusecuencial,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametrofactusecuencial.getIsDeleted()) {
					/*if(!parametrofactusecuencial.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroFactuSecuencialDataAccess.TABLENAME, parametrofactusecuencial.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroFactuSecuencialLogic.registrarAuditoriaDetallesParametroFactuSecuencial(connexion,parametrofactusecuencial,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFactuSecuencialDataAccess.TABLENAME, parametrofactusecuencial.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametrofactusecuencial.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFactuSecuencialDataAccess.TABLENAME, parametrofactusecuencial.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroFactuSecuencialConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroFactuSecuencialLogic.registrarAuditoriaDetallesParametroFactuSecuencial(connexion,parametrofactusecuencial,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroFactuSecuencial(Connexion connexion,ParametroFactuSecuencial parametrofactusecuencial)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametrofactusecuencial.getIsNew()||!parametrofactusecuencial.getid_empresa().equals(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_empresa()!=null)
				{
					strValorActual=parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_empresa().toString();
				}
				if(parametrofactusecuencial.getid_empresa()!=null)
				{
					strValorNuevo=parametrofactusecuencial.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuSecuencialConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactusecuencial.getIsNew()||!parametrofactusecuencial.getid_sucursal().equals(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_sucursal()!=null)
				{
					strValorActual=parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_sucursal().toString();
				}
				if(parametrofactusecuencial.getid_sucursal()!=null)
				{
					strValorNuevo=parametrofactusecuencial.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuSecuencialConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactusecuencial.getIsNew()||!parametrofactusecuencial.getid_tipo_documento_general().equals(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_tipo_documento_general()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_tipo_documento_general()!=null)
				{
					strValorActual=parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_tipo_documento_general().toString();
				}
				if(parametrofactusecuencial.getid_tipo_documento_general()!=null)
				{
					strValorNuevo=parametrofactusecuencial.getid_tipo_documento_general().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuSecuencialConstantesFunciones.IDTIPODOCUMENTOGENERAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactusecuencial.getIsNew()||!parametrofactusecuencial.getsecuencial().equals(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getsecuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getsecuencial()!=null)
				{
					strValorActual=parametrofactusecuencial.getParametroFactuSecuencialOriginal().getsecuencial();
				}
				if(parametrofactusecuencial.getsecuencial()!=null)
				{
					strValorNuevo=parametrofactusecuencial.getsecuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuSecuencialConstantesFunciones.SECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactusecuencial.getIsNew()||!parametrofactusecuencial.getnumero_digitos().equals(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getnumero_digitos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getnumero_digitos()!=null)
				{
					strValorActual=parametrofactusecuencial.getParametroFactuSecuencialOriginal().getnumero_digitos().toString();
				}
				if(parametrofactusecuencial.getnumero_digitos()!=null)
				{
					strValorNuevo=parametrofactusecuencial.getnumero_digitos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOS,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactusecuencial.getIsNew()||!parametrofactusecuencial.getnumero_items().equals(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getnumero_items()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getnumero_items()!=null)
				{
					strValorActual=parametrofactusecuencial.getParametroFactuSecuencialOriginal().getnumero_items().toString();
				}
				if(parametrofactusecuencial.getnumero_items()!=null)
				{
					strValorNuevo=parametrofactusecuencial.getnumero_items().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuSecuencialConstantesFunciones.NUMEROITEMS,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactusecuencial.getIsNew()||!parametrofactusecuencial.getnumero_descuento().equals(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getnumero_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getnumero_descuento()!=null)
				{
					strValorActual=parametrofactusecuencial.getParametroFactuSecuencialOriginal().getnumero_descuento().toString();
				}
				if(parametrofactusecuencial.getnumero_descuento()!=null)
				{
					strValorNuevo=parametrofactusecuencial.getnumero_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuSecuencialConstantesFunciones.NUMERODESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactusecuencial.getIsNew()||!parametrofactusecuencial.getnumero_adiicionales().equals(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getnumero_adiicionales()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getnumero_adiicionales()!=null)
				{
					strValorActual=parametrofactusecuencial.getParametroFactuSecuencialOriginal().getnumero_adiicionales().toString();
				}
				if(parametrofactusecuencial.getnumero_adiicionales()!=null)
				{
					strValorNuevo=parametrofactusecuencial.getnumero_adiicionales().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuSecuencialConstantesFunciones.NUMEROADIICIONALES,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactusecuencial.getIsNew()||!parametrofactusecuencial.getnumero_digito_inicio().equals(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getnumero_digito_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getnumero_digito_inicio()!=null)
				{
					strValorActual=parametrofactusecuencial.getParametroFactuSecuencialOriginal().getnumero_digito_inicio().toString();
				}
				if(parametrofactusecuencial.getnumero_digito_inicio()!=null)
				{
					strValorNuevo=parametrofactusecuencial.getnumero_digito_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOINICIO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactusecuencial.getIsNew()||!parametrofactusecuencial.getnumero_digito_fin().equals(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getnumero_digito_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getnumero_digito_fin()!=null)
				{
					strValorActual=parametrofactusecuencial.getParametroFactuSecuencialOriginal().getnumero_digito_fin().toString();
				}
				if(parametrofactusecuencial.getnumero_digito_fin()!=null)
				{
					strValorNuevo=parametrofactusecuencial.getnumero_digito_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOFIN,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactusecuencial.getIsNew()||!parametrofactusecuencial.getnumero_dias_plazo().equals(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getnumero_dias_plazo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getnumero_dias_plazo()!=null)
				{
					strValorActual=parametrofactusecuencial.getParametroFactuSecuencialOriginal().getnumero_dias_plazo().toString();
				}
				if(parametrofactusecuencial.getnumero_dias_plazo()!=null)
				{
					strValorNuevo=parametrofactusecuencial.getnumero_dias_plazo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuSecuencialConstantesFunciones.NUMERODIASPLAZO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactusecuencial.getIsNew()||!parametrofactusecuencial.getcon_detalle().equals(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getcon_detalle()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getcon_detalle()!=null)
				{
					strValorActual=parametrofactusecuencial.getParametroFactuSecuencialOriginal().getcon_detalle().toString();
				}
				if(parametrofactusecuencial.getcon_detalle()!=null)
				{
					strValorNuevo=parametrofactusecuencial.getcon_detalle().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuSecuencialConstantesFunciones.CONDETALLE,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactusecuencial.getIsNew()||!parametrofactusecuencial.getcon_lector().equals(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getcon_lector()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getcon_lector()!=null)
				{
					strValorActual=parametrofactusecuencial.getParametroFactuSecuencialOriginal().getcon_lector().toString();
				}
				if(parametrofactusecuencial.getcon_lector()!=null)
				{
					strValorNuevo=parametrofactusecuencial.getcon_lector().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuSecuencialConstantesFunciones.CONLECTOR,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactusecuencial.getIsNew()||!parametrofactusecuencial.getid_bodega().equals(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_bodega()!=null)
				{
					strValorActual=parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_bodega().toString();
				}
				if(parametrofactusecuencial.getid_bodega()!=null)
				{
					strValorNuevo=parametrofactusecuencial.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuSecuencialConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactusecuencial.getIsNew()||!parametrofactusecuencial.getid_tipo_param_factu_plazo().equals(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_tipo_param_factu_plazo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_tipo_param_factu_plazo()!=null)
				{
					strValorActual=parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_tipo_param_factu_plazo().toString();
				}
				if(parametrofactusecuencial.getid_tipo_param_factu_plazo()!=null)
				{
					strValorNuevo=parametrofactusecuencial.getid_tipo_param_factu_plazo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuSecuencialConstantesFunciones.IDTIPOPARAMFACTUPLAZO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactusecuencial.getIsNew()||!parametrofactusecuencial.getid_formato().equals(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_formato()!=null)
				{
					strValorActual=parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_formato().toString();
				}
				if(parametrofactusecuencial.getid_formato()!=null)
				{
					strValorNuevo=parametrofactusecuencial.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuSecuencialConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactusecuencial.getIsNew()||!parametrofactusecuencial.getcon_transferencia().equals(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getcon_transferencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getcon_transferencia()!=null)
				{
					strValorActual=parametrofactusecuencial.getParametroFactuSecuencialOriginal().getcon_transferencia().toString();
				}
				if(parametrofactusecuencial.getcon_transferencia()!=null)
				{
					strValorNuevo=parametrofactusecuencial.getcon_transferencia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuSecuencialConstantesFunciones.CONTRANSFERENCIA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactusecuencial.getIsNew()||!parametrofactusecuencial.getid_bodega_transferencia().equals(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_bodega_transferencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_bodega_transferencia()!=null)
				{
					strValorActual=parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_bodega_transferencia().toString();
				}
				if(parametrofactusecuencial.getid_bodega_transferencia()!=null)
				{
					strValorNuevo=parametrofactusecuencial.getid_bodega_transferencia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuSecuencialConstantesFunciones.IDBODEGATRANSFERENCIA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactusecuencial.getIsNew()||!parametrofactusecuencial.getid_transaccion_transferencia().equals(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_transaccion_transferencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_transaccion_transferencia()!=null)
				{
					strValorActual=parametrofactusecuencial.getParametroFactuSecuencialOriginal().getid_transaccion_transferencia().toString();
				}
				if(parametrofactusecuencial.getid_transaccion_transferencia()!=null)
				{
					strValorNuevo=parametrofactusecuencial.getid_transaccion_transferencia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuSecuencialConstantesFunciones.IDTRANSACCIONTRANSFERENCIA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroFactuSecuencialRelacionesWithConnection(ParametroFactuSecuencial parametrofactusecuencial) throws Exception {

		if(!parametrofactusecuencial.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroFactuSecuencialRelacionesBase(parametrofactusecuencial,true);
		}
	}

	public void saveParametroFactuSecuencialRelaciones(ParametroFactuSecuencial parametrofactusecuencial)throws Exception {

		if(!parametrofactusecuencial.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroFactuSecuencialRelacionesBase(parametrofactusecuencial,false);
		}
	}

	public void saveParametroFactuSecuencialRelacionesBase(ParametroFactuSecuencial parametrofactusecuencial,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroFactuSecuencial-saveRelacionesWithConnection");}
	

			this.setParametroFactuSecuencial(parametrofactusecuencial);

			if(ParametroFactuSecuencialLogicAdditional.validarSaveRelaciones(parametrofactusecuencial,this)) {

				ParametroFactuSecuencialLogicAdditional.updateRelacionesToSave(parametrofactusecuencial,this);

				if((parametrofactusecuencial.getIsNew()||parametrofactusecuencial.getIsChanged())&&!parametrofactusecuencial.getIsDeleted()) {
					this.saveParametroFactuSecuencial();
					this.saveParametroFactuSecuencialRelacionesDetalles();

				} else if(parametrofactusecuencial.getIsDeleted()) {
					this.saveParametroFactuSecuencialRelacionesDetalles();
					this.saveParametroFactuSecuencial();
				}

				ParametroFactuSecuencialLogicAdditional.updateRelacionesToSaveAfter(parametrofactusecuencial,this);

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
	
	
	private void saveParametroFactuSecuencialRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroFactuSecuencial(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroFactuSecuencialConstantesFunciones.getClassesForeignKeysOfParametroFactuSecuencial(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFactuSecuencial(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroFactuSecuencialConstantesFunciones.getClassesRelationshipsOfParametroFactuSecuencial(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

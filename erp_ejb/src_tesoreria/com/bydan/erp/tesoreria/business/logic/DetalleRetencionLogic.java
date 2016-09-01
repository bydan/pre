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
package com.bydan.erp.tesoreria.business.logic;

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
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.tesoreria.util.DetalleRetencionConstantesFunciones;
import com.bydan.erp.tesoreria.util.DetalleRetencionParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.DetalleRetencionParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.DetalleRetencion;
import com.bydan.erp.tesoreria.business.logic.DetalleRetencionLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

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
public class DetalleRetencionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleRetencionLogic.class);
	
	protected DetalleRetencionDataAccess detalleretencionDataAccess; 	
	protected DetalleRetencion detalleretencion;
	protected List<DetalleRetencion> detalleretencions;
	protected Object detalleretencionObject;	
	protected List<Object> detalleretencionsObject;
	
	public static ClassValidator<DetalleRetencion> detalleretencionValidator = new ClassValidator<DetalleRetencion>(DetalleRetencion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleRetencionLogicAdditional detalleretencionLogicAdditional=null;
	
	public DetalleRetencionLogicAdditional getDetalleRetencionLogicAdditional() {
		return this.detalleretencionLogicAdditional;
	}
	
	public void setDetalleRetencionLogicAdditional(DetalleRetencionLogicAdditional detalleretencionLogicAdditional) {
		try {
			this.detalleretencionLogicAdditional=detalleretencionLogicAdditional;
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
	
	
	
	
	public  DetalleRetencionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalleretencionDataAccess = new DetalleRetencionDataAccess();
			
			this.detalleretencions= new ArrayList<DetalleRetencion>();
			this.detalleretencion= new DetalleRetencion();
			
			this.detalleretencionObject=new Object();
			this.detalleretencionsObject=new ArrayList<Object>();
				
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
			
			this.detalleretencionDataAccess.setConnexionType(this.connexionType);
			this.detalleretencionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleRetencionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalleretencionDataAccess = new DetalleRetencionDataAccess();
			this.detalleretencions= new ArrayList<DetalleRetencion>();
			this.detalleretencion= new DetalleRetencion();
			this.detalleretencionObject=new Object();
			this.detalleretencionsObject=new ArrayList<Object>();
			
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
			
			this.detalleretencionDataAccess.setConnexionType(this.connexionType);
			this.detalleretencionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleRetencion getDetalleRetencion() throws Exception {	
		DetalleRetencionLogicAdditional.checkDetalleRetencionToGet(detalleretencion,this.datosCliente,this.arrDatoGeneral);
		DetalleRetencionLogicAdditional.updateDetalleRetencionToGet(detalleretencion,this.arrDatoGeneral);
		
		return detalleretencion;
	}
		
	public void setDetalleRetencion(DetalleRetencion newDetalleRetencion) {
		this.detalleretencion = newDetalleRetencion;
	}
	
	public DetalleRetencionDataAccess getDetalleRetencionDataAccess() {
		return detalleretencionDataAccess;
	}
	
	public void setDetalleRetencionDataAccess(DetalleRetencionDataAccess newdetalleretencionDataAccess) {
		this.detalleretencionDataAccess = newdetalleretencionDataAccess;
	}
	
	public List<DetalleRetencion> getDetalleRetencions() throws Exception {		
		this.quitarDetalleRetencionsNulos();
		
		DetalleRetencionLogicAdditional.checkDetalleRetencionToGets(detalleretencions,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleRetencion detalleretencionLocal: detalleretencions ) {
			DetalleRetencionLogicAdditional.updateDetalleRetencionToGet(detalleretencionLocal,this.arrDatoGeneral);
		}
		
		return detalleretencions;
	}
	
	public void setDetalleRetencions(List<DetalleRetencion> newDetalleRetencions) {
		this.detalleretencions = newDetalleRetencions;
	}
	
	public Object getDetalleRetencionObject() {	
		this.detalleretencionObject=this.detalleretencionDataAccess.getEntityObject();
		return this.detalleretencionObject;
	}
		
	public void setDetalleRetencionObject(Object newDetalleRetencionObject) {
		this.detalleretencionObject = newDetalleRetencionObject;
	}
	
	public List<Object> getDetalleRetencionsObject() {		
		this.detalleretencionsObject=this.detalleretencionDataAccess.getEntitiesObject();
		return this.detalleretencionsObject;
	}
		
	public void setDetalleRetencionsObject(List<Object> newDetalleRetencionsObject) {
		this.detalleretencionsObject = newDetalleRetencionsObject;
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
		
		if(this.detalleretencionDataAccess!=null) {
			this.detalleretencionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalleretencionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalleretencionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalleretencion = new  DetalleRetencion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleretencion=detalleretencionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencion);
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
		detalleretencion = new  DetalleRetencion();
		  		  
        try {
			
			detalleretencion=detalleretencionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalleretencion = new  DetalleRetencion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleretencion=detalleretencionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencion);
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
		detalleretencion = new  DetalleRetencion();
		  		  
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
		detalleretencion = new  DetalleRetencion();
		  		  
        try {
			
			detalleretencion=detalleretencionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalleretencion = new  DetalleRetencion();
		  		  
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
		detalleretencion = new  DetalleRetencion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalleretencionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleretencion = new  DetalleRetencion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalleretencionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleretencion = new  DetalleRetencion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalleretencionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleretencion = new  DetalleRetencion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalleretencionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleretencion = new  DetalleRetencion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalleretencionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleretencion = new  DetalleRetencion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalleretencionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleretencions = new  ArrayList<DetalleRetencion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleretencions=detalleretencionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleRetencion(detalleretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencions);
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
		detalleretencions = new  ArrayList<DetalleRetencion>();
		  		  
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
		detalleretencions = new  ArrayList<DetalleRetencion>();
		  		  
        try {			
			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleretencions=detalleretencionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleRetencion(detalleretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalleretencions = new  ArrayList<DetalleRetencion>();
		  		  
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
		detalleretencions = new  ArrayList<DetalleRetencion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleretencions=detalleretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleRetencion(detalleretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencions);
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
		detalleretencions = new  ArrayList<DetalleRetencion>();
		  		  
        try {
			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleretencions=detalleretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleRetencion(detalleretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencions);
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
		detalleretencions = new  ArrayList<DetalleRetencion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleretencions=detalleretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleRetencion(detalleretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencions);
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
		detalleretencions = new  ArrayList<DetalleRetencion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleretencions=detalleretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleRetencion(detalleretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalleretencion = new  DetalleRetencion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleretencion=detalleretencionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleRetencion(detalleretencion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencion);
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
		detalleretencion = new  DetalleRetencion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleretencion=detalleretencionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleRetencion(detalleretencion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleretencions = new  ArrayList<DetalleRetencion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleretencions=detalleretencionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleRetencion(detalleretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencions);
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
		detalleretencions = new  ArrayList<DetalleRetencion>();
		  		  
        try {
			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleretencions=detalleretencionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleRetencion(detalleretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleRetencionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalleretencions = new  ArrayList<DetalleRetencion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-getTodosDetalleRetencionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleretencions=detalleretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleRetencion(detalleretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencions);
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
	
	public  void  getTodosDetalleRetencions(String sFinalQuery,Pagination pagination)throws Exception {
		detalleretencions = new  ArrayList<DetalleRetencion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleretencions=detalleretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleRetencion(detalleretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleRetencion(DetalleRetencion detalleretencion) throws Exception {
		Boolean estaValidado=false;
		
		if(detalleretencion.getIsNew() || detalleretencion.getIsChanged()) { 
			this.invalidValues = detalleretencionValidator.getInvalidValues(detalleretencion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalleretencion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleRetencion(List<DetalleRetencion> DetalleRetencions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleRetencion detalleretencionLocal:detalleretencions) {				
			estaValidadoObjeto=this.validarGuardarDetalleRetencion(detalleretencionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleRetencion(List<DetalleRetencion> DetalleRetencions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleRetencion(detalleretencions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleRetencion(DetalleRetencion DetalleRetencion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleRetencion(detalleretencion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleRetencion detalleretencion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalleretencion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleRetencionConstantesFunciones.getDetalleRetencionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalleretencion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleRetencionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleRetencionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleRetencionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-saveDetalleRetencionWithConnection");connexion.begin();			
			
			DetalleRetencionLogicAdditional.checkDetalleRetencionToSave(this.detalleretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleRetencionLogicAdditional.updateDetalleRetencionToSave(this.detalleretencion,this.arrDatoGeneral);
			
			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleretencion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleRetencion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleRetencion(this.detalleretencion)) {
				DetalleRetencionDataAccess.save(this.detalleretencion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalleretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleRetencionLogicAdditional.checkDetalleRetencionToSaveAfter(this.detalleretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleRetencion();
			
			connexion.commit();			
			
			if(this.detalleretencion.getIsDeleted()) {
				this.detalleretencion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleRetencion()throws Exception {	
		try {	
			
			DetalleRetencionLogicAdditional.checkDetalleRetencionToSave(this.detalleretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleRetencionLogicAdditional.updateDetalleRetencionToSave(this.detalleretencion,this.arrDatoGeneral);
			
			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleretencion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleRetencion(this.detalleretencion)) {			
				DetalleRetencionDataAccess.save(this.detalleretencion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalleretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleRetencionLogicAdditional.checkDetalleRetencionToSaveAfter(this.detalleretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalleretencion.getIsDeleted()) {
				this.detalleretencion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleRetencionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-saveDetalleRetencionsWithConnection");connexion.begin();			
			
			DetalleRetencionLogicAdditional.checkDetalleRetencionToSaves(detalleretencions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleRetencions();
			
			Boolean validadoTodosDetalleRetencion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleRetencion detalleretencionLocal:detalleretencions) {		
				if(detalleretencionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleRetencionLogicAdditional.updateDetalleRetencionToSave(detalleretencionLocal,this.arrDatoGeneral);
	        	
				DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleretencionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleRetencion(detalleretencionLocal)) {
					DetalleRetencionDataAccess.save(detalleretencionLocal, connexion);				
				} else {
					validadoTodosDetalleRetencion=false;
				}
			}
			
			if(!validadoTodosDetalleRetencion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleRetencionLogicAdditional.checkDetalleRetencionToSavesAfter(detalleretencions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleRetencions();
			
			connexion.commit();		
			
			this.quitarDetalleRetencionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleRetencions()throws Exception {				
		 try {	
			DetalleRetencionLogicAdditional.checkDetalleRetencionToSaves(detalleretencions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleRetencion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleRetencion detalleretencionLocal:detalleretencions) {				
				if(detalleretencionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleRetencionLogicAdditional.updateDetalleRetencionToSave(detalleretencionLocal,this.arrDatoGeneral);
	        	
				DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleretencionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleRetencion(detalleretencionLocal)) {				
					DetalleRetencionDataAccess.save(detalleretencionLocal, connexion);				
				} else {
					validadoTodosDetalleRetencion=false;
				}
			}
			
			if(!validadoTodosDetalleRetencion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleRetencionLogicAdditional.checkDetalleRetencionToSavesAfter(detalleretencions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleRetencionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleRetencionParameterReturnGeneral procesarAccionDetalleRetencions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleRetencion> detalleretencions,DetalleRetencionParameterReturnGeneral detalleretencionParameterGeneral)throws Exception {
		 try {	
			DetalleRetencionParameterReturnGeneral detalleretencionReturnGeneral=new DetalleRetencionParameterReturnGeneral();
	
			DetalleRetencionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleretencions,detalleretencionParameterGeneral,detalleretencionReturnGeneral);
			
			return detalleretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleRetencionParameterReturnGeneral procesarAccionDetalleRetencionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleRetencion> detalleretencions,DetalleRetencionParameterReturnGeneral detalleretencionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-procesarAccionDetalleRetencionsWithConnection");connexion.begin();			
			
			DetalleRetencionParameterReturnGeneral detalleretencionReturnGeneral=new DetalleRetencionParameterReturnGeneral();
	
			DetalleRetencionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleretencions,detalleretencionParameterGeneral,detalleretencionReturnGeneral);
			
			this.connexion.commit();
			
			return detalleretencionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleRetencionParameterReturnGeneral procesarEventosDetalleRetencions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleRetencion> detalleretencions,DetalleRetencion detalleretencion,DetalleRetencionParameterReturnGeneral detalleretencionParameterGeneral,Boolean isEsNuevoDetalleRetencion,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleRetencionParameterReturnGeneral detalleretencionReturnGeneral=new DetalleRetencionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleretencionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleRetencionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleretencions,detalleretencion,detalleretencionParameterGeneral,detalleretencionReturnGeneral,isEsNuevoDetalleRetencion,clases);
			
			return detalleretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleRetencionParameterReturnGeneral procesarEventosDetalleRetencionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleRetencion> detalleretencions,DetalleRetencion detalleretencion,DetalleRetencionParameterReturnGeneral detalleretencionParameterGeneral,Boolean isEsNuevoDetalleRetencion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-procesarEventosDetalleRetencionsWithConnection");connexion.begin();			
			
			DetalleRetencionParameterReturnGeneral detalleretencionReturnGeneral=new DetalleRetencionParameterReturnGeneral();
	
			detalleretencionReturnGeneral.setDetalleRetencion(detalleretencion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleretencionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleRetencionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleretencions,detalleretencion,detalleretencionParameterGeneral,detalleretencionReturnGeneral,isEsNuevoDetalleRetencion,clases);
			
			this.connexion.commit();
			
			return detalleretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleRetencionParameterReturnGeneral procesarImportacionDetalleRetencionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleRetencionParameterReturnGeneral detalleretencionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-procesarImportacionDetalleRetencionsWithConnection");connexion.begin();			
			
			DetalleRetencionParameterReturnGeneral detalleretencionReturnGeneral=new DetalleRetencionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalleretencions=new ArrayList<DetalleRetencion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalleretencion=new DetalleRetencion();
				
				
				if(conColumnasBase) {this.detalleretencion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalleretencion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalleretencion.setdescripcion(arrColumnas[iColumn++]);
				this.detalleretencion.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleretencion.setmonto_minimo(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.detalleretencions.add(this.detalleretencion);
			}
			
			this.saveDetalleRetencions();
			
			this.connexion.commit();
			
			detalleretencionReturnGeneral.setConRetornoEstaProcesado(true);
			detalleretencionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalleretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleRetencionsEliminados() throws Exception {				
		
		List<DetalleRetencion> detalleretencionsAux= new ArrayList<DetalleRetencion>();
		
		for(DetalleRetencion detalleretencion:detalleretencions) {
			if(!detalleretencion.getIsDeleted()) {
				detalleretencionsAux.add(detalleretencion);
			}
		}
		
		detalleretencions=detalleretencionsAux;
	}
	
	public void quitarDetalleRetencionsNulos() throws Exception {				
		
		List<DetalleRetencion> detalleretencionsAux= new ArrayList<DetalleRetencion>();
		
		for(DetalleRetencion detalleretencion : this.detalleretencions) {
			if(detalleretencion==null) {
				detalleretencionsAux.add(detalleretencion);
			}
		}
		
		//this.detalleretencions=detalleretencionsAux;
		
		this.detalleretencions.removeAll(detalleretencionsAux);
	}
	
	public void getSetVersionRowDetalleRetencionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalleretencion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalleretencion.getIsDeleted() || (detalleretencion.getIsChanged()&&!detalleretencion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalleretencionDataAccess.getSetVersionRowDetalleRetencion(connexion,detalleretencion.getId());
				
				if(!detalleretencion.getVersionRow().equals(timestamp)) {	
					detalleretencion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalleretencion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleRetencion()throws Exception {	
		
		if(detalleretencion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalleretencion.getIsDeleted() || (detalleretencion.getIsChanged()&&!detalleretencion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalleretencionDataAccess.getSetVersionRowDetalleRetencion(connexion,detalleretencion.getId());
			
			try {							
				if(!detalleretencion.getVersionRow().equals(timestamp)) {	
					detalleretencion.setVersionRow(timestamp);
				}
				
				detalleretencion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleRetencionsWithConnection()throws Exception {	
		if(detalleretencions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleRetencion detalleretencionAux:detalleretencions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalleretencionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleretencionAux.getIsDeleted() || (detalleretencionAux.getIsChanged()&&!detalleretencionAux.getIsNew())) {
						
						timestamp=detalleretencionDataAccess.getSetVersionRowDetalleRetencion(connexion,detalleretencionAux.getId());
						
						if(!detalleretencion.getVersionRow().equals(timestamp)) {	
							detalleretencionAux.setVersionRow(timestamp);
						}
								
						detalleretencionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleRetencions()throws Exception {	
		if(detalleretencions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleRetencion detalleretencionAux:detalleretencions) {
					if(detalleretencionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleretencionAux.getIsDeleted() || (detalleretencionAux.getIsChanged()&&!detalleretencionAux.getIsNew())) {
						
						timestamp=detalleretencionDataAccess.getSetVersionRowDetalleRetencion(connexion,detalleretencionAux.getId());
						
						if(!detalleretencionAux.getVersionRow().equals(timestamp)) {	
							detalleretencionAux.setVersionRow(timestamp);
						}
						
													
						detalleretencionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleRetencionParameterReturnGeneral cargarCombosLoteForeignKeyDetalleRetencionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpresaDestino,String finalQueryGlobalCuentaContable,String finalQueryGlobalCuentaContableCredito) throws Exception {
		DetalleRetencionParameterReturnGeneral  detalleretencionReturnGeneral =new DetalleRetencionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleRetencionWithConnection");connexion.begin();
			
			detalleretencionReturnGeneral =new DetalleRetencionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleretencionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empresa> empresadestinosForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresadestinoLogic=new EmpresaLogic();
			empresadestinoLogic.setConnexion(this.connexion);
			empresadestinoLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresaDestino.equals("NONE")) {
				empresadestinoLogic.getTodosEmpresas(finalQueryGlobalEmpresaDestino,new Pagination());
				empresadestinosForeignKey=empresadestinoLogic.getEmpresas();
			}

			detalleretencionReturnGeneral.setempresadestinosForeignKey(empresadestinosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			detalleretencionReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			detalleretencionReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalleretencionReturnGeneral;
	}
	
	public DetalleRetencionParameterReturnGeneral cargarCombosLoteForeignKeyDetalleRetencion(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpresaDestino,String finalQueryGlobalCuentaContable,String finalQueryGlobalCuentaContableCredito) throws Exception {
		DetalleRetencionParameterReturnGeneral  detalleretencionReturnGeneral =new DetalleRetencionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalleretencionReturnGeneral =new DetalleRetencionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleretencionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empresa> empresadestinosForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresadestinoLogic=new EmpresaLogic();
			empresadestinoLogic.setConnexion(this.connexion);
			empresadestinoLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresaDestino.equals("NONE")) {
				empresadestinoLogic.getTodosEmpresas(finalQueryGlobalEmpresaDestino,new Pagination());
				empresadestinosForeignKey=empresadestinoLogic.getEmpresas();
			}

			detalleretencionReturnGeneral.setempresadestinosForeignKey(empresadestinosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			detalleretencionReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			detalleretencionReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalleretencionReturnGeneral;
	}
	
	
	public void deepLoad(DetalleRetencion detalleretencion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleRetencionLogicAdditional.updateDetalleRetencionToGet(detalleretencion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleretencion.setEmpresa(detalleretencionDataAccess.getEmpresa(connexion,detalleretencion));
		detalleretencion.setEmpresaDestino(detalleretencionDataAccess.getEmpresaDestino(connexion,detalleretencion));
		detalleretencion.setCuentaContable(detalleretencionDataAccess.getCuentaContable(connexion,detalleretencion));
		detalleretencion.setCuentaContableCredito(detalleretencionDataAccess.getCuentaContableCredito(connexion,detalleretencion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleretencion.setEmpresa(detalleretencionDataAccess.getEmpresa(connexion,detalleretencion));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detalleretencion.setEmpresaDestino(detalleretencionDataAccess.getEmpresaDestino(connexion,detalleretencion));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detalleretencion.setCuentaContable(detalleretencionDataAccess.getCuentaContable(connexion,detalleretencion));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detalleretencion.setCuentaContableCredito(detalleretencionDataAccess.getCuentaContableCredito(connexion,detalleretencion));
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
			detalleretencion.setEmpresa(detalleretencionDataAccess.getEmpresa(connexion,detalleretencion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleretencion.setEmpresaDestino(detalleretencionDataAccess.getEmpresaDestino(connexion,detalleretencion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleretencion.setCuentaContable(detalleretencionDataAccess.getCuentaContable(connexion,detalleretencion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleretencion.setCuentaContableCredito(detalleretencionDataAccess.getCuentaContableCredito(connexion,detalleretencion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleretencion.setEmpresa(detalleretencionDataAccess.getEmpresa(connexion,detalleretencion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleretencion.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalleretencion.setEmpresaDestino(detalleretencionDataAccess.getEmpresaDestino(connexion,detalleretencion));
		EmpresaLogic empresadestinoLogic= new EmpresaLogic(connexion);
		empresadestinoLogic.deepLoad(detalleretencion.getEmpresaDestino(),isDeep,deepLoadType,clases);
				
		detalleretencion.setCuentaContable(detalleretencionDataAccess.getCuentaContable(connexion,detalleretencion));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(detalleretencion.getCuentaContable(),isDeep,deepLoadType,clases);
				
		detalleretencion.setCuentaContableCredito(detalleretencionDataAccess.getCuentaContableCredito(connexion,detalleretencion));
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(detalleretencion.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleretencion.setEmpresa(detalleretencionDataAccess.getEmpresa(connexion,detalleretencion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalleretencion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detalleretencion.setEmpresaDestino(detalleretencionDataAccess.getEmpresaDestino(connexion,detalleretencion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalleretencion.getEmpresaDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detalleretencion.setCuentaContable(detalleretencionDataAccess.getCuentaContable(connexion,detalleretencion));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(detalleretencion.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detalleretencion.setCuentaContableCredito(detalleretencionDataAccess.getCuentaContableCredito(connexion,detalleretencion));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(detalleretencion.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
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
			detalleretencion.setEmpresa(detalleretencionDataAccess.getEmpresa(connexion,detalleretencion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalleretencion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleretencion.setEmpresaDestino(detalleretencionDataAccess.getEmpresaDestino(connexion,detalleretencion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalleretencion.getEmpresaDestino(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleretencion.setCuentaContable(detalleretencionDataAccess.getCuentaContable(connexion,detalleretencion));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(detalleretencion.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleretencion.setCuentaContableCredito(detalleretencionDataAccess.getCuentaContableCredito(connexion,detalleretencion));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(detalleretencion.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleRetencion detalleretencion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleRetencionLogicAdditional.updateDetalleRetencionToSave(detalleretencion,this.arrDatoGeneral);
			
DetalleRetencionDataAccess.save(detalleretencion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleretencion.getEmpresa(),connexion);

		EmpresaDataAccess.save(detalleretencion.getEmpresaDestino(),connexion);

		CuentaContableDataAccess.save(detalleretencion.getCuentaContable(),connexion);

		CuentaContableDataAccess.save(detalleretencion.getCuentaContableCredito(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleretencion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleretencion.getEmpresaDestino(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detalleretencion.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detalleretencion.getCuentaContableCredito(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleretencion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleretencion.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(detalleretencion.getEmpresaDestino(),connexion);
		EmpresaLogic empresadestinoLogic= new EmpresaLogic(connexion);
		empresadestinoLogic.deepLoad(detalleretencion.getEmpresaDestino(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(detalleretencion.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(detalleretencion.getCuentaContable(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(detalleretencion.getCuentaContableCredito(),connexion);
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(detalleretencion.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleretencion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalleretencion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleretencion.getEmpresaDestino(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalleretencion.getEmpresaDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detalleretencion.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(detalleretencion.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detalleretencion.getCuentaContableCredito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(detalleretencion.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleRetencion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalleretencion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(detalleretencion);
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
			this.deepLoad(this.detalleretencion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleRetencion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalleretencions!=null) {
				for(DetalleRetencion detalleretencion:detalleretencions) {
					this.deepLoad(detalleretencion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(detalleretencions);
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
			if(detalleretencions!=null) {
				for(DetalleRetencion detalleretencion:detalleretencions) {
					this.deepLoad(detalleretencion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(detalleretencions);
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
			this.getNewConnexionToDeep(DetalleRetencion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalleretencion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleRetencion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalleretencions!=null) {
				for(DetalleRetencion detalleretencion:detalleretencions) {
					this.deepSave(detalleretencion,isDeep,deepLoadType,clases);
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
			if(detalleretencions!=null) {
				for(DetalleRetencion detalleretencion:detalleretencions) {
					this.deepSave(detalleretencion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleRetencionsFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,DetalleRetencionConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleretencions=detalleretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRetencionsFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,DetalleRetencionConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleretencions=detalleretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRetencionsFK_IdCuentaContableCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,DetalleRetencionConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleretencions=detalleretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRetencionsFK_IdCuentaContableCredito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,DetalleRetencionConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleretencions=detalleretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRetencionsFK_IdDetalleRetencionWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa_destino)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresaDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresaDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa_destino,DetalleRetencionConstantesFunciones.IDEMPRESADESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresaDestino);

			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleretencions=detalleretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRetencionsFK_IdDetalleRetencion(String sFinalQuery,Pagination pagination,Long id_empresa_destino)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresaDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresaDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa_destino,DetalleRetencionConstantesFunciones.IDEMPRESADESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresaDestino);

			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleretencions=detalleretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRetencionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleRetencionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleretencions=detalleretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRetencionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleRetencionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleretencions=detalleretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRetencionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRetencion(this.detalleretencions);
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
			if(DetalleRetencionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleRetencionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleRetencion detalleretencion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleRetencionConstantesFunciones.ISCONAUDITORIA) {
				if(detalleretencion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleRetencionDataAccess.TABLENAME, detalleretencion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleRetencionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleRetencionLogic.registrarAuditoriaDetallesDetalleRetencion(connexion,detalleretencion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalleretencion.getIsDeleted()) {
					/*if(!detalleretencion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleRetencionDataAccess.TABLENAME, detalleretencion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleRetencionLogic.registrarAuditoriaDetallesDetalleRetencion(connexion,detalleretencion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleRetencionDataAccess.TABLENAME, detalleretencion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalleretencion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleRetencionDataAccess.TABLENAME, detalleretencion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleRetencionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleRetencionLogic.registrarAuditoriaDetallesDetalleRetencion(connexion,detalleretencion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleRetencion(Connexion connexion,DetalleRetencion detalleretencion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalleretencion.getIsNew()||!detalleretencion.getid_empresa().equals(detalleretencion.getDetalleRetencionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleretencion.getDetalleRetencionOriginal().getid_empresa()!=null)
				{
					strValorActual=detalleretencion.getDetalleRetencionOriginal().getid_empresa().toString();
				}
				if(detalleretencion.getid_empresa()!=null)
				{
					strValorNuevo=detalleretencion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRetencionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleretencion.getIsNew()||!detalleretencion.getid_empresa_destino().equals(detalleretencion.getDetalleRetencionOriginal().getid_empresa_destino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleretencion.getDetalleRetencionOriginal().getid_empresa_destino()!=null)
				{
					strValorActual=detalleretencion.getDetalleRetencionOriginal().getid_empresa_destino().toString();
				}
				if(detalleretencion.getid_empresa_destino()!=null)
				{
					strValorNuevo=detalleretencion.getid_empresa_destino().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRetencionConstantesFunciones.IDEMPRESADESTINO,strValorActual,strValorNuevo);
			}	
			
			if(detalleretencion.getIsNew()||!detalleretencion.getid_cuenta_contable().equals(detalleretencion.getDetalleRetencionOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleretencion.getDetalleRetencionOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=detalleretencion.getDetalleRetencionOriginal().getid_cuenta_contable().toString();
				}
				if(detalleretencion.getid_cuenta_contable()!=null)
				{
					strValorNuevo=detalleretencion.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRetencionConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(detalleretencion.getIsNew()||!detalleretencion.getid_cuenta_contable_credito().equals(detalleretencion.getDetalleRetencionOriginal().getid_cuenta_contable_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleretencion.getDetalleRetencionOriginal().getid_cuenta_contable_credito()!=null)
				{
					strValorActual=detalleretencion.getDetalleRetencionOriginal().getid_cuenta_contable_credito().toString();
				}
				if(detalleretencion.getid_cuenta_contable_credito()!=null)
				{
					strValorNuevo=detalleretencion.getid_cuenta_contable_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRetencionConstantesFunciones.IDCUENTACONTABLECREDITO,strValorActual,strValorNuevo);
			}	
			
			if(detalleretencion.getIsNew()||!detalleretencion.getdescripcion().equals(detalleretencion.getDetalleRetencionOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleretencion.getDetalleRetencionOriginal().getdescripcion()!=null)
				{
					strValorActual=detalleretencion.getDetalleRetencionOriginal().getdescripcion();
				}
				if(detalleretencion.getdescripcion()!=null)
				{
					strValorNuevo=detalleretencion.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRetencionConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(detalleretencion.getIsNew()||!detalleretencion.getporcentaje().equals(detalleretencion.getDetalleRetencionOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleretencion.getDetalleRetencionOriginal().getporcentaje()!=null)
				{
					strValorActual=detalleretencion.getDetalleRetencionOriginal().getporcentaje().toString();
				}
				if(detalleretencion.getporcentaje()!=null)
				{
					strValorNuevo=detalleretencion.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRetencionConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(detalleretencion.getIsNew()||!detalleretencion.getmonto_minimo().equals(detalleretencion.getDetalleRetencionOriginal().getmonto_minimo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleretencion.getDetalleRetencionOriginal().getmonto_minimo()!=null)
				{
					strValorActual=detalleretencion.getDetalleRetencionOriginal().getmonto_minimo().toString();
				}
				if(detalleretencion.getmonto_minimo()!=null)
				{
					strValorNuevo=detalleretencion.getmonto_minimo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRetencionConstantesFunciones.MONTOMINIMO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleRetencionRelacionesWithConnection(DetalleRetencion detalleretencion) throws Exception {

		if(!detalleretencion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleRetencionRelacionesBase(detalleretencion,true);
		}
	}

	public void saveDetalleRetencionRelaciones(DetalleRetencion detalleretencion)throws Exception {

		if(!detalleretencion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleRetencionRelacionesBase(detalleretencion,false);
		}
	}

	public void saveDetalleRetencionRelacionesBase(DetalleRetencion detalleretencion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleRetencion-saveRelacionesWithConnection");}
	

			this.setDetalleRetencion(detalleretencion);

			if(DetalleRetencionLogicAdditional.validarSaveRelaciones(detalleretencion,this)) {

				DetalleRetencionLogicAdditional.updateRelacionesToSave(detalleretencion,this);

				if((detalleretencion.getIsNew()||detalleretencion.getIsChanged())&&!detalleretencion.getIsDeleted()) {
					this.saveDetalleRetencion();
					this.saveDetalleRetencionRelacionesDetalles();

				} else if(detalleretencion.getIsDeleted()) {
					this.saveDetalleRetencionRelacionesDetalles();
					this.saveDetalleRetencion();
				}

				DetalleRetencionLogicAdditional.updateRelacionesToSaveAfter(detalleretencion,this);

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
	
	
	private void saveDetalleRetencionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleRetencionConstantesFunciones.getClassesForeignKeysOfDetalleRetencion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleRetencionConstantesFunciones.getClassesRelationshipsOfDetalleRetencion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

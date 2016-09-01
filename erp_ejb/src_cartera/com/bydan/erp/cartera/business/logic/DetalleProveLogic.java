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
package com.bydan.erp.cartera.business.logic;

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
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.cartera.util.DetalleProveConstantesFunciones;
import com.bydan.erp.cartera.util.DetalleProveParameterReturnGeneral;
//import com.bydan.erp.cartera.util.DetalleProveParameterGeneral;
import com.bydan.erp.cartera.business.entity.DetalleProve;
import com.bydan.erp.cartera.business.logic.DetalleProveLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetalleProveLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleProveLogic.class);
	
	protected DetalleProveDataAccess detalleproveDataAccess; 	
	protected DetalleProve detalleprove;
	protected List<DetalleProve> detalleproves;
	protected Object detalleproveObject;	
	protected List<Object> detalleprovesObject;
	
	public static ClassValidator<DetalleProve> detalleproveValidator = new ClassValidator<DetalleProve>(DetalleProve.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleProveLogicAdditional detalleproveLogicAdditional=null;
	
	public DetalleProveLogicAdditional getDetalleProveLogicAdditional() {
		return this.detalleproveLogicAdditional;
	}
	
	public void setDetalleProveLogicAdditional(DetalleProveLogicAdditional detalleproveLogicAdditional) {
		try {
			this.detalleproveLogicAdditional=detalleproveLogicAdditional;
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
	
	
	
	
	public  DetalleProveLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalleproveDataAccess = new DetalleProveDataAccess();
			
			this.detalleproves= new ArrayList<DetalleProve>();
			this.detalleprove= new DetalleProve();
			
			this.detalleproveObject=new Object();
			this.detalleprovesObject=new ArrayList<Object>();
				
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
			
			this.detalleproveDataAccess.setConnexionType(this.connexionType);
			this.detalleproveDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleProveLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalleproveDataAccess = new DetalleProveDataAccess();
			this.detalleproves= new ArrayList<DetalleProve>();
			this.detalleprove= new DetalleProve();
			this.detalleproveObject=new Object();
			this.detalleprovesObject=new ArrayList<Object>();
			
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
			
			this.detalleproveDataAccess.setConnexionType(this.connexionType);
			this.detalleproveDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleProve getDetalleProve() throws Exception {	
		DetalleProveLogicAdditional.checkDetalleProveToGet(detalleprove,this.datosCliente,this.arrDatoGeneral);
		DetalleProveLogicAdditional.updateDetalleProveToGet(detalleprove,this.arrDatoGeneral);
		
		return detalleprove;
	}
		
	public void setDetalleProve(DetalleProve newDetalleProve) {
		this.detalleprove = newDetalleProve;
	}
	
	public DetalleProveDataAccess getDetalleProveDataAccess() {
		return detalleproveDataAccess;
	}
	
	public void setDetalleProveDataAccess(DetalleProveDataAccess newdetalleproveDataAccess) {
		this.detalleproveDataAccess = newdetalleproveDataAccess;
	}
	
	public List<DetalleProve> getDetalleProves() throws Exception {		
		this.quitarDetalleProvesNulos();
		
		DetalleProveLogicAdditional.checkDetalleProveToGets(detalleproves,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleProve detalleproveLocal: detalleproves ) {
			DetalleProveLogicAdditional.updateDetalleProveToGet(detalleproveLocal,this.arrDatoGeneral);
		}
		
		return detalleproves;
	}
	
	public void setDetalleProves(List<DetalleProve> newDetalleProves) {
		this.detalleproves = newDetalleProves;
	}
	
	public Object getDetalleProveObject() {	
		this.detalleproveObject=this.detalleproveDataAccess.getEntityObject();
		return this.detalleproveObject;
	}
		
	public void setDetalleProveObject(Object newDetalleProveObject) {
		this.detalleproveObject = newDetalleProveObject;
	}
	
	public List<Object> getDetalleProvesObject() {		
		this.detalleprovesObject=this.detalleproveDataAccess.getEntitiesObject();
		return this.detalleprovesObject;
	}
		
	public void setDetalleProvesObject(List<Object> newDetalleProvesObject) {
		this.detalleprovesObject = newDetalleProvesObject;
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
		
		if(this.detalleproveDataAccess!=null) {
			this.detalleproveDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalleproveDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalleproveDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalleprove = new  DetalleProve();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleprove=detalleproveDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleprove);
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
		detalleprove = new  DetalleProve();
		  		  
        try {
			
			detalleprove=detalleproveDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleprove);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalleprove = new  DetalleProve();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleprove=detalleproveDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleprove);
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
		detalleprove = new  DetalleProve();
		  		  
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
		detalleprove = new  DetalleProve();
		  		  
        try {
			
			detalleprove=detalleproveDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleprove);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalleprove = new  DetalleProve();
		  		  
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
		detalleprove = new  DetalleProve();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalleproveDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleprove = new  DetalleProve();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalleproveDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleprove = new  DetalleProve();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalleproveDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleprove = new  DetalleProve();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalleproveDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleprove = new  DetalleProve();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalleproveDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleprove = new  DetalleProve();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalleproveDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleproves = new  ArrayList<DetalleProve>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproves=detalleproveDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleProve(detalleproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
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
		detalleproves = new  ArrayList<DetalleProve>();
		  		  
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
		detalleproves = new  ArrayList<DetalleProve>();
		  		  
        try {			
			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproves=detalleproveDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleProve(detalleproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalleproves = new  ArrayList<DetalleProve>();
		  		  
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
		detalleproves = new  ArrayList<DetalleProve>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproves=detalleproveDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleProve(detalleproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
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
		detalleproves = new  ArrayList<DetalleProve>();
		  		  
        try {
			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproves=detalleproveDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleProve(detalleproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
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
		detalleproves = new  ArrayList<DetalleProve>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproves=detalleproveDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleProve(detalleproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
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
		detalleproves = new  ArrayList<DetalleProve>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproves=detalleproveDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleProve(detalleproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalleprove = new  DetalleProve();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleprove=detalleproveDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleProve(detalleprove);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleprove);
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
		detalleprove = new  DetalleProve();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleprove=detalleproveDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleProve(detalleprove);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleprove);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleproves = new  ArrayList<DetalleProve>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproves=detalleproveDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleProve(detalleproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
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
		detalleproves = new  ArrayList<DetalleProve>();
		  		  
        try {
			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproves=detalleproveDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleProve(detalleproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleProvesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalleproves = new  ArrayList<DetalleProve>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getTodosDetalleProvesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleProve(detalleproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
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
	
	public  void  getTodosDetalleProves(String sFinalQuery,Pagination pagination)throws Exception {
		detalleproves = new  ArrayList<DetalleProve>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleProve(detalleproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleProve(DetalleProve detalleprove) throws Exception {
		Boolean estaValidado=false;
		
		if(detalleprove.getIsNew() || detalleprove.getIsChanged()) { 
			this.invalidValues = detalleproveValidator.getInvalidValues(detalleprove);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalleprove);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleProve(List<DetalleProve> DetalleProves) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleProve detalleproveLocal:detalleproves) {				
			estaValidadoObjeto=this.validarGuardarDetalleProve(detalleproveLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleProve(List<DetalleProve> DetalleProves) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleProve(detalleproves)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleProve(DetalleProve DetalleProve) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleProve(detalleprove)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleProve detalleprove) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalleprove.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleProveConstantesFunciones.getDetalleProveLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalleprove","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleProveConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleProveConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleProveWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-saveDetalleProveWithConnection");connexion.begin();			
			
			DetalleProveLogicAdditional.checkDetalleProveToSave(this.detalleprove,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleProveLogicAdditional.updateDetalleProveToSave(this.detalleprove,this.arrDatoGeneral);
			
			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleprove,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleProve();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleProve(this.detalleprove)) {
				DetalleProveDataAccess.save(this.detalleprove, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalleprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleProveLogicAdditional.checkDetalleProveToSaveAfter(this.detalleprove,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleProve();
			
			connexion.commit();			
			
			if(this.detalleprove.getIsDeleted()) {
				this.detalleprove=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleProve()throws Exception {	
		try {	
			
			DetalleProveLogicAdditional.checkDetalleProveToSave(this.detalleprove,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleProveLogicAdditional.updateDetalleProveToSave(this.detalleprove,this.arrDatoGeneral);
			
			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleprove,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleProve(this.detalleprove)) {			
				DetalleProveDataAccess.save(this.detalleprove, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalleprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleProveLogicAdditional.checkDetalleProveToSaveAfter(this.detalleprove,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalleprove.getIsDeleted()) {
				this.detalleprove=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleProvesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-saveDetalleProvesWithConnection");connexion.begin();			
			
			DetalleProveLogicAdditional.checkDetalleProveToSaves(detalleproves,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleProves();
			
			Boolean validadoTodosDetalleProve=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleProve detalleproveLocal:detalleproves) {		
				if(detalleproveLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleProveLogicAdditional.updateDetalleProveToSave(detalleproveLocal,this.arrDatoGeneral);
	        	
				DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleproveLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleProve(detalleproveLocal)) {
					DetalleProveDataAccess.save(detalleproveLocal, connexion);				
				} else {
					validadoTodosDetalleProve=false;
				}
			}
			
			if(!validadoTodosDetalleProve) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleProveLogicAdditional.checkDetalleProveToSavesAfter(detalleproves,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleProves();
			
			connexion.commit();		
			
			this.quitarDetalleProvesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleProves()throws Exception {				
		 try {	
			DetalleProveLogicAdditional.checkDetalleProveToSaves(detalleproves,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleProve=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleProve detalleproveLocal:detalleproves) {				
				if(detalleproveLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleProveLogicAdditional.updateDetalleProveToSave(detalleproveLocal,this.arrDatoGeneral);
	        	
				DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleproveLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleProve(detalleproveLocal)) {				
					DetalleProveDataAccess.save(detalleproveLocal, connexion);				
				} else {
					validadoTodosDetalleProve=false;
				}
			}
			
			if(!validadoTodosDetalleProve) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleProveLogicAdditional.checkDetalleProveToSavesAfter(detalleproves,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleProvesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleProveParameterReturnGeneral procesarAccionDetalleProves(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleProve> detalleproves,DetalleProveParameterReturnGeneral detalleproveParameterGeneral)throws Exception {
		 try {	
			DetalleProveParameterReturnGeneral detalleproveReturnGeneral=new DetalleProveParameterReturnGeneral();
	
			DetalleProveLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleproves,detalleproveParameterGeneral,detalleproveReturnGeneral);
			
			return detalleproveReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleProveParameterReturnGeneral procesarAccionDetalleProvesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleProve> detalleproves,DetalleProveParameterReturnGeneral detalleproveParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-procesarAccionDetalleProvesWithConnection");connexion.begin();			
			
			DetalleProveParameterReturnGeneral detalleproveReturnGeneral=new DetalleProveParameterReturnGeneral();
	
			DetalleProveLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleproves,detalleproveParameterGeneral,detalleproveReturnGeneral);
			
			this.connexion.commit();
			
			return detalleproveReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleProveParameterReturnGeneral procesarEventosDetalleProves(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleProve> detalleproves,DetalleProve detalleprove,DetalleProveParameterReturnGeneral detalleproveParameterGeneral,Boolean isEsNuevoDetalleProve,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleProveParameterReturnGeneral detalleproveReturnGeneral=new DetalleProveParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleproveReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleProveLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleproves,detalleprove,detalleproveParameterGeneral,detalleproveReturnGeneral,isEsNuevoDetalleProve,clases);
			
			return detalleproveReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleProveParameterReturnGeneral procesarEventosDetalleProvesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleProve> detalleproves,DetalleProve detalleprove,DetalleProveParameterReturnGeneral detalleproveParameterGeneral,Boolean isEsNuevoDetalleProve,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-procesarEventosDetalleProvesWithConnection");connexion.begin();			
			
			DetalleProveParameterReturnGeneral detalleproveReturnGeneral=new DetalleProveParameterReturnGeneral();
	
			detalleproveReturnGeneral.setDetalleProve(detalleprove);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleproveReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleProveLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleproves,detalleprove,detalleproveParameterGeneral,detalleproveReturnGeneral,isEsNuevoDetalleProve,clases);
			
			this.connexion.commit();
			
			return detalleproveReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleProveParameterReturnGeneral procesarImportacionDetalleProvesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleProveParameterReturnGeneral detalleproveParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-procesarImportacionDetalleProvesWithConnection");connexion.begin();			
			
			DetalleProveParameterReturnGeneral detalleproveReturnGeneral=new DetalleProveParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalleproves=new ArrayList<DetalleProve>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalleprove=new DetalleProve();
				
				
				if(conColumnasBase) {this.detalleprove.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalleprove.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalleprove.setfecha_venta(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detalleprove.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detalleprove.setfecha_pago(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detalleprove.setfecha_vencimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detalleprove.setmonto_mone_local(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleprove.setmonto_mone_extra(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleprove.setnumero_comprobante(arrColumnas[iColumn++]);
				this.detalleprove.setnumero_factura(arrColumnas[iColumn++]);
				this.detalleprove.setdebito_mone_local(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleprove.setcredito_mone_local(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleprove.setdebito_mone_extra(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleprove.setcredito_mone_extra(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleprove.setdescripcion(arrColumnas[iColumn++]);
				
				this.detalleproves.add(this.detalleprove);
			}
			
			this.saveDetalleProves();
			
			this.connexion.commit();
			
			detalleproveReturnGeneral.setConRetornoEstaProcesado(true);
			detalleproveReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalleproveReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleProvesEliminados() throws Exception {				
		
		List<DetalleProve> detalleprovesAux= new ArrayList<DetalleProve>();
		
		for(DetalleProve detalleprove:detalleproves) {
			if(!detalleprove.getIsDeleted()) {
				detalleprovesAux.add(detalleprove);
			}
		}
		
		detalleproves=detalleprovesAux;
	}
	
	public void quitarDetalleProvesNulos() throws Exception {				
		
		List<DetalleProve> detalleprovesAux= new ArrayList<DetalleProve>();
		
		for(DetalleProve detalleprove : this.detalleproves) {
			if(detalleprove==null) {
				detalleprovesAux.add(detalleprove);
			}
		}
		
		//this.detalleproves=detalleprovesAux;
		
		this.detalleproves.removeAll(detalleprovesAux);
	}
	
	public void getSetVersionRowDetalleProveWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalleprove.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalleprove.getIsDeleted() || (detalleprove.getIsChanged()&&!detalleprove.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalleproveDataAccess.getSetVersionRowDetalleProve(connexion,detalleprove.getId());
				
				if(!detalleprove.getVersionRow().equals(timestamp)) {	
					detalleprove.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalleprove.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleProve()throws Exception {	
		
		if(detalleprove.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalleprove.getIsDeleted() || (detalleprove.getIsChanged()&&!detalleprove.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalleproveDataAccess.getSetVersionRowDetalleProve(connexion,detalleprove.getId());
			
			try {							
				if(!detalleprove.getVersionRow().equals(timestamp)) {	
					detalleprove.setVersionRow(timestamp);
				}
				
				detalleprove.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleProvesWithConnection()throws Exception {	
		if(detalleproves!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleProve detalleproveAux:detalleproves) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalleproveAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleproveAux.getIsDeleted() || (detalleproveAux.getIsChanged()&&!detalleproveAux.getIsNew())) {
						
						timestamp=detalleproveDataAccess.getSetVersionRowDetalleProve(connexion,detalleproveAux.getId());
						
						if(!detalleprove.getVersionRow().equals(timestamp)) {	
							detalleproveAux.setVersionRow(timestamp);
						}
								
						detalleproveAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleProves()throws Exception {	
		if(detalleproves!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleProve detalleproveAux:detalleproves) {
					if(detalleproveAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleproveAux.getIsDeleted() || (detalleproveAux.getIsChanged()&&!detalleproveAux.getIsNew())) {
						
						timestamp=detalleproveDataAccess.getSetVersionRowDetalleProve(connexion,detalleproveAux.getId());
						
						if(!detalleproveAux.getVersionRow().equals(timestamp)) {	
							detalleproveAux.setVersionRow(timestamp);
						}
						
													
						detalleproveAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleProveParameterReturnGeneral cargarCombosLoteForeignKeyDetalleProveWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalSucursalMovimiento,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalModulo,String finalQueryGlobalMoneda,String finalQueryGlobalCliente,String finalQueryGlobalTransaccion,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalAsientoContable,String finalQueryGlobalFactura,String finalQueryGlobalOrdenCompra,String finalQueryGlobalEstadoDetalleCliente,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		DetalleProveParameterReturnGeneral  detalleproveReturnGeneral =new DetalleProveParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleProveWithConnection");connexion.begin();
			
			detalleproveReturnGeneral =new DetalleProveParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleproveReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleproveReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Sucursal> sucursalmovimientosForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalmovimientoLogic=new SucursalLogic();
			sucursalmovimientoLogic.setConnexion(this.connexion);
			sucursalmovimientoLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursalMovimiento.equals("NONE")) {
				sucursalmovimientoLogic.getTodosSucursals(finalQueryGlobalSucursalMovimiento,new Pagination());
				sucursalmovimientosForeignKey=sucursalmovimientoLogic.getSucursals();
			}

			detalleproveReturnGeneral.setsucursalmovimientosForeignKey(sucursalmovimientosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleproveReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleproveReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			detalleproveReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			detalleproveReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			detalleproveReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			detalleproveReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			detalleproveReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			detalleproveReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			detalleproveReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<OrdenCompra> ordencomprasForeignKey=new ArrayList<OrdenCompra>();
			OrdenCompraLogic ordencompraLogic=new OrdenCompraLogic();
			ordencompraLogic.setConnexion(this.connexion);
			ordencompraLogic.getOrdenCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenCompra.equals("NONE")) {
				ordencompraLogic.getTodosOrdenCompras(finalQueryGlobalOrdenCompra,new Pagination());
				ordencomprasForeignKey=ordencompraLogic.getOrdenCompras();
			}

			detalleproveReturnGeneral.setordencomprasForeignKey(ordencomprasForeignKey);


			List<EstadoDetalleCliente> estadodetalleclientesForeignKey=new ArrayList<EstadoDetalleCliente>();
			EstadoDetalleClienteLogic estadodetalleclienteLogic=new EstadoDetalleClienteLogic();
			estadodetalleclienteLogic.setConnexion(this.connexion);
			estadodetalleclienteLogic.getEstadoDetalleClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetalleCliente.equals("NONE")) {
				estadodetalleclienteLogic.getTodosEstadoDetalleClientes(finalQueryGlobalEstadoDetalleCliente,new Pagination());
				estadodetalleclientesForeignKey=estadodetalleclienteLogic.getEstadoDetalleClientes();
			}

			detalleproveReturnGeneral.setestadodetalleclientesForeignKey(estadodetalleclientesForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detalleproveReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detalleproveReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalleproveReturnGeneral;
	}
	
	public DetalleProveParameterReturnGeneral cargarCombosLoteForeignKeyDetalleProve(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalSucursalMovimiento,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalModulo,String finalQueryGlobalMoneda,String finalQueryGlobalCliente,String finalQueryGlobalTransaccion,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalAsientoContable,String finalQueryGlobalFactura,String finalQueryGlobalOrdenCompra,String finalQueryGlobalEstadoDetalleCliente,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		DetalleProveParameterReturnGeneral  detalleproveReturnGeneral =new DetalleProveParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalleproveReturnGeneral =new DetalleProveParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleproveReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleproveReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Sucursal> sucursalmovimientosForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalmovimientoLogic=new SucursalLogic();
			sucursalmovimientoLogic.setConnexion(this.connexion);
			sucursalmovimientoLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursalMovimiento.equals("NONE")) {
				sucursalmovimientoLogic.getTodosSucursals(finalQueryGlobalSucursalMovimiento,new Pagination());
				sucursalmovimientosForeignKey=sucursalmovimientoLogic.getSucursals();
			}

			detalleproveReturnGeneral.setsucursalmovimientosForeignKey(sucursalmovimientosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleproveReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleproveReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			detalleproveReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			detalleproveReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			detalleproveReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			detalleproveReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			detalleproveReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			detalleproveReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			detalleproveReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<OrdenCompra> ordencomprasForeignKey=new ArrayList<OrdenCompra>();
			OrdenCompraLogic ordencompraLogic=new OrdenCompraLogic();
			ordencompraLogic.setConnexion(this.connexion);
			ordencompraLogic.getOrdenCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenCompra.equals("NONE")) {
				ordencompraLogic.getTodosOrdenCompras(finalQueryGlobalOrdenCompra,new Pagination());
				ordencomprasForeignKey=ordencompraLogic.getOrdenCompras();
			}

			detalleproveReturnGeneral.setordencomprasForeignKey(ordencomprasForeignKey);


			List<EstadoDetalleCliente> estadodetalleclientesForeignKey=new ArrayList<EstadoDetalleCliente>();
			EstadoDetalleClienteLogic estadodetalleclienteLogic=new EstadoDetalleClienteLogic();
			estadodetalleclienteLogic.setConnexion(this.connexion);
			estadodetalleclienteLogic.getEstadoDetalleClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetalleCliente.equals("NONE")) {
				estadodetalleclienteLogic.getTodosEstadoDetalleClientes(finalQueryGlobalEstadoDetalleCliente,new Pagination());
				estadodetalleclientesForeignKey=estadodetalleclienteLogic.getEstadoDetalleClientes();
			}

			detalleproveReturnGeneral.setestadodetalleclientesForeignKey(estadodetalleclientesForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detalleproveReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detalleproveReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalleproveReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyDetalleProveWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PagoAutoLogic pagoautoLogic=new PagoAutoLogic();
			AutoriPagoLogic autoripagoLogic=new AutoriPagoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyDetalleProveWithConnection");connexion.begin();
			
			
			classes.add(new Classe(PagoAuto.class));
			classes.add(new Classe(AutoriPago.class));
											
			

			pagoautoLogic.setConnexion(this.getConnexion());
			pagoautoLogic.setDatosCliente(this.datosCliente);
			pagoautoLogic.setIsConRefrescarForeignKeys(true);

			autoripagoLogic.setConnexion(this.getConnexion());
			autoripagoLogic.setDatosCliente(this.datosCliente);
			autoripagoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(DetalleProve detalleprove:this.detalleproves) {
				

				classes=new ArrayList<Classe>();
				classes=PagoAutoConstantesFunciones.getClassesForeignKeysOfPagoAuto(new ArrayList<Classe>(),DeepLoadType.NONE);

				pagoautoLogic.setPagoAutos(detalleprove.pagoautos);
				pagoautoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=AutoriPagoConstantesFunciones.getClassesForeignKeysOfAutoriPago(new ArrayList<Classe>(),DeepLoadType.NONE);

				autoripagoLogic.setAutoriPagos(detalleprove.autoripagos);
				autoripagoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(DetalleProve detalleprove,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleProveLogicAdditional.updateDetalleProveToGet(detalleprove,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleprove.setEmpresa(detalleproveDataAccess.getEmpresa(connexion,detalleprove));
		detalleprove.setSucursal(detalleproveDataAccess.getSucursal(connexion,detalleprove));
		detalleprove.setSucursalMovimiento(detalleproveDataAccess.getSucursalMovimiento(connexion,detalleprove));
		detalleprove.setEjercicio(detalleproveDataAccess.getEjercicio(connexion,detalleprove));
		detalleprove.setPeriodo(detalleproveDataAccess.getPeriodo(connexion,detalleprove));
		detalleprove.setModulo(detalleproveDataAccess.getModulo(connexion,detalleprove));
		detalleprove.setMoneda(detalleproveDataAccess.getMoneda(connexion,detalleprove));
		detalleprove.setCliente(detalleproveDataAccess.getCliente(connexion,detalleprove));
		detalleprove.setTransaccion(detalleproveDataAccess.getTransaccion(connexion,detalleprove));
		detalleprove.setTipoTransaccionModulo(detalleproveDataAccess.getTipoTransaccionModulo(connexion,detalleprove));
		detalleprove.setAsientoContable(detalleproveDataAccess.getAsientoContable(connexion,detalleprove));
		detalleprove.setFactura(detalleproveDataAccess.getFactura(connexion,detalleprove));
		detalleprove.setOrdenCompra(detalleproveDataAccess.getOrdenCompra(connexion,detalleprove));
		detalleprove.setEstadoDetalleCliente(detalleproveDataAccess.getEstadoDetalleCliente(connexion,detalleprove));
		detalleprove.setAnio(detalleproveDataAccess.getAnio(connexion,detalleprove));
		detalleprove.setMes(detalleproveDataAccess.getMes(connexion,detalleprove));
		detalleprove.setPagoAutos(detalleproveDataAccess.getPagoAutos(connexion,detalleprove));
		detalleprove.setAutoriPagos(detalleproveDataAccess.getAutoriPagos(connexion,detalleprove));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleprove.setEmpresa(detalleproveDataAccess.getEmpresa(connexion,detalleprove));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleprove.setSucursal(detalleproveDataAccess.getSucursal(connexion,detalleprove));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleprove.setSucursalMovimiento(detalleproveDataAccess.getSucursalMovimiento(connexion,detalleprove));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleprove.setEjercicio(detalleproveDataAccess.getEjercicio(connexion,detalleprove));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalleprove.setPeriodo(detalleproveDataAccess.getPeriodo(connexion,detalleprove));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				detalleprove.setModulo(detalleproveDataAccess.getModulo(connexion,detalleprove));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				detalleprove.setMoneda(detalleproveDataAccess.getMoneda(connexion,detalleprove));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				detalleprove.setCliente(detalleproveDataAccess.getCliente(connexion,detalleprove));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				detalleprove.setTransaccion(detalleproveDataAccess.getTransaccion(connexion,detalleprove));
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				detalleprove.setTipoTransaccionModulo(detalleproveDataAccess.getTipoTransaccionModulo(connexion,detalleprove));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				detalleprove.setAsientoContable(detalleproveDataAccess.getAsientoContable(connexion,detalleprove));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				detalleprove.setFactura(detalleproveDataAccess.getFactura(connexion,detalleprove));
				continue;
			}

			if(clas.clas.equals(OrdenCompra.class)) {
				detalleprove.setOrdenCompra(detalleproveDataAccess.getOrdenCompra(connexion,detalleprove));
				continue;
			}

			if(clas.clas.equals(EstadoDetalleCliente.class)) {
				detalleprove.setEstadoDetalleCliente(detalleproveDataAccess.getEstadoDetalleCliente(connexion,detalleprove));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detalleprove.setAnio(detalleproveDataAccess.getAnio(connexion,detalleprove));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detalleprove.setMes(detalleproveDataAccess.getMes(connexion,detalleprove));
				continue;
			}

			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleprove.setPagoAutos(detalleproveDataAccess.getPagoAutos(connexion,detalleprove));

				if(this.isConDeep) {
					PagoAutoLogic pagoautoLogic= new PagoAutoLogic(this.connexion);
					pagoautoLogic.setPagoAutos(detalleprove.getPagoAutos());
					ArrayList<Classe> classesLocal=PagoAutoConstantesFunciones.getClassesForeignKeysOfPagoAuto(new ArrayList<Classe>(),DeepLoadType.NONE);
					pagoautoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(pagoautoLogic.getPagoAutos());
					detalleprove.setPagoAutos(pagoautoLogic.getPagoAutos());
				}

				continue;
			}

			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleprove.setAutoriPagos(detalleproveDataAccess.getAutoriPagos(connexion,detalleprove));

				if(this.isConDeep) {
					AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(this.connexion);
					autoripagoLogic.setAutoriPagos(detalleprove.getAutoriPagos());
					ArrayList<Classe> classesLocal=AutoriPagoConstantesFunciones.getClassesForeignKeysOfAutoriPago(new ArrayList<Classe>(),DeepLoadType.NONE);
					autoripagoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(autoripagoLogic.getAutoriPagos());
					detalleprove.setAutoriPagos(autoripagoLogic.getAutoriPagos());
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
			detalleprove.setEmpresa(detalleproveDataAccess.getEmpresa(connexion,detalleprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setSucursal(detalleproveDataAccess.getSucursal(connexion,detalleprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setSucursalMovimiento(detalleproveDataAccess.getSucursalMovimiento(connexion,detalleprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setEjercicio(detalleproveDataAccess.getEjercicio(connexion,detalleprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setPeriodo(detalleproveDataAccess.getPeriodo(connexion,detalleprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setModulo(detalleproveDataAccess.getModulo(connexion,detalleprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setMoneda(detalleproveDataAccess.getMoneda(connexion,detalleprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setCliente(detalleproveDataAccess.getCliente(connexion,detalleprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setTransaccion(detalleproveDataAccess.getTransaccion(connexion,detalleprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setTipoTransaccionModulo(detalleproveDataAccess.getTipoTransaccionModulo(connexion,detalleprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setAsientoContable(detalleproveDataAccess.getAsientoContable(connexion,detalleprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setFactura(detalleproveDataAccess.getFactura(connexion,detalleprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setOrdenCompra(detalleproveDataAccess.getOrdenCompra(connexion,detalleprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetalleCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setEstadoDetalleCliente(detalleproveDataAccess.getEstadoDetalleCliente(connexion,detalleprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setAnio(detalleproveDataAccess.getAnio(connexion,detalleprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setMes(detalleproveDataAccess.getMes(connexion,detalleprove));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PagoAuto.class));
			detalleprove.setPagoAutos(detalleproveDataAccess.getPagoAutos(connexion,detalleprove));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AutoriPago.class));
			detalleprove.setAutoriPagos(detalleproveDataAccess.getAutoriPagos(connexion,detalleprove));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleprove.setEmpresa(detalleproveDataAccess.getEmpresa(connexion,detalleprove));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleprove.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalleprove.setSucursal(detalleproveDataAccess.getSucursal(connexion,detalleprove));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleprove.getSucursal(),isDeep,deepLoadType,clases);
				
		detalleprove.setSucursalMovimiento(detalleproveDataAccess.getSucursalMovimiento(connexion,detalleprove));
		SucursalLogic sucursalmovimientoLogic= new SucursalLogic(connexion);
		sucursalmovimientoLogic.deepLoad(detalleprove.getSucursalMovimiento(),isDeep,deepLoadType,clases);
				
		detalleprove.setEjercicio(detalleproveDataAccess.getEjercicio(connexion,detalleprove));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleprove.getEjercicio(),isDeep,deepLoadType,clases);
				
		detalleprove.setPeriodo(detalleproveDataAccess.getPeriodo(connexion,detalleprove));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalleprove.getPeriodo(),isDeep,deepLoadType,clases);
				
		detalleprove.setModulo(detalleproveDataAccess.getModulo(connexion,detalleprove));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(detalleprove.getModulo(),isDeep,deepLoadType,clases);
				
		detalleprove.setMoneda(detalleproveDataAccess.getMoneda(connexion,detalleprove));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(detalleprove.getMoneda(),isDeep,deepLoadType,clases);
				
		detalleprove.setCliente(detalleproveDataAccess.getCliente(connexion,detalleprove));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(detalleprove.getCliente(),isDeep,deepLoadType,clases);
				
		detalleprove.setTransaccion(detalleproveDataAccess.getTransaccion(connexion,detalleprove));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(detalleprove.getTransaccion(),isDeep,deepLoadType,clases);
				
		detalleprove.setTipoTransaccionModulo(detalleproveDataAccess.getTipoTransaccionModulo(connexion,detalleprove));
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(detalleprove.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		detalleprove.setAsientoContable(detalleproveDataAccess.getAsientoContable(connexion,detalleprove));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(detalleprove.getAsientoContable(),isDeep,deepLoadType,clases);
				
		detalleprove.setFactura(detalleproveDataAccess.getFactura(connexion,detalleprove));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(detalleprove.getFactura(),isDeep,deepLoadType,clases);
				
		detalleprove.setOrdenCompra(detalleproveDataAccess.getOrdenCompra(connexion,detalleprove));
		OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
		ordencompraLogic.deepLoad(detalleprove.getOrdenCompra(),isDeep,deepLoadType,clases);
				
		detalleprove.setEstadoDetalleCliente(detalleproveDataAccess.getEstadoDetalleCliente(connexion,detalleprove));
		EstadoDetalleClienteLogic estadodetalleclienteLogic= new EstadoDetalleClienteLogic(connexion);
		estadodetalleclienteLogic.deepLoad(detalleprove.getEstadoDetalleCliente(),isDeep,deepLoadType,clases);
				
		detalleprove.setAnio(detalleproveDataAccess.getAnio(connexion,detalleprove));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detalleprove.getAnio(),isDeep,deepLoadType,clases);
				
		detalleprove.setMes(detalleproveDataAccess.getMes(connexion,detalleprove));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detalleprove.getMes(),isDeep,deepLoadType,clases);
				

		detalleprove.setPagoAutos(detalleproveDataAccess.getPagoAutos(connexion,detalleprove));

		for(PagoAuto pagoauto:detalleprove.getPagoAutos()) {
			PagoAutoLogic pagoautoLogic= new PagoAutoLogic(connexion);
			pagoautoLogic.deepLoad(pagoauto,isDeep,deepLoadType,clases);
		}

		detalleprove.setAutoriPagos(detalleproveDataAccess.getAutoriPagos(connexion,detalleprove));

		for(AutoriPago autoripago:detalleprove.getAutoriPagos()) {
			AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(connexion);
			autoripagoLogic.deepLoad(autoripago,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleprove.setEmpresa(detalleproveDataAccess.getEmpresa(connexion,detalleprove));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalleprove.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleprove.setSucursal(detalleproveDataAccess.getSucursal(connexion,detalleprove));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detalleprove.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleprove.setSucursalMovimiento(detalleproveDataAccess.getSucursalMovimiento(connexion,detalleprove));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detalleprove.getSucursalMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleprove.setEjercicio(detalleproveDataAccess.getEjercicio(connexion,detalleprove));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detalleprove.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalleprove.setPeriodo(detalleproveDataAccess.getPeriodo(connexion,detalleprove));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detalleprove.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				detalleprove.setModulo(detalleproveDataAccess.getModulo(connexion,detalleprove));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(detalleprove.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				detalleprove.setMoneda(detalleproveDataAccess.getMoneda(connexion,detalleprove));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(detalleprove.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				detalleprove.setCliente(detalleproveDataAccess.getCliente(connexion,detalleprove));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(detalleprove.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				detalleprove.setTransaccion(detalleproveDataAccess.getTransaccion(connexion,detalleprove));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(detalleprove.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				detalleprove.setTipoTransaccionModulo(detalleproveDataAccess.getTipoTransaccionModulo(connexion,detalleprove));
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepLoad(detalleprove.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				detalleprove.setAsientoContable(detalleproveDataAccess.getAsientoContable(connexion,detalleprove));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(detalleprove.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				detalleprove.setFactura(detalleproveDataAccess.getFactura(connexion,detalleprove));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(detalleprove.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(OrdenCompra.class)) {
				detalleprove.setOrdenCompra(detalleproveDataAccess.getOrdenCompra(connexion,detalleprove));
				OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
				ordencompraLogic.deepLoad(detalleprove.getOrdenCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetalleCliente.class)) {
				detalleprove.setEstadoDetalleCliente(detalleproveDataAccess.getEstadoDetalleCliente(connexion,detalleprove));
				EstadoDetalleClienteLogic estadodetalleclienteLogic= new EstadoDetalleClienteLogic(connexion);
				estadodetalleclienteLogic.deepLoad(detalleprove.getEstadoDetalleCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detalleprove.setAnio(detalleproveDataAccess.getAnio(connexion,detalleprove));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detalleprove.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detalleprove.setMes(detalleproveDataAccess.getMes(connexion,detalleprove));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detalleprove.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleprove.setPagoAutos(detalleproveDataAccess.getPagoAutos(connexion,detalleprove));

				for(PagoAuto pagoauto:detalleprove.getPagoAutos()) {
					PagoAutoLogic pagoautoLogic= new PagoAutoLogic(connexion);
					pagoautoLogic.deepLoad(pagoauto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleprove.setAutoriPagos(detalleproveDataAccess.getAutoriPagos(connexion,detalleprove));

				for(AutoriPago autoripago:detalleprove.getAutoriPagos()) {
					AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(connexion);
					autoripagoLogic.deepLoad(autoripago,isDeep,deepLoadType,clases);
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
			detalleprove.setEmpresa(detalleproveDataAccess.getEmpresa(connexion,detalleprove));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalleprove.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setSucursal(detalleproveDataAccess.getSucursal(connexion,detalleprove));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detalleprove.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setSucursalMovimiento(detalleproveDataAccess.getSucursalMovimiento(connexion,detalleprove));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detalleprove.getSucursalMovimiento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setEjercicio(detalleproveDataAccess.getEjercicio(connexion,detalleprove));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detalleprove.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setPeriodo(detalleproveDataAccess.getPeriodo(connexion,detalleprove));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detalleprove.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setModulo(detalleproveDataAccess.getModulo(connexion,detalleprove));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(detalleprove.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setMoneda(detalleproveDataAccess.getMoneda(connexion,detalleprove));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(detalleprove.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setCliente(detalleproveDataAccess.getCliente(connexion,detalleprove));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(detalleprove.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setTransaccion(detalleproveDataAccess.getTransaccion(connexion,detalleprove));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(detalleprove.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setTipoTransaccionModulo(detalleproveDataAccess.getTipoTransaccionModulo(connexion,detalleprove));
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
			tipotransaccionmoduloLogic.deepLoad(detalleprove.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setAsientoContable(detalleproveDataAccess.getAsientoContable(connexion,detalleprove));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(detalleprove.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setFactura(detalleproveDataAccess.getFactura(connexion,detalleprove));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(detalleprove.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setOrdenCompra(detalleproveDataAccess.getOrdenCompra(connexion,detalleprove));
			OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
			ordencompraLogic.deepLoad(detalleprove.getOrdenCompra(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetalleCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setEstadoDetalleCliente(detalleproveDataAccess.getEstadoDetalleCliente(connexion,detalleprove));
			EstadoDetalleClienteLogic estadodetalleclienteLogic= new EstadoDetalleClienteLogic(connexion);
			estadodetalleclienteLogic.deepLoad(detalleprove.getEstadoDetalleCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setAnio(detalleproveDataAccess.getAnio(connexion,detalleprove));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detalleprove.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleprove.setMes(detalleproveDataAccess.getMes(connexion,detalleprove));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detalleprove.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PagoAuto.class));
			detalleprove.setPagoAutos(detalleproveDataAccess.getPagoAutos(connexion,detalleprove));

			for(PagoAuto pagoauto:detalleprove.getPagoAutos()) {
				PagoAutoLogic pagoautoLogic= new PagoAutoLogic(connexion);
				pagoautoLogic.deepLoad(pagoauto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AutoriPago.class));
			detalleprove.setAutoriPagos(detalleproveDataAccess.getAutoriPagos(connexion,detalleprove));

			for(AutoriPago autoripago:detalleprove.getAutoriPagos()) {
				AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(connexion);
				autoripagoLogic.deepLoad(autoripago,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleProve detalleprove,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleProveLogicAdditional.updateDetalleProveToSave(detalleprove,this.arrDatoGeneral);
			
DetalleProveDataAccess.save(detalleprove, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleprove.getEmpresa(),connexion);

		SucursalDataAccess.save(detalleprove.getSucursal(),connexion);

		SucursalDataAccess.save(detalleprove.getSucursalMovimiento(),connexion);

		EjercicioDataAccess.save(detalleprove.getEjercicio(),connexion);

		PeriodoDataAccess.save(detalleprove.getPeriodo(),connexion);

		ModuloDataAccess.save(detalleprove.getModulo(),connexion);

		MonedaDataAccess.save(detalleprove.getMoneda(),connexion);

		ClienteDataAccess.save(detalleprove.getCliente(),connexion);

		TransaccionDataAccess.save(detalleprove.getTransaccion(),connexion);

		TipoTransaccionModuloDataAccess.save(detalleprove.getTipoTransaccionModulo(),connexion);

		AsientoContableDataAccess.save(detalleprove.getAsientoContable(),connexion);

		FacturaDataAccess.save(detalleprove.getFactura(),connexion);

		OrdenCompraDataAccess.save(detalleprove.getOrdenCompra(),connexion);

		EstadoDetalleClienteDataAccess.save(detalleprove.getEstadoDetalleCliente(),connexion);

		AnioDataAccess.save(detalleprove.getAnio(),connexion);

		MesDataAccess.save(detalleprove.getMes(),connexion);

		for(PagoAuto pagoauto:detalleprove.getPagoAutos()) {
			pagoauto.setid_detalle_prove(detalleprove.getId());
			PagoAutoDataAccess.save(pagoauto,connexion);
		}

		for(AutoriPago autoripago:detalleprove.getAutoriPagos()) {
			autoripago.setid_detalle_prove(detalleprove.getId());
			AutoriPagoDataAccess.save(autoripago,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleprove.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleprove.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleprove.getSucursalMovimiento(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleprove.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalleprove.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(detalleprove.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(detalleprove.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(detalleprove.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(detalleprove.getTransaccion(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(detalleprove.getTipoTransaccionModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(detalleprove.getAsientoContable(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(detalleprove.getFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(OrdenCompra.class)) {
				OrdenCompraDataAccess.save(detalleprove.getOrdenCompra(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoDetalleCliente.class)) {
				EstadoDetalleClienteDataAccess.save(detalleprove.getEstadoDetalleCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detalleprove.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detalleprove.getMes(),connexion);
				continue;
			}


			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PagoAuto pagoauto:detalleprove.getPagoAutos()) {
					pagoauto.setid_detalle_prove(detalleprove.getId());
					PagoAutoDataAccess.save(pagoauto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AutoriPago autoripago:detalleprove.getAutoriPagos()) {
					autoripago.setid_detalle_prove(detalleprove.getId());
					AutoriPagoDataAccess.save(autoripago,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleprove.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleprove.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detalleprove.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleprove.getSucursal(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detalleprove.getSucursalMovimiento(),connexion);
		SucursalLogic sucursalmovimientoLogic= new SucursalLogic(connexion);
		sucursalmovimientoLogic.deepLoad(detalleprove.getSucursalMovimiento(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detalleprove.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleprove.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detalleprove.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalleprove.getPeriodo(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(detalleprove.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(detalleprove.getModulo(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(detalleprove.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(detalleprove.getMoneda(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(detalleprove.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(detalleprove.getCliente(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(detalleprove.getTransaccion(),connexion);
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(detalleprove.getTransaccion(),isDeep,deepLoadType,clases);
				

		TipoTransaccionModuloDataAccess.save(detalleprove.getTipoTransaccionModulo(),connexion);
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(detalleprove.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(detalleprove.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(detalleprove.getAsientoContable(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(detalleprove.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(detalleprove.getFactura(),isDeep,deepLoadType,clases);
				

		OrdenCompraDataAccess.save(detalleprove.getOrdenCompra(),connexion);
		OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
		ordencompraLogic.deepLoad(detalleprove.getOrdenCompra(),isDeep,deepLoadType,clases);
				

		EstadoDetalleClienteDataAccess.save(detalleprove.getEstadoDetalleCliente(),connexion);
		EstadoDetalleClienteLogic estadodetalleclienteLogic= new EstadoDetalleClienteLogic(connexion);
		estadodetalleclienteLogic.deepLoad(detalleprove.getEstadoDetalleCliente(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detalleprove.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detalleprove.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detalleprove.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detalleprove.getMes(),isDeep,deepLoadType,clases);
				

		for(PagoAuto pagoauto:detalleprove.getPagoAutos()) {
			PagoAutoLogic pagoautoLogic= new PagoAutoLogic(connexion);
			pagoauto.setid_detalle_prove(detalleprove.getId());
			PagoAutoDataAccess.save(pagoauto,connexion);
			pagoautoLogic.deepSave(pagoauto,isDeep,deepLoadType,clases);
		}

		for(AutoriPago autoripago:detalleprove.getAutoriPagos()) {
			AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(connexion);
			autoripago.setid_detalle_prove(detalleprove.getId());
			AutoriPagoDataAccess.save(autoripago,connexion);
			autoripagoLogic.deepSave(autoripago,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleprove.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalleprove.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleprove.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detalleprove.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleprove.getSucursalMovimiento(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detalleprove.getSucursalMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleprove.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detalleprove.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalleprove.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detalleprove.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(detalleprove.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(detalleprove.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(detalleprove.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(detalleprove.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(detalleprove.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(detalleprove.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(detalleprove.getTransaccion(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(detalleprove.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(detalleprove.getTipoTransaccionModulo(),connexion);
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepSave(detalleprove.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(detalleprove.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(detalleprove.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(detalleprove.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(detalleprove.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(OrdenCompra.class)) {
				OrdenCompraDataAccess.save(detalleprove.getOrdenCompra(),connexion);
				OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
				ordencompraLogic.deepSave(detalleprove.getOrdenCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetalleCliente.class)) {
				EstadoDetalleClienteDataAccess.save(detalleprove.getEstadoDetalleCliente(),connexion);
				EstadoDetalleClienteLogic estadodetalleclienteLogic= new EstadoDetalleClienteLogic(connexion);
				estadodetalleclienteLogic.deepSave(detalleprove.getEstadoDetalleCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detalleprove.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detalleprove.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detalleprove.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detalleprove.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PagoAuto pagoauto:detalleprove.getPagoAutos()) {
					PagoAutoLogic pagoautoLogic= new PagoAutoLogic(connexion);
					pagoauto.setid_detalle_prove(detalleprove.getId());
					PagoAutoDataAccess.save(pagoauto,connexion);
					pagoautoLogic.deepSave(pagoauto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AutoriPago autoripago:detalleprove.getAutoriPagos()) {
					AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(connexion);
					autoripago.setid_detalle_prove(detalleprove.getId());
					AutoriPagoDataAccess.save(autoripago,connexion);
					autoripagoLogic.deepSave(autoripago,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(DetalleProve.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalleprove,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(detalleprove);
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
			this.deepLoad(this.detalleprove,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleprove);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleProve.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalleproves!=null) {
				for(DetalleProve detalleprove:detalleproves) {
					this.deepLoad(detalleprove,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(detalleproves);
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
			if(detalleproves!=null) {
				for(DetalleProve detalleprove:detalleproves) {
					this.deepLoad(detalleprove,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(detalleproves);
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
			this.getNewConnexionToDeep(DetalleProve.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalleprove,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleProve.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalleproves!=null) {
				for(DetalleProve detalleprove:detalleproves) {
					this.deepSave(detalleprove,isDeep,deepLoadType,clases);
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
			if(detalleproves!=null) {
				for(DetalleProve detalleprove:detalleproves) {
					this.deepSave(detalleprove,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleProvesFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleProveConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProvesFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleProveConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProvesFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,DetalleProveConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProvesFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,DetalleProveConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProvesFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,DetalleProveConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProvesFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,DetalleProveConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProvesFK_IdDetalleProveWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal_movimiento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursalMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursalMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal_movimiento,DetalleProveConstantesFunciones.IDSUCURSALMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursalMovimiento);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleProve","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProvesFK_IdDetalleProve(String sFinalQuery,Pagination pagination,Long id_sucursal_movimiento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursalMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursalMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal_movimiento,DetalleProveConstantesFunciones.IDSUCURSALMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursalMovimiento);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleProve","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProvesFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleProveConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProvesFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleProveConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProvesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleProveConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProvesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleProveConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProvesFK_IdEstadoDetalleClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_detalle_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetalleCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetalleCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_cliente,DetalleProveConstantesFunciones.IDESTADODETALLECLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetalleCliente);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetalleCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProvesFK_IdEstadoDetalleCliente(String sFinalQuery,Pagination pagination,Long id_estado_detalle_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetalleCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetalleCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_cliente,DetalleProveConstantesFunciones.IDESTADODETALLECLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetalleCliente);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetalleCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProvesFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,DetalleProveConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProvesFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,DetalleProveConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProvesFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleProveConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProvesFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleProveConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProvesFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,DetalleProveConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProvesFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,DetalleProveConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProvesFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,DetalleProveConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProvesFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,DetalleProveConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProvesFK_IdOrdenCompraWithConnection(String sFinalQuery,Pagination pagination,Long id_orden_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_compra,DetalleProveConstantesFunciones.IDORDENCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenCompra);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProvesFK_IdOrdenCompra(String sFinalQuery,Pagination pagination,Long id_orden_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_compra,DetalleProveConstantesFunciones.IDORDENCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenCompra);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProvesFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleProveConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProvesFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleProveConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProvesFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleProveConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProvesFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleProveConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProvesFK_IdTipoTransaccionModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,DetalleProveConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProvesFK_IdTipoTransaccionModulo(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,DetalleProveConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProvesFK_IdTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,DetalleProveConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProvesFK_IdTransaccion(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,DetalleProveConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			DetalleProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(this.detalleproves);
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
			if(DetalleProveConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleProveDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleProve detalleprove,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleProveConstantesFunciones.ISCONAUDITORIA) {
				if(detalleprove.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleProveDataAccess.TABLENAME, detalleprove.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleProveConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleProveLogic.registrarAuditoriaDetallesDetalleProve(connexion,detalleprove,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalleprove.getIsDeleted()) {
					/*if(!detalleprove.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleProveDataAccess.TABLENAME, detalleprove.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleProveLogic.registrarAuditoriaDetallesDetalleProve(connexion,detalleprove,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleProveDataAccess.TABLENAME, detalleprove.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalleprove.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleProveDataAccess.TABLENAME, detalleprove.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleProveConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleProveLogic.registrarAuditoriaDetallesDetalleProve(connexion,detalleprove,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleProve(Connexion connexion,DetalleProve detalleprove)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalleprove.getIsNew()||!detalleprove.getid_empresa().equals(detalleprove.getDetalleProveOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getid_empresa()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getid_empresa().toString();
				}
				if(detalleprove.getid_empresa()!=null)
				{
					strValorNuevo=detalleprove.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getid_sucursal().equals(detalleprove.getDetalleProveOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getid_sucursal()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getid_sucursal().toString();
				}
				if(detalleprove.getid_sucursal()!=null)
				{
					strValorNuevo=detalleprove.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getid_sucursal_movimiento().equals(detalleprove.getDetalleProveOriginal().getid_sucursal_movimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getid_sucursal_movimiento()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getid_sucursal_movimiento().toString();
				}
				if(detalleprove.getid_sucursal_movimiento()!=null)
				{
					strValorNuevo=detalleprove.getid_sucursal_movimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.IDSUCURSALMOVIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getid_ejercicio().equals(detalleprove.getDetalleProveOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getid_ejercicio().toString();
				}
				if(detalleprove.getid_ejercicio()!=null)
				{
					strValorNuevo=detalleprove.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getid_periodo().equals(detalleprove.getDetalleProveOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getid_periodo()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getid_periodo().toString();
				}
				if(detalleprove.getid_periodo()!=null)
				{
					strValorNuevo=detalleprove.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getid_modulo().equals(detalleprove.getDetalleProveOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getid_modulo()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getid_modulo().toString();
				}
				if(detalleprove.getid_modulo()!=null)
				{
					strValorNuevo=detalleprove.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getid_moneda().equals(detalleprove.getDetalleProveOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getid_moneda()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getid_moneda().toString();
				}
				if(detalleprove.getid_moneda()!=null)
				{
					strValorNuevo=detalleprove.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getid_cliente().equals(detalleprove.getDetalleProveOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getid_cliente()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getid_cliente().toString();
				}
				if(detalleprove.getid_cliente()!=null)
				{
					strValorNuevo=detalleprove.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getid_transaccion().equals(detalleprove.getDetalleProveOriginal().getid_transaccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getid_transaccion()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getid_transaccion().toString();
				}
				if(detalleprove.getid_transaccion()!=null)
				{
					strValorNuevo=detalleprove.getid_transaccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.IDTRANSACCION,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getid_tipo_transaccion_modulo().equals(detalleprove.getDetalleProveOriginal().getid_tipo_transaccion_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getid_tipo_transaccion_modulo()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getid_tipo_transaccion_modulo().toString();
				}
				if(detalleprove.getid_tipo_transaccion_modulo()!=null)
				{
					strValorNuevo=detalleprove.getid_tipo_transaccion_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.IDTIPOTRANSACCIONMODULO,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getid_asiento_contable().equals(detalleprove.getDetalleProveOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getid_asiento_contable().toString();
				}
				if(detalleprove.getid_asiento_contable()!=null)
				{
					strValorNuevo=detalleprove.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getid_factura().equals(detalleprove.getDetalleProveOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getid_factura()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getid_factura().toString();
				}
				if(detalleprove.getid_factura()!=null)
				{
					strValorNuevo=detalleprove.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getid_orden_compra().equals(detalleprove.getDetalleProveOriginal().getid_orden_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getid_orden_compra()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getid_orden_compra().toString();
				}
				if(detalleprove.getid_orden_compra()!=null)
				{
					strValorNuevo=detalleprove.getid_orden_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.IDORDENCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getid_estado_detalle_cliente().equals(detalleprove.getDetalleProveOriginal().getid_estado_detalle_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getid_estado_detalle_cliente()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getid_estado_detalle_cliente().toString();
				}
				if(detalleprove.getid_estado_detalle_cliente()!=null)
				{
					strValorNuevo=detalleprove.getid_estado_detalle_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.IDESTADODETALLECLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getfecha_venta().equals(detalleprove.getDetalleProveOriginal().getfecha_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getfecha_venta()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getfecha_venta().toString();
				}
				if(detalleprove.getfecha_venta()!=null)
				{
					strValorNuevo=detalleprove.getfecha_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.FECHAVENTA,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getfecha_emision().equals(detalleprove.getDetalleProveOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getfecha_emision()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getfecha_emision().toString();
				}
				if(detalleprove.getfecha_emision()!=null)
				{
					strValorNuevo=detalleprove.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getfecha_pago().equals(detalleprove.getDetalleProveOriginal().getfecha_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getfecha_pago()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getfecha_pago().toString();
				}
				if(detalleprove.getfecha_pago()!=null)
				{
					strValorNuevo=detalleprove.getfecha_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.FECHAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getfecha_vencimiento().equals(detalleprove.getDetalleProveOriginal().getfecha_vencimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getfecha_vencimiento()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getfecha_vencimiento().toString();
				}
				if(detalleprove.getfecha_vencimiento()!=null)
				{
					strValorNuevo=detalleprove.getfecha_vencimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.FECHAVENCIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getmonto_mone_local().equals(detalleprove.getDetalleProveOriginal().getmonto_mone_local()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getmonto_mone_local()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getmonto_mone_local().toString();
				}
				if(detalleprove.getmonto_mone_local()!=null)
				{
					strValorNuevo=detalleprove.getmonto_mone_local().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.MONTOMONELOCAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getmonto_mone_extra().equals(detalleprove.getDetalleProveOriginal().getmonto_mone_extra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getmonto_mone_extra()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getmonto_mone_extra().toString();
				}
				if(detalleprove.getmonto_mone_extra()!=null)
				{
					strValorNuevo=detalleprove.getmonto_mone_extra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.MONTOMONEEXTRA,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getnumero_comprobante().equals(detalleprove.getDetalleProveOriginal().getnumero_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getnumero_comprobante()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getnumero_comprobante();
				}
				if(detalleprove.getnumero_comprobante()!=null)
				{
					strValorNuevo=detalleprove.getnumero_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.NUMEROCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getnumero_factura().equals(detalleprove.getDetalleProveOriginal().getnumero_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getnumero_factura()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getnumero_factura();
				}
				if(detalleprove.getnumero_factura()!=null)
				{
					strValorNuevo=detalleprove.getnumero_factura() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.NUMEROFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getdebito_mone_local().equals(detalleprove.getDetalleProveOriginal().getdebito_mone_local()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getdebito_mone_local()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getdebito_mone_local().toString();
				}
				if(detalleprove.getdebito_mone_local()!=null)
				{
					strValorNuevo=detalleprove.getdebito_mone_local().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.DEBITOMONELOCAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getcredito_mone_local().equals(detalleprove.getDetalleProveOriginal().getcredito_mone_local()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getcredito_mone_local()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getcredito_mone_local().toString();
				}
				if(detalleprove.getcredito_mone_local()!=null)
				{
					strValorNuevo=detalleprove.getcredito_mone_local().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.CREDITOMONELOCAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getdebito_mone_extra().equals(detalleprove.getDetalleProveOriginal().getdebito_mone_extra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getdebito_mone_extra()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getdebito_mone_extra().toString();
				}
				if(detalleprove.getdebito_mone_extra()!=null)
				{
					strValorNuevo=detalleprove.getdebito_mone_extra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.DEBITOMONEEXTRA,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getcredito_mone_extra().equals(detalleprove.getDetalleProveOriginal().getcredito_mone_extra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getcredito_mone_extra()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getcredito_mone_extra().toString();
				}
				if(detalleprove.getcredito_mone_extra()!=null)
				{
					strValorNuevo=detalleprove.getcredito_mone_extra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.CREDITOMONEEXTRA,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getdescripcion().equals(detalleprove.getDetalleProveOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getdescripcion()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getdescripcion();
				}
				if(detalleprove.getdescripcion()!=null)
				{
					strValorNuevo=detalleprove.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getid_anio().equals(detalleprove.getDetalleProveOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getid_anio()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getid_anio().toString();
				}
				if(detalleprove.getid_anio()!=null)
				{
					strValorNuevo=detalleprove.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleprove.getIsNew()||!detalleprove.getid_mes().equals(detalleprove.getDetalleProveOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleprove.getDetalleProveOriginal().getid_mes()!=null)
				{
					strValorActual=detalleprove.getDetalleProveOriginal().getid_mes().toString();
				}
				if(detalleprove.getid_mes()!=null)
				{
					strValorNuevo=detalleprove.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProveConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleProveRelacionesWithConnection(DetalleProve detalleprove,List<PagoAuto> pagoautos,List<AutoriPago> autoripagos) throws Exception {

		if(!detalleprove.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleProveRelacionesBase(detalleprove,pagoautos,autoripagos,true);
		}
	}

	public void saveDetalleProveRelaciones(DetalleProve detalleprove,List<PagoAuto> pagoautos,List<AutoriPago> autoripagos)throws Exception {

		if(!detalleprove.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleProveRelacionesBase(detalleprove,pagoautos,autoripagos,false);
		}
	}

	public void saveDetalleProveRelacionesBase(DetalleProve detalleprove,List<PagoAuto> pagoautos,List<AutoriPago> autoripagos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleProve-saveRelacionesWithConnection");}
	
			detalleprove.setPagoAutos(pagoautos);
			detalleprove.setAutoriPagos(autoripagos);

			this.setDetalleProve(detalleprove);

			if(DetalleProveLogicAdditional.validarSaveRelaciones(detalleprove,this)) {

				DetalleProveLogicAdditional.updateRelacionesToSave(detalleprove,this);

				if((detalleprove.getIsNew()||detalleprove.getIsChanged())&&!detalleprove.getIsDeleted()) {
					this.saveDetalleProve();
					this.saveDetalleProveRelacionesDetalles(pagoautos,autoripagos);

				} else if(detalleprove.getIsDeleted()) {
					this.saveDetalleProveRelacionesDetalles(pagoautos,autoripagos);
					this.saveDetalleProve();
				}

				DetalleProveLogicAdditional.updateRelacionesToSaveAfter(detalleprove,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			PagoAutoConstantesFunciones.InicializarGeneralEntityAuxiliaresPagoAutos(pagoautos,true,true);
			AutoriPagoConstantesFunciones.InicializarGeneralEntityAuxiliaresAutoriPagos(autoripagos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveDetalleProveRelacionesDetalles(List<PagoAuto> pagoautos,List<AutoriPago> autoripagos)throws Exception {
		try {
	

			Long idDetalleProveActual=this.getDetalleProve().getId();

			PagoAutoLogic pagoautoLogic_Desde_DetalleProve=new PagoAutoLogic();
			pagoautoLogic_Desde_DetalleProve.setPagoAutos(pagoautos);

			pagoautoLogic_Desde_DetalleProve.setConnexion(this.getConnexion());
			pagoautoLogic_Desde_DetalleProve.setDatosCliente(this.datosCliente);

			for(PagoAuto pagoauto_Desde_DetalleProve:pagoautoLogic_Desde_DetalleProve.getPagoAutos()) {
				pagoauto_Desde_DetalleProve.setid_detalle_prove(idDetalleProveActual);
			}

			pagoautoLogic_Desde_DetalleProve.savePagoAutos();

			AutoriPagoLogic autoripagoLogic_Desde_DetalleProve=new AutoriPagoLogic();
			autoripagoLogic_Desde_DetalleProve.setAutoriPagos(autoripagos);

			autoripagoLogic_Desde_DetalleProve.setConnexion(this.getConnexion());
			autoripagoLogic_Desde_DetalleProve.setDatosCliente(this.datosCliente);

			for(AutoriPago autoripago_Desde_DetalleProve:autoripagoLogic_Desde_DetalleProve.getAutoriPagos()) {
				autoripago_Desde_DetalleProve.setid_detalle_prove(idDetalleProveActual);
			}

			autoripagoLogic_Desde_DetalleProve.saveAutoriPagos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleProve(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleProveConstantesFunciones.getClassesForeignKeysOfDetalleProve(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleProve(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleProveConstantesFunciones.getClassesRelationshipsOfDetalleProve(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

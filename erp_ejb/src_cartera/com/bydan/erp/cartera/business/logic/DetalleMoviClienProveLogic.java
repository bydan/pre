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
import com.bydan.erp.cartera.util.DetalleMoviClienProveConstantesFunciones;
import com.bydan.erp.cartera.util.DetalleMoviClienProveParameterReturnGeneral;
//import com.bydan.erp.cartera.util.DetalleMoviClienProveParameterGeneral;
import com.bydan.erp.cartera.business.entity.DetalleMoviClienProve;
import com.bydan.erp.cartera.business.logic.DetalleMoviClienProveLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetalleMoviClienProveLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleMoviClienProveLogic.class);
	
	protected DetalleMoviClienProveDataAccess detallemoviclienproveDataAccess; 	
	protected DetalleMoviClienProve detallemoviclienprove;
	protected List<DetalleMoviClienProve> detallemoviclienproves;
	protected Object detallemoviclienproveObject;	
	protected List<Object> detallemoviclienprovesObject;
	
	public static ClassValidator<DetalleMoviClienProve> detallemoviclienproveValidator = new ClassValidator<DetalleMoviClienProve>(DetalleMoviClienProve.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleMoviClienProveLogicAdditional detallemoviclienproveLogicAdditional=null;
	
	public DetalleMoviClienProveLogicAdditional getDetalleMoviClienProveLogicAdditional() {
		return this.detallemoviclienproveLogicAdditional;
	}
	
	public void setDetalleMoviClienProveLogicAdditional(DetalleMoviClienProveLogicAdditional detallemoviclienproveLogicAdditional) {
		try {
			this.detallemoviclienproveLogicAdditional=detallemoviclienproveLogicAdditional;
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
	
	
	
	
	public  DetalleMoviClienProveLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detallemoviclienproveDataAccess = new DetalleMoviClienProveDataAccess();
			
			this.detallemoviclienproves= new ArrayList<DetalleMoviClienProve>();
			this.detallemoviclienprove= new DetalleMoviClienProve();
			
			this.detallemoviclienproveObject=new Object();
			this.detallemoviclienprovesObject=new ArrayList<Object>();
				
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
			
			this.detallemoviclienproveDataAccess.setConnexionType(this.connexionType);
			this.detallemoviclienproveDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleMoviClienProveLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detallemoviclienproveDataAccess = new DetalleMoviClienProveDataAccess();
			this.detallemoviclienproves= new ArrayList<DetalleMoviClienProve>();
			this.detallemoviclienprove= new DetalleMoviClienProve();
			this.detallemoviclienproveObject=new Object();
			this.detallemoviclienprovesObject=new ArrayList<Object>();
			
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
			
			this.detallemoviclienproveDataAccess.setConnexionType(this.connexionType);
			this.detallemoviclienproveDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleMoviClienProve getDetalleMoviClienProve() throws Exception {	
		DetalleMoviClienProveLogicAdditional.checkDetalleMoviClienProveToGet(detallemoviclienprove,this.datosCliente,this.arrDatoGeneral);
		DetalleMoviClienProveLogicAdditional.updateDetalleMoviClienProveToGet(detallemoviclienprove,this.arrDatoGeneral);
		
		return detallemoviclienprove;
	}
		
	public void setDetalleMoviClienProve(DetalleMoviClienProve newDetalleMoviClienProve) {
		this.detallemoviclienprove = newDetalleMoviClienProve;
	}
	
	public DetalleMoviClienProveDataAccess getDetalleMoviClienProveDataAccess() {
		return detallemoviclienproveDataAccess;
	}
	
	public void setDetalleMoviClienProveDataAccess(DetalleMoviClienProveDataAccess newdetallemoviclienproveDataAccess) {
		this.detallemoviclienproveDataAccess = newdetallemoviclienproveDataAccess;
	}
	
	public List<DetalleMoviClienProve> getDetalleMoviClienProves() throws Exception {		
		this.quitarDetalleMoviClienProvesNulos();
		
		DetalleMoviClienProveLogicAdditional.checkDetalleMoviClienProveToGets(detallemoviclienproves,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleMoviClienProve detallemoviclienproveLocal: detallemoviclienproves ) {
			DetalleMoviClienProveLogicAdditional.updateDetalleMoviClienProveToGet(detallemoviclienproveLocal,this.arrDatoGeneral);
		}
		
		return detallemoviclienproves;
	}
	
	public void setDetalleMoviClienProves(List<DetalleMoviClienProve> newDetalleMoviClienProves) {
		this.detallemoviclienproves = newDetalleMoviClienProves;
	}
	
	public Object getDetalleMoviClienProveObject() {	
		this.detallemoviclienproveObject=this.detallemoviclienproveDataAccess.getEntityObject();
		return this.detallemoviclienproveObject;
	}
		
	public void setDetalleMoviClienProveObject(Object newDetalleMoviClienProveObject) {
		this.detallemoviclienproveObject = newDetalleMoviClienProveObject;
	}
	
	public List<Object> getDetalleMoviClienProvesObject() {		
		this.detallemoviclienprovesObject=this.detallemoviclienproveDataAccess.getEntitiesObject();
		return this.detallemoviclienprovesObject;
	}
		
	public void setDetalleMoviClienProvesObject(List<Object> newDetalleMoviClienProvesObject) {
		this.detallemoviclienprovesObject = newDetalleMoviClienProvesObject;
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
		
		if(this.detallemoviclienproveDataAccess!=null) {
			this.detallemoviclienproveDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detallemoviclienproveDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detallemoviclienproveDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detallemoviclienprove = new  DetalleMoviClienProve();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallemoviclienprove=detallemoviclienproveDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallemoviclienprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienprove);
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
		detallemoviclienprove = new  DetalleMoviClienProve();
		  		  
        try {
			
			detallemoviclienprove=detallemoviclienproveDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallemoviclienprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienprove);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detallemoviclienprove = new  DetalleMoviClienProve();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallemoviclienprove=detallemoviclienproveDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallemoviclienprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienprove);
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
		detallemoviclienprove = new  DetalleMoviClienProve();
		  		  
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
		detallemoviclienprove = new  DetalleMoviClienProve();
		  		  
        try {
			
			detallemoviclienprove=detallemoviclienproveDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallemoviclienprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienprove);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detallemoviclienprove = new  DetalleMoviClienProve();
		  		  
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
		detallemoviclienprove = new  DetalleMoviClienProve();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detallemoviclienproveDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallemoviclienprove = new  DetalleMoviClienProve();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detallemoviclienproveDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallemoviclienprove = new  DetalleMoviClienProve();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detallemoviclienproveDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallemoviclienprove = new  DetalleMoviClienProve();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detallemoviclienproveDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallemoviclienprove = new  DetalleMoviClienProve();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detallemoviclienproveDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallemoviclienprove = new  DetalleMoviClienProve();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detallemoviclienproveDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallemoviclienproves = new  ArrayList<DetalleMoviClienProve>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleMoviClienProve(detallemoviclienproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
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
		detallemoviclienproves = new  ArrayList<DetalleMoviClienProve>();
		  		  
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
		detallemoviclienproves = new  ArrayList<DetalleMoviClienProve>();
		  		  
        try {			
			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleMoviClienProve(detallemoviclienproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detallemoviclienproves = new  ArrayList<DetalleMoviClienProve>();
		  		  
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
		detallemoviclienproves = new  ArrayList<DetalleMoviClienProve>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleMoviClienProve(detallemoviclienproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
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
		detallemoviclienproves = new  ArrayList<DetalleMoviClienProve>();
		  		  
        try {
			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleMoviClienProve(detallemoviclienproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
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
		detallemoviclienproves = new  ArrayList<DetalleMoviClienProve>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleMoviClienProve(detallemoviclienproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
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
		detallemoviclienproves = new  ArrayList<DetalleMoviClienProve>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleMoviClienProve(detallemoviclienproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detallemoviclienprove = new  DetalleMoviClienProve();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemoviclienprove=detallemoviclienproveDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleMoviClienProve(detallemoviclienprove);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienprove);
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
		detallemoviclienprove = new  DetalleMoviClienProve();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemoviclienprove=detallemoviclienproveDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleMoviClienProve(detallemoviclienprove);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienprove);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallemoviclienproves = new  ArrayList<DetalleMoviClienProve>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemoviclienproves=detallemoviclienproveDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleMoviClienProve(detallemoviclienproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
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
		detallemoviclienproves = new  ArrayList<DetalleMoviClienProve>();
		  		  
        try {
			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemoviclienproves=detallemoviclienproveDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleMoviClienProve(detallemoviclienproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleMoviClienProvesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detallemoviclienproves = new  ArrayList<DetalleMoviClienProve>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getTodosDetalleMoviClienProvesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleMoviClienProve(detallemoviclienproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
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
	
	public  void  getTodosDetalleMoviClienProves(String sFinalQuery,Pagination pagination)throws Exception {
		detallemoviclienproves = new  ArrayList<DetalleMoviClienProve>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleMoviClienProve(detallemoviclienproves);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleMoviClienProve(DetalleMoviClienProve detallemoviclienprove) throws Exception {
		Boolean estaValidado=false;
		
		if(detallemoviclienprove.getIsNew() || detallemoviclienprove.getIsChanged()) { 
			this.invalidValues = detallemoviclienproveValidator.getInvalidValues(detallemoviclienprove);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detallemoviclienprove);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleMoviClienProve(List<DetalleMoviClienProve> DetalleMoviClienProves) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleMoviClienProve detallemoviclienproveLocal:detallemoviclienproves) {				
			estaValidadoObjeto=this.validarGuardarDetalleMoviClienProve(detallemoviclienproveLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleMoviClienProve(List<DetalleMoviClienProve> DetalleMoviClienProves) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleMoviClienProve(detallemoviclienproves)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleMoviClienProve(DetalleMoviClienProve DetalleMoviClienProve) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleMoviClienProve(detallemoviclienprove)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleMoviClienProve detallemoviclienprove) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detallemoviclienprove.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleMoviClienProveConstantesFunciones.getDetalleMoviClienProveLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detallemoviclienprove","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleMoviClienProveConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleMoviClienProveConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleMoviClienProveWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-saveDetalleMoviClienProveWithConnection");connexion.begin();			
			
			DetalleMoviClienProveLogicAdditional.checkDetalleMoviClienProveToSave(this.detallemoviclienprove,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleMoviClienProveLogicAdditional.updateDetalleMoviClienProveToSave(this.detallemoviclienprove,this.arrDatoGeneral);
			
			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallemoviclienprove,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleMoviClienProve();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleMoviClienProve(this.detallemoviclienprove)) {
				DetalleMoviClienProveDataAccess.save(this.detallemoviclienprove, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detallemoviclienprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleMoviClienProveLogicAdditional.checkDetalleMoviClienProveToSaveAfter(this.detallemoviclienprove,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleMoviClienProve();
			
			connexion.commit();			
			
			if(this.detallemoviclienprove.getIsDeleted()) {
				this.detallemoviclienprove=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleMoviClienProve()throws Exception {	
		try {	
			
			DetalleMoviClienProveLogicAdditional.checkDetalleMoviClienProveToSave(this.detallemoviclienprove,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleMoviClienProveLogicAdditional.updateDetalleMoviClienProveToSave(this.detallemoviclienprove,this.arrDatoGeneral);
			
			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallemoviclienprove,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleMoviClienProve(this.detallemoviclienprove)) {			
				DetalleMoviClienProveDataAccess.save(this.detallemoviclienprove, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detallemoviclienprove,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleMoviClienProveLogicAdditional.checkDetalleMoviClienProveToSaveAfter(this.detallemoviclienprove,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detallemoviclienprove.getIsDeleted()) {
				this.detallemoviclienprove=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleMoviClienProvesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-saveDetalleMoviClienProvesWithConnection");connexion.begin();			
			
			DetalleMoviClienProveLogicAdditional.checkDetalleMoviClienProveToSaves(detallemoviclienproves,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleMoviClienProves();
			
			Boolean validadoTodosDetalleMoviClienProve=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleMoviClienProve detallemoviclienproveLocal:detallemoviclienproves) {		
				if(detallemoviclienproveLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleMoviClienProveLogicAdditional.updateDetalleMoviClienProveToSave(detallemoviclienproveLocal,this.arrDatoGeneral);
	        	
				DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallemoviclienproveLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleMoviClienProve(detallemoviclienproveLocal)) {
					DetalleMoviClienProveDataAccess.save(detallemoviclienproveLocal, connexion);				
				} else {
					validadoTodosDetalleMoviClienProve=false;
				}
			}
			
			if(!validadoTodosDetalleMoviClienProve) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleMoviClienProveLogicAdditional.checkDetalleMoviClienProveToSavesAfter(detallemoviclienproves,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleMoviClienProves();
			
			connexion.commit();		
			
			this.quitarDetalleMoviClienProvesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleMoviClienProves()throws Exception {				
		 try {	
			DetalleMoviClienProveLogicAdditional.checkDetalleMoviClienProveToSaves(detallemoviclienproves,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleMoviClienProve=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleMoviClienProve detallemoviclienproveLocal:detallemoviclienproves) {				
				if(detallemoviclienproveLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleMoviClienProveLogicAdditional.updateDetalleMoviClienProveToSave(detallemoviclienproveLocal,this.arrDatoGeneral);
	        	
				DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallemoviclienproveLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleMoviClienProve(detallemoviclienproveLocal)) {				
					DetalleMoviClienProveDataAccess.save(detallemoviclienproveLocal, connexion);				
				} else {
					validadoTodosDetalleMoviClienProve=false;
				}
			}
			
			if(!validadoTodosDetalleMoviClienProve) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleMoviClienProveLogicAdditional.checkDetalleMoviClienProveToSavesAfter(detallemoviclienproves,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleMoviClienProvesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleMoviClienProveParameterReturnGeneral procesarAccionDetalleMoviClienProves(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleMoviClienProve> detallemoviclienproves,DetalleMoviClienProveParameterReturnGeneral detallemoviclienproveParameterGeneral)throws Exception {
		 try {	
			DetalleMoviClienProveParameterReturnGeneral detallemoviclienproveReturnGeneral=new DetalleMoviClienProveParameterReturnGeneral();
	
			DetalleMoviClienProveLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallemoviclienproves,detallemoviclienproveParameterGeneral,detallemoviclienproveReturnGeneral);
			
			return detallemoviclienproveReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleMoviClienProveParameterReturnGeneral procesarAccionDetalleMoviClienProvesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleMoviClienProve> detallemoviclienproves,DetalleMoviClienProveParameterReturnGeneral detallemoviclienproveParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-procesarAccionDetalleMoviClienProvesWithConnection");connexion.begin();			
			
			DetalleMoviClienProveParameterReturnGeneral detallemoviclienproveReturnGeneral=new DetalleMoviClienProveParameterReturnGeneral();
	
			DetalleMoviClienProveLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallemoviclienproves,detallemoviclienproveParameterGeneral,detallemoviclienproveReturnGeneral);
			
			this.connexion.commit();
			
			return detallemoviclienproveReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleMoviClienProveParameterReturnGeneral procesarEventosDetalleMoviClienProves(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleMoviClienProve> detallemoviclienproves,DetalleMoviClienProve detallemoviclienprove,DetalleMoviClienProveParameterReturnGeneral detallemoviclienproveParameterGeneral,Boolean isEsNuevoDetalleMoviClienProve,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleMoviClienProveParameterReturnGeneral detallemoviclienproveReturnGeneral=new DetalleMoviClienProveParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallemoviclienproveReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleMoviClienProveLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallemoviclienproves,detallemoviclienprove,detallemoviclienproveParameterGeneral,detallemoviclienproveReturnGeneral,isEsNuevoDetalleMoviClienProve,clases);
			
			return detallemoviclienproveReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleMoviClienProveParameterReturnGeneral procesarEventosDetalleMoviClienProvesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleMoviClienProve> detallemoviclienproves,DetalleMoviClienProve detallemoviclienprove,DetalleMoviClienProveParameterReturnGeneral detallemoviclienproveParameterGeneral,Boolean isEsNuevoDetalleMoviClienProve,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-procesarEventosDetalleMoviClienProvesWithConnection");connexion.begin();			
			
			DetalleMoviClienProveParameterReturnGeneral detallemoviclienproveReturnGeneral=new DetalleMoviClienProveParameterReturnGeneral();
	
			detallemoviclienproveReturnGeneral.setDetalleMoviClienProve(detallemoviclienprove);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallemoviclienproveReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleMoviClienProveLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallemoviclienproves,detallemoviclienprove,detallemoviclienproveParameterGeneral,detallemoviclienproveReturnGeneral,isEsNuevoDetalleMoviClienProve,clases);
			
			this.connexion.commit();
			
			return detallemoviclienproveReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleMoviClienProveParameterReturnGeneral procesarImportacionDetalleMoviClienProvesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleMoviClienProveParameterReturnGeneral detallemoviclienproveParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-procesarImportacionDetalleMoviClienProvesWithConnection");connexion.begin();			
			
			DetalleMoviClienProveParameterReturnGeneral detallemoviclienproveReturnGeneral=new DetalleMoviClienProveParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detallemoviclienproves=new ArrayList<DetalleMoviClienProve>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detallemoviclienprove=new DetalleMoviClienProve();
				
				
				if(conColumnasBase) {this.detallemoviclienprove.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detallemoviclienprove.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detallemoviclienprove.setfecha_vence(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detallemoviclienprove.setdebito_mone_local(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallemoviclienprove.setcredito_mone_local(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallemoviclienprove.setdebito_mone_extra(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallemoviclienprove.setcredito_mone_extra(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallemoviclienprove.setcotizacion(Double.parseDouble(arrColumnas[iColumn++]));
			this.detallemoviclienprove.setdescripcion(arrColumnas[iColumn++]);
				
				this.detallemoviclienproves.add(this.detallemoviclienprove);
			}
			
			this.saveDetalleMoviClienProves();
			
			this.connexion.commit();
			
			detallemoviclienproveReturnGeneral.setConRetornoEstaProcesado(true);
			detallemoviclienproveReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detallemoviclienproveReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleMoviClienProvesEliminados() throws Exception {				
		
		List<DetalleMoviClienProve> detallemoviclienprovesAux= new ArrayList<DetalleMoviClienProve>();
		
		for(DetalleMoviClienProve detallemoviclienprove:detallemoviclienproves) {
			if(!detallemoviclienprove.getIsDeleted()) {
				detallemoviclienprovesAux.add(detallemoviclienprove);
			}
		}
		
		detallemoviclienproves=detallemoviclienprovesAux;
	}
	
	public void quitarDetalleMoviClienProvesNulos() throws Exception {				
		
		List<DetalleMoviClienProve> detallemoviclienprovesAux= new ArrayList<DetalleMoviClienProve>();
		
		for(DetalleMoviClienProve detallemoviclienprove : this.detallemoviclienproves) {
			if(detallemoviclienprove==null) {
				detallemoviclienprovesAux.add(detallemoviclienprove);
			}
		}
		
		//this.detallemoviclienproves=detallemoviclienprovesAux;
		
		this.detallemoviclienproves.removeAll(detallemoviclienprovesAux);
	}
	
	public void getSetVersionRowDetalleMoviClienProveWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detallemoviclienprove.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detallemoviclienprove.getIsDeleted() || (detallemoviclienprove.getIsChanged()&&!detallemoviclienprove.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detallemoviclienproveDataAccess.getSetVersionRowDetalleMoviClienProve(connexion,detallemoviclienprove.getId());
				
				if(!detallemoviclienprove.getVersionRow().equals(timestamp)) {	
					detallemoviclienprove.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detallemoviclienprove.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleMoviClienProve()throws Exception {	
		
		if(detallemoviclienprove.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detallemoviclienprove.getIsDeleted() || (detallemoviclienprove.getIsChanged()&&!detallemoviclienprove.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detallemoviclienproveDataAccess.getSetVersionRowDetalleMoviClienProve(connexion,detallemoviclienprove.getId());
			
			try {							
				if(!detallemoviclienprove.getVersionRow().equals(timestamp)) {	
					detallemoviclienprove.setVersionRow(timestamp);
				}
				
				detallemoviclienprove.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleMoviClienProvesWithConnection()throws Exception {	
		if(detallemoviclienproves!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleMoviClienProve detallemoviclienproveAux:detallemoviclienproves) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detallemoviclienproveAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallemoviclienproveAux.getIsDeleted() || (detallemoviclienproveAux.getIsChanged()&&!detallemoviclienproveAux.getIsNew())) {
						
						timestamp=detallemoviclienproveDataAccess.getSetVersionRowDetalleMoviClienProve(connexion,detallemoviclienproveAux.getId());
						
						if(!detallemoviclienprove.getVersionRow().equals(timestamp)) {	
							detallemoviclienproveAux.setVersionRow(timestamp);
						}
								
						detallemoviclienproveAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleMoviClienProves()throws Exception {	
		if(detallemoviclienproves!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleMoviClienProve detallemoviclienproveAux:detallemoviclienproves) {
					if(detallemoviclienproveAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallemoviclienproveAux.getIsDeleted() || (detallemoviclienproveAux.getIsChanged()&&!detallemoviclienproveAux.getIsNew())) {
						
						timestamp=detallemoviclienproveDataAccess.getSetVersionRowDetalleMoviClienProve(connexion,detallemoviclienproveAux.getId());
						
						if(!detallemoviclienproveAux.getVersionRow().equals(timestamp)) {	
							detallemoviclienproveAux.setVersionRow(timestamp);
						}
						
													
						detallemoviclienproveAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleMoviClienProveParameterReturnGeneral cargarCombosLoteForeignKeyDetalleMoviClienProveWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalModulo,String finalQueryGlobalAsientoContable,String finalQueryGlobalCliente,String finalQueryGlobalFactura,String finalQueryGlobalTransaccion,String finalQueryGlobalMoneda,String finalQueryGlobalSucursalMovimiento,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalEstadoDetalleCliente) throws Exception {
		DetalleMoviClienProveParameterReturnGeneral  detallemoviclienproveReturnGeneral =new DetalleMoviClienProveParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleMoviClienProveWithConnection");connexion.begin();
			
			detallemoviclienproveReturnGeneral =new DetalleMoviClienProveParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallemoviclienproveReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallemoviclienproveReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallemoviclienproveReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallemoviclienproveReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallemoviclienproveReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallemoviclienproveReturnGeneral.setmessForeignKey(messForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			detallemoviclienproveReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			detallemoviclienproveReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			detallemoviclienproveReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			detallemoviclienproveReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			detallemoviclienproveReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			detallemoviclienproveReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Sucursal> sucursalmovimientosForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalmovimientoLogic=new SucursalLogic();
			sucursalmovimientoLogic.setConnexion(this.connexion);
			sucursalmovimientoLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursalMovimiento.equals("NONE")) {
				sucursalmovimientoLogic.getTodosSucursals(finalQueryGlobalSucursalMovimiento,new Pagination());
				sucursalmovimientosForeignKey=sucursalmovimientoLogic.getSucursals();
			}

			detallemoviclienproveReturnGeneral.setsucursalmovimientosForeignKey(sucursalmovimientosForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			detallemoviclienproveReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<EstadoDetalleCliente> estadodetalleclientesForeignKey=new ArrayList<EstadoDetalleCliente>();
			EstadoDetalleClienteLogic estadodetalleclienteLogic=new EstadoDetalleClienteLogic();
			estadodetalleclienteLogic.setConnexion(this.connexion);
			estadodetalleclienteLogic.getEstadoDetalleClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetalleCliente.equals("NONE")) {
				estadodetalleclienteLogic.getTodosEstadoDetalleClientes(finalQueryGlobalEstadoDetalleCliente,new Pagination());
				estadodetalleclientesForeignKey=estadodetalleclienteLogic.getEstadoDetalleClientes();
			}

			detallemoviclienproveReturnGeneral.setestadodetalleclientesForeignKey(estadodetalleclientesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detallemoviclienproveReturnGeneral;
	}
	
	public DetalleMoviClienProveParameterReturnGeneral cargarCombosLoteForeignKeyDetalleMoviClienProve(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalModulo,String finalQueryGlobalAsientoContable,String finalQueryGlobalCliente,String finalQueryGlobalFactura,String finalQueryGlobalTransaccion,String finalQueryGlobalMoneda,String finalQueryGlobalSucursalMovimiento,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalEstadoDetalleCliente) throws Exception {
		DetalleMoviClienProveParameterReturnGeneral  detallemoviclienproveReturnGeneral =new DetalleMoviClienProveParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detallemoviclienproveReturnGeneral =new DetalleMoviClienProveParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallemoviclienproveReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallemoviclienproveReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallemoviclienproveReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallemoviclienproveReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallemoviclienproveReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallemoviclienproveReturnGeneral.setmessForeignKey(messForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			detallemoviclienproveReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			detallemoviclienproveReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			detallemoviclienproveReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			detallemoviclienproveReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			detallemoviclienproveReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			detallemoviclienproveReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Sucursal> sucursalmovimientosForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalmovimientoLogic=new SucursalLogic();
			sucursalmovimientoLogic.setConnexion(this.connexion);
			sucursalmovimientoLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursalMovimiento.equals("NONE")) {
				sucursalmovimientoLogic.getTodosSucursals(finalQueryGlobalSucursalMovimiento,new Pagination());
				sucursalmovimientosForeignKey=sucursalmovimientoLogic.getSucursals();
			}

			detallemoviclienproveReturnGeneral.setsucursalmovimientosForeignKey(sucursalmovimientosForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			detallemoviclienproveReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<EstadoDetalleCliente> estadodetalleclientesForeignKey=new ArrayList<EstadoDetalleCliente>();
			EstadoDetalleClienteLogic estadodetalleclienteLogic=new EstadoDetalleClienteLogic();
			estadodetalleclienteLogic.setConnexion(this.connexion);
			estadodetalleclienteLogic.getEstadoDetalleClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetalleCliente.equals("NONE")) {
				estadodetalleclienteLogic.getTodosEstadoDetalleClientes(finalQueryGlobalEstadoDetalleCliente,new Pagination());
				estadodetalleclientesForeignKey=estadodetalleclienteLogic.getEstadoDetalleClientes();
			}

			detallemoviclienproveReturnGeneral.setestadodetalleclientesForeignKey(estadodetalleclientesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detallemoviclienproveReturnGeneral;
	}
	
	
	public void deepLoad(DetalleMoviClienProve detallemoviclienprove,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleMoviClienProveLogicAdditional.updateDetalleMoviClienProveToGet(detallemoviclienprove,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallemoviclienprove.setEmpresa(detallemoviclienproveDataAccess.getEmpresa(connexion,detallemoviclienprove));
		detallemoviclienprove.setSucursal(detallemoviclienproveDataAccess.getSucursal(connexion,detallemoviclienprove));
		detallemoviclienprove.setEjercicio(detallemoviclienproveDataAccess.getEjercicio(connexion,detallemoviclienprove));
		detallemoviclienprove.setPeriodo(detallemoviclienproveDataAccess.getPeriodo(connexion,detallemoviclienprove));
		detallemoviclienprove.setAnio(detallemoviclienproveDataAccess.getAnio(connexion,detallemoviclienprove));
		detallemoviclienprove.setMes(detallemoviclienproveDataAccess.getMes(connexion,detallemoviclienprove));
		detallemoviclienprove.setModulo(detallemoviclienproveDataAccess.getModulo(connexion,detallemoviclienprove));
		detallemoviclienprove.setAsientoContable(detallemoviclienproveDataAccess.getAsientoContable(connexion,detallemoviclienprove));
		detallemoviclienprove.setCliente(detallemoviclienproveDataAccess.getCliente(connexion,detallemoviclienprove));
		detallemoviclienprove.setFactura(detallemoviclienproveDataAccess.getFactura(connexion,detallemoviclienprove));
		detallemoviclienprove.setTransaccion(detallemoviclienproveDataAccess.getTransaccion(connexion,detallemoviclienprove));
		detallemoviclienprove.setMoneda(detallemoviclienproveDataAccess.getMoneda(connexion,detallemoviclienprove));
		detallemoviclienprove.setSucursalMovimiento(detallemoviclienproveDataAccess.getSucursalMovimiento(connexion,detallemoviclienprove));
		detallemoviclienprove.setTipoTransaccionModulo(detallemoviclienproveDataAccess.getTipoTransaccionModulo(connexion,detallemoviclienprove));
		detallemoviclienprove.setEstadoDetalleCliente(detallemoviclienproveDataAccess.getEstadoDetalleCliente(connexion,detallemoviclienprove));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detallemoviclienprove.setEmpresa(detallemoviclienproveDataAccess.getEmpresa(connexion,detallemoviclienprove));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallemoviclienprove.setSucursal(detallemoviclienproveDataAccess.getSucursal(connexion,detallemoviclienprove));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallemoviclienprove.setEjercicio(detallemoviclienproveDataAccess.getEjercicio(connexion,detallemoviclienprove));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallemoviclienprove.setPeriodo(detallemoviclienproveDataAccess.getPeriodo(connexion,detallemoviclienprove));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallemoviclienprove.setAnio(detallemoviclienproveDataAccess.getAnio(connexion,detallemoviclienprove));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallemoviclienprove.setMes(detallemoviclienproveDataAccess.getMes(connexion,detallemoviclienprove));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				detallemoviclienprove.setModulo(detallemoviclienproveDataAccess.getModulo(connexion,detallemoviclienprove));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				detallemoviclienprove.setAsientoContable(detallemoviclienproveDataAccess.getAsientoContable(connexion,detallemoviclienprove));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				detallemoviclienprove.setCliente(detallemoviclienproveDataAccess.getCliente(connexion,detallemoviclienprove));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				detallemoviclienprove.setFactura(detallemoviclienproveDataAccess.getFactura(connexion,detallemoviclienprove));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				detallemoviclienprove.setTransaccion(detallemoviclienproveDataAccess.getTransaccion(connexion,detallemoviclienprove));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				detallemoviclienprove.setMoneda(detallemoviclienproveDataAccess.getMoneda(connexion,detallemoviclienprove));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallemoviclienprove.setSucursalMovimiento(detallemoviclienproveDataAccess.getSucursalMovimiento(connexion,detallemoviclienprove));
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				detallemoviclienprove.setTipoTransaccionModulo(detallemoviclienproveDataAccess.getTipoTransaccionModulo(connexion,detallemoviclienprove));
				continue;
			}

			if(clas.clas.equals(EstadoDetalleCliente.class)) {
				detallemoviclienprove.setEstadoDetalleCliente(detallemoviclienproveDataAccess.getEstadoDetalleCliente(connexion,detallemoviclienprove));
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
			detallemoviclienprove.setEmpresa(detallemoviclienproveDataAccess.getEmpresa(connexion,detallemoviclienprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setSucursal(detallemoviclienproveDataAccess.getSucursal(connexion,detallemoviclienprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setEjercicio(detallemoviclienproveDataAccess.getEjercicio(connexion,detallemoviclienprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setPeriodo(detallemoviclienproveDataAccess.getPeriodo(connexion,detallemoviclienprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setAnio(detallemoviclienproveDataAccess.getAnio(connexion,detallemoviclienprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setMes(detallemoviclienproveDataAccess.getMes(connexion,detallemoviclienprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setModulo(detallemoviclienproveDataAccess.getModulo(connexion,detallemoviclienprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setAsientoContable(detallemoviclienproveDataAccess.getAsientoContable(connexion,detallemoviclienprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setCliente(detallemoviclienproveDataAccess.getCliente(connexion,detallemoviclienprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setFactura(detallemoviclienproveDataAccess.getFactura(connexion,detallemoviclienprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setTransaccion(detallemoviclienproveDataAccess.getTransaccion(connexion,detallemoviclienprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setMoneda(detallemoviclienproveDataAccess.getMoneda(connexion,detallemoviclienprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setSucursalMovimiento(detallemoviclienproveDataAccess.getSucursalMovimiento(connexion,detallemoviclienprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setTipoTransaccionModulo(detallemoviclienproveDataAccess.getTipoTransaccionModulo(connexion,detallemoviclienprove));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetalleCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setEstadoDetalleCliente(detallemoviclienproveDataAccess.getEstadoDetalleCliente(connexion,detallemoviclienprove));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallemoviclienprove.setEmpresa(detallemoviclienproveDataAccess.getEmpresa(connexion,detallemoviclienprove));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallemoviclienprove.getEmpresa(),isDeep,deepLoadType,clases);
				
		detallemoviclienprove.setSucursal(detallemoviclienproveDataAccess.getSucursal(connexion,detallemoviclienprove));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallemoviclienprove.getSucursal(),isDeep,deepLoadType,clases);
				
		detallemoviclienprove.setEjercicio(detallemoviclienproveDataAccess.getEjercicio(connexion,detallemoviclienprove));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallemoviclienprove.getEjercicio(),isDeep,deepLoadType,clases);
				
		detallemoviclienprove.setPeriodo(detallemoviclienproveDataAccess.getPeriodo(connexion,detallemoviclienprove));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallemoviclienprove.getPeriodo(),isDeep,deepLoadType,clases);
				
		detallemoviclienprove.setAnio(detallemoviclienproveDataAccess.getAnio(connexion,detallemoviclienprove));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallemoviclienprove.getAnio(),isDeep,deepLoadType,clases);
				
		detallemoviclienprove.setMes(detallemoviclienproveDataAccess.getMes(connexion,detallemoviclienprove));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallemoviclienprove.getMes(),isDeep,deepLoadType,clases);
				
		detallemoviclienprove.setModulo(detallemoviclienproveDataAccess.getModulo(connexion,detallemoviclienprove));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(detallemoviclienprove.getModulo(),isDeep,deepLoadType,clases);
				
		detallemoviclienprove.setAsientoContable(detallemoviclienproveDataAccess.getAsientoContable(connexion,detallemoviclienprove));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(detallemoviclienprove.getAsientoContable(),isDeep,deepLoadType,clases);
				
		detallemoviclienprove.setCliente(detallemoviclienproveDataAccess.getCliente(connexion,detallemoviclienprove));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(detallemoviclienprove.getCliente(),isDeep,deepLoadType,clases);
				
		detallemoviclienprove.setFactura(detallemoviclienproveDataAccess.getFactura(connexion,detallemoviclienprove));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(detallemoviclienprove.getFactura(),isDeep,deepLoadType,clases);
				
		detallemoviclienprove.setTransaccion(detallemoviclienproveDataAccess.getTransaccion(connexion,detallemoviclienprove));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(detallemoviclienprove.getTransaccion(),isDeep,deepLoadType,clases);
				
		detallemoviclienprove.setMoneda(detallemoviclienproveDataAccess.getMoneda(connexion,detallemoviclienprove));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(detallemoviclienprove.getMoneda(),isDeep,deepLoadType,clases);
				
		detallemoviclienprove.setSucursalMovimiento(detallemoviclienproveDataAccess.getSucursalMovimiento(connexion,detallemoviclienprove));
		SucursalLogic sucursalmovimientoLogic= new SucursalLogic(connexion);
		sucursalmovimientoLogic.deepLoad(detallemoviclienprove.getSucursalMovimiento(),isDeep,deepLoadType,clases);
				
		detallemoviclienprove.setTipoTransaccionModulo(detallemoviclienproveDataAccess.getTipoTransaccionModulo(connexion,detallemoviclienprove));
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(detallemoviclienprove.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		detallemoviclienprove.setEstadoDetalleCliente(detallemoviclienproveDataAccess.getEstadoDetalleCliente(connexion,detallemoviclienprove));
		EstadoDetalleClienteLogic estadodetalleclienteLogic= new EstadoDetalleClienteLogic(connexion);
		estadodetalleclienteLogic.deepLoad(detallemoviclienprove.getEstadoDetalleCliente(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detallemoviclienprove.setEmpresa(detallemoviclienproveDataAccess.getEmpresa(connexion,detallemoviclienprove));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detallemoviclienprove.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallemoviclienprove.setSucursal(detallemoviclienproveDataAccess.getSucursal(connexion,detallemoviclienprove));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detallemoviclienprove.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallemoviclienprove.setEjercicio(detallemoviclienproveDataAccess.getEjercicio(connexion,detallemoviclienprove));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detallemoviclienprove.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallemoviclienprove.setPeriodo(detallemoviclienproveDataAccess.getPeriodo(connexion,detallemoviclienprove));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detallemoviclienprove.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallemoviclienprove.setAnio(detallemoviclienproveDataAccess.getAnio(connexion,detallemoviclienprove));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detallemoviclienprove.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallemoviclienprove.setMes(detallemoviclienproveDataAccess.getMes(connexion,detallemoviclienprove));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detallemoviclienprove.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				detallemoviclienprove.setModulo(detallemoviclienproveDataAccess.getModulo(connexion,detallemoviclienprove));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(detallemoviclienprove.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				detallemoviclienprove.setAsientoContable(detallemoviclienproveDataAccess.getAsientoContable(connexion,detallemoviclienprove));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(detallemoviclienprove.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				detallemoviclienprove.setCliente(detallemoviclienproveDataAccess.getCliente(connexion,detallemoviclienprove));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(detallemoviclienprove.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				detallemoviclienprove.setFactura(detallemoviclienproveDataAccess.getFactura(connexion,detallemoviclienprove));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(detallemoviclienprove.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				detallemoviclienprove.setTransaccion(detallemoviclienproveDataAccess.getTransaccion(connexion,detallemoviclienprove));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(detallemoviclienprove.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				detallemoviclienprove.setMoneda(detallemoviclienproveDataAccess.getMoneda(connexion,detallemoviclienprove));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(detallemoviclienprove.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallemoviclienprove.setSucursalMovimiento(detallemoviclienproveDataAccess.getSucursalMovimiento(connexion,detallemoviclienprove));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detallemoviclienprove.getSucursalMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				detallemoviclienprove.setTipoTransaccionModulo(detallemoviclienproveDataAccess.getTipoTransaccionModulo(connexion,detallemoviclienprove));
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepLoad(detallemoviclienprove.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetalleCliente.class)) {
				detallemoviclienprove.setEstadoDetalleCliente(detallemoviclienproveDataAccess.getEstadoDetalleCliente(connexion,detallemoviclienprove));
				EstadoDetalleClienteLogic estadodetalleclienteLogic= new EstadoDetalleClienteLogic(connexion);
				estadodetalleclienteLogic.deepLoad(detallemoviclienprove.getEstadoDetalleCliente(),isDeep,deepLoadType,clases);				
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
			detallemoviclienprove.setEmpresa(detallemoviclienproveDataAccess.getEmpresa(connexion,detallemoviclienprove));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detallemoviclienprove.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setSucursal(detallemoviclienproveDataAccess.getSucursal(connexion,detallemoviclienprove));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detallemoviclienprove.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setEjercicio(detallemoviclienproveDataAccess.getEjercicio(connexion,detallemoviclienprove));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detallemoviclienprove.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setPeriodo(detallemoviclienproveDataAccess.getPeriodo(connexion,detallemoviclienprove));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detallemoviclienprove.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setAnio(detallemoviclienproveDataAccess.getAnio(connexion,detallemoviclienprove));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detallemoviclienprove.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setMes(detallemoviclienproveDataAccess.getMes(connexion,detallemoviclienprove));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detallemoviclienprove.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setModulo(detallemoviclienproveDataAccess.getModulo(connexion,detallemoviclienprove));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(detallemoviclienprove.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setAsientoContable(detallemoviclienproveDataAccess.getAsientoContable(connexion,detallemoviclienprove));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(detallemoviclienprove.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setCliente(detallemoviclienproveDataAccess.getCliente(connexion,detallemoviclienprove));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(detallemoviclienprove.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setFactura(detallemoviclienproveDataAccess.getFactura(connexion,detallemoviclienprove));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(detallemoviclienprove.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setTransaccion(detallemoviclienproveDataAccess.getTransaccion(connexion,detallemoviclienprove));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(detallemoviclienprove.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setMoneda(detallemoviclienproveDataAccess.getMoneda(connexion,detallemoviclienprove));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(detallemoviclienprove.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setSucursalMovimiento(detallemoviclienproveDataAccess.getSucursalMovimiento(connexion,detallemoviclienprove));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detallemoviclienprove.getSucursalMovimiento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setTipoTransaccionModulo(detallemoviclienproveDataAccess.getTipoTransaccionModulo(connexion,detallemoviclienprove));
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
			tipotransaccionmoduloLogic.deepLoad(detallemoviclienprove.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetalleCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemoviclienprove.setEstadoDetalleCliente(detallemoviclienproveDataAccess.getEstadoDetalleCliente(connexion,detallemoviclienprove));
			EstadoDetalleClienteLogic estadodetalleclienteLogic= new EstadoDetalleClienteLogic(connexion);
			estadodetalleclienteLogic.deepLoad(detallemoviclienprove.getEstadoDetalleCliente(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleMoviClienProve detallemoviclienprove,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleMoviClienProveLogicAdditional.updateDetalleMoviClienProveToSave(detallemoviclienprove,this.arrDatoGeneral);
			
DetalleMoviClienProveDataAccess.save(detallemoviclienprove, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detallemoviclienprove.getEmpresa(),connexion);

		SucursalDataAccess.save(detallemoviclienprove.getSucursal(),connexion);

		EjercicioDataAccess.save(detallemoviclienprove.getEjercicio(),connexion);

		PeriodoDataAccess.save(detallemoviclienprove.getPeriodo(),connexion);

		AnioDataAccess.save(detallemoviclienprove.getAnio(),connexion);

		MesDataAccess.save(detallemoviclienprove.getMes(),connexion);

		ModuloDataAccess.save(detallemoviclienprove.getModulo(),connexion);

		AsientoContableDataAccess.save(detallemoviclienprove.getAsientoContable(),connexion);

		ClienteDataAccess.save(detallemoviclienprove.getCliente(),connexion);

		FacturaDataAccess.save(detallemoviclienprove.getFactura(),connexion);

		TransaccionDataAccess.save(detallemoviclienprove.getTransaccion(),connexion);

		MonedaDataAccess.save(detallemoviclienprove.getMoneda(),connexion);

		SucursalDataAccess.save(detallemoviclienprove.getSucursalMovimiento(),connexion);

		TipoTransaccionModuloDataAccess.save(detallemoviclienprove.getTipoTransaccionModulo(),connexion);

		EstadoDetalleClienteDataAccess.save(detallemoviclienprove.getEstadoDetalleCliente(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallemoviclienprove.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallemoviclienprove.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallemoviclienprove.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallemoviclienprove.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallemoviclienprove.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallemoviclienprove.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(detallemoviclienprove.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(detallemoviclienprove.getAsientoContable(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(detallemoviclienprove.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(detallemoviclienprove.getFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(detallemoviclienprove.getTransaccion(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(detallemoviclienprove.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallemoviclienprove.getSucursalMovimiento(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(detallemoviclienprove.getTipoTransaccionModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoDetalleCliente.class)) {
				EstadoDetalleClienteDataAccess.save(detallemoviclienprove.getEstadoDetalleCliente(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detallemoviclienprove.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallemoviclienprove.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detallemoviclienprove.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallemoviclienprove.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detallemoviclienprove.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallemoviclienprove.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detallemoviclienprove.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallemoviclienprove.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detallemoviclienprove.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallemoviclienprove.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detallemoviclienprove.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallemoviclienprove.getMes(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(detallemoviclienprove.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(detallemoviclienprove.getModulo(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(detallemoviclienprove.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(detallemoviclienprove.getAsientoContable(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(detallemoviclienprove.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(detallemoviclienprove.getCliente(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(detallemoviclienprove.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(detallemoviclienprove.getFactura(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(detallemoviclienprove.getTransaccion(),connexion);
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(detallemoviclienprove.getTransaccion(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(detallemoviclienprove.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(detallemoviclienprove.getMoneda(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detallemoviclienprove.getSucursalMovimiento(),connexion);
		SucursalLogic sucursalmovimientoLogic= new SucursalLogic(connexion);
		sucursalmovimientoLogic.deepLoad(detallemoviclienprove.getSucursalMovimiento(),isDeep,deepLoadType,clases);
				

		TipoTransaccionModuloDataAccess.save(detallemoviclienprove.getTipoTransaccionModulo(),connexion);
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(detallemoviclienprove.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				

		EstadoDetalleClienteDataAccess.save(detallemoviclienprove.getEstadoDetalleCliente(),connexion);
		EstadoDetalleClienteLogic estadodetalleclienteLogic= new EstadoDetalleClienteLogic(connexion);
		estadodetalleclienteLogic.deepLoad(detallemoviclienprove.getEstadoDetalleCliente(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallemoviclienprove.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detallemoviclienprove.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallemoviclienprove.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detallemoviclienprove.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallemoviclienprove.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detallemoviclienprove.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallemoviclienprove.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detallemoviclienprove.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallemoviclienprove.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detallemoviclienprove.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallemoviclienprove.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detallemoviclienprove.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(detallemoviclienprove.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(detallemoviclienprove.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(detallemoviclienprove.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(detallemoviclienprove.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(detallemoviclienprove.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(detallemoviclienprove.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(detallemoviclienprove.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(detallemoviclienprove.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(detallemoviclienprove.getTransaccion(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(detallemoviclienprove.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(detallemoviclienprove.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(detallemoviclienprove.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallemoviclienprove.getSucursalMovimiento(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detallemoviclienprove.getSucursalMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(detallemoviclienprove.getTipoTransaccionModulo(),connexion);
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepSave(detallemoviclienprove.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetalleCliente.class)) {
				EstadoDetalleClienteDataAccess.save(detallemoviclienprove.getEstadoDetalleCliente(),connexion);
				EstadoDetalleClienteLogic estadodetalleclienteLogic= new EstadoDetalleClienteLogic(connexion);
				estadodetalleclienteLogic.deepSave(detallemoviclienprove.getEstadoDetalleCliente(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleMoviClienProve.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detallemoviclienprove,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(detallemoviclienprove);
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
			this.deepLoad(this.detallemoviclienprove,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienprove);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleMoviClienProve.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detallemoviclienproves!=null) {
				for(DetalleMoviClienProve detallemoviclienprove:detallemoviclienproves) {
					this.deepLoad(detallemoviclienprove,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(detallemoviclienproves);
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
			if(detallemoviclienproves!=null) {
				for(DetalleMoviClienProve detallemoviclienprove:detallemoviclienproves) {
					this.deepLoad(detallemoviclienprove,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(detallemoviclienproves);
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
			this.getNewConnexionToDeep(DetalleMoviClienProve.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detallemoviclienprove,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleMoviClienProve.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detallemoviclienproves!=null) {
				for(DetalleMoviClienProve detallemoviclienprove:detallemoviclienproves) {
					this.deepSave(detallemoviclienprove,isDeep,deepLoadType,clases);
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
			if(detallemoviclienproves!=null) {
				for(DetalleMoviClienProve detallemoviclienprove:detallemoviclienproves) {
					this.deepSave(detallemoviclienprove,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleMoviClienProvesFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleMoviClienProveConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMoviClienProvesFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleMoviClienProveConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMoviClienProvesFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,DetalleMoviClienProveConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMoviClienProvesFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,DetalleMoviClienProveConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMoviClienProvesFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,DetalleMoviClienProveConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMoviClienProvesFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,DetalleMoviClienProveConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMoviClienProvesFK_IdDetalleMoviClienProveWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal_movimiento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursalMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursalMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal_movimiento,DetalleMoviClienProveConstantesFunciones.IDSUCURSALMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursalMovimiento);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleMoviClienProve","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMoviClienProvesFK_IdDetalleMoviClienProve(String sFinalQuery,Pagination pagination,Long id_sucursal_movimiento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursalMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursalMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal_movimiento,DetalleMoviClienProveConstantesFunciones.IDSUCURSALMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursalMovimiento);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleMoviClienProve","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMoviClienProvesFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleMoviClienProveConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMoviClienProvesFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleMoviClienProveConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMoviClienProvesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleMoviClienProveConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMoviClienProvesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleMoviClienProveConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMoviClienProvesFK_IdEstadoDetalleClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_detalle_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetalleCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetalleCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_cliente,DetalleMoviClienProveConstantesFunciones.IDESTADODETALLECLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetalleCliente);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetalleCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMoviClienProvesFK_IdEstadoDetalleCliente(String sFinalQuery,Pagination pagination,Long id_estado_detalle_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetalleCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetalleCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_cliente,DetalleMoviClienProveConstantesFunciones.IDESTADODETALLECLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetalleCliente);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetalleCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMoviClienProvesFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,DetalleMoviClienProveConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMoviClienProvesFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,DetalleMoviClienProveConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMoviClienProvesFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleMoviClienProveConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMoviClienProvesFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleMoviClienProveConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMoviClienProvesFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,DetalleMoviClienProveConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMoviClienProvesFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,DetalleMoviClienProveConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMoviClienProvesFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,DetalleMoviClienProveConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMoviClienProvesFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,DetalleMoviClienProveConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMoviClienProvesFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleMoviClienProveConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMoviClienProvesFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleMoviClienProveConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMoviClienProvesFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleMoviClienProveConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMoviClienProvesFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleMoviClienProveConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMoviClienProvesFK_IdTipoTransaccionModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,DetalleMoviClienProveConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMoviClienProvesFK_IdTipoTransaccionModulo(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,DetalleMoviClienProveConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMoviClienProvesFK_IdTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMoviClienProve.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,DetalleMoviClienProveConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMoviClienProvesFK_IdTransaccion(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,DetalleMoviClienProveConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			DetalleMoviClienProveLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(this.detallemoviclienproves);
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
			if(DetalleMoviClienProveConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleMoviClienProveDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleMoviClienProve detallemoviclienprove,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleMoviClienProveConstantesFunciones.ISCONAUDITORIA) {
				if(detallemoviclienprove.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleMoviClienProveDataAccess.TABLENAME, detallemoviclienprove.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleMoviClienProveConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleMoviClienProveLogic.registrarAuditoriaDetallesDetalleMoviClienProve(connexion,detallemoviclienprove,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detallemoviclienprove.getIsDeleted()) {
					/*if(!detallemoviclienprove.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleMoviClienProveDataAccess.TABLENAME, detallemoviclienprove.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleMoviClienProveLogic.registrarAuditoriaDetallesDetalleMoviClienProve(connexion,detallemoviclienprove,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleMoviClienProveDataAccess.TABLENAME, detallemoviclienprove.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detallemoviclienprove.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleMoviClienProveDataAccess.TABLENAME, detallemoviclienprove.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleMoviClienProveConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleMoviClienProveLogic.registrarAuditoriaDetallesDetalleMoviClienProve(connexion,detallemoviclienprove,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleMoviClienProve(Connexion connexion,DetalleMoviClienProve detallemoviclienprove)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getid_empresa().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_empresa()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_empresa().toString();
				}
				if(detallemoviclienprove.getid_empresa()!=null)
				{
					strValorNuevo=detallemoviclienprove.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getid_sucursal().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_sucursal()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_sucursal().toString();
				}
				if(detallemoviclienprove.getid_sucursal()!=null)
				{
					strValorNuevo=detallemoviclienprove.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getid_ejercicio().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_ejercicio().toString();
				}
				if(detallemoviclienprove.getid_ejercicio()!=null)
				{
					strValorNuevo=detallemoviclienprove.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getid_periodo().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_periodo()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_periodo().toString();
				}
				if(detallemoviclienprove.getid_periodo()!=null)
				{
					strValorNuevo=detallemoviclienprove.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getid_anio().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_anio()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_anio().toString();
				}
				if(detallemoviclienprove.getid_anio()!=null)
				{
					strValorNuevo=detallemoviclienprove.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getid_mes().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_mes()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_mes().toString();
				}
				if(detallemoviclienprove.getid_mes()!=null)
				{
					strValorNuevo=detallemoviclienprove.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getid_modulo().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_modulo()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_modulo().toString();
				}
				if(detallemoviclienprove.getid_modulo()!=null)
				{
					strValorNuevo=detallemoviclienprove.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getid_asiento_contable().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_asiento_contable().toString();
				}
				if(detallemoviclienprove.getid_asiento_contable()!=null)
				{
					strValorNuevo=detallemoviclienprove.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getfecha_vence().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getfecha_vence()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getfecha_vence()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getfecha_vence().toString();
				}
				if(detallemoviclienprove.getfecha_vence()!=null)
				{
					strValorNuevo=detallemoviclienprove.getfecha_vence().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.FECHAVENCE,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getid_cliente().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_cliente()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_cliente().toString();
				}
				if(detallemoviclienprove.getid_cliente()!=null)
				{
					strValorNuevo=detallemoviclienprove.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getid_factura().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_factura()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_factura().toString();
				}
				if(detallemoviclienprove.getid_factura()!=null)
				{
					strValorNuevo=detallemoviclienprove.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getnumero_factura().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getnumero_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getnumero_factura()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getnumero_factura();
				}
				if(detallemoviclienprove.getnumero_factura()!=null)
				{
					strValorNuevo=detallemoviclienprove.getnumero_factura() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.NUMEROFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getid_transaccion().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_transaccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_transaccion()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_transaccion().toString();
				}
				if(detallemoviclienprove.getid_transaccion()!=null)
				{
					strValorNuevo=detallemoviclienprove.getid_transaccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.IDTRANSACCION,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getdebito_mone_local().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getdebito_mone_local()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getdebito_mone_local()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getdebito_mone_local().toString();
				}
				if(detallemoviclienprove.getdebito_mone_local()!=null)
				{
					strValorNuevo=detallemoviclienprove.getdebito_mone_local().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.DEBITOMONELOCAL,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getcredito_mone_local().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getcredito_mone_local()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getcredito_mone_local()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getcredito_mone_local().toString();
				}
				if(detallemoviclienprove.getcredito_mone_local()!=null)
				{
					strValorNuevo=detallemoviclienprove.getcredito_mone_local().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.CREDITOMONELOCAL,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getdebito_mone_extra().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getdebito_mone_extra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getdebito_mone_extra()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getdebito_mone_extra().toString();
				}
				if(detallemoviclienprove.getdebito_mone_extra()!=null)
				{
					strValorNuevo=detallemoviclienprove.getdebito_mone_extra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.DEBITOMONEEXTRA,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getcredito_mone_extra().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getcredito_mone_extra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getcredito_mone_extra()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getcredito_mone_extra().toString();
				}
				if(detallemoviclienprove.getcredito_mone_extra()!=null)
				{
					strValorNuevo=detallemoviclienprove.getcredito_mone_extra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.CREDITOMONEEXTRA,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getid_moneda().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_moneda()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_moneda().toString();
				}
				if(detallemoviclienprove.getid_moneda()!=null)
				{
					strValorNuevo=detallemoviclienprove.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getcotizacion().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getcotizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getcotizacion()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getcotizacion().toString();
				}
				if(detallemoviclienprove.getcotizacion()!=null)
				{
					strValorNuevo=detallemoviclienprove.getcotizacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.COTIZACION,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getdescripcion().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getdescripcion()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getdescripcion();
				}
				if(detallemoviclienprove.getdescripcion()!=null)
				{
					strValorNuevo=detallemoviclienprove.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getid_sucursal_movimiento().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_sucursal_movimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_sucursal_movimiento()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_sucursal_movimiento().toString();
				}
				if(detallemoviclienprove.getid_sucursal_movimiento()!=null)
				{
					strValorNuevo=detallemoviclienprove.getid_sucursal_movimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.IDSUCURSALMOVIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getid_tipo_transaccion_modulo().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_tipo_transaccion_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_tipo_transaccion_modulo()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_tipo_transaccion_modulo().toString();
				}
				if(detallemoviclienprove.getid_tipo_transaccion_modulo()!=null)
				{
					strValorNuevo=detallemoviclienprove.getid_tipo_transaccion_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.IDTIPOTRANSACCIONMODULO,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getid_estado_detalle_cliente().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_estado_detalle_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_estado_detalle_cliente()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getid_estado_detalle_cliente().toString();
				}
				if(detallemoviclienprove.getid_estado_detalle_cliente()!=null)
				{
					strValorNuevo=detallemoviclienprove.getid_estado_detalle_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.IDESTADODETALLECLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getfecha_emision().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getfecha_emision()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getfecha_emision().toString();
				}
				if(detallemoviclienprove.getfecha_emision()!=null)
				{
					strValorNuevo=detallemoviclienprove.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getmonto_mone_local().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getmonto_mone_local()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getmonto_mone_local()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getmonto_mone_local().toString();
				}
				if(detallemoviclienprove.getmonto_mone_local()!=null)
				{
					strValorNuevo=detallemoviclienprove.getmonto_mone_local().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.MONTOMONELOCAL,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getmonto_mone_extra().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getmonto_mone_extra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getmonto_mone_extra()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getmonto_mone_extra().toString();
				}
				if(detallemoviclienprove.getmonto_mone_extra()!=null)
				{
					strValorNuevo=detallemoviclienprove.getmonto_mone_extra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.MONTOMONEEXTRA,strValorActual,strValorNuevo);
			}	
			
			if(detallemoviclienprove.getIsNew()||!detallemoviclienprove.getnumero_comprobante().equals(detallemoviclienprove.getDetalleMoviClienProveOriginal().getnumero_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemoviclienprove.getDetalleMoviClienProveOriginal().getnumero_comprobante()!=null)
				{
					strValorActual=detallemoviclienprove.getDetalleMoviClienProveOriginal().getnumero_comprobante();
				}
				if(detallemoviclienprove.getnumero_comprobante()!=null)
				{
					strValorNuevo=detallemoviclienprove.getnumero_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMoviClienProveConstantesFunciones.NUMEROCOMPROBANTE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleMoviClienProveRelacionesWithConnection(DetalleMoviClienProve detallemoviclienprove) throws Exception {

		if(!detallemoviclienprove.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleMoviClienProveRelacionesBase(detallemoviclienprove,true);
		}
	}

	public void saveDetalleMoviClienProveRelaciones(DetalleMoviClienProve detallemoviclienprove)throws Exception {

		if(!detallemoviclienprove.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleMoviClienProveRelacionesBase(detallemoviclienprove,false);
		}
	}

	public void saveDetalleMoviClienProveRelacionesBase(DetalleMoviClienProve detallemoviclienprove,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleMoviClienProve-saveRelacionesWithConnection");}
	

			this.setDetalleMoviClienProve(detallemoviclienprove);

			if(DetalleMoviClienProveLogicAdditional.validarSaveRelaciones(detallemoviclienprove,this)) {

				DetalleMoviClienProveLogicAdditional.updateRelacionesToSave(detallemoviclienprove,this);

				if((detallemoviclienprove.getIsNew()||detallemoviclienprove.getIsChanged())&&!detallemoviclienprove.getIsDeleted()) {
					this.saveDetalleMoviClienProve();
					this.saveDetalleMoviClienProveRelacionesDetalles();

				} else if(detallemoviclienprove.getIsDeleted()) {
					this.saveDetalleMoviClienProveRelacionesDetalles();
					this.saveDetalleMoviClienProve();
				}

				DetalleMoviClienProveLogicAdditional.updateRelacionesToSaveAfter(detallemoviclienprove,this);

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
	
	
	private void saveDetalleMoviClienProveRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleMoviClienProve(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleMoviClienProveConstantesFunciones.getClassesForeignKeysOfDetalleMoviClienProve(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleMoviClienProve(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleMoviClienProveConstantesFunciones.getClassesRelationshipsOfDetalleMoviClienProve(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

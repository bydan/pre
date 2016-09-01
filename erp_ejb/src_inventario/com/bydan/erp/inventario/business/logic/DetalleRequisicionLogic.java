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
import com.bydan.erp.inventario.util.DetalleRequisicionConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleRequisicionParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleRequisicionParameterGeneral;
import com.bydan.erp.inventario.business.entity.DetalleRequisicion;
import com.bydan.erp.inventario.business.logic.DetalleRequisicionLogicAdditional;
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
public class DetalleRequisicionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleRequisicionLogic.class);
	
	protected DetalleRequisicionDataAccess detallerequisicionDataAccess; 	
	protected DetalleRequisicion detallerequisicion;
	protected List<DetalleRequisicion> detallerequisicions;
	protected Object detallerequisicionObject;	
	protected List<Object> detallerequisicionsObject;
	
	public static ClassValidator<DetalleRequisicion> detallerequisicionValidator = new ClassValidator<DetalleRequisicion>(DetalleRequisicion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleRequisicionLogicAdditional detallerequisicionLogicAdditional=null;
	
	public DetalleRequisicionLogicAdditional getDetalleRequisicionLogicAdditional() {
		return this.detallerequisicionLogicAdditional;
	}
	
	public void setDetalleRequisicionLogicAdditional(DetalleRequisicionLogicAdditional detallerequisicionLogicAdditional) {
		try {
			this.detallerequisicionLogicAdditional=detallerequisicionLogicAdditional;
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
	
	
	
	
	public  DetalleRequisicionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detallerequisicionDataAccess = new DetalleRequisicionDataAccess();
			
			this.detallerequisicions= new ArrayList<DetalleRequisicion>();
			this.detallerequisicion= new DetalleRequisicion();
			
			this.detallerequisicionObject=new Object();
			this.detallerequisicionsObject=new ArrayList<Object>();
				
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
			
			this.detallerequisicionDataAccess.setConnexionType(this.connexionType);
			this.detallerequisicionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleRequisicionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detallerequisicionDataAccess = new DetalleRequisicionDataAccess();
			this.detallerequisicions= new ArrayList<DetalleRequisicion>();
			this.detallerequisicion= new DetalleRequisicion();
			this.detallerequisicionObject=new Object();
			this.detallerequisicionsObject=new ArrayList<Object>();
			
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
			
			this.detallerequisicionDataAccess.setConnexionType(this.connexionType);
			this.detallerequisicionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleRequisicion getDetalleRequisicion() throws Exception {	
		DetalleRequisicionLogicAdditional.checkDetalleRequisicionToGet(detallerequisicion,this.datosCliente,this.arrDatoGeneral);
		DetalleRequisicionLogicAdditional.updateDetalleRequisicionToGet(detallerequisicion,this.arrDatoGeneral);
		
		return detallerequisicion;
	}
		
	public void setDetalleRequisicion(DetalleRequisicion newDetalleRequisicion) {
		this.detallerequisicion = newDetalleRequisicion;
	}
	
	public DetalleRequisicionDataAccess getDetalleRequisicionDataAccess() {
		return detallerequisicionDataAccess;
	}
	
	public void setDetalleRequisicionDataAccess(DetalleRequisicionDataAccess newdetallerequisicionDataAccess) {
		this.detallerequisicionDataAccess = newdetallerequisicionDataAccess;
	}
	
	public List<DetalleRequisicion> getDetalleRequisicions() throws Exception {		
		this.quitarDetalleRequisicionsNulos();
		
		DetalleRequisicionLogicAdditional.checkDetalleRequisicionToGets(detallerequisicions,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleRequisicion detallerequisicionLocal: detallerequisicions ) {
			DetalleRequisicionLogicAdditional.updateDetalleRequisicionToGet(detallerequisicionLocal,this.arrDatoGeneral);
		}
		
		return detallerequisicions;
	}
	
	public void setDetalleRequisicions(List<DetalleRequisicion> newDetalleRequisicions) {
		this.detallerequisicions = newDetalleRequisicions;
	}
	
	public Object getDetalleRequisicionObject() {	
		this.detallerequisicionObject=this.detallerequisicionDataAccess.getEntityObject();
		return this.detallerequisicionObject;
	}
		
	public void setDetalleRequisicionObject(Object newDetalleRequisicionObject) {
		this.detallerequisicionObject = newDetalleRequisicionObject;
	}
	
	public List<Object> getDetalleRequisicionsObject() {		
		this.detallerequisicionsObject=this.detallerequisicionDataAccess.getEntitiesObject();
		return this.detallerequisicionsObject;
	}
		
	public void setDetalleRequisicionsObject(List<Object> newDetalleRequisicionsObject) {
		this.detallerequisicionsObject = newDetalleRequisicionsObject;
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
		
		if(this.detallerequisicionDataAccess!=null) {
			this.detallerequisicionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detallerequisicionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detallerequisicionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detallerequisicion = new  DetalleRequisicion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallerequisicion=detallerequisicionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallerequisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicion);
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
		detallerequisicion = new  DetalleRequisicion();
		  		  
        try {
			
			detallerequisicion=detallerequisicionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallerequisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detallerequisicion = new  DetalleRequisicion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallerequisicion=detallerequisicionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallerequisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicion);
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
		detallerequisicion = new  DetalleRequisicion();
		  		  
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
		detallerequisicion = new  DetalleRequisicion();
		  		  
        try {
			
			detallerequisicion=detallerequisicionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallerequisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detallerequisicion = new  DetalleRequisicion();
		  		  
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
		detallerequisicion = new  DetalleRequisicion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detallerequisicionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallerequisicion = new  DetalleRequisicion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detallerequisicionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallerequisicion = new  DetalleRequisicion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detallerequisicionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallerequisicion = new  DetalleRequisicion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detallerequisicionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallerequisicion = new  DetalleRequisicion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detallerequisicionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallerequisicion = new  DetalleRequisicion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detallerequisicionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallerequisicions = new  ArrayList<DetalleRequisicion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleRequisicion(detallerequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
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
		detallerequisicions = new  ArrayList<DetalleRequisicion>();
		  		  
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
		detallerequisicions = new  ArrayList<DetalleRequisicion>();
		  		  
        try {			
			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleRequisicion(detallerequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detallerequisicions = new  ArrayList<DetalleRequisicion>();
		  		  
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
		detallerequisicions = new  ArrayList<DetalleRequisicion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleRequisicion(detallerequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
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
		detallerequisicions = new  ArrayList<DetalleRequisicion>();
		  		  
        try {
			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleRequisicion(detallerequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
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
		detallerequisicions = new  ArrayList<DetalleRequisicion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleRequisicion(detallerequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
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
		detallerequisicions = new  ArrayList<DetalleRequisicion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleRequisicion(detallerequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detallerequisicion = new  DetalleRequisicion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicion=detallerequisicionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleRequisicion(detallerequisicion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicion);
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
		detallerequisicion = new  DetalleRequisicion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicion=detallerequisicionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleRequisicion(detallerequisicion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallerequisicions = new  ArrayList<DetalleRequisicion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicions=detallerequisicionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleRequisicion(detallerequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
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
		detallerequisicions = new  ArrayList<DetalleRequisicion>();
		  		  
        try {
			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicions=detallerequisicionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleRequisicion(detallerequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleRequisicionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detallerequisicions = new  ArrayList<DetalleRequisicion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-getTodosDetalleRequisicionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleRequisicion(detallerequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
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
	
	public  void  getTodosDetalleRequisicions(String sFinalQuery,Pagination pagination)throws Exception {
		detallerequisicions = new  ArrayList<DetalleRequisicion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleRequisicion(detallerequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleRequisicion(DetalleRequisicion detallerequisicion) throws Exception {
		Boolean estaValidado=false;
		
		if(detallerequisicion.getIsNew() || detallerequisicion.getIsChanged()) { 
			this.invalidValues = detallerequisicionValidator.getInvalidValues(detallerequisicion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detallerequisicion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleRequisicion(List<DetalleRequisicion> DetalleRequisicions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleRequisicion detallerequisicionLocal:detallerequisicions) {				
			estaValidadoObjeto=this.validarGuardarDetalleRequisicion(detallerequisicionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleRequisicion(List<DetalleRequisicion> DetalleRequisicions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleRequisicion(detallerequisicions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleRequisicion(DetalleRequisicion DetalleRequisicion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleRequisicion(detallerequisicion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleRequisicion detallerequisicion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detallerequisicion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleRequisicionConstantesFunciones.getDetalleRequisicionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detallerequisicion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleRequisicionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleRequisicionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleRequisicionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-saveDetalleRequisicionWithConnection");connexion.begin();			
			
			DetalleRequisicionLogicAdditional.checkDetalleRequisicionToSave(this.detallerequisicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleRequisicionLogicAdditional.updateDetalleRequisicionToSave(this.detallerequisicion,this.arrDatoGeneral);
			
			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallerequisicion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleRequisicion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleRequisicion(this.detallerequisicion)) {
				DetalleRequisicionDataAccess.save(this.detallerequisicion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detallerequisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleRequisicionLogicAdditional.checkDetalleRequisicionToSaveAfter(this.detallerequisicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleRequisicion();
			
			connexion.commit();			
			
			if(this.detallerequisicion.getIsDeleted()) {
				this.detallerequisicion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleRequisicion()throws Exception {	
		try {	
			
			DetalleRequisicionLogicAdditional.checkDetalleRequisicionToSave(this.detallerequisicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleRequisicionLogicAdditional.updateDetalleRequisicionToSave(this.detallerequisicion,this.arrDatoGeneral);
			
			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallerequisicion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleRequisicion(this.detallerequisicion)) {			
				DetalleRequisicionDataAccess.save(this.detallerequisicion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detallerequisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleRequisicionLogicAdditional.checkDetalleRequisicionToSaveAfter(this.detallerequisicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detallerequisicion.getIsDeleted()) {
				this.detallerequisicion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleRequisicionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-saveDetalleRequisicionsWithConnection");connexion.begin();			
			
			DetalleRequisicionLogicAdditional.checkDetalleRequisicionToSaves(detallerequisicions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleRequisicions();
			
			Boolean validadoTodosDetalleRequisicion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleRequisicion detallerequisicionLocal:detallerequisicions) {		
				if(detallerequisicionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleRequisicionLogicAdditional.updateDetalleRequisicionToSave(detallerequisicionLocal,this.arrDatoGeneral);
	        	
				DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallerequisicionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleRequisicion(detallerequisicionLocal)) {
					DetalleRequisicionDataAccess.save(detallerequisicionLocal, connexion);				
				} else {
					validadoTodosDetalleRequisicion=false;
				}
			}
			
			if(!validadoTodosDetalleRequisicion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleRequisicionLogicAdditional.checkDetalleRequisicionToSavesAfter(detallerequisicions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleRequisicions();
			
			connexion.commit();		
			
			this.quitarDetalleRequisicionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleRequisicions()throws Exception {				
		 try {	
			DetalleRequisicionLogicAdditional.checkDetalleRequisicionToSaves(detallerequisicions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleRequisicion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleRequisicion detallerequisicionLocal:detallerequisicions) {				
				if(detallerequisicionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleRequisicionLogicAdditional.updateDetalleRequisicionToSave(detallerequisicionLocal,this.arrDatoGeneral);
	        	
				DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallerequisicionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleRequisicion(detallerequisicionLocal)) {				
					DetalleRequisicionDataAccess.save(detallerequisicionLocal, connexion);				
				} else {
					validadoTodosDetalleRequisicion=false;
				}
			}
			
			if(!validadoTodosDetalleRequisicion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleRequisicionLogicAdditional.checkDetalleRequisicionToSavesAfter(detallerequisicions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleRequisicionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleRequisicionParameterReturnGeneral procesarAccionDetalleRequisicions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleRequisicion> detallerequisicions,DetalleRequisicionParameterReturnGeneral detallerequisicionParameterGeneral)throws Exception {
		 try {	
			DetalleRequisicionParameterReturnGeneral detallerequisicionReturnGeneral=new DetalleRequisicionParameterReturnGeneral();
	
			DetalleRequisicionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallerequisicions,detallerequisicionParameterGeneral,detallerequisicionReturnGeneral);
			
			return detallerequisicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleRequisicionParameterReturnGeneral procesarAccionDetalleRequisicionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleRequisicion> detallerequisicions,DetalleRequisicionParameterReturnGeneral detallerequisicionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-procesarAccionDetalleRequisicionsWithConnection");connexion.begin();			
			
			DetalleRequisicionParameterReturnGeneral detallerequisicionReturnGeneral=new DetalleRequisicionParameterReturnGeneral();
	
			DetalleRequisicionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallerequisicions,detallerequisicionParameterGeneral,detallerequisicionReturnGeneral);
			
			this.connexion.commit();
			
			return detallerequisicionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleRequisicionParameterReturnGeneral procesarEventosDetalleRequisicions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleRequisicion> detallerequisicions,DetalleRequisicion detallerequisicion,DetalleRequisicionParameterReturnGeneral detallerequisicionParameterGeneral,Boolean isEsNuevoDetalleRequisicion,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleRequisicionParameterReturnGeneral detallerequisicionReturnGeneral=new DetalleRequisicionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallerequisicionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleRequisicionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallerequisicions,detallerequisicion,detallerequisicionParameterGeneral,detallerequisicionReturnGeneral,isEsNuevoDetalleRequisicion,clases);
			
			return detallerequisicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleRequisicionParameterReturnGeneral procesarEventosDetalleRequisicionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleRequisicion> detallerequisicions,DetalleRequisicion detallerequisicion,DetalleRequisicionParameterReturnGeneral detallerequisicionParameterGeneral,Boolean isEsNuevoDetalleRequisicion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-procesarEventosDetalleRequisicionsWithConnection");connexion.begin();			
			
			DetalleRequisicionParameterReturnGeneral detallerequisicionReturnGeneral=new DetalleRequisicionParameterReturnGeneral();
	
			detallerequisicionReturnGeneral.setDetalleRequisicion(detallerequisicion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallerequisicionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleRequisicionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallerequisicions,detallerequisicion,detallerequisicionParameterGeneral,detallerequisicionReturnGeneral,isEsNuevoDetalleRequisicion,clases);
			
			this.connexion.commit();
			
			return detallerequisicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleRequisicionParameterReturnGeneral procesarImportacionDetalleRequisicionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleRequisicionParameterReturnGeneral detallerequisicionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-procesarImportacionDetalleRequisicionsWithConnection");connexion.begin();			
			
			DetalleRequisicionParameterReturnGeneral detallerequisicionReturnGeneral=new DetalleRequisicionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detallerequisicions=new ArrayList<DetalleRequisicion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detallerequisicion=new DetalleRequisicion();
				
				
				if(conColumnasBase) {this.detallerequisicion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detallerequisicion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detallerequisicion.setcantidad(Long.parseLong(arrColumnas[iColumn++]));
				this.detallerequisicion.setdescripcion(arrColumnas[iColumn++]);
				
				this.detallerequisicions.add(this.detallerequisicion);
			}
			
			this.saveDetalleRequisicions();
			
			this.connexion.commit();
			
			detallerequisicionReturnGeneral.setConRetornoEstaProcesado(true);
			detallerequisicionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detallerequisicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleRequisicionsEliminados() throws Exception {				
		
		List<DetalleRequisicion> detallerequisicionsAux= new ArrayList<DetalleRequisicion>();
		
		for(DetalleRequisicion detallerequisicion:detallerequisicions) {
			if(!detallerequisicion.getIsDeleted()) {
				detallerequisicionsAux.add(detallerequisicion);
			}
		}
		
		detallerequisicions=detallerequisicionsAux;
	}
	
	public void quitarDetalleRequisicionsNulos() throws Exception {				
		
		List<DetalleRequisicion> detallerequisicionsAux= new ArrayList<DetalleRequisicion>();
		
		for(DetalleRequisicion detallerequisicion : this.detallerequisicions) {
			if(detallerequisicion==null) {
				detallerequisicionsAux.add(detallerequisicion);
			}
		}
		
		//this.detallerequisicions=detallerequisicionsAux;
		
		this.detallerequisicions.removeAll(detallerequisicionsAux);
	}
	
	public void getSetVersionRowDetalleRequisicionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detallerequisicion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detallerequisicion.getIsDeleted() || (detallerequisicion.getIsChanged()&&!detallerequisicion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detallerequisicionDataAccess.getSetVersionRowDetalleRequisicion(connexion,detallerequisicion.getId());
				
				if(!detallerequisicion.getVersionRow().equals(timestamp)) {	
					detallerequisicion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detallerequisicion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleRequisicion()throws Exception {	
		
		if(detallerequisicion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detallerequisicion.getIsDeleted() || (detallerequisicion.getIsChanged()&&!detallerequisicion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detallerequisicionDataAccess.getSetVersionRowDetalleRequisicion(connexion,detallerequisicion.getId());
			
			try {							
				if(!detallerequisicion.getVersionRow().equals(timestamp)) {	
					detallerequisicion.setVersionRow(timestamp);
				}
				
				detallerequisicion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleRequisicionsWithConnection()throws Exception {	
		if(detallerequisicions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleRequisicion detallerequisicionAux:detallerequisicions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detallerequisicionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallerequisicionAux.getIsDeleted() || (detallerequisicionAux.getIsChanged()&&!detallerequisicionAux.getIsNew())) {
						
						timestamp=detallerequisicionDataAccess.getSetVersionRowDetalleRequisicion(connexion,detallerequisicionAux.getId());
						
						if(!detallerequisicion.getVersionRow().equals(timestamp)) {	
							detallerequisicionAux.setVersionRow(timestamp);
						}
								
						detallerequisicionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleRequisicions()throws Exception {	
		if(detallerequisicions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleRequisicion detallerequisicionAux:detallerequisicions) {
					if(detallerequisicionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallerequisicionAux.getIsDeleted() || (detallerequisicionAux.getIsChanged()&&!detallerequisicionAux.getIsNew())) {
						
						timestamp=detallerequisicionDataAccess.getSetVersionRowDetalleRequisicion(connexion,detallerequisicionAux.getId());
						
						if(!detallerequisicionAux.getVersionRow().equals(timestamp)) {	
							detallerequisicionAux.setVersionRow(timestamp);
						}
						
													
						detallerequisicionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleRequisicionParameterReturnGeneral cargarCombosLoteForeignKeyDetalleRequisicionWithConnection(String finalQueryGlobalRequisicion,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad) throws Exception {
		DetalleRequisicionParameterReturnGeneral  detallerequisicionReturnGeneral =new DetalleRequisicionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleRequisicionWithConnection");connexion.begin();
			
			detallerequisicionReturnGeneral =new DetalleRequisicionParameterReturnGeneral();
			
			

			List<Requisicion> requisicionsForeignKey=new ArrayList<Requisicion>();
			RequisicionLogic requisicionLogic=new RequisicionLogic();
			requisicionLogic.setConnexion(this.connexion);
			requisicionLogic.getRequisicionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRequisicion.equals("NONE")) {
				requisicionLogic.getTodosRequisicions(finalQueryGlobalRequisicion,new Pagination());
				requisicionsForeignKey=requisicionLogic.getRequisicions();
			}

			detallerequisicionReturnGeneral.setrequisicionsForeignKey(requisicionsForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallerequisicionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallerequisicionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallerequisicionReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallerequisicionReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallerequisicionReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallerequisicionReturnGeneral.setmessForeignKey(messForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallerequisicionReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallerequisicionReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallerequisicionReturnGeneral.setunidadsForeignKey(unidadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detallerequisicionReturnGeneral;
	}
	
	public DetalleRequisicionParameterReturnGeneral cargarCombosLoteForeignKeyDetalleRequisicion(String finalQueryGlobalRequisicion,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad) throws Exception {
		DetalleRequisicionParameterReturnGeneral  detallerequisicionReturnGeneral =new DetalleRequisicionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detallerequisicionReturnGeneral =new DetalleRequisicionParameterReturnGeneral();
			
			

			List<Requisicion> requisicionsForeignKey=new ArrayList<Requisicion>();
			RequisicionLogic requisicionLogic=new RequisicionLogic();
			requisicionLogic.setConnexion(this.connexion);
			requisicionLogic.getRequisicionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRequisicion.equals("NONE")) {
				requisicionLogic.getTodosRequisicions(finalQueryGlobalRequisicion,new Pagination());
				requisicionsForeignKey=requisicionLogic.getRequisicions();
			}

			detallerequisicionReturnGeneral.setrequisicionsForeignKey(requisicionsForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallerequisicionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallerequisicionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallerequisicionReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallerequisicionReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallerequisicionReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallerequisicionReturnGeneral.setmessForeignKey(messForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallerequisicionReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallerequisicionReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallerequisicionReturnGeneral.setunidadsForeignKey(unidadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detallerequisicionReturnGeneral;
	}
	
	
	public void deepLoad(DetalleRequisicion detallerequisicion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleRequisicionLogicAdditional.updateDetalleRequisicionToGet(detallerequisicion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallerequisicion.setRequisicion(detallerequisicionDataAccess.getRequisicion(connexion,detallerequisicion));
		detallerequisicion.setEmpresa(detallerequisicionDataAccess.getEmpresa(connexion,detallerequisicion));
		detallerequisicion.setSucursal(detallerequisicionDataAccess.getSucursal(connexion,detallerequisicion));
		detallerequisicion.setEjercicio(detallerequisicionDataAccess.getEjercicio(connexion,detallerequisicion));
		detallerequisicion.setPeriodo(detallerequisicionDataAccess.getPeriodo(connexion,detallerequisicion));
		detallerequisicion.setAnio(detallerequisicionDataAccess.getAnio(connexion,detallerequisicion));
		detallerequisicion.setMes(detallerequisicionDataAccess.getMes(connexion,detallerequisicion));
		detallerequisicion.setBodega(detallerequisicionDataAccess.getBodega(connexion,detallerequisicion));
		detallerequisicion.setProducto(detallerequisicionDataAccess.getProducto(connexion,detallerequisicion));
		detallerequisicion.setUnidad(detallerequisicionDataAccess.getUnidad(connexion,detallerequisicion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Requisicion.class)) {
				detallerequisicion.setRequisicion(detallerequisicionDataAccess.getRequisicion(connexion,detallerequisicion));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallerequisicion.setEmpresa(detallerequisicionDataAccess.getEmpresa(connexion,detallerequisicion));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallerequisicion.setSucursal(detallerequisicionDataAccess.getSucursal(connexion,detallerequisicion));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallerequisicion.setEjercicio(detallerequisicionDataAccess.getEjercicio(connexion,detallerequisicion));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallerequisicion.setPeriodo(detallerequisicionDataAccess.getPeriodo(connexion,detallerequisicion));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallerequisicion.setAnio(detallerequisicionDataAccess.getAnio(connexion,detallerequisicion));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallerequisicion.setMes(detallerequisicionDataAccess.getMes(connexion,detallerequisicion));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallerequisicion.setBodega(detallerequisicionDataAccess.getBodega(connexion,detallerequisicion));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallerequisicion.setProducto(detallerequisicionDataAccess.getProducto(connexion,detallerequisicion));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallerequisicion.setUnidad(detallerequisicionDataAccess.getUnidad(connexion,detallerequisicion));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Requisicion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicion.setRequisicion(detallerequisicionDataAccess.getRequisicion(connexion,detallerequisicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicion.setEmpresa(detallerequisicionDataAccess.getEmpresa(connexion,detallerequisicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicion.setSucursal(detallerequisicionDataAccess.getSucursal(connexion,detallerequisicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicion.setEjercicio(detallerequisicionDataAccess.getEjercicio(connexion,detallerequisicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicion.setPeriodo(detallerequisicionDataAccess.getPeriodo(connexion,detallerequisicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicion.setAnio(detallerequisicionDataAccess.getAnio(connexion,detallerequisicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicion.setMes(detallerequisicionDataAccess.getMes(connexion,detallerequisicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicion.setBodega(detallerequisicionDataAccess.getBodega(connexion,detallerequisicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicion.setProducto(detallerequisicionDataAccess.getProducto(connexion,detallerequisicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicion.setUnidad(detallerequisicionDataAccess.getUnidad(connexion,detallerequisicion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallerequisicion.setRequisicion(detallerequisicionDataAccess.getRequisicion(connexion,detallerequisicion));
		RequisicionLogic requisicionLogic= new RequisicionLogic(connexion);
		requisicionLogic.deepLoad(detallerequisicion.getRequisicion(),isDeep,deepLoadType,clases);
				
		detallerequisicion.setEmpresa(detallerequisicionDataAccess.getEmpresa(connexion,detallerequisicion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallerequisicion.getEmpresa(),isDeep,deepLoadType,clases);
				
		detallerequisicion.setSucursal(detallerequisicionDataAccess.getSucursal(connexion,detallerequisicion));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallerequisicion.getSucursal(),isDeep,deepLoadType,clases);
				
		detallerequisicion.setEjercicio(detallerequisicionDataAccess.getEjercicio(connexion,detallerequisicion));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallerequisicion.getEjercicio(),isDeep,deepLoadType,clases);
				
		detallerequisicion.setPeriodo(detallerequisicionDataAccess.getPeriodo(connexion,detallerequisicion));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallerequisicion.getPeriodo(),isDeep,deepLoadType,clases);
				
		detallerequisicion.setAnio(detallerequisicionDataAccess.getAnio(connexion,detallerequisicion));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallerequisicion.getAnio(),isDeep,deepLoadType,clases);
				
		detallerequisicion.setMes(detallerequisicionDataAccess.getMes(connexion,detallerequisicion));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallerequisicion.getMes(),isDeep,deepLoadType,clases);
				
		detallerequisicion.setBodega(detallerequisicionDataAccess.getBodega(connexion,detallerequisicion));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallerequisicion.getBodega(),isDeep,deepLoadType,clases);
				
		detallerequisicion.setProducto(detallerequisicionDataAccess.getProducto(connexion,detallerequisicion));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallerequisicion.getProducto(),isDeep,deepLoadType,clases);
				
		detallerequisicion.setUnidad(detallerequisicionDataAccess.getUnidad(connexion,detallerequisicion));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallerequisicion.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Requisicion.class)) {
				detallerequisicion.setRequisicion(detallerequisicionDataAccess.getRequisicion(connexion,detallerequisicion));
				RequisicionLogic requisicionLogic= new RequisicionLogic(connexion);
				requisicionLogic.deepLoad(detallerequisicion.getRequisicion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallerequisicion.setEmpresa(detallerequisicionDataAccess.getEmpresa(connexion,detallerequisicion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detallerequisicion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallerequisicion.setSucursal(detallerequisicionDataAccess.getSucursal(connexion,detallerequisicion));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detallerequisicion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallerequisicion.setEjercicio(detallerequisicionDataAccess.getEjercicio(connexion,detallerequisicion));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detallerequisicion.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallerequisicion.setPeriodo(detallerequisicionDataAccess.getPeriodo(connexion,detallerequisicion));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detallerequisicion.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallerequisicion.setAnio(detallerequisicionDataAccess.getAnio(connexion,detallerequisicion));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detallerequisicion.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallerequisicion.setMes(detallerequisicionDataAccess.getMes(connexion,detallerequisicion));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detallerequisicion.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallerequisicion.setBodega(detallerequisicionDataAccess.getBodega(connexion,detallerequisicion));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detallerequisicion.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallerequisicion.setProducto(detallerequisicionDataAccess.getProducto(connexion,detallerequisicion));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detallerequisicion.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallerequisicion.setUnidad(detallerequisicionDataAccess.getUnidad(connexion,detallerequisicion));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detallerequisicion.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Requisicion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicion.setRequisicion(detallerequisicionDataAccess.getRequisicion(connexion,detallerequisicion));
			RequisicionLogic requisicionLogic= new RequisicionLogic(connexion);
			requisicionLogic.deepLoad(detallerequisicion.getRequisicion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicion.setEmpresa(detallerequisicionDataAccess.getEmpresa(connexion,detallerequisicion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detallerequisicion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicion.setSucursal(detallerequisicionDataAccess.getSucursal(connexion,detallerequisicion));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detallerequisicion.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicion.setEjercicio(detallerequisicionDataAccess.getEjercicio(connexion,detallerequisicion));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detallerequisicion.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicion.setPeriodo(detallerequisicionDataAccess.getPeriodo(connexion,detallerequisicion));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detallerequisicion.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicion.setAnio(detallerequisicionDataAccess.getAnio(connexion,detallerequisicion));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detallerequisicion.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicion.setMes(detallerequisicionDataAccess.getMes(connexion,detallerequisicion));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detallerequisicion.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicion.setBodega(detallerequisicionDataAccess.getBodega(connexion,detallerequisicion));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detallerequisicion.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicion.setProducto(detallerequisicionDataAccess.getProducto(connexion,detallerequisicion));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detallerequisicion.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicion.setUnidad(detallerequisicionDataAccess.getUnidad(connexion,detallerequisicion));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detallerequisicion.getUnidad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleRequisicion detallerequisicion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleRequisicionLogicAdditional.updateDetalleRequisicionToSave(detallerequisicion,this.arrDatoGeneral);
			
DetalleRequisicionDataAccess.save(detallerequisicion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		RequisicionDataAccess.save(detallerequisicion.getRequisicion(),connexion);

		EmpresaDataAccess.save(detallerequisicion.getEmpresa(),connexion);

		SucursalDataAccess.save(detallerequisicion.getSucursal(),connexion);

		EjercicioDataAccess.save(detallerequisicion.getEjercicio(),connexion);

		PeriodoDataAccess.save(detallerequisicion.getPeriodo(),connexion);

		AnioDataAccess.save(detallerequisicion.getAnio(),connexion);

		MesDataAccess.save(detallerequisicion.getMes(),connexion);

		BodegaDataAccess.save(detallerequisicion.getBodega(),connexion);

		ProductoDataAccess.save(detallerequisicion.getProducto(),connexion);

		UnidadDataAccess.save(detallerequisicion.getUnidad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Requisicion.class)) {
				RequisicionDataAccess.save(detallerequisicion.getRequisicion(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallerequisicion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallerequisicion.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallerequisicion.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallerequisicion.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallerequisicion.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallerequisicion.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallerequisicion.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallerequisicion.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallerequisicion.getUnidad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		RequisicionDataAccess.save(detallerequisicion.getRequisicion(),connexion);
		RequisicionLogic requisicionLogic= new RequisicionLogic(connexion);
		requisicionLogic.deepLoad(detallerequisicion.getRequisicion(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(detallerequisicion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallerequisicion.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detallerequisicion.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallerequisicion.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detallerequisicion.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallerequisicion.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detallerequisicion.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallerequisicion.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detallerequisicion.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallerequisicion.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detallerequisicion.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallerequisicion.getMes(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detallerequisicion.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallerequisicion.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detallerequisicion.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallerequisicion.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detallerequisicion.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallerequisicion.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Requisicion.class)) {
				RequisicionDataAccess.save(detallerequisicion.getRequisicion(),connexion);
				RequisicionLogic requisicionLogic= new RequisicionLogic(connexion);
				requisicionLogic.deepSave(detallerequisicion.getRequisicion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallerequisicion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detallerequisicion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallerequisicion.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detallerequisicion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallerequisicion.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detallerequisicion.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallerequisicion.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detallerequisicion.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallerequisicion.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detallerequisicion.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallerequisicion.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detallerequisicion.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallerequisicion.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detallerequisicion.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallerequisicion.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detallerequisicion.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallerequisicion.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detallerequisicion.getUnidad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleRequisicion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detallerequisicion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(detallerequisicion);
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
			this.deepLoad(this.detallerequisicion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleRequisicion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detallerequisicions!=null) {
				for(DetalleRequisicion detallerequisicion:detallerequisicions) {
					this.deepLoad(detallerequisicion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(detallerequisicions);
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
			if(detallerequisicions!=null) {
				for(DetalleRequisicion detallerequisicion:detallerequisicions) {
					this.deepLoad(detallerequisicion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(detallerequisicions);
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
			this.getNewConnexionToDeep(DetalleRequisicion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detallerequisicion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleRequisicion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detallerequisicions!=null) {
				for(DetalleRequisicion detallerequisicion:detallerequisicions) {
					this.deepSave(detallerequisicion,isDeep,deepLoadType,clases);
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
			if(detallerequisicions!=null) {
				for(DetalleRequisicion detallerequisicion:detallerequisicions) {
					this.deepSave(detallerequisicion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleRequisicionsFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleRequisicionConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRequisicionsFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleRequisicionConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRequisicionsFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleRequisicionConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRequisicionsFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleRequisicionConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRequisicionsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleRequisicionConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRequisicionsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleRequisicionConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRequisicionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleRequisicionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRequisicionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleRequisicionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRequisicionsFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleRequisicionConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRequisicionsFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleRequisicionConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRequisicionsFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleRequisicionConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRequisicionsFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleRequisicionConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRequisicionsFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleRequisicionConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRequisicionsFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleRequisicionConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRequisicionsFK_IdRequisicionWithConnection(String sFinalQuery,Pagination pagination,Long id_requisicion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRequisicion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRequisicion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_requisicion,DetalleRequisicionConstantesFunciones.IDREQUISICION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRequisicion);

			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRequisicion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRequisicionsFK_IdRequisicion(String sFinalQuery,Pagination pagination,Long id_requisicion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRequisicion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRequisicion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_requisicion,DetalleRequisicionConstantesFunciones.IDREQUISICION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRequisicion);

			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRequisicion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRequisicionsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleRequisicionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRequisicionsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleRequisicionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRequisicionsFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleRequisicionConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRequisicionsFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleRequisicionConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(this.detallerequisicions);
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
			if(DetalleRequisicionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleRequisicionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleRequisicion detallerequisicion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleRequisicionConstantesFunciones.ISCONAUDITORIA) {
				if(detallerequisicion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleRequisicionDataAccess.TABLENAME, detallerequisicion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleRequisicionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleRequisicionLogic.registrarAuditoriaDetallesDetalleRequisicion(connexion,detallerequisicion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detallerequisicion.getIsDeleted()) {
					/*if(!detallerequisicion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleRequisicionDataAccess.TABLENAME, detallerequisicion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleRequisicionLogic.registrarAuditoriaDetallesDetalleRequisicion(connexion,detallerequisicion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleRequisicionDataAccess.TABLENAME, detallerequisicion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detallerequisicion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleRequisicionDataAccess.TABLENAME, detallerequisicion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleRequisicionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleRequisicionLogic.registrarAuditoriaDetallesDetalleRequisicion(connexion,detallerequisicion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleRequisicion(Connexion connexion,DetalleRequisicion detallerequisicion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detallerequisicion.getIsNew()||!detallerequisicion.getid_requisicion().equals(detallerequisicion.getDetalleRequisicionOriginal().getid_requisicion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicion.getDetalleRequisicionOriginal().getid_requisicion()!=null)
				{
					strValorActual=detallerequisicion.getDetalleRequisicionOriginal().getid_requisicion().toString();
				}
				if(detallerequisicion.getid_requisicion()!=null)
				{
					strValorNuevo=detallerequisicion.getid_requisicion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionConstantesFunciones.IDREQUISICION,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicion.getIsNew()||!detallerequisicion.getid_empresa().equals(detallerequisicion.getDetalleRequisicionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicion.getDetalleRequisicionOriginal().getid_empresa()!=null)
				{
					strValorActual=detallerequisicion.getDetalleRequisicionOriginal().getid_empresa().toString();
				}
				if(detallerequisicion.getid_empresa()!=null)
				{
					strValorNuevo=detallerequisicion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicion.getIsNew()||!detallerequisicion.getid_sucursal().equals(detallerequisicion.getDetalleRequisicionOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicion.getDetalleRequisicionOriginal().getid_sucursal()!=null)
				{
					strValorActual=detallerequisicion.getDetalleRequisicionOriginal().getid_sucursal().toString();
				}
				if(detallerequisicion.getid_sucursal()!=null)
				{
					strValorNuevo=detallerequisicion.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicion.getIsNew()||!detallerequisicion.getid_ejercicio().equals(detallerequisicion.getDetalleRequisicionOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicion.getDetalleRequisicionOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detallerequisicion.getDetalleRequisicionOriginal().getid_ejercicio().toString();
				}
				if(detallerequisicion.getid_ejercicio()!=null)
				{
					strValorNuevo=detallerequisicion.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicion.getIsNew()||!detallerequisicion.getid_periodo().equals(detallerequisicion.getDetalleRequisicionOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicion.getDetalleRequisicionOriginal().getid_periodo()!=null)
				{
					strValorActual=detallerequisicion.getDetalleRequisicionOriginal().getid_periodo().toString();
				}
				if(detallerequisicion.getid_periodo()!=null)
				{
					strValorNuevo=detallerequisicion.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicion.getIsNew()||!detallerequisicion.getid_anio().equals(detallerequisicion.getDetalleRequisicionOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicion.getDetalleRequisicionOriginal().getid_anio()!=null)
				{
					strValorActual=detallerequisicion.getDetalleRequisicionOriginal().getid_anio().toString();
				}
				if(detallerequisicion.getid_anio()!=null)
				{
					strValorNuevo=detallerequisicion.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicion.getIsNew()||!detallerequisicion.getid_mes().equals(detallerequisicion.getDetalleRequisicionOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicion.getDetalleRequisicionOriginal().getid_mes()!=null)
				{
					strValorActual=detallerequisicion.getDetalleRequisicionOriginal().getid_mes().toString();
				}
				if(detallerequisicion.getid_mes()!=null)
				{
					strValorNuevo=detallerequisicion.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicion.getIsNew()||!detallerequisicion.getid_bodega().equals(detallerequisicion.getDetalleRequisicionOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicion.getDetalleRequisicionOriginal().getid_bodega()!=null)
				{
					strValorActual=detallerequisicion.getDetalleRequisicionOriginal().getid_bodega().toString();
				}
				if(detallerequisicion.getid_bodega()!=null)
				{
					strValorNuevo=detallerequisicion.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicion.getIsNew()||!detallerequisicion.getid_producto().equals(detallerequisicion.getDetalleRequisicionOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicion.getDetalleRequisicionOriginal().getid_producto()!=null)
				{
					strValorActual=detallerequisicion.getDetalleRequisicionOriginal().getid_producto().toString();
				}
				if(detallerequisicion.getid_producto()!=null)
				{
					strValorNuevo=detallerequisicion.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicion.getIsNew()||!detallerequisicion.getid_unidad().equals(detallerequisicion.getDetalleRequisicionOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicion.getDetalleRequisicionOriginal().getid_unidad()!=null)
				{
					strValorActual=detallerequisicion.getDetalleRequisicionOriginal().getid_unidad().toString();
				}
				if(detallerequisicion.getid_unidad()!=null)
				{
					strValorNuevo=detallerequisicion.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicion.getIsNew()||!detallerequisicion.getcantidad().equals(detallerequisicion.getDetalleRequisicionOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicion.getDetalleRequisicionOriginal().getcantidad()!=null)
				{
					strValorActual=detallerequisicion.getDetalleRequisicionOriginal().getcantidad().toString();
				}
				if(detallerequisicion.getcantidad()!=null)
				{
					strValorNuevo=detallerequisicion.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicion.getIsNew()||!detallerequisicion.getdescripcion().equals(detallerequisicion.getDetalleRequisicionOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicion.getDetalleRequisicionOriginal().getdescripcion()!=null)
				{
					strValorActual=detallerequisicion.getDetalleRequisicionOriginal().getdescripcion();
				}
				if(detallerequisicion.getdescripcion()!=null)
				{
					strValorNuevo=detallerequisicion.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicion.getIsNew()||!detallerequisicion.getfecha_autoriza().equals(detallerequisicion.getDetalleRequisicionOriginal().getfecha_autoriza()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicion.getDetalleRequisicionOriginal().getfecha_autoriza()!=null)
				{
					strValorActual=detallerequisicion.getDetalleRequisicionOriginal().getfecha_autoriza().toString();
				}
				if(detallerequisicion.getfecha_autoriza()!=null)
				{
					strValorNuevo=detallerequisicion.getfecha_autoriza().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionConstantesFunciones.FECHAAUTORIZA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleRequisicionRelacionesWithConnection(DetalleRequisicion detallerequisicion) throws Exception {

		if(!detallerequisicion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleRequisicionRelacionesBase(detallerequisicion,true);
		}
	}

	public void saveDetalleRequisicionRelaciones(DetalleRequisicion detallerequisicion)throws Exception {

		if(!detallerequisicion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleRequisicionRelacionesBase(detallerequisicion,false);
		}
	}

	public void saveDetalleRequisicionRelacionesBase(DetalleRequisicion detallerequisicion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleRequisicion-saveRelacionesWithConnection");}
	

			this.setDetalleRequisicion(detallerequisicion);

			if(DetalleRequisicionLogicAdditional.validarSaveRelaciones(detallerequisicion,this)) {

				DetalleRequisicionLogicAdditional.updateRelacionesToSave(detallerequisicion,this);

				if((detallerequisicion.getIsNew()||detallerequisicion.getIsChanged())&&!detallerequisicion.getIsDeleted()) {
					this.saveDetalleRequisicion();
					this.saveDetalleRequisicionRelacionesDetalles();

				} else if(detallerequisicion.getIsDeleted()) {
					this.saveDetalleRequisicionRelacionesDetalles();
					this.saveDetalleRequisicion();
				}

				DetalleRequisicionLogicAdditional.updateRelacionesToSaveAfter(detallerequisicion,this);

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
	
	
	private void saveDetalleRequisicionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleRequisicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleRequisicionConstantesFunciones.getClassesForeignKeysOfDetalleRequisicion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleRequisicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleRequisicionConstantesFunciones.getClassesRelationshipsOfDetalleRequisicion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.cartera.util.VehiculoClienteConstantesFunciones;
import com.bydan.erp.cartera.util.VehiculoClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.VehiculoClienteParameterGeneral;
import com.bydan.erp.cartera.business.entity.VehiculoCliente;
import com.bydan.erp.cartera.business.logic.VehiculoClienteLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class VehiculoClienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(VehiculoClienteLogic.class);
	
	protected VehiculoClienteDataAccess vehiculoclienteDataAccess; 	
	protected VehiculoCliente vehiculocliente;
	protected List<VehiculoCliente> vehiculoclientes;
	protected Object vehiculoclienteObject;	
	protected List<Object> vehiculoclientesObject;
	
	public static ClassValidator<VehiculoCliente> vehiculoclienteValidator = new ClassValidator<VehiculoCliente>(VehiculoCliente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected VehiculoClienteLogicAdditional vehiculoclienteLogicAdditional=null;
	
	public VehiculoClienteLogicAdditional getVehiculoClienteLogicAdditional() {
		return this.vehiculoclienteLogicAdditional;
	}
	
	public void setVehiculoClienteLogicAdditional(VehiculoClienteLogicAdditional vehiculoclienteLogicAdditional) {
		try {
			this.vehiculoclienteLogicAdditional=vehiculoclienteLogicAdditional;
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
	
	
	
	
	public  VehiculoClienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.vehiculoclienteDataAccess = new VehiculoClienteDataAccess();
			
			this.vehiculoclientes= new ArrayList<VehiculoCliente>();
			this.vehiculocliente= new VehiculoCliente();
			
			this.vehiculoclienteObject=new Object();
			this.vehiculoclientesObject=new ArrayList<Object>();
				
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
			
			this.vehiculoclienteDataAccess.setConnexionType(this.connexionType);
			this.vehiculoclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  VehiculoClienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.vehiculoclienteDataAccess = new VehiculoClienteDataAccess();
			this.vehiculoclientes= new ArrayList<VehiculoCliente>();
			this.vehiculocliente= new VehiculoCliente();
			this.vehiculoclienteObject=new Object();
			this.vehiculoclientesObject=new ArrayList<Object>();
			
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
			
			this.vehiculoclienteDataAccess.setConnexionType(this.connexionType);
			this.vehiculoclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public VehiculoCliente getVehiculoCliente() throws Exception {	
		VehiculoClienteLogicAdditional.checkVehiculoClienteToGet(vehiculocliente,this.datosCliente,this.arrDatoGeneral);
		VehiculoClienteLogicAdditional.updateVehiculoClienteToGet(vehiculocliente,this.arrDatoGeneral);
		
		return vehiculocliente;
	}
		
	public void setVehiculoCliente(VehiculoCliente newVehiculoCliente) {
		this.vehiculocliente = newVehiculoCliente;
	}
	
	public VehiculoClienteDataAccess getVehiculoClienteDataAccess() {
		return vehiculoclienteDataAccess;
	}
	
	public void setVehiculoClienteDataAccess(VehiculoClienteDataAccess newvehiculoclienteDataAccess) {
		this.vehiculoclienteDataAccess = newvehiculoclienteDataAccess;
	}
	
	public List<VehiculoCliente> getVehiculoClientes() throws Exception {		
		this.quitarVehiculoClientesNulos();
		
		VehiculoClienteLogicAdditional.checkVehiculoClienteToGets(vehiculoclientes,this.datosCliente,this.arrDatoGeneral);
		
		for (VehiculoCliente vehiculoclienteLocal: vehiculoclientes ) {
			VehiculoClienteLogicAdditional.updateVehiculoClienteToGet(vehiculoclienteLocal,this.arrDatoGeneral);
		}
		
		return vehiculoclientes;
	}
	
	public void setVehiculoClientes(List<VehiculoCliente> newVehiculoClientes) {
		this.vehiculoclientes = newVehiculoClientes;
	}
	
	public Object getVehiculoClienteObject() {	
		this.vehiculoclienteObject=this.vehiculoclienteDataAccess.getEntityObject();
		return this.vehiculoclienteObject;
	}
		
	public void setVehiculoClienteObject(Object newVehiculoClienteObject) {
		this.vehiculoclienteObject = newVehiculoClienteObject;
	}
	
	public List<Object> getVehiculoClientesObject() {		
		this.vehiculoclientesObject=this.vehiculoclienteDataAccess.getEntitiesObject();
		return this.vehiculoclientesObject;
	}
		
	public void setVehiculoClientesObject(List<Object> newVehiculoClientesObject) {
		this.vehiculoclientesObject = newVehiculoClientesObject;
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
		
		if(this.vehiculoclienteDataAccess!=null) {
			this.vehiculoclienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VehiculoCliente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			vehiculoclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			vehiculoclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		vehiculocliente = new  VehiculoCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VehiculoCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			vehiculocliente=vehiculoclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vehiculocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(this.vehiculocliente);
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
		vehiculocliente = new  VehiculoCliente();
		  		  
        try {
			
			vehiculocliente=vehiculoclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vehiculocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(this.vehiculocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		vehiculocliente = new  VehiculoCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VehiculoCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			vehiculocliente=vehiculoclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vehiculocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(this.vehiculocliente);
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
		vehiculocliente = new  VehiculoCliente();
		  		  
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
		vehiculocliente = new  VehiculoCliente();
		  		  
        try {
			
			vehiculocliente=vehiculoclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vehiculocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(this.vehiculocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		vehiculocliente = new  VehiculoCliente();
		  		  
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
		vehiculocliente = new  VehiculoCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VehiculoCliente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =vehiculoclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		vehiculocliente = new  VehiculoCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=vehiculoclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		vehiculocliente = new  VehiculoCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VehiculoCliente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =vehiculoclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		vehiculocliente = new  VehiculoCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=vehiculoclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		vehiculocliente = new  VehiculoCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VehiculoCliente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =vehiculoclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		vehiculocliente = new  VehiculoCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=vehiculoclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		vehiculoclientes = new  ArrayList<VehiculoCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VehiculoCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			VehiculoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculoclientes=vehiculoclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVehiculoCliente(vehiculoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(this.vehiculoclientes);
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
		vehiculoclientes = new  ArrayList<VehiculoCliente>();
		  		  
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
		vehiculoclientes = new  ArrayList<VehiculoCliente>();
		  		  
        try {			
			VehiculoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculoclientes=vehiculoclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarVehiculoCliente(vehiculoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(this.vehiculoclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		vehiculoclientes = new  ArrayList<VehiculoCliente>();
		  		  
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
		vehiculoclientes = new  ArrayList<VehiculoCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VehiculoCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			VehiculoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculoclientes=vehiculoclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVehiculoCliente(vehiculoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(this.vehiculoclientes);
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
		vehiculoclientes = new  ArrayList<VehiculoCliente>();
		  		  
        try {
			VehiculoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculoclientes=vehiculoclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVehiculoCliente(vehiculoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(this.vehiculoclientes);
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
		vehiculoclientes = new  ArrayList<VehiculoCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VehiculoCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VehiculoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculoclientes=vehiculoclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVehiculoCliente(vehiculoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(this.vehiculoclientes);
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
		vehiculoclientes = new  ArrayList<VehiculoCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VehiculoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculoclientes=vehiculoclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVehiculoCliente(vehiculoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(this.vehiculoclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		vehiculocliente = new  VehiculoCliente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VehiculoCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VehiculoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculocliente=vehiculoclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVehiculoCliente(vehiculocliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(this.vehiculocliente);
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
		vehiculocliente = new  VehiculoCliente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VehiculoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculocliente=vehiculoclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVehiculoCliente(vehiculocliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(this.vehiculocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		vehiculoclientes = new  ArrayList<VehiculoCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VehiculoCliente.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			VehiculoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculoclientes=vehiculoclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVehiculoCliente(vehiculoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(this.vehiculoclientes);
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
		vehiculoclientes = new  ArrayList<VehiculoCliente>();
		  		  
        try {
			VehiculoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculoclientes=vehiculoclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVehiculoCliente(vehiculoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(this.vehiculoclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosVehiculoClientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		vehiculoclientes = new  ArrayList<VehiculoCliente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VehiculoCliente.class.getSimpleName()+"-getTodosVehiculoClientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VehiculoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculoclientes=vehiculoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarVehiculoCliente(vehiculoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(this.vehiculoclientes);
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
	
	public  void  getTodosVehiculoClientes(String sFinalQuery,Pagination pagination)throws Exception {
		vehiculoclientes = new  ArrayList<VehiculoCliente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VehiculoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculoclientes=vehiculoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarVehiculoCliente(vehiculoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(this.vehiculoclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarVehiculoCliente(VehiculoCliente vehiculocliente) throws Exception {
		Boolean estaValidado=false;
		
		if(vehiculocliente.getIsNew() || vehiculocliente.getIsChanged()) { 
			this.invalidValues = vehiculoclienteValidator.getInvalidValues(vehiculocliente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(vehiculocliente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarVehiculoCliente(List<VehiculoCliente> VehiculoClientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(VehiculoCliente vehiculoclienteLocal:vehiculoclientes) {				
			estaValidadoObjeto=this.validarGuardarVehiculoCliente(vehiculoclienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarVehiculoCliente(List<VehiculoCliente> VehiculoClientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarVehiculoCliente(vehiculoclientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarVehiculoCliente(VehiculoCliente VehiculoCliente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarVehiculoCliente(vehiculocliente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(VehiculoCliente vehiculocliente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+vehiculocliente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=VehiculoClienteConstantesFunciones.getVehiculoClienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"vehiculocliente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(VehiculoClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(VehiculoClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveVehiculoClienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VehiculoCliente.class.getSimpleName()+"-saveVehiculoClienteWithConnection");connexion.begin();			
			
			VehiculoClienteLogicAdditional.checkVehiculoClienteToSave(this.vehiculocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			VehiculoClienteLogicAdditional.updateVehiculoClienteToSave(this.vehiculocliente,this.arrDatoGeneral);
			
			VehiculoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.vehiculocliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowVehiculoCliente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarVehiculoCliente(this.vehiculocliente)) {
				VehiculoClienteDataAccess.save(this.vehiculocliente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.vehiculocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			VehiculoClienteLogicAdditional.checkVehiculoClienteToSaveAfter(this.vehiculocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowVehiculoCliente();
			
			connexion.commit();			
			
			if(this.vehiculocliente.getIsDeleted()) {
				this.vehiculocliente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveVehiculoCliente()throws Exception {	
		try {	
			
			VehiculoClienteLogicAdditional.checkVehiculoClienteToSave(this.vehiculocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			VehiculoClienteLogicAdditional.updateVehiculoClienteToSave(this.vehiculocliente,this.arrDatoGeneral);
			
			VehiculoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.vehiculocliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarVehiculoCliente(this.vehiculocliente)) {			
				VehiculoClienteDataAccess.save(this.vehiculocliente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.vehiculocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			VehiculoClienteLogicAdditional.checkVehiculoClienteToSaveAfter(this.vehiculocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.vehiculocliente.getIsDeleted()) {
				this.vehiculocliente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveVehiculoClientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VehiculoCliente.class.getSimpleName()+"-saveVehiculoClientesWithConnection");connexion.begin();			
			
			VehiculoClienteLogicAdditional.checkVehiculoClienteToSaves(vehiculoclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowVehiculoClientes();
			
			Boolean validadoTodosVehiculoCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(VehiculoCliente vehiculoclienteLocal:vehiculoclientes) {		
				if(vehiculoclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				VehiculoClienteLogicAdditional.updateVehiculoClienteToSave(vehiculoclienteLocal,this.arrDatoGeneral);
	        	
				VehiculoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),vehiculoclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarVehiculoCliente(vehiculoclienteLocal)) {
					VehiculoClienteDataAccess.save(vehiculoclienteLocal, connexion);				
				} else {
					validadoTodosVehiculoCliente=false;
				}
			}
			
			if(!validadoTodosVehiculoCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			VehiculoClienteLogicAdditional.checkVehiculoClienteToSavesAfter(vehiculoclientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowVehiculoClientes();
			
			connexion.commit();		
			
			this.quitarVehiculoClientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveVehiculoClientes()throws Exception {				
		 try {	
			VehiculoClienteLogicAdditional.checkVehiculoClienteToSaves(vehiculoclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosVehiculoCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(VehiculoCliente vehiculoclienteLocal:vehiculoclientes) {				
				if(vehiculoclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				VehiculoClienteLogicAdditional.updateVehiculoClienteToSave(vehiculoclienteLocal,this.arrDatoGeneral);
	        	
				VehiculoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),vehiculoclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarVehiculoCliente(vehiculoclienteLocal)) {				
					VehiculoClienteDataAccess.save(vehiculoclienteLocal, connexion);				
				} else {
					validadoTodosVehiculoCliente=false;
				}
			}
			
			if(!validadoTodosVehiculoCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			VehiculoClienteLogicAdditional.checkVehiculoClienteToSavesAfter(vehiculoclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarVehiculoClientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public VehiculoClienteParameterReturnGeneral procesarAccionVehiculoClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<VehiculoCliente> vehiculoclientes,VehiculoClienteParameterReturnGeneral vehiculoclienteParameterGeneral)throws Exception {
		 try {	
			VehiculoClienteParameterReturnGeneral vehiculoclienteReturnGeneral=new VehiculoClienteParameterReturnGeneral();
	
			VehiculoClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,vehiculoclientes,vehiculoclienteParameterGeneral,vehiculoclienteReturnGeneral);
			
			return vehiculoclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public VehiculoClienteParameterReturnGeneral procesarAccionVehiculoClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<VehiculoCliente> vehiculoclientes,VehiculoClienteParameterReturnGeneral vehiculoclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VehiculoCliente.class.getSimpleName()+"-procesarAccionVehiculoClientesWithConnection");connexion.begin();			
			
			VehiculoClienteParameterReturnGeneral vehiculoclienteReturnGeneral=new VehiculoClienteParameterReturnGeneral();
	
			VehiculoClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,vehiculoclientes,vehiculoclienteParameterGeneral,vehiculoclienteReturnGeneral);
			
			this.connexion.commit();
			
			return vehiculoclienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public VehiculoClienteParameterReturnGeneral procesarEventosVehiculoClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<VehiculoCliente> vehiculoclientes,VehiculoCliente vehiculocliente,VehiculoClienteParameterReturnGeneral vehiculoclienteParameterGeneral,Boolean isEsNuevoVehiculoCliente,ArrayList<Classe> clases)throws Exception {
		 try {	
			VehiculoClienteParameterReturnGeneral vehiculoclienteReturnGeneral=new VehiculoClienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				vehiculoclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			VehiculoClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,vehiculoclientes,vehiculocliente,vehiculoclienteParameterGeneral,vehiculoclienteReturnGeneral,isEsNuevoVehiculoCliente,clases);
			
			return vehiculoclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public VehiculoClienteParameterReturnGeneral procesarEventosVehiculoClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<VehiculoCliente> vehiculoclientes,VehiculoCliente vehiculocliente,VehiculoClienteParameterReturnGeneral vehiculoclienteParameterGeneral,Boolean isEsNuevoVehiculoCliente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VehiculoCliente.class.getSimpleName()+"-procesarEventosVehiculoClientesWithConnection");connexion.begin();			
			
			VehiculoClienteParameterReturnGeneral vehiculoclienteReturnGeneral=new VehiculoClienteParameterReturnGeneral();
	
			vehiculoclienteReturnGeneral.setVehiculoCliente(vehiculocliente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				vehiculoclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			VehiculoClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,vehiculoclientes,vehiculocliente,vehiculoclienteParameterGeneral,vehiculoclienteReturnGeneral,isEsNuevoVehiculoCliente,clases);
			
			this.connexion.commit();
			
			return vehiculoclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public VehiculoClienteParameterReturnGeneral procesarImportacionVehiculoClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,VehiculoClienteParameterReturnGeneral vehiculoclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VehiculoCliente.class.getSimpleName()+"-procesarImportacionVehiculoClientesWithConnection");connexion.begin();			
			
			VehiculoClienteParameterReturnGeneral vehiculoclienteReturnGeneral=new VehiculoClienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.vehiculoclientes=new ArrayList<VehiculoCliente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.vehiculocliente=new VehiculoCliente();
				
				
				if(conColumnasBase) {this.vehiculocliente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.vehiculocliente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.vehiculocliente.setcodigo(arrColumnas[iColumn++]);
				this.vehiculocliente.setmarca(arrColumnas[iColumn++]);
				this.vehiculocliente.setmodelo(arrColumnas[iColumn++]);
				this.vehiculocliente.setplaca(arrColumnas[iColumn++]);
				this.vehiculocliente.setanio(Integer.parseInt(arrColumnas[iColumn++]));
				this.vehiculocliente.setes_prendado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.vehiculocliente.setvalor_avaluo(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.vehiculoclientes.add(this.vehiculocliente);
			}
			
			this.saveVehiculoClientes();
			
			this.connexion.commit();
			
			vehiculoclienteReturnGeneral.setConRetornoEstaProcesado(true);
			vehiculoclienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return vehiculoclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarVehiculoClientesEliminados() throws Exception {				
		
		List<VehiculoCliente> vehiculoclientesAux= new ArrayList<VehiculoCliente>();
		
		for(VehiculoCliente vehiculocliente:vehiculoclientes) {
			if(!vehiculocliente.getIsDeleted()) {
				vehiculoclientesAux.add(vehiculocliente);
			}
		}
		
		vehiculoclientes=vehiculoclientesAux;
	}
	
	public void quitarVehiculoClientesNulos() throws Exception {				
		
		List<VehiculoCliente> vehiculoclientesAux= new ArrayList<VehiculoCliente>();
		
		for(VehiculoCliente vehiculocliente : this.vehiculoclientes) {
			if(vehiculocliente==null) {
				vehiculoclientesAux.add(vehiculocliente);
			}
		}
		
		//this.vehiculoclientes=vehiculoclientesAux;
		
		this.vehiculoclientes.removeAll(vehiculoclientesAux);
	}
	
	public void getSetVersionRowVehiculoClienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(vehiculocliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((vehiculocliente.getIsDeleted() || (vehiculocliente.getIsChanged()&&!vehiculocliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=vehiculoclienteDataAccess.getSetVersionRowVehiculoCliente(connexion,vehiculocliente.getId());
				
				if(!vehiculocliente.getVersionRow().equals(timestamp)) {	
					vehiculocliente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				vehiculocliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowVehiculoCliente()throws Exception {	
		
		if(vehiculocliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((vehiculocliente.getIsDeleted() || (vehiculocliente.getIsChanged()&&!vehiculocliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=vehiculoclienteDataAccess.getSetVersionRowVehiculoCliente(connexion,vehiculocliente.getId());
			
			try {							
				if(!vehiculocliente.getVersionRow().equals(timestamp)) {	
					vehiculocliente.setVersionRow(timestamp);
				}
				
				vehiculocliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowVehiculoClientesWithConnection()throws Exception {	
		if(vehiculoclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(VehiculoCliente vehiculoclienteAux:vehiculoclientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(vehiculoclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(vehiculoclienteAux.getIsDeleted() || (vehiculoclienteAux.getIsChanged()&&!vehiculoclienteAux.getIsNew())) {
						
						timestamp=vehiculoclienteDataAccess.getSetVersionRowVehiculoCliente(connexion,vehiculoclienteAux.getId());
						
						if(!vehiculocliente.getVersionRow().equals(timestamp)) {	
							vehiculoclienteAux.setVersionRow(timestamp);
						}
								
						vehiculoclienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowVehiculoClientes()throws Exception {	
		if(vehiculoclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(VehiculoCliente vehiculoclienteAux:vehiculoclientes) {
					if(vehiculoclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(vehiculoclienteAux.getIsDeleted() || (vehiculoclienteAux.getIsChanged()&&!vehiculoclienteAux.getIsNew())) {
						
						timestamp=vehiculoclienteDataAccess.getSetVersionRowVehiculoCliente(connexion,vehiculoclienteAux.getId());
						
						if(!vehiculoclienteAux.getVersionRow().equals(timestamp)) {	
							vehiculoclienteAux.setVersionRow(timestamp);
						}
						
													
						vehiculoclienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public VehiculoClienteParameterReturnGeneral cargarCombosLoteForeignKeyVehiculoClienteWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente) throws Exception {
		VehiculoClienteParameterReturnGeneral  vehiculoclienteReturnGeneral =new VehiculoClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VehiculoCliente.class.getSimpleName()+"-cargarCombosLoteForeignKeyVehiculoClienteWithConnection");connexion.begin();
			
			vehiculoclienteReturnGeneral =new VehiculoClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			vehiculoclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			vehiculoclienteReturnGeneral.setclientesForeignKey(clientesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return vehiculoclienteReturnGeneral;
	}
	
	public VehiculoClienteParameterReturnGeneral cargarCombosLoteForeignKeyVehiculoCliente(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente) throws Exception {
		VehiculoClienteParameterReturnGeneral  vehiculoclienteReturnGeneral =new VehiculoClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			vehiculoclienteReturnGeneral =new VehiculoClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			vehiculoclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			vehiculoclienteReturnGeneral.setclientesForeignKey(clientesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return vehiculoclienteReturnGeneral;
	}
	
	
	public void deepLoad(VehiculoCliente vehiculocliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			VehiculoClienteLogicAdditional.updateVehiculoClienteToGet(vehiculocliente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		vehiculocliente.setEmpresa(vehiculoclienteDataAccess.getEmpresa(connexion,vehiculocliente));
		vehiculocliente.setCliente(vehiculoclienteDataAccess.getCliente(connexion,vehiculocliente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				vehiculocliente.setEmpresa(vehiculoclienteDataAccess.getEmpresa(connexion,vehiculocliente));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				vehiculocliente.setCliente(vehiculoclienteDataAccess.getCliente(connexion,vehiculocliente));
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
			vehiculocliente.setEmpresa(vehiculoclienteDataAccess.getEmpresa(connexion,vehiculocliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vehiculocliente.setCliente(vehiculoclienteDataAccess.getCliente(connexion,vehiculocliente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		vehiculocliente.setEmpresa(vehiculoclienteDataAccess.getEmpresa(connexion,vehiculocliente));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(vehiculocliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		vehiculocliente.setCliente(vehiculoclienteDataAccess.getCliente(connexion,vehiculocliente));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(vehiculocliente.getCliente(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				vehiculocliente.setEmpresa(vehiculoclienteDataAccess.getEmpresa(connexion,vehiculocliente));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(vehiculocliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				vehiculocliente.setCliente(vehiculoclienteDataAccess.getCliente(connexion,vehiculocliente));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(vehiculocliente.getCliente(),isDeep,deepLoadType,clases);				
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
			vehiculocliente.setEmpresa(vehiculoclienteDataAccess.getEmpresa(connexion,vehiculocliente));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(vehiculocliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vehiculocliente.setCliente(vehiculoclienteDataAccess.getCliente(connexion,vehiculocliente));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(vehiculocliente.getCliente(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(VehiculoCliente vehiculocliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			VehiculoClienteLogicAdditional.updateVehiculoClienteToSave(vehiculocliente,this.arrDatoGeneral);
			
VehiculoClienteDataAccess.save(vehiculocliente, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(vehiculocliente.getEmpresa(),connexion);

		ClienteDataAccess.save(vehiculocliente.getCliente(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(vehiculocliente.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(vehiculocliente.getCliente(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(vehiculocliente.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(vehiculocliente.getEmpresa(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(vehiculocliente.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(vehiculocliente.getCliente(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(vehiculocliente.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(vehiculocliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(vehiculocliente.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(vehiculocliente.getCliente(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(VehiculoCliente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(vehiculocliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(vehiculocliente);
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
			this.deepLoad(this.vehiculocliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(this.vehiculocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(VehiculoCliente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(vehiculoclientes!=null) {
				for(VehiculoCliente vehiculocliente:vehiculoclientes) {
					this.deepLoad(vehiculocliente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(vehiculoclientes);
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
			if(vehiculoclientes!=null) {
				for(VehiculoCliente vehiculocliente:vehiculoclientes) {
					this.deepLoad(vehiculocliente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(vehiculoclientes);
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
			this.getNewConnexionToDeep(VehiculoCliente.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(vehiculocliente,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(VehiculoCliente.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(vehiculoclientes!=null) {
				for(VehiculoCliente vehiculocliente:vehiculoclientes) {
					this.deepSave(vehiculocliente,isDeep,deepLoadType,clases);
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
			if(vehiculoclientes!=null) {
				for(VehiculoCliente vehiculocliente:vehiculoclientes) {
					this.deepSave(vehiculocliente,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getVehiculoClientesFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VehiculoCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,VehiculoClienteConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			VehiculoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vehiculoclientes=vehiculoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(this.vehiculoclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVehiculoClientesFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,VehiculoClienteConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			VehiculoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vehiculoclientes=vehiculoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(this.vehiculoclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVehiculoClientesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VehiculoCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,VehiculoClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			VehiculoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vehiculoclientes=vehiculoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(this.vehiculoclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVehiculoClientesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,VehiculoClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			VehiculoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vehiculoclientes=vehiculoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(this.vehiculoclientes);
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
			if(VehiculoClienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,VehiculoClienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,VehiculoCliente vehiculocliente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(VehiculoClienteConstantesFunciones.ISCONAUDITORIA) {
				if(vehiculocliente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VehiculoClienteDataAccess.TABLENAME, vehiculocliente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(VehiculoClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////VehiculoClienteLogic.registrarAuditoriaDetallesVehiculoCliente(connexion,vehiculocliente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(vehiculocliente.getIsDeleted()) {
					/*if(!vehiculocliente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,VehiculoClienteDataAccess.TABLENAME, vehiculocliente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////VehiculoClienteLogic.registrarAuditoriaDetallesVehiculoCliente(connexion,vehiculocliente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VehiculoClienteDataAccess.TABLENAME, vehiculocliente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(vehiculocliente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VehiculoClienteDataAccess.TABLENAME, vehiculocliente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(VehiculoClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////VehiculoClienteLogic.registrarAuditoriaDetallesVehiculoCliente(connexion,vehiculocliente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesVehiculoCliente(Connexion connexion,VehiculoCliente vehiculocliente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(vehiculocliente.getIsNew()||!vehiculocliente.getid_empresa().equals(vehiculocliente.getVehiculoClienteOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculocliente.getVehiculoClienteOriginal().getid_empresa()!=null)
				{
					strValorActual=vehiculocliente.getVehiculoClienteOriginal().getid_empresa().toString();
				}
				if(vehiculocliente.getid_empresa()!=null)
				{
					strValorNuevo=vehiculocliente.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoClienteConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(vehiculocliente.getIsNew()||!vehiculocliente.getid_cliente().equals(vehiculocliente.getVehiculoClienteOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculocliente.getVehiculoClienteOriginal().getid_cliente()!=null)
				{
					strValorActual=vehiculocliente.getVehiculoClienteOriginal().getid_cliente().toString();
				}
				if(vehiculocliente.getid_cliente()!=null)
				{
					strValorNuevo=vehiculocliente.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoClienteConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(vehiculocliente.getIsNew()||!vehiculocliente.getcodigo().equals(vehiculocliente.getVehiculoClienteOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculocliente.getVehiculoClienteOriginal().getcodigo()!=null)
				{
					strValorActual=vehiculocliente.getVehiculoClienteOriginal().getcodigo();
				}
				if(vehiculocliente.getcodigo()!=null)
				{
					strValorNuevo=vehiculocliente.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoClienteConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(vehiculocliente.getIsNew()||!vehiculocliente.getmarca().equals(vehiculocliente.getVehiculoClienteOriginal().getmarca()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculocliente.getVehiculoClienteOriginal().getmarca()!=null)
				{
					strValorActual=vehiculocliente.getVehiculoClienteOriginal().getmarca();
				}
				if(vehiculocliente.getmarca()!=null)
				{
					strValorNuevo=vehiculocliente.getmarca() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoClienteConstantesFunciones.MARCA,strValorActual,strValorNuevo);
			}	
			
			if(vehiculocliente.getIsNew()||!vehiculocliente.getmodelo().equals(vehiculocliente.getVehiculoClienteOriginal().getmodelo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculocliente.getVehiculoClienteOriginal().getmodelo()!=null)
				{
					strValorActual=vehiculocliente.getVehiculoClienteOriginal().getmodelo();
				}
				if(vehiculocliente.getmodelo()!=null)
				{
					strValorNuevo=vehiculocliente.getmodelo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoClienteConstantesFunciones.MODELO,strValorActual,strValorNuevo);
			}	
			
			if(vehiculocliente.getIsNew()||!vehiculocliente.getplaca().equals(vehiculocliente.getVehiculoClienteOriginal().getplaca()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculocliente.getVehiculoClienteOriginal().getplaca()!=null)
				{
					strValorActual=vehiculocliente.getVehiculoClienteOriginal().getplaca();
				}
				if(vehiculocliente.getplaca()!=null)
				{
					strValorNuevo=vehiculocliente.getplaca() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoClienteConstantesFunciones.PLACA,strValorActual,strValorNuevo);
			}	
			
			if(vehiculocliente.getIsNew()||!vehiculocliente.getanio().equals(vehiculocliente.getVehiculoClienteOriginal().getanio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculocliente.getVehiculoClienteOriginal().getanio()!=null)
				{
					strValorActual=vehiculocliente.getVehiculoClienteOriginal().getanio().toString();
				}
				if(vehiculocliente.getanio()!=null)
				{
					strValorNuevo=vehiculocliente.getanio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoClienteConstantesFunciones.ANIO,strValorActual,strValorNuevo);
			}	
			
			if(vehiculocliente.getIsNew()||!vehiculocliente.getes_prendado().equals(vehiculocliente.getVehiculoClienteOriginal().getes_prendado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculocliente.getVehiculoClienteOriginal().getes_prendado()!=null)
				{
					strValorActual=vehiculocliente.getVehiculoClienteOriginal().getes_prendado().toString();
				}
				if(vehiculocliente.getes_prendado()!=null)
				{
					strValorNuevo=vehiculocliente.getes_prendado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoClienteConstantesFunciones.ESPRENDADO,strValorActual,strValorNuevo);
			}	
			
			if(vehiculocliente.getIsNew()||!vehiculocliente.getvalor_avaluo().equals(vehiculocliente.getVehiculoClienteOriginal().getvalor_avaluo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculocliente.getVehiculoClienteOriginal().getvalor_avaluo()!=null)
				{
					strValorActual=vehiculocliente.getVehiculoClienteOriginal().getvalor_avaluo().toString();
				}
				if(vehiculocliente.getvalor_avaluo()!=null)
				{
					strValorNuevo=vehiculocliente.getvalor_avaluo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoClienteConstantesFunciones.VALORAVALUO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveVehiculoClienteRelacionesWithConnection(VehiculoCliente vehiculocliente) throws Exception {

		if(!vehiculocliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveVehiculoClienteRelacionesBase(vehiculocliente,true);
		}
	}

	public void saveVehiculoClienteRelaciones(VehiculoCliente vehiculocliente)throws Exception {

		if(!vehiculocliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveVehiculoClienteRelacionesBase(vehiculocliente,false);
		}
	}

	public void saveVehiculoClienteRelacionesBase(VehiculoCliente vehiculocliente,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("VehiculoCliente-saveRelacionesWithConnection");}
	

			this.setVehiculoCliente(vehiculocliente);

			if(VehiculoClienteLogicAdditional.validarSaveRelaciones(vehiculocliente,this)) {

				VehiculoClienteLogicAdditional.updateRelacionesToSave(vehiculocliente,this);

				if((vehiculocliente.getIsNew()||vehiculocliente.getIsChanged())&&!vehiculocliente.getIsDeleted()) {
					this.saveVehiculoCliente();
					this.saveVehiculoClienteRelacionesDetalles();

				} else if(vehiculocliente.getIsDeleted()) {
					this.saveVehiculoClienteRelacionesDetalles();
					this.saveVehiculoCliente();
				}

				VehiculoClienteLogicAdditional.updateRelacionesToSaveAfter(vehiculocliente,this);

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
	
	
	private void saveVehiculoClienteRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfVehiculoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=VehiculoClienteConstantesFunciones.getClassesForeignKeysOfVehiculoCliente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVehiculoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=VehiculoClienteConstantesFunciones.getClassesRelationshipsOfVehiculoCliente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.inventario.util.ControlVehiculoConstantesFunciones;
import com.bydan.erp.inventario.util.ControlVehiculoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ControlVehiculoParameterGeneral;
import com.bydan.erp.inventario.business.entity.ControlVehiculo;
import com.bydan.erp.inventario.business.logic.ControlVehiculoLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ControlVehiculoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ControlVehiculoLogic.class);
	
	protected ControlVehiculoDataAccess controlvehiculoDataAccess; 	
	protected ControlVehiculo controlvehiculo;
	protected List<ControlVehiculo> controlvehiculos;
	protected Object controlvehiculoObject;	
	protected List<Object> controlvehiculosObject;
	
	public static ClassValidator<ControlVehiculo> controlvehiculoValidator = new ClassValidator<ControlVehiculo>(ControlVehiculo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ControlVehiculoLogicAdditional controlvehiculoLogicAdditional=null;
	
	public ControlVehiculoLogicAdditional getControlVehiculoLogicAdditional() {
		return this.controlvehiculoLogicAdditional;
	}
	
	public void setControlVehiculoLogicAdditional(ControlVehiculoLogicAdditional controlvehiculoLogicAdditional) {
		try {
			this.controlvehiculoLogicAdditional=controlvehiculoLogicAdditional;
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
	
	
	
	
	public  ControlVehiculoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.controlvehiculoDataAccess = new ControlVehiculoDataAccess();
			
			this.controlvehiculos= new ArrayList<ControlVehiculo>();
			this.controlvehiculo= new ControlVehiculo();
			
			this.controlvehiculoObject=new Object();
			this.controlvehiculosObject=new ArrayList<Object>();
				
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
			
			this.controlvehiculoDataAccess.setConnexionType(this.connexionType);
			this.controlvehiculoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ControlVehiculoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.controlvehiculoDataAccess = new ControlVehiculoDataAccess();
			this.controlvehiculos= new ArrayList<ControlVehiculo>();
			this.controlvehiculo= new ControlVehiculo();
			this.controlvehiculoObject=new Object();
			this.controlvehiculosObject=new ArrayList<Object>();
			
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
			
			this.controlvehiculoDataAccess.setConnexionType(this.connexionType);
			this.controlvehiculoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ControlVehiculo getControlVehiculo() throws Exception {	
		ControlVehiculoLogicAdditional.checkControlVehiculoToGet(controlvehiculo,this.datosCliente,this.arrDatoGeneral);
		ControlVehiculoLogicAdditional.updateControlVehiculoToGet(controlvehiculo,this.arrDatoGeneral);
		
		return controlvehiculo;
	}
		
	public void setControlVehiculo(ControlVehiculo newControlVehiculo) {
		this.controlvehiculo = newControlVehiculo;
	}
	
	public ControlVehiculoDataAccess getControlVehiculoDataAccess() {
		return controlvehiculoDataAccess;
	}
	
	public void setControlVehiculoDataAccess(ControlVehiculoDataAccess newcontrolvehiculoDataAccess) {
		this.controlvehiculoDataAccess = newcontrolvehiculoDataAccess;
	}
	
	public List<ControlVehiculo> getControlVehiculos() throws Exception {		
		this.quitarControlVehiculosNulos();
		
		ControlVehiculoLogicAdditional.checkControlVehiculoToGets(controlvehiculos,this.datosCliente,this.arrDatoGeneral);
		
		for (ControlVehiculo controlvehiculoLocal: controlvehiculos ) {
			ControlVehiculoLogicAdditional.updateControlVehiculoToGet(controlvehiculoLocal,this.arrDatoGeneral);
		}
		
		return controlvehiculos;
	}
	
	public void setControlVehiculos(List<ControlVehiculo> newControlVehiculos) {
		this.controlvehiculos = newControlVehiculos;
	}
	
	public Object getControlVehiculoObject() {	
		this.controlvehiculoObject=this.controlvehiculoDataAccess.getEntityObject();
		return this.controlvehiculoObject;
	}
		
	public void setControlVehiculoObject(Object newControlVehiculoObject) {
		this.controlvehiculoObject = newControlVehiculoObject;
	}
	
	public List<Object> getControlVehiculosObject() {		
		this.controlvehiculosObject=this.controlvehiculoDataAccess.getEntitiesObject();
		return this.controlvehiculosObject;
	}
		
	public void setControlVehiculosObject(List<Object> newControlVehiculosObject) {
		this.controlvehiculosObject = newControlVehiculosObject;
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
		
		if(this.controlvehiculoDataAccess!=null) {
			this.controlvehiculoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			controlvehiculoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			controlvehiculoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		controlvehiculo = new  ControlVehiculo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			controlvehiculo=controlvehiculoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.controlvehiculo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculo);
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
		controlvehiculo = new  ControlVehiculo();
		  		  
        try {
			
			controlvehiculo=controlvehiculoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.controlvehiculo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		controlvehiculo = new  ControlVehiculo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			controlvehiculo=controlvehiculoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.controlvehiculo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculo);
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
		controlvehiculo = new  ControlVehiculo();
		  		  
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
		controlvehiculo = new  ControlVehiculo();
		  		  
        try {
			
			controlvehiculo=controlvehiculoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.controlvehiculo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		controlvehiculo = new  ControlVehiculo();
		  		  
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
		controlvehiculo = new  ControlVehiculo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =controlvehiculoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		controlvehiculo = new  ControlVehiculo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=controlvehiculoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		controlvehiculo = new  ControlVehiculo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =controlvehiculoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		controlvehiculo = new  ControlVehiculo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=controlvehiculoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		controlvehiculo = new  ControlVehiculo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =controlvehiculoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		controlvehiculo = new  ControlVehiculo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=controlvehiculoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		controlvehiculos = new  ArrayList<ControlVehiculo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			controlvehiculos=controlvehiculoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarControlVehiculo(controlvehiculos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculos);
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
		controlvehiculos = new  ArrayList<ControlVehiculo>();
		  		  
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
		controlvehiculos = new  ArrayList<ControlVehiculo>();
		  		  
        try {			
			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			controlvehiculos=controlvehiculoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarControlVehiculo(controlvehiculos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		controlvehiculos = new  ArrayList<ControlVehiculo>();
		  		  
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
		controlvehiculos = new  ArrayList<ControlVehiculo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			controlvehiculos=controlvehiculoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarControlVehiculo(controlvehiculos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculos);
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
		controlvehiculos = new  ArrayList<ControlVehiculo>();
		  		  
        try {
			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			controlvehiculos=controlvehiculoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarControlVehiculo(controlvehiculos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculos);
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
		controlvehiculos = new  ArrayList<ControlVehiculo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			controlvehiculos=controlvehiculoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarControlVehiculo(controlvehiculos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculos);
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
		controlvehiculos = new  ArrayList<ControlVehiculo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			controlvehiculos=controlvehiculoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarControlVehiculo(controlvehiculos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		controlvehiculo = new  ControlVehiculo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			controlvehiculo=controlvehiculoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarControlVehiculo(controlvehiculo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculo);
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
		controlvehiculo = new  ControlVehiculo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			controlvehiculo=controlvehiculoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarControlVehiculo(controlvehiculo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		controlvehiculos = new  ArrayList<ControlVehiculo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			controlvehiculos=controlvehiculoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarControlVehiculo(controlvehiculos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculos);
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
		controlvehiculos = new  ArrayList<ControlVehiculo>();
		  		  
        try {
			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			controlvehiculos=controlvehiculoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarControlVehiculo(controlvehiculos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosControlVehiculosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		controlvehiculos = new  ArrayList<ControlVehiculo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-getTodosControlVehiculosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			controlvehiculos=controlvehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarControlVehiculo(controlvehiculos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculos);
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
	
	public  void  getTodosControlVehiculos(String sFinalQuery,Pagination pagination)throws Exception {
		controlvehiculos = new  ArrayList<ControlVehiculo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			controlvehiculos=controlvehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarControlVehiculo(controlvehiculos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarControlVehiculo(ControlVehiculo controlvehiculo) throws Exception {
		Boolean estaValidado=false;
		
		if(controlvehiculo.getIsNew() || controlvehiculo.getIsChanged()) { 
			this.invalidValues = controlvehiculoValidator.getInvalidValues(controlvehiculo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(controlvehiculo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarControlVehiculo(List<ControlVehiculo> ControlVehiculos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ControlVehiculo controlvehiculoLocal:controlvehiculos) {				
			estaValidadoObjeto=this.validarGuardarControlVehiculo(controlvehiculoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarControlVehiculo(List<ControlVehiculo> ControlVehiculos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarControlVehiculo(controlvehiculos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarControlVehiculo(ControlVehiculo ControlVehiculo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarControlVehiculo(controlvehiculo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ControlVehiculo controlvehiculo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+controlvehiculo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ControlVehiculoConstantesFunciones.getControlVehiculoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"controlvehiculo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ControlVehiculoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ControlVehiculoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveControlVehiculoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-saveControlVehiculoWithConnection");connexion.begin();			
			
			ControlVehiculoLogicAdditional.checkControlVehiculoToSave(this.controlvehiculo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ControlVehiculoLogicAdditional.updateControlVehiculoToSave(this.controlvehiculo,this.arrDatoGeneral);
			
			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.controlvehiculo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowControlVehiculo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarControlVehiculo(this.controlvehiculo)) {
				ControlVehiculoDataAccess.save(this.controlvehiculo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.controlvehiculo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ControlVehiculoLogicAdditional.checkControlVehiculoToSaveAfter(this.controlvehiculo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowControlVehiculo();
			
			connexion.commit();			
			
			if(this.controlvehiculo.getIsDeleted()) {
				this.controlvehiculo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveControlVehiculo()throws Exception {	
		try {	
			
			ControlVehiculoLogicAdditional.checkControlVehiculoToSave(this.controlvehiculo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ControlVehiculoLogicAdditional.updateControlVehiculoToSave(this.controlvehiculo,this.arrDatoGeneral);
			
			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.controlvehiculo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarControlVehiculo(this.controlvehiculo)) {			
				ControlVehiculoDataAccess.save(this.controlvehiculo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.controlvehiculo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ControlVehiculoLogicAdditional.checkControlVehiculoToSaveAfter(this.controlvehiculo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.controlvehiculo.getIsDeleted()) {
				this.controlvehiculo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveControlVehiculosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-saveControlVehiculosWithConnection");connexion.begin();			
			
			ControlVehiculoLogicAdditional.checkControlVehiculoToSaves(controlvehiculos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowControlVehiculos();
			
			Boolean validadoTodosControlVehiculo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ControlVehiculo controlvehiculoLocal:controlvehiculos) {		
				if(controlvehiculoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ControlVehiculoLogicAdditional.updateControlVehiculoToSave(controlvehiculoLocal,this.arrDatoGeneral);
	        	
				ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),controlvehiculoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarControlVehiculo(controlvehiculoLocal)) {
					ControlVehiculoDataAccess.save(controlvehiculoLocal, connexion);				
				} else {
					validadoTodosControlVehiculo=false;
				}
			}
			
			if(!validadoTodosControlVehiculo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ControlVehiculoLogicAdditional.checkControlVehiculoToSavesAfter(controlvehiculos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowControlVehiculos();
			
			connexion.commit();		
			
			this.quitarControlVehiculosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveControlVehiculos()throws Exception {				
		 try {	
			ControlVehiculoLogicAdditional.checkControlVehiculoToSaves(controlvehiculos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosControlVehiculo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ControlVehiculo controlvehiculoLocal:controlvehiculos) {				
				if(controlvehiculoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ControlVehiculoLogicAdditional.updateControlVehiculoToSave(controlvehiculoLocal,this.arrDatoGeneral);
	        	
				ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),controlvehiculoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarControlVehiculo(controlvehiculoLocal)) {				
					ControlVehiculoDataAccess.save(controlvehiculoLocal, connexion);				
				} else {
					validadoTodosControlVehiculo=false;
				}
			}
			
			if(!validadoTodosControlVehiculo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ControlVehiculoLogicAdditional.checkControlVehiculoToSavesAfter(controlvehiculos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarControlVehiculosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ControlVehiculoParameterReturnGeneral procesarAccionControlVehiculos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ControlVehiculo> controlvehiculos,ControlVehiculoParameterReturnGeneral controlvehiculoParameterGeneral)throws Exception {
		 try {	
			ControlVehiculoParameterReturnGeneral controlvehiculoReturnGeneral=new ControlVehiculoParameterReturnGeneral();
	
			ControlVehiculoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,controlvehiculos,controlvehiculoParameterGeneral,controlvehiculoReturnGeneral);
			
			return controlvehiculoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ControlVehiculoParameterReturnGeneral procesarAccionControlVehiculosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ControlVehiculo> controlvehiculos,ControlVehiculoParameterReturnGeneral controlvehiculoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-procesarAccionControlVehiculosWithConnection");connexion.begin();			
			
			ControlVehiculoParameterReturnGeneral controlvehiculoReturnGeneral=new ControlVehiculoParameterReturnGeneral();
	
			ControlVehiculoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,controlvehiculos,controlvehiculoParameterGeneral,controlvehiculoReturnGeneral);
			
			this.connexion.commit();
			
			return controlvehiculoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ControlVehiculoParameterReturnGeneral procesarEventosControlVehiculos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ControlVehiculo> controlvehiculos,ControlVehiculo controlvehiculo,ControlVehiculoParameterReturnGeneral controlvehiculoParameterGeneral,Boolean isEsNuevoControlVehiculo,ArrayList<Classe> clases)throws Exception {
		 try {	
			ControlVehiculoParameterReturnGeneral controlvehiculoReturnGeneral=new ControlVehiculoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				controlvehiculoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ControlVehiculoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,controlvehiculos,controlvehiculo,controlvehiculoParameterGeneral,controlvehiculoReturnGeneral,isEsNuevoControlVehiculo,clases);
			
			return controlvehiculoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ControlVehiculoParameterReturnGeneral procesarEventosControlVehiculosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ControlVehiculo> controlvehiculos,ControlVehiculo controlvehiculo,ControlVehiculoParameterReturnGeneral controlvehiculoParameterGeneral,Boolean isEsNuevoControlVehiculo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-procesarEventosControlVehiculosWithConnection");connexion.begin();			
			
			ControlVehiculoParameterReturnGeneral controlvehiculoReturnGeneral=new ControlVehiculoParameterReturnGeneral();
	
			controlvehiculoReturnGeneral.setControlVehiculo(controlvehiculo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				controlvehiculoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ControlVehiculoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,controlvehiculos,controlvehiculo,controlvehiculoParameterGeneral,controlvehiculoReturnGeneral,isEsNuevoControlVehiculo,clases);
			
			this.connexion.commit();
			
			return controlvehiculoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ControlVehiculoParameterReturnGeneral procesarImportacionControlVehiculosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ControlVehiculoParameterReturnGeneral controlvehiculoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-procesarImportacionControlVehiculosWithConnection");connexion.begin();			
			
			ControlVehiculoParameterReturnGeneral controlvehiculoReturnGeneral=new ControlVehiculoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.controlvehiculos=new ArrayList<ControlVehiculo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.controlvehiculo=new ControlVehiculo();
				
				
				if(conColumnasBase) {this.controlvehiculo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.controlvehiculo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.controlvehiculo.setnombre_conductor(arrColumnas[iColumn++]);
				this.controlvehiculo.setnumero_placa(arrColumnas[iColumn++]);
				this.controlvehiculo.setfecha_entrada(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.controlvehiculo.setfecha_salida(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				
				this.controlvehiculos.add(this.controlvehiculo);
			}
			
			this.saveControlVehiculos();
			
			this.connexion.commit();
			
			controlvehiculoReturnGeneral.setConRetornoEstaProcesado(true);
			controlvehiculoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return controlvehiculoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarControlVehiculosEliminados() throws Exception {				
		
		List<ControlVehiculo> controlvehiculosAux= new ArrayList<ControlVehiculo>();
		
		for(ControlVehiculo controlvehiculo:controlvehiculos) {
			if(!controlvehiculo.getIsDeleted()) {
				controlvehiculosAux.add(controlvehiculo);
			}
		}
		
		controlvehiculos=controlvehiculosAux;
	}
	
	public void quitarControlVehiculosNulos() throws Exception {				
		
		List<ControlVehiculo> controlvehiculosAux= new ArrayList<ControlVehiculo>();
		
		for(ControlVehiculo controlvehiculo : this.controlvehiculos) {
			if(controlvehiculo==null) {
				controlvehiculosAux.add(controlvehiculo);
			}
		}
		
		//this.controlvehiculos=controlvehiculosAux;
		
		this.controlvehiculos.removeAll(controlvehiculosAux);
	}
	
	public void getSetVersionRowControlVehiculoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(controlvehiculo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((controlvehiculo.getIsDeleted() || (controlvehiculo.getIsChanged()&&!controlvehiculo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=controlvehiculoDataAccess.getSetVersionRowControlVehiculo(connexion,controlvehiculo.getId());
				
				if(!controlvehiculo.getVersionRow().equals(timestamp)) {	
					controlvehiculo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				controlvehiculo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowControlVehiculo()throws Exception {	
		
		if(controlvehiculo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((controlvehiculo.getIsDeleted() || (controlvehiculo.getIsChanged()&&!controlvehiculo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=controlvehiculoDataAccess.getSetVersionRowControlVehiculo(connexion,controlvehiculo.getId());
			
			try {							
				if(!controlvehiculo.getVersionRow().equals(timestamp)) {	
					controlvehiculo.setVersionRow(timestamp);
				}
				
				controlvehiculo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowControlVehiculosWithConnection()throws Exception {	
		if(controlvehiculos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ControlVehiculo controlvehiculoAux:controlvehiculos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(controlvehiculoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(controlvehiculoAux.getIsDeleted() || (controlvehiculoAux.getIsChanged()&&!controlvehiculoAux.getIsNew())) {
						
						timestamp=controlvehiculoDataAccess.getSetVersionRowControlVehiculo(connexion,controlvehiculoAux.getId());
						
						if(!controlvehiculo.getVersionRow().equals(timestamp)) {	
							controlvehiculoAux.setVersionRow(timestamp);
						}
								
						controlvehiculoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowControlVehiculos()throws Exception {	
		if(controlvehiculos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ControlVehiculo controlvehiculoAux:controlvehiculos) {
					if(controlvehiculoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(controlvehiculoAux.getIsDeleted() || (controlvehiculoAux.getIsChanged()&&!controlvehiculoAux.getIsNew())) {
						
						timestamp=controlvehiculoDataAccess.getSetVersionRowControlVehiculo(connexion,controlvehiculoAux.getId());
						
						if(!controlvehiculoAux.getVersionRow().equals(timestamp)) {	
							controlvehiculoAux.setVersionRow(timestamp);
						}
						
													
						controlvehiculoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ControlVehiculoParameterReturnGeneral cargarCombosLoteForeignKeyControlVehiculoWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		ControlVehiculoParameterReturnGeneral  controlvehiculoReturnGeneral =new ControlVehiculoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-cargarCombosLoteForeignKeyControlVehiculoWithConnection");connexion.begin();
			
			controlvehiculoReturnGeneral =new ControlVehiculoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			controlvehiculoReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return controlvehiculoReturnGeneral;
	}
	
	public ControlVehiculoParameterReturnGeneral cargarCombosLoteForeignKeyControlVehiculo(String finalQueryGlobalEmpresa) throws Exception {
		ControlVehiculoParameterReturnGeneral  controlvehiculoReturnGeneral =new ControlVehiculoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			controlvehiculoReturnGeneral =new ControlVehiculoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			controlvehiculoReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return controlvehiculoReturnGeneral;
	}
	
	
	public void deepLoad(ControlVehiculo controlvehiculo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ControlVehiculoLogicAdditional.updateControlVehiculoToGet(controlvehiculo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		controlvehiculo.setEmpresa(controlvehiculoDataAccess.getEmpresa(connexion,controlvehiculo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				controlvehiculo.setEmpresa(controlvehiculoDataAccess.getEmpresa(connexion,controlvehiculo));
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
			controlvehiculo.setEmpresa(controlvehiculoDataAccess.getEmpresa(connexion,controlvehiculo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		controlvehiculo.setEmpresa(controlvehiculoDataAccess.getEmpresa(connexion,controlvehiculo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(controlvehiculo.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				controlvehiculo.setEmpresa(controlvehiculoDataAccess.getEmpresa(connexion,controlvehiculo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(controlvehiculo.getEmpresa(),isDeep,deepLoadType,clases);				
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
			controlvehiculo.setEmpresa(controlvehiculoDataAccess.getEmpresa(connexion,controlvehiculo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(controlvehiculo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ControlVehiculo controlvehiculo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ControlVehiculoLogicAdditional.updateControlVehiculoToSave(controlvehiculo,this.arrDatoGeneral);
			
ControlVehiculoDataAccess.save(controlvehiculo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(controlvehiculo.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(controlvehiculo.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(controlvehiculo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(controlvehiculo.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(controlvehiculo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(controlvehiculo.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ControlVehiculo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(controlvehiculo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(controlvehiculo);
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
			this.deepLoad(this.controlvehiculo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ControlVehiculo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(controlvehiculos!=null) {
				for(ControlVehiculo controlvehiculo:controlvehiculos) {
					this.deepLoad(controlvehiculo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(controlvehiculos);
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
			if(controlvehiculos!=null) {
				for(ControlVehiculo controlvehiculo:controlvehiculos) {
					this.deepLoad(controlvehiculo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(controlvehiculos);
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
			this.getNewConnexionToDeep(ControlVehiculo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(controlvehiculo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ControlVehiculo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(controlvehiculos!=null) {
				for(ControlVehiculo controlvehiculo:controlvehiculos) {
					this.deepSave(controlvehiculo,isDeep,deepLoadType,clases);
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
			if(controlvehiculos!=null) {
				for(ControlVehiculo controlvehiculo:controlvehiculos) {
					this.deepSave(controlvehiculo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getControlVehiculosBusquedaPorFechaEntradaWithConnection(String sFinalQuery,Pagination pagination,Date fecha_entrada)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaEntrada= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaEntrada.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_entrada,ControlVehiculoConstantesFunciones.FECHAENTRADA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaEntrada);

			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaEntrada","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			controlvehiculos=controlvehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getControlVehiculosBusquedaPorFechaEntrada(String sFinalQuery,Pagination pagination,Date fecha_entrada)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaEntrada= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaEntrada.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_entrada,ControlVehiculoConstantesFunciones.FECHAENTRADA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaEntrada);

			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaEntrada","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			controlvehiculos=controlvehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getControlVehiculosBusquedaPorFechaSalidaWithConnection(String sFinalQuery,Pagination pagination,Date fecha_salida)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaSalida= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaSalida.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_salida,ControlVehiculoConstantesFunciones.FECHASALIDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaSalida);

			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaSalida","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			controlvehiculos=controlvehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getControlVehiculosBusquedaPorFechaSalida(String sFinalQuery,Pagination pagination,Date fecha_salida)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaSalida= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaSalida.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_salida,ControlVehiculoConstantesFunciones.FECHASALIDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaSalida);

			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaSalida","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			controlvehiculos=controlvehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getControlVehiculosBusquedaPorNombreConductorWithConnection(String sFinalQuery,Pagination pagination,String nombre_conductor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombreConductor= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombreConductor.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_conductor+"%",ControlVehiculoConstantesFunciones.NOMBRECONDUCTOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombreConductor);

			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombreConductor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			controlvehiculos=controlvehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getControlVehiculosBusquedaPorNombreConductor(String sFinalQuery,Pagination pagination,String nombre_conductor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombreConductor= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombreConductor.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_conductor+"%",ControlVehiculoConstantesFunciones.NOMBRECONDUCTOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombreConductor);

			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombreConductor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			controlvehiculos=controlvehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getControlVehiculosBusquedaPorNumeroPlacaWithConnection(String sFinalQuery,Pagination pagination,String numero_placa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroPlaca= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroPlaca.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_placa+"%",ControlVehiculoConstantesFunciones.NUMEROPLACA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroPlaca);

			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroPlaca","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			controlvehiculos=controlvehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getControlVehiculosBusquedaPorNumeroPlaca(String sFinalQuery,Pagination pagination,String numero_placa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroPlaca= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroPlaca.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_placa+"%",ControlVehiculoConstantesFunciones.NUMEROPLACA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroPlaca);

			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroPlaca","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			controlvehiculos=controlvehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getControlVehiculosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ControlVehiculo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ControlVehiculoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			controlvehiculos=controlvehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getControlVehiculosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ControlVehiculoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ControlVehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			controlvehiculos=controlvehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ControlVehiculoConstantesFunciones.refrescarForeignKeysDescripcionesControlVehiculo(this.controlvehiculos);
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
			if(ControlVehiculoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ControlVehiculoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ControlVehiculo controlvehiculo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ControlVehiculoConstantesFunciones.ISCONAUDITORIA) {
				if(controlvehiculo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ControlVehiculoDataAccess.TABLENAME, controlvehiculo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ControlVehiculoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ControlVehiculoLogic.registrarAuditoriaDetallesControlVehiculo(connexion,controlvehiculo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(controlvehiculo.getIsDeleted()) {
					/*if(!controlvehiculo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ControlVehiculoDataAccess.TABLENAME, controlvehiculo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ControlVehiculoLogic.registrarAuditoriaDetallesControlVehiculo(connexion,controlvehiculo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ControlVehiculoDataAccess.TABLENAME, controlvehiculo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(controlvehiculo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ControlVehiculoDataAccess.TABLENAME, controlvehiculo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ControlVehiculoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ControlVehiculoLogic.registrarAuditoriaDetallesControlVehiculo(connexion,controlvehiculo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesControlVehiculo(Connexion connexion,ControlVehiculo controlvehiculo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(controlvehiculo.getIsNew()||!controlvehiculo.getid_empresa().equals(controlvehiculo.getControlVehiculoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(controlvehiculo.getControlVehiculoOriginal().getid_empresa()!=null)
				{
					strValorActual=controlvehiculo.getControlVehiculoOriginal().getid_empresa().toString();
				}
				if(controlvehiculo.getid_empresa()!=null)
				{
					strValorNuevo=controlvehiculo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ControlVehiculoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(controlvehiculo.getIsNew()||!controlvehiculo.getnombre_conductor().equals(controlvehiculo.getControlVehiculoOriginal().getnombre_conductor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(controlvehiculo.getControlVehiculoOriginal().getnombre_conductor()!=null)
				{
					strValorActual=controlvehiculo.getControlVehiculoOriginal().getnombre_conductor();
				}
				if(controlvehiculo.getnombre_conductor()!=null)
				{
					strValorNuevo=controlvehiculo.getnombre_conductor() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ControlVehiculoConstantesFunciones.NOMBRECONDUCTOR,strValorActual,strValorNuevo);
			}	
			
			if(controlvehiculo.getIsNew()||!controlvehiculo.getnumero_placa().equals(controlvehiculo.getControlVehiculoOriginal().getnumero_placa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(controlvehiculo.getControlVehiculoOriginal().getnumero_placa()!=null)
				{
					strValorActual=controlvehiculo.getControlVehiculoOriginal().getnumero_placa();
				}
				if(controlvehiculo.getnumero_placa()!=null)
				{
					strValorNuevo=controlvehiculo.getnumero_placa() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ControlVehiculoConstantesFunciones.NUMEROPLACA,strValorActual,strValorNuevo);
			}	
			
			if(controlvehiculo.getIsNew()||!controlvehiculo.getfecha_entrada().equals(controlvehiculo.getControlVehiculoOriginal().getfecha_entrada()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(controlvehiculo.getControlVehiculoOriginal().getfecha_entrada()!=null)
				{
					strValorActual=controlvehiculo.getControlVehiculoOriginal().getfecha_entrada().toString();
				}
				if(controlvehiculo.getfecha_entrada()!=null)
				{
					strValorNuevo=controlvehiculo.getfecha_entrada().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ControlVehiculoConstantesFunciones.FECHAENTRADA,strValorActual,strValorNuevo);
			}	
			
			if(controlvehiculo.getIsNew()||!controlvehiculo.getfecha_salida().equals(controlvehiculo.getControlVehiculoOriginal().getfecha_salida()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(controlvehiculo.getControlVehiculoOriginal().getfecha_salida()!=null)
				{
					strValorActual=controlvehiculo.getControlVehiculoOriginal().getfecha_salida().toString();
				}
				if(controlvehiculo.getfecha_salida()!=null)
				{
					strValorNuevo=controlvehiculo.getfecha_salida().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ControlVehiculoConstantesFunciones.FECHASALIDA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveControlVehiculoRelacionesWithConnection(ControlVehiculo controlvehiculo) throws Exception {

		if(!controlvehiculo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveControlVehiculoRelacionesBase(controlvehiculo,true);
		}
	}

	public void saveControlVehiculoRelaciones(ControlVehiculo controlvehiculo)throws Exception {

		if(!controlvehiculo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveControlVehiculoRelacionesBase(controlvehiculo,false);
		}
	}

	public void saveControlVehiculoRelacionesBase(ControlVehiculo controlvehiculo,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ControlVehiculo-saveRelacionesWithConnection");}
	

			this.setControlVehiculo(controlvehiculo);

			if(ControlVehiculoLogicAdditional.validarSaveRelaciones(controlvehiculo,this)) {

				ControlVehiculoLogicAdditional.updateRelacionesToSave(controlvehiculo,this);

				if((controlvehiculo.getIsNew()||controlvehiculo.getIsChanged())&&!controlvehiculo.getIsDeleted()) {
					this.saveControlVehiculo();
					this.saveControlVehiculoRelacionesDetalles();

				} else if(controlvehiculo.getIsDeleted()) {
					this.saveControlVehiculoRelacionesDetalles();
					this.saveControlVehiculo();
				}

				ControlVehiculoLogicAdditional.updateRelacionesToSaveAfter(controlvehiculo,this);

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
	
	
	private void saveControlVehiculoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfControlVehiculo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ControlVehiculoConstantesFunciones.getClassesForeignKeysOfControlVehiculo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfControlVehiculo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ControlVehiculoConstantesFunciones.getClassesRelationshipsOfControlVehiculo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

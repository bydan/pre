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
package com.bydan.erp.activosfijos.business.logic;

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
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.activosfijos.util.VehiculoConstantesFunciones;
import com.bydan.erp.activosfijos.util.VehiculoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.VehiculoParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.Vehiculo;
import com.bydan.erp.activosfijos.business.logic.VehiculoLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;








@SuppressWarnings("unused")
public class VehiculoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(VehiculoLogic.class);
	
	protected VehiculoDataAccess vehiculoDataAccess; 	
	protected Vehiculo vehiculo;
	protected List<Vehiculo> vehiculos;
	protected Object vehiculoObject;	
	protected List<Object> vehiculosObject;
	
	public static ClassValidator<Vehiculo> vehiculoValidator = new ClassValidator<Vehiculo>(Vehiculo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected VehiculoLogicAdditional vehiculoLogicAdditional=null;
	
	public VehiculoLogicAdditional getVehiculoLogicAdditional() {
		return this.vehiculoLogicAdditional;
	}
	
	public void setVehiculoLogicAdditional(VehiculoLogicAdditional vehiculoLogicAdditional) {
		try {
			this.vehiculoLogicAdditional=vehiculoLogicAdditional;
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
	
	
	
	
	public  VehiculoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.vehiculoDataAccess = new VehiculoDataAccess();
			
			this.vehiculos= new ArrayList<Vehiculo>();
			this.vehiculo= new Vehiculo();
			
			this.vehiculoObject=new Object();
			this.vehiculosObject=new ArrayList<Object>();
				
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
			
			this.vehiculoDataAccess.setConnexionType(this.connexionType);
			this.vehiculoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  VehiculoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.vehiculoDataAccess = new VehiculoDataAccess();
			this.vehiculos= new ArrayList<Vehiculo>();
			this.vehiculo= new Vehiculo();
			this.vehiculoObject=new Object();
			this.vehiculosObject=new ArrayList<Object>();
			
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
			
			this.vehiculoDataAccess.setConnexionType(this.connexionType);
			this.vehiculoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Vehiculo getVehiculo() throws Exception {	
		VehiculoLogicAdditional.checkVehiculoToGet(vehiculo,this.datosCliente,this.arrDatoGeneral);
		VehiculoLogicAdditional.updateVehiculoToGet(vehiculo,this.arrDatoGeneral);
		
		return vehiculo;
	}
		
	public void setVehiculo(Vehiculo newVehiculo) {
		this.vehiculo = newVehiculo;
	}
	
	public VehiculoDataAccess getVehiculoDataAccess() {
		return vehiculoDataAccess;
	}
	
	public void setVehiculoDataAccess(VehiculoDataAccess newvehiculoDataAccess) {
		this.vehiculoDataAccess = newvehiculoDataAccess;
	}
	
	public List<Vehiculo> getVehiculos() throws Exception {		
		this.quitarVehiculosNulos();
		
		VehiculoLogicAdditional.checkVehiculoToGets(vehiculos,this.datosCliente,this.arrDatoGeneral);
		
		for (Vehiculo vehiculoLocal: vehiculos ) {
			VehiculoLogicAdditional.updateVehiculoToGet(vehiculoLocal,this.arrDatoGeneral);
		}
		
		return vehiculos;
	}
	
	public void setVehiculos(List<Vehiculo> newVehiculos) {
		this.vehiculos = newVehiculos;
	}
	
	public Object getVehiculoObject() {	
		this.vehiculoObject=this.vehiculoDataAccess.getEntityObject();
		return this.vehiculoObject;
	}
		
	public void setVehiculoObject(Object newVehiculoObject) {
		this.vehiculoObject = newVehiculoObject;
	}
	
	public List<Object> getVehiculosObject() {		
		this.vehiculosObject=this.vehiculoDataAccess.getEntitiesObject();
		return this.vehiculosObject;
	}
		
	public void setVehiculosObject(List<Object> newVehiculosObject) {
		this.vehiculosObject = newVehiculosObject;
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
		
		if(this.vehiculoDataAccess!=null) {
			this.vehiculoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			vehiculoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			vehiculoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		vehiculo = new  Vehiculo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			vehiculo=vehiculoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vehiculo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculo);
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
		vehiculo = new  Vehiculo();
		  		  
        try {
			
			vehiculo=vehiculoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vehiculo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		vehiculo = new  Vehiculo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			vehiculo=vehiculoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vehiculo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculo);
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
		vehiculo = new  Vehiculo();
		  		  
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
		vehiculo = new  Vehiculo();
		  		  
        try {
			
			vehiculo=vehiculoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vehiculo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		vehiculo = new  Vehiculo();
		  		  
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
		vehiculo = new  Vehiculo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =vehiculoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		vehiculo = new  Vehiculo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=vehiculoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		vehiculo = new  Vehiculo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =vehiculoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		vehiculo = new  Vehiculo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=vehiculoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		vehiculo = new  Vehiculo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =vehiculoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		vehiculo = new  Vehiculo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=vehiculoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		vehiculos = new  ArrayList<Vehiculo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculos=vehiculoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVehiculo(vehiculos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculos);
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
		vehiculos = new  ArrayList<Vehiculo>();
		  		  
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
		vehiculos = new  ArrayList<Vehiculo>();
		  		  
        try {			
			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculos=vehiculoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarVehiculo(vehiculos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		vehiculos = new  ArrayList<Vehiculo>();
		  		  
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
		vehiculos = new  ArrayList<Vehiculo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculos=vehiculoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVehiculo(vehiculos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculos);
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
		vehiculos = new  ArrayList<Vehiculo>();
		  		  
        try {
			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculos=vehiculoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVehiculo(vehiculos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculos);
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
		vehiculos = new  ArrayList<Vehiculo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculos=vehiculoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVehiculo(vehiculos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculos);
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
		vehiculos = new  ArrayList<Vehiculo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculos=vehiculoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVehiculo(vehiculos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		vehiculo = new  Vehiculo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculo=vehiculoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVehiculo(vehiculo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculo);
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
		vehiculo = new  Vehiculo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculo=vehiculoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVehiculo(vehiculo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		vehiculos = new  ArrayList<Vehiculo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculos=vehiculoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVehiculo(vehiculos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculos);
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
		vehiculos = new  ArrayList<Vehiculo>();
		  		  
        try {
			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculos=vehiculoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVehiculo(vehiculos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosVehiculosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		vehiculos = new  ArrayList<Vehiculo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-getTodosVehiculosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculos=vehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarVehiculo(vehiculos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculos);
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
	
	public  void  getTodosVehiculos(String sFinalQuery,Pagination pagination)throws Exception {
		vehiculos = new  ArrayList<Vehiculo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vehiculos=vehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarVehiculo(vehiculos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarVehiculo(Vehiculo vehiculo) throws Exception {
		Boolean estaValidado=false;
		
		if(vehiculo.getIsNew() || vehiculo.getIsChanged()) { 
			this.invalidValues = vehiculoValidator.getInvalidValues(vehiculo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(vehiculo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarVehiculo(List<Vehiculo> Vehiculos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Vehiculo vehiculoLocal:vehiculos) {				
			estaValidadoObjeto=this.validarGuardarVehiculo(vehiculoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarVehiculo(List<Vehiculo> Vehiculos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarVehiculo(vehiculos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarVehiculo(Vehiculo Vehiculo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarVehiculo(vehiculo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Vehiculo vehiculo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+vehiculo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=VehiculoConstantesFunciones.getVehiculoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"vehiculo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(VehiculoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(VehiculoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveVehiculoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-saveVehiculoWithConnection");connexion.begin();			
			
			VehiculoLogicAdditional.checkVehiculoToSave(this.vehiculo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			VehiculoLogicAdditional.updateVehiculoToSave(this.vehiculo,this.arrDatoGeneral);
			
			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.vehiculo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowVehiculo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarVehiculo(this.vehiculo)) {
				VehiculoDataAccess.save(this.vehiculo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.vehiculo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			VehiculoLogicAdditional.checkVehiculoToSaveAfter(this.vehiculo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowVehiculo();
			
			connexion.commit();			
			
			if(this.vehiculo.getIsDeleted()) {
				this.vehiculo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveVehiculo()throws Exception {	
		try {	
			
			VehiculoLogicAdditional.checkVehiculoToSave(this.vehiculo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			VehiculoLogicAdditional.updateVehiculoToSave(this.vehiculo,this.arrDatoGeneral);
			
			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.vehiculo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarVehiculo(this.vehiculo)) {			
				VehiculoDataAccess.save(this.vehiculo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.vehiculo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			VehiculoLogicAdditional.checkVehiculoToSaveAfter(this.vehiculo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.vehiculo.getIsDeleted()) {
				this.vehiculo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveVehiculosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-saveVehiculosWithConnection");connexion.begin();			
			
			VehiculoLogicAdditional.checkVehiculoToSaves(vehiculos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowVehiculos();
			
			Boolean validadoTodosVehiculo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Vehiculo vehiculoLocal:vehiculos) {		
				if(vehiculoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				VehiculoLogicAdditional.updateVehiculoToSave(vehiculoLocal,this.arrDatoGeneral);
	        	
				VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),vehiculoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarVehiculo(vehiculoLocal)) {
					VehiculoDataAccess.save(vehiculoLocal, connexion);				
				} else {
					validadoTodosVehiculo=false;
				}
			}
			
			if(!validadoTodosVehiculo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			VehiculoLogicAdditional.checkVehiculoToSavesAfter(vehiculos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowVehiculos();
			
			connexion.commit();		
			
			this.quitarVehiculosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveVehiculos()throws Exception {				
		 try {	
			VehiculoLogicAdditional.checkVehiculoToSaves(vehiculos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosVehiculo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Vehiculo vehiculoLocal:vehiculos) {				
				if(vehiculoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				VehiculoLogicAdditional.updateVehiculoToSave(vehiculoLocal,this.arrDatoGeneral);
	        	
				VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),vehiculoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarVehiculo(vehiculoLocal)) {				
					VehiculoDataAccess.save(vehiculoLocal, connexion);				
				} else {
					validadoTodosVehiculo=false;
				}
			}
			
			if(!validadoTodosVehiculo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			VehiculoLogicAdditional.checkVehiculoToSavesAfter(vehiculos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarVehiculosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public VehiculoParameterReturnGeneral procesarAccionVehiculos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Vehiculo> vehiculos,VehiculoParameterReturnGeneral vehiculoParameterGeneral)throws Exception {
		 try {	
			VehiculoParameterReturnGeneral vehiculoReturnGeneral=new VehiculoParameterReturnGeneral();
	
			VehiculoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,vehiculos,vehiculoParameterGeneral,vehiculoReturnGeneral);
			
			return vehiculoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public VehiculoParameterReturnGeneral procesarAccionVehiculosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Vehiculo> vehiculos,VehiculoParameterReturnGeneral vehiculoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-procesarAccionVehiculosWithConnection");connexion.begin();			
			
			VehiculoParameterReturnGeneral vehiculoReturnGeneral=new VehiculoParameterReturnGeneral();
	
			VehiculoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,vehiculos,vehiculoParameterGeneral,vehiculoReturnGeneral);
			
			this.connexion.commit();
			
			return vehiculoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public VehiculoParameterReturnGeneral procesarEventosVehiculos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Vehiculo> vehiculos,Vehiculo vehiculo,VehiculoParameterReturnGeneral vehiculoParameterGeneral,Boolean isEsNuevoVehiculo,ArrayList<Classe> clases)throws Exception {
		 try {	
			VehiculoParameterReturnGeneral vehiculoReturnGeneral=new VehiculoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				vehiculoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			VehiculoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,vehiculos,vehiculo,vehiculoParameterGeneral,vehiculoReturnGeneral,isEsNuevoVehiculo,clases);
			
			return vehiculoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public VehiculoParameterReturnGeneral procesarEventosVehiculosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Vehiculo> vehiculos,Vehiculo vehiculo,VehiculoParameterReturnGeneral vehiculoParameterGeneral,Boolean isEsNuevoVehiculo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-procesarEventosVehiculosWithConnection");connexion.begin();			
			
			VehiculoParameterReturnGeneral vehiculoReturnGeneral=new VehiculoParameterReturnGeneral();
	
			vehiculoReturnGeneral.setVehiculo(vehiculo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				vehiculoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			VehiculoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,vehiculos,vehiculo,vehiculoParameterGeneral,vehiculoReturnGeneral,isEsNuevoVehiculo,clases);
			
			this.connexion.commit();
			
			return vehiculoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public VehiculoParameterReturnGeneral procesarImportacionVehiculosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,VehiculoParameterReturnGeneral vehiculoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-procesarImportacionVehiculosWithConnection");connexion.begin();			
			
			VehiculoParameterReturnGeneral vehiculoReturnGeneral=new VehiculoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.vehiculos=new ArrayList<Vehiculo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.vehiculo=new Vehiculo();
				
				
				if(conColumnasBase) {this.vehiculo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.vehiculo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.vehiculo.setnumero_poliza(arrColumnas[iColumn++]);
				this.vehiculo.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.vehiculo.setfecha_vencimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.vehiculo.setvalor_asegurado(Double.parseDouble(arrColumnas[iColumn++]));
				this.vehiculo.setvalor_deducible(Double.parseDouble(arrColumnas[iColumn++]));
				this.vehiculo.setnumero_matricula(arrColumnas[iColumn++]);
				this.vehiculo.setnumero_motor(arrColumnas[iColumn++]);
				this.vehiculo.setnumero_chasis(arrColumnas[iColumn++]);
				this.vehiculo.setnumero_placa(arrColumnas[iColumn++]);
				this.vehiculo.setvalor_comercial(Double.parseDouble(arrColumnas[iColumn++]));
				this.vehiculo.setdescripcion(arrColumnas[iColumn++]);
				
				this.vehiculos.add(this.vehiculo);
			}
			
			this.saveVehiculos();
			
			this.connexion.commit();
			
			vehiculoReturnGeneral.setConRetornoEstaProcesado(true);
			vehiculoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return vehiculoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarVehiculosEliminados() throws Exception {				
		
		List<Vehiculo> vehiculosAux= new ArrayList<Vehiculo>();
		
		for(Vehiculo vehiculo:vehiculos) {
			if(!vehiculo.getIsDeleted()) {
				vehiculosAux.add(vehiculo);
			}
		}
		
		vehiculos=vehiculosAux;
	}
	
	public void quitarVehiculosNulos() throws Exception {				
		
		List<Vehiculo> vehiculosAux= new ArrayList<Vehiculo>();
		
		for(Vehiculo vehiculo : this.vehiculos) {
			if(vehiculo==null) {
				vehiculosAux.add(vehiculo);
			}
		}
		
		//this.vehiculos=vehiculosAux;
		
		this.vehiculos.removeAll(vehiculosAux);
	}
	
	public void getSetVersionRowVehiculoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(vehiculo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((vehiculo.getIsDeleted() || (vehiculo.getIsChanged()&&!vehiculo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=vehiculoDataAccess.getSetVersionRowVehiculo(connexion,vehiculo.getId());
				
				if(!vehiculo.getVersionRow().equals(timestamp)) {	
					vehiculo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				vehiculo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowVehiculo()throws Exception {	
		
		if(vehiculo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((vehiculo.getIsDeleted() || (vehiculo.getIsChanged()&&!vehiculo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=vehiculoDataAccess.getSetVersionRowVehiculo(connexion,vehiculo.getId());
			
			try {							
				if(!vehiculo.getVersionRow().equals(timestamp)) {	
					vehiculo.setVersionRow(timestamp);
				}
				
				vehiculo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowVehiculosWithConnection()throws Exception {	
		if(vehiculos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Vehiculo vehiculoAux:vehiculos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(vehiculoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(vehiculoAux.getIsDeleted() || (vehiculoAux.getIsChanged()&&!vehiculoAux.getIsNew())) {
						
						timestamp=vehiculoDataAccess.getSetVersionRowVehiculo(connexion,vehiculoAux.getId());
						
						if(!vehiculo.getVersionRow().equals(timestamp)) {	
							vehiculoAux.setVersionRow(timestamp);
						}
								
						vehiculoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowVehiculos()throws Exception {	
		if(vehiculos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Vehiculo vehiculoAux:vehiculos) {
					if(vehiculoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(vehiculoAux.getIsDeleted() || (vehiculoAux.getIsChanged()&&!vehiculoAux.getIsNew())) {
						
						timestamp=vehiculoDataAccess.getSetVersionRowVehiculo(connexion,vehiculoAux.getId());
						
						if(!vehiculoAux.getVersionRow().equals(timestamp)) {	
							vehiculoAux.setVersionRow(timestamp);
						}
						
													
						vehiculoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public VehiculoParameterReturnGeneral cargarCombosLoteForeignKeyVehiculoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalDetalleActivoFijo,String finalQueryGlobalAseguradora) throws Exception {
		VehiculoParameterReturnGeneral  vehiculoReturnGeneral =new VehiculoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-cargarCombosLoteForeignKeyVehiculoWithConnection");connexion.begin();
			
			vehiculoReturnGeneral =new VehiculoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			vehiculoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			vehiculoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<DetalleActivoFijo> detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
			DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
			detalleactivofijoLogic.setConnexion(this.connexion);
			detalleactivofijoLogic.getDetalleActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleActivoFijo.equals("NONE")) {
				detalleactivofijoLogic.getTodosDetalleActivoFijos(finalQueryGlobalDetalleActivoFijo,new Pagination());
				detalleactivofijosForeignKey=detalleactivofijoLogic.getDetalleActivoFijos();
			}

			vehiculoReturnGeneral.setdetalleactivofijosForeignKey(detalleactivofijosForeignKey);


			List<Aseguradora> aseguradorasForeignKey=new ArrayList<Aseguradora>();
			AseguradoraLogic aseguradoraLogic=new AseguradoraLogic();
			aseguradoraLogic.setConnexion(this.connexion);
			aseguradoraLogic.getAseguradoraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAseguradora.equals("NONE")) {
				aseguradoraLogic.getTodosAseguradoras(finalQueryGlobalAseguradora,new Pagination());
				aseguradorasForeignKey=aseguradoraLogic.getAseguradoras();
			}

			vehiculoReturnGeneral.setaseguradorasForeignKey(aseguradorasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return vehiculoReturnGeneral;
	}
	
	public VehiculoParameterReturnGeneral cargarCombosLoteForeignKeyVehiculo(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalDetalleActivoFijo,String finalQueryGlobalAseguradora) throws Exception {
		VehiculoParameterReturnGeneral  vehiculoReturnGeneral =new VehiculoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			vehiculoReturnGeneral =new VehiculoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			vehiculoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			vehiculoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<DetalleActivoFijo> detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
			DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
			detalleactivofijoLogic.setConnexion(this.connexion);
			detalleactivofijoLogic.getDetalleActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleActivoFijo.equals("NONE")) {
				detalleactivofijoLogic.getTodosDetalleActivoFijos(finalQueryGlobalDetalleActivoFijo,new Pagination());
				detalleactivofijosForeignKey=detalleactivofijoLogic.getDetalleActivoFijos();
			}

			vehiculoReturnGeneral.setdetalleactivofijosForeignKey(detalleactivofijosForeignKey);


			List<Aseguradora> aseguradorasForeignKey=new ArrayList<Aseguradora>();
			AseguradoraLogic aseguradoraLogic=new AseguradoraLogic();
			aseguradoraLogic.setConnexion(this.connexion);
			aseguradoraLogic.getAseguradoraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAseguradora.equals("NONE")) {
				aseguradoraLogic.getTodosAseguradoras(finalQueryGlobalAseguradora,new Pagination());
				aseguradorasForeignKey=aseguradoraLogic.getAseguradoras();
			}

			vehiculoReturnGeneral.setaseguradorasForeignKey(aseguradorasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return vehiculoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyVehiculoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ServicioTransporteLogic serviciotransporteLogic=new ServicioTransporteLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyVehiculoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ServicioTransporte.class));
											
			

			serviciotransporteLogic.setConnexion(this.getConnexion());
			serviciotransporteLogic.setDatosCliente(this.datosCliente);
			serviciotransporteLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Vehiculo vehiculo:this.vehiculos) {
				

				classes=new ArrayList<Classe>();
				classes=ServicioTransporteConstantesFunciones.getClassesForeignKeysOfServicioTransporte(new ArrayList<Classe>(),DeepLoadType.NONE);

				serviciotransporteLogic.setServicioTransportes(vehiculo.serviciotransportes);
				serviciotransporteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Vehiculo vehiculo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			VehiculoLogicAdditional.updateVehiculoToGet(vehiculo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		vehiculo.setEmpresa(vehiculoDataAccess.getEmpresa(connexion,vehiculo));
		vehiculo.setSucursal(vehiculoDataAccess.getSucursal(connexion,vehiculo));
		vehiculo.setDetalleActivoFijo(vehiculoDataAccess.getDetalleActivoFijo(connexion,vehiculo));
		vehiculo.setAseguradora(vehiculoDataAccess.getAseguradora(connexion,vehiculo));
		vehiculo.setServicioTransportes(vehiculoDataAccess.getServicioTransportes(connexion,vehiculo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				vehiculo.setEmpresa(vehiculoDataAccess.getEmpresa(connexion,vehiculo));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				vehiculo.setSucursal(vehiculoDataAccess.getSucursal(connexion,vehiculo));
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				vehiculo.setDetalleActivoFijo(vehiculoDataAccess.getDetalleActivoFijo(connexion,vehiculo));
				continue;
			}

			if(clas.clas.equals(Aseguradora.class)) {
				vehiculo.setAseguradora(vehiculoDataAccess.getAseguradora(connexion,vehiculo));
				continue;
			}

			if(clas.clas.equals(ServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vehiculo.setServicioTransportes(vehiculoDataAccess.getServicioTransportes(connexion,vehiculo));

				if(this.isConDeep) {
					ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(this.connexion);
					serviciotransporteLogic.setServicioTransportes(vehiculo.getServicioTransportes());
					ArrayList<Classe> classesLocal=ServicioTransporteConstantesFunciones.getClassesForeignKeysOfServicioTransporte(new ArrayList<Classe>(),DeepLoadType.NONE);
					serviciotransporteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(serviciotransporteLogic.getServicioTransportes());
					vehiculo.setServicioTransportes(serviciotransporteLogic.getServicioTransportes());
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
			vehiculo.setEmpresa(vehiculoDataAccess.getEmpresa(connexion,vehiculo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vehiculo.setSucursal(vehiculoDataAccess.getSucursal(connexion,vehiculo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vehiculo.setDetalleActivoFijo(vehiculoDataAccess.getDetalleActivoFijo(connexion,vehiculo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Aseguradora.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vehiculo.setAseguradora(vehiculoDataAccess.getAseguradora(connexion,vehiculo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ServicioTransporte.class));
			vehiculo.setServicioTransportes(vehiculoDataAccess.getServicioTransportes(connexion,vehiculo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		vehiculo.setEmpresa(vehiculoDataAccess.getEmpresa(connexion,vehiculo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(vehiculo.getEmpresa(),isDeep,deepLoadType,clases);
				
		vehiculo.setSucursal(vehiculoDataAccess.getSucursal(connexion,vehiculo));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(vehiculo.getSucursal(),isDeep,deepLoadType,clases);
				
		vehiculo.setDetalleActivoFijo(vehiculoDataAccess.getDetalleActivoFijo(connexion,vehiculo));
		DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
		detalleactivofijoLogic.deepLoad(vehiculo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				
		vehiculo.setAseguradora(vehiculoDataAccess.getAseguradora(connexion,vehiculo));
		AseguradoraLogic aseguradoraLogic= new AseguradoraLogic(connexion);
		aseguradoraLogic.deepLoad(vehiculo.getAseguradora(),isDeep,deepLoadType,clases);
				

		vehiculo.setServicioTransportes(vehiculoDataAccess.getServicioTransportes(connexion,vehiculo));

		for(ServicioTransporte serviciotransporte:vehiculo.getServicioTransportes()) {
			ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(connexion);
			serviciotransporteLogic.deepLoad(serviciotransporte,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				vehiculo.setEmpresa(vehiculoDataAccess.getEmpresa(connexion,vehiculo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(vehiculo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				vehiculo.setSucursal(vehiculoDataAccess.getSucursal(connexion,vehiculo));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(vehiculo.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				vehiculo.setDetalleActivoFijo(vehiculoDataAccess.getDetalleActivoFijo(connexion,vehiculo));
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepLoad(vehiculo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Aseguradora.class)) {
				vehiculo.setAseguradora(vehiculoDataAccess.getAseguradora(connexion,vehiculo));
				AseguradoraLogic aseguradoraLogic= new AseguradoraLogic(connexion);
				aseguradoraLogic.deepLoad(vehiculo.getAseguradora(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vehiculo.setServicioTransportes(vehiculoDataAccess.getServicioTransportes(connexion,vehiculo));

				for(ServicioTransporte serviciotransporte:vehiculo.getServicioTransportes()) {
					ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(connexion);
					serviciotransporteLogic.deepLoad(serviciotransporte,isDeep,deepLoadType,clases);
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
			vehiculo.setEmpresa(vehiculoDataAccess.getEmpresa(connexion,vehiculo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(vehiculo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vehiculo.setSucursal(vehiculoDataAccess.getSucursal(connexion,vehiculo));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(vehiculo.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vehiculo.setDetalleActivoFijo(vehiculoDataAccess.getDetalleActivoFijo(connexion,vehiculo));
			DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
			detalleactivofijoLogic.deepLoad(vehiculo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Aseguradora.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vehiculo.setAseguradora(vehiculoDataAccess.getAseguradora(connexion,vehiculo));
			AseguradoraLogic aseguradoraLogic= new AseguradoraLogic(connexion);
			aseguradoraLogic.deepLoad(vehiculo.getAseguradora(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ServicioTransporte.class));
			vehiculo.setServicioTransportes(vehiculoDataAccess.getServicioTransportes(connexion,vehiculo));

			for(ServicioTransporte serviciotransporte:vehiculo.getServicioTransportes()) {
				ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(connexion);
				serviciotransporteLogic.deepLoad(serviciotransporte,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Vehiculo vehiculo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			VehiculoLogicAdditional.updateVehiculoToSave(vehiculo,this.arrDatoGeneral);
			
VehiculoDataAccess.save(vehiculo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(vehiculo.getEmpresa(),connexion);

		SucursalDataAccess.save(vehiculo.getSucursal(),connexion);

		DetalleActivoFijoDataAccess.save(vehiculo.getDetalleActivoFijo(),connexion);

		AseguradoraDataAccess.save(vehiculo.getAseguradora(),connexion);

		for(ServicioTransporte serviciotransporte:vehiculo.getServicioTransportes()) {
			serviciotransporte.setid_vehiculo(vehiculo.getId());
			ServicioTransporteDataAccess.save(serviciotransporte,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(vehiculo.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(vehiculo.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				DetalleActivoFijoDataAccess.save(vehiculo.getDetalleActivoFijo(),connexion);
				continue;
			}

			if(clas.clas.equals(Aseguradora.class)) {
				AseguradoraDataAccess.save(vehiculo.getAseguradora(),connexion);
				continue;
			}


			if(clas.clas.equals(ServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ServicioTransporte serviciotransporte:vehiculo.getServicioTransportes()) {
					serviciotransporte.setid_vehiculo(vehiculo.getId());
					ServicioTransporteDataAccess.save(serviciotransporte,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(vehiculo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(vehiculo.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(vehiculo.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(vehiculo.getSucursal(),isDeep,deepLoadType,clases);
				

		DetalleActivoFijoDataAccess.save(vehiculo.getDetalleActivoFijo(),connexion);
		DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
		detalleactivofijoLogic.deepLoad(vehiculo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				

		AseguradoraDataAccess.save(vehiculo.getAseguradora(),connexion);
		AseguradoraLogic aseguradoraLogic= new AseguradoraLogic(connexion);
		aseguradoraLogic.deepLoad(vehiculo.getAseguradora(),isDeep,deepLoadType,clases);
				

		for(ServicioTransporte serviciotransporte:vehiculo.getServicioTransportes()) {
			ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(connexion);
			serviciotransporte.setid_vehiculo(vehiculo.getId());
			ServicioTransporteDataAccess.save(serviciotransporte,connexion);
			serviciotransporteLogic.deepSave(serviciotransporte,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(vehiculo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(vehiculo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(vehiculo.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(vehiculo.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				DetalleActivoFijoDataAccess.save(vehiculo.getDetalleActivoFijo(),connexion);
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepSave(vehiculo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Aseguradora.class)) {
				AseguradoraDataAccess.save(vehiculo.getAseguradora(),connexion);
				AseguradoraLogic aseguradoraLogic= new AseguradoraLogic(connexion);
				aseguradoraLogic.deepSave(vehiculo.getAseguradora(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ServicioTransporte serviciotransporte:vehiculo.getServicioTransportes()) {
					ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(connexion);
					serviciotransporte.setid_vehiculo(vehiculo.getId());
					ServicioTransporteDataAccess.save(serviciotransporte,connexion);
					serviciotransporteLogic.deepSave(serviciotransporte,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Vehiculo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(vehiculo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(vehiculo);
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
			this.deepLoad(this.vehiculo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Vehiculo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(vehiculos!=null) {
				for(Vehiculo vehiculo:vehiculos) {
					this.deepLoad(vehiculo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(vehiculos);
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
			if(vehiculos!=null) {
				for(Vehiculo vehiculo:vehiculos) {
					this.deepLoad(vehiculo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(vehiculos);
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
			this.getNewConnexionToDeep(Vehiculo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(vehiculo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Vehiculo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(vehiculos!=null) {
				for(Vehiculo vehiculo:vehiculos) {
					this.deepSave(vehiculo,isDeep,deepLoadType,clases);
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
			if(vehiculos!=null) {
				for(Vehiculo vehiculo:vehiculos) {
					this.deepSave(vehiculo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getVehiculosFK_IdAseguradoraWithConnection(String sFinalQuery,Pagination pagination,Long id_aseguradora)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAseguradora= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAseguradora.setParameterSelectionGeneralEqual(ParameterType.LONG,id_aseguradora,VehiculoConstantesFunciones.IDASEGURADORA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAseguradora);

			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAseguradora","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vehiculos=vehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVehiculosFK_IdAseguradora(String sFinalQuery,Pagination pagination,Long id_aseguradora)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAseguradora= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAseguradora.setParameterSelectionGeneralEqual(ParameterType.LONG,id_aseguradora,VehiculoConstantesFunciones.IDASEGURADORA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAseguradora);

			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAseguradora","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vehiculos=vehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVehiculosFK_IdDetalleActivoFijoWithConnection(String sFinalQuery,Pagination pagination,Long id_detalle_activo_fijo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_activo_fijo,VehiculoConstantesFunciones.IDDETALLEACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleActivoFijo);

			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vehiculos=vehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVehiculosFK_IdDetalleActivoFijo(String sFinalQuery,Pagination pagination,Long id_detalle_activo_fijo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_activo_fijo,VehiculoConstantesFunciones.IDDETALLEACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleActivoFijo);

			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vehiculos=vehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVehiculosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,VehiculoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vehiculos=vehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVehiculosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,VehiculoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vehiculos=vehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVehiculosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vehiculo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,VehiculoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vehiculos=vehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVehiculosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,VehiculoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			VehiculoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vehiculos=vehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(this.vehiculos);
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
			if(VehiculoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,VehiculoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Vehiculo vehiculo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(VehiculoConstantesFunciones.ISCONAUDITORIA) {
				if(vehiculo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VehiculoDataAccess.TABLENAME, vehiculo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(VehiculoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////VehiculoLogic.registrarAuditoriaDetallesVehiculo(connexion,vehiculo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(vehiculo.getIsDeleted()) {
					/*if(!vehiculo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,VehiculoDataAccess.TABLENAME, vehiculo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////VehiculoLogic.registrarAuditoriaDetallesVehiculo(connexion,vehiculo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VehiculoDataAccess.TABLENAME, vehiculo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(vehiculo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VehiculoDataAccess.TABLENAME, vehiculo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(VehiculoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////VehiculoLogic.registrarAuditoriaDetallesVehiculo(connexion,vehiculo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesVehiculo(Connexion connexion,Vehiculo vehiculo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(vehiculo.getIsNew()||!vehiculo.getid_empresa().equals(vehiculo.getVehiculoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculo.getVehiculoOriginal().getid_empresa()!=null)
				{
					strValorActual=vehiculo.getVehiculoOriginal().getid_empresa().toString();
				}
				if(vehiculo.getid_empresa()!=null)
				{
					strValorNuevo=vehiculo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(vehiculo.getIsNew()||!vehiculo.getid_sucursal().equals(vehiculo.getVehiculoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculo.getVehiculoOriginal().getid_sucursal()!=null)
				{
					strValorActual=vehiculo.getVehiculoOriginal().getid_sucursal().toString();
				}
				if(vehiculo.getid_sucursal()!=null)
				{
					strValorNuevo=vehiculo.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(vehiculo.getIsNew()||!vehiculo.getid_detalle_activo_fijo().equals(vehiculo.getVehiculoOriginal().getid_detalle_activo_fijo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculo.getVehiculoOriginal().getid_detalle_activo_fijo()!=null)
				{
					strValorActual=vehiculo.getVehiculoOriginal().getid_detalle_activo_fijo().toString();
				}
				if(vehiculo.getid_detalle_activo_fijo()!=null)
				{
					strValorNuevo=vehiculo.getid_detalle_activo_fijo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoConstantesFunciones.IDDETALLEACTIVOFIJO,strValorActual,strValorNuevo);
			}	
			
			if(vehiculo.getIsNew()||!vehiculo.getid_aseguradora().equals(vehiculo.getVehiculoOriginal().getid_aseguradora()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculo.getVehiculoOriginal().getid_aseguradora()!=null)
				{
					strValorActual=vehiculo.getVehiculoOriginal().getid_aseguradora().toString();
				}
				if(vehiculo.getid_aseguradora()!=null)
				{
					strValorNuevo=vehiculo.getid_aseguradora().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoConstantesFunciones.IDASEGURADORA,strValorActual,strValorNuevo);
			}	
			
			if(vehiculo.getIsNew()||!vehiculo.getnumero_poliza().equals(vehiculo.getVehiculoOriginal().getnumero_poliza()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculo.getVehiculoOriginal().getnumero_poliza()!=null)
				{
					strValorActual=vehiculo.getVehiculoOriginal().getnumero_poliza();
				}
				if(vehiculo.getnumero_poliza()!=null)
				{
					strValorNuevo=vehiculo.getnumero_poliza() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoConstantesFunciones.NUMEROPOLIZA,strValorActual,strValorNuevo);
			}	
			
			if(vehiculo.getIsNew()||!vehiculo.getfecha_emision().equals(vehiculo.getVehiculoOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculo.getVehiculoOriginal().getfecha_emision()!=null)
				{
					strValorActual=vehiculo.getVehiculoOriginal().getfecha_emision().toString();
				}
				if(vehiculo.getfecha_emision()!=null)
				{
					strValorNuevo=vehiculo.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(vehiculo.getIsNew()||!vehiculo.getfecha_vencimiento().equals(vehiculo.getVehiculoOriginal().getfecha_vencimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculo.getVehiculoOriginal().getfecha_vencimiento()!=null)
				{
					strValorActual=vehiculo.getVehiculoOriginal().getfecha_vencimiento().toString();
				}
				if(vehiculo.getfecha_vencimiento()!=null)
				{
					strValorNuevo=vehiculo.getfecha_vencimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoConstantesFunciones.FECHAVENCIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(vehiculo.getIsNew()||!vehiculo.getvalor_asegurado().equals(vehiculo.getVehiculoOriginal().getvalor_asegurado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculo.getVehiculoOriginal().getvalor_asegurado()!=null)
				{
					strValorActual=vehiculo.getVehiculoOriginal().getvalor_asegurado().toString();
				}
				if(vehiculo.getvalor_asegurado()!=null)
				{
					strValorNuevo=vehiculo.getvalor_asegurado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoConstantesFunciones.VALORASEGURADO,strValorActual,strValorNuevo);
			}	
			
			if(vehiculo.getIsNew()||!vehiculo.getvalor_deducible().equals(vehiculo.getVehiculoOriginal().getvalor_deducible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculo.getVehiculoOriginal().getvalor_deducible()!=null)
				{
					strValorActual=vehiculo.getVehiculoOriginal().getvalor_deducible().toString();
				}
				if(vehiculo.getvalor_deducible()!=null)
				{
					strValorNuevo=vehiculo.getvalor_deducible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoConstantesFunciones.VALORDEDUCIBLE,strValorActual,strValorNuevo);
			}	
			
			if(vehiculo.getIsNew()||!vehiculo.getnumero_matricula().equals(vehiculo.getVehiculoOriginal().getnumero_matricula()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculo.getVehiculoOriginal().getnumero_matricula()!=null)
				{
					strValorActual=vehiculo.getVehiculoOriginal().getnumero_matricula();
				}
				if(vehiculo.getnumero_matricula()!=null)
				{
					strValorNuevo=vehiculo.getnumero_matricula() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoConstantesFunciones.NUMEROMATRICULA,strValorActual,strValorNuevo);
			}	
			
			if(vehiculo.getIsNew()||!vehiculo.getnumero_motor().equals(vehiculo.getVehiculoOriginal().getnumero_motor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculo.getVehiculoOriginal().getnumero_motor()!=null)
				{
					strValorActual=vehiculo.getVehiculoOriginal().getnumero_motor();
				}
				if(vehiculo.getnumero_motor()!=null)
				{
					strValorNuevo=vehiculo.getnumero_motor() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoConstantesFunciones.NUMEROMOTOR,strValorActual,strValorNuevo);
			}	
			
			if(vehiculo.getIsNew()||!vehiculo.getnumero_chasis().equals(vehiculo.getVehiculoOriginal().getnumero_chasis()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculo.getVehiculoOriginal().getnumero_chasis()!=null)
				{
					strValorActual=vehiculo.getVehiculoOriginal().getnumero_chasis();
				}
				if(vehiculo.getnumero_chasis()!=null)
				{
					strValorNuevo=vehiculo.getnumero_chasis() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoConstantesFunciones.NUMEROCHASIS,strValorActual,strValorNuevo);
			}	
			
			if(vehiculo.getIsNew()||!vehiculo.getnumero_placa().equals(vehiculo.getVehiculoOriginal().getnumero_placa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculo.getVehiculoOriginal().getnumero_placa()!=null)
				{
					strValorActual=vehiculo.getVehiculoOriginal().getnumero_placa();
				}
				if(vehiculo.getnumero_placa()!=null)
				{
					strValorNuevo=vehiculo.getnumero_placa() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoConstantesFunciones.NUMEROPLACA,strValorActual,strValorNuevo);
			}	
			
			if(vehiculo.getIsNew()||!vehiculo.getvalor_comercial().equals(vehiculo.getVehiculoOriginal().getvalor_comercial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculo.getVehiculoOriginal().getvalor_comercial()!=null)
				{
					strValorActual=vehiculo.getVehiculoOriginal().getvalor_comercial().toString();
				}
				if(vehiculo.getvalor_comercial()!=null)
				{
					strValorNuevo=vehiculo.getvalor_comercial().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoConstantesFunciones.VALORCOMERCIAL,strValorActual,strValorNuevo);
			}	
			
			if(vehiculo.getIsNew()||!vehiculo.getdescripcion().equals(vehiculo.getVehiculoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vehiculo.getVehiculoOriginal().getdescripcion()!=null)
				{
					strValorActual=vehiculo.getVehiculoOriginal().getdescripcion();
				}
				if(vehiculo.getdescripcion()!=null)
				{
					strValorNuevo=vehiculo.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VehiculoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveVehiculoRelacionesWithConnection(Vehiculo vehiculo,List<ServicioTransporte> serviciotransportes) throws Exception {

		if(!vehiculo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveVehiculoRelacionesBase(vehiculo,serviciotransportes,true);
		}
	}

	public void saveVehiculoRelaciones(Vehiculo vehiculo,List<ServicioTransporte> serviciotransportes)throws Exception {

		if(!vehiculo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveVehiculoRelacionesBase(vehiculo,serviciotransportes,false);
		}
	}

	public void saveVehiculoRelacionesBase(Vehiculo vehiculo,List<ServicioTransporte> serviciotransportes,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Vehiculo-saveRelacionesWithConnection");}
	
			vehiculo.setServicioTransportes(serviciotransportes);

			this.setVehiculo(vehiculo);

			if(VehiculoLogicAdditional.validarSaveRelaciones(vehiculo,this)) {

				VehiculoLogicAdditional.updateRelacionesToSave(vehiculo,this);

				if((vehiculo.getIsNew()||vehiculo.getIsChanged())&&!vehiculo.getIsDeleted()) {
					this.saveVehiculo();
					this.saveVehiculoRelacionesDetalles(serviciotransportes);

				} else if(vehiculo.getIsDeleted()) {
					this.saveVehiculoRelacionesDetalles(serviciotransportes);
					this.saveVehiculo();
				}

				VehiculoLogicAdditional.updateRelacionesToSaveAfter(vehiculo,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ServicioTransporteConstantesFunciones.InicializarGeneralEntityAuxiliaresServicioTransportes(serviciotransportes,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveVehiculoRelacionesDetalles(List<ServicioTransporte> serviciotransportes)throws Exception {
		try {
	

			Long idVehiculoActual=this.getVehiculo().getId();

			ServicioTransporteLogic serviciotransporteLogic_Desde_Vehiculo=new ServicioTransporteLogic();
			serviciotransporteLogic_Desde_Vehiculo.setServicioTransportes(serviciotransportes);

			serviciotransporteLogic_Desde_Vehiculo.setConnexion(this.getConnexion());
			serviciotransporteLogic_Desde_Vehiculo.setDatosCliente(this.datosCliente);

			for(ServicioTransporte serviciotransporte_Desde_Vehiculo:serviciotransporteLogic_Desde_Vehiculo.getServicioTransportes()) {
				serviciotransporte_Desde_Vehiculo.setid_vehiculo(idVehiculoActual);

				serviciotransporteLogic_Desde_Vehiculo.setServicioTransporte(serviciotransporte_Desde_Vehiculo);
				serviciotransporteLogic_Desde_Vehiculo.saveServicioTransporte();

				Long idServicioTransporteActual=serviciotransporte_Desde_Vehiculo.getId();

				DetalleServicioTransporteLogic detalleserviciotransporteLogic_Desde_ServicioTransporte=new DetalleServicioTransporteLogic();

				if(serviciotransporte_Desde_Vehiculo.getDetalleServicioTransportes()==null){
					serviciotransporte_Desde_Vehiculo.setDetalleServicioTransportes(new ArrayList<DetalleServicioTransporte>());
				}

				detalleserviciotransporteLogic_Desde_ServicioTransporte.setDetalleServicioTransportes(serviciotransporte_Desde_Vehiculo.getDetalleServicioTransportes());

				detalleserviciotransporteLogic_Desde_ServicioTransporte.setConnexion(this.getConnexion());
				detalleserviciotransporteLogic_Desde_ServicioTransporte.setDatosCliente(this.datosCliente);

				for(DetalleServicioTransporte detalleserviciotransporte_Desde_ServicioTransporte:detalleserviciotransporteLogic_Desde_ServicioTransporte.getDetalleServicioTransportes()) {
					detalleserviciotransporte_Desde_ServicioTransporte.setid_servicio_transporte(idServicioTransporteActual);
				}

				detalleserviciotransporteLogic_Desde_ServicioTransporte.saveDetalleServicioTransportes();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfVehiculo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=VehiculoConstantesFunciones.getClassesForeignKeysOfVehiculo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVehiculo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=VehiculoConstantesFunciones.getClassesRelationshipsOfVehiculo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
